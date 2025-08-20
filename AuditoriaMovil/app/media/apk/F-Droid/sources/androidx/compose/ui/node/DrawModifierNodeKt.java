package androidx.compose.ui.node;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: DrawModifierNode.kt */
/* loaded from: classes.dex */
public abstract class DrawModifierNodeKt {
    public static final void invalidateDraw(DrawModifierNode drawModifierNode) {
        Intrinsics.checkNotNullParameter(drawModifierNode, "<this>");
        if (drawModifierNode.getNode().isAttached()) {
            DelegatableNodeKt.m1296requireCoordinator64DMado(drawModifierNode, NodeKind.m1386constructorimpl(1)).invalidateLayer();
        }
    }
}
