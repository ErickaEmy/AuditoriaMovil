package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
/* compiled from: ValueClassUtil.kt */
/* loaded from: classes2.dex */
public abstract class ValueClassUtilKt {
    public static final ValueClassRepresentation loadValueClassRepresentation(ProtoBuf$Class protoBuf$Class, NameResolver nameResolver, TypeTable typeTable, Function1 typeDeserializer, Function1 typeOfPublicProperty) {
        SimpleTypeMarker simpleTypeMarker;
        int collectionSizeOrDefault;
        List<Object> multiFieldValueClassUnderlyingTypeList;
        int collectionSizeOrDefault2;
        List zip;
        int collectionSizeOrDefault3;
        Intrinsics.checkNotNullParameter(protoBuf$Class, "<this>");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics.checkNotNullParameter(typeDeserializer, "typeDeserializer");
        Intrinsics.checkNotNullParameter(typeOfPublicProperty, "typeOfPublicProperty");
        if (protoBuf$Class.getMultiFieldValueClassUnderlyingNameCount() <= 0) {
            if (protoBuf$Class.hasInlineClassUnderlyingPropertyName()) {
                Name name = NameResolverUtilKt.getName(nameResolver, protoBuf$Class.getInlineClassUnderlyingPropertyName());
                ProtoBuf$Type inlineClassUnderlyingType = ProtoTypeTableUtilKt.inlineClassUnderlyingType(protoBuf$Class, typeTable);
                if ((inlineClassUnderlyingType == null || (simpleTypeMarker = (SimpleTypeMarker) typeDeserializer.invoke(inlineClassUnderlyingType)) == null) && (simpleTypeMarker = (SimpleTypeMarker) typeOfPublicProperty.invoke(name)) == null) {
                    throw new IllegalStateException(("cannot determine underlying type for value class " + NameResolverUtilKt.getName(nameResolver, protoBuf$Class.getFqName()) + " with property " + name).toString());
                }
                return new InlineClassRepresentation(name, simpleTypeMarker);
            }
            return null;
        }
        List<Integer> multiFieldValueClassUnderlyingNameList = protoBuf$Class.getMultiFieldValueClassUnderlyingNameList();
        Intrinsics.checkNotNullExpressionValue(multiFieldValueClassUnderlyingNameList, "getMultiFieldValueClassUnderlyingNameList(...)");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(multiFieldValueClassUnderlyingNameList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Integer num : multiFieldValueClassUnderlyingNameList) {
            Intrinsics.checkNotNull(num);
            arrayList.add(NameResolverUtilKt.getName(nameResolver, num.intValue()));
        }
        Pair pair = TuplesKt.to(Integer.valueOf(protoBuf$Class.getMultiFieldValueClassUnderlyingTypeIdCount()), Integer.valueOf(protoBuf$Class.getMultiFieldValueClassUnderlyingTypeCount()));
        if (Intrinsics.areEqual(pair, TuplesKt.to(Integer.valueOf(arrayList.size()), 0))) {
            List<Integer> multiFieldValueClassUnderlyingTypeIdList = protoBuf$Class.getMultiFieldValueClassUnderlyingTypeIdList();
            Intrinsics.checkNotNullExpressionValue(multiFieldValueClassUnderlyingTypeIdList, "getMultiFieldValueClassUnderlyingTypeIdList(...)");
            collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(multiFieldValueClassUnderlyingTypeIdList, 10);
            multiFieldValueClassUnderlyingTypeList = new ArrayList(collectionSizeOrDefault3);
            for (Integer num2 : multiFieldValueClassUnderlyingTypeIdList) {
                Intrinsics.checkNotNull(num2);
                multiFieldValueClassUnderlyingTypeList.add(typeTable.get(num2.intValue()));
            }
        } else if (!Intrinsics.areEqual(pair, TuplesKt.to(0, Integer.valueOf(arrayList.size())))) {
            throw new IllegalStateException(("class " + NameResolverUtilKt.getName(nameResolver, protoBuf$Class.getFqName()) + " has illegal multi-field value class representation").toString());
        } else {
            multiFieldValueClassUnderlyingTypeList = protoBuf$Class.getMultiFieldValueClassUnderlyingTypeList();
        }
        Intrinsics.checkNotNull(multiFieldValueClassUnderlyingTypeList);
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(multiFieldValueClassUnderlyingTypeList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        for (Object obj : multiFieldValueClassUnderlyingTypeList) {
            arrayList2.add(typeDeserializer.invoke(obj));
        }
        zip = CollectionsKt___CollectionsKt.zip(arrayList, arrayList2);
        return new MultiFieldValueClassRepresentation(zip);
    }
}
