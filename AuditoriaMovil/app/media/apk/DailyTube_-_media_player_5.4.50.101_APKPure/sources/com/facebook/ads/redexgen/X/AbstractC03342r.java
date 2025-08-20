package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.2r  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC03342r {
    public static final int[] A00 = new int[0];
    public static final long[] A01 = new long[0];
    public static final Object[] A02 = new Object[0];

    public static int A00(int i) {
        return A01(i * 8) / 8;
    }

    public static int A01(int i) {
        for (int i5 = 4; i5 < 32; i5++) {
            int i6 = 1 << i5;
            if (i <= i6 - 12) {
                int i8 = (1 << i5) - 12;
                return i8;
            }
        }
        return i;
    }

    public static int A02(int[] iArr, int i, int i5) {
        int midVal = 0;
        int mid = i - 1;
        while (midVal <= mid) {
            int lo = midVal + mid;
            int hi = lo >>> 1;
            int lo2 = iArr[hi];
            if (lo2 < i5) {
                midVal = hi + 1;
            } else if (lo2 > i5) {
                mid = hi - 1;
            } else {
                return hi;
            }
        }
        int lo3 = midVal ^ (-1);
        return lo3;
    }

    public static int A03(long[] jArr, int i, long j2) {
        int i5 = 0;
        int i6 = i - 1;
        while (i5 <= i6) {
            int lo = i5 + i6;
            int i8 = lo >>> 1;
            long j4 = jArr[i8];
            int lo2 = (j4 > j2 ? 1 : (j4 == j2 ? 0 : -1));
            if (lo2 < 0) {
                i5 = i8 + 1;
            } else {
                int lo3 = (j4 > j2 ? 1 : (j4 == j2 ? 0 : -1));
                if (lo3 > 0) {
                    i6 = i8 - 1;
                } else {
                    return i8;
                }
            }
        }
        int lo4 = i5 ^ (-1);
        return lo4;
    }

    public static boolean A04(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
