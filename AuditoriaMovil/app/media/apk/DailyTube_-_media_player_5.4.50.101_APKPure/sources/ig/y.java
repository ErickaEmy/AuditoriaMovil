package ig;

import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import hx.f;
import hx.wz;
/* loaded from: classes.dex */
public class y extends CardView implements Checkable, wz {

    /* renamed from: f3  reason: collision with root package name */
    public boolean f9305f3;

    /* renamed from: r  reason: collision with root package name */
    public boolean f9306r;

    /* renamed from: z  reason: collision with root package name */
    public boolean f9307z;

    /* renamed from: n  reason: collision with root package name */
    public static final int[] f9304n = {16842911};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f9301c = {16842912};

    /* renamed from: d0  reason: collision with root package name */
    public static final int[] f9302d0 = {R$attr.fhb};

    /* renamed from: fh  reason: collision with root package name */
    public static final int f9303fh = R$style.f5112xc;

    /* renamed from: ig.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0123y {
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        new RectF();
        throw null;
    }

    public boolean a() {
        return false;
    }

    public boolean fb() {
        return this.f9305f3;
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        throw null;
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        throw null;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        throw null;
    }

    public int getCheckedIconMargin() {
        throw null;
    }

    public int getCheckedIconSize() {
        throw null;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        throw null;
    }

    public float getProgress() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        throw null;
    }

    public ColorStateList getRippleColor() {
        throw null;
    }

    @NonNull
    public f getShapeAppearanceModel() {
        throw null;
    }

    @Deprecated
    public int getStrokeColor() {
        throw null;
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        throw null;
    }

    public int getStrokeWidth() {
        throw null;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f9306r;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 3);
        if (a()) {
            View.mergeDrawableStates(onCreateDrawableState, f9304n);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f9301c);
        }
        if (fb()) {
            View.mergeDrawableStates(onCreateDrawableState, f9302d0);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i5) {
        super.onMeasure(i, i5);
        getMeasuredWidth();
        getMeasuredHeight();
        throw null;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!this.f9307z) {
            return;
        }
        throw null;
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i) {
        ColorStateList.valueOf(i);
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f4) {
        super.setCardElevation(f4);
        throw null;
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        throw null;
    }

    public void setCheckable(boolean z2) {
        throw null;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (this.f9306r != z2) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        throw null;
    }

    public void setCheckedIconMargin(int i) {
        throw null;
    }

    public void setCheckedIconMarginResource(int i) {
        if (i == -1) {
            return;
        }
        getResources().getDimensionPixelSize(i);
        throw null;
    }

    public void setCheckedIconResource(int i) {
        c5.y.gv(getContext(), i);
        throw null;
    }

    public void setCheckedIconSize(int i) {
        throw null;
    }

    public void setCheckedIconSizeResource(int i) {
        if (i == 0) {
            return;
        }
        getResources().getDimensionPixelSize(i);
        throw null;
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        throw null;
    }

    @Override // android.view.View
    public void setClickable(boolean z2) {
        super.setClickable(z2);
    }

    public void setDragged(boolean z2) {
        if (this.f9305f3 != z2) {
            this.f9305f3 = z2;
            refreshDrawableState();
            v();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f4) {
        super.setMaxCardElevation(f4);
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z2) {
        super.setPreventCornerOverlap(z2);
        throw null;
    }

    public void setProgress(float f4) {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f4) {
        super.setRadius(f4);
        throw null;
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        throw null;
    }

    public void setRippleColorResource(int i) {
        c5.y.zn(getContext(), i);
        throw null;
    }

    @Override // hx.wz
    public void setShapeAppearanceModel(@NonNull f fVar) {
        setClipToOutline(fVar.r(getBoundsAsRectF()));
        throw null;
    }

    public void setStrokeColor(int i) {
        ColorStateList.valueOf(i);
        throw null;
    }

    public void setStrokeWidth(int i) {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z2) {
        super.setUseCompatPadding(z2);
        throw null;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (a() && isEnabled()) {
            this.f9306r = !this.f9306r;
            refreshDrawableState();
            v();
        }
    }

    public final void v() {
        if (Build.VERSION.SDK_INT <= 26) {
            return;
        }
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        throw null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setOnCheckedChangeListener(@Nullable InterfaceC0123y interfaceC0123y) {
    }
}
