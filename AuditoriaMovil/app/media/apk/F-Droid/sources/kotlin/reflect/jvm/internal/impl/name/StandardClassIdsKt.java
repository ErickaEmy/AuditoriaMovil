package kotlin.reflect.jvm.internal.impl.name;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
/* compiled from: StandardClassIds.kt */
/* loaded from: classes2.dex */
public abstract class StandardClassIdsKt {
    private static final FqName JAVA_LANG_ANNOTATION_PACKAGE;
    private static final FqName JAVA_LANG_PACKAGE;

    public static final /* synthetic */ ClassId access$annotationId(String str) {
        return annotationId(str);
    }

    public static final /* synthetic */ ClassId access$baseId(String str) {
        return baseId(str);
    }

    public static final /* synthetic */ ClassId access$collectionsId(String str) {
        return collectionsId(str);
    }

    public static final /* synthetic */ ClassId access$coroutinesId(String str) {
        return coroutinesId(str);
    }

    public static final /* synthetic */ ClassId access$enumsId(String str) {
        return enumsId(str);
    }

    public static final /* synthetic */ Map access$inverseMap(Map map) {
        return inverseMap(map);
    }

    public static final /* synthetic */ ClassId access$primitiveArrayId(Name name) {
        return primitiveArrayId(name);
    }

    public static final /* synthetic */ ClassId access$rangesId(String str) {
        return rangesId(str);
    }

    public static final /* synthetic */ ClassId access$reflectId(String str) {
        return reflectId(str);
    }

    public static final /* synthetic */ ClassId access$unsignedId(ClassId classId) {
        return unsignedId(classId);
    }

    public static final ClassId baseId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE(), Name.identifier(str));
    }

    public static final ClassId unsignedId(ClassId classId) {
        FqName base_kotlin_package = StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE();
        return new ClassId(base_kotlin_package, Name.identifier(Matrix.MATRIX_TYPE_RANDOM_UT + classId.getShortClassName().getIdentifier()));
    }

    public static final ClassId reflectId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_REFLECT_PACKAGE(), Name.identifier(str));
    }

    public static final ClassId primitiveArrayId(Name name) {
        StandardClassIds standardClassIds = StandardClassIds.INSTANCE;
        FqName packageFqName = standardClassIds.getArray().getPackageFqName();
        return new ClassId(packageFqName, Name.identifier(name.getIdentifier() + standardClassIds.getArray().getShortClassName().getIdentifier()));
    }

    public static final ClassId collectionsId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_COLLECTIONS_PACKAGE(), Name.identifier(str));
    }

    public static final ClassId rangesId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_RANGES_PACKAGE(), Name.identifier(str));
    }

    public static final ClassId annotationId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_ANNOTATION_PACKAGE(), Name.identifier(str));
    }

    public static final ClassId coroutinesId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_COROUTINES_PACKAGE(), Name.identifier(str));
    }

    public static final ClassId enumsId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_ENUMS_PACKAGE(), Name.identifier(str));
    }

    static {
        FqName fqName = new FqName("java.lang");
        JAVA_LANG_PACKAGE = fqName;
        FqName child = fqName.child(Name.identifier("annotation"));
        Intrinsics.checkNotNullExpressionValue(child, "child(...)");
        JAVA_LANG_ANNOTATION_PACKAGE = child;
    }

    public static final Map inverseMap(Map map) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Set<Map.Entry> entrySet = map.entrySet();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Map.Entry entry : entrySet) {
            Pair pair = TuplesKt.to(entry.getValue(), entry.getKey());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
