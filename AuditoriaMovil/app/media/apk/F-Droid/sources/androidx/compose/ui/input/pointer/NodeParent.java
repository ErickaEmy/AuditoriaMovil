package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HitPathTracker.kt */
/* loaded from: classes.dex */
public class NodeParent {
    private final MutableVector children = new MutableVector(new Node[16], 0);

    public final MutableVector getChildren() {
        return this.children;
    }

    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        int size = this.children.getSize();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            if (((Node) this.children.getContent()[size]).getPointerIds().isEmpty()) {
                this.children.removeAt(size);
            }
        }
    }

    public final void clear() {
        this.children.clear();
    }

    public final void removeDetachedPointerInputFilters() {
        int i = 0;
        while (i < this.children.getSize()) {
            Node node = (Node) this.children.getContent()[i];
            if (!node.getModifierNode().isAttached()) {
                this.children.removeAt(i);
                node.dispatchCancel();
            } else {
                i++;
                node.removeDetachedPointerInputFilters();
            }
        }
    }

    public boolean buildCache(Map changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean z) {
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        MutableVector mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            boolean z2 = false;
            do {
                z2 = ((Node) content[i]).buildCache(changes, parentCoordinates, internalPointerEvent, z) || z2;
                i++;
            } while (i < size);
            return z2;
        }
        return false;
    }

    public void dispatchCancel() {
        MutableVector mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                ((Node) content[i]).dispatchCancel();
                i++;
            } while (i < size);
        }
    }

    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        MutableVector mutableVector = this.children;
        int size = mutableVector.getSize();
        boolean z = false;
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            boolean z2 = false;
            do {
                z2 = ((Node) content[i]).dispatchFinalEventPass(internalPointerEvent) || z2;
                i++;
            } while (i < size);
            z = z2;
        }
        cleanUpHits(internalPointerEvent);
        return z;
    }

    public boolean dispatchMainEventPass(Map changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean z) {
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        MutableVector mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            boolean z2 = false;
            do {
                z2 = ((Node) content[i]).dispatchMainEventPass(changes, parentCoordinates, internalPointerEvent, z) || z2;
                i++;
            } while (i < size);
            return z2;
        }
        return false;
    }
}
