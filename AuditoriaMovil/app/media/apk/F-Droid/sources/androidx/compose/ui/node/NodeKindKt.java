package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusEventModifierNodeKt;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusPropertiesModifierNodeKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTargetNodeKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.semantics.SemanticsModifier;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
/* compiled from: NodeKind.kt */
/* loaded from: classes.dex */
public abstract class NodeKindKt {
    public static final int calculateNodeKindSetFrom(Modifier.Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        int m1386constructorimpl = NodeKind.m1386constructorimpl(1);
        if (element instanceof LayoutModifier) {
            m1386constructorimpl |= NodeKind.m1386constructorimpl(2);
        }
        if (element instanceof DrawModifier) {
            m1386constructorimpl |= NodeKind.m1386constructorimpl(4);
        }
        if (element instanceof SemanticsModifier) {
            m1386constructorimpl |= NodeKind.m1386constructorimpl(8);
        }
        if ((element instanceof ModifierLocalConsumer) || (element instanceof ModifierLocalProvider)) {
            m1386constructorimpl |= NodeKind.m1386constructorimpl(32);
        }
        if (element instanceof OnGloballyPositionedModifier) {
            m1386constructorimpl |= NodeKind.m1386constructorimpl(256);
        }
        return ((element instanceof OnPlacedModifier) || (element instanceof OnRemeasuredModifier)) ? m1386constructorimpl | NodeKind.m1386constructorimpl(128) : m1386constructorimpl;
    }

    /* renamed from: getIncludeSelfInTraversal-H91voCI  reason: not valid java name */
    public static final boolean m1387getIncludeSelfInTraversalH91voCI(int i) {
        return (i & NodeKind.m1386constructorimpl(128)) != 0;
    }

