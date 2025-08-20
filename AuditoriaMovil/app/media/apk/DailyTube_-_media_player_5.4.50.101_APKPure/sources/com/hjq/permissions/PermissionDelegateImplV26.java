package com.hjq.permissions;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PermissionDelegateImplV26 extends PermissionDelegateImplV23 {
    private static Intent getInstallPermissionIntent(@NonNull Context context) {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
        intent.setData(PermissionUtils.getPackageNameUri(context));
        if (!PermissionUtils.areActivityIntent(context, intent)) {
            return PermissionUtils.getApplicationDetailsIntent(context);
        }
        return intent;
    }

    private static Intent getPictureInPicturePermissionIntent(@NonNull Context context) {
        Intent intent = new Intent("android.settings.PICTURE_IN_PICTURE_SETTINGS");
        intent.setData(PermissionUtils.getPackageNameUri(context));
        if (!PermissionUtils.areActivityIntent(context, intent)) {
            return PermissionUtils.getApplicationDetailsIntent(context);
        }
        return intent;
    }

    private static boolean isGrantedInstallPermission(@NonNull Context context) {
        return context.getPackageManager().canRequestPackageInstalls();
    }

    private static boolean isGrantedPictureInPicturePermission(@NonNull Context context) {
        int checkOpNoThrow;
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        if (AndroidVersion.isAndroid10()) {
            checkOpNoThrow = appOpsManager.unsafeCheckOpNoThrow("android:picture_in_picture", context.getApplicationInfo().uid, context.getPackageName());
        } else {
            checkOpNoThrow = appOpsManager.checkOpNoThrow("android:picture_in_picture", context.getApplicationInfo().uid, context.getPackageName());
        }
        if (checkOpNoThrow == 0) {
            return true;
        }
        return false;
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public Intent getPermissionIntent(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.REQUEST_INSTALL_PACKAGES)) {
            return getInstallPermissionIntent(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.PICTURE_IN_PICTURE)) {
            return getPictureInPicturePermissionIntent(context);
        }
        return super.getPermissionIntent(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.REQUEST_INSTALL_PACKAGES)) {
            return isGrantedInstallPermission(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.PICTURE_IN_PICTURE)) {
            return isGrantedPictureInPicturePermission(context);
        }
        if (!PermissionUtils.equalsPermission(str, Permission.READ_PHONE_NUMBERS) && !PermissionUtils.equalsPermission(str, Permission.ANSWER_PHONE_CALLS)) {
            return super.isGrantedPermission(context, str);
        }
        return PermissionUtils.checkSelfPermission(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isPermissionPermanentDenied(@NonNull Activity activity, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.REQUEST_INSTALL_PACKAGES) || PermissionUtils.equalsPermission(str, Permission.PICTURE_IN_PICTURE)) {
            return false;
        }
        if (!PermissionUtils.equalsPermission(str, Permission.READ_PHONE_NUMBERS) && !PermissionUtils.equalsPermission(str, Permission.ANSWER_PHONE_CALLS)) {
            return super.isPermissionPermanentDenied(activity, str);
        }
        if (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) {
            return false;
        }
        return true;
    }
}
