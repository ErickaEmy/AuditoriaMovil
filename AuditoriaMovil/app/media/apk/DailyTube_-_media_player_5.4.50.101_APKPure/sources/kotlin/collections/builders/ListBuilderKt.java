package kotlin.collections.builders;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class ListBuilderKt {
    public static final <E> E[] arrayOfUninitializedElements(int i) {
        if (i >= 0) {
            return (E[]) new Object[i];
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    public static final <T> T[] copyOfUninitializedElements(T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i);
        Intrinsics.checkNotNullExpressionValue(tArr2, "copyOf(...)");
        return tArr2;
    }

    public static final <E> void resetAt(E[] eArr, int i) {
        Intrinsics.checkNotNullParameter(eArr, "<this>");
        eArr[i] = null;
    }

    public static final <E> void resetRange(E[] eArr, int i, int i5) {
        Intrinsics.checkNotNullParameter(eArr, "<this>");
        while (i < i5) {
            resetAt(eArr, i);
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean subarrayContentEquals(T[] tArr, int i, int i5, List<?> list) {
        if (i5 != list.size()) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (!Intrinsics.areEqual(tArr[i + i6], list.get(i6))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int subarrayContentHashCode(T[] tArr, int i, int i5) {
        int i6;
        int i8 = 1;
        for (int i10 = 0; i10 < i5; i10++) {
            T t2 = tArr[i + i10];
            int i11 = i8 * 31;
            if (t2 != null) {
                i6 = t2.hashCode();
            } else {
                i6 = 0;
            }
            i8 = i11 + i6;
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> String subarrayContentToString(T[] tArr, int i, int i5, Collection<? extends T> collection) {
        StringBuilder sb = new StringBuilder((i5 * 3) + 2);
        sb.append("[");
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            T t2 = tArr[i + i6];
            if (t2 == collection) {
                sb.append("(this Collection)");
            } else {
                sb.append(t2);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
