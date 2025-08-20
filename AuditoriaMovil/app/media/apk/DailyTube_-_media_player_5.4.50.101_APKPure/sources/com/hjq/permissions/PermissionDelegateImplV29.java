package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import androidx.annotation.NonNull;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PermissionDelegateImplV29 extends PermissionDelegateImplV28 {
    private boolean hasReadStoragePermission(@NonNull Context context) {
        if (AndroidVersion.isAndroid13() && AndroidVersion.getTargetSdkVersionCode(context) >= 33) {
            if (PermissionUtils.checkSelfPermission(context, Permission.READ_MEDIA_IMAGES) || isGrantedPermission(context, Permission.MANAGE_EXTERNAL_STORAGE)) {
                return true;
            }
            return false;
        } else if (AndroidVersion.isAndroid11() && AndroidVersion.getTargetSdkVersionCode(context) >= 30) {
            if (PermissionUtils.checkSelfPermission(context, Permission.READ_EXTERNAL_STORAGE) || isGrantedPermission(context, Permission.MANAGE_EXTERNAL_STORAGE)) {
                return true;
            }
            return false;
        } else {
            return PermissionUtils.checkSelfPermission(context, Permission.READ_EXTERNAL_STORAGE);
        }
    }

    private static boolean isUseDeprecationExternalStorage() {
        return Environment.isExternalStorageLegacy();
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.ACCESS_MEDIA_LOCATION)) {
            if (!hasReadStoragePermission(context) || !PermissionUtils.checkSelfPermission(context, Permission.ACCESS_MEDIA_LOCATION)) {
                return false;
            }
            return true;
        } else if (!PermissionUtils.equalsPermission(str, Permission.ACCESS_BACKGROUND_LOCATION) && !PermissionUtils.equalsPermission(str, Permission.ACTIVITY_RECOGNITION)) {
            if (!AndroidVersion.isAndroid11() && PermissionUtils.equalsPermission(str, Permission.MANAGE_EXTERNAL_STORAGE) && !isUseDeprecationExternalStorage()) {
                return false;
            }
            return super.isGrantedPermission(context, str);
        } else {
            return PermissionUtils.checkSelfPermission(context, str);
        }
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isPermissionPermanentDenied(@NonNull Activity activity, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.ACCESS_BACKGROUND_LOCATION)) {
            if (!PermissionUtils.checkSelfPermission(activity, Permission.ACCESS_FINE_LOCATION)) {
                return !PermissionUtils.shouldShowRequestPermissionRationale(activity, Permission.ACCESS_FINE_LOCATION);
            }
            if (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) {
                return false;
            }
            return true;
        } else if (PermissionUtils.equalsPermission(str, Permission.ACCESS_MEDIA_LOCATION)) {
            if (!hasReadStoragePermission(activity) || PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) {
                return false;
            }
            return true;
        } else if (PermissionUtils.equalsPermission(str, Permission.ACTIVITY_RECOGNITION)) {
            if (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) {
                return false;
            }
            return true;
        } else if (!AndroidVersion.isAndroid11() && PermissionUtils.equalsPermission(str, Permission.MANAGE_EXTERNAL_STORAGE) && !isUseDeprecationExternalStorage()) {
            return true;
        } else {
            return super.isPermissionPermanentDenied(activity, str);
        }
    }
}
