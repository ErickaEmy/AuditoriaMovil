package androidx.compose.ui.node;

import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
/* compiled from: PointerInputModifierNode.kt */
/* loaded from: classes.dex */
public interface PointerInputModifierNode extends DelegatableNode {
    boolean interceptOutOfBoundsChildEvents();

    void onCancelPointerInput();

    void onDensityChange();

    /* renamed from: onPointerEvent-H0pRuoY */
    void mo60onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j);

    void onViewConfigurationChange();

    boolean sharePointerInputWithSiblings();

    /* compiled from: PointerInputModifierNode.kt */
    /* renamed from: androidx.compose.ui.node.PointerInputModifierNode$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static boolean $default$interceptOutOfBoundsChildEvents(PointerInputModifierNode pointerInputModifierNode) {
            return false;
        }

        public static boolean $default$sharePointerInputWithSiblings(PointerInputModifierNode pointerInputModifierNode) {
            return false;
        }
    }
}
