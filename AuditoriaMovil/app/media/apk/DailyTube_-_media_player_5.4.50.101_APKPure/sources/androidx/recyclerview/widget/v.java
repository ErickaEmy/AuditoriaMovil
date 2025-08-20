package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;
import hw.i4;
/* loaded from: classes.dex */
public class v extends RecyclerView.xc implements RecyclerView.z {

    /* renamed from: c5  reason: collision with root package name */
    public final Drawable f3289c5;

    /* renamed from: co  reason: collision with root package name */
    public int f3290co;

    /* renamed from: d0  reason: collision with root package name */
    public final ValueAnimator f3291d0;

    /* renamed from: f  reason: collision with root package name */
    public final int f3292f;

    /* renamed from: f3  reason: collision with root package name */
    public int f3293f3;

    /* renamed from: fb  reason: collision with root package name */
    public final int f3294fb;

    /* renamed from: fh  reason: collision with root package name */
    public int f3295fh;

    /* renamed from: gv  reason: collision with root package name */
    public final Drawable f3296gv;

    /* renamed from: i4  reason: collision with root package name */
    public int f3297i4;

    /* renamed from: i9  reason: collision with root package name */
    public final int f3298i9;

    /* renamed from: mg  reason: collision with root package name */
    public final RecyclerView.r f3299mg;

    /* renamed from: mt  reason: collision with root package name */
    public int f3300mt;

    /* renamed from: n3  reason: collision with root package name */
    public final int f3302n3;

    /* renamed from: p  reason: collision with root package name */
    public float f3303p;

    /* renamed from: r  reason: collision with root package name */
    public boolean f3304r;

    /* renamed from: rz  reason: collision with root package name */
    public final Runnable f3305rz;

    /* renamed from: s  reason: collision with root package name */
    public final StateListDrawable f3306s;

    /* renamed from: t  reason: collision with root package name */
    public int f3307t;

    /* renamed from: tl  reason: collision with root package name */
    public int f3308tl;

    /* renamed from: v  reason: collision with root package name */
    public final int f3309v;

    /* renamed from: w  reason: collision with root package name */
    public int f3310w;

    /* renamed from: wz  reason: collision with root package name */
    public float f3311wz;

    /* renamed from: x4  reason: collision with root package name */
    public boolean f3312x4;

    /* renamed from: xc  reason: collision with root package name */
    public int f3313xc;
    public final int y;

    /* renamed from: z  reason: collision with root package name */
    public RecyclerView f3314z;

    /* renamed from: zn  reason: collision with root package name */
    public final StateListDrawable f3315zn;

    /* renamed from: ta  reason: collision with root package name */
    public static final int[] f3287ta = {16842919};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f3286d = new int[0];

    /* renamed from: n  reason: collision with root package name */
    public final int[] f3301n = new int[2];

    /* renamed from: c  reason: collision with root package name */
    public final int[] f3288c = new int[2];

    /* loaded from: classes.dex */
    public class gv implements ValueAnimator.AnimatorUpdateListener {
        public gv() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            v.this.f3315zn.setAlpha(floatValue);
            v.this.f3296gv.setAlpha(floatValue);
            v.this.tl();
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends RecyclerView.r {
        public n3() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void n3(RecyclerView recyclerView, int i, int i5) {
            v.this.co(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.s(500);
        }
    }

    /* loaded from: classes.dex */
    public class zn extends AnimatorListenerAdapter {
        public boolean y;

        public zn() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.y = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.y) {
                this.y = false;
            } else if (((Float) v.this.f3291d0.getAnimatedValue()).floatValue() == 0.0f) {
                v vVar = v.this;
                vVar.f3295fh = 0;
                vVar.w(0);
            } else {
                v vVar2 = v.this;
                vVar2.f3295fh = 2;
                vVar2.tl();
            }
        }
    }

