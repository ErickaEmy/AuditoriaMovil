package androidx.compose.ui.node;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PointerInputModifierNode.kt */
/* loaded from: classes.dex */
public abstract class PointerInputModifierNodeKt {
    public static final LayoutCoordinates getLayoutCoordinates(PointerInputModifierNode pointerInputModifierNode) {
        Intrinsics.checkNotNullParameter(pointerInputModifierNode, "<this>");
        return DelegatableNodeKt.m1296requireCoordinator64DMado(pointerInputModifierNode, NodeKind.m1386constructorimpl(16));
    }
}
