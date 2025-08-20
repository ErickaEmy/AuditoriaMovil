package org.fdroid.index.v2;

import androidx.compose.foundation.ClickableElement$$ExternalSyntheticBackport0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: PackageV2.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J#\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eHÁ\u0001¢\u0006\u0002\b\u001fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lorg/fdroid/index/v2/SignerV2;", "", "seen1", "", "sha256", "", "", "hasMultipleSigners", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Z)V", "getHasMultipleSigners", "()Z", "getSha256", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class SignerV2 {
    private final boolean hasMultipleSigners;
    private final List<String> sha256;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer[] $childSerializers = {new ArrayListSerializer(StringSerializer.INSTANCE), null};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SignerV2 copy$default(SignerV2 signerV2, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = signerV2.sha256;
        }
        if ((i & 2) != 0) {
            z = signerV2.hasMultipleSigners;
        }
        return signerV2.copy(list, z);
    }

    public final List<String> component1() {
        return this.sha256;
    }

    public final boolean component2() {
        return this.hasMultipleSigners;
    }

    public final SignerV2 copy(List<String> sha256, boolean z) {
        Intrinsics.checkNotNullParameter(sha256, "sha256");
        return new SignerV2(sha256, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SignerV2) {
            SignerV2 signerV2 = (SignerV2) obj;
            return Intrinsics.areEqual(this.sha256, signerV2.sha256) && this.hasMultipleSigners == signerV2.hasMultipleSigners;
        }
        return false;
    }

    public final boolean getHasMultipleSigners() {
        return this.hasMultipleSigners;
    }

    public final List<String> getSha256() {
        return this.sha256;
    }

    public int hashCode() {
        return (this.sha256.hashCode() * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.hasMultipleSigners);
    }

    public String toString() {
        List<String> list = this.sha256;
        boolean z = this.hasMultipleSigners;
        return "SignerV2(sha256=" + list + ", hasMultipleSigners=" + z + ")";
    }

    /* compiled from: PackageV2.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lorg/fdroid/index/v2/SignerV2$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v2/SignerV2;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return SignerV2$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SignerV2(int i, List list, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, SignerV2$$serializer.INSTANCE.getDescriptor());
        }
        this.sha256 = list;
        if ((i & 2) == 0) {
            this.hasMultipleSigners = false;
        } else {
            this.hasMultipleSigners = z;
        }
    }

    public SignerV2(List<String> sha256, boolean z) {
        Intrinsics.checkNotNullParameter(sha256, "sha256");
        this.sha256 = sha256;
        this.hasMultipleSigners = z;
    }

    public static final /* synthetic */ void write$Self$index_release(SignerV2 signerV2, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, $childSerializers[0], signerV2.sha256);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || signerV2.hasMultipleSigners) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 1, signerV2.hasMultipleSigners);
        }
    }

    public /* synthetic */ SignerV2(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? false : z);
    }
}
