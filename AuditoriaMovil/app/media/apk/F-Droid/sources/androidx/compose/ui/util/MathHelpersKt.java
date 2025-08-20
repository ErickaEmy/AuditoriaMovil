package androidx.compose.ui.util;

import kotlin.math.MathKt__MathJVMKt;
/* compiled from: MathHelpers.kt */
/* loaded from: classes.dex */
public abstract class MathHelpersKt {
    public static final float lerp(float f, float f2, float f3) {
        return ((1 - f3) * f) + (f3 * f2);
    }

    public static final int lerp(int i, int i2, float f) {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt((i2 - i) * f);
        return i + roundToInt;
    }
}
