package wz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class x4 extends ToggleButton {

    /* renamed from: v  reason: collision with root package name */
    public final z f14839v;
    public final v y;

    public x4(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        v vVar = this.y;
        if (vVar != null) {
            vVar.n3();
        }
        z zVar = this.f14839v;
        if (zVar != null) {
            zVar.n3();
        }
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

    @Override // android.widget.ToggleButton, android.view.View
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

    public x4(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        x.y(this, getContext());
        v vVar = new v(this);
        this.y = vVar;
        vVar.v(attributeSet, i);
        z zVar = new z(this);
        this.f14839v = zVar;
        zVar.tl(attributeSet, i);
    }
}
