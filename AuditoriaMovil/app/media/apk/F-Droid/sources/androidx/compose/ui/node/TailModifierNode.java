package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
/* compiled from: InnerNodeCoordinator.kt */
/* loaded from: classes.dex */
public final class TailModifierNode extends Modifier.Node {
    private boolean attachHasBeenRun;

    public final boolean getAttachHasBeenRun() {
        return this.attachHasBeenRun;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        this.attachHasBeenRun = true;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.attachHasBeenRun = false;
    }

    public String toString() {
        return "<tail>";
    }

    public TailModifierNode() {
        setAggregateChildKindSet$ui_release(0);
    }
}
