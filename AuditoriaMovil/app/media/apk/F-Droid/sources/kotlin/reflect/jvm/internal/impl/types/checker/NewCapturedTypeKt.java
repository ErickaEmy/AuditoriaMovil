package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
/* compiled from: NewCapturedType.kt */
/* loaded from: classes2.dex */
public abstract class NewCapturedTypeKt {
    public static final SimpleType captureFromArguments(SimpleType type, CaptureStatus status) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(status, "status");
        List captureArguments = captureArguments(type, status);
        if (captureArguments != null) {
            return replaceArguments(type, captureArguments);
        }
        return null;
    }

    private static final SimpleType replaceArguments(UnwrappedType unwrappedType, List list) {
        return KotlinTypeFactory.simpleType$default(unwrappedType.getAttributes(), unwrappedType.getConstructor(), list, unwrappedType.isMarkedNullable(), null, 16, null);
    }

    private static final List captureArguments(UnwrappedType unwrappedType, CaptureStatus captureStatus) {
        List<Pair> zip;
        int collectionSizeOrDefault;
        if (unwrappedType.getArguments().size() != unwrappedType.getConstructor().getParameters().size()) {
            return null;
        }
        List<TypeProjection> arguments = unwrappedType.getArguments();
        if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
            for (TypeProjection typeProjection : arguments) {
                if (typeProjection.getProjectionKind() != Variance.INVARIANT) {
                    List parameters = unwrappedType.getConstructor().getParameters();
                    Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
                    zip = CollectionsKt___CollectionsKt.zip(arguments, parameters);
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(zip, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (Pair pair : zip) {
                        TypeProjection typeProjection2 = (TypeProjection) pair.component1();
                        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) pair.component2();
                        if (typeProjection2.getProjectionKind() != Variance.INVARIANT) {
                            UnwrappedType unwrap = (typeProjection2.isStarProjection() || typeProjection2.getProjectionKind() != Variance.IN_VARIANCE) ? null : typeProjection2.getType().unwrap();
                            Intrinsics.checkNotNull(typeParameterDescriptor);
                            typeProjection2 = TypeUtilsKt.asTypeProjection(new NewCapturedType(captureStatus, unwrap, typeProjection2, typeParameterDescriptor));
                        }
                        arrayList.add(typeProjection2);
                    }
                    TypeSubstitutor buildSubstitutor = TypeConstructorSubstitution.Companion.create(unwrappedType.getConstructor(), arrayList).buildSubstitutor();
                    int size = arguments.size();
                    for (int i = 0; i < size; i++) {
                        TypeProjection typeProjection3 = (TypeProjection) arguments.get(i);
                        TypeProjection typeProjection4 = (TypeProjection) arrayList.get(i);
                        if (typeProjection3.getProjectionKind() != Variance.INVARIANT) {
                            List<KotlinType> upperBounds = ((TypeParameterDescriptor) unwrappedType.getConstructor().getParameters().get(i)).getUpperBounds();
                            Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
                            ArrayList arrayList2 = new ArrayList();
                            for (KotlinType kotlinType : upperBounds) {
                                arrayList2.add(KotlinTypePreparator.Default.INSTANCE.prepareType((KotlinTypeMarker) buildSubstitutor.safeSubstitute(kotlinType, Variance.INVARIANT).unwrap()));
                            }
                            if (!typeProjection3.isStarProjection() && typeProjection3.getProjectionKind() == Variance.OUT_VARIANCE) {
                                arrayList2.add(KotlinTypePreparator.Default.INSTANCE.prepareType((KotlinTypeMarker) typeProjection3.getType().unwrap()));
                            }
                            KotlinType type = typeProjection4.getType();
                            Intrinsics.checkNotNull(type, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                            ((NewCapturedType) type).getConstructor().initializeSupertypes(arrayList2);
                        }
                    }
                    return arrayList;
                }
            }
        }
        return null;
    }
}
