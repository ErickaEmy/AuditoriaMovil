package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
/* compiled from: LayoutNodeDrawScope.kt */
/* loaded from: classes.dex */
public abstract class LayoutNodeDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier.Node nextDrawNode(DelegatableNode delegatableNode) {
        int m1386constructorimpl = NodeKind.m1386constructorimpl(4);
        int m1386constructorimpl2 = NodeKind.m1386constructorimpl(2);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null || (child$ui_release.getAggregateChildKindSet$ui_release() & m1386constructorimpl) == 0) {
            return null;
        }
        while (child$ui_release != null && (child$ui_release.getKindSet$ui_release() & m1386constructorimpl2) == 0) {
            if ((child$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                return child$ui_release;
            }
            child$ui_release = child$ui_release.getChild$ui_release();
        }
        return null;
    }
}
