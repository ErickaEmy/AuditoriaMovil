package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RowColumnImpl.kt */
/* loaded from: classes.dex */
public abstract class OrientationIndependentConstraints {
    /* renamed from: constructor-impl  reason: not valid java name */
    private static long m197constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-yUG9Ft0$default  reason: not valid java name */
    public static /* synthetic */ long m200copyyUG9Ft0$default(long j, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = Constraints.m1874getMinWidthimpl(j);
        }
        int i6 = i;
        if ((i5 & 2) != 0) {
            i2 = Constraints.m1872getMaxWidthimpl(j);
        }
        int i7 = i2;
        if ((i5 & 4) != 0) {
            i3 = Constraints.m1873getMinHeightimpl(j);
        }
        int i8 = i3;
        if ((i5 & 8) != 0) {
            i4 = Constraints.m1871getMaxHeightimpl(j);
        }
        return m199copyyUG9Ft0(j, i6, i7, i8, i4);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m196constructorimpl(int i, int i2, int i3, int i4) {
        return m197constructorimpl(ConstraintsKt.Constraints(i, i2, i3, i4));
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m198constructorimpl(long j, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        LayoutOrientation layoutOrientation = LayoutOrientation.Horizontal;
        return m196constructorimpl(orientation == layoutOrientation ? Constraints.m1874getMinWidthimpl(j) : Constraints.m1873getMinHeightimpl(j), orientation == layoutOrientation ? Constraints.m1872getMaxWidthimpl(j) : Constraints.m1871getMaxHeightimpl(j), orientation == layoutOrientation ? Constraints.m1873getMinHeightimpl(j) : Constraints.m1874getMinWidthimpl(j), orientation == layoutOrientation ? Constraints.m1871getMaxHeightimpl(j) : Constraints.m1872getMaxWidthimpl(j));
    }

    /* renamed from: toBoxConstraints-OenEA2s  reason: not valid java name */
    public static final long m201toBoxConstraintsOenEA2s(long j, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == LayoutOrientation.Horizontal) {
            return ConstraintsKt.Constraints(Constraints.m1874getMinWidthimpl(j), Constraints.m1872getMaxWidthimpl(j), Constraints.m1873getMinHeightimpl(j), Constraints.m1871getMaxHeightimpl(j));
        }
        return ConstraintsKt.Constraints(Constraints.m1873getMinHeightimpl(j), Constraints.m1871getMaxHeightimpl(j), Constraints.m1874getMinWidthimpl(j), Constraints.m1872getMaxWidthimpl(j));
    }

    /* renamed from: copy-yUG9Ft0  reason: not valid java name */
    public static final long m199copyyUG9Ft0(long j, int i, int i2, int i3, int i4) {
        return m196constructorimpl(i, i2, i3, i4);
    }
}
