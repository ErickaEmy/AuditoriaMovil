package nr;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import ej.a;
import hx.f;
import hx.fb;
import hx.wz;
/* loaded from: classes.dex */
public class y extends Drawable implements wz, a {
    public n3 y;

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        n3 n3Var = this.y;
        if (n3Var.f12057n3) {
            n3Var.y.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.y;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.y.y.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.y.y.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(@NonNull int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.y.y.setState(iArr)) {
            onStateChange = true;
        }
        boolean v2 = nr.n3.v(iArr);
        n3 n3Var = this.y;
        if (n3Var.f12057n3 != v2) {
            n3Var.f12057n3 = v2;
            return true;
        }
        return onStateChange;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.y.y.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.y.y.setColorFilter(colorFilter);
    }

    @Override // hx.wz
    public void setShapeAppearanceModel(@NonNull f fVar) {
        this.y.y.setShapeAppearanceModel(fVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        this.y.y.setTint(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.y.y.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.y.y.setTintMode(mode);
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    /* renamed from: y */
    public y mutate() {
        this.y = new n3(this.y);
        return this;
    }

    /* loaded from: classes.dex */
    public static final class n3 extends Drawable.ConstantState {

        /* renamed from: n3  reason: collision with root package name */
        public boolean f12057n3;
        @NonNull
        public fb y;

        public n3(fb fbVar) {
            this.y = fbVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        /* renamed from: y */
        public y newDrawable() {
            return new y(new n3(this));
        }

        public n3(@NonNull n3 n3Var) {
            this.y = (fb) n3Var.y.getConstantState().newDrawable();
            this.f12057n3 = n3Var.f12057n3;
        }
    }

    public y(f fVar) {
        this(new n3(new fb(fVar)));
    }

    public y(n3 n3Var) {
        this.y = n3Var;
    }
}
