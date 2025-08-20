package d1;

import w0.xc;
/* loaded from: classes.dex */
public final class s {
    public static long gv(long... jArr) {
        boolean z2;
        if (jArr.length > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        xc.gv(z2);
        long j2 = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            long j4 = jArr[i];
            if (j4 > j2) {
                j2 = j4;
            }
        }
        return j2;
    }

    public static long n3(byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9) {
        return ((b3 & 255) << 48) | ((b2 & 255) << 56) | ((b4 & 255) << 40) | ((b5 & 255) << 32) | ((b6 & 255) << 24) | ((b7 & 255) << 16) | ((b8 & 255) << 8) | (b9 & 255);
    }

    public static long v(long... jArr) {
        boolean z2;
        if (jArr.length > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        xc.gv(z2);
        long j2 = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            long j4 = jArr[i];
            if (j4 < j2) {
                j2 = j4;
            }
        }
        return j2;
    }

    public static int y(long j2, long j4) {
        int i = (j2 > j4 ? 1 : (j2 == j4 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        if (i > 0) {
            return 1;
        }
        return 0;
    }

    public static int zn(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }
}
