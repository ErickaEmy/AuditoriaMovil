package j;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import hw.i4;
/* loaded from: classes.dex */
public abstract class y implements View.OnTouchListener {

    /* renamed from: ej  reason: collision with root package name */
    public static final int f9324ej = ViewConfiguration.getTapTimeout();

    /* renamed from: c  reason: collision with root package name */
    public boolean f9325c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9327d;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f9328d0;

    /* renamed from: f3  reason: collision with root package name */
    public boolean f9330f3;

    /* renamed from: fb  reason: collision with root package name */
    public final View f9331fb;

    /* renamed from: fh  reason: collision with root package name */
    public boolean f9332fh;

    /* renamed from: n  reason: collision with root package name */
    public boolean f9333n;

    /* renamed from: p  reason: collision with root package name */
    public int f9334p;

    /* renamed from: s  reason: collision with root package name */
    public Runnable f9336s;

    /* renamed from: w  reason: collision with root package name */
    public int f9339w;
    public final C0126y y = new C0126y();

    /* renamed from: v  reason: collision with root package name */
    public final Interpolator f9338v = new AccelerateInterpolator();

    /* renamed from: f  reason: collision with root package name */
    public float[] f9329f = {0.0f, 0.0f};

    /* renamed from: t  reason: collision with root package name */
    public float[] f9337t = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: co  reason: collision with root package name */
    public float[] f9326co = {0.0f, 0.0f};

    /* renamed from: z  reason: collision with root package name */
    public float[] f9340z = {0.0f, 0.0f};

