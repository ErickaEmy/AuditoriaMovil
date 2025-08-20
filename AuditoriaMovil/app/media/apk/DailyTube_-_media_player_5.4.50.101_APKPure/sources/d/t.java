package d;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class t {

    /* renamed from: f  reason: collision with root package name */
    public static final t f6924f = f(n3.f6916zn, (float) ((n3.s(50.0f) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: a  reason: collision with root package name */
    public final float f6925a;

    /* renamed from: c5  reason: collision with root package name */
    public final float f6926c5;

    /* renamed from: fb  reason: collision with root package name */
    public final float[] f6927fb;

    /* renamed from: gv  reason: collision with root package name */
    public final float f6928gv;

    /* renamed from: i9  reason: collision with root package name */
    public final float f6929i9;

    /* renamed from: n3  reason: collision with root package name */
    public final float f6930n3;

    /* renamed from: s  reason: collision with root package name */
    public final float f6931s;

    /* renamed from: v  reason: collision with root package name */
    public final float f6932v;
    public final float y;

    /* renamed from: zn  reason: collision with root package name */
    public final float f6933zn;

    public t(float f4, float f6, float f9, float f10, float f11, float f12, float[] fArr, float f13, float f14, float f15) {
        this.f6925a = f4;
        this.y = f6;
        this.f6930n3 = f9;
        this.f6933zn = f10;
        this.f6928gv = f11;
        this.f6932v = f12;
        this.f6927fb = fArr;
        this.f6931s = f13;
        this.f6926c5 = f14;
        this.f6929i9 = f15;
    }

    @NonNull
    public static t f(@NonNull float[] fArr, float f4, float f6, float f9, boolean z2) {
        float gv2;
        float exp;
        float[][] fArr2 = n3.y;
        float f10 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f11 = fArr[1];
        float f12 = fArr[2];
        float f13 = (fArr3[0] * f10) + (fArr3[1] * f11) + (fArr3[2] * f12);
        float[] fArr4 = fArr2[1];
        float f14 = (fArr4[0] * f10) + (fArr4[1] * f11) + (fArr4[2] * f12);
        float[] fArr5 = fArr2[2];
        float f15 = (f10 * fArr5[0]) + (f11 * fArr5[1]) + (f12 * fArr5[2]);
        float f16 = (f9 / 10.0f) + 0.8f;
        if (f16 >= 0.9d) {
            gv2 = n3.gv(0.59f, 0.69f, (f16 - 0.9f) * 10.0f);
        } else {
            gv2 = n3.gv(0.525f, 0.59f, (f16 - 0.8f) * 10.0f);
        }
        float f17 = gv2;
        if (z2) {
            exp = 1.0f;
        } else {
            exp = (1.0f - (((float) Math.exp(((-f4) - 42.0f) / 92.0f)) * 0.2777778f)) * f16;
        }
        double d2 = exp;
        if (d2 > 1.0d) {
            exp = 1.0f;
        } else if (d2 < 0.0d) {
            exp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f13) * exp) + 1.0f) - exp, (((100.0f / f14) * exp) + 1.0f) - exp, (((100.0f / f15) * exp) + 1.0f) - exp};
        float f18 = 1.0f / ((5.0f * f4) + 1.0f);
        float f19 = f18 * f18 * f18 * f18;
        float f20 = 1.0f - f19;
        float cbrt = (f19 * f4) + (0.1f * f20 * f20 * ((float) Math.cbrt(f4 * 5.0d)));
        float s2 = n3.s(f6) / fArr[1];
        double d3 = s2;
        float sqrt = ((float) Math.sqrt(d3)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d3, 0.2d));
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * cbrt) * f13) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * cbrt) * f14) / 100.0d, 0.42d), (float) Math.pow(((fArr6[2] * cbrt) * f15) / 100.0d, 0.42d)};
        float f21 = fArr7[0];
        float f22 = (f21 * 400.0f) / (f21 + 27.13f);
        float f23 = fArr7[1];
        float f24 = (f23 * 400.0f) / (f23 + 27.13f);
        float f25 = fArr7[2];
        float[] fArr8 = {f22, f24, (400.0f * f25) / (f25 + 27.13f)};
        return new t(s2, ((fArr8[0] * 2.0f) + fArr8[1] + (fArr8[2] * 0.05f)) * pow, pow, pow, f17, f16, fArr6, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
    }

    public float a() {
        return this.f6930n3;
    }

    @NonNull
    public float[] c5() {
        return this.f6927fb;
    }

    public float fb() {
        return this.f6932v;
    }

    public float gv() {
        return this.f6926c5;
    }

    public float i9() {
        return this.f6929i9;
    }

    public float n3() {
        return this.f6928gv;
    }

    public float s() {
        return this.f6933zn;
    }

    public float v() {
        return this.f6925a;
    }

    public float y() {
        return this.y;
    }

    public float zn() {
        return this.f6931s;
    }
}
