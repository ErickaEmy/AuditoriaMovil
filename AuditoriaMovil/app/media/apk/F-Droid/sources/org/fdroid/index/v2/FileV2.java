package org.fdroid.index.v2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import org.fdroid.IndexFile;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
import org.fdroid.index.IndexParser;
/* compiled from: IndexV2.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-BC\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J<\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\b\u0010\"\u001a\u00020\u0005H\u0016J\t\u0010#\u001a\u00020\u0005HÖ\u0001J&\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*HÁ\u0001¢\u0006\u0002\b+R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006."}, d2 = {"Lorg/fdroid/index/v2/FileV2;", "Lorg/fdroid/IndexFile;", "seen1", "", "name", "", "sha256", "size", "", "ipfsCidV1", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getIpfsCidV1$annotations", "()V", "getIpfsCidV1", "()Ljava/lang/String;", "getName", "getSha256", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lorg/fdroid/index/v2/FileV2;", "equals", "", "other", "", "hashCode", "serialize", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class FileV2 implements IndexFile {
    public static final Companion Companion = new Companion(null);
    private final String ipfsCidV1;
    private final String name;
    private final String sha256;
    private final Long size;

    public static /* synthetic */ FileV2 copy$default(FileV2 fileV2, String str, String str2, Long l, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileV2.name;
        }
        if ((i & 2) != 0) {
            str2 = fileV2.sha256;
        }
        if ((i & 4) != 0) {
            l = fileV2.size;
        }
        if ((i & 8) != 0) {
            str3 = fileV2.ipfsCidV1;
        }
        return fileV2.copy(str, str2, l, str3);
    }

    public static final FileV2 deserialize(String str) {
        return Companion.deserialize(str);
    }

    public static final FileV2 fromPath(String str) {
        return Companion.fromPath(str);
    }

    public static /* synthetic */ void getIpfsCidV1$annotations() {
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.sha256;
    }

    public final Long component3() {
        return this.size;
    }

    public final String component4() {
        return this.ipfsCidV1;
    }

    public final FileV2 copy(String name, String str, Long l, String str2) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new FileV2(name, str, l, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FileV2) {
            FileV2 fileV2 = (FileV2) obj;
            return Intrinsics.areEqual(this.name, fileV2.name) && Intrinsics.areEqual(this.sha256, fileV2.sha256) && Intrinsics.areEqual(this.size, fileV2.size) && Intrinsics.areEqual(this.ipfsCidV1, fileV2.ipfsCidV1);
        }
        return false;
    }

    @Override // org.fdroid.IndexFile
    public String getIpfsCidV1() {
        return this.ipfsCidV1;
    }

    @Override // org.fdroid.IndexFile
    public String getName() {
        return this.name;
    }

    @Override // org.fdroid.IndexFile
    public String getSha256() {
        return this.sha256;
    }

    @Override // org.fdroid.IndexFile
    public Long getSize() {
        return this.size;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.sha256;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.size;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.ipfsCidV1;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.name;
        String str2 = this.sha256;
        Long l = this.size;
        String str3 = this.ipfsCidV1;
        return "FileV2(name=" + str + ", sha256=" + str2 + ", size=" + l + ", ipfsCidV1=" + str3 + ")";
    }

    public /* synthetic */ FileV2(int i, String str, String str2, Long l, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, FileV2$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        if ((i & 2) == 0) {
            this.sha256 = null;
        } else {
            this.sha256 = str2;
        }
        if ((i & 4) == 0) {
            this.size = null;
        } else {
            this.size = l;
        }
        if ((i & 8) == 0) {
            this.ipfsCidV1 = null;
        } else {
            this.ipfsCidV1 = str3;
        }
    }

    public FileV2(String name, String str, Long l, String str2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.sha256 = str;
        this.size = l;
        this.ipfsCidV1 = str2;
    }

    public static final /* synthetic */ void write$Self$index_release(FileV2 fileV2, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeStringElement(serialDescriptor, 0, fileV2.getName());
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || fileV2.getSha256() != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, fileV2.getSha256());
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || fileV2.getSize() != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, LongSerializer.INSTANCE, fileV2.getSize());
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) && fileV2.getIpfsCidV1() == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, fileV2.getIpfsCidV1());
    }

    public /* synthetic */ FileV2(String str, String str2, Long l, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str3);
    }

    /* compiled from: IndexV2.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0001¨\u0006\u000b"}, d2 = {"Lorg/fdroid/index/v2/FileV2$Companion;", "", "()V", "deserialize", "Lorg/fdroid/index/v2/FileV2;", "string", "", "fromPath", BonjourPeer.PATH, "serializer", "Lkotlinx/serialization/KSerializer;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return FileV2$$serializer.INSTANCE;
        }

        public final FileV2 deserialize(String str) {
            if (str == null || str.length() == 0) {
                return null;
            }
            Json json = IndexParser.getJson();
            KSerializer serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.nullableTypeOf(FileV2.class));
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return (FileV2) json.decodeFromString(serializer, str);
        }

        public final FileV2 fromPath(String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            return new FileV2(path, (String) null, (Long) null, (String) null, 14, (DefaultConstructorMarker) null);
        }
    }

    @Override // org.fdroid.IndexFile
    public String serialize() {
        Json json = IndexParser.getJson();
        KSerializer serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(FileV2.class));
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return json.encodeToString(serializer, this);
    }
}
