package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
/* renamed from: com.facebook.ads.redexgen.X.a8  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1160a8 implements InterfaceC03252i {
    public final /* synthetic */ C1159a7 A00;

    public C1160a8(C1159a7 c1159a7) {
        this.A00 = c1159a7;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03252i
    public final void A5E(Canvas canvas, RectF rectF, float f4, Paint paint) {
        float f6 = f4 * 2.0f;
        float width = (rectF.width() - f6) - 1.0f;
        float height = (rectF.height() - f6) - 1.0f;
        Canvas canvas2 = canvas;
        Paint paint2 = paint;
        if (f4 >= 1.0f) {
            float f9 = f4 + 0.5f;
            this.A00.A00.set(-f9, -f9, f9, f9);
            int save = canvas2.save();
            canvas2.translate(rectF.left + f9, rectF.top + f9);
            canvas2.drawArc(this.A00.A00, 180.0f, 90.0f, true, paint2);
            canvas2.translate(width, 0.0f);
            canvas2.rotate(90.0f);
            canvas2.drawArc(this.A00.A00, 180.0f, 90.0f, true, paint2);
            canvas2.translate(height, 0.0f);
            canvas2.rotate(90.0f);
            canvas2.drawArc(this.A00.A00, 180.0f, 90.0f, true, paint2);
            canvas2.translate(width, 0.0f);
            canvas2.rotate(90.0f);
            canvas2 = canvas2;
            canvas2.drawArc(this.A00.A00, 180.0f, 90.0f, true, paint2);
            canvas2.restoreToCount(save);
            float innerWidth = rectF.top;
            float innerHeight = (rectF.right - f9) + 1.0f;
            float roundedCornerRadius = rectF.top + f9;
            canvas2.drawRect((rectF.left + f9) - 1.0f, innerWidth, innerHeight, roundedCornerRadius, paint2);
            float innerWidth2 = rectF.bottom - f9;
            float innerHeight2 = (rectF.right - f9) + 1.0f;
            float roundedCornerRadius2 = rectF.bottom;
            paint2 = paint2;
            canvas2.drawRect((rectF.left + f9) - 1.0f, innerWidth2, innerHeight2, roundedCornerRadius2, paint2);
        }
        float f10 = rectF.left;
        float innerWidth3 = rectF.top + f4;
        float innerHeight3 = rectF.right;
        canvas2.drawRect(f10, innerWidth3, innerHeight3, rectF.bottom - f4, paint2);
    }
}
