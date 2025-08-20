package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.chip.y;
import hw.i4;
import hx.f;
import hx.wz;
import j5.zn;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import pv.gv;
import ur.i9;
import wz.a;
import y6.s;
/* loaded from: classes.dex */
public class Chip extends a implements y.InterfaceC0059y, wz {

    /* renamed from: c  reason: collision with root package name */
    public int f5546c;

    /* renamed from: co  reason: collision with root package name */
    public boolean f5547co;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f5548d;

    /* renamed from: d0  reason: collision with root package name */
    public int f5549d0;

    /* renamed from: ej  reason: collision with root package name */
    public final RectF f5550ej;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public InsetDrawable f5551f;

    /* renamed from: f3  reason: collision with root package name */
    public boolean f5552f3;
    @NonNull

    /* renamed from: fh  reason: collision with root package name */
    public final zn f5553fh;

    /* renamed from: n  reason: collision with root package name */
    public boolean f5554n;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f5555p;

    /* renamed from: r  reason: collision with root package name */
    public boolean f5556r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public com.google.android.material.chip.y f5557s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public RippleDrawable f5558t;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public View.OnClickListener f5559w;

    /* renamed from: x  reason: collision with root package name */
    public final pv.a f5560x;

    /* renamed from: z  reason: collision with root package name */
    public boolean f5561z;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5542b = R$style.f5110p;

    /* renamed from: j5  reason: collision with root package name */
    public static final Rect f5543j5 = new Rect();

    /* renamed from: qn  reason: collision with root package name */
    public static final int[] f5545qn = {16842913};

    /* renamed from: o  reason: collision with root package name */
    public static final int[] f5544o = {16842911};

    /* loaded from: classes.dex */
    public class n3 extends ViewOutlineProvider {
        public n3() {
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View view, @NonNull Outline outline) {
            if (Chip.this.f5557s != null) {
                Chip.this.f5557s.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class y extends pv.a {
        public y() {
        }

        @Override // pv.a
        public void n3(@NonNull Typeface typeface, boolean z2) {
            CharSequence text;
            Chip chip = Chip.this;
            if (chip.f5557s.gd()) {
                text = Chip.this.f5557s.gf();
            } else {
                text = Chip.this.getText();
            }
            chip.setText(text);
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }

        @Override // pv.a
        public void y(int i) {
        }
    }

    /* loaded from: classes.dex */
    public class zn extends ut.y {
        public zn(Chip chip) {
            super(chip);
        }

        @Override // ut.y
        public boolean a8(int i, int i5, Bundle bundle) {
            if (i5 == 16) {
                if (i == 0) {
                    return Chip.this.performClick();
                }
                if (i == 1) {
                    return Chip.this.z();
                }
                return false;
            }
            return false;
        }

        @Override // ut.y
        public int fh(float f4, float f6) {
            if (Chip.this.wz() && Chip.this.getCloseIconTouchBounds().contains(f4, f6)) {
                return 1;
            }
            return 0;
        }

        @Override // ut.y
        public void k5(@NonNull j5.zn znVar) {
            String str;
            znVar.nf(Chip.this.mt());
            znVar.s8(Chip.this.isClickable());
            if (!Chip.this.mt() && !Chip.this.isClickable()) {
                znVar.e("android.view.View");
            } else {
                if (Chip.this.mt()) {
                    str = "android.widget.CompoundButton";
                } else {
                    str = "android.widget.Button";
                }
                znVar.e(str);
            }
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                znVar.gq(text);
            } else {
                znVar.yc(text);
            }
        }

        @Override // ut.y
        public void rz(@NonNull List<Integer> list) {
            list.add(0);
            if (Chip.this.wz() && Chip.this.co() && Chip.this.f5559w != null) {
                list.add(1);
            }
        }

        @Override // ut.y
        public void vl(int i, boolean z2) {
            if (i == 1) {
                Chip.this.f5552f3 = z2;
                Chip.this.refreshDrawableState();
            }
        }

        @Override // ut.y
        public void yt(int i, @NonNull j5.zn znVar) {
            String str = "";
            if (i == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    znVar.yc(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i5 = R$string.flk;
                    if (!TextUtils.isEmpty(text)) {
                        str = text;
                    }
                    znVar.yc(context.getString(i5, str).trim());
                }
                znVar.eb(Chip.this.getCloseIconTouchBoundsInt());
                znVar.n3(zn.y.f9381c5);
                znVar.rb(Chip.this.isEnabled());
                return;
            }
            znVar.yc("");
            znVar.eb(Chip.f5543j5);
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.js);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public RectF getCloseIconTouchBounds() {
        this.f5550ej.setEmpty();
        if (wz() && this.f5559w != null) {
            this.f5557s.yk(this.f5550ej);
        }
        return this.f5550ej;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f5548d.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f5548d;
    }

    @Nullable
    private gv getTextAppearance() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.bv();
        }
        return null;
    }

