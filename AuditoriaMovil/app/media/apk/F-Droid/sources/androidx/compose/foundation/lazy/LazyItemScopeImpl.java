package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LazyItemScopeImpl.kt */
/* loaded from: classes.dex */
public final class LazyItemScopeImpl implements LazyItemScope {
    private MutableIntState maxWidthState = SnapshotIntStateKt.mutableIntStateOf(Integer.MAX_VALUE);
    private MutableIntState maxHeightState = SnapshotIntStateKt.mutableIntStateOf(Integer.MAX_VALUE);

    public final void setMaxSize(int i, int i2) {
        this.maxWidthState.setIntValue(i);
        this.maxHeightState.setIntValue(i2);
    }

    @Override // androidx.compose.foundation.lazy.LazyItemScope
    public Modifier animateItemPlacement(Modifier modifier, FiniteAnimationSpec animationSpec) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return modifier.then(new AnimateItemPlacementElement(animationSpec));
    }
}
