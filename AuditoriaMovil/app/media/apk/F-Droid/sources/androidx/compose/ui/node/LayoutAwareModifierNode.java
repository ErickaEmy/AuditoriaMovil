package androidx.compose.ui.node;

import androidx.compose.ui.layout.LayoutCoordinates;
/* compiled from: LayoutAwareModifierNode.kt */
/* loaded from: classes.dex */
public interface LayoutAwareModifierNode extends DelegatableNode {

    /* compiled from: LayoutAwareModifierNode.kt */
    /* renamed from: androidx.compose.ui.node.LayoutAwareModifierNode$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        /* renamed from: $default$onRemeasured-ozmzZPI  reason: not valid java name */
        public static void m1303$default$onRemeasuredozmzZPI(LayoutAwareModifierNode layoutAwareModifierNode, long j) {
        }
    }

    void onPlaced(LayoutCoordinates layoutCoordinates);

    /* renamed from: onRemeasured-ozmzZPI */
    void mo105onRemeasuredozmzZPI(long j);
}