    private void setCloseIconHovered(boolean z2) {
        if (this.f5556r != z2) {
            this.f5556r = z2;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z2) {
        if (this.f5561z != z2) {
            this.f5561z = z2;
            refreshDrawableState();
        }
    }

    public final void c() {
        this.f5558t = new RippleDrawable(nr.n3.gv(this.f5557s.wm()), getBackgroundDrawable(), null);
        this.f5557s.cp(false);
        i4.u0(this, this.f5558t);
        d0();
    }

    public final void c5(@NonNull com.google.android.material.chip.y yVar) {
        yVar.xu(this);
    }

    public boolean co() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null && yVar.h()) {
            return true;
        }
        return false;
    }

    public final void d0() {
        com.google.android.material.chip.y yVar;
        if (!TextUtils.isEmpty(getText()) && (yVar = this.f5557s) != null) {
            int qk2 = (int) (yVar.qk() + this.f5557s.fc() + this.f5557s.yg());
            int oa2 = (int) (this.f5557s.oa() + this.f5557s.br() + this.f5557s.ra());
            if (this.f5551f != null) {
                Rect rect = new Rect();
                this.f5551f.getPadding(rect);
                oa2 += rect.left;
                qk2 += rect.right;
            }
            i4.cy(this, oa2, getPaddingTop(), qk2, getPaddingBottom());
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        if (!tl(motionEvent) && !this.f5553fh.x4(motionEvent) && !super.dispatchHoverEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.f5553fh.i4(keyEvent) && this.f5553fh.d0() != Integer.MIN_VALUE) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // wz.a, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        boolean z2;
        super.drawableStateChanged();
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null && yVar.c8()) {
            z2 = this.f5557s.yh(i9());
        } else {
            z2 = false;
        }
        if (z2) {
            invalidate();
        }
    }

    public boolean f(int i) {
        int i5;
        this.f5549d0 = i;
        int i6 = 0;
        if (!x4()) {
            if (this.f5551f != null) {
                r();
            } else {
                n();
            }
            return false;
        }
        int max = Math.max(0, i - this.f5557s.getIntrinsicHeight());
        int max2 = Math.max(0, i - this.f5557s.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            if (this.f5551f != null) {
                r();
            } else {
                n();
            }
            return false;
        }
        if (max2 > 0) {
            i5 = max2 / 2;
        } else {
            i5 = 0;
        }
        if (max > 0) {
            i6 = max / 2;
        }
        if (this.f5551f != null) {
            Rect rect = new Rect();
            this.f5551f.getPadding(rect);
            if (rect.top == i6 && rect.bottom == i6 && rect.left == i5 && rect.right == i5) {
                n();
                return true;
            }
        }
        if (getMinHeight() != i) {
            setMinHeight(i);
        }
        if (getMinWidth() != i) {
            setMinWidth(i);
        }
        p(i5, i6, i5, i6);
        n();
        return true;
    }

    public final void f3() {
        if (wz() && co() && this.f5559w != null) {
            i4.g3(this, this.f5553fh);
        } else {
            i4.g3(this, null);
        }
    }

