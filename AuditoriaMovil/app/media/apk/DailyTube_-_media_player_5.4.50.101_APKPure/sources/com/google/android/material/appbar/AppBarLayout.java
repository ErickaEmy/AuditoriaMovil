package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$integer;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import hw.ej;
import hw.f;
import hw.i4;
import hw.w;
import hx.fb;
import hx.s;
import j5.a;
import j5.zn;
import java.lang.ref.WeakReference;
import java.util.List;
import u4.v;
/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.n3 {

    /* renamed from: ej  reason: collision with root package name */
    public static final int f5330ej = R$style.zx;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<View> f5331c;

    /* renamed from: co  reason: collision with root package name */
    public boolean f5332co;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public Drawable f5333d;
    @Nullable

    /* renamed from: d0  reason: collision with root package name */
    public ValueAnimator f5334d0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5335f;

    /* renamed from: f3  reason: collision with root package name */
    public boolean f5336f3;

    /* renamed from: fb  reason: collision with root package name */
    public int f5337fb;

    /* renamed from: fh  reason: collision with root package name */
    public int[] f5338fh;

    /* renamed from: n  reason: collision with root package name */
    public int f5339n;

    /* renamed from: p  reason: collision with root package name */
    public List<zn> f5340p;

    /* renamed from: r  reason: collision with root package name */
    public boolean f5341r;

    /* renamed from: s  reason: collision with root package name */
    public int f5342s;

    /* renamed from: t  reason: collision with root package name */
    public int f5343t;

    /* renamed from: v  reason: collision with root package name */
    public int f5344v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public ej f5345w;
    public int y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f5346z;

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean e(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, View view2, int i, int i5) {
            return super.d0(coordinatorLayout, appBarLayout, view, view2, i, i5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void eb(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i, int i5, int[] iArr, int i6) {
            super.p(coordinatorLayout, appBarLayout, view, i, i5, iArr, i6);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void lc(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i, int i5, int i6, int i8, int i10, int[] iArr) {
            super.z(coordinatorLayout, appBarLayout, view, i, i5, i6, i8, i10, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void nf(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, Parcelable parcelable) {
            super.f3(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean o4(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i) {
            return super.t(coordinatorLayout, appBarLayout, i);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable ra(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout) {
            return super.n(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean rs(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i, int i5, int i6, int i8) {
            return super.tl(coordinatorLayout, appBarLayout, i, i5, i6, i8);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void s8(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i) {
            super.rz(coordinatorLayout, appBarLayout, view, i);
        }

        @Override // u4.zn
        public /* bridge */ /* synthetic */ int ta() {
            return super.ta();
        }

        @Override // u4.zn
        public /* bridge */ /* synthetic */ boolean z6(int i) {
            return super.z6(i);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public static class ScrollingViewBehavior extends u4.n3 {
        public ScrollingViewBehavior() {
        }

        public static int qn(@NonNull AppBarLayout appBarLayout) {
            CoordinatorLayout.zn a2 = ((CoordinatorLayout.a) appBarLayout.getLayoutParams()).a();
            if (a2 instanceof BaseBehavior) {
                return ((BaseBehavior) a2).k5();
            }
            return 0;
        }

        @Override // u4.n3
        public float a8(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int qn2 = qn(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + qn2 > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (qn2 / i) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // u4.n3
        public int b(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.b(view);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        public void c5(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof AppBarLayout) {
                i4.e(coordinatorLayout, zn.y.f9401p.n3());
                i4.e(coordinatorLayout, zn.y.f9397mt.n3());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        public boolean i4(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z2) {
            AppBarLayout ej2 = ej(coordinatorLayout.mt(view));
            if (ej2 != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f14038gv;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    ej2.wz(false, !z2);
                    return true;
                }
            }
            return false;
        }

        public final void j(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.i9()) {
                    appBarLayout.p(appBarLayout.co(view));
                }
            }
        }

        @Override // u4.n3
        @Nullable
        /* renamed from: j5 */
        public AppBarLayout ej(@NonNull List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        public final void o(@NonNull View view, @NonNull View view2) {
            CoordinatorLayout.zn a2 = ((CoordinatorLayout.a) view2.getLayoutParams()).a();
            if (a2 instanceof BaseBehavior) {
                i4.xg(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) a2).f5347f) + k5()) - ud(view2));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        public boolean s(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            o(view, view2);
            j(view, view2);
            return false;
        }

        @Override // u4.zn, androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        public /* bridge */ /* synthetic */ boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
            return super.t(coordinatorLayout, view, i);
        }

        @Override // u4.n3, androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        public /* bridge */ /* synthetic */ boolean tl(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i, int i5, int i6, int i8) {
            return super.tl(coordinatorLayout, view, i, i5, i6, i8);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        public boolean v(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f5245p0);
            vl(obtainStyledAttributes.getDimensionPixelSize(R$styleable.f5272sc, 0));
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ fb y;

        public n3(fb fbVar) {
            this.y = fbVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            this.y.q9(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public class y implements w {
        public y() {
        }

        @Override // hw.w
        public ej y(View view, ej ejVar) {
            return AppBarLayout.this.t(ejVar);
        }
    }

    /* loaded from: classes.dex */
    public interface zn<T extends AppBarLayout> {
        void y(T t2, int i);
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.r8);
    }

    public boolean a() {
        return this.f5335f;
    }

    public final void c5() {
        this.f5344v = -1;
        this.f5337fb = -1;
        this.f5342s = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof gv;
    }

    public boolean co(@Nullable View view) {
        View n32 = n3(view);
        if (n32 != null) {
            view = n32;
        }
        if (view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (mt()) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.y);
            this.f5333d.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f5333d;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public void f(int i) {
        this.y = i;
        if (!willNotDraw()) {
            i4.lc(this);
        }
        List<zn> list = this.f5340p;
        if (list != null) {
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                zn znVar = this.f5340p.get(i5);
                if (znVar != null) {
                    znVar.y(this, i);
                }
            }
        }
    }

    public final boolean fb() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((gv) getChildAt(i).getLayoutParams()).zn()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.n3
    @NonNull
    public CoordinatorLayout.zn<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    public int getDownNestedPreScrollRange() {
        int i;
        int d2;
        int i5 = this.f5337fb;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            gv gvVar = (gv) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i8 = gvVar.y;
            if ((i8 & 5) == 5) {
                int i10 = ((LinearLayout.LayoutParams) gvVar).topMargin + ((LinearLayout.LayoutParams) gvVar).bottomMargin;
                if ((i8 & 8) != 0) {
                    d2 = i4.d(childAt);
                } else if ((i8 & 2) != 0) {
                    d2 = measuredHeight - i4.d(childAt);
                } else {
                    i = i10 + measuredHeight;
                    if (childCount == 0 && i4.fh(childAt)) {
                        i = Math.min(i, measuredHeight - getTopInset());
                    }
                    i6 += i;
                }
                i = i10 + d2;
                if (childCount == 0) {
                    i = Math.min(i, measuredHeight - getTopInset());
                }
                i6 += i;
            } else if (i6 > 0) {
                break;
            }
        }
        int max = Math.max(0, i6);
        this.f5337fb = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i = this.f5342s;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            gv gvVar = (gv) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) gvVar).topMargin + ((LinearLayout.LayoutParams) gvVar).bottomMargin;
            int i8 = gvVar.y;
            if ((i8 & 1) == 0) {
                break;
            }
            i6 += measuredHeight;
            if ((i8 & 2) != 0) {
                i6 -= i4.d(childAt);
                break;
            }
            i5++;
        }
        int max = Math.max(0, i6);
        this.f5342s = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f5339n;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int d2 = i4.d(this);
        if (d2 == 0) {
            int childCount = getChildCount();
            if (childCount >= 1) {
                d2 = i4.d(getChildAt(childCount - 1));
            } else {
                d2 = 0;
            }
            if (d2 == 0) {
                return getHeight() / 3;
            }
        }
        return (d2 * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f5343t;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.f5333d;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        ej ejVar = this.f5345w;
        if (ejVar != null) {
            return ejVar.tl();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.f5344v;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            gv gvVar = (gv) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i8 = gvVar.y;
            if ((i8 & 1) == 0) {
                break;
            }
            i6 += measuredHeight + ((LinearLayout.LayoutParams) gvVar).topMargin + ((LinearLayout.LayoutParams) gvVar).bottomMargin;
            if (i5 == 0 && i4.fh(childAt)) {
                i6 -= getTopInset();
            }
            if ((i8 & 2) != 0) {
                i6 -= i4.d(childAt);
                break;
            }
            i5++;
        }
        int max = Math.max(0, i6);
        this.f5344v = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: gv */
    public gv generateLayoutParams(AttributeSet attributeSet) {
        return new gv(getContext(), attributeSet);
    }

    public boolean i9() {
        return this.f5336f3;
    }

    public final boolean mt() {
        if (this.f5333d != null && getTopInset() > 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public final View n3(@Nullable View view) {
        int i;
        View view2;
        if (this.f5331c == null && (i = this.f5339n) != -1) {
            if (view != null) {
                view2 = view.findViewById(i);
            } else {
                view2 = null;
            }
            if (view2 == null && (getParent() instanceof ViewGroup)) {
                view2 = ((ViewGroup) getParent()).findViewById(this.f5339n);
            }
            if (view2 != null) {
                this.f5331c = new WeakReference<>(view2);
            }
        }
        WeakReference<View> weakReference = this.f5331c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        s.v(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int i5;
        int i6;
        if (this.f5338fh == null) {
            this.f5338fh = new int[4];
        }
        int[] iArr = this.f5338fh;
        int[] onCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        boolean z2 = this.f5346z;
        int i8 = R$attr.fhk;
        if (!z2) {
            i8 = -i8;
        }
        iArr[0] = i8;
        if (z2 && this.f5341r) {
            i5 = R$attr.fhj;
        } else {
            i5 = -R$attr.fhj;
        }
        iArr[1] = i5;
        int i10 = R$attr.fha;
        if (!z2) {
            i10 = -i10;
        }
        iArr[2] = i10;
        if (z2 && this.f5341r) {
            i6 = R$attr.fhs;
        } else {
            i6 = -R$attr.fhs;
        }
        iArr[3] = i6;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        y();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        super.onLayout(z2, i, i5, i6, i8);
        boolean z3 = true;
        if (i4.fh(this) && z()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                i4.xg(getChildAt(childCount), topInset);
            }
        }
        c5();
        this.f5335f = false;
        int childCount2 = getChildCount();
        int i10 = 0;
        while (true) {
            if (i10 >= childCount2) {
                break;
            } else if (((gv) getChildAt(i10).getLayoutParams()).n3() != null) {
                this.f5335f = true;
                break;
            } else {
                i10++;
            }
        }
        Drawable drawable = this.f5333d;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.f5332co) {
            if (!this.f5336f3 && !fb()) {
                z3 = false;
            }
            w(z3);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i5) {
        super.onMeasure(i, i5);
        int mode = View.MeasureSpec.getMode(i5);
        if (mode != 1073741824 && i4.fh(this) && z()) {
            int measuredHeight = getMeasuredHeight();
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    measuredHeight += getTopInset();
                }
            } else {
                measuredHeight = a8.y.n3(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i5));
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        c5();
    }

    public boolean p(boolean z2) {
        if (this.f5341r != z2) {
            this.f5341r = z2;
            refreshDrawableState();
            if (this.f5336f3 && (getBackground() instanceof fb)) {
                r((fb) getBackground(), z2);
                return true;
            }
            return true;
        }
        return false;
    }

    public final void r(@NonNull fb fbVar, boolean z2) {
        float f4;
        float dimension = getResources().getDimension(R$dimen.ks);
        if (z2) {
            f4 = 0.0f;
        } else {
            f4 = dimension;
        }
        if (!z2) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.f5334d0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f4, dimension);
        this.f5334d0 = ofFloat;
        ofFloat.setDuration(getResources().getInteger(R$integer.b));
        this.f5334d0.setInterpolator(y6.y.y);
        this.f5334d0.addUpdateListener(new n3(fbVar));
        this.f5334d0.start();
    }

    public boolean s() {
        if (getTotalScrollRange() != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        s.gv(this, f4);
    }

    public void setExpanded(boolean z2) {
        wz(z2, i4.q9(this));
    }

    public void setLiftOnScroll(boolean z2) {
        this.f5336f3 = z2;
    }

    public void setLiftOnScrollTargetViewId(int i) {
        this.f5339n = i;
        y();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i == 1) {
            super.setOrientation(i);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        boolean z2;
        Drawable drawable2 = this.f5333d;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f5333d = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f5333d.setState(getDrawableState());
                }
                ej.y.tl(this.f5333d, i4.ta(this));
                Drawable drawable4 = this.f5333d;
                if (getVisibility() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                drawable4.setVisible(z2, false);
                this.f5333d.setCallback(this);
            }
            x4();
            i4.lc(this);
        }
    }

    public void setStatusBarForegroundColor(int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(int i) {
        setStatusBarForeground(c5.y.gv(getContext(), i));
    }

    @Deprecated
    public void setTargetElevation(float f4) {
        v.n3(this, f4);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        boolean z2;
        super.setVisibility(i);
        if (i == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Drawable drawable = this.f5333d;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
    }

    public ej t(ej ejVar) {
        ej ejVar2;
        if (i4.fh(this)) {
            ejVar2 = ejVar;
        } else {
            ejVar2 = null;
        }
        if (!vl.zn.y(this.f5345w, ejVar2)) {
            this.f5345w = ejVar2;
            x4();
            requestLayout();
        }
        return ejVar;
    }

    public void tl() {
        this.f5343t = 0;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: v */
    public gv generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new gv((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new gv((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new gv(layoutParams);
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f5333d) {
            return false;
        }
        return true;
    }

    public final boolean w(boolean z2) {
        if (this.f5346z != z2) {
            this.f5346z = z2;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    public void wz(boolean z2, boolean z3) {
        xc(z2, z3, true);
    }

    public final void x4() {
        setWillNotDraw(!mt());
    }

    public final void xc(boolean z2, boolean z3, boolean z4) {
        int i;
        int i5;
        if (z2) {
            i = 1;
        } else {
            i = 2;
        }
        int i6 = 0;
        if (z3) {
            i5 = 4;
        } else {
            i5 = 0;
        }
        int i8 = i | i5;
        if (z4) {
            i6 = 8;
        }
        this.f5343t = i8 | i6;
        requestLayout();
    }

    public final void y() {
        WeakReference<View> weakReference = this.f5331c;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f5331c = null;
    }

    public final boolean z() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt.getVisibility() == 8 || i4.fh(childAt)) {
            return false;
        }
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: zn */
    public gv generateDefaultLayoutParams() {
        return new gv(-1, -2);
    }

    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends u4.y<T> {

        /* renamed from: f  reason: collision with root package name */
        public int f5347f;
        @Nullable

        /* renamed from: p  reason: collision with root package name */
        public WeakReference<View> f5348p;

        /* renamed from: t  reason: collision with root package name */
        public int f5349t;

        /* renamed from: tl  reason: collision with root package name */
        public ValueAnimator f5350tl;

        /* renamed from: w  reason: collision with root package name */
        public float f5351w;

        /* renamed from: wz  reason: collision with root package name */
        public int f5352wz;

        /* renamed from: xc  reason: collision with root package name */
        public boolean f5353xc;

        /* loaded from: classes.dex */
        public class n3 implements a {

            /* renamed from: gv  reason: collision with root package name */
            public final /* synthetic */ int f5357gv;

            /* renamed from: n3  reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f5358n3;
            public final /* synthetic */ CoordinatorLayout y;

            /* renamed from: zn  reason: collision with root package name */
            public final /* synthetic */ View f5360zn;

            public n3(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
                this.y = coordinatorLayout;
                this.f5358n3 = appBarLayout;
                this.f5360zn = view;
                this.f5357gv = i;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // j5.a
            public boolean y(@NonNull View view, @Nullable a.y yVar) {
                BaseBehavior.this.p(this.y, this.f5358n3, this.f5360zn, 0, this.f5357gv, new int[]{0, 0}, 1);
                return true;
            }
        }

        /* loaded from: classes.dex */
        public class y implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: n3  reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f5361n3;
            public final /* synthetic */ CoordinatorLayout y;

            public y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.y = coordinatorLayout;
                this.f5361n3 = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                BaseBehavior.this.hw(this.y, this.f5361n3, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* loaded from: classes.dex */
        public class zn implements a {

            /* renamed from: n3  reason: collision with root package name */
            public final /* synthetic */ boolean f5363n3;
            public final /* synthetic */ AppBarLayout y;

            public zn(AppBarLayout appBarLayout, boolean z2) {
                this.y = appBarLayout;
                this.f5363n3 = z2;
            }

            @Override // j5.a
            public boolean y(@NonNull View view, @Nullable a.y yVar) {
                this.y.setExpanded(this.f5363n3);
                return true;
            }
        }

        public BaseBehavior() {
            this.f5352wz = -1;
        }

        public static boolean f7(int i, int i5) {
            return (i & i5) == i5;
        }

        @Nullable
        public static View jz(@NonNull AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = appBarLayout.getChildAt(i5);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // u4.y
        /* renamed from: ap */
        public int j5(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, int i, int i5, int i6) {
            int i8;
            int i10;
            int k52 = k5();
            int i11 = 0;
            if (i5 != 0 && k52 >= i5 && k52 <= i6) {
                int n32 = a8.y.n3(i, i5, i6);
                if (k52 != n32) {
                    if (t2.a()) {
                        i8 = dm(t2, n32);
                    } else {
                        i8 = n32;
                    }
                    boolean z62 = z6(i8);
                    i11 = k52 - n32;
                    this.f5347f = n32 - i8;
                    if (!z62 && t2.a()) {
                        coordinatorLayout.a(t2);
                    }
                    t2.f(ta());
                    if (n32 < k52) {
                        i10 = -1;
                    } else {
                        i10 = 1;
                    }
                    rb(coordinatorLayout, t2, n32, i10, false);
                }
            } else {
                this.f5347f = 0;
            }
            kp(coordinatorLayout, t2);
            return i11;
        }

        @Override // u4.y
        /* renamed from: ct */
        public void yt(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2) {
            yc(coordinatorLayout, t2);
            if (t2.i9()) {
                t2.p(t2.co(en(coordinatorLayout)));
            }
        }

        public final int dm(@NonNull T t2, int i) {
            int abs = Math.abs(i);
            int childCount = t2.getChildCount();
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (i6 >= childCount) {
                    break;
                }
                View childAt = t2.getChildAt(i6);
                gv gvVar = (gv) childAt.getLayoutParams();
                Interpolator n32 = gvVar.n3();
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    if (n32 != null) {
                        int y2 = gvVar.y();
                        if ((y2 & 1) != 0) {
                            i5 = childAt.getHeight() + ((LinearLayout.LayoutParams) gvVar).topMargin + ((LinearLayout.LayoutParams) gvVar).bottomMargin;
                            if ((y2 & 2) != 0) {
                                i5 -= i4.d(childAt);
                            }
                        }
                        if (i4.fh(childAt)) {
                            i5 -= t2.getTopInset();
                        }
                        if (i5 > 0) {
                            float f4 = i5;
                            return Integer.signum(i) * (childAt.getTop() + Math.round(f4 * n32.getInterpolation((abs - childAt.getTop()) / f4)));
                        }
                    }
                } else {
                    i6++;
                }
            }
            return i;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        /* renamed from: e */
        public boolean d0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, @NonNull View view, View view2, int i, int i5) {
            boolean z2;
            ValueAnimator valueAnimator;
            if ((i & 2) != 0 && (t2.i9() || k(coordinatorLayout, t2, view))) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 && (valueAnimator = this.f5350tl) != null) {
                valueAnimator.cancel();
            }
            this.f5348p = null;
            this.f5349t = i5;
            return z2;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        /* renamed from: eb */
        public void p(CoordinatorLayout coordinatorLayout, @NonNull T t2, View view, int i, int i5, int[] iArr, int i6) {
            int i8;
            int i10;
            if (i5 != 0) {
                if (i5 < 0) {
                    int i11 = -t2.getTotalScrollRange();
                    i8 = i11;
                    i10 = t2.getDownNestedPreScrollRange() + i11;
                } else {
                    i8 = -t2.getUpNestedPreScrollRange();
                    i10 = 0;
                }
                if (i8 != i10) {
                    iArr[1] = vl(coordinatorLayout, t2, i5, i8, i10);
                }
            }
            if (t2.i9()) {
                t2.p(t2.co(view));
            }
        }

        @Nullable
        public final View en(@NonNull CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof f) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        public final void j(CoordinatorLayout coordinatorLayout, @NonNull T t2, @NonNull zn.y yVar, boolean z2) {
            i4.ap(coordinatorLayout, yVar, null, new zn(t2, z2));
        }

        public final boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, @NonNull View view) {
            if (t2.s() && coordinatorLayout.getHeight() - view.getHeight() <= t2.getHeight()) {
                return true;
            }
            return false;
        }

        @Override // u4.y
        public int k5() {
            return ta() + this.f5347f;
        }

        public final void kp(CoordinatorLayout coordinatorLayout, @NonNull T t2) {
            i4.e(coordinatorLayout, zn.y.f9401p.n3());
            i4.e(coordinatorLayout, zn.y.f9397mt.n3());
            View en2 = en(coordinatorLayout);
            if (en2 == null || t2.getTotalScrollRange() == 0 || !(((CoordinatorLayout.a) en2.getLayoutParams()).a() instanceof ScrollingViewBehavior)) {
                return;
            }
            o(coordinatorLayout, t2, en2);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        /* renamed from: lc */
        public void z(CoordinatorLayout coordinatorLayout, @NonNull T t2, View view, int i, int i5, int i6, int i8, int i10, int[] iArr) {
            if (i8 < 0) {
                iArr[1] = vl(coordinatorLayout, t2, i8, -t2.getDownNestedScrollRange(), 0);
            }
            if (i8 == 0) {
                kp(coordinatorLayout, t2);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        /* renamed from: nf */
        public void f3(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.f3(coordinatorLayout, t2, savedState.y());
                this.f5352wz = savedState.f5355fb;
                this.f5351w = savedState.f5356s;
                this.f5353xc = savedState.f5354f;
                return;
            }
            super.f3(coordinatorLayout, t2, parcelable);
            this.f5352wz = -1;
        }

        public final void o(CoordinatorLayout coordinatorLayout, @NonNull T t2, @NonNull View view) {
            if (k5() != (-t2.getTotalScrollRange()) && view.canScrollVertically(1)) {
                j(coordinatorLayout, t2, zn.y.f9401p, false);
            }
            if (k5() != 0) {
                if (view.canScrollVertically(-1)) {
                    int i = -t2.getDownNestedPreScrollRange();
                    if (i != 0) {
                        i4.ap(coordinatorLayout, zn.y.f9397mt, null, new n3(coordinatorLayout, t2, view, i));
                        return;
                    }
                    return;
                }
                j(coordinatorLayout, t2, zn.y.f9397mt, true);
            }
        }

        @Override // u4.zn, androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        /* renamed from: o4 */
        public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, int i) {
            boolean z2;
            int round;
            boolean t3 = super.t(coordinatorLayout, t2, i);
            int pendingAction = t2.getPendingAction();
            int i5 = this.f5352wz;
            if (i5 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t2.getChildAt(i5);
                int i6 = -childAt.getBottom();
                if (this.f5353xc) {
                    round = i4.d(childAt) + t2.getTopInset();
                } else {
                    round = Math.round(childAt.getHeight() * this.f5351w);
                }
                hw(coordinatorLayout, t2, i6 + round);
            } else if (pendingAction != 0) {
                if ((pendingAction & 4) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if ((pendingAction & 2) != 0) {
                    int i8 = -t2.getUpNestedPreScrollRange();
                    if (z2) {
                        oz(coordinatorLayout, t2, i8, 0.0f);
                    } else {
                        hw(coordinatorLayout, t2, i8);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z2) {
                        oz(coordinatorLayout, t2, 0, 0.0f);
                    } else {
                        hw(coordinatorLayout, t2, 0);
                    }
                }
            }
            t2.tl();
            this.f5352wz = -1;
            z6(a8.y.n3(ta(), -t2.getTotalScrollRange(), 0));
            rb(coordinatorLayout, t2, ta(), 0, true);
            t2.f(ta());
            kp(coordinatorLayout, t2);
            return t3;
        }

        public final void oz(CoordinatorLayout coordinatorLayout, @NonNull T t2, int i, float f4) {
            int height;
            int abs = Math.abs(k5() - i);
            float abs2 = Math.abs(f4);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / t2.getHeight()) + 1.0f) * 150.0f);
            }
            ut(coordinatorLayout, t2, i, height);
        }

        @Override // u4.y
        /* renamed from: q9 */
        public boolean ej(T t2) {
            WeakReference<View> weakReference = this.f5348p;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            if (view != null && view.isShown() && !view.canScrollVertically(-1)) {
                return true;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        /* renamed from: ra */
        public Parcelable n(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2) {
            Parcelable n2 = super.n(coordinatorLayout, t2);
            int ta2 = ta();
            int childCount = t2.getChildCount();
            boolean z2 = false;
            for (int i = 0; i < childCount; i++) {
                View childAt = t2.getChildAt(i);
                int bottom = childAt.getBottom() + ta2;
                if (childAt.getTop() + ta2 <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(n2);
                    savedState.f5355fb = i;
                    if (bottom == i4.d(childAt) + t2.getTopInset()) {
                        z2 = true;
                    }
                    savedState.f5354f = z2;
                    savedState.f5356s = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return n2;
        }

        public final void rb(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, int i, int i5, boolean z2) {
            View jz2 = jz(t2, i);
            if (jz2 != null) {
                int y2 = ((gv) jz2.getLayoutParams()).y();
                boolean z3 = false;
                if ((y2 & 1) != 0) {
                    int d2 = i4.d(jz2);
                    if (i5 <= 0 || (y2 & 12) == 0 ? !((y2 & 2) == 0 || (-i) < (jz2.getBottom() - d2) - t2.getTopInset()) : (-i) >= (jz2.getBottom() - d2) - t2.getTopInset()) {
                        z3 = true;
                    }
                }
                if (t2.i9()) {
                    z3 = t2.co(en(coordinatorLayout));
                }
                boolean p2 = t2.p(z3);
                if (z2 || (p2 && yg(coordinatorLayout, t2))) {
                    t2.jumpDrawablesToCurrentState();
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        /* renamed from: rs */
        public boolean tl(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, int i, int i5, int i6, int i8) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.a) t2.getLayoutParams())).height == -2) {
                coordinatorLayout.a8(t2, i, i5, View.MeasureSpec.makeMeasureSpec(0, 0), i8);
                return true;
            }
            return super.tl(coordinatorLayout, t2, i, i5, i6, i8);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        /* renamed from: s8 */
        public void rz(CoordinatorLayout coordinatorLayout, @NonNull T t2, View view, int i) {
            if (this.f5349t == 0 || i == 1) {
                yc(coordinatorLayout, t2);
                if (t2.i9()) {
                    t2.p(t2.co(view));
                }
            }
            this.f5348p = new WeakReference<>(view);
        }

        public final int u(@NonNull T t2, int i) {
            int childCount = t2.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = t2.getChildAt(i5);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                gv gvVar = (gv) childAt.getLayoutParams();
                if (f7(gvVar.y(), 32)) {
                    top -= ((LinearLayout.LayoutParams) gvVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) gvVar).bottomMargin;
                }
                int i6 = -i;
                if (top <= i6 && bottom >= i6) {
                    return i5;
                }
            }
            return -1;
        }

        public final void ut(CoordinatorLayout coordinatorLayout, T t2, int i, int i5) {
            int k52 = k5();
            if (k52 == i) {
                ValueAnimator valueAnimator = this.f5350tl;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f5350tl.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.f5350tl;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f5350tl = valueAnimator3;
                valueAnimator3.setInterpolator(y6.y.f15326v);
                this.f5350tl.addUpdateListener(new y(coordinatorLayout, t2));
            } else {
                valueAnimator2.cancel();
            }
            this.f5350tl.setDuration(Math.min(i5, 600));
            this.f5350tl.setIntValues(k52, i);
            this.f5350tl.start();
        }

        @Override // u4.y
        /* renamed from: xg */
        public int b(@NonNull T t2) {
            return t2.getTotalScrollRange();
        }

        @Override // u4.y
        /* renamed from: y5 */
        public int x(@NonNull T t2) {
            return -t2.getDownNestedScrollRange();
        }

        public final void yc(CoordinatorLayout coordinatorLayout, @NonNull T t2) {
            int k52 = k5();
            int u2 = u(t2, k52);
            if (u2 >= 0) {
                View childAt = t2.getChildAt(u2);
                gv gvVar = (gv) childAt.getLayoutParams();
                int y2 = gvVar.y();
                if ((y2 & 17) == 17) {
                    int i = -childAt.getTop();
                    int i5 = -childAt.getBottom();
                    if (u2 == t2.getChildCount() - 1) {
                        i5 += t2.getTopInset();
                    }
                    if (f7(y2, 2)) {
                        i5 += i4.d(childAt);
                    } else if (f7(y2, 5)) {
                        int d2 = i4.d(childAt) + i5;
                        if (k52 < d2) {
                            i = d2;
                        } else {
                            i5 = d2;
                        }
                    }
                    if (f7(y2, 32)) {
                        i += ((LinearLayout.LayoutParams) gvVar).topMargin;
                        i5 -= ((LinearLayout.LayoutParams) gvVar).bottomMargin;
                    }
                    if (k52 < (i5 + i) / 2) {
                        i = i5;
                    }
                    oz(coordinatorLayout, t2, a8.y.n3(i, -t2.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        public final boolean yg(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2) {
            List<View> co2 = coordinatorLayout.co(t2);
            int size = co2.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.zn a2 = ((CoordinatorLayout.a) co2.get(i).getLayoutParams()).a();
                if (a2 instanceof ScrollingViewBehavior) {
                    if (((ScrollingViewBehavior) a2).x() == 0) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5352wz = -1;
        }

        /* loaded from: classes.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new y();

            /* renamed from: f  reason: collision with root package name */
            public boolean f5354f;

            /* renamed from: fb  reason: collision with root package name */
            public int f5355fb;

            /* renamed from: s  reason: collision with root package name */
            public float f5356s;

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
                    return new SavedState(parcel, null);
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
                this.f5355fb = parcel.readInt();
                this.f5356s = parcel.readFloat();
                this.f5354f = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f5355fb);
                parcel.writeFloat(this.f5356s);
                parcel.writeByte(this.f5354f ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppBarLayout(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.Nullable android.util.AttributeSet r11, int r12) {
        /*
            r9 = this;
            int r4 = com.google.android.material.appbar.AppBarLayout.f5330ej
            android.content.Context r10 = c0.y.zn(r10, r11, r12, r4)
            r9.<init>(r10, r11, r12)
            r10 = -1
            r9.f5344v = r10
            r9.f5337fb = r10
            r9.f5342s = r10
            r6 = 0
            r9.f5343t = r6
            android.content.Context r7 = r9.getContext()
            r0 = 1
            r9.setOrientation(r0)
            int r8 = android.os.Build.VERSION.SDK_INT
            u4.v.y(r9)
            u4.v.zn(r9, r11, r12, r4)
            int[] r2 = com.google.android.material.R$styleable.f5158f
            int[] r5 = new int[r6]
            r0 = r7
            r1 = r11
            r3 = r12
            android.content.res.TypedArray r11 = ur.i9.s(r0, r1, r2, r3, r4, r5)
            int r12 = com.google.android.material.R$styleable.f5274t
            android.graphics.drawable.Drawable r12 = r11.getDrawable(r12)
            hw.i4.u0(r9, r12)
            android.graphics.drawable.Drawable r12 = r9.getBackground()
            boolean r12 = r12 instanceof android.graphics.drawable.ColorDrawable
            if (r12 == 0) goto L5b
            android.graphics.drawable.Drawable r12 = r9.getBackground()
            android.graphics.drawable.ColorDrawable r12 = (android.graphics.drawable.ColorDrawable) r12
            hx.fb r0 = new hx.fb
            r0.<init>()
            int r12 = r12.getColor()
            android.content.res.ColorStateList r12 = android.content.res.ColorStateList.valueOf(r12)
            r0.k(r12)
            r0.k5(r7)
            hw.i4.u0(r9, r0)
        L5b:
            int r12 = com.google.android.material.R$styleable.f5296w
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto L6a
            boolean r12 = r11.getBoolean(r12, r6)
            r9.xc(r12, r6, r6)
        L6a:
            int r12 = com.google.android.material.R$styleable.f5311xc
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto L7a
            int r12 = r11.getDimensionPixelSize(r12, r6)
            float r12 = (float) r12
            u4.v.n3(r9, r12)
        L7a:
            r12 = 26
            if (r8 < r12) goto L9c
            int r12 = com.google.android.material.R$styleable.f5304wz
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto L8d
            boolean r12 = r11.getBoolean(r12, r6)
            r9.setKeyboardNavigationCluster(r12)
        L8d:
            int r12 = com.google.android.material.R$styleable.f5278tl
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto L9c
            boolean r12 = r11.getBoolean(r12, r6)
            r9.setTouchscreenBlocksFocus(r12)
        L9c:
            int r12 = com.google.android.material.R$styleable.f5244p
            boolean r12 = r11.getBoolean(r12, r6)
            r9.f5336f3 = r12
            int r12 = com.google.android.material.R$styleable.f5222mt
            int r10 = r11.getResourceId(r12, r10)
            r9.f5339n = r10
            int r10 = com.google.android.material.R$styleable.f5132co
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r10)
            r9.setStatusBarForeground(r10)
            r11.recycle()
            com.google.android.material.appbar.AppBarLayout$y r10 = new com.google.android.material.appbar.AppBarLayout$y
            r10.<init>()
            hw.i4.ad(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* loaded from: classes.dex */
    public static class gv extends LinearLayout.LayoutParams {

        /* renamed from: n3  reason: collision with root package name */
        public Interpolator f5365n3;
        public int y;

        public gv(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.y = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f5262r);
            this.y = obtainStyledAttributes.getInt(R$styleable.f5307x4, 0);
            int i = R$styleable.f5186i4;
            if (obtainStyledAttributes.hasValue(i)) {
                this.f5365n3 = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public Interpolator n3() {
            return this.f5365n3;
        }

        public int y() {
            return this.y;
        }

        public boolean zn() {
            int i = this.y;
            if ((i & 1) == 1 && (i & 10) != 0) {
                return true;
            }
            return false;
        }

        public gv(int i, int i5) {
            super(i, i5);
            this.y = 1;
        }

        public gv(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.y = 1;
        }

        public gv(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.y = 1;
        }

        public gv(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.y = 1;
        }
    }
}
