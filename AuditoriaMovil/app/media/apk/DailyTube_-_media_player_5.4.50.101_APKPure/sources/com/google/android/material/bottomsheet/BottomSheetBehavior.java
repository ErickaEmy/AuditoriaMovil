package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import hw.ej;
import hw.i4;
import hx.f;
import j5.a;
import j5.zn;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import ur.f;
import ut.zn;
/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.zn<V> {

    /* renamed from: qn  reason: collision with root package name */
    public static final int f5445qn = R$style.f5109fb;

    /* renamed from: a  reason: collision with root package name */
    public boolean f5446a;
    @NonNull

    /* renamed from: a8  reason: collision with root package name */
    public final ArrayList<a> f5447a8;

    /* renamed from: b  reason: collision with root package name */
    public int f5448b;

    /* renamed from: c  reason: collision with root package name */
    public int f5449c;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f5450c5;

    /* renamed from: co  reason: collision with root package name */
    public int f5451co;

    /* renamed from: d  reason: collision with root package name */
    public int f5452d;
    @Nullable

    /* renamed from: d0  reason: collision with root package name */
    public ut.zn f5453d0;
    @Nullable

    /* renamed from: ej  reason: collision with root package name */
    public WeakReference<V> f5454ej;

    /* renamed from: f  reason: collision with root package name */
    public int f5455f;

    /* renamed from: f3  reason: collision with root package name */
    public boolean f5456f3;

    /* renamed from: fb  reason: collision with root package name */
    public int f5457fb;

    /* renamed from: fh  reason: collision with root package name */
    public boolean f5458fh;

    /* renamed from: gv  reason: collision with root package name */
    public float f5459gv;

    /* renamed from: hw  reason: collision with root package name */
    public int f5460hw;

    /* renamed from: i4  reason: collision with root package name */
    public boolean f5461i4;

    /* renamed from: i9  reason: collision with root package name */
    public hx.fb f5462i9;

    /* renamed from: j5  reason: collision with root package name */
    public final zn.AbstractC0235zn f5463j5;

    /* renamed from: k5  reason: collision with root package name */
    public int f5464k5;

    /* renamed from: mg  reason: collision with root package name */
    public boolean f5465mg;

    /* renamed from: mt  reason: collision with root package name */
    public int f5466mt;

    /* renamed from: n  reason: collision with root package name */
    public boolean f5467n;

    /* renamed from: n3  reason: collision with root package name */
    public boolean f5468n3;

    /* renamed from: p  reason: collision with root package name */
    public int f5469p;

    /* renamed from: r  reason: collision with root package name */
    public int f5470r;

    /* renamed from: rz  reason: collision with root package name */
    public int f5471rz;

    /* renamed from: s  reason: collision with root package name */
    public int f5472s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f5473t;

    /* renamed from: ta  reason: collision with root package name */
    public int f5474ta;

    /* renamed from: tl  reason: collision with root package name */
    public f f5475tl;
    @Nullable

    /* renamed from: ud  reason: collision with root package name */
    public WeakReference<View> f5476ud;

    /* renamed from: v  reason: collision with root package name */
    public int f5477v;
    @Nullable

    /* renamed from: vl  reason: collision with root package name */
    public Map<View, Integer> f5478vl;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public ValueAnimator f5479w;

    /* renamed from: wz  reason: collision with root package name */
    public boolean f5480wz;
    @Nullable

    /* renamed from: x  reason: collision with root package name */
    public VelocityTracker f5481x;

    /* renamed from: x4  reason: collision with root package name */
    public float f5482x4;

    /* renamed from: xc  reason: collision with root package name */
    public BottomSheetBehavior<V>.fb f5483xc;
    public int y;

    /* renamed from: yt  reason: collision with root package name */
    public boolean f5484yt;

    /* renamed from: z  reason: collision with root package name */
    public float f5485z;

    /* renamed from: z6  reason: collision with root package name */
    public int f5486z6;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f5487zn;

    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract void n3(@NonNull View view, int i);

        public abstract void y(@NonNull View view, float f4);
    }

    /* loaded from: classes.dex */
    public class fb implements Runnable {

        /* renamed from: fb  reason: collision with root package name */
        public int f5493fb;

        /* renamed from: v  reason: collision with root package name */
        public boolean f5495v;
        public final View y;

        public fb(View view, int i) {
            this.y = view;
            this.f5493fb = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ut.zn znVar = BottomSheetBehavior.this.f5453d0;
            if (znVar != null && znVar.tl(true)) {
                i4.nf(this.y, this);
            } else {
                BottomSheetBehavior.this.rb(this.f5493fb);
            }
            this.f5495v = false;
        }
    }

    /* loaded from: classes.dex */
    public class gv extends zn.AbstractC0235zn {
        public gv() {
        }

        @Override // ut.zn.AbstractC0235zn
        public void f(@NonNull View view, int i, int i5, int i6, int i8) {
            BottomSheetBehavior.this.oz(i5);
        }

        @Override // ut.zn.AbstractC0235zn
        public void i9(int i) {
            if (i == 1 && BottomSheetBehavior.this.f5467n) {
                BottomSheetBehavior.this.rb(1);
            }
        }

        @Override // ut.zn.AbstractC0235zn
        public int n3(@NonNull View view, int i, int i5) {
            int i6;
            int k2 = BottomSheetBehavior.this.k();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.f5461i4) {
                i6 = bottomSheetBehavior.f5486z6;
            } else {
                i6 = bottomSheetBehavior.f5470r;
            }
            return a8.y.n3(i, k2, i6);
        }

        @Override // ut.zn.AbstractC0235zn
        public void t(@NonNull View view, float f4, float f6) {
            int i;
            int i5 = 6;
            if (f6 < 0.0f) {
                if (BottomSheetBehavior.this.f5468n3) {
                    i = BottomSheetBehavior.this.f5466mt;
                } else {
                    int top = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    int i6 = bottomSheetBehavior.f5451co;
                    if (top > i6) {
                        i = i6;
                    } else {
                        i = bottomSheetBehavior.f5469p;
                    }
                }
                i5 = 3;
            } else {
                BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                if (bottomSheetBehavior2.f5461i4 && bottomSheetBehavior2.u0(view, f6)) {
                    if ((Math.abs(f4) < Math.abs(f6) && f6 > 500.0f) || wz(view)) {
                        i = BottomSheetBehavior.this.f5486z6;
                        i5 = 5;
                    } else {
                        if (BottomSheetBehavior.this.f5468n3) {
                            i = BottomSheetBehavior.this.f5466mt;
                        } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.f5469p) < Math.abs(view.getTop() - BottomSheetBehavior.this.f5451co)) {
                            i = BottomSheetBehavior.this.f5469p;
                        } else {
                            i = BottomSheetBehavior.this.f5451co;
                        }
                        i5 = 3;
                    }
                } else if (f6 != 0.0f && Math.abs(f4) <= Math.abs(f6)) {
                    if (BottomSheetBehavior.this.f5468n3) {
                        i = BottomSheetBehavior.this.f5470r;
                    } else {
                        int top2 = view.getTop();
                        if (Math.abs(top2 - BottomSheetBehavior.this.f5451co) < Math.abs(top2 - BottomSheetBehavior.this.f5470r)) {
                            i = BottomSheetBehavior.this.f5451co;
                        } else {
                            i = BottomSheetBehavior.this.f5470r;
                        }
                    }
                    i5 = 4;
                } else {
                    int top3 = view.getTop();
                    if (BottomSheetBehavior.this.f5468n3) {
                        if (Math.abs(top3 - BottomSheetBehavior.this.f5466mt) < Math.abs(top3 - BottomSheetBehavior.this.f5470r)) {
                            i = BottomSheetBehavior.this.f5466mt;
                            i5 = 3;
                        } else {
                            i = BottomSheetBehavior.this.f5470r;
                            i5 = 4;
                        }
                    } else {
                        BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                        int i8 = bottomSheetBehavior3.f5451co;
                        if (top3 < i8) {
                            if (top3 < Math.abs(top3 - bottomSheetBehavior3.f5470r)) {
                                i = BottomSheetBehavior.this.f5469p;
                                i5 = 3;
                            } else {
                                i = BottomSheetBehavior.this.f5451co;
                            }
                        } else if (Math.abs(top3 - i8) < Math.abs(top3 - BottomSheetBehavior.this.f5470r)) {
                            i = BottomSheetBehavior.this.f5451co;
                        } else {
                            i = BottomSheetBehavior.this.f5470r;
                            i5 = 4;
                        }
                    }
                }
            }
            BottomSheetBehavior.this.bk(view, i5, i, true);
        }

        @Override // ut.zn.AbstractC0235zn
        public boolean tl(@NonNull View view, int i) {
            View view2;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i5 = bottomSheetBehavior.f5449c;
            if (i5 == 1 || bottomSheetBehavior.f5484yt) {
                return false;
            }
            if (i5 == 3 && bottomSheetBehavior.f5448b == i) {
                WeakReference<View> weakReference = bottomSheetBehavior.f5476ud;
                if (weakReference != null) {
                    view2 = weakReference.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.f5454ej;
            if (weakReference2 == null || weakReference2.get() != view) {
                return false;
            }
            return true;
        }

        @Override // ut.zn.AbstractC0235zn
        public int v(@NonNull View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.f5461i4) {
                return bottomSheetBehavior.f5486z6;
            }
            return bottomSheetBehavior.f5470r;
        }

        public final boolean wz(@NonNull View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (top > (bottomSheetBehavior.f5486z6 + bottomSheetBehavior.k()) / 2) {
                return true;
            }
            return false;
        }

        @Override // ut.zn.AbstractC0235zn
        public int y(@NonNull View view, int i, int i5) {
            return view.getLeft();
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements ValueAnimator.AnimatorUpdateListener {
        public n3() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f5462i9 != null) {
                BottomSheetBehavior.this.f5462i9.f7(floatValue);
            }
        }
    }

    /* loaded from: classes.dex */
    public class v implements j5.a {
        public final /* synthetic */ int y;

        public v(int i) {
            this.y = i;
        }

        @Override // j5.a
        public boolean y(@NonNull View view, @Nullable a.y yVar) {
            BottomSheetBehavior.this.kp(this.y);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ int f5498v;
        public final /* synthetic */ View y;

        public y(View view, int i) {
            this.y = view;
            this.f5498v = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.m(this.y, this.f5498v);
        }
    }

    /* loaded from: classes.dex */
    public class zn implements f.zn {
        public zn() {
        }

        @Override // ur.f.zn
        public ej y(View view, ej ejVar, f.gv gvVar) {
            BottomSheetBehavior.this.f5455f = ejVar.fb().f15663gv;
            BottomSheetBehavior.this.pq(false);
            return ejVar;
        }
    }

    public BottomSheetBehavior() {
        this.f5468n3 = true;
        this.f5485z = 0.5f;
        this.f5482x4 = -1.0f;
        this.f5467n = true;
        this.f5449c = 4;
        this.f5447a8 = new ArrayList<>();
        this.f5460hw = -1;
        this.f5463j5 = new gv();
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> q9(@NonNull V v2) {
        ViewGroup.LayoutParams layoutParams = v2.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.a) {
            CoordinatorLayout.zn a2 = ((CoordinatorLayout.a) layoutParams).a();
            if (a2 instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) a2;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public final void ap(int i, boolean z2) {
        if (i == -1) {
            if (!this.f5446a) {
                this.f5446a = true;
            } else {
                return;
            }
        } else if (this.f5446a || this.f5477v != i) {
            this.f5446a = false;
            this.f5477v = Math.max(0, i);
        } else {
            return;
        }
        pq(z2);
    }

    public final int b(V v2, int i, int i5) {
        return i4.zn(v2, v2.getResources().getString(i), j5(i5));
    }

    public void bk(View view, int i, int i5, boolean z2) {
        ut.zn znVar = this.f5453d0;
        if (znVar != null && (!z2 ? znVar.j5(view, view.getLeft(), i5) : znVar.vl(view.getLeft(), i5))) {
            rb(2);
            tg(i);
            if (this.f5483xc == null) {
                this.f5483xc = new fb(view, i);
            }
            if (!this.f5483xc.f5495v) {
                BottomSheetBehavior<V>.fb fbVar = this.f5483xc;
                fbVar.f5493fb = i;
                i4.nf(view, fbVar);
                this.f5483xc.f5495v = true;
                return;
            }
            this.f5483xc.f5493fb = i;
            return;
        }
        rb(i);
    }

    public final void ct(@NonNull SavedState savedState) {
        int i = this.y;
        if (i == 0) {
            return;
        }
        if (i == -1 || (i & 1) == 1) {
            this.f5477v = savedState.f5490s;
        }
        if (i == -1 || (i & 2) == 2) {
            this.f5468n3 = savedState.f5488f;
        }
        if (i == -1 || (i & 4) == 4) {
            this.f5461i4 = savedState.f5491t;
        }
        if (i == -1 || (i & 8) == 8) {
            this.f5456f3 = savedState.f5492w;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public boolean d0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, @NonNull View view2, int i, int i5) {
        this.f5471rz = 0;
        this.f5465mg = false;
        if ((i & 2) == 0) {
            return false;
        }
        return true;
    }

    public final void dm() {
        this.f5448b = -1;
        VelocityTracker velocityTracker = this.f5481x;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f5481x = null;
        }
    }

    public void e(boolean z2) {
        if (this.f5461i4 != z2) {
            this.f5461i4 = z2;
            if (!z2 && this.f5449c == 5) {
                kp(4);
            }
            y4();
        }
    }

    public void eb(int i) {
        if (i >= 0) {
            this.f5469p = i;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public final float en() {
        VelocityTracker velocityTracker = this.f5481x;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f5459gv);
        return this.f5481x.getYVelocity(this.f5448b);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public boolean f(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull MotionEvent motionEvent) {
        boolean z2;
        View view;
        ut.zn znVar;
        if (v2.isShown() && this.f5467n) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                dm();
            }
            if (this.f5481x == null) {
                this.f5481x = VelocityTracker.obtain();
            }
            this.f5481x.addMovement(motionEvent);
            View view2 = null;
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    this.f5484yt = false;
                    this.f5448b = -1;
                    if (this.f5458fh) {
                        this.f5458fh = false;
                        return false;
                    }
                }
            } else {
                int x2 = (int) motionEvent.getX();
                this.f5464k5 = (int) motionEvent.getY();
                if (this.f5449c != 2) {
                    WeakReference<View> weakReference = this.f5476ud;
                    if (weakReference != null) {
                        view = weakReference.get();
                    } else {
                        view = null;
                    }
                    if (view != null && coordinatorLayout.fh(view, x2, this.f5464k5)) {
                        this.f5448b = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.f5484yt = true;
                    }
                }
                if (this.f5448b == -1 && !coordinatorLayout.fh(v2, x2, this.f5464k5)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.f5458fh = z2;
            }
            if (!this.f5458fh && (znVar = this.f5453d0) != null && znVar.hw(motionEvent)) {
                return true;
            }
            WeakReference<View> weakReference2 = this.f5476ud;
            if (weakReference2 != null) {
                view2 = weakReference2.get();
            }
            if (actionMasked != 2 || view2 == null || this.f5458fh || this.f5449c == 1 || coordinatorLayout.fh(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f5453d0 == null || Math.abs(this.f5464k5 - motionEvent.getY()) <= this.f5453d0.c()) {
                return false;
            }
            return true;
        }
        this.f5458fh = true;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public void f3(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.f3(coordinatorLayout, v2, savedState.y());
        ct(savedState);
        int i = savedState.f5489fb;
        if (i != 1 && i != 2) {
            this.f5449c = i;
        } else {
            this.f5449c = 4;
        }
    }

    public int f7() {
        return this.f5449c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public void fb(@NonNull CoordinatorLayout.a aVar) {
        super.fb(aVar);
        this.f5454ej = null;
        this.f5453d0 = null;
    }

    public final void g(int i) {
        V v2 = this.f5454ej.get();
        if (v2 == null) {
            return;
        }
        ViewParent parent = v2.getParent();
        if (parent != null && parent.isLayoutRequested() && i4.ut(v2)) {
            v2.post(new y(v2, i));
        } else {
            m(v2, i);
        }
    }

    public final void g3(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 29 && !jz() && !this.f5446a) {
            ur.f.y(view, new zn());
        }
    }

    public final int hw() {
        int i;
        if (this.f5446a) {
            return Math.min(Math.max(this.f5457fb, this.f5486z6 - ((this.f5452d * 9) / 16)), this.f5474ta);
        }
        if (!this.f5473t && (i = this.f5455f) > 0) {
            return Math.max(this.f5477v, i + this.f5472s);
        }
        return this.f5477v;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public void i9() {
        super.i9();
        this.f5454ej = null;
        this.f5453d0 = null;
    }

    public final void j() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f5479w = ofFloat;
        ofFloat.setDuration(500L);
        this.f5479w.addUpdateListener(new n3());
    }

    public final j5.a j5(int i) {
        return new v(i);
    }

    public boolean jz() {
        return this.f5473t;
    }

    public int k() {
        if (this.f5468n3) {
            return this.f5466mt;
        }
        return this.f5469p;
    }

    public void k5(@NonNull a aVar) {
        if (!this.f5447a8.contains(aVar)) {
            this.f5447a8.add(aVar);
        }
    }

    public void kp(int i) {
        if (i == this.f5449c) {
            return;
        }
        if (this.f5454ej == null) {
            if (i == 4 || i == 3 || i == 6 || (this.f5461i4 && i == 5)) {
                this.f5449c = i;
                return;
            }
            return;
        }
        g(i);
    }

    public void lc(boolean z2) {
        int i;
        if (this.f5468n3 == z2) {
            return;
        }
        this.f5468n3 = z2;
        if (this.f5454ej != null) {
            yt();
        }
        if (this.f5468n3 && this.f5449c == 6) {
            i = 3;
        } else {
            i = this.f5449c;
        }
        rb(i);
        y4();
    }

    public void m(@NonNull View view, int i) {
        int i5;
        int i6;
        if (i == 4) {
            i5 = this.f5470r;
        } else if (i == 6) {
            i5 = this.f5451co;
            if (this.f5468n3 && i5 <= (i6 = this.f5466mt)) {
                i5 = i6;
                i = 3;
            }
        } else if (i == 3) {
            i5 = k();
        } else if (this.f5461i4 && i == 5) {
            i5 = this.f5486z6;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i);
        }
        bk(view, i, i5, false);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public boolean mg(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull MotionEvent motionEvent) {
        if (!v2.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f5449c == 1 && actionMasked == 0) {
            return true;
        }
        ut.zn znVar = this.f5453d0;
        if (znVar != null) {
            znVar.d(motionEvent);
        }
        if (actionMasked == 0) {
            dm();
        }
        if (this.f5481x == null) {
            this.f5481x = VelocityTracker.obtain();
        }
        this.f5481x.addMovement(motionEvent);
        if (this.f5453d0 != null && actionMasked == 2 && !this.f5458fh && Math.abs(this.f5464k5 - motionEvent.getY()) > this.f5453d0.c()) {
            this.f5453d0.n3(v2, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f5458fh;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    @NonNull
    public Parcelable n(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2) {
        return new SavedState(super.n(coordinatorLayout, v2), (BottomSheetBehavior<?>) this);
    }

    public void nf(boolean z2) {
        this.f5473t = z2;
    }

    public final void o(@NonNull Context context, AttributeSet attributeSet, boolean z2, @Nullable ColorStateList colorStateList) {
        if (this.f5450c5) {
            this.f5475tl = hx.f.v(context, attributeSet, R$attr.ba, f5445qn).tl();
            hx.fb fbVar = new hx.fb(this.f5475tl);
            this.f5462i9 = fbVar;
            fbVar.k5(context);
            if (z2 && colorStateList != null) {
                this.f5462i9.k(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.f5462i9.setTint(typedValue.data);
        }
    }

    @Deprecated
    public void o4(a aVar) {
        Log.w("BottomSheetBehavior", "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.f5447a8.clear();
        if (aVar != null) {
            this.f5447a8.add(aVar);
        }
    }

    public void oz(int i) {
        float f4;
        float f6;
        V v2 = this.f5454ej.get();
        if (v2 != null && !this.f5447a8.isEmpty()) {
            int i5 = this.f5470r;
            if (i <= i5 && i5 != k()) {
                int i6 = this.f5470r;
                f4 = i6 - i;
                f6 = i6 - k();
            } else {
                int i8 = this.f5470r;
                f4 = i8 - i;
                f6 = this.f5486z6 - i8;
            }
            float f9 = f4 / f6;
            for (int i10 = 0; i10 < this.f5447a8.size(); i10++) {
                this.f5447a8.get(i10).y(v2, f9);
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public void p(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, int i, int i5, @NonNull int[] iArr, int i6) {
        View view2;
        if (i6 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.f5476ud;
        if (weakReference != null) {
            view2 = weakReference.get();
        } else {
            view2 = null;
        }
        if (view != view2) {
            return;
        }
        int top = v2.getTop();
        int i8 = top - i5;
        if (i5 > 0) {
            if (i8 < k()) {
                int k2 = top - k();
                iArr[1] = k2;
                i4.xg(v2, -k2);
                rb(3);
            } else if (!this.f5467n) {
                return;
            } else {
                iArr[1] = i5;
                i4.xg(v2, -i5);
                rb(1);
            }
        } else if (i5 < 0 && !view.canScrollVertically(-1)) {
            int i10 = this.f5470r;
            if (i8 > i10 && !this.f5461i4) {
                int i11 = top - i10;
                iArr[1] = i11;
                i4.xg(v2, -i11);
                rb(4);
            } else if (!this.f5467n) {
                return;
            } else {
                iArr[1] = i5;
                i4.xg(v2, -i5);
                rb(1);
            }
        }
        oz(v2.getTop());
        this.f5471rz = i5;
        this.f5465mg = true;
    }

    public final void pq(boolean z2) {
        V v2;
        if (this.f5454ej != null) {
            yt();
            if (this.f5449c == 4 && (v2 = this.f5454ej.get()) != null) {
                if (z2) {
                    g(this.f5449c);
                } else {
                    v2.requestLayout();
                }
            }
        }
    }

    public final void pz(boolean z2) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.f5454ej;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (!(parent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        int childCount = coordinatorLayout.getChildCount();
        if (z2) {
            if (this.f5478vl == null) {
                this.f5478vl = new HashMap(childCount);
            } else {
                return;
            }
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = coordinatorLayout.getChildAt(i);
            if (childAt != this.f5454ej.get()) {
                if (z2) {
                    this.f5478vl.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    if (this.f5487zn) {
                        i4.o0(childAt, 4);
                    }
                } else if (this.f5487zn && (map = this.f5478vl) != null && map.containsKey(childAt)) {
                    i4.o0(childAt, this.f5478vl.get(childAt).intValue());
                }
            }
        }
        if (!z2) {
            this.f5478vl = null;
        } else if (this.f5487zn) {
            this.f5454ej.get().sendAccessibilityEvent(8);
        }
    }

    public final void qn(@NonNull Context context, AttributeSet attributeSet, boolean z2) {
        o(context, attributeSet, z2, null);
    }

    public void ra(float f4) {
        if (f4 > 0.0f && f4 < 1.0f) {
            this.f5485z = f4;
            if (this.f5454ej != null) {
                vl();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void rb(int i) {
        V v2;
        if (this.f5449c == i) {
            return;
        }
        this.f5449c = i;
        WeakReference<V> weakReference = this.f5454ej;
        if (weakReference == null || (v2 = weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            pz(true);
        } else if (i == 6 || i == 5 || i == 4) {
            pz(false);
        }
        tg(i);
        for (int i5 = 0; i5 < this.f5447a8.size(); i5++) {
            this.f5447a8.get(i5).n3(v2, i);
        }
        y4();
    }

    public void rs(boolean z2) {
        this.f5467n = z2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public void rz(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, int i) {
        int i5;
        int i6 = 3;
        if (v2.getTop() == k()) {
            rb(3);
            return;
        }
        WeakReference<View> weakReference = this.f5476ud;
        if (weakReference != null && view == weakReference.get() && this.f5465mg) {
            if (this.f5471rz > 0) {
                if (this.f5468n3) {
                    i5 = this.f5466mt;
                } else {
                    int top = v2.getTop();
                    int i8 = this.f5451co;
                    if (top > i8) {
                        i5 = i8;
                        i6 = 6;
                    } else {
                        i5 = this.f5469p;
                    }
                }
            } else if (this.f5461i4 && u0(v2, en())) {
                i5 = this.f5486z6;
                i6 = 5;
            } else if (this.f5471rz == 0) {
                int top2 = v2.getTop();
                if (this.f5468n3) {
                    if (Math.abs(top2 - this.f5466mt) < Math.abs(top2 - this.f5470r)) {
                        i5 = this.f5466mt;
                    } else {
                        i5 = this.f5470r;
                        i6 = 4;
                    }
                } else {
                    int i10 = this.f5451co;
                    if (top2 < i10) {
                        if (top2 < Math.abs(top2 - this.f5470r)) {
                            i5 = this.f5469p;
                        } else {
                            i5 = this.f5451co;
                        }
                    } else if (Math.abs(top2 - i10) < Math.abs(top2 - this.f5470r)) {
                        i5 = this.f5451co;
                    } else {
                        i5 = this.f5470r;
                        i6 = 4;
                    }
                    i6 = 6;
                }
            } else {
                if (this.f5468n3) {
                    i5 = this.f5470r;
                } else {
                    int top3 = v2.getTop();
                    if (Math.abs(top3 - this.f5451co) < Math.abs(top3 - this.f5470r)) {
                        i5 = this.f5451co;
                        i6 = 6;
                    } else {
                        i5 = this.f5470r;
                    }
                }
                i6 = 4;
            }
            bk(v2, i6, i5, false);
            this.f5465mg = false;
        }
    }

    public void s8(int i) {
        ap(i, false);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, int i) {
        boolean z2;
        float f4;
        hx.fb fbVar;
        if (i4.fh(coordinatorLayout) && !i4.fh(v2)) {
            v2.setFitsSystemWindows(true);
        }
        if (this.f5454ej == null) {
            this.f5457fb = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.kc);
            g3(v2);
            this.f5454ej = new WeakReference<>(v2);
            if (this.f5450c5 && (fbVar = this.f5462i9) != null) {
                i4.u0(v2, fbVar);
            }
            hx.fb fbVar2 = this.f5462i9;
            if (fbVar2 != null) {
                float f6 = this.f5482x4;
                if (f6 == -1.0f) {
                    f6 = i4.n(v2);
                }
                fbVar2.q9(f6);
                if (this.f5449c == 3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.f5480wz = z2;
                hx.fb fbVar3 = this.f5462i9;
                if (z2) {
                    f4 = 0.0f;
                } else {
                    f4 = 1.0f;
                }
                fbVar3.f7(f4);
            }
            y4();
            if (i4.rz(v2) == 0) {
                i4.o0(v2, 1);
            }
        }
        if (this.f5453d0 == null) {
            this.f5453d0 = ut.zn.xc(coordinatorLayout, this.f5463j5);
        }
        int top = v2.getTop();
        coordinatorLayout.ud(v2, i);
        this.f5452d = coordinatorLayout.getWidth();
        this.f5486z6 = coordinatorLayout.getHeight();
        int height = v2.getHeight();
        this.f5474ta = height;
        this.f5466mt = Math.max(0, this.f5486z6 - height);
        vl();
        yt();
        int i5 = this.f5449c;
        if (i5 == 3) {
            i4.xg(v2, k());
        } else if (i5 == 6) {
            i4.xg(v2, this.f5451co);
        } else if (this.f5461i4 && i5 == 5) {
            i4.xg(v2, this.f5486z6);
        } else if (i5 == 4) {
            i4.xg(v2, this.f5470r);
        } else if (i5 == 1 || i5 == 2) {
            i4.xg(v2, top - v2.getTop());
        }
        this.f5476ud = new WeakReference<>(ut(v2));
        return true;
    }

    public final void tg(int i) {
        boolean z2;
        ValueAnimator valueAnimator;
        float f4;
        if (i == 2) {
            return;
        }
        if (i == 3) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f5480wz != z2) {
            this.f5480wz = z2;
            if (this.f5462i9 != null && (valueAnimator = this.f5479w) != null) {
                if (valueAnimator.isRunning()) {
                    this.f5479w.reverse();
                    return;
                }
                if (z2) {
                    f4 = 0.0f;
                } else {
                    f4 = 1.0f;
                }
                this.f5479w.setFloatValues(1.0f - f4, f4);
                this.f5479w.start();
            }
        }
    }

    public boolean u() {
        return this.f5461i4;
    }

    public boolean u0(@NonNull View view, float f4) {
        if (this.f5456f3) {
            return true;
        }
        if (view.getTop() < this.f5470r) {
            return false;
        }
        if (Math.abs((view.getTop() + (f4 * 0.1f)) - this.f5470r) / hw() > 0.5f) {
            return true;
        }
        return false;
    }

    @Nullable
    public View ut(View view) {
        if (i4.k(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View ut2 = ut(viewGroup.getChildAt(i));
                if (ut2 != null) {
                    return ut2;
                }
            }
            return null;
        }
        return null;
    }

    public final void vl() {
        this.f5451co = (int) (this.f5486z6 * (1.0f - this.f5485z));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public boolean xc(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, float f4, float f6) {
        WeakReference<View> weakReference = this.f5476ud;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        if (this.f5449c == 3 && !super.xc(coordinatorLayout, v2, view, f4, f6)) {
            return false;
        }
        return true;
    }

    public final void xg(V v2, zn.y yVar, int i) {
        i4.ap(v2, yVar, null, j5(i));
    }

    public final void y4() {
        V v2;
        WeakReference<V> weakReference = this.f5454ej;
        if (weakReference == null || (v2 = weakReference.get()) == null) {
            return;
        }
        i4.e(v2, 524288);
        i4.e(v2, 262144);
        i4.e(v2, 1048576);
        int i = this.f5460hw;
        if (i != -1) {
            i4.e(v2, i);
        }
        int i5 = 6;
        if (this.f5449c != 6) {
            this.f5460hw = b(v2, R$string.yh, 6);
        }
        if (this.f5461i4 && this.f5449c != 5) {
            xg(v2, zn.y.f9398n, 5);
        }
        int i6 = this.f5449c;
        if (i6 != 3) {
            if (i6 != 4) {
                if (i6 == 6) {
                    xg(v2, zn.y.f9387f3, 4);
                    xg(v2, zn.y.f9391i4, 3);
                    return;
                }
                return;
            }
            if (this.f5468n3) {
                i5 = 3;
            }
            xg(v2, zn.y.f9391i4, i5);
            return;
        }
        if (this.f5468n3) {
            i5 = 4;
        }
        xg(v2, zn.y.f9387f3, i5);
    }

    public void y5(@NonNull a aVar) {
        this.f5447a8.remove(aVar);
    }

    public void yc(boolean z2) {
        this.f5456f3 = z2;
    }

    public void yg(int i) {
        this.y = i;
    }

    public final void yt() {
        int hw2 = hw();
        if (this.f5468n3) {
            this.f5470r = Math.max(this.f5486z6 - hw2, this.f5466mt);
        } else {
            this.f5470r = this.f5486z6 - hw2;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public void z(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, int i, int i5, int i6, int i8, int i10, @NonNull int[] iArr) {
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        /* renamed from: f  reason: collision with root package name */
        public boolean f5488f;

        /* renamed from: fb  reason: collision with root package name */
        public final int f5489fb;

        /* renamed from: s  reason: collision with root package name */
        public int f5490s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f5491t;

        /* renamed from: w  reason: collision with root package name */
        public boolean f5492w;

        /* loaded from: classes.dex */
        public static class y implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: n3 */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            /* renamed from: y */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: zn */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f5489fb = parcel.readInt();
            this.f5490s = parcel.readInt();
            this.f5488f = parcel.readInt() == 1;
            this.f5491t = parcel.readInt() == 1;
            this.f5492w = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5489fb);
            parcel.writeInt(this.f5490s);
            parcel.writeInt(this.f5488f ? 1 : 0);
            parcel.writeInt(this.f5491t ? 1 : 0);
            parcel.writeInt(this.f5492w ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f5489fb = bottomSheetBehavior.f5449c;
            this.f5490s = bottomSheetBehavior.f5477v;
            this.f5488f = bottomSheetBehavior.f5468n3;
            this.f5491t = bottomSheetBehavior.f5461i4;
            this.f5492w = bottomSheetBehavior.f5456f3;
        }
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        this.f5468n3 = true;
        this.f5485z = 0.5f;
        this.f5482x4 = -1.0f;
        this.f5467n = true;
        this.f5449c = 4;
        this.f5447a8 = new ArrayList<>();
        this.f5460hw = -1;
        this.f5463j5 = new gv();
        this.f5472s = context.getResources().getDimensionPixelSize(R$dimen.t6);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f5290ut);
        this.f5450c5 = obtainStyledAttributes.hasValue(R$styleable.f5267rs);
        int i5 = R$styleable.f5200k;
        boolean hasValue = obtainStyledAttributes.hasValue(i5);
        if (hasValue) {
            o(context, attributeSet, hasValue, pv.zn.y(context, obtainStyledAttributes, i5));
        } else {
            qn(context, attributeSet, hasValue);
        }
        j();
        this.f5482x4 = obtainStyledAttributes.getDimension(R$styleable.f5255q9, -1.0f);
        int i6 = R$styleable.f5312xg;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i6);
        if (peekValue != null && (i = peekValue.data) == -1) {
            s8(i);
        } else {
            s8(obtainStyledAttributes.getDimensionPixelSize(i6, -1));
        }
        e(obtainStyledAttributes.getBoolean(R$styleable.f5316y5, false));
        nf(obtainStyledAttributes.getBoolean(R$styleable.f5237o4, false));
        lc(obtainStyledAttributes.getBoolean(R$styleable.f5199jz, true));
        yc(obtainStyledAttributes.getBoolean(R$styleable.f5135ct, false));
        rs(obtainStyledAttributes.getBoolean(R$styleable.f5163f7, true));
        yg(obtainStyledAttributes.getInt(R$styleable.f5145dm, 0));
        ra(obtainStyledAttributes.getFloat(R$styleable.f5282u, 0.5f));
        int i8 = R$styleable.f5157en;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i8);
        if (peekValue2 != null && peekValue2.type == 16) {
            eb(peekValue2.data);
        } else {
            eb(obtainStyledAttributes.getDimensionPixelOffset(i8, 0));
        }
        obtainStyledAttributes.recycle();
        this.f5459gv = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
