package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
class SetsKt___SetsKt extends SetsKt__SetsKt {
    public static <T> Set<T> minus(Set<? extends T> set, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<?> convertToListIfNotCollection = CollectionsKt__MutableCollectionsKt.convertToListIfNotCollection(elements);
        if (convertToListIfNotCollection.isEmpty()) {
            return CollectionsKt.toSet(set);
        }
        if (convertToListIfNotCollection instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t2 : set) {
                if (!convertToListIfNotCollection.contains(t2)) {
                    linkedHashSet.add(t2);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(convertToListIfNotCollection);
        return linkedHashSet2;
    }

    public static <T> Set<T> plus(Set<? extends T> set, Iterable<? extends T> elements) {
        int size;
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Integer collectionSizeOrNull = CollectionsKt__IterablesKt.collectionSizeOrNull(elements);
        if (collectionSizeOrNull != null) {
            size = set.size() + collectionSizeOrNull.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(size));
        linkedHashSet.addAll(set);
        CollectionsKt.addAll(linkedHashSet, elements);
        return linkedHashSet;
    }
}
