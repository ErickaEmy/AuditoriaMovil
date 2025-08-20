package androidx.compose.ui.node;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: ParentDataModifierNode.kt */
/* loaded from: classes.dex */
public abstract class ParentDataModifierNodeKt {
    public static final void invalidateParentData(ParentDataModifierNode parentDataModifierNode) {
        Intrinsics.checkNotNullParameter(parentDataModifierNode, "<this>");
        DelegatableNodeKt.requireLayoutNode(parentDataModifierNode).invalidateParentData$ui_release();
    }
}
