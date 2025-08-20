package androidx.compose.animation.core;

import androidx.compose.animation.core.FloatAnimationSpec;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: FloatAnimationSpec.kt */
/* loaded from: classes.dex */
public final class FloatTweenSpec implements FloatAnimationSpec {
    private final int delay;
    private final int duration;
    private final Easing easing;

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public long getDurationNanos(float f, float f2, float f3) {
        return (this.delay + this.duration) * 1000000;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public /* synthetic */ float getEndVelocity(float f, float f2, float f3) {
        float velocityFromNanos;
        velocityFromNanos = getVelocityFromNanos(getDurationNanos(f, f2, f3), f, f2, f3);
        return velocityFromNanos;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public /* bridge */ /* synthetic */ VectorizedAnimationSpec vectorize(TwoWayConverter twoWayConverter) {
        VectorizedAnimationSpec vectorize;
        vectorize = vectorize(twoWayConverter);
        return vectorize;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public /* synthetic */ VectorizedFloatAnimationSpec vectorize(TwoWayConverter twoWayConverter) {
        return FloatAnimationSpec.CC.m32$default$vectorize((FloatAnimationSpec) this, twoWayConverter);
    }

    public FloatTweenSpec(int i, int i2, Easing easing) {
        Intrinsics.checkNotNullParameter(easing, "easing");
        this.duration = i;
        this.delay = i2;
        this.easing = easing;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getValueFromNanos(long j, float f, float f2, float f3) {
        float coerceIn;
        long clampPlayTime = clampPlayTime(j / 1000000);
        int i = this.duration;
        float f4 = i == 0 ? 1.0f : ((float) clampPlayTime) / i;
        Easing easing = this.easing;
        coerceIn = RangesKt___RangesKt.coerceIn(f4, 0.0f, 1.0f);
        return VectorConvertersKt.lerp(f, f2, easing.transform(coerceIn));
    }

    private final long clampPlayTime(long j) {
        long coerceIn;
        coerceIn = RangesKt___RangesKt.coerceIn(j - this.delay, 0L, this.duration);
        return coerceIn;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getVelocityFromNanos(long j, float f, float f2, float f3) {
        long clampPlayTime = clampPlayTime(j / 1000000);
        int i = (clampPlayTime > 0L ? 1 : (clampPlayTime == 0L ? 0 : -1));
        if (i < 0) {
            return 0.0f;
        }
        if (i == 0) {
            return f3;
        }
        return (getValueFromNanos(clampPlayTime * 1000000, f, f2, f3) - getValueFromNanos((clampPlayTime - 1) * 1000000, f, f2, f3)) * 1000.0f;
    }
}
