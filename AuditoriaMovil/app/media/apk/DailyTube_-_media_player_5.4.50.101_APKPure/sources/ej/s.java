package ej;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class s extends Drawable implements Drawable.Callback, fb, a {

    /* renamed from: w  reason: collision with root package name */
    public static final PorterDuff.Mode f7612w = PorterDuff.Mode.SRC_IN;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7613f;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f7614fb;

    /* renamed from: s  reason: collision with root package name */
    public i9 f7615s;

    /* renamed from: t  reason: collision with root package name */
    public Drawable f7616t;

    /* renamed from: v  reason: collision with root package name */
    public PorterDuff.Mode f7617v;
    public int y;

    public s(@NonNull i9 i9Var, @Nullable Resources resources) {
        this.f7615s = i9Var;
        v(resources);
    }

    public final boolean a(int[] iArr) {
        if (!zn()) {
            return false;
        }
        i9 i9Var = this.f7615s;
        ColorStateList colorStateList = i9Var.f7611zn;
        PorterDuff.Mode mode = i9Var.f7609gv;
        if (colorStateList != null && mode != null) {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f7614fb || colorForState != this.y || mode != this.f7617v) {
                setColorFilter(colorForState, mode);
                this.y = colorForState;
                this.f7617v = mode;
                this.f7614fb = true;
                return true;
            }
        } else {
            this.f7614fb = false;
            clearColorFilter();
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f7616t.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int i;
        int changingConfigurations = super.getChangingConfigurations();
        i9 i9Var = this.f7615s;
        if (i9Var != null) {
            i = i9Var.getChangingConfigurations();
        } else {
            i = 0;
        }
        return changingConfigurations | i | this.f7616t.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        i9 i9Var = this.f7615s;
        if (i9Var != null && i9Var.y()) {
            this.f7615s.y = getChangingConfigurations();
            return this.f7615s;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.f7616t.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f7616t.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f7616t.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return y.a(this.f7616t);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f7616t.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f7616t.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f7616t.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        return this.f7616t.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public int[] getState() {
        return this.f7616t.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f7616t.getTransparentRegion();
    }

    @NonNull
    public final i9 gv() {
        return new i9(this.f7615s);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return y.s(this.f7616t);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        i9 i9Var;
        if (zn() && (i9Var = this.f7615s) != null) {
            colorStateList = i9Var.f7611zn;
        } else {
            colorStateList = null;
        }
        if ((colorStateList != null && colorStateList.isStateful()) || this.f7616t.isStateful()) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f7616t.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        Drawable.ConstantState constantState;
        if (!this.f7613f && super.mutate() == this) {
            this.f7615s = gv();
            Drawable drawable = this.f7616t;
            if (drawable != null) {
                drawable.mutate();
            }
            i9 i9Var = this.f7615s;
            if (i9Var != null) {
                Drawable drawable2 = this.f7616t;
                if (drawable2 != null) {
                    constantState = drawable2.getConstantState();
                } else {
                    constantState = null;
                }
                i9Var.f7610n3 = constantState;
            }
            this.f7613f = true;
        }
        return this;
    }

    @Override // ej.fb
    public final void n3(Drawable drawable) {
        Drawable drawable2 = this.f7616t;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f7616t = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            i9 i9Var = this.f7615s;
            if (i9Var != null) {
                i9Var.f7610n3 = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f7616t;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return y.tl(this.f7616t, i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        return this.f7616t.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f7616t.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        y.i9(this.f7616t, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f7616t.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f7616t.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.f7616t.setDither(z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.f7616t.setFilterBitmap(z2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(@NonNull int[] iArr) {
        boolean state = this.f7616t.setState(iArr);
        if (!a(iArr) && !state) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f7615s.f7611zn = colorStateList;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        this.f7615s.f7609gv = mode;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        if (!super.setVisible(z2, z3) && !this.f7616t.setVisible(z2, z3)) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public final void v(@Nullable Resources resources) {
        Drawable.ConstantState constantState;
        i9 i9Var = this.f7615s;
        if (i9Var != null && (constantState = i9Var.f7610n3) != null) {
            n3(constantState.newDrawable(resources));
        }
    }

    @Override // ej.fb
    public final Drawable y() {
        return this.f7616t;
    }

    public boolean zn() {
        throw null;
    }

    public s(@Nullable Drawable drawable) {
        this.f7615s = gv();
        n3(drawable);
    }
}
