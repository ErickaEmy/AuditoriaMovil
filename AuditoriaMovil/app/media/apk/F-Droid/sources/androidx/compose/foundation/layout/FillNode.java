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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: Size.kt */
/* loaded from: classes.dex */
final class FillNode extends Modifier.Node implements LayoutModifierNode {
    private Direction direction;
    private float fraction;

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

    public final void setDirection(Direction direction) {
        Intrinsics.checkNotNullParameter(direction, "<set-?>");
        this.direction = direction;
    }

    public final void setFraction(float f) {
        this.fraction = f;
    }

    public FillNode(Direction direction, float f) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.direction = direction;
        this.fraction = f;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo117measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        int m1874getMinWidthimpl;
        int m1872getMaxWidthimpl;
        int m1871getMaxHeightimpl;
        int i;
        int roundToInt;
        int roundToInt2;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (Constraints.m1868getHasBoundedWidthimpl(j) && this.direction != Direction.Vertical) {
            roundToInt2 = MathKt__MathJVMKt.roundToInt(Constraints.m1872getMaxWidthimpl(j) * this.fraction);
            m1874getMinWidthimpl = RangesKt___RangesKt.coerceIn(roundToInt2, Constraints.m1874getMinWidthimpl(j), Constraints.m1872getMaxWidthimpl(j));
            m1872getMaxWidthimpl = m1874getMinWidthimpl;
        } else {
            m1874getMinWidthimpl = Constraints.m1874getMinWidthimpl(j);
            m1872getMaxWidthimpl = Constraints.m1872getMaxWidthimpl(j);
        }
        if (Constraints.m1867getHasBoundedHeightimpl(j) && this.direction != Direction.Horizontal) {
            roundToInt = MathKt__MathJVMKt.roundToInt(Constraints.m1871getMaxHeightimpl(j) * this.fraction);
            i = RangesKt___RangesKt.coerceIn(roundToInt, Constraints.m1873getMinHeightimpl(j), Constraints.m1871getMaxHeightimpl(j));
            m1871getMaxHeightimpl = i;
        } else {
            int m1873getMinHeightimpl = Constraints.m1873getMinHeightimpl(j);
            m1871getMaxHeightimpl = Constraints.m1871getMaxHeightimpl(j);
            i = m1873getMinHeightimpl;
        }
        final Placeable mo1251measureBRTryo0 = measurable.mo1251measureBRTryo0(ConstraintsKt.Constraints(m1874getMinWidthimpl, m1872getMaxWidthimpl, i, m1871getMaxHeightimpl));
        return MeasureScope.CC.layout$default(measure, mo1251measureBRTryo0.getWidth(), mo1251measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.FillNode$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Placeable.PlacementScope.placeRelative$default(layout, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
