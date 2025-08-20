package org.fdroid;

import android.os.Build;
import kotlin.Metadata;
/* compiled from: CompatibilityChecker.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lorg/fdroid/CompatibilityCheckerUtils;", "", "()V", "minInstallableTargetSdk", "", "sdkInt", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CompatibilityCheckerUtils {
    public static final CompatibilityCheckerUtils INSTANCE = new CompatibilityCheckerUtils();

    private CompatibilityCheckerUtils() {
    }

    public final int minInstallableTargetSdk() {
        return minInstallableTargetSdk$default(this, 0, 1, null);
    }

    public final int minInstallableTargetSdk(int i) {
        if (i != 34) {
            return i != 35 ? 1 : 24;
        }
        return 23;
    }

    public static /* synthetic */ int minInstallableTargetSdk$default(CompatibilityCheckerUtils compatibilityCheckerUtils, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Build.VERSION.SDK_INT;
        }
        return compatibilityCheckerUtils.minInstallableTargetSdk(i);
    }
}
