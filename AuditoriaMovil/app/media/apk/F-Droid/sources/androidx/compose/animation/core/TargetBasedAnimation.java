package androidx.compose.animation.core;

import androidx.compose.animation.core.Animation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Animation.kt */
/* loaded from: classes.dex */
public final class TargetBasedAnimation implements Animation {
    private final VectorizedAnimationSpec animationSpec;
    private final long durationNanos;
    private final AnimationVector endVelocity;
    private final Object initialValue;
    private final AnimationVector initialValueVector;
    private final AnimationVector initialVelocityVector;
    private final Object targetValue;
    private final AnimationVector targetValueVector;
    private final TwoWayConverter typeConverter;

    @Override // androidx.compose.animation.core.Animation
    public long getDurationNanos() {
        return this.durationNanos;
    }

    public final Object getInitialValue() {
        return this.initialValue;
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

    public TargetBasedAnimation(VectorizedAnimationSpec animationSpec, TwoWayConverter typeConverter, Object obj, Object obj2, AnimationVector animationVector) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        this.animationSpec = animationSpec;
        this.typeConverter = typeConverter;
        this.initialValue = obj;
        this.targetValue = obj2;
        AnimationVector animationVector2 = (AnimationVector) getTypeConverter().getConvertToVector().invoke(obj);
        this.initialValueVector = animationVector2;
        AnimationVector animationVector3 = (AnimationVector) getTypeConverter().getConvertToVector().invoke(getTargetValue());
        this.targetValueVector = animationVector3;
        AnimationVector newInstance = (animationVector == null || (newInstance = AnimationVectorsKt.copy(animationVector)) == null) ? AnimationVectorsKt.newInstance((AnimationVector) getTypeConverter().getConvertToVector().invoke(obj)) : newInstance;
        this.initialVelocityVector = newInstance;
        this.durationNanos = animationSpec.getDurationNanos(animationVector2, animationVector3, newInstance);
        this.endVelocity = animationSpec.getEndVelocity(animationVector2, animationVector3, newInstance);
    }

    public /* synthetic */ TargetBasedAnimation(AnimationSpec animationSpec, TwoWayConverter twoWayConverter, Object obj, Object obj2, AnimationVector animationVector, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(animationSpec, twoWayConverter, obj, obj2, (i & 16) != 0 ? null : animationVector);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TargetBasedAnimation(AnimationSpec animationSpec, TwoWayConverter typeConverter, Object obj, Object obj2, AnimationVector animationVector) {
        this(animationSpec.vectorize(typeConverter), typeConverter, obj, obj2, animationVector);
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
    }

    @Override // androidx.compose.animation.core.Animation
    public boolean isInfinite() {
        return this.animationSpec.isInfinite();
    }

    @Override // androidx.compose.animation.core.Animation
    public Object getValueFromNanos(long j) {
        if (!isFinishedFromNanos(j)) {
            AnimationVector valueFromNanos = this.animationSpec.getValueFromNanos(j, this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
            int size$animation_core_release = valueFromNanos.getSize$animation_core_release();
            for (int i = 0; i < size$animation_core_release; i++) {
                if (!(!Float.isNaN(valueFromNanos.get$animation_core_release(i)))) {
                    throw new IllegalStateException(("AnimationVector cannot contain a NaN. " + valueFromNanos + ". Animation: " + this + ", playTimeNanos: " + j).toString());
                }
            }
            return getTypeConverter().getConvertFromVector().invoke(valueFromNanos);
        }
        return getTargetValue();
    }

    @Override // androidx.compose.animation.core.Animation
    public AnimationVector getVelocityVectorFromNanos(long j) {
        return !isFinishedFromNanos(j) ? this.animationSpec.getVelocityFromNanos(j, this.initialValueVector, this.targetValueVector, this.initialVelocityVector) : this.endVelocity;
    }

    public String toString() {
        return "TargetBasedAnimation: " + this.initialValue + " -> " + getTargetValue() + ",initial velocity: " + this.initialVelocityVector + ", duration: " + AnimationKt.getDurationMillis(this) + " ms,animationSpec: " + this.animationSpec;
    }
}
