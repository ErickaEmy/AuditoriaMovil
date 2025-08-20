package co;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class v extends Drawable {
    public static final double y = Math.cos(Math.toRadians(45.0d));

    public static float n3(float f4, float f6, boolean z2) {
        if (z2) {
            return (float) ((f4 * 1.5f) + ((1.0d - y) * f6));
        }
        return f4 * 1.5f;
    }

    public static float y(float f4, float f6, boolean z2) {
        if (z2) {
            return (float) (f4 + ((1.0d - y) * f6));
        }
        return f4;
    }
}
