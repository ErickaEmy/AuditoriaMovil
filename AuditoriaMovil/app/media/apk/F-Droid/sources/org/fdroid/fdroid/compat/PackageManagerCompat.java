package org.fdroid.fdroid.compat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import org.fdroid.fdroid.BuildConfig;
import org.fdroid.fdroid.Utils;
import org.fdroid.fdroid.installer.PrivilegedInstaller;
/* loaded from: classes2.dex */
public class PackageManagerCompat {
    private static final String TAG = "PackageManagerCompat";

    public static void setInstaller(Context context, PackageManager packageManager, String str) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            return;
        }
        if (i >= 24) {
            try {
                if (PrivilegedInstaller.isDefault(context)) {
                    packageManager.setInstallerPackageName(str, "org.fdroid.fdroid.privileged");
                    Utils.debugLog(TAG, "Installer package name for " + str + " set successfully");
                }
            } catch (IllegalArgumentException e) {
                e = e;
                Log.e(TAG, "Could not set installer package name for " + str, e);
                return;
            } catch (SecurityException e2) {
                e = e2;
                Log.e(TAG, "Could not set installer package name for " + str, e);
                return;
            }
        }
        packageManager.setInstallerPackageName(str, BuildConfig.APPLICATION_ID);
        Utils.debugLog(TAG, "Installer package name for " + str + " set successfully");
    }
}
