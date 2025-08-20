package androidx.compose.animation.core;
/* compiled from: VectorizedDecayAnimationSpec.kt */
/* loaded from: classes.dex */
public interface VectorizedDecayAnimationSpec {
    float getAbsVelocityThreshold();

    long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2);

    AnimationVector getTargetValue(AnimationVector animationVector, AnimationVector animationVector2);

    AnimationVector getValueFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2);

    AnimationVector getVelocityFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2);
}
