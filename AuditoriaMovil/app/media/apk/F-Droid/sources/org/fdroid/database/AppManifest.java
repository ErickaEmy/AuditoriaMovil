package org.fdroid.database;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.index.v2.PackageManifest;
import org.fdroid.index.v2.SignerV2;
import org.fdroid.index.v2.UsesSdkV2;
/* compiled from: Version.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003Jj\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\tHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00063"}, d2 = {"Lorg/fdroid/database/AppManifest;", "Lorg/fdroid/index/v2/PackageManifest;", "versionName", "", "versionCode", "", "usesSdk", "Lorg/fdroid/index/v2/UsesSdkV2;", "maxSdkVersion", "", "signer", "Lorg/fdroid/index/v2/SignerV2;", "nativecode", "", "features", "(Ljava/lang/String;JLorg/fdroid/index/v2/UsesSdkV2;Ljava/lang/Integer;Lorg/fdroid/index/v2/SignerV2;Ljava/util/List;Ljava/util/List;)V", "featureNames", "getFeatureNames", "()Ljava/util/List;", "getFeatures", "getMaxSdkVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "minSdkVersion", "getMinSdkVersion", "getNativecode", "getSigner", "()Lorg/fdroid/index/v2/SignerV2;", "targetSdkVersion", "getTargetSdkVersion", "getUsesSdk", "()Lorg/fdroid/index/v2/UsesSdkV2;", "getVersionCode", "()J", "getVersionName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;JLorg/fdroid/index/v2/UsesSdkV2;Ljava/lang/Integer;Lorg/fdroid/index/v2/SignerV2;Ljava/util/List;Ljava/util/List;)Lorg/fdroid/database/AppManifest;", "equals", "", "other", "", "hashCode", "toString", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AppManifest implements PackageManifest {
    private final List<String> features;
    private final Integer maxSdkVersion;
    private final List<String> nativecode;
    private final SignerV2 signer;
    private final UsesSdkV2 usesSdk;
    private final long versionCode;
    private final String versionName;

    public final String component1() {
        return this.versionName;
    }

    public final long component2() {
        return this.versionCode;
    }

    public final UsesSdkV2 component3() {
        return this.usesSdk;
    }

    public final Integer component4() {
        return this.maxSdkVersion;
    }

    public final SignerV2 component5() {
        return this.signer;
    }

    public final List<String> component6() {
        return this.nativecode;
    }

    public final List<String> component7() {
        return this.features;
    }

    public final AppManifest copy(String versionName, long j, UsesSdkV2 usesSdkV2, Integer num, SignerV2 signerV2, List<String> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        return new AppManifest(versionName, j, usesSdkV2, num, signerV2, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AppManifest) {
            AppManifest appManifest = (AppManifest) obj;
            return Intrinsics.areEqual(this.versionName, appManifest.versionName) && this.versionCode == appManifest.versionCode && Intrinsics.areEqual(this.usesSdk, appManifest.usesSdk) && Intrinsics.areEqual(this.maxSdkVersion, appManifest.maxSdkVersion) && Intrinsics.areEqual(this.signer, appManifest.signer) && Intrinsics.areEqual(this.nativecode, appManifest.nativecode) && Intrinsics.areEqual(this.features, appManifest.features);
        }
        return false;
    }

    @Override // org.fdroid.index.v2.PackageManifest
    public List<String> getFeatureNames() {
        return this.features;
    }

    public final List<String> getFeatures() {
        return this.features;
    }

    @Override // org.fdroid.index.v2.PackageManifest
    public Integer getMaxSdkVersion() {
        return this.maxSdkVersion;
    }

    @Override // org.fdroid.index.v2.PackageManifest
    public List<String> getNativecode() {
        return this.nativecode;
    }

    public final SignerV2 getSigner() {
        return this.signer;
    }

    public final UsesSdkV2 getUsesSdk() {
        return this.usesSdk;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public int hashCode() {
        int hashCode = ((this.versionName.hashCode() * 31) + FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.versionCode)) * 31;
        UsesSdkV2 usesSdkV2 = this.usesSdk;
        int hashCode2 = (hashCode + (usesSdkV2 == null ? 0 : usesSdkV2.hashCode())) * 31;
        Integer num = this.maxSdkVersion;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        SignerV2 signerV2 = this.signer;
        int hashCode4 = (hashCode3 + (signerV2 == null ? 0 : signerV2.hashCode())) * 31;
        List<String> list = this.nativecode;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.features;
        return hashCode5 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        String str = this.versionName;
        long j = this.versionCode;
        UsesSdkV2 usesSdkV2 = this.usesSdk;
        Integer num = this.maxSdkVersion;
        SignerV2 signerV2 = this.signer;
        List<String> list = this.nativecode;
        List<String> list2 = this.features;
        return "AppManifest(versionName=" + str + ", versionCode=" + j + ", usesSdk=" + usesSdkV2 + ", maxSdkVersion=" + num + ", signer=" + signerV2 + ", nativecode=" + list + ", features=" + list2 + ")";
    }

    public AppManifest(String versionName, long j, UsesSdkV2 usesSdkV2, Integer num, SignerV2 signerV2, List<String> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        this.versionName = versionName;
        this.versionCode = j;
        this.usesSdk = usesSdkV2;
        this.maxSdkVersion = num;
        this.signer = signerV2;
        this.nativecode = list;
        this.features = list2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ AppManifest(java.lang.String r12, long r13, org.fdroid.index.v2.UsesSdkV2 r15, java.lang.Integer r16, org.fdroid.index.v2.SignerV2 r17, java.util.List r18, java.util.List r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r11 = this;
            r0 = r20 & 4
            r1 = 0
            if (r0 == 0) goto L7
            r6 = r1
            goto L8
        L7:
            r6 = r15
        L8:
            r0 = r20 & 8
            if (r0 == 0) goto Le
            r7 = r1
            goto L10
        Le:
            r7 = r16
        L10:
            r0 = r20 & 16
            if (r0 == 0) goto L16
            r8 = r1
            goto L18
        L16:
            r8 = r17
        L18:
            r0 = r20 & 32
            if (r0 == 0) goto L22
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r9 = r0
            goto L24
        L22:
            r9 = r18
        L24:
            r0 = r20 & 64
            if (r0 == 0) goto L2e
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r10 = r0
            goto L30
        L2e:
            r10 = r19
        L30:
            r2 = r11
            r3 = r12
            r4 = r13
            r2.<init>(r3, r4, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.database.AppManifest.<init>(java.lang.String, long, org.fdroid.index.v2.UsesSdkV2, java.lang.Integer, org.fdroid.index.v2.SignerV2, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // org.fdroid.index.v2.PackageManifest
    public Integer getMinSdkVersion() {
        UsesSdkV2 usesSdkV2 = this.usesSdk;
        if (usesSdkV2 != null) {
            return Integer.valueOf(usesSdkV2.getMinSdkVersion());
        }
        return null;
    }

    @Override // org.fdroid.index.v2.PackageManifest
    public Integer getTargetSdkVersion() {
        UsesSdkV2 usesSdkV2 = this.usesSdk;
        if (usesSdkV2 != null) {
            return Integer.valueOf(usesSdkV2.getTargetSdkVersion());
        }
        return null;
    }
}
