package c1;

import com.uv.v7.R;
import java.math.RoundingMode;
import w0.xc;
/* loaded from: classes.dex */
public final class n3 {
    public static final byte[] y = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    /* renamed from: n3  reason: collision with root package name */
    public static final int[] f3972n3 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    /* renamed from: zn  reason: collision with root package name */
    public static final int[] f3974zn = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};

    /* renamed from: gv  reason: collision with root package name */
    public static final int[] f3971gv = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    /* renamed from: v  reason: collision with root package name */
    public static int[] f3973v = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, R.styleable.AppCompatTheme_textColorAlertDialogListItem, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    public static int n3(int i, int i5) {
        if (i5 > 0) {
            int i6 = i % i5;
            if (i6 < 0) {
                return i6 + i5;
            }
            return i6;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("Modulus ");
        sb.append(i5);
        sb.append(" must be > 0");
        throw new ArithmeticException(sb.toString());
    }

    public static int y(int i, int i5, RoundingMode roundingMode) {
        boolean z2;
        xc.wz(roundingMode);
        if (i5 != 0) {
            int i6 = i / i5;
            int i8 = i - (i5 * i6);
            if (i8 == 0) {
                return i6;
            }
            boolean z3 = true;
            int i10 = ((i ^ i5) >> 31) | 1;
            switch (y.y[roundingMode.ordinal()]) {
                case 1:
                    if (i8 != 0) {
                        z3 = false;
                    }
                    gv.y(z3);
                    return i6;
                case 2:
                    return i6;
                case 3:
                    if (i10 >= 0) {
                        return i6;
                    }
                    break;
                case 4:
                    break;
                case 5:
                    if (i10 <= 0) {
                        return i6;
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    int abs = Math.abs(i8);
                    int abs2 = abs - (Math.abs(i5) - abs);
                    if (abs2 == 0) {
                        if (roundingMode != RoundingMode.HALF_UP) {
                            if (roundingMode == RoundingMode.HALF_EVEN) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if ((i6 & 1) == 0) {
                                z3 = false;
                            }
                            if (!(z2 & z3)) {
                                return i6;
                            }
                        }
                    } else if (abs2 <= 0) {
                        return i6;
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            return i6 + i10;
        }
        throw new ArithmeticException("/ by zero");
    }
}
