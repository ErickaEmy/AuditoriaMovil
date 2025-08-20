package androidx.compose.ui.node;

import androidx.compose.runtime.CompositionLocal;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CompositionLocalConsumerModifierNode.kt */
/* loaded from: classes.dex */
public abstract class CompositionLocalConsumerModifierNodeKt {
    public static final Object currentValueOf(CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode, CompositionLocal local) {
        Intrinsics.checkNotNullParameter(compositionLocalConsumerModifierNode, "<this>");
        Intrinsics.checkNotNullParameter(local, "local");
        if (!compositionLocalConsumerModifierNode.getNode().isAttached()) {
            throw new IllegalStateException("Cannot read CompositionLocal because the Modifier node is not currently attached.".toString());
        }
        return DelegatableNodeKt.requireLayoutNode(compositionLocalConsumerModifierNode).getCompositionLocalMap().get(local);
    }
}
