package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PermissionDelegateImplV28 extends PermissionDelegateImplV26 {
    @Override // com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.ACCEPT_HANDOVER)) {
            return PermissionUtils.checkSelfPermission(context, str);
        }
        return super.isGrantedPermission(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isPermissionPermanentDenied(@NonNull Activity activity, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.ACCEPT_HANDOVER)) {
            if (!PermissionUtils.checkSelfPermission(activity, str) && !PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) {
                return true;
            }
            return false;
        }
        return super.isPermissionPermanentDenied(activity, str);
    }
}
