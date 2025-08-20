package jz;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public abstract class gv implements Interpolator {

    /* renamed from: n3  reason: collision with root package name */
    public final float f9554n3;
    public final float[] y;

    public gv(float[] fArr) {
        this.y = fArr;
        this.f9554n3 = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f4) {
        if (f4 >= 1.0f) {
            return 1.0f;
        }
        if (f4 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.y;
        int min = Math.min((int) ((fArr.length - 1) * f4), fArr.length - 2);
        float f6 = this.f9554n3;
        float f9 = (f4 - (min * f6)) / f6;
        float[] fArr2 = this.y;
        float f10 = fArr2[min];
        return f10 + (f9 * (fArr2[min + 1] - f10));
    }
}
