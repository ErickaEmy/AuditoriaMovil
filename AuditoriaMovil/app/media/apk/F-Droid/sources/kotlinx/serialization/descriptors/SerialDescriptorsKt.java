package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.internal.PrimitivesKt;
/* compiled from: SerialDescriptors.kt */
/* loaded from: classes2.dex */
public abstract class SerialDescriptorsKt {
    public static final SerialDescriptor buildClassSerialDescriptor(String serialName, SerialDescriptor[] typeParameters, Function1 builderAction) {
        boolean isBlank;
        List list;
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        isBlank = StringsKt__StringsJVMKt.isBlank(serialName);
        if (!(!isBlank)) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        }
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(serialName);
        builderAction.invoke(classSerialDescriptorBuilder);
        StructureKind.CLASS r3 = StructureKind.CLASS.INSTANCE;
        int size = classSerialDescriptorBuilder.getElementNames$kotlinx_serialization_core().size();
        list = ArraysKt___ArraysKt.toList(typeParameters);
        return new SerialDescriptorImpl(serialName, r3, size, list, classSerialDescriptorBuilder);
    }

    public static final SerialDescriptor PrimitiveSerialDescriptor(String serialName, PrimitiveKind kind) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        isBlank = StringsKt__StringsJVMKt.isBlank(serialName);
        if (!(!isBlank)) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        }
        return PrimitivesKt.PrimitiveDescriptorSafe(serialName, kind);
    }

    public static /* synthetic */ SerialDescriptor buildSerialDescriptor$default(String str, SerialKind serialKind, SerialDescriptor[] serialDescriptorArr, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = new Function1() { // from class: kotlinx.serialization.descriptors.SerialDescriptorsKt$buildSerialDescriptor$1
                public final void invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                    Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((ClassSerialDescriptorBuilder) obj2);
                    return Unit.INSTANCE;
                }
            };
        }
        return buildSerialDescriptor(str, serialKind, serialDescriptorArr, function1);
    }

    public static final SerialDescriptor buildSerialDescriptor(String serialName, SerialKind kind, SerialDescriptor[] typeParameters, Function1 builder) {
        boolean isBlank;
        List list;
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builder, "builder");
        isBlank = StringsKt__StringsJVMKt.isBlank(serialName);
        if (!(!isBlank)) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        }
        if (!(!Intrinsics.areEqual(kind, StructureKind.CLASS.INSTANCE))) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead".toString());
        }
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(serialName);
        builder.invoke(classSerialDescriptorBuilder);
        int size = classSerialDescriptorBuilder.getElementNames$kotlinx_serialization_core().size();
        list = ArraysKt___ArraysKt.toList(typeParameters);
        return new SerialDescriptorImpl(serialName, kind, size, list, classSerialDescriptorBuilder);
    }
}
