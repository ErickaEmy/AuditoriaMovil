package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import j.tl;
import j.xc;
import wz.k5;
import wz.v;
import wz.x;
import wz.z;
/* loaded from: classes.dex */
public class AppCompatButton extends Button implements j.n3, xc {

    /* renamed from: v  reason: collision with root package name */
    public final z f1304v;
    public final v y;

    public AppCompatButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f646p);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        v vVar = this.y;
        if (vVar != null) {
            vVar.n3();
        }
        z zVar = this.f1304v;
        if (zVar != null) {
            zVar.n3();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (j.n3.f9315wz) {
            return super.getAutoSizeMaxTextSize();
        }
        z zVar = this.f1304v;
        if (zVar != null) {
            return zVar.v();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (j.n3.f9315wz) {
            return super.getAutoSizeMinTextSize();
        }
        z zVar = this.f1304v;
        if (zVar != null) {
            return zVar.a();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (j.n3.f9315wz) {
            return super.getAutoSizeStepGranularity();
        }
        z zVar = this.f1304v;
        if (zVar != null) {
            return zVar.fb();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (j.n3.f9315wz) {
            return super.getAutoSizeTextAvailableSizes();
        }
        z zVar = this.f1304v;
        if (zVar != null) {
            return zVar.s();
        }
        return new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (j.n3.f9315wz) {
            if (super.getAutoSizeTextType() != 1) {
                return 0;
            }
            return 1;
        }
        z zVar = this.f1304v;
        if (zVar == null) {
            return 0;
        }
        return zVar.c5();
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        v vVar = this.y;
        if (vVar != null) {
            return vVar.zn();
        }
        return null;
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        v vVar = this.y;
        if (vVar != null) {
            return vVar.gv();
        }
        return null;
    }

    @Nullable
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1304v.i9();
    }

    @Nullable
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1304v.f();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        super.onLayout(z2, i, i5, i6, i8);
        z zVar = this.f1304v;
        if (zVar != null) {
            zVar.xc(z2, i, i5, i6, i8);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i5, int i6) {
        super.onTextChanged(charSequence, i, i5, i6);
        z zVar = this.f1304v;
        if (zVar != null && !j.n3.f9315wz && zVar.t()) {
            this.f1304v.zn();
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i5, int i6, int i8) throws IllegalArgumentException {
        if (j.n3.f9315wz) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i5, i6, i8);
            return;
        }
        z zVar = this.f1304v;
        if (zVar != null) {
            zVar.z(i, i5, i6, i8);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i) throws IllegalArgumentException {
        if (j.n3.f9315wz) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        z zVar = this.f1304v;
        if (zVar != null) {
            zVar.r(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (j.n3.f9315wz) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        z zVar = this.f1304v;
        if (zVar != null) {
            zVar.x4(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        v vVar = this.y;
        if (vVar != null) {
            vVar.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        v vVar = this.y;
        if (vVar != null) {
            vVar.fb(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(tl.p(this, callback));
    }

    public void setSupportAllCaps(boolean z2) {
        z zVar = this.f1304v;
        if (zVar != null) {
            zVar.co(z2);
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        v vVar = this.y;
        if (vVar != null) {
            vVar.c5(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        v vVar = this.y;
        if (vVar != null) {
            vVar.i9(mode);
        }
    }

    @Override // j.xc
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        this.f1304v.i4(colorStateList);
        this.f1304v.n3();
    }

    @Override // j.xc
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        this.f1304v.f3(mode);
        this.f1304v.n3();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        z zVar = this.f1304v;
        if (zVar != null) {
            zVar.p(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f4) {
        if (j.n3.f9315wz) {
            super.setTextSize(i, f4);
            return;
        }
        z zVar = this.f1304v;
        if (zVar != null) {
            zVar.d0(i, f4);
        }
    }

    public AppCompatButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(k5.n3(context), attributeSet, i);
        x.y(this, getContext());
        v vVar = new v(this);
        this.y = vVar;
        vVar.v(attributeSet, i);
        z zVar = new z(this);
        this.f1304v = zVar;
        zVar.tl(attributeSet, i);
        zVar.n3();
    }
}
