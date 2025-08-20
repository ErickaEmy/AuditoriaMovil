package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
/* compiled from: Transition.kt */
/* loaded from: classes.dex */
public final class MutableTransitionState {
    public static final int $stable = 0;
    private final MutableState currentState$delegate;
    private final MutableState isRunning$delegate;
    private final MutableState targetState$delegate;

    public final Object getCurrentState() {
        return this.currentState$delegate.getValue();
    }

    public final Object getTargetState() {
        return this.targetState$delegate.getValue();
    }

    public MutableTransitionState(Object obj) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
        this.currentState$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
        this.targetState$delegate = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.isRunning$delegate = mutableStateOf$default3;
    }

    public final void setCurrentState$animation_core_release(Object obj) {
        this.currentState$delegate.setValue(obj);
    }

    public final void setTargetState(Object obj) {
        this.targetState$delegate.setValue(obj);
    }

    public final void setRunning$animation_core_release(boolean z) {
        this.isRunning$delegate.setValue(Boolean.valueOf(z));
    }
}
