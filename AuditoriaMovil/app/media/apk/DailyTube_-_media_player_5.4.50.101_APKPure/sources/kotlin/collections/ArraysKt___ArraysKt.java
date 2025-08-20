package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ArraysKt___ArraysKt extends ArraysKt___ArraysJvmKt {
    public static <T> Iterable<T> asIterable(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return CollectionsKt.emptyList();
        }
        return new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1(tArr);
    }

    public static <T> Sequence<T> asSequence(final T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return SequencesKt.emptySequence();
        }
        return new Sequence<T>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return ArrayIteratorKt.iterator(tArr);
            }
        };
    }

    public static <T> boolean contains(T[] tArr, T t2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return ArraysKt.indexOf(tArr, t2) >= 0;
    }

    public static <T> List<T> filterNotNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (List) filterNotNullTo(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(T[] tArr, C destination) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t2 : tArr) {
            if (t2 != null) {
                destination.add(t2);
            }
        }
        return destination;
    }

    public static <T> T first(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> T firstOrNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static <T> IntRange getIndices(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new IntRange(0, ArraysKt.getLastIndex(tArr));
    }

    public static <T> int getLastIndex(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length - 1;
    }

    public static <T> T getOrNull(T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (i < 0 || i > ArraysKt.getLastIndex(tArr)) {
            return null;
        }
        return tArr[i];
    }

    public static <T> int indexOf(T[] tArr, T t2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int i = 0;
        if (t2 == null) {
            int length = tArr.length;
            while (i < length) {
                if (tArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i < length2) {
            if (Intrinsics.areEqual(t2, tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T, A extends Appendable> A joinTo(T[] tArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i5 = 0;
        for (T t2 : tArr) {
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

    public static final <T> String joinToString(T[] tArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String sb = ((StringBuilder) joinTo(tArr, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            charSequence = ", ";
        }
        String str = (i5 & 2) != 0 ? "" : charSequence2;
        String str2 = (i5 & 4) == 0 ? charSequence3 : "";
        int i6 = (i5 & 8) != 0 ? -1 : i;
        if ((i5 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        if ((i5 & 32) != 0) {
            function1 = null;
        }
        return joinToString(objArr, charSequence, str, str2, i6, charSequence5, function1);
    }

    public static <T> T last(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[ArraysKt.getLastIndex(tArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int lastIndexOf(byte[] bArr, byte b2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (b2 == bArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static <T extends Comparable<? super T>> T minOrThrow(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length != 0) {
            T t2 = tArr[0];
            ?? it = new IntRange(1, ArraysKt.getLastIndex(tArr)).iterator();
            while (it.hasNext()) {
                T t3 = tArr[it.nextInt()];
                if (t2.compareTo(t3) > 0) {
                    t2 = t3;
                }
            }
            return t2;
        }
        throw new NoSuchElementException();
    }

    public static <T> List<T> reversed(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return CollectionsKt.emptyList();
        }
        List<T> mutableList = ArraysKt.toMutableList(tArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static char single(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            if (length == 1) {
                return cArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> T singleOrNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static List<Byte> slice(byte[] bArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt.copyOfRange(bArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static <T extends Comparable<? super T>> T[] sortedArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        T[] tArr2 = (T[]) ((Comparable[]) copyOf);
        ArraysKt.sort(tArr2);
        return tArr2;
    }

    public static final <T> T[] sortedArrayWith(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkNotNullExpressionValue(tArr2, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sortWith(tArr2, comparator);
        return tArr2;
    }

    public static <T> List<T> sortedWith(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt.asList(sortedArrayWith(tArr, comparator));
    }

    public static int sum(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i = 0;
        for (int i5 : iArr) {
            i += i5;
        }
        return i;
    }

    public static <T> List<T> take(T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt.emptyList();
            }
            if (i >= tArr.length) {
                return ArraysKt.toList(tArr);
            }
            if (i == 1) {
                return CollectionsKt.listOf(tArr[0]);
            }
            ArrayList arrayList = new ArrayList(i);
            int i5 = 0;
            for (T t2 : tArr) {
                arrayList.add(t2);
                i5++;
                if (i5 == i) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static final <T, C extends Collection<? super T>> C toCollection(T[] tArr, C destination) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t2 : tArr) {
            destination.add(t2);
        }
        return destination;
    }

    public static <T> HashSet<T> toHashSet(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (HashSet) toCollection(tArr, new HashSet(MapsKt.mapCapacity(tArr.length)));
    }

    public static <T> List<T> toList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                return ArraysKt.toMutableList(tArr);
            }
            return CollectionsKt.listOf(tArr[0]);
        }
        return CollectionsKt.emptyList();
    }

    public static <T> List<T> toMutableList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new ArrayList(CollectionsKt__CollectionsKt.asCollection(tArr));
    }

    public static <T> Set<T> toSet(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                return (Set) toCollection(tArr, new LinkedHashSet(MapsKt.mapCapacity(tArr.length)));
            }
            return SetsKt.setOf(tArr[0]);
        }
        return SetsKt.emptySet();
    }

    public static final boolean contains(byte[] bArr, byte b2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return indexOf(bArr, b2) >= 0;
    }

    public static IntRange getIndices(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new IntRange(0, getLastIndex(bArr));
    }

    public static final int getLastIndex(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr.length - 1;
    }

    public static Long getOrNull(long[] jArr, int i) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (i < 0 || i > getLastIndex(jArr)) {
            return null;
        }
        return Long.valueOf(jArr[i]);
    }

    public static final String joinToString(byte[] bArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1<? super Byte, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String sb = ((StringBuilder) joinTo(bArr, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            charSequence = ", ";
        }
        String str = (i5 & 2) != 0 ? "" : charSequence2;
        String str2 = (i5 & 4) == 0 ? charSequence3 : "";
        int i6 = (i5 & 8) != 0 ? -1 : i;
        if ((i5 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        if ((i5 & 32) != 0) {
            function1 = null;
        }
        return joinToString(bArr, charSequence, str, str2, i6, charSequence5, function1);
    }

    public static final List<Integer> toMutableList(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public static boolean contains(int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return indexOf(iArr, i) >= 0;
    }

    public static int getLastIndex(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length - 1;
    }

    public static byte first(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length != 0) {
            return bArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int getLastIndex(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr.length - 1;
    }

    public static final int indexOf(byte[] bArr, byte b2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (b2 == bArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static List<Integer> toList(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        if (length != 0) {
            if (length != 1) {
                return toMutableList(iArr);
            }
            return CollectionsKt.listOf(Integer.valueOf(iArr[0]));
        }
        return CollectionsKt.emptyList();
    }

    public static final int indexOf(int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (i == iArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    public static final <A extends Appendable> A joinTo(byte[] bArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1<? super Byte, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i5 = 0;
        for (byte b2 : bArr) {
            i5++;
            if (i5 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i5 > i) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Byte.valueOf(b2)));
            } else {
                buffer.append(String.valueOf((int) b2));
            }
        }
        if (i >= 0 && i5 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }
}
