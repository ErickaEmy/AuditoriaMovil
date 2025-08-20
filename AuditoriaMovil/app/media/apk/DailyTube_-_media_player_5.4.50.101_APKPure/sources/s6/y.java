package s6;
/* loaded from: classes.dex */
public final class y {
    public static float gv(float f4, float f6, float f9, float f10) {
        if (f4 <= f6 || f4 <= f9 || f4 <= f10) {
            if (f6 > f9 && f6 > f10) {
                return f6;
            }
            if (f9 > f10) {
                return f9;
            }
            return f10;
        }
        return f4;
    }

    public static float n3(float f4, float f6, float f9, float f10, float f11, float f12) {
        return gv(y(f4, f6, f9, f10), y(f4, f6, f11, f10), y(f4, f6, f11, f12), y(f4, f6, f9, f12));
    }

    public static float y(float f4, float f6, float f9, float f10) {
        return (float) Math.hypot(f9 - f4, f10 - f6);
    }

    public static float zn(float f4, float f6, float f9) {
        return ((1.0f - f9) * f4) + (f9 * f6);
    }
}
