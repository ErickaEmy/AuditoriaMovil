package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HitPathTracker.kt */
/* loaded from: classes.dex */
public final class HitPathTracker {
    private final NodeParent root;
    private final LayoutCoordinates rootCoordinates;

    public HitPathTracker(LayoutCoordinates rootCoordinates) {
        Intrinsics.checkNotNullParameter(rootCoordinates, "rootCoordinates");
        this.rootCoordinates = rootCoordinates;
        this.root = new NodeParent();
    }

    /* renamed from: addHitPath-KNwqfcY  reason: not valid java name */
    public final void m1163addHitPathKNwqfcY(long j, List pointerInputNodes) {
        Node node;
        Intrinsics.checkNotNullParameter(pointerInputNodes, "pointerInputNodes");
        Node node2 = this.root;
        int size = pointerInputNodes.size();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            Modifier.Node node3 = (Modifier.Node) pointerInputNodes.get(i);
            if (z) {
                MutableVector children = node2.getChildren();
                int size2 = children.getSize();
                if (size2 > 0) {
                    Object[] content = children.getContent();
                    int i2 = 0;
                    do {
                        node = content[i2];
                        if (Intrinsics.areEqual(((Node) node).getModifierNode(), node3)) {
                            break;
                        }
                        i2++;
                    } while (i2 < size2);
                    node = null;
                } else {
                    node = null;
                }
                Node node4 = node;
                if (node4 != null) {
                    node4.markIsIn();
                    if (!node4.getPointerIds().contains(PointerId.m1185boximpl(j))) {
                        node4.getPointerIds().add(PointerId.m1185boximpl(j));
                    }
                    node2 = node4;
                } else {
                    z = false;
                }
            }
            Node node5 = new Node(node3);
            node5.getPointerIds().add(PointerId.m1185boximpl(j));
            node2.getChildren().add(node5);
            node2 = node5;
        }
    }

    public final boolean dispatchChanges(InternalPointerEvent internalPointerEvent, boolean z) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        if (this.root.buildCache(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, z)) {
            return this.root.dispatchFinalEventPass(internalPointerEvent) || this.root.dispatchMainEventPass(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, z);
        }
        return false;
    }

    public final void processCancel() {
        this.root.dispatchCancel();
        this.root.clear();
    }

    public final void removeDetachedPointerInputFilters() {
        this.root.removeDetachedPointerInputFilters();
    }
}
