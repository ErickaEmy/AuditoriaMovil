package org.fdroid.index.v2;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
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
/* compiled from: PackageV2.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B9\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\rJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\u001c\u0010\u001a\u001a\u00020\u001b2\u0014\u0010\u001c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020\u001b0\u001dJ&\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÁ\u0001¢\u0006\u0002\b%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006("}, d2 = {"Lorg/fdroid/index/v2/PackageV2;", "", "seen1", "", "metadata", "Lorg/fdroid/index/v2/MetadataV2;", "versions", "", "", "Lorg/fdroid/index/v2/PackageVersionV2;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILorg/fdroid/index/v2/MetadataV2;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lorg/fdroid/index/v2/MetadataV2;Ljava/util/Map;)V", "getMetadata", "()Lorg/fdroid/index/v2/MetadataV2;", "getVersions", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "walkFiles", "", "fileConsumer", "Lkotlin/Function1;", "Lorg/fdroid/index/v2/FileV2;", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class PackageV2 {
    private final MetadataV2 metadata;
    private final Map<String, PackageVersionV2> versions;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer[] $childSerializers = {null, new LinkedHashMapSerializer(StringSerializer.INSTANCE, PackageVersionV2$$serializer.INSTANCE)};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PackageV2 copy$default(PackageV2 packageV2, MetadataV2 metadataV2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            metadataV2 = packageV2.metadata;
        }
        if ((i & 2) != 0) {
            map = packageV2.versions;
        }
        return packageV2.copy(metadataV2, map);
    }

    public final MetadataV2 component1() {
        return this.metadata;
    }

    public final Map<String, PackageVersionV2> component2() {
        return this.versions;
    }

    public final PackageV2 copy(MetadataV2 metadata, Map<String, PackageVersionV2> versions) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(versions, "versions");
        return new PackageV2(metadata, versions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PackageV2) {
            PackageV2 packageV2 = (PackageV2) obj;
            return Intrinsics.areEqual(this.metadata, packageV2.metadata) && Intrinsics.areEqual(this.versions, packageV2.versions);
        }
        return false;
    }

    public final MetadataV2 getMetadata() {
        return this.metadata;
    }

    public final Map<String, PackageVersionV2> getVersions() {
        return this.versions;
    }

    public int hashCode() {
        return (this.metadata.hashCode() * 31) + this.versions.hashCode();
    }

    public String toString() {
        MetadataV2 metadataV2 = this.metadata;
        Map<String, PackageVersionV2> map = this.versions;
        return "PackageV2(metadata=" + metadataV2 + ", versions=" + map + ")";
    }

    /* compiled from: PackageV2.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lorg/fdroid/index/v2/PackageV2$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v2/PackageV2;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return PackageV2$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ PackageV2(int i, MetadataV2 metadataV2, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        Map<String, PackageVersionV2> emptyMap;
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, PackageV2$$serializer.INSTANCE.getDescriptor());
        }
        this.metadata = metadataV2;
        if ((i & 2) != 0) {
            this.versions = map;
            return;
        }
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.versions = emptyMap;
    }

    public PackageV2(MetadataV2 metadata, Map<String, PackageVersionV2> versions) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(versions, "versions");
        this.metadata = metadata;
        this.versions = versions;
    }

    public static final /* synthetic */ void write$Self$index_release(PackageV2 packageV2, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Map emptyMap;
        KSerializer[] kSerializerArr = $childSerializers;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, MetadataV2$$serializer.INSTANCE, packageV2.metadata);
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1)) {
            Map<String, PackageVersionV2> map = packageV2.versions;
            emptyMap = MapsKt__MapsKt.emptyMap();
            if (Intrinsics.areEqual(map, emptyMap)) {
                return;
            }
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], packageV2.versions);
    }

    public /* synthetic */ PackageV2(MetadataV2 metadataV2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(metadataV2, (i & 2) != 0 ? MapsKt__MapsKt.emptyMap() : map);
    }

    public final void walkFiles(Function1 fileConsumer) {
        Intrinsics.checkNotNullParameter(fileConsumer, "fileConsumer");
        this.metadata.walkFiles(fileConsumer);
        for (PackageVersionV2 packageVersionV2 : this.versions.values()) {
            packageVersionV2.walkFiles(fileConsumer);
        }
    }
}
