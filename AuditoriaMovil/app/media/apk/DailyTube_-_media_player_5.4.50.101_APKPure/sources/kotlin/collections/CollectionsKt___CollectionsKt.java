package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
/* loaded from: classes.dex */
public class CollectionsKt___CollectionsKt extends CollectionsKt___CollectionsJvmKt {
    public static <T> Sequence<T> asSequence(final Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return new Sequence<T>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return iterable.iterator();
            }
        };
    }

    public static <T> List<List<T>> chunked(Iterable<? extends T> iterable, int i) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return windowed(iterable, i, i, true);
    }

    public static <T> boolean contains(Iterable<? extends T> iterable, T t2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t2);
        }
        if (indexOf(iterable, t2) >= 0) {
            return true;
        }
        return false;
    }

    public static <T> List<T> distinct(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt.toList(CollectionsKt.toMutableSet(iterable));
    }

    public static <T> List<T> drop(Iterable<? extends T> iterable, int i) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt.toList(iterable);
            }
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                int size = collection.size() - i;
                if (size <= 0) {
                    return CollectionsKt.emptyList();
                }
                if (size == 1) {
                    return CollectionsKt.listOf(CollectionsKt.last(iterable));
                }
                arrayList = new ArrayList(size);
                if (iterable instanceof List) {
                    if (iterable instanceof RandomAccess) {
                        int size2 = collection.size();
                        while (i < size2) {
                            arrayList.add(((List) iterable).get(i));
                            i++;
                        }
                    } else {
                        ListIterator listIterator = ((List) iterable).listIterator(i);
                        while (listIterator.hasNext()) {
                            arrayList.add(listIterator.next());
                        }
                    }
                    return arrayList;
                }
            } else {
                arrayList = new ArrayList();
            }
            int i5 = 0;
            for (T t2 : iterable) {
                if (i5 >= i) {
                    arrayList.add(t2);
                } else {
                    i5++;
                }
            }
            return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static <T> List<T> dropLast(List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i >= 0) {
            return CollectionsKt.take(list, RangesKt.coerceAtLeast(list.size() - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static <T> T elementAt(Iterable<? extends T> iterable, final int i) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) ((List) iterable).get(i);
        }
        return (T) elementAtOrElse(iterable, i, new Function1<Integer, T>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$elementAt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final T invoke(int i5) {
                throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + i + '.');
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }
        });
    }

    public static final <T> T elementAtOrElse(Iterable<? extends T> iterable, int i, Function1<? super Integer, ? extends T> defaultValue) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (i >= 0 && i <= CollectionsKt.getLastIndex(list)) {
                return (T) list.get(i);
            }
            return defaultValue.invoke(Integer.valueOf(i));
        } else if (i < 0) {
            return defaultValue.invoke(Integer.valueOf(i));
        } else {
            int i5 = 0;
            for (T t2 : iterable) {
                int i6 = i5 + 1;
                if (i == i5) {
                    return t2;
                }
                i5 = i6;
            }
            return defaultValue.invoke(Integer.valueOf(i));
        }
    }

    public static <T> List<T> filterNotNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return (List) filterNotNullTo(iterable, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(Iterable<? extends T> iterable, C destination) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t2 : iterable) {
            if (t2 != null) {
                destination.add(t2);
            }
        }
        return destination;
    }

    public static <T> T first(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) CollectionsKt.first((List<? extends Object>) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T firstOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static <T> T getOrNull(List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i >= 0 && i <= CollectionsKt.getLastIndex(list)) {
            return list.get(i);
        }
        return null;
    }

    public static final <T> int indexOf(Iterable<? extends T> iterable, T t2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t2);
        }
        int i = 0;
        for (T t3 : iterable) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(t2, t3)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T, A extends Appendable> A joinTo(Iterable<? extends T> iterable, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i5 = 0;
        for (T t2 : iterable) {
            i5++;
            if (i5 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i5 > i) {
                break;
            }
            StringsKt.appendElement(buffer, t2, function1);
        }
        if (i >= 0 && i5 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static /* synthetic */ Appendable joinTo$default(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i5, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i6;
        CharSequence charSequence7;
        Function1 function12;
        if ((i5 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i5 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i5 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i5 & 16) != 0) {
            i6 = -1;
        } else {
            i6 = i;
        }
        if ((i5 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i5 & 64) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        return joinTo(iterable, appendable, charSequence5, charSequence6, charSequence8, i6, charSequence7, function12);
    }

    public static final <T> String joinToString(Iterable<? extends T> iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String sb = ((StringBuilder) joinTo(iterable, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i5, Object obj) {
        CharSequence charSequence5;
        int i6;
        if ((i5 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i5 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i5 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i5 & 8) != 0) {
            i6 = -1;
        } else {
            i6 = i;
        }
        if ((i5 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i5 & 32) != 0) {
            function1 = null;
        }
        return joinToString(iterable, charSequence, charSequence5, charSequence6, i6, charSequence7, function1);
    }

    public static <T> T last(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) CollectionsKt.last((List<? extends Object>) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T lastOrNull(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static <T extends Comparable<? super T>> T maxOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T maxWithOrNull(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (T) it.next();
        while (it.hasNext()) {
            T next = it.next();
            if (comparator.compare(obj, next) < 0) {
                obj = next;
            }
        }
        return (T) obj;
    }

    public static <T extends Comparable<? super T>> T minOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T> List<T> minus(Iterable<? extends T> iterable, T t2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        boolean z2 = false;
        for (T t3 : iterable) {
            boolean z3 = true;
            if (!z2 && Intrinsics.areEqual(t3, t2)) {
                z2 = true;
                z3 = false;
            }
            if (z3) {
                arrayList.add(t3);
            }
        }
        return arrayList;
    }

    public static <T> List<T> plus(Collection<? extends T> collection, T t2) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t2);
        return arrayList;
    }

    public static <T> T random(Collection<? extends T> collection, Random random) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (!collection.isEmpty()) {
            return (T) CollectionsKt.elementAt(collection, random.nextInt(collection.size()));
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T randomOrNull(Collection<? extends T> collection, Random random) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (collection.isEmpty()) {
            return null;
        }
        return (T) CollectionsKt.elementAt(collection, random.nextInt(collection.size()));
    }

    public static <T> List<T> reversed(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return CollectionsKt.toList(iterable);
        }
        List<T> mutableList = toMutableList(iterable);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static <T> T single(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) single((List<? extends Object>) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (it.hasNext()) {
                throw new IllegalArgumentException("Collection has more than one element.");
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> List<T> slice(List<? extends T> list, IntRange indices) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        return CollectionsKt.toList(list.subList(indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static <T extends Comparable<? super T>> List<T> sorted(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return CollectionsKt.toList(iterable);
            }
            Object[] array = collection.toArray(new Comparable[0]);
            ArraysKt.sort((Comparable[]) array);
            return ArraysKt.asList(array);
        }
        List<T> mutableList = toMutableList(iterable);
        CollectionsKt.sort(mutableList);
        return mutableList;
    }

    public static <T extends Comparable<? super T>> List<T> sortedDescending(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt.sortedWith(iterable, ComparisonsKt.reverseOrder());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> sortedWith(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return CollectionsKt.toList(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            ArraysKt___ArraysJvmKt.sortWith(array, comparator);
            return ArraysKt.asList(array);
        }
        List<T> mutableList = toMutableList(iterable);
        CollectionsKt.sortWith(mutableList, comparator);
        return mutableList;
    }

    public static <T> Set<T> subtract(Iterable<? extends T> iterable, Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = CollectionsKt.toMutableSet(iterable);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static int sumOfInt(Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int i = 0;
        for (Integer num : iterable) {
            i += num.intValue();
        }
        return i;
    }

    public static <T> List<T> take(Iterable<? extends T> iterable, int i) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt.emptyList();
            }
            if (iterable instanceof Collection) {
                if (i >= ((Collection) iterable).size()) {
                    return CollectionsKt.toList(iterable);
                }
                if (i == 1) {
                    return CollectionsKt.listOf(CollectionsKt.first(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i);
            int i5 = 0;
            for (T t2 : iterable) {
                arrayList.add(t2);
                i5++;
                if (i5 == i) {
                    break;
                }
            }
            return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static <T> List<T> takeLast(List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt.emptyList();
            }
            int size = list.size();
            if (i >= size) {
                return CollectionsKt.toList(list);
            }
            if (i == 1) {
                return CollectionsKt.listOf(CollectionsKt.last((List<? extends Object>) list));
            }
            ArrayList arrayList = new ArrayList(i);
            if (list instanceof RandomAccess) {
                for (int i5 = size - i; i5 < size; i5++) {
                    arrayList.add(list.get(i5));
                }
            } else {
                ListIterator<? extends T> listIterator = list.listIterator(size - i);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static boolean[] toBooleanArray(Collection<Boolean> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        int i = 0;
        for (Boolean bool : collection) {
            zArr[i] = bool.booleanValue();
            i++;
        }
        return zArr;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Iterable<? extends T> iterable, C destination) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t2 : iterable) {
            destination.add(t2);
        }
        return destination;
    }

    public static <T> HashSet<T> toHashSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return (HashSet) toCollection(iterable, new HashSet(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 12))));
    }

    public static int[] toIntArray(Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] iArr = new int[collection.size()];
        int i = 0;
        for (Integer num : collection) {
            iArr[i] = num.intValue();
            i++;
        }
        return iArr;
    }

    public static <T> List<T> toList(Iterable<? extends T> iterable) {
        Object next;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return CollectionsKt.toMutableList(collection);
                }
                if (iterable instanceof List) {
                    next = ((List) iterable).get(0);
                } else {
                    next = iterable.iterator().next();
                }
                return CollectionsKt.listOf(next);
            }
            return CollectionsKt.emptyList();
        }
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(toMutableList(iterable));
    }

    public static long[] toLongArray(Collection<Long> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] jArr = new long[collection.size()];
        int i = 0;
        for (Long l2 : collection) {
            jArr[i] = l2.longValue();
            i++;
        }
        return jArr;
    }

    public static final <T> List<T> toMutableList(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return CollectionsKt.toMutableList((Collection) iterable);
        }
        return (List) toCollection(iterable, new ArrayList());
    }

    public static <T> Set<T> toMutableSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        return (Set) toCollection(iterable, new LinkedHashSet());
    }

    public static <T> Set<T> toSet(Iterable<? extends T> iterable) {
        Object next;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return (Set) toCollection(iterable, new LinkedHashSet(MapsKt.mapCapacity(collection.size())));
                }
                if (iterable instanceof List) {
                    next = ((List) iterable).get(0);
                } else {
                    next = iterable.iterator().next();
                }
                return SetsKt.setOf(next);
            }
            return SetsKt.emptySet();
        }
        return SetsKt__SetsKt.optimizeReadOnlySet((Set) toCollection(iterable, new LinkedHashSet()));
    }

    public static <T> Set<T> union(Iterable<? extends T> iterable, Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = CollectionsKt.toMutableSet(iterable);
        CollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final <T> List<List<T>> windowed(Iterable<? extends T> iterable, int i, int i5, boolean z2) {
        int i6;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        SlidingWindowKt.checkWindowSizeStep(i, i5);
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            List list = (List) iterable;
            int size = list.size();
            int i8 = size / i5;
            if (size % i5 == 0) {
                i6 = 0;
            } else {
                i6 = 1;
            }
            ArrayList arrayList = new ArrayList(i8 + i6);
            int i10 = 0;
            while (i10 >= 0 && i10 < size) {
                int coerceAtMost = RangesKt.coerceAtMost(i, size - i10);
                if (coerceAtMost < i && !z2) {
                    break;
                }
                ArrayList arrayList2 = new ArrayList(coerceAtMost);
                for (int i11 = 0; i11 < coerceAtMost; i11++) {
                    arrayList2.add(list.get(i11 + i10));
                }
                arrayList.add(arrayList2);
                i10 += i5;
            }
            return arrayList;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator windowedIterator = SlidingWindowKt.windowedIterator(iterable.iterator(), i, i5, z2, false);
        while (windowedIterator.hasNext()) {
            arrayList3.add((List) windowedIterator.next());
        }
        return arrayList3;
    }

    public static <T> Iterable<IndexedValue<T>> withIndex(final Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return new IndexingIterable(new Function0<Iterator<? extends T>>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$withIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Iterator<T> invoke() {
                return iterable.iterator();
            }
        });
    }

    public static <T> List<T> plus(Collection<? extends T> collection, T[] elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + elements.length);
        arrayList.addAll(collection);
        CollectionsKt.addAll(arrayList, elements);
        return arrayList;
    }

    public static <T> List<T> toMutableList(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> int indexOf(List<? extends T> list, T t2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.indexOf(t2);
    }

    public static <T> T first(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T firstOrNull(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T> List<T> plus(Collection<? extends T> collection, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            Collection collection2 = (Collection) elements;
            ArrayList arrayList = new ArrayList(collection.size() + collection2.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        CollectionsKt.addAll(arrayList2, elements);
        return arrayList2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static <T> T firstOrNull(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t2 : iterable) {
            if (predicate.invoke(t2).booleanValue()) {
                return t2;
            }
        }
        return null;
    }

    public static <T> T last(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(CollectionsKt.getLastIndex(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T single(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        if (size != 0) {
            if (size == 1) {
                return list.get(0);
            }
            throw new IllegalArgumentException("List has more than one element.");
        }
        throw new NoSuchElementException("List is empty.");
    }
}
