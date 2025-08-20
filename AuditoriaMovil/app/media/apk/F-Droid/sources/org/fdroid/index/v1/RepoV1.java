package org.fdroid.index.v1;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.fdroid.index.IndexConverterKt;
import org.fdroid.index.v2.AntiFeatureV2;
import org.fdroid.index.v2.CategoryV2;
import org.fdroid.index.v2.FileV2;
import org.fdroid.index.v2.MirrorV2;
import org.fdroid.index.v2.ReleaseChannelV2;
import org.fdroid.index.v2.RepoV2;
/* compiled from: IndexV1.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 E2\u00020\u0001:\u0002DEBm\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011BQ\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\u000eHÆ\u0003Jf\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001JL\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u00020\t2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000206052\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000208052\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020:05J\t\u0010;\u001a\u00020\tHÖ\u0001J&\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BHÁ\u0001¢\u0006\u0002\bCR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006F"}, d2 = {"Lorg/fdroid/index/v1/RepoV1;", "", "seen1", "", "timestamp", "", "version", "maxAge", "name", "", "icon", "address", "description", "mirrors", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(JILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAddress", "()Ljava/lang/String;", "getDescription", "getIcon", "getMaxAge$annotations", "()V", "getMaxAge", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMirrors", "()Ljava/util/List;", "getName", "getTimestamp", "()J", "getVersion", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lorg/fdroid/index/v1/RepoV1;", "equals", "", "other", "hashCode", "toRepoV2", "Lorg/fdroid/index/v2/RepoV2;", "locale", "antiFeatures", "", "Lorg/fdroid/index/v2/AntiFeatureV2;", "categories", "Lorg/fdroid/index/v2/CategoryV2;", "releaseChannels", "Lorg/fdroid/index/v2/ReleaseChannelV2;", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class RepoV1 {
    private final String address;
    private final String description;
    private final String icon;
    private final Integer maxAge;
    private final List<String> mirrors;
    private final String name;
    private final long timestamp;
    private final int version;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer[] $childSerializers = {null, null, null, null, null, null, null, new ArrayListSerializer(StringSerializer.INSTANCE)};

    public static /* synthetic */ void getMaxAge$annotations() {
    }

    public final long component1() {
        return this.timestamp;
    }

    public final int component2() {
        return this.version;
    }

    public final Integer component3() {
        return this.maxAge;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.icon;
    }

    public final String component6() {
        return this.address;
    }

    public final String component7() {
        return this.description;
    }

    public final List<String> component8() {
        return this.mirrors;
    }

    public final RepoV1 copy(long j, int i, Integer num, String name, String icon, String address, String description, List<String> mirrors) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(mirrors, "mirrors");
        return new RepoV1(j, i, num, name, icon, address, description, mirrors);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RepoV1) {
            RepoV1 repoV1 = (RepoV1) obj;
            return this.timestamp == repoV1.timestamp && this.version == repoV1.version && Intrinsics.areEqual(this.maxAge, repoV1.maxAge) && Intrinsics.areEqual(this.name, repoV1.name) && Intrinsics.areEqual(this.icon, repoV1.icon) && Intrinsics.areEqual(this.address, repoV1.address) && Intrinsics.areEqual(this.description, repoV1.description) && Intrinsics.areEqual(this.mirrors, repoV1.mirrors);
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final Integer getMaxAge() {
        return this.maxAge;
    }

    public final List<String> getMirrors() {
        return this.mirrors;
    }

    public final String getName() {
        return this.name;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int m = ((FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.timestamp) * 31) + this.version) * 31;
        Integer num = this.maxAge;
        return ((((((((((m + (num == null ? 0 : num.hashCode())) * 31) + this.name.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.address.hashCode()) * 31) + this.description.hashCode()) * 31) + this.mirrors.hashCode();
    }

    public String toString() {
        long j = this.timestamp;
        int i = this.version;
        Integer num = this.maxAge;
        String str = this.name;
        String str2 = this.icon;
        String str3 = this.address;
        String str4 = this.description;
        List<String> list = this.mirrors;
        return "RepoV1(timestamp=" + j + ", version=" + i + ", maxAge=" + num + ", name=" + str + ", icon=" + str2 + ", address=" + str3 + ", description=" + str4 + ", mirrors=" + list + ")";
    }

    /* compiled from: IndexV1.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lorg/fdroid/index/v1/RepoV1$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v1/RepoV1;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return RepoV1$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ RepoV1(int i, long j, int i2, Integer num, String str, String str2, String str3, String str4, List list, SerializationConstructorMarker serializationConstructorMarker) {
        List<String> emptyList;
        if (123 != (i & 123)) {
            PluginExceptionsKt.throwMissingFieldException(i, 123, RepoV1$$serializer.INSTANCE.getDescriptor());
        }
        this.timestamp = j;
        this.version = i2;
        if ((i & 4) == 0) {
            this.maxAge = null;
        } else {
            this.maxAge = num;
        }
        this.name = str;
        this.icon = str2;
        this.address = str3;
        this.description = str4;
        if ((i & 128) != 0) {
            this.mirrors = list;
            return;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mirrors = emptyList;
    }

    public RepoV1(long j, int i, Integer num, String name, String icon, String address, String description, List<String> mirrors) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(mirrors, "mirrors");
        this.timestamp = j;
        this.version = i;
        this.maxAge = num;
        this.name = name;
        this.icon = icon;
        this.address = address;
        this.description = description;
        this.mirrors = mirrors;
    }

    public static final /* synthetic */ void write$Self$index_release(RepoV1 repoV1, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        List emptyList;
        KSerializer[] kSerializerArr = $childSerializers;
        compositeEncoder.encodeLongElement(serialDescriptor, 0, repoV1.timestamp);
        compositeEncoder.encodeIntElement(serialDescriptor, 1, repoV1.version);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || repoV1.maxAge != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, repoV1.maxAge);
        }
        compositeEncoder.encodeStringElement(serialDescriptor, 3, repoV1.name);
        compositeEncoder.encodeStringElement(serialDescriptor, 4, repoV1.icon);
        compositeEncoder.encodeStringElement(serialDescriptor, 5, repoV1.address);
        compositeEncoder.encodeStringElement(serialDescriptor, 6, repoV1.description);
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7)) {
            List<String> list = repoV1.mirrors;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            if (Intrinsics.areEqual(list, emptyList)) {
                return;
            }
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 7, kSerializerArr[7], repoV1.mirrors);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ RepoV1(long r13, int r15, java.lang.Integer r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.util.List r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r12 = this;
            r0 = r22
            r1 = r0 & 4
            if (r1 == 0) goto L9
            r1 = 0
            r6 = r1
            goto Lb
        L9:
            r6 = r16
        Lb:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L15
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r11 = r0
            goto L17
        L15:
            r11 = r21
        L17:
            r2 = r12
            r3 = r13
            r5 = r15
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r2.<init>(r3, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.v1.RepoV1.<init>(long, int, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ RepoV2 toRepoV2$default(RepoV1 repoV1, String str, Map map, Map map2, Map map3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = IndexConverterKt.DEFAULT_LOCALE;
        }
        return repoV1.toRepoV2(str, map, map2, map3);
    }

    public final RepoV2 toRepoV2(String locale, Map<String, AntiFeatureV2> antiFeatures, Map<String, CategoryV2> categories, Map<String, ReleaseChannelV2> releaseChannels) {
        Map mapOf;
        Map mapOf2;
        Map mapOf3;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(antiFeatures, "antiFeatures");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(releaseChannels, "releaseChannels");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(locale, this.name));
        String str = this.icon;
        mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(locale, new FileV2("/icons/" + str, (String) null, (Long) null, (String) null, 14, (DefaultConstructorMarker) null)));
        String str2 = this.address;
        mapOf3 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(locale, this.description));
        List<String> list = this.mirrors;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String str3 : list) {
            arrayList.add(new MirrorV2(str3, (String) null, 2, (DefaultConstructorMarker) null));
        }
        return new RepoV2(mapOf, mapOf2, str2, null, mapOf3, arrayList, this.timestamp, antiFeatures, categories, releaseChannels);
    }
}
