package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.Owner;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FocusTransactions.kt */
/* loaded from: classes.dex */
public abstract class FocusTransactionsKt {

    /* compiled from: FocusTransactions.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final boolean requestFocus(FocusTargetNode focusTargetNode) {
        Intrinsics.checkNotNullParameter(focusTargetNode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[m675performCustomRequestFocusMxy_nc0(focusTargetNode, FocusDirection.Companion.m655getEnterdhqQ8s()).ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3 || i == 4) {
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            }
            return true;
        }
        return performRequestFocus(focusTargetNode);
    }

    public static final boolean performRequestFocus(FocusTargetNode focusTargetNode) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(focusTargetNode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        boolean z = true;
        if (i == 1 || i == 2) {
            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
            return true;
        }
        FocusTargetNode focusTargetNode2 = null;
        if (i == 3) {
            z = (clearChildFocus$default(focusTargetNode, false, false, 3, null) && grantFocus(focusTargetNode)) ? false : false;
            if (z) {
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                return z;
            }
            return z;
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            int m1386constructorimpl = NodeKind.m1386constructorimpl(1024);
            if (!focusTargetNode.getNode().isAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            Modifier.Node parent$ui_release = focusTargetNode.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                if (requireLayoutNode == null) {
                    break;
                }
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m1386constructorimpl) != 0) {
                    while (parent$ui_release != null) {
                        if ((parent$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                            Modifier.Node node = parent$ui_release;
                            MutableVector mutableVector = null;
                            while (node != null) {
                                if (node instanceof FocusTargetNode) {
                                    focusTargetNode2 = node;
                                    break loop0;
                                }
                                if ((node.getKindSet$ui_release() & m1386constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                node = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    mutableVector.add(node);
                                                    node = null;
                                                }
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector);
                            }
                            continue;
                        }
                        parent$ui_release = parent$ui_release.getParent$ui_release();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            FocusTargetNode focusTargetNode3 = focusTargetNode2;
            if (focusTargetNode3 != null) {
                return requestFocusForChild(focusTargetNode3, focusTargetNode);
            }
            z = (requestFocusForOwner(focusTargetNode) && grantFocus(focusTargetNode)) ? false : false;
            if (z) {
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                return z;
            }
            return z;
        }
    }

    private static final boolean requestFocusForChild(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        boolean z;
        FocusTargetNode focusTargetNode3;
        Modifier.Node node;
        NodeChain nodes$ui_release;
        NodeChain nodes$ui_release2;
        int m1386constructorimpl = NodeKind.m1386constructorimpl(1024);
        if (focusTargetNode2.getNode().isAttached()) {
            Modifier.Node parent$ui_release = focusTargetNode2.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode2);
            loop0: while (true) {
                z = true;
                focusTargetNode3 = null;
                if (requireLayoutNode == null) {
                    node = null;
                    break;
                }
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m1386constructorimpl) != 0) {
                    while (parent$ui_release != null) {
                        if ((parent$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                            node = parent$ui_release;
                            MutableVector mutableVector = null;
                            while (node != null) {
                                if (node instanceof FocusTargetNode) {
                                    break loop0;
                                }
                                if ((node.getKindSet$ui_release() & m1386constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    mutableVector.add(node);
                                                    node = null;
                                                }
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector);
                            }
                            continue;
                        }
                        parent$ui_release = parent$ui_release.getParent$ui_release();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                parent$ui_release = (requireLayoutNode == null || (nodes$ui_release2 = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
            }
            if (Intrinsics.areEqual(node, focusTargetNode)) {
                int i2 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
                if (i2 == 1) {
                    boolean grantFocus = grantFocus(focusTargetNode2);
                    if (grantFocus) {
                        focusTargetNode.setFocusState(FocusStateImpl.ActiveParent);
                        FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode2);
                        FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                        return grantFocus;
                    }
                    return grantFocus;
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        if (FocusTraversalKt.getActiveChild(focusTargetNode) != null) {
                            z = (clearChildFocus$default(focusTargetNode, false, false, 3, null) && grantFocus(focusTargetNode2)) ? false : false;
                            if (z) {
                                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode2);
                            }
                            return z;
                        }
                        throw new IllegalStateException("Required value was null.".toString());
                    } else if (i2 == 4) {
                        int m1386constructorimpl2 = NodeKind.m1386constructorimpl(1024);
                        if (focusTargetNode.getNode().isAttached()) {
                            Modifier.Node parent$ui_release2 = focusTargetNode.getNode().getParent$ui_release();
                            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                            loop4: while (true) {
                                if (requireLayoutNode2 == null) {
                                    break;
                                }
                                if ((requireLayoutNode2.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m1386constructorimpl2) != 0) {
                                    while (parent$ui_release2 != null) {
                                        if ((parent$ui_release2.getKindSet$ui_release() & m1386constructorimpl2) != 0) {
                                            Modifier.Node node2 = parent$ui_release2;
                                            MutableVector mutableVector2 = null;
                                            while (node2 != null) {
                                                if (node2 instanceof FocusTargetNode) {
                                                    focusTargetNode3 = node2;
                                                    break loop4;
                                                }
                                                if ((node2.getKindSet$ui_release() & m1386constructorimpl2) != 0 && (node2 instanceof DelegatingNode)) {
                                                    int i3 = 0;
                                                    for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild$ui_release()) {
                                                        if ((delegate$ui_release2.getKindSet$ui_release() & m1386constructorimpl2) != 0) {
                                                            i3++;
                                                            if (i3 == 1) {
                                                                node2 = delegate$ui_release2;
                                                            } else {
                                                                if (mutableVector2 == null) {
                                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                                }
                                                                if (node2 != null) {
                                                                    mutableVector2.add(node2);
                                                                    node2 = null;
                                                                }
                                                                mutableVector2.add(delegate$ui_release2);
                                                            }
                                                        }
                                                    }
                                                    if (i3 == 1) {
                                                    }
                                                }
                                                node2 = DelegatableNodeKt.pop(mutableVector2);
                                            }
                                            continue;
                                        }
                                        parent$ui_release2 = parent$ui_release2.getParent$ui_release();
                                    }
                                }
                                requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                                parent$ui_release2 = (requireLayoutNode2 == null || (nodes$ui_release = requireLayoutNode2.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                            }
                            FocusTargetNode focusTargetNode4 = focusTargetNode3;
                            if (focusTargetNode4 == null && requestFocusForOwner(focusTargetNode)) {
                                focusTargetNode.setFocusState(FocusStateImpl.Active);
                                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                                return requestFocusForChild(focusTargetNode, focusTargetNode2);
                            } else if (focusTargetNode4 == null || !requestFocusForChild(focusTargetNode4, focusTargetNode)) {
                                return false;
                            } else {
                                boolean requestFocusForChild = requestFocusForChild(focusTargetNode, focusTargetNode2);
                                if (focusTargetNode.getFocusState() == FocusStateImpl.ActiveParent) {
                                    return requestFocusForChild;
                                }
                                throw new IllegalStateException("Check failed.".toString());
                            }
                        }
                        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    return false;
                }
            }
            throw new IllegalStateException("Non child node cannot request focus.".toString());
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    /* renamed from: performCustomEnter-Mxy_nc0  reason: not valid java name */
    private static final CustomDestinationResult m673performCustomEnterMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        boolean z;
        z = focusTargetNode.isProcessingCustomEnter;
        if (!z) {
            focusTargetNode.isProcessingCustomEnter = true;
            try {
                FocusRequester focusRequester = (FocusRequester) focusTargetNode.fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.m647boximpl(i));
                FocusRequester.Companion companion = FocusRequester.Companion;
                if (focusRequester != companion.getDefault()) {
                    if (focusRequester == companion.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    return focusRequester.focus$ui_release() ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.isProcessingCustomEnter = false;
            }
        }
        return CustomDestinationResult.None;
    }

