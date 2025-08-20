package androidx.compose.ui.node;

import androidx.compose.ui.layout.LayoutCoordinates;
/* compiled from: GlobalPositionAwareModifierNode.kt */
/* loaded from: classes.dex */
public interface GlobalPositionAwareModifierNode extends DelegatableNode {
    void onGloballyPositioned(LayoutCoordinates layoutCoordinates);
}
