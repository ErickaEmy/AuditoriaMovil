package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.y;
import com.google.android.material.stateful.ExtendableSavedState;
import hw.i4;
import hx.wz;
import java.util.List;
import ur.t;
import wz.c5;
import wz.f;
import y6.s;
/* loaded from: classes.dex */
public class FloatingActionButton extends t implements w3.y, wz, CoordinatorLayout.n3 {

    /* renamed from: ej  reason: collision with root package name */
    public static final int f5721ej = R$style.zt;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f5722c;

    /* renamed from: co  reason: collision with root package name */
    public int f5723co;

    /* renamed from: d  reason: collision with root package name */
    public com.google.android.material.floatingactionbutton.y f5724d;
    @NonNull

    /* renamed from: d0  reason: collision with root package name */
    public final f f5725d0;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public PorterDuff.Mode f5726f;

    /* renamed from: f3  reason: collision with root package name */
    public boolean f5727f3;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public PorterDuff.Mode f5728fb;
    @NonNull

    /* renamed from: fh  reason: collision with root package name */
    public final w3.n3 f5729fh;

    /* renamed from: n  reason: collision with root package name */
    public final Rect f5730n;

    /* renamed from: p  reason: collision with root package name */
    public int f5731p;

    /* renamed from: r  reason: collision with root package name */
    public int f5732r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public ColorStateList f5733s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public ColorStateList f5734t;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public ColorStateList f5735v;

    /* renamed from: w  reason: collision with root package name */
    public int f5736w;

