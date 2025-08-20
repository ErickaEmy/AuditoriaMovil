package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import hw.i4;
import java.util.List;
import y6.s;
/* loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.n3 {

    /* renamed from: b  reason: collision with root package name */
    public final int f5709b;

    /* renamed from: j  reason: collision with root package name */
    public boolean f5710j;

    /* renamed from: j5  reason: collision with root package name */
    public int f5711j5;
    @NonNull

    /* renamed from: o  reason: collision with root package name */
    public final CoordinatorLayout.zn<ExtendedFloatingActionButton> f5712o;

    /* renamed from: oz  reason: collision with root package name */
    public boolean f5713oz;
    @NonNull

    /* renamed from: q9  reason: collision with root package name */
    public ColorStateList f5714q9;

    /* renamed from: qn  reason: collision with root package name */
    public int f5715qn;

    /* renamed from: ut  reason: collision with root package name */
    public boolean f5716ut;

    /* renamed from: x  reason: collision with root package name */
    public int f5717x;

    /* renamed from: k  reason: collision with root package name */
    public static final int f5707k = R$style.o8;

    /* renamed from: f7  reason: collision with root package name */
    public static final Property<View, Float> f5705f7 = new n3(Float.class, "width");

    /* renamed from: en  reason: collision with root package name */
    public static final Property<View, Float> f5704en = new zn(Float.class, "height");

    /* renamed from: jz  reason: collision with root package name */
    public static final Property<View, Float> f5706jz = new gv(Float.class, "paddingStart");

    /* renamed from: u  reason: collision with root package name */
    public static final Property<View, Float> f5708u = new v(Float.class, "paddingEnd");

    /* loaded from: classes.dex */
    public static abstract class a {
    }

    /* loaded from: classes.dex */
    public static class gv extends Property<View, Float> {
        public gv(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: n3 */
        public void set(@NonNull View view, @NonNull Float f4) {
            i4.cy(view, f4.intValue(), view.getPaddingTop(), i4.ud(view), view.getPaddingBottom());
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: y */
        public Float get(@NonNull View view) {
            return Float.valueOf(i4.a8(view));
        }
    }

    /* loaded from: classes.dex */
    public static class n3 extends Property<View, Float> {
        public n3(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: n3 */
        public void set(@NonNull View view, @NonNull Float f4) {
            view.getLayoutParams().width = f4.intValue();
            view.requestLayout();
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: y */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }
    }

    /* loaded from: classes.dex */
    public static class v extends Property<View, Float> {
        public v(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: n3 */
        public void set(@NonNull View view, @NonNull Float f4) {
            i4.cy(view, i4.a8(view), view.getPaddingTop(), f4.intValue(), view.getPaddingBottom());
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: y */
        public Float get(@NonNull View view) {
            return Float.valueOf(i4.ud(view));
        }
    }

    /* loaded from: classes.dex */
    public class y extends AnimatorListenerAdapter {
        public boolean y;

        public y(com.google.android.material.floatingactionbutton.n3 n3Var, a aVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.y = true;
            throw null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            throw null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends Property<View, Float> {
        public zn(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: n3 */
        public void set(@NonNull View view, @NonNull Float f4) {
            view.getLayoutParams().height = f4.intValue();
            view.requestLayout();
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: y */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }
    }

    private boolean p() {
        if (getVisibility() != 0) {
            if (this.f5717x != 2) {
                return false;
            }
            return true;
        } else if (this.f5717x == 1) {
            return false;
        } else {
            return true;
        }
    }

    public static /* synthetic */ com.google.android.material.floatingactionbutton.n3 t(ExtendedFloatingActionButton extendedFloatingActionButton) {
        extendedFloatingActionButton.getClass();
        return null;
    }

    public static /* synthetic */ com.google.android.material.floatingactionbutton.n3 tl(ExtendedFloatingActionButton extendedFloatingActionButton) {
        extendedFloatingActionButton.getClass();
        return null;
    }

    public static /* synthetic */ com.google.android.material.floatingactionbutton.n3 w(ExtendedFloatingActionButton extendedFloatingActionButton) {
        extendedFloatingActionButton.getClass();
        return null;
    }

    public static /* synthetic */ com.google.android.material.floatingactionbutton.n3 xc(ExtendedFloatingActionButton extendedFloatingActionButton) {
        extendedFloatingActionButton.getClass();
        return null;
    }

    public final void co() {
        this.f5714q9 = getTextColors();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.n3
    @NonNull
    public CoordinatorLayout.zn<ExtendedFloatingActionButton> getBehavior() {
        return this.f5712o;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    public int getCollapsedSize() {
        int i = this.f5709b;
        if (i < 0) {
            return (Math.min(i4.a8(this), i4.ud(this)) * 2) + getIconSize();
        }
        return i;
    }

    @Nullable
    public s getExtendMotionSpec() {
        throw null;
    }

    @Nullable
    public s getHideMotionSpec() {
        throw null;
    }

    @Nullable
    public s getShowMotionSpec() {
        throw null;
    }

    @Nullable
    public s getShrinkMotionSpec() {
        throw null;
    }

    public final void mt(@NonNull com.google.android.material.floatingactionbutton.n3 n3Var, @Nullable a aVar) {
        if (n3Var.n3()) {
            return;
        }
        if (!z()) {
            n3Var.y();
            n3Var.v(aVar);
            return;
        }
        measure(0, 0);
        AnimatorSet zn2 = n3Var.zn();
        zn2.addListener(new y(n3Var, aVar));
        for (Animator.AnimatorListener animatorListener : n3Var.gv()) {
            zn2.addListener(animatorListener);
        }
        zn2.start();
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5710j && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.f5710j = false;
            throw null;
        }
    }

    public void setAnimateShowBeforeLayout(boolean z2) {
        this.f5716ut = z2;
    }

    public void setExtendMotionSpec(@Nullable s sVar) {
        throw null;
    }

    public void setExtendMotionSpecResource(int i) {
        setExtendMotionSpec(s.zn(getContext(), i));
    }

    public void setExtended(boolean z2) {
        if (this.f5710j == z2) {
            return;
        }
        throw null;
    }

    public void setHideMotionSpec(@Nullable s sVar) {
        throw null;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(s.zn(getContext(), i));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i5, int i6, int i8) {
        super.setPadding(i, i5, i6, i8);
        if (this.f5710j && !this.f5713oz) {
            this.f5711j5 = i4.a8(this);
            this.f5715qn = i4.ud(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i, int i5, int i6, int i8) {
        super.setPaddingRelative(i, i5, i6, i8);
        if (this.f5710j && !this.f5713oz) {
            this.f5711j5 = i;
            this.f5715qn = i6;
        }
    }

    public void setShowMotionSpec(@Nullable s sVar) {
        throw null;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(s.zn(getContext(), i));
    }

    public void setShrinkMotionSpec(@Nullable s sVar) {
        throw null;
    }

    public void setShrinkMotionSpecResource(int i) {
        setShrinkMotionSpec(s.zn(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        co();
    }

    public final boolean z() {
        if ((i4.q9(this) || (!p() && this.f5716ut)) && !isInEditMode()) {
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.zn<T> {

        /* renamed from: n3  reason: collision with root package name */
        public boolean f5718n3;
        public Rect y;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f5719zn;

        public ExtendedFloatingActionButtonBehavior() {
            this.f5719zn = true;
        }

        public static boolean z6(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.a) {
                return ((CoordinatorLayout.a) layoutParams).a() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public final boolean a8(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            CoordinatorLayout.a aVar = (CoordinatorLayout.a) extendedFloatingActionButton.getLayoutParams();
            if ((!this.f5718n3 && !this.f5719zn) || aVar.v() != view.getId()) {
                return false;
            }
            return true;
        }

        public final boolean b(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!a8(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.y == null) {
                this.y = new Rect();
            }
            Rect rect = this.y;
            ur.n3.y(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                x(extendedFloatingActionButton);
                return true;
            }
            ta(extendedFloatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        /* renamed from: d */
        public boolean n3(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull Rect rect) {
            return super.n3(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        /* renamed from: ej */
        public boolean s(CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                b(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            } else if (z6(view)) {
                k5(view, extendedFloatingActionButton);
                return false;
            } else {
                return false;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        public void fb(@NonNull CoordinatorLayout.a aVar) {
            if (aVar.f2081s == 0) {
                aVar.f2081s = 80;
            }
        }

        public final boolean k5(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!a8(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.a) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                x(extendedFloatingActionButton);
                return true;
            }
            ta(extendedFloatingActionButton);
            return true;
        }

        public void ta(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (this.f5719zn) {
                ExtendedFloatingActionButton.xc(extendedFloatingActionButton);
            } else {
                ExtendedFloatingActionButton.w(extendedFloatingActionButton);
            }
            extendedFloatingActionButton.mt(null, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        /* renamed from: ud */
        public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
            List<View> mt2 = coordinatorLayout.mt(extendedFloatingActionButton);
            int size = mt2.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view = mt2.get(i5);
                if (view instanceof AppBarLayout) {
                    if (b(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (z6(view) && k5(view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.ud(extendedFloatingActionButton, i);
            return true;
        }

        public void x(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (this.f5719zn) {
                ExtendedFloatingActionButton.t(extendedFloatingActionButton);
            } else {
                ExtendedFloatingActionButton.tl(extendedFloatingActionButton);
            }
            extendedFloatingActionButton.mt(null, null);
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.p1);
            this.f5718n3 = obtainStyledAttributes.getBoolean(R$styleable.i, false);
            this.f5719zn = obtainStyledAttributes.getBoolean(R$styleable.rv, true);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        co();
    }
}
