package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SelectionManager.kt */
/* loaded from: classes.dex */
public abstract class SelectionManagerKt {
    public static final Rect visibleBounds(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates);
        return RectKt.m731Rect0a9Yr6o(layoutCoordinates.mo1257windowToLocalMKHz9U(boundsInWindow.m729getTopLeftF1C5BW0()), layoutCoordinates.mo1257windowToLocalMKHz9U(boundsInWindow.m726getBottomRightF1C5BW0()));
    }

    /* renamed from: containsInclusive-Uv8p0NA  reason: not valid java name */
    public static final boolean m405containsInclusiveUv8p0NA(Rect containsInclusive, long j) {
        Intrinsics.checkNotNullParameter(containsInclusive, "$this$containsInclusive");
        float left = containsInclusive.getLeft();
        float right = containsInclusive.getRight();
        float m709getXimpl = Offset.m709getXimpl(j);
        if (left <= m709getXimpl && m709getXimpl <= right) {
            float top = containsInclusive.getTop();
            float bottom = containsInclusive.getBottom();
            float m710getYimpl = Offset.m710getYimpl(j);
            if (top <= m710getYimpl && m710getYimpl <= bottom) {
                return true;
            }
        }
        return false;
    }
}
