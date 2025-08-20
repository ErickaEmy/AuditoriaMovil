package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.appcompat.app.ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
/* compiled from: FocusOwnerImpl.kt */
/* loaded from: classes.dex */
public final class FocusOwnerImpl implements FocusOwner {
    private final FocusInvalidationManager focusInvalidationManager;
    public LayoutDirection layoutDirection;
    private final Modifier modifier;
    private FocusTargetNode rootFocusNode;

    /* compiled from: FocusOwnerImpl.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Modifier getModifier() {
        return this.modifier;
    }

    public final FocusTargetNode getRootFocusNode$ui_release() {
        return this.rootFocusNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void setLayoutDirection(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
        this.layoutDirection = layoutDirection;
    }

    public FocusOwnerImpl(Function1 onRequestApplyChangesListener) {
        Intrinsics.checkNotNullParameter(onRequestApplyChangesListener, "onRequestApplyChangesListener");
        this.rootFocusNode = new FocusTargetNode();
        this.focusInvalidationManager = new FocusInvalidationManager(onRequestApplyChangesListener);
        this.modifier = new ModifierNodeElement() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
            public boolean equals(Object obj) {
                return obj == this;
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public void update(FocusTargetNode node) {
                Intrinsics.checkNotNullParameter(node, "node");
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public FocusTargetNode create() {
                return FocusOwnerImpl.this.getRootFocusNode$ui_release();
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public int hashCode() {
                return FocusOwnerImpl.this.getRootFocusNode$ui_release().hashCode();
            }
        };
    }

    public LayoutDirection getLayoutDirection() {
        LayoutDirection layoutDirection = this.layoutDirection;
        if (layoutDirection != null) {
            return layoutDirection;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutDirection");
        return null;
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode delegatableNode) {
        int m1386constructorimpl = NodeKind.m1386constructorimpl(1024) | NodeKind.m1386constructorimpl(8192);
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("visitLocalDescendants called on an unattached node".toString());
        }
        Modifier.Node node = delegatableNode.getNode();
        Modifier.Node node2 = null;
        if ((node.getAggregateChildKindSet$ui_release() & m1386constructorimpl) != 0) {
            for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                if ((child$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                    if ((NodeKind.m1386constructorimpl(1024) & child$ui_release.getKindSet$ui_release()) != 0) {
                        return node2;
                    }
                    node2 = child$ui_release;
                }
            }
        }
        return node2;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void takeFocus() {
        if (this.rootFocusNode.getFocusState() == FocusStateImpl.Inactive) {
            this.rootFocusNode.setFocusState(FocusStateImpl.Active);
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public void clearFocus(boolean z) {
        clearFocus(z, true);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void clearFocus(boolean z, boolean z2) {
        FocusStateImpl focusStateImpl;
        if (!z) {
            int i = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m672performCustomClearFocusMxy_nc0(this.rootFocusNode, FocusDirection.Companion.m656getExitdhqQ8s()).ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                return;
            }
        }
        FocusStateImpl focusState = this.rootFocusNode.getFocusState();
        if (FocusTransactionsKt.clearFocus(this.rootFocusNode, z, z2)) {
            FocusTargetNode focusTargetNode = this.rootFocusNode;
            int i2 = WhenMappings.$EnumSwitchMapping$1[focusState.ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                focusStateImpl = FocusStateImpl.Active;
            } else if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            } else {
                focusStateImpl = FocusStateImpl.Inactive;
            }
            focusTargetNode.setFocusState(focusStateImpl);
        }
    }

    @Override // androidx.compose.ui.focus.FocusManager
    /* renamed from: moveFocus-3ESFkO8 */
    public boolean mo663moveFocus3ESFkO8(final int i) {
        final FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode == null) {
            return false;
        }
        FocusRequester m677customFocusSearchOMvw8 = FocusTraversalKt.m677customFocusSearchOMvw8(findActiveFocusNode, i, getLayoutDirection());
        FocusRequester.Companion companion = FocusRequester.Companion;
        if (m677customFocusSearchOMvw8 != companion.getDefault()) {
            return m677customFocusSearchOMvw8 != companion.getCancel() && m677customFocusSearchOMvw8.focus$ui_release();
        }
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        boolean m678focusSearchsMXa3k8 = FocusTraversalKt.m678focusSearchsMXa3k8(this.rootFocusNode, i, getLayoutDirection(), new Function1() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$foundNextItem$1

            /* compiled from: FocusOwnerImpl.kt */
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[CustomDestinationResult.values().length];
                    try {
                        iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[CustomDestinationResult.None.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode destination) {
                Modifier.Node node;
                boolean z;
                NodeChain nodes$ui_release;
                Intrinsics.checkNotNullParameter(destination, "destination");
                if (Intrinsics.areEqual(destination, FocusTargetNode.this)) {
                    return Boolean.FALSE;
                }
                int m1386constructorimpl = NodeKind.m1386constructorimpl(1024);
                if (!destination.getNode().isAttached()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                }
                Modifier.Node parent$ui_release = destination.getNode().getParent$ui_release();
                LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(destination);
                loop0: while (true) {
                    node = null;
                    z = true;
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
                                        int i2 = 0;
                                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                            if ((delegate$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                                                i2++;
                                                if (i2 == 1) {
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
                                        if (i2 == 1) {
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
                if (node == null) {
                    throw new IllegalStateException("Focus search landed at the root.".toString());
                }
                int i3 = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m675performCustomRequestFocusMxy_nc0(destination, i).ordinal()];
                if (i3 != 1) {
                    if (i3 == 2 || i3 == 3) {
                        ref$BooleanRef.element = true;
                    } else if (i3 != 4) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        z = FocusTransactionsKt.performRequestFocus(destination);
                    }
                }
                return Boolean.valueOf(z);
            }
        });
        if (ref$BooleanRef.element) {
            return false;
        }
        return m678focusSearchsMXa3k8 || m666wrapAroundFocus3ESFkO8(i);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchKeyEvent-ZmokQxo */
    public boolean mo665dispatchKeyEventZmokQxo(KeyEvent keyEvent) {
        int i;
        NodeChain nodes$ui_release;
        Modifier.Node node;
        NodeChain nodes$ui_release2;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            Modifier.Node lastLocalKeyInputNode = lastLocalKeyInputNode(findActiveFocusNode);
            if (lastLocalKeyInputNode == null) {
                int m1386constructorimpl = NodeKind.m1386constructorimpl(8192);
                if (!findActiveFocusNode.getNode().isAttached()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                }
                Modifier.Node parent$ui_release = findActiveFocusNode.getNode().getParent$ui_release();
                LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(findActiveFocusNode);
                loop0: while (true) {
                    if (requireLayoutNode == null) {
                        node = null;
                        break;
                    }
                    if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m1386constructorimpl) != 0) {
                        while (parent$ui_release != null) {
                            if ((parent$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                                MutableVector mutableVector = null;
                                node = parent$ui_release;
                                while (node != null) {
                                    if (node instanceof KeyInputModifierNode) {
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
                    parent$ui_release = (requireLayoutNode == null || (nodes$ui_release2 = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
                }
                KeyInputModifierNode keyInputModifierNode = (KeyInputModifierNode) node;
                lastLocalKeyInputNode = keyInputModifierNode != null ? keyInputModifierNode.getNode() : null;
            }
            if (lastLocalKeyInputNode != null) {
                int m1386constructorimpl2 = NodeKind.m1386constructorimpl(8192);
                if (!lastLocalKeyInputNode.getNode().isAttached()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                }
                Modifier.Node parent$ui_release2 = lastLocalKeyInputNode.getNode().getParent$ui_release();
                LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(lastLocalKeyInputNode);
                ArrayList arrayList = null;
                while (requireLayoutNode2 != null) {
                    if ((requireLayoutNode2.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m1386constructorimpl2) != 0) {
                        while (parent$ui_release2 != null) {
                            if ((parent$ui_release2.getKindSet$ui_release() & m1386constructorimpl2) != 0) {
                                Modifier.Node node2 = parent$ui_release2;
                                MutableVector mutableVector2 = null;
                                while (node2 != null) {
                                    if (node2 instanceof KeyInputModifierNode) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(node2);
                                    } else if ((node2.getKindSet$ui_release() & m1386constructorimpl2) != 0 && (node2 instanceof DelegatingNode)) {
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
                            }
                            parent$ui_release2 = parent$ui_release2.getParent$ui_release();
                        }
                    }
                    requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                    parent$ui_release2 = (requireLayoutNode2 == null || (nodes$ui_release = requireLayoutNode2.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                }
                if (arrayList != null && arrayList.size() - 1 >= 0) {
                    while (true) {
                        int i4 = i - 1;
                        if (((KeyInputModifierNode) arrayList.get(i)).mo61onPreKeyEventZmokQxo(keyEvent)) {
                            return true;
                        }
                        if (i4 < 0) {
                            break;
                        }
                        i = i4;
                    }
                }
                Modifier.Node node3 = lastLocalKeyInputNode.getNode();
                MutableVector mutableVector3 = null;
                while (node3 != null) {
                    if (node3 instanceof KeyInputModifierNode) {
                        if (((KeyInputModifierNode) node3).mo61onPreKeyEventZmokQxo(keyEvent)) {
                            return true;
                        }
                    } else if ((node3.getKindSet$ui_release() & m1386constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                        int i5 = 0;
                        for (Modifier.Node delegate$ui_release3 = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release3 != null; delegate$ui_release3 = delegate$ui_release3.getChild$ui_release()) {
                            if ((delegate$ui_release3.getKindSet$ui_release() & m1386constructorimpl2) != 0) {
                                i5++;
                                if (i5 == 1) {
                                    node3 = delegate$ui_release3;
                                } else {
                                    if (mutableVector3 == null) {
                                        mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node3 != null) {
                                        mutableVector3.add(node3);
                                        node3 = null;
                                    }
                                    mutableVector3.add(delegate$ui_release3);
                                }
                            }
                        }
                        if (i5 == 1) {
                        }
                    }
                    node3 = DelegatableNodeKt.pop(mutableVector3);
                }
                Modifier.Node node4 = lastLocalKeyInputNode.getNode();
                MutableVector mutableVector4 = null;
                while (node4 != null) {
                    if (node4 instanceof KeyInputModifierNode) {
                        if (((KeyInputModifierNode) node4).mo59onKeyEventZmokQxo(keyEvent)) {
                            return true;
                        }
                    } else if ((node4.getKindSet$ui_release() & m1386constructorimpl2) != 0 && (node4 instanceof DelegatingNode)) {
                        int i6 = 0;
                        for (Modifier.Node delegate$ui_release4 = ((DelegatingNode) node4).getDelegate$ui_release(); delegate$ui_release4 != null; delegate$ui_release4 = delegate$ui_release4.getChild$ui_release()) {
                            if ((delegate$ui_release4.getKindSet$ui_release() & m1386constructorimpl2) != 0) {
                                i6++;
                                if (i6 == 1) {
                                    node4 = delegate$ui_release4;
                                } else {
                                    if (mutableVector4 == null) {
                                        mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node4 != null) {
                                        mutableVector4.add(node4);
                                        node4 = null;
                                    }
                                    mutableVector4.add(delegate$ui_release4);
                                }
                            }
                        }
                        if (i6 == 1) {
                        }
                    }
                    node4 = DelegatableNodeKt.pop(mutableVector4);
                }
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        if (((KeyInputModifierNode) arrayList.get(i7)).mo59onKeyEventZmokQxo(keyEvent)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        throw new IllegalStateException("Event can't be processed because we do not have an active focus target.".toString());
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo */
    public boolean mo664dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent keyEvent) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            int m1386constructorimpl = NodeKind.m1386constructorimpl(PKIFailureInfo.unsupportedVersion);
            if (!findActiveFocusNode.getNode().isAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            Modifier.Node parent$ui_release = findActiveFocusNode.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(findActiveFocusNode);
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m1386constructorimpl) != 0) {
                    while (parent$ui_release != null) {
                        if ((parent$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                            Modifier.Node node = parent$ui_release;
                            MutableVector mutableVector = null;
                            while (node != null) {
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
                        }
                        parent$ui_release = parent$ui_release.getParent$ui_release();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(null);
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(RotaryScrollEvent event) {
        RotaryInputModifierNode rotaryInputModifierNode;
        int i;
        NodeChain nodes$ui_release;
        Modifier.Node node;
        NodeChain nodes$ui_release2;
        Intrinsics.checkNotNullParameter(event, "event");
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            int m1386constructorimpl = NodeKind.m1386constructorimpl(16384);
            if (!findActiveFocusNode.getNode().isAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            Modifier.Node parent$ui_release = findActiveFocusNode.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(findActiveFocusNode);
            loop0: while (true) {
                if (requireLayoutNode == null) {
                    node = null;
                    break;
                }
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m1386constructorimpl) != 0) {
                    while (parent$ui_release != null) {
                        if ((parent$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            node = parent$ui_release;
                            while (node != null) {
                                if (node instanceof RotaryInputModifierNode) {
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
                parent$ui_release = (requireLayoutNode == null || (nodes$ui_release2 = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
            }
            rotaryInputModifierNode = (RotaryInputModifierNode) node;
        } else {
            rotaryInputModifierNode = null;
        }
        if (rotaryInputModifierNode != null) {
            int m1386constructorimpl2 = NodeKind.m1386constructorimpl(16384);
            if (!rotaryInputModifierNode.getNode().isAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            Modifier.Node parent$ui_release2 = rotaryInputModifierNode.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(rotaryInputModifierNode);
            ArrayList arrayList = null;
            while (requireLayoutNode2 != null) {
                if ((requireLayoutNode2.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m1386constructorimpl2) != 0) {
                    while (parent$ui_release2 != null) {
                        if ((parent$ui_release2.getKindSet$ui_release() & m1386constructorimpl2) != 0) {
                            Modifier.Node node2 = parent$ui_release2;
                            MutableVector mutableVector2 = null;
                            while (node2 != null) {
                                if (node2 instanceof RotaryInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(node2);
                                } else if ((node2.getKindSet$ui_release() & m1386constructorimpl2) != 0 && (node2 instanceof DelegatingNode)) {
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
                        }
                        parent$ui_release2 = parent$ui_release2.getParent$ui_release();
                    }
                }
                requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                parent$ui_release2 = (requireLayoutNode2 == null || (nodes$ui_release = requireLayoutNode2.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i4 = i - 1;
                    if (((RotaryInputModifierNode) arrayList.get(i)).onPreRotaryScrollEvent(event)) {
                        return true;
                    }
                    if (i4 < 0) {
                        break;
                    }
                    i = i4;
                }
            }
            Modifier.Node node3 = rotaryInputModifierNode.getNode();
            MutableVector mutableVector3 = null;
            while (node3 != null) {
                if (node3 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node3).onPreRotaryScrollEvent(event)) {
                        return true;
                    }
                } else if ((node3.getKindSet$ui_release() & m1386constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                    int i5 = 0;
                    for (Modifier.Node delegate$ui_release3 = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release3 != null; delegate$ui_release3 = delegate$ui_release3.getChild$ui_release()) {
                        if ((delegate$ui_release3.getKindSet$ui_release() & m1386constructorimpl2) != 0) {
                            i5++;
                            if (i5 == 1) {
                                node3 = delegate$ui_release3;
                            } else {
                                if (mutableVector3 == null) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node3 != null) {
                                    mutableVector3.add(node3);
                                    node3 = null;
                                }
                                mutableVector3.add(delegate$ui_release3);
                            }
                        }
                    }
                    if (i5 == 1) {
                    }
                }
                node3 = DelegatableNodeKt.pop(mutableVector3);
            }
            Modifier.Node node4 = rotaryInputModifierNode.getNode();
            MutableVector mutableVector4 = null;
            while (node4 != null) {
                if (node4 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node4).onRotaryScrollEvent(event)) {
                        return true;
                    }
                } else if ((node4.getKindSet$ui_release() & m1386constructorimpl2) != 0 && (node4 instanceof DelegatingNode)) {
                    int i6 = 0;
                    for (Modifier.Node delegate$ui_release4 = ((DelegatingNode) node4).getDelegate$ui_release(); delegate$ui_release4 != null; delegate$ui_release4 = delegate$ui_release4.getChild$ui_release()) {
                        if ((delegate$ui_release4.getKindSet$ui_release() & m1386constructorimpl2) != 0) {
                            i6++;
                            if (i6 == 1) {
                                node4 = delegate$ui_release4;
                            } else {
                                if (mutableVector4 == null) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node4 != null) {
                                    mutableVector4.add(node4);
                                    node4 = null;
                                }
                                mutableVector4.add(delegate$ui_release4);
                            }
                        }
                    }
                    if (i6 == 1) {
                    }
                }
                node4 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i7 = 0; i7 < size; i7++) {
                    if (((RotaryInputModifierNode) arrayList.get(i7)).onRotaryScrollEvent(event)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusTargetNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusEventModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusPropertiesModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Rect getFocusRect() {
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            return FocusTraversalKt.focusRect(findActiveFocusNode);
        }
        return null;
    }

    /* renamed from: wrapAroundFocus-3ESFkO8  reason: not valid java name */
    private final boolean m666wrapAroundFocus3ESFkO8(int i) {
        if (this.rootFocusNode.getFocusState().getHasFocus() && !this.rootFocusNode.getFocusState().isFocused()) {
            FocusDirection.Companion companion = FocusDirection.Companion;
            if (FocusDirection.m650equalsimpl0(i, companion.m658getNextdhqQ8s()) || FocusDirection.m650equalsimpl0(i, companion.m659getPreviousdhqQ8s())) {
                clearFocus(false);
                if (this.rootFocusNode.getFocusState().isFocused()) {
                    return mo663moveFocus3ESFkO8(i);
                }
                return false;
            }
        }
        return false;
    }
}
