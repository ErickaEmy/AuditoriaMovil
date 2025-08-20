package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import hw.i4;
import hx.f;
import hx.s;
import hx.wz;
import j.tl;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, wz {

    /* renamed from: c  reason: collision with root package name */
    public boolean f5512c;

    /* renamed from: co  reason: collision with root package name */
    public int f5513co;

    /* renamed from: d0  reason: collision with root package name */
    public int f5514d0;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public n3 f5515f;

    /* renamed from: f3  reason: collision with root package name */
    public int f5516f3;
    @NonNull

    /* renamed from: fb  reason: collision with root package name */
    public final ao.y f5517fb;

    /* renamed from: n  reason: collision with root package name */
    public boolean f5518n;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public Drawable f5519p;

    /* renamed from: r  reason: collision with root package name */
    public int f5520r;
    @NonNull

    /* renamed from: s  reason: collision with root package name */
    public final LinkedHashSet<y> f5521s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public PorterDuff.Mode f5522t;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public ColorStateList f5523w;

    /* renamed from: z  reason: collision with root package name */
    public int f5524z;

    /* renamed from: fh  reason: collision with root package name */
    public static final int[] f5511fh = {16842911};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f5509d = {16842912};

    /* renamed from: ej  reason: collision with root package name */
    public static final int f5510ej = R$style.oj;

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        /* renamed from: fb  reason: collision with root package name */
        public boolean f5525fb;

        /* loaded from: classes.dex */
        public static class y implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: n3 */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public final void n3(@NonNull Parcel parcel) {
            boolean z2 = true;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.f5525fb = z2;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5525fb ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            n3(parcel);
        }
    }

    /* loaded from: classes.dex */
    public interface n3 {
        void y(MaterialButton materialButton, boolean z2);
    }

    /* loaded from: classes.dex */
    public interface y {
        void y(MaterialButton materialButton, boolean z2);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.frd);
    }

    @NonNull
    private String getA11yClassName() {
        Class cls;
        if (n3()) {
            cls = CompoundButton.class;
        } else {
            cls = Button.class;
        }
        return cls.getName();
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    public final boolean a() {
        if (i4.ta(this) == 1) {
            return true;
        }
        return false;
    }

    public final void c5() {
        if (gv()) {
            tl.i9(this, this.f5519p, null, null, null);
        } else if (zn()) {
            tl.i9(this, null, null, this.f5519p, null);
        } else if (v()) {
            tl.i9(this, null, this.f5519p, null, null);
        }
    }

    public final void f(int i, int i5) {
        if (this.f5519p != null && getLayout() != null) {
            if (!gv() && !zn()) {
                if (v()) {
                    this.f5524z = 0;
                    if (this.f5514d0 == 16) {
                        this.f5520r = 0;
                        i9(false);
                        return;
                    }
                    int i6 = this.f5513co;
                    if (i6 == 0) {
                        i6 = this.f5519p.getIntrinsicHeight();
                    }
                    int textHeight = (((((i5 - getTextHeight()) - getPaddingTop()) - i6) - this.f5516f3) - getPaddingBottom()) / 2;
                    if (this.f5520r != textHeight) {
                        this.f5520r = textHeight;
                        i9(false);
                        return;
                    }
                    return;
                }
                return;
            }
            this.f5520r = 0;
            int i8 = this.f5514d0;
            boolean z2 = true;
            if (i8 != 1 && i8 != 3) {
                int i10 = this.f5513co;
                if (i10 == 0) {
                    i10 = this.f5519p.getIntrinsicWidth();
                }
                int textWidth = (((((i - getTextWidth()) - i4.ud(this)) - i10) - this.f5516f3) - i4.a8(this)) / 2;
                boolean a2 = a();
                if (this.f5514d0 != 4) {
                    z2 = false;
                }
                if (a2 != z2) {
                    textWidth = -textWidth;
                }
                if (this.f5524z != textWidth) {
                    this.f5524z = textWidth;
                    i9(false);
                    return;
                }
                return;
            }
            this.f5524z = 0;
            i9(false);
        }
    }

    public final boolean fb() {
        ao.y yVar = this.f5517fb;
        if (yVar != null && !yVar.xc()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (fb()) {
            return this.f5517fb.n3();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f5519p;
    }

    public int getIconGravity() {
        return this.f5514d0;
    }

    public int getIconPadding() {
        return this.f5516f3;
    }

    public int getIconSize() {
        return this.f5513co;
    }

    public ColorStateList getIconTint() {
        return this.f5523w;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f5522t;
    }

    public int getInsetBottom() {
        return this.f5517fb.zn();
    }

    public int getInsetTop() {
        return this.f5517fb.gv();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (fb()) {
            return this.f5517fb.s();
        }
        return null;
    }

    @NonNull
    public f getShapeAppearanceModel() {
        if (fb()) {
            return this.f5517fb.c5();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (fb()) {
            return this.f5517fb.i9();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (fb()) {
            return this.f5517fb.f();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        if (fb()) {
            return this.f5517fb.t();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (fb()) {
            return this.f5517fb.tl();
        }
        return super.getSupportBackgroundTintMode();
    }

    public final boolean gv() {
        int i = this.f5514d0;
        if (i == 1 || i == 2) {
            return true;
        }
        return false;
    }

    public final void i9(boolean z2) {
        Drawable drawable = this.f5519p;
        if (drawable != null) {
            Drawable mutate = ej.y.mt(drawable).mutate();
            this.f5519p = mutate;
            ej.y.xc(mutate, this.f5523w);
            PorterDuff.Mode mode = this.f5522t;
            if (mode != null) {
                ej.y.w(this.f5519p, mode);
            }
            int i = this.f5513co;
            if (i == 0) {
                i = this.f5519p.getIntrinsicWidth();
            }
            int i5 = this.f5513co;
            if (i5 == 0) {
                i5 = this.f5519p.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f5519p;
            int i6 = this.f5524z;
            int i8 = this.f5520r;
            drawable2.setBounds(i6, i8, i + i6, i5 + i8);
        }
        if (z2) {
            c5();
            return;
        }
        Drawable[] y2 = tl.y(this);
        Drawable drawable3 = y2[0];
        Drawable drawable4 = y2[1];
        Drawable drawable5 = y2[2];
        if ((gv() && drawable3 != this.f5519p) || ((zn() && drawable5 != this.f5519p) || (v() && drawable4 != this.f5519p))) {
            c5();
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f5518n;
    }

    public boolean n3() {
        ao.y yVar = this.f5517fb;
        if (yVar != null && yVar.w()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (fb()) {
            s.a(this, this.f5517fb.a());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (n3()) {
            View.mergeDrawableStates(onCreateDrawableState, f5511fh);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f5509d);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(n3());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        ao.y yVar;
        super.onLayout(z2, i, i5, i6, i8);
        if (Build.VERSION.SDK_INT == 21 && (yVar = this.f5517fb) != null) {
            yVar.ej(i8 - i5, i6 - i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.y());
        setChecked(savedState.f5525fb);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5525fb = this.f5518n;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i5, int i6, int i8) {
        super.onSizeChanged(i, i5, i6, i8);
        f(i, i5);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i5, int i6) {
        super.onTextChanged(charSequence, i, i5, i6);
        f(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void s(@NonNull y yVar) {
        this.f5521s.remove(yVar);
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (fb()) {
            this.f5517fb.mt(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (fb()) {
            if (drawable != getBackground()) {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                this.f5517fb.co();
                super.setBackgroundDrawable(drawable);
                return;
            }
            getBackground().setState(drawable.getState());
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i) {
        Drawable drawable;
        if (i != 0) {
            drawable = c5.y.gv(getContext(), i);
        } else {
            drawable = null;
        }
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z2) {
        if (fb()) {
            this.f5517fb.z(z2);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (n3() && isEnabled() && this.f5518n != z2) {
            this.f5518n = z2;
            refreshDrawableState();
            if (this.f5512c) {
                return;
            }
            this.f5512c = true;
            Iterator<y> it = this.f5521s.iterator();
            while (it.hasNext()) {
                it.next().y(this, this.f5518n);
            }
            this.f5512c = false;
        }
    }

    public void setCornerRadius(int i) {
        if (fb()) {
            this.f5517fb.r(i);
        }
    }

    public void setCornerRadiusResource(int i) {
        if (fb()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        if (fb()) {
            this.f5517fb.a().q9(f4);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.f5519p != drawable) {
            this.f5519p = drawable;
            i9(true);
            f(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i) {
        if (this.f5514d0 != i) {
            this.f5514d0 = i;
            f(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i) {
        if (this.f5516f3 != i) {
            this.f5516f3 = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        Drawable drawable;
        if (i != 0) {
            drawable = c5.y.gv(getContext(), i);
        } else {
            drawable = null;
        }
        setIcon(drawable);
    }

    public void setIconSize(int i) {
        if (i >= 0) {
            if (this.f5513co != i) {
                this.f5513co = i;
                i9(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f5523w != colorStateList) {
            this.f5523w = colorStateList;
            i9(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f5522t != mode) {
            this.f5522t = mode;
            i9(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(c5.y.zn(getContext(), i));
    }

    public void setInsetBottom(int i) {
        this.f5517fb.x4(i);
    }

    public void setInsetTop(int i) {
        this.f5517fb.i4(i);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(@Nullable n3 n3Var) {
        this.f5515f = n3Var;
    }

    @Override // android.view.View
    public void setPressed(boolean z2) {
        n3 n3Var = this.f5515f;
        if (n3Var != null) {
            n3Var.y(this, z2);
        }
        super.setPressed(z2);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (fb()) {
            this.f5517fb.f3(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        if (fb()) {
            setRippleColor(c5.y.zn(getContext(), i));
        }
    }

    @Override // hx.wz
    public void setShapeAppearanceModel(@NonNull f fVar) {
        if (fb()) {
            this.f5517fb.n(fVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean z2) {
        if (fb()) {
            this.f5517fb.c(z2);
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (fb()) {
            this.f5517fb.d0(colorStateList);
        }
    }

    public void setStrokeColorResource(int i) {
        if (fb()) {
            setStrokeColor(c5.y.zn(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (fb()) {
            this.f5517fb.fh(i);
        }
    }

    public void setStrokeWidthResource(int i) {
        if (fb()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (fb()) {
            this.f5517fb.rz(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (fb()) {
            this.f5517fb.mg(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f5518n);
    }

    public final boolean v() {
        int i = this.f5514d0;
        if (i != 16 && i != 32) {
            return false;
        }
        return true;
    }

    public void y(@NonNull y yVar) {
        this.f5521s.add(yVar);
    }

    public final boolean zn() {
        int i = this.f5514d0;
        if (i != 3 && i != 4) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialButton(@androidx.annotation.NonNull android.content.Context r9, @androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r6 = com.google.android.material.button.MaterialButton.f5510ej
            android.content.Context r9 = c0.y.zn(r9, r10, r11, r6)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.f5521s = r9
            r9 = 0
            r8.f5518n = r9
            r8.f5512c = r9
            android.content.Context r7 = r8.getContext()
            int[] r2 = com.google.android.material.R$styleable.x0
            int[] r5 = new int[r9]
            r0 = r7
            r1 = r10
            r3 = r11
            r4 = r6
            android.content.res.TypedArray r0 = ur.i9.s(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R$styleable.rk
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f5516f3 = r1
            int r1 = com.google.android.material.R$styleable.cp
            r2 = -1
            int r1 = r0.getInt(r1, r2)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = ur.f.v(r1, r2)
            r8.f5522t = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R$styleable.ja
            android.content.res.ColorStateList r1 = pv.zn.y(r1, r0, r2)
            r8.f5523w = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R$styleable.xh
            android.graphics.drawable.Drawable r1 = pv.zn.gv(r1, r0, r2)
            r8.f5519p = r1
            int r1 = com.google.android.material.R$styleable.wv
            r2 = 1
            int r1 = r0.getInteger(r1, r2)
            r8.f5514d0 = r1
            int r1 = com.google.android.material.R$styleable.bx
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f5513co = r1
            hx.f$n3 r10 = hx.f.v(r7, r10, r11, r6)
            hx.f r10 = r10.tl()
            ao.y r11 = new ao.y
            r11.<init>(r8, r10)
            r8.f5517fb = r11
            r11.p(r0)
            r0.recycle()
            int r10 = r8.f5516f3
            r8.setCompoundDrawablePadding(r10)
            android.graphics.drawable.Drawable r10 = r8.f5519p
            if (r10 == 0) goto L84
            r9 = 1
        L84:
            r8.i9(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
