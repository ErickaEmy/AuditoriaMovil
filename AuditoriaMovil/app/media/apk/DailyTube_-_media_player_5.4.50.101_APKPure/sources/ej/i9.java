package ej;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class i9 extends Drawable.ConstantState {

    /* renamed from: gv  reason: collision with root package name */
    public PorterDuff.Mode f7609gv;

    /* renamed from: n3  reason: collision with root package name */
    public Drawable.ConstantState f7610n3;
    public int y;

    /* renamed from: zn  reason: collision with root package name */
    public ColorStateList f7611zn;

    public i9(@Nullable i9 i9Var) {
        this.f7609gv = s.f7612w;
        if (i9Var != null) {
            this.y = i9Var.y;
            this.f7610n3 = i9Var.f7610n3;
            this.f7611zn = i9Var.f7611zn;
            this.f7609gv = i9Var.f7609gv;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i;
        int i5 = this.y;
        Drawable.ConstantState constantState = this.f7610n3;
        if (constantState != null) {
            i = constantState.getChangingConfigurations();
        } else {
            i = 0;
        }
        return i5 | i;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    public boolean y() {
        if (this.f7610n3 != null) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable(@Nullable Resources resources) {
        return new c5(this, resources);
    }
}
