package com.hjq.permissions;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
class PermissionDelegateImplV31 extends PermissionDelegateImplV30 {
    private static Intent getAlarmPermissionIntent(@NonNull Context context) {
        Intent intent = new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM");
        intent.setData(PermissionUtils.getPackageNameUri(context));
        if (!PermissionUtils.areActivityIntent(context, intent)) {
            return PermissionUtils.getApplicationDetailsIntent(context);
        }
        return intent;
    }

    private static boolean isGrantedAlarmPermission(@NonNull Context context) {
        return ((AlarmManager) context.getSystemService(AlarmManager.class)).canScheduleExactAlarms();
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public Intent getPermissionIntent(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.SCHEDULE_EXACT_ALARM)) {
            return getAlarmPermissionIntent(context);
        }
        return super.getPermissionIntent(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.SCHEDULE_EXACT_ALARM)) {
            return isGrantedAlarmPermission(context);
        }
        if (!PermissionUtils.equalsPermission(str, Permission.BLUETOOTH_SCAN) && !PermissionUtils.equalsPermission(str, Permission.BLUETOOTH_CONNECT) && !PermissionUtils.equalsPermission(str, Permission.BLUETOOTH_ADVERTISE)) {
            return super.isGrantedPermission(context, str);
        }
        return PermissionUtils.checkSelfPermission(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isPermissionPermanentDenied(@NonNull Activity activity, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.SCHEDULE_EXACT_ALARM)) {
            return false;
        }
        if (!PermissionUtils.equalsPermission(str, Permission.BLUETOOTH_SCAN) && !PermissionUtils.equalsPermission(str, Permission.BLUETOOTH_CONNECT) && !PermissionUtils.equalsPermission(str, Permission.BLUETOOTH_ADVERTISE)) {
            if (activity.getApplicationInfo().targetSdkVersion >= 31 && PermissionUtils.equalsPermission(str, Permission.ACCESS_BACKGROUND_LOCATION)) {
                if (!PermissionUtils.checkSelfPermission(activity, Permission.ACCESS_FINE_LOCATION) && !PermissionUtils.checkSelfPermission(activity, Permission.ACCESS_COARSE_LOCATION)) {
                    if (PermissionUtils.shouldShowRequestPermissionRationale(activity, Permission.ACCESS_FINE_LOCATION) || PermissionUtils.shouldShowRequestPermissionRationale(activity, Permission.ACCESS_COARSE_LOCATION)) {
                        return false;
                    }
                    return true;
                } else if (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) {
                    return false;
                } else {
                    return true;
                }
            }
            return super.isPermissionPermanentDenied(activity, str);
        } else if (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) {
            return false;
        } else {
            return true;
        }
    }
}
