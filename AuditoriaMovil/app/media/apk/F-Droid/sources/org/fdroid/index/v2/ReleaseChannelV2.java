package org.fdroid.index.v2;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: IndexV2.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !BQ\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB7\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007¢\u0006\u0002\u0010\fJ\u0019\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007HÆ\u0003J=\u0010\u0012\u001a\u00020\u00002\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eHÁ\u0001¢\u0006\u0002\b\u001fR!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\""}, d2 = {"Lorg/fdroid/index/v2/ReleaseChannelV2;", "", "seen1", "", "name", "", "", "Lorg/fdroid/index/v2/LocalizedTextV2;", "description", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/Map;Ljava/util/Map;)V", "getDescription", "()Ljava/util/Map;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class ReleaseChannelV2 {
    private static final KSerializer[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final Map<String, String> description;
    private final Map<String, String> name;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReleaseChannelV2 copy$default(ReleaseChannelV2 releaseChannelV2, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = releaseChannelV2.name;
        }
        if ((i & 2) != 0) {
            map2 = releaseChannelV2.description;
        }
        return releaseChannelV2.copy(map, map2);
    }

    public final Map<String, String> component1() {
        return this.name;
    }

    public final Map<String, String> component2() {
        return this.description;
    }

    public final ReleaseChannelV2 copy(Map<String, String> name, Map<String, String> description) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        return new ReleaseChannelV2(name, description);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReleaseChannelV2) {
            ReleaseChannelV2 releaseChannelV2 = (ReleaseChannelV2) obj;
            return Intrinsics.areEqual(this.name, releaseChannelV2.name) && Intrinsics.areEqual(this.description, releaseChannelV2.description);
        }
        return false;
    }

    public final Map<String, String> getDescription() {
        return this.description;
    }

    public final Map<String, String> getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.description.hashCode();
    }

    public String toString() {
        Map<String, String> map = this.name;
        Map<String, String> map2 = this.description;
        return "ReleaseChannelV2(name=" + map + ", description=" + map2 + ")";
    }

    /* compiled from: IndexV2.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lorg/fdroid/index/v2/ReleaseChannelV2$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v2/ReleaseChannelV2;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return ReleaseChannelV2$$serializer.INSTANCE;
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        $childSerializers = new KSerializer[]{new LinkedHashMapSerializer(stringSerializer, stringSerializer), new LinkedHashMapSerializer(stringSerializer, stringSerializer)};
    }

    public /* synthetic */ ReleaseChannelV2(int i, Map map, Map map2, SerializationConstructorMarker serializationConstructorMarker) {
        Map<String, String> emptyMap;
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, ReleaseChannelV2$$serializer.INSTANCE.getDescriptor());
        }
        this.name = map;
        if ((i & 2) != 0) {
            this.description = map2;
            return;
        }
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.description = emptyMap;
    }

    public ReleaseChannelV2(Map<String, String> name, Map<String, String> description) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        this.name = name;
        this.description = description;
    }

    public static final /* synthetic */ void write$Self$index_release(ReleaseChannelV2 releaseChannelV2, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Map emptyMap;
        KSerializer[] kSerializerArr = $childSerializers;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], releaseChannelV2.name);
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1)) {
            Map<String, String> map = releaseChannelV2.description;
            emptyMap = MapsKt__MapsKt.emptyMap();
            if (Intrinsics.areEqual(map, emptyMap)) {
                return;
            }
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], releaseChannelV2.description);
    }

    public /* synthetic */ ReleaseChannelV2(Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, (i & 2) != 0 ? MapsKt__MapsKt.emptyMap() : map2);
    }
}
