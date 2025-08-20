package kotlin.math;
/* loaded from: classes.dex */
class MathKt__MathJVMKt extends MathKt__MathHKt {
    public static int roundToInt(float f4) {
        if (!Float.isNaN(f4)) {
            return Math.round(f4);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }
}
