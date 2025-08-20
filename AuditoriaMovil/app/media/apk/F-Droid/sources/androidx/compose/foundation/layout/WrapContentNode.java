package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: Size.kt */
/* loaded from: classes.dex */
final class WrapContentNode extends Modifier.Node implements LayoutModifierNode {
    private Function2 alignmentCallback;
    private Direction direction;
    private boolean unbounded;

    public final Function2 getAlignmentCallback() {
        return this.alignmentCallback;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public final void setAlignmentCallback(Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.alignmentCallback = function2;
    }

    public final void setDirection(Direction direction) {
        Intrinsics.checkNotNullParameter(direction, "<set-?>");
        this.direction = direction;
    }

    public final void setUnbounded(boolean z) {
        this.unbounded = z;
    }

    public WrapContentNode(Direction direction, boolean z, Function2 alignmentCallback) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(alignmentCallback, "alignmentCallback");
        this.direction = direction;
        this.unbounded = z;
        this.alignmentCallback = alignmentCallback;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo117measure3p2s80s(final MeasureScope measure, Measurable measurable, long j) {
        final int coerceIn;
        final int coerceIn2;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Direction direction = this.direction;
        Direction direction2 = Direction.Vertical;
        int m1874getMinWidthimpl = direction != direction2 ? 0 : Constraints.m1874getMinWidthimpl(j);
        Direction direction3 = this.direction;
        Direction direction4 = Direction.Horizontal;
        int m1873getMinHeightimpl = direction3 == direction4 ? Constraints.m1873getMinHeightimpl(j) : 0;
        int i = Integer.MAX_VALUE;
        int m1872getMaxWidthimpl = (this.direction == direction2 || !this.unbounded) ? Constraints.m1872getMaxWidthimpl(j) : Integer.MAX_VALUE;
        if (this.direction == direction4 || !this.unbounded) {
            i = Constraints.m1871getMaxHeightimpl(j);
        }
        final Placeable mo1251measureBRTryo0 = measurable.mo1251measureBRTryo0(ConstraintsKt.Constraints(m1874getMinWidthimpl, m1872getMaxWidthimpl, m1873getMinHeightimpl, i));
        coerceIn = RangesKt___RangesKt.coerceIn(mo1251measureBRTryo0.getWidth(), Constraints.m1874getMinWidthimpl(j), Constraints.m1872getMaxWidthimpl(j));
        coerceIn2 = RangesKt___RangesKt.coerceIn(mo1251measureBRTryo0.getHeight(), Constraints.m1873getMinHeightimpl(j), Constraints.m1871getMaxHeightimpl(j));
        return MeasureScope.CC.layout$default(measure, coerceIn, coerceIn2, null, new Function1() { // from class: androidx.compose.foundation.layout.WrapContentNode$measure$1
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
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable.PlacementScope.m1272place70tqf50$default(layout, mo1251measureBRTryo0, ((IntOffset) WrapContentNode.this.getAlignmentCallback().invoke(IntSize.m1946boximpl(IntSizeKt.IntSize(coerceIn - mo1251measureBRTryo0.getWidth(), coerceIn2 - mo1251measureBRTryo0.getHeight())), measure.getLayoutDirection())).m1941unboximpl(), 0.0f, 2, null);
            }
        }, 4, null);
    }
}
