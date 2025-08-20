package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Intrinsic.kt */
/* loaded from: classes.dex */
public interface IntrinsicSizeModifier extends LayoutModifier {
    /* renamed from: calculateContentConstraints-l58MMJ0  reason: not valid java name */
    long mo194calculateContentConstraintsl58MMJ0(MeasureScope measureScope, Measurable measurable, long j);

    boolean getEnforceIncoming();

    /* compiled from: Intrinsic.kt */
    /* renamed from: androidx.compose.foundation.layout.IntrinsicSizeModifier$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static boolean $default$getEnforceIncoming(IntrinsicSizeModifier intrinsicSizeModifier) {
            return true;
        }

        /* renamed from: $default$measure-3p2s80s  reason: not valid java name */
        public static MeasureResult m195$default$measure3p2s80s(IntrinsicSizeModifier intrinsicSizeModifier, MeasureScope measure, Measurable measurable, long j) {
            Intrinsics.checkNotNullParameter(measure, "$this$measure");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            long mo194calculateContentConstraintsl58MMJ0 = intrinsicSizeModifier.mo194calculateContentConstraintsl58MMJ0(measure, measurable, j);
            if (intrinsicSizeModifier.getEnforceIncoming()) {
                mo194calculateContentConstraintsl58MMJ0 = ConstraintsKt.m1882constrainN9IONVI(j, mo194calculateContentConstraintsl58MMJ0);
            }
            final Placeable mo1251measureBRTryo0 = measurable.mo1251measureBRTryo0(mo194calculateContentConstraintsl58MMJ0);
            return MeasureScope.CC.layout$default(measure, mo1251measureBRTryo0.getWidth(), mo1251measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.IntrinsicSizeModifier$measure$1
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
                    Placeable.PlacementScope.m1273placeRelative70tqf50$default(layout, Placeable.this, IntOffset.Companion.m1942getZeronOccac(), 0.0f, 2, null);
                }
            }, 4, null);
        }

        public static int $default$minIntrinsicWidth(IntrinsicSizeModifier intrinsicSizeModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            return measurable.minIntrinsicWidth(i);
        }

        public static int $default$minIntrinsicHeight(IntrinsicSizeModifier intrinsicSizeModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            return measurable.minIntrinsicHeight(i);
        }

        public static int $default$maxIntrinsicWidth(IntrinsicSizeModifier intrinsicSizeModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            return measurable.maxIntrinsicWidth(i);
        }

        public static int $default$maxIntrinsicHeight(IntrinsicSizeModifier intrinsicSizeModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            return measurable.maxIntrinsicHeight(i);
        }
    }
}
