package ha;

import v5.j5;
/* loaded from: classes.dex */
public final class gv {

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: a  reason: collision with root package name */
        public final long f8841a;

        /* renamed from: gv  reason: collision with root package name */
        public final long[] f8842gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int[] f8843n3;

        /* renamed from: v  reason: collision with root package name */
        public final int[] f8844v;
        public final long[] y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f8845zn;

        public n3(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j2) {
            this.y = jArr;
            this.f8843n3 = iArr;
            this.f8845zn = i;
            this.f8842gv = jArr2;
            this.f8844v = iArr2;
            this.f8841a = j2;
        }
    }

    public static n3 y(int i, long[] jArr, int[] iArr, long j2) {
        int i5 = 8192 / i;
        int i6 = 0;
        for (int i8 : iArr) {
            i6 += j5.t(i8, i5);
        }
        long[] jArr2 = new long[i6];
        int[] iArr2 = new int[i6];
        long[] jArr3 = new long[i6];
        int[] iArr3 = new int[i6];
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < iArr.length; i13++) {
            int i14 = iArr[i13];
            long j4 = jArr[i13];
            while (i14 > 0) {
                int min = Math.min(i5, i14);
                jArr2[i11] = j4;
                int i15 = i * min;
                iArr2[i11] = i15;
                i12 = Math.max(i12, i15);
                jArr3[i11] = i10 * j2;
                iArr3[i11] = 1;
                j4 += iArr2[i11];
                i10 += min;
                i14 -= min;
                i11++;
            }
        }
        return new n3(jArr2, iArr2, i12, jArr3, iArr3, j2 * i10);
    }
}
