package androidx.compose.animation.core;

import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AnimationState.kt */
/* loaded from: classes.dex */
public abstract class AnimationStateKt {
    public static /* synthetic */ AnimationState copy$default(AnimationState animationState, Object obj, AnimationVector animationVector, long j, long j2, boolean z, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = animationState.getValue();
        }
        if ((i & 2) != 0) {
            animationVector = AnimationVectorsKt.copy(animationState.getVelocityVector());
        }
        AnimationVector animationVector2 = animationVector;
        if ((i & 4) != 0) {
            j = animationState.getLastFrameTimeNanos();
        }
        long j3 = j;
        if ((i & 8) != 0) {
            j2 = animationState.getFinishedTimeNanos();
        }
        long j4 = j2;
        if ((i & 16) != 0) {
            z = animationState.isRunning();
        }
        return copy(animationState, obj, animationVector2, j3, j4, z);
    }

    public static final AnimationState copy(AnimationState animationState, Object obj, AnimationVector animationVector, long j, long j2, boolean z) {
        Intrinsics.checkNotNullParameter(animationState, "<this>");
        return new AnimationState(animationState.getTypeConverter(), obj, animationVector, j, j2, z);
    }

    public static /* synthetic */ AnimationState AnimationState$default(float f, float f2, long j, long j2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        long j3 = (i & 4) != 0 ? Long.MIN_VALUE : j;
        long j4 = (i & 8) == 0 ? j2 : Long.MIN_VALUE;
        if ((i & 16) != 0) {
            z = false;
        }
        return AnimationState(f, f2, j3, j4, z);
    }

    public static final AnimationState AnimationState(float f, float f2, long j, long j2, boolean z) {
        return new AnimationState(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(f), AnimationVectorsKt.AnimationVector(f2), j, j2, z);
    }

    public static final AnimationVector createZeroVectorFrom(TwoWayConverter twoWayConverter, Object obj) {
        Intrinsics.checkNotNullParameter(twoWayConverter, "<this>");
        return AnimationVectorsKt.newInstance((AnimationVector) twoWayConverter.getConvertToVector().invoke(obj));
    }
}
