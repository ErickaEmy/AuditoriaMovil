package wz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
/* loaded from: classes.dex */
public class xc extends RadioButton {

    /* renamed from: fb  reason: collision with root package name */
    public final z f14840fb;

    /* renamed from: v  reason: collision with root package name */
    public final v f14841v;
    public final s y;

    public xc(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f663z6);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        v vVar = this.f14841v;
        if (vVar != null) {
            vVar.n3();
        }
        z zVar = this.f14840fb;
        if (zVar != null) {
            zVar.n3();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        s sVar = this.y;
        if (sVar != null) {
            return sVar.n3(compoundPaddingLeft);
        }
        return compoundPaddingLeft;
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        v vVar = this.f14841v;
        if (vVar != null) {
            return vVar.zn();
        }
        return null;
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        v vVar = this.f14841v;
        if (vVar != null) {
            return vVar.gv();
        }
        return null;
    }

    @Nullable
    public ColorStateList getSupportButtonTintList() {
        s sVar = this.y;
        if (sVar != null) {
            return sVar.zn();
        }
        return null;
    }

    @Nullable
    public PorterDuff.Mode getSupportButtonTintMode() {
        s sVar = this.y;
        if (sVar != null) {
            return sVar.gv();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        v vVar = this.f14841v;
        if (vVar != null) {
            vVar.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        v vVar = this.f14841v;
        if (vVar != null) {
            vVar.fb(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        s sVar = this.y;
        if (sVar != null) {
            sVar.a();
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        v vVar = this.f14841v;
        if (vVar != null) {
            vVar.c5(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        v vVar = this.f14841v;
        if (vVar != null) {
            vVar.i9(mode);
        }
    }

    public void setSupportButtonTintList(@Nullable ColorStateList colorStateList) {
        s sVar = this.y;
        if (sVar != null) {
            sVar.fb(colorStateList);
        }
    }

    public void setSupportButtonTintMode(@Nullable PorterDuff.Mode mode) {
        s sVar = this.y;
        if (sVar != null) {
            sVar.s(mode);
        }
    }

    public xc(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(k5.n3(context), attributeSet, i);
        x.y(this, getContext());
        s sVar = new s(this);
        this.y = sVar;
        sVar.v(attributeSet, i);
        v vVar = new v(this);
        this.f14841v = vVar;
        vVar.v(attributeSet, i);
        z zVar = new z(this);
        this.f14840fb = zVar;
        zVar.tl(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(c5.y.gv(getContext(), i));
    }
}
