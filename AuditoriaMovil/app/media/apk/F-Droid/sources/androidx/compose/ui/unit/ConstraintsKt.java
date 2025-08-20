package androidx.compose.ui.unit;

import ch.qos.logback.core.CoreConstants;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: Constraints.kt */
/* loaded from: classes.dex */
public abstract class ConstraintsKt {
    public static /* synthetic */ long Constraints$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return Constraints(i, i2, i3, i4);
    }

    public static final long Constraints(int i, int i2, int i3, int i4) {
        if (i2 < i) {
            throw new IllegalArgumentException(("maxWidth(" + i2 + ") must be >= than minWidth(" + i + CoreConstants.RIGHT_PARENTHESIS_CHAR).toString());
        } else if (i4 < i3) {
            throw new IllegalArgumentException(("maxHeight(" + i4 + ") must be >= than minHeight(" + i3 + CoreConstants.RIGHT_PARENTHESIS_CHAR).toString());
        } else if (i < 0 || i3 < 0) {
            throw new IllegalArgumentException(("minWidth(" + i + ") and minHeight(" + i3 + ") must be >= 0").toString());
        } else {
            return Constraints.Companion.m1878createConstraintsZbe2FdA$ui_unit_release(i, i2, i3, i4);
        }
    }

    /* renamed from: constrain-N9IONVI  reason: not valid java name */
    public static final long m1882constrainN9IONVI(long j, long j2) {
        int coerceIn;
        int coerceIn2;
        int coerceIn3;
        int coerceIn4;
        coerceIn = RangesKt___RangesKt.coerceIn(Constraints.m1874getMinWidthimpl(j2), Constraints.m1874getMinWidthimpl(j), Constraints.m1872getMaxWidthimpl(j));
        coerceIn2 = RangesKt___RangesKt.coerceIn(Constraints.m1872getMaxWidthimpl(j2), Constraints.m1874getMinWidthimpl(j), Constraints.m1872getMaxWidthimpl(j));
        coerceIn3 = RangesKt___RangesKt.coerceIn(Constraints.m1873getMinHeightimpl(j2), Constraints.m1873getMinHeightimpl(j), Constraints.m1871getMaxHeightimpl(j));
        coerceIn4 = RangesKt___RangesKt.coerceIn(Constraints.m1871getMaxHeightimpl(j2), Constraints.m1873getMinHeightimpl(j), Constraints.m1871getMaxHeightimpl(j));
        return Constraints(coerceIn, coerceIn2, coerceIn3, coerceIn4);
    }

    /* renamed from: constrain-4WqzIAM  reason: not valid java name */
    public static final long m1881constrain4WqzIAM(long j, long j2) {
        int coerceIn;
        int coerceIn2;
        coerceIn = RangesKt___RangesKt.coerceIn(IntSize.m1951getWidthimpl(j2), Constraints.m1874getMinWidthimpl(j), Constraints.m1872getMaxWidthimpl(j));
        coerceIn2 = RangesKt___RangesKt.coerceIn(IntSize.m1950getHeightimpl(j2), Constraints.m1873getMinHeightimpl(j), Constraints.m1871getMaxHeightimpl(j));
        return IntSizeKt.IntSize(coerceIn, coerceIn2);
    }

    /* renamed from: constrainWidth-K40F9xA  reason: not valid java name */
    public static final int m1884constrainWidthK40F9xA(long j, int i) {
        int coerceIn;
        coerceIn = RangesKt___RangesKt.coerceIn(i, Constraints.m1874getMinWidthimpl(j), Constraints.m1872getMaxWidthimpl(j));
        return coerceIn;
    }

    /* renamed from: constrainHeight-K40F9xA  reason: not valid java name */
    public static final int m1883constrainHeightK40F9xA(long j, int i) {
        int coerceIn;
        coerceIn = RangesKt___RangesKt.coerceIn(i, Constraints.m1873getMinHeightimpl(j), Constraints.m1871getMaxHeightimpl(j));
        return coerceIn;
    }

    /* renamed from: offset-NN6Ew-U$default  reason: not valid java name */
    public static /* synthetic */ long m1886offsetNN6EwU$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m1885offsetNN6EwU(j, i, i2);
    }

    /* renamed from: offset-NN6Ew-U  reason: not valid java name */
    public static final long m1885offsetNN6EwU(long j, int i, int i2) {
        int coerceAtLeast;
        int coerceAtLeast2;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(Constraints.m1874getMinWidthimpl(j) + i, 0);
        int addMaxWithMinimum = addMaxWithMinimum(Constraints.m1872getMaxWidthimpl(j), i);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(Constraints.m1873getMinHeightimpl(j) + i2, 0);
        return Constraints(coerceAtLeast, addMaxWithMinimum, coerceAtLeast2, addMaxWithMinimum(Constraints.m1871getMaxHeightimpl(j), i2));
    }

    private static final int addMaxWithMinimum(int i, int i2) {
        int coerceAtLeast;
        if (i == Integer.MAX_VALUE) {
            return i;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i + i2, 0);
        return coerceAtLeast;
    }
}
