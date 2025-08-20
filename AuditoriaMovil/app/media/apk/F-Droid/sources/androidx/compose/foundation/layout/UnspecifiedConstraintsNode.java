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
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: Size.kt */
/* loaded from: classes.dex */
final class UnspecifiedConstraintsNode extends Modifier.Node implements LayoutModifierNode {
    private float minHeight;
    private float minWidth;

    public /* synthetic */ UnspecifiedConstraintsNode(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    /* renamed from: setMinHeight-0680j_4  reason: not valid java name */
    public final void m241setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    /* renamed from: setMinWidth-0680j_4  reason: not valid java name */
    public final void m242setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    private UnspecifiedConstraintsNode(float f, float f2) {
        this.minWidth = f;
        this.minHeight = f2;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo117measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        int m1874getMinWidthimpl;
        int m1873getMinHeightimpl;
        int coerceAtMost;
        int coerceAtMost2;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        float f = this.minWidth;
        Dp.Companion companion = Dp.Companion;
        if (!Dp.m1899equalsimpl0(f, companion.m1905getUnspecifiedD9Ej5fM()) && Constraints.m1874getMinWidthimpl(j) == 0) {
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(measure.mo150roundToPx0680j_4(this.minWidth), Constraints.m1872getMaxWidthimpl(j));
            m1874getMinWidthimpl = RangesKt___RangesKt.coerceAtLeast(coerceAtMost2, 0);
        } else {
            m1874getMinWidthimpl = Constraints.m1874getMinWidthimpl(j);
        }
        int m1872getMaxWidthimpl = Constraints.m1872getMaxWidthimpl(j);
        if (!Dp.m1899equalsimpl0(this.minHeight, companion.m1905getUnspecifiedD9Ej5fM()) && Constraints.m1873getMinHeightimpl(j) == 0) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(measure.mo150roundToPx0680j_4(this.minHeight), Constraints.m1871getMaxHeightimpl(j));
            m1873getMinHeightimpl = RangesKt___RangesKt.coerceAtLeast(coerceAtMost, 0);
        } else {
            m1873getMinHeightimpl = Constraints.m1873getMinHeightimpl(j);
        }
        final Placeable mo1251measureBRTryo0 = measurable.mo1251measureBRTryo0(ConstraintsKt.Constraints(m1874getMinWidthimpl, m1872getMaxWidthimpl, m1873getMinHeightimpl, Constraints.m1871getMaxHeightimpl(j)));
        return MeasureScope.CC.layout$default(measure, mo1251measureBRTryo0.getWidth(), mo1251measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.UnspecifiedConstraintsNode$measure$1
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

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(measurable.minIntrinsicWidth(i), !Dp.m1899equalsimpl0(this.minWidth, Dp.Companion.m1905getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo150roundToPx0680j_4(this.minWidth) : 0);
        return coerceAtLeast;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(measurable.maxIntrinsicWidth(i), !Dp.m1899equalsimpl0(this.minWidth, Dp.Companion.m1905getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo150roundToPx0680j_4(this.minWidth) : 0);
        return coerceAtLeast;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(measurable.minIntrinsicHeight(i), !Dp.m1899equalsimpl0(this.minHeight, Dp.Companion.m1905getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo150roundToPx0680j_4(this.minHeight) : 0);
        return coerceAtLeast;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(measurable.maxIntrinsicHeight(i), !Dp.m1899equalsimpl0(this.minHeight, Dp.Companion.m1905getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo150roundToPx0680j_4(this.minHeight) : 0);
        return coerceAtLeast;
    }
}
