package z6;

import android.graphics.Color;
/* loaded from: classes.dex */
public final class y {
    public static final ThreadLocal<double[]> y = new ThreadLocal<>();

    public static int a(int i, int i5) {
        if (i5 >= 0 && i5 <= 255) {
            return (i & 16777215) | (i5 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    public static int gv(int i, int i5, int i6, int i8, int i10) {
        if (i10 == 0) {
            return 0;
        }
        return (((i * 255) * i5) + ((i6 * i8) * (255 - i5))) / (i10 * 255);
    }

    public static int n3(int i, int i5) {
        return 255 - (((255 - i5) * (255 - i)) / 255);
    }

    public static int v(int i, int i5, int i6) {
        if (i >= i5) {
            return Math.min(i, i6);
        }
        return i5;
    }

    public static int y(double d2, double d3, double d4) {
        double d5;
        double d6;
        double d7;
        double d8 = (((3.2406d * d2) + ((-1.5372d) * d3)) + ((-0.4986d) * d4)) / 100.0d;
        double d10 = ((((-0.9689d) * d2) + (1.8758d * d3)) + (0.0415d * d4)) / 100.0d;
        double d11 = (((0.0557d * d2) + ((-0.204d) * d3)) + (1.057d * d4)) / 100.0d;
        if (d8 > 0.0031308d) {
            d5 = (Math.pow(d8, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d5 = d8 * 12.92d;
        }
        if (d10 > 0.0031308d) {
            d6 = (Math.pow(d10, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d6 = d10 * 12.92d;
        }
        if (d11 > 0.0031308d) {
            d7 = (Math.pow(d11, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d7 = 12.92d * d11;
        }
        return Color.rgb(v((int) Math.round(d5 * 255.0d), 0, 255), v((int) Math.round(d6 * 255.0d), 0, 255), v((int) Math.round(d7 * 255.0d), 0, 255));
    }

    public static int zn(int i, int i5) {
        int alpha = Color.alpha(i5);
        int alpha2 = Color.alpha(i);
        int n32 = n3(alpha2, alpha);
        return Color.argb(n32, gv(Color.red(i), alpha2, Color.red(i5), alpha, n32), gv(Color.green(i), alpha2, Color.green(i5), alpha, n32), gv(Color.blue(i), alpha2, Color.blue(i5), alpha, n32));
    }
}
