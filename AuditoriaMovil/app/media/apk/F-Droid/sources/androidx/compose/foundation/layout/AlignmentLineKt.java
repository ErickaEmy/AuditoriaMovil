package androidx.compose.foundation.layout;

import androidx.appcompat.app.ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: AlignmentLine.kt */
/* loaded from: classes.dex */
public abstract class AlignmentLineKt {
    /* renamed from: paddingFrom-4j6BHR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m183paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Dp.Companion.m1905getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f2 = Dp.Companion.m1905getUnspecifiedD9Ej5fM();
        }
        return m182paddingFrom4j6BHR0(modifier, alignmentLine, f, f2);
    }

    /* renamed from: paddingFrom-4j6BHR0  reason: not valid java name */
    public static final Modifier m182paddingFrom4j6BHR0(Modifier paddingFrom, final AlignmentLine alignmentLine, final float f, final float f2) {
        Intrinsics.checkNotNullParameter(paddingFrom, "$this$paddingFrom");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return paddingFrom.then(new AlignmentLineOffsetDpElement(alignmentLine, f, f2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-4j6BHR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
                invoke((InspectorInfo) null);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                throw null;
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: paddingFromBaseline-VpY3zN4  reason: not valid java name */
    public static final Modifier m184paddingFromBaselineVpY3zN4(Modifier paddingFromBaseline, float f, float f2) {
        Modifier modifier;
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(paddingFromBaseline, "$this$paddingFromBaseline");
        Dp.Companion companion = Dp.Companion;
        if (!Dp.m1899equalsimpl0(f, companion.m1905getUnspecifiedD9Ej5fM())) {
            modifier = m183paddingFrom4j6BHR0$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), f, 0.0f, 4, null);
        } else {
            modifier = Modifier.Companion;
        }
        Modifier then = paddingFromBaseline.then(modifier);
        if (!Dp.m1899equalsimpl0(f2, companion.m1905getUnspecifiedD9Ej5fM())) {
            modifier2 = m183paddingFrom4j6BHR0$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, f2, 2, null);
        } else {
            modifier2 = Modifier.Companion;
        }
        return then.then(modifier2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: alignmentLineOffsetMeasure-tjqqzMA  reason: not valid java name */
    public static final MeasureResult m181alignmentLineOffsetMeasuretjqqzMA(MeasureScope measureScope, final AlignmentLine alignmentLine, final float f, float f2, Measurable measurable, long j) {
        final int coerceIn;
        final int coerceIn2;
        int max;
        int height;
        final Placeable mo1251measureBRTryo0 = measurable.mo1251measureBRTryo0(getHorizontal(alignmentLine) ? Constraints.m1863copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null) : Constraints.m1863copyZbe2FdA$default(j, 0, 0, 0, 0, 14, null));
        int i = mo1251measureBRTryo0.get(alignmentLine);
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        int height2 = getHorizontal(alignmentLine) ? mo1251measureBRTryo0.getHeight() : mo1251measureBRTryo0.getWidth();
        int m1871getMaxHeightimpl = getHorizontal(alignmentLine) ? Constraints.m1871getMaxHeightimpl(j) : Constraints.m1872getMaxWidthimpl(j);
        Dp.Companion companion = Dp.Companion;
        int i2 = m1871getMaxHeightimpl - height2;
        coerceIn = RangesKt___RangesKt.coerceIn((!Dp.m1899equalsimpl0(f, companion.m1905getUnspecifiedD9Ej5fM()) ? measureScope.mo150roundToPx0680j_4(f) : 0) - i, 0, i2);
        coerceIn2 = RangesKt___RangesKt.coerceIn(((!Dp.m1899equalsimpl0(f2, companion.m1905getUnspecifiedD9Ej5fM()) ? measureScope.mo150roundToPx0680j_4(f2) : 0) - height2) + i, 0, i2 - coerceIn);
        if (getHorizontal(alignmentLine)) {
            max = mo1251measureBRTryo0.getWidth();
        } else {
            max = Math.max(mo1251measureBRTryo0.getWidth() + coerceIn + coerceIn2, Constraints.m1874getMinWidthimpl(j));
        }
        final int i3 = max;
        if (getHorizontal(alignmentLine)) {
            height = Math.max(mo1251measureBRTryo0.getHeight() + coerceIn + coerceIn2, Constraints.m1873getMinHeightimpl(j));
        } else {
            height = mo1251measureBRTryo0.getHeight();
        }
        final int i4 = height;
        return MeasureScope.CC.layout$default(measureScope, i3, i4, null, new Function1() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$alignmentLineOffsetMeasure$1
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
                boolean horizontal;
                int width;
                boolean horizontal2;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                horizontal = AlignmentLineKt.getHorizontal(AlignmentLine.this);
                int i5 = 0;
                if (horizontal) {
                    width = 0;
                } else {
                    width = !Dp.m1899equalsimpl0(f, Dp.Companion.m1905getUnspecifiedD9Ej5fM()) ? coerceIn : (i3 - coerceIn2) - mo1251measureBRTryo0.getWidth();
                }
                horizontal2 = AlignmentLineKt.getHorizontal(AlignmentLine.this);
                if (horizontal2) {
                    i5 = !Dp.m1899equalsimpl0(f, Dp.Companion.m1905getUnspecifiedD9Ej5fM()) ? coerceIn : (i4 - coerceIn2) - mo1251measureBRTryo0.getHeight();
                }
                Placeable.PlacementScope.placeRelative$default(layout, mo1251measureBRTryo0, width, i5, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHorizontal(AlignmentLine alignmentLine) {
        return alignmentLine instanceof HorizontalAlignmentLine;
    }
}
