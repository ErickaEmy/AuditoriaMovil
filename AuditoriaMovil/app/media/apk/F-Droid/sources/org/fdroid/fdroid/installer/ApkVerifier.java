package org.fdroid.fdroid.installer;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.HashSet;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.fdroid.fdroid.Utils;
import org.fdroid.fdroid.data.Apk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ApkVerifier {
    private static final String TAG = "ApkVerifier";
    private final Apk expectedApk;
    private final Uri localApkUri;
    private final PackageManager pm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ApkVerifier(Context context, Uri uri, Apk apk) {
        this.localApkUri = uri;
        this.expectedApk = apk;
        this.pm = context.getPackageManager();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void verifyApk() throws ApkVerificationException, ApkPermissionUnequalException {
        Utils.debugLog(TAG, "localApkUri.getPath: " + this.localApkUri.getPath());
        PackageInfo packageArchiveInfo = this.pm.getPackageArchiveInfo(this.localApkUri.getPath(), PKIFailureInfo.certConfirmed);
        if (packageArchiveInfo == null) {
            throw new ApkVerificationException("Parsing apk file failed! Maybe minSdk of apk is lower than current Sdk? Look into logcat for more specific warnings of Android's PackageParser");
        }
        if (!TextUtils.equals(packageArchiveInfo.packageName, this.expectedApk.packageName)) {
            throw new ApkVerificationException("Apk file has unexpected packageName! " + packageArchiveInfo.packageName);
        } else if (packageArchiveInfo.versionCode < 0) {
            throw new ApkVerificationException("Apk file has no valid versionCode!");
        } else {
            int i = packageArchiveInfo.applicationInfo.targetSdkVersion;
            int i2 = this.expectedApk.targetSdkVersion;
            Utils.debugLog(TAG, "localTargetSdkVersion: " + i);
            Utils.debugLog(TAG, "expectedTargetSdkVersion: " + i2);
            if (i2 == 0) {
                Log.w(TAG, "Skipping check for targetSdkVersion, not available in this app or repo!");
            } else if (i != i2) {
                throw new ApkVerificationException(String.format("TargetSdkVersion of apk file (%d) is not the expected targetSdkVersion (%d)!", Integer.valueOf(i), Integer.valueOf(i2)));
            }
            if (!requestedPermissionsEqual(this.expectedApk.requestedPermissions, packageArchiveInfo.requestedPermissions)) {
                throw new ApkPermissionUnequalException("Permissions in APK and index do not match!");
            }
        }
    }

    static boolean requestedPermissionsEqual(String[] strArr, String[] strArr2) {
        Utils.debugLog(TAG, "Checking permissions");
        StringBuilder sb = new StringBuilder();
        sb.append("Expected:\n  ");
        sb.append(strArr == null ? "None" : TextUtils.join("\n  ", strArr));
        Utils.debugLog(TAG, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Actual:\n  ");
        sb2.append(strArr2 != null ? TextUtils.join("\n  ", strArr2) : "None");
        Utils.debugLog(TAG, sb2.toString());
        if (strArr == null && strArr2 == null) {
            return true;
        }
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        return new HashSet(Arrays.asList(strArr)).equals(new HashSet(Arrays.asList(strArr2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ApkVerificationException extends Exception {
        ApkVerificationException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ApkPermissionUnequalException extends Exception {
        ApkPermissionUnequalException(String str) {
            super(str);
        }
    }
}
