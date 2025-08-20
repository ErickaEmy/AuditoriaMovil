package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DelegatingNode.kt */
/* loaded from: classes.dex */
public abstract class DelegatingNode extends Modifier.Node {
    private Modifier.Node delegate;
    private final int selfKindSet = NodeKindKt.calculateNodeKindSetFrom(this);

    public final Modifier.Node getDelegate$ui_release() {
        return this.delegate;
    }

    public final int getSelfKindSet$ui_release() {
        return this.selfKindSet;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void updateCoordinator$ui_release(NodeCoordinator nodeCoordinator) {
        super.updateCoordinator$ui_release(nodeCoordinator);
        for (Modifier.Node delegate$ui_release = getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
            delegate$ui_release.updateCoordinator$ui_release(nodeCoordinator);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DelegatableNode delegate(DelegatableNode delegatableNode) {
        Intrinsics.checkNotNullParameter(delegatableNode, "delegatableNode");
        Modifier.Node node = delegatableNode.getNode();
        if (node != delegatableNode) {
            Modifier.Node node2 = delegatableNode instanceof Modifier.Node ? (Modifier.Node) delegatableNode : null;
            Modifier.Node parent$ui_release = node2 != null ? node2.getParent$ui_release() : null;
            if (node == getNode() && Intrinsics.areEqual(parent$ui_release, this)) {
                return delegatableNode;
            }
            throw new IllegalStateException("Cannot delegate to an already delegated node".toString());
        } else if (!(!node.isAttached())) {
            throw new IllegalStateException("Cannot delegate to an already attached node".toString());
        } else {
            node.setAsDelegateTo$ui_release(getNode());
            int kindSet$ui_release = getKindSet$ui_release();
            int calculateNodeKindSetFromIncludingDelegates = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node);
            node.setKindSet$ui_release(calculateNodeKindSetFromIncludingDelegates);
            validateDelegateKindSet(calculateNodeKindSetFromIncludingDelegates, node);
            node.setChild$ui_release(this.delegate);
            this.delegate = node;
            node.setParent$ui_release(this);
            updateNodeKindSet(getKindSet$ui_release() | calculateNodeKindSetFromIncludingDelegates, false);
            if (isAttached()) {
                if ((calculateNodeKindSetFromIncludingDelegates & NodeKind.m1386constructorimpl(2)) != 0 && (kindSet$ui_release & NodeKind.m1386constructorimpl(2)) == 0) {
                    NodeChain nodes$ui_release = DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release();
                    getNode().updateCoordinator$ui_release(null);
                    nodes$ui_release.syncCoordinators();
                } else {
                    updateCoordinator$ui_release(getCoordinator$ui_release());
                }
                node.markAsAttached$ui_release();
                node.runAttachLifecycle$ui_release();
                NodeKindKt.autoInvalidateInsertedNode(node);
            }
            return delegatableNode;
        }
    }

    private final void validateDelegateKindSet(int i, Modifier.Node node) {
        int kindSet$ui_release = getKindSet$ui_release();
        if ((i & NodeKind.m1386constructorimpl(2)) == 0 || (NodeKind.m1386constructorimpl(2) & kindSet$ui_release) == 0 || (this instanceof LayoutModifierNode)) {
            return;
        }
        throw new IllegalStateException(("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + node).toString());
    }

    private final void updateNodeKindSet(int i, boolean z) {
        Modifier.Node child$ui_release;
        int kindSet$ui_release = getKindSet$ui_release();
        setKindSet$ui_release(i);
        if (kindSet$ui_release != i) {
            if (DelegatableNodeKt.isDelegationRoot(this)) {
                setAggregateChildKindSet$ui_release(i);
            }
            if (isAttached()) {
                Modifier.Node node = getNode();
                Modifier.Node node2 = this;
                while (node2 != null) {
                    i |= node2.getKindSet$ui_release();
                    node2.setKindSet$ui_release(i);
                    if (node2 == node) {
                        break;
                    }
                    node2 = node2.getParent$ui_release();
                }
                if (z && node2 == node) {
                    i = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node);
                    node.setKindSet$ui_release(i);
                }
                int aggregateChildKindSet$ui_release = i | ((node2 == null || (child$ui_release = node2.getChild$ui_release()) == null) ? 0 : child$ui_release.getAggregateChildKindSet$ui_release());
                while (node2 != null) {
                    aggregateChildKindSet$ui_release |= node2.getKindSet$ui_release();
                    node2.setAggregateChildKindSet$ui_release(aggregateChildKindSet$ui_release);
                    node2 = node2.getParent$ui_release();
                }
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void markAsDetached$ui_release() {
        for (Modifier.Node delegate$ui_release = getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
            delegate$ui_release.markAsDetached$ui_release();
        }
        super.markAsDetached$ui_release();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void runAttachLifecycle$ui_release() {
        for (Modifier.Node delegate$ui_release = getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
            delegate$ui_release.runAttachLifecycle$ui_release();
        }
        super.runAttachLifecycle$ui_release();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void markAsAttached$ui_release() {
        super.markAsAttached$ui_release();
        for (Modifier.Node delegate$ui_release = getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
            delegate$ui_release.updateCoordinator$ui_release(getCoordinator$ui_release());
            if (!delegate$ui_release.isAttached()) {
                delegate$ui_release.markAsAttached$ui_release();
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void runDetachLifecycle$ui_release() {
        super.runDetachLifecycle$ui_release();
        for (Modifier.Node delegate$ui_release = getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
            delegate$ui_release.runDetachLifecycle$ui_release();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void reset$ui_release() {
        super.reset$ui_release();
        for (Modifier.Node delegate$ui_release = getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
            delegate$ui_release.reset$ui_release();
        }
    }
}
