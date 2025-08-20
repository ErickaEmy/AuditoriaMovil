package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    public static <T> ArrayList<T> arrayListOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length == 0) {
            return new ArrayList<>();
        }
        return new ArrayList<>(new ArrayAsCollection(elements, true));
    }

    public static final <T> Collection<T> asCollection(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new ArrayAsCollection(tArr, false);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T t2, int i, int i5) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i, i5);
        int i6 = i5 - 1;
        while (i <= i6) {
            int i8 = (i + i6) >>> 1;
            int compareValues = ComparisonsKt.compareValues(list.get(i8), t2);
            if (compareValues < 0) {
                i = i8 + 1;
            } else if (compareValues > 0) {
                i6 = i8 - 1;
            } else {
                return i8;
            }
        }
        return -(i + 1);
    }

    public static /* synthetic */ int binarySearch$default(List list, Comparable comparable, int i, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = list.size();
        }
        return binarySearch(list, comparable, i, i5);
    }

    public static <T> List<T> emptyList() {
        return EmptyList.INSTANCE;
    }

    public static IntRange getIndices(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new IntRange(0, collection.size() - 1);
    }

    public static <T> int getLastIndex(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.size() - 1;
    }

    public static <T> List<T> listOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length > 0) {
            return ArraysKt.asList(elements);
        }
        return CollectionsKt.emptyList();
    }

    public static <T> List<T> listOfNotNull(T t2) {
        return t2 != null ? CollectionsKt.listOf(t2) : CollectionsKt.emptyList();
    }

    public static <T> List<T> mutableListOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length == 0) {
            return new ArrayList();
        }
        return new ArrayList(new ArrayAsCollection(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        if (size != 0) {
            if (size == 1) {
                return CollectionsKt.listOf(list.get(0));
            }
            return list;
        }
        return CollectionsKt.emptyList();
    }

    private static final void rangeCheck$CollectionsKt__CollectionsKt(int i, int i5, int i6) {
        if (i5 <= i6) {
            if (i5 >= 0) {
                if (i6 <= i) {
                    return;
                }
                throw new IndexOutOfBoundsException("toIndex (" + i6 + ") is greater than size (" + i + ").");
            }
            throw new IndexOutOfBoundsException("fromIndex (" + i5 + ") is less than zero.");
        }
        throw new IllegalArgumentException("fromIndex (" + i5 + ") is greater than toIndex (" + i6 + ").");
    }

    public static void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static <T> List<T> listOfNotNull(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt.filterNotNull(elements);
    }
}
