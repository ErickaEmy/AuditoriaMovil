package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public interface PermissionDelegate {
    Intent getPermissionIntent(@NonNull Context context, @NonNull String str);

    boolean isGrantedPermission(@NonNull Context context, @NonNull String str);

    boolean isPermissionPermanentDenied(@NonNull Activity activity, @NonNull String str);
}
