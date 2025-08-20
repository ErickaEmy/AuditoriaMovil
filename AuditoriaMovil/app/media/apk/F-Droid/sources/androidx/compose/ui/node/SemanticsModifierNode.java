package androidx.compose.ui.node;

import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
/* compiled from: SemanticsModifierNode.kt */
/* loaded from: classes.dex */
public interface SemanticsModifierNode extends DelegatableNode {

    /* compiled from: SemanticsModifierNode.kt */
    /* renamed from: androidx.compose.ui.node.SemanticsModifierNode$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static boolean $default$getShouldClearDescendantSemantics(SemanticsModifierNode semanticsModifierNode) {
            return false;
        }

        public static boolean $default$getShouldMergeDescendantSemantics(SemanticsModifierNode semanticsModifierNode) {
            return false;
        }
    }

    void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver);

    boolean getShouldClearDescendantSemantics();

    boolean getShouldMergeDescendantSemantics();
}
