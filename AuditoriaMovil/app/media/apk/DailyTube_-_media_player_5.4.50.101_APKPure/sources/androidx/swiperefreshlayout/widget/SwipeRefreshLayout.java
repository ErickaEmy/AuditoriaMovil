package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import hw.f;
import hw.i4;
import hw.t;
import hw.tl;
import hw.wz;
import hw.xc;
/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements wz, tl, f {

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f3391e = {16842766};

    /* renamed from: ra  reason: collision with root package name */
    public static final String f3392ra = "SwipeRefreshLayout";

    /* renamed from: b  reason: collision with root package name */
    public boolean f3393b;

    /* renamed from: c  reason: collision with root package name */
    public int f3394c;

    /* renamed from: co  reason: collision with root package name */
    public final int[] f3395co;

    /* renamed from: ct  reason: collision with root package name */
    public int f3396ct;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3397d;

    /* renamed from: d0  reason: collision with root package name */
    public float f3398d0;

    /* renamed from: dm  reason: collision with root package name */
    public boolean f3399dm;

    /* renamed from: eb  reason: collision with root package name */
    public Animation.AnimationListener f3400eb;

    /* renamed from: ej  reason: collision with root package name */
    public int f3401ej;

    /* renamed from: en  reason: collision with root package name */
    public Animation f3402en;

    /* renamed from: f  reason: collision with root package name */
    public float f3403f;

    /* renamed from: f3  reason: collision with root package name */
    public boolean f3404f3;

    /* renamed from: f7  reason: collision with root package name */
    public pz.n3 f3405f7;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f3406fb;

    /* renamed from: fh  reason: collision with root package name */
    public float f3407fh;

    /* renamed from: j  reason: collision with root package name */
    public int f3408j;

    /* renamed from: j5  reason: collision with root package name */
    public final DecelerateInterpolator f3409j5;

    /* renamed from: jz  reason: collision with root package name */
    public Animation f3410jz;

    /* renamed from: k  reason: collision with root package name */
    public int f3411k;

    /* renamed from: lc  reason: collision with root package name */
    public final Animation f3412lc;

    /* renamed from: n  reason: collision with root package name */
    public int f3413n;

    /* renamed from: nf  reason: collision with root package name */
    public final Animation f3414nf;

    /* renamed from: o  reason: collision with root package name */
    public int f3415o;

    /* renamed from: o4  reason: collision with root package name */
    public boolean f3416o4;

    /* renamed from: oz  reason: collision with root package name */
    public float f3417oz;

    /* renamed from: p  reason: collision with root package name */
    public final t f3418p;

    /* renamed from: q9  reason: collision with root package name */
    public int f3419q9;

    /* renamed from: qn  reason: collision with root package name */
    public pz.y f3420qn;

    /* renamed from: r  reason: collision with root package name */
    public final int[] f3421r;

    /* renamed from: rs  reason: collision with root package name */
    public boolean f3422rs;

    /* renamed from: s  reason: collision with root package name */
    public int f3423s;

    /* renamed from: t  reason: collision with root package name */
    public float f3424t;

    /* renamed from: u  reason: collision with root package name */
    public Animation f3425u;

    /* renamed from: ut  reason: collision with root package name */
    public int f3426ut;

    /* renamed from: v  reason: collision with root package name */
    public i9 f3427v;

    /* renamed from: w  reason: collision with root package name */
    public final xc f3428w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f3429x;

    /* renamed from: xg  reason: collision with root package name */
    public Animation f3430xg;
    public View y;

    /* renamed from: y5  reason: collision with root package name */
    public Animation f3431y5;

    /* renamed from: z  reason: collision with root package name */
    public final int[] f3432z;

    /* loaded from: classes.dex */
    public class a extends Animation {
        public a() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f4, Transformation transformation) {
            int i;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f3416o4) {
                i = swipeRefreshLayout.f3419q9 - Math.abs(swipeRefreshLayout.f3426ut);
            } else {
                i = swipeRefreshLayout.f3419q9;
            }
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            int i5 = swipeRefreshLayout2.f3408j;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i5 + ((int) ((i - i5) * f4))) - swipeRefreshLayout2.f3420qn.getTop());
            SwipeRefreshLayout.this.f3405f7.v(1.0f - f4);
        }
    }

    /* loaded from: classes.dex */
    public interface c5 {
    }

    /* loaded from: classes.dex */
    public class fb extends Animation {
        public fb() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f4, Transformation transformation) {
            SwipeRefreshLayout.this.p(f4);
        }
    }

    /* loaded from: classes.dex */
    public class gv extends Animation {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ int f3434v;
        public final /* synthetic */ int y;

        public gv(int i, int i5) {
            this.y = i;
            this.f3434v = i5;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f4, Transformation transformation) {
            pz.n3 n3Var = SwipeRefreshLayout.this.f3405f7;
            int i = this.y;
            n3Var.setAlpha((int) (i + ((this.f3434v - i) * f4)));
        }
    }

    /* loaded from: classes.dex */
    public interface i9 {
        void onRefresh();
    }

    /* loaded from: classes.dex */
    public class n3 extends Animation {
        public n3() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f4, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f4);
        }
    }

    /* loaded from: classes.dex */
    public class s extends Animation {
        public s() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f4, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f6 = swipeRefreshLayout.f3417oz;
            swipeRefreshLayout.setAnimationProgress(f6 + ((-f6) * f4));
            SwipeRefreshLayout.this.p(f4);
        }
    }

    /* loaded from: classes.dex */
    public class v implements Animation.AnimationListener {
        public v() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f3429x) {
                swipeRefreshLayout.n(null);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes.dex */
    public class y implements Animation.AnimationListener {
        public y() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i9 i9Var;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f3406fb) {
                swipeRefreshLayout.f3405f7.setAlpha(255);
                SwipeRefreshLayout.this.f3405f7.start();
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                if (swipeRefreshLayout2.f3399dm && (i9Var = swipeRefreshLayout2.f3427v) != null) {
                    i9Var.onRefresh();
                }
                SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
                swipeRefreshLayout3.f3394c = swipeRefreshLayout3.f3420qn.getTop();
                return;
            }
            swipeRefreshLayout.co();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes.dex */
    public class zn extends Animation {
        public zn() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f4, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f4);
        }
    }

    public SwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3403f = -1.0f;
        this.f3395co = new int[2];
        this.f3432z = new int[2];
        this.f3421r = new int[2];
        this.f3401ej = -1;
        this.f3415o = -1;
        this.f3400eb = new y();
        this.f3412lc = new a();
        this.f3414nf = new fb();
        this.f3423s = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f3413n = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f3409j5 = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f3396ct = (int) (displayMetrics.density * 40.0f);
        gv();
        setChildrenDrawingOrderEnabled(true);
        int i = (int) (displayMetrics.density * 64.0f);
        this.f3419q9 = i;
        this.f3403f = i;
        this.f3428w = new xc(this);
        this.f3418p = new t(this);
        setNestedScrollingEnabled(true);
        int i5 = -this.f3396ct;
        this.f3394c = i5;
        this.f3426ut = i5;
        p(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3391e);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    private void mt(MotionEvent motionEvent) {
        int i;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3401ej) {
            if (actionIndex == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.f3401ej = motionEvent.getPointerId(i);
        }
    }

    private void setColorViewAlpha(int i) {
        this.f3420qn.getBackground().setAlpha(i);
        this.f3405f7.setAlpha(i);
    }

    public final void a() {
        if (this.y == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.f3420qn)) {
                    this.y = childAt;
                    return;
                }
            }
        }
    }

    public final void c(int i, Animation.AnimationListener animationListener) {
        this.f3408j = i;
        this.f3417oz = this.f3420qn.getScaleX();
        s sVar = new s();
        this.f3430xg = sVar;
        sVar.setDuration(150L);
        if (animationListener != null) {
            this.f3420qn.n3(animationListener);
        }
        this.f3420qn.clearAnimation();
        this.f3420qn.startAnimation(this.f3430xg);
    }

    @Override // hw.tl
    public void c5(View view, View view2, int i, int i5) {
        if (i5 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    public void co() {
        this.f3420qn.clearAnimation();
        this.f3405f7.stop();
        this.f3420qn.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f3429x) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.f3426ut - this.f3394c);
        }
        this.f3394c = this.f3420qn.getTop();
    }

    public final void d0(Animation.AnimationListener animationListener) {
        this.f3420qn.setVisibility(0);
        this.f3405f7.setAlpha(255);
        n3 n3Var = new n3();
        this.f3402en = n3Var;
        n3Var.setDuration(this.f3413n);
        if (animationListener != null) {
            this.f3420qn.n3(animationListener);
        }
        this.f3420qn.clearAnimation();
        this.f3420qn.startAnimation(this.f3402en);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f4, float f6, boolean z2) {
        return this.f3418p.y(f4, f6, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f4, float f6) {
        return this.f3418p.n3(f4, f6);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i5, int[] iArr, int[] iArr2) {
        return this.f3418p.zn(i, i5, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i5, int i6, int i8, int[] iArr) {
        return this.f3418p.a(i, i5, i6, i8, iArr);
    }

    @Override // hw.tl
    public void f(View view, int i, int i5, int[] iArr, int i6) {
        if (i6 == 0) {
            onNestedPreScroll(view, i, i5, iArr);
        }
    }

    public final void f3() {
        this.f3425u = r(this.f3405f7.getAlpha(), 76);
    }

    public final void fb(float f4) {
        v vVar;
        if (f4 > this.f3403f) {
            z(true, true);
            return;
        }
        this.f3406fb = false;
        this.f3405f7.i9(0.0f, 0.0f);
        if (!this.f3429x) {
            vVar = new v();
        } else {
            vVar = null;
        }
        n3(this.f3394c, vVar);
        this.f3405f7.gv(false);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i5) {
        int i6 = this.f3415o;
        if (i6 < 0) {
            return i5;
        }
        if (i5 == i - 1) {
            return i6;
        }
        if (i5 >= i6) {
            return i5 + 1;
        }
        return i5;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f3428w.y();
    }

    public int getProgressCircleDiameter() {
        return this.f3396ct;
    }

    public int getProgressViewEndOffset() {
        return this.f3419q9;
    }

    public int getProgressViewStartOffset() {
        return this.f3426ut;
    }

    public final void gv() {
        this.f3420qn = new pz.y(getContext());
        pz.n3 n3Var = new pz.n3(getContext());
        this.f3405f7 = n3Var;
        n3Var.t(1);
        this.f3420qn.setImageDrawable(this.f3405f7);
        this.f3420qn.setVisibility(8);
        addView(this.f3420qn);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.f3418p.f();
    }

    public final void i4() {
        this.f3431y5 = r(this.f3405f7.getAlpha(), 255);
    }

    @Override // hw.tl
    public void i9(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f3418p.tl();
    }

    public void n(Animation.AnimationListener animationListener) {
        zn znVar = new zn();
        this.f3410jz = znVar;
        znVar.setDuration(150L);
        this.f3420qn.n3(animationListener);
        this.f3420qn.clearAnimation();
        this.f3420qn.startAnimation(this.f3410jz);
    }

    public final void n3(int i, Animation.AnimationListener animationListener) {
        if (this.f3429x) {
            c(i, animationListener);
            return;
        }
        this.f3408j = i;
        this.f3414nf.reset();
        this.f3414nf.setDuration(200L);
        this.f3414nf.setInterpolator(this.f3409j5);
        if (animationListener != null) {
            this.f3420qn.n3(animationListener);
        }
        this.f3420qn.clearAnimation();
        this.f3420qn.startAnimation(this.f3414nf);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        co();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f3393b && actionMasked == 0) {
            this.f3393b = false;
        }
        if (!isEnabled() || this.f3393b || zn() || this.f3406fb || this.f3404f3) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            mt(motionEvent);
                        }
                    }
                } else {
                    int i = this.f3401ej;
                    if (i == -1) {
                        Log.e(f3392ra, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    x4(motionEvent.getY(findPointerIndex));
                }
            }
            this.f3397d = false;
            this.f3401ej = -1;
        } else {
            setTargetOffsetTopAndBottom(this.f3426ut - this.f3420qn.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.f3401ej = pointerId;
            this.f3397d = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.f3407fh = motionEvent.getY(findPointerIndex2);
        }
        return this.f3397d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.y == null) {
            a();
        }
        View view = this.y;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.f3420qn.getMeasuredWidth();
        int measuredHeight2 = this.f3420qn.getMeasuredHeight();
        int i10 = measuredWidth / 2;
        int i11 = measuredWidth2 / 2;
        int i12 = this.f3394c;
        this.f3420qn.layout(i10 - i11, i12, i10 + i11, measuredHeight2 + i12);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i5) {
        super.onMeasure(i, i5);
        if (this.y == null) {
            a();
        }
        View view = this.y;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f3420qn.measure(View.MeasureSpec.makeMeasureSpec(this.f3396ct, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f3396ct, 1073741824));
        this.f3415o = -1;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            if (getChildAt(i6) == this.f3420qn) {
                this.f3415o = i6;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f4, float f6, boolean z2) {
        return dispatchNestedFling(f4, f6, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f4, float f6) {
        return dispatchNestedPreFling(f4, f6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i5, int[] iArr) {
        if (i5 > 0) {
            float f4 = this.f3424t;
            if (f4 > 0.0f) {
                float f6 = i5;
                if (f6 > f4) {
                    iArr[1] = (int) f4;
                    this.f3424t = 0.0f;
                } else {
                    this.f3424t = f4 - f6;
                    iArr[1] = i5;
                }
                w(this.f3424t);
            }
        }
        if (this.f3416o4 && i5 > 0 && this.f3424t == 0.0f && Math.abs(i5 - iArr[1]) > 0) {
            this.f3420qn.setVisibility(8);
        }
        int[] iArr2 = this.f3395co;
        if (dispatchNestedPreScroll(i - iArr[0], i5 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i5, int i6, int i8) {
        tl(view, i, i5, i6, i8, 0, this.f3421r);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f3428w.n3(view, view2, i);
        startNestedScroll(i & 2);
        this.f3424t = 0.0f;
        this.f3404f3 = true;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRefreshing(savedState.y);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f3406fb);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if (isEnabled() && !this.f3393b && !this.f3406fb && (i & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.f3428w.gv(view);
        this.f3404f3 = false;
        float f4 = this.f3424t;
        if (f4 > 0.0f) {
            fb(f4);
            this.f3424t = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f3393b && actionMasked == 0) {
            this.f3393b = false;
        }
        if (!isEnabled() || this.f3393b || zn() || this.f3406fb || this.f3404f3) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked == 3) {
                        return false;
                    }
                    if (actionMasked != 5) {
                        if (actionMasked == 6) {
                            mt(motionEvent);
                        }
                    } else {
                        int actionIndex = motionEvent.getActionIndex();
                        if (actionIndex < 0) {
                            Log.e(f3392ra, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                            return false;
                        }
                        this.f3401ej = motionEvent.getPointerId(actionIndex);
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f3401ej);
                    if (findPointerIndex < 0) {
                        Log.e(f3392ra, "Got ACTION_MOVE event but have an invalid active pointer id.");
                        return false;
                    }
                    float y2 = motionEvent.getY(findPointerIndex);
                    x4(y2);
                    if (this.f3397d) {
                        float f4 = (y2 - this.f3398d0) * 0.5f;
                        if (f4 <= 0.0f) {
                            return false;
                        }
                        getParent().requestDisallowInterceptTouchEvent(true);
                        w(f4);
                    }
                }
            } else {
                int findPointerIndex2 = motionEvent.findPointerIndex(this.f3401ej);
                if (findPointerIndex2 < 0) {
                    Log.e(f3392ra, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.f3397d) {
                    this.f3397d = false;
                    fb((motionEvent.getY(findPointerIndex2) - this.f3398d0) * 0.5f);
                }
                this.f3401ej = -1;
                return false;
            }
        } else {
            this.f3401ej = motionEvent.getPointerId(0);
            this.f3397d = false;
        }
        return true;
    }

    public void p(float f4) {
        int i = this.f3408j;
        setTargetOffsetTopAndBottom((i + ((int) ((this.f3426ut - i) * f4))) - this.f3420qn.getTop());
    }

    public final Animation r(int i, int i5) {
        gv gvVar = new gv(i, i5);
        gvVar.setDuration(300L);
        this.f3420qn.n3(null);
        this.f3420qn.clearAnimation();
        this.f3420qn.startAnimation(gvVar);
        return gvVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        ViewParent parent;
        View view = this.y;
        if (view != null && !i4.k(view)) {
            if (!this.f3422rs && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(z2);
                return;
            }
            return;
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public final boolean s(Animation animation) {
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            return true;
        }
        return false;
    }

    public void setAnimationProgress(float f4) {
        this.f3420qn.setScaleX(f4);
        this.f3420qn.setScaleY(f4);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        a();
        this.f3405f7.a(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = mg.y.zn(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i) {
        this.f3403f = i;
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (!z2) {
            co();
        }
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z2) {
        this.f3422rs = z2;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        this.f3418p.wz(z2);
    }

    public void setOnChildScrollUpCallback(@Nullable c5 c5Var) {
    }

    public void setOnRefreshListener(@Nullable i9 i9Var) {
        this.f3427v = i9Var;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.f3420qn.setBackgroundColor(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(mg.y.zn(getContext(), i));
    }

    public void setRefreshing(boolean z2) {
        int i;
        if (z2 && this.f3406fb != z2) {
            this.f3406fb = z2;
            if (!this.f3416o4) {
                i = this.f3419q9 + this.f3426ut;
            } else {
                i = this.f3419q9;
            }
            setTargetOffsetTopAndBottom(i - this.f3394c);
            this.f3399dm = false;
            d0(this.f3400eb);
            return;
        }
        z(z2, false);
    }

    public void setSize(int i) {
        if (i != 0 && i != 1) {
            return;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (i == 0) {
            this.f3396ct = (int) (displayMetrics.density * 56.0f);
        } else {
            this.f3396ct = (int) (displayMetrics.density * 40.0f);
        }
        this.f3420qn.setImageDrawable(null);
        this.f3405f7.t(i);
        this.f3420qn.setImageDrawable(this.f3405f7);
    }

    public void setSlingshotDistance(int i) {
        this.f3411k = i;
    }

    public void setTargetOffsetTopAndBottom(int i) {
        this.f3420qn.bringToFront();
        i4.xg(this.f3420qn, i);
        this.f3394c = this.f3420qn.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.f3418p.w(i);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.f3418p.mt();
    }

    public boolean t() {
        return this.f3406fb;
    }

    @Override // hw.wz
    public void tl(@NonNull View view, int i, int i5, int i6, int i8, int i10, @NonNull int[] iArr) {
        int i11;
        if (i10 != 0) {
            return;
        }
        int i12 = iArr[1];
        v(i, i5, i6, i8, this.f3432z, i10, iArr);
        int i13 = i8 - (iArr[1] - i12);
        if (i13 == 0) {
            i11 = i8 + this.f3432z[1];
        } else {
            i11 = i13;
        }
        if (i11 < 0 && !zn()) {
            float abs = this.f3424t + Math.abs(i11);
            this.f3424t = abs;
            w(abs);
            iArr[1] = iArr[1] + i13;
        }
    }

    public void v(int i, int i5, int i6, int i8, @Nullable int[] iArr, int i10, @NonNull int[] iArr2) {
        if (i10 == 0) {
            this.f3418p.v(i, i5, i6, i8, iArr, i10, iArr2);
        }
    }

    public final void w(float f4) {
        this.f3405f7.gv(true);
        float min = Math.min(1.0f, Math.abs(f4 / this.f3403f));
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f4) - this.f3403f;
        int i = this.f3411k;
        if (i <= 0) {
            if (this.f3416o4) {
                i = this.f3419q9 - this.f3426ut;
            } else {
                i = this.f3419q9;
            }
        }
        float f6 = i;
        double max2 = Math.max(0.0f, Math.min(abs, f6 * 2.0f) / f6) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i5 = this.f3426ut + ((int) ((f6 * min) + (f6 * pow * 2.0f)));
        if (this.f3420qn.getVisibility() != 0) {
            this.f3420qn.setVisibility(0);
        }
        if (!this.f3429x) {
            this.f3420qn.setScaleX(1.0f);
            this.f3420qn.setScaleY(1.0f);
        }
        if (this.f3429x) {
            setAnimationProgress(Math.min(1.0f, f4 / this.f3403f));
        }
        if (f4 < this.f3403f) {
            if (this.f3405f7.getAlpha() > 76 && !s(this.f3425u)) {
                f3();
            }
        } else if (this.f3405f7.getAlpha() < 255 && !s(this.f3431y5)) {
            i4();
        }
        this.f3405f7.i9(0.0f, Math.min(0.8f, max * 0.8f));
        this.f3405f7.v(Math.min(1.0f, max));
        this.f3405f7.fb((((max * 0.4f) - 0.25f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i5 - this.f3394c);
    }

    @Override // hw.tl
    public void wz(View view, int i, int i5, int i6, int i8, int i10) {
        tl(view, i, i5, i6, i8, i10, this.f3421r);
    }

    public final void x4(float f4) {
        float f6 = this.f3407fh;
        int i = this.f3423s;
        if (f4 - f6 > i && !this.f3397d) {
            this.f3398d0 = f6 + i;
            this.f3397d = true;
            this.f3405f7.setAlpha(76);
        }
    }

    @Override // hw.tl
    public boolean xc(View view, View view2, int i, int i5) {
        if (i5 == 0) {
            return onStartNestedScroll(view, view2, i);
        }
        return false;
    }

    public final void y(int i, Animation.AnimationListener animationListener) {
        this.f3408j = i;
        this.f3412lc.reset();
        this.f3412lc.setDuration(200L);
        this.f3412lc.setInterpolator(this.f3409j5);
        if (animationListener != null) {
            this.f3420qn.n3(animationListener);
        }
        this.f3420qn.clearAnimation();
        this.f3420qn.startAnimation(this.f3412lc);
    }

    public final void z(boolean z2, boolean z3) {
        if (this.f3406fb != z2) {
            this.f3399dm = z3;
            a();
            this.f3406fb = z2;
            if (z2) {
                y(this.f3394c, this.f3400eb);
            } else {
                n(this.f3400eb);
            }
        }
    }

    public boolean zn() {
        View view = this.y;
        if (view instanceof ListView) {
            return j.f.y((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();
        public final boolean y;

        /* loaded from: classes.dex */
        public class y implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: n3 */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        public SavedState(Parcelable parcelable, boolean z2) {
            super(parcelable);
            this.y = z2;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.y ? (byte) 1 : (byte) 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.y = parcel.readByte() != 0;
        }
    }
}
