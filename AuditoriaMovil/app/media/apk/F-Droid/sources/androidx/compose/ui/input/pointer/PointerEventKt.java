package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PointerEvent.kt */
/* loaded from: classes.dex */
public abstract class PointerEventKt {
    public static final boolean changedToDown(PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return (pointerInputChange.isConsumed() || pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) ? false : true;
    }

    public static final boolean changedToDownIgnoreConsumed(PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return !pointerInputChange.getPreviousPressed() && pointerInputChange.getPressed();
    }

    public static final boolean changedToUp(PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return (pointerInputChange.isConsumed() || !pointerInputChange.getPreviousPressed() || pointerInputChange.getPressed()) ? false : true;
    }

    public static final boolean changedToUpIgnoreConsumed(PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return pointerInputChange.getPreviousPressed() && !pointerInputChange.getPressed();
    }

    public static final boolean positionChangedIgnoreConsumed(PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return !Offset.m706equalsimpl0(positionChangeInternal(pointerInputChange, true), Offset.Companion.m721getZeroF1C5BW0());
    }

    public static final long positionChange(PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return positionChangeInternal(pointerInputChange, false);
    }

    public static final long positionChangeIgnoreConsumed(PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return positionChangeInternal(pointerInputChange, true);
    }

    private static final long positionChangeInternal(PointerInputChange pointerInputChange, boolean z) {
        long m713minusMKHz9U = Offset.m713minusMKHz9U(pointerInputChange.m1196getPositionF1C5BW0(), pointerInputChange.m1197getPreviousPositionF1C5BW0());
        return (z || !pointerInputChange.isConsumed()) ? m713minusMKHz9U : Offset.Companion.m721getZeroF1C5BW0();
    }

    /* renamed from: isOutOfBounds-O0kMr_c  reason: not valid java name */
    public static final boolean m1172isOutOfBoundsO0kMr_c(PointerInputChange isOutOfBounds, long j) {
        Intrinsics.checkNotNullParameter(isOutOfBounds, "$this$isOutOfBounds");
        long m1196getPositionF1C5BW0 = isOutOfBounds.m1196getPositionF1C5BW0();
        float m709getXimpl = Offset.m709getXimpl(m1196getPositionF1C5BW0);
        float m710getYimpl = Offset.m710getYimpl(m1196getPositionF1C5BW0);
        return m709getXimpl < 0.0f || m709getXimpl > ((float) IntSize.m1951getWidthimpl(j)) || m710getYimpl < 0.0f || m710getYimpl > ((float) IntSize.m1950getHeightimpl(j));
    }

    /* renamed from: isOutOfBounds-jwHxaWs  reason: not valid java name */
    public static final boolean m1173isOutOfBoundsjwHxaWs(PointerInputChange isOutOfBounds, long j, long j2) {
        Intrinsics.checkNotNullParameter(isOutOfBounds, "$this$isOutOfBounds");
        if (!PointerType.m1215equalsimpl0(isOutOfBounds.m1199getTypeT8wyACA(), PointerType.Companion.m1221getTouchT8wyACA())) {
            return m1172isOutOfBoundsO0kMr_c(isOutOfBounds, j);
        }
        long m1196getPositionF1C5BW0 = isOutOfBounds.m1196getPositionF1C5BW0();
        float m709getXimpl = Offset.m709getXimpl(m1196getPositionF1C5BW0);
        float m710getYimpl = Offset.m710getYimpl(m1196getPositionF1C5BW0);
        return m709getXimpl < (-Size.m745getWidthimpl(j2)) || m709getXimpl > ((float) IntSize.m1951getWidthimpl(j)) + Size.m745getWidthimpl(j2) || m710getYimpl < (-Size.m743getHeightimpl(j2)) || m710getYimpl > ((float) IntSize.m1950getHeightimpl(j)) + Size.m743getHeightimpl(j2);
    }
}
