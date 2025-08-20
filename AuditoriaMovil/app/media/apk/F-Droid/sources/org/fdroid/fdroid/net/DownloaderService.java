package org.fdroid.fdroid.net;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.JobIntentService;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.io.File;
import org.fdroid.download.Downloader;
import org.fdroid.fdroid.Utils;
import org.fdroid.fdroid.data.Apk;
import org.fdroid.fdroid.data.App;
import org.fdroid.fdroid.installer.InstallManagerService;
import org.fdroid.fdroid.installer.Installer;
/* loaded from: classes2.dex */
public class DownloaderService extends JobIntentService {
    public static final String ACTION_COMPLETE = "org.fdroid.fdroid.net.Downloader.action.COMPLETE";
    public static final String ACTION_CONNECTION_FAILED = "org.fdroid.fdroid.net.Downloader.action.CONNECTION_FAILED";
    public static final String ACTION_INTERRUPTED = "org.fdroid.fdroid.net.Downloader.action.INTERRUPTED";
    public static final String ACTION_PROGRESS = "org.fdroid.fdroid.net.Downloader.action.PROGRESS";
    private static final String ACTION_QUEUE = "org.fdroid.fdroid.net.DownloaderService.action.QUEUE";
    public static final String ACTION_STARTED = "org.fdroid.fdroid.net.Downloader.action.STARTED";
    public static final String EXTRA_BYTES_READ = "org.fdroid.fdroid.net.Downloader.extra.BYTES_READ";
    public static final String EXTRA_CANONICAL_URL = "org.fdroid.fdroid.net.Downloader.extra.CANONICAL_URL";
    public static final String EXTRA_DOWNLOAD_PATH = "org.fdroid.fdroid.net.Downloader.extra.DOWNLOAD_PATH";
    public static final String EXTRA_ERROR_MESSAGE = "org.fdroid.fdroid.net.Downloader.extra.ERROR_MESSAGE";
    private static final String EXTRA_MIRROR_URL = "org.fdroid.fdroid.net.Downloader.extra.MIRROR_URL";
    private static final String EXTRA_REPO_ID = "org.fdroid.fdroid.net.Downloader.extra.REPO_ID";
    public static final String EXTRA_TOTAL_BYTES = "org.fdroid.fdroid.net.Downloader.extra.TOTAL_BYTES";
    private static final int JOB_ID = 1964029344;
    private static final String TAG = "DownloaderService";
    private static volatile String activeCanonicalUrl;
    private static volatile Downloader downloader;
    private InstallManagerService installManagerService;
    private LocalBroadcastManager localBroadcastManager;

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        Utils.debugLog(TAG, "Creating downloader service.");
        this.installManagerService = InstallManagerService.getInstance(this);
        this.localBroadcastManager = LocalBroadcastManager.getInstance(this);
    }

    @Override // androidx.core.app.JobIntentService
    protected void onHandleWork(Intent intent) {
        Utils.debugLog(TAG, "Received Intent for downloading: " + intent);
        if (intent.getDataString() == null) {
            Utils.debugLog(TAG, "Received Intent with no URI: " + intent);
        } else if (ACTION_QUEUE.equals(intent.getAction())) {
            handleIntent(intent);
        } else {
            Utils.debugLog(TAG, "Received Intent with unknown action: " + intent);
        }
    }

    @Override // androidx.core.app.JobIntentService
    public boolean onStopCurrentWork() {
        Log.i(TAG, "onStopCurrentWork - activeCanonicalUrl: " + activeCanonicalUrl);
        cancel(activeCanonicalUrl);
        return true;
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onDestroy() {
        Utils.debugLog(TAG, "Destroying downloader service.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x012c, code lost:
        if (org.fdroid.fdroid.net.DownloaderService.downloader != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x012e, code lost:
        org.fdroid.fdroid.net.DownloaderService.downloader.close();
        r15 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x016f, code lost:
        if (org.fdroid.fdroid.net.DownloaderService.downloader == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01a0, code lost:
        if (org.fdroid.fdroid.net.DownloaderService.downloader != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01b5, code lost:
        if (org.fdroid.fdroid.net.DownloaderService.downloader == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01b9, code lost:
        org.fdroid.fdroid.net.DownloaderService.downloader = r15;
        org.fdroid.fdroid.net.DownloaderService.activeCanonicalUrl = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01bd, code lost:
        return;
     */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v7, types: [java.lang.String, org.fdroid.download.Downloader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void handleIntent(android.content.Intent r19) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.fdroid.net.DownloaderService.handleIntent(android.content.Intent):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleIntent$0(long[] jArr, Uri uri, App app, Apk apk, long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - jArr[0] < 1000) {
            return;
        }
        jArr[0] = currentTimeMillis;
        Intent intent = new Intent(ACTION_PROGRESS);
        intent.setData(uri);
        intent.putExtra(EXTRA_BYTES_READ, j);
        intent.putExtra(EXTRA_TOTAL_BYTES, j2);
        this.localBroadcastManager.sendBroadcast(intent);
        this.installManagerService.onDownloadProgress(uri, app, apk, j, j2);
    }

    private void sendBroadcast(Uri uri, String str, File file, long j, Uri uri2) {
        sendBroadcast(uri, str, file, null, j, uri2);
    }

    private void sendBroadcast(Uri uri, String str, File file, String str2, long j, Uri uri2) {
        Intent intent = new Intent(str);
        if (uri2 != null) {
            intent.setData(uri2);
        }
        if (file != null) {
            intent.putExtra(EXTRA_DOWNLOAD_PATH, file.getAbsolutePath());
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(EXTRA_ERROR_MESSAGE, str2);
        }
        intent.putExtra(EXTRA_REPO_ID, j);
        intent.putExtra(EXTRA_MIRROR_URL, uri.toString());
        this.localBroadcastManager.sendBroadcast(intent);
    }

    public static void queue(Context context, long j, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Utils.debugLog(TAG, "Queue download " + str.hashCode() + "/" + str);
        Intent intent = new Intent(context, DownloaderService.class);
        intent.setAction(ACTION_QUEUE);
        intent.setData(Uri.parse(str));
        intent.putExtra(EXTRA_REPO_ID, j);
        intent.putExtra(EXTRA_CANONICAL_URL, str2);
        JobIntentService.enqueueWork(context, DownloaderService.class, JOB_ID, intent);
    }

    public static void queue(Context context, String str, App app, Apk apk) {
        if (TextUtils.isEmpty(str) || apk.apkFile == null) {
            return;
        }
        Utils.debugLog(TAG, "Queue download " + str.hashCode() + "/" + str);
        Intent intent = new Intent(context, DownloaderService.class);
        intent.setAction(ACTION_QUEUE);
        intent.setData(Uri.parse(str));
        intent.putExtra(Installer.EXTRA_APP, app);
        intent.putExtra(Installer.EXTRA_APK, apk);
        JobIntentService.enqueueWork(context, DownloaderService.class, JOB_ID, intent);
    }

    public static void cancel(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Utils.debugLog(TAG, "Cancelling download of " + str.hashCode() + "/" + str + " downloading from " + str);
        int hashCode = str.hashCode();
        if (isActive(str)) {
            downloader.cancelDownload();
            return;
        }
        Utils.debugLog(TAG, "ACTION_CANCEL called on something not queued or running (expected to find message with ID of " + hashCode + " in queue).");
    }

    private static boolean isActive(String str) {
        return downloader != null && TextUtils.equals(str, activeCanonicalUrl);
    }

    public static IntentFilter getIntentFilter(String str) {
        Uri parse = Uri.parse(str);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_STARTED);
        intentFilter.addAction(ACTION_PROGRESS);
        intentFilter.addAction(ACTION_COMPLETE);
        intentFilter.addAction(ACTION_INTERRUPTED);
        intentFilter.addAction(ACTION_CONNECTION_FAILED);
        intentFilter.addDataScheme(parse.getScheme());
        intentFilter.addDataAuthority(parse.getHost(), String.valueOf(parse.getPort()));
        intentFilter.addDataPath(parse.getPath(), 0);
        return intentFilter;
    }
}
