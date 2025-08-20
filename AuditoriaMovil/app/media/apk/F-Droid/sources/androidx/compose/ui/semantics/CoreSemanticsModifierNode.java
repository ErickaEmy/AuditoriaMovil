package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SemanticsModifier.kt */
/* loaded from: classes.dex */
public final class CoreSemanticsModifierNode extends Modifier.Node implements SemanticsModifierNode {
    private boolean isClearingSemantics;
    private boolean mergeDescendants;
    private Function1 properties;

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public boolean getShouldClearDescendantSemantics() {
        return this.isClearingSemantics;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public boolean getShouldMergeDescendantSemantics() {
        return this.mergeDescendants;
    }

    public final void setMergeDescendants(boolean z) {
        this.mergeDescendants = z;
    }

    public final void setProperties(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.properties = function1;
    }

    public CoreSemanticsModifierNode(boolean z, boolean z2, Function1 properties) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.mergeDescendants = z;
        this.isClearingSemantics = z2;
        this.properties = properties;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        this.properties.invoke(semanticsPropertyReceiver);
    }
}
