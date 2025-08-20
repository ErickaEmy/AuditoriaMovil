package co;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class gv extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3998a;

    /* renamed from: c5  reason: collision with root package name */
    public PorterDuffColorFilter f3999c5;

    /* renamed from: gv  reason: collision with root package name */
    public final Rect f4002gv;

    /* renamed from: i9  reason: collision with root package name */
    public ColorStateList f4003i9;

    /* renamed from: s  reason: collision with root package name */
    public ColorStateList f4005s;

    /* renamed from: v  reason: collision with root package name */
    public float f4006v;
    public float y;

    /* renamed from: zn  reason: collision with root package name */
    public final RectF f4007zn;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f4001fb = true;

    /* renamed from: f  reason: collision with root package name */
    public PorterDuff.Mode f4000f = PorterDuff.Mode.SRC_IN;

    /* renamed from: n3  reason: collision with root package name */
    public final Paint f4004n3 = new Paint(5);

    public gv(ColorStateList colorStateList, float f4) {
        this.y = f4;
        v(colorStateList);
        this.f4007zn = new RectF();
        this.f4002gv = new Rect();
    }

    public void a(@Nullable ColorStateList colorStateList) {
        v(colorStateList);
        invalidateSelf();
    }

    public final void c5(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f4007zn.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f4002gv.set(rect);
        if (this.f3998a) {
            float n32 = v.n3(this.f4006v, this.y, this.f4001fb);
            this.f4002gv.inset((int) Math.ceil(v.y(this.f4006v, this.y, this.f4001fb)), (int) Math.ceil(n32));
            this.f4007zn.set(this.f4002gv);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z2;
        Paint paint = this.f4004n3;
        if (this.f3999c5 != null && paint.getColorFilter() == null) {
            paint.setColorFilter(this.f3999c5);
            z2 = true;
        } else {
            z2 = false;
        }
        RectF rectF = this.f4007zn;
        float f4 = this.y;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        if (z2) {
            paint.setColorFilter(null);
        }
    }

    public void fb(float f4, boolean z2, boolean z3) {
        if (f4 == this.f4006v && this.f3998a == z2 && this.f4001fb == z3) {
            return;
        }
        this.f4006v = f4;
        this.f3998a = z2;
        this.f4001fb = z3;
        c5(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f4002gv, this.y);
    }

    public float gv() {
        return this.y;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f4003i9;
        if ((colorStateList2 != null && colorStateList2.isStateful()) || (((colorStateList = this.f4005s) != null && colorStateList.isStateful()) || super.isStateful())) {
            return true;
        }
        return false;
    }

    public ColorStateList n3() {
        return this.f4005s;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        c5(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z2;
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f4005s;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (colorForState != this.f4004n3.getColor()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.f4004n3.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f4003i9;
        if (colorStateList2 != null && (mode = this.f4000f) != null) {
            this.f3999c5 = y(colorStateList2, mode);
            return true;
        }
        return z2;
    }

    public void s(float f4) {
        if (f4 == this.y) {
            return;
        }
        this.y = f4;
        c5(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f4004n3.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4004n3.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f4003i9 = colorStateList;
        this.f3999c5 = y(colorStateList, this.f4000f);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f4000f = mode;
        this.f3999c5 = y(this.f4003i9, mode);
        invalidateSelf();
    }

    public final void v(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f4005s = colorStateList;
        this.f4004n3.setColor(colorStateList.getColorForState(getState(), this.f4005s.getDefaultColor()));
    }

    public final PorterDuffColorFilter y(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return null;
    }

    public float zn() {
        return this.f4006v;
    }
}
