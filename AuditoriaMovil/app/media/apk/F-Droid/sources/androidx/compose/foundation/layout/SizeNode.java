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
final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    private boolean enforceIncoming;
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;

    public /* synthetic */ SizeNode(float f, float f2, float f3, float f4, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z);
    }

    public final void setEnforceIncoming(boolean z) {
        this.enforceIncoming = z;
    }

    /* renamed from: setMaxHeight-0680j_4  reason: not valid java name */
    public final void m237setMaxHeight0680j_4(float f) {
        this.maxHeight = f;
    }

    /* renamed from: setMaxWidth-0680j_4  reason: not valid java name */
    public final void m238setMaxWidth0680j_4(float f) {
        this.maxWidth = f;
    }

    /* renamed from: setMinHeight-0680j_4  reason: not valid java name */
    public final void m239setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    /* renamed from: setMinWidth-0680j_4  reason: not valid java name */
    public final void m240setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    private SizeNode(float f, float f2, float f3, float f4, boolean z) {
        this.minWidth = f;
        this.minHeight = f2;
        this.maxWidth = f3;
        this.maxHeight = f4;
        this.enforceIncoming = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0050, code lost:
        if (r5 != Integer.MAX_VALUE) goto L11;
     */
    /* renamed from: getTargetConstraints-OenEA2s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long m236getTargetConstraintsOenEA2s(androidx.compose.ui.unit.Density r8) {
        /*
            r7 = this;
            float r0 = r7.maxWidth
            androidx.compose.ui.unit.Dp$Companion r1 = androidx.compose.ui.unit.Dp.Companion
            float r2 = r1.m1905getUnspecifiedD9Ej5fM()
            boolean r0 = androidx.compose.ui.unit.Dp.m1899equalsimpl0(r0, r2)
            r2 = 2147483647(0x7fffffff, float:NaN)
            r3 = 0
            if (r0 != 0) goto L1d
            float r0 = r7.maxWidth
            int r0 = r8.mo150roundToPx0680j_4(r0)
            int r0 = kotlin.ranges.RangesKt.coerceAtLeast(r0, r3)
            goto L1e
        L1d:
            r0 = r2
        L1e:
            float r4 = r7.maxHeight
            float r5 = r1.m1905getUnspecifiedD9Ej5fM()
            boolean r4 = androidx.compose.ui.unit.Dp.m1899equalsimpl0(r4, r5)
            if (r4 != 0) goto L35
            float r4 = r7.maxHeight
            int r4 = r8.mo150roundToPx0680j_4(r4)
            int r4 = kotlin.ranges.RangesKt.coerceAtLeast(r4, r3)
            goto L36
        L35:
            r4 = r2
        L36:
            float r5 = r7.minWidth
            float r6 = r1.m1905getUnspecifiedD9Ej5fM()
            boolean r5 = androidx.compose.ui.unit.Dp.m1899equalsimpl0(r5, r6)
            if (r5 != 0) goto L53
            float r5 = r7.minWidth
            int r5 = r8.mo150roundToPx0680j_4(r5)
            int r5 = kotlin.ranges.RangesKt.coerceAtMost(r5, r0)
            int r5 = kotlin.ranges.RangesKt.coerceAtLeast(r5, r3)
            if (r5 == r2) goto L53
            goto L54
        L53:
            r5 = r3
        L54:
            float r6 = r7.minHeight
            float r1 = r1.m1905getUnspecifiedD9Ej5fM()
            boolean r1 = androidx.compose.ui.unit.Dp.m1899equalsimpl0(r6, r1)
            if (r1 != 0) goto L71
            float r1 = r7.minHeight
            int r8 = r8.mo150roundToPx0680j_4(r1)
            int r8 = kotlin.ranges.RangesKt.coerceAtMost(r8, r4)
            int r8 = kotlin.ranges.RangesKt.coerceAtLeast(r8, r3)
            if (r8 == r2) goto L71
            r3 = r8
        L71:
            long r0 = androidx.compose.ui.unit.ConstraintsKt.Constraints(r5, r0, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.SizeNode.m236getTargetConstraintsOenEA2s(androidx.compose.ui.unit.Density):long");
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo117measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        int coerceAtMost;
        int coerceAtLeast;
        int coerceAtMost2;
        int coerceAtLeast2;
        long Constraints;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long m236getTargetConstraintsOenEA2s = m236getTargetConstraintsOenEA2s(measure);
        if (this.enforceIncoming) {
            Constraints = ConstraintsKt.m1882constrainN9IONVI(j, m236getTargetConstraintsOenEA2s);
        } else {
            float f = this.minWidth;
            Dp.Companion companion = Dp.Companion;
            if (!Dp.m1899equalsimpl0(f, companion.m1905getUnspecifiedD9Ej5fM())) {
                coerceAtMost = Constraints.m1874getMinWidthimpl(m236getTargetConstraintsOenEA2s);
            } else {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(Constraints.m1874getMinWidthimpl(j), Constraints.m1872getMaxWidthimpl(m236getTargetConstraintsOenEA2s));
            }
            if (!Dp.m1899equalsimpl0(this.maxWidth, companion.m1905getUnspecifiedD9Ej5fM())) {
                coerceAtLeast = Constraints.m1872getMaxWidthimpl(m236getTargetConstraintsOenEA2s);
            } else {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(Constraints.m1872getMaxWidthimpl(j), Constraints.m1874getMinWidthimpl(m236getTargetConstraintsOenEA2s));
            }
            if (!Dp.m1899equalsimpl0(this.minHeight, companion.m1905getUnspecifiedD9Ej5fM())) {
                coerceAtMost2 = Constraints.m1873getMinHeightimpl(m236getTargetConstraintsOenEA2s);
            } else {
                coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(Constraints.m1873getMinHeightimpl(j), Constraints.m1871getMaxHeightimpl(m236getTargetConstraintsOenEA2s));
            }
            if (!Dp.m1899equalsimpl0(this.maxHeight, companion.m1905getUnspecifiedD9Ej5fM())) {
                coerceAtLeast2 = Constraints.m1871getMaxHeightimpl(m236getTargetConstraintsOenEA2s);
            } else {
                coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(Constraints.m1871getMaxHeightimpl(j), Constraints.m1873getMinHeightimpl(m236getTargetConstraintsOenEA2s));
            }
            Constraints = ConstraintsKt.Constraints(coerceAtMost, coerceAtLeast, coerceAtMost2, coerceAtLeast2);
        }
        final Placeable mo1251measureBRTryo0 = measurable.mo1251measureBRTryo0(Constraints);
        return MeasureScope.CC.layout$default(measure, mo1251measureBRTryo0.getWidth(), mo1251measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.SizeNode$measure$1
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
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long m236getTargetConstraintsOenEA2s = m236getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m1870getHasFixedWidthimpl(m236getTargetConstraintsOenEA2s)) {
            return Constraints.m1872getMaxWidthimpl(m236getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m1884constrainWidthK40F9xA(m236getTargetConstraintsOenEA2s, measurable.minIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long m236getTargetConstraintsOenEA2s = m236getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m1869getHasFixedHeightimpl(m236getTargetConstraintsOenEA2s)) {
            return Constraints.m1871getMaxHeightimpl(m236getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m1883constrainHeightK40F9xA(m236getTargetConstraintsOenEA2s, measurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long m236getTargetConstraintsOenEA2s = m236getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m1870getHasFixedWidthimpl(m236getTargetConstraintsOenEA2s)) {
            return Constraints.m1872getMaxWidthimpl(m236getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m1884constrainWidthK40F9xA(m236getTargetConstraintsOenEA2s, measurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long m236getTargetConstraintsOenEA2s = m236getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m1869getHasFixedHeightimpl(m236getTargetConstraintsOenEA2s)) {
            return Constraints.m1871getMaxHeightimpl(m236getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m1883constrainHeightK40F9xA(m236getTargetConstraintsOenEA2s, measurable.maxIntrinsicHeight(i));
    }
}
