package h6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class gv extends c5<ObjectAnimator> {

    /* renamed from: a  reason: collision with root package name */
    public final jz.n3 f8741a;

    /* renamed from: c5  reason: collision with root package name */
    public float f8742c5;

    /* renamed from: f  reason: collision with root package name */
    public o0.n3 f8743f;

    /* renamed from: fb  reason: collision with root package name */
    public final h6.n3 f8744fb;

    /* renamed from: gv  reason: collision with root package name */
    public ObjectAnimator f8745gv;

    /* renamed from: i9  reason: collision with root package name */
    public float f8746i9;

    /* renamed from: s  reason: collision with root package name */
    public int f8747s;

    /* renamed from: v  reason: collision with root package name */
    public ObjectAnimator f8748v;

    /* renamed from: t  reason: collision with root package name */
    public static final int[] f8736t = {0, 1350, 2700, 4050};

    /* renamed from: tl  reason: collision with root package name */
    public static final int[] f8737tl = {667, 2017, 3367, 4717};

    /* renamed from: wz  reason: collision with root package name */
    public static final int[] f8739wz = {1000, 2350, 3700, 5050};

    /* renamed from: xc  reason: collision with root package name */
    public static final Property<gv, Float> f8740xc = new zn(Float.class, "animationFraction");

    /* renamed from: w  reason: collision with root package name */
    public static final Property<gv, Float> f8738w = new C0104gv(Float.class, "completeEndFraction");

    /* renamed from: h6.gv$gv  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0104gv extends Property<gv, Float> {
        public C0104gv(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: n3 */
        public void set(gv gvVar, Float f4) {
            gvVar.r(f4.floatValue());
        }

        @Override // android.util.Property
        /* renamed from: y */
        public Float get(gv gvVar) {
            return Float.valueOf(gvVar.w());
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends AnimatorListenerAdapter {
        public n3() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            gv.this.y();
            gv gvVar = gv.this;
            gvVar.f8743f.y(gvVar.y);
        }
    }

    /* loaded from: classes.dex */
    public class y extends AnimatorListenerAdapter {
        public y() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            gv gvVar = gv.this;
            gvVar.f8747s = (gvVar.f8747s + 4) % gv.this.f8744fb.f8755zn.length;
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends Property<gv, Float> {
        public zn(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: n3 */
        public void set(gv gvVar, Float f4) {
            gvVar.z(f4.floatValue());
        }

        @Override // android.util.Property
        /* renamed from: y */
        public Float get(gv gvVar) {
            return Float.valueOf(gvVar.xc());
        }
    }

    public gv(@NonNull v vVar) {
        super(1);
        this.f8744fb = vVar;
        this.f8741a = new jz.n3();
    }

    @Override // h6.c5
    public void a() {
        if (this.f8748v.isRunning()) {
            return;
        }
        if (this.y.isVisible()) {
            this.f8748v.start();
        } else {
            y();
        }
    }

    public void co() {
        this.f8747s = 0;
        this.f8721zn[0] = td.y.y(this.f8744fb.f8755zn[0], this.y.getAlpha());
        this.f8746i9 = 0.0f;
    }

    @Override // h6.c5
    public void fb() {
        p();
        co();
        this.f8745gv.start();
    }

    @Override // h6.c5
    public void gv(@NonNull o0.n3 n3Var) {
        this.f8743f = n3Var;
    }

    public final void mt(int i) {
        for (int i5 = 0; i5 < 4; i5++) {
            float n32 = n3(i, f8739wz[i5], 333);
            if (n32 >= 0.0f && n32 <= 1.0f) {
                int i6 = i5 + this.f8747s;
                int[] iArr = this.f8744fb.f8755zn;
                int length = i6 % iArr.length;
                int y2 = td.y.y(iArr[length], this.y.getAlpha());
                int y7 = td.y.y(this.f8744fb.f8755zn[(length + 1) % iArr.length], this.y.getAlpha());
                this.f8721zn[0] = y6.zn.n3().evaluate(this.f8741a.getInterpolation(n32), Integer.valueOf(y2), Integer.valueOf(y7)).intValue();
                return;
            }
        }
    }

    public final void p() {
        if (this.f8745gv == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f8740xc, 0.0f, 1.0f);
            this.f8745gv = ofFloat;
            ofFloat.setDuration(5400L);
            this.f8745gv.setInterpolator(null);
            this.f8745gv.setRepeatCount(-1);
            this.f8745gv.addListener(new y());
        }
        if (this.f8748v == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f8738w, 0.0f, 1.0f);
            this.f8748v = ofFloat2;
            ofFloat2.setDuration(333L);
            this.f8748v.setInterpolator(this.f8741a);
            this.f8748v.addListener(new n3());
        }
    }

    public final void r(float f4) {
        this.f8746i9 = f4;
    }

    @Override // h6.c5
    public void s() {
        this.f8743f = null;
    }

    public final float w() {
        return this.f8746i9;
    }

    public final void x4(int i) {
        float[] fArr = this.f8720n3;
        float f4 = this.f8742c5;
        fArr[0] = (f4 * 1520.0f) - 20.0f;
        fArr[1] = f4 * 1520.0f;
        for (int i5 = 0; i5 < 4; i5++) {
            float n32 = n3(i, f8736t[i5], 667);
            float[] fArr2 = this.f8720n3;
            fArr2[1] = fArr2[1] + (this.f8741a.getInterpolation(n32) * 250.0f);
            float n33 = n3(i, f8737tl[i5], 667);
            float[] fArr3 = this.f8720n3;
            fArr3[0] = fArr3[0] + (this.f8741a.getInterpolation(n33) * 250.0f);
        }
        float[] fArr4 = this.f8720n3;
        float f6 = fArr4[0];
        float f9 = fArr4[1];
        float f10 = f6 + ((f9 - f6) * this.f8746i9);
        fArr4[0] = f10;
        fArr4[0] = f10 / 360.0f;
        fArr4[1] = f9 / 360.0f;
    }

    public final float xc() {
        return this.f8742c5;
    }

    @Override // h6.c5
    public void y() {
        ObjectAnimator objectAnimator = this.f8745gv;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void z(float f4) {
        this.f8742c5 = f4;
        int i = (int) (f4 * 5400.0f);
        x4(i);
        mt(i);
        this.y.invalidateSelf();
    }

    @Override // h6.c5
    public void zn() {
        co();
    }
}
