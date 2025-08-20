package kotlin.reflect.jvm.internal.calls;

import ch.qos.logback.core.CoreConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
/* compiled from: ValueClassAwareCaller.kt */
/* loaded from: classes2.dex */
public abstract class ValueClassAwareCallerKt {
    public static final String toJvmDescriptor(ClassifierDescriptor classifierDescriptor) {
        Intrinsics.checkNotNullParameter(classifierDescriptor, "<this>");
        ClassId classId = DescriptorUtilsKt.getClassId(classifierDescriptor);
        Intrinsics.checkNotNull(classId);
        String asString = classId.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return ClassMapperLite.mapClass(asString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getValueClassUnboxMethods(SimpleType simpleType, CallableMemberDescriptor callableMemberDescriptor) {
        Method inlineClassUnboxMethod;
        List listOf;
        List mfvcUnboxMethods = getMfvcUnboxMethods(simpleType);
        if (mfvcUnboxMethods == null) {
            Class inlineClass = toInlineClass(simpleType);
            if (inlineClass == null || (inlineClassUnboxMethod = getInlineClassUnboxMethod(inlineClass, callableMemberDescriptor)) == null) {
                return null;
            }
            listOf = CollectionsKt__CollectionsJVMKt.listOf(inlineClassUnboxMethod);
            return listOf;
        }
        return mfvcUnboxMethods;
    }

    private static final List getMfvcUnboxMethods$getUnboxMethodNameSuffixes(SimpleType simpleType) {
        Collection listOf;
        int collectionSizeOrDefault;
        if (InlineClassesUtilsKt.needsMfvcFlattening(simpleType)) {
            ClassifierDescriptor mo2222getDeclarationDescriptor = simpleType.getConstructor().mo2222getDeclarationDescriptor();
            Intrinsics.checkNotNull(mo2222getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            MultiFieldValueClassRepresentation multiFieldValueClassRepresentation = DescriptorUtilsKt.getMultiFieldValueClassRepresentation((ClassDescriptor) mo2222getDeclarationDescriptor);
            Intrinsics.checkNotNull(multiFieldValueClassRepresentation);
            List<Pair> underlyingPropertyNamesToTypes = multiFieldValueClassRepresentation.getUnderlyingPropertyNamesToTypes();
            ArrayList arrayList = new ArrayList();
            for (Pair pair : underlyingPropertyNamesToTypes) {
                Name name = (Name) pair.component1();
                List mfvcUnboxMethods$getUnboxMethodNameSuffixes = getMfvcUnboxMethods$getUnboxMethodNameSuffixes((SimpleType) pair.component2());
                if (mfvcUnboxMethods$getUnboxMethodNameSuffixes == null) {
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(name.getIdentifier());
                } else {
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(mfvcUnboxMethods$getUnboxMethodNameSuffixes, 10);
                    listOf = new ArrayList(collectionSizeOrDefault);
                    Iterator it = mfvcUnboxMethods$getUnboxMethodNameSuffixes.iterator();
                    while (it.hasNext()) {
                        listOf.add(name.getIdentifier() + CoreConstants.DASH_CHAR + ((String) it.next()));
                    }
                }
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, listOf);
            }
            return arrayList;
        }
        return null;
    }

    public static final List getMfvcUnboxMethods(SimpleType type) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(type, "type");
        List mfvcUnboxMethods$getUnboxMethodNameSuffixes = getMfvcUnboxMethods$getUnboxMethodNameSuffixes(TypeSubstitutionKt.asSimpleType(type));
        if (mfvcUnboxMethods$getUnboxMethodNameSuffixes != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(mfvcUnboxMethods$getUnboxMethodNameSuffixes, 10);
            ArrayList<String> arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = mfvcUnboxMethods$getUnboxMethodNameSuffixes.iterator();
            while (it.hasNext()) {
                arrayList.add("unbox-impl-" + ((String) it.next()));
            }
            ClassifierDescriptor mo2222getDeclarationDescriptor = type.getConstructor().mo2222getDeclarationDescriptor();
            Intrinsics.checkNotNull(mo2222getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class javaClass = UtilKt.toJavaClass((ClassDescriptor) mo2222getDeclarationDescriptor);
            Intrinsics.checkNotNull(javaClass);
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            for (String str : arrayList) {
                arrayList2.add(javaClass.getDeclaredMethod(str, new Class[0]));
            }
            return arrayList2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkParametersSize(Caller caller, int i, CallableMemberDescriptor callableMemberDescriptor, boolean z) {
        if (CallerKt.getArity(caller) == i) {
            return;
        }
        throw new KotlinReflectionInternalError("Inconsistent number of parameters in the descriptor and Java reflection object: " + CallerKt.getArity(caller) + " != " + i + "\nCalling: " + callableMemberDescriptor + "\nParameter types: " + caller.getParameterTypes() + ")\nDefault: " + z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List makeKotlinParameterTypes(CallableMemberDescriptor callableMemberDescriptor, Function1 function1) {
        ArrayList arrayList = new ArrayList();
        ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
        KotlinType type = extensionReceiverParameter != null ? extensionReceiverParameter.getType() : null;
        if (type != null) {
            arrayList.add(type);
        } else if (callableMemberDescriptor instanceof ConstructorDescriptor) {
            ClassDescriptor constructedClass = ((ConstructorDescriptor) callableMemberDescriptor).getConstructedClass();
            Intrinsics.checkNotNullExpressionValue(constructedClass, "getConstructedClass(...)");
            if (constructedClass.isInner()) {
                DeclarationDescriptor containingDeclaration = constructedClass.getContainingDeclaration();
                Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                arrayList.add(((ClassDescriptor) containingDeclaration).getDefaultType());
            }
        } else {
            DeclarationDescriptor containingDeclaration2 = callableMemberDescriptor.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "getContainingDeclaration(...)");
            if ((containingDeclaration2 instanceof ClassDescriptor) && ((Boolean) function1.invoke(containingDeclaration2)).booleanValue()) {
                arrayList.add(((ClassDescriptor) containingDeclaration2).getDefaultType());
            }
        }
        List<ValueParameterDescriptor> valueParameters = callableMemberDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        for (ValueParameterDescriptor valueParameterDescriptor : valueParameters) {
            arrayList.add(valueParameterDescriptor.getType());
        }
        return arrayList;
    }

    public static /* synthetic */ Caller createValueClassAwareCallerIfNeeded$default(Caller caller, CallableMemberDescriptor callableMemberDescriptor, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return createValueClassAwareCallerIfNeeded(caller, callableMemberDescriptor, z);
    }

    public static final Caller createValueClassAwareCallerIfNeeded(Caller caller, CallableMemberDescriptor descriptor, boolean z) {
        Intrinsics.checkNotNullParameter(caller, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (!InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfValueClass(descriptor)) {
            List<ReceiverParameterDescriptor> contextReceiverParameters = descriptor.getContextReceiverParameters();
            Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "getContextReceiverParameters(...)");
            if (!(contextReceiverParameters instanceof Collection) || !contextReceiverParameters.isEmpty()) {
                for (ReceiverParameterDescriptor receiverParameterDescriptor : contextReceiverParameters) {
                    KotlinType type = receiverParameterDescriptor.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                    if (InlineClassesUtilsKt.isValueClassType(type)) {
                        break;
                    }
                }
            }
            List<ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            if (!(valueParameters instanceof Collection) || !valueParameters.isEmpty()) {
                for (ValueParameterDescriptor valueParameterDescriptor : valueParameters) {
                    KotlinType type2 = valueParameterDescriptor.getType();
                    Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                    if (InlineClassesUtilsKt.isValueClassType(type2)) {
                        break;
                    }
                }
            }
            KotlinType returnType = descriptor.getReturnType();
            if ((returnType == null || !InlineClassesUtilsKt.isInlineClassType(returnType)) && !hasValueClassReceiver(descriptor)) {
                return caller;
            }
        }
        return new ValueClassAwareCaller(descriptor, caller, z);
    }

    private static final boolean hasValueClassReceiver(CallableMemberDescriptor callableMemberDescriptor) {
        KotlinType expectedReceiverType = getExpectedReceiverType(callableMemberDescriptor);
        return expectedReceiverType != null && InlineClassesUtilsKt.isValueClassType(expectedReceiverType);
    }

    public static final Method getInlineClassUnboxMethod(Class cls, CallableMemberDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", new Class[0]);
            Intrinsics.checkNotNull(declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No unbox method found in inline class: " + cls + " (calling " + descriptor + CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method getBoxMethod(Class cls, CallableMemberDescriptor callableMemberDescriptor) {
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", getInlineClassUnboxMethod(cls, callableMemberDescriptor).getReturnType());
            Intrinsics.checkNotNull(declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No box method found in inline class: " + cls + " (calling " + callableMemberDescriptor + CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Class toInlineClass(KotlinType kotlinType) {
        Class inlineClass = toInlineClass(kotlinType.getConstructor().mo2222getDeclarationDescriptor());
        if (inlineClass == null) {
            return null;
        }
        if (TypeUtils.isNullableType(kotlinType)) {
            KotlinType unsubstitutedUnderlyingType = InlineClassesUtilsKt.unsubstitutedUnderlyingType(kotlinType);
            if (unsubstitutedUnderlyingType == null || TypeUtils.isNullableType(unsubstitutedUnderlyingType) || KotlinBuiltIns.isPrimitiveType(unsubstitutedUnderlyingType)) {
                return null;
            }
            return inlineClass;
        }
        return inlineClass;
    }

    public static final Class toInlineClass(DeclarationDescriptor declarationDescriptor) {
        if ((declarationDescriptor instanceof ClassDescriptor) && InlineClassesUtilsKt.isInlineClass(declarationDescriptor)) {
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            Class javaClass = UtilKt.toJavaClass(classDescriptor);
            if (javaClass != null) {
                return javaClass;
            }
            throw new KotlinReflectionInternalError("Class object for the class " + classDescriptor.getName() + " cannot be found (classId=" + DescriptorUtilsKt.getClassId((ClassifierDescriptor) declarationDescriptor) + CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
        return null;
    }

    private static final KotlinType getExpectedReceiverType(CallableMemberDescriptor callableMemberDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
        ReceiverParameterDescriptor dispatchReceiverParameter = callableMemberDescriptor.getDispatchReceiverParameter();
        if (extensionReceiverParameter != null) {
            return extensionReceiverParameter.getType();
        }
        if (dispatchReceiverParameter != null) {
            if (callableMemberDescriptor instanceof ConstructorDescriptor) {
                return dispatchReceiverParameter.getType();
            }
            DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
            ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
            if (classDescriptor != null) {
                return classDescriptor.getDefaultType();
            }
        }
        return null;
    }

    public static final Object coerceToExpectedReceiverType(Object obj, CallableMemberDescriptor descriptor) {
        KotlinType expectedReceiverType;
        Class inlineClass;
        Method inlineClassUnboxMethod;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return (((descriptor instanceof PropertyDescriptor) && InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass((VariableDescriptor) descriptor)) || (expectedReceiverType = getExpectedReceiverType(descriptor)) == null || (inlineClass = toInlineClass(expectedReceiverType)) == null || (inlineClassUnboxMethod = getInlineClassUnboxMethod(inlineClass, descriptor)) == null) ? obj : inlineClassUnboxMethod.invoke(obj, new Object[0]);
    }
}
