package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: VectorizedAnimationSpec.kt */
/* loaded from: classes.dex */
public interface VectorizedDurationBasedAnimationSpec extends VectorizedFiniteAnimationSpec {
    int getDelayMillis();

    int getDurationMillis();

    /* compiled from: VectorizedAnimationSpec.kt */
    /* renamed from: androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static long $default$getDurationNanos(VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, AnimationVector initialValue, AnimationVector targetValue, AnimationVector initialVelocity) {
            Intrinsics.checkNotNullParameter(initialValue, "initialValue");
            Intrinsics.checkNotNullParameter(targetValue, "targetValue");
            Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
            return (vectorizedDurationBasedAnimationSpec.getDelayMillis() + vectorizedDurationBasedAnimationSpec.getDurationMillis()) * 1000000;
        }
    }
}
