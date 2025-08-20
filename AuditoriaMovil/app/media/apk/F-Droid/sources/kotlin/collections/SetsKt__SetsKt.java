package kotlin.collections;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sets.kt */
/* loaded from: classes.dex */
public abstract class SetsKt__SetsKt extends SetsKt__SetsJVMKt {
    public static Set emptySet() {
        return EmptySet.INSTANCE;
    }

    public static Set setOf(Object... elements) {
        Set emptySet;
        Set set;
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length > 0) {
            set = ArraysKt___ArraysKt.toSet(elements);
            return set;
        }
        emptySet = emptySet();
        return emptySet;
    }

    public static Set mutableSetOf(Object... elements) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(elements, "elements");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(elements.length);
        return (Set) ArraysKt___ArraysKt.toCollection(elements, new LinkedHashSet(mapCapacity));
    }

    public static LinkedHashSet linkedSetOf(Object... elements) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(elements, "elements");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(elements.length);
        return (LinkedHashSet) ArraysKt___ArraysKt.toCollection(elements, new LinkedHashSet(mapCapacity));
    }

    public static final Set optimizeReadOnlySet(Set set) {
        Set emptySet;
        Set of;
        Intrinsics.checkNotNullParameter(set, "<this>");
        int size = set.size();
        if (size == 0) {
            emptySet = emptySet();
            return emptySet;
        } else if (size != 1) {
            return set;
        } else {
            of = SetsKt__SetsJVMKt.setOf(set.iterator().next());
            return of;
        }
    }
}
