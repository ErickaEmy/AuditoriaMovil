package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
/* compiled from: CompanionObjectMapping.kt */
/* loaded from: classes2.dex */
public final class CompanionObjectMapping {
    public static final CompanionObjectMapping INSTANCE = new CompanionObjectMapping();
    private static final Set classIds;

    private CompanionObjectMapping() {
    }

    public final Set allClassesWithIntrinsicCompanions() {
        return classIds;
    }

    public final Set getClassIds() {
        return classIds;
    }

    static {
        int collectionSizeOrDefault;
        List plus;
        List plus2;
        List<FqName> plus3;
        Set<PrimitiveType> set = PrimitiveType.NUMBER_TYPES;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(set, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (PrimitiveType primitiveType : set) {
            arrayList.add(StandardNames.getPrimitiveFqName(primitiveType));
        }
        FqName safe = StandardNames.FqNames.string.toSafe();
        Intrinsics.checkNotNullExpressionValue(safe, "toSafe(...)");
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Object) safe);
        FqName safe2 = StandardNames.FqNames._boolean.toSafe();
        Intrinsics.checkNotNullExpressionValue(safe2, "toSafe(...)");
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Object) safe2);
        FqName safe3 = StandardNames.FqNames._enum.toSafe();
        Intrinsics.checkNotNullExpressionValue(safe3, "toSafe(...)");
        plus3 = CollectionsKt___CollectionsKt.plus((Collection) plus2, (Object) safe3);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (FqName fqName : plus3) {
            linkedHashSet.add(ClassId.topLevel(fqName));
        }
        classIds = linkedHashSet;
    }
}