    /* renamed from: r  reason: collision with root package name */
    public float[] f9335r = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* loaded from: classes.dex */
    public class n3 implements Runnable {
        public n3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y yVar = y.this;
            if (!yVar.f9328d0) {
                return;
            }
            if (yVar.f9333n) {
                yVar.f9333n = false;
                yVar.y.tl();
            }
            C0126y c0126y = y.this.y;
            if (!c0126y.s() && y.this.r()) {
                y yVar2 = y.this;
                if (yVar2.f9325c) {
                    yVar2.f9325c = false;
                    yVar2.zn();
                }
                c0126y.y();
                y.this.i9(c0126y.n3(), c0126y.zn());
                i4.nf(y.this.f9331fb, this);
                return;
            }
            y.this.f9328d0 = false;
        }
    }

    /* renamed from: j.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0126y {

        /* renamed from: a  reason: collision with root package name */
        public long f9341a;

        /* renamed from: f  reason: collision with root package name */
        public int f9343f;

        /* renamed from: fb  reason: collision with root package name */
        public int f9344fb;

        /* renamed from: gv  reason: collision with root package name */
        public float f9345gv;

        /* renamed from: i9  reason: collision with root package name */
        public float f9346i9;

        /* renamed from: n3  reason: collision with root package name */
        public int f9347n3;

        /* renamed from: s  reason: collision with root package name */
        public int f9348s;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public float f9350zn;

        /* renamed from: v  reason: collision with root package name */
        public long f9349v = Long.MIN_VALUE;

        /* renamed from: c5  reason: collision with root package name */
        public long f9342c5 = -1;

        public int a() {
            float f4 = this.f9345gv;
            return (int) (f4 / Math.abs(f4));
        }

        public void c5() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f9343f = y.a((int) (currentAnimationTimeMillis - this.f9349v), 0, this.f9347n3);
            this.f9346i9 = v(currentAnimationTimeMillis);
            this.f9342c5 = currentAnimationTimeMillis;
        }

        public void f(int i) {
            this.y = i;
        }

        public final float fb(float f4) {
            return ((-4.0f) * f4 * f4) + (f4 * 4.0f);
        }

        public int gv() {
            float f4 = this.f9350zn;
            return (int) (f4 / Math.abs(f4));
        }

        public void i9(int i) {
            this.f9347n3 = i;
        }

        public int n3() {
            return this.f9344fb;
        }

        public boolean s() {
            if (this.f9342c5 > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f9342c5 + this.f9343f) {
                return true;
            }
            return false;
        }

        public void t(float f4, float f6) {
            this.f9350zn = f4;
            this.f9345gv = f6;
        }

        public void tl() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f9349v = currentAnimationTimeMillis;
            this.f9342c5 = -1L;
            this.f9341a = currentAnimationTimeMillis;
            this.f9346i9 = 0.5f;
            this.f9344fb = 0;
            this.f9348s = 0;
        }

        public final float v(long j2) {
            long j4 = this.f9349v;
            if (j2 < j4) {
                return 0.0f;
            }
            long j6 = this.f9342c5;
            if (j6 >= 0 && j2 >= j6) {
                float f4 = this.f9346i9;
                return (1.0f - f4) + (f4 * y.v(((float) (j2 - j6)) / this.f9343f, 0.0f, 1.0f));
            }
            return y.v(((float) (j2 - j4)) / this.y, 0.0f, 1.0f) * 0.5f;
        }

        public void y() {
            if (this.f9341a != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float fb2 = fb(v(currentAnimationTimeMillis));
                this.f9341a = currentAnimationTimeMillis;
                float f4 = ((float) (currentAnimationTimeMillis - this.f9341a)) * fb2;
                this.f9344fb = (int) (this.f9350zn * f4);
                this.f9348s = (int) (f4 * this.f9345gv);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int zn() {
            return this.f9348s;
        }
    }

    public y(@NonNull View view) {
        this.f9331fb = view;
        float f4 = Resources.getSystem().getDisplayMetrics().density;
        float f6 = (int) ((1575.0f * f4) + 0.5f);
        xc(f6, f6);
        float f9 = (int) ((f4 * 315.0f) + 0.5f);
        w(f9, f9);
        t(1);
        wz(Float.MAX_VALUE, Float.MAX_VALUE);
        co(0.2f, 0.2f);
        z(1.0f, 1.0f);
        f(f9324ej);
        mt(500);
        p(500);
    }

    public static int a(int i, int i5, int i6) {
        if (i > i6) {
            return i6;
        }
        if (i < i5) {
            return i5;
        }
        return i;
    }

    public static float v(float f4, float f6, float f9) {
        if (f4 > f9) {
            return f9;
        }
        if (f4 < f6) {
            return f6;
        }
        return f4;
    }

    public final void c5() {
        if (this.f9333n) {
            this.f9328d0 = false;
        } else {
            this.y.c5();
        }
    }

    @NonNull
    public y co(float f4, float f6) {
        float[] fArr = this.f9329f;
        fArr[0] = f4;
        fArr[1] = f6;
        return this;
    }

    @NonNull
    public y f(int i) {
        this.f9334p = i;
        return this;
    }

    public final float fb(float f4, float f6) {
        if (f6 == 0.0f) {
            return 0.0f;
        }
        int i = this.f9339w;
        if (i != 0 && i != 1) {
            if (i == 2 && f4 < 0.0f) {
                return f4 / (-f6);
            }
        } else if (f4 < f6) {
            if (f4 >= 0.0f) {
                return 1.0f - (f4 / f6);
            }
            if (this.f9328d0 && i == 1) {
                return 1.0f;
            }
        }
        return 0.0f;
    }

    public final float gv(int i, float f4, float f6, float f9) {
        float s2 = s(this.f9329f[i], f6, this.f9337t[i], f4);
        int i5 = (s2 > 0.0f ? 1 : (s2 == 0.0f ? 0 : -1));
        if (i5 == 0) {
            return 0.0f;
        }
        float f10 = this.f9326co[i];
        float f11 = this.f9340z[i];
        float f12 = this.f9335r[i];
        float f13 = f10 * f9;
        if (i5 > 0) {
            return v(s2 * f13, f11, f12);
        }
        return -v((-s2) * f13, f11, f12);
    }

    public abstract void i9(int i, int i5);

    @NonNull
    public y mt(int i) {
        this.y.f(i);
        return this;
    }

    public abstract boolean n3(int i);

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f9332fh
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.c5()
            goto L58
        L1a:
            r5.f9325c = r2
            r5.f9330f3 = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f9331fb
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.gv(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f9331fb
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.gv(r2, r7, r6, r3)
            j.y$y r7 = r5.y
            r7.t(r0, r6)
            boolean r6 = r5.f9328d0
            if (r6 != 0) goto L58
            boolean r6 = r5.r()
            if (r6 == 0) goto L58
            r5.x4()
        L58:
            boolean r6 = r5.f9327d
            if (r6 == 0) goto L61
            boolean r6 = r5.f9328d0
            if (r6 == 0) goto L61
            r1 = 1
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j.y.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @NonNull
    public y p(int i) {
        this.y.i9(i);
        return this;
    }

    public boolean r() {
        C0126y c0126y = this.y;
        int a2 = c0126y.a();
        int gv2 = c0126y.gv();
        if ((a2 != 0 && n3(a2)) || (gv2 != 0 && y(gv2))) {
            return true;
        }
        return false;
    }

    public final float s(float f4, float f6, float f9, float f10) {
        float interpolation;
        float v2 = v(f4 * f6, 0.0f, f9);
        float fb2 = fb(f6 - f10, v2) - fb(f10, v2);
        if (fb2 < 0.0f) {
            interpolation = -this.f9338v.getInterpolation(-fb2);
        } else if (fb2 <= 0.0f) {
            return 0.0f;
        } else {
            interpolation = this.f9338v.getInterpolation(fb2);
        }
        return v(interpolation, -1.0f, 1.0f);
    }

    @NonNull
    public y t(int i) {
        this.f9339w = i;
        return this;
    }

    public y tl(boolean z2) {
        if (this.f9332fh && !z2) {
            c5();
        }
        this.f9332fh = z2;
        return this;
    }

    @NonNull
    public y w(float f4, float f6) {
        float[] fArr = this.f9340z;
        fArr[0] = f4 / 1000.0f;
        fArr[1] = f6 / 1000.0f;
        return this;
    }

    @NonNull
    public y wz(float f4, float f6) {
        float[] fArr = this.f9337t;
        fArr[0] = f4;
        fArr[1] = f6;
        return this;
    }

    public final void x4() {
        int i;
        if (this.f9336s == null) {
            this.f9336s = new n3();
        }
        this.f9328d0 = true;
        this.f9333n = true;
        if (!this.f9330f3 && (i = this.f9334p) > 0) {
            i4.ra(this.f9331fb, this.f9336s, i);
        } else {
            this.f9336s.run();
        }
        this.f9330f3 = true;
    }

    @NonNull
    public y xc(float f4, float f6) {
        float[] fArr = this.f9335r;
        fArr[0] = f4 / 1000.0f;
        fArr[1] = f6 / 1000.0f;
        return this;
    }

    public abstract boolean y(int i);

    @NonNull
    public y z(float f4, float f6) {
        float[] fArr = this.f9326co;
        fArr[0] = f4 / 1000.0f;
        fArr[1] = f6 / 1000.0f;
        return this;
    }

    public void zn() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f9331fb.onTouchEvent(obtain);
        obtain.recycle();
    }
}
