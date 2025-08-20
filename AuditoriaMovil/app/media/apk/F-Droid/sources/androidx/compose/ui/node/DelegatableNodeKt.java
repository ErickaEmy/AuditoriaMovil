package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DelegatableNode.kt */
/* loaded from: classes.dex */
public abstract class DelegatableNodeKt {
    public static final boolean isDelegationRoot(DelegatableNode delegatableNode) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        return delegatableNode.getNode() == delegatableNode;
    }

    public static final LayoutModifierNode asLayoutModifierNode(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "<this>");
        if ((NodeKind.m1386constructorimpl(2) & node.getKindSet$ui_release()) != 0) {
            if (node instanceof LayoutModifierNode) {
                return (LayoutModifierNode) node;
            }
            if (node instanceof DelegatingNode) {
                Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release();
                while (delegate$ui_release != null) {
                    if (delegate$ui_release instanceof LayoutModifierNode) {
                        return (LayoutModifierNode) delegate$ui_release;
                    }
                    if ((delegate$ui_release instanceof DelegatingNode) && (NodeKind.m1386constructorimpl(2) & delegate$ui_release.getKindSet$ui_release()) != 0) {
                        delegate$ui_release = ((DelegatingNode) delegate$ui_release).getDelegate$ui_release();
                    } else {
                        delegate$ui_release = delegate$ui_release.getChild$ui_release();
                    }
                }
            }
        }
        return null;
    }

    public static final void addLayoutNodeChildren(MutableVector mutableVector, Modifier.Node node) {
        MutableVector mutableVector2 = requireLayoutNode(node).get_children$ui_release();
        int size = mutableVector2.getSize();
        if (size > 0) {
            int i = size - 1;
            Object[] content = mutableVector2.getContent();
            do {
                mutableVector.add(((LayoutNode) content[i]).getNodes$ui_release().getHead$ui_release());
                i--;
            } while (i >= 0);
        }
    }

    /* renamed from: has-64DMado */
    public static final boolean m1295has64DMado(DelegatableNode has, int i) {
        Intrinsics.checkNotNullParameter(has, "$this$has");
        return (has.getNode().getAggregateChildKindSet$ui_release() & i) != 0;
    }

    /* renamed from: requireCoordinator-64DMado */
    public static final NodeCoordinator m1296requireCoordinator64DMado(DelegatableNode requireCoordinator, int i) {
        Intrinsics.checkNotNullParameter(requireCoordinator, "$this$requireCoordinator");
        NodeCoordinator coordinator$ui_release = requireCoordinator.getNode().getCoordinator$ui_release();
        Intrinsics.checkNotNull(coordinator$ui_release);
        if (coordinator$ui_release.getTail() == requireCoordinator && NodeKindKt.m1387getIncludeSelfInTraversalH91voCI(i)) {
            NodeCoordinator wrapped$ui_release = coordinator$ui_release.getWrapped$ui_release();
            Intrinsics.checkNotNull(wrapped$ui_release);
            return wrapped$ui_release;
        }
        return coordinator$ui_release;
    }

    public static final LayoutNode requireLayoutNode(DelegatableNode delegatableNode) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        NodeCoordinator coordinator$ui_release = delegatableNode.getNode().getCoordinator$ui_release();
        if (coordinator$ui_release == null) {
            throw new IllegalStateException("Cannot obtain node coordinator. Is the Modifier.Node attached?".toString());
        }
        return coordinator$ui_release.getLayoutNode();
    }

    public static final Owner requireOwner(DelegatableNode delegatableNode) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Owner owner$ui_release = requireLayoutNode(delegatableNode).getOwner$ui_release();
        if (owner$ui_release != null) {
            return owner$ui_release;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final Density requireDensity(DelegatableNode delegatableNode) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        return requireLayoutNode(delegatableNode).getDensity();
    }

    public static final LayoutDirection requireLayoutDirection(DelegatableNode delegatableNode) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        return requireLayoutNode(delegatableNode).getLayoutDirection();
    }

    public static final Modifier.Node pop(MutableVector mutableVector) {
        if (mutableVector == null || mutableVector.isEmpty()) {
            return null;
        }
        return (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
    }
}
