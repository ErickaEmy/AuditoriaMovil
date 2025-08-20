package androidx.compose.foundation.lazy;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: LazyListAnimateScrollScope.kt */
/* loaded from: classes.dex */
public final class LazyListAnimateScrollScope {
    private final int numOfItemsForTeleport;
    private final LazyListState state;

    public LazyListAnimateScrollScope(LazyListState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
        this.numOfItemsForTeleport = 100;
    }
}
