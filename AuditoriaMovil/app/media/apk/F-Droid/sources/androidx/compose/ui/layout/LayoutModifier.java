package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LayoutModifier.kt */
/* loaded from: classes.dex */
public interface LayoutModifier extends Modifier.Element {
    int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    /* renamed from: measure-3p2s80s */
    MeasureResult mo20measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j);

    int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    /* compiled from: LayoutModifier.kt */
    /* renamed from: androidx.compose.ui.layout.LayoutModifier$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static int $default$minIntrinsicWidth(LayoutModifier layoutModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            return MeasuringIntrinsics.INSTANCE.minWidth(layoutModifier, intrinsicMeasureScope, measurable, i);
        }

        public static int $default$minIntrinsicHeight(LayoutModifier layoutModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            return MeasuringIntrinsics.INSTANCE.minHeight(layoutModifier, intrinsicMeasureScope, measurable, i);
        }

        public static int $default$maxIntrinsicWidth(LayoutModifier layoutModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            return MeasuringIntrinsics.INSTANCE.maxWidth(layoutModifier, intrinsicMeasureScope, measurable, i);
        }

        public static int $default$maxIntrinsicHeight(LayoutModifier layoutModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            return MeasuringIntrinsics.INSTANCE.maxHeight(layoutModifier, intrinsicMeasureScope, measurable, i);
        }
    }
}
