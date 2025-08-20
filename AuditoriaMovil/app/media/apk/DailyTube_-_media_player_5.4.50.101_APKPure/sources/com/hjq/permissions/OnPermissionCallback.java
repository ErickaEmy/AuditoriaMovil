package com.hjq.permissions;

import androidx.annotation.NonNull;
import java.util.List;
/* loaded from: classes.dex */
public interface OnPermissionCallback {
    void onDenied(@NonNull List<String> list, boolean z2);

    void onGranted(@NonNull List<String> list, boolean z2);
}
