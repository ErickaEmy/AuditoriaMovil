package kotlin.reflect.jvm.internal;

import ch.qos.logback.core.CoreConstants;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
/* compiled from: KCallableImpl.kt */
/* loaded from: classes2.dex */
public abstract class KCallableImpl implements KCallable, KTypeParameterOwnerImpl {
    private final ReflectProperties.LazySoftVal _absentArguments;
    private final ReflectProperties.LazySoftVal _annotations;
    private final ReflectProperties.LazySoftVal _parameters;
    private final ReflectProperties.LazySoftVal _returnType;
    private final ReflectProperties.LazySoftVal _typeParameters;
    private final Lazy parametersNeedMFVCFlattening;

    public abstract Caller getCaller();

    public abstract KDeclarationContainerImpl getContainer();

    public abstract Caller getDefaultCaller();

    public abstract CallableMemberDescriptor getDescriptor();

    public abstract boolean isBound();

    public KCallableImpl() {
        Lazy lazy;
        ReflectProperties.LazySoftVal lazySoft = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_annotations$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List invoke() {
                return UtilKt.computeAnnotations(KCallableImpl.this.getDescriptor());
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft, "lazySoft(...)");
        this._annotations = lazySoft;
        ReflectProperties.LazySoftVal lazySoft2 = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ArrayList invoke() {
                int i;
                final CallableMemberDescriptor descriptor = KCallableImpl.this.getDescriptor();
                ArrayList arrayList = new ArrayList();
                final int i2 = 0;
                if (KCallableImpl.this.isBound()) {
                    i = 0;
                } else {
                    final ReceiverParameterDescriptor instanceReceiverParameter = UtilKt.getInstanceReceiverParameter(descriptor);
                    if (instanceReceiverParameter != null) {
                        arrayList.add(new KParameterImpl(KCallableImpl.this, 0, KParameter.Kind.INSTANCE, new Function0() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final ParameterDescriptor invoke() {
                                return ReceiverParameterDescriptor.this;
                            }
                        }));
                        i = 1;
                    } else {
                        i = 0;
                    }
                    final ReceiverParameterDescriptor extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
                    if (extensionReceiverParameter != null) {
                        arrayList.add(new KParameterImpl(KCallableImpl.this, i, KParameter.Kind.EXTENSION_RECEIVER, new Function0() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final ParameterDescriptor invoke() {
                                return ReceiverParameterDescriptor.this;
                            }
                        }));
                        i++;
                    }
                }
                int size = descriptor.getValueParameters().size();
                while (i2 < size) {
                    arrayList.add(new KParameterImpl(KCallableImpl.this, i, KParameter.Kind.VALUE, new Function0() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final ParameterDescriptor invoke() {
                            Object obj = CallableMemberDescriptor.this.getValueParameters().get(i2);
                            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                            return (ParameterDescriptor) obj;
                        }
                    }));
                    i2++;
                    i++;
                }
                if (KCallableImpl.this.isAnnotationConstructor() && (descriptor instanceof JavaCallableMemberDescriptor) && arrayList.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new Comparator() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1$invoke$$inlined$sortBy$1
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            int compareValues;
                            compareValues = ComparisonsKt__ComparisonsKt.compareValues(((KParameter) obj).getName(), ((KParameter) obj2).getName());
                            return compareValues;
                        }
                    });
                }
                arrayList.trimToSize();
                return arrayList;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft2, "lazySoft(...)");
        this._parameters = lazySoft2;
        ReflectProperties.LazySoftVal lazySoft3 = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_returnType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KTypeImpl invoke() {
                KotlinType returnType = KCallableImpl.this.getDescriptor().getReturnType();
                Intrinsics.checkNotNull(returnType);
                final KCallableImpl kCallableImpl = KCallableImpl.this;
                return new KTypeImpl(returnType, new Function0() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_returnType$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Type invoke() {
                        Type extractContinuationArgument;
                        extractContinuationArgument = KCallableImpl.this.extractContinuationArgument();
                        return extractContinuationArgument == null ? KCallableImpl.this.getCaller().getReturnType() : extractContinuationArgument;
                    }
                });
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft3, "lazySoft(...)");
        this._returnType = lazySoft3;
        ReflectProperties.LazySoftVal lazySoft4 = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_typeParameters$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List invoke() {
                int collectionSizeOrDefault;
                List<TypeParameterDescriptor> typeParameters = KCallableImpl.this.getDescriptor().getTypeParameters();
                Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
                KCallableImpl kCallableImpl = KCallableImpl.this;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(typeParameters, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (TypeParameterDescriptor typeParameterDescriptor : typeParameters) {
                    Intrinsics.checkNotNull(typeParameterDescriptor);
                    arrayList.add(new KTypeParameterImpl(kCallableImpl, typeParameterDescriptor));
                }
                return arrayList;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft4, "lazySoft(...)");
        this._typeParameters = lazySoft4;
        ReflectProperties.LazySoftVal lazySoft5 = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_absentArguments$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object[] invoke() {
                Lazy lazy2;
                int i;
                Object defaultEmptyArray;
                List<KParameter> parameters = KCallableImpl.this.getParameters();
                int size = parameters.size() + (KCallableImpl.this.isSuspend() ? 1 : 0);
                lazy2 = KCallableImpl.this.parametersNeedMFVCFlattening;
                if (((Boolean) lazy2.getValue()).booleanValue()) {
                    KCallableImpl kCallableImpl = KCallableImpl.this;
                    i = 0;
                    for (KParameter kParameter : parameters) {
                        i += kParameter.getKind() == KParameter.Kind.VALUE ? kCallableImpl.getParameterTypeSize(kParameter) : 0;
                    }
                } else if (parameters.isEmpty()) {
                    i = 0;
                } else {
                    i = 0;
                    for (KParameter kParameter2 : parameters) {
                        if (kParameter2.getKind() == KParameter.Kind.VALUE && (i = i + 1) < 0) {
                            CollectionsKt__CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                int i2 = (i + 31) / 32;
                Object[] objArr = new Object[size + i2 + 1];
                KCallableImpl kCallableImpl2 = KCallableImpl.this;
                for (KParameter kParameter3 : parameters) {
                    if (kParameter3.isOptional() && !UtilKt.isInlineClassType(kParameter3.getType())) {
                        objArr[kParameter3.getIndex()] = UtilKt.defaultPrimitiveValue(ReflectJvmMapping.getJavaType(kParameter3.getType()));
                    } else if (kParameter3.isVararg()) {
                        int index = kParameter3.getIndex();
                        defaultEmptyArray = kCallableImpl2.defaultEmptyArray(kParameter3.getType());
                        objArr[index] = defaultEmptyArray;
                    }
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    objArr[size + i3] = 0;
                }
                return objArr;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft5, "lazySoft(...)");
        this._absentArguments = lazySoft5;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$parametersNeedMFVCFlattening$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                List parameters = KCallableImpl.this.getParameters();
                boolean z = false;
                if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                    Iterator it = parameters.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (UtilKt.getNeedsMultiFieldValueClassFlattening(((KParameter) it.next()).getType())) {
                            z = true;
                            break;
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
        });
        this.parametersNeedMFVCFlattening = lazy;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List getAnnotations() {
        Object invoke = this._annotations.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return (List) invoke;
    }

    @Override // kotlin.reflect.KCallable
    public List getParameters() {
        Object invoke = this._parameters.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return (List) invoke;
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        Object invoke = this._returnType.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return (KType) invoke;
    }

    @Override // kotlin.reflect.KCallable
    public List getTypeParameters() {
        Object invoke = this._typeParameters.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return (List) invoke;
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        DescriptorVisibility visibility = getDescriptor().getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
        return UtilKt.toKVisibility(visibility);
    }

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        return getDescriptor().getModality() == Modality.FINAL;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        return getDescriptor().getModality() == Modality.OPEN;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        return getDescriptor().getModality() == Modality.ABSTRACT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isAnnotationConstructor() {
        return Intrinsics.areEqual(getName(), "<init>") && getContainer().getJClass().isAnnotation();
    }

    @Override // kotlin.reflect.KCallable
    public Object call(Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            return getCaller().call(args);
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }

    @Override // kotlin.reflect.KCallable
    public Object callBy(Map args) {
        Intrinsics.checkNotNullParameter(args, "args");
        return isAnnotationConstructor() ? callAnnotationConstructor(args) : callDefaultMethod$kotlin_reflection(args, null);
    }

    private final Object[] getAbsentArguments() {
        return (Object[]) ((Object[]) this._absentArguments.invoke()).clone();
    }

    public final Object callDefaultMethod$kotlin_reflection(Map args, Continuation continuation) {
        Intrinsics.checkNotNullParameter(args, "args");
        List<KParameter> parameters = getParameters();
        boolean z = false;
        if (!parameters.isEmpty()) {
            int size = parameters.size() + (isSuspend() ? 1 : 0);
            Object[] absentArguments = getAbsentArguments();
            if (isSuspend()) {
                absentArguments[parameters.size()] = continuation;
            }
            boolean booleanValue = ((Boolean) this.parametersNeedMFVCFlattening.getValue()).booleanValue();
            int i = 0;
            for (KParameter kParameter : parameters) {
                int parameterTypeSize = booleanValue ? getParameterTypeSize(kParameter) : 1;
                if (args.containsKey(kParameter)) {
                    absentArguments[kParameter.getIndex()] = args.get(kParameter);
                } else if (kParameter.isOptional()) {
                    if (booleanValue) {
                        int i2 = i + parameterTypeSize;
                        for (int i3 = i; i3 < i2; i3++) {
                            int i4 = (i3 / 32) + size;
                            Object obj = absentArguments[i4];
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                            absentArguments[i4] = Integer.valueOf(((Integer) obj).intValue() | (1 << (i3 % 32)));
                        }
                    } else {
                        int i5 = (i / 32) + size;
                        Object obj2 = absentArguments[i5];
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                        absentArguments[i5] = Integer.valueOf(((Integer) obj2).intValue() | (1 << (i % 32)));
                    }
                    z = true;
                } else if (!kParameter.isVararg()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
                }
                if (kParameter.getKind() == KParameter.Kind.VALUE) {
                    i += parameterTypeSize;
                }
            }
            if (!z) {
                try {
                    Caller caller = getCaller();
                    Object[] copyOf = Arrays.copyOf(absentArguments, size);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                    return caller.call(copyOf);
                } catch (IllegalAccessException e) {
                    throw new IllegalCallableAccessException(e);
                }
            }
            Caller defaultCaller = getDefaultCaller();
            if (defaultCaller == null) {
                throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
            }
            try {
                return defaultCaller.call(absentArguments);
            } catch (IllegalAccessException e2) {
                throw new IllegalCallableAccessException(e2);
            }
        }
        try {
            return getCaller().call(isSuspend() ? new Continuation[]{continuation} : new Continuation[0]);
        } catch (IllegalAccessException e3) {
            throw new IllegalCallableAccessException(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getParameterTypeSize(KParameter kParameter) {
        if (!((Boolean) this.parametersNeedMFVCFlattening.getValue()).booleanValue()) {
            throw new IllegalArgumentException("Check if parametersNeedMFVCFlattening is true before".toString());
        }
        if (UtilKt.getNeedsMultiFieldValueClassFlattening(kParameter.getType())) {
            KType type = kParameter.getType();
            Intrinsics.checkNotNull(type, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            List mfvcUnboxMethods = ValueClassAwareCallerKt.getMfvcUnboxMethods(TypeSubstitutionKt.asSimpleType(((KTypeImpl) type).getType()));
            Intrinsics.checkNotNull(mfvcUnboxMethods);
            return mfvcUnboxMethods.size();
        }
        return 1;
    }

    private final Object callAnnotationConstructor(Map map) {
        int collectionSizeOrDefault;
        Object defaultEmptyArray;
        List<KParameter> parameters = getParameters();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(parameters, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (KParameter kParameter : parameters) {
            if (map.containsKey(kParameter)) {
                defaultEmptyArray = map.get(kParameter);
                if (defaultEmptyArray == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + kParameter + CoreConstants.RIGHT_PARENTHESIS_CHAR);
                }
            } else if (kParameter.isOptional()) {
                defaultEmptyArray = null;
            } else if (!kParameter.isVararg()) {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
            } else {
                defaultEmptyArray = defaultEmptyArray(kParameter.getType());
            }
            arrayList.add(defaultEmptyArray);
        }
        Caller defaultCaller = getDefaultCaller();
        if (defaultCaller == null) {
            throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
        }
        try {
            return defaultCaller.call(arrayList.toArray(new Object[0]));
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object defaultEmptyArray(KType kType) {
        Class javaClass = JvmClassMappingKt.getJavaClass(KTypesJvm.getJvmErasure(kType));
        if (javaClass.isArray()) {
            Object newInstance = Array.newInstance(javaClass.getComponentType(), 0);
            Intrinsics.checkNotNullExpressionValue(newInstance, "run(...)");
            return newInstance;
        }
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + javaClass.getSimpleName() + ", because it is not an array type");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Type extractContinuationArgument() {
        Object lastOrNull;
        Object single;
        Type[] lowerBounds;
        Object first;
        if (isSuspend()) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull(getCaller().getParameterTypes());
            ParameterizedType parameterizedType = lastOrNull instanceof ParameterizedType ? (ParameterizedType) lastOrNull : null;
            if (Intrinsics.areEqual(parameterizedType != null ? parameterizedType.getRawType() : null, Continuation.class)) {
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "getActualTypeArguments(...)");
                single = ArraysKt___ArraysKt.single(actualTypeArguments);
                WildcardType wildcardType = single instanceof WildcardType ? (WildcardType) single : null;
                if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
                    return null;
                }
                first = ArraysKt___ArraysKt.first(lowerBounds);
                return (Type) first;
            }
            return null;
        }
        return null;
    }
}
