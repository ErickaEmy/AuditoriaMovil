package kotlin.reflect.jvm.internal;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.action.Action;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.text.StringsKt__StringsJVMKt;
/* compiled from: KPackageImpl.kt */
/* loaded from: classes2.dex */
public final class KPackageImpl extends KDeclarationContainerImpl {
    private final Lazy data;
    private final Class jClass;

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class getJClass() {
        return this.jClass;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KPackageImpl.kt */
    /* loaded from: classes2.dex */
    public final class Data extends KDeclarationContainerImpl.Data {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), Action.SCOPE_ATTRIBUTE, "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "members", "getMembers()Ljava/util/Collection;"))};
        private final ReflectProperties.LazySoftVal kotlinClass$delegate;
        private final ReflectProperties.LazySoftVal members$delegate;
        private final Lazy metadata$delegate;
        private final Lazy multifileFacade$delegate;
        private final ReflectProperties.LazySoftVal scope$delegate;

        public Data() {
            super();
            Lazy lazy;
            Lazy lazy2;
            this.kotlinClass$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$kotlinClass$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final ReflectKotlinClass invoke() {
                    return ReflectKotlinClass.Factory.create(KPackageImpl.this.getJClass());
                }
            });
            this.scope$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$scope$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final MemberScope invoke() {
                    ReflectKotlinClass kotlinClass;
                    kotlinClass = KPackageImpl.Data.this.getKotlinClass();
                    if (kotlinClass != null) {
                        return KPackageImpl.Data.this.getModuleData().getPackagePartScopeCache().getPackagePartScope(kotlinClass);
                    }
                    return MemberScope.Empty.INSTANCE;
                }
            });
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
            lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$multifileFacade$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Class invoke() {
                    ReflectKotlinClass kotlinClass;
                    String replace$default;
                    KotlinClassHeader classHeader;
                    kotlinClass = KPackageImpl.Data.this.getKotlinClass();
                    String multifileClassName = (kotlinClass == null || (classHeader = kotlinClass.getClassHeader()) == null) ? null : classHeader.getMultifileClassName();
                    if (multifileClassName == null || multifileClassName.length() <= 0) {
                        return null;
                    }
                    ClassLoader classLoader = r2.getJClass().getClassLoader();
                    replace$default = StringsKt__StringsJVMKt.replace$default(multifileClassName, '/', (char) CoreConstants.DOT, false, 4, (Object) null);
                    return classLoader.loadClass(replace$default);
                }
            });
            this.multifileFacade$delegate = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$metadata$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Triple invoke() {
                    ReflectKotlinClass kotlinClass;
                    KotlinClassHeader classHeader;
                    kotlinClass = KPackageImpl.Data.this.getKotlinClass();
                    if (kotlinClass == null || (classHeader = kotlinClass.getClassHeader()) == null) {
                        return null;
                    }
                    String[] data = classHeader.getData();
                    String[] strings = classHeader.getStrings();
                    if (data == null || strings == null) {
                        return null;
                    }
                    Pair readPackageDataFrom = JvmProtoBufUtil.readPackageDataFrom(data, strings);
                    return new Triple((JvmNameResolver) readPackageDataFrom.component1(), (ProtoBuf$Package) readPackageDataFrom.component2(), classHeader.getMetadataVersion());
                }
            });
            this.metadata$delegate = lazy2;
            this.members$delegate = ReflectProperties.lazySoft(new Function0() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$members$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Collection invoke() {
                    return KPackageImpl.this.getMembers(this.getScope(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ReflectKotlinClass getKotlinClass() {
            return (ReflectKotlinClass) this.kotlinClass$delegate.getValue(this, $$delegatedProperties[0]);
        }

        public final MemberScope getScope() {
            Object value = this.scope$delegate.getValue(this, $$delegatedProperties[1]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (MemberScope) value;
        }

        public final Class getMultifileFacade() {
            return (Class) this.multifileFacade$delegate.getValue();
        }

        public final Triple getMetadata() {
            return (Triple) this.metadata$delegate.getValue();
        }
    }

    public KPackageImpl(Class jClass) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.jClass = jClass;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$data$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KPackageImpl.Data invoke() {
                return new KPackageImpl.Data();
            }
        });
        this.data = lazy;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    protected Class getMethodOwner() {
        Class multifileFacade = ((Data) this.data.getValue()).getMultifileFacade();
        return multifileFacade == null ? getJClass() : multifileFacade;
    }

    private final MemberScope getScope() {
        return ((Data) this.data.getValue()).getScope();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection getConstructorDescriptors() {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection getProperties(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getScope().getContributedVariables(name, NoLookupLocation.FROM_REFLECTION);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection getFunctions(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getScope().getContributedFunctions(name, NoLookupLocation.FROM_REFLECTION);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public PropertyDescriptor getLocalProperty(int i) {
        Triple metadata = ((Data) this.data.getValue()).getMetadata();
        if (metadata != null) {
            JvmNameResolver jvmNameResolver = (JvmNameResolver) metadata.component1();
            ProtoBuf$Package protoBuf$Package = (ProtoBuf$Package) metadata.component2();
            JvmMetadataVersion jvmMetadataVersion = (JvmMetadataVersion) metadata.component3();
            GeneratedMessageLite.GeneratedExtension packageLocalVariable = JvmProtoBuf.packageLocalVariable;
            Intrinsics.checkNotNullExpressionValue(packageLocalVariable, "packageLocalVariable");
            ProtoBuf$Property protoBuf$Property = (ProtoBuf$Property) ProtoBufUtilKt.getExtensionOrNull(protoBuf$Package, packageLocalVariable, i);
            if (protoBuf$Property != null) {
                Class jClass = getJClass();
                ProtoBuf$TypeTable typeTable = protoBuf$Package.getTypeTable();
                Intrinsics.checkNotNullExpressionValue(typeTable, "getTypeTable(...)");
                return (PropertyDescriptor) UtilKt.deserializeToDescriptor(jClass, protoBuf$Property, jvmNameResolver, new TypeTable(typeTable), jvmMetadataVersion, KPackageImpl$getLocalProperty$1$1$1.INSTANCE);
            }
            return null;
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof KPackageImpl) && Intrinsics.areEqual(getJClass(), ((KPackageImpl) obj).getJClass());
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        return "file class " + ReflectClassUtilKt.getClassId(getJClass()).asSingleFqName();
    }
}
