package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
/* compiled from: IntersectionType.kt */
/* loaded from: classes2.dex */
public abstract class IntersectionTypeKt {
    public static final UnwrappedType intersectTypes(List types) {
        Object single;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        SimpleType lowerBound;
        Intrinsics.checkNotNullParameter(types, "types");
        int size = types.size();
        if (size != 0) {
            if (size == 1) {
                single = CollectionsKt___CollectionsKt.single(types);
                return (UnwrappedType) single;
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(types, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = types.iterator();
            boolean z = false;
            boolean z2 = false;
            while (it.hasNext()) {
                UnwrappedType unwrappedType = (UnwrappedType) it.next();
                z = z || KotlinTypeKt.isError(unwrappedType);
                if (unwrappedType instanceof SimpleType) {
                    lowerBound = (SimpleType) unwrappedType;
                } else if (!(unwrappedType instanceof FlexibleType)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    if (DynamicTypesKt.isDynamic(unwrappedType)) {
                        return unwrappedType;
                    }
                    lowerBound = ((FlexibleType) unwrappedType).getLowerBound();
                    z2 = true;
                }
                arrayList.add(lowerBound);
            }
            if (z) {
                return ErrorUtils.createErrorType(ErrorTypeKind.INTERSECTION_OF_ERROR_TYPES, types.toString());
            }
            if (z2) {
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(types, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                Iterator it2 = types.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(FlexibleTypesKt.upperIfFlexible((UnwrappedType) it2.next()));
                }
                TypeIntersector typeIntersector = TypeIntersector.INSTANCE;
                return KotlinTypeFactory.flexibleType(typeIntersector.intersectTypes$descriptors(arrayList), typeIntersector.intersectTypes$descriptors(arrayList2));
            }
            return TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList);
        }
        throw new IllegalStateException("Expected some types".toString());
    }
}
