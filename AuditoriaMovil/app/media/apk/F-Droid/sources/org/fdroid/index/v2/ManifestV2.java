package org.fdroid.index.v2;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: PackageV2.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 H2\u00020\u0001:\u0002GHB\u00ad\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000e\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019By\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e¢\u0006\u0002\u0010\u001aJ\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00102\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eHÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eHÆ\u0003J\u0086\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eHÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020\u0003HÖ\u0001J\t\u0010>\u001a\u00020\u0005HÖ\u0001J&\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EHÁ\u0001¢\u0006\u0002\bFR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0018\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b%\u0010\u001fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006I"}, d2 = {"Lorg/fdroid/index/v2/ManifestV2;", "Lorg/fdroid/index/v2/PackageManifest;", "seen1", "", "versionName", "", "versionCode", "", "usesSdk", "Lorg/fdroid/index/v2/UsesSdkV2;", "maxSdkVersion", "signer", "Lorg/fdroid/index/v2/SignerV2;", "usesPermission", "", "Lorg/fdroid/index/v2/PermissionV2;", "usesPermissionSdk23", "nativecode", "features", "Lorg/fdroid/index/v2/FeatureV2;", "minSdkVersion", "featureNames", "targetSdkVersion", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JLorg/fdroid/index/v2/UsesSdkV2;Ljava/lang/Integer;Lorg/fdroid/index/v2/SignerV2;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;JLorg/fdroid/index/v2/UsesSdkV2;Ljava/lang/Integer;Lorg/fdroid/index/v2/SignerV2;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getFeatureNames", "()Ljava/util/List;", "getFeatures", "getMaxSdkVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMinSdkVersion", "getNativecode", "getSigner", "()Lorg/fdroid/index/v2/SignerV2;", "getTargetSdkVersion", "getUsesPermission", "getUsesPermissionSdk23", "getUsesSdk", "()Lorg/fdroid/index/v2/UsesSdkV2;", "getVersionCode", "()J", "getVersionName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;JLorg/fdroid/index/v2/UsesSdkV2;Ljava/lang/Integer;Lorg/fdroid/index/v2/SignerV2;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lorg/fdroid/index/v2/ManifestV2;", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class ManifestV2 implements PackageManifest {
    private static final KSerializer[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final List<String> featureNames;
    private final List<FeatureV2> features;
    private final Integer maxSdkVersion;
    private final Integer minSdkVersion;
    private final List<String> nativecode;
    private final SignerV2 signer;
    private final Integer targetSdkVersion;
    private final List<PermissionV2> usesPermission;
    private final List<PermissionV2> usesPermissionSdk23;
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

    public final List<PermissionV2> component6() {
        return this.usesPermission;
    }

    public final List<PermissionV2> component7() {
        return this.usesPermissionSdk23;
    }

    public final List<String> component8() {
        return this.nativecode;
    }

    public final List<FeatureV2> component9() {
        return this.features;
    }

    public final ManifestV2 copy(String versionName, long j, UsesSdkV2 usesSdkV2, Integer num, SignerV2 signerV2, List<PermissionV2> usesPermission, List<PermissionV2> usesPermissionSdk23, List<String> nativecode, List<FeatureV2> features) {
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(usesPermission, "usesPermission");
        Intrinsics.checkNotNullParameter(usesPermissionSdk23, "usesPermissionSdk23");
        Intrinsics.checkNotNullParameter(nativecode, "nativecode");
        Intrinsics.checkNotNullParameter(features, "features");
        return new ManifestV2(versionName, j, usesSdkV2, num, signerV2, usesPermission, usesPermissionSdk23, nativecode, features);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ManifestV2) {
            ManifestV2 manifestV2 = (ManifestV2) obj;
            return Intrinsics.areEqual(this.versionName, manifestV2.versionName) && this.versionCode == manifestV2.versionCode && Intrinsics.areEqual(this.usesSdk, manifestV2.usesSdk) && Intrinsics.areEqual(this.maxSdkVersion, manifestV2.maxSdkVersion) && Intrinsics.areEqual(this.signer, manifestV2.signer) && Intrinsics.areEqual(this.usesPermission, manifestV2.usesPermission) && Intrinsics.areEqual(this.usesPermissionSdk23, manifestV2.usesPermissionSdk23) && Intrinsics.areEqual(this.nativecode, manifestV2.nativecode) && Intrinsics.areEqual(this.features, manifestV2.features);
        }
        return false;
    }

    @Override // org.fdroid.index.v2.PackageManifest
    public List<String> getFeatureNames() {
        return this.featureNames;
    }

    public final List<FeatureV2> getFeatures() {
        return this.features;
    }

    @Override // org.fdroid.index.v2.PackageManifest
    public Integer getMaxSdkVersion() {
        return this.maxSdkVersion;
    }

    @Override // org.fdroid.index.v2.PackageManifest
    public Integer getMinSdkVersion() {
        return this.minSdkVersion;
    }

    @Override // org.fdroid.index.v2.PackageManifest
    public List<String> getNativecode() {
        return this.nativecode;
    }

    public final SignerV2 getSigner() {
        return this.signer;
    }

    @Override // org.fdroid.index.v2.PackageManifest
    public Integer getTargetSdkVersion() {
        return this.targetSdkVersion;
    }

    public final List<PermissionV2> getUsesPermission() {
        return this.usesPermission;
    }

    public final List<PermissionV2> getUsesPermissionSdk23() {
        return this.usesPermissionSdk23;
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
        return ((((((((hashCode3 + (signerV2 != null ? signerV2.hashCode() : 0)) * 31) + this.usesPermission.hashCode()) * 31) + this.usesPermissionSdk23.hashCode()) * 31) + this.nativecode.hashCode()) * 31) + this.features.hashCode();
    }

    public String toString() {
        String str = this.versionName;
        long j = this.versionCode;
        UsesSdkV2 usesSdkV2 = this.usesSdk;
        Integer num = this.maxSdkVersion;
        SignerV2 signerV2 = this.signer;
        List<PermissionV2> list = this.usesPermission;
        List<PermissionV2> list2 = this.usesPermissionSdk23;
        List<String> list3 = this.nativecode;
        List<FeatureV2> list4 = this.features;
        return "ManifestV2(versionName=" + str + ", versionCode=" + j + ", usesSdk=" + usesSdkV2 + ", maxSdkVersion=" + num + ", signer=" + signerV2 + ", usesPermission=" + list + ", usesPermissionSdk23=" + list2 + ", nativecode=" + list3 + ", features=" + list4 + ")";
    }

    /* compiled from: PackageV2.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lorg/fdroid/index/v2/ManifestV2$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v2/ManifestV2;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return ManifestV2$$serializer.INSTANCE;
        }
    }

    static {
        PermissionV2$$serializer permissionV2$$serializer = PermissionV2$$serializer.INSTANCE;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        $childSerializers = new KSerializer[]{null, null, null, null, null, new ArrayListSerializer(permissionV2$$serializer), new ArrayListSerializer(permissionV2$$serializer), new ArrayListSerializer(stringSerializer), new ArrayListSerializer(FeatureV2$$serializer.INSTANCE), null, new ArrayListSerializer(stringSerializer), null};
    }

    public /* synthetic */ ManifestV2(int i, String str, long j, UsesSdkV2 usesSdkV2, Integer num, SignerV2 signerV2, List list, List list2, List list3, List list4, Integer num2, List list5, Integer num3, SerializationConstructorMarker serializationConstructorMarker) {
        Integer num4;
        int collectionSizeOrDefault;
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, ManifestV2$$serializer.INSTANCE.getDescriptor());
        }
        this.versionName = str;
        this.versionCode = j;
        if ((i & 4) == 0) {
            this.usesSdk = null;
        } else {
            this.usesSdk = usesSdkV2;
        }
        if ((i & 8) == 0) {
            this.maxSdkVersion = null;
        } else {
            this.maxSdkVersion = num;
        }
        if ((i & 16) == 0) {
            this.signer = null;
        } else {
            this.signer = signerV2;
        }
        this.usesPermission = (i & 32) == 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        this.usesPermissionSdk23 = (i & 64) == 0 ? CollectionsKt__CollectionsKt.emptyList() : list2;
        this.nativecode = (i & 128) == 0 ? CollectionsKt__CollectionsKt.emptyList() : list3;
        this.features = (i & 256) == 0 ? CollectionsKt__CollectionsKt.emptyList() : list4;
        if ((i & 512) == 0) {
            UsesSdkV2 usesSdkV22 = this.usesSdk;
            num4 = usesSdkV22 != null ? Integer.valueOf(usesSdkV22.getMinSdkVersion()) : null;
        } else {
            num4 = num2;
        }
        this.minSdkVersion = num4;
        if ((i & 1024) == 0) {
            List<FeatureV2> list6 = this.features;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (FeatureV2 featureV2 : list6) {
                arrayList.add(featureV2.getName());
            }
            this.featureNames = arrayList;
        } else {
            this.featureNames = list5;
        }
        if ((i & 2048) != 0) {
            this.targetSdkVersion = num3;
            return;
        }
        UsesSdkV2 usesSdkV23 = this.usesSdk;
        this.targetSdkVersion = usesSdkV23 != null ? Integer.valueOf(usesSdkV23.getTargetSdkVersion()) : null;
    }

    public ManifestV2(String versionName, long j, UsesSdkV2 usesSdkV2, Integer num, SignerV2 signerV2, List<PermissionV2> usesPermission, List<PermissionV2> usesPermissionSdk23, List<String> nativecode, List<FeatureV2> features) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(usesPermission, "usesPermission");
        Intrinsics.checkNotNullParameter(usesPermissionSdk23, "usesPermissionSdk23");
        Intrinsics.checkNotNullParameter(nativecode, "nativecode");
        Intrinsics.checkNotNullParameter(features, "features");
        this.versionName = versionName;
        this.versionCode = j;
        this.usesSdk = usesSdkV2;
        this.maxSdkVersion = num;
        this.signer = signerV2;
        this.usesPermission = usesPermission;
        this.usesPermissionSdk23 = usesPermissionSdk23;
        this.nativecode = nativecode;
        this.features = features;
        this.minSdkVersion = usesSdkV2 != null ? Integer.valueOf(usesSdkV2.getMinSdkVersion()) : null;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(features, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (FeatureV2 featureV2 : features) {
            arrayList.add(featureV2.getName());
        }
        this.featureNames = arrayList;
        UsesSdkV2 usesSdkV22 = this.usesSdk;
        this.targetSdkVersion = usesSdkV22 != null ? Integer.valueOf(usesSdkV22.getTargetSdkVersion()) : null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0095, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b3, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00dc, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r4 != null ? java.lang.Integer.valueOf(r4.getMinSdkVersion()) : null) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x011b, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r5) == false) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void write$Self$index_release(org.fdroid.index.v2.ManifestV2 r7, kotlinx.serialization.encoding.CompositeEncoder r8, kotlinx.serialization.descriptors.SerialDescriptor r9) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.v2.ManifestV2.write$Self$index_release(org.fdroid.index.v2.ManifestV2, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ ManifestV2(java.lang.String r15, long r16, org.fdroid.index.v2.UsesSdkV2 r18, java.lang.Integer r19, org.fdroid.index.v2.SignerV2 r20, java.util.List r21, java.util.List r22, java.util.List r23, java.util.List r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r14 = this;
            r0 = r25
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L9
            r7 = r2
            goto Lb
        L9:
            r7 = r18
        Lb:
            r1 = r0 & 8
            if (r1 == 0) goto L11
            r8 = r2
            goto L13
        L11:
            r8 = r19
        L13:
            r1 = r0 & 16
            if (r1 == 0) goto L19
            r9 = r2
            goto L1b
        L19:
            r9 = r20
        L1b:
            r1 = r0 & 32
            if (r1 == 0) goto L25
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r10 = r1
            goto L27
        L25:
            r10 = r21
        L27:
            r1 = r0 & 64
            if (r1 == 0) goto L31
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r11 = r1
            goto L33
        L31:
            r11 = r22
        L33:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L3d
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r12 = r1
            goto L3f
        L3d:
            r12 = r23
        L3f:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L49
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r13 = r0
            goto L4b
        L49:
            r13 = r24
        L4b:
            r3 = r14
            r4 = r15
            r5 = r16
            r3.<init>(r4, r5, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.v2.ManifestV2.<init>(java.lang.String, long, org.fdroid.index.v2.UsesSdkV2, java.lang.Integer, org.fdroid.index.v2.SignerV2, java.util.List, java.util.List, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
