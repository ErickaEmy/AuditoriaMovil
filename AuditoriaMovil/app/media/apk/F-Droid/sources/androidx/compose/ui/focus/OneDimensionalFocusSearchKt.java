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
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
/* compiled from: OneDimensionalFocusSearch.kt */
/* loaded from: classes.dex */
public abstract class OneDimensionalFocusSearchKt {

    /* compiled from: OneDimensionalFocusSearch.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: oneDimensionalFocusSearch--OM-vw8  reason: not valid java name */
    public static final boolean m681oneDimensionalFocusSearchOMvw8(FocusTargetNode oneDimensionalFocusSearch, int i, Function1 onFound) {
        Intrinsics.checkNotNullParameter(oneDimensionalFocusSearch, "$this$oneDimensionalFocusSearch");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m650equalsimpl0(i, companion.m658getNextdhqQ8s())) {
            return forwardFocusSearch(oneDimensionalFocusSearch, onFound);
        }
        if (FocusDirection.m650equalsimpl0(i, companion.m659getPreviousdhqQ8s())) {
            return backwardFocusSearch(oneDimensionalFocusSearch, onFound);
        }
        throw new IllegalStateException("This function should only be used for 1-D focus search".toString());
    }

    private static final boolean forwardFocusSearch(FocusTargetNode focusTargetNode, Function1 function1) {
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i == 1) {
            FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
            if (activeChild != null) {
                return forwardFocusSearch(activeChild, function1) || m680generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, FocusDirection.Companion.m658getNextdhqQ8s(), function1);
            }
            throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
        } else if (i == 2 || i == 3) {
            return pickChildForForwardSearch(focusTargetNode, function1);
        } else {
            if (i == 4) {
                if (focusTargetNode.fetchFocusProperties$ui_release().getCanFocus()) {
                    return ((Boolean) function1.invoke(focusTargetNode)).booleanValue();
                }
                return pickChildForForwardSearch(focusTargetNode, function1);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    private static final boolean backwardFocusSearch(FocusTargetNode focusTargetNode, Function1 function1) {
        FocusStateImpl focusState = focusTargetNode.getFocusState();
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i = iArr[focusState.ordinal()];
        if (i == 1) {
            FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
            if (activeChild == null) {
                throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
            }
            int i2 = iArr[activeChild.getFocusState().ordinal()];
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    return m680generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, FocusDirection.Companion.m659getPreviousdhqQ8s(), function1);
                }
                if (i2 == 4) {
                    throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
                }
                throw new NoWhenBranchMatchedException();
            } else if (!backwardFocusSearch(activeChild, function1) && !m680generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, FocusDirection.Companion.m659getPreviousdhqQ8s(), function1) && (!activeChild.fetchFocusProperties$ui_release().getCanFocus() || !((Boolean) function1.invoke(activeChild)).booleanValue())) {
                return false;
            }
        } else if (i == 2 || i == 3) {
            return pickChildForBackwardSearch(focusTargetNode, function1);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (!pickChildForBackwardSearch(focusTargetNode, function1) && (!focusTargetNode.fetchFocusProperties$ui_release().getCanFocus() || !((Boolean) function1.invoke(focusTargetNode)).booleanValue())) {
                return false;
            }
        }
        return true;
    }

    private static final boolean isRoot(FocusTargetNode focusTargetNode) {
        Modifier.Node node;
        NodeChain nodes$ui_release;
        int m1386constructorimpl = NodeKind.m1386constructorimpl(1024);
        if (!focusTargetNode.getNode().isAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node parent$ui_release = focusTargetNode.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
        loop0: while (true) {
            node = null;
            if (requireLayoutNode == null) {
                break;
            }
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m1386constructorimpl) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                        Modifier.Node node2 = parent$ui_release;
                        MutableVector mutableVector = null;
                        while (node2 != null) {
                            if (node2 instanceof FocusTargetNode) {
                                node = node2;
                                break loop0;
                            }
                            if ((node2.getKindSet$ui_release() & m1386constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node2 = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node2 != null) {
                                                mutableVector.add(node2);
                                                node2 = null;
                                            }
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node2 = DelegatableNodeKt.pop(mutableVector);
                        }
                        continue;
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
        return node == null;
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg  reason: not valid java name */
    private static final boolean m680generateAndSearchChildren4C6V_qg(final FocusTargetNode focusTargetNode, final FocusTargetNode focusTargetNode2, final int i, final Function1 function1) {
        if (m682searchChildren4C6V_qg(focusTargetNode, focusTargetNode2, i, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m646searchBeyondBoundsOMvw8(focusTargetNode, i, new Function1() { // from class: androidx.compose.ui.focus.OneDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BeyondBoundsLayout.BeyondBoundsScope searchBeyondBounds) {
                boolean m682searchChildren4C6V_qg;
                Intrinsics.checkNotNullParameter(searchBeyondBounds, "$this$searchBeyondBounds");
                m682searchChildren4C6V_qg = OneDimensionalFocusSearchKt.m682searchChildren4C6V_qg(FocusTargetNode.this, focusTargetNode2, i, function1);
                Boolean valueOf = Boolean.valueOf(m682searchChildren4C6V_qg);
                if (valueOf.booleanValue() || !searchBeyondBounds.getHasMoreContent()) {
                    return valueOf;
                }
                return null;
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg  reason: not valid java name */
    public static final boolean m682searchChildren4C6V_qg(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, int i, Function1 function1) {
        if (focusTargetNode.getFocusState() == FocusStateImpl.ActiveParent) {
            MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
            int m1386constructorimpl = NodeKind.m1386constructorimpl(1024);
            if (focusTargetNode.getNode().isAttached()) {
                MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                Modifier.Node child$ui_release = focusTargetNode.getNode().getChild$ui_release();
                if (child$ui_release == null) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusTargetNode.getNode());
                } else {
                    mutableVector2.add(child$ui_release);
                }
                while (mutableVector2.isNotEmpty()) {
                    Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
                    if ((node.getAggregateChildKindSet$ui_release() & m1386constructorimpl) == 0) {
                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node);
                    } else {
                        while (true) {
                            if (node == null) {
                                break;
                            } else if ((node.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                                MutableVector mutableVector3 = null;
                                while (node != null) {
                                    if (node instanceof FocusTargetNode) {
                                        mutableVector.add((FocusTargetNode) node);
                                    } else if ((node.getKindSet$ui_release() & m1386constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                        int i2 = 0;
                                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                            if ((delegate$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    node = delegate$ui_release;
                                                } else {
                                                    if (mutableVector3 == null) {
                                                        mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (node != null) {
                                                        mutableVector3.add(node);
                                                        node = null;
                                                    }
                                                    mutableVector3.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                        if (i2 == 1) {
                                        }
                                    }
                                    node = DelegatableNodeKt.pop(mutableVector3);
                                }
                            } else {
                                node = node.getChild$ui_release();
                            }
                        }
                    }
                }
                mutableVector.sortWith(FocusableChildrenComparator.INSTANCE);
                FocusDirection.Companion companion = FocusDirection.Companion;
                if (FocusDirection.m650equalsimpl0(i, companion.m658getNextdhqQ8s())) {
                    IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
                    int first = intRange.getFirst();
                    int last = intRange.getLast();
                    if (first <= last) {
                        boolean z = false;
                        while (true) {
                            if (z) {
                                FocusTargetNode focusTargetNode3 = (FocusTargetNode) mutableVector.getContent()[first];
                                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode3) && forwardFocusSearch(focusTargetNode3, function1)) {
                                    return true;
                                }
                            }
                            if (Intrinsics.areEqual(mutableVector.getContent()[first], focusTargetNode2)) {
                                z = true;
                            }
                            if (first == last) {
                                break;
                            }
                            first++;
                        }
                    }
                } else if (!FocusDirection.m650equalsimpl0(i, companion.m659getPreviousdhqQ8s())) {
                    throw new IllegalStateException("This function should only be used for 1-D focus search".toString());
                } else {
                    IntRange intRange2 = new IntRange(0, mutableVector.getSize() - 1);
                    int first2 = intRange2.getFirst();
                    int last2 = intRange2.getLast();
                    if (first2 <= last2) {
                        boolean z2 = false;
                        while (true) {
                            if (z2) {
                                FocusTargetNode focusTargetNode4 = (FocusTargetNode) mutableVector.getContent()[last2];
                                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode4) && backwardFocusSearch(focusTargetNode4, function1)) {
                                    return true;
                                }
                            }
                            if (Intrinsics.areEqual(mutableVector.getContent()[last2], focusTargetNode2)) {
                                z2 = true;
                            }
                            if (last2 == first2) {
                                break;
                            }
                            last2--;
                        }
                    }
                }
                if (FocusDirection.m650equalsimpl0(i, FocusDirection.Companion.m658getNextdhqQ8s()) || !focusTargetNode.fetchFocusProperties$ui_release().getCanFocus() || isRoot(focusTargetNode)) {
                    return false;
                }
                return ((Boolean) function1.invoke(focusTargetNode)).booleanValue();
            }
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        throw new IllegalStateException("This function should only be used within a parent that has focus.".toString());
    }

    private static final boolean pickChildForBackwardSearch(FocusTargetNode focusTargetNode, Function1 function1) {
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        int m1386constructorimpl = NodeKind.m1386constructorimpl(1024);
        if (!focusTargetNode.getNode().isAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = focusTargetNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusTargetNode.getNode());
        } else {
            mutableVector2.add(child$ui_release);
        }
        while (mutableVector2.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & m1386constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    } else if ((node.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                mutableVector.add((FocusTargetNode) node);
                            } else if ((node.getKindSet$ui_release() & m1386constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate$ui_release;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                mutableVector3.add(node);
                                                node = null;
                                            }
                                            mutableVector3.add(delegate$ui_release);
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector3);
                        }
                    } else {
                        node = node.getChild$ui_release();
                    }
                }
            }
        }
        mutableVector.sortWith(FocusableChildrenComparator.INSTANCE);
        int size = mutableVector.getSize();
        if (size > 0) {
            int i2 = size - 1;
            Object[] content = mutableVector.getContent();
            do {
                FocusTargetNode focusTargetNode2 = (FocusTargetNode) content[i2];
                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2) && backwardFocusSearch(focusTargetNode2, function1)) {
                    return true;
                }
                i2--;
            } while (i2 >= 0);
            return false;
        }
        return false;
    }

    private static final boolean pickChildForForwardSearch(FocusTargetNode focusTargetNode, Function1 function1) {
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        int m1386constructorimpl = NodeKind.m1386constructorimpl(1024);
        if (!focusTargetNode.getNode().isAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = focusTargetNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusTargetNode.getNode());
        } else {
            mutableVector2.add(child$ui_release);
        }
        while (mutableVector2.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & m1386constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    } else if ((node.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                mutableVector.add((FocusTargetNode) node);
                            } else if ((node.getKindSet$ui_release() & m1386constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate$ui_release;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                mutableVector3.add(node);
                                                node = null;
                                            }
                                            mutableVector3.add(delegate$ui_release);
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector3);
                        }
                    } else {
                        node = node.getChild$ui_release();
                    }
                }
            }
        }
        mutableVector.sortWith(FocusableChildrenComparator.INSTANCE);
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i2 = 0;
            do {
                FocusTargetNode focusTargetNode2 = (FocusTargetNode) content[i2];
                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2) && forwardFocusSearch(focusTargetNode2, function1)) {
                    return true;
                }
                i2++;
            } while (i2 < size);
            return false;
        }
        return false;
    }
}
