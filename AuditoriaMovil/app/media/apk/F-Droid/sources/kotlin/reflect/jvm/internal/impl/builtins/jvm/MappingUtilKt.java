package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
/* compiled from: mappingUtil.kt */
/* loaded from: classes2.dex */
public abstract class MappingUtilKt {
    public static final TypeConstructorSubstitution createMappedTypeParametersSubstitution(ClassDescriptor from, ClassDescriptor to) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List zip;
        Map map;
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        from.getDeclaredTypeParameters().size();
        to.getDeclaredTypeParameters().size();
        TypeConstructorSubstitution.Companion companion = TypeConstructorSubstitution.Companion;
        List<TypeParameterDescriptor> declaredTypeParameters = from.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "getDeclaredTypeParameters(...)");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(declaredTypeParameters, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (TypeParameterDescriptor typeParameterDescriptor : declaredTypeParameters) {
            arrayList.add(typeParameterDescriptor.getTypeConstructor());
        }
        List<TypeParameterDescriptor> declaredTypeParameters2 = to.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters2, "getDeclaredTypeParameters(...)");
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(declaredTypeParameters2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        for (TypeParameterDescriptor typeParameterDescriptor2 : declaredTypeParameters2) {
            SimpleType defaultType = typeParameterDescriptor2.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
            arrayList2.add(TypeUtilsKt.asTypeProjection(defaultType));
        }
        zip = CollectionsKt___CollectionsKt.zip(arrayList, arrayList2);
        map = MapsKt__MapsKt.toMap(zip);
        return TypeConstructorSubstitution.Companion.createByConstructorsMap$default(companion, map, false, 2, null);
    }
}
