package kotlin.reflect.jvm.internal.impl.descriptors;

import ch.qos.logback.core.CoreConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
/* compiled from: NotFoundClasses.kt */
/* loaded from: classes2.dex */
public final class NotFoundClasses {
    private final MemoizedFunctionToNotNull classes;
    private final ModuleDescriptor module;
    private final MemoizedFunctionToNotNull packageFragments;
    private final StorageManager storageManager;

    public NotFoundClasses(StorageManager storageManager, ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(module, "module");
        this.storageManager = storageManager;
        this.module = module;
        this.packageFragments = storageManager.createMemoizedFunction(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$packageFragments$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final PackageFragmentDescriptor invoke(FqName fqName) {
                ModuleDescriptor moduleDescriptor;
                Intrinsics.checkNotNullParameter(fqName, "fqName");
                moduleDescriptor = NotFoundClasses.this.module;
                return new EmptyPackageFragmentDescriptor(moduleDescriptor, fqName);
            }
        });
        this.classes = storageManager.createMemoizedFunction(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$classes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x0024, code lost:
                if (r1 != null) goto L7;
             */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor invoke(kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.ClassRequest r9) {
                /*
                    r8 = this;
                    java.lang.String r0 = "<name for destructuring parameter 0>"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                    kotlin.reflect.jvm.internal.impl.name.ClassId r0 = r9.component1()
                    java.util.List r9 = r9.component2()
                    boolean r1 = r0.isLocal()
                    if (r1 != 0) goto L68
                    kotlin.reflect.jvm.internal.impl.name.ClassId r1 = r0.getOuterClassId()
                    if (r1 == 0) goto L28
                    kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses r2 = kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.this
                    r3 = 1
                    java.util.List r3 = kotlin.collections.CollectionsKt.drop(r9, r3)
                    kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1 = r2.getClass(r1, r3)
                    if (r1 == 0) goto L28
                L26:
                    r4 = r1
                    goto L3e
                L28:
                    kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses r1 = kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.this
                    kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull r1 = kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.access$getPackageFragments$p(r1)
                    kotlin.reflect.jvm.internal.impl.name.FqName r2 = r0.getPackageFqName()
                    java.lang.String r3 = "getPackageFqName(...)"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                    java.lang.Object r1 = r1.invoke(r2)
                    kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor) r1
                    goto L26
                L3e:
                    boolean r6 = r0.isNestedClass()
                    kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$MockClassDescriptor r1 = new kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$MockClassDescriptor
                    kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses r2 = kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.this
                    kotlin.reflect.jvm.internal.impl.storage.StorageManager r3 = kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.access$getStorageManager$p(r2)
                    kotlin.reflect.jvm.internal.impl.name.Name r5 = r0.getShortClassName()
                    java.lang.String r0 = "getShortClassName(...)"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                    java.lang.Object r9 = kotlin.collections.CollectionsKt.firstOrNull(r9)
                    java.lang.Integer r9 = (java.lang.Integer) r9
                    if (r9 == 0) goto L61
                    int r9 = r9.intValue()
                L5f:
                    r7 = r9
                    goto L63
                L61:
                    r9 = 0
                    goto L5f
                L63:
                    r2 = r1
                    r2.<init>(r3, r4, r5, r6, r7)
                    return r1
                L68:
                    java.lang.UnsupportedOperationException r9 = new java.lang.UnsupportedOperationException
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "Unresolved local class: "
                    r1.append(r2)
                    r1.append(r0)
                    java.lang.String r0 = r1.toString()
                    r9.<init>(r0)
                    throw r9
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$classes$1.invoke(kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$ClassRequest):kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NotFoundClasses.kt */
    /* loaded from: classes2.dex */
    public static final class ClassRequest {
        private final ClassId classId;
        private final List typeParametersCount;

        public final ClassId component1() {
            return this.classId;
        }

        public final List component2() {
            return this.typeParametersCount;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ClassRequest) {
                ClassRequest classRequest = (ClassRequest) obj;
                return Intrinsics.areEqual(this.classId, classRequest.classId) && Intrinsics.areEqual(this.typeParametersCount, classRequest.typeParametersCount);
            }
            return false;
        }

        public int hashCode() {
            return (this.classId.hashCode() * 31) + this.typeParametersCount.hashCode();
        }

        public String toString() {
            return "ClassRequest(classId=" + this.classId + ", typeParametersCount=" + this.typeParametersCount + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public ClassRequest(ClassId classId, List typeParametersCount) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            Intrinsics.checkNotNullParameter(typeParametersCount, "typeParametersCount");
            this.classId = classId;
            this.typeParametersCount = typeParametersCount;
        }
    }

    /* compiled from: NotFoundClasses.kt */
    /* loaded from: classes2.dex */
    public static final class MockClassDescriptor extends ClassDescriptorBase {
        private final List declaredTypeParameters;
        private final boolean isInner;
        private final ClassTypeConstructorImpl typeConstructor;

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        /* renamed from: getCompanionObjectDescriptor */
        public ClassDescriptor mo2186getCompanionObjectDescriptor() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
        public List getDeclaredTypeParameters() {
            return this.declaredTypeParameters;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
        public ClassTypeConstructorImpl getTypeConstructor() {
            return this.typeConstructor;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        /* renamed from: getUnsubstitutedPrimaryConstructor */
        public ClassConstructorDescriptor mo2187getUnsubstitutedPrimaryConstructor() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public ValueClassRepresentation getValueClassRepresentation() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isActual() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isCompanionObject() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isData() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isExpect() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isExternal() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isFun() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isInline() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
        public boolean isInner() {
            return this.isInner;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isValue() {
            return false;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MockClassDescriptor(StorageManager storageManager, DeclarationDescriptor container, Name name, boolean z, int i) {
            super(storageManager, container, name, SourceElement.NO_SOURCE, false);
            IntRange until;
            int collectionSizeOrDefault;
            Set of;
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(name, "name");
            this.isInner = z;
            until = RangesKt___RangesKt.until(0, i);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                Annotations empty = Annotations.Companion.getEMPTY();
                Variance variance = Variance.INVARIANT;
                StringBuilder sb = new StringBuilder();
                sb.append('T');
                sb.append(nextInt);
                arrayList.add(TypeParameterDescriptorImpl.createWithDefaultBound(this, empty, false, variance, Name.identifier(sb.toString()), nextInt, storageManager));
            }
            this.declaredTypeParameters = arrayList;
            List computeConstructorTypeParameters = TypeParameterUtilsKt.computeConstructorTypeParameters(this);
            of = SetsKt__SetsJVMKt.setOf(DescriptorUtilsKt.getModule(this).getBuiltIns().getAnyType());
            this.typeConstructor = new ClassTypeConstructorImpl(this, computeConstructorTypeParameters, of, storageManager);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public ClassKind getKind() {
            return ClassKind.CLASS;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public Modality getModality() {
            return Modality.FINAL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public DescriptorVisibility getVisibility() {
            DescriptorVisibility PUBLIC = DescriptorVisibilities.PUBLIC;
            Intrinsics.checkNotNullExpressionValue(PUBLIC, "PUBLIC");
            return PUBLIC;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
        public Annotations getAnnotations() {
            return Annotations.Companion.getEMPTY();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
        public MemberScope.Empty getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return MemberScope.Empty.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public MemberScope.Empty getStaticScope() {
            return MemberScope.Empty.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public Collection getConstructors() {
            Set emptySet;
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public Collection getSealedSubclasses() {
            List emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }

        public String toString() {
            return "class " + getName() + " (not found)";
        }
    }

    public final ClassDescriptor getClass(ClassId classId, List typeParametersCount) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(typeParametersCount, "typeParametersCount");
        return (ClassDescriptor) this.classes.invoke(new ClassRequest(classId, typeParametersCount));
    }
}
