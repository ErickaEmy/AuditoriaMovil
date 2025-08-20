package h6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class zn extends s<v> {

    /* renamed from: a  reason: collision with root package name */
    public float f8760a;

    /* renamed from: gv  reason: collision with root package name */
    public float f8761gv;

    /* renamed from: v  reason: collision with root package name */
    public float f8762v;

    /* renamed from: zn  reason: collision with root package name */
    public int f8763zn;

    public zn(@NonNull v vVar) {
        super(vVar);
        this.f8763zn = 1;
    }

    public final int c5() {
        S s2 = this.y;
        return ((v) s2).f8758fb + (((v) s2).f8759s * 2);
    }

    @Override // h6.s
    public int gv() {
        return c5();
    }

    @Override // h6.s
    public void n3(@NonNull Canvas canvas, @NonNull Paint paint, float f4, float f6, int i) {
        float f9;
        if (f4 == f6) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(this.f8761gv);
        int i5 = this.f8763zn;
        float f10 = f4 * 360.0f * i5;
        if (f6 >= f4) {
            f9 = f6 - f4;
        } else {
            f9 = (f6 + 1.0f) - f4;
        }
        float f11 = f9 * 360.0f * i5;
        float f12 = this.f8760a;
        canvas.drawArc(new RectF(-f12, -f12, f12, f12), f10, f11, false, paint);
        if (this.f8762v > 0.0f && Math.abs(f11) < 360.0f) {
            paint.setStyle(Paint.Style.FILL);
            float f13 = this.f8762v;
            RectF rectF = new RectF(-f13, -f13, f13, f13);
            s(canvas, paint, this.f8761gv, this.f8762v, f10, true, rectF);
            s(canvas, paint, this.f8761gv, this.f8762v, f10 + f11, false, rectF);
        }
    }

    public final void s(Canvas canvas, Paint paint, float f4, float f6, float f9, boolean z2, RectF rectF) {
        float f10;
        if (z2) {
            f10 = -1.0f;
        } else {
            f10 = 1.0f;
        }
        canvas.save();
        canvas.rotate(f9);
        float f11 = f4 / 2.0f;
        float f12 = f10 * f6;
        canvas.drawRect((this.f8760a - f11) + f6, Math.min(0.0f, this.f8763zn * f12), (this.f8760a + f11) - f6, Math.max(0.0f, f12 * this.f8763zn), paint);
        canvas.translate((this.f8760a - f11) + f6, 0.0f);
        canvas.drawArc(rectF, 180.0f, (-f10) * 90.0f * this.f8763zn, true, paint);
        canvas.translate(f4 - (f6 * 2.0f), 0.0f);
        canvas.drawArc(rectF, 0.0f, f10 * 90.0f * this.f8763zn, true, paint);
        canvas.restore();
    }

    @Override // h6.s
    public int v() {
        return c5();
    }

    @Override // h6.s
    public void y(@NonNull Canvas canvas, float f4) {
        S s2;
        int i;
        S s3 = this.y;
        float f6 = (((v) s3).f8758fb / 2.0f) + ((v) s3).f8759s;
        canvas.translate(f6, f6);
        canvas.rotate(-90.0f);
        float f9 = -f6;
        canvas.clipRect(f9, f9, f6, f6);
        if (((v) this.y).f8757c5 == 0) {
            i = 1;
        } else {
            i = -1;
        }
        this.f8763zn = i;
        this.f8761gv = ((v) s2).y * f4;
        this.f8762v = ((v) s2).f8753n3 * f4;
        this.f8760a = (((v) s2).f8758fb - ((v) s2).y) / 2.0f;
        if ((this.f8756n3.i9() && ((v) this.y).f8754v == 2) || (this.f8756n3.c5() && ((v) this.y).f8751a == 1)) {
            this.f8760a += ((1.0f - f4) * ((v) this.y).y) / 2.0f;
        } else if ((this.f8756n3.i9() && ((v) this.y).f8754v == 1) || (this.f8756n3.c5() && ((v) this.y).f8751a == 2)) {
            this.f8760a -= ((1.0f - f4) * ((v) this.y).y) / 2.0f;
        }
    }

    @Override // h6.s
    public void zn(@NonNull Canvas canvas, @NonNull Paint paint) {
        int y = td.y.y(((v) this.y).f8752gv, this.f8756n3.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(y);
        paint.setStrokeWidth(this.f8761gv);
        float f4 = this.f8760a;
        canvas.drawArc(new RectF(-f4, -f4, f4, f4), 0.0f, 360.0f, false, paint);
    }
}
