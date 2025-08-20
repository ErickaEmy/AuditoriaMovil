package y6;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class fb implements TypeEvaluator<Matrix> {
    public final float[] y = new float[9];

    /* renamed from: n3  reason: collision with root package name */
    public final float[] f15318n3 = new float[9];

    /* renamed from: zn  reason: collision with root package name */
    public final Matrix f15319zn = new Matrix();

    @NonNull
    public Matrix y(float f4, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        matrix.getValues(this.y);
        matrix2.getValues(this.f15318n3);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.f15318n3;
            float f6 = fArr[i];
            float f9 = this.y[i];
            fArr[i] = f9 + ((f6 - f9) * f4);
        }
        this.f15319zn.setValues(this.f15318n3);
        return this.f15319zn;
    }
}
