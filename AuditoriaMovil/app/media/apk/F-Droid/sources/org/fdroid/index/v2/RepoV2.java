package org.fdroid.index.v2;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: IndexV2.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0002FGBÛ\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0005\u0012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0005\u0012\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001bBÁ\u0001\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005j\u0002`\n\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0005\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0005\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00180\u0005¢\u0006\u0002\u0010\u001cJ\u0019\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007HÆ\u0003J\u0015\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00180\u0005HÆ\u0003J\u0019\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005j\u0002`\nHÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0019\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007HÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\t\u00102\u001a\u00020\u0012HÆ\u0003J\u0015\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0005HÆ\u0003J\u0015\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0005HÆ\u0003JÉ\u0001\u00105\u001a\u00020\u00002\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005j\u0002`\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u00072\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u00052\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u00052\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00180\u0005HÆ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0003HÖ\u0001J\t\u0010:\u001a\u00020\u0006HÖ\u0001J\u001c\u0010;\u001a\u00020<2\u0014\u0010=\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020<0>J&\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DHÁ\u0001¢\u0006\u0002\bER\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005j\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00180\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001e¨\u0006H"}, d2 = {"Lorg/fdroid/index/v2/RepoV2;", "", "seen1", "", "name", "", "", "Lorg/fdroid/index/v2/LocalizedTextV2;", "icon", "Lorg/fdroid/index/v2/FileV2;", "Lorg/fdroid/index/v2/LocalizedFileV2;", "address", "webBaseUrl", "description", "mirrors", "", "Lorg/fdroid/index/v2/MirrorV2;", "timestamp", "", "antiFeatures", "Lorg/fdroid/index/v2/AntiFeatureV2;", "categories", "Lorg/fdroid/index/v2/CategoryV2;", "releaseChannels", "Lorg/fdroid/index/v2/ReleaseChannelV2;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;JLjava/util/Map;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;JLjava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getAddress", "()Ljava/lang/String;", "getAntiFeatures", "()Ljava/util/Map;", "getCategories", "getDescription", "getIcon", "getMirrors", "()Ljava/util/List;", "getName", "getReleaseChannels", "getTimestamp", "()J", "getWebBaseUrl", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "walkFiles", "", "fileConsumer", "Lkotlin/Function1;", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class RepoV2 {
    private static final KSerializer[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final String address;
    private final Map<String, AntiFeatureV2> antiFeatures;
    private final Map<String, CategoryV2> categories;
    private final Map<String, String> description;
    private final Map<String, FileV2> icon;
    private final List<MirrorV2> mirrors;
    private final Map<String, String> name;
    private final Map<String, ReleaseChannelV2> releaseChannels;
    private final long timestamp;
    private final String webBaseUrl;

    public final Map<String, String> component1() {
        return this.name;
    }

    public final Map<String, ReleaseChannelV2> component10() {
        return this.releaseChannels;
    }

    public final Map<String, FileV2> component2() {
        return this.icon;
    }

    public final String component3() {
        return this.address;
    }

    public final String component4() {
        return this.webBaseUrl;
    }

    public final Map<String, String> component5() {
        return this.description;
    }

    public final List<MirrorV2> component6() {
        return this.mirrors;
    }

    public final long component7() {
        return this.timestamp;
    }

    public final Map<String, AntiFeatureV2> component8() {
        return this.antiFeatures;
    }

    public final Map<String, CategoryV2> component9() {
        return this.categories;
    }

    public final RepoV2 copy(Map<String, String> name, Map<String, FileV2> icon, String address, String str, Map<String, String> description, List<MirrorV2> mirrors, long j, Map<String, AntiFeatureV2> antiFeatures, Map<String, CategoryV2> categories, Map<String, ReleaseChannelV2> releaseChannels) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(mirrors, "mirrors");
        Intrinsics.checkNotNullParameter(antiFeatures, "antiFeatures");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(releaseChannels, "releaseChannels");
        return new RepoV2(name, icon, address, str, description, mirrors, j, antiFeatures, categories, releaseChannels);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RepoV2) {
            RepoV2 repoV2 = (RepoV2) obj;
            return Intrinsics.areEqual(this.name, repoV2.name) && Intrinsics.areEqual(this.icon, repoV2.icon) && Intrinsics.areEqual(this.address, repoV2.address) && Intrinsics.areEqual(this.webBaseUrl, repoV2.webBaseUrl) && Intrinsics.areEqual(this.description, repoV2.description) && Intrinsics.areEqual(this.mirrors, repoV2.mirrors) && this.timestamp == repoV2.timestamp && Intrinsics.areEqual(this.antiFeatures, repoV2.antiFeatures) && Intrinsics.areEqual(this.categories, repoV2.categories) && Intrinsics.areEqual(this.releaseChannels, repoV2.releaseChannels);
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final Map<String, AntiFeatureV2> getAntiFeatures() {
        return this.antiFeatures;
    }

    public final Map<String, CategoryV2> getCategories() {
        return this.categories;
    }

    public final Map<String, String> getDescription() {
        return this.description;
    }

    public final Map<String, FileV2> getIcon() {
        return this.icon;
    }

    public final List<MirrorV2> getMirrors() {
        return this.mirrors;
    }

    public final Map<String, String> getName() {
        return this.name;
    }

    public final Map<String, ReleaseChannelV2> getReleaseChannels() {
        return this.releaseChannels;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getWebBaseUrl() {
        return this.webBaseUrl;
    }

    public int hashCode() {
        int hashCode = ((((this.name.hashCode() * 31) + this.icon.hashCode()) * 31) + this.address.hashCode()) * 31;
        String str = this.webBaseUrl;
        return ((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.description.hashCode()) * 31) + this.mirrors.hashCode()) * 31) + FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.timestamp)) * 31) + this.antiFeatures.hashCode()) * 31) + this.categories.hashCode()) * 31) + this.releaseChannels.hashCode();
    }

    public String toString() {
        Map<String, String> map = this.name;
        Map<String, FileV2> map2 = this.icon;
        String str = this.address;
        String str2 = this.webBaseUrl;
        Map<String, String> map3 = this.description;
        List<MirrorV2> list = this.mirrors;
        long j = this.timestamp;
        Map<String, AntiFeatureV2> map4 = this.antiFeatures;
        Map<String, CategoryV2> map5 = this.categories;
        Map<String, ReleaseChannelV2> map6 = this.releaseChannels;
        return "RepoV2(name=" + map + ", icon=" + map2 + ", address=" + str + ", webBaseUrl=" + str2 + ", description=" + map3 + ", mirrors=" + list + ", timestamp=" + j + ", antiFeatures=" + map4 + ", categories=" + map5 + ", releaseChannels=" + map6 + ")";
    }

    /* compiled from: IndexV2.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lorg/fdroid/index/v2/RepoV2$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v2/RepoV2;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return RepoV2$$serializer.INSTANCE;
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        $childSerializers = new KSerializer[]{new LinkedHashMapSerializer(stringSerializer, stringSerializer), new LinkedHashMapSerializer(stringSerializer, FileV2$$serializer.INSTANCE), null, null, new LinkedHashMapSerializer(stringSerializer, stringSerializer), new ArrayListSerializer(MirrorV2$$serializer.INSTANCE), null, new LinkedHashMapSerializer(stringSerializer, AntiFeatureV2$$serializer.INSTANCE), new LinkedHashMapSerializer(stringSerializer, CategoryV2$$serializer.INSTANCE), new LinkedHashMapSerializer(stringSerializer, ReleaseChannelV2$$serializer.INSTANCE)};
    }

    public /* synthetic */ RepoV2(int i, Map map, Map map2, String str, String str2, Map map3, List list, long j, Map map4, Map map5, Map map6, SerializationConstructorMarker serializationConstructorMarker) {
        Map<String, ReleaseChannelV2> emptyMap;
        Map<String, CategoryV2> emptyMap2;
        Map<String, AntiFeatureV2> emptyMap3;
        List<MirrorV2> emptyList;
        Map<String, String> emptyMap4;
        Map<String, FileV2> emptyMap5;
        if (68 != (i & 68)) {
            PluginExceptionsKt.throwMissingFieldException(i, 68, RepoV2$$serializer.INSTANCE.getDescriptor());
        }
        this.name = (i & 1) == 0 ? MapsKt__MapsKt.emptyMap() : map;
        if ((i & 2) == 0) {
            emptyMap5 = MapsKt__MapsKt.emptyMap();
            this.icon = emptyMap5;
        } else {
            this.icon = map2;
        }
        this.address = str;
        if ((i & 8) == 0) {
            this.webBaseUrl = null;
        } else {
            this.webBaseUrl = str2;
        }
        if ((i & 16) == 0) {
            emptyMap4 = MapsKt__MapsKt.emptyMap();
            this.description = emptyMap4;
        } else {
            this.description = map3;
        }
        if ((i & 32) == 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.mirrors = emptyList;
        } else {
            this.mirrors = list;
        }
        this.timestamp = j;
        if ((i & 128) == 0) {
            emptyMap3 = MapsKt__MapsKt.emptyMap();
            this.antiFeatures = emptyMap3;
        } else {
            this.antiFeatures = map4;
        }
        if ((i & 256) == 0) {
            emptyMap2 = MapsKt__MapsKt.emptyMap();
            this.categories = emptyMap2;
        } else {
            this.categories = map5;
        }
        if ((i & 512) != 0) {
            this.releaseChannels = map6;
            return;
        }
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.releaseChannels = emptyMap;
    }

    public RepoV2(Map<String, String> name, Map<String, FileV2> icon, String address, String str, Map<String, String> description, List<MirrorV2> mirrors, long j, Map<String, AntiFeatureV2> antiFeatures, Map<String, CategoryV2> categories, Map<String, ReleaseChannelV2> releaseChannels) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(mirrors, "mirrors");
        Intrinsics.checkNotNullParameter(antiFeatures, "antiFeatures");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(releaseChannels, "releaseChannels");
        this.name = name;
        this.icon = icon;
        this.address = address;
        this.webBaseUrl = str;
        this.description = description;
        this.mirrors = mirrors;
        this.timestamp = j;
        this.antiFeatures = antiFeatures;
        this.categories = categories;
        this.releaseChannels = releaseChannels;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007e, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009f, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bb, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void write$Self$index_release(org.fdroid.index.v2.RepoV2 r4, kotlinx.serialization.encoding.CompositeEncoder r5, kotlinx.serialization.descriptors.SerialDescriptor r6) {
        /*
            kotlinx.serialization.KSerializer[] r0 = org.fdroid.index.v2.RepoV2.$childSerializers
            r1 = 0
            boolean r2 = r5.shouldEncodeElementDefault(r6, r1)
            if (r2 == 0) goto La
            goto L16
        La:
            java.util.Map<java.lang.String, java.lang.String> r2 = r4.name
            java.util.Map r3 = kotlin.collections.MapsKt.emptyMap()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto L1d
        L16:
            r2 = r0[r1]
            java.util.Map<java.lang.String, java.lang.String> r3 = r4.name
            r5.encodeSerializableElement(r6, r1, r2, r3)
        L1d:
            r1 = 1
            boolean r2 = r5.shouldEncodeElementDefault(r6, r1)
            if (r2 == 0) goto L25
            goto L31
        L25:
            java.util.Map<java.lang.String, org.fdroid.index.v2.FileV2> r2 = r4.icon
            java.util.Map r3 = kotlin.collections.MapsKt.emptyMap()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto L38
        L31:
            r2 = r0[r1]
            java.util.Map<java.lang.String, org.fdroid.index.v2.FileV2> r3 = r4.icon
            r5.encodeSerializableElement(r6, r1, r2, r3)
        L38:
            java.lang.String r1 = r4.address
            r2 = 2
            r5.encodeStringElement(r6, r2, r1)
            r1 = 3
            boolean r2 = r5.shouldEncodeElementDefault(r6, r1)
            if (r2 == 0) goto L46
            goto L4a
        L46:
            java.lang.String r2 = r4.webBaseUrl
            if (r2 == 0) goto L51
        L4a:
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.String r3 = r4.webBaseUrl
            r5.encodeNullableSerializableElement(r6, r1, r2, r3)
        L51:
            r1 = 4
            boolean r2 = r5.shouldEncodeElementDefault(r6, r1)
            if (r2 == 0) goto L59
            goto L65
        L59:
            java.util.Map<java.lang.String, java.lang.String> r2 = r4.description
            java.util.Map r3 = kotlin.collections.MapsKt.emptyMap()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto L6c
        L65:
            r2 = r0[r1]
            java.util.Map<java.lang.String, java.lang.String> r3 = r4.description
            r5.encodeSerializableElement(r6, r1, r2, r3)
        L6c:
            r1 = 5
            boolean r2 = r5.shouldEncodeElementDefault(r6, r1)
            if (r2 == 0) goto L74
            goto L80
        L74:
            java.util.List<org.fdroid.index.v2.MirrorV2> r2 = r4.mirrors
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto L87
        L80:
            r2 = r0[r1]
            java.util.List<org.fdroid.index.v2.MirrorV2> r3 = r4.mirrors
            r5.encodeSerializableElement(r6, r1, r2, r3)
        L87:
            r1 = 6
            long r2 = r4.timestamp
            r5.encodeLongElement(r6, r1, r2)
            r1 = 7
            boolean r2 = r5.shouldEncodeElementDefault(r6, r1)
            if (r2 == 0) goto L95
            goto La1
        L95:
            java.util.Map<java.lang.String, org.fdroid.index.v2.AntiFeatureV2> r2 = r4.antiFeatures
            java.util.Map r3 = kotlin.collections.MapsKt.emptyMap()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto La8
        La1:
            r2 = r0[r1]
            java.util.Map<java.lang.String, org.fdroid.index.v2.AntiFeatureV2> r3 = r4.antiFeatures
            r5.encodeSerializableElement(r6, r1, r2, r3)
        La8:
            r1 = 8
            boolean r2 = r5.shouldEncodeElementDefault(r6, r1)
            if (r2 == 0) goto Lb1
            goto Lbd
        Lb1:
            java.util.Map<java.lang.String, org.fdroid.index.v2.CategoryV2> r2 = r4.categories
            java.util.Map r3 = kotlin.collections.MapsKt.emptyMap()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto Lc4
        Lbd:
            r2 = r0[r1]
            java.util.Map<java.lang.String, org.fdroid.index.v2.CategoryV2> r3 = r4.categories
            r5.encodeSerializableElement(r6, r1, r2, r3)
        Lc4:
            r1 = 9
            boolean r2 = r5.shouldEncodeElementDefault(r6, r1)
            if (r2 == 0) goto Lcd
            goto Ld9
        Lcd:
            java.util.Map<java.lang.String, org.fdroid.index.v2.ReleaseChannelV2> r2 = r4.releaseChannels
            java.util.Map r3 = kotlin.collections.MapsKt.emptyMap()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto Le0
        Ld9:
            r0 = r0[r1]
            java.util.Map<java.lang.String, org.fdroid.index.v2.ReleaseChannelV2> r4 = r4.releaseChannels
            r5.encodeSerializableElement(r6, r1, r0, r4)
        Le0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.v2.RepoV2.write$Self$index_release(org.fdroid.index.v2.RepoV2, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ RepoV2(java.util.Map r15, java.util.Map r16, java.lang.String r17, java.lang.String r18, java.util.Map r19, java.util.List r20, long r21, java.util.Map r23, java.util.Map r24, java.util.Map r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r14 = this;
            r0 = r26
            r1 = r0 & 1
            if (r1 == 0) goto Lc
            java.util.Map r1 = kotlin.collections.MapsKt.emptyMap()
            r3 = r1
            goto Ld
        Lc:
            r3 = r15
        Ld:
            r1 = r0 & 2
            if (r1 == 0) goto L17
            java.util.Map r1 = kotlin.collections.MapsKt.emptyMap()
            r4 = r1
            goto L19
        L17:
            r4 = r16
        L19:
            r1 = r0 & 8
            if (r1 == 0) goto L20
            r1 = 0
            r6 = r1
            goto L22
        L20:
            r6 = r18
        L22:
            r1 = r0 & 16
            if (r1 == 0) goto L2c
            java.util.Map r1 = kotlin.collections.MapsKt.emptyMap()
            r7 = r1
            goto L2e
        L2c:
            r7 = r19
        L2e:
            r1 = r0 & 32
            if (r1 == 0) goto L38
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r8 = r1
            goto L3a
        L38:
            r8 = r20
        L3a:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L44
            java.util.Map r1 = kotlin.collections.MapsKt.emptyMap()
            r11 = r1
            goto L46
        L44:
            r11 = r23
        L46:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L50
            java.util.Map r1 = kotlin.collections.MapsKt.emptyMap()
            r12 = r1
            goto L52
        L50:
            r12 = r24
        L52:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L5c
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            r13 = r0
            goto L5e
        L5c:
            r13 = r25
        L5e:
            r2 = r14
            r5 = r17
            r9 = r21
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.v2.RepoV2.<init>(java.util.Map, java.util.Map, java.lang.String, java.lang.String, java.util.Map, java.util.List, long, java.util.Map, java.util.Map, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final void walkFiles(Function1 fileConsumer) {
        Intrinsics.checkNotNullParameter(fileConsumer, "fileConsumer");
        for (FileV2 fileV2 : this.icon.values()) {
            fileConsumer.invoke(fileV2);
        }
        for (AntiFeatureV2 antiFeatureV2 : this.antiFeatures.values()) {
            for (FileV2 fileV22 : antiFeatureV2.getIcon().values()) {
                fileConsumer.invoke(fileV22);
            }
        }
        for (CategoryV2 categoryV2 : this.categories.values()) {
            for (FileV2 fileV23 : categoryV2.getIcon().values()) {
                fileConsumer.invoke(fileV23);
            }
        }
    }
}
