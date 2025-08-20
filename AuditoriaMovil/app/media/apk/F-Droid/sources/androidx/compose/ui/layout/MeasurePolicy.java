package androidx.compose.ui.layout;

import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MeasurePolicy.kt */
/* loaded from: classes.dex */
public interface MeasurePolicy {
    int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i);

    int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i);

    /* renamed from: measure-3p2s80s */
    MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j);

    int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i);

    int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i);

    /* compiled from: MeasurePolicy.kt */
    /* renamed from: androidx.compose.ui.layout.MeasurePolicy$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static int $default$minIntrinsicWidth(MeasurePolicy measurePolicy, IntrinsicMeasureScope intrinsicMeasureScope, List measurables, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            ArrayList arrayList = new ArrayList(measurables.size());
            int size = measurables.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) measurables.get(i2), IntrinsicMinMax.Min, IntrinsicWidthHeight.Width));
            }
            return measurePolicy.mo13measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null)).getWidth();
        }

        public static int $default$minIntrinsicHeight(MeasurePolicy measurePolicy, IntrinsicMeasureScope intrinsicMeasureScope, List measurables, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            ArrayList arrayList = new ArrayList(measurables.size());
            int size = measurables.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) measurables.get(i2), IntrinsicMinMax.Min, IntrinsicWidthHeight.Height));
            }
            return measurePolicy.mo13measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null)).getHeight();
        }

        public static int $default$maxIntrinsicWidth(MeasurePolicy measurePolicy, IntrinsicMeasureScope intrinsicMeasureScope, List measurables, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            ArrayList arrayList = new ArrayList(measurables.size());
            int size = measurables.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) measurables.get(i2), IntrinsicMinMax.Max, IntrinsicWidthHeight.Width));
            }
            return measurePolicy.mo13measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null)).getWidth();
        }

        public static int $default$maxIntrinsicHeight(MeasurePolicy measurePolicy, IntrinsicMeasureScope intrinsicMeasureScope, List measurables, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            ArrayList arrayList = new ArrayList(measurables.size());
            int size = measurables.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) measurables.get(i2), IntrinsicMinMax.Max, IntrinsicWidthHeight.Height));
            }
            return measurePolicy.mo13measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null)).getHeight();
        }
    }
}
