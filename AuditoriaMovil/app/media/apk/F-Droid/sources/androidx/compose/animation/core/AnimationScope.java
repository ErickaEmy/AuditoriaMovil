package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AnimationState.kt */
/* loaded from: classes.dex */
public final class AnimationScope {
    private long finishedTimeNanos;
    private final MutableState isRunning$delegate;
    private long lastFrameTimeNanos;
    private final Function0 onCancel;
    private final long startTimeNanos;
    private final Object targetValue;
    private final TwoWayConverter typeConverter;
    private final MutableState value$delegate;
    private AnimationVector velocityVector;

    public final long getFinishedTimeNanos() {
        return this.finishedTimeNanos;
    }

    public final long getLastFrameTimeNanos() {
        return this.lastFrameTimeNanos;
    }

    public final long getStartTimeNanos() {
        return this.startTimeNanos;
    }

    public final AnimationVector getVelocityVector() {
        return this.velocityVector;
    }

    public final void setFinishedTimeNanos$animation_core_release(long j) {
        this.finishedTimeNanos = j;
    }

    public final void setLastFrameTimeNanos$animation_core_release(long j) {
        this.lastFrameTimeNanos = j;
    }

    public final void setVelocityVector$animation_core_release(AnimationVector animationVector) {
        Intrinsics.checkNotNullParameter(animationVector, "<set-?>");
        this.velocityVector = animationVector;
    }

    public final Object getValue() {
        return this.value$delegate.getValue();
    }

    public final boolean isRunning() {
        return ((Boolean) this.isRunning$delegate.getValue()).booleanValue();
    }

    public final void setValue$animation_core_release(Object obj) {
        this.value$delegate.setValue(obj);
    }

    public AnimationScope(Object obj, TwoWayConverter typeConverter, AnimationVector initialVelocityVector, long j, Object obj2, long j2, boolean z, Function0 onCancel) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(initialVelocityVector, "initialVelocityVector");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        this.typeConverter = typeConverter;
        this.targetValue = obj2;
        this.startTimeNanos = j2;
        this.onCancel = onCancel;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
        this.value$delegate = mutableStateOf$default;
        this.velocityVector = AnimationVectorsKt.copy(initialVelocityVector);
        this.lastFrameTimeNanos = j;
        this.finishedTimeNanos = Long.MIN_VALUE;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), null, 2, null);
        this.isRunning$delegate = mutableStateOf$default2;
    }

    public final void setRunning$animation_core_release(boolean z) {
        this.isRunning$delegate.setValue(Boolean.valueOf(z));
    }

    public final Object getVelocity() {
        return this.typeConverter.getConvertFromVector().invoke(this.velocityVector);
    }

    public final void cancelAnimation() {
        setRunning$animation_core_release(false);
        this.onCancel.invoke();
    }
}
