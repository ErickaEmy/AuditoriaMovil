package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: DecayAnimationSpec.kt */
/* loaded from: classes.dex */
final class VectorizedFloatDecaySpec implements VectorizedDecayAnimationSpec {
    private final float absVelocityThreshold;
    private final FloatDecayAnimationSpec floatDecaySpec;
    private AnimationVector targetVector;
    private AnimationVector valueVector;
    private AnimationVector velocityVector;

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public float getAbsVelocityThreshold() {
        return this.absVelocityThreshold;
    }

    public VectorizedFloatDecaySpec(FloatDecayAnimationSpec floatDecaySpec) {
        Intrinsics.checkNotNullParameter(floatDecaySpec, "floatDecaySpec");
        this.floatDecaySpec = floatDecaySpec;
        this.absVelocityThreshold = floatDecaySpec.getAbsVelocityThreshold();
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public AnimationVector getValueFromNanos(long j, AnimationVector initialValue, AnimationVector initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        if (this.valueVector == null) {
            this.valueVector = AnimationVectorsKt.newInstance(initialValue);
        }
        AnimationVector animationVector = this.valueVector;
        if (animationVector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            animationVector = null;
        }
        int size$animation_core_release = animationVector.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            AnimationVector animationVector2 = this.valueVector;
            if (animationVector2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                animationVector2 = null;
            }
            animationVector2.set$animation_core_release(i, this.floatDecaySpec.getValueFromNanos(j, initialValue.get$animation_core_release(i), initialVelocity.get$animation_core_release(i)));
        }
        AnimationVector animationVector3 = this.valueVector;
        if (animationVector3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            return null;
        }
        return animationVector3;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public long getDurationNanos(AnimationVector initialValue, AnimationVector initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        if (this.velocityVector == null) {
            this.velocityVector = AnimationVectorsKt.newInstance(initialValue);
        }
        AnimationVector animationVector = this.velocityVector;
        if (animationVector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            animationVector = null;
        }
        int size$animation_core_release = animationVector.getSize$animation_core_release();
        long j = 0;
        for (int i = 0; i < size$animation_core_release; i++) {
            j = Math.max(j, this.floatDecaySpec.getDurationNanos(initialValue.get$animation_core_release(i), initialVelocity.get$animation_core_release(i)));
        }
        return j;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public AnimationVector getVelocityFromNanos(long j, AnimationVector initialValue, AnimationVector initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        if (this.velocityVector == null) {
            this.velocityVector = AnimationVectorsKt.newInstance(initialValue);
        }
        AnimationVector animationVector = this.velocityVector;
        if (animationVector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            animationVector = null;
        }
        int size$animation_core_release = animationVector.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            AnimationVector animationVector2 = this.velocityVector;
            if (animationVector2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                animationVector2 = null;
            }
            animationVector2.set$animation_core_release(i, this.floatDecaySpec.getVelocityFromNanos(j, initialValue.get$animation_core_release(i), initialVelocity.get$animation_core_release(i)));
        }
        AnimationVector animationVector3 = this.velocityVector;
        if (animationVector3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            return null;
        }
        return animationVector3;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public AnimationVector getTargetValue(AnimationVector initialValue, AnimationVector initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        if (this.targetVector == null) {
            this.targetVector = AnimationVectorsKt.newInstance(initialValue);
        }
        AnimationVector animationVector = this.targetVector;
        if (animationVector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("targetVector");
            animationVector = null;
        }
        int size$animation_core_release = animationVector.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            AnimationVector animationVector2 = this.targetVector;
            if (animationVector2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("targetVector");
                animationVector2 = null;
            }
            animationVector2.set$animation_core_release(i, this.floatDecaySpec.getTargetValue(initialValue.get$animation_core_release(i), initialVelocity.get$animation_core_release(i)));
        }
        AnimationVector animationVector3 = this.targetVector;
        if (animationVector3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("targetVector");
            return null;
        }
        return animationVector3;
    }
}
