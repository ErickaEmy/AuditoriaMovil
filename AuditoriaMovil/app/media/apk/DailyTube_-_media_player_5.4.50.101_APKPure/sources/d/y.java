package d;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public final float f6942a;

    /* renamed from: c5  reason: collision with root package name */
    public final float f6943c5;

    /* renamed from: fb  reason: collision with root package name */
    public final float f6944fb;

    /* renamed from: gv  reason: collision with root package name */
    public final float f6945gv;

    /* renamed from: n3  reason: collision with root package name */
    public final float f6946n3;

    /* renamed from: s  reason: collision with root package name */
    public final float f6947s;

    /* renamed from: v  reason: collision with root package name */
    public final float f6948v;
    public final float y;

    /* renamed from: zn  reason: collision with root package name */
    public final float f6949zn;

    public y(float f4, float f6, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
        this.y = f4;
        this.f6946n3 = f6;
        this.f6949zn = f9;
        this.f6945gv = f10;
        this.f6948v = f11;
        this.f6942a = f12;
        this.f6944fb = f13;
        this.f6947s = f14;
        this.f6943c5 = f15;
    }

    @NonNull
    public static y a(float f4, float f6, float f9, t tVar) {
        double d2;
        float n32 = (4.0f / tVar.n3()) * ((float) Math.sqrt(f4 / 100.0d)) * (tVar.y() + 4.0f) * tVar.gv();
        float gv2 = f6 * tVar.gv();
        float sqrt = ((float) Math.sqrt(((f6 / ((float) Math.sqrt(d2))) * tVar.n3()) / (tVar.y() + 4.0f))) * 50.0f;
        float f10 = (1.7f * f4) / ((0.007f * f4) + 1.0f);
        float log = ((float) Math.log((gv2 * 0.0228d) + 1.0d)) * 43.85965f;
        double d3 = (3.1415927f * f9) / 180.0f;
        return new y(f9, f6, f4, n32, gv2, sqrt, f10, log * ((float) Math.cos(d3)), log * ((float) Math.sin(d3)));
    }

    public static void gv(int i, @NonNull t tVar, @Nullable float[] fArr, @NonNull float[] fArr2) {
        float f4;
        float pow;
        n3.a(i, fArr2);
        float[][] fArr3 = n3.y;
        float f6 = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f9 = fArr2[1];
        float f10 = fArr2[2];
        float f11 = (fArr4[0] * f6) + (fArr4[1] * f9) + (fArr4[2] * f10);
        float[] fArr5 = fArr3[1];
        float f12 = (fArr5[0] * f6) + (fArr5[1] * f9) + (fArr5[2] * f10);
        float[] fArr6 = fArr3[2];
        float f13 = tVar.c5()[0] * f11;
        float f14 = tVar.c5()[1] * f12;
        float f15 = tVar.c5()[2] * ((f6 * fArr6[0]) + (f9 * fArr6[1]) + (f10 * fArr6[2]));
        float pow2 = (float) Math.pow((tVar.zn() * Math.abs(f13)) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((tVar.zn() * Math.abs(f14)) / 100.0d, 0.42d);
        float pow4 = (float) Math.pow((tVar.zn() * Math.abs(f15)) / 100.0d, 0.42d);
        float signum = ((Math.signum(f13) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum2 = ((Math.signum(f14) * 400.0f) * pow3) / (pow3 + 27.13f);
        float signum3 = ((Math.signum(f15) * 400.0f) * pow4) / (pow4 + 27.13f);
        double d2 = signum3;
        float f16 = ((float) (((signum * 11.0d) + (signum2 * (-12.0d))) + d2)) / 11.0f;
        float f17 = ((float) ((signum + signum2) - (d2 * 2.0d))) / 9.0f;
        float f18 = signum2 * 20.0f;
        float f19 = (((signum * 20.0f) + f18) + (21.0f * signum3)) / 20.0f;
        float f20 = (((signum * 40.0f) + f18) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f17, f16)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f21 = (3.1415927f * atan2) / 180.0f;
        float pow5 = ((float) Math.pow((f20 * tVar.a()) / tVar.y(), tVar.n3() * tVar.i9())) * 100.0f;
        float n32 = (4.0f / tVar.n3()) * ((float) Math.sqrt(pow5 / 100.0f)) * (tVar.y() + 4.0f) * tVar.gv();
        if (atan2 < 20.14d) {
            f4 = 360.0f + atan2;
        } else {
            f4 = atan2;
        }
        float sqrt = ((float) Math.sqrt(pow5 / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, tVar.v()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((f4 * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * tVar.fb()) * tVar.s()) * ((float) Math.sqrt((f16 * f16) + (f17 * f17)))) / (f19 + 0.305f), 0.9d));
        float gv2 = tVar.gv() * sqrt;
        float sqrt2 = ((float) Math.sqrt((pow * tVar.n3()) / (tVar.y() + 4.0f))) * 50.0f;
        float f22 = (1.7f * pow5) / ((0.007f * pow5) + 1.0f);
        float log = ((float) Math.log((0.0228f * gv2) + 1.0f)) * 43.85965f;
        double d3 = f21;
        float cos = ((float) Math.cos(d3)) * log;
        float sin = log * ((float) Math.sin(d3));
        fArr2[0] = atan2;
        fArr2[1] = sqrt;
        if (fArr != null) {
            fArr[0] = pow5;
            fArr[1] = n32;
            fArr[2] = gv2;
            fArr[3] = sqrt2;
            fArr[4] = f22;
            fArr[5] = cos;
            fArr[6] = sin;
        }
    }

    @Nullable
    public static y n3(float f4, float f6, float f9) {
        float f10 = 100.0f;
        float f11 = 1000.0f;
        y yVar = null;
        float f12 = 1000.0f;
        float f13 = 0.0f;
        while (Math.abs(f13 - f10) > 0.01f) {
            float f14 = ((f10 - f13) / 2.0f) + f13;
            int w4 = v(f14, f6, f4).w();
            float n32 = n3.n3(w4);
            float abs = Math.abs(f9 - n32);
            if (abs < 0.2f) {
                y zn2 = zn(w4);
                float y = zn2.y(v(zn2.f(), zn2.c5(), f4));
                if (y <= 1.0f) {
                    yVar = zn2;
                    f11 = abs;
                    f12 = y;
                }
            }
            if (f11 == 0.0f && f12 == 0.0f) {
                break;
            } else if (n32 < f9) {
                f13 = f14;
            } else {
                f10 = f14;
            }
        }
        return yVar;
    }

    public static int tl(float f4, float f6, float f9) {
        return wz(f4, f6, f9, t.f6924f);
    }

    @NonNull
    public static y v(float f4, float f6, float f9) {
        return a(f4, f6, f9, t.f6924f);
    }

    public static int wz(float f4, float f6, float f9, @NonNull t tVar) {
        float min;
        if (f6 >= 1.0d && Math.round(f9) > 0.0d && Math.round(f9) < 100.0d) {
            if (f4 < 0.0f) {
                min = 0.0f;
            } else {
                min = Math.min(360.0f, f4);
            }
            float f10 = f6;
            y yVar = null;
            float f11 = 0.0f;
            boolean z2 = true;
            while (Math.abs(f11 - f6) >= 0.4f) {
                y n32 = n3(min, f10, f9);
                if (z2) {
                    if (n32 != null) {
                        return n32.xc(tVar);
                    }
                    f10 = ((f6 - f11) / 2.0f) + f11;
                    z2 = false;
                } else {
                    if (n32 == null) {
                        f6 = f10;
                    } else {
                        f11 = f10;
                        yVar = n32;
                    }
                    f10 = ((f6 - f11) / 2.0f) + f11;
                }
            }
            if (yVar == null) {
                return n3.y(f9);
            }
            return yVar.xc(tVar);
        }
        return n3.y(f9);
    }

    @NonNull
    public static y zn(int i) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        gv(i, t.f6924f, fArr, fArr2);
        return new y(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    public float c5() {
        return this.f6946n3;
    }

    public float f() {
        return this.f6949zn;
    }

    public float fb() {
        return this.f6947s;
    }

    public float i9() {
        return this.y;
    }

    public float s() {
        return this.f6943c5;
    }

    public float t() {
        return this.f6944fb;
    }

    public int w() {
        return xc(t.f6924f);
    }

    public int xc(@NonNull t tVar) {
        float f4;
        float f6;
        if (c5() != 0.0d && f() != 0.0d) {
            f4 = c5() / ((float) Math.sqrt(f() / 100.0d));
        } else {
            f4 = 0.0f;
        }
        float pow = (float) Math.pow(f4 / Math.pow(1.64d - Math.pow(0.29d, tVar.v()), 0.73d), 1.1111111111111112d);
        double i92 = (i9() * 3.1415927f) / 180.0f;
        float y = tVar.y() * ((float) Math.pow(f() / 100.0d, (1.0d / tVar.n3()) / tVar.i9()));
        float cos = ((float) (Math.cos(2.0d + i92) + 3.8d)) * 0.25f * 3846.1538f * tVar.fb() * tVar.s();
        float a2 = y / tVar.a();
        float sin = (float) Math.sin(i92);
        float cos2 = (float) Math.cos(i92);
        float f9 = (((0.305f + a2) * 23.0f) * pow) / (((cos * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f10 = cos2 * f9;
        float f11 = f9 * sin;
        float f12 = a2 * 460.0f;
        float f13 = (((451.0f * f10) + f12) + (288.0f * f11)) / 1403.0f;
        float f14 = ((f12 - (891.0f * f10)) - (261.0f * f11)) / 1403.0f;
        float signum = Math.signum(f13) * (100.0f / tVar.zn()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f13) * 27.13d) / (400.0d - Math.abs(f13))), 2.380952380952381d));
        float signum2 = Math.signum(f14) * (100.0f / tVar.zn()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f14) * 27.13d) / (400.0d - Math.abs(f14))), 2.380952380952381d));
        float signum3 = Math.signum(((f12 - (f10 * 220.0f)) - (f11 * 6300.0f)) / 1403.0f) * (100.0f / tVar.zn()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f6) * 27.13d) / (400.0d - Math.abs(f6))), 2.380952380952381d));
        float f15 = signum / tVar.c5()[0];
        float f16 = signum2 / tVar.c5()[1];
        float f17 = signum3 / tVar.c5()[2];
        float[][] fArr = n3.f6915n3;
        float[] fArr2 = fArr[0];
        float f18 = (fArr2[0] * f15) + (fArr2[1] * f16) + (fArr2[2] * f17);
        float[] fArr3 = fArr[1];
        float[] fArr4 = fArr[2];
        return z6.y.y(f18, (fArr3[0] * f15) + (fArr3[1] * f16) + (fArr3[2] * f17), (f15 * fArr4[0]) + (f16 * fArr4[1]) + (f17 * fArr4[2]));
    }

    public float y(@NonNull y yVar) {
        float t2 = t() - yVar.t();
        float fb2 = fb() - yVar.fb();
        float s2 = s() - yVar.s();
        return (float) (Math.pow(Math.sqrt((t2 * t2) + (fb2 * fb2) + (s2 * s2)), 0.63d) * 1.41d);
    }
}
