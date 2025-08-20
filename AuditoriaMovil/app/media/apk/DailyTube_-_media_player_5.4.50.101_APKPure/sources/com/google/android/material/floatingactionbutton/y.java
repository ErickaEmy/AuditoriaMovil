package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$animator;
import hw.i4;
import hx.wz;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5748a;

    /* renamed from: c  reason: collision with root package name */
    public final os.n3 f5749c;

    /* renamed from: c5  reason: collision with root package name */
    public float f5750c5;

    /* renamed from: f  reason: collision with root package name */
    public int f5753f;

    /* renamed from: f3  reason: collision with root package name */
    public ArrayList<c5> f5754f3;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public np.y f5757gv;

    /* renamed from: i4  reason: collision with root package name */
    public ArrayList<Animator.AnimatorListener> f5758i4;

    /* renamed from: i9  reason: collision with root package name */
    public float f5759i9;

    /* renamed from: mt  reason: collision with root package name */
    public float f5761mt;

    /* renamed from: n  reason: collision with root package name */
    public final FloatingActionButton f5762n;
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public hx.fb f5763n3;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public y6.s f5764p;

    /* renamed from: r  reason: collision with root package name */
    public int f5765r;

    /* renamed from: s  reason: collision with root package name */
    public float f5767s;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    public final ur.a f5768t;
    @Nullable

    /* renamed from: ta  reason: collision with root package name */
    public ViewTreeObserver.OnPreDrawListener f5769ta;
    @Nullable

    /* renamed from: tl  reason: collision with root package name */
    public y6.s f5770tl;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public Drawable f5771v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public y6.s f5772w;
    @Nullable

    /* renamed from: wz  reason: collision with root package name */
    public y6.s f5773wz;

    /* renamed from: x4  reason: collision with root package name */
    public ArrayList<Animator.AnimatorListener> f5774x4;
    @Nullable

    /* renamed from: xc  reason: collision with root package name */
    public Animator f5775xc;
    @Nullable
    public hx.f y;

    /* renamed from: z  reason: collision with root package name */
    public int f5776z;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public Drawable f5777zn;

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f5743d = y6.y.f15327zn;

    /* renamed from: z6  reason: collision with root package name */
    public static final int[] f5747z6 = {16842919, 16842910};

    /* renamed from: ej  reason: collision with root package name */
    public static final int[] f5744ej = {16843623, 16842908, 16842910};

    /* renamed from: ud  reason: collision with root package name */
    public static final int[] f5745ud = {16842908, 16842910};

    /* renamed from: a8  reason: collision with root package name */
    public static final int[] f5741a8 = {16843623, 16842910};

    /* renamed from: x  reason: collision with root package name */
    public static final int[] f5746x = {16842910};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f5742b = new int[0];

    /* renamed from: fb  reason: collision with root package name */
    public boolean f5755fb = true;

    /* renamed from: co  reason: collision with root package name */
    public float f5751co = 1.0f;

    /* renamed from: d0  reason: collision with root package name */
    public final Rect f5752d0 = new Rect();

    /* renamed from: fh  reason: collision with root package name */
    public final RectF f5756fh = new RectF();

    /* renamed from: rz  reason: collision with root package name */
    public final RectF f5766rz = new RectF();

    /* renamed from: mg  reason: collision with root package name */
    public final Matrix f5760mg = new Matrix();

    /* loaded from: classes.dex */
    public class a extends t {
        public a() {
            super(y.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.y.t
        public float y() {
            return 0.0f;
        }
    }

    /* loaded from: classes.dex */
    public interface c5 {
        void n3();

        void y();
    }

    /* loaded from: classes.dex */
    public class f extends t {
        public f() {
            super(y.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.y.t
        public float y() {
            return y.this.f5767s;
        }
    }

    /* loaded from: classes.dex */
    public class fb extends t {
        public fb() {
            super(y.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.y.t
        public float y() {
            y yVar = y.this;
            return yVar.f5767s + yVar.f5750c5;
        }
    }

    /* loaded from: classes.dex */
    public class gv implements TypeEvaluator<Float> {
        public FloatEvaluator y = new FloatEvaluator();

        public gv() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: y */
        public Float evaluate(float f4, Float f6, Float f9) {
            float floatValue = this.y.evaluate(f4, (Number) f6, (Number) f9).floatValue();
            if (floatValue < 0.1f) {
                floatValue = 0.0f;
            }
            return Float.valueOf(floatValue);
        }
    }

    /* loaded from: classes.dex */
    public interface i9 {
        void n3();

        void y();
    }

    /* loaded from: classes.dex */
    public class n3 extends AnimatorListenerAdapter {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ i9 f5782n3;
        public final /* synthetic */ boolean y;

        public n3(boolean z2, i9 i9Var) {
            this.y = z2;
            this.f5782n3 = i9Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            y.this.f5765r = 0;
            y.this.f5775xc = null;
            i9 i9Var = this.f5782n3;
            if (i9Var != null) {
                i9Var.y();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            y.this.f5762n.n3(0, this.y);
            y.this.f5765r = 2;
            y.this.f5775xc = animator;
        }
    }

    /* loaded from: classes.dex */
    public class s extends t {
        public s() {
            super(y.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.y.t
        public float y() {
            y yVar = y.this;
            return yVar.f5767s + yVar.f5759i9;
        }
    }

    /* loaded from: classes.dex */
    public abstract class t extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: n3  reason: collision with root package name */
        public float f5786n3;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public float f5787zn;

        public t() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            y.this.ct((int) this.f5787zn);
            this.y = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float i42;
            if (!this.y) {
                hx.fb fbVar = y.this.f5763n3;
                if (fbVar == null) {
                    i42 = 0.0f;
                } else {
                    i42 = fbVar.i4();
                }
                this.f5786n3 = i42;
                this.f5787zn = y();
                this.y = true;
            }
            y yVar = y.this;
            float f4 = this.f5786n3;
            yVar.ct((int) (f4 + ((this.f5787zn - f4) * valueAnimator.getAnimatedFraction())));
        }

        public abstract float y();

        public /* synthetic */ t(y yVar, C0062y c0062y) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public class v implements ViewTreeObserver.OnPreDrawListener {
        public v() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            y.this.z6();
            return true;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0062y extends AnimatorListenerAdapter {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ boolean f5789n3;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ i9 f5790zn;

        public C0062y(boolean z2, i9 i9Var) {
            this.f5789n3 = z2;
            this.f5790zn = i9Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.y = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int i;
            y.this.f5765r = 0;
            y.this.f5775xc = null;
            if (!this.y) {
                FloatingActionButton floatingActionButton = y.this.f5762n;
                boolean z2 = this.f5789n3;
                if (z2) {
                    i = 8;
                } else {
                    i = 4;
                }
                floatingActionButton.n3(i, z2);
                i9 i9Var = this.f5790zn;
                if (i9Var != null) {
                    i9Var.n3();
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            y.this.f5762n.n3(0, this.f5789n3);
            y.this.f5765r = 1;
            y.this.f5775xc = animator;
            this.y = false;
        }
    }

    /* loaded from: classes.dex */
    public class zn extends y6.fb {
        public zn() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: y */
        public Matrix evaluate(float f4, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
            y.this.f5751co = f4;
            return super.y(f4, matrix, matrix2);
        }
    }

    public y(FloatingActionButton floatingActionButton, os.n3 n3Var) {
        this.f5762n = floatingActionButton;
        this.f5749c = n3Var;
        ur.a aVar = new ur.a();
        this.f5768t = aVar;
        aVar.y(f5747z6, c5(new s()));
        aVar.y(f5744ej, c5(new fb()));
        aVar.y(f5745ud, c5(new fb()));
        aVar.y(f5741a8, c5(new fb()));
        aVar.y(f5746x, c5(new f()));
        aVar.y(f5742b, c5(new a()));
        this.f5761mt = floatingActionButton.getRotation();
    }

    public void a(@NonNull c5 c5Var) {
        if (this.f5754f3 == null) {
            this.f5754f3 = new ArrayList<>();
        }
        this.f5754f3.add(c5Var);
    }

    public boolean a8() {
        throw null;
    }

    public void b(@Nullable PorterDuff.Mode mode) {
        hx.fb fbVar = this.f5763n3;
        if (fbVar != null) {
            fbVar.setTintMode(mode);
        }
    }

    public void c() {
        throw null;
    }

    @NonNull
    public final ValueAnimator c5(@NonNull t tVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f5743d);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(tVar);
        valueAnimator.addUpdateListener(tVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public float co() {
        return this.f5759i9;
    }

    public void ct(float f4) {
        hx.fb fbVar = this.f5763n3;
        if (fbVar != null) {
            fbVar.q9(f4);
        }
    }

    public void d(@NonNull Rect rect) {
        vl.s.s(this.f5771v, "Didn't initialize content background");
        if (f7()) {
            this.f5749c.n3(new InsetDrawable(this.f5771v, rect.left, rect.top, rect.right, rect.bottom));
            return;
        }
        this.f5749c.n3(this.f5771v);
    }

    public void d0() {
        hx.fb fbVar = this.f5763n3;
        if (fbVar != null) {
            hx.s.a(this.f5762n, fbVar);
        }
        if (a8()) {
            this.f5762n.getViewTreeObserver().addOnPreDrawListener(p());
        }
    }

    public final void dm() {
        Rect rect = this.f5752d0;
        mt(rect);
        d(rect);
        this.f5749c.y(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void ej() {
        ArrayList<c5> arrayList = this.f5754f3;
        if (arrayList != null) {
            Iterator<c5> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().n3();
            }
        }
    }

    public final boolean en() {
        if (i4.q9(this.f5762n) && !this.f5762n.isInEditMode()) {
            return true;
        }
        return false;
    }

    public final y6.s f() {
        if (this.f5773wz == null) {
            this.f5773wz = y6.s.zn(this.f5762n.getContext(), R$animator.a);
        }
        return (y6.s) vl.s.fb(this.f5773wz);
    }

    public boolean f3() {
        if (this.f5762n.getVisibility() == 0) {
            if (this.f5765r != 1) {
                return false;
            }
            return true;
        } else if (this.f5765r == 2) {
            return false;
        } else {
            return true;
        }
    }

    public boolean f7() {
        throw null;
    }

    public final void fb(float f4, @NonNull Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f5762n.getDrawable();
        if (drawable != null && this.f5776z != 0) {
            RectF rectF = this.f5756fh;
            RectF rectF2 = this.f5766rz;
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            int i = this.f5776z;
            rectF2.set(0.0f, 0.0f, i, i);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i5 = this.f5776z;
            matrix.postScale(f4, f4, i5 / 2.0f, i5 / 2.0f);
        }
    }

    public void fh() {
        throw null;
    }

    public void gv(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.f5758i4 == null) {
            this.f5758i4 = new ArrayList<>();
        }
        this.f5758i4.add(animatorListener);
    }

    public final void hw(float f4) {
        if (this.f5750c5 != f4) {
            this.f5750c5 = f4;
            ta(this.f5767s, f4, this.f5759i9);
        }
    }

    public void i4(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        throw null;
    }

    @Nullable
    public final Drawable i9() {
        return this.f5771v;
    }

    public final void j(float f4) {
        if (this.f5759i9 != f4) {
            this.f5759i9 = f4;
            ta(this.f5767s, this.f5750c5, f4);
        }
    }

    public final void j5(float f4) {
        this.f5751co = f4;
        Matrix matrix = this.f5760mg;
        fb(f4, matrix);
        this.f5762n.setImageMatrix(matrix);
    }

    public final boolean jz() {
        if (this.f5748a && this.f5762n.getSizeDimension() < this.f5753f) {
            return false;
        }
        return true;
    }

    public final void k(@Nullable y6.s sVar) {
        this.f5772w = sVar;
    }

    public final void k5(float f4) {
        if (this.f5767s != f4) {
            this.f5767s = f4;
            ta(f4, this.f5750c5, this.f5759i9);
        }
    }

    public void mg(int[] iArr) {
        throw null;
    }

    public void mt(@NonNull Rect rect) {
        int i;
        float f4;
        if (this.f5748a) {
            i = (this.f5753f - this.f5762n.getSizeDimension()) / 2;
        } else {
            i = 0;
        }
        if (this.f5755fb) {
            f4 = tl() + this.f5759i9;
        } else {
            f4 = 0.0f;
        }
        int max = Math.max(i, (int) Math.ceil(f4));
        int max2 = Math.max(i, (int) Math.ceil(f4 * 1.5f));
        rect.set(max, max2, max, max2);
    }

    public boolean n() {
        if (this.f5762n.getVisibility() != 0) {
            if (this.f5765r != 2) {
                return false;
            }
            return true;
        } else if (this.f5765r == 1) {
            return false;
        } else {
            return true;
        }
    }

    public void o(int i) {
        this.f5753f = i;
    }

    public final void o4(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new gv());
    }

    public void oz(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f5777zn;
        if (drawable != null) {
            ej.y.xc(drawable, nr.n3.gv(colorStateList));
        }
    }

    @NonNull
    public final ViewTreeObserver.OnPreDrawListener p() {
        if (this.f5769ta == null) {
            this.f5769ta = new v();
        }
        return this.f5769ta;
    }

    public final void q9(@NonNull hx.f fVar) {
        this.y = fVar;
        hx.fb fbVar = this.f5763n3;
        if (fbVar != null) {
            fbVar.setShapeAppearanceModel(fVar);
        }
        Drawable drawable = this.f5777zn;
        if (drawable instanceof wz) {
            ((wz) drawable).setShapeAppearanceModel(fVar);
        }
        np.y yVar = this.f5757gv;
        if (yVar != null) {
            yVar.a(fVar);
        }
    }

    public final void qn(int i) {
        if (this.f5776z != i) {
            this.f5776z = i;
            xg();
        }
    }

    @Nullable
    public final y6.s r() {
        return this.f5772w;
    }

    public void rz() {
        ViewTreeObserver viewTreeObserver = this.f5762n.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.f5769ta;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.f5769ta = null;
        }
    }

    @NonNull
    public final AnimatorSet s(@NonNull y6.s sVar, float f4, float f6, float f9) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f5762n, View.ALPHA, f4);
        sVar.v("opacity").y(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f5762n, View.SCALE_X, f6);
        sVar.v("scale").y(ofFloat2);
        o4(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f5762n, View.SCALE_Y, f6);
        sVar.v("scale").y(ofFloat3);
        o4(ofFloat3);
        arrayList.add(ofFloat3);
        fb(f9, this.f5760mg);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f5762n, new y6.a(), new zn(), new Matrix(this.f5760mg));
        sVar.v("iconScale").y(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        y6.n3.y(animatorSet, arrayList);
        return animatorSet;
    }

    public final y6.s t() {
        if (this.f5770tl == null) {
            this.f5770tl = y6.s.zn(this.f5762n.getContext(), R$animator.n3);
        }
        return (y6.s) vl.s.fb(this.f5770tl);
    }

    public void ta(float f4, float f6, float f9) {
        throw null;
    }

    public float tl() {
        throw null;
    }

    public void u(@Nullable i9 i9Var, boolean z2) {
        if (n()) {
            return;
        }
        Animator animator = this.f5775xc;
        if (animator != null) {
            animator.cancel();
        }
        if (en()) {
            if (this.f5762n.getVisibility() != 0) {
                this.f5762n.setAlpha(0.0f);
                this.f5762n.setScaleY(0.0f);
                this.f5762n.setScaleX(0.0f);
                j5(0.0f);
            }
            y6.s sVar = this.f5772w;
            if (sVar == null) {
                sVar = t();
            }
            AnimatorSet s2 = s(sVar, 1.0f, 1.0f, 1.0f);
            s2.addListener(new n3(z2, i9Var));
            ArrayList<Animator.AnimatorListener> arrayList = this.f5774x4;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    s2.addListener(it.next());
                }
            }
            s2.start();
            return;
        }
        this.f5762n.n3(0, z2);
        this.f5762n.setAlpha(1.0f);
        this.f5762n.setScaleY(1.0f);
        this.f5762n.setScaleX(1.0f);
        j5(1.0f);
        if (i9Var != null) {
            i9Var.y();
        }
    }

    public void ud() {
        ArrayList<c5> arrayList = this.f5754f3;
        if (arrayList != null) {
            Iterator<c5> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().y();
            }
        }
    }

    public void ut(boolean z2) {
        this.f5755fb = z2;
        dm();
    }

    public void v(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.f5774x4 == null) {
            this.f5774x4 = new ArrayList<>();
        }
        this.f5774x4.add(animatorListener);
    }

    public final void vl(@Nullable y6.s sVar) {
        this.f5764p = sVar;
    }

    public float w() {
        return this.f5750c5;
    }

    public boolean wz() {
        return this.f5748a;
    }

    public void x(@Nullable ColorStateList colorStateList) {
        hx.fb fbVar = this.f5763n3;
        if (fbVar != null) {
            fbVar.setTintList(colorStateList);
        }
        np.y yVar = this.f5757gv;
        if (yVar != null) {
            yVar.zn(colorStateList);
        }
    }

    public void x4(@Nullable i9 i9Var, boolean z2) {
        int i;
        if (f3()) {
            return;
        }
        Animator animator = this.f5775xc;
        if (animator != null) {
            animator.cancel();
        }
        if (en()) {
            y6.s sVar = this.f5764p;
            if (sVar == null) {
                sVar = f();
            }
            AnimatorSet s2 = s(sVar, 0.0f, 0.0f, 0.0f);
            s2.addListener(new C0062y(z2, i9Var));
            ArrayList<Animator.AnimatorListener> arrayList = this.f5758i4;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    s2.addListener(it.next());
                }
            }
            s2.start();
            return;
        }
        FloatingActionButton floatingActionButton = this.f5762n;
        if (z2) {
            i = 8;
        } else {
            i = 4;
        }
        floatingActionButton.n3(i, z2);
        if (i9Var != null) {
            i9Var.n3();
        }
    }

    @Nullable
    public final y6.s xc() {
        return this.f5764p;
    }

    public final void xg() {
        j5(this.f5751co);
    }

    public void y5() {
        throw null;
    }

    public void yt(boolean z2) {
        this.f5748a = z2;
    }

    @Nullable
    public final hx.f z() {
        return this.y;
    }

    public void z6() {
        float rotation = this.f5762n.getRotation();
        if (this.f5761mt != rotation) {
            this.f5761mt = rotation;
            y5();
        }
    }
}
