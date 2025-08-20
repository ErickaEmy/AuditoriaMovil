package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
/* compiled from: UnsignedUtils.kt */
/* loaded from: classes.dex */
public abstract class UnsignedKt {
    public static final double ulongToDouble(long j) {
        return ((j >>> 11) * 2048) + (j & 2047);
    }

    public static final int uintCompare(int i, int i2) {
        return Intrinsics.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    public static final int ulongCompare(long j, long j2) {
        return Intrinsics.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    public static final String ulongToString(long j) {
        return ulongToString(j, 10);
    }

    public static final String ulongToString(long j, int i) {
        int checkRadix;
        int checkRadix2;
        int checkRadix3;
        if (j >= 0) {
            checkRadix3 = CharsKt__CharJVMKt.checkRadix(i);
            String l = Long.toString(j, checkRadix3);
            Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
            return l;
        }
        long j2 = i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        checkRadix = CharsKt__CharJVMKt.checkRadix(i);
        String l2 = Long.toString(j3, checkRadix);
        Intrinsics.checkNotNullExpressionValue(l2, "toString(...)");
        sb.append(l2);
        checkRadix2 = CharsKt__CharJVMKt.checkRadix(i);
        String l3 = Long.toString(j4, checkRadix2);
        Intrinsics.checkNotNullExpressionValue(l3, "toString(...)");
        sb.append(l3);
        return sb.toString();
    }
}
