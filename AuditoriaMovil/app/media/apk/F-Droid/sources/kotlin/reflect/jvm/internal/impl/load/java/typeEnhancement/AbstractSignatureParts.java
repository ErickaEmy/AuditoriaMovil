package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
/* compiled from: AbstractSignatureParts.kt */
/* loaded from: classes2.dex */
public abstract class AbstractSignatureParts {
    public abstract boolean forceWarning(Object obj, KotlinTypeMarker kotlinTypeMarker);

    public abstract AbstractAnnotationTypeQualifierResolver getAnnotationTypeQualifierResolver();

    public abstract Iterable getAnnotations(KotlinTypeMarker kotlinTypeMarker);

    public abstract Iterable getContainerAnnotations();

    public abstract AnnotationQualifierApplicabilityType getContainerApplicabilityType();

    public abstract JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers();

    public abstract boolean getContainerIsVarargParameter();

    public abstract boolean getEnableImprovementsInStrictMode();

    public abstract KotlinTypeMarker getEnhancedForWarnings(KotlinTypeMarker kotlinTypeMarker);

    public boolean getForceOnlyHeadTypeConstructor() {
        return false;
    }

    public abstract FqNameUnsafe getFqNameUnsafe(KotlinTypeMarker kotlinTypeMarker);

    public abstract boolean getSkipRawTypeArguments();

    public abstract TypeSystemContext getTypeSystem();

    public abstract boolean isArrayOrPrimitiveArray(KotlinTypeMarker kotlinTypeMarker);

    public abstract boolean isCovariant();

    public abstract boolean isEqual(KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2);

    public abstract boolean isFromJava(TypeParameterMarker typeParameterMarker);

    public abstract boolean isNotNullTypeParameterCompat(KotlinTypeMarker kotlinTypeMarker);

    private final NullabilityQualifier getNullabilityQualifier(KotlinTypeMarker kotlinTypeMarker) {
        TypeSystemContext typeSystem = getTypeSystem();
        if (typeSystem.isMarkedNullable(typeSystem.lowerBoundIfFlexible(kotlinTypeMarker))) {
            return NullabilityQualifier.NULLABLE;
        }
        if (typeSystem.isMarkedNullable(typeSystem.upperBoundIfFlexible(kotlinTypeMarker))) {
            return null;
        }
        return NullabilityQualifier.NOT_NULL;
    }