    public final void fh() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            paint.drawableState = yVar.getState();
        }
        gv textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.i9(getContext(), paint, this.f5560x);
        }
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f5551f;
        if (insetDrawable == null) {
            return this.f5557s;
        }
        return insetDrawable;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.xb();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.wf();
        }
        return null;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.ad();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar == null) {
            return 0.0f;
        }
        return Math.max(0.0f, yVar.cy());
    }

    public Drawable getChipDrawable() {
        return this.f5557s;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.qk();
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getChipIcon() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.qj();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.l();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.gq();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.vp();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.oa();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.w9();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.w2();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Nullable
    public Drawable getCloseIcon() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.x5();
        }
        return null;
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.q5();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.mp();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.le();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.cs();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.ix();
        }
        return null;
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.vn();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@NonNull Rect rect) {
        if (this.f5553fh.d0() != 1 && this.f5553fh.f3() != 1) {
            super.getFocusedRect(rect);
        } else {
            rect.set(getCloseIconTouchBoundsInt());
        }
    }

    @Nullable
    public s getHideMotionSpec() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.j3();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.ne();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.q();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.wm();
        }
        return null;
    }

    @NonNull
    public f getShapeAppearanceModel() {
        return this.f5557s.rz();
    }

    @Nullable
    public s getShowMotionSpec() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.nd();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.fc();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            return yVar.br();
        }
        return 0.0f;
    }

    public final void i4(@Nullable com.google.android.material.chip.y yVar) {
        if (yVar != null) {
            yVar.xu(null);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    @NonNull
    public final int[] i9() {
        ?? isEnabled = isEnabled();
        int i = isEnabled;
        if (this.f5552f3) {
            i = isEnabled + 1;
        }
        int i5 = i;
        if (this.f5556r) {
            i5 = i + 1;
        }
        int i6 = i5;
        if (this.f5561z) {
            i6 = i5 + 1;
        }
        int i8 = i6;
        if (isChecked()) {
            i8 = i6 + 1;
        }
        int[] iArr = new int[i8];
        int i10 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i10 = 1;
        }
        if (this.f5552f3) {
            iArr[i10] = 16842908;
            i10++;
        }
        if (this.f5556r) {
            iArr[i10] = 16843623;
            i10++;
        }
        if (this.f5561z) {
            iArr[i10] = 16842919;
            i10++;
        }
        if (isChecked()) {
            iArr[i10] = 16842913;
        }
        return iArr;
    }

    public boolean mt() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null && yVar.n7()) {
            return true;
        }
        return false;
    }

    public final void n() {
        if (nr.n3.y) {
            c();
            return;
        }
        this.f5557s.cp(true);
        i4.u0(this, getBackgroundDrawable());
        d0();
        t();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        hx.s.a(this, this.f5557s);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f5545qn);
        }
        if (mt()) {
            View.mergeDrawableStates(onCreateDrawableState, f5544o);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z2, int i, Rect rect) {
        super.onFocusChanged(z2, i, rect);
        this.f5553fh.ud(z2, i, rect);
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                setCloseIconHovered(false);
            }
        } else {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        String str;
        int i;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (!mt() && !isClickable()) {
            accessibilityNodeInfo.setClassName("android.view.View");
        } else {
            if (mt()) {
                str = "android.widget.CompoundButton";
            } else {
                str = "android.widget.Button";
            }
            accessibilityNodeInfo.setClassName(str);
        }
        accessibilityNodeInfo.setCheckable(mt());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof mo.y) {
            mo.y yVar = (mo.y) getParent();
            j5.zn w22 = j5.zn.w2(accessibilityNodeInfo);
            if (yVar.zn()) {
                i = yVar.v(this);
            } else {
                i = -1;
            }
            w22.yg(zn.fb.y(yVar.n3(this), 1, i, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @Nullable
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@NonNull MotionEvent motionEvent, int i) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.f5546c != i) {
            this.f5546c = i;
            d0();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r0 != 3) goto L17;
     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L3a
            if (r0 == r2) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L35
            goto L40
        L21:
            boolean r0 = r5.f5561z
            if (r0 == 0) goto L40
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r3)
        L2a:
            r0 = 1
            goto L41
        L2c:
            boolean r0 = r5.f5561z
            if (r0 == 0) goto L35
            r5.z()
            r0 = 1
            goto L36
        L35:
            r0 = 0
        L36:
            r5.setCloseIconPressed(r3)
            goto L41
        L3a:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r2)
            goto L2a
        L40:
            r0 = 0
        L41:
            if (r0 != 0) goto L4b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L4a
            goto L4b
        L4a:
            r2 = 0
        L4b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(int i, int i5, int i6, int i8) {
        this.f5551f = new InsetDrawable((Drawable) this.f5557s, i, i5, i6, i8);
    }

    public final void r() {
        if (this.f5551f != null) {
            this.f5551f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            n();
        }
    }

    public final void rz(@Nullable AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null) {
                if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null) {
                    if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null) {
                        if (attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1) {
                            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                                Log.w("Chip", "Chip text must be vertically center and start aligned");
                                return;
                            }
                            return;
                        }
                        throw new UnsupportedOperationException("Chip does not support multi-line text");
                    }
                    throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
                }
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable != getBackgroundDrawable() && drawable != this.f5558t) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        } else {
            super.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // wz.a, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != getBackgroundDrawable() && drawable != this.f5558t) {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        } else {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // wz.a, android.view.View
    public void setBackgroundResource(int i) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z2) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.ic(z2);
        }
    }

    public void setCheckableResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.gn(i);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar == null) {
            this.f5547co = z2;
        } else if (yVar.n7()) {
            boolean isChecked = isChecked();
            super.setChecked(z2);
            if (isChecked != z2 && (onCheckedChangeListener = this.f5555p) != null) {
                onCheckedChangeListener.onCheckedChanged(this, z2);
            }
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.vc(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z2) {
        setCheckedIconVisible(z2);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.p1(i);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.i(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.rv(i);
        }
    }

    public void setCheckedIconVisible(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.dp(i);
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.cx(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.vh(i);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f4) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.hy(f4);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.xq(i);
        }
    }

    public void setChipDrawable(@NonNull com.google.android.material.chip.y yVar) {
        com.google.android.material.chip.y yVar2 = this.f5557s;
        if (yVar2 != yVar) {
            i4(yVar2);
            this.f5557s = yVar;
            yVar.p2(false);
            c5(this.f5557s);
            f(this.f5549d0);
        }
    }

    public void setChipEndPadding(float f4) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.jt(f4);
        }
    }

    public void setChipEndPaddingResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.jb(i);
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.sw(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z2) {
        setChipIconVisible(z2);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.v1(i);
        }
    }

    public void setChipIconSize(float f4) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.gi(f4);
        }
    }

    public void setChipIconSizeResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.zx(i);
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.l0(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.wo(i);
        }
    }

    public void setChipIconVisible(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.zh(i);
        }
    }

    public void setChipMinHeight(float f4) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.ob(f4);
        }
    }

    public void setChipMinHeightResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.vb(i);
        }
    }

    public void setChipStartPadding(float f4) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.fq(f4);
        }
    }

    public void setChipStartPaddingResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.sx(i);
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.ux(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.vd(i);
        }
    }

    public void setChipStrokeWidth(float f4) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.t5(f4);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.rt(i);
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.fp(drawable);
        }
        f3();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.hj(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z2) {
        setCloseIconVisible(z2);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f4) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.sh(f4);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.hf(i);
        }
    }

    public void setCloseIconResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.w7(i);
        }
        f3();
    }

    public void setCloseIconSize(float f4) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.ou(f4);
        }
    }

    public void setCloseIconSizeResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.vi(i);
        }
    }

    public void setCloseIconStartPadding(float f4) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.l3(f4);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.e5(i);
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.nh(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.i1(i);
        }
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 == null) {
                super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
                return;
            }
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 == null) {
                super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
                return;
            }
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i5, int i6, int i8) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i6 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i5, i6, i8);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i5, int i6, int i8) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i6 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i, i5, i6, i8);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.q9(f4);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f5557s == null) {
            return;
        }
        if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
            super.setEllipsize(truncateAt);
            com.google.android.material.chip.y yVar = this.f5557s;
            if (yVar != null) {
                yVar.z8(truncateAt);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        this.f5554n = z2;
        f(this.f5549d0);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    public void setHideMotionSpec(@Nullable s sVar) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.ih(sVar);
        }
    }

    public void setHideMotionSpecResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.jm(i);
        }
    }

    public void setIconEndPadding(float f4) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.mq(f4);
        }
    }

    public void setIconEndPaddingResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.x0(i);
        }
    }

    public void setIconStartPadding(float f4) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.mc(f4);
        }
    }

    public void setIconStartPaddingResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.ez(i);
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        if (this.f5557s == null) {
            return;
        }
        super.setLayoutDirection(i);
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i <= 1) {
            super.setLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i <= 1) {
            super.setMaxLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.wb(i);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i <= 1) {
            super.setMinLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f5555p = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f5559w = onClickListener;
        f3();
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.j4(colorStateList);
        }
        if (!this.f5557s.im()) {
            c();
        }
    }

    public void setRippleColorResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.t7(i);
            if (!this.f5557s.im()) {
                c();
            }
        }
    }

    @Override // hx.wz
    public void setShapeAppearanceModel(@NonNull f fVar) {
        this.f5557s.setShapeAppearanceModel(fVar);
    }

    public void setShowMotionSpec(@Nullable s sVar) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.iu(sVar);
        }
    }

    public void setShowMotionSpecResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.cw(i);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z2) {
        if (z2) {
            super.setSingleLine(z2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        CharSequence charSequence2;
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        if (yVar.gd()) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        super.setText(charSequence2, bufferType);
        com.google.android.material.chip.y yVar2 = this.f5557s;
        if (yVar2 != null) {
            yVar2.nz(charSequence);
        }
    }

    public void setTextAppearance(@Nullable gv gvVar) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.l8(gvVar);
        }
        fh();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f4) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.wv(f4);
        }
    }

    public void setTextEndPaddingResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.rk(i);
        }
    }

    public void setTextStartPadding(float f4) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.bx(f4);
        }
    }

    public void setTextStartPaddingResource(int i) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.ja(i);
        }
    }

    public final void t() {
        if (getBackgroundDrawable() == this.f5551f && this.f5557s.getCallback() == null) {
            this.f5557s.setCallback(this.f5551f);
        }
    }

    @SuppressLint({"PrivateApi"})
    public final boolean tl(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = ut.y.class.getDeclaredField("tl");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.f5553fh)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = ut.y.class.getDeclaredMethod("ut", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.f5553fh, Integer.MIN_VALUE);
                    return true;
                }
            } catch (IllegalAccessException e2) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e2);
            } catch (NoSuchFieldException e3) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e3);
            } catch (NoSuchMethodException e5) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e5);
            } catch (InvocationTargetException e6) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e6);
            }
        }
        return false;
    }

    public final void w() {
        setOutlineProvider(new n3());
    }

    public final boolean wz() {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null && yVar.x5() != null) {
            return true;
        }
        return false;
    }

    public boolean x4() {
        return this.f5554n;
    }

    public final void xc(Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray s2 = i9.s(context, attributeSet, R$styleable.f5231nf, i, f5542b, new int[0]);
        this.f5554n = s2.getBoolean(R$styleable.f5254q5, false);
        this.f5549d0 = (int) Math.ceil(s2.getDimension(R$styleable.f5301wf, (float) Math.ceil(ur.f.n3(getContext(), 48))));
        s2.recycle();
    }

    @Override // com.google.android.material.chip.y.InterfaceC0059y
    public void y() {
        f(this.f5549d0);
        requestLayout();
        invalidateOutline();
    }

    public boolean z() {
        boolean z2 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f5559w;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z2 = true;
        }
        this.f5553fh.oz(1, 1);
        return z2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Chip(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.chip.Chip.f5542b
            android.content.Context r8 = c0.y.zn(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            r7.f5548d = r8
            android.graphics.RectF r8 = new android.graphics.RectF
            r8.<init>()
            r7.f5550ej = r8
            com.google.android.material.chip.Chip$y r8 = new com.google.android.material.chip.Chip$y
            r8.<init>()
            r7.f5560x = r8
            android.content.Context r8 = r7.getContext()
            r7.rz(r9)
            com.google.android.material.chip.y r6 = com.google.android.material.chip.y.m(r8, r9, r10, r4)
            r7.xc(r8, r9, r10)
            r7.setChipDrawable(r6)
            float r0 = hw.i4.n(r7)
            r6.q9(r0)
            int[] r2 = com.google.android.material.R$styleable.f5231nf
            r0 = 0
            int[] r5 = new int[r0]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = ur.i9.s(r0, r1, r2, r3, r4, r5)
            int r10 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            if (r10 >= r0) goto L51
            int r10 = com.google.android.material.R$styleable.f5271s8
            android.content.res.ColorStateList r8 = pv.zn.y(r8, r9, r10)
            r7.setTextColor(r8)
        L51:
            int r8 = com.google.android.material.R$styleable.f5190ix
            boolean r8 = r9.hasValue(r8)
            r9.recycle()
            com.google.android.material.chip.Chip$zn r9 = new com.google.android.material.chip.Chip$zn
            r9.<init>(r7)
            r7.f5553fh = r9
            r7.f3()
            if (r8 != 0) goto L69
            r7.w()
        L69:
            boolean r8 = r7.f5547co
            r7.setChecked(r8)
            java.lang.CharSequence r8 = r6.gf()
            r7.setText(r8)
            android.text.TextUtils$TruncateAt r8 = r6.vn()
            r7.setEllipsize(r8)
            r7.fh()
            com.google.android.material.chip.y r8 = r7.f5557s
            boolean r8 = r8.gd()
            if (r8 != 0) goto L8e
            r8 = 1
            r7.setLines(r8)
            r7.setHorizontallyScrolling(r8)
        L8e:
            r8 = 8388627(0x800013, float:1.175497E-38)
            r7.setGravity(r8)
            r7.d0()
            boolean r8 = r7.x4()
            if (r8 == 0) goto La2
            int r8 = r7.f5549d0
            r7.setMinHeight(r8)
        La2:
            int r8 = hw.i4.ta(r7)
            r7.f5546c = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCloseIconVisible(boolean z2) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.eu(z2);
        }
        f3();
    }

    public void setCheckedIconVisible(boolean z2) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.hr(z2);
        }
    }

    public void setChipIconVisible(boolean z2) {
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.hb(z2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.xh(i);
        }
        fh();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        com.google.android.material.chip.y yVar = this.f5557s;
        if (yVar != null) {
            yVar.xh(i);
        }
        fh();
    }
}
