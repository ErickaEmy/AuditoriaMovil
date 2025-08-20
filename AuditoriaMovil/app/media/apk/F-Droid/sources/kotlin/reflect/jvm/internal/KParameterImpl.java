package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
/* compiled from: KParameterImpl.kt */
/* loaded from: classes2.dex */
public final class KParameterImpl implements KParameter {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KParameterImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KParameterImpl.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    private final ReflectProperties.LazySoftVal annotations$delegate;
    private final KCallableImpl callable;
    private final ReflectProperties.LazySoftVal descriptor$delegate;
    private final int index;
    private final KParameter.Kind kind;

    public final KCallableImpl getCallable() {
        return this.callable;
    }

    @Override // kotlin.reflect.KParameter
    public int getIndex() {
        return this.index;
    }

    @Override // kotlin.reflect.KParameter
    public KParameter.Kind getKind() {
        return this.kind;
    }

    public KParameterImpl(KCallableImpl callable, int i, KParameter.Kind kind, Function0 computeDescriptor) {
        Intrinsics.checkNotNullParameter(callable, "callable");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(computeDescriptor, "computeDescriptor");
        this.callable = callable;
        this.index = i;
        this.kind = kind;
        this.descriptor$delegate = ReflectProperties.lazySoft(computeDescriptor);
        this.annotations$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KParameterImpl$annotations$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List invoke() {
                ParameterDescriptor descriptor;
                descriptor = KParameterImpl.this.getDescriptor();
                return UtilKt.computeAnnotations(descriptor);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ParameterDescriptor getDescriptor() {
        Object value = this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ParameterDescriptor) value;
    }

    @Override // kotlin.reflect.KParameter
    public String getName() {
        ParameterDescriptor descriptor = getDescriptor();
        ValueParameterDescriptor valueParameterDescriptor = descriptor instanceof ValueParameterDescriptor ? (ValueParameterDescriptor) descriptor : null;
        if (valueParameterDescriptor == null || valueParameterDescriptor.getContainingDeclaration().hasSynthesizedParameterNames()) {
            return null;
        }
        Name name = valueParameterDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (name.isSpecial()) {
            return null;
        }
        return name.asString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Type compoundType(Type... typeArr) {
        Object single;
        int length = typeArr.length;
        if (length != 0) {
            if (length == 1) {
                single = ArraysKt___ArraysKt.single(typeArr);
                return (Type) single;
            }
            return new CompoundTypeImpl(typeArr);
        }
        throw new KotlinReflectionNotSupportedError("Expected at least 1 type for compound type");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KParameterImpl.kt */
    /* loaded from: classes2.dex */
    public static final class CompoundTypeImpl implements Type {
        private final int hashCode;
        private final Type[] types;

        public int hashCode() {
            return this.hashCode;
        }

        public CompoundTypeImpl(Type[] types) {
            Intrinsics.checkNotNullParameter(types, "types");
            this.types = types;
            this.hashCode = Arrays.hashCode(types);
        }

        @Override // java.lang.reflect.Type
        public String getTypeName() {
            String joinToString$default;
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(this.types, ", ", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
            return joinToString$default;
        }

        public boolean equals(Object obj) {
            return (obj instanceof CompoundTypeImpl) && Arrays.equals(this.types, ((CompoundTypeImpl) obj).types);
        }

        public String toString() {
            return getTypeName();
        }
    }

    @Override // kotlin.reflect.KParameter
    public KType getType() {
        KotlinType type = getDescriptor().getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return new KTypeImpl(type, new Function0() { // from class: kotlin.reflect.jvm.internal.KParameterImpl$type$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Type invoke() {
                ParameterDescriptor descriptor;
                Type compoundType;
                List slice;
                Type compoundType2;
                descriptor = KParameterImpl.this.getDescriptor();
                if ((descriptor instanceof ReceiverParameterDescriptor) && Intrinsics.areEqual(UtilKt.getInstanceReceiverParameter(KParameterImpl.this.getCallable().getDescriptor()), descriptor) && KParameterImpl.this.getCallable().getDescriptor().getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                    DeclarationDescriptor containingDeclaration = KParameterImpl.this.getCallable().getDescriptor().getContainingDeclaration();
                    Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class javaClass = UtilKt.toJavaClass((ClassDescriptor) containingDeclaration);
                    if (javaClass != null) {
                        return javaClass;
                    }
                    throw new KotlinReflectionInternalError("Cannot determine receiver Java type of inherited declaration: " + descriptor);
                }
                Caller caller = KParameterImpl.this.getCallable().getCaller();
                if (caller instanceof ValueClassAwareCaller) {
                    slice = CollectionsKt___CollectionsKt.slice(caller.getParameterTypes(), ((ValueClassAwareCaller) caller).getRealSlicesOfParameters(KParameterImpl.this.getIndex()));
                    KParameterImpl kParameterImpl = KParameterImpl.this;
                    Type[] typeArr = (Type[]) slice.toArray(new Type[0]);
                    compoundType2 = kParameterImpl.compoundType((Type[]) Arrays.copyOf(typeArr, typeArr.length));
                    return compoundType2;
                } else if (caller instanceof ValueClassAwareCaller.MultiFieldValueClassPrimaryConstructorCaller) {
                    KParameterImpl kParameterImpl2 = KParameterImpl.this;
                    Class[] clsArr = (Class[]) ((Collection) ((ValueClassAwareCaller.MultiFieldValueClassPrimaryConstructorCaller) caller).getOriginalParametersGroups().get(KParameterImpl.this.getIndex())).toArray(new Class[0]);
                    compoundType = kParameterImpl2.compoundType((Type[]) Arrays.copyOf(clsArr, clsArr.length));
                    return compoundType;
                } else {
                    return (Type) caller.getParameterTypes().get(KParameterImpl.this.getIndex());
                }
            }
        });
    }

    @Override // kotlin.reflect.KParameter
    public boolean isOptional() {
        ParameterDescriptor descriptor = getDescriptor();
        ValueParameterDescriptor valueParameterDescriptor = descriptor instanceof ValueParameterDescriptor ? (ValueParameterDescriptor) descriptor : null;
        if (valueParameterDescriptor != null) {
            return DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor);
        }
        return false;
    }

    @Override // kotlin.reflect.KParameter
    public boolean isVararg() {
        ParameterDescriptor descriptor = getDescriptor();
        return (descriptor instanceof ValueParameterDescriptor) && ((ValueParameterDescriptor) descriptor).getVarargElementType() != null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof KParameterImpl) {
            KParameterImpl kParameterImpl = (KParameterImpl) obj;
            if (Intrinsics.areEqual(this.callable, kParameterImpl.callable) && getIndex() == kParameterImpl.getIndex()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.callable.hashCode() * 31) + getIndex();
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderParameter(this);
    }
}
