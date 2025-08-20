package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Padding.kt */
/* loaded from: classes.dex */
public final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {
    private PaddingValues paddingValues;

    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
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

    public final void setPaddingValues(PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(paddingValues, "<set-?>");
        this.paddingValues = paddingValues;
    }

    public PaddingValuesModifier(PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        this.paddingValues = paddingValues;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo117measure3p2s80s(final MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        float f = 0;
        if (Dp.m1896compareTo0680j_4(this.paddingValues.mo219calculateLeftPaddingu2uoSUM(measure.getLayoutDirection()), Dp.m1897constructorimpl(f)) < 0 || Dp.m1896compareTo0680j_4(this.paddingValues.mo221calculateTopPaddingD9Ej5fM(), Dp.m1897constructorimpl(f)) < 0 || Dp.m1896compareTo0680j_4(this.paddingValues.mo220calculateRightPaddingu2uoSUM(measure.getLayoutDirection()), Dp.m1897constructorimpl(f)) < 0 || Dp.m1896compareTo0680j_4(this.paddingValues.mo218calculateBottomPaddingD9Ej5fM(), Dp.m1897constructorimpl(f)) < 0) {
            throw new IllegalArgumentException("Padding must be non-negative".toString());
        }
        int mo150roundToPx0680j_4 = measure.mo150roundToPx0680j_4(this.paddingValues.mo219calculateLeftPaddingu2uoSUM(measure.getLayoutDirection())) + measure.mo150roundToPx0680j_4(this.paddingValues.mo220calculateRightPaddingu2uoSUM(measure.getLayoutDirection()));
        int mo150roundToPx0680j_42 = measure.mo150roundToPx0680j_4(this.paddingValues.mo221calculateTopPaddingD9Ej5fM()) + measure.mo150roundToPx0680j_4(this.paddingValues.mo218calculateBottomPaddingD9Ej5fM());
        final Placeable mo1251measureBRTryo0 = measurable.mo1251measureBRTryo0(ConstraintsKt.m1885offsetNN6EwU(j, -mo150roundToPx0680j_4, -mo150roundToPx0680j_42));
        return MeasureScope.CC.layout$default(measure, ConstraintsKt.m1884constrainWidthK40F9xA(j, mo1251measureBRTryo0.getWidth() + mo150roundToPx0680j_4), ConstraintsKt.m1883constrainHeightK40F9xA(j, mo1251measureBRTryo0.getHeight() + mo150roundToPx0680j_42), null, new Function1() { // from class: androidx.compose.foundation.layout.PaddingValuesModifier$measure$2
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
                Placeable.PlacementScope.place$default(layout, Placeable.this, measure.mo150roundToPx0680j_4(this.getPaddingValues().mo219calculateLeftPaddingu2uoSUM(measure.getLayoutDirection())), measure.mo150roundToPx0680j_4(this.getPaddingValues().mo221calculateTopPaddingD9Ej5fM()), 0.0f, 4, null);
            }
        }, 4, null);
    }
}
