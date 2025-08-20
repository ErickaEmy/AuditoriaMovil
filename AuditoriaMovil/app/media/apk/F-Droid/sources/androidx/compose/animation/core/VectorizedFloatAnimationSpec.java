package androidx.compose.animation.core;

import androidx.compose.animation.core.VectorizedFiniteAnimationSpec;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: VectorizedAnimationSpec.kt */
/* loaded from: classes.dex */
public final class VectorizedFloatAnimationSpec implements VectorizedFiniteAnimationSpec {
    private final Animations anims;
    private AnimationVector endVelocityVector;
    private AnimationVector valueVector;
    private AnimationVector velocityVector;

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ boolean isInfinite() {
        return VectorizedFiniteAnimationSpec.CC.$default$isInfinite(this);
    }

    public VectorizedFloatAnimationSpec(Animations anims) {
        Intrinsics.checkNotNullParameter(anims, "anims");
        this.anims = anims;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VectorizedFloatAnimationSpec(final FloatAnimationSpec anim) {
        this(new Animations() { // from class: androidx.compose.animation.core.VectorizedFloatAnimationSpec.1
            @Override // androidx.compose.animation.core.Animations
            public FloatAnimationSpec get(int i) {
                return FloatAnimationSpec.this;
            }
        });
        Intrinsics.checkNotNullParameter(anim, "anim");
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getValueFromNanos(long j, AnimationVector initialValue, AnimationVector targetValue, AnimationVector initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
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
            animationVector2.set$animation_core_release(i, this.anims.get(i).getValueFromNanos(j, initialValue.get$animation_core_release(i), targetValue.get$animation_core_release(i), initialVelocity.get$animation_core_release(i)));
        }
        AnimationVector animationVector3 = this.valueVector;
        if (animationVector3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            return null;
        }
        return animationVector3;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getVelocityFromNanos(long j, AnimationVector initialValue, AnimationVector targetValue, AnimationVector initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        if (this.velocityVector == null) {
            this.velocityVector = AnimationVectorsKt.newInstance(initialVelocity);
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
            animationVector2.set$animation_core_release(i, this.anims.get(i).getVelocityFromNanos(j, initialValue.get$animation_core_release(i), targetValue.get$animation_core_release(i), initialVelocity.get$animation_core_release(i)));
        }
        AnimationVector animationVector3 = this.velocityVector;
        if (animationVector3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            return null;
        }
        return animationVector3;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getEndVelocity(AnimationVector initialValue, AnimationVector targetValue, AnimationVector initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        if (this.endVelocityVector == null) {
            this.endVelocityVector = AnimationVectorsKt.newInstance(initialVelocity);
        }
        AnimationVector animationVector = this.endVelocityVector;
        if (animationVector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
            animationVector = null;
        }
        int size$animation_core_release = animationVector.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            AnimationVector animationVector2 = this.endVelocityVector;
            if (animationVector2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
                animationVector2 = null;
            }
            animationVector2.set$animation_core_release(i, this.anims.get(i).getEndVelocity(initialValue.get$animation_core_release(i), targetValue.get$animation_core_release(i), initialVelocity.get$animation_core_release(i)));
        }
        AnimationVector animationVector3 = this.endVelocityVector;
        if (animationVector3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
            return null;
        }
        return animationVector3;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(AnimationVector initialValue, AnimationVector targetValue, AnimationVector initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        Iterator it = RangesKt.until(0, initialValue.getSize$animation_core_release()).iterator();
        long j = 0;
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            j = Math.max(j, this.anims.get(nextInt).getDurationNanos(initialValue.get$animation_core_release(nextInt), targetValue.get$animation_core_release(nextInt), initialVelocity.get$animation_core_release(nextInt)));
        }
        return j;
    }
}
