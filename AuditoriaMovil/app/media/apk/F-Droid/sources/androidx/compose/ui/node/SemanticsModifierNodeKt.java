package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SemanticsModifierNode.kt */
/* loaded from: classes.dex */
public abstract class SemanticsModifierNodeKt {
    public static final void invalidateSemantics(SemanticsModifierNode semanticsModifierNode) {
        Intrinsics.checkNotNullParameter(semanticsModifierNode, "<this>");
        DelegatableNodeKt.requireLayoutNode(semanticsModifierNode).invalidateSemantics$ui_release();
    }

    public static final boolean getUseMinimumTouchTarget(SemanticsConfiguration semanticsConfiguration) {
        Intrinsics.checkNotNullParameter(semanticsConfiguration, "<this>");
        return SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsActions.INSTANCE.getOnClick()) != null;
    }

    public static final Rect touchBoundsInRoot(Modifier.Node node, boolean z) {
        Intrinsics.checkNotNullParameter(node, "<this>");
        if (node.getNode().isAttached()) {
            if (!z) {
                return LayoutCoordinatesKt.boundsInRoot(DelegatableNodeKt.m1296requireCoordinator64DMado(node, NodeKind.m1386constructorimpl(8)));
            }
            return DelegatableNodeKt.m1296requireCoordinator64DMado(node, NodeKind.m1386constructorimpl(8)).touchBoundsInRoot();
        }
        return Rect.Companion.getZero();
    }
}
