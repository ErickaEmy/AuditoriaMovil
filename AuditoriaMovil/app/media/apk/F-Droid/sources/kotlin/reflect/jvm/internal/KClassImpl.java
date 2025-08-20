package kotlin.reflect.jvm.internal;

import ch.qos.logback.core.CoreConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMappingUtilsKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: KClassImpl.kt */
/* loaded from: classes2.dex */
public final class KClassImpl extends KDeclarationContainerImpl implements KClass, KClassifierImpl, KTypeParameterOwnerImpl {
    private final Lazy data;
    private final Class jClass;

    /* compiled from: KClassImpl.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            try {
                iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[KotlinClassHeader.Kind.SYNTHETIC_CLASS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[KotlinClassHeader.Kind.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[KotlinClassHeader.Kind.CLASS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final Lazy getData() {
        return this.data;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class getJClass() {
        return this.jClass;
    }

    /* compiled from: KClassImpl.kt */
    /* loaded from: classes2.dex */
    public final class Data extends KDeclarationContainerImpl.Data {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "annotations", "getAnnotations()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "simpleName", "getSimpleName()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "constructors", "getConstructors()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "supertypes", "getSupertypes()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        private final ReflectProperties.LazySoftVal allMembers$delegate;
        private final ReflectProperties.LazySoftVal allNonStaticMembers$delegate;
        private final ReflectProperties.LazySoftVal allStaticMembers$delegate;
        private final ReflectProperties.LazySoftVal annotations$delegate;
        private final ReflectProperties.LazySoftVal constructors$delegate;
        private final ReflectProperties.LazySoftVal declaredMembers$delegate;
        private final ReflectProperties.LazySoftVal declaredNonStaticMembers$delegate;
        private final ReflectProperties.LazySoftVal declaredStaticMembers$delegate;
        private final ReflectProperties.LazySoftVal descriptor$delegate;
        private final ReflectProperties.LazySoftVal inheritedNonStaticMembers$delegate;
        private final ReflectProperties.LazySoftVal inheritedStaticMembers$delegate;
        private final ReflectProperties.LazySoftVal nestedClasses$delegate;
        private final Lazy objectInstance$delegate;
        private final ReflectProperties.LazySoftVal qualifiedName$delegate;
        private final ReflectProperties.LazySoftVal sealedSubclasses$delegate;
        private final ReflectProperties.LazySoftVal simpleName$delegate;
        private final ReflectProperties.LazySoftVal supertypes$delegate;
        private final ReflectProperties.LazySoftVal typeParameters$delegate;

