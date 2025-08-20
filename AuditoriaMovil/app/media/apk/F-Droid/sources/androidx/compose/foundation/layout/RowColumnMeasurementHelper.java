package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: RowColumnMeasurementHelper.kt */
/* loaded from: classes.dex */
public final class RowColumnMeasurementHelper {
    private final Function5 arrangement;
    private final float arrangementSpacing;
    private final CrossAxisAlignment crossAxisAlignment;
    private final SizeMode crossAxisSize;
    private final List measurables;
    private final LayoutOrientation orientation;
    private final Placeable[] placeables;
    private final RowColumnParentData[] rowColumnParentData;

    public /* synthetic */ RowColumnMeasurementHelper(LayoutOrientation layoutOrientation, Function5 function5, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment, List list, Placeable[] placeableArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutOrientation, function5, f, sizeMode, crossAxisAlignment, list, placeableArr);
    }

    private RowColumnMeasurementHelper(LayoutOrientation orientation, Function5 arrangement, float f, SizeMode crossAxisSize, CrossAxisAlignment crossAxisAlignment, List measurables, Placeable[] placeables) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(arrangement, "arrangement");
        Intrinsics.checkNotNullParameter(crossAxisSize, "crossAxisSize");
        Intrinsics.checkNotNullParameter(crossAxisAlignment, "crossAxisAlignment");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        Intrinsics.checkNotNullParameter(placeables, "placeables");
        this.orientation = orientation;
        this.arrangement = arrangement;
        this.arrangementSpacing = f;
        this.crossAxisSize = crossAxisSize;
        this.crossAxisAlignment = crossAxisAlignment;
        this.measurables = measurables;
        this.placeables = placeables;
        int size = measurables.size();
        RowColumnParentData[] rowColumnParentDataArr = new RowColumnParentData[size];
        for (int i = 0; i < size; i++) {
            rowColumnParentDataArr[i] = RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable) this.measurables.get(i));
        }
        this.rowColumnParentData = rowColumnParentDataArr;
    }

    public final int mainAxisSize(Placeable placeable) {
        Intrinsics.checkNotNullParameter(placeable, "<this>");
        return this.orientation == LayoutOrientation.Horizontal ? placeable.getWidth() : placeable.getHeight();
    }

    public final int crossAxisSize(Placeable placeable) {
        Intrinsics.checkNotNullParameter(placeable, "<this>");
        return this.orientation == LayoutOrientation.Horizontal ? placeable.getHeight() : placeable.getWidth();
    }

    /* renamed from: measureWithoutPlacing-_EkL_-Y  reason: not valid java name */
    public final RowColumnMeasureHelperResult m223measureWithoutPlacing_EkL_Y(MeasureScope measureScope, long j, int i, int i2) {
        long coerceAtLeast;
        IntRange until;
        int i3;
        int i4;
        long coerceIn;
        int i5;
        int i6;
        float f;
        int sign;
        int roundToInt;
        int roundToInt2;
        int i7;
        int i8;
        long coerceAtLeast2;
        int i9;
        int i10;
        int i11;
        long j2;
        long coerceAtLeast3;
        long coerceAtLeast4;
        int i12;
        int i13 = i2;
        Intrinsics.checkNotNullParameter(measureScope, "measureScope");
        long m198constructorimpl = OrientationIndependentConstraints.m198constructorimpl(j, this.orientation);
        long mo150roundToPx0680j_4 = measureScope.mo150roundToPx0680j_4(this.arrangementSpacing);
        int i14 = i13 - i;
        long j3 = 0;
        int i15 = i;
        long j4 = 0;
        float f2 = 0.0f;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        boolean z = false;
        while (true) {
            boolean z2 = true;
            if (i15 >= i13) {
                break;
            }
            Measurable measurable = (Measurable) this.measurables.get(i15);
            RowColumnParentData rowColumnParentData = this.rowColumnParentData[i15];
            float weight = RowColumnImplKt.getWeight(rowColumnParentData);
            if (weight > 0.0f) {
                f2 += weight;
                i18++;
                i10 = i15;
                j2 = j3;
            } else {
                int m1872getMaxWidthimpl = Constraints.m1872getMaxWidthimpl(m198constructorimpl);
                Placeable placeable = this.placeables[i15];
                if (placeable == null) {
                    if (m1872getMaxWidthimpl == Integer.MAX_VALUE) {
                        i12 = Integer.MAX_VALUE;
                    } else {
                        coerceAtLeast4 = RangesKt___RangesKt.coerceAtLeast(m1872getMaxWidthimpl - j4, j3);
                        i12 = (int) coerceAtLeast4;
                    }
                    i9 = i17;
                    i10 = i15;
                    i11 = m1872getMaxWidthimpl;
                    placeable = measurable.mo1251measureBRTryo0(OrientationIndependentConstraints.m201toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m200copyyUG9Ft0$default(m198constructorimpl, 0, i12, 0, 0, 8, null), this.orientation));
                } else {
                    i9 = i17;
                    i10 = i15;
                    i11 = m1872getMaxWidthimpl;
                }
                j2 = 0;
                coerceAtLeast3 = RangesKt___RangesKt.coerceAtLeast((i11 - j4) - mainAxisSize(placeable), 0L);
                int min = Math.min((int) mo150roundToPx0680j_4, (int) coerceAtLeast3);
                j4 += mainAxisSize(placeable) + min;
                int max = Math.max(i9, crossAxisSize(placeable));
                if (!z && !RowColumnImplKt.isRelative(rowColumnParentData)) {
                    z2 = false;
                }
                this.placeables[i10] = placeable;
                i16 = min;
                i17 = max;
                z = z2;
            }
            j3 = j2;
            i15 = i10 + 1;
        }
        long j5 = j3;
        if (i18 == 0) {
            j4 -= i16;
            i3 = i14;
            i4 = 0;
            i5 = 0;
        } else {
            int i19 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            long j6 = mo150roundToPx0680j_4 * (i18 - 1);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((((i19 <= 0 || Constraints.m1872getMaxWidthimpl(m198constructorimpl) == Integer.MAX_VALUE) ? Constraints.m1874getMinWidthimpl(m198constructorimpl) : Constraints.m1872getMaxWidthimpl(m198constructorimpl)) - j4) - j6, j5);
            float f3 = i19 > 0 ? ((float) coerceAtLeast) / f2 : 0.0f;
            until = RangesKt___RangesKt.until(i, i2);
            Iterator it = until.iterator();
            int i20 = 0;
            while (it.hasNext()) {
                roundToInt2 = MathKt__MathJVMKt.roundToInt(RowColumnImplKt.getWeight(this.rowColumnParentData[((IntIterator) it).nextInt()]) * f3);
                i20 += roundToInt2;
            }
            long j7 = coerceAtLeast - i20;
            int i21 = i;
            int i22 = 0;
            while (i21 < i13) {
                if (this.placeables[i21] == null) {
                    Measurable measurable2 = (Measurable) this.measurables.get(i21);
                    RowColumnParentData rowColumnParentData2 = this.rowColumnParentData[i21];
                    float weight2 = RowColumnImplKt.getWeight(rowColumnParentData2);
                    if (weight2 <= 0.0f) {
                        throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                    }
                    sign = MathKt__MathJVMKt.getSign(j7);
                    i6 = i14;
                    j7 -= sign;
                    roundToInt = MathKt__MathJVMKt.roundToInt(weight2 * f3);
                    int max2 = Math.max(0, roundToInt + sign);
                    f = f3;
                    Placeable mo1251measureBRTryo0 = measurable2.mo1251measureBRTryo0(OrientationIndependentConstraints.m201toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m196constructorimpl((!RowColumnImplKt.getFill(rowColumnParentData2) || max2 == Integer.MAX_VALUE) ? 0 : max2, max2, 0, Constraints.m1871getMaxHeightimpl(m198constructorimpl)), this.orientation));
                    i22 += mainAxisSize(mo1251measureBRTryo0);
                    int max3 = Math.max(i17, crossAxisSize(mo1251measureBRTryo0));
                    boolean z3 = z || RowColumnImplKt.isRelative(rowColumnParentData2);
                    this.placeables[i21] = mo1251measureBRTryo0;
                    i17 = max3;
                    z = z3;
                } else {
                    i6 = i14;
                    f = f3;
                }
                i21++;
                i14 = i6;
                i13 = i2;
                f3 = f;
            }
            i3 = i14;
            i4 = 0;
            coerceIn = RangesKt___RangesKt.coerceIn(i22 + j6, 0L, Constraints.m1872getMaxWidthimpl(m198constructorimpl) - j4);
            i5 = (int) coerceIn;
        }
        if (z) {
            int i23 = i4;
            i7 = i23;
            for (int i24 = i; i24 < i2; i24++) {
                Placeable placeable2 = this.placeables[i24];
                Intrinsics.checkNotNull(placeable2);
                CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(this.rowColumnParentData[i24]);
                Integer calculateAlignmentLinePosition$foundation_layout_release = crossAxisAlignment != null ? crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(placeable2) : null;
                if (calculateAlignmentLinePosition$foundation_layout_release != null) {
                    int intValue = calculateAlignmentLinePosition$foundation_layout_release.intValue();
                    if (intValue == Integer.MIN_VALUE) {
                        intValue = i4;
                    }
                    i23 = Math.max(i23, intValue);
                    int crossAxisSize = crossAxisSize(placeable2);
                    int intValue2 = calculateAlignmentLinePosition$foundation_layout_release.intValue();
                    if (intValue2 == Integer.MIN_VALUE) {
                        intValue2 = crossAxisSize(placeable2);
                    }
                    i7 = Math.max(i7, crossAxisSize - intValue2);
                }
            }
            i8 = i23;
        } else {
            i7 = i4;
            i8 = i7;
        }
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(j4 + i5, 0L);
        int max4 = Math.max((int) coerceAtLeast2, Constraints.m1874getMinWidthimpl(m198constructorimpl));
        int max5 = (Constraints.m1871getMaxHeightimpl(m198constructorimpl) == Integer.MAX_VALUE || this.crossAxisSize != SizeMode.Expand) ? Math.max(i17, Math.max(Constraints.m1873getMinHeightimpl(m198constructorimpl), i7 + i8)) : Constraints.m1871getMaxHeightimpl(m198constructorimpl);
        int i25 = i3;
        int[] iArr = new int[i25];
        for (int i26 = i4; i26 < i25; i26++) {
            iArr[i26] = i4;
        }
        int[] iArr2 = new int[i25];
        for (int i27 = i4; i27 < i25; i27++) {
            Placeable placeable3 = this.placeables[i27 + i];
            Intrinsics.checkNotNull(placeable3);
            iArr2[i27] = mainAxisSize(placeable3);
        }
        return new RowColumnMeasureHelperResult(max5, max4, i, i2, i8, mainAxisPositions(max4, iArr2, iArr, measureScope));
    }

    private final int[] mainAxisPositions(int i, int[] iArr, int[] iArr2, MeasureScope measureScope) {
        this.arrangement.invoke(Integer.valueOf(i), iArr, measureScope.getLayoutDirection(), measureScope, iArr2);
        return iArr2;
    }

    private final int getCrossAxisPosition(Placeable placeable, RowColumnParentData rowColumnParentData, int i, LayoutDirection layoutDirection, int i2) {
        CrossAxisAlignment crossAxisAlignment;
        if (rowColumnParentData == null || (crossAxisAlignment = rowColumnParentData.getCrossAxisAlignment()) == null) {
            crossAxisAlignment = this.crossAxisAlignment;
        }
        int crossAxisSize = i - crossAxisSize(placeable);
        if (this.orientation == LayoutOrientation.Horizontal) {
            layoutDirection = LayoutDirection.Ltr;
        }
        return crossAxisAlignment.align$foundation_layout_release(crossAxisSize, layoutDirection, placeable, i2);
    }

    public final void placeHelper(Placeable.PlacementScope placeableScope, RowColumnMeasureHelperResult measureResult, int i, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(placeableScope, "placeableScope");
        Intrinsics.checkNotNullParameter(measureResult, "measureResult");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int endIndex = measureResult.getEndIndex();
        for (int startIndex = measureResult.getStartIndex(); startIndex < endIndex; startIndex++) {
            Placeable placeable = this.placeables[startIndex];
            Intrinsics.checkNotNull(placeable);
            int[] mainAxisPositions = measureResult.getMainAxisPositions();
            Object parentData = ((Measurable) this.measurables.get(startIndex)).getParentData();
            int crossAxisPosition = getCrossAxisPosition(placeable, parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null, measureResult.getCrossAxisSize(), layoutDirection, measureResult.getBeforeCrossAxisAlignmentLine()) + i;
            if (this.orientation == LayoutOrientation.Horizontal) {
                Placeable.PlacementScope.place$default(placeableScope, placeable, mainAxisPositions[startIndex - measureResult.getStartIndex()], crossAxisPosition, 0.0f, 4, null);
            } else {
                Placeable.PlacementScope.place$default(placeableScope, placeable, crossAxisPosition, mainAxisPositions[startIndex - measureResult.getStartIndex()], 0.0f, 4, null);
            }
        }
    }
}
