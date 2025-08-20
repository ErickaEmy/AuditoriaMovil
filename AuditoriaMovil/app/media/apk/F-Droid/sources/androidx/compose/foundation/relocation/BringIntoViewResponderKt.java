package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BringIntoViewResponder.kt */
/* loaded from: classes.dex */
public abstract class BringIntoViewResponderKt {
    public static final /* synthetic */ Rect access$localRectOf(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, Rect rect) {
        return localRectOf(layoutCoordinates, layoutCoordinates2, rect);
    }

    public static final Modifier bringIntoViewResponder(Modifier modifier, BringIntoViewResponder responder) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(responder, "responder");
        return modifier.then(new BringIntoViewResponderElement(responder));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect localRectOf(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, Rect rect) {
        return rect.m730translatek4lQ0M(layoutCoordinates.localBoundingBoxOf(layoutCoordinates2, false).m729getTopLeftF1C5BW0());
    }
}
