package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
/* compiled from: TypeTable.kt */
/* loaded from: classes2.dex */
public final class TypeTable {
    private final List types;

    public TypeTable(ProtoBuf$TypeTable typeTable) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        List typeList = typeTable.getTypeList();
        if (typeTable.hasFirstNullable()) {
            int firstNullable = typeTable.getFirstNullable();
            List typeList2 = typeTable.getTypeList();
            Intrinsics.checkNotNullExpressionValue(typeList2, "getTypeList(...)");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(typeList2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            int i = 0;
            for (Object obj : typeList2) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) obj;
                if (i >= firstNullable) {
                    protoBuf$Type = protoBuf$Type.toBuilder().setNullable(true).build();
                }
                arrayList.add(protoBuf$Type);
                i = i2;
            }
            typeList = arrayList;
        }
        Intrinsics.checkNotNullExpressionValue(typeList, "run(...)");
        this.types = typeList;
    }

    public final ProtoBuf$Type get(int i) {
        return (ProtoBuf$Type) this.types.get(i);
    }
}
