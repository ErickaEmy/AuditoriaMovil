package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController$;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.ndk.NativeFileUtils;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.proto.ClsFileOutputStream;
import com.google.firebase.crashlytics.internal.proto.CodedOutputStream;
import com.google.firebase.crashlytics.internal.proto.SessionProtobufHelper;
import com.google.firebase.crashlytics.internal.report.ReportManager;
import com.google.firebase.crashlytics.internal.report.ReportUploader;
import com.google.firebase.crashlytics.internal.report.ReportUploader$Provider;
import com.google.firebase.crashlytics.internal.report.model.SessionReport;
import com.google.firebase.crashlytics.internal.report.network.CompositeCreateReportSpiCall;
import com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall;
import com.google.firebase.crashlytics.internal.report.network.DefaultCreateReportSpiCall;
import com.google.firebase.crashlytics.internal.report.network.NativeCreateReportSpiCall;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.RemoveRepeatsStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import com.google.firebase.crashlytics.internal.unity.UnityVersionProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CrashlyticsController {
    private final AnalyticsEventLogger analyticsEventLogger;
    private final AppData appData;
    private final CrashlyticsBackgroundWorker backgroundWorker;
    private final Context context;
    private CrashlyticsUncaughtExceptionHandler crashHandler;
    private final CrashlyticsFileMarker crashMarker;
    private final DataCollectionArbiter dataCollectionArbiter;
    private final FileStore fileStore;
    private final ReportUploader.HandlingExceptionCheck handlingExceptionCheck;
    private final HttpRequestFactory httpRequestFactory;
    private final IdManager idManager;
    private final LogFileDirectoryProvider logFileDirectoryProvider;
    private final LogFileManager logFileManager;
    private final CrashlyticsNativeComponent nativeComponent;
    private final ReportManager reportManager;
    private final ReportUploader$Provider reportUploaderProvider;
    private final SessionReportingCoordinator reportingCoordinator;
    private final StackTraceTrimmingStrategy stackTraceTrimmingStrategy;
    private final String unityVersion;
    private final UserMetadata userMetadata;
    static final FilenameFilter SESSION_BEGIN_FILE_FILTER = new 1("BeginSession");
    static final FilenameFilter APP_EXCEPTION_MARKER_FILTER = CrashlyticsController$.Lambda.1.lambdaFactory$();
    static final FilenameFilter SESSION_FILE_FILTER = new 2();
    static final Comparator<File> LARGEST_FILE_NAME_FIRST = new 3();
    static final Comparator<File> SMALLEST_FILE_NAME_FIRST = new 4();
    private static final Pattern SESSION_FILE_PATTERN = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final Map<String, String> SEND_AT_CRASHTIME_HEADER = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    private static final String[] INITIAL_SESSION_PART_TAGS = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    private final AtomicInteger eventCounter = new AtomicInteger(0);
    TaskCompletionSource<Boolean> unsentReportsAvailable = new TaskCompletionSource<>();
    TaskCompletionSource<Boolean> reportActionProvided = new TaskCompletionSource<>();
    TaskCompletionSource<Void> unsentReportsHandled = new TaskCompletionSource<>();
    AtomicBoolean checkForUnsentReportsCalled = new AtomicBoolean(false);

    public CrashlyticsController(Context context, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, HttpRequestFactory httpRequestFactory, IdManager idManager, DataCollectionArbiter dataCollectionArbiter, FileStore fileStore, CrashlyticsFileMarker crashlyticsFileMarker, AppData appData, ReportManager reportManager, ReportUploader$Provider reportUploader$Provider, CrashlyticsNativeComponent crashlyticsNativeComponent, UnityVersionProvider unityVersionProvider, AnalyticsEventLogger analyticsEventLogger, SettingsDataProvider settingsDataProvider) {
        ReportManager reportManager2;
        this.context = context;
        this.backgroundWorker = crashlyticsBackgroundWorker;
        this.httpRequestFactory = httpRequestFactory;
        this.idManager = idManager;
        this.dataCollectionArbiter = dataCollectionArbiter;
        this.fileStore = fileStore;
        this.crashMarker = crashlyticsFileMarker;
        this.appData = appData;
        if (reportUploader$Provider != null) {
            this.reportUploaderProvider = reportUploader$Provider;
        } else {
            this.reportUploaderProvider = defaultReportUploader();
        }
        this.nativeComponent = crashlyticsNativeComponent;
        this.unityVersion = unityVersionProvider.getUnityVersion();
        this.analyticsEventLogger = analyticsEventLogger;
        UserMetadata userMetadata = new UserMetadata();
        this.userMetadata = userMetadata;
        LogFileDirectoryProvider logFileDirectoryProvider = new LogFileDirectoryProvider(fileStore);
        this.logFileDirectoryProvider = logFileDirectoryProvider;
        LogFileManager logFileManager = new LogFileManager(context, logFileDirectoryProvider);
        this.logFileManager = logFileManager;
        if (reportManager == null) {
            reportManager2 = new ReportManager(new ReportUploaderFilesProvider(this, (1) null));
        } else {
            reportManager2 = reportManager;
        }
        this.reportManager = reportManager2;
        this.handlingExceptionCheck = new ReportUploaderHandlingExceptionCheck(this, (1) null);
        MiddleOutFallbackStrategy middleOutFallbackStrategy = new MiddleOutFallbackStrategy(1024, new StackTraceTrimmingStrategy[]{new RemoveRepeatsStrategy(10)});
        this.stackTraceTrimmingStrategy = middleOutFallbackStrategy;
        this.reportingCoordinator = SessionReportingCoordinator.create(context, idManager, fileStore, appData, logFileManager, userMetadata, middleOutFallbackStrategy, settingsDataProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendOrganizationIdToSessionFile(@Nullable String str, @NonNull File file) throws Exception {
        if (str == null) {
            return;
        }
        appendToProtoFile(file, new 22(str));
    }

    private static void appendToProtoFile(@NonNull File file, @NonNull CodedOutputStreamWriteAction codedOutputStreamWriteAction) throws Exception {
        FileOutputStream fileOutputStream;
        CodedOutputStream codedOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            codedOutputStream = CodedOutputStream.newInstance(fileOutputStream);
            codedOutputStreamWriteAction.writeTo(codedOutputStream);
            CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to append to " + file.getPath());
            CommonUtils.closeOrLog(fileOutputStream, "Failed to close " + file.getPath());
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to append to " + file.getPath());
            CommonUtils.closeOrLog(fileOutputStream, "Failed to close " + file.getPath());
            throw th;
        }
    }

    private void cacheKeyData(Map<String, String> map) {
        this.backgroundWorker.submit((Callable) new 13(this, map));
    }

    private void cacheUserData(UserMetadata userMetadata) {
        this.backgroundWorker.submit((Callable) new 12(this, userMetadata));
    }

    private void closeOpenSessions(File[] fileArr, int i, int i5) {
        Logger.getLogger().d("Closing open sessions.");
        while (i < fileArr.length) {
            File file = fileArr[i];
            String sessionIdFromSessionFile = getSessionIdFromSessionFile(file);
            Logger logger = Logger.getLogger();
            logger.d("Closing session: " + sessionIdFromSessionFile);
            writeSessionPartsToSessionFile(file, sessionIdFromSessionFile, i5);
            i++;
        }
    }

    private void closeWithoutRenamingOrLog(ClsFileOutputStream clsFileOutputStream) {
        if (clsFileOutputStream == null) {
            return;
        }
        try {
            clsFileOutputStream.closeInProgressStream();
        } catch (IOException e2) {
            Logger.getLogger().e("Error closing session file stream in the presence of an exception", e2);
        }
    }

    private static void copyToCodedOutputStream(InputStream inputStream, CodedOutputStream codedOutputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i5 = 0;
        while (i5 < i) {
            int read = inputStream.read(bArr, i5, i - i5);
            if (read < 0) {
                break;
            }
            i5 += read;
        }
        codedOutputStream.writeRawBytes(bArr);
    }

    private ReportUploader$Provider defaultReportUploader() {
        return new 9(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void deleteFiles(File[] fileArr) {
        if (fileArr == null) {
            return;
        }
        for (File file : fileArr) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOpenSession() throws Exception {
        long currentTimestampSeconds = getCurrentTimestampSeconds();
        String clsuuid = new CLSUUID(this.idManager).toString();
        Logger logger = Logger.getLogger();
        logger.d("Opening a new session with ID " + clsuuid);
        this.nativeComponent.openSession(clsuuid);
        writeBeginSession(clsuuid, currentTimestampSeconds);
        writeSessionApp(clsuuid);
        writeSessionOS(clsuuid);
        writeSessionDevice(clsuuid);
        this.logFileManager.setCurrentSession(clsuuid);
        this.reportingCoordinator.onBeginSession(makeFirebaseSessionIdentifier(clsuuid), currentTimestampSeconds);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doWriteAppExceptionMarker(long j2) {
        try {
            File filesDir = getFilesDir();
            new File(filesDir, ".ae" + j2).createNewFile();
        } catch (IOException unused) {
            Logger.getLogger().d("Could not write app exception marker.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doWriteFatal(@NonNull Thread thread, @NonNull Throwable th, @NonNull String str, long j2) {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStream = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str + "SessionCrash");
            try {
                try {
                    codedOutputStream = CodedOutputStream.newInstance(clsFileOutputStream);
                    writeSessionEvent(codedOutputStream, thread, th, j2, "crash", true);
                } catch (Exception e2) {
                    e = e2;
                    Logger.getLogger().e("An error occurred in the fatal exception logger", e);
                    CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session begin file.");
                    CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                }
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session begin file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            clsFileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            clsFileOutputStream = null;
            CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session begin file.");
            CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close fatal exception file output stream.");
            throw th;
        }
        CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session begin file.");
        CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close fatal exception file output stream.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doWriteNonFatal(@NonNull Thread thread, @NonNull Throwable th, @NonNull String str, long j2) {
        OutputStream outputStream;
        CodedOutputStream newInstance;
        CodedOutputStream codedOutputStream = null;
        try {
            try {
                Logger.getLogger().d("Crashlytics is logging non-fatal exception \"" + th + "\" from thread " + thread.getName());
                outputStream = new ClsFileOutputStream(getFilesDir(), str + "SessionEvent" + CommonUtils.padWithZerosToMaxIntWidth(this.eventCounter.getAndIncrement()));
                try {
                    newInstance = CodedOutputStream.newInstance(outputStream);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
            outputStream = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
        try {
            try {
                CodedOutputStream codedOutputStream2 = this;
                codedOutputStream2.writeSessionEvent(newInstance, thread, th, j2, "error", false);
                CommonUtils.flushOrLog(newInstance, "Failed to flush to non-fatal file.");
                codedOutputStream = codedOutputStream2;
            } catch (Exception e5) {
                e = e5;
                codedOutputStream = newInstance;
                Logger.getLogger().e("An error occurred in the non-fatal exception logger", e);
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
                codedOutputStream = codedOutputStream;
                CommonUtils.closeOrLog(outputStream, "Failed to close non-fatal file output stream.");
                trimSessionEventFiles(str, 64);
                return;
            } catch (Throwable th4) {
                th = th4;
                codedOutputStream = newInstance;
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
                CommonUtils.closeOrLog(outputStream, "Failed to close non-fatal file output stream.");
                throw th;
            }
            trimSessionEventFiles(str, 64);
            return;
        } catch (Exception e6) {
            Logger.getLogger().e("An error occurred when trimming non-fatal files.", e6);
            return;
        }
        CommonUtils.closeOrLog(outputStream, "Failed to close non-fatal file output stream.");
    }

    private static File[] ensureFileArrayNotNull(File[] fileArr) {
        if (fileArr == null) {
            return new File[0];
        }
        return fileArr;
    }

    private void finalizePreviousNativeSession(String str) {
        Logger logger = Logger.getLogger();
        logger.d("Finalizing native report for session " + str);
        NativeSessionFileProvider sessionFileProvider = this.nativeComponent.getSessionFileProvider(str);
        File minidumpFile = sessionFileProvider.getMinidumpFile();
        if (minidumpFile != null && minidumpFile.exists()) {
            long lastModified = minidumpFile.lastModified();
            LogFileManager logFileManager = new LogFileManager(this.context, this.logFileDirectoryProvider, str);
            File file = new File(getNativeSessionFilesDir(), str);
            if (!file.mkdirs()) {
                Logger.getLogger().d("Couldn't create native sessions directory");
                return;
            }
            doWriteAppExceptionMarker(lastModified);
            List<NativeSessionFile> nativeSessionFiles = getNativeSessionFiles(sessionFileProvider, str, getContext(), getFilesDir(), logFileManager.getBytesForLog());
            NativeSessionFileGzipper.processNativeSessions(file, nativeSessionFiles);
            this.reportingCoordinator.finalizeSessionWithNativeEvent(makeFirebaseSessionIdentifier(str), nativeSessionFiles);
            logFileManager.clearLog();
            return;
        }
        Logger logger2 = Logger.getLogger();
        logger2.w("No minidump data found for session " + str);
    }

    private static boolean firebaseCrashExists() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private Context getContext() {
        return this.context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CreateReportSpiCall getCreateReportSpiCall(String str, String str2) {
        String stringsFileValue = CommonUtils.getStringsFileValue(getContext(), "com.crashlytics.ApiEndpoint");
        return new CompositeCreateReportSpiCall(new DefaultCreateReportSpiCall(stringsFileValue, str, this.httpRequestFactory, CrashlyticsCore.getVersion()), new NativeCreateReportSpiCall(stringsFileValue, str2, this.httpRequestFactory, CrashlyticsCore.getVersion()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String getCurrentSessionId() {
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        if (listSortedSessionBeginFiles.length > 0) {
            return getSessionIdFromSessionFile(listSortedSessionBeginFiles[0]);
        }
        return null;
    }

    private static long getCurrentTimestampSeconds() {
        return getTimestampSeconds(new Date());
    }

    @NonNull
    public static List<NativeSessionFile> getNativeSessionFiles(NativeSessionFileProvider nativeSessionFileProvider, String str, Context context, File file, byte[] bArr) {
        byte[] bArr2;
        MetaDataStore metaDataStore = new MetaDataStore(file);
        File userDataFileForSession = metaDataStore.getUserDataFileForSession(str);
        File keysFileForSession = metaDataStore.getKeysFileForSession(str);
        try {
            bArr2 = NativeFileUtils.binaryImagesJsonFromMapsFile(nativeSessionFileProvider.getBinaryImagesFile(), context);
        } catch (Exception unused) {
            bArr2 = null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BytesBackedNativeSessionFile("logs_file", "logs", bArr));
        arrayList.add(new BytesBackedNativeSessionFile("binary_images_file", "binaryImages", bArr2));
        arrayList.add(new FileBackedNativeSessionFile("crash_meta_file", "metadata", nativeSessionFileProvider.getMetadataFile()));
        arrayList.add(new FileBackedNativeSessionFile("session_meta_file", "session", nativeSessionFileProvider.getSessionFile()));
        arrayList.add(new FileBackedNativeSessionFile("app_meta_file", "app", nativeSessionFileProvider.getAppFile()));
        arrayList.add(new FileBackedNativeSessionFile("device_meta_file", "device", nativeSessionFileProvider.getDeviceFile()));
        arrayList.add(new FileBackedNativeSessionFile("os_meta_file", "os", nativeSessionFileProvider.getOsFile()));
        arrayList.add(new FileBackedNativeSessionFile("minidump_file", "minidump", nativeSessionFileProvider.getMinidumpFile()));
        arrayList.add(new FileBackedNativeSessionFile("user_meta_file", "user", userDataFileForSession));
        arrayList.add(new FileBackedNativeSessionFile("keys_file", "keys", keysFileForSession));
        return arrayList;
    }

    public static String getSessionIdFromSessionFile(File file) {
        return file.getName().substring(0, 35);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getTimestampSeconds(Date date) {
        return date.getTime() / 1000;
    }

    private File[] getTrimmedNonFatalFiles(String str, File[] fileArr, int i) {
        if (fileArr.length > i) {
            Logger.getLogger().d(String.format(Locale.US, "Trimming down to %d logged exceptions.", Integer.valueOf(i)));
            trimSessionEventFiles(str, i);
            return listFilesMatching(new FileNameContainsFilter(str + "SessionEvent"));
        }
        return fileArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File[] listFilesMatching(FilenameFilter filenameFilter) {
        return listFilesMatching(getFilesDir(), filenameFilter);
    }

    private File[] listSessionPartFilesFor(String str) {
        return listFilesMatching(new SessionPartFileFilter(str));
    }

    private File[] listSortedSessionBeginFiles() {
        File[] listSessionBeginFiles = listSessionBeginFiles();
        Arrays.sort(listSessionBeginFiles, LARGEST_FILE_NAME_FIRST);
        return listSessionBeginFiles;
    }

    private Task<Void> logAnalyticsAppExceptionEvent(long j2) {
        if (firebaseCrashExists()) {
            Logger.getLogger().d("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return Tasks.forResult(null);
        }
        return Tasks.call(new ScheduledThreadPoolExecutor(1), new 23(this, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task<Void> logAnalyticsAppExceptionEvents() {
        File[] listAppExceptionMarkerFiles;
        ArrayList arrayList = new ArrayList();
        for (File file : listAppExceptionMarkerFiles()) {
            try {
                arrayList.add(logAnalyticsAppExceptionEvent(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                Logger.getLogger().d("Could not parse timestamp from file " + file.getName());
            }
            file.delete();
        }
        return Tasks.whenAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static String makeFirebaseSessionIdentifier(@NonNull String str) {
        return str.replaceAll("-", "");
    }

    private void retainSessions(File[] fileArr, Set<String> set) {
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = SESSION_FILE_PATTERN.matcher(name);
            if (!matcher.matches()) {
                Logger.getLogger().d("Deleting unknown file: " + name);
                file.delete();
            } else if (!set.contains(matcher.group(1))) {
                Logger.getLogger().d("Trimming session file: " + name);
                file.delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSessionReports(@NonNull AppSettingsData appSettingsData, boolean z2) throws Exception {
        File[] listCompleteSessionFiles;
        Context context = getContext();
        ReportUploader createReportUploader = this.reportUploaderProvider.createReportUploader(appSettingsData);
        for (File file : listCompleteSessionFiles()) {
            appendOrganizationIdToSessionFile(appSettingsData.organizationId, file);
            this.backgroundWorker.submit((Runnable) new SendReportRunnable(context, new SessionReport(file, SEND_AT_CRASHTIME_HEADER), createReportUploader, z2));
        }
    }

    private void synthesizeSessionFile(File file, String str, File[] fileArr, File file2) {
        boolean z2;
        File nonFatalSessionFilesDir;
        ClsFileOutputStream clsFileOutputStream;
        if (file2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            nonFatalSessionFilesDir = getFatalSessionFilesDir();
        } else {
            nonFatalSessionFilesDir = getNonFatalSessionFilesDir();
        }
        if (!nonFatalSessionFilesDir.exists()) {
            nonFatalSessionFilesDir.mkdirs();
        }
        CodedOutputStream codedOutputStream = null;
        try {
            try {
                clsFileOutputStream = new ClsFileOutputStream(nonFatalSessionFilesDir, str);
                try {
                    codedOutputStream = CodedOutputStream.newInstance(clsFileOutputStream);
                    Logger.getLogger().d("Collecting SessionStart data for session ID " + str);
                    writeToCosFromFile(codedOutputStream, file);
                    codedOutputStream.writeUInt64(4, getCurrentTimestampSeconds());
                    codedOutputStream.writeBool(5, z2);
                    codedOutputStream.writeUInt32(11, 1);
                    codedOutputStream.writeEnum(12, 3);
                    writeInitialPartsTo(codedOutputStream, str);
                    writeNonFatalEventsTo(codedOutputStream, fileArr, str);
                    if (z2) {
                        writeToCosFromFile(codedOutputStream, file2);
                    }
                    CommonUtils.flushOrLog(codedOutputStream, "Error flushing session file stream");
                    CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close CLS file");
                } catch (Exception e2) {
                    e = e2;
                    Logger.getLogger().e("Failed to write session file for session ID: " + str, e);
                    CommonUtils.flushOrLog(codedOutputStream, "Error flushing session file stream");
                    closeWithoutRenamingOrLog(clsFileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                CommonUtils.flushOrLog(null, "Error flushing session file stream");
                CommonUtils.closeOrLog(null, "Failed to close CLS file");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            clsFileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.flushOrLog(null, "Error flushing session file stream");
            CommonUtils.closeOrLog(null, "Failed to close CLS file");
            throw th;
        }
    }

    private void trimOpenSessions(int i) {
        HashSet hashSet = new HashSet();
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        int min = Math.min(i, listSortedSessionBeginFiles.length);
        for (int i5 = 0; i5 < min; i5++) {
            hashSet.add(getSessionIdFromSessionFile(listSortedSessionBeginFiles[i5]));
        }
        this.logFileManager.discardOldLogFiles(hashSet);
        retainSessions(listFilesMatching(new AnySessionPartFileFilter((1) null)), hashSet);
    }

    private void trimSessionEventFiles(String str, int i) {
        File filesDir = getFilesDir();
        Utils.capFileCount(filesDir, new FileNameContainsFilter(str + "SessionEvent"), i, SMALLEST_FILE_NAME_FIRST);
    }

    private Task<Boolean> waitForReportAction() {
        if (this.dataCollectionArbiter.isAutomaticDataCollectionEnabled()) {
            Logger.getLogger().d("Automatic data collection is enabled. Allowing upload.");
            this.unsentReportsAvailable.trySetResult(Boolean.FALSE);
            return Tasks.forResult(Boolean.TRUE);
        }
        Logger.getLogger().d("Automatic data collection is disabled.");
        Logger.getLogger().d("Notifying that unsent reports are available.");
        this.unsentReportsAvailable.trySetResult(Boolean.TRUE);
        Task<TContinuationResult> onSuccessTask = this.dataCollectionArbiter.waitForAutomaticDataCollectionEnabled().onSuccessTask(new 7(this));
        Logger.getLogger().d("Waiting for send/deleteUnsentReports to be called.");
        return Utils.race(onSuccessTask, this.reportActionProvided.getTask());
    }

    private void writeBeginSession(String str, long j2) throws Exception {
        String format = String.format(Locale.US, "Crashlytics Android SDK/%s", CrashlyticsCore.getVersion());
        writeSessionPartFile(str, "BeginSession", new 17(this, str, format, j2));
        this.nativeComponent.writeBeginSession(str, format, j2);
    }

    private void writeInitialPartsTo(CodedOutputStream codedOutputStream, String str) throws IOException {
        String[] strArr;
        for (String str2 : INITIAL_SESSION_PART_TAGS) {
            File[] listFilesMatching = listFilesMatching(new FileNameContainsFilter(str + str2 + ".cls"));
            if (listFilesMatching.length == 0) {
                Logger.getLogger().d("Can't find " + str2 + " data for session ID " + str);
            } else {
                Logger.getLogger().d("Collecting " + str2 + " data for session ID " + str);
                writeToCosFromFile(codedOutputStream, listFilesMatching[0]);
            }
        }
    }

    private static void writeNonFatalEventsTo(CodedOutputStream codedOutputStream, File[] fileArr, String str) {
        Arrays.sort(fileArr, CommonUtils.FILE_MODIFIED_COMPARATOR);
        for (File file : fileArr) {
            try {
                Logger.getLogger().d(String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName()));
                writeToCosFromFile(codedOutputStream, file);
            } catch (Exception e2) {
                Logger.getLogger().e("Error writting non-fatal to session.", e2);
            }
        }
    }

    private void writeSessionApp(String str) throws Exception {
        String appIdentifier = this.idManager.getAppIdentifier();
        AppData appData = this.appData;
        String str2 = appData.versionCode;
        String str3 = appData.versionName;
        String crashlyticsInstallId = this.idManager.getCrashlyticsInstallId();
        int id = DeliveryMechanism.determineFrom(this.appData.installerPackageName).getId();
        writeSessionPartFile(str, "SessionApp", new 18(this, appIdentifier, str2, str3, crashlyticsInstallId, id));
        this.nativeComponent.writeSessionApp(str, appIdentifier, str2, str3, crashlyticsInstallId, id, this.unityVersion);
    }

    private void writeSessionDevice(String str) throws Exception {
        Context context = getContext();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int cpuArchitectureInt = CommonUtils.getCpuArchitectureInt();
        String str2 = Build.MODEL;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long totalRamInBytes = CommonUtils.getTotalRamInBytes();
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        boolean isEmulator = CommonUtils.isEmulator(context);
        int deviceState = CommonUtils.getDeviceState(context);
        String str3 = Build.MANUFACTURER;
        String str4 = Build.PRODUCT;
        writeSessionPartFile(str, "SessionDevice", new 20(this, cpuArchitectureInt, str2, availableProcessors, totalRamInBytes, blockCount, isEmulator, deviceState, str3, str4));
        this.nativeComponent.writeSessionDevice(str, cpuArchitectureInt, str2, availableProcessors, totalRamInBytes, blockCount, isEmulator, deviceState, str3, str4);
    }

    private void writeSessionEvent(CodedOutputStream codedOutputStream, Thread thread, Throwable th, long j2, String str, boolean z2) throws Exception {
        Thread[] threadArr;
        Map customKeys;
        Map treeMap;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, this.stackTraceTrimmingStrategy);
        Context context = getContext();
        BatteryState batteryState = BatteryState.get(context);
        Float batteryLevel = batteryState.getBatteryLevel();
        int batteryVelocity = batteryState.getBatteryVelocity();
        boolean proximitySensorEnabled = CommonUtils.getProximitySensorEnabled(context);
        int i = context.getResources().getConfiguration().orientation;
        long totalRamInBytes = CommonUtils.getTotalRamInBytes() - CommonUtils.calculateFreeRamInBytes(context);
        long calculateUsedDiskSpaceInBytes = CommonUtils.calculateUsedDiskSpaceInBytes(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo appProcessInfo = CommonUtils.getAppProcessInfo(context.getPackageName(), context);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.stacktrace;
        String str2 = this.appData.buildId;
        String appIdentifier = this.idManager.getAppIdentifier();
        int i5 = 0;
        if (z2) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                threadArr2[i5] = entry.getKey();
                linkedList.add(this.stackTraceTrimmingStrategy.getTrimmedStackTrace(entry.getValue()));
                i5++;
            }
            threadArr = threadArr2;
        } else {
            threadArr = new Thread[0];
        }
        if (!CommonUtils.getBooleanResourceValue(context, "com.crashlytics.CollectCustomKeys", true)) {
            customKeys = new TreeMap();
        } else {
            customKeys = this.userMetadata.getCustomKeys();
            if (customKeys != null && customKeys.size() > 1) {
                treeMap = new TreeMap(customKeys);
                SessionProtobufHelper.writeSessionEvent(codedOutputStream, j2, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, 8, treeMap, this.logFileManager.getBytesForLog(), appProcessInfo, i, appIdentifier, str2, batteryLevel, batteryVelocity, proximitySensorEnabled, totalRamInBytes, calculateUsedDiskSpaceInBytes);
                this.logFileManager.clearLog();
            }
        }
        treeMap = customKeys;
        SessionProtobufHelper.writeSessionEvent(codedOutputStream, j2, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, 8, treeMap, this.logFileManager.getBytesForLog(), appProcessInfo, i, appIdentifier, str2, batteryLevel, batteryVelocity, proximitySensorEnabled, totalRamInBytes, calculateUsedDiskSpaceInBytes);
        this.logFileManager.clearLog();
    }

    private void writeSessionOS(String str) throws Exception {
        String str2 = Build.VERSION.RELEASE;
        String str3 = Build.VERSION.CODENAME;
        boolean isRooted = CommonUtils.isRooted(getContext());
        writeSessionPartFile(str, "SessionOS", new 19(this, str2, str3, isRooted));
        this.nativeComponent.writeSessionOs(str, str2, str3, isRooted);
    }

    private void writeSessionPartFile(String str, String str2, CodedOutputStreamWriteAction codedOutputStreamWriteAction) throws Exception {
        OutputStream outputStream;
        CodedOutputStream codedOutputStream = null;
        try {
            outputStream = new ClsFileOutputStream(getFilesDir(), str + str2);
            try {
                codedOutputStream = CodedOutputStream.newInstance(outputStream);
                codedOutputStreamWriteAction.writeTo(codedOutputStream);
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session " + str2 + " file.");
                CommonUtils.closeOrLog(outputStream, "Failed to close session " + str2 + " file.");
            } catch (Throwable th) {
                th = th;
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session " + str2 + " file.");
                CommonUtils.closeOrLog(outputStream, "Failed to close session " + str2 + " file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
    }

    private void writeSessionPartsToSessionFile(File file, String str, int i) {
        boolean z2;
        boolean z3;
        File file2;
        Logger logger = Logger.getLogger();
        logger.d("Collecting session parts for ID " + str);
        File[] listFilesMatching = listFilesMatching(new FileNameContainsFilter(str + "SessionCrash"));
        if (listFilesMatching != null && listFilesMatching.length > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Logger logger2 = Logger.getLogger();
        Locale locale = Locale.US;
        logger2.d(String.format(locale, "Session %s has fatal exception: %s", str, Boolean.valueOf(z2)));
        File[] listFilesMatching2 = listFilesMatching(new FileNameContainsFilter(str + "SessionEvent"));
        if (listFilesMatching2 != null && listFilesMatching2.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Logger.getLogger().d(String.format(locale, "Session %s has non-fatal exceptions: %s", str, Boolean.valueOf(z3)));
        if (!z2 && !z3) {
            Logger logger3 = Logger.getLogger();
            logger3.d("No events present for session ID " + str);
        } else {
            File[] trimmedNonFatalFiles = getTrimmedNonFatalFiles(str, listFilesMatching2, i);
            if (z2) {
                file2 = listFilesMatching[0];
            } else {
                file2 = null;
            }
            synthesizeSessionFile(file, str, trimmedNonFatalFiles, file2);
        }
        Logger logger4 = Logger.getLogger();
        logger4.d("Removing session part files for ID " + str);
        deleteFiles(listSessionPartFilesFor(str));
    }

    private void writeSessionUser(String str) throws Exception {
        writeSessionPartFile(str, "SessionUser", new 21(this, getUserMetadata(str)));
    }

    private static void writeToCosFromFile(CodedOutputStream codedOutputStream, File file) throws IOException {
        if (!file.exists()) {
            Logger logger = Logger.getLogger();
            logger.e("Tried to include a file that doesn't exist: " + file.getName());
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                copyToCodedOutputStream(fileInputStream2, codedOutputStream, (int) file.length());
                CommonUtils.closeOrLog(fileInputStream2, "Failed to close file input stream.");
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                CommonUtils.closeOrLog(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @NonNull
    public Task<Boolean> checkForUnsentReports() {
        if (!this.checkForUnsentReportsCalled.compareAndSet(false, true)) {
            Logger.getLogger().d("checkForUnsentReports should only be called once per execution.");
            return Tasks.forResult(Boolean.FALSE);
        }
        return this.unsentReportsAvailable.getTask();
    }

    public void cleanInvalidTempFiles() {
        this.backgroundWorker.submit((Runnable) new 15(this));
    }

    public Task<Void> deleteUnsentReports() {
        this.reportActionProvided.trySetResult(Boolean.FALSE);
        return this.unsentReportsHandled.getTask();
    }

    public boolean didCrashOnPreviousExecution() {
        if (!this.crashMarker.isPresent()) {
            String currentSessionId = getCurrentSessionId();
            if (currentSessionId != null && this.nativeComponent.hasCrashDataForSession(currentSessionId)) {
                return true;
            }
            return false;
        }
        Logger.getLogger().d("Found previous crash marker.");
        this.crashMarker.remove();
        return true;
    }

    public void doCleanInvalidTempFiles(File[] fileArr) {
        File[] listFilesMatching;
        HashSet hashSet = new HashSet();
        for (File file : fileArr) {
            Logger.getLogger().d("Found invalid session part file: " + file);
            hashSet.add(getSessionIdFromSessionFile(file));
        }
        if (hashSet.isEmpty()) {
            return;
        }
        for (File file2 : listFilesMatching(new 16(this, hashSet))) {
            Logger.getLogger().d("Deleting invalid session file: " + file2);
            file2.delete();
        }
    }

    public void doCloseSessions(int i) throws Exception {
        doCloseSessions(i, false);
    }

    public void enableExceptionHandling(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, SettingsDataProvider settingsDataProvider) {
        openSession();
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = new CrashlyticsUncaughtExceptionHandler(new 5(this), settingsDataProvider, uncaughtExceptionHandler);
        this.crashHandler = crashlyticsUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(crashlyticsUncaughtExceptionHandler);
    }

    public boolean finalizeSessions(int i) {
        this.backgroundWorker.checkRunningOnThread();
        if (isHandlingException()) {
            Logger.getLogger().d("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        Logger.getLogger().d("Finalizing previously open sessions.");
        try {
            doCloseSessions(i, true);
            Logger.getLogger().d("Closed all previously open sessions");
            return true;
        } catch (Exception e2) {
            Logger.getLogger().e("Unable to finalize previously open sessions.", e2);
            return false;
        }
    }

    public File getFatalSessionFilesDir() {
        return new File(getFilesDir(), "fatal-sessions");
    }

    public File getFilesDir() {
        return this.fileStore.getFilesDir();
    }

    public File getNativeSessionFilesDir() {
        return new File(getFilesDir(), "native-sessions");
    }

    public File getNonFatalSessionFilesDir() {
        return new File(getFilesDir(), "nonfatal-sessions");
    }

    public UserMetadata getUserMetadata() {
        return this.userMetadata;
    }

    public synchronized void handleUncaughtException(@NonNull SettingsDataProvider settingsDataProvider, @NonNull Thread thread, @NonNull Throwable th) {
        Logger logger = Logger.getLogger();
        logger.d("Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        try {
            Utils.awaitEvenIfOnMainThread(this.backgroundWorker.submitTask(new 6(this, new Date(), th, thread, settingsDataProvider)));
        } catch (Exception unused) {
        }
    }

    public boolean hasOpenSession() {
        if (listSessionBeginFiles().length > 0) {
            return true;
        }
        return false;
    }

    public boolean isHandlingException() {
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = this.crashHandler;
        if (crashlyticsUncaughtExceptionHandler != null && crashlyticsUncaughtExceptionHandler.isHandlingException()) {
            return true;
        }
        return false;
    }

    public File[] listAppExceptionMarkerFiles() {
        return listFilesMatching(APP_EXCEPTION_MARKER_FILTER);
    }

    public File[] listCompleteSessionFiles() {
        LinkedList linkedList = new LinkedList();
        File fatalSessionFilesDir = getFatalSessionFilesDir();
        FilenameFilter filenameFilter = SESSION_FILE_FILTER;
        Collections.addAll(linkedList, listFilesMatching(fatalSessionFilesDir, filenameFilter));
        Collections.addAll(linkedList, listFilesMatching(getNonFatalSessionFilesDir(), filenameFilter));
        Collections.addAll(linkedList, listFilesMatching(getFilesDir(), filenameFilter));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    public File[] listNativeSessionFileDirectories() {
        return ensureFileArrayNotNull(getNativeSessionFilesDir().listFiles());
    }

    public File[] listSessionBeginFiles() {
        return listFilesMatching(SESSION_BEGIN_FILE_FILTER);
    }

    public void openSession() {
        this.backgroundWorker.submit((Callable) new 14(this));
    }

    public Task<Void> sendUnsentReports() {
        this.reportActionProvided.trySetResult(Boolean.TRUE);
        return this.unsentReportsHandled.getTask();
    }

    public void setCustomKey(String str, String str2) {
        try {
            this.userMetadata.setCustomKey(str, str2);
            cacheKeyData(this.userMetadata.getCustomKeys());
        } catch (IllegalArgumentException e2) {
            Context context = this.context;
            if (context != null && CommonUtils.isAppDebuggable(context)) {
                throw e2;
            }
            Logger.getLogger().e("Attempting to set custom attribute with null key, ignoring.");
        }
    }

    public void setUserId(String str) {
        this.userMetadata.setUserId(str);
        cacheUserData(this.userMetadata);
    }

    public Task<Void> submitAllReports(float f4, Task<AppSettingsData> task) {
        if (!this.reportManager.areReportsAvailable()) {
            Logger.getLogger().d("No reports are available.");
            this.unsentReportsAvailable.trySetResult(Boolean.FALSE);
            return Tasks.forResult(null);
        }
        Logger.getLogger().d("Unsent reports are available.");
        return waitForReportAction().onSuccessTask(new 8(this, task, f4));
    }

    public void trimSessionFiles(int i) {
        File nativeSessionFilesDir = getNativeSessionFilesDir();
        File fatalSessionFilesDir = getFatalSessionFilesDir();
        Comparator<File> comparator = SMALLEST_FILE_NAME_FIRST;
        int capSessionCount = i - Utils.capSessionCount(nativeSessionFilesDir, fatalSessionFilesDir, i, comparator);
        Utils.capFileCount(getFilesDir(), SESSION_FILE_FILTER, capSessionCount - Utils.capFileCount(getNonFatalSessionFilesDir(), capSessionCount, comparator), comparator);
    }

    public void writeNonFatalException(@NonNull Thread thread, @NonNull Throwable th) {
        this.backgroundWorker.submit((Runnable) new 11(this, new Date(), th, thread));
    }

    public void writeToLog(long j2, String str) {
        this.backgroundWorker.submit((Callable) new 10(this, j2, str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void doCloseSessions(int i, boolean z2) throws Exception {
        trimOpenSessions((z2 ? 1 : 0) + 8);
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        if (listSortedSessionBeginFiles.length <= z2) {
            Logger.getLogger().d("No open sessions to be closed.");
            return;
        }
        String sessionIdFromSessionFile = getSessionIdFromSessionFile(listSortedSessionBeginFiles[z2 ? 1 : 0]);
        writeSessionUser(sessionIdFromSessionFile);
        if (this.nativeComponent.hasCrashDataForSession(sessionIdFromSessionFile)) {
            finalizePreviousNativeSession(sessionIdFromSessionFile);
            if (!this.nativeComponent.finalizeSession(sessionIdFromSessionFile)) {
                Logger logger = Logger.getLogger();
                logger.d("Could not finalize native session: " + sessionIdFromSessionFile);
            }
        }
        closeOpenSessions(listSortedSessionBeginFiles, z2 ? 1 : 0, i);
        this.reportingCoordinator.finalizeSessions(getCurrentTimestampSeconds(), z2 != 0 ? makeFirebaseSessionIdentifier(getSessionIdFromSessionFile(listSortedSessionBeginFiles[0])) : null);
    }

    private UserMetadata getUserMetadata(String str) {
        if (isHandlingException()) {
            return this.userMetadata;
        }
        return new MetaDataStore(getFilesDir()).readUserData(str);
    }

    private static File[] listFilesMatching(File file, FilenameFilter filenameFilter) {
        return ensureFileArrayNotNull(file.listFiles(filenameFilter));
    }
}
