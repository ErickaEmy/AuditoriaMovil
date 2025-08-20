package androidx.compose.foundation.relocation;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BringIntoViewResponder.android.kt */
/* loaded from: classes.dex */
public abstract class BringIntoViewResponder_androidKt {
    public static final BringIntoViewParent defaultBringIntoViewParent(final CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode) {
        Intrinsics.checkNotNullParameter(compositionLocalConsumerModifierNode, "<this>");
        return new BringIntoViewParent() { // from class: androidx.compose.foundation.relocation.BringIntoViewResponder_androidKt$defaultBringIntoViewParent$1
            @Override // androidx.compose.foundation.relocation.BringIntoViewParent
            public final Object bringChildIntoView(LayoutCoordinates layoutCoordinates, Function0 function0, Continuation continuation) {
                Rect rect;
                View view = (View) CompositionLocalConsumerModifierNodeKt.currentValueOf(CompositionLocalConsumerModifierNode.this, AndroidCompositionLocals_androidKt.getLocalView());
                long positionInRoot = LayoutCoordinatesKt.positionInRoot(layoutCoordinates);
                androidx.compose.ui.geometry.Rect rect2 = (androidx.compose.ui.geometry.Rect) function0.invoke();
                androidx.compose.ui.geometry.Rect m730translatek4lQ0M = rect2 != null ? rect2.m730translatek4lQ0M(positionInRoot) : null;
                if (m730translatek4lQ0M != null) {
                    rect = BringIntoViewResponder_androidKt.toRect(m730translatek4lQ0M);
                    view.requestRectangleOnScreen(rect, false);
                }
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect toRect(androidx.compose.ui.geometry.Rect rect) {
        return new Rect((int) rect.getLeft(), (int) rect.getTop(), (int) rect.getRight(), (int) rect.getBottom());
    }
}
