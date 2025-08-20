package pz;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import vl.s;
/* loaded from: classes.dex */
public class n3 extends Drawable implements Animatable {

    /* renamed from: f  reason: collision with root package name */
    public float f12662f;

    /* renamed from: fb  reason: collision with root package name */
    public Resources f12663fb;

    /* renamed from: s  reason: collision with root package name */
    public Animator f12664s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f12665t;

    /* renamed from: v  reason: collision with root package name */
    public float f12666v;
    public final zn y;

    /* renamed from: w  reason: collision with root package name */
    public static final Interpolator f12661w = new LinearInterpolator();

    /* renamed from: p  reason: collision with root package name */
    public static final Interpolator f12660p = new jz.n3();

    /* renamed from: co  reason: collision with root package name */
    public static final int[] f12659co = {-16777216};

    /* loaded from: classes.dex */
    public class y implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ zn y;

        public y(zn znVar) {
            this.y = znVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            n3.this.wz(floatValue, this.y);
            n3.this.n3(floatValue, this.y, false);
            n3.this.invalidateSelf();
        }
    }

    /* loaded from: classes.dex */
    public static class zn {

        /* renamed from: a  reason: collision with root package name */
        public float f12669a;

        /* renamed from: c5  reason: collision with root package name */
        public int[] f12670c5;

        /* renamed from: co  reason: collision with root package name */
        public int f12671co;

        /* renamed from: f  reason: collision with root package name */
        public float f12672f;

        /* renamed from: fb  reason: collision with root package name */
        public float f12673fb;

        /* renamed from: gv  reason: collision with root package name */
        public final Paint f12674gv;

        /* renamed from: i9  reason: collision with root package name */
        public int f12675i9;

        /* renamed from: mt  reason: collision with root package name */
        public int f12676mt;

        /* renamed from: n3  reason: collision with root package name */
        public final Paint f12677n3;

        /* renamed from: p  reason: collision with root package name */
        public float f12678p;

        /* renamed from: r  reason: collision with root package name */
        public int f12679r;

        /* renamed from: s  reason: collision with root package name */
        public float f12680s;

        /* renamed from: t  reason: collision with root package name */
        public float f12681t;

        /* renamed from: tl  reason: collision with root package name */
        public float f12682tl;

        /* renamed from: v  reason: collision with root package name */
        public float f12683v;

        /* renamed from: w  reason: collision with root package name */
        public float f12684w;

        /* renamed from: wz  reason: collision with root package name */
        public boolean f12685wz;

        /* renamed from: xc  reason: collision with root package name */
        public Path f12686xc;
        public final RectF y = new RectF();

        /* renamed from: z  reason: collision with root package name */
        public int f12687z;

        /* renamed from: zn  reason: collision with root package name */
        public final Paint f12688zn;

        public zn() {
            Paint paint = new Paint();
            this.f12677n3 = paint;
            Paint paint2 = new Paint();
            this.f12688zn = paint2;
            Paint paint3 = new Paint();
            this.f12674gv = paint3;
            this.f12683v = 0.0f;
            this.f12669a = 0.0f;
            this.f12673fb = 0.0f;
            this.f12680s = 5.0f;
            this.f12684w = 1.0f;
            this.f12687z = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        public int a() {
            return (this.f12675i9 + 1) % this.f12670c5.length;
        }

        public void c(float f4) {
            this.f12680s = f4;
            this.f12677n3.setStrokeWidth(f4);
        }

        public float c5() {
            return this.f12681t;
        }

        public void co(ColorFilter colorFilter) {
            this.f12677n3.setColorFilter(colorFilter);
        }

        public void d0() {
            this.f12672f = this.f12683v;
            this.f12681t = this.f12669a;
            this.f12682tl = this.f12673fb;
        }

        public float f() {
            return this.f12672f;
        }

        public void f3(boolean z2) {
            if (this.f12685wz != z2) {
                this.f12685wz = z2;
            }
        }

        public float fb() {
            return this.f12683v;
        }

        public float gv() {
            return this.f12669a;
        }

        public void i4(float f4) {
            this.f12673fb = f4;
        }

        public float i9() {
            return this.f12682tl;
        }

        public void mt(int i) {
            this.f12679r = i;
        }

        public void n(float f4) {
            this.f12683v = f4;
        }

        public void n3(Canvas canvas, float f4, float f6, RectF rectF) {
            if (this.f12685wz) {
                Path path = this.f12686xc;
                if (path == null) {
                    Path path2 = new Path();
                    this.f12686xc = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.f12686xc.moveTo(0.0f, 0.0f);
                this.f12686xc.lineTo(this.f12676mt * this.f12684w, 0.0f);
                Path path3 = this.f12686xc;
                float f9 = this.f12684w;
                path3.lineTo((this.f12676mt * f9) / 2.0f, this.f12671co * f9);
                this.f12686xc.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((this.f12676mt * this.f12684w) / 2.0f), rectF.centerY() + (this.f12680s / 2.0f));
                this.f12686xc.close();
                this.f12688zn.setColor(this.f12679r);
                this.f12688zn.setAlpha(this.f12687z);
                canvas.save();
                canvas.rotate(f4 + f6, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f12686xc, this.f12688zn);
                canvas.restore();
            }
        }

        public void p(float f4) {
            this.f12678p = f4;
        }

        public void r(@NonNull int[] iArr) {
            this.f12670c5 = iArr;
            z(0);
        }

        public int s() {
            return this.f12670c5[this.f12675i9];
        }

        public void t() {
            z(a());
        }

        public void tl() {
            this.f12672f = 0.0f;
            this.f12681t = 0.0f;
            this.f12682tl = 0.0f;
            n(0.0f);
            x4(0.0f);
            i4(0.0f);
        }

        public int v() {
            return this.f12670c5[a()];
        }

        public void w(float f4) {
            if (f4 != this.f12684w) {
                this.f12684w = f4;
            }
        }

        public void wz(int i) {
            this.f12687z = i;
        }

        public void x4(float f4) {
            this.f12669a = f4;
        }

        public void xc(float f4, float f6) {
            this.f12676mt = (int) f4;
            this.f12671co = (int) f6;
        }

        public void y(Canvas canvas, Rect rect) {
            RectF rectF = this.y;
            float f4 = this.f12678p;
            float f6 = (this.f12680s / 2.0f) + f4;
            if (f4 <= 0.0f) {
                f6 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.f12676mt * this.f12684w) / 2.0f, this.f12680s / 2.0f);
            }
            rectF.set(rect.centerX() - f6, rect.centerY() - f6, rect.centerX() + f6, rect.centerY() + f6);
            float f9 = this.f12683v;
            float f10 = this.f12673fb;
            float f11 = (f9 + f10) * 360.0f;
            float f12 = ((this.f12669a + f10) * 360.0f) - f11;
            this.f12677n3.setColor(this.f12679r);
            this.f12677n3.setAlpha(this.f12687z);
            float f13 = this.f12680s / 2.0f;
            rectF.inset(f13, f13);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f12674gv);
            float f14 = -f13;
            rectF.inset(f14, f14);
            canvas.drawArc(rectF, f11, f12, false, this.f12677n3);
            n3(canvas, f11, f12, rectF);
        }

        public void z(int i) {
            this.f12675i9 = i;
            this.f12679r = this.f12670c5[i];
        }

        public int zn() {
            return this.f12687z;
        }
    }

    public n3(@NonNull Context context) {
        this.f12663fb = ((Context) s.fb(context)).getResources();
        zn znVar = new zn();
        this.y = znVar;
        znVar.r(f12659co);
        f(2.5f);
        tl();
    }

    public void a(@NonNull int... iArr) {
        this.y.r(iArr);
        this.y.z(0);
        invalidateSelf();
    }

    public final void c5(float f4, float f6, float f9, float f10) {
        zn znVar = this.y;
        float f11 = this.f12663fb.getDisplayMetrics().density;
        znVar.c(f6 * f11);
        znVar.p(f4 * f11);
        znVar.z(0);
        znVar.xc(f9 * f11, f10 * f11);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f12666v, bounds.exactCenterX(), bounds.exactCenterY());
        this.y.y(canvas, bounds);
        canvas.restore();
    }

    public void f(float f4) {
        this.y.c(f4);
        invalidateSelf();
    }

    public void fb(float f4) {
        this.y.i4(f4);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.y.zn();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void gv(boolean z2) {
        this.y.f3(z2);
        invalidateSelf();
    }

    public void i9(float f4, float f6) {
        this.y.n(f4);
        this.y.x4(f6);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f12664s.isRunning();
    }

    public void n3(float f4, zn znVar, boolean z2) {
        float interpolation;
        float f6;
        if (this.f12665t) {
            y(f4, znVar);
        } else if (f4 != 1.0f || z2) {
            float i92 = znVar.i9();
            if (f4 < 0.5f) {
                interpolation = znVar.f();
                f6 = (f12660p.getInterpolation(f4 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float f9 = znVar.f() + 0.79f;
                interpolation = f9 - (((1.0f - f12660p.getInterpolation((f4 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f6 = f9;
            }
            znVar.n(interpolation);
            znVar.x4(f6);
            znVar.i4(i92 + (0.20999998f * f4));
            s((f4 + this.f12662f) * 216.0f);
        }
    }

    public final void s(float f4) {
        this.f12666v = f4;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.y.wz(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.y.co(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f12664s.cancel();
        this.y.d0();
        if (this.y.gv() != this.y.fb()) {
            this.f12665t = true;
            this.f12664s.setDuration(666L);
            this.f12664s.start();
            return;
        }
        this.y.z(0);
        this.y.tl();
        this.f12664s.setDuration(1332L);
        this.f12664s.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f12664s.cancel();
        s(0.0f);
        this.y.f3(false);
        this.y.z(0);
        this.y.tl();
        invalidateSelf();
    }

    public void t(int i) {
        if (i == 0) {
            c5(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            c5(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public final void tl() {
        zn znVar = this.y;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new y(znVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f12661w);
        ofFloat.addListener(new C0182n3(znVar));
        this.f12664s = ofFloat;
    }

    public void v(float f4) {
        this.y.w(f4);
        invalidateSelf();
    }

    public void wz(float f4, zn znVar) {
        if (f4 > 0.75f) {
            znVar.mt(zn((f4 - 0.75f) / 0.25f, znVar.s(), znVar.v()));
        } else {
            znVar.mt(znVar.s());
        }
    }

    public final void y(float f4, zn znVar) {
        wz(f4, znVar);
        znVar.n(znVar.f() + (((znVar.c5() - 0.01f) - znVar.f()) * f4));
        znVar.x4(znVar.c5());
        znVar.i4(znVar.i9() + ((((float) (Math.floor(znVar.i9() / 0.8f) + 1.0d)) - znVar.i9()) * f4));
    }

    public final int zn(float f4, int i, int i5) {
        int i6 = (i >> 24) & 255;
        int i8 = (i >> 16) & 255;
        int i10 = (i >> 8) & 255;
        int i11 = i & 255;
        return ((i6 + ((int) ((((i5 >> 24) & 255) - i6) * f4))) << 24) | ((i8 + ((int) ((((i5 >> 16) & 255) - i8) * f4))) << 16) | ((i10 + ((int) ((((i5 >> 8) & 255) - i10) * f4))) << 8) | (i11 + ((int) (f4 * ((i5 & 255) - i11))));
    }

    /* renamed from: pz.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0182n3 implements Animator.AnimatorListener {
        public final /* synthetic */ zn y;

        public C0182n3(zn znVar) {
            this.y = znVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            n3.this.n3(1.0f, this.y, true);
            this.y.d0();
            this.y.t();
            n3 n3Var = n3.this;
            if (n3Var.f12665t) {
                n3Var.f12665t = false;
                animator.cancel();
                animator.setDuration(1332L);
                animator.start();
                this.y.f3(false);
                return;
            }
            n3Var.f12662f += 1.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            n3.this.f12662f = 0.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }
    }
}
