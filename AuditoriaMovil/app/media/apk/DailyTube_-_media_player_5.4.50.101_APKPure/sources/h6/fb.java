package h6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class fb extends Drawable implements Animatable {

    /* renamed from: d0  reason: collision with root package name */
    public static final Property<fb, Float> f8722d0 = new zn(Float.class, "growFraction");

    /* renamed from: c  reason: collision with root package name */
    public int f8723c;

    /* renamed from: co  reason: collision with root package name */
    public List<o0.n3> f8724co;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f8725f;

    /* renamed from: f3  reason: collision with root package name */
    public float f8726f3;

    /* renamed from: p  reason: collision with root package name */
    public float f8729p;

    /* renamed from: r  reason: collision with root package name */
    public boolean f8730r;

    /* renamed from: s  reason: collision with root package name */
    public ValueAnimator f8731s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f8732t;

    /* renamed from: v  reason: collision with root package name */
    public final h6.n3 f8733v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f8734w;
    public final Context y;

    /* renamed from: z  reason: collision with root package name */
    public o0.n3 f8735z;

    /* renamed from: n  reason: collision with root package name */
    public final Paint f8728n = new Paint();

    /* renamed from: fb  reason: collision with root package name */
    public h6.y f8727fb = new h6.y();

    /* loaded from: classes.dex */
    public class n3 extends AnimatorListenerAdapter {
        public n3() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            fb.super.setVisible(false, false);
            fb.this.gv();
        }
    }

    /* loaded from: classes.dex */
    public class y extends AnimatorListenerAdapter {
        public y() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            fb.this.v();
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends Property<fb, Float> {
        public zn(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: n3 */
        public void set(fb fbVar, Float f4) {
            fbVar.tl(f4.floatValue());
        }

        @Override // android.util.Property
        /* renamed from: y */
        public Float get(fb fbVar) {
            return Float.valueOf(fbVar.fb());
        }
    }

    public fb(@NonNull Context context, @NonNull h6.n3 n3Var) {
        this.y = context;
        this.f8733v = n3Var;
        setAlpha(255);
    }

    public final void a(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z2 = this.f8730r;
        this.f8730r = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.f8730r = z2;
    }

    public boolean c5() {
        ValueAnimator valueAnimator = this.f8725f;
        if ((valueAnimator != null && valueAnimator.isRunning()) || this.f8734w) {
            return true;
        }
        return false;
    }

    public final void f() {
        if (this.f8731s == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f8722d0, 0.0f, 1.0f);
            this.f8731s = ofFloat;
            ofFloat.setDuration(500L);
            this.f8731s.setInterpolator(y6.y.f15325n3);
            xc(this.f8731s);
        }
        if (this.f8725f == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f8722d0, 1.0f, 0.0f);
            this.f8725f = ofFloat2;
            ofFloat2.setDuration(500L);
            this.f8725f.setInterpolator(y6.y.f15325n3);
            wz(this.f8725f);
        }
    }

    public float fb() {
        if (!this.f8733v.n3() && !this.f8733v.y()) {
            return 1.0f;
        }
        if (!this.f8734w && !this.f8732t) {
            return this.f8726f3;
        }
        return this.f8729p;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f8723c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void gv() {
        o0.n3 n3Var = this.f8735z;
        if (n3Var != null) {
            n3Var.y(this);
        }
        List<o0.n3> list = this.f8724co;
        if (list != null && !this.f8730r) {
            for (o0.n3 n3Var2 : list) {
                n3Var2.y(this);
            }
        }
    }

    public boolean i9() {
        ValueAnimator valueAnimator = this.f8731s;
        if ((valueAnimator != null && valueAnimator.isRunning()) || this.f8732t) {
            return true;
        }
        return false;
    }

    public boolean isRunning() {
        if (!i9() && !c5()) {
            return false;
        }
        return true;
    }

    public boolean mt(@NonNull o0.n3 n3Var) {
        List<o0.n3> list = this.f8724co;
        if (list != null && list.contains(n3Var)) {
            this.f8724co.remove(n3Var);
            if (this.f8724co.isEmpty()) {
                this.f8724co = null;
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean p(boolean z2, boolean z3, boolean z4) {
        ValueAnimator valueAnimator;
        boolean z5;
        boolean y2;
        f();
        if (!isVisible() && !z2) {
            return false;
        }
        if (z2) {
            valueAnimator = this.f8731s;
        } else {
            valueAnimator = this.f8725f;
        }
        if (!z4) {
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                a(valueAnimator);
            }
            return super.setVisible(z2, false);
        } else if (z4 && valueAnimator.isRunning()) {
            return false;
        } else {
            if (z2 && !super.setVisible(z2, false)) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z2) {
                y2 = this.f8733v.n3();
            } else {
                y2 = this.f8733v.y();
            }
            if (!y2) {
                a(valueAnimator);
                return z5;
            }
            if (!z3 && valueAnimator.isPaused()) {
                valueAnimator.resume();
            } else {
                valueAnimator.start();
            }
            return z5;
        }
    }

    public boolean s() {
        return w(false, false, false);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f8723c = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f8728n.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        return w(z2, z3, true);
    }

    public void start() {
        p(true, true, false);
    }

    public void stop() {
        p(false, true, false);
    }

    public void t(@NonNull o0.n3 n3Var) {
        if (this.f8724co == null) {
            this.f8724co = new ArrayList();
        }
        if (!this.f8724co.contains(n3Var)) {
            this.f8724co.add(n3Var);
        }
    }

    public void tl(float f4) {
        if (this.f8726f3 != f4) {
            this.f8726f3 = f4;
            invalidateSelf();
        }
    }

    public final void v() {
        o0.n3 n3Var = this.f8735z;
        if (n3Var != null) {
            n3Var.n3(this);
        }
        List<o0.n3> list = this.f8724co;
        if (list != null && !this.f8730r) {
            for (o0.n3 n3Var2 : list) {
                n3Var2.n3(this);
            }
        }
    }

    public boolean w(boolean z2, boolean z3, boolean z4) {
        boolean z5;
        float y2 = this.f8727fb.y(this.y.getContentResolver());
        if (z4 && y2 > 0.0f) {
            z5 = true;
        } else {
            z5 = false;
        }
        return p(z2, z3, z5);
    }

    public final void wz(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f8725f;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.f8725f = valueAnimator;
        valueAnimator.addListener(new n3());
    }

    public final void xc(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f8731s;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.f8731s = valueAnimator;
        valueAnimator.addListener(new y());
    }
}