    private static final void scheduleInvalidationOfAssociatedFocusTargets(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        int m1386constructorimpl = NodeKind.m1386constructorimpl(1024);
        if (!focusPropertiesModifierNode.getNode().isAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = focusPropertiesModifierNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusPropertiesModifierNode.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & m1386constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    } else if ((node.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                        MutableVector mutableVector2 = null;
                        while (node != null) {
                            if (!(node instanceof FocusTargetNode)) {
                                if ((node.getKindSet$ui_release() & m1386constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node = delegate$ui_release;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    mutableVector2.add(node);
                                                    node = null;
                                                }
                                                mutableVector2.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                            } else {
                                FocusTargetNodeKt.invalidateFocusTarget((FocusTargetNode) node);
                            }
                            node = DelegatableNodeKt.pop(mutableVector2);
                        }
                    } else {
                        node = node.getChild$ui_release();
                    }
                }
            }
        }
    }

    public static final int calculateNodeKindSetFrom(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node.getKindSet$ui_release() != 0) {
            return node.getKindSet$ui_release();
        }
        int m1386constructorimpl = NodeKind.m1386constructorimpl(1);
        if (node instanceof LayoutModifierNode) {
            m1386constructorimpl |= NodeKind.m1386constructorimpl(2);
        }
        if (node instanceof DrawModifierNode) {
            m1386constructorimpl |= NodeKind.m1386constructorimpl(4);
        }
        if (node instanceof SemanticsModifierNode) {
            m1386constructorimpl |= NodeKind.m1386constructorimpl(8);
        }
        if (node instanceof PointerInputModifierNode) {
            m1386constructorimpl |= NodeKind.m1386constructorimpl(16);
        }
        if (node instanceof ModifierLocalModifierNode) {
            m1386constructorimpl |= NodeKind.m1386constructorimpl(32);
        }
        if (node instanceof ParentDataModifierNode) {
            m1386constructorimpl |= NodeKind.m1386constructorimpl(64);
        }
        if (node instanceof LayoutAwareModifierNode) {
            m1386constructorimpl |= NodeKind.m1386constructorimpl(128);
        }
        if (node instanceof GlobalPositionAwareModifierNode) {
            m1386constructorimpl |= NodeKind.m1386constructorimpl(256);
        }
        if (node instanceof FocusTargetNode) {
            m1386constructorimpl |= NodeKind.m1386constructorimpl(1024);
        }
        if (node instanceof FocusPropertiesModifierNode) {
            m1386constructorimpl |= NodeKind.m1386constructorimpl(2048);
        }
        if (node instanceof FocusEventModifierNode) {
            m1386constructorimpl |= NodeKind.m1386constructorimpl(PKIFailureInfo.certConfirmed);
        }
        if (node instanceof KeyInputModifierNode) {
            m1386constructorimpl |= NodeKind.m1386constructorimpl(8192);
        }
        if (node instanceof RotaryInputModifierNode) {
            m1386constructorimpl |= NodeKind.m1386constructorimpl(16384);
        }
        return node instanceof CompositionLocalConsumerModifierNode ? m1386constructorimpl | NodeKind.m1386constructorimpl(32768) : m1386constructorimpl;
    }

    public static final void autoInvalidateRemovedNode(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (!node.isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 2);
    }

    public static final void autoInvalidateInsertedNode(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (!node.isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 1);
    }

    public static final void autoInvalidateUpdatedNode(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (!node.isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 0);
    }

    public static final void autoInvalidateNodeIncludingDelegates(Modifier.Node node, int i, int i2) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node instanceof DelegatingNode) {
            DelegatingNode delegatingNode = (DelegatingNode) node;
            autoInvalidateNodeSelf(node, delegatingNode.getSelfKindSet$ui_release() & i, i2);
            int i3 = (~delegatingNode.getSelfKindSet$ui_release()) & i;
            for (Modifier.Node delegate$ui_release = delegatingNode.getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                autoInvalidateNodeIncludingDelegates(delegate$ui_release, i3, i2);
            }
            return;
        }
        autoInvalidateNodeSelf(node, i & node.getKindSet$ui_release(), i2);
    }

    private static final void autoInvalidateNodeSelf(Modifier.Node node, int i, int i2) {
        if (i2 != 0 || node.getShouldAutoInvalidate()) {
            if ((NodeKind.m1386constructorimpl(2) & i) != 0 && (node instanceof LayoutModifierNode)) {
                LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode) node);
                if (i2 == 2) {
                    DelegatableNodeKt.m1296requireCoordinator64DMado(node, NodeKind.m1386constructorimpl(2)).onRelease();
                }
            }
            if ((NodeKind.m1386constructorimpl(256) & i) != 0 && (node instanceof GlobalPositionAwareModifierNode)) {
                DelegatableNodeKt.requireLayoutNode(node).invalidateMeasurements$ui_release();
            }
            if ((NodeKind.m1386constructorimpl(4) & i) != 0 && (node instanceof DrawModifierNode)) {
                DrawModifierNodeKt.invalidateDraw((DrawModifierNode) node);
            }
            if ((NodeKind.m1386constructorimpl(8) & i) != 0 && (node instanceof SemanticsModifierNode)) {
                SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode) node);
            }
            if ((NodeKind.m1386constructorimpl(64) & i) != 0 && (node instanceof ParentDataModifierNode)) {
                ParentDataModifierNodeKt.invalidateParentData((ParentDataModifierNode) node);
            }
            if ((NodeKind.m1386constructorimpl(1024) & i) != 0 && (node instanceof FocusTargetNode)) {
                if (i2 == 2) {
                    node.onReset();
                } else {
                    DelegatableNodeKt.requireOwner(node).getFocusOwner().scheduleInvalidation((FocusTargetNode) node);
                }
            }
            if ((NodeKind.m1386constructorimpl(2048) & i) != 0 && (node instanceof FocusPropertiesModifierNode)) {
                FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) node;
                if (specifiesCanFocusProperty(focusPropertiesModifierNode)) {
                    if (i2 == 2) {
                        scheduleInvalidationOfAssociatedFocusTargets(focusPropertiesModifierNode);
                    } else {
                        FocusPropertiesModifierNodeKt.invalidateFocusProperties(focusPropertiesModifierNode);
                    }
                }
            }
            if ((i & NodeKind.m1386constructorimpl(PKIFailureInfo.certConfirmed)) == 0 || !(node instanceof FocusEventModifierNode)) {
                return;
            }
            FocusEventModifierNodeKt.invalidateFocusEvent((FocusEventModifierNode) node);
        }
    }

    private static final boolean specifiesCanFocusProperty(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        CanFocusChecker canFocusChecker = CanFocusChecker.INSTANCE;
        canFocusChecker.reset();
        focusPropertiesModifierNode.applyFocusProperties(canFocusChecker);
        return canFocusChecker.isCanFocusSet();
    }

    public static final int calculateNodeKindSetFromIncludingDelegates(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node instanceof DelegatingNode) {
            DelegatingNode delegatingNode = (DelegatingNode) node;
            int selfKindSet$ui_release = delegatingNode.getSelfKindSet$ui_release();
            for (Modifier.Node delegate$ui_release = delegatingNode.getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                selfKindSet$ui_release |= calculateNodeKindSetFromIncludingDelegates(delegate$ui_release);
            }
            return selfKindSet$ui_release;
        }
        return calculateNodeKindSetFrom(node);
    }
}
