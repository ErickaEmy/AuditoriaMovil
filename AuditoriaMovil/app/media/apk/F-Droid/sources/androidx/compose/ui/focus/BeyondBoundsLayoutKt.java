package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BeyondBoundsLayout.kt */
/* loaded from: classes.dex */
public abstract class BeyondBoundsLayoutKt {
    /* renamed from: searchBeyondBounds--OM-vw8  reason: not valid java name */
    public static final Object m646searchBeyondBoundsOMvw8(FocusTargetNode searchBeyondBounds, int i, Function1 block) {
        FocusTargetNode focusTargetNode;
        BeyondBoundsLayout beyondBoundsLayoutParent;
        int m1237getBeforehoxUOeE;
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(searchBeyondBounds, "$this$searchBeyondBounds");
        Intrinsics.checkNotNullParameter(block, "block");
        int m1386constructorimpl = NodeKind.m1386constructorimpl(1024);
        if (!searchBeyondBounds.getNode().isAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node parent$ui_release = searchBeyondBounds.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(searchBeyondBounds);
        loop0: while (true) {
            if (requireLayoutNode == null) {
                focusTargetNode = null;
                break;
            }
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m1386constructorimpl) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                        focusTargetNode = parent$ui_release;
                        MutableVector mutableVector = null;
                        while (focusTargetNode != null) {
                            if (focusTargetNode instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((focusTargetNode.getKindSet$ui_release() & m1386constructorimpl) != 0 && (focusTargetNode instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) focusTargetNode).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            focusTargetNode = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (focusTargetNode != null) {
                                                mutableVector.add(focusTargetNode);
                                                focusTargetNode = null;
                                            }
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            focusTargetNode = DelegatableNodeKt.pop(mutableVector);
                        }
                        continue;
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
        FocusTargetNode focusTargetNode2 = focusTargetNode;
        if ((focusTargetNode2 == null || !Intrinsics.areEqual(focusTargetNode2.getBeyondBoundsLayoutParent(), searchBeyondBounds.getBeyondBoundsLayoutParent())) && (beyondBoundsLayoutParent = searchBeyondBounds.getBeyondBoundsLayoutParent()) != null) {
            FocusDirection.Companion companion = FocusDirection.Companion;
            if (FocusDirection.m650equalsimpl0(i, companion.m661getUpdhqQ8s())) {
                m1237getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m1235getAbovehoxUOeE();
            } else if (FocusDirection.m650equalsimpl0(i, companion.m654getDowndhqQ8s())) {
                m1237getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m1238getBelowhoxUOeE();
            } else if (FocusDirection.m650equalsimpl0(i, companion.m657getLeftdhqQ8s())) {
                m1237getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m1239getLefthoxUOeE();
            } else if (FocusDirection.m650equalsimpl0(i, companion.m660getRightdhqQ8s())) {
                m1237getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m1240getRighthoxUOeE();
            } else if (FocusDirection.m650equalsimpl0(i, companion.m658getNextdhqQ8s())) {
                m1237getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m1236getAfterhoxUOeE();
            } else if (!FocusDirection.m650equalsimpl0(i, companion.m659getPreviousdhqQ8s())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
            } else {
                m1237getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m1237getBeforehoxUOeE();
            }
            return beyondBoundsLayoutParent.mo264layouto7g1Pn8(m1237getBeforehoxUOeE, block);
        }
        return null;
    }
}