    public static final boolean clearFocus(FocusTargetNode focusTargetNode, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(focusTargetNode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i == 1) {
            focusTargetNode.setFocusState(FocusStateImpl.Inactive);
            if (z2) {
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
            }
        } else if (i == 2) {
            if (z) {
                focusTargetNode.setFocusState(FocusStateImpl.Inactive);
                if (z2) {
                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                    return z;
                }
                return z;
            }
            return z;
        } else if (i != 3) {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
        } else if (!clearChildFocus(focusTargetNode, z, z2)) {
            return false;
        } else {
            focusTargetNode.setFocusState(FocusStateImpl.Inactive);
            if (z2) {
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
            }
        }
        return true;
    }

    /* renamed from: performCustomExit-Mxy_nc0  reason: not valid java name */
    private static final CustomDestinationResult m674performCustomExitMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        boolean z;
        z = focusTargetNode.isProcessingCustomExit;
        if (!z) {
            focusTargetNode.isProcessingCustomExit = true;
            try {
                FocusRequester focusRequester = (FocusRequester) focusTargetNode.fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.m647boximpl(i));
                FocusRequester.Companion companion = FocusRequester.Companion;
                if (focusRequester != companion.getDefault()) {
                    if (focusRequester == companion.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    return focusRequester.focus$ui_release() ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.isProcessingCustomExit = false;
            }
        }
        return CustomDestinationResult.None;
    }

