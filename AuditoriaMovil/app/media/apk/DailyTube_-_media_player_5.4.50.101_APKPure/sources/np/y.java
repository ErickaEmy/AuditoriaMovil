package np;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import hx.f;
import hx.t;
/* loaded from: classes.dex */
public class y extends Drawable {

    /* renamed from: c5  reason: collision with root package name */
    public int f12032c5;

    /* renamed from: f  reason: collision with root package name */
    public int f12033f;

    /* renamed from: i9  reason: collision with root package name */
    public int f12036i9;
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public final Paint f12037n3;

    /* renamed from: s  reason: collision with root package name */
    public float f12038s;

    /* renamed from: t  reason: collision with root package name */
    public int f12039t;

    /* renamed from: tl  reason: collision with root package name */
    public int f12040tl;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public ColorStateList f12042w;

    /* renamed from: xc  reason: collision with root package name */
    public f f12044xc;
    public final t y = t.f();

    /* renamed from: zn  reason: collision with root package name */
    public final Path f12045zn = new Path();

    /* renamed from: gv  reason: collision with root package name */
    public final Rect f12035gv = new Rect();

    /* renamed from: v  reason: collision with root package name */
    public final RectF f12041v = new RectF();

    /* renamed from: a  reason: collision with root package name */
    public final RectF f12031a = new RectF();

    /* renamed from: fb  reason: collision with root package name */
    public final n3 f12034fb = new n3();

    /* renamed from: wz  reason: collision with root package name */
    public boolean f12043wz = true;

    /* loaded from: classes.dex */
    public class n3 extends Drawable.ConstantState {
        public n3() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return y.this;
        }
    }

    public y(f fVar) {
        this.f12044xc = fVar;
        Paint paint = new Paint(1);
        this.f12037n3 = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    public void a(f fVar) {
        this.f12044xc = fVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f12043wz) {
            this.f12037n3.setShader(y());
            this.f12043wz = false;
        }
        float strokeWidth = this.f12037n3.getStrokeWidth() / 2.0f;
        copyBounds(this.f12035gv);
        this.f12041v.set(this.f12035gv);
        float min = Math.min(this.f12044xc.mt().y(n3()), this.f12041v.width() / 2.0f);
        if (this.f12044xc.r(n3())) {
            this.f12041v.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f12041v, min, min, this.f12037n3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f12034fb;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f12038s > 0.0f) {
            return -3;
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f12044xc.r(n3())) {
            outline.setRoundRect(getBounds(), this.f12044xc.mt().y(n3()));
            return;
        }
        copyBounds(this.f12035gv);
        this.f12041v.set(this.f12035gv);
        this.y.gv(this.f12044xc, 1.0f, this.f12041v, this.f12045zn);
        if (this.f12045zn.isConvex()) {
            outline.setConvexPath(this.f12045zn);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        if (this.f12044xc.r(n3())) {
            int round = Math.round(this.f12038s);
            rect.set(round, round, round, round);
            return true;
        }
        return true;
    }

    public void gv(float f4) {
        if (this.f12038s != f4) {
            this.f12038s = f4;
            this.f12037n3.setStrokeWidth(f4 * 1.3333f);
            this.f12043wz = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f12042w;
        if ((colorStateList != null && colorStateList.isStateful()) || super.isStateful()) {
            return true;
        }
        return false;
    }

    @NonNull
    public RectF n3() {
        this.f12031a.set(getBounds());
        return this.f12031a;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f12043wz = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f12042w;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f12040tl)) != this.f12040tl) {
            this.f12043wz = true;
            this.f12040tl = colorForState;
        }
        if (this.f12043wz) {
            invalidateSelf();
        }
        return this.f12043wz;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f12037n3.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f12037n3.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void v(int i, int i5, int i6, int i8) {
        this.f12032c5 = i;
        this.f12036i9 = i5;
        this.f12033f = i6;
        this.f12039t = i8;
    }

    @NonNull
    public final Shader y() {
        Rect rect = this.f12035gv;
        copyBounds(rect);
        float height = this.f12038s / rect.height();
        return new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{z6.y.zn(this.f12032c5, this.f12040tl), z6.y.zn(this.f12036i9, this.f12040tl), z6.y.zn(z6.y.a(this.f12036i9, 0), this.f12040tl), z6.y.zn(z6.y.a(this.f12039t, 0), this.f12040tl), z6.y.zn(this.f12039t, this.f12040tl), z6.y.zn(this.f12033f, this.f12040tl)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    public void zn(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f12040tl = colorStateList.getColorForState(getState(), this.f12040tl);
        }
        this.f12042w = colorStateList;
        this.f12043wz = true;
        invalidateSelf();
    }
}
