package org.fdroid.index.v2;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: PackageV2.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.BÃ\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t\u0012 \u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t\u0012 \u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t\u0012 \u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t\u0012 \u0010\r\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010B¹\u0001\u0012\"\b\u0002\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t\u0012\"\b\u0002\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t\u0012\"\b\u0002\u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t\u0012\"\b\u0002\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t\u0012\"\b\u0002\u0010\r\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t¢\u0006\u0002\u0010\u0011J#\u0010\u001b\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\tHÆ\u0003J#\u0010\u001c\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\tHÆ\u0003J#\u0010\u001d\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\tHÆ\u0003J#\u0010\u001e\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\tHÆ\u0003J#\u0010\u001f\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\tHÆ\u0003J½\u0001\u0010 \u001a\u00020\u00002\"\b\u0002\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t2\"\b\u0002\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t2\"\b\u0002\u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t2\"\b\u0002\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t2\"\b\u0002\u0010\r\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\tHÆ\u0001J\u0013\u0010!\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001J&\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+HÁ\u0001¢\u0006\u0002\b,R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R+\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R+\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R+\u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R+\u0010\r\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R+\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016¨\u0006/"}, d2 = {"Lorg/fdroid/index/v2/Screenshots;", "", "seen1", "", "phone", "", "", "", "Lorg/fdroid/index/v2/FileV2;", "Lorg/fdroid/index/v2/LocalizedFileListV2;", "sevenInch", "tenInch", "wear", "tv", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "isNull", "", "()Z", "getPhone", "()Ljava/util/Map;", "getSevenInch", "getTenInch", "getTv", "getWear", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class Screenshots {
    private static final KSerializer[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final Map<String, List<FileV2>> phone;
    private final Map<String, List<FileV2>> sevenInch;
    private final Map<String, List<FileV2>> tenInch;
    private final Map<String, List<FileV2>> tv;
    private final Map<String, List<FileV2>> wear;

    public Screenshots() {
        this((Map) null, (Map) null, (Map) null, (Map) null, (Map) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Screenshots copy$default(Screenshots screenshots, Map map, Map map2, Map map3, Map map4, Map map5, int i, Object obj) {
        Map<String, List<FileV2>> map6 = map;
        if ((i & 1) != 0) {
            map6 = screenshots.phone;
        }
        Map<String, List<FileV2>> map7 = map2;
        if ((i & 2) != 0) {
            map7 = screenshots.sevenInch;
        }
        Map map8 = map7;
        Map<String, List<FileV2>> map9 = map3;
        if ((i & 4) != 0) {
            map9 = screenshots.tenInch;
        }
        Map map10 = map9;
        Map<String, List<FileV2>> map11 = map4;
        if ((i & 8) != 0) {
            map11 = screenshots.wear;
        }
        Map map12 = map11;
        Map<String, List<FileV2>> map13 = map5;
        if ((i & 16) != 0) {
            map13 = screenshots.tv;
        }
        return screenshots.copy(map6, map8, map10, map12, map13);
    }

    public final Map<String, List<FileV2>> component1() {
        return this.phone;
    }

    public final Map<String, List<FileV2>> component2() {
        return this.sevenInch;
    }

    public final Map<String, List<FileV2>> component3() {
        return this.tenInch;
    }

    public final Map<String, List<FileV2>> component4() {
        return this.wear;
    }

    public final Map<String, List<FileV2>> component5() {
        return this.tv;
    }

    public final Screenshots copy(Map<String, ? extends List<FileV2>> map, Map<String, ? extends List<FileV2>> map2, Map<String, ? extends List<FileV2>> map3, Map<String, ? extends List<FileV2>> map4, Map<String, ? extends List<FileV2>> map5) {
        return new Screenshots(map, map2, map3, map4, map5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Screenshots) {
            Screenshots screenshots = (Screenshots) obj;
            return Intrinsics.areEqual(this.phone, screenshots.phone) && Intrinsics.areEqual(this.sevenInch, screenshots.sevenInch) && Intrinsics.areEqual(this.tenInch, screenshots.tenInch) && Intrinsics.areEqual(this.wear, screenshots.wear) && Intrinsics.areEqual(this.tv, screenshots.tv);
        }
        return false;
    }

    public final Map<String, List<FileV2>> getPhone() {
        return this.phone;
    }

    public final Map<String, List<FileV2>> getSevenInch() {
        return this.sevenInch;
    }

    public final Map<String, List<FileV2>> getTenInch() {
        return this.tenInch;
    }

    public final Map<String, List<FileV2>> getTv() {
        return this.tv;
    }

    public final Map<String, List<FileV2>> getWear() {
        return this.wear;
    }

    public int hashCode() {
        Map<String, List<FileV2>> map = this.phone;
        int hashCode = (map == null ? 0 : map.hashCode()) * 31;
        Map<String, List<FileV2>> map2 = this.sevenInch;
        int hashCode2 = (hashCode + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, List<FileV2>> map3 = this.tenInch;
        int hashCode3 = (hashCode2 + (map3 == null ? 0 : map3.hashCode())) * 31;
        Map<String, List<FileV2>> map4 = this.wear;
        int hashCode4 = (hashCode3 + (map4 == null ? 0 : map4.hashCode())) * 31;
        Map<String, List<FileV2>> map5 = this.tv;
        return hashCode4 + (map5 != null ? map5.hashCode() : 0);
    }

    public final boolean isNull() {
        return this.phone == null && this.sevenInch == null && this.tenInch == null && this.wear == null && this.tv == null;
    }

    public String toString() {
        Map<String, List<FileV2>> map = this.phone;
        Map<String, List<FileV2>> map2 = this.sevenInch;
        Map<String, List<FileV2>> map3 = this.tenInch;
        Map<String, List<FileV2>> map4 = this.wear;
        Map<String, List<FileV2>> map5 = this.tv;
        return "Screenshots(phone=" + map + ", sevenInch=" + map2 + ", tenInch=" + map3 + ", wear=" + map4 + ", tv=" + map5 + ")";
    }

    /* compiled from: PackageV2.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lorg/fdroid/index/v2/Screenshots$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v2/Screenshots;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return Screenshots$$serializer.INSTANCE;
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        FileV2$$serializer fileV2$$serializer = FileV2$$serializer.INSTANCE;
        $childSerializers = new KSerializer[]{new LinkedHashMapSerializer(stringSerializer, new ArrayListSerializer(fileV2$$serializer)), new LinkedHashMapSerializer(stringSerializer, new ArrayListSerializer(fileV2$$serializer)), new LinkedHashMapSerializer(stringSerializer, new ArrayListSerializer(fileV2$$serializer)), new LinkedHashMapSerializer(stringSerializer, new ArrayListSerializer(fileV2$$serializer)), new LinkedHashMapSerializer(stringSerializer, new ArrayListSerializer(fileV2$$serializer))};
    }

    public /* synthetic */ Screenshots(int i, Map map, Map map2, Map map3, Map map4, Map map5, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.phone = null;
        } else {
            this.phone = map;
        }
        if ((i & 2) == 0) {
            this.sevenInch = null;
        } else {
            this.sevenInch = map2;
        }
        if ((i & 4) == 0) {
            this.tenInch = null;
        } else {
            this.tenInch = map3;
        }
        if ((i & 8) == 0) {
            this.wear = null;
        } else {
            this.wear = map4;
        }
        if ((i & 16) == 0) {
            this.tv = null;
        } else {
            this.tv = map5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Screenshots(Map<String, ? extends List<FileV2>> map, Map<String, ? extends List<FileV2>> map2, Map<String, ? extends List<FileV2>> map3, Map<String, ? extends List<FileV2>> map4, Map<String, ? extends List<FileV2>> map5) {
        this.phone = map;
        this.sevenInch = map2;
        this.tenInch = map3;
        this.wear = map4;
        this.tv = map5;
    }

    public static final /* synthetic */ void write$Self$index_release(Screenshots screenshots, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer[] kSerializerArr = $childSerializers;
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || screenshots.phone != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, kSerializerArr[0], screenshots.phone);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || screenshots.sevenInch != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, kSerializerArr[1], screenshots.sevenInch);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || screenshots.tenInch != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, kSerializerArr[2], screenshots.tenInch);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || screenshots.wear != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, kSerializerArr[3], screenshots.wear);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) && screenshots.tv == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, kSerializerArr[4], screenshots.tv);
    }

    public /* synthetic */ Screenshots(Map map, Map map2, Map map3, Map map4, Map map5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : map2, (i & 4) != 0 ? null : map3, (i & 8) != 0 ? null : map4, (i & 16) != 0 ? null : map5);
    }
}
