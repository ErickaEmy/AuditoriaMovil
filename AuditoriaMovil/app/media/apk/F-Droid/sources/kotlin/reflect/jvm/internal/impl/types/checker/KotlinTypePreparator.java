package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
/* compiled from: KotlinTypePreparator.kt */
/* loaded from: classes2.dex */
public abstract class KotlinTypePreparator extends AbstractTypePreparator {
    private final SimpleType transformToNewType(SimpleType simpleType) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        KotlinType type;
        TypeConstructor constructor = simpleType.getConstructor();
        IntersectionTypeConstructor intersectionTypeConstructor = null;
        r3 = null;
        UnwrappedType unwrappedType = null;
        if (!(constructor instanceof CapturedTypeConstructorImpl)) {
            if ((constructor instanceof IntersectionTypeConstructor) && simpleType.isMarkedNullable()) {
                IntersectionTypeConstructor intersectionTypeConstructor2 = (IntersectionTypeConstructor) constructor;
                Collection<KotlinType> mo2223getSupertypes = intersectionTypeConstructor2.mo2223getSupertypes();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(mo2223getSupertypes, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                boolean z = false;
                for (KotlinType kotlinType : mo2223getSupertypes) {
                    arrayList.add(TypeUtilsKt.makeNullable(kotlinType));
                    z = true;
                }
                if (z) {
                    KotlinType alternativeType = intersectionTypeConstructor2.getAlternativeType();
                    intersectionTypeConstructor = new IntersectionTypeConstructor(arrayList).setAlternative(alternativeType != null ? TypeUtilsKt.makeNullable(alternativeType) : null);
                }
                if (intersectionTypeConstructor != null) {
                    intersectionTypeConstructor2 = intersectionTypeConstructor;
                }
                return intersectionTypeConstructor2.createType();
            }
            return simpleType;
        }
        CapturedTypeConstructorImpl capturedTypeConstructorImpl = (CapturedTypeConstructorImpl) constructor;
        TypeProjection projection = capturedTypeConstructorImpl.getProjection();
        if (projection.getProjectionKind() != Variance.IN_VARIANCE) {
            projection = null;
        }
        if (projection != null && (type = projection.getType()) != null) {
            unwrappedType = type.unwrap();
        }
        UnwrappedType unwrappedType2 = unwrappedType;
        if (capturedTypeConstructorImpl.getNewTypeConstructor() == null) {
            TypeProjection projection2 = capturedTypeConstructorImpl.getProjection();
            Collection<KotlinType> mo2223getSupertypes2 = capturedTypeConstructorImpl.mo2223getSupertypes();
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(mo2223getSupertypes2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            for (KotlinType kotlinType2 : mo2223getSupertypes2) {
                arrayList2.add(kotlinType2.unwrap());
            }
            capturedTypeConstructorImpl.setNewTypeConstructor(new NewCapturedTypeConstructor(projection2, arrayList2, null, 4, null));
        }
        CaptureStatus captureStatus = CaptureStatus.FOR_SUBTYPING;
        NewCapturedTypeConstructor newTypeConstructor = capturedTypeConstructorImpl.getNewTypeConstructor();
        Intrinsics.checkNotNull(newTypeConstructor);
        return new NewCapturedType(captureStatus, newTypeConstructor, unwrappedType2, simpleType.getAttributes(), simpleType.isMarkedNullable(), false, 32, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator
    public UnwrappedType prepareType(KotlinTypeMarker type) {
        UnwrappedType flexibleType;
        Intrinsics.checkNotNullParameter(type, "type");
        if (!(type instanceof KotlinType)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        UnwrappedType unwrap = ((KotlinType) type).unwrap();
        if (unwrap instanceof SimpleType) {
            flexibleType = transformToNewType((SimpleType) unwrap);
        } else if (unwrap instanceof FlexibleType) {
            FlexibleType flexibleType2 = (FlexibleType) unwrap;
            SimpleType transformToNewType = transformToNewType(flexibleType2.getLowerBound());
            SimpleType transformToNewType2 = transformToNewType(flexibleType2.getUpperBound());
            flexibleType = (transformToNewType == flexibleType2.getLowerBound() && transformToNewType2 == flexibleType2.getUpperBound()) ? unwrap : KotlinTypeFactory.flexibleType(transformToNewType, transformToNewType2);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(flexibleType, unwrap, new KotlinTypePreparator$prepareType$1(this));
    }

    /* compiled from: KotlinTypePreparator.kt */
    /* loaded from: classes2.dex */
    public static final class Default extends KotlinTypePreparator {
        public static final Default INSTANCE = new Default();

        private Default() {
        }
    }
}
