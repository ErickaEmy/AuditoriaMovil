package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import ch.qos.logback.core.CoreConstants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HitPathTracker.kt */
/* loaded from: classes.dex */
public final class Node extends NodeParent {
    private LayoutCoordinates coordinates;
    private boolean hasExited;
    private boolean isIn;
    private final Modifier.Node modifierNode;
    private PointerEvent pointerEvent;
    private final MutableVector pointerIds;
    private final Map relevantChanges;
    private boolean wasIn;

    public final Modifier.Node getModifierNode() {
        return this.modifierNode;
    }

    public final MutableVector getPointerIds() {
        return this.pointerIds;
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    public Node(Modifier.Node modifierNode) {
        Intrinsics.checkNotNullParameter(modifierNode, "modifierNode");
        this.modifierNode = modifierNode;
        this.pointerIds = new MutableVector(new PointerId[16], 0);
        this.relevantChanges = new LinkedHashMap();
        this.isIn = true;
        this.hasExited = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x01f4  */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean buildCache(java.util.Map r34, androidx.compose.ui.layout.LayoutCoordinates r35, androidx.compose.ui.input.pointer.InternalPointerEvent r36, boolean r37) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.buildCache(java.util.Map, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent, boolean):boolean");
    }

    private final boolean hasPositionChanged(PointerEvent pointerEvent, PointerEvent pointerEvent2) {
        if (pointerEvent == null || pointerEvent.getChanges().size() != pointerEvent2.getChanges().size()) {
            return true;
        }
        int size = pointerEvent2.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m706equalsimpl0(((PointerInputChange) pointerEvent.getChanges().get(i)).m1196getPositionF1C5BW0(), ((PointerInputChange) pointerEvent2.getChanges().get(i)).m1196getPositionF1C5BW0())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        MutableVector children;
        int size;
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        boolean z = false;
        int i = 0;
        z = false;
        if (!this.relevantChanges.isEmpty() && this.modifierNode.isAttached()) {
            PointerEvent pointerEvent = this.pointerEvent;
            Intrinsics.checkNotNull(pointerEvent);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long mo1253getSizeYbymL2g = layoutCoordinates.mo1253getSizeYbymL2g();
            Modifier.Node node = this.modifierNode;
            int m1386constructorimpl = NodeKind.m1386constructorimpl(16);
            MutableVector mutableVector = null;
            while (node != null) {
                if (!(node instanceof PointerInputModifierNode)) {
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
                } else {
                    ((PointerInputModifierNode) node).mo60onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, mo1253getSizeYbymL2g);
                }
                node = DelegatableNodeKt.pop(mutableVector);
            }
            if (!this.modifierNode.isAttached() || (size = (children = getChildren()).getSize()) <= 0) {
                z = true;
            } else {
                Object[] content = children.getContent();
                do {
                    ((Node) content[i]).dispatchFinalEventPass(internalPointerEvent);
                    i++;
                } while (i < size);
                z = true;
            }
        }
        cleanUpHits(internalPointerEvent);
        clearCache();
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00bc  */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchMainEventPass(java.util.Map r12, androidx.compose.ui.layout.LayoutCoordinates r13, androidx.compose.ui.input.pointer.InternalPointerEvent r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.dispatchMainEventPass(java.util.Map, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void dispatchCancel() {
        /*
            r10 = this;
            androidx.compose.runtime.collection.MutableVector r0 = r10.getChildren()
            int r1 = r0.getSize()
            r2 = 0
            r3 = 1
            if (r1 <= 0) goto L1b
            java.lang.Object[] r0 = r0.getContent()
            r4 = r2
        L11:
            r5 = r0[r4]
            androidx.compose.ui.input.pointer.Node r5 = (androidx.compose.ui.input.pointer.Node) r5
            r5.dispatchCancel()
            int r4 = r4 + r3
            if (r4 < r1) goto L11
        L1b:
            androidx.compose.ui.Modifier$Node r0 = r10.modifierNode
            r1 = 16
            int r4 = androidx.compose.ui.node.NodeKind.m1386constructorimpl(r1)
            r5 = 0
            r6 = r5
        L25:
            if (r0 == 0) goto L72
            boolean r7 = r0 instanceof androidx.compose.ui.node.PointerInputModifierNode
            if (r7 == 0) goto L31
            androidx.compose.ui.node.PointerInputModifierNode r0 = (androidx.compose.ui.node.PointerInputModifierNode) r0
            r0.onCancelPointerInput()
            goto L6d
        L31:
            int r7 = r0.getKindSet$ui_release()
            r7 = r7 & r4
            if (r7 == 0) goto L6d
            boolean r7 = r0 instanceof androidx.compose.ui.node.DelegatingNode
            if (r7 == 0) goto L6d
            r7 = r0
            androidx.compose.ui.node.DelegatingNode r7 = (androidx.compose.ui.node.DelegatingNode) r7
            androidx.compose.ui.Modifier$Node r7 = r7.getDelegate$ui_release()
            r8 = r2
        L44:
            if (r7 == 0) goto L6a
            int r9 = r7.getKindSet$ui_release()
            r9 = r9 & r4
            if (r9 == 0) goto L65
            int r8 = r8 + 1
            if (r8 != r3) goto L53
            r0 = r7
            goto L65
        L53:
            if (r6 != 0) goto L5c
            androidx.compose.runtime.collection.MutableVector r6 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r9 = new androidx.compose.ui.Modifier.Node[r1]
            r6.<init>(r9, r2)
        L5c:
            if (r0 == 0) goto L62
            r6.add(r0)
            r0 = r5
        L62:
            r6.add(r7)
        L65:
            androidx.compose.ui.Modifier$Node r7 = r7.getChild$ui_release()
            goto L44
        L6a:
            if (r8 != r3) goto L6d
            goto L25
        L6d:
            androidx.compose.ui.Modifier$Node r0 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r6)
            goto L25
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.dispatchCancel():void");
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = (PointerInputChange) changes.get(i);
            if (!pointerInputChange.getPressed() && (!internalPointerEvent.m1164issuesEnterExitEvent0FcD4WY(pointerInputChange.m1195getIdJ3iCeTQ()) || !this.isIn)) {
                this.pointerIds.remove(PointerId.m1185boximpl(pointerInputChange.m1195getIdJ3iCeTQ()));
            }
        }
        this.isIn = false;
        this.hasExited = PointerEventType.m1175equalsimpl0(pointerEvent.m1170getType7fucELk(), PointerEventType.Companion.m1177getExit7fucELk());
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.modifierNode + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
