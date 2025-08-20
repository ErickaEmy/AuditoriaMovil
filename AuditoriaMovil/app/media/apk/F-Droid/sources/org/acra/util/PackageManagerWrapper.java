package org.acra.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.log.ACRALog;
/* compiled from: PackageManagerWrapper.kt */
/* loaded from: classes2.dex */
public final class PackageManagerWrapper {
    private final Context context;

    public PackageManagerWrapper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final boolean hasPermission(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        PackageManager packageManager = this.context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            return packageManager.checkPermission(permission, this.context.getPackageName()) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public final PackageInfo getPackageInfo() {
        PackageManager packageManager = this.context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            return packageManager.getPackageInfo(this.context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            String packageName = this.context.getPackageName();
            aCRALog.w(str, "Failed to find PackageInfo for current App : " + packageName);
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }
}
