package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.widget.ImageView;
/* loaded from: assets/audience_network.dex */
public class O3 extends ImageView {
    public static final int A04;
    public static final float[] A05;
    public boolean A00;
    public float[] A01;
    public final Path A02;
    public final RectF A03;

    static {
        int i = (int) (LD.A02 * 8.0f);
        A04 = i;
        A05 = new float[]{i, i, i, i, i, i, i, i};
    }

    public O3(C1116Yn c1116Yn) {
        super(c1116Yn);
        this.A01 = A05;
        this.A00 = false;
        this.A02 = new Path();
        this.A03 = new RectF();
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    private float[] getRadiiForCircularImage() {
        int min = Math.min(getWidth(), getHeight()) / 2;
        return new float[]{min, min, min, min, min, min, min, min};
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        this.A03.set(0.0f, 0.0f, getWidth(), getHeight());
        this.A02.reset();
        this.A02.addRoundRect(this.A03, this.A00 ? getRadiiForCircularImage() : this.A01, Path.Direction.CW);
        canvas.clipPath(this.A02);
        super.onDraw(canvas);
    }

    public void setFullCircleCorners(boolean z2) {
        this.A00 = z2;
    }

    public void setRadius(int i) {
        int i5 = (int) (i * LD.A02);
        this.A01 = new float[]{i5, i5, i5, i5, i5, i5, i5, i5};
    }

    public void setRadius(float[] fArr) {
        this.A01 = fArr;
    }
}
