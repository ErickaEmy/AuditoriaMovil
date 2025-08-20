package org.fdroid.index.v2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
/* compiled from: PackageV2.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB)\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cHÁ\u0001¢\u0006\u0002\b\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006 "}, d2 = {"Lorg/fdroid/index/v2/UsesSdkV2;", "", "seen1", "", "minSdkVersion", "targetSdkVersion", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(II)V", "getMinSdkVersion", "()I", "getTargetSdkVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class UsesSdkV2 {
    public static final Companion Companion = new Companion(null);
    private final int minSdkVersion;
    private final int targetSdkVersion;

    public static /* synthetic */ UsesSdkV2 copy$default(UsesSdkV2 usesSdkV2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = usesSdkV2.minSdkVersion;
        }
        if ((i3 & 2) != 0) {
            i2 = usesSdkV2.targetSdkVersion;
        }
        return usesSdkV2.copy(i, i2);
    }

    public final int component1() {
        return this.minSdkVersion;
    }

    public final int component2() {
        return this.targetSdkVersion;
    }

    public final UsesSdkV2 copy(int i, int i2) {
        return new UsesSdkV2(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UsesSdkV2) {
            UsesSdkV2 usesSdkV2 = (UsesSdkV2) obj;
            return this.minSdkVersion == usesSdkV2.minSdkVersion && this.targetSdkVersion == usesSdkV2.targetSdkVersion;
        }
        return false;
    }

    public final int getMinSdkVersion() {
        return this.minSdkVersion;
    }

    public final int getTargetSdkVersion() {
        return this.targetSdkVersion;
    }

    public int hashCode() {
        return (this.minSdkVersion * 31) + this.targetSdkVersion;
    }

    public String toString() {
        int i = this.minSdkVersion;
        int i2 = this.targetSdkVersion;
        return "UsesSdkV2(minSdkVersion=" + i + ", targetSdkVersion=" + i2 + ")";
    }

    /* compiled from: PackageV2.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lorg/fdroid/index/v2/UsesSdkV2$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v2/UsesSdkV2;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return UsesSdkV2$$serializer.INSTANCE;
        }
    }

    public UsesSdkV2(int i, int i2) {
        this.minSdkVersion = i;
        this.targetSdkVersion = i2;
    }

    public /* synthetic */ UsesSdkV2(int i, int i2, int i3, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, UsesSdkV2$$serializer.INSTANCE.getDescriptor());
        }
        this.minSdkVersion = i2;
        this.targetSdkVersion = i3;
    }

    public static final /* synthetic */ void write$Self$index_release(UsesSdkV2 usesSdkV2, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeIntElement(serialDescriptor, 0, usesSdkV2.minSdkVersion);
        compositeEncoder.encodeIntElement(serialDescriptor, 1, usesSdkV2.targetSdkVersion);
    }
}
