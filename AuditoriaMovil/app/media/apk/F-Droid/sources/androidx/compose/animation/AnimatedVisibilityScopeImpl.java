package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AnimatedVisibility.kt */
/* loaded from: classes.dex */
public final class AnimatedVisibilityScopeImpl implements AnimatedVisibilityScope {
    private final MutableState targetSize;
    private Transition transition;

    public final MutableState getTargetSize$animation_release() {
        return this.targetSize;
    }

    public AnimatedVisibilityScopeImpl(Transition transition) {
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(transition, "transition");
        this.transition = transition;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m1946boximpl(IntSize.Companion.m1955getZeroYbymL2g()), null, 2, null);
        this.targetSize = mutableStateOf$default;
    }
}
