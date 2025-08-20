package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: Scroll.kt */
/* loaded from: classes.dex */
final class ScrollingLayoutNode extends Modifier.Node implements LayoutModifierNode {
    private boolean isReversed;
    private boolean isVertical;
    private ScrollState scrollerState;

    public final ScrollState getScrollerState() {
        return this.scrollerState;
    }

    public final boolean isReversed() {
        return this.isReversed;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final void setReversed(boolean z) {
        this.isReversed = z;
    }

    public final void setScrollerState(ScrollState scrollState) {
        Intrinsics.checkNotNullParameter(scrollState, "<set-?>");
        this.scrollerState = scrollState;
    }

    public final void setVertical(boolean z) {
        this.isVertical = z;
    }

    public ScrollingLayoutNode(ScrollState scrollerState, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(scrollerState, "scrollerState");
        this.scrollerState = scrollerState;
        this.isReversed = z;
        this.isVertical = z2;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult mo117measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        int coerceAtMost;
        int coerceAtMost2;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        CheckScrollableContainerConstraintsKt.m90checkScrollableContainerConstraintsK40F9xA(j, this.isVertical ? Orientation.Vertical : Orientation.Horizontal);
        final Placeable mo1251measureBRTryo0 = measurable.mo1251measureBRTryo0(Constraints.m1863copyZbe2FdA$default(j, 0, this.isVertical ? Constraints.m1872getMaxWidthimpl(j) : Integer.MAX_VALUE, 0, this.isVertical ? Integer.MAX_VALUE : Constraints.m1871getMaxHeightimpl(j), 5, null));
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(mo1251measureBRTryo0.getWidth(), Constraints.m1872getMaxWidthimpl(j));
        coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(mo1251measureBRTryo0.getHeight(), Constraints.m1871getMaxHeightimpl(j));
        final int height = mo1251measureBRTryo0.getHeight() - coerceAtMost2;
        int width = mo1251measureBRTryo0.getWidth() - coerceAtMost;
        if (!this.isVertical) {
            height = width;
        }
        this.scrollerState.setMaxValue$foundation_release(height);
        this.scrollerState.setViewportSize$foundation_release(this.isVertical ? coerceAtMost2 : coerceAtMost);
        return MeasureScope.CC.layout$default(measure, coerceAtMost, coerceAtMost2, null, new Function1() { // from class: androidx.compose.foundation.ScrollingLayoutNode$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope layout) {
                int coerceIn;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                coerceIn = RangesKt___RangesKt.coerceIn(ScrollingLayoutNode.this.getScrollerState().getValue(), 0, height);
                int i = ScrollingLayoutNode.this.isReversed() ? coerceIn - height : -coerceIn;
                Placeable.PlacementScope.placeRelativeWithLayer$default(layout, mo1251measureBRTryo0, ScrollingLayoutNode.this.isVertical() ? 0 : i, ScrollingLayoutNode.this.isVertical() ? i : 0, 0.0f, null, 12, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (this.isVertical) {
            return measurable.minIntrinsicWidth(Integer.MAX_VALUE);
        }
        return measurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (this.isVertical) {
            return measurable.minIntrinsicHeight(i);
        }
        return measurable.minIntrinsicHeight(Integer.MAX_VALUE);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (this.isVertical) {
            return measurable.maxIntrinsicWidth(Integer.MAX_VALUE);
        }
        return measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (this.isVertical) {
            return measurable.maxIntrinsicHeight(i);
        }
        return measurable.maxIntrinsicHeight(Integer.MAX_VALUE);
    }
}
