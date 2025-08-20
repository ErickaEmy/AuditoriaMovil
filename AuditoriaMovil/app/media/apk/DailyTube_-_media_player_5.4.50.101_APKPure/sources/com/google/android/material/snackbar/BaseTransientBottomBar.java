package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.y;
import hw.ej;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5830a;
    @Nullable

    /* renamed from: co  reason: collision with root package name */
    public final AccessibilityManager f5832co;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Rect f5833f;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public View f5834fb;
    @NonNull

    /* renamed from: gv  reason: collision with root package name */
    public final jn.y f5835gv;

    /* renamed from: mt  reason: collision with root package name */
    public Behavior f5837mt;

    /* renamed from: n3  reason: collision with root package name */
    public final Context f5838n3;

    /* renamed from: p  reason: collision with root package name */
    public List<co<B>> f5839p;

    /* renamed from: s  reason: collision with root package name */
    public boolean f5840s;

    /* renamed from: t  reason: collision with root package name */
    public int f5841t;

    /* renamed from: tl  reason: collision with root package name */
    public int f5842tl;

    /* renamed from: v  reason: collision with root package name */
    public int f5843v;

    /* renamed from: w  reason: collision with root package name */
    public int f5844w;

    /* renamed from: wz  reason: collision with root package name */
    public int f5845wz;

    /* renamed from: xc  reason: collision with root package name */
    public int f5846xc;
    @NonNull
    public final ViewGroup y;
    @NonNull

    /* renamed from: zn  reason: collision with root package name */
    public final i4 f5848zn;

    /* renamed from: x4  reason: collision with root package name */
    public static final boolean f5829x4 = false;

    /* renamed from: i4  reason: collision with root package name */
    public static final int[] f5827i4 = {R$attr.fgl};

    /* renamed from: f3  reason: collision with root package name */
    public static final String f5826f3 = BaseTransientBottomBar.class.getSimpleName();
    @NonNull

    /* renamed from: r  reason: collision with root package name */
    public static final Handler f5828r = new Handler(Looper.getMainLooper(), new i9());

    /* renamed from: c5  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f5831c5 = new f();

    /* renamed from: i9  reason: collision with root package name */
    public final Runnable f5836i9 = new t();
    @NonNull

    /* renamed from: z  reason: collision with root package name */
    public y.n3 f5847z = new xc();

    /* loaded from: classes.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        public final z f5849f = new z(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        public boolean f(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            this.f5849f.n3(coordinatorLayout, view, motionEvent);
            return super.f(coordinatorLayout, view, motionEvent);
        }

        public final void hw(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f5849f.zn(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean ta(View view) {
            return this.f5849f.y(view);
        }
    }

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.b();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f5835gv.y(70, 180);
        }
    }

    /* loaded from: classes.dex */
    public class c5 implements ValueAnimator.AnimatorUpdateListener {
        public int y;

        public c5() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f5829x4) {
                hw.i4.xg(BaseTransientBottomBar.this.f5848zn, intValue - this.y);
            } else {
                BaseTransientBottomBar.this.f5848zn.setTranslationY(intValue);
            }
            this.y = intValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class co<B> {
        public void n3(B b2) {
        }

        public void y(B b2, int i) {
        }
    }

    /* loaded from: classes.dex */
    public class f implements ViewTreeObserver.OnGlobalLayoutListener {
        public f() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!BaseTransientBottomBar.this.f5840s) {
                return;
            }
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            baseTransientBottomBar.f5844w = baseTransientBottomBar.r();
            BaseTransientBottomBar.this.k();
        }
    }

    /* loaded from: classes.dex */
    public class fb implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ int f5851n3;
        public int y;

        public fb(int i) {
            this.f5851n3 = i;
            this.y = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f5829x4) {
                hw.i4.xg(BaseTransientBottomBar.this.f5848zn, intValue - this.y);
            } else {
                BaseTransientBottomBar.this.f5848zn.setTranslationY(intValue);
            }
            this.y = intValue;
        }
    }

    /* loaded from: classes.dex */
    public class gv implements ValueAnimator.AnimatorUpdateListener {
        public gv() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f5848zn.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public static class i4 extends FrameLayout {

        /* renamed from: p  reason: collision with root package name */
        public static final View.OnTouchListener f5853p = new y();

        /* renamed from: f  reason: collision with root package name */
        public final float f5854f;

        /* renamed from: fb  reason: collision with root package name */
        public int f5855fb;

        /* renamed from: s  reason: collision with root package name */
        public final float f5856s;

        /* renamed from: t  reason: collision with root package name */
        public ColorStateList f5857t;

        /* renamed from: v  reason: collision with root package name */
        public r f5858v;

        /* renamed from: w  reason: collision with root package name */
        public PorterDuff.Mode f5859w;
        public x4 y;

        /* loaded from: classes.dex */
        public static class y implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public i4(@NonNull Context context, AttributeSet attributeSet) {
            super(c0.y.zn(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.f5253q3);
            int i = R$styleable.f5181hu;
            if (obtainStyledAttributes.hasValue(i)) {
                hw.i4.pz(this, obtainStyledAttributes.getDimensionPixelSize(i, 0));
            }
            this.f5855fb = obtainStyledAttributes.getInt(R$styleable.f5246p5, 0);
            this.f5856s = obtainStyledAttributes.getFloat(R$styleable.f5130c3, 1.0f);
            setBackgroundTintList(pv.zn.y(context2, obtainStyledAttributes, R$styleable.f5313xp));
            setBackgroundTintMode(ur.f.v(obtainStyledAttributes.getInt(R$styleable.f5249ps, -1), PorterDuff.Mode.SRC_IN));
            this.f5854f = obtainStyledAttributes.getFloat(R$styleable.f5289us, 1.0f);
            obtainStyledAttributes.recycle();
            setOnTouchListener(f5853p);
            setFocusable(true);
            if (getBackground() == null) {
                hw.i4.u0(this, y());
            }
        }

        public float getActionTextColorAlpha() {
            return this.f5854f;
        }

        public int getAnimationMode() {
            return this.f5855fb;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f5856s;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            r rVar = this.f5858v;
            if (rVar != null) {
                rVar.onViewAttachedToWindow(this);
            }
            hw.i4.yg(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            r rVar = this.f5858v;
            if (rVar != null) {
                rVar.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
            super.onLayout(z2, i, i5, i6, i8);
            x4 x4Var = this.y;
            if (x4Var != null) {
                x4Var.y(this, i, i5, i6, i8);
            }
        }

        public void setAnimationMode(int i) {
            this.f5855fb = i;
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null && this.f5857t != null) {
                drawable = ej.y.mt(drawable.mutate());
                ej.y.xc(drawable, this.f5857t);
                ej.y.w(drawable, this.f5859w);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            this.f5857t = colorStateList;
            if (getBackground() != null) {
                Drawable mt2 = ej.y.mt(getBackground().mutate());
                ej.y.xc(mt2, colorStateList);
                ej.y.w(mt2, this.f5859w);
                if (mt2 != getBackground()) {
                    super.setBackgroundDrawable(mt2);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            this.f5859w = mode;
            if (getBackground() != null) {
                Drawable mt2 = ej.y.mt(getBackground().mutate());
                ej.y.w(mt2, mode);
                if (mt2 != getBackground()) {
                    super.setBackgroundDrawable(mt2);
                }
            }
        }

        public void setOnAttachStateChangeListener(r rVar) {
            this.f5858v = rVar;
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            View.OnTouchListener onTouchListener;
            if (onClickListener != null) {
                onTouchListener = null;
            } else {
                onTouchListener = f5853p;
            }
            setOnTouchListener(onTouchListener);
            super.setOnClickListener(onClickListener);
        }

        public void setOnLayoutChangeListener(x4 x4Var) {
            this.y = x4Var;
        }

        @NonNull
        public final Drawable y() {
            float dimension = getResources().getDimension(R$dimen.m5);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(td.y.s(this, R$attr.uh, R$attr.y5, getBackgroundOverlayColorAlpha()));
            if (this.f5857t != null) {
                Drawable mt2 = ej.y.mt(gradientDrawable);
                ej.y.xc(mt2, this.f5857t);
                return mt2;
            }
            return ej.y.mt(gradientDrawable);
        }
    }

    /* loaded from: classes.dex */
    public static class i9 implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    return false;
                }
                ((BaseTransientBottomBar) message.obj).ej(message.arg1);
                return true;
            }
            ((BaseTransientBottomBar) message.obj).qn();
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class mt implements SwipeDismissBehavior.zn {
        public mt() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.zn
        public void n3(int i) {
            if (i != 0) {
                if (i == 1 || i == 2) {
                    com.google.android.material.snackbar.y.zn().i9(BaseTransientBottomBar.this.f5847z);
                    return;
                }
                return;
            }
            com.google.android.material.snackbar.y.zn().f(BaseTransientBottomBar.this.f5847z);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.zn
        public void y(@NonNull View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.i4(0);
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends AnimatorListenerAdapter {
        public n3() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.b();
        }
    }

    /* loaded from: classes.dex */
    public class p implements x4 {
        public p() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.x4
        public void y(View view, int i, int i5, int i6, int i8) {
            BaseTransientBottomBar.this.f5848zn.setOnLayoutChangeListener(null);
            BaseTransientBottomBar.this.o();
        }
    }

    /* loaded from: classes.dex */
    public interface r {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    /* loaded from: classes.dex */
    public class s extends AnimatorListenerAdapter {
        public final /* synthetic */ int y;

        public s(int i) {
            this.y = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.x(this.y);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f5835gv.n3(0, 180);
        }
    }

    /* loaded from: classes.dex */
    public class t implements Runnable {
        public t() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int fh2;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f5848zn == null || baseTransientBottomBar.f5838n3 == null || (fh2 = (BaseTransientBottomBar.this.fh() - BaseTransientBottomBar.this.d()) + ((int) BaseTransientBottomBar.this.f5848zn.getTranslationY())) >= BaseTransientBottomBar.this.f5846xc) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f5848zn.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.f5826f3, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.f5846xc - fh2;
            BaseTransientBottomBar.this.f5848zn.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public class tl implements hw.w {
        public tl() {
        }

        @Override // hw.w
        @NonNull
        public ej y(View view, @NonNull ej ejVar) {
            BaseTransientBottomBar.this.f5841t = ejVar.i9();
            BaseTransientBottomBar.this.f5842tl = ejVar.f();
            BaseTransientBottomBar.this.f5845wz = ejVar.t();
            BaseTransientBottomBar.this.k();
            return ejVar;
        }
    }

    /* loaded from: classes.dex */
    public class v implements ValueAnimator.AnimatorUpdateListener {
        public v() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f5848zn.setScaleX(floatValue);
            BaseTransientBottomBar.this.f5848zn.setScaleY(floatValue);
        }
    }

    /* loaded from: classes.dex */
    public class w implements r {

        /* loaded from: classes.dex */
        public class y implements Runnable {
            public y() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseTransientBottomBar.this.x(3);
            }
        }

        public w() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.r
        public void onViewAttachedToWindow(View view) {
            WindowInsets rootWindowInsets;
            if (Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = BaseTransientBottomBar.this.f5848zn.getRootWindowInsets()) != null) {
                BaseTransientBottomBar.this.f5846xc = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
                BaseTransientBottomBar.this.k();
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.r
        public void onViewDetachedFromWindow(View view) {
            if (BaseTransientBottomBar.this.ud()) {
                BaseTransientBottomBar.f5828r.post(new y());
            }
        }
    }

    /* loaded from: classes.dex */
    public class wz extends hw.y {
        public wz() {
        }

        @Override // hw.y
        public void fb(View view, @NonNull j5.zn znVar) {
            super.fb(view, znVar);
            znVar.y(1048576);
            znVar.kp(true);
        }

        @Override // hw.y
        public boolean i9(View view, int i, Bundle bundle) {
            if (i == 1048576) {
                BaseTransientBottomBar.this.x4();
                return true;
            }
            return super.i9(view, i, bundle);
        }
    }

    /* loaded from: classes.dex */
    public interface x4 {
        void y(View view, int i, int i5, int i6, int i8);
    }

    /* loaded from: classes.dex */
    public class xc implements y.n3 {
        public xc() {
        }

        @Override // com.google.android.material.snackbar.y.n3
        public void show() {
            Handler handler = BaseTransientBottomBar.f5828r;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.y.n3
        public void y(int i) {
            Handler handler = BaseTransientBottomBar.f5828r;
            handler.sendMessage(handler.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i4 i4Var = BaseTransientBottomBar.this.f5848zn;
            if (i4Var == null) {
                return;
            }
            if (i4Var.getParent() != null) {
                BaseTransientBottomBar.this.f5848zn.setVisibility(0);
            }
            if (BaseTransientBottomBar.this.f5848zn.getAnimationMode() == 1) {
                BaseTransientBottomBar.this.j();
            } else {
                BaseTransientBottomBar.this.ut();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class z {
        public y.n3 y;

        public z(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.b(0.1f);
            swipeDismissBehavior.a8(0.6f);
            swipeDismissBehavior.k5(0);
        }

        public void n3(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    com.google.android.material.snackbar.y.zn().f(this.y);
                }
            } else if (coordinatorLayout.fh(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                com.google.android.material.snackbar.y.zn().i9(this.y);
            }
        }

        public boolean y(View view) {
            return view instanceof i4;
        }

        public void zn(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.y = baseTransientBottomBar.f5847z;
        }
    }

    /* loaded from: classes.dex */
    public class zn extends AnimatorListenerAdapter {
        public final /* synthetic */ int y;

        public zn(int i) {
            this.y = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.x(this.y);
        }
    }

    public BaseTransientBottomBar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull jn.y yVar) {
        if (viewGroup != null) {
            if (view != null) {
                if (yVar != null) {
                    this.y = viewGroup;
                    this.f5835gv = yVar;
                    this.f5838n3 = context;
                    ur.i9.y(context);
                    i4 i4Var = (i4) LayoutInflater.from(context).inflate(rz(), viewGroup, false);
                    this.f5848zn = i4Var;
                    if (view instanceof SnackbarContentLayout) {
                        ((SnackbarContentLayout) view).zn(i4Var.getActionTextColorAlpha());
                    }
                    i4Var.addView(view);
                    ViewGroup.LayoutParams layoutParams = i4Var.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        this.f5833f = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    }
                    hw.i4.g(i4Var, 1);
                    hw.i4.o0(i4Var, 1);
                    hw.i4.pq(i4Var, true);
                    hw.i4.ad(i4Var, new tl());
                    hw.i4.g3(i4Var, new wz());
                    this.f5832co = (AccessibilityManager) context.getSystemService("accessibility");
                    return;
                }
                throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
            }
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
    }

    public final boolean a8() {
        ViewGroup.LayoutParams layoutParams = this.f5848zn.getLayoutParams();
        if ((layoutParams instanceof CoordinatorLayout.a) && (((CoordinatorLayout.a) layoutParams).a() instanceof SwipeDismissBehavior)) {
            return true;
        }
        return false;
    }

    public void b() {
        com.google.android.material.snackbar.y.zn().c5(this.f5847z);
        List<co<B>> list = this.f5839p;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f5839p.get(size).n3(this);
            }
        }
    }

    @NonNull
    public SwipeDismissBehavior<? extends View> c() {
        return new Behavior();
    }

    public void co() {
        this.f5848zn.post(new y());
    }

    public final int d() {
        int[] iArr = new int[2];
        this.f5848zn.getLocationOnScreen(iArr);
        return iArr[1] + this.f5848zn.getHeight();
    }

    public final ValueAnimator d0(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(y6.y.f15324gv);
        ofFloat.addUpdateListener(new v());
        return ofFloat;
    }

    public final void ej(int i) {
        if (vl() && this.f5848zn.getVisibility() == 0) {
            z(i);
        } else {
            x(i);
        }
    }

    public final ValueAnimator f3(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(y6.y.y);
        ofFloat.addUpdateListener(new gv());
        return ofFloat;
    }

    public final int fh() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f5838n3.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public final boolean hw() {
        if (this.f5846xc > 0 && !this.f5830a && a8()) {
            return true;
        }
        return false;
    }

    public void i4(int i) {
        com.google.android.material.snackbar.y.zn().n3(this.f5847z, i);
    }

    public final void j() {
        ValueAnimator f32 = f3(0.0f, 1.0f);
        ValueAnimator d02 = d0(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(f32, d02);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new n3());
        animatorSet.start();
    }

    public void j5() {
        com.google.android.material.snackbar.y.zn().tl(n(), this.f5847z);
    }

    public final void k() {
        Rect rect;
        int i;
        ViewGroup.LayoutParams layoutParams = this.f5848zn.getLayoutParams();
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && (rect = this.f5833f) != null) {
            if (this.f5834fb != null) {
                i = this.f5844w;
            } else {
                i = this.f5841t;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = rect.bottom + i;
            marginLayoutParams.leftMargin = rect.left + this.f5842tl;
            marginLayoutParams.rightMargin = rect.right + this.f5845wz;
            this.f5848zn.requestLayout();
            if (Build.VERSION.SDK_INT >= 29 && hw()) {
                this.f5848zn.removeCallbacks(this.f5836i9);
                this.f5848zn.post(this.f5836i9);
                return;
            }
            return;
        }
        Log.w(f5826f3, "Unable to update margins because layout params are not MarginLayoutParams");
    }

    @NonNull
    public B k5(int i) {
        this.f5843v = i;
        return this;
    }

    public final int mg() {
        int height = this.f5848zn.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f5848zn.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return height;
    }

    public int n() {
        return this.f5843v;
    }

    public final void o() {
        if (vl()) {
            co();
            return;
        }
        if (this.f5848zn.getParent() != null) {
            this.f5848zn.setVisibility(0);
        }
        b();
    }

    public final void oz(int i) {
        ValueAnimator f32 = f3(1.0f, 0.0f);
        f32.setDuration(75L);
        f32.addListener(new zn(i));
        f32.start();
    }

    public final void q9(int i) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, mg());
        valueAnimator.setInterpolator(y6.y.f15325n3);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new s(i));
        valueAnimator.addUpdateListener(new c5());
        valueAnimator.start();
    }

    public final void qn() {
        this.f5848zn.setOnAttachStateChangeListener(new w());
        if (this.f5848zn.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f5848zn.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.a) {
                yt((CoordinatorLayout.a) layoutParams);
            }
            this.f5844w = r();
            k();
            this.f5848zn.setVisibility(4);
            this.y.addView(this.f5848zn);
        }
        if (hw.i4.q9(this.f5848zn)) {
            o();
        } else {
            this.f5848zn.setOnLayoutChangeListener(new p());
        }
    }

    public final int r() {
        View view = this.f5834fb;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[1];
        int[] iArr2 = new int[2];
        this.y.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.y.getHeight()) - i;
    }

    public int rz() {
        if (z6()) {
            return R$layout.wl;
        }
        return R$layout.s2;
    }

    @NonNull
    public View ta() {
        return this.f5848zn;
    }

    public boolean ud() {
        return com.google.android.material.snackbar.y.zn().v(this.f5847z);
    }

    public final void ut() {
        int mg2 = mg();
        if (f5829x4) {
            hw.i4.xg(this.f5848zn, mg2);
        } else {
            this.f5848zn.setTranslationY(mg2);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(mg2, 0);
        valueAnimator.setInterpolator(y6.y.f15325n3);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new a());
        valueAnimator.addUpdateListener(new fb(mg2));
        valueAnimator.start();
    }

    public boolean vl() {
        AccessibilityManager accessibilityManager = this.f5832co;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        if (enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty()) {
            return true;
        }
        return false;
    }

    public void x(int i) {
        com.google.android.material.snackbar.y.zn().s(this.f5847z);
        List<co<B>> list = this.f5839p;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f5839p.get(size).y(this, i);
            }
        }
        ViewParent parent = this.f5848zn.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f5848zn);
        }
    }

    public void x4() {
        i4(3);
    }

    public final void yt(CoordinatorLayout.a aVar) {
        SwipeDismissBehavior<? extends View> swipeDismissBehavior = this.f5837mt;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = c();
        }
        if (swipeDismissBehavior instanceof Behavior) {
            ((Behavior) swipeDismissBehavior).hw(this);
        }
        swipeDismissBehavior.x(new mt());
        aVar.xc(swipeDismissBehavior);
        if (this.f5834fb == null) {
            aVar.f2075fb = 80;
        }
    }

    public final void z(int i) {
        if (this.f5848zn.getAnimationMode() == 1) {
            oz(i);
        } else {
            q9(i);
        }
    }

    public boolean z6() {
        TypedArray obtainStyledAttributes = this.f5838n3.obtainStyledAttributes(f5827i4);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        if (resourceId == -1) {
            return false;
        }
        return true;
    }
}
