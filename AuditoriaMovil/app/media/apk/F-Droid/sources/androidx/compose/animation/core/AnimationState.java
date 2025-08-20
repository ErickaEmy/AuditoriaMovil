package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AnimationState.kt */
/* loaded from: classes.dex */
public final class AnimationState implements State {
    private long finishedTimeNanos;
    private boolean isRunning;
    private long lastFrameTimeNanos;
    private final TwoWayConverter typeConverter;
    private final MutableState value$delegate;
    private AnimationVector velocityVector;

    public final long getFinishedTimeNanos() {
        return this.finishedTimeNanos;
    }

    public final long getLastFrameTimeNanos() {
        return this.lastFrameTimeNanos;
    }

    public final TwoWayConverter getTypeConverter() {
        return this.typeConverter;
    }

    public final AnimationVector getVelocityVector() {
        return this.velocityVector;
    }

    public final boolean isRunning() {
        return this.isRunning;
    }

    public final void setFinishedTimeNanos$animation_core_release(long j) {
        this.finishedTimeNanos = j;
    }

    public final void setLastFrameTimeNanos$animation_core_release(long j) {
        this.lastFrameTimeNanos = j;
    }

    public final void setRunning$animation_core_release(boolean z) {
        this.isRunning = z;
    }

    public final void setVelocityVector$animation_core_release(AnimationVector animationVector) {
        Intrinsics.checkNotNullParameter(animationVector, "<set-?>");
        this.velocityVector = animationVector;
    }

    public AnimationState(TwoWayConverter typeConverter, Object obj, AnimationVector animationVector, long j, long j2, boolean z) {
        MutableState mutableStateOf$default;
        AnimationVector createZeroVectorFrom;
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        this.typeConverter = typeConverter;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
        this.value$delegate = mutableStateOf$default;
        this.velocityVector = (animationVector == null || (createZeroVectorFrom = AnimationVectorsKt.copy(animationVector)) == null) ? AnimationStateKt.createZeroVectorFrom(typeConverter, obj) : createZeroVectorFrom;
        this.lastFrameTimeNanos = j;
        this.finishedTimeNanos = j2;
        this.isRunning = z;
    }

    public /* synthetic */ AnimationState(TwoWayConverter twoWayConverter, Object obj, AnimationVector animationVector, long j, long j2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(twoWayConverter, obj, (i & 4) != 0 ? null : animationVector, (i & 8) != 0 ? Long.MIN_VALUE : j, (i & 16) != 0 ? Long.MIN_VALUE : j2, (i & 32) != 0 ? false : z);
    }

    @Override // androidx.compose.runtime.State
    public Object getValue() {
        return this.value$delegate.getValue();
    }

    public final Object getVelocity() {
        return this.typeConverter.getConvertFromVector().invoke(this.velocityVector);
    }

    public String toString() {
        return "AnimationState(value=" + getValue() + ", velocity=" + getVelocity() + ", isRunning=" + this.isRunning + ", lastFrameTimeNanos=" + this.lastFrameTimeNanos + ", finishedTimeNanos=" + this.finishedTimeNanos + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public void setValue$animation_core_release(Object obj) {
        this.value$delegate.setValue(obj);
    }
}
