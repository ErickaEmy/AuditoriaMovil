package org.fdroid.fdroid.installer;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.io.IOException;
import org.fdroid.fdroid.Utils;
import org.fdroid.fdroid.data.Apk;
import org.fdroid.fdroid.data.App;
import org.fdroid.fdroid.installer.ApkVerifier;
import org.fdroid.fdroid.privileged.views.AppDiff;
import org.fdroid.fdroid.privileged.views.AppSecurityPermissions;
import org.fdroid.fdroid.privileged.views.InstallConfirmActivity;
import org.fdroid.fdroid.privileged.views.UninstallDialogActivity;
/* loaded from: classes2.dex */
public abstract class Installer {
    public static final String ACTION_INSTALL_COMPLETE = "org.fdroid.fdroid.installer.Installer.action.INSTALL_COMPLETE";
    public static final String ACTION_INSTALL_INTERRUPTED = "org.fdroid.fdroid.installer.Installer.action.INSTALL_INTERRUPTED";
    public static final String ACTION_INSTALL_STARTED = "org.fdroid.fdroid.installer.Installer.action.INSTALL_STARTED";
    public static final String ACTION_INSTALL_USER_INTERACTION = "org.fdroid.fdroid.installer.Installer.action.INSTALL_USER_INTERACTION";
    public static final String ACTION_UNINSTALL_COMPLETE = "org.fdroid.fdroid.installer.Installer.action.UNINSTALL_COMPLETE";
    public static final String ACTION_UNINSTALL_INTERRUPTED = "org.fdroid.fdroid.installer.Installer.action.UNINSTALL_INTERRUPTED";
    public static final String ACTION_UNINSTALL_STARTED = "org.fdroid.fdroid.installer.Installer.action.UNINSTALL_STARTED";
    public static final String ACTION_UNINSTALL_USER_INTERACTION = "org.fdroid.fdroid.installer.Installer.action.UNINSTALL_USER_INTERACTION";
    public static final String AUTHORITY = "org.fdroid.fdroid.installer";
    public static final String EXTRA_APK = "org.fdroid.fdroid.installer.Installer.extra.APK";
    public static final String EXTRA_APP = "org.fdroid.fdroid.installer.Installer.extra.APP";
    public static final String EXTRA_ERROR_MESSAGE = "org.fdroid.fdroid.net.installer.Installer.extra.ERROR_MESSAGE";
    public static final String EXTRA_USER_INTERACTION_PI = "org.fdroid.fdroid.installer.Installer.extra.USER_INTERACTION_PI";
    private static final String TAG = "Installer";
    final Apk apk;
    final App app;
    final Context context;

    protected abstract void installPackageInternal(Uri uri, Uri uri2);

    protected abstract boolean isUnattended();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void uninstallPackage();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Installer(Context context, App app, Apk apk) {
        this.context = context;
        this.app = app;
        this.apk = apk;
    }

    public Intent getPermissionScreen() {
        if (isUnattended() && newPermissionCount() != 0) {
            Intent intent = new Intent(this.context, InstallConfirmActivity.class);
            intent.putExtra(EXTRA_APP, this.app);
            intent.putExtra(EXTRA_APK, this.apk);
            return intent;
        }
        return null;
    }

    private int newPermissionCount() {
        Apk apk = this.apk;
        if (apk.targetSdkVersion >= 23) {
            return 0;
        }
        AppDiff appDiff = new AppDiff(this.context, apk);
        AppSecurityPermissions appSecurityPermissions = new AppSecurityPermissions(this.context, appDiff.apkPackageInfo);
        if (appDiff.installedApplicationInfo != null) {
            return appSecurityPermissions.getPermissionCount(4);
        }
        return appSecurityPermissions.getPermissionCount(65535);
    }

