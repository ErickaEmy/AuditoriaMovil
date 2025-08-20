package ej;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class c5 extends s {

    /* renamed from: p  reason: collision with root package name */
    public static Method f7596p;

    public c5(Drawable drawable) {
        super(drawable);
        fb();
    }

    public final void fb() {
        if (f7596p == null) {
            try {
                f7596p = Drawable.class.getDeclaredMethod("isProjected", null);
            } catch (Exception e2) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Rect getDirtyBounds() {
        return this.f7616t.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@NonNull Outline outline) {
        this.f7616t.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f7616t;
        if (drawable != null && (method = f7596p) != null) {
            try {
                return ((Boolean) method.invoke(drawable, null)).booleanValue();
            } catch (Exception e2) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e2);
                return false;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f4, float f6) {
        this.f7616t.setHotspot(f4, f6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i5, int i6, int i8) {
        this.f7616t.setHotspotBounds(i, i5, i6, i8);
    }

    @Override // ej.s, android.graphics.drawable.Drawable
    public boolean setState(@NonNull int[] iArr) {
        if (super.setState(iArr)) {
            invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // ej.s, android.graphics.drawable.Drawable
    public void setTint(int i) {
        if (zn()) {
            super.setTint(i);
        } else {
            this.f7616t.setTint(i);
        }
    }

    @Override // ej.s, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (zn()) {
            super.setTintList(colorStateList);
        } else {
            this.f7616t.setTintList(colorStateList);
        }
    }

    @Override // ej.s, android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (zn()) {
            super.setTintMode(mode);
        } else {
            this.f7616t.setTintMode(mode);
        }
    }

    @Override // ej.s
    public boolean zn() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f7616t;
        if (!(drawable instanceof GradientDrawable) && !(drawable instanceof DrawableContainer) && !(drawable instanceof InsetDrawable) && !(drawable instanceof RippleDrawable)) {
            return false;
        }
        return true;
    }

    public c5(i9 i9Var, Resources resources) {
        super(i9Var, resources);
        fb();
    }
}
