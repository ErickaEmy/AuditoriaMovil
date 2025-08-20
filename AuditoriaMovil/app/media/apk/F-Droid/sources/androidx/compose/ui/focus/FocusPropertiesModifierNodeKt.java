package androidx.compose.ui.focus;

import androidx.compose.ui.node.DelegatableNodeKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FocusPropertiesModifierNode.kt */
/* loaded from: classes.dex */
public abstract class FocusPropertiesModifierNodeKt {
    public static final void invalidateFocusProperties(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        Intrinsics.checkNotNullParameter(focusPropertiesModifierNode, "<this>");
        DelegatableNodeKt.requireOwner(focusPropertiesModifierNode).getFocusOwner().scheduleInvalidation(focusPropertiesModifierNode);
    }
}
