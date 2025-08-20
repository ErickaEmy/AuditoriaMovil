package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
class PermissionDelegateImplV33 extends PermissionDelegateImplV31 {
    @Override // com.hjq.permissions.PermissionDelegateImplV31, com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.BODY_SENSORS_BACKGROUND)) {
            if (PermissionUtils.checkSelfPermission(context, Permission.BODY_SENSORS) && PermissionUtils.checkSelfPermission(context, Permission.BODY_SENSORS_BACKGROUND)) {
                return true;
            }
            return false;
        } else if (!PermissionUtils.equalsPermission(str, Permission.POST_NOTIFICATIONS) && !PermissionUtils.equalsPermission(str, Permission.NEARBY_WIFI_DEVICES) && !PermissionUtils.equalsPermission(str, Permission.READ_MEDIA_IMAGES) && !PermissionUtils.equalsPermission(str, Permission.READ_MEDIA_VIDEO) && !PermissionUtils.equalsPermission(str, Permission.READ_MEDIA_AUDIO)) {
            return super.isGrantedPermission(context, str);
        } else {
            return PermissionUtils.checkSelfPermission(context, str);
        }
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV31, com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isPermissionPermanentDenied(@NonNull Activity activity, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.BODY_SENSORS_BACKGROUND)) {
            if (!PermissionUtils.checkSelfPermission(activity, Permission.BODY_SENSORS)) {
                return !PermissionUtils.shouldShowRequestPermissionRationale(activity, Permission.BODY_SENSORS);
            }
            if (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) {
                return false;
            }
            return true;
        } else if (!PermissionUtils.equalsPermission(str, Permission.POST_NOTIFICATIONS) && !PermissionUtils.equalsPermission(str, Permission.NEARBY_WIFI_DEVICES) && !PermissionUtils.equalsPermission(str, Permission.READ_MEDIA_IMAGES) && !PermissionUtils.equalsPermission(str, Permission.READ_MEDIA_VIDEO) && !PermissionUtils.equalsPermission(str, Permission.READ_MEDIA_AUDIO)) {
            return super.isPermissionPermanentDenied(activity, str);
        } else {
            if (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) {
                return false;
            }
            return true;
        }
    }
}