        public Data() {
            super();
            Lazy lazy;
            this.descriptor$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$descriptor$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final ClassDescriptor invoke() {
                    ClassId classId;
                    ClassDescriptor findClassAcrossModuleDependencies;
                    ClassDescriptor createSyntheticClassOrFail;
                    classId = KClassImpl.this.getClassId();
                    RuntimeModuleData moduleData = ((KClassImpl.Data) KClassImpl.this.getData().getValue()).getModuleData();
                    ModuleDescriptor module = moduleData.getModule();
                    if (classId.isLocal() && KClassImpl.this.getJClass().isAnnotationPresent(Metadata.class)) {
                        findClassAcrossModuleDependencies = moduleData.getDeserialization().deserializeClass(classId);
                    } else {
                        findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(module, classId);
                    }
                    if (findClassAcrossModuleDependencies == null) {
                        createSyntheticClassOrFail = KClassImpl.this.createSyntheticClassOrFail(classId, moduleData);
                        return createSyntheticClassOrFail;
                    }
                    return findClassAcrossModuleDependencies;
                }
            });
            this.annotations$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$annotations$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List invoke() {
                    return UtilKt.computeAnnotations(KClassImpl.Data.this.getDescriptor());
                }
            });
            this.simpleName$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$simpleName$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    ClassId classId;
                    String calculateLocalClassName;
                    if (KClassImpl.this.getJClass().isAnonymousClass()) {
                        return null;
                    }
                    classId = KClassImpl.this.getClassId();
                    if (classId.isLocal()) {
                        calculateLocalClassName = this.calculateLocalClassName(KClassImpl.this.getJClass());
                        return calculateLocalClassName;
                    }
                    String asString = classId.getShortClassName().asString();
                    Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
                    return asString;
                }
            });
            this.qualifiedName$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$qualifiedName$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    ClassId classId;
                    if (KClassImpl.this.getJClass().isAnonymousClass()) {
                        return null;
                    }
                    classId = KClassImpl.this.getClassId();
                    if (classId.isLocal()) {
                        return null;
                    }
                    return classId.asSingleFqName().asString();
                }
            });
            this.constructors$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$constructors$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List invoke() {
                    int collectionSizeOrDefault;
                    Collection<ConstructorDescriptor> constructorDescriptors = KClassImpl.this.getConstructorDescriptors();
                    KClassImpl kClassImpl = KClassImpl.this;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(constructorDescriptors, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (ConstructorDescriptor constructorDescriptor : constructorDescriptors) {
                        arrayList.add(new KFunctionImpl(kClassImpl, constructorDescriptor));
                    }
                    return arrayList;
                }
            });
            this.nestedClasses$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$nestedClasses$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List invoke() {
                    MemberScope unsubstitutedInnerClassesScope = KClassImpl.Data.this.getDescriptor().getUnsubstitutedInnerClassesScope();
                    Intrinsics.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "getUnsubstitutedInnerClassesScope(...)");
                    ArrayList<DeclarationDescriptor> arrayList = new ArrayList();
                    for (Object obj : ResolutionScope.DefaultImpls.getContributedDescriptors$default(unsubstitutedInnerClassesScope, null, null, 3, null)) {
                        if (!DescriptorUtils.isEnumEntry((DeclarationDescriptor) obj)) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (DeclarationDescriptor declarationDescriptor : arrayList) {
                        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
                        Class javaClass = classDescriptor != null ? UtilKt.toJavaClass(classDescriptor) : null;
                        KClassImpl kClassImpl = javaClass != null ? new KClassImpl(javaClass) : null;
                        if (kClassImpl != null) {
                            arrayList2.add(kClassImpl);
                        }
                    }
                    return arrayList2;
                }
            });
            lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$objectInstance$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Field declaredField;
                    ClassDescriptor descriptor = KClassImpl.Data.this.getDescriptor();
                    if (descriptor.getKind() != ClassKind.OBJECT) {
                        return null;
                    }
                    if (descriptor.isCompanionObject() && !CompanionObjectMappingUtilsKt.isMappedIntrinsicCompanionObject(CompanionObjectMapping.INSTANCE, descriptor)) {
                        declaredField = r2.getJClass().getEnclosingClass().getDeclaredField(descriptor.getName().asString());
                    } else {
                        declaredField = r2.getJClass().getDeclaredField("INSTANCE");
                    }
                    Object obj = declaredField.get(null);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl");
                    return obj;
                }
            });
            this.objectInstance$delegate = lazy;
            this.typeParameters$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$typeParameters$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List invoke() {
                    int collectionSizeOrDefault;
                    List<TypeParameterDescriptor> declaredTypeParameters = KClassImpl.Data.this.getDescriptor().getDeclaredTypeParameters();
                    Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "getDeclaredTypeParameters(...)");
                    KClassImpl kClassImpl = r2;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(declaredTypeParameters, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (TypeParameterDescriptor typeParameterDescriptor : declaredTypeParameters) {
                        Intrinsics.checkNotNull(typeParameterDescriptor);
                        arrayList.add(new KTypeParameterImpl(kClassImpl, typeParameterDescriptor));
                    }
                    return arrayList;
                }
            });
            this.supertypes$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$supertypes$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List invoke() {
                    Collection<KotlinType> mo2223getSupertypes = KClassImpl.Data.this.getDescriptor().getTypeConstructor().mo2223getSupertypes();
                    Intrinsics.checkNotNullExpressionValue(mo2223getSupertypes, "getSupertypes(...)");
                    ArrayList<KTypeImpl> arrayList = new ArrayList(mo2223getSupertypes.size());
                    final KClassImpl.Data data = KClassImpl.Data.this;
                    final KClassImpl kClassImpl = r2;
                    for (final KotlinType kotlinType : mo2223getSupertypes) {
                        Intrinsics.checkNotNull(kotlinType);
                        arrayList.add(new KTypeImpl(kotlinType, new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$supertypes$2$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Type invoke() {
                                int indexOf;
                                ClassifierDescriptor mo2222getDeclarationDescriptor = KotlinType.this.getConstructor().mo2222getDeclarationDescriptor();
                                if (!(mo2222getDeclarationDescriptor instanceof ClassDescriptor)) {
                                    throw new KotlinReflectionInternalError("Supertype not a class: " + mo2222getDeclarationDescriptor);
                                }
                                Class javaClass = UtilKt.toJavaClass((ClassDescriptor) mo2222getDeclarationDescriptor);
                                if (javaClass == null) {
                                    throw new KotlinReflectionInternalError("Unsupported superclass of " + data + ": " + mo2222getDeclarationDescriptor);
                                } else if (Intrinsics.areEqual(kClassImpl.getJClass().getSuperclass(), javaClass)) {
                                    Type genericSuperclass = kClassImpl.getJClass().getGenericSuperclass();
                                    Intrinsics.checkNotNull(genericSuperclass);
                                    return genericSuperclass;
                                } else {
                                    Class<?>[] interfaces = kClassImpl.getJClass().getInterfaces();
                                    Intrinsics.checkNotNullExpressionValue(interfaces, "getInterfaces(...)");
                                    indexOf = ArraysKt___ArraysKt.indexOf(interfaces, javaClass);
                                    if (indexOf < 0) {
                                        throw new KotlinReflectionInternalError("No superclass of " + data + " in Java reflection for " + mo2222getDeclarationDescriptor);
                                    }
                                    Type type = kClassImpl.getJClass().getGenericInterfaces()[indexOf];
                                    Intrinsics.checkNotNull(type);
                                    return type;
                                }
                            }
                        }));
                    }
                    if (!KotlinBuiltIns.isSpecialClassWithNoSupertypes(KClassImpl.Data.this.getDescriptor())) {
                        if (!arrayList.isEmpty()) {
                            for (KTypeImpl kTypeImpl : arrayList) {
                                ClassKind kind = DescriptorUtils.getClassDescriptorForType(kTypeImpl.getType()).getKind();
                                Intrinsics.checkNotNullExpressionValue(kind, "getKind(...)");
                                if (kind != ClassKind.INTERFACE && kind != ClassKind.ANNOTATION_CLASS) {
                                    break;
                                }
                            }
                        }
                        SimpleType anyType = DescriptorUtilsKt.getBuiltIns(KClassImpl.Data.this.getDescriptor()).getAnyType();
                        Intrinsics.checkNotNullExpressionValue(anyType, "getAnyType(...)");
                        arrayList.add(new KTypeImpl(anyType, new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$supertypes$2.3
                            @Override // kotlin.jvm.functions.Function0
                            public final Type invoke() {
                                return Object.class;
                            }
                        }));
                    }
                    return CollectionsKt.compact(arrayList);
                }
            });
            this.sealedSubclasses$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$sealedSubclasses$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List invoke() {
                    Collection<ClassDescriptor> sealedSubclasses = KClassImpl.Data.this.getDescriptor().getSealedSubclasses();
                    Intrinsics.checkNotNullExpressionValue(sealedSubclasses, "getSealedSubclasses(...)");
                    ArrayList arrayList = new ArrayList();
                    for (ClassDescriptor classDescriptor : sealedSubclasses) {
                        Intrinsics.checkNotNull(classDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        Class javaClass = UtilKt.toJavaClass(classDescriptor);
                        KClassImpl kClassImpl = javaClass != null ? new KClassImpl(javaClass) : null;
                        if (kClassImpl != null) {
                            arrayList.add(kClassImpl);
                        }
                    }
                    return arrayList;
                }
            });
            this.declaredNonStaticMembers$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$declaredNonStaticMembers$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Collection invoke() {
                    KClassImpl kClassImpl = KClassImpl.this;
                    return kClassImpl.getMembers(kClassImpl.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
                }
            });
            this.declaredStaticMembers$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$declaredStaticMembers$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Collection invoke() {
                    KClassImpl kClassImpl = KClassImpl.this;
                    return kClassImpl.getMembers(kClassImpl.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
                }
            });
            this.inheritedNonStaticMembers$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$inheritedNonStaticMembers$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Collection invoke() {
                    KClassImpl kClassImpl = KClassImpl.this;
                    return kClassImpl.getMembers(kClassImpl.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
                }
            });
            this.inheritedStaticMembers$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$inheritedStaticMembers$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Collection invoke() {
                    KClassImpl kClassImpl = KClassImpl.this;
                    return kClassImpl.getMembers(kClassImpl.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
                }
            });
            this.allNonStaticMembers$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$allNonStaticMembers$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List invoke() {
                    Collection inheritedNonStaticMembers;
                    List plus;
                    Collection declaredNonStaticMembers = KClassImpl.Data.this.getDeclaredNonStaticMembers();
                    inheritedNonStaticMembers = KClassImpl.Data.this.getInheritedNonStaticMembers();
                    plus = CollectionsKt___CollectionsKt.plus(declaredNonStaticMembers, (Iterable) inheritedNonStaticMembers);
                    return plus;
                }
            });
            this.allStaticMembers$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$allStaticMembers$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List invoke() {
                    Collection declaredStaticMembers;
                    Collection inheritedStaticMembers;
                    List plus;
                    declaredStaticMembers = KClassImpl.Data.this.getDeclaredStaticMembers();
                    inheritedStaticMembers = KClassImpl.Data.this.getInheritedStaticMembers();
                    plus = CollectionsKt___CollectionsKt.plus(declaredStaticMembers, (Iterable) inheritedStaticMembers);
                    return plus;
                }
            });
            this.declaredMembers$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$declaredMembers$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List invoke() {
                    Collection declaredStaticMembers;
                    List plus;
                    Collection declaredNonStaticMembers = KClassImpl.Data.this.getDeclaredNonStaticMembers();
                    declaredStaticMembers = KClassImpl.Data.this.getDeclaredStaticMembers();
                    plus = CollectionsKt___CollectionsKt.plus(declaredNonStaticMembers, (Iterable) declaredStaticMembers);
                    return plus;
                }
            });
            this.allMembers$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$allMembers$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List invoke() {
                    List plus;
                    plus = CollectionsKt___CollectionsKt.plus(KClassImpl.Data.this.getAllNonStaticMembers(), (Iterable) KClassImpl.Data.this.getAllStaticMembers());
                    return plus;
                }
            });
        }

        public final ClassDescriptor getDescriptor() {
            Object value = this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (ClassDescriptor) value;
        }

        public final String getSimpleName() {
            return (String) this.simpleName$delegate.getValue(this, $$delegatedProperties[2]);
        }

        public final String getQualifiedName() {
            return (String) this.qualifiedName$delegate.getValue(this, $$delegatedProperties[3]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String calculateLocalClassName(Class cls) {
            String substringAfter$default;
            String substringAfter$default2;
            String substringAfter$default3;
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                Intrinsics.checkNotNull(simpleName);
                substringAfter$default3 = StringsKt__StringsKt.substringAfter$default(simpleName, enclosingMethod.getName() + CoreConstants.DOLLAR, (String) null, 2, (Object) null);
                return substringAfter$default3;
            }
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                Intrinsics.checkNotNull(simpleName);
                substringAfter$default2 = StringsKt__StringsKt.substringAfter$default(simpleName, enclosingConstructor.getName() + CoreConstants.DOLLAR, (String) null, 2, (Object) null);
                return substringAfter$default2;
            }
            Intrinsics.checkNotNull(simpleName);
            substringAfter$default = StringsKt__StringsKt.substringAfter$default(simpleName, (char) CoreConstants.DOLLAR, (String) null, 2, (Object) null);
            return substringAfter$default;
        }

        public final Collection getConstructors() {
            Object value = this.constructors$delegate.getValue(this, $$delegatedProperties[4]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        public final Collection getDeclaredNonStaticMembers() {
            Object value = this.declaredNonStaticMembers$delegate.getValue(this, $$delegatedProperties[9]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection getDeclaredStaticMembers() {
            Object value = this.declaredStaticMembers$delegate.getValue(this, $$delegatedProperties[10]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection getInheritedNonStaticMembers() {
            Object value = this.inheritedNonStaticMembers$delegate.getValue(this, $$delegatedProperties[11]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection getInheritedStaticMembers() {
            Object value = this.inheritedStaticMembers$delegate.getValue(this, $$delegatedProperties[12]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        public final Collection getAllNonStaticMembers() {
            Object value = this.allNonStaticMembers$delegate.getValue(this, $$delegatedProperties[13]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        public final Collection getAllStaticMembers() {
            Object value = this.allStaticMembers$delegate.getValue(this, $$delegatedProperties[14]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }
    }

    public KClassImpl(Class jClass) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.jClass = jClass;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$data$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KClassImpl.Data invoke() {
                return new KClassImpl.Data();
            }
        });
        this.data = lazy;
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public ClassDescriptor getDescriptor() {
        return ((Data) this.data.getValue()).getDescriptor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassId getClassId() {
        return RuntimeTypeMapper.INSTANCE.mapJvmClassToKotlinClassId(getJClass());
    }

    public final MemberScope getMemberScope$kotlin_reflection() {
        return getDescriptor().getDefaultType().getMemberScope();
    }

    public final MemberScope getStaticScope$kotlin_reflection() {
        MemberScope staticScope = getDescriptor().getStaticScope();
        Intrinsics.checkNotNullExpressionValue(staticScope, "getStaticScope(...)");
        return staticScope;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection getConstructorDescriptors() {
        List emptyList;
        ClassDescriptor descriptor = getDescriptor();
        if (descriptor.getKind() == ClassKind.INTERFACE || descriptor.getKind() == ClassKind.OBJECT) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        Collection constructors = descriptor.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "getConstructors(...)");
        return constructors;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection getProperties(Name name) {
        List plus;
        Intrinsics.checkNotNullParameter(name, "name");
        MemberScope memberScope$kotlin_reflection = getMemberScope$kotlin_reflection();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        plus = CollectionsKt___CollectionsKt.plus(memberScope$kotlin_reflection.getContributedVariables(name, noLookupLocation), (Iterable) getStaticScope$kotlin_reflection().getContributedVariables(name, noLookupLocation));
        return plus;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection getFunctions(Name name) {
        List plus;
        Intrinsics.checkNotNullParameter(name, "name");
        MemberScope memberScope$kotlin_reflection = getMemberScope$kotlin_reflection();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        plus = CollectionsKt___CollectionsKt.plus(memberScope$kotlin_reflection.getContributedFunctions(name, noLookupLocation), (Iterable) getStaticScope$kotlin_reflection().getContributedFunctions(name, noLookupLocation));
        return plus;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public PropertyDescriptor getLocalProperty(int i) {
        Class<?> declaringClass;
        if (Intrinsics.areEqual(getJClass().getSimpleName(), "DefaultImpls") && (declaringClass = getJClass().getDeclaringClass()) != null && declaringClass.isInterface()) {
            KClass kotlinClass = JvmClassMappingKt.getKotlinClass(declaringClass);
            Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            return ((KClassImpl) kotlinClass).getLocalProperty(i);
        }
        ClassDescriptor descriptor = getDescriptor();
        DeserializedClassDescriptor deserializedClassDescriptor = descriptor instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) descriptor : null;
        if (deserializedClassDescriptor != null) {
            ProtoBuf$Class classProto = deserializedClassDescriptor.getClassProto();
            GeneratedMessageLite.GeneratedExtension classLocalVariable = JvmProtoBuf.classLocalVariable;
            Intrinsics.checkNotNullExpressionValue(classLocalVariable, "classLocalVariable");
            ProtoBuf$Property protoBuf$Property = (ProtoBuf$Property) ProtoBufUtilKt.getExtensionOrNull(classProto, classLocalVariable, i);
            if (protoBuf$Property != null) {
                return (PropertyDescriptor) UtilKt.deserializeToDescriptor(getJClass(), protoBuf$Property, deserializedClassDescriptor.getC().getNameResolver(), deserializedClassDescriptor.getC().getTypeTable(), deserializedClassDescriptor.getMetadataVersion(), KClassImpl$getLocalProperty$2$1$1.INSTANCE);
            }
            return null;
        }
        return null;
    }

    @Override // kotlin.reflect.KClass
    public String getSimpleName() {
        return ((Data) this.data.getValue()).getSimpleName();
    }

    @Override // kotlin.reflect.KClass
    public String getQualifiedName() {
        return ((Data) this.data.getValue()).getQualifiedName();
    }

    public Collection getConstructors() {
        return ((Data) this.data.getValue()).getConstructors();
    }

    public boolean equals(Object obj) {
        return (obj instanceof KClassImpl) && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) obj));
    }

    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    public String toString() {
        String str;
        String replace$default;
        StringBuilder sb = new StringBuilder();
        sb.append("class ");
        ClassId classId = getClassId();
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName, "getPackageFqName(...)");
        if (packageFqName.isRoot()) {
            str = "";
        } else {
            str = packageFqName.asString() + CoreConstants.DOT;
        }
        String asString = classId.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        replace$default = StringsKt__StringsJVMKt.replace$default(asString, (char) CoreConstants.DOT, (char) CoreConstants.DOLLAR, false, 4, (Object) null);
        sb.append(str + replace$default);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassDescriptor createSyntheticClassOrFail(ClassId classId, RuntimeModuleData runtimeModuleData) {
        KotlinClassHeader classHeader;
        if (getJClass().isSynthetic()) {
            return createSyntheticClass(classId, runtimeModuleData);
        }
        ReflectKotlinClass create = ReflectKotlinClass.Factory.create(getJClass());
        KotlinClassHeader.Kind kind = (create == null || (classHeader = create.getClassHeader()) == null) ? null : classHeader.getKind();
        switch (kind == null ? -1 : WhenMappings.$EnumSwitchMapping$0[kind.ordinal()]) {
            case -1:
            case 6:
                throw new KotlinReflectionInternalError("Unresolved class: " + getJClass() + " (kind = " + kind + CoreConstants.RIGHT_PARENTHESIS_CHAR);
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
            case 2:
            case 3:
            case 4:
                return createSyntheticClass(classId, runtimeModuleData);
            case 5:
                throw new KotlinReflectionInternalError("Unknown class: " + getJClass() + " (kind = " + kind + CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
    }

    private final ClassDescriptor createSyntheticClass(ClassId classId, RuntimeModuleData runtimeModuleData) {
        List listOf;
        Set emptySet;
        ModuleDescriptor module = runtimeModuleData.getModule();
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName, "getPackageFqName(...)");
        EmptyPackageFragmentDescriptor emptyPackageFragmentDescriptor = new EmptyPackageFragmentDescriptor(module, packageFqName);
        Name shortClassName = classId.getShortClassName();
        Modality modality = Modality.FINAL;
        ClassKind classKind = ClassKind.CLASS;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(runtimeModuleData.getModule().getBuiltIns().getAny().getDefaultType());
        final ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl(emptyPackageFragmentDescriptor, shortClassName, modality, classKind, listOf, SourceElement.NO_SOURCE, false, runtimeModuleData.getDeserialization().getStorageManager());
        final StorageManager storageManager = runtimeModuleData.getDeserialization().getStorageManager();
        GivenFunctionsMemberScope givenFunctionsMemberScope = new GivenFunctionsMemberScope(classDescriptorImpl, storageManager) { // from class: kotlin.reflect.jvm.internal.KClassImpl$createSyntheticClass$1$1
            @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
            protected List computeDeclaredFunctions() {
                List emptyList;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
        };
        emptySet = SetsKt__SetsKt.emptySet();
        classDescriptorImpl.initialize(givenFunctionsMemberScope, emptySet, null);
        return classDescriptorImpl;
    }
}
