package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ArraysKt___ArraysJvmKt extends ArraysKt__ArraysKt {
    public static <T> List<T> asList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        List<T> asList = ArraysUtilJVM.asList(tArr);
        Intrinsics.checkNotNullExpressionValue(asList, "asList(...)");
        return asList;
    }

    public static <T> T[] copyInto(T[] tArr, T[] destination, int i, int i5, int i6) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(tArr, i5, destination, i, i6 - i5);
        return destination;
    }

    public static /* synthetic */ Object[] copyInto$default(Object[] objArr, Object[] objArr2, int i, int i5, int i6, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i = 0;
        }
        if ((i8 & 4) != 0) {
            i5 = 0;
        }
        if ((i8 & 8) != 0) {
            i6 = objArr.length;
        }
        return ArraysKt.copyInto(objArr, objArr2, i, i5, i6);
    }

    public static <T> T[] copyOfRange(T[] tArr, int i, int i5) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i5, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i, i5);
        Intrinsics.checkNotNullExpressionValue(tArr2, "copyOfRange(...)");
        return tArr2;
    }

    public static <T> void fill(T[] tArr, T t2, int i, int i5) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Arrays.fill(tArr, i, i5, t2);
    }

    public static /* synthetic */ void fill$default(Object[] objArr, Object obj, int i, int i5, int i6, Object obj2) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = objArr.length;
        }
        ArraysKt.fill(objArr, obj, i, i5);
    }

    public static byte[] plus(byte[] bArr, byte[] elements) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = bArr.length;
        int length2 = elements.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        Intrinsics.checkNotNull(copyOf);
        return copyOf;
    }

    public static <T> void sort(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static final <T> void sortWith(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static final List<Byte> asList(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new ArraysKt___ArraysJvmKt$asList$1(bArr);
    }

    public static byte[] copyInto(byte[] bArr, byte[] destination, int i, int i5, int i6) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(bArr, i5, destination, i, i6 - i5);
        return destination;
    }

    public static /* synthetic */ byte[] copyInto$default(byte[] bArr, byte[] bArr2, int i, int i5, int i6, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i = 0;
        }
        if ((i8 & 4) != 0) {
            i5 = 0;
        }
        if ((i8 & 8) != 0) {
            i6 = bArr.length;
        }
        return ArraysKt.copyInto(bArr, bArr2, i, i5, i6);
    }

    public static void fill(int[] iArr, int i, int i5, int i6) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Arrays.fill(iArr, i5, i6, i);
    }

    public static byte[] copyOfRange(byte[] bArr, int i, int i5) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i5, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i5);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }
}
