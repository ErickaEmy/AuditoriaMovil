package org.fdroid.fdroid.installer;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Process;
import androidx.core.util.Pair;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.fdroid.fdroid.Utils;
import org.fdroid.fdroid.data.Apk;
import org.fdroid.fdroid.data.SanitizedFile;
/* loaded from: classes2.dex */
public class ApkCache {
    private static final String CACHE_DIR = "apks";

    /* loaded from: classes2.dex */
    public enum ApkCacheState {
        MISS_OR_PARTIAL,
        CACHED,
        CORRUPTED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair getApkCacheState(Context context, Apk apk) {
        SanitizedFile apkDownloadPath = getApkDownloadPath(context, apk.getCanonicalUrl());
        long length = apkDownloadPath.length();
        if (!apkDownloadPath.exists() || length < apk.size) {
            return new Pair(ApkCacheState.MISS_OR_PARTIAL, apkDownloadPath);
        }
        if (apkIsCached(apkDownloadPath, apk)) {
            return new Pair(ApkCacheState.CACHED, apkDownloadPath);
        }
        return new Pair(ApkCacheState.CORRUPTED, apkDownloadPath);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SanitizedFile copyInstalledApkToFiles(Context context, PackageInfo packageInfo) throws IOException {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        CharSequence applicationLabel = context.getPackageManager().getApplicationLabel(applicationInfo);
        return copyApkToFiles(context, new File(applicationInfo.publicSourceDir), ((Object) applicationLabel) + "-" + packageInfo.versionName + ".apk", false, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SanitizedFile copyApkFromCacheToFiles(Context context, File file, Apk apk) throws IOException {
        String str = apk.packageName;
        return copyApkToFiles(context, file, str + "-" + apk.versionName + ".apk", true, apk.apkFile.getSha256(), "sha256");
    }

    private static SanitizedFile copyApkToFiles(Context context, File file, String str, boolean z, String str2, String str3) throws IOException {
        final SanitizedFile sanitizedFile = new SanitizedFile(context.getFilesDir(), str);
        if (sanitizedFile.exists()) {
            sanitizedFile.delete();
        }
        FileUtils.copyFile(file, sanitizedFile);
        if (z && !Utils.isFileMatchingHash(sanitizedFile, str2, str3)) {
            FileUtils.deleteQuietly(file);
            throw new IOException(file + " failed to verify!");
        }
        new Thread() { // from class: org.fdroid.fdroid.installer.ApkCache.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(19);
                try {
                    Thread.sleep(1200000L);
                } catch (InterruptedException unused) {
                } catch (Throwable th) {
                    FileUtils.deleteQuietly(sanitizedFile);
                    throw th;
                }
                FileUtils.deleteQuietly(sanitizedFile);
            }
        }.start();
        return sanitizedFile;
    }

    public static SanitizedFile getApkDownloadPath(Context context, String str) {
        return getApkDownloadPath(context, Uri.parse(str));
    }

    public static SanitizedFile getApkDownloadPath(Context context, Uri uri) {
        File apkCacheDir = getApkCacheDir(context);
        File file = new File(apkCacheDir, uri.getHost() + "-" + uri.getPort());
        if (!file.exists()) {
            file.mkdirs();
        }
        return new SanitizedFile(file, uri.getLastPathSegment());
    }

    private static boolean apkIsCached(File file, Apk apk) {
        return file.length() == apk.size && Utils.isFileMatchingHash(file, apk.apkFile.getSha256(), "sha256");
    }

    public static File getApkCacheDir(Context context) {
        File file = new File(context.getCacheDir(), CACHE_DIR);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }
}
