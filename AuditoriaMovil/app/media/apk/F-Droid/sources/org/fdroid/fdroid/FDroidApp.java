package org.fdroid.fdroid;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.core.util.Supplier;
import androidx.work.Configuration;
import com.bumptech.glide.Glide;
import info.guardianproject.netcipher.NetCipher;
import info.guardianproject.netcipher.proxy.OrbotHelper;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.exceptions.UndeliverableException;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.lang.Thread;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.nio.ByteBuffer;
import java.security.Security;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.config.CoreConfigurationBuilder;
import org.acra.config.DialogConfigurationBuilder;
import org.acra.config.MailSenderConfigurationBuilder;
import org.apache.commons.net.util.SubnetUtils;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.fdroid.database.FDroidDatabase;
import org.fdroid.database.Repository;
import org.fdroid.fdroid.Preferences;
import org.fdroid.fdroid.data.App;
import org.fdroid.fdroid.data.DBHelper;
import org.fdroid.fdroid.installer.InstallHistoryService;
import org.fdroid.fdroid.installer.SessionInstallManager;
import org.fdroid.fdroid.nearby.SDCardScannerService;
import org.fdroid.fdroid.nearby.WifiStateChangeService;
import org.fdroid.fdroid.net.ConnectivityMonitorService;
import org.fdroid.fdroid.net.DownloaderFactory;
import org.fdroid.fdroid.panic.HidingManager;
import org.fdroid.fdroid.receiver.DeviceStorageReceiver;
import org.fdroid.fdroid.work.CleanCacheWorker;
import org.fdroid.fdroid.work.RepoUpdateWorker;
import org.fdroid.index.IndexFormatVersion;
import org.fdroid.index.RepoManager;
import org.fdroid.index.RepoUriBuilder;
/* loaded from: classes2.dex */
public class FDroidApp extends Application implements Configuration.Provider {
    private static final String ACRA_ID = "org.fdroid.fdroid:acra";
    private static final String TAG = "FDroidApp";
    public static volatile String bssid;
    public static volatile boolean generateNewPort;
    private static FDroidApp instance;
    public static volatile String ipAddressString;
    public static volatile int port;
    public static volatile String queryString;
    public static volatile Repository repo;
    private static RepoManager repoManager;
    private static RepoUpdateManager repoUpdateManager;
    public static volatile SessionInstallManager sessionInstallManager;
    public static volatile String ssid;
    public static volatile SubnetUtils.SubnetInfo subnetInfo;
    private NotificationHelper notificationHelper;
    public static final String SYSTEM_DIR_NAME = Environment.getRootDirectory().getAbsolutePath();
    public static volatile int networkState = 0;
    public static final SubnetUtils.SubnetInfo UNSET_SUBNET_INFO = new SubnetUtils("0.0.0.0/32").getInfo();
    private static final BouncyCastleProvider BOUNCYCASTLE_PROVIDER = new BouncyCastleProvider();

    public static Context getInstance() {
        return instance;
    }

