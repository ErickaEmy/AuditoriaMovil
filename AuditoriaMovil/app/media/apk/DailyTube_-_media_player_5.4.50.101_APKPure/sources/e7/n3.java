package e7;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import hx.f;
import hx.fb;
/* loaded from: classes.dex */
public class n3 extends fb {
    @NonNull

    /* renamed from: oz  reason: collision with root package name */
    public final Paint f7581oz;

    /* renamed from: q9  reason: collision with root package name */
    public int f7582q9;
    @NonNull

    /* renamed from: ut  reason: collision with root package name */
    public final RectF f7583ut;

    public n3() {
        this(null);
    }

    public void ap(float f4, float f6, float f9, float f10) {
        RectF rectF = this.f7583ut;
        if (f4 != rectF.left || f6 != rectF.top || f9 != rectF.right || f10 != rectF.bottom) {
            rectF.set(f4, f6, f9, f10);
            invalidateSelf();
        }
    }

    @Override // hx.fb, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        ra(canvas);
        super.draw(canvas);
        canvas.drawRect(this.f7583ut, this.f7581oz);
        nf(canvas);
    }

    public void e() {
        ap(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public final boolean kp(Drawable.Callback callback) {
        return callback instanceof View;
    }

    public boolean lc() {
        return !this.f7583ut.isEmpty();
    }

    public final void nf(@NonNull Canvas canvas) {
        if (!kp(getCallback())) {
            canvas.restoreToCount(this.f7582q9);
        }
    }

    public final void ra(@NonNull Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (kp(callback)) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
                return;
            }
            return;
        }
        s8(canvas);
    }

    public final void s8(@NonNull Canvas canvas) {
        this.f7582q9 = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
    }

    public final void yc() {
        this.f7581oz.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f7581oz.setColor(-1);
        this.f7581oz.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public void yg(@NonNull RectF rectF) {
        ap(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public n3(@Nullable f fVar) {
        super(fVar == null ? new f() : fVar);
        this.f7581oz = new Paint(1);
        yc();
        this.f7583ut = new RectF();
    }
}
