package br;

import android.view.Choreographer;
import androidx.annotation.Nullable;
import yk.zn;
/* loaded from: classes.dex */
public class v extends y implements Choreographer.FrameCallback {

    /* renamed from: c  reason: collision with root package name */
    public boolean f3872c;

    /* renamed from: co  reason: collision with root package name */
    public int f3873co;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3874f;
    @Nullable

    /* renamed from: f3  reason: collision with root package name */
    public yk.s f3875f3;

    /* renamed from: n  reason: collision with root package name */
    public boolean f3876n;

    /* renamed from: p  reason: collision with root package name */
    public float f3877p;

    /* renamed from: t  reason: collision with root package name */
    public long f3880t;

    /* renamed from: w  reason: collision with root package name */
    public float f3881w;

    /* renamed from: s  reason: collision with root package name */
    public float f3879s = 1.0f;

    /* renamed from: z  reason: collision with root package name */
    public float f3882z = -2.14748365E9f;

    /* renamed from: r  reason: collision with root package name */
    public float f3878r = 2.14748365E9f;

    public void c() {
        d(-p());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        n3();
        i4();
    }

    public void co() {
        i4();
        gv();
    }

    public void d(float f4) {
        this.f3879s = f4;
    }

    public void d0(yk.s sVar) {
        boolean z2;
        if (this.f3875f3 == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f3875f3 = sVar;
        if (z2) {
            mg(Math.max(this.f3882z, sVar.w()), Math.min(this.f3878r, sVar.a()));
        } else {
            mg((int) sVar.w(), (int) sVar.a());
        }
        float f4 = this.f3877p;
        this.f3877p = 0.0f;
        this.f3881w = 0.0f;
        fh((int) f4);
        c5();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j2) {
        float w4;
        float xc2;
        x4();
        if (this.f3875f3 != null && isRunning()) {
            zn.y("LottieValueAnimator#doFrame");
            long j4 = this.f3880t;
            long j6 = 0;
            if (j4 != 0) {
                j6 = j2 - j4;
            }
            float wz2 = ((float) j6) / wz();
            float f4 = this.f3881w;
            if (mt()) {
                wz2 = -wz2;
            }
            float f6 = f4 + wz2;
            boolean gv2 = fb.gv(f6, w(), xc());
            float f9 = this.f3881w;
            float n32 = fb.n3(f6, w(), xc());
            this.f3881w = n32;
            if (this.f3872c) {
                n32 = (float) Math.floor(n32);
            }
            this.f3877p = n32;
            this.f3880t = j2;
            if (!this.f3872c || this.f3881w != f9) {
                c5();
            }
            if (!gv2) {
                if (getRepeatCount() != -1 && this.f3873co >= getRepeatCount()) {
                    if (this.f3879s < 0.0f) {
                        xc2 = w();
                    } else {
                        xc2 = xc();
                    }
                    this.f3881w = xc2;
                    this.f3877p = xc2;
                    i4();
                    zn(mt());
                } else {
                    a();
                    this.f3873co++;
                    if (getRepeatMode() == 2) {
                        this.f3874f = !this.f3874f;
                        c();
                    } else {
                        if (mt()) {
                            w4 = xc();
                        } else {
                            w4 = w();
                        }
                        this.f3881w = w4;
                        this.f3877p = w4;
                    }
                    this.f3880t = j2;
                }
            }
            ej();
            zn.n3("LottieValueAnimator#doFrame");
        }
    }

    public final void ej() {
        if (this.f3875f3 == null) {
            return;
        }
        float f4 = this.f3877p;
        if (f4 >= this.f3882z && f4 <= this.f3878r) {
            return;
        }
        throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f3882z), Float.valueOf(this.f3878r), Float.valueOf(this.f3877p)));
    }

    public void f() {
        i4();
        zn(mt());
    }

    public void f3(boolean z2) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z2) {
            this.f3876n = false;
        }
    }

    public void fh(float f4) {
        if (this.f3881w == f4) {
            return;
        }
        float n32 = fb.n3(f4, w(), xc());
        this.f3881w = n32;
        if (this.f3872c) {
            n32 = (float) Math.floor(n32);
        }
        this.f3877p = n32;
        this.f3880t = 0L;
        c5();
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float w4;
        float xc2;
        float w5;
        if (this.f3875f3 == null) {
            return 0.0f;
        }
        if (mt()) {
            w4 = xc() - this.f3877p;
            xc2 = xc();
            w5 = w();
        } else {
            w4 = this.f3877p - w();
            xc2 = xc();
            w5 = w();
        }
        return w4 / (xc2 - w5);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(t());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        yk.s sVar = this.f3875f3;
        if (sVar == null) {
            return 0L;
        }
        return sVar.gv();
    }

    public void i4() {
        f3(true);
    }

    public void i9() {
        this.f3875f3 = null;
        this.f3882z = -2.14748365E9f;
        this.f3878r = 2.14748365E9f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f3876n;
    }

    public void mg(float f4, float f6) {
        float w4;
        float a2;
        if (f4 <= f6) {
            yk.s sVar = this.f3875f3;
            if (sVar == null) {
                w4 = -3.4028235E38f;
            } else {
                w4 = sVar.w();
            }
            yk.s sVar2 = this.f3875f3;
            if (sVar2 == null) {
                a2 = Float.MAX_VALUE;
            } else {
                a2 = sVar2.a();
            }
            float n32 = fb.n3(f4, w4, a2);
            float n33 = fb.n3(f6, w4, a2);
            if (n32 != this.f3882z || n33 != this.f3878r) {
                this.f3882z = n32;
                this.f3878r = n33;
                fh((int) fb.n3(this.f3877p, n32, n33));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f4), Float.valueOf(f6)));
    }

    public final boolean mt() {
        if (p() < 0.0f) {
            return true;
        }
        return false;
    }

    public void n() {
        this.f3876n = true;
        x4();
        this.f3880t = 0L;
        if (mt() && tl() == w()) {
            fh(xc());
        } else if (!mt() && tl() == xc()) {
            fh(w());
        }
        fb();
    }

    @Override // br.y
    public void n3() {
        super.n3();
        zn(mt());
    }

    public float p() {
        return this.f3879s;
    }

    public void rz(float f4) {
        mg(this.f3882z, f4);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.f3874f) {
            this.f3874f = false;
            c();
        }
    }

    public float t() {
        yk.s sVar = this.f3875f3;
        if (sVar == null) {
            return 0.0f;
        }
        return (this.f3877p - sVar.w()) / (this.f3875f3.a() - this.f3875f3.w());
    }

    public void ta(int i) {
        mg(i, (int) this.f3878r);
    }

    public float tl() {
        return this.f3877p;
    }

    public float w() {
        yk.s sVar = this.f3875f3;
        if (sVar == null) {
            return 0.0f;
        }
        float f4 = this.f3882z;
        if (f4 == -2.14748365E9f) {
            return sVar.w();
        }
        return f4;
    }

    public final float wz() {
        yk.s sVar = this.f3875f3;
        if (sVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / sVar.c5()) / Math.abs(this.f3879s);
    }

    public void x4() {
        if (isRunning()) {
            f3(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public float xc() {
        yk.s sVar = this.f3875f3;
        if (sVar == null) {
            return 0.0f;
        }
        float f4 = this.f3878r;
        if (f4 == 2.14748365E9f) {
            return sVar.a();
        }
        return f4;
    }

    public void z() {
        float w4;
        this.f3876n = true;
        s(mt());
        if (mt()) {
            w4 = xc();
        } else {
            w4 = w();
        }
        fh((int) w4);
        this.f3880t = 0L;
        this.f3873co = 0;
        x4();
    }

    public void z6(boolean z2) {
        this.f3872c = z2;
    }
}
