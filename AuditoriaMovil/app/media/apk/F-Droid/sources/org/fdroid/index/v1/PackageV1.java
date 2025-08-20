package org.fdroid.index.v1;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.fdroid.index.v1.PermissionV1;
import org.fdroid.index.v2.FeatureV2;
import org.fdroid.index.v2.FileV1;
import org.fdroid.index.v2.FileV2;
import org.fdroid.index.v2.ManifestV2;
import org.fdroid.index.v2.PackageVersionV2;
import org.fdroid.index.v2.PermissionV2;
import org.fdroid.index.v2.SignerV2;
import org.fdroid.index.v2.UsesSdkV2;
/* compiled from: PackageV1.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 h2\u00020\u0001:\u0002ghBû\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0001\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\u0010\b\u0001\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0001\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\u001dBë\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013¢\u0006\u0002\u0010\u001eJ\u0010\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010?\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\t\u0010E\u001a\u00020\u0007HÆ\u0003J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013HÆ\u0003J\u0011\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013HÆ\u0003J\u0011\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013HÆ\u0003J\t\u0010I\u001a\u00020\u0007HÆ\u0003J\t\u0010J\u001a\u00020\u0007HÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010*J\t\u0010O\u001a\u00020\u0007HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0080\u0002\u0010Q\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00072\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00132\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00132\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010RJ\u0013\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020\u0003HÖ\u0001JT\u0010W\u001a\u00020X2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00070\u00132\"\u0010Z\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070[j\u0002`\\0[2\u001a\u0010]\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010[j\u0004\u0018\u0001`\\J\t\u0010^\u001a\u00020\u0007HÖ\u0001J&\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00002\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020eHÁ\u0001¢\u0006\u0002\bfR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0019\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010+\u001a\u0004\b,\u0010*R$\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010.\u001a\u0004\b/\u0010#R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010%R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010.\u001a\u0004\b6\u0010%R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010+\u001a\u0004\b7\u0010*R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010.\u001a\u0004\b9\u0010#R\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010.\u001a\u0004\b;\u0010#R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010!\u001a\u0004\b<\u0010 R\u0011\u0010\u0017\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b=\u0010%¨\u0006i"}, d2 = {"Lorg/fdroid/index/v1/PackageV1;", "", "seen1", "", "added", "", "apkName", "", "hash", "hashType", "minSdkVersion", "maxSdkVersion", "targetSdkVersion", "packageName", "sig", "signer", "size", "srcName", "usesPermission", "", "Lorg/fdroid/index/v1/PermissionV1;", "usesPermission23", "versionCode", "versionName", "nativeCode", "features", "antiFeatures", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAdded", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAntiFeatures", "()Ljava/util/List;", "getApkName", "()Ljava/lang/String;", "getFeatures", "getHash", "getHashType", "getMaxSdkVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMinSdkVersion", "getNativeCode$annotations", "()V", "getNativeCode", "getPackageName", "getSig", "getSigner", "getSize", "()J", "getSrcName$annotations", "getSrcName", "getTargetSdkVersion", "getUsesPermission$annotations", "getUsesPermission", "getUsesPermission23$annotations", "getUsesPermission23", "getVersionCode", "getVersionName", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lorg/fdroid/index/v1/PackageV1;", "equals", "", "other", "hashCode", "toPackageVersionV2", "Lorg/fdroid/index/v2/PackageVersionV2;", "releaseChannels", "appAntiFeatures", "", "Lorg/fdroid/index/v2/LocalizedTextV2;", "whatsNew", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class PackageV1 {
    private static final KSerializer[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final Long added;
    private final List<String> antiFeatures;
    private final String apkName;
    private final List<String> features;
    private final String hash;
    private final String hashType;
    private final Integer maxSdkVersion;
    private final Integer minSdkVersion;
    private final List<String> nativeCode;
    private final String packageName;
    private final String sig;
    private final String signer;
    private final long size;
    private final String srcName;
    private final Integer targetSdkVersion;
    private final List<PermissionV1> usesPermission;
    private final List<PermissionV1> usesPermission23;
    private final Long versionCode;
    private final String versionName;

    public static /* synthetic */ void getNativeCode$annotations() {
    }

    public static /* synthetic */ void getSrcName$annotations() {
    }

    public static /* synthetic */ void getUsesPermission$annotations() {
    }

    public static /* synthetic */ void getUsesPermission23$annotations() {
    }

    public final Long component1() {
        return this.added;
    }

    public final String component10() {
        return this.signer;
    }

    public final long component11() {
        return this.size;
    }

    public final String component12() {
        return this.srcName;
    }

    public final List<PermissionV1> component13() {
        return this.usesPermission;
    }

    public final List<PermissionV1> component14() {
        return this.usesPermission23;
    }

    public final Long component15() {
        return this.versionCode;
    }

    public final String component16() {
        return this.versionName;
    }

    public final List<String> component17() {
        return this.nativeCode;
    }

    public final List<String> component18() {
        return this.features;
    }

    public final List<String> component19() {
        return this.antiFeatures;
    }

    public final String component2() {
        return this.apkName;
    }

    public final String component3() {
        return this.hash;
    }

    public final String component4() {
        return this.hashType;
    }

    public final Integer component5() {
        return this.minSdkVersion;
    }

    public final Integer component6() {
        return this.maxSdkVersion;
    }

    public final Integer component7() {
        return this.targetSdkVersion;
    }

    public final String component8() {
        return this.packageName;
    }

    public final String component9() {
        return this.sig;
    }

    public final PackageV1 copy(Long l, String apkName, String hash, String hashType, Integer num, Integer num2, Integer num3, String packageName, String str, String str2, long j, String str3, List<PermissionV1> usesPermission, List<PermissionV1> usesPermission23, Long l2, String versionName, List<String> list, List<String> list2, List<String> list3) {
        Intrinsics.checkNotNullParameter(apkName, "apkName");
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(hashType, "hashType");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(usesPermission, "usesPermission");
        Intrinsics.checkNotNullParameter(usesPermission23, "usesPermission23");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        return new PackageV1(l, apkName, hash, hashType, num, num2, num3, packageName, str, str2, j, str3, usesPermission, usesPermission23, l2, versionName, list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PackageV1) {
            PackageV1 packageV1 = (PackageV1) obj;
            return Intrinsics.areEqual(this.added, packageV1.added) && Intrinsics.areEqual(this.apkName, packageV1.apkName) && Intrinsics.areEqual(this.hash, packageV1.hash) && Intrinsics.areEqual(this.hashType, packageV1.hashType) && Intrinsics.areEqual(this.minSdkVersion, packageV1.minSdkVersion) && Intrinsics.areEqual(this.maxSdkVersion, packageV1.maxSdkVersion) && Intrinsics.areEqual(this.targetSdkVersion, packageV1.targetSdkVersion) && Intrinsics.areEqual(this.packageName, packageV1.packageName) && Intrinsics.areEqual(this.sig, packageV1.sig) && Intrinsics.areEqual(this.signer, packageV1.signer) && this.size == packageV1.size && Intrinsics.areEqual(this.srcName, packageV1.srcName) && Intrinsics.areEqual(this.usesPermission, packageV1.usesPermission) && Intrinsics.areEqual(this.usesPermission23, packageV1.usesPermission23) && Intrinsics.areEqual(this.versionCode, packageV1.versionCode) && Intrinsics.areEqual(this.versionName, packageV1.versionName) && Intrinsics.areEqual(this.nativeCode, packageV1.nativeCode) && Intrinsics.areEqual(this.features, packageV1.features) && Intrinsics.areEqual(this.antiFeatures, packageV1.antiFeatures);
        }
        return false;
    }

    public final Long getAdded() {
        return this.added;
    }

    public final List<String> getAntiFeatures() {
        return this.antiFeatures;
    }

    public final String getApkName() {
        return this.apkName;
    }

    public final List<String> getFeatures() {
        return this.features;
    }

    public final String getHash() {
        return this.hash;
    }

    public final String getHashType() {
        return this.hashType;
    }

    public final Integer getMaxSdkVersion() {
        return this.maxSdkVersion;
    }

    public final Integer getMinSdkVersion() {
        return this.minSdkVersion;
    }

    public final List<String> getNativeCode() {
        return this.nativeCode;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getSig() {
        return this.sig;
    }

    public final String getSigner() {
        return this.signer;
    }

    public final long getSize() {
        return this.size;
    }

    public final String getSrcName() {
        return this.srcName;
    }

    public final Integer getTargetSdkVersion() {
        return this.targetSdkVersion;
    }

    public final List<PermissionV1> getUsesPermission() {
        return this.usesPermission;
    }

    public final List<PermissionV1> getUsesPermission23() {
        return this.usesPermission23;
    }

    public final Long getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public int hashCode() {
        Long l = this.added;
        int hashCode = (((((((l == null ? 0 : l.hashCode()) * 31) + this.apkName.hashCode()) * 31) + this.hash.hashCode()) * 31) + this.hashType.hashCode()) * 31;
        Integer num = this.minSdkVersion;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.maxSdkVersion;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.targetSdkVersion;
        int hashCode4 = (((hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31) + this.packageName.hashCode()) * 31;
        String str = this.sig;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.signer;
        int hashCode6 = (((hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31) + FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.size)) * 31;
        String str3 = this.srcName;
        int hashCode7 = (((((hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.usesPermission.hashCode()) * 31) + this.usesPermission23.hashCode()) * 31;
        Long l2 = this.versionCode;
        int hashCode8 = (((hashCode7 + (l2 == null ? 0 : l2.hashCode())) * 31) + this.versionName.hashCode()) * 31;
        List<String> list = this.nativeCode;
        int hashCode9 = (hashCode8 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.features;
        int hashCode10 = (hashCode9 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.antiFeatures;
        return hashCode10 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        Long l = this.added;
        String str = this.apkName;
        String str2 = this.hash;
        String str3 = this.hashType;
        Integer num = this.minSdkVersion;
        Integer num2 = this.maxSdkVersion;
        Integer num3 = this.targetSdkVersion;
        String str4 = this.packageName;
        String str5 = this.sig;
        String str6 = this.signer;
        long j = this.size;
        String str7 = this.srcName;
        List<PermissionV1> list = this.usesPermission;
        List<PermissionV1> list2 = this.usesPermission23;
        Long l2 = this.versionCode;
        String str8 = this.versionName;
        List<String> list3 = this.nativeCode;
        List<String> list4 = this.features;
        List<String> list5 = this.antiFeatures;
        return "PackageV1(added=" + l + ", apkName=" + str + ", hash=" + str2 + ", hashType=" + str3 + ", minSdkVersion=" + num + ", maxSdkVersion=" + num2 + ", targetSdkVersion=" + num3 + ", packageName=" + str4 + ", sig=" + str5 + ", signer=" + str6 + ", size=" + j + ", srcName=" + str7 + ", usesPermission=" + list + ", usesPermission23=" + list2 + ", versionCode=" + l2 + ", versionName=" + str8 + ", nativeCode=" + list3 + ", features=" + list4 + ", antiFeatures=" + list5 + ")";
    }

    /* compiled from: PackageV1.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lorg/fdroid/index/v1/PackageV1$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v1/PackageV1;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return PackageV1$$serializer.INSTANCE;
        }
    }

    static {
        PermissionV1.Companion companion = PermissionV1.Companion;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        $childSerializers = new KSerializer[]{null, null, null, null, null, null, null, null, null, null, null, null, new ArrayListSerializer(companion.serializer()), new ArrayListSerializer(companion.serializer()), null, null, new ArrayListSerializer(stringSerializer), new ArrayListSerializer(stringSerializer), new ArrayListSerializer(stringSerializer)};
    }

    public /* synthetic */ PackageV1(int i, Long l, String str, String str2, String str3, Integer num, Integer num2, Integer num3, String str4, String str5, String str6, long j, String str7, List list, List list2, Long l2, String str8, List list3, List list4, List list5, SerializationConstructorMarker serializationConstructorMarker) {
        if (33934 != (i & 33934)) {
            PluginExceptionsKt.throwMissingFieldException(i, 33934, PackageV1$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.added = null;
        } else {
            this.added = l;
        }
        this.apkName = str;
        this.hash = str2;
        this.hashType = str3;
        if ((i & 16) == 0) {
            this.minSdkVersion = null;
        } else {
            this.minSdkVersion = num;
        }
        if ((i & 32) == 0) {
            this.maxSdkVersion = null;
        } else {
            this.maxSdkVersion = num2;
        }
        this.targetSdkVersion = (i & 64) == 0 ? this.minSdkVersion : num3;
        this.packageName = str4;
        if ((i & 256) == 0) {
            this.sig = null;
        } else {
            this.sig = str5;
        }
        if ((i & 512) == 0) {
            this.signer = null;
        } else {
            this.signer = str6;
        }
        this.size = j;
        if ((i & 2048) == 0) {
            this.srcName = null;
        } else {
            this.srcName = str7;
        }
        this.usesPermission = (i & PKIFailureInfo.certConfirmed) == 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        this.usesPermission23 = (i & 8192) == 0 ? CollectionsKt__CollectionsKt.emptyList() : list2;
        if ((i & 16384) == 0) {
            this.versionCode = null;
        } else {
            this.versionCode = l2;
        }
        this.versionName = str8;
        if ((65536 & i) == 0) {
            this.nativeCode = null;
        } else {
            this.nativeCode = list3;
        }
        if ((131072 & i) == 0) {
            this.features = null;
        } else {
            this.features = list4;
        }
        if ((i & PKIFailureInfo.transactionIdInUse) == 0) {
            this.antiFeatures = null;
        } else {
            this.antiFeatures = list5;
        }
    }

    public PackageV1(Long l, String apkName, String hash, String hashType, Integer num, Integer num2, Integer num3, String packageName, String str, String str2, long j, String str3, List<PermissionV1> usesPermission, List<PermissionV1> usesPermission23, Long l2, String versionName, List<String> list, List<String> list2, List<String> list3) {
        Intrinsics.checkNotNullParameter(apkName, "apkName");
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(hashType, "hashType");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(usesPermission, "usesPermission");
        Intrinsics.checkNotNullParameter(usesPermission23, "usesPermission23");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        this.added = l;
        this.apkName = apkName;
        this.hash = hash;
        this.hashType = hashType;
        this.minSdkVersion = num;
        this.maxSdkVersion = num2;
        this.targetSdkVersion = num3;
        this.packageName = packageName;
        this.sig = str;
        this.signer = str2;
        this.size = j;
        this.srcName = str3;
        this.usesPermission = usesPermission;
        this.usesPermission23 = usesPermission23;
        this.versionCode = l2;
        this.versionName = versionName;
        this.nativeCode = list;
        this.features = list2;
        this.antiFeatures = list3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c2, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00de, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void write$Self$index_release(org.fdroid.index.v1.PackageV1 r4, kotlinx.serialization.encoding.CompositeEncoder r5, kotlinx.serialization.descriptors.SerialDescriptor r6) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.v1.PackageV1.write$Self$index_release(org.fdroid.index.v1.PackageV1, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ PackageV1(java.lang.Long r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.Integer r29, java.lang.Integer r30, java.lang.Integer r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, long r35, java.lang.String r37, java.util.List r38, java.util.List r39, java.lang.Long r40, java.lang.String r41, java.util.List r42, java.util.List r43, java.util.List r44, int r45, kotlin.jvm.internal.DefaultConstructorMarker r46) {
        /*
            r24 = this;
            r0 = r45
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L9
            r4 = r2
            goto Lb
        L9:
            r4 = r25
        Lb:
            r1 = r0 & 16
            if (r1 == 0) goto L11
            r8 = r2
            goto L13
        L11:
            r8 = r29
        L13:
            r1 = r0 & 32
            if (r1 == 0) goto L19
            r9 = r2
            goto L1b
        L19:
            r9 = r30
        L1b:
            r1 = r0 & 64
            if (r1 == 0) goto L21
            r10 = r8
            goto L23
        L21:
            r10 = r31
        L23:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L29
            r12 = r2
            goto L2b
        L29:
            r12 = r33
        L2b:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L31
            r13 = r2
            goto L33
        L31:
            r13 = r34
        L33:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L3a
            r16 = r2
            goto L3c
        L3a:
            r16 = r37
        L3c:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L47
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r17 = r1
            goto L49
        L47:
            r17 = r38
        L49:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L54
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r18 = r1
            goto L56
        L54:
            r18 = r39
        L56:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L5d
            r19 = r2
            goto L5f
        L5d:
            r19 = r40
        L5f:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L67
            r21 = r2
            goto L69
        L67:
            r21 = r42
        L69:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L71
            r22 = r2
            goto L73
        L71:
            r22 = r43
        L73:
            r1 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L7b
            r23 = r2
            goto L7d
        L7b:
            r23 = r44
        L7d:
            r3 = r24
            r5 = r26
            r6 = r27
            r7 = r28
            r11 = r32
            r14 = r35
            r20 = r41
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.v1.PackageV1.<init>(java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.String, java.util.List, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final PackageVersionV2 toPackageVersionV2(List<String> releaseChannels, Map<String, ? extends Map<String, String>> appAntiFeatures, Map<String, String> map) {
        UsesSdkV2 usesSdkV2;
        SignerV2 signerV2;
        int collectionSizeOrDefault;
        List<PermissionV1> list;
        int collectionSizeOrDefault2;
        FileV2 fileV2;
        List emptyList;
        ArrayList arrayList;
        Map emptyMap;
        Map plus;
        Map<String, String> map2;
        Map<String, String> emptyMap2;
        int collectionSizeOrDefault3;
        int mapCapacity;
        int coerceAtLeast;
        Map emptyMap3;
        int collectionSizeOrDefault4;
        List listOf;
        Intrinsics.checkNotNullParameter(releaseChannels, "releaseChannels");
        Intrinsics.checkNotNullParameter(appAntiFeatures, "appAntiFeatures");
        Long l = this.added;
        long longValue = l != null ? l.longValue() : 0L;
        String str = "/" + this.apkName;
        String str2 = this.hash;
        if (Intrinsics.areEqual(this.hashType, "sha256")) {
            Unit unit = Unit.INSTANCE;
            FileV1 fileV1 = new FileV1(str, str2, Long.valueOf(this.size), (String) null, 8, (DefaultConstructorMarker) null);
            String str3 = this.srcName;
            FileV2 fileV22 = str3 != null ? new FileV2("/" + str3, (String) null, (Long) null, (String) null, 14, (DefaultConstructorMarker) null) : null;
            String str4 = this.versionName;
            Long l2 = this.versionCode;
            long longValue2 = l2 != null ? l2.longValue() : 1L;
            if (this.minSdkVersion == null && this.targetSdkVersion == null) {
                usesSdkV2 = null;
            } else {
                Integer num = this.minSdkVersion;
                int intValue = num != null ? num.intValue() : 1;
                Integer num2 = this.targetSdkVersion;
                usesSdkV2 = new UsesSdkV2(intValue, (num2 == null && (num2 = this.minSdkVersion) == null) ? 1 : num2.intValue());
            }
            Integer num3 = this.maxSdkVersion;
            String str5 = this.signer;
            if (str5 != null) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(str5);
                signerV2 = new SignerV2(listOf, false, 2, (DefaultConstructorMarker) null);
            } else {
                signerV2 = null;
            }
            List<PermissionV1> list2 = this.usesPermission;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (PermissionV1 permissionV1 : list2) {
                arrayList2.add(new PermissionV2(permissionV1.getName(), permissionV1.getMaxSdk()));
            }
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(this.usesPermission23, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
            for (Iterator it = list.iterator(); it.hasNext(); it = it) {
                PermissionV1 permissionV12 = (PermissionV1) it.next();
                arrayList3.add(new PermissionV2(permissionV12.getName(), permissionV12.getMaxSdk()));
            }
            List<String> list3 = this.nativeCode;
            if (list3 == null) {
                list3 = CollectionsKt__CollectionsKt.emptyList();
            }
            List<String> list4 = list3;
            List<String> list5 = this.features;
            if (list5 != null) {
                fileV2 = fileV22;
                collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10);
                ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault4);
                for (String str6 : list5) {
                    arrayList4.add(new FeatureV2(str6));
                }
                arrayList = arrayList4;
            } else {
                fileV2 = fileV22;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                arrayList = emptyList;
            }
            ManifestV2 manifestV2 = new ManifestV2(str4, longValue2, usesSdkV2, num3, signerV2, arrayList2, arrayList3, list4, arrayList);
            List<String> list6 = this.antiFeatures;
            if (list6 != null) {
                collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault3);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                emptyMap = new LinkedHashMap(coerceAtLeast);
                for (String str7 : list6) {
                    emptyMap3 = MapsKt__MapsKt.emptyMap();
                    Pair pair = TuplesKt.to(str7, emptyMap3);
                    emptyMap.put(pair.getFirst(), pair.getSecond());
                }
            } else {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
            plus = MapsKt__MapsKt.plus(appAntiFeatures, emptyMap);
            if (map == null) {
                emptyMap2 = MapsKt__MapsKt.emptyMap();
                map2 = emptyMap2;
            } else {
                map2 = map;
            }
            return new PackageVersionV2(longValue, fileV1, fileV2, manifestV2, releaseChannels, plus, map2);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