    public v(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i5, int i6) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f3291d0 = ofFloat;
        this.f3295fh = 0;
        this.f3305rz = new y();
        this.f3299mg = new n3();
        this.f3315zn = stateListDrawable;
        this.f3296gv = drawable;
        this.f3306s = stateListDrawable2;
        this.f3289c5 = drawable2;
        this.f3309v = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f3294fb = Math.max(i, drawable.getIntrinsicWidth());
        this.f3298i9 = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.f3292f = Math.max(i, drawable2.getIntrinsicWidth());
        this.y = i5;
        this.f3302n3 = i6;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new zn());
        ofFloat.addUpdateListener(new gv());
        y(recyclerView);
    }

    public final int[] a() {
        int[] iArr = this.f3288c;
        int i = this.f3302n3;
        iArr[0] = i;
        iArr[1] = this.f3300mt - i;
        return iArr;
    }

    public final void c5(float f4) {
        int[] a2 = a();
        float max = Math.max(a2[0], Math.min(a2[1], f4));
        if (Math.abs(this.f3310w - max) < 2.0f) {
            return;
        }
        int xc2 = xc(this.f3303p, max, a2, this.f3314z.computeHorizontalScrollRange(), this.f3314z.computeHorizontalScrollOffset(), this.f3300mt);
        if (xc2 != 0) {
            this.f3314z.scrollBy(xc2, 0);
        }
        this.f3303p = max;
    }

    public void co(int i, int i5) {
        boolean z2;
        boolean z3;
        int computeVerticalScrollRange = this.f3314z.computeVerticalScrollRange();
        int i6 = this.f3290co;
        if (computeVerticalScrollRange - i6 > 0 && i6 >= this.y) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f3304r = z2;
        int computeHorizontalScrollRange = this.f3314z.computeHorizontalScrollRange();
        int i8 = this.f3300mt;
        if (computeHorizontalScrollRange - i8 > 0 && i8 >= this.y) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f3312x4 = z3;
        boolean z4 = this.f3304r;
        if (!z4 && !z3) {
            if (this.f3297i4 != 0) {
                w(0);
                return;
            }
            return;
        }
        if (z4) {
            float f4 = i6;
            this.f3308tl = (int) ((f4 * (i5 + (f4 / 2.0f))) / computeVerticalScrollRange);
            this.f3307t = Math.min(i6, (i6 * i6) / computeVerticalScrollRange);
        }
        if (this.f3312x4) {
            float f6 = i8;
            this.f3310w = (int) ((f6 * (i + (f6 / 2.0f))) / computeHorizontalScrollRange);
            this.f3313xc = Math.min(i8, (i8 * i8) / computeHorizontalScrollRange);
        }
        int i10 = this.f3297i4;
        if (i10 == 0 || i10 == 1) {
            w(1);
        }
    }

    public boolean f(float f4, float f6) {
        if (f6 >= this.f3290co - this.f3298i9) {
            int i = this.f3310w;
            int i5 = this.f3313xc;
            if (f4 >= i - (i5 / 2) && f4 <= i + (i5 / 2)) {
                return true;
            }
        }
        return false;
    }

    public final int[] fb() {
        int[] iArr = this.f3301n;
        int i = this.f3302n3;
        iArr[0] = i;
        iArr[1] = this.f3290co - i;
        return iArr;
    }

    public final void gv(Canvas canvas) {
        int i = this.f3290co;
        int i5 = this.f3298i9;
        int i6 = i - i5;
        int i8 = this.f3310w;
        int i10 = this.f3313xc;
        int i11 = i8 - (i10 / 2);
        this.f3306s.setBounds(0, 0, i10, i5);
        this.f3289c5.setBounds(0, 0, this.f3300mt, this.f3292f);
        canvas.translate(0.0f, i6);
        this.f3289c5.draw(canvas);
        canvas.translate(i11, 0.0f);
        this.f3306s.draw(canvas);
        canvas.translate(-i11, -i6);
    }

    public final boolean i9() {
        if (i4.ta(this.f3314z) == 1) {
            return true;
        }
        return false;
    }

    public void mt() {
        int i = this.f3295fh;
        if (i != 0) {
            if (i == 3) {
                this.f3291d0.cancel();
            } else {
                return;
            }
        }
        this.f3295fh = 1;
        ValueAnimator valueAnimator = this.f3291d0;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f3291d0.setDuration(500L);
        this.f3291d0.setStartDelay(0L);
        this.f3291d0.start();
    }

    public final void n3() {
        this.f3314z.removeCallbacks(this.f3305rz);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.xc
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.fh fhVar) {
        if (this.f3300mt == this.f3314z.getWidth() && this.f3290co == this.f3314z.getHeight()) {
            if (this.f3295fh != 0) {
                if (this.f3304r) {
                    v(canvas);
                }
                if (this.f3312x4) {
                    gv(canvas);
                    return;
                }
                return;
            }
            return;
        }
        this.f3300mt = this.f3314z.getWidth();
        this.f3290co = this.f3314z.getHeight();
        w(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        int i = this.f3297i4;
        if (i == 1) {
            boolean t2 = t(motionEvent.getX(), motionEvent.getY());
            boolean f4 = f(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!t2 && !f4) {
                return false;
            }
            if (f4) {
                this.f3293f3 = 1;
                this.f3303p = (int) motionEvent.getX();
            } else if (t2) {
                this.f3293f3 = 2;
                this.f3311wz = (int) motionEvent.getY();
            }
            w(2);
        } else if (i != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    public void onRequestDisallowInterceptTouchEvent(boolean z2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        if (this.f3297i4 == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean t2 = t(motionEvent.getX(), motionEvent.getY());
            boolean f4 = f(motionEvent.getX(), motionEvent.getY());
            if (t2 || f4) {
                if (f4) {
                    this.f3293f3 = 1;
                    this.f3303p = (int) motionEvent.getX();
                } else if (t2) {
                    this.f3293f3 = 2;
                    this.f3311wz = (int) motionEvent.getY();
                }
                w(2);
            }
        } else if (motionEvent.getAction() == 1 && this.f3297i4 == 2) {
            this.f3311wz = 0.0f;
            this.f3303p = 0.0f;
            w(1);
            this.f3293f3 = 0;
        } else if (motionEvent.getAction() == 2 && this.f3297i4 == 2) {
            mt();
            if (this.f3293f3 == 1) {
                c5(motionEvent.getX());
            }
            if (this.f3293f3 == 2) {
                z(motionEvent.getY());
            }
        }
    }

    public final void p() {
        this.f3314z.addItemDecoration(this);
        this.f3314z.addOnItemTouchListener(this);
        this.f3314z.addOnScrollListener(this.f3299mg);
    }

    public void s(int i) {
        int i5 = this.f3295fh;
        if (i5 != 1) {
            if (i5 != 2) {
                return;
            }
        } else {
            this.f3291d0.cancel();
        }
        this.f3295fh = 3;
        ValueAnimator valueAnimator = this.f3291d0;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f3291d0.setDuration(i);
        this.f3291d0.start();
    }

    public boolean t(float f4, float f6) {
        if (!i9() ? f4 >= this.f3300mt - this.f3309v : f4 <= this.f3309v) {
            int i = this.f3308tl;
            int i5 = this.f3307t;
            if (f6 >= i - (i5 / 2) && f6 <= i + (i5 / 2)) {
                return true;
            }
        }
        return false;
    }

    public void tl() {
        this.f3314z.invalidate();
    }

    public final void v(Canvas canvas) {
        int i = this.f3300mt;
        int i5 = this.f3309v;
        int i6 = i - i5;
        int i8 = this.f3308tl;
        int i10 = this.f3307t;
        int i11 = i8 - (i10 / 2);
        this.f3315zn.setBounds(0, 0, i5, i10);
        this.f3296gv.setBounds(0, 0, this.f3294fb, this.f3290co);
        if (i9()) {
            this.f3296gv.draw(canvas);
            canvas.translate(this.f3309v, i11);
            canvas.scale(-1.0f, 1.0f);
            this.f3315zn.draw(canvas);
            canvas.scale(-1.0f, 1.0f);
            canvas.translate(-this.f3309v, -i11);
            return;
        }
        canvas.translate(i6, 0.0f);
        this.f3296gv.draw(canvas);
        canvas.translate(0.0f, i11);
        this.f3315zn.draw(canvas);
        canvas.translate(-i6, -i11);
    }

    public void w(int i) {
        if (i == 2 && this.f3297i4 != 2) {
            this.f3315zn.setState(f3287ta);
            n3();
        }
        if (i == 0) {
            tl();
        } else {
            mt();
        }
        if (this.f3297i4 == 2 && i != 2) {
            this.f3315zn.setState(f3286d);
            wz(1200);
        } else if (i == 1) {
            wz(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
        this.f3297i4 = i;
    }

    public final void wz(int i) {
        n3();
        this.f3314z.postDelayed(this.f3305rz, i);
    }

    public final int xc(float f4, float f6, int[] iArr, int i, int i5, int i6) {
        int i8 = iArr[1] - iArr[0];
        if (i8 == 0) {
            return 0;
        }
        int i10 = i - i6;
        int i11 = (int) (((f6 - f4) / i8) * i10);
        int i12 = i5 + i11;
        if (i12 >= i10 || i12 < 0) {
            return 0;
        }
        return i11;
    }

    public void y(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f3314z;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            zn();
        }
        this.f3314z = recyclerView;
        if (recyclerView != null) {
            p();
        }
    }

    public final void z(float f4) {
        int[] fb2 = fb();
        float max = Math.max(fb2[0], Math.min(fb2[1], f4));
        if (Math.abs(this.f3308tl - max) < 2.0f) {
            return;
        }
        int xc2 = xc(this.f3311wz, max, fb2, this.f3314z.computeVerticalScrollRange(), this.f3314z.computeVerticalScrollOffset(), this.f3290co);
        if (xc2 != 0) {
            this.f3314z.scrollBy(0, xc2);
        }
        this.f3311wz = max;
    }

    public final void zn() {
        this.f3314z.removeItemDecoration(this);
        this.f3314z.removeOnItemTouchListener(this);
        this.f3314z.removeOnScrollListener(this.f3299mg);
        n3();
    }
}
