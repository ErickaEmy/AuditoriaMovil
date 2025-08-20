package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
class PermissionDelegateImplV30 extends PermissionDelegateImplV29 {
    private static Intent getManageStoragePermissionIntent(@NonNull Context context) {
        Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
        intent.setData(PermissionUtils.getPackageNameUri(context));
        if (!PermissionUtils.areActivityIntent(context, intent)) {
            intent = new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
        }
        if (!PermissionUtils.areActivityIntent(context, intent)) {
            return PermissionUtils.getApplicationDetailsIntent(context);
        }
        return intent;
    }

    private static boolean isGrantedManageStoragePermission() {
        return Environment.isExternalStorageManager();
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public Intent getPermissionIntent(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.MANAGE_EXTERNAL_STORAGE)) {
            return getManageStoragePermissionIntent(context);
        }
        return super.getPermissionIntent(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.MANAGE_EXTERNAL_STORAGE)) {
            return isGrantedManageStoragePermission();
        }
        return super.isGrantedPermission(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isPermissionPermanentDenied(@NonNull Activity activity, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.MANAGE_EXTERNAL_STORAGE)) {
            return false;
        }
        return super.isPermissionPermanentDenied(activity, str);
    }
}
