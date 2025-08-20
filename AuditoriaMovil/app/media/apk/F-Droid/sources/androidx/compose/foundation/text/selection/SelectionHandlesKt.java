package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.Dp;
/* compiled from: SelectionHandles.kt */
/* loaded from: classes.dex */
public abstract class SelectionHandlesKt {
    private static final float HandleHeight;
    private static final float HandleWidth;
    private static final SemanticsPropertyKey SelectionHandleInfoKey = new SemanticsPropertyKey("SelectionHandleInfo", null, 2, null);

    public static final float getHandleHeight() {
        return HandleHeight;
    }

    public static final float getHandleWidth() {
        return HandleWidth;
    }

    public static final SemanticsPropertyKey getSelectionHandleInfoKey() {
        return SelectionHandleInfoKey;
    }

    /* renamed from: getAdjustedCoordinates-k-4lQ0M  reason: not valid java name */
    public static final long m399getAdjustedCoordinatesk4lQ0M(long j) {
        return OffsetKt.Offset(Offset.m709getXimpl(j), Offset.m710getYimpl(j) - 1.0f);
    }

    static {
        float f = 25;
        HandleWidth = Dp.m1897constructorimpl(f);
        HandleHeight = Dp.m1897constructorimpl(f);
    }
}
