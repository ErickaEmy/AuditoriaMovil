package androidx.compose.animation;

import androidx.compose.ui.unit.Density;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FlingCalculator.kt */
/* loaded from: classes.dex */
public final class FlingCalculator {
    private final Density density;
    private final float friction;
    private final float magicPhysicalCoefficient;

    public FlingCalculator(float f, Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        this.friction = f;
        this.density = density;
        this.magicPhysicalCoefficient = computeDeceleration(density);
    }

    private final float computeDeceleration(Density density) {
        float computeDeceleration;
        computeDeceleration = FlingCalculatorKt.computeDeceleration(0.84f, density.getDensity());
        return computeDeceleration;
    }

    private final double getSplineDeceleration(float f) {
        return AndroidFlingSpline.INSTANCE.deceleration(f, this.friction * this.magicPhysicalCoefficient);
    }

    public final long flingDuration(float f) {
        float f2;
        double splineDeceleration = getSplineDeceleration(f);
        f2 = FlingCalculatorKt.DecelerationRate;
        return (long) (Math.exp(splineDeceleration / (f2 - 1.0d)) * 1000.0d);
    }

    public final float flingDistance(float f) {
        float f2;
        float f3;
        double splineDeceleration = getSplineDeceleration(f);
        f2 = FlingCalculatorKt.DecelerationRate;
        double d = this.friction * this.magicPhysicalCoefficient;
        f3 = FlingCalculatorKt.DecelerationRate;
        return (float) (d * Math.exp((f3 / (f2 - 1.0d)) * splineDeceleration));
    }

    public final FlingInfo flingInfo(float f) {
        float f2;
        float f3;
        double splineDeceleration = getSplineDeceleration(f);
        f2 = FlingCalculatorKt.DecelerationRate;
        double d = f2 - 1.0d;
        f3 = FlingCalculatorKt.DecelerationRate;
        return new FlingInfo(f, (float) (this.friction * this.magicPhysicalCoefficient * Math.exp((f3 / d) * splineDeceleration)), (long) (Math.exp(splineDeceleration / d) * 1000.0d));
    }

    /* compiled from: FlingCalculator.kt */
    /* loaded from: classes.dex */
    public static final class FlingInfo {
        private final float distance;
        private final long duration;
        private final float initialVelocity;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FlingInfo) {
                FlingInfo flingInfo = (FlingInfo) obj;
                return Float.compare(this.initialVelocity, flingInfo.initialVelocity) == 0 && Float.compare(this.distance, flingInfo.distance) == 0 && this.duration == flingInfo.duration;
            }
            return false;
        }

        public int hashCode() {
            return (((Float.floatToIntBits(this.initialVelocity) * 31) + Float.floatToIntBits(this.distance)) * 31) + FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.duration);
        }

        public String toString() {
            return "FlingInfo(initialVelocity=" + this.initialVelocity + ", distance=" + this.distance + ", duration=" + this.duration + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public FlingInfo(float f, float f2, long j) {
            this.initialVelocity = f;
            this.distance = f2;
            this.duration = j;
        }

        public final float position(long j) {
            long j2 = this.duration;
            return this.distance * Math.signum(this.initialVelocity) * AndroidFlingSpline.INSTANCE.flingPosition(j2 > 0 ? ((float) j) / ((float) j2) : 1.0f).getDistanceCoefficient();
        }

        public final float velocity(long j) {
            long j2 = this.duration;
            return (((AndroidFlingSpline.INSTANCE.flingPosition(j2 > 0 ? ((float) j) / ((float) j2) : 1.0f).getVelocityCoefficient() * Math.signum(this.initialVelocity)) * this.distance) / ((float) this.duration)) * 1000.0f;
        }
    }
}
