package d9;

import java.nio.ShortBuffer;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class k5 {

    /* renamed from: a  reason: collision with root package name */
    public final int f7051a;

    /* renamed from: c5  reason: collision with root package name */
    public final short[] f7052c5;

    /* renamed from: co  reason: collision with root package name */
    public int f7053co;

    /* renamed from: f  reason: collision with root package name */
    public int f7054f;

    /* renamed from: fb  reason: collision with root package name */
    public final int f7055fb;

    /* renamed from: gv  reason: collision with root package name */
    public final float f7056gv;

    /* renamed from: i9  reason: collision with root package name */
    public short[] f7057i9;

    /* renamed from: mt  reason: collision with root package name */
    public int f7058mt;

    /* renamed from: n3  reason: collision with root package name */
    public final int f7059n3;

    /* renamed from: p  reason: collision with root package name */
    public int f7060p;

    /* renamed from: r  reason: collision with root package name */
    public int f7061r;

    /* renamed from: s  reason: collision with root package name */
    public final int f7062s;

    /* renamed from: t  reason: collision with root package name */
    public short[] f7063t;

    /* renamed from: tl  reason: collision with root package name */
    public int f7064tl;

    /* renamed from: v  reason: collision with root package name */
    public final float f7065v;

    /* renamed from: w  reason: collision with root package name */
    public int f7066w;

    /* renamed from: wz  reason: collision with root package name */
    public short[] f7067wz;

    /* renamed from: x4  reason: collision with root package name */
    public int f7068x4;

    /* renamed from: xc  reason: collision with root package name */
    public int f7069xc;
    public final int y;

    /* renamed from: z  reason: collision with root package name */
    public int f7070z;

    /* renamed from: zn  reason: collision with root package name */
    public final float f7071zn;

    public k5(int i, int i5, float f4, float f6, int i6) {
        this.y = i;
        this.f7059n3 = i5;
        this.f7071zn = f4;
        this.f7056gv = f6;
        this.f7065v = i / i6;
        this.f7051a = i / 400;
        int i8 = i / 65;
        this.f7055fb = i8;
        int i10 = i8 * 2;
        this.f7062s = i10;
        this.f7052c5 = new short[i10];
        this.f7057i9 = new short[i10 * i5];
        this.f7063t = new short[i10 * i5];
        this.f7067wz = new short[i10 * i5];
    }

    public static void w(int i, int i5, short[] sArr, int i6, short[] sArr2, int i8, short[] sArr3, int i10) {
        for (int i11 = 0; i11 < i5; i11++) {
            int i12 = (i6 * i5) + i11;
            int i13 = (i10 * i5) + i11;
            int i14 = (i8 * i5) + i11;
            for (int i15 = 0; i15 < i; i15++) {
                sArr[i12] = (short) (((sArr2[i14] * (i - i15)) + (sArr3[i13] * i15)) / i);
                i12 += i5;
                i14 += i5;
                i13 += i5;
            }
        }
    }

    public final short[] a(short[] sArr, int i, int i5) {
        int length = sArr.length;
        int i6 = this.f7059n3;
        int i8 = length / i6;
        if (i + i5 <= i8) {
            return sArr;
        }
        return Arrays.copyOf(sArr, (((i8 * 3) / 2) + i5) * i6);
    }

    public void c5() {
        this.f7054f = 0;
        this.f7064tl = 0;
        this.f7069xc = 0;
        this.f7066w = 0;
        this.f7060p = 0;
        this.f7058mt = 0;
        this.f7053co = 0;
        this.f7070z = 0;
        this.f7061r = 0;
        this.f7068x4 = 0;
    }

    public void co() {
        int i;
        int i5 = this.f7054f;
        float f4 = this.f7071zn;
        float f6 = this.f7056gv;
        int i6 = this.f7064tl + ((int) ((((i5 / (f4 / f6)) + this.f7069xc) / (this.f7065v * f6)) + 0.5f));
        this.f7057i9 = a(this.f7057i9, i5, (this.f7062s * 2) + i5);
        int i8 = 0;
        while (true) {
            i = this.f7062s;
            int i10 = this.f7059n3;
            if (i8 >= i * 2 * i10) {
                break;
            }
            this.f7057i9[(i10 * i5) + i8] = 0;
            i8++;
        }
        this.f7054f += i * 2;
        mt();
        if (this.f7064tl > i6) {
            this.f7064tl = i6;
        }
        this.f7054f = 0;
        this.f7058mt = 0;
        this.f7069xc = 0;
    }

    public int f() {
        return this.f7064tl * this.f7059n3 * 2;
    }

    public final int fb(short[] sArr, int i) {
        int i5;
        int i6;
        int i8;
        int i10 = this.y;
        if (i10 > 4000) {
            i5 = i10 / 4000;
        } else {
            i5 = 1;
        }
        if (this.f7059n3 == 1 && i5 == 1) {
            i6 = s(sArr, i, this.f7051a, this.f7055fb);
        } else {
            v(sArr, i, i5);
            int s2 = s(this.f7052c5, 0, this.f7051a / i5, this.f7055fb / i5);
            if (i5 != 1) {
                int i11 = s2 * i5;
                int i12 = i5 * 4;
                int i13 = i11 - i12;
                int i14 = i11 + i12;
                int i15 = this.f7051a;
                if (i13 < i15) {
                    i13 = i15;
                }
                int i16 = this.f7055fb;
                if (i14 > i16) {
                    i14 = i16;
                }
                if (this.f7059n3 == 1) {
                    i6 = s(sArr, i, i13, i14);
                } else {
                    v(sArr, i, 1);
                    i6 = s(this.f7052c5, 0, i13, i14);
                }
            } else {
                i6 = s2;
            }
        }
        if (p(this.f7061r, this.f7068x4)) {
            i8 = this.f7053co;
        } else {
            i8 = i6;
        }
        this.f7070z = this.f7061r;
        this.f7053co = i6;
        return i8;
    }

    public final void gv(short[] sArr, int i, int i5) {
        short[] a2 = a(this.f7063t, this.f7064tl, i5);
        this.f7063t = a2;
        int i6 = this.f7059n3;
        System.arraycopy(sArr, i * i6, a2, this.f7064tl * i6, i6 * i5);
        this.f7064tl += i5;
    }

    public final int i4(short[] sArr, int i, float f4, int i5) {
        int i6;
        if (f4 >= 2.0f) {
            i6 = (int) (i5 / (f4 - 1.0f));
        } else {
            this.f7058mt = (int) ((i5 * (2.0f - f4)) / (f4 - 1.0f));
            i6 = i5;
        }
        short[] a2 = a(this.f7063t, this.f7064tl, i6);
        this.f7063t = a2;
        w(i6, this.f7059n3, a2, this.f7064tl, sArr, i, sArr, i + i5);
        this.f7064tl += i6;
        return i6;
    }

    public void i9(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f7059n3, this.f7064tl);
        shortBuffer.put(this.f7063t, 0, this.f7059n3 * min);
        int i = this.f7064tl - min;
        this.f7064tl = i;
        short[] sArr = this.f7063t;
        int i5 = this.f7059n3;
        System.arraycopy(sArr, min * i5, sArr, 0, i * i5);
    }

    public final void mt() {
        int i = this.f7064tl;
        float f4 = this.f7071zn;
        float f6 = this.f7056gv;
        float f9 = f4 / f6;
        float f10 = this.f7065v * f6;
        double d2 = f9;
        if (d2 <= 1.00001d && d2 >= 0.99999d) {
            gv(this.f7057i9, 0, this.f7054f);
            this.f7054f = 0;
        } else {
            n3(f9);
        }
        if (f10 != 1.0f) {
            y(f10, i);
        }
    }

    public final void n3(float f4) {
        int tl2;
        int i = this.f7054f;
        if (i < this.f7062s) {
            return;
        }
        int i5 = 0;
        do {
            if (this.f7058mt > 0) {
                tl2 = zn(i5);
            } else {
                int fb2 = fb(this.f7057i9, i5);
                if (f4 > 1.0d) {
                    tl2 = fb2 + i4(this.f7057i9, i5, f4, fb2);
                } else {
                    tl2 = tl(this.f7057i9, i5, f4, fb2);
                }
            }
            i5 += tl2;
        } while (this.f7062s + i5 <= i);
        x4(i5);
    }

    public final boolean p(int i, int i5) {
        if (i == 0 || this.f7053co == 0 || i5 > i * 3 || i * 2 <= this.f7070z * 3) {
            return false;
        }
        return true;
    }

    public final void r(int i) {
        if (i == 0) {
            return;
        }
        short[] sArr = this.f7067wz;
        int i5 = this.f7059n3;
        System.arraycopy(sArr, i * i5, sArr, 0, (this.f7069xc - i) * i5);
        this.f7069xc -= i;
    }

    public final int s(short[] sArr, int i, int i5, int i6) {
        int i8 = i * this.f7059n3;
        int i10 = 255;
        int i11 = 1;
        int i12 = 0;
        int i13 = 0;
        while (i5 <= i6) {
            int i14 = 0;
            for (int i15 = 0; i15 < i5; i15++) {
                i14 += Math.abs(sArr[i8 + i15] - sArr[(i8 + i5) + i15]);
            }
            if (i14 * i12 < i11 * i5) {
                i12 = i5;
                i11 = i14;
            }
            if (i14 * i10 > i13 * i5) {
                i10 = i5;
                i13 = i14;
            }
            i5++;
        }
        this.f7061r = i11 / i12;
        this.f7068x4 = i13 / i10;
        return i12;
    }

    public int t() {
        return this.f7054f * this.f7059n3 * 2;
    }

    public final int tl(short[] sArr, int i, float f4, int i5) {
        int i6;
        if (f4 < 0.5f) {
            i6 = (int) ((i5 * f4) / (1.0f - f4));
        } else {
            this.f7058mt = (int) ((i5 * ((2.0f * f4) - 1.0f)) / (1.0f - f4));
            i6 = i5;
        }
        int i8 = i5 + i6;
        short[] a2 = a(this.f7063t, this.f7064tl, i8);
        this.f7063t = a2;
        int i10 = this.f7059n3;
        System.arraycopy(sArr, i * i10, a2, this.f7064tl * i10, i10 * i5);
        w(i6, this.f7059n3, this.f7063t, this.f7064tl + i5, sArr, i + i5, sArr, i);
        this.f7064tl += i8;
        return i6;
    }

    public final void v(short[] sArr, int i, int i5) {
        int i6 = this.f7062s / i5;
        int i8 = this.f7059n3;
        int i10 = i5 * i8;
        int i11 = i * i8;
        for (int i12 = 0; i12 < i6; i12++) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                i13 += sArr[(i12 * i10) + i11 + i14];
            }
            this.f7052c5[i12] = (short) (i13 / i10);
        }
    }

    public final short wz(short[] sArr, int i, int i5, int i6) {
        short s2 = sArr[i];
        short s3 = sArr[i + this.f7059n3];
        int i8 = this.f7060p * i5;
        int i10 = this.f7066w;
        int i11 = i10 * i6;
        int i12 = (i10 + 1) * i6;
        int i13 = i12 - i8;
        int i14 = i12 - i11;
        return (short) (((s2 * i13) + ((i14 - i13) * s3)) / i14);
    }

    public final void x4(int i) {
        int i5 = this.f7054f - i;
        short[] sArr = this.f7057i9;
        int i6 = this.f7059n3;
        System.arraycopy(sArr, i * i6, sArr, 0, i6 * i5);
        this.f7054f = i5;
    }

    public final void xc(int i) {
        int i5 = this.f7064tl - i;
        short[] a2 = a(this.f7067wz, this.f7069xc, i5);
        this.f7067wz = a2;
        short[] sArr = this.f7063t;
        int i6 = this.f7059n3;
        System.arraycopy(sArr, i * i6, a2, this.f7069xc * i6, i6 * i5);
        this.f7064tl = i;
        this.f7069xc += i5;
    }

    public final void y(float f4, int i) {
        int i5;
        int i6;
        if (this.f7064tl == i) {
            return;
        }
        int i8 = this.y;
        int i10 = (int) (i8 / f4);
        while (true) {
            if (i10 <= 16384 && i8 <= 16384) {
                break;
            }
            i10 /= 2;
            i8 /= 2;
        }
        xc(i);
        int i11 = 0;
        while (true) {
            int i12 = this.f7069xc;
            boolean z2 = true;
            if (i11 < i12 - 1) {
                while (true) {
                    i5 = this.f7066w;
                    int i13 = (i5 + 1) * i10;
                    i6 = this.f7060p;
                    if (i13 <= i6 * i8) {
                        break;
                    }
                    this.f7063t = a(this.f7063t, this.f7064tl, 1);
                    int i14 = 0;
                    while (true) {
                        int i15 = this.f7059n3;
                        if (i14 < i15) {
                            this.f7063t[(this.f7064tl * i15) + i14] = wz(this.f7067wz, (i15 * i11) + i14, i8, i10);
                            i14++;
                        }
                    }
                    this.f7060p++;
                    this.f7064tl++;
                }
                int i16 = i5 + 1;
                this.f7066w = i16;
                if (i16 == i8) {
                    this.f7066w = 0;
                    if (i6 != i10) {
                        z2 = false;
                    }
                    v5.y.fb(z2);
                    this.f7060p = 0;
                }
                i11++;
            } else {
                r(i12 - 1);
                return;
            }
        }
    }

    public void z(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.f7059n3;
        int i5 = remaining / i;
        short[] a2 = a(this.f7057i9, this.f7054f, i5);
        this.f7057i9 = a2;
        shortBuffer.get(a2, this.f7054f * this.f7059n3, ((i * i5) * 2) / 2);
        this.f7054f += i5;
        mt();
    }

    public final int zn(int i) {
        int min = Math.min(this.f7062s, this.f7058mt);
        gv(this.f7057i9, i, min);
        this.f7058mt -= min;
        return min;
    }
}
