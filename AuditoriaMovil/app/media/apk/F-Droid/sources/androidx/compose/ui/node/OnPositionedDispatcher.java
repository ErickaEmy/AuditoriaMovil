package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import java.util.Comparator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: OnPositionedDispatcher.kt */
/* loaded from: classes.dex */
public final class OnPositionedDispatcher {
    public static final Companion Companion = new Companion(null);
    private final MutableVector layoutNodes = new MutableVector(new LayoutNode[16], 0);

    public final boolean isNotEmpty() {
        return this.layoutNodes.isNotEmpty();
    }

    public final void onRootNodePositioned(LayoutNode rootNode) {
        Intrinsics.checkNotNullParameter(rootNode, "rootNode");
        this.layoutNodes.clear();
        this.layoutNodes.add(rootNode);
        rootNode.setNeedsOnPositionedDispatch$ui_release(true);
    }

    public final void dispatch() {
        this.layoutNodes.sortWith(Companion.DepthComparator.INSTANCE);
        MutableVector mutableVector = this.layoutNodes;
        int size = mutableVector.getSize();
        if (size <= 0) {
            this.layoutNodes.clear();
        }
        int i = size - 1;
        Object[] content = mutableVector.getContent();
        do {
            LayoutNode layoutNode = (LayoutNode) content[i];
            if (layoutNode.getNeedsOnPositionedDispatch$ui_release()) {
                dispatchHierarchy(layoutNode);
            }
            i--;
        } while (i >= 0);
        this.layoutNodes.clear();
    }

    private final void dispatchHierarchy(LayoutNode layoutNode) {
        layoutNode.dispatchOnPositionedCallbacks$ui_release();
        int i = 0;
        layoutNode.setNeedsOnPositionedDispatch$ui_release(false);
        MutableVector mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            do {
                dispatchHierarchy((LayoutNode) content[i]);
                i++;
            } while (i < size);
        }
    }

    /* compiled from: OnPositionedDispatcher.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: OnPositionedDispatcher.kt */
        /* loaded from: classes.dex */
        private static final class DepthComparator implements Comparator {
            public static final DepthComparator INSTANCE = new DepthComparator();

            private DepthComparator() {
            }

            @Override // java.util.Comparator
            public int compare(LayoutNode a, LayoutNode b) {
                Intrinsics.checkNotNullParameter(a, "a");
                Intrinsics.checkNotNullParameter(b, "b");
                int compare = Intrinsics.compare(b.getDepth$ui_release(), a.getDepth$ui_release());
                return compare != 0 ? compare : Intrinsics.compare(a.hashCode(), b.hashCode());
            }
        }
    }

    public final void onNodePositioned(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.layoutNodes.add(node);
        node.setNeedsOnPositionedDispatch$ui_release(true);
    }
}
