package z0;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class t {
    public static int a(Object obj, Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i5;
        int i6;
        int zn2 = co.zn(obj);
        int i8 = zn2 & i;
        int s2 = s(obj3, i8);
        if (s2 == 0) {
            return -1;
        }
        int n32 = n3(zn2, i);
        int i10 = -1;
        while (true) {
            i5 = s2 - 1;
            i6 = iArr[i5];
            if (n3(i6, i) != n32 || !w0.f.y(obj, objArr[i5]) || (objArr2 != null && !w0.f.y(obj2, objArr2[i5]))) {
                int zn3 = zn(i6, i);
                if (zn3 == 0) {
                    return -1;
                }
                i10 = i5;
                s2 = zn3;
            }
        }
        int zn4 = zn(i6, i);
        if (i10 == -1) {
            c5(obj3, i8, zn4);
        } else {
            iArr[i10] = gv(iArr[i10], zn4, i);
        }
        return i5;
    }

    public static void c5(Object obj, int i, int i5) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i5;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i5;
        } else {
            ((int[]) obj)[i] = i5;
        }
    }

    public static void fb(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    public static int gv(int i, int i5, int i6) {
        return (i & (~i6)) | (i5 & i6);
    }

    public static int i9(int i) {
        return Math.max(4, co.y(i + 1, 1.0d));
    }

    public static int n3(int i, int i5) {
        return i & (~i5);
    }

    public static int s(Object obj, int i) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i] & 255;
        }
        if (obj instanceof short[]) {
            return ((short[]) obj)[i] & 65535;
        }
        return ((int[]) obj)[i];
    }

    public static int v(int i) {
        int i5;
        if (i < 32) {
            i5 = 4;
        } else {
            i5 = 2;
        }
        return i5 * (i + 1);
    }

    public static Object y(int i) {
        if (i >= 2 && i <= 1073741824 && Integer.highestOneBit(i) == i) {
            if (i <= 256) {
                return new byte[i];
            }
            if (i <= 65536) {
                return new short[i];
            }
            return new int[i];
        }
        StringBuilder sb = new StringBuilder(52);
        sb.append("must be power of 2 between 2^1 and 2^30: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int zn(int i, int i5) {
        return i & i5;
    }
}
