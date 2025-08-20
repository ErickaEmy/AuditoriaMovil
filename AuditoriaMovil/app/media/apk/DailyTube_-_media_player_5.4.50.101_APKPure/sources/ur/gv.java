package ur;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.R$styleable;
import com.uv.v7.R;
/* loaded from: classes.dex */
public class gv extends LinearLayoutCompat {

    /* renamed from: b  reason: collision with root package name */
    public boolean f14102b;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f14103d;

    /* renamed from: ej  reason: collision with root package name */
    public final Rect f14104ej;
    @Nullable

    /* renamed from: fh  reason: collision with root package name */
    public Drawable f14105fh;

    /* renamed from: j5  reason: collision with root package name */
    public boolean f14106j5;

    /* renamed from: x  reason: collision with root package name */
    public int f14107x;

    public gv(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f14105fh;
        if (drawable != null) {
            if (this.f14106j5) {
                this.f14106j5 = false;
                Rect rect = this.f14103d;
                Rect rect2 = this.f14104ej;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f14102b) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f14107x, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void drawableHotspotChanged(float f4, float f6) {
        super.drawableHotspotChanged(f4, f6);
        Drawable drawable = this.f14105fh;
        if (drawable != null) {
            drawable.setHotspot(f4, f6);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f14105fh;
        if (drawable != null && drawable.isStateful()) {
            this.f14105fh.setState(getDrawableState());
        }
    }

    @Override // android.view.View
    @Nullable
    public Drawable getForeground() {
        return this.f14105fh;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f14107x;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f14105fh;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        super.onLayout(z2, i, i5, i6, i8);
        this.f14106j5 = z2 | this.f14106j5;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i5, int i6, int i8) {
        super.onSizeChanged(i, i5, i6, i8);
        this.f14106j5 = true;
    }

    @Override // android.view.View
    public void setForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f14105fh;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f14105fh);
            }
            this.f14105fh = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f14107x == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i) {
        if (this.f14107x != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
                i |= 48;
            }
            this.f14107x = i;
            if (i == 119 && this.f14105fh != null) {
                this.f14105fh.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f14105fh) {
            return false;
        }
        return true;
    }

    public gv(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14103d = new Rect();
        this.f14104ej = new Rect();
        this.f14107x = 119;
        this.f14102b = true;
        this.f14106j5 = false;
        TypedArray s2 = i9.s(context, attributeSet, R$styleable.vd, i, 0, new int[0]);
        this.f14107x = s2.getInt(R$styleable.rt, this.f14107x);
        Drawable drawable = s2.getDrawable(R$styleable.t5);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f14102b = s2.getBoolean(R$styleable.ks, true);
        s2.recycle();
    }
}
