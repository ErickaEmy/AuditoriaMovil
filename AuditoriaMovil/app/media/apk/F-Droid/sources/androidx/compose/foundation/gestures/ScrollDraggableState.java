package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.runtime.State;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Scrollable.kt */
/* loaded from: classes.dex */
public final class ScrollDraggableState implements DraggableState, DragScope {
    private ScrollScope latestScrollScope;
    private final State scrollLogic;

    public final void setLatestScrollScope(ScrollScope scrollScope) {
        Intrinsics.checkNotNullParameter(scrollScope, "<set-?>");
        this.latestScrollScope = scrollScope;
    }

    public ScrollDraggableState(State scrollLogic) {
        ScrollScope scrollScope;
        Intrinsics.checkNotNullParameter(scrollLogic, "scrollLogic");
        this.scrollLogic = scrollLogic;
        scrollScope = ScrollableKt.NoOpScrollScope;
        this.latestScrollScope = scrollScope;
    }

    @Override // androidx.compose.foundation.gestures.DragScope
    public void dragBy(float f) {
        ScrollingLogic scrollingLogic = (ScrollingLogic) this.scrollLogic.getValue();
        scrollingLogic.m164dispatchScroll3eAAhYA(this.latestScrollScope, scrollingLogic.m173toOffsettuRUvjQ(f), NestedScrollSource.Companion.m1158getDragWNlRxjI());
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public Object drag(MutatePriority mutatePriority, Function2 function2, Continuation continuation) {
        Object coroutine_suspended;
        Object scroll = ((ScrollingLogic) this.scrollLogic.getValue()).getScrollableState().scroll(mutatePriority, new ScrollDraggableState$drag$2(this, function2, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return scroll == coroutine_suspended ? scroll : Unit.INSTANCE;
    }
}
