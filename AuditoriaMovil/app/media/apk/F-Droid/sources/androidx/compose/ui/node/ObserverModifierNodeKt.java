package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ObserverModifierNode.kt */
/* loaded from: classes.dex */
public abstract class ObserverModifierNodeKt {
    public static final void observeReads(Modifier.Node node, Function0 block) {
        Intrinsics.checkNotNullParameter(node, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ObserverNodeOwnerScope ownerScope$ui_release = node.getOwnerScope$ui_release();
        if (ownerScope$ui_release == null) {
            ownerScope$ui_release = new ObserverNodeOwnerScope((ObserverModifierNode) node);
            node.setOwnerScope$ui_release(ownerScope$ui_release);
        }
        DelegatableNodeKt.requireOwner(node).getSnapshotObserver().observeReads$ui_release(ownerScope$ui_release, ObserverNodeOwnerScope.Companion.getOnObserveReadsChanged$ui_release(), block);
    }
}
