package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: assets/audience_network.dex */
public final class O6 extends ImageView {
    public float A00;
    public final int A01;
    public final int A02;
    public final Bitmap A03;

    public O6(C1116Yn c1116Yn, int i, int i5) {
        super(c1116Yn);
        this.A03 = AbstractC0792Lx.A01(EnumC0791Lw.RATINGS);
        this.A00 = 1.0f;
        this.A01 = i;
        this.A02 = i5;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint(2);
        paint.setColorFilter(new PorterDuffColorFilter(this.A01, PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(this.A03, (Rect) null, new Rect(0, 0, getWidth(), getHeight()), paint);
        paint.setColorFilter(new PorterDuffColorFilter(this.A02, PorterDuff.Mode.SRC_ATOP));
        Rect fillRect = new Rect(0, 0, (int) (this.A00 * this.A03.getWidth()), this.A03.getHeight());
        Rect drawRect = new Rect(0, 0, (int) (this.A00 * getWidth()), getHeight());
        canvas.drawBitmap(this.A03, fillRect, drawRect, paint);
    }

    public void setFillRatio(float f4) {
        this.A00 = f4;
        postInvalidate();
    }
}
