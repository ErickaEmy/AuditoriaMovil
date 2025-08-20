package ej;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public abstract class gv extends Drawable {

    /* renamed from: f  reason: collision with root package name */
    public boolean f7599f;

    /* renamed from: fb  reason: collision with root package name */
    public float f7600fb;

    /* renamed from: n3  reason: collision with root package name */
    public int f7603n3;

    /* renamed from: t  reason: collision with root package name */
    public int f7605t;

    /* renamed from: tl  reason: collision with root package name */
    public int f7606tl;

    /* renamed from: v  reason: collision with root package name */
    public final BitmapShader f7607v;
    public final Bitmap y;

    /* renamed from: zn  reason: collision with root package name */
    public int f7608zn = 119;

    /* renamed from: gv  reason: collision with root package name */
    public final Paint f7601gv = new Paint(3);

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f7597a = new Matrix();

    /* renamed from: s  reason: collision with root package name */
    public final Rect f7604s = new Rect();

    /* renamed from: c5  reason: collision with root package name */
    public final RectF f7598c5 = new RectF();

    /* renamed from: i9  reason: collision with root package name */
    public boolean f7602i9 = true;

    public gv(Resources resources, Bitmap bitmap) {
        this.f7603n3 = 160;
        if (resources != null) {
            this.f7603n3 = resources.getDisplayMetrics().densityDpi;
        }
        this.y = bitmap;
        if (bitmap != null) {
            y();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f7607v = new BitmapShader(bitmap, tileMode, tileMode);
            return;
        }
        this.f7606tl = -1;
        this.f7605t = -1;
        this.f7607v = null;
    }

    public static boolean gv(float f4) {
        if (f4 > 0.05f) {
            return true;
        }
        return false;
    }

    public final void a() {
        this.f7600fb = Math.min(this.f7606tl, this.f7605t) / 2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Bitmap bitmap = this.y;
        if (bitmap == null) {
            return;
        }
        fb();
        if (this.f7601gv.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f7604s, this.f7601gv);
            return;
        }
        RectF rectF = this.f7598c5;
        float f4 = this.f7600fb;
        canvas.drawRoundRect(rectF, f4, f4, this.f7601gv);
    }

    public void fb() {
        if (this.f7602i9) {
            if (this.f7599f) {
                int min = Math.min(this.f7605t, this.f7606tl);
                zn(this.f7608zn, min, min, getBounds(), this.f7604s);
                int min2 = Math.min(this.f7604s.width(), this.f7604s.height());
                this.f7604s.inset(Math.max(0, (this.f7604s.width() - min2) / 2), Math.max(0, (this.f7604s.height() - min2) / 2));
                this.f7600fb = min2 * 0.5f;
            } else {
                zn(this.f7608zn, this.f7605t, this.f7606tl, getBounds(), this.f7604s);
            }
            this.f7598c5.set(this.f7604s);
            if (this.f7607v != null) {
                Matrix matrix = this.f7597a;
                RectF rectF = this.f7598c5;
                matrix.setTranslate(rectF.left, rectF.top);
                this.f7597a.preScale(this.f7598c5.width() / this.y.getWidth(), this.f7598c5.height() / this.y.getHeight());
                this.f7607v.setLocalMatrix(this.f7597a);
                this.f7601gv.setShader(this.f7607v);
            }
            this.f7602i9 = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f7601gv.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f7601gv.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f7606tl;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f7605t;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        if (this.f7608zn != 119 || this.f7599f || (bitmap = this.y) == null || bitmap.hasAlpha() || this.f7601gv.getAlpha() < 255 || gv(this.f7600fb)) {
            return -3;
        }
        return -1;
    }

    public float n3() {
        return this.f7600fb;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        if (this.f7599f) {
            a();
        }
        this.f7602i9 = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.f7601gv.getAlpha()) {
            this.f7601gv.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f7601gv.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.f7601gv.setDither(z2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.f7601gv.setFilterBitmap(z2);
        invalidateSelf();
    }

    public void v(float f4) {
        if (this.f7600fb == f4) {
            return;
        }
        this.f7599f = false;
        if (gv(f4)) {
            this.f7601gv.setShader(this.f7607v);
        } else {
            this.f7601gv.setShader(null);
        }
        this.f7600fb = f4;
        invalidateSelf();
    }

    public final void y() {
        this.f7605t = this.y.getScaledWidth(this.f7603n3);
        this.f7606tl = this.y.getScaledHeight(this.f7603n3);
    }

    public abstract void zn(int i, int i5, int i6, Rect rect, Rect rect2);
}
