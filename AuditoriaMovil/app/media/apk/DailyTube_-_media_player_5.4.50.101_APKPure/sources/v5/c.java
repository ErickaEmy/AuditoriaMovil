package v5;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class c {
    public static final byte[] y = {0, 0, 0, 1};

    /* renamed from: n3  reason: collision with root package name */
    public static final float[] f14308n3 = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: zn  reason: collision with root package name */
    public static final Object f14309zn = new Object();

    /* renamed from: gv  reason: collision with root package name */
    public static int[] f14307gv = new int[10];

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final int f14310n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final boolean f14311zn;

        public n3(int i, int i5, boolean z2) {
            this.y = i;
            this.f14310n3 = i5;
            this.f14311zn = z2;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        public final int f14312a;

        /* renamed from: c5  reason: collision with root package name */
        public final int f14313c5;

        /* renamed from: f  reason: collision with root package name */
        public final int f14314f;

        /* renamed from: fb  reason: collision with root package name */
        public final int f14315fb;

        /* renamed from: gv  reason: collision with root package name */
        public final int f14316gv;

        /* renamed from: i9  reason: collision with root package name */
        public final float f14317i9;

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f14318n3;

        /* renamed from: s  reason: collision with root package name */
        public final int f14319s;

        /* renamed from: t  reason: collision with root package name */
        public final int f14320t;

        /* renamed from: tl  reason: collision with root package name */
        public final int f14321tl;

        /* renamed from: v  reason: collision with root package name */
        public final int[] f14322v;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f14323zn;

        public y(int i, boolean z2, int i5, int i6, int[] iArr, int i8, int i10, int i11, int i12, float f4, int i13, int i14, int i15) {
            this.y = i;
            this.f14318n3 = z2;
            this.f14323zn = i5;
            this.f14316gv = i6;
            this.f14322v = iArr;
            this.f14312a = i8;
            this.f14315fb = i10;
            this.f14319s = i11;
            this.f14313c5 = i12;
            this.f14317i9 = f4;
            this.f14314f = i13;
            this.f14320t = i14;
            this.f14321tl = i15;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: a  reason: collision with root package name */
        public final int f14324a;

        /* renamed from: c5  reason: collision with root package name */
        public final boolean f14325c5;

        /* renamed from: f  reason: collision with root package name */
        public final int f14326f;

        /* renamed from: fb  reason: collision with root package name */
        public final int f14327fb;

        /* renamed from: gv  reason: collision with root package name */
        public final int f14328gv;

        /* renamed from: i9  reason: collision with root package name */
        public final boolean f14329i9;

        /* renamed from: n3  reason: collision with root package name */
        public final int f14330n3;

        /* renamed from: s  reason: collision with root package name */
        public final float f14331s;

        /* renamed from: t  reason: collision with root package name */
        public final int f14332t;

        /* renamed from: tl  reason: collision with root package name */
        public final int f14333tl;

        /* renamed from: v  reason: collision with root package name */
        public final int f14334v;

        /* renamed from: wz  reason: collision with root package name */
        public final boolean f14335wz;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f14336zn;

        public zn(int i, int i5, int i6, int i8, int i10, int i11, int i12, float f4, boolean z2, boolean z3, int i13, int i14, int i15, boolean z4) {
            this.y = i;
            this.f14330n3 = i5;
            this.f14336zn = i6;
            this.f14328gv = i8;
            this.f14334v = i10;
            this.f14324a = i11;
            this.f14327fb = i12;
            this.f14331s = f4;
            this.f14325c5 = z2;
            this.f14329i9 = z3;
            this.f14326f = i13;
            this.f14332t = i14;
            this.f14333tl = i15;
            this.f14335wz = z4;
        }
    }

    public static int a(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static v5.c.y c5(byte[] r23, int r24, int r25) {
        /*
            Method dump skipped, instructions count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v5.c.c5(byte[], int, int):v5.c$y");
    }

    public static n3 f(byte[] bArr, int i, int i5) {
        mg mgVar = new mg(bArr, i, i5);
        int s2 = mgVar.s();
        int s3 = mgVar.s();
        mgVar.f();
        return new n3(s2, s3, mgVar.gv());
    }

    public static boolean fb(@Nullable String str, byte b2) {
        if ("video/avc".equals(str) && (b2 & 31) == 6) {
            return true;
        }
        if ("video/hevc".equals(str) && ((b2 & 126) >> 1) == 39) {
            return true;
        }
        return false;
    }

    public static int gv(byte[] bArr, int i, int i5) {
        while (i < i5 - 2) {
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 3) {
                return i;
            }
            i++;
        }
        return i5;
    }

    public static n3 i9(byte[] bArr, int i, int i5) {
        return f(bArr, i + 1, i5);
    }

    public static void n3(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i5 = 0;
        while (true) {
            int i6 = i + 1;
            if (i6 < position) {
                int i8 = byteBuffer.get(i) & 255;
                if (i5 == 3) {
                    if (i8 == 1 && (byteBuffer.get(i6) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (i8 == 0) {
                    i5++;
                }
                if (i8 != 0) {
                    i5 = 0;
                }
                i = i6;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static int p(byte[] bArr, int i) {
        int i5;
        synchronized (f14309zn) {
            int i6 = 0;
            int i8 = 0;
            while (i6 < i) {
                try {
                    i6 = gv(bArr, i6, i);
                    if (i6 < i) {
                        int[] iArr = f14307gv;
                        if (iArr.length <= i8) {
                            f14307gv = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f14307gv[i8] = i6;
                        i6 += 3;
                        i8++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i5 = i - i8;
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < i8; i12++) {
                int i13 = f14307gv[i12] - i11;
                System.arraycopy(bArr, i11, bArr, i10, i13);
                int i14 = i10 + i13;
                int i15 = i14 + 1;
                bArr[i14] = 0;
                i10 = i14 + 2;
                bArr[i15] = 0;
                i11 += i13 + 3;
            }
            System.arraycopy(bArr, i11, bArr, i10, i5 - i10);
        }
        return i5;
    }

    public static y s(byte[] bArr, int i, int i5) {
        return c5(bArr, i + 2, i5);
    }

    public static zn t(byte[] bArr, int i, int i5) {
        return tl(bArr, i + 1, i5);
    }

    public static zn tl(byte[] bArr, int i, int i5) {
        int s2;
        boolean z2;
        int i6;
        int i8;
        int i10;
        boolean z3;
        boolean z4;
        int i11;
        float f4;
        int i12;
        int i13;
        mg mgVar = new mg(bArr, i, i5);
        int v2 = mgVar.v(8);
        int v3 = mgVar.v(8);
        int v4 = mgVar.v(8);
        int s3 = mgVar.s();
        int i14 = 1;
        if (v2 != 100 && v2 != 110 && v2 != 122 && v2 != 244 && v2 != 44 && v2 != 83 && v2 != 86 && v2 != 118 && v2 != 128 && v2 != 138) {
            s2 = 1;
            z2 = false;
        } else {
            s2 = mgVar.s();
            if (s2 == 3) {
                z2 = mgVar.gv();
            } else {
                z2 = false;
            }
            mgVar.s();
            mgVar.s();
            mgVar.f();
            if (mgVar.gv()) {
                if (s2 != 3) {
                    i6 = 8;
                } else {
                    i6 = 12;
                }
                for (int i15 = 0; i15 < i6; i15++) {
                    if (mgVar.gv()) {
                        if (i15 < 6) {
                            i8 = 16;
                        } else {
                            i8 = 64;
                        }
                        xc(mgVar, i8);
                    }
                }
            }
        }
        int s4 = mgVar.s() + 4;
        int s5 = mgVar.s();
        if (s5 == 0) {
            i10 = s2;
            z3 = z2;
            i11 = mgVar.s() + 4;
            z4 = false;
        } else {
            if (s5 == 1) {
                boolean gv2 = mgVar.gv();
                mgVar.fb();
                mgVar.fb();
                z3 = z2;
                long s7 = mgVar.s();
                i10 = s2;
                for (int i16 = 0; i16 < s7; i16++) {
                    mgVar.s();
                }
                z4 = gv2;
            } else {
                i10 = s2;
                z3 = z2;
                z4 = false;
            }
            i11 = 0;
        }
        int s9 = mgVar.s();
        mgVar.f();
        int s10 = mgVar.s() + 1;
        boolean gv3 = mgVar.gv();
        int s11 = (2 - (gv3 ? 1 : 0)) * (mgVar.s() + 1);
        if (!gv3) {
            mgVar.f();
        }
        mgVar.f();
        int i17 = s10 * 16;
        int i18 = s11 * 16;
        if (mgVar.gv()) {
            int s12 = mgVar.s();
            int s13 = mgVar.s();
            int s14 = mgVar.s();
            int s15 = mgVar.s();
            if (i10 == 0) {
                i13 = 2 - (gv3 ? 1 : 0);
            } else {
                int i19 = i10;
                if (i19 == 3) {
                    i12 = 1;
                } else {
                    i12 = 2;
                }
                if (i19 == 1) {
                    i14 = 2;
                }
                int i20 = (2 - (gv3 ? 1 : 0)) * i14;
                i14 = i12;
                i13 = i20;
            }
            i17 -= (s12 + s13) * i14;
            i18 -= (s14 + s15) * i13;
        }
        int i21 = i17;
        int i22 = i18;
        float f6 = 1.0f;
        if (mgVar.gv() && mgVar.gv()) {
            int v6 = mgVar.v(8);
            if (v6 == 255) {
                int v7 = mgVar.v(16);
                int v8 = mgVar.v(16);
                if (v7 != 0 && v8 != 0) {
                    f6 = v7 / v8;
                }
                f4 = f6;
            } else {
                float[] fArr = f14308n3;
                if (v6 < fArr.length) {
                    f4 = fArr[v6];
                } else {
                    r.c5("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + v6);
                }
            }
            return new zn(v2, v3, v4, s3, s9, i21, i22, f4, z3, gv3, s4, s5, i11, z4);
        }
        f4 = 1.0f;
        return new zn(v2, v3, v4, s3, s9, i21, i22, f4, z3, gv3, s4, s5, i11, z4);
    }

    public static int v(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static void w(mg mgVar) {
        int s2 = mgVar.s();
        int[] iArr = new int[0];
        int[] iArr2 = new int[0];
        int i = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < s2; i6++) {
            if (i6 != 0 && mgVar.gv()) {
                int i8 = i + i5;
                int s3 = (1 - ((mgVar.gv() ? 1 : 0) * 2)) * (mgVar.s() + 1);
                int i10 = i8 + 1;
                boolean[] zArr = new boolean[i10];
                for (int i11 = 0; i11 <= i8; i11++) {
                    if (!mgVar.gv()) {
                        zArr[i11] = mgVar.gv();
                    } else {
                        zArr[i11] = true;
                    }
                }
                int[] iArr3 = new int[i10];
                int[] iArr4 = new int[i10];
                int i12 = 0;
                for (int i13 = i5 - 1; i13 >= 0; i13--) {
                    int i14 = iArr2[i13] + s3;
                    if (i14 < 0 && zArr[i + i13]) {
                        iArr3[i12] = i14;
                        i12++;
                    }
                }
                if (s3 < 0 && zArr[i8]) {
                    iArr3[i12] = s3;
                    i12++;
                }
                for (int i15 = 0; i15 < i; i15++) {
                    int i16 = iArr[i15] + s3;
                    if (i16 < 0 && zArr[i15]) {
                        iArr3[i12] = i16;
                        i12++;
                    }
                }
                int[] copyOf = Arrays.copyOf(iArr3, i12);
                int i17 = 0;
                for (int i18 = i - 1; i18 >= 0; i18--) {
                    int i19 = iArr[i18] + s3;
                    if (i19 > 0 && zArr[i18]) {
                        iArr4[i17] = i19;
                        i17++;
                    }
                }
                if (s3 > 0 && zArr[i8]) {
                    iArr4[i17] = s3;
                    i17++;
                }
                for (int i20 = 0; i20 < i5; i20++) {
                    int i21 = iArr2[i20] + s3;
                    if (i21 > 0 && zArr[i + i20]) {
                        iArr4[i17] = i21;
                        i17++;
                    }
                }
                iArr2 = Arrays.copyOf(iArr4, i17);
                iArr = copyOf;
                i = i12;
                i5 = i17;
            } else {
                int s4 = mgVar.s();
                int s5 = mgVar.s();
                int[] iArr5 = new int[s4];
                for (int i22 = 0; i22 < s4; i22++) {
                    iArr5[i22] = mgVar.s() + 1;
                    mgVar.f();
                }
                int[] iArr6 = new int[s5];
                for (int i23 = 0; i23 < s5; i23++) {
                    iArr6[i23] = mgVar.s() + 1;
                    mgVar.f();
                }
                i = s4;
                iArr = iArr5;
                i5 = s5;
                iArr2 = iArr6;
            }
        }
    }

    public static void wz(mg mgVar) {
        for (int i = 0; i < 4; i++) {
            int i5 = 0;
            while (i5 < 6) {
                int i6 = 1;
                if (!mgVar.gv()) {
                    mgVar.s();
                } else {
                    int min = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        mgVar.fb();
                    }
                    for (int i8 = 0; i8 < min; i8++) {
                        mgVar.fb();
                    }
                }
                if (i == 3) {
                    i6 = 3;
                }
                i5 += i6;
            }
        }
    }

    public static void xc(mg mgVar, int i) {
        int i5 = 8;
        int i6 = 8;
        for (int i8 = 0; i8 < i; i8++) {
            if (i5 != 0) {
                i5 = ((mgVar.fb() + i6) + 256) % 256;
            }
            if (i5 != 0) {
                i6 = i5;
            }
        }
    }

    public static void y(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static int zn(byte[] bArr, int i, int i5, boolean[] zArr) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i6 = i5 - i;
        boolean z5 = false;
        if (i6 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        if (i6 == 0) {
            return i5;
        }
        if (zArr[0]) {
            y(zArr);
            return i - 3;
        } else if (i6 > 1 && zArr[1] && bArr[i] == 1) {
            y(zArr);
            return i - 2;
        } else if (i6 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            y(zArr);
            return i - 1;
        } else {
            int i8 = i5 - 1;
            int i10 = i + 2;
            while (i10 < i8) {
                byte b2 = bArr[i10];
                if ((b2 & 254) == 0) {
                    int i11 = i10 - 2;
                    if (bArr[i11] == 0 && bArr[i10 - 1] == 0 && b2 == 1) {
                        y(zArr);
                        return i11;
                    }
                    i10 -= 2;
                }
                i10 += 3;
            }
            if (i6 <= 2 ? !(i6 != 2 ? !zArr[1] || bArr[i8] != 1 : !zArr[2] || bArr[i5 - 2] != 0 || bArr[i8] != 1) : !(bArr[i5 - 3] != 0 || bArr[i5 - 2] != 0 || bArr[i8] != 1)) {
                z3 = true;
            } else {
                z3 = false;
            }
            zArr[0] = z3;
            if (i6 <= 1 ? !(!zArr[2] || bArr[i8] != 0) : !(bArr[i5 - 2] != 0 || bArr[i8] != 0)) {
                z4 = true;
            } else {
                z4 = false;
            }
            zArr[1] = z4;
            if (bArr[i8] == 0) {
                z5 = true;
            }
            zArr[2] = z5;
            return i5;
        }
    }
}
