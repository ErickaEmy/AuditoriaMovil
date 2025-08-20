package androidx.compose.ui.geometry;
/* compiled from: GeometryUtils.kt */
/* loaded from: classes.dex */
public abstract class GeometryUtilsKt {
    public static final String toStringAsFixed(float f, int i) {
        int max = Math.max(i, 0);
        float pow = (float) Math.pow(10.0f, max);
        float f2 = f * pow;
        int i2 = (int) f2;
        if (f2 - i2 >= 0.5f) {
            i2++;
        }
        float f3 = i2 / pow;
        if (max > 0) {
            return String.valueOf(f3);
        }
        return String.valueOf((int) f3);
    }
}
