package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
/* compiled from: NodeCoordinator.kt */
/* loaded from: classes.dex */
public abstract class NodeCoordinatorKt {
    /* renamed from: access$nextUntil-hw7D004  reason: not valid java name */
    public static final /* synthetic */ Modifier.Node m1384access$nextUntilhw7D004(DelegatableNode delegatableNode, int i, int i2) {
        return m1385nextUntilhw7D004(delegatableNode, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: nextUntil-hw7D004  reason: not valid java name */
    public static final Modifier.Node m1385nextUntilhw7D004(DelegatableNode delegatableNode, int i, int i2) {
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null || (child$ui_release.getAggregateChildKindSet$ui_release() & i) == 0) {
            return null;
        }
        while (child$ui_release != null) {
            int kindSet$ui_release = child$ui_release.getKindSet$ui_release();
            if ((kindSet$ui_release & i2) != 0) {
                return null;
            }
            if ((kindSet$ui_release & i) != 0) {
                return child$ui_release;
            }
            child$ui_release = child$ui_release.getChild$ui_release();
        }
        return null;
    }
}
