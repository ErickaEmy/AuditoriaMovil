package kotlinx.serialization.internal;

import ch.qos.logback.core.CoreConstants;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
/* compiled from: Enums.kt */
/* loaded from: classes2.dex */
public final class EnumDescriptor extends PluginGeneratedSerialDescriptor {
    private final Lazy elementDescriptors$delegate;
    private final SerialKind kind;

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind getKind() {
        return this.kind;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnumDescriptor(final String name, final int i) {
        super(name, null, i, 2, null);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(name, "name");
        this.kind = SerialKind.ENUM.INSTANCE;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: kotlinx.serialization.internal.EnumDescriptor$elementDescriptors$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SerialDescriptor[] invoke() {
                int i2 = i;
                SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    serialDescriptorArr[i3] = SerialDescriptorsKt.buildSerialDescriptor$default(name + CoreConstants.DOT + this.getElementName(i3), StructureKind.OBJECT.INSTANCE, new SerialDescriptor[0], null, 8, null);
                }
                return serialDescriptorArr;
            }
        });
        this.elementDescriptors$delegate = lazy;
    }

    private final SerialDescriptor[] getElementDescriptors() {
        return (SerialDescriptor[]) this.elementDescriptors$delegate.getValue();
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor getElementDescriptor(int i) {
        return getElementDescriptors()[i];
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof SerialDescriptor)) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            return serialDescriptor.getKind() == SerialKind.ENUM.INSTANCE && Intrinsics.areEqual(getSerialName(), serialDescriptor.getSerialName()) && Intrinsics.areEqual(Platform_commonKt.cachedSerialNames(this), Platform_commonKt.cachedSerialNames(serialDescriptor));
        }
        return false;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public String toString() {
        String joinToString$default;
        Iterable elementNames = SerialDescriptorKt.getElementNames(this);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(elementNames, ", ", getSerialName() + CoreConstants.LEFT_PARENTHESIS_CHAR, ")", 0, null, null, 56, null);
        return joinToString$default;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public int hashCode() {
        int hashCode = getSerialName().hashCode();
        int i = 1;
        for (String str : SerialDescriptorKt.getElementNames(this)) {
            int i2 = i * 31;
            i = i2 + (str != null ? str.hashCode() : 0);
        }
        return (hashCode * 31) + i;
    }
}
