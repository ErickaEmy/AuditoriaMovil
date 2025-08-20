package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: FloatAnimationSpec.kt */
/* loaded from: classes.dex */
public interface FloatAnimationSpec extends AnimationSpec {
    long getDurationNanos(float f, float f2, float f3);

    float getEndVelocity(float f, float f2, float f3);

    float getValueFromNanos(long j, float f, float f2, float f3);

    float getVelocityFromNanos(long j, float f, float f2, float f3);

    @Override // androidx.compose.animation.core.AnimationSpec
    VectorizedFloatAnimationSpec vectorize(TwoWayConverter twoWayConverter);

    /* compiled from: FloatAnimationSpec.kt */
    /* renamed from: androidx.compose.animation.core.FloatAnimationSpec$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        /* renamed from: $default$vectorize  reason: collision with other method in class */
        public static VectorizedFloatAnimationSpec m32$default$vectorize(FloatAnimationSpec floatAnimationSpec, TwoWayConverter converter) {
            Intrinsics.checkNotNullParameter(converter, "converter");
            return new VectorizedFloatAnimationSpec(floatAnimationSpec);
        }
    }
}
