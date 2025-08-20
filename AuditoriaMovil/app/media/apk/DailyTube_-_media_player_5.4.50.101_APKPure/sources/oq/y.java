package oq;

import androidx.annotation.NonNull;
import hx.a;
import hx.tl;
/* loaded from: classes.dex */
public class y extends a implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    public float f12343f;

    /* renamed from: fb  reason: collision with root package name */
    public float f12344fb;

    /* renamed from: s  reason: collision with root package name */
    public float f12345s;

    /* renamed from: v  reason: collision with root package name */
    public float f12346v;
    public float y;

    public float a() {
        return this.f12346v;
    }

    public void c5(float f4) {
        if (f4 >= 0.0f) {
            this.f12345s = f4;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void f(float f4) {
        this.y = f4;
    }

    public float fb() {
        return this.y;
    }

    public float gv() {
        return this.f12345s;
    }

    public void i9(float f4) {
        this.f12346v = f4;
    }

    public float s() {
        return this.f12344fb;
    }

    public void t(float f4) {
        this.f12344fb = f4;
    }

    public void tl(float f4) {
        this.f12343f = f4;
    }

    @Override // hx.a
    public void zn(float f4, float f6, float f9, @NonNull tl tlVar) {
        float f10 = this.f12344fb;
        if (f10 == 0.0f) {
            tlVar.tl(f4, 0.0f);
            return;
        }
        float f11 = ((this.f12346v * 2.0f) + f10) / 2.0f;
        float f12 = f9 * this.y;
        float f13 = f6 + this.f12343f;
        float f14 = (this.f12345s * f9) + ((1.0f - f9) * f11);
        if (f14 / f11 >= 1.0f) {
            tlVar.tl(f4, 0.0f);
            return;
        }
        float f15 = f11 + f12;
        float f16 = f14 + f12;
        float sqrt = (float) Math.sqrt((f15 * f15) - (f16 * f16));
        float f17 = f13 - sqrt;
        float f18 = f13 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f16));
        float f19 = 90.0f - degrees;
        tlVar.tl(f17, 0.0f);
        float f20 = f12 * 2.0f;
        tlVar.y(f17 - f12, 0.0f, f17 + f12, f20, 270.0f, degrees);
        tlVar.y(f13 - f11, (-f11) - f14, f13 + f11, f11 - f14, 180.0f - f19, (f19 * 2.0f) - 180.0f);
        tlVar.y(f18 - f12, 0.0f, f18 + f12, f20, 270.0f - degrees, degrees);
        tlVar.tl(f4, 0.0f);
    }
}