    /* renamed from: z  reason: collision with root package name */
    public int f5737z;

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean ej(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            return super.s(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        public /* bridge */ /* synthetic */ void fb(@NonNull CoordinatorLayout.a aVar) {
            super.fb(aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean ta(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            return super.n3(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean ud(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i) {
            return super.t(coordinatorLayout, floatingActionButton, i);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public class gv<T extends FloatingActionButton> implements y.c5 {
        public gv(@NonNull y6.f<T> fVar) {
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof gv)) {
                return false;
            }
            ((gv) obj).getClass();
            throw null;
        }

        public int hashCode() {
            throw null;
        }

        @Override // com.google.android.material.floatingactionbutton.y.c5
        public void n3() {
            throw null;
        }

        @Override // com.google.android.material.floatingactionbutton.y.c5
        public void y() {
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n3 {
        public void n3(FloatingActionButton floatingActionButton) {
        }

        public void y(FloatingActionButton floatingActionButton) {
        }
    }

    /* loaded from: classes.dex */
    public class y implements y.i9 {
        public final /* synthetic */ n3 y;

        public y(n3 n3Var) {
            this.y = n3Var;
        }

        @Override // com.google.android.material.floatingactionbutton.y.i9
        public void n3() {
            this.y.y(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.y.i9
        public void y() {
            this.y.n3(FloatingActionButton.this);
        }
    }

    /* loaded from: classes.dex */
    public class zn implements os.n3 {
        public zn() {
        }

        @Override // os.n3
        public void n3(@Nullable Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // os.n3
        public void y(int i, int i5, int i6, int i8) {
            FloatingActionButton.this.f5730n.set(i, i5, i6, i8);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i + floatingActionButton.f5737z, i5 + FloatingActionButton.this.f5737z, i6 + FloatingActionButton.this.f5737z, i8 + FloatingActionButton.this.f5737z);
        }

        @Override // os.n3
        public boolean zn() {
            return FloatingActionButton.this.f5727f3;
        }
    }

    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.lv);
    }

    private com.google.android.material.floatingactionbutton.y getImpl() {
        if (this.f5724d == null) {
            this.f5724d = s();
        }
        return this.f5724d;
    }

    public static int mt(int i, int i5) {
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    return size;
                }
                throw new IllegalArgumentException();
            }
            return i;
        }
        return Math.min(i, size);
    }

    public void a(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().v(animatorListener);
    }

    @Deprecated
    public boolean c5(@NonNull Rect rect) {
        if (!i4.q9(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        w(rect);
        return true;
    }

    public void co(@Nullable n3 n3Var) {
        z(n3Var, true);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().mg(getDrawableState());
    }

    public final int f(int i) {
        int i5 = this.f5723co;
        if (i5 != 0) {
            return i5;
        }
        Resources resources = getResources();
        if (i != -1) {
            if (i != 1) {
                return resources.getDimensionPixelSize(R$dimen.kw);
            }
            return resources.getDimensionPixelSize(R$dimen.ko);
        } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return f(1);
        } else {
            return f(0);
        }
    }

    public void fb(@NonNull y6.f<? extends FloatingActionButton> fVar) {
        getImpl().a(new gv(fVar));
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.f5735v;
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f5728fb;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.n3
    @NonNull
    public CoordinatorLayout.zn<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().tl();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().w();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().co();
    }

    @Nullable
    public Drawable getContentBackground() {
        return getImpl().i9();
    }

    public int getCustomSize() {
        return this.f5723co;
    }

    public int getExpandedComponentIdHint() {
        return this.f5729fh.n3();
    }

    @Nullable
    public s getHideMotionSpec() {
        return getImpl().xc();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f5734t;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    @Nullable
    public ColorStateList getRippleColorStateList() {
        return this.f5734t;
    }

    @NonNull
    public hx.f getShapeAppearanceModel() {
        return (hx.f) vl.s.fb(getImpl().z());
    }

    @Nullable
    public s getShowMotionSpec() {
        return getImpl().r();
    }

    public int getSize() {
        return this.f5731p;
    }

    public int getSizeDimension() {
        return f(this.f5731p);
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Nullable
    public ColorStateList getSupportImageTintList() {
        return this.f5733s;
    }

    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f5726f;
    }

    public boolean getUseCompatPadding() {
        return this.f5727f3;
    }

    public void i9(@NonNull Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        w(rect);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().c();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().d0();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().rz();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i5) {
        int sizeDimension = getSizeDimension();
        this.f5737z = (sizeDimension - this.f5732r) / 2;
        getImpl().dm();
        int min = Math.min(mt(sizeDimension, i), mt(sizeDimension, i5));
        Rect rect = this.f5730n;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.y());
        this.f5729fh.gv((Bundle) vl.s.fb(extendableSavedState.f5876fb.get("expandableWidgetHelper")));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
        extendableSavedState.f5876fb.put("expandableWidgetHelper", this.f5729fh.v());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && c5(this.f5722c) && !this.f5722c.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void p() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f5733s;
        if (colorStateList == null) {
            ej.y.zn(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f5726f;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(c5.v(colorForState, mode));
    }

    @Nullable
    public final y.i9 r(@Nullable n3 n3Var) {
        if (n3Var == null) {
            return null;
        }
        return new y(n3Var);
    }

    @NonNull
    public final com.google.android.material.floatingactionbutton.y s() {
        return new np.n3(this, new zn());
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f5735v != colorStateList) {
            this.f5735v = colorStateList;
            getImpl().x(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f5728fb != mode) {
            this.f5728fb = mode;
            getImpl().b(mode);
        }
    }

    public void setCompatElevation(float f4) {
        getImpl().k5(f4);
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f4) {
        getImpl().hw(f4);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f4) {
        getImpl().j(f4);
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(int i) {
        if (i >= 0) {
            if (i != this.f5723co) {
                this.f5723co = i;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        getImpl().ct(f4);
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        if (z2 != getImpl().wz()) {
            getImpl().yt(z2);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i) {
        this.f5729fh.a(i);
    }

    public void setHideMotionSpec(@Nullable s sVar) {
        getImpl().vl(sVar);
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(s.zn(getContext(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().xg();
            if (this.f5733s != null) {
                p();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.f5725d0.fb(i);
        p();
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    @Override // android.view.View
    public void setScaleX(float f4) {
        super.setScaleX(f4);
        getImpl().ej();
    }

    @Override // android.view.View
    public void setScaleY(float f4) {
        super.setScaleY(f4);
        getImpl().ej();
    }

    public void setShadowPaddingEnabled(boolean z2) {
        getImpl().ut(z2);
    }

    @Override // hx.wz
    public void setShapeAppearanceModel(@NonNull hx.f fVar) {
        getImpl().q9(fVar);
    }

    public void setShowMotionSpec(@Nullable s sVar) {
        getImpl().k(sVar);
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(s.zn(getContext(), i));
    }

    public void setSize(int i) {
        this.f5723co = 0;
        if (i != this.f5731p) {
            this.f5731p = i;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        if (this.f5733s != colorStateList) {
            this.f5733s = colorStateList;
            p();
        }
    }

    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f5726f != mode) {
            this.f5726f = mode;
            p();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f4) {
        super.setTranslationX(f4);
        getImpl().ud();
    }

    @Override // android.view.View
    public void setTranslationY(float f4) {
        super.setTranslationY(f4);
        getImpl().ud();
    }

    @Override // android.view.View
    public void setTranslationZ(float f4) {
        super.setTranslationZ(f4);
        getImpl().ud();
    }

    public void setUseCompatPadding(boolean z2) {
        if (this.f5727f3 != z2) {
            this.f5727f3 = z2;
            getImpl().fh();
        }
    }

    @Override // ur.t, android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void t(@Nullable n3 n3Var) {
        tl(n3Var, true);
    }

    public void tl(@Nullable n3 n3Var, boolean z2) {
        getImpl().x4(r(n3Var), z2);
    }

    public void v(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().gv(animatorListener);
    }

    public final void w(@NonNull Rect rect) {
        int i = rect.left;
        Rect rect2 = this.f5730n;
        rect.left = i + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    public boolean wz() {
        return getImpl().f3();
    }

    public boolean xc() {
        return getImpl().n();
    }

    @Override // w3.y
    public boolean y() {
        return this.f5729fh.zn();
    }

    public void z(@Nullable n3 n3Var, boolean z2) {
        getImpl().u(r(n3Var), z2);
    }

    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.zn<T> {

        /* renamed from: n3  reason: collision with root package name */
        public n3 f5738n3;
        public Rect y;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f5739zn;

        public BaseBehavior() {
            this.f5739zn = true;
        }

        private static boolean d(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.a) {
                return ((CoordinatorLayout.a) layoutParams).a() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public final boolean a8(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            CoordinatorLayout.a aVar = (CoordinatorLayout.a) floatingActionButton.getLayoutParams();
            if (!this.f5739zn || aVar.v() != view.getId() || floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            return true;
        }

        public final boolean b(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            if (!a8(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.a) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.tl(this.f5738n3, false);
                return true;
            }
            floatingActionButton.z(this.f5738n3, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        /* renamed from: ej */
        public boolean s(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                x(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (d(view)) {
                b(view, floatingActionButton);
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

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        /* renamed from: ta */
        public boolean n3(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            Rect rect2 = floatingActionButton.f5730n;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        /* renamed from: ud */
        public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i) {
            List<View> mt2 = coordinatorLayout.mt(floatingActionButton);
            int size = mt2.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view = mt2.get(i5);
                if (view instanceof AppBarLayout) {
                    if (x(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (d(view) && b(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.ud(floatingActionButton, i);
            z6(coordinatorLayout, floatingActionButton);
            return true;
        }

        public final boolean x(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull FloatingActionButton floatingActionButton) {
            if (!a8(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.y == null) {
                this.y = new Rect();
            }
            Rect rect = this.y;
            ur.n3.y(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.tl(this.f5738n3, false);
                return true;
            }
            floatingActionButton.z(this.f5738n3, false);
            return true;
        }

        public final void z6(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton) {
            int i;
            Rect rect = floatingActionButton.f5730n;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.a aVar = (CoordinatorLayout.a) floatingActionButton.getLayoutParams();
                int i5 = 0;
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) aVar).rightMargin) {
                    i = rect.right;
                } else if (floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) aVar).leftMargin) {
                    i = -rect.left;
                } else {
                    i = 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin) {
                    i5 = rect.bottom;
                } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) aVar).topMargin) {
                    i5 = -rect.top;
                }
                if (i5 != 0) {
                    i4.xg(floatingActionButton, i5);
                }
                if (i != 0) {
                    i4.y5(floatingActionButton, i);
                }
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ob);
            this.f5739zn = obtainStyledAttributes.getBoolean(R$styleable.vb, true);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public FloatingActionButton(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.FloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f5734t != colorStateList) {
            this.f5734t = colorStateList;
            getImpl().oz(this.f5734t);
        }
    }
}
