package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
/* compiled from: typeEnhancementUtils.kt */
/* loaded from: classes2.dex */
public abstract class TypeEnhancementUtilsKt {
    private static final Object select(Set set, Object obj, Object obj2, Object obj3, boolean z) {
        Object singleOrNull;
        Set plus;
        Set set2;
        if (z) {
            Object obj4 = set.contains(obj) ? obj : set.contains(obj2) ? obj2 : null;
            if (Intrinsics.areEqual(obj4, obj) && Intrinsics.areEqual(obj3, obj2)) {
                return null;
            }
            return obj3 == null ? obj4 : obj3;
        }
        if (obj3 != null) {
            plus = SetsKt___SetsKt.plus(set, obj3);
            set2 = CollectionsKt___CollectionsKt.toSet(plus);
            if (set2 != null) {
                set = set2;
            }
        }
        singleOrNull = CollectionsKt___CollectionsKt.singleOrNull(set);
        return singleOrNull;
    }

    private static final NullabilityQualifier select(Set set, NullabilityQualifier nullabilityQualifier, boolean z) {
        NullabilityQualifier nullabilityQualifier2 = NullabilityQualifier.FORCE_FLEXIBILITY;
        return nullabilityQualifier == nullabilityQualifier2 ? nullabilityQualifier2 : (NullabilityQualifier) select(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z);
    }

    private static final NullabilityQualifier getNullabilityForErrors(JavaTypeQualifiers javaTypeQualifiers) {
        if (javaTypeQualifiers.isNullabilityQualifierForWarning()) {
            return null;
        }
        return javaTypeQualifiers.getNullability();
    }

    public static final JavaTypeQualifiers computeQualifiersForOverride(JavaTypeQualifiers javaTypeQualifiers, Collection superQualifiers, boolean z, boolean z2, boolean z3) {
        Set set;
        NullabilityQualifier nullabilityQualifier;
        Set set2;
        boolean z4;
        Set set3;
        Intrinsics.checkNotNullParameter(javaTypeQualifiers, "<this>");
        Intrinsics.checkNotNullParameter(superQualifiers, "superQualifiers");
        Collection<JavaTypeQualifiers> collection = superQualifiers;
        ArrayList arrayList = new ArrayList();
        for (JavaTypeQualifiers javaTypeQualifiers2 : collection) {
            NullabilityQualifier nullabilityForErrors = getNullabilityForErrors(javaTypeQualifiers2);
            if (nullabilityForErrors != null) {
                arrayList.add(nullabilityForErrors);
            }
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        NullabilityQualifier select = select(set, getNullabilityForErrors(javaTypeQualifiers), z);
        if (select == null) {
            ArrayList arrayList2 = new ArrayList();
            for (JavaTypeQualifiers javaTypeQualifiers3 : collection) {
                NullabilityQualifier nullability = javaTypeQualifiers3.getNullability();
                if (nullability != null) {
                    arrayList2.add(nullability);
                }
            }
            set3 = CollectionsKt___CollectionsKt.toSet(arrayList2);
            nullabilityQualifier = select(set3, javaTypeQualifiers.getNullability(), z);
        } else {
            nullabilityQualifier = select;
        }
        ArrayList arrayList3 = new ArrayList();
        for (JavaTypeQualifiers javaTypeQualifiers4 : collection) {
            MutabilityQualifier mutability = javaTypeQualifiers4.getMutability();
            if (mutability != null) {
                arrayList3.add(mutability);
            }
        }
        set2 = CollectionsKt___CollectionsKt.toSet(arrayList3);
        MutabilityQualifier mutabilityQualifier = (MutabilityQualifier) select(set2, MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, javaTypeQualifiers.getMutability(), z);
        NullabilityQualifier nullabilityQualifier2 = null;
        if (nullabilityQualifier != null && !z3 && (!z2 || nullabilityQualifier != NullabilityQualifier.NULLABLE)) {
            nullabilityQualifier2 = nullabilityQualifier;
        }
        boolean z5 = false;
        if (nullabilityQualifier2 == NullabilityQualifier.NOT_NULL) {
            if (javaTypeQualifiers.getDefinitelyNotNull()) {
                z4 = true;
                if (nullabilityQualifier2 != null && select != nullabilityQualifier) {
                    z5 = true;
                }
                return new JavaTypeQualifiers(nullabilityQualifier2, mutabilityQualifier, z4, z5);
            } else if (!collection.isEmpty()) {
                for (JavaTypeQualifiers javaTypeQualifiers5 : collection) {
                    if (javaTypeQualifiers5.getDefinitelyNotNull()) {
                        z4 = true;
                        break;
                    }
                }
            }
        }
        z4 = false;
        if (nullabilityQualifier2 != null) {
            z5 = true;
        }
        return new JavaTypeQualifiers(nullabilityQualifier2, mutabilityQualifier, z4, z5);
    }

    public static final boolean hasEnhancedNullability(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker type) {
        Intrinsics.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        FqName ENHANCED_NULLABILITY_ANNOTATION = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        return typeSystemCommonBackendContext.hasAnnotation(type, ENHANCED_NULLABILITY_ANNOTATION);
    }
}