    private final JavaTypeQualifiers extractQualifiers(KotlinTypeMarker kotlinTypeMarker) {
        NullabilityQualifier nullabilityQualifier;
        NullabilityQualifier nullabilityQualifier2 = getNullabilityQualifier(kotlinTypeMarker);
        MutabilityQualifier mutabilityQualifier = null;
        if (nullabilityQualifier2 == null) {
            KotlinTypeMarker enhancedForWarnings = getEnhancedForWarnings(kotlinTypeMarker);
            nullabilityQualifier = enhancedForWarnings != null ? getNullabilityQualifier(enhancedForWarnings) : null;
        } else {
            nullabilityQualifier = nullabilityQualifier2;
        }
        TypeSystemContext typeSystem = getTypeSystem();
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        if (javaToKotlinClassMap.isReadOnly(getFqNameUnsafe(typeSystem.lowerBoundIfFlexible(kotlinTypeMarker)))) {
            mutabilityQualifier = MutabilityQualifier.READ_ONLY;
        } else if (javaToKotlinClassMap.isMutable(getFqNameUnsafe(typeSystem.upperBoundIfFlexible(kotlinTypeMarker)))) {
            mutabilityQualifier = MutabilityQualifier.MUTABLE;
        }
        return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, getTypeSystem().isDefinitelyNotNullType(kotlinTypeMarker) || isNotNullTypeParameterCompat(kotlinTypeMarker), nullabilityQualifier != nullabilityQualifier2);
    }

    private final JavaTypeQualifiers extractQualifiersFromAnnotations(final TypeAndDefaultQualifiers typeAndDefaultQualifiers) {
        Iterable emptyList;
        AnnotationQualifierApplicabilityType containerApplicabilityType;
        NullabilityQualifierWithMigrationStatus nullabilityQualifier;
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus;
        KotlinTypeMarker type;
        TypeConstructorMarker typeConstructor;
        if (typeAndDefaultQualifiers.getType() == null) {
            TypeSystemContext typeSystem = getTypeSystem();
            TypeParameterMarker typeParameterForArgument = typeAndDefaultQualifiers.getTypeParameterForArgument();
            if ((typeParameterForArgument != null ? typeSystem.getVariance(typeParameterForArgument) : null) == TypeVariance.IN) {
                return JavaTypeQualifiers.Companion.getNONE();
            }
        }
        boolean z = false;
        boolean z2 = typeAndDefaultQualifiers.getTypeParameterForArgument() == null;
        KotlinTypeMarker type2 = typeAndDefaultQualifiers.getType();
        if (type2 == null || (emptyList = getAnnotations(type2)) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        TypeSystemContext typeSystem2 = getTypeSystem();
        KotlinTypeMarker type3 = typeAndDefaultQualifiers.getType();
        TypeParameterMarker typeParameterClassifier = (type3 == null || (typeConstructor = typeSystem2.typeConstructor(type3)) == null) ? null : typeSystem2.getTypeParameterClassifier(typeConstructor);
        boolean z3 = getContainerApplicabilityType() == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
        if (z2) {
            if (!z3 && getEnableImprovementsInStrictMode() && (type = typeAndDefaultQualifiers.getType()) != null && isArrayOrPrimitiveArray(type)) {
                Iterable containerAnnotations = getContainerAnnotations();
                ArrayList arrayList = new ArrayList();
                for (Object obj : containerAnnotations) {
                    if (!getAnnotationTypeQualifierResolver().isTypeUseAnnotation(obj)) {
                        arrayList.add(obj);
                    }
                }
                emptyList = CollectionsKt___CollectionsKt.plus((Collection) arrayList, emptyList);
            } else {
                emptyList = CollectionsKt___CollectionsKt.plus(getContainerAnnotations(), emptyList);
            }
        }
        MutabilityQualifier extractMutability = getAnnotationTypeQualifierResolver().extractMutability(emptyList);
        NullabilityQualifierWithMigrationStatus extractNullability = getAnnotationTypeQualifierResolver().extractNullability(emptyList, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$extractQualifiersFromAnnotations$annotationsNullability$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object extractNullability2) {
                Intrinsics.checkNotNullParameter(extractNullability2, "$this$extractNullability");
                return Boolean.valueOf(AbstractSignatureParts.this.forceWarning(extractNullability2, typeAndDefaultQualifiers.getType()));
            }
        });
        if (extractNullability != null) {
            NullabilityQualifier qualifier = extractNullability.getQualifier();
            if (extractNullability.getQualifier() == NullabilityQualifier.NOT_NULL && typeParameterClassifier != null) {
                z = true;
            }
            return new JavaTypeQualifiers(qualifier, extractMutability, z, extractNullability.isForWarningOnly());
        }
        if (z2 || z3) {
            containerApplicabilityType = getContainerApplicabilityType();
        } else {
            containerApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_USE;
        }
        JavaTypeQualifiersByElementType defaultQualifiers = typeAndDefaultQualifiers.getDefaultQualifiers();
        JavaDefaultQualifiers javaDefaultQualifiers = defaultQualifiers != null ? defaultQualifiers.get(containerApplicabilityType) : null;
        NullabilityQualifierWithMigrationStatus boundsNullability = typeParameterClassifier != null ? getBoundsNullability(typeParameterClassifier) : null;
        if (boundsNullability == null || (nullabilityQualifier = NullabilityQualifierWithMigrationStatus.copy$default(boundsNullability, NullabilityQualifier.NOT_NULL, false, 2, null)) == null) {
            nullabilityQualifier = javaDefaultQualifiers != null ? javaDefaultQualifiers.getNullabilityQualifier() : null;
        }
        boolean z4 = (boundsNullability != null ? boundsNullability.getQualifier() : null) == NullabilityQualifier.NOT_NULL || !(typeParameterClassifier == null || javaDefaultQualifiers == null || !javaDefaultQualifiers.getDefinitelyNotNull());
        TypeParameterMarker typeParameterForArgument2 = typeAndDefaultQualifiers.getTypeParameterForArgument();
        if (typeParameterForArgument2 == null || (nullabilityQualifierWithMigrationStatus = getBoundsNullability(typeParameterForArgument2)) == null) {
            nullabilityQualifierWithMigrationStatus = null;
        } else if (nullabilityQualifierWithMigrationStatus.getQualifier() == NullabilityQualifier.NULLABLE) {
            nullabilityQualifierWithMigrationStatus = NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifierWithMigrationStatus, NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null);
        }
        NullabilityQualifierWithMigrationStatus mostSpecific = mostSpecific(nullabilityQualifierWithMigrationStatus, nullabilityQualifier);
        NullabilityQualifier qualifier2 = mostSpecific != null ? mostSpecific.getQualifier() : null;
        if (mostSpecific != null && mostSpecific.isForWarningOnly()) {
            z = true;
        }
        return new JavaTypeQualifiers(qualifier2, extractMutability, z4, z);
    }

    private final NullabilityQualifierWithMigrationStatus mostSpecific(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2) {
        return nullabilityQualifierWithMigrationStatus == null ? nullabilityQualifierWithMigrationStatus2 : nullabilityQualifierWithMigrationStatus2 == null ? nullabilityQualifierWithMigrationStatus : (!nullabilityQualifierWithMigrationStatus.isForWarningOnly() || nullabilityQualifierWithMigrationStatus2.isForWarningOnly()) ? (nullabilityQualifierWithMigrationStatus.isForWarningOnly() || !nullabilityQualifierWithMigrationStatus2.isForWarningOnly()) ? (nullabilityQualifierWithMigrationStatus.getQualifier().compareTo(nullabilityQualifierWithMigrationStatus2.getQualifier()) >= 0 && nullabilityQualifierWithMigrationStatus.getQualifier().compareTo(nullabilityQualifierWithMigrationStatus2.getQualifier()) > 0) ? nullabilityQualifierWithMigrationStatus : nullabilityQualifierWithMigrationStatus2 : nullabilityQualifierWithMigrationStatus : nullabilityQualifierWithMigrationStatus2;
    }

    private final NullabilityQualifierWithMigrationStatus getBoundsNullability(TypeParameterMarker typeParameterMarker) {
        List<KotlinTypeMarker> list;
        NullabilityQualifier nullabilityQualifier;
        TypeSystemContext typeSystem = getTypeSystem();
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = null;
        if (isFromJava(typeParameterMarker)) {
            List<KotlinTypeMarker> upperBounds = typeSystem.getUpperBounds(typeParameterMarker);
            boolean z = upperBounds instanceof Collection;
            if (!z || !upperBounds.isEmpty()) {
                Iterator it = upperBounds.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (!typeSystem.isError((KotlinTypeMarker) it.next())) {
                        if (!z || !upperBounds.isEmpty()) {
                            for (KotlinTypeMarker kotlinTypeMarker : upperBounds) {
                                if (getNullabilityQualifier(kotlinTypeMarker) != null) {
                                    list = upperBounds;
                                    break;
                                }
                            }
                        }
                        if (!z || !upperBounds.isEmpty()) {
                            for (KotlinTypeMarker kotlinTypeMarker2 : upperBounds) {
                                if (getEnhancedForWarnings(kotlinTypeMarker2) != null) {
                                    list = new ArrayList();
                                    for (KotlinTypeMarker kotlinTypeMarker3 : upperBounds) {
                                        KotlinTypeMarker enhancedForWarnings = getEnhancedForWarnings(kotlinTypeMarker3);
                                        if (enhancedForWarnings != null) {
                                            list.add(enhancedForWarnings);
                                        }
                                    }
                                    if (!(list instanceof Collection) || !list.isEmpty()) {
                                        for (KotlinTypeMarker kotlinTypeMarker4 : list) {
                                            if (!typeSystem.isNullableType(kotlinTypeMarker4)) {
                                                nullabilityQualifier = NullabilityQualifier.NOT_NULL;
                                                break;
                                            }
                                        }
                                    }
                                    nullabilityQualifier = NullabilityQualifier.NULLABLE;
                                    nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, list != upperBounds);
                                }
                            }
                        }
                    }
                }
            }
            return nullabilityQualifierWithMigrationStatus;
        }
        return null;
    }

    public final Function1 computeIndexedQualifiers(KotlinTypeMarker kotlinTypeMarker, Iterable overrides, final TypeEnhancementInfo typeEnhancementInfo, boolean z) {
        int collectionSizeOrDefault;
        int i;
        Object orNull;
        KotlinTypeMarker type;
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        List indexed = toIndexed(kotlinTypeMarker);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(overrides, 10);
        ArrayList<List> arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = overrides.iterator();
        while (it.hasNext()) {
            arrayList.add(toIndexed((KotlinTypeMarker) it.next()));
        }
        if (getForceOnlyHeadTypeConstructor()) {
            i = 1;
            break;
        }
        if (isCovariant() && (!(overrides instanceof Collection) || !((Collection) overrides).isEmpty())) {
            Iterator it2 = overrides.iterator();
            while (it2.hasNext()) {
                if (!isEqual(kotlinTypeMarker, (KotlinTypeMarker) it2.next())) {
                    i = 1;
                    break;
                }
            }
        }
        i = indexed.size();
        final JavaTypeQualifiers[] javaTypeQualifiersArr = new JavaTypeQualifiers[i];
        int i2 = 0;
        while (i2 < i) {
            JavaTypeQualifiers extractQualifiersFromAnnotations = extractQualifiersFromAnnotations((TypeAndDefaultQualifiers) indexed.get(i2));
            ArrayList arrayList2 = new ArrayList();
            for (List list : arrayList) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(list, i2);
                TypeAndDefaultQualifiers typeAndDefaultQualifiers = (TypeAndDefaultQualifiers) orNull;
                JavaTypeQualifiers extractQualifiers = (typeAndDefaultQualifiers == null || (type = typeAndDefaultQualifiers.getType()) == null) ? null : extractQualifiers(type);
                if (extractQualifiers != null) {
                    arrayList2.add(extractQualifiers);
                }
            }
            javaTypeQualifiersArr[i2] = TypeEnhancementUtilsKt.computeQualifiersForOverride(extractQualifiersFromAnnotations, arrayList2, i2 == 0 && isCovariant(), i2 == 0 && getContainerIsVarargParameter(), z);
            i2++;
        }
        return new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$computeIndexedQualifiers$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final JavaTypeQualifiers invoke(int i3) {
                int lastIndex;
                Map map;
                JavaTypeQualifiers javaTypeQualifiers;
                TypeEnhancementInfo typeEnhancementInfo2 = TypeEnhancementInfo.this;
                if (typeEnhancementInfo2 == null || (map = typeEnhancementInfo2.getMap()) == null || (javaTypeQualifiers = (JavaTypeQualifiers) map.get(Integer.valueOf(i3))) == null) {
                    JavaTypeQualifiers[] javaTypeQualifiersArr2 = javaTypeQualifiersArr;
                    if (i3 >= 0) {
                        lastIndex = ArraysKt___ArraysKt.getLastIndex(javaTypeQualifiersArr2);
                        if (i3 <= lastIndex) {
                            return javaTypeQualifiersArr2[i3];
                        }
                    }
                    return JavaTypeQualifiers.Companion.getNONE();
                }
                return javaTypeQualifiers;
            }
        };
    }

    private final void flattenTree(Object obj, List list, Function1 function1) {
        list.add(obj);
        Iterable<Object> iterable = (Iterable) function1.invoke(obj);
        if (iterable != null) {
            for (Object obj2 : iterable) {
                flattenTree(obj2, list, function1);
            }
        }
    }

    private final List flattenTree(Object obj, Function1 function1) {
        ArrayList arrayList = new ArrayList(1);
        flattenTree(obj, arrayList, function1);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(KotlinTypeMarker kotlinTypeMarker, JavaTypeQualifiersByElementType javaTypeQualifiersByElementType) {
        return getAnnotationTypeQualifierResolver().extractAndMergeDefaultQualifiers(javaTypeQualifiersByElementType, getAnnotations(kotlinTypeMarker));
    }

    private final List toIndexed(KotlinTypeMarker kotlinTypeMarker) {
        final TypeSystemContext typeSystem = getTypeSystem();
        return flattenTree(new TypeAndDefaultQualifiers(kotlinTypeMarker, extractAndMergeDefaultQualifiers(kotlinTypeMarker, getContainerDefaultTypeQualifiers()), null), new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$toIndexed$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Iterable invoke(AbstractSignatureParts.TypeAndDefaultQualifiers it) {
                KotlinTypeMarker type;
                TypeConstructorMarker typeConstructor;
                List parameters;
                int collectionSizeOrDefault;
                int collectionSizeOrDefault2;
                JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers;
                AbstractSignatureParts.TypeAndDefaultQualifiers typeAndDefaultQualifiers;
                KotlinTypeMarker type2;
                Intrinsics.checkNotNullParameter(it, "it");
                if ((AbstractSignatureParts.this.getSkipRawTypeArguments() && (type2 = it.getType()) != null && typeSystem.isRawType(type2)) || (type = it.getType()) == null || (typeConstructor = typeSystem.typeConstructor(type)) == null || (parameters = typeSystem.getParameters(typeConstructor)) == null) {
                    return null;
                }
                List arguments = typeSystem.getArguments(it.getType());
                TypeSystemContext typeSystemContext = typeSystem;
                AbstractSignatureParts abstractSignatureParts = AbstractSignatureParts.this;
                Iterator it2 = parameters.iterator();
                Iterator it3 = arguments.iterator();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(parameters, 10);
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arguments, 10);
                ArrayList arrayList = new ArrayList(Math.min(collectionSizeOrDefault, collectionSizeOrDefault2));
                while (it2.hasNext() && it3.hasNext()) {
                    Object next = it2.next();
                    TypeArgumentMarker typeArgumentMarker = (TypeArgumentMarker) it3.next();
                    TypeParameterMarker typeParameterMarker = (TypeParameterMarker) next;
                    if (typeSystemContext.isStarProjection(typeArgumentMarker)) {
                        typeAndDefaultQualifiers = new AbstractSignatureParts.TypeAndDefaultQualifiers(null, it.getDefaultQualifiers(), typeParameterMarker);
                    } else {
                        KotlinTypeMarker type3 = typeSystemContext.getType(typeArgumentMarker);
                        extractAndMergeDefaultQualifiers = abstractSignatureParts.extractAndMergeDefaultQualifiers(type3, it.getDefaultQualifiers());
                        typeAndDefaultQualifiers = new AbstractSignatureParts.TypeAndDefaultQualifiers(type3, extractAndMergeDefaultQualifiers, typeParameterMarker);
                    }
                    arrayList.add(typeAndDefaultQualifiers);
                }
                return arrayList;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractSignatureParts.kt */
    /* loaded from: classes2.dex */
    public static final class TypeAndDefaultQualifiers {
        private final JavaTypeQualifiersByElementType defaultQualifiers;
        private final KotlinTypeMarker type;
        private final TypeParameterMarker typeParameterForArgument;

        public final JavaTypeQualifiersByElementType getDefaultQualifiers() {
            return this.defaultQualifiers;
        }

        public final KotlinTypeMarker getType() {
            return this.type;
        }

        public final TypeParameterMarker getTypeParameterForArgument() {
            return this.typeParameterForArgument;
        }

        public TypeAndDefaultQualifiers(KotlinTypeMarker kotlinTypeMarker, JavaTypeQualifiersByElementType javaTypeQualifiersByElementType, TypeParameterMarker typeParameterMarker) {
            this.type = kotlinTypeMarker;
            this.defaultQualifiers = javaTypeQualifiersByElementType;
            this.typeParameterForArgument = typeParameterMarker;
        }
    }
}
