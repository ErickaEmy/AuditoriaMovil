package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: LayoutUtils.kt */
/* loaded from: classes.dex */
public abstract class LayoutUtilsKt {
    /* renamed from: finalConstraints-tfFHcEY  reason: not valid java name */
    public static final long m368finalConstraintstfFHcEY(long j, boolean z, int i, float f) {
        return ConstraintsKt.Constraints$default(0, m370finalMaxWidthtfFHcEY(j, z, i, f), 0, Constraints.m1871getMaxHeightimpl(j), 5, null);
    }

    /* renamed from: finalMaxWidth-tfFHcEY  reason: not valid java name */
    public static final int m370finalMaxWidthtfFHcEY(long j, boolean z, int i, float f) {
        int coerceIn;
        int m1872getMaxWidthimpl = ((z || TextOverflow.m1854equalsimpl0(i, TextOverflow.Companion.m1858getEllipsisgIe3tQ8())) && Constraints.m1868getHasBoundedWidthimpl(j)) ? Constraints.m1872getMaxWidthimpl(j) : Integer.MAX_VALUE;
        if (Constraints.m1874getMinWidthimpl(j) == m1872getMaxWidthimpl) {
            return m1872getMaxWidthimpl;
        }
        coerceIn = RangesKt___RangesKt.coerceIn(TextDelegateKt.ceilToIntPx(f), Constraints.m1874getMinWidthimpl(j), m1872getMaxWidthimpl);
        return coerceIn;
    }

    /* renamed from: finalMaxLines-xdlQI24  reason: not valid java name */
    public static final int m369finalMaxLinesxdlQI24(boolean z, int i, int i2) {
        int coerceAtLeast;
        if (z || !TextOverflow.m1854equalsimpl0(i, TextOverflow.Companion.m1858getEllipsisgIe3tQ8())) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i2, 1);
            return coerceAtLeast;
        }
        return 1;
    }
}
