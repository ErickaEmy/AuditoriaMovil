package androidx.compose.animation.core;

import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec;
import androidx.compose.animation.core.VectorizedFiniteAnimationSpec;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: VectorizedAnimationSpec.kt */
/* loaded from: classes.dex */
public final class VectorizedKeyframesSpec implements VectorizedDurationBasedAnimationSpec {
    private final int delayMillis;
    private final int durationMillis;
    private final Map keyframes;
    private AnimationVector valueVector;
    private AnimationVector velocityVector;

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.durationMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return VectorizedDurationBasedAnimationSpec.CC.$default$getDurationNanos(this, animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return VectorizedAnimationSpec.CC.$default$getEndVelocity(this, animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ boolean isInfinite() {
        return VectorizedFiniteAnimationSpec.CC.$default$isInfinite(this);
    }

    public VectorizedKeyframesSpec(Map keyframes, int i, int i2) {
        Intrinsics.checkNotNullParameter(keyframes, "keyframes");
        this.keyframes = keyframes;
        this.durationMillis = i;
        this.delayMillis = i2;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getValueFromNanos(long j, AnimationVector initialValue, AnimationVector targetValue, AnimationVector initialVelocity) {
        long clampPlayTime;
        Object value;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        clampPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, j / 1000000);
        int i = (int) clampPlayTime;
        if (this.keyframes.containsKey(Integer.valueOf(i))) {
            value = MapsKt__MapsKt.getValue(this.keyframes, Integer.valueOf(i));
            return (AnimationVector) ((Pair) value).getFirst();
        } else if (i >= getDurationMillis()) {
            return targetValue;
        } else {
            if (i <= 0) {
                return initialValue;
            }
            int durationMillis = getDurationMillis();
            Easing linearEasing = EasingKt.getLinearEasing();
            int i2 = 0;
            AnimationVector animationVector = initialValue;
            int i3 = 0;
            for (Map.Entry entry : this.keyframes.entrySet()) {
                int intValue = ((Number) entry.getKey()).intValue();
                Pair pair = (Pair) entry.getValue();
                if (i > intValue && intValue >= i3) {
                    animationVector = (AnimationVector) pair.getFirst();
                    linearEasing = (Easing) pair.getSecond();
                    i3 = intValue;
                } else if (i < intValue && intValue <= durationMillis) {
                    targetValue = (AnimationVector) pair.getFirst();
                    durationMillis = intValue;
                }
            }
            float transform = linearEasing.transform((i - i3) / (durationMillis - i3));
            init(initialValue);
            int size$animation_core_release = animationVector.getSize$animation_core_release();
            while (true) {
                AnimationVector animationVector2 = null;
                if (i2 >= size$animation_core_release) {
                    break;
                }
                AnimationVector animationVector3 = this.valueVector;
                if (animationVector3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                } else {
                    animationVector2 = animationVector3;
                }
                animationVector2.set$animation_core_release(i2, VectorConvertersKt.lerp(animationVector.get$animation_core_release(i2), targetValue.get$animation_core_release(i2), transform));
                i2++;
            }
            AnimationVector animationVector4 = this.valueVector;
            if (animationVector4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                return null;
            }
            return animationVector4;
        }
    }

    private final void init(AnimationVector animationVector) {
        if (this.valueVector == null) {
            this.valueVector = AnimationVectorsKt.newInstance(animationVector);
            this.velocityVector = AnimationVectorsKt.newInstance(animationVector);
        }
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getVelocityFromNanos(long j, AnimationVector initialValue, AnimationVector targetValue, AnimationVector initialVelocity) {
        long clampPlayTime;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        clampPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, j / 1000000);
        if (clampPlayTime <= 0) {
            return initialVelocity;
        }
        AnimationVector valueFromMillis = VectorizedAnimationSpecKt.getValueFromMillis(this, clampPlayTime - 1, initialValue, targetValue, initialVelocity);
        AnimationVector valueFromMillis2 = VectorizedAnimationSpecKt.getValueFromMillis(this, clampPlayTime, initialValue, targetValue, initialVelocity);
        init(initialValue);
        int size$animation_core_release = valueFromMillis.getSize$animation_core_release();
        int i = 0;
        while (true) {
            AnimationVector animationVector = null;
            if (i >= size$animation_core_release) {
                break;
            }
            AnimationVector animationVector2 = this.velocityVector;
            if (animationVector2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            } else {
                animationVector = animationVector2;
            }
            animationVector.set$animation_core_release(i, (valueFromMillis.get$animation_core_release(i) - valueFromMillis2.get$animation_core_release(i)) * 1000.0f);
            i++;
        }
        AnimationVector animationVector3 = this.velocityVector;
        if (animationVector3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            return null;
        }
        return animationVector3;
    }
}
