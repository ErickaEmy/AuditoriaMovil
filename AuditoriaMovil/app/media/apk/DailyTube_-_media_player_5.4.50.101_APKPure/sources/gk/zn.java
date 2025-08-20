package gk;

import android.opengl.Matrix;
import v5.b;
import v5.w;
/* loaded from: classes.dex */
public final class zn {

    /* renamed from: gv  reason: collision with root package name */
    public boolean f8342gv;
    public final float[] y = new float[16];

    /* renamed from: n3  reason: collision with root package name */
    public final float[] f8343n3 = new float[16];

    /* renamed from: zn  reason: collision with root package name */
    public final b<float[]> f8344zn = new b<>();

    public static void n3(float[] fArr, float[] fArr2) {
        float f4 = fArr2[0];
        float f6 = -fArr2[1];
        float f9 = -fArr2[2];
        float length = Matrix.length(f4, f6, f9);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr, 0, (float) Math.toDegrees(length), f4 / length, f6 / length, f9 / length);
        } else {
            w.i9(fArr);
        }
    }

    public static void y(float[] fArr, float[] fArr2) {
        w.i9(fArr);
        float f4 = fArr2[10];
        float f6 = fArr2[8];
        float sqrt = (float) Math.sqrt((f4 * f4) + (f6 * f6));
        float f9 = fArr2[10];
        fArr[0] = f9 / sqrt;
        float f10 = fArr2[8];
        fArr[2] = f10 / sqrt;
        fArr[8] = (-f10) / sqrt;
        fArr[10] = f9 / sqrt;
    }

    public void gv() {
        this.f8344zn.zn();
        this.f8342gv = false;
    }

    public void v(long j2, float[] fArr) {
        this.f8344zn.y(j2, fArr);
    }

    public boolean zn(float[] fArr, long j2) {
        float[] i92 = this.f8344zn.i9(j2);
        if (i92 == null) {
            return false;
        }
        n3(this.f8343n3, i92);
        if (!this.f8342gv) {
            y(this.y, this.f8343n3);
            this.f8342gv = true;
        }
        Matrix.multiplyMM(fArr, 0, this.y, 0, this.f8343n3, 0);
        return true;
    }
}
