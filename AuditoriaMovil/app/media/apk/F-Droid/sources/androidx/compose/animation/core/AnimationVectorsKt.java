package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: AnimationVectors.kt */
/* loaded from: classes.dex */
public abstract class AnimationVectorsKt {
    public static final AnimationVector1D AnimationVector(float f) {
        return new AnimationVector1D(f);
    }

    public static final AnimationVector newInstance(AnimationVector animationVector) {
        Intrinsics.checkNotNullParameter(animationVector, "<this>");
        AnimationVector newVector$animation_core_release = animationVector.newVector$animation_core_release();
        Intrinsics.checkNotNull(newVector$animation_core_release, "null cannot be cast to non-null type T of androidx.compose.animation.core.AnimationVectorsKt.newInstance");
        return newVector$animation_core_release;
    }

    public static final AnimationVector copy(AnimationVector animationVector) {
        Intrinsics.checkNotNullParameter(animationVector, "<this>");
        AnimationVector newInstance = newInstance(animationVector);
        int size$animation_core_release = newInstance.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            newInstance.set$animation_core_release(i, animationVector.get$animation_core_release(i));
        }
        return newInstance;
    }

    public static final void copyFrom(AnimationVector animationVector, AnimationVector source) {
        Intrinsics.checkNotNullParameter(animationVector, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int size$animation_core_release = animationVector.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            animationVector.set$animation_core_release(i, source.get$animation_core_release(i));
        }
    }
}
