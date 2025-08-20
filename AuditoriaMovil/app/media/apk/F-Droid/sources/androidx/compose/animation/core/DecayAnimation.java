package androidx.compose.animation.core;

import androidx.compose.animation.core.Animation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: Animation.kt */
/* loaded from: classes.dex */
public final class DecayAnimation implements Animation {
    private final VectorizedDecayAnimationSpec animationSpec;
    private final long durationNanos;
    private final AnimationVector endVelocity;
    private final Object initialValue;
    private final AnimationVector initialValueVector;
    private final AnimationVector initialVelocityVector;
    private final boolean isInfinite;
    private final Object targetValue;
    private final TwoWayConverter typeConverter;

    @Override // androidx.compose.animation.core.Animation
    public long getDurationNanos() {
        return this.durationNanos;
    }

    @Override // androidx.compose.animation.core.Animation
    public Object getTargetValue() {
        return this.targetValue;
    }

    @Override // androidx.compose.animation.core.Animation
    public TwoWayConverter getTypeConverter() {
        return this.typeConverter;
    }

    @Override // androidx.compose.animation.core.Animation
    public /* synthetic */ boolean isFinishedFromNanos(long j) {
        return Animation.CC.$default$isFinishedFromNanos(this, j);
    }

    @Override // androidx.compose.animation.core.Animation
    public boolean isInfinite() {
        return this.isInfinite;
    }

    public DecayAnimation(VectorizedDecayAnimationSpec animationSpec, TwoWayConverter typeConverter, Object obj, AnimationVector initialVelocityVector) {
        float coerceIn;
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(initialVelocityVector, "initialVelocityVector");
        this.animationSpec = animationSpec;
        this.typeConverter = typeConverter;
        this.initialValue = obj;
        AnimationVector animationVector = (AnimationVector) getTypeConverter().getConvertToVector().invoke(obj);
        this.initialValueVector = animationVector;
        this.initialVelocityVector = AnimationVectorsKt.copy(initialVelocityVector);
        this.targetValue = getTypeConverter().getConvertFromVector().invoke(animationSpec.getTargetValue(animationVector, initialVelocityVector));
        this.durationNanos = animationSpec.getDurationNanos(animationVector, initialVelocityVector);
        AnimationVector copy = AnimationVectorsKt.copy(animationSpec.getVelocityFromNanos(getDurationNanos(), animationVector, initialVelocityVector));
        this.endVelocity = copy;
        int size$animation_core_release = copy.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            AnimationVector animationVector2 = this.endVelocity;
            coerceIn = RangesKt___RangesKt.coerceIn(animationVector2.get$animation_core_release(i), -this.animationSpec.getAbsVelocityThreshold(), this.animationSpec.getAbsVelocityThreshold());
            animationVector2.set$animation_core_release(i, coerceIn);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DecayAnimation(DecayAnimationSpec animationSpec, TwoWayConverter typeConverter, Object obj, AnimationVector initialVelocityVector) {
        this(animationSpec.vectorize(typeConverter), typeConverter, obj, initialVelocityVector);
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(initialVelocityVector, "initialVelocityVector");
    }

    @Override // androidx.compose.animation.core.Animation
    public Object getValueFromNanos(long j) {
        if (!isFinishedFromNanos(j)) {
            return getTypeConverter().getConvertFromVector().invoke(this.animationSpec.getValueFromNanos(j, this.initialValueVector, this.initialVelocityVector));
        }
        return getTargetValue();
    }

    @Override // androidx.compose.animation.core.Animation
    public AnimationVector getVelocityVectorFromNanos(long j) {
        return !isFinishedFromNanos(j) ? this.animationSpec.getVelocityFromNanos(j, this.initialValueVector, this.initialVelocityVector) : this.endVelocity;
    }
}
