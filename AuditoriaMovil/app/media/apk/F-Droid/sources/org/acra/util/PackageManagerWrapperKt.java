package org.acra.util;

import android.content.pm.PackageInfo;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PackageManagerWrapper.kt */
/* loaded from: classes2.dex */
public abstract class PackageManagerWrapperKt {
    public static final long getVersionCodeLong(PackageInfo packageInfo) {
        long longVersionCode;
        Intrinsics.checkNotNullParameter(packageInfo, "<this>");
        if (Build.VERSION.SDK_INT >= 28) {
            longVersionCode = packageInfo.getLongVersionCode();
            return longVersionCode;
        }
        return packageInfo.versionCode;
    }
}
