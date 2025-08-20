package z;
/* loaded from: classes.dex */
public class gv {
    public static final int[] y = new int[0];

    /* renamed from: n3  reason: collision with root package name */
    public static final long[] f15526n3 = new long[0];

    /* renamed from: zn  reason: collision with root package name */
    public static final Object[] f15527zn = new Object[0];

    public static int a(int i) {
        return gv(i * 8) / 8;
    }

    public static int gv(int i) {
        for (int i5 = 4; i5 < 32; i5++) {
            int i6 = (1 << i5) - 12;
            if (i <= i6) {
                return i6;
            }
        }
        return i;
    }

    public static int n3(long[] jArr, int i, long j2) {
        int i5 = i - 1;
        int i6 = 0;
        while (i6 <= i5) {
            int i8 = (i6 + i5) >>> 1;
            int i10 = (jArr[i8] > j2 ? 1 : (jArr[i8] == j2 ? 0 : -1));
            if (i10 < 0) {
                i6 = i8 + 1;
            } else if (i10 > 0) {
                i5 = i8 - 1;
            } else {
                return i8;
            }
        }
        return ~i6;
    }

    public static int v(int i) {
        return gv(i * 4) / 4;
    }

    public static int y(int[] iArr, int i, int i5) {
        int i6 = i - 1;
        int i8 = 0;
        while (i8 <= i6) {
            int i10 = (i8 + i6) >>> 1;
            int i11 = iArr[i10];
            if (i11 < i5) {
                i8 = i10 + 1;
            } else if (i11 > i5) {
                i6 = i10 - 1;
            } else {
                return i10;
            }
        }
        return ~i8;
    }

    public static boolean zn(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }
}
