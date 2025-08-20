package androidx.compose.animation;

import ch.qos.logback.core.CoreConstants;
/* compiled from: SplineBasedDecay.kt */
/* loaded from: classes.dex */
public final class AndroidFlingSpline {
    public static final AndroidFlingSpline INSTANCE = new AndroidFlingSpline();
    private static final float[] SplinePositions;
    private static final float[] SplineTimes;

    private AndroidFlingSpline() {
    }

    static {
        float[] fArr = new float[101];
        SplinePositions = fArr;
        float[] fArr2 = new float[101];
        SplineTimes = fArr2;
        SplineBasedDecayKt.computeSplineInfo(fArr, fArr2, 100);
    }

    public final FlingResult flingPosition(float f) {
        float f2;
        float f3;
        float f4 = 100;
        int i = (int) (f4 * f);
        if (i < 100) {
            float f5 = i / f4;
            int i2 = i + 1;
            float f6 = i2 / f4;
            float[] fArr = SplinePositions;
            float f7 = fArr[i];
            f3 = (fArr[i2] - f7) / (f6 - f5);
            f2 = f7 + ((f - f5) * f3);
        } else {
            f2 = 1.0f;
            f3 = 0.0f;
        }
        return new FlingResult(f2, f3);
    }

    public final double deceleration(float f, float f2) {
        return Math.log((Math.abs(f) * 0.35f) / f2);
    }

    /* compiled from: SplineBasedDecay.kt */
    /* loaded from: classes.dex */
    public static final class FlingResult {
        private final float distanceCoefficient;
        private final float velocityCoefficient;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FlingResult) {
                FlingResult flingResult = (FlingResult) obj;
                return Float.compare(this.distanceCoefficient, flingResult.distanceCoefficient) == 0 && Float.compare(this.velocityCoefficient, flingResult.velocityCoefficient) == 0;
            }
            return false;
        }

        public final float getDistanceCoefficient() {
            return this.distanceCoefficient;
        }

        public final float getVelocityCoefficient() {
            return this.velocityCoefficient;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.distanceCoefficient) * 31) + Float.floatToIntBits(this.velocityCoefficient);
        }

        public String toString() {
            return "FlingResult(distanceCoefficient=" + this.distanceCoefficient + ", velocityCoefficient=" + this.velocityCoefficient + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public FlingResult(float f, float f2) {
            this.distanceCoefficient = f;
            this.velocityCoefficient = f2;
        }
    }
}