    private static final boolean grantFocus(final FocusTargetNode focusTargetNode) {
        ObserverModifierNodeKt.observeReads(focusTargetNode, new Function0() { // from class: androidx.compose.ui.focus.FocusTransactionsKt$grantFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m676invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m676invoke() {
                FocusTargetNode.this.fetchFocusProperties$ui_release();
            }
        });
        int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i == 3 || i == 4) {
            focusTargetNode.setFocusState(FocusStateImpl.Active);
            return true;
        }
        return true;
    }

    static /* synthetic */ boolean clearChildFocus$default(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return clearChildFocus(focusTargetNode, z, z2);
    }

    private static final boolean clearChildFocus(FocusTargetNode focusTargetNode, boolean z, boolean z2) {
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild != null) {
            return clearFocus(activeChild, z, z2);
        }
        return true;
    }

    private static final boolean requestFocusForOwner(FocusTargetNode focusTargetNode) {
        LayoutNode layoutNode;
        Owner owner$ui_release;
        NodeCoordinator coordinator$ui_release = focusTargetNode.getCoordinator$ui_release();
        if (coordinator$ui_release == null || (layoutNode = coordinator$ui_release.getLayoutNode()) == null || (owner$ui_release = layoutNode.getOwner$ui_release()) == null) {
            throw new IllegalStateException("Owner not initialized.".toString());
        }
        return owner$ui_release.requestFocus();
    }

    /* renamed from: performCustomRequestFocus-Mxy_nc0  reason: not valid java name */
    public static final CustomDestinationResult m675performCustomRequestFocusMxy_nc0(FocusTargetNode performCustomRequestFocus, int i) {
        FocusTargetNode focusTargetNode;
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(performCustomRequestFocus, "$this$performCustomRequestFocus");
        int i2 = WhenMappings.$EnumSwitchMapping$1[performCustomRequestFocus.getFocusState().ordinal()];
        if (i2 == 1 || i2 == 2) {
            return CustomDestinationResult.None;
        }
        if (i2 == 3) {
            FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(performCustomRequestFocus);
            if (activeChild != null) {
                return m672performCustomClearFocusMxy_nc0(activeChild, i);
            }
            throw new IllegalStateException("Required value was null.".toString());
        } else if (i2 == 4) {
            int m1386constructorimpl = NodeKind.m1386constructorimpl(1024);
            if (!performCustomRequestFocus.getNode().isAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            Modifier.Node parent$ui_release = performCustomRequestFocus.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(performCustomRequestFocus);
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
                                    int i3 = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) focusTargetNode).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                                            i3++;
                                            if (i3 == 1) {
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
                                    if (i3 == 1) {
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
            if (focusTargetNode2 == null) {
                return CustomDestinationResult.None;
            }
            int i4 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode2.getFocusState().ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 == 4) {
                            CustomDestinationResult m675performCustomRequestFocusMxy_nc0 = m675performCustomRequestFocusMxy_nc0(focusTargetNode2, i);
                            CustomDestinationResult customDestinationResult = m675performCustomRequestFocusMxy_nc0 != CustomDestinationResult.None ? m675performCustomRequestFocusMxy_nc0 : null;
                            return customDestinationResult == null ? m673performCustomEnterMxy_nc0(focusTargetNode2, i) : customDestinationResult;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return m675performCustomRequestFocusMxy_nc0(focusTargetNode2, i);
                }
                return CustomDestinationResult.Cancelled;
            }
            return m673performCustomEnterMxy_nc0(focusTargetNode2, i);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: performCustomClearFocus-Mxy_nc0  reason: not valid java name */
    public static final CustomDestinationResult m672performCustomClearFocusMxy_nc0(FocusTargetNode performCustomClearFocus, int i) {
        Intrinsics.checkNotNullParameter(performCustomClearFocus, "$this$performCustomClearFocus");
        int i2 = WhenMappings.$EnumSwitchMapping$1[performCustomClearFocus.getFocusState().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return CustomDestinationResult.Cancelled;
            }
            if (i2 == 3) {
                FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(performCustomClearFocus);
                if (activeChild != null) {
                    CustomDestinationResult m672performCustomClearFocusMxy_nc0 = m672performCustomClearFocusMxy_nc0(activeChild, i);
                    if (m672performCustomClearFocusMxy_nc0 == CustomDestinationResult.None) {
                        m672performCustomClearFocusMxy_nc0 = null;
                    }
                    return m672performCustomClearFocusMxy_nc0 == null ? m674performCustomExitMxy_nc0(performCustomClearFocus, i) : m672performCustomClearFocusMxy_nc0;
                }
                throw new IllegalStateException("Required value was null.".toString());
            } else if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return CustomDestinationResult.None;
    }
}
