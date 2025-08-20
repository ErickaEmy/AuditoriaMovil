package org.fdroid;

import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.index.v2.PackageManifest;
/* compiled from: CompatibilityChecker.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\rj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0014"}, d2 = {"Lorg/fdroid/CompatibilityCheckerImpl;", "Lorg/fdroid/CompatibilityChecker;", "packageManager", "Landroid/content/pm/PackageManager;", "forceTouchApps", "", "sdkInt", "", "supportedAbis", "", "", "(Landroid/content/pm/PackageManager;ZI[Ljava/lang/String;)V", "features", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "[Ljava/lang/String;", "isCompatible", "manifest", "Lorg/fdroid/index/v2/PackageManifest;", "isNativeCodeCompatible", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CompatibilityCheckerImpl implements CompatibilityChecker {
    private final HashMap<String, Integer> features;
    private final boolean forceTouchApps;
    private final int sdkInt;
    private final String[] supportedAbis;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CompatibilityCheckerImpl(PackageManager packageManager) {
        this(packageManager, false, 0, null, 14, null);
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CompatibilityCheckerImpl(PackageManager packageManager, boolean z) {
        this(packageManager, z, 0, null, 12, null);
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CompatibilityCheckerImpl(PackageManager packageManager, boolean z, int i) {
        this(packageManager, z, i, null, 8, null);
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
    }

    public CompatibilityCheckerImpl(PackageManager packageManager, boolean z, int i, String[] supportedAbis) {
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Intrinsics.checkNotNullParameter(supportedAbis, "supportedAbis");
        this.forceTouchApps = z;
        this.sdkInt = i;
        this.supportedAbis = supportedAbis;
        HashMap<String, Integer> hashMap = new HashMap<>();
        FeatureInfo[] systemAvailableFeatures = packageManager.getSystemAvailableFeatures();
        if (systemAvailableFeatures != null) {
            Intrinsics.checkNotNull(systemAvailableFeatures);
            for (FeatureInfo featureInfo : systemAvailableFeatures) {
                hashMap.put(featureInfo.name, Integer.valueOf(Build.VERSION.SDK_INT >= 24 ? featureInfo.version : 0));
            }
        }
        this.features = hashMap;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ CompatibilityCheckerImpl(android.content.pm.PackageManager r1, boolean r2, int r3, java.lang.String[] r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r6 = r5 & 2
            if (r6 == 0) goto L5
            r2 = 0
        L5:
            r6 = r5 & 4
            if (r6 == 0) goto Lb
            int r3 = android.os.Build.VERSION.SDK_INT
        Lb:
            r5 = r5 & 8
            if (r5 == 0) goto L16
            java.lang.String[] r4 = android.os.Build.SUPPORTED_ABIS
            java.lang.String r5 = "SUPPORTED_ABIS"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
        L16:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.CompatibilityCheckerImpl.<init>(android.content.pm.PackageManager, boolean, int, java.lang.String[], int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // org.fdroid.CompatibilityChecker
    public boolean isCompatible(PackageManifest manifest) {
        Intrinsics.checkNotNullParameter(manifest, "manifest");
        int i = this.sdkInt;
        Integer minSdkVersion = manifest.getMinSdkVersion();
        if (i < (minSdkVersion != null ? minSdkVersion.intValue() : 0)) {
            return false;
        }
        int i2 = this.sdkInt;
        Integer maxSdkVersion = manifest.getMaxSdkVersion();
        if (i2 > (maxSdkVersion != null ? maxSdkVersion.intValue() : Integer.MAX_VALUE)) {
            return false;
        }
        Integer targetSdkVersion = manifest.getTargetSdkVersion();
        if ((targetSdkVersion != null ? targetSdkVersion.intValue() : 1) >= CompatibilityCheckerUtils.INSTANCE.minInstallableTargetSdk(this.sdkInt) && isNativeCodeCompatible(manifest)) {
            List<String> featureNames = manifest.getFeatureNames();
            if (featureNames != null && (r6 = featureNames.iterator()) != null) {
                for (String str : featureNames) {
                    if (!this.forceTouchApps || !Intrinsics.areEqual(str, "android.hardware.touchscreen")) {
                        if (!this.features.containsKey(str)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    private final boolean isNativeCodeCompatible(PackageManifest packageManifest) {
        List<String> nativecode = packageManifest.getNativecode();
        if (nativecode == null || nativecode.isEmpty()) {
            return true;
        }
        for (String str : this.supportedAbis) {
            if (nativecode.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
