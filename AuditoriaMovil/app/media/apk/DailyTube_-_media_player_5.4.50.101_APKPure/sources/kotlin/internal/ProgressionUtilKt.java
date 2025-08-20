package kotlin.internal;
/* loaded from: classes.dex */
public final class ProgressionUtilKt {
    private static final int differenceModulo(int i, int i5, int i6) {
        return mod(mod(i, i6) - mod(i5, i6), i6);
    }

    public static final int getProgressionLastElement(int i, int i5, int i6) {
        if (i6 > 0) {
            return i >= i5 ? i5 : i5 - differenceModulo(i5, i, i6);
        } else if (i6 < 0) {
            return i <= i5 ? i5 : i5 + differenceModulo(i, i5, -i6);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    private static final int mod(int i, int i5) {
        int i6 = i % i5;
        return i6 >= 0 ? i6 : i6 + i5;
    }

    private static final long differenceModulo(long j2, long j4, long j6) {
        return mod(mod(j2, j6) - mod(j4, j6), j6);
    }

    private static final long mod(long j2, long j4) {
        long j6 = j2 % j4;
        return j6 >= 0 ? j6 : j6 + j4;
    }

    public static final long getProgressionLastElement(long j2, long j4, long j6) {
        int i = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        if (i > 0) {
            return j2 >= j4 ? j4 : j4 - differenceModulo(j4, j2, j6);
        } else if (i < 0) {
            return j2 <= j4 ? j4 : j4 + differenceModulo(j2, j4, -j6);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }
}
