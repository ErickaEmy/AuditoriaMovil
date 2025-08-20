package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import ch.qos.logback.core.CoreConstants;
import java.util.Iterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
/* compiled from: Menu.kt */
/* loaded from: classes.dex */
public final class DropdownMenuPositionProvider implements PopupPositionProvider {
    private final long contentOffset;
    private final Density density;
    private final Function2 onPositionCalculated;

    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, density, function2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DropdownMenuPositionProvider) {
            DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) obj;
            return DpOffset.m1911equalsimpl0(this.contentOffset, dropdownMenuPositionProvider.contentOffset) && Intrinsics.areEqual(this.density, dropdownMenuPositionProvider.density) && Intrinsics.areEqual(this.onPositionCalculated, dropdownMenuPositionProvider.onPositionCalculated);
        }
        return false;
    }

    public int hashCode() {
        return (((DpOffset.m1914hashCodeimpl(this.contentOffset) * 31) + this.density.hashCode()) * 31) + this.onPositionCalculated.hashCode();
    }

    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + ((Object) DpOffset.m1915toStringimpl(this.contentOffset)) + ", density=" + this.density + ", onPositionCalculated=" + this.onPositionCalculated + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    private DropdownMenuPositionProvider(long j, Density density, Function2 onPositionCalculated) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(onPositionCalculated, "onPositionCalculated");
        this.contentOffset = j;
        this.density = density;
        this.onPositionCalculated = onPositionCalculated;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* renamed from: calculatePosition-llwVHH4 */
    public long mo389calculatePositionllwVHH4(IntRect anchorBounds, long j, LayoutDirection layoutDirection, long j2) {
        Sequence sequenceOf;
        Object obj;
        Object obj2;
        Sequence sequenceOf2;
        Intrinsics.checkNotNullParameter(anchorBounds, "anchorBounds");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int mo150roundToPx0680j_4 = this.density.mo150roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
        int mo150roundToPx0680j_42 = this.density.mo150roundToPx0680j_4(DpOffset.m1912getXD9Ej5fM(this.contentOffset));
        int mo150roundToPx0680j_43 = this.density.mo150roundToPx0680j_4(DpOffset.m1913getYD9Ej5fM(this.contentOffset));
        int left = anchorBounds.getLeft() + mo150roundToPx0680j_42;
        int right = (anchorBounds.getRight() - mo150roundToPx0680j_42) - IntSize.m1951getWidthimpl(j2);
        int m1951getWidthimpl = IntSize.m1951getWidthimpl(j) - IntSize.m1951getWidthimpl(j2);
        if (layoutDirection == LayoutDirection.Ltr) {
            Integer[] numArr = new Integer[3];
            numArr[0] = Integer.valueOf(left);
            numArr[1] = Integer.valueOf(right);
            if (anchorBounds.getLeft() < 0) {
                m1951getWidthimpl = 0;
            }
            numArr[2] = Integer.valueOf(m1951getWidthimpl);
            sequenceOf = SequencesKt__SequencesKt.sequenceOf(numArr);
        } else {
            Integer[] numArr2 = new Integer[3];
            numArr2[0] = Integer.valueOf(right);
            numArr2[1] = Integer.valueOf(left);
            if (anchorBounds.getRight() <= IntSize.m1951getWidthimpl(j)) {
                m1951getWidthimpl = 0;
            }
            numArr2[2] = Integer.valueOf(m1951getWidthimpl);
            sequenceOf = SequencesKt__SequencesKt.sequenceOf(numArr2);
        }
        Iterator it = sequenceOf.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            int intValue = ((Number) obj2).intValue();
            if (intValue >= 0 && intValue + IntSize.m1951getWidthimpl(j2) <= IntSize.m1951getWidthimpl(j)) {
                break;
            }
        }
        Integer num = (Integer) obj2;
        if (num != null) {
            right = num.intValue();
        }
        int max = Math.max(anchorBounds.getBottom() + mo150roundToPx0680j_43, mo150roundToPx0680j_4);
        int top = (anchorBounds.getTop() - mo150roundToPx0680j_43) - IntSize.m1950getHeightimpl(j2);
        sequenceOf2 = SequencesKt__SequencesKt.sequenceOf(Integer.valueOf(max), Integer.valueOf(top), Integer.valueOf(anchorBounds.getTop() - (IntSize.m1950getHeightimpl(j2) / 2)), Integer.valueOf((IntSize.m1950getHeightimpl(j) - IntSize.m1950getHeightimpl(j2)) - mo150roundToPx0680j_4));
        Iterator it2 = sequenceOf2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            int intValue2 = ((Number) next).intValue();
            if (intValue2 >= mo150roundToPx0680j_4 && intValue2 + IntSize.m1950getHeightimpl(j2) <= IntSize.m1950getHeightimpl(j) - mo150roundToPx0680j_4) {
                obj = next;
                break;
            }
        }
        Integer num2 = (Integer) obj;
        if (num2 != null) {
            top = num2.intValue();
        }
        this.onPositionCalculated.invoke(anchorBounds, new IntRect(right, top, IntSize.m1951getWidthimpl(j2) + right, IntSize.m1950getHeightimpl(j2) + top));
        return IntOffsetKt.IntOffset(right, top);
    }
}
