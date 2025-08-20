package kotlinx.serialization;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.action.Action;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
/* compiled from: PolymorphicSerializer.kt */
/* loaded from: classes2.dex */
public final class PolymorphicSerializer extends AbstractPolymorphicSerializer {
    private List _annotations;
    private final KClass baseClass;
    private final Lazy descriptor$delegate;

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public KClass getBaseClass() {
        return this.baseClass;
    }

    public PolymorphicSerializer(KClass baseClass) {
        List emptyList;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        this.baseClass = baseClass;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this._annotations = emptyList;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kotlinx.serialization.PolymorphicSerializer$descriptor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SerialDescriptor invoke() {
                final PolymorphicSerializer polymorphicSerializer = PolymorphicSerializer.this;
                return ContextAwareKt.withContext(SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.Polymorphic", PolymorphicKind.OPEN.INSTANCE, new SerialDescriptor[0], new Function1() { // from class: kotlinx.serialization.PolymorphicSerializer$descriptor$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ClassSerialDescriptorBuilder) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ClassSerialDescriptorBuilder buildSerialDescriptor) {
                        List list;
                        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
                        ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, BonjourPeer.TYPE, BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
                        ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, Action.VALUE_ATTRIBUTE, SerialDescriptorsKt.buildSerialDescriptor$default("kotlinx.serialization.Polymorphic<" + PolymorphicSerializer.this.getBaseClass().getSimpleName() + '>', SerialKind.CONTEXTUAL.INSTANCE, new SerialDescriptor[0], null, 8, null), null, false, 12, null);
                        list = PolymorphicSerializer.this._annotations;
                        buildSerialDescriptor.setAnnotations(list);
                    }
                }), PolymorphicSerializer.this.getBaseClass());
            }
        });
        this.descriptor$delegate = lazy;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PolymorphicSerializer(KClass baseClass, Annotation[] classAnnotations) {
        this(baseClass);
        List asList;
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(classAnnotations, "classAnnotations");
        asList = ArraysKt___ArraysJvmKt.asList(classAnnotations);
        this._annotations = asList;
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor$delegate.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + getBaseClass() + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
