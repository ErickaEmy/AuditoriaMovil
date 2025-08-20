package d;

import android.graphics.Color;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class n3 {
    public static final float[][] y = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: n3  reason: collision with root package name */
    public static final float[][] f6915n3 = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: zn  reason: collision with root package name */
    public static final float[] f6916zn = {95.047f, 100.0f, 108.883f};

    /* renamed from: gv  reason: collision with root package name */
    public static final float[][] f6914gv = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    public static void a(int i, @NonNull float[] fArr) {
        float v2 = v(Color.red(i));
        float v3 = v(Color.green(i));
        float v4 = v(Color.blue(i));
        float[][] fArr2 = f6914gv;
        float[] fArr3 = fArr2[0];
        fArr[0] = (fArr3[0] * v2) + (fArr3[1] * v3) + (fArr3[2] * v4);
        float[] fArr4 = fArr2[1];
        fArr[1] = (fArr4[0] * v2) + (fArr4[1] * v3) + (fArr4[2] * v4);
        float[] fArr5 = fArr2[2];
        fArr[2] = (v2 * fArr5[0]) + (v3 * fArr5[1]) + (v4 * fArr5[2]);
    }

    public static float fb(int i) {
        float v2 = v(Color.red(i));
        float v3 = v(Color.green(i));
        float v4 = v(Color.blue(i));
        float[] fArr = f6914gv[1];
        return (v2 * fArr[0]) + (v3 * fArr[1]) + (v4 * fArr[2]);
    }

    public static float gv(float f4, float f6, float f9) {
        return f4 + ((f6 - f4) * f9);
    }

    public static float n3(int i) {
        return zn(fb(i));
    }

    public static float s(float f4) {
        float f6;
        if (f4 > 8.0f) {
            f6 = (float) Math.pow((f4 + 16.0d) / 116.0d, 3.0d);
        } else {
            f6 = f4 / 903.2963f;
        }
        return f6 * 100.0f;
    }

    public static float v(int i) {
        float pow;
        float f4 = i / 255.0f;
        if (f4 <= 0.04045f) {
            pow = f4 / 12.92f;
        } else {
            pow = (float) Math.pow((f4 + 0.055f) / 1.055f, 2.4000000953674316d);
        }
        return pow * 100.0f;
    }

    public static int y(float f4) {
        float f6;
        boolean z2;
        float f9;
        if (f4 < 1.0f) {
            return -16777216;
        }
        if (f4 > 99.0f) {
            return -1;
        }
        float f10 = (f4 + 16.0f) / 116.0f;
        if (f4 > 8.0f) {
            f6 = f10 * f10 * f10;
        } else {
            f6 = f4 / 903.2963f;
        }
        float f11 = f10 * f10 * f10;
        if (f11 > 0.008856452f) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            f9 = f11;
        } else {
            f9 = ((f10 * 116.0f) - 16.0f) / 903.2963f;
        }
        if (!z2) {
            f11 = ((f10 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f6916zn;
        return z6.y.y(f9 * fArr[0], f6 * fArr[1], f11 * fArr[2]);
    }

    public static float zn(float f4) {
        float f6 = f4 / 100.0f;
        if (f6 <= 0.008856452f) {
            return f6 * 903.2963f;
        }
        return (((float) Math.cbrt(f6)) * 116.0f) - 16.0f;
    }
}
