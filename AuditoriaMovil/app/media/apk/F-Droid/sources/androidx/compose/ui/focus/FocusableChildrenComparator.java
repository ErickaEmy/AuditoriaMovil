package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OneDimensionalFocusSearch.kt */
/* loaded from: classes.dex */
public final class FocusableChildrenComparator implements Comparator {
    public static final FocusableChildrenComparator INSTANCE = new FocusableChildrenComparator();

    private FocusableChildrenComparator() {
    }

    @Override // java.util.Comparator
    public int compare(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        if (focusTargetNode != null) {
            if (focusTargetNode2 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            int i = 0;
            if (!FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode) || !FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2)) {
                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode)) {
                    return -1;
                }
                return FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2) ? 1 : 0;
            }
            NodeCoordinator coordinator$ui_release = focusTargetNode.getCoordinator$ui_release();
            LayoutNode layoutNode = coordinator$ui_release != null ? coordinator$ui_release.getLayoutNode() : null;
            if (layoutNode == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            NodeCoordinator coordinator$ui_release2 = focusTargetNode2.getCoordinator$ui_release();
            LayoutNode layoutNode2 = coordinator$ui_release2 != null ? coordinator$ui_release2.getLayoutNode() : null;
            if (layoutNode2 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            if (Intrinsics.areEqual(layoutNode, layoutNode2)) {
                return 0;
            }
            MutableVector pathFromRoot = pathFromRoot(layoutNode);
            MutableVector pathFromRoot2 = pathFromRoot(layoutNode2);
            int min = Math.min(pathFromRoot.getSize() - 1, pathFromRoot2.getSize() - 1);
            if (min >= 0) {
                while (Intrinsics.areEqual(pathFromRoot.getContent()[i], pathFromRoot2.getContent()[i])) {
                    if (i != min) {
                        i++;
                    }
                }
                return Intrinsics.compare(((LayoutNode) pathFromRoot.getContent()[i]).getPlaceOrder$ui_release(), ((LayoutNode) pathFromRoot2.getContent()[i]).getPlaceOrder$ui_release());
            }
            throw new IllegalStateException("Could not find a common ancestor between the two FocusModifiers.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final MutableVector pathFromRoot(LayoutNode layoutNode) {
        MutableVector mutableVector = new MutableVector(new LayoutNode[16], 0);
        while (layoutNode != null) {
            mutableVector.add(0, layoutNode);
            layoutNode = layoutNode.getParent$ui_release();
        }
        return mutableVector;
    }
}
