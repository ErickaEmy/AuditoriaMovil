package org.fdroid.index.v2;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import org.fdroid.IndexFile;
import org.fdroid.index.IndexParser;
/* compiled from: IndexV2.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002./BI\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J=\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\b\u0010$\u001a\u00020\u0005H\u0016J\t\u0010%\u001a\u00020\u0005HÖ\u0001J&\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,HÁ\u0001¢\u0006\u0002\b-R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u00060"}, d2 = {"Lorg/fdroid/index/v2/EntryFileV2;", "Lorg/fdroid/IndexFile;", "seen1", "", "name", "", "sha256", "size", "", "ipfsCidV1", "numPackages", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;I)V", "getIpfsCidV1$annotations", "()V", "getIpfsCidV1", "()Ljava/lang/String;", "getName", "getNumPackages", "()I", "getSha256", "getSize", "()Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "serialize", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class EntryFileV2 implements IndexFile {
    public static final Companion Companion = new Companion(null);
    private final String ipfsCidV1;
    private final String name;
    private final int numPackages;
    private final String sha256;
    private final long size;

    public static /* synthetic */ EntryFileV2 copy$default(EntryFileV2 entryFileV2, String str, String str2, long j, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = entryFileV2.name;
        }
        if ((i2 & 2) != 0) {
            str2 = entryFileV2.sha256;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            j = entryFileV2.size;
        }
        long j2 = j;
        if ((i2 & 8) != 0) {
            str3 = entryFileV2.ipfsCidV1;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            i = entryFileV2.numPackages;
        }
        return entryFileV2.copy(str, str4, j2, str5, i);
    }

    public static /* synthetic */ void getIpfsCidV1$annotations() {
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.sha256;
    }

    public final long component3() {
        return this.size;
    }

    public final String component4() {
        return this.ipfsCidV1;
    }

    public final int component5() {
        return this.numPackages;
    }

    public final EntryFileV2 copy(String name, String sha256, long j, String str, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sha256, "sha256");
        return new EntryFileV2(name, sha256, j, str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EntryFileV2) {
            EntryFileV2 entryFileV2 = (EntryFileV2) obj;
            return Intrinsics.areEqual(this.name, entryFileV2.name) && Intrinsics.areEqual(this.sha256, entryFileV2.sha256) && this.size == entryFileV2.size && Intrinsics.areEqual(this.ipfsCidV1, entryFileV2.ipfsCidV1) && this.numPackages == entryFileV2.numPackages;
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

    public final int getNumPackages() {
        return this.numPackages;
    }

    @Override // org.fdroid.IndexFile
    public String getSha256() {
        return this.sha256;
    }

    public int hashCode() {
        int hashCode = ((((this.name.hashCode() * 31) + this.sha256.hashCode()) * 31) + FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.size)) * 31;
        String str = this.ipfsCidV1;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.numPackages;
    }

    public String toString() {
        String str = this.name;
        String str2 = this.sha256;
        long j = this.size;
        String str3 = this.ipfsCidV1;
        int i = this.numPackages;
        return "EntryFileV2(name=" + str + ", sha256=" + str2 + ", size=" + j + ", ipfsCidV1=" + str3 + ", numPackages=" + i + ")";
    }

    public /* synthetic */ EntryFileV2(int i, String str, String str2, long j, String str3, int i2, SerializationConstructorMarker serializationConstructorMarker) {
        if (23 != (i & 23)) {
            PluginExceptionsKt.throwMissingFieldException(i, 23, EntryFileV2$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        this.sha256 = str2;
        this.size = j;
        if ((i & 8) == 0) {
            this.ipfsCidV1 = null;
        } else {
            this.ipfsCidV1 = str3;
        }
        this.numPackages = i2;
    }

    public EntryFileV2(String name, String sha256, long j, String str, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sha256, "sha256");
        this.name = name;
        this.sha256 = sha256;
        this.size = j;
        this.ipfsCidV1 = str;
        this.numPackages = i;
    }

    public static final /* synthetic */ void write$Self$index_release(EntryFileV2 entryFileV2, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeStringElement(serialDescriptor, 0, entryFileV2.getName());
        compositeEncoder.encodeStringElement(serialDescriptor, 1, entryFileV2.getSha256());
        compositeEncoder.encodeLongElement(serialDescriptor, 2, entryFileV2.getSize().longValue());
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || entryFileV2.getIpfsCidV1() != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, entryFileV2.getIpfsCidV1());
        }
        compositeEncoder.encodeIntElement(serialDescriptor, 4, entryFileV2.numPackages);
    }

    public /* synthetic */ EntryFileV2(String str, String str2, long j, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, (i2 & 8) != 0 ? null : str3, i);
    }

    @Override // org.fdroid.IndexFile
    public Long getSize() {
        return Long.valueOf(this.size);
    }

    /* compiled from: IndexV2.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0001¨\u0006\t"}, d2 = {"Lorg/fdroid/index/v2/EntryFileV2$Companion;", "", "()V", "deserialize", "Lorg/fdroid/index/v2/EntryFileV2;", "string", "", "serializer", "Lkotlinx/serialization/KSerializer;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return EntryFileV2$$serializer.INSTANCE;
        }

        public final EntryFileV2 deserialize(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            Json json = IndexParser.getJson();
            KSerializer serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(EntryFileV2.class));
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return (EntryFileV2) json.decodeFromString(serializer, string);
        }
    }

    @Override // org.fdroid.IndexFile
    public String serialize() {
        Json json = IndexParser.getJson();
        KSerializer serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(EntryFileV2.class));
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return json.encodeToString(serializer, this);
    }
}
