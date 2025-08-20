package kotlin.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SetsKt__SetsKt extends SetsKt__SetsJVMKt {
    public static <T> Set<T> emptySet() {
        return EmptySet.INSTANCE;
    }

    public static <T> HashSet<T> hashSetOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (HashSet) ArraysKt___ArraysKt.toCollection(elements, new HashSet(MapsKt.mapCapacity(elements.length)));
    }

    public static <T> Set<T> mutableSetOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (Set) ArraysKt___ArraysKt.toCollection(elements, new LinkedHashSet(MapsKt.mapCapacity(elements.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> optimizeReadOnlySet(Set<? extends T> set) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        int size = set.size();
        if (size != 0) {
            if (size == 1) {
                return SetsKt.setOf(set.iterator().next());
            }
            return set;
        }
        return SetsKt.emptySet();
    }

    public static <T> Set<T> setOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length > 0) {
            return ArraysKt.toSet(elements);
        }
        return SetsKt.emptySet();
    }
}