    public Intent getUninstallScreen() {
        String str = null;
        if (isUnattended()) {
            try {
                str = this.context.getPackageManager().getInstallerPackageName(this.apk.packageName);
            } catch (IllegalArgumentException e) {
                Log.e(TAG, "App not installed: " + this.apk.packageName, e);
            }
            if (Build.VERSION.SDK_INT >= 24 && ("com.android.packageinstaller".equals(str) || "com.google.android.packageinstaller".equals(str))) {
                Utils.debugLog(TAG, "Falling back to default installer for uninstall");
                Intent intent = new Intent(this.context, DefaultInstallerActivity.class);
                intent.setAction("org.fdroid.fdroid.installer.DefaultInstaller.action.UNINSTALL_PACKAGE");
                intent.putExtra(EXTRA_APP, this.app);
                intent.putExtra(EXTRA_APK, this.apk);
                return intent;
            }
            Intent intent2 = new Intent(this.context, UninstallDialogActivity.class);
            intent2.putExtra(EXTRA_APP, this.app);
            intent2.putExtra(EXTRA_APK, this.apk);
            return intent2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendBroadcastInstall(Uri uri, String str, PendingIntent pendingIntent) {
        sendBroadcastInstall(this.context, uri, str, this.app, this.apk, pendingIntent, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendBroadcastInstall(Uri uri, String str) {
        sendBroadcastInstall(this.context, uri, str, this.app, this.apk, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendBroadcastInstall(Uri uri, String str, String str2) {
        sendBroadcastInstall(this.context, uri, str, this.app, this.apk, null, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sendBroadcastInstall(Context context, Uri uri, String str, App app, Apk apk, PendingIntent pendingIntent, String str2) {
        Intent intent = new Intent(str);
        intent.setData(uri);
        intent.putExtra(EXTRA_USER_INTERACTION_PI, pendingIntent);
        intent.putExtra(EXTRA_APP, app);
        intent.putExtra(EXTRA_APK, apk);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(EXTRA_ERROR_MESSAGE, str2);
        }
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendBroadcastUninstall(String str, String str2) {
        sendBroadcastUninstall(str, null, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendBroadcastUninstall(String str) {
        sendBroadcastUninstall(str, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendBroadcastUninstall(String str, PendingIntent pendingIntent) {
        sendBroadcastUninstall(str, pendingIntent, null);
    }

    private void sendBroadcastUninstall(String str, PendingIntent pendingIntent, String str2) {
        sendBroadcastUninstall(this.context, this.app, this.apk, str, pendingIntent, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sendBroadcastUninstall(Context context, App app, Apk apk, String str) {
        sendBroadcastUninstall(context, app, apk, str, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sendBroadcastUninstall(Context context, App app, Apk apk, String str, PendingIntent pendingIntent, String str2) {
        Uri fromParts = Uri.fromParts("package", apk.packageName, null);
        Intent intent = new Intent(str);
        intent.setData(fromParts);
        intent.putExtra(EXTRA_APP, app);
        intent.putExtra(EXTRA_APK, apk);
        intent.putExtra(EXTRA_USER_INTERACTION_PI, pendingIntent);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(EXTRA_ERROR_MESSAGE, str2);
        }
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IntentFilter getInstallIntentFilter(Uri uri) {
        IntentFilter installInteractionIntentFilter = getInstallInteractionIntentFilter(uri);
        installInteractionIntentFilter.addAction(ACTION_INSTALL_STARTED);
        installInteractionIntentFilter.addAction(ACTION_INSTALL_COMPLETE);
        installInteractionIntentFilter.addAction(ACTION_INSTALL_INTERRUPTED);
        return installInteractionIntentFilter;
    }

    public static IntentFilter getInstallInteractionIntentFilter(Uri uri) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_INSTALL_USER_INTERACTION);
        intentFilter.addDataScheme(uri.getScheme());
        intentFilter.addDataAuthority(uri.getHost(), String.valueOf(uri.getPort()));
        intentFilter.addDataPath(uri.getPath(), 0);
        return intentFilter;
    }

    public static IntentFilter getInstallIntentFilter(String str) {
        return getInstallIntentFilter(Uri.parse(str));
    }

    public static IntentFilter getUninstallIntentFilter(String str) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_UNINSTALL_STARTED);
        intentFilter.addAction(ACTION_UNINSTALL_COMPLETE);
        intentFilter.addAction(ACTION_UNINSTALL_INTERRUPTED);
        intentFilter.addAction(ACTION_UNINSTALL_USER_INTERACTION);
        intentFilter.addDataScheme("package");
        intentFilter.addDataPath(str, 0);
        return intentFilter;
    }

    public void installPackage(Uri uri, Uri uri2) {
        try {
            Uri safeUri = ApkFileProvider.getSafeUri(this.context, uri, this.apk);
            try {
                new ApkVerifier(this.context, uri, this.apk).verifyApk();
            } catch (ApkVerifier.ApkPermissionUnequalException unused) {
            } catch (ApkVerifier.ApkVerificationException e) {
                Utils.debugLog(TAG, e.getMessage(), e);
                sendBroadcastInstall(uri2, ACTION_INSTALL_INTERRUPTED, e.getMessage());
                return;
            }
            installPackageInternal(safeUri, uri2);
        } catch (IOException e2) {
            Utils.debugLog(TAG, e2.getMessage(), e2);
            sendBroadcastInstall(uri2, ACTION_INSTALL_INTERRUPTED, e2.getMessage());
        }
    }
}
