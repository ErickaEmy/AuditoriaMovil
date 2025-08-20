package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FocusInvalidationManager.kt */
/* loaded from: classes.dex */
public final class FocusInvalidationManager {
    private Set focusEventNodes;
    private Set focusPropertiesNodes;
    private Set focusTargetNodes;
    private final Function0 invalidateNodes;
    private final Function1 onRequestApplyChangesListener;

    public FocusInvalidationManager(Function1 onRequestApplyChangesListener) {
        Intrinsics.checkNotNullParameter(onRequestApplyChangesListener, "onRequestApplyChangesListener");
        this.onRequestApplyChangesListener = onRequestApplyChangesListener;
        this.focusTargetNodes = new LinkedHashSet();
        this.focusEventNodes = new LinkedHashSet();
        this.focusPropertiesNodes = new LinkedHashSet();
        this.invalidateNodes = new Function0() { // from class: androidx.compose.ui.focus.FocusInvalidationManager$invalidateNodes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m662invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m662invoke() {
                Set set;
                Set set2;
                Set<FocusEventModifierNode> set3;
                Set set4;
                Set<FocusTargetNode> set5;
                Set set6;
                Set set7;
                Set set8;
                Set set9;
                int i;
                int i2;
                FocusState focusState;
                int i3;
                int i4;
                Set set10;
                Set set11;
                Set set12;
                Set set13;
                set = FocusInvalidationManager.this.focusPropertiesNodes;
                FocusInvalidationManager focusInvalidationManager = FocusInvalidationManager.this;
                Iterator it = set.iterator();
                while (true) {
                    int i5 = 1024;
                    int i6 = 16;
                    int i7 = 0;
                    int i8 = 1;
                    if (!it.hasNext()) {
                        set2 = FocusInvalidationManager.this.focusPropertiesNodes;
                        set2.clear();
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        set3 = FocusInvalidationManager.this.focusEventNodes;
                        FocusInvalidationManager focusInvalidationManager2 = FocusInvalidationManager.this;
                        for (FocusEventModifierNode focusEventModifierNode : set3) {
                            if (focusEventModifierNode.getNode().isAttached()) {
                                int m1386constructorimpl = NodeKind.m1386constructorimpl(i5);
                                Modifier.Node node = focusEventModifierNode.getNode();
                                int i9 = i7;
                                int i10 = i8;
                                FocusTargetNode focusTargetNode = null;
                                MutableVector mutableVector = null;
                                while (node != null) {
                                    if (node instanceof FocusTargetNode) {
                                        FocusTargetNode focusTargetNode2 = (FocusTargetNode) node;
                                        if (focusTargetNode != null) {
                                            i9 = i8;
                                        }
                                        set11 = focusInvalidationManager2.focusTargetNodes;
                                        if (set11.contains(focusTargetNode2)) {
                                            linkedHashSet.add(focusTargetNode2);
                                            i10 = i7;
                                        }
                                        focusTargetNode = focusTargetNode2;
                                    } else if ((node.getKindSet$ui_release() & m1386constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                        Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release();
                                        int i11 = i7;
                                        while (delegate$ui_release != null) {
                                            if ((delegate$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                                                i11++;
                                                if (i11 == i8) {
                                                    node = delegate$ui_release;
                                                } else {
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[i6], i7);
                                                    }
                                                    if (node != null) {
                                                        mutableVector.add(node);
                                                        node = null;
                                                    }
                                                    mutableVector.add(delegate$ui_release);
                                                }
                                            }
                                            delegate$ui_release = delegate$ui_release.getChild$ui_release();
                                            i8 = 1;
                                        }
                                        int i12 = i8;
                                        if (i11 == i12) {
                                            i8 = i12;
                                        }
                                    }
                                    node = DelegatableNodeKt.pop(mutableVector);
                                    i8 = 1;
                                }
                                if (!focusEventModifierNode.getNode().isAttached()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                                }
                                MutableVector mutableVector2 = new MutableVector(new Modifier.Node[i6], i7);
                                Modifier.Node child$ui_release = focusEventModifierNode.getNode().getChild$ui_release();
                                if (child$ui_release == null) {
                                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusEventModifierNode.getNode());
                                } else {
                                    mutableVector2.add(child$ui_release);
                                }
                                while (mutableVector2.isNotEmpty()) {
                                    Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
                                    if ((node2.getAggregateChildKindSet$ui_release() & m1386constructorimpl) == 0) {
                                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node2);
                                    } else {
                                        while (node2 != null) {
                                            if ((node2.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                                                MutableVector mutableVector3 = null;
                                                while (node2 != null) {
                                                    if (node2 instanceof FocusTargetNode) {
                                                        FocusTargetNode focusTargetNode3 = (FocusTargetNode) node2;
                                                        if (focusTargetNode != null) {
                                                            i9 = 1;
                                                        }
                                                        set10 = focusInvalidationManager2.focusTargetNodes;
                                                        if (set10.contains(focusTargetNode3)) {
                                                            linkedHashSet.add(focusTargetNode3);
                                                            i10 = i7;
                                                        }
                                                        focusTargetNode = focusTargetNode3;
                                                    } else if ((node2.getKindSet$ui_release() & m1386constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                                                        Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release();
                                                        int i13 = i7;
                                                        while (delegate$ui_release2 != null) {
                                                            if ((delegate$ui_release2.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                                                                i13++;
                                                                if (i13 == 1) {
                                                                    node2 = delegate$ui_release2;
                                                                    i4 = 0;
                                                                } else {
                                                                    if (mutableVector3 == null) {
                                                                        Modifier.Node[] nodeArr = new Modifier.Node[i6];
                                                                        i4 = 0;
                                                                        mutableVector3 = new MutableVector(nodeArr, 0);
                                                                    } else {
                                                                        i4 = 0;
                                                                    }
                                                                    if (node2 != null) {
                                                                        mutableVector3.add(node2);
                                                                        node2 = null;
                                                                    }
                                                                    mutableVector3.add(delegate$ui_release2);
                                                                }
                                                            } else {
                                                                i4 = i7;
                                                            }
                                                            delegate$ui_release2 = delegate$ui_release2.getChild$ui_release();
                                                            i7 = i4;
                                                            i6 = 16;
                                                        }
                                                        i3 = i7;
                                                        if (i13 == 1) {
                                                            i7 = i3;
                                                            i6 = 16;
                                                        }
                                                        node2 = DelegatableNodeKt.pop(mutableVector3);
                                                        i7 = i3;
                                                        i6 = 16;
                                                    }
                                                    i3 = i7;
                                                    node2 = DelegatableNodeKt.pop(mutableVector3);
                                                    i7 = i3;
                                                    i6 = 16;
                                                }
                                            } else {
                                                node2 = node2.getChild$ui_release();
                                                i7 = i7;
                                                i6 = 16;
                                            }
                                        }
                                    }
                                    i7 = i7;
                                    i6 = 16;
                                }
                                i = i7;
                                i2 = 1;
                                if (i10 != 0) {
                                    if (i9 != 0) {
                                        focusState = FocusEventModifierNodeKt.getFocusState(focusEventModifierNode);
                                    } else if (focusTargetNode == null || (focusState = focusTargetNode.getFocusState()) == null) {
                                        focusState = FocusStateImpl.Inactive;
                                    }
                                    focusEventModifierNode.onFocusEvent(focusState);
                                }
                            } else {
                                focusEventModifierNode.onFocusEvent(FocusStateImpl.Inactive);
                                i = i7;
                                i2 = i8;
                            }
                            i8 = i2;
                            i5 = 1024;
                            i7 = i;
                            i6 = 16;
                        }
                        set4 = FocusInvalidationManager.this.focusEventNodes;
                        set4.clear();
                        set5 = FocusInvalidationManager.this.focusTargetNodes;
                        for (FocusTargetNode focusTargetNode4 : set5) {
                            if (focusTargetNode4.isAttached()) {
                                FocusStateImpl focusState2 = focusTargetNode4.getFocusState();
                                focusTargetNode4.invalidateFocus$ui_release();
                                if (focusState2 != focusTargetNode4.getFocusState() || linkedHashSet.contains(focusTargetNode4)) {
                                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode4);
                                }
                            }
                        }
                        set6 = FocusInvalidationManager.this.focusTargetNodes;
                        set6.clear();
                        linkedHashSet.clear();
                        set7 = FocusInvalidationManager.this.focusPropertiesNodes;
                        if (!set7.isEmpty()) {
                            throw new IllegalStateException("Unprocessed FocusProperties nodes".toString());
                        }
                        set8 = FocusInvalidationManager.this.focusEventNodes;
                        if (!set8.isEmpty()) {
                            throw new IllegalStateException("Unprocessed FocusEvent nodes".toString());
                        }
                        set9 = FocusInvalidationManager.this.focusTargetNodes;
                        if (!set9.isEmpty()) {
                            throw new IllegalStateException("Unprocessed FocusTarget nodes".toString());
                        }
                        return;
                    }
                    FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) it.next();
                    if (focusPropertiesModifierNode.getNode().isAttached()) {
                        int m1386constructorimpl2 = NodeKind.m1386constructorimpl(1024);
                        Modifier.Node node3 = focusPropertiesModifierNode.getNode();
                        MutableVector mutableVector4 = null;
                        while (node3 != null) {
                            if (node3 instanceof FocusTargetNode) {
                                set13 = focusInvalidationManager.focusTargetNodes;
                                set13.add((FocusTargetNode) node3);
                            } else if ((node3.getKindSet$ui_release() & m1386constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                                int i14 = 0;
                                for (Modifier.Node delegate$ui_release3 = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release3 != null; delegate$ui_release3 = delegate$ui_release3.getChild$ui_release()) {
                                    if ((delegate$ui_release3.getKindSet$ui_release() & m1386constructorimpl2) != 0) {
                                        i14++;
                                        if (i14 == 1) {
                                            node3 = delegate$ui_release3;
                                        } else {
                                            if (mutableVector4 == null) {
                                                mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node3 != null) {
                                                mutableVector4.add(node3);
                                                node3 = null;
                                            }
                                            mutableVector4.add(delegate$ui_release3);
                                        }
                                    }
                                }
                                if (i14 == 1) {
                                }
                            }
                            node3 = DelegatableNodeKt.pop(mutableVector4);
                        }
                        if (!focusPropertiesModifierNode.getNode().isAttached()) {
                            throw new IllegalStateException("visitChildren called on an unattached node".toString());
                        }
                        MutableVector mutableVector5 = new MutableVector(new Modifier.Node[16], 0);
                        Modifier.Node child$ui_release2 = focusPropertiesModifierNode.getNode().getChild$ui_release();
                        if (child$ui_release2 == null) {
                            DelegatableNodeKt.addLayoutNodeChildren(mutableVector5, focusPropertiesModifierNode.getNode());
                        } else {
                            mutableVector5.add(child$ui_release2);
                        }
                        while (mutableVector5.isNotEmpty()) {
                            Modifier.Node node4 = (Modifier.Node) mutableVector5.removeAt(mutableVector5.getSize() - 1);
                            if ((node4.getAggregateChildKindSet$ui_release() & m1386constructorimpl2) == 0) {
                                DelegatableNodeKt.addLayoutNodeChildren(mutableVector5, node4);
                            } else {
                                while (true) {
                                    if (node4 == null) {
                                        break;
                                    } else if ((node4.getKindSet$ui_release() & m1386constructorimpl2) != 0) {
                                        MutableVector mutableVector6 = null;
                                        while (node4 != null) {
                                            if (node4 instanceof FocusTargetNode) {
                                                set12 = focusInvalidationManager.focusTargetNodes;
                                                set12.add((FocusTargetNode) node4);
                                            } else if ((node4.getKindSet$ui_release() & m1386constructorimpl2) != 0 && (node4 instanceof DelegatingNode)) {
                                                int i15 = 0;
                                                for (Modifier.Node delegate$ui_release4 = ((DelegatingNode) node4).getDelegate$ui_release(); delegate$ui_release4 != null; delegate$ui_release4 = delegate$ui_release4.getChild$ui_release()) {
                                                    if ((delegate$ui_release4.getKindSet$ui_release() & m1386constructorimpl2) != 0) {
                                                        i15++;
                                                        if (i15 == 1) {
                                                            node4 = delegate$ui_release4;
                                                        } else {
                                                            if (mutableVector6 == null) {
                                                                mutableVector6 = new MutableVector(new Modifier.Node[16], 0);
                                                            }
                                                            if (node4 != null) {
                                                                mutableVector6.add(node4);
                                                                node4 = null;
                                                            }
                                                            mutableVector6.add(delegate$ui_release4);
                                                        }
                                                    }
                                                }
                                                if (i15 == 1) {
                                                }
                                            }
                                            node4 = DelegatableNodeKt.pop(mutableVector6);
                                        }
                                    } else {
                                        node4 = node4.getChild$ui_release();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        };
    }

    public final void scheduleInvalidation(FocusTargetNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        scheduleInvalidation(this.focusTargetNodes, node);
    }

    public final void scheduleInvalidation(FocusEventModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        scheduleInvalidation(this.focusEventNodes, node);
    }

    public final void scheduleInvalidation(FocusPropertiesModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        scheduleInvalidation(this.focusPropertiesNodes, node);
    }

    private final void scheduleInvalidation(Set set, Object obj) {
        if (set.add(obj) && this.focusTargetNodes.size() + this.focusEventNodes.size() + this.focusPropertiesNodes.size() == 1) {
            this.onRequestApplyChangesListener.invoke(this.invalidateNodes);
        }
    }
}
