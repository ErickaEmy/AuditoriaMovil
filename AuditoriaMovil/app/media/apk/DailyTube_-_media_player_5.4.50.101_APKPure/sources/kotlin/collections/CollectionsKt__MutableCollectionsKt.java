package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    public static <T> boolean addAll(Collection<? super T> collection, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        Iterator<? extends T> it = elements.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (collection.add((T) it.next())) {
                z2 = true;
            }
        }
        return z2;
    }

    public static final <T> Collection<T> convertToListIfNotCollection(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            iterable = CollectionsKt.toList(iterable);
        }
        return (Collection) iterable;
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z2) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            if (function1.invoke((T) it.next()).booleanValue() == z2) {
                it.remove();
                z3 = true;
            }
        }
        return z3;
    }

    public static final <T> boolean removeAll(Collection<? super T> collection, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return collection.removeAll(convertToListIfNotCollection(elements));
    }

    public static <T> T removeFirst(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.remove(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T removeLast(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.remove(CollectionsKt.getLastIndex(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> boolean removeAll(List<T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((List) list, (Function1) predicate, true);
    }

    public static <T> boolean addAll(Collection<? super T> collection, T[] elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return collection.addAll(ArraysKt.asList(elements));
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(List<T> list, Function1<? super T, Boolean> function1, boolean z2) {
        if (!(list instanceof RandomAccess)) {
            Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return filterInPlace$CollectionsKt__MutableCollectionsKt(TypeIntrinsics.asMutableIterable(list), function1, z2);
        }
        ?? it = new IntRange(0, CollectionsKt.getLastIndex(list)).iterator();
        int i = 0;
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            T t2 = list.get(nextInt);
            if (function1.invoke(t2).booleanValue() != z2) {
                if (i != nextInt) {
                    list.set(i, t2);
                }
                i++;
            }
        }
        if (i >= list.size()) {
            return false;
        }
        int lastIndex = CollectionsKt.getLastIndex(list);
        if (i > lastIndex) {
            return true;
        }
        while (true) {
            list.remove(lastIndex);
            if (lastIndex == i) {
                return true;
            }
            lastIndex--;
        }
    }
}
