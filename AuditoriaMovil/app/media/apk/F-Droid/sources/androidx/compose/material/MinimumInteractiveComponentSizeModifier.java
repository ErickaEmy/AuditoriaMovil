package androidx.compose.material;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.DpSize;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InteractiveComponentSize.kt */
/* loaded from: classes.dex */
public final class MinimumInteractiveComponentSizeModifier implements LayoutModifier {
    private final long size;

    public /* synthetic */ MinimumInteractiveComponentSizeModifier(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return Modifier.Element.CC.$default$all(this, function1);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return Modifier.Element.CC.$default$foldIn(this, obj, function2);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifier.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifier.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifier.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifier.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    private MinimumInteractiveComponentSizeModifier(long j) {
        this.size = j;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo20measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo1251measureBRTryo0 = measurable.mo1251measureBRTryo0(j);
        final int max = Math.max(mo1251measureBRTryo0.getWidth(), measure.mo150roundToPx0680j_4(DpSize.m1923getWidthD9Ej5fM(this.size)));
        final int max2 = Math.max(mo1251measureBRTryo0.getHeight(), measure.mo150roundToPx0680j_4(DpSize.m1922getHeightD9Ej5fM(this.size)));
        return MeasureScope.CC.layout$default(measure, max, max2, null, new Function1() { // from class: androidx.compose.material.MinimumInteractiveComponentSizeModifier$measure$1
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
                int roundToInt;
                int roundToInt2;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                roundToInt = MathKt__MathJVMKt.roundToInt((max - mo1251measureBRTryo0.getWidth()) / 2.0f);
                roundToInt2 = MathKt__MathJVMKt.roundToInt((max2 - mo1251measureBRTryo0.getHeight()) / 2.0f);
                Placeable.PlacementScope.place$default(layout, mo1251measureBRTryo0, roundToInt, roundToInt2, 0.0f, 4, null);
            }
        }, 4, null);
    }

    public boolean equals(Object obj) {
        MinimumInteractiveComponentSizeModifier minimumInteractiveComponentSizeModifier = obj instanceof MinimumInteractiveComponentSizeModifier ? (MinimumInteractiveComponentSizeModifier) obj : null;
        if (minimumInteractiveComponentSizeModifier == null) {
            return false;
        }
        return DpSize.m1921equalsimpl0(this.size, minimumInteractiveComponentSizeModifier.size);
    }

    public int hashCode() {
        return DpSize.m1924hashCodeimpl(this.size);
    }
}
