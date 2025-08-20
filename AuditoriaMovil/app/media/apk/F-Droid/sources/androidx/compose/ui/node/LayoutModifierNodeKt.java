package androidx.compose.ui.node;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: LayoutModifierNode.kt */
/* loaded from: classes.dex */
public abstract class LayoutModifierNodeKt {
    public static final void invalidateLayer(LayoutModifierNode layoutModifierNode) {
        Intrinsics.checkNotNullParameter(layoutModifierNode, "<this>");
        DelegatableNodeKt.m1296requireCoordinator64DMado(layoutModifierNode, NodeKind.m1386constructorimpl(2)).invalidateLayer();
    }

    public static final void invalidateMeasurement(LayoutModifierNode layoutModifierNode) {
        Intrinsics.checkNotNullParameter(layoutModifierNode, "<this>");
        DelegatableNodeKt.requireLayoutNode(layoutModifierNode).invalidateMeasurements$ui_release();
    }
}
