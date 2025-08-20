package androidx.compose.ui.node;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import ch.qos.logback.classic.pattern.CallerDataConverter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LayoutTreeConsistencyChecker.kt */
/* loaded from: classes.dex */
public final class LayoutTreeConsistencyChecker {
    private final List postponedMeasureRequests;
    private final DepthSortedSetsForDifferentPasses relayoutNodes;
    private final LayoutNode root;

    public LayoutTreeConsistencyChecker(LayoutNode root, DepthSortedSetsForDifferentPasses relayoutNodes, List postponedMeasureRequests) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(relayoutNodes, "relayoutNodes");
        Intrinsics.checkNotNullParameter(postponedMeasureRequests, "postponedMeasureRequests");
        this.root = root;
        this.relayoutNodes = relayoutNodes;
        this.postponedMeasureRequests = postponedMeasureRequests;
    }

    public final void assertConsistent() {
        if (!isTreeConsistent(this.root)) {
            System.out.println((Object) logTree());
            throw new IllegalStateException("Inconsistency found!");
        }
    }

    private final boolean isTreeConsistent(LayoutNode layoutNode) {
        if (consistentLayoutState(layoutNode)) {
            List children$ui_release = layoutNode.getChildren$ui_release();
            int size = children$ui_release.size();
            for (int i = 0; i < size; i++) {
                if (!isTreeConsistent((LayoutNode) children$ui_release.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private final boolean consistentLayoutState(LayoutNode layoutNode) {
        Object obj;
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        Object obj2 = null;
        LayoutNode.LayoutState layoutState$ui_release = parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null;
        if (layoutNode.isPlaced() || (layoutNode.getPlaceOrder$ui_release() != Integer.MAX_VALUE && parent$ui_release != null && parent$ui_release.isPlaced())) {
            if (layoutNode.getMeasurePending$ui_release()) {
                List list = this.postponedMeasureRequests;
                int size = list.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        obj = null;
                        break;
                    }
                    obj = list.get(i);
                    MeasureAndLayoutDelegate.PostponedRequest postponedRequest = (MeasureAndLayoutDelegate.PostponedRequest) obj;
                    if (Intrinsics.areEqual(postponedRequest.getNode(), layoutNode) && !postponedRequest.isLookahead()) {
                        break;
                    }
                    i++;
                }
                if (obj != null) {
                    return true;
                }
            }
            if (layoutNode.getMeasurePending$ui_release()) {
                return this.relayoutNodes.contains(layoutNode) || (parent$ui_release != null && parent$ui_release.getMeasurePending$ui_release()) || ((parent$ui_release != null && parent$ui_release.getLookaheadMeasurePending$ui_release()) || layoutState$ui_release == LayoutNode.LayoutState.Measuring);
            } else if (layoutNode.getLayoutPending$ui_release()) {
                return this.relayoutNodes.contains(layoutNode) || parent$ui_release == null || parent$ui_release.getMeasurePending$ui_release() || parent$ui_release.getLayoutPending$ui_release() || layoutState$ui_release == LayoutNode.LayoutState.Measuring || layoutState$ui_release == LayoutNode.LayoutState.LayingOut;
            }
        }
        if (Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE)) {
            if (layoutNode.getLookaheadMeasurePending$ui_release()) {
                List list2 = this.postponedMeasureRequests;
                int size2 = list2.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size2) {
                        break;
                    }
                    Object obj3 = list2.get(i2);
                    MeasureAndLayoutDelegate.PostponedRequest postponedRequest2 = (MeasureAndLayoutDelegate.PostponedRequest) obj3;
                    if (Intrinsics.areEqual(postponedRequest2.getNode(), layoutNode) && postponedRequest2.isLookahead()) {
                        obj2 = obj3;
                        break;
                    }
                    i2++;
                }
                if (obj2 != null) {
                    return true;
                }
            }
            if (layoutNode.getLookaheadMeasurePending$ui_release()) {
                return this.relayoutNodes.contains(layoutNode, true) || (parent$ui_release != null && parent$ui_release.getLookaheadMeasurePending$ui_release()) || layoutState$ui_release == LayoutNode.LayoutState.LookaheadMeasuring || (parent$ui_release != null && parent$ui_release.getMeasurePending$ui_release() && Intrinsics.areEqual(layoutNode.getLookaheadRoot$ui_release(), layoutNode));
            } else if (layoutNode.getLookaheadLayoutPending$ui_release()) {
                return this.relayoutNodes.contains(layoutNode, true) || parent$ui_release == null || parent$ui_release.getLookaheadMeasurePending$ui_release() || parent$ui_release.getLookaheadLayoutPending$ui_release() || layoutState$ui_release == LayoutNode.LayoutState.LookaheadMeasuring || layoutState$ui_release == LayoutNode.LayoutState.LookaheadLayingOut || (parent$ui_release.getLayoutPending$ui_release() && Intrinsics.areEqual(layoutNode.getLookaheadRoot$ui_release(), layoutNode));
            }
        }
        return true;
    }

    private final String nodeToString(LayoutNode layoutNode) {
        StringBuilder sb = new StringBuilder();
        sb.append(layoutNode);
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        sb2.append(layoutNode.getLayoutState$ui_release());
        sb2.append(']');
        sb.append(sb2.toString());
        if (!layoutNode.isPlaced()) {
            sb.append("[!isPlaced]");
        }
        sb.append("[measuredByParent=" + layoutNode.getMeasuredByParent$ui_release() + ']');
        if (!consistentLayoutState(layoutNode)) {
            sb.append("[INCONSISTENT]");
        }
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "with(StringBuilder()) {\n…     toString()\n        }");
        return sb3;
    }

    private final String logTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tree state:");
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        logTree$printSubTree(this, sb, this.root, 0);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
        return sb2;
    }

    private static final void logTree$printSubTree(LayoutTreeConsistencyChecker layoutTreeConsistencyChecker, StringBuilder sb, LayoutNode layoutNode, int i) {
        String nodeToString = layoutTreeConsistencyChecker.nodeToString(layoutNode);
        if (nodeToString.length() > 0) {
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(CallerDataConverter.DEFAULT_RANGE_DELIMITER);
            }
            sb.append(nodeToString);
            Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
            i++;
        }
        List children$ui_release = layoutNode.getChildren$ui_release();
        int size = children$ui_release.size();
        for (int i3 = 0; i3 < size; i3++) {
            logTree$printSubTree(layoutTreeConsistencyChecker, sb, (LayoutNode) children$ui_release.get(i3), i);
        }
    }
}