    static {
        enableBouncyCastle();
        RxJavaPlugins.setErrorHandler(new Consumer() { // from class: org.fdroid.fdroid.FDroidApp$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                FDroidApp.lambda$static$0((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Throwable th) throws Throwable {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        if (th instanceof UndeliverableException) {
            th = th.getCause();
        }
        if ((th instanceof InterruptedException) || (uncaughtExceptionHandler = Thread.currentThread().getUncaughtExceptionHandler()) == null || th == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
    }

    public void applyPureBlackBackgroundInDarkTheme(AppCompatActivity appCompatActivity) {
        if (Preferences.get().isPureBlack()) {
            appCompatActivity.setTheme(R.style.Theme_App_Black);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.fdroid.fdroid.FDroidApp$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$fdroid$fdroid$Preferences$Theme;

        static {
            int[] iArr = new int[Preferences.Theme.values().length];
            $SwitchMap$org$fdroid$fdroid$Preferences$Theme = iArr;
            try {
                iArr[Preferences.Theme.dark.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$fdroid$fdroid$Preferences$Theme[Preferences.Theme.light.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static void applyTheme() {
        int i = AnonymousClass1.$SwitchMap$org$fdroid$fdroid$Preferences$Theme[Preferences.get().getTheme().ordinal()];
        if (i == 1) {
            AppCompatDelegate.setDefaultNightMode(2);
        } else if (i == 2) {
            AppCompatDelegate.setDefaultNightMode(1);
        } else if (Build.VERSION.SDK_INT <= 28) {
            AppCompatDelegate.setDefaultNightMode(3);
        } else {
            AppCompatDelegate.setDefaultNightMode(-1);
        }
    }

    public void setSecureWindow(AppCompatActivity appCompatActivity) {
        if (Preferences.get().preventScreenshots()) {
            appCompatActivity.getWindow().addFlags(8192);
        }
    }

    private static void enableBouncyCastle() {
        if (Build.VERSION.SDK_INT >= 31) {
            Security.removeProvider(BouncyCastleProvider.PROVIDER_NAME);
        }
        Security.addProvider(BOUNCYCASTLE_PROVIDER);
    }

    public static void initWifiSettings() {
        if (generateNewPort) {
            port = new Random().nextInt(8888) + 1024;
            generateNewPort = false;
        } else {
            port = 8888;
        }
        ipAddressString = null;
        subnetInfo = UNSET_SUBNET_INFO;
        ssid = "";
        bssid = "";
        repo = null;
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Languages.setLanguage(this);
        App.systemLocaleList = null;
        updateLanguagesIfNecessary();
    }

    private void updateLanguagesIfNecessary() {
        SharedPreferences atStartTimeSharedPreferences = getAtStartTimeSharedPreferences();
        String string = atStartTimeSharedPreferences.getString("lastLocale", null);
        String localeListCompat = App.getLocales().toString();
        if (!TextUtils.equals(string, localeListCompat)) {
            Log.i(TAG, "Locales changed. Old: " + string + " New: " + localeListCompat);
            onLanguageChanged(getApplicationContext());
        }
        atStartTimeSharedPreferences.edit().putString("lastLocale", localeListCompat).apply();
    }

    public static void onLanguageChanged(Context context) {
        final FDroidDatabase db = DBHelper.getDb(context);
        Single.fromCallable(new Callable() { // from class: org.fdroid.fdroid.FDroidApp$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean lambda$onLanguageChanged$1;
                lambda$onLanguageChanged$1 = FDroidApp.lambda$onLanguageChanged$1(FDroidDatabase.this);
                return lambda$onLanguageChanged$1;
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$onLanguageChanged$1(FDroidDatabase fDroidDatabase) throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        fDroidDatabase.afterLocalesChanged(App.getLocales());
        Log.d(TAG, "Updating DB locales took: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        return Boolean.TRUE;
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (i >= 40) {
            clearImageLoaderMemoryCache();
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        clearImageLoaderMemoryCache();
    }

    private void clearImageLoaderMemoryCache() {
        Glide.get(getApplicationContext()).clearMemory();
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        instance = this;
        Preferences.setup(this);
        Languages.setLanguage(this);
        Preferences preferences = Preferences.get();
        if (preferences.promptToSendCrashReports()) {
            ACRA.init(this, new CoreConfigurationBuilder().withReportContent(ReportField.USER_COMMENT, ReportField.PACKAGE_NAME, ReportField.APP_VERSION_NAME, ReportField.ANDROID_VERSION, ReportField.PRODUCT, ReportField.BRAND, ReportField.PHONE_MODEL, ReportField.DISPLAY, ReportField.TOTAL_MEM_SIZE, ReportField.AVAILABLE_MEM_SIZE, ReportField.CUSTOM_DATA, ReportField.STACK_TRACE_HASH, ReportField.STACK_TRACE).withPluginConfigurations(new MailSenderConfigurationBuilder().withMailTo(BuildConfig.ACRA_REPORT_EMAIL).withReportFileName(BuildConfig.ACRA_REPORT_FILE_NAME).withSubject(String.format(Locale.ENGLISH, "%s %s: Crash Report", BuildConfig.APPLICATION_ID, BuildConfig.VERSION_NAME)).build(), new DialogConfigurationBuilder().withResTheme(Integer.valueOf(R.style.Theme_App)).withTitle(getString(R.string.crash_dialog_title)).withText(getString(R.string.crash_dialog_text)).withCommentPrompt(getString(R.string.crash_dialog_comment_prompt)).build()));
            if (isAcraProcess() || HidingManager.isHidden(this)) {
                return;
            }
        }
        registerReceiver(new DeviceStorageReceiver(), new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW"));
        WifiStateChangeService.registerReceiver(this);
        applyTheme();
        configureProxy(preferences);
        preferences.registerUnstableUpdatesChangeListener(new Preferences.ChangeListener() { // from class: org.fdroid.fdroid.FDroidApp$$ExternalSyntheticLambda2
            @Override // org.fdroid.fdroid.Preferences.ChangeListener
            public final void onPreferenceChange() {
                FDroidApp.this.lambda$onCreate$2();
            }
        });
        CleanCacheWorker.schedule(this);
        sessionInstallManager = new SessionInstallManager(getApplicationContext());
        this.notificationHelper = new NotificationHelper(getApplicationContext());
        if (preferences.isIndexNeverUpdated()) {
            preferences.setDefaultForDataOnlyConnection(this);
        }
        networkState = ConnectivityMonitorService.getNetworkState(this);
        ConnectivityMonitorService.registerAndStart(this);
        RepoUpdateWorker.scheduleOrCancel(getApplicationContext());
        initWifiSettings();
        WifiStateChangeService.start(this, null);
        preferences.registerLocalRepoHttpsListeners(new Preferences.ChangeListener() { // from class: org.fdroid.fdroid.FDroidApp$$ExternalSyntheticLambda3
            @Override // org.fdroid.fdroid.Preferences.ChangeListener
            public final void onPreferenceChange() {
                FDroidApp.this.lambda$onCreate$3();
            }
        });
        if (preferences.isKeepingInstallHistory()) {
            InstallHistoryService.register(this);
        }
        String string = getString(R.string.install_history_reader_packageName);
        if (!TextUtils.equals(string, getString(R.string.install_history_reader_packageName_UNSET))) {
            grantUriPermission(string, InstallHistoryService.LOG_URI, 67);
        }
        SharedPreferences atStartTimeSharedPreferences = getAtStartTimeSharedPreferences();
        int i = Build.VERSION.SDK_INT;
        if (i != atStartTimeSharedPreferences.getInt("build-version", i)) {
            Utils.runOffUiThread(new Supplier() { // from class: org.fdroid.fdroid.FDroidApp$$ExternalSyntheticLambda4
                @Override // androidx.core.util.Supplier
                public final Object get() {
                    Boolean lambda$onCreate$4;
                    lambda$onCreate$4 = FDroidApp.this.lambda$onCreate$4();
                    return lambda$onCreate$4;
                }
            }, new androidx.core.util.Consumer() { // from class: org.fdroid.fdroid.FDroidApp$$ExternalSyntheticLambda5
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    FDroidApp.this.lambda$onCreate$5((Boolean) obj);
                }
            });
        }
        atStartTimeSharedPreferences.edit().putInt("build-version", i).apply();
        if (!preferences.isIndexNeverUpdated()) {
            updateLanguagesIfNecessary();
        }
        if (preferences.sendVersionAndUUIDToServers()) {
            queryString = atStartTimeSharedPreferences.getString("http-downloader-query-string", null);
            if (queryString == null) {
                UUID randomUUID = UUID.randomUUID();
                ByteBuffer allocate = ByteBuffer.allocate(16);
                allocate.putLong(randomUUID.getMostSignificantBits());
                allocate.putLong(randomUUID.getLeastSignificantBits());
                String encodeToString = Base64.encodeToString(allocate.array(), 11);
                StringBuilder sb = new StringBuilder("id=");
                sb.append(encodeToString);
                String encode = Uri.encode(Utils.getVersionName(this));
                if (encode != null) {
                    sb.append("&client_version=");
                    sb.append(encode);
                }
                queryString = sb.toString();
                atStartTimeSharedPreferences.edit().putString("http-downloader-query-string", queryString).apply();
            }
        } else {
            atStartTimeSharedPreferences.edit().remove("http-downloader-query-string").apply();
        }
        if (Preferences.get().isScanRemovableStorageEnabled()) {
            SDCardScannerService.scan(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2() {
        AppUpdateStatusManager.getInstance(this).checkForUpdates();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3() {
        WifiStateChangeService.start(getApplicationContext(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$onCreate$4() {
        DBHelper.resetTransient(getApplicationContext());
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(Boolean bool) {
        RepoUpdateWorker.updateNow(getApplicationContext());
    }

    private boolean isAcraProcess() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) ContextCompat.getSystemService(this, ActivityManager.class)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid && ACRA_ID.equals(runningAppProcessInfo.processName)) {
                return true;
            }
        }
        return false;
    }

    private SharedPreferences getAtStartTimeSharedPreferences() {
        return getSharedPreferences("at-start-time", 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void sendViaBluetooth(androidx.appcompat.app.AppCompatActivity r6, int r7, java.lang.String r8) {
        /*
            r5 = this;
            if (r7 != 0) goto L3
            return
        L3:
            r7 = 0
            r0 = 0
            android.content.pm.PackageManager r1 = r5.getPackageManager()     // Catch: java.io.IOException -> L5d android.content.pm.PackageManager.NameNotFoundException -> L61
            r2 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r8 = r1.getPackageInfo(r8, r2)     // Catch: java.io.IOException -> L5d android.content.pm.PackageManager.NameNotFoundException -> L61
            android.content.Intent r2 = new android.content.Intent     // Catch: java.io.IOException -> L5d android.content.pm.PackageManager.NameNotFoundException -> L61
            java.lang.String r3 = "android.intent.action.SEND"
            r2.<init>(r3)     // Catch: java.io.IOException -> L5d android.content.pm.PackageManager.NameNotFoundException -> L61
            java.lang.String r3 = "application/zip"
            r2.setType(r3)     // Catch: java.io.IOException -> L57 android.content.pm.PackageManager.NameNotFoundException -> L5a
            java.lang.String r3 = "android.intent.extra.STREAM"
            android.net.Uri r8 = org.fdroid.fdroid.installer.ApkFileProvider.getSafeUri(r5, r8)     // Catch: java.io.IOException -> L57 android.content.pm.PackageManager.NameNotFoundException -> L5a
            r2.putExtra(r3, r8)     // Catch: java.io.IOException -> L57 android.content.pm.PackageManager.NameNotFoundException -> L5a
            java.util.List r8 = r1.queryIntentActivities(r2, r7)     // Catch: java.io.IOException -> L57 android.content.pm.PackageManager.NameNotFoundException -> L5a
            java.util.Iterator r8 = r8.iterator()     // Catch: java.io.IOException -> L57 android.content.pm.PackageManager.NameNotFoundException -> L5a
            r1 = r0
        L2d:
            boolean r3 = r8.hasNext()     // Catch: java.io.IOException -> L4e android.content.pm.PackageManager.NameNotFoundException -> L50
            if (r3 == 0) goto L7b
            java.lang.Object r3 = r8.next()     // Catch: java.io.IOException -> L4e android.content.pm.PackageManager.NameNotFoundException -> L50
            android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3     // Catch: java.io.IOException -> L4e android.content.pm.PackageManager.NameNotFoundException -> L50
            android.content.pm.ActivityInfo r4 = r3.activityInfo     // Catch: java.io.IOException -> L4e android.content.pm.PackageManager.NameNotFoundException -> L50
            java.lang.String r1 = r4.packageName     // Catch: java.io.IOException -> L4e android.content.pm.PackageManager.NameNotFoundException -> L50
            java.lang.String r4 = "com.android.bluetooth"
            boolean r4 = r4.equals(r1)     // Catch: java.io.IOException -> L4e android.content.pm.PackageManager.NameNotFoundException -> L50
            if (r4 != 0) goto L52
            java.lang.String r4 = "com.mediatek.bluetooth"
            boolean r4 = r4.equals(r1)     // Catch: java.io.IOException -> L4e android.content.pm.PackageManager.NameNotFoundException -> L50
            if (r4 == 0) goto L2d
            goto L52
        L4e:
            r8 = move-exception
            goto L65
        L50:
            r8 = move-exception
            goto L74
        L52:
            android.content.pm.ActivityInfo r8 = r3.activityInfo     // Catch: java.io.IOException -> L4e android.content.pm.PackageManager.NameNotFoundException -> L50
            java.lang.String r0 = r8.name     // Catch: java.io.IOException -> L4e android.content.pm.PackageManager.NameNotFoundException -> L50
            goto L7b
        L57:
            r8 = move-exception
            r1 = r0
            goto L65
        L5a:
            r8 = move-exception
            r1 = r0
            goto L74
        L5d:
            r8 = move-exception
            r1 = r0
            r2 = r1
            goto L65
        L61:
            r8 = move-exception
            r1 = r0
            r2 = r1
            goto L74
        L65:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.String r4 = "Error preparing file to send via Bluetooth"
            r3.<init>(r4, r8)
            org.acra.ErrorReporter r8 = org.acra.ACRA.getErrorReporter()
            r8.handleException(r3, r7)
            goto L7b
        L74:
            java.lang.String r3 = "FDroidApp"
            java.lang.String r4 = "Could not get application info to send via bluetooth"
            android.util.Log.e(r3, r4, r8)
        L7b:
            if (r2 == 0) goto L9c
            if (r0 == 0) goto L86
            r2.setClassName(r1, r0)
            r6.startActivity(r2)
            goto L9c
        L86:
            int r8 = org.fdroid.fdroid.R.string.bluetooth_activity_not_found
            android.widget.Toast r7 = android.widget.Toast.makeText(r5, r8, r7)
            r7.show()
            int r7 = org.fdroid.fdroid.R.string.choose_bt_send
            java.lang.String r7 = r5.getString(r7)
            android.content.Intent r7 = android.content.Intent.createChooser(r2, r7)
            r6.startActivity(r7)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.fdroid.FDroidApp.sendViaBluetooth(androidx.appcompat.app.AppCompatActivity, int, java.lang.String):void");
    }

    public static void configureProxy(Preferences preferences) {
        if (preferences.isTorEnabled()) {
            NetCipher.useTor();
        } else if (preferences.isProxyEnabled()) {
            NetCipher.setProxy(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(preferences.getProxyHost(), preferences.getProxyPort())));
        } else {
            NetCipher.clearProxy();
        }
    }

    public static void checkStartTor(Context context, Preferences preferences) {
        if (preferences.isTorEnabled()) {
            OrbotHelper.requestStartTor(context);
        }
    }

    public static Repository createSwapRepo(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str2 == null) {
            str2 = "d0ef";
        }
        return new Repository(42L, str, currentTimeMillis, IndexFormatVersion.ONE, str2, 20001L, 42, currentTimeMillis);
    }

    public static RepoManager getRepoManager(Context context) {
        if (repoManager == null) {
            repoManager = new RepoManager(context, DBHelper.getDb(context), DownloaderFactory.INSTANCE, DownloaderFactory.HTTP_MANAGER, new RepoUriBuilder() { // from class: org.fdroid.fdroid.FDroidApp$$ExternalSyntheticLambda1
                @Override // org.fdroid.index.RepoUriBuilder
                public final Uri getUri(Repository repository, String[] strArr) {
                    Uri lambda$getRepoManager$6;
                    lambda$getRepoManager$6 = FDroidApp.lambda$getRepoManager$6(repository, strArr);
                    return lambda$getRepoManager$6;
                }
            });
        }
        return repoManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Uri lambda$getRepoManager$6(Repository repository, String[] strArr) {
        return Utils.getUri(Utils.getRepoAddress(repository), strArr);
    }

    public static RepoUpdateManager getRepoUpdateManager(Context context) {
        if (repoUpdateManager == null) {
            repoUpdateManager = new RepoUpdateManager(context, DBHelper.getDb(context), getRepoManager(context));
        }
        return repoUpdateManager;
    }

    @Override // androidx.work.Configuration.Provider
    public Configuration getWorkManagerConfiguration() {
        return new Configuration.Builder().setJobSchedulerJobIdRange(0, PKIFailureInfo.certConfirmed).setMinimumLoggingLevel(6).build();
    }
}
