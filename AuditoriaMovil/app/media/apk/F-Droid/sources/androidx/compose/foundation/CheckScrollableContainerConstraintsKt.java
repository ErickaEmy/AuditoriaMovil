package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CheckScrollableContainerConstraints.kt */
/* loaded from: classes.dex */
public abstract class CheckScrollableContainerConstraintsKt {
    /* renamed from: checkScrollableContainerConstraints-K40F9xA  reason: not valid java name */
    public static final void m90checkScrollableContainerConstraintsK40F9xA(long j, Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == Orientation.Vertical) {
            if (Constraints.m1871getMaxHeightimpl(j) == Integer.MAX_VALUE) {
                throw new IllegalStateException("Vertically scrollable component was measured with an infinity maximum height constraints, which is disallowed. One of the common reasons is nesting layouts like LazyColumn and Column(Modifier.verticalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyColumn scope. There are could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.".toString());
            }
        } else if (Constraints.m1872getMaxWidthimpl(j) == Integer.MAX_VALUE) {
            throw new IllegalStateException("Horizontally scrollable component was measured with an infinity maximum width constraints, which is disallowed. One of the common reasons is nesting layouts like LazyRow and Row(Modifier.horizontalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyRow scope. There are could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.".toString());
        }
    }
}
