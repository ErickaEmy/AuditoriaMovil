package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/gestures/MouseWheelScrollElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/MouseWheelScrollNode;", "create", "node", "", "update", "", "hashCode", "", "other", "", "equals", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "scrollingLogicState", "Landroidx/compose/runtime/State;", "getScrollingLogicState", "()Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/gestures/ScrollConfig;", "mouseWheelScrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "getMouseWheelScrollConfig", "()Landroidx/compose/foundation/gestures/ScrollConfig;", "<init>", "(Landroidx/compose/runtime/State;Landroidx/compose/foundation/gestures/ScrollConfig;)V", "foundation_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class MouseWheelScrollElement extends ModifierNodeElement {
    private final ScrollConfig mouseWheelScrollConfig;
    private final State scrollingLogicState;

    public MouseWheelScrollElement(State scrollingLogicState, ScrollConfig mouseWheelScrollConfig) {
        Intrinsics.checkNotNullParameter(scrollingLogicState, "scrollingLogicState");
        Intrinsics.checkNotNullParameter(mouseWheelScrollConfig, "mouseWheelScrollConfig");
        this.scrollingLogicState = scrollingLogicState;
        this.mouseWheelScrollConfig = mouseWheelScrollConfig;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public MouseWheelScrollNode create() {
        return new MouseWheelScrollNode(this.scrollingLogicState, this.mouseWheelScrollConfig);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(MouseWheelScrollNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setScrollingLogicState(this.scrollingLogicState);
        node.setMouseWheelScrollConfig(this.mouseWheelScrollConfig);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (this.scrollingLogicState.hashCode() * 31) + this.mouseWheelScrollConfig.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MouseWheelScrollElement) {
            MouseWheelScrollElement mouseWheelScrollElement = (MouseWheelScrollElement) obj;
            return Intrinsics.areEqual(this.scrollingLogicState, mouseWheelScrollElement.scrollingLogicState) && Intrinsics.areEqual(this.mouseWheelScrollConfig, mouseWheelScrollElement.mouseWheelScrollConfig);
        }
        return false;
    }
}
