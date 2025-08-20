package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.semantics.Role;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Clickable.kt */
/* loaded from: classes.dex */
final class ClickableNode extends AbstractClickableNode {
    private final ClickablePointerInputNode clickablePointerInputNode;
    private final ClickableSemanticsNode clickableSemanticsNode;

    public /* synthetic */ ClickableNode(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, z, str, role, function0);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public ClickablePointerInputNode getClickablePointerInputNode() {
        return this.clickablePointerInputNode;
    }

    public ClickableSemanticsNode getClickableSemanticsNode() {
        return this.clickableSemanticsNode;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private ClickableNode(MutableInteractionSource interactionSource, boolean z, String str, Role role, Function0 onClick) {
        super(interactionSource, z, str, role, onClick, null);
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.clickableSemanticsNode = (ClickableSemanticsNode) delegate(new ClickableSemanticsNode(z, str, role, onClick, null, null, null));
        this.clickablePointerInputNode = (ClickablePointerInputNode) delegate(new ClickablePointerInputNode(z, interactionSource, onClick, getInteractionData()));
    }

    /* renamed from: update-XHw0xAI  reason: not valid java name */
    public final void m97updateXHw0xAI(MutableInteractionSource interactionSource, boolean z, String str, Role role, Function0 onClick) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        m62updateCommonXHw0xAI(interactionSource, z, str, role, onClick);
        getClickableSemanticsNode().m100updateUMe6uN4(z, str, role, onClick, null, null);
        getClickablePointerInputNode().update(z, interactionSource, onClick);
    }
}
