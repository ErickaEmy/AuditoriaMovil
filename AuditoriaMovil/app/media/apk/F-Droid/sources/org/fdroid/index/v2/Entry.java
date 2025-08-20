package org.fdroid.index.v2;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: IndexV2.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201BS\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000bHÆ\u0003JN\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0005J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\fHÖ\u0001J&\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.HÁ\u0001¢\u0006\u0002\b/R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u00062"}, d2 = {"Lorg/fdroid/index/v2/Entry;", "", "seen1", "", "timestamp", "", "version", "maxAge", "index", "Lorg/fdroid/index/v2/EntryFileV2;", "diffs", "", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLjava/lang/Integer;Lorg/fdroid/index/v2/EntryFileV2;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(JJLjava/lang/Integer;Lorg/fdroid/index/v2/EntryFileV2;Ljava/util/Map;)V", "getDiffs", "()Ljava/util/Map;", "getIndex", "()Lorg/fdroid/index/v2/EntryFileV2;", "getMaxAge", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTimestamp", "()J", "getVersion", "component1", "component2", "component3", "component4", "component5", "copy", "(JJLjava/lang/Integer;Lorg/fdroid/index/v2/EntryFileV2;Ljava/util/Map;)Lorg/fdroid/index/v2/Entry;", "equals", "", "other", "getDiff", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class Entry {
    private final Map<String, EntryFileV2> diffs;
    private final EntryFileV2 index;
    private final Integer maxAge;
    private final long timestamp;
    private final long version;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer[] $childSerializers = {null, null, null, null, new LinkedHashMapSerializer(StringSerializer.INSTANCE, EntryFileV2$$serializer.INSTANCE)};

    public final long component1() {
        return this.timestamp;
    }

    public final long component2() {
        return this.version;
    }

    public final Integer component3() {
        return this.maxAge;
    }

    public final EntryFileV2 component4() {
        return this.index;
    }

    public final Map<String, EntryFileV2> component5() {
        return this.diffs;
    }

    public final Entry copy(long j, long j2, Integer num, EntryFileV2 index, Map<String, EntryFileV2> diffs) {
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(diffs, "diffs");
        return new Entry(j, j2, num, index, diffs);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Entry) {
            Entry entry = (Entry) obj;
            return this.timestamp == entry.timestamp && this.version == entry.version && Intrinsics.areEqual(this.maxAge, entry.maxAge) && Intrinsics.areEqual(this.index, entry.index) && Intrinsics.areEqual(this.diffs, entry.diffs);
        }
        return false;
    }

    public final Map<String, EntryFileV2> getDiffs() {
        return this.diffs;
    }

    public final EntryFileV2 getIndex() {
        return this.index;
    }

    public final Integer getMaxAge() {
        return this.maxAge;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final long getVersion() {
        return this.version;
    }

    public int hashCode() {
        int m = ((FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.timestamp) * 31) + FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.version)) * 31;
        Integer num = this.maxAge;
        return ((((m + (num == null ? 0 : num.hashCode())) * 31) + this.index.hashCode()) * 31) + this.diffs.hashCode();
    }

    public String toString() {
        long j = this.timestamp;
        long j2 = this.version;
        Integer num = this.maxAge;
        EntryFileV2 entryFileV2 = this.index;
        Map<String, EntryFileV2> map = this.diffs;
        return "Entry(timestamp=" + j + ", version=" + j2 + ", maxAge=" + num + ", index=" + entryFileV2 + ", diffs=" + map + ")";
    }

    /* compiled from: IndexV2.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lorg/fdroid/index/v2/Entry$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v2/Entry;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return Entry$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Entry(int i, long j, long j2, Integer num, EntryFileV2 entryFileV2, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        Map<String, EntryFileV2> emptyMap;
        if (11 != (i & 11)) {
            PluginExceptionsKt.throwMissingFieldException(i, 11, Entry$$serializer.INSTANCE.getDescriptor());
        }
        this.timestamp = j;
        this.version = j2;
        if ((i & 4) == 0) {
            this.maxAge = null;
        } else {
            this.maxAge = num;
        }
        this.index = entryFileV2;
        if ((i & 16) != 0) {
            this.diffs = map;
            return;
        }
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.diffs = emptyMap;
    }

    public Entry(long j, long j2, Integer num, EntryFileV2 index, Map<String, EntryFileV2> diffs) {
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(diffs, "diffs");
        this.timestamp = j;
        this.version = j2;
        this.maxAge = num;
        this.index = index;
        this.diffs = diffs;
    }

    public static final /* synthetic */ void write$Self$index_release(Entry entry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Map emptyMap;
        KSerializer[] kSerializerArr = $childSerializers;
        compositeEncoder.encodeLongElement(serialDescriptor, 0, entry.timestamp);
        compositeEncoder.encodeLongElement(serialDescriptor, 1, entry.version);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || entry.maxAge != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, entry.maxAge);
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 3, EntryFileV2$$serializer.INSTANCE, entry.index);
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4)) {
            Map<String, EntryFileV2> map = entry.diffs;
            emptyMap = MapsKt__MapsKt.emptyMap();
            if (Intrinsics.areEqual(map, emptyMap)) {
                return;
            }
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], entry.diffs);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ Entry(long r10, long r12, java.lang.Integer r14, org.fdroid.index.v2.EntryFileV2 r15, java.util.Map r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r9 = this;
            r0 = r17 & 4
            if (r0 == 0) goto L7
            r0 = 0
            r6 = r0
            goto L8
        L7:
            r6 = r14
        L8:
            r0 = r17 & 16
            if (r0 == 0) goto L12
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            r8 = r0
            goto L14
        L12:
            r8 = r16
        L14:
            r1 = r9
            r2 = r10
            r4 = r12
            r7 = r15
            r1.<init>(r2, r4, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.v2.Entry.<init>(long, long, java.lang.Integer, org.fdroid.index.v2.EntryFileV2, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final EntryFileV2 getDiff(long j) {
        return this.diffs.get(String.valueOf(j));
    }
}
