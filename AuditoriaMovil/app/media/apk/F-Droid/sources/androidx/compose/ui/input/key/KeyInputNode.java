package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: KeyInputModifier.kt */
/* loaded from: classes.dex */
final class KeyInputNode extends Modifier.Node implements KeyInputModifierNode {
    private Function1 onEvent;
    private Function1 onPreEvent;

    public final void setOnEvent(Function1 function1) {
        this.onEvent = function1;
    }

    public final void setOnPreEvent(Function1 function1) {
        this.onPreEvent = function1;
    }

    public KeyInputNode(Function1 function1, Function1 function12) {
        this.onEvent = function1;
        this.onPreEvent = function12;
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* renamed from: onKeyEvent-ZmokQxo */
    public boolean mo59onKeyEventZmokQxo(android.view.KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Function1 function1 = this.onEvent;
        if (function1 != null) {
            return ((Boolean) function1.invoke(KeyEvent.m1132boximpl(event))).booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* renamed from: onPreKeyEvent-ZmokQxo */
    public boolean mo61onPreKeyEventZmokQxo(android.view.KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Function1 function1 = this.onPreEvent;
        if (function1 != null) {
            return ((Boolean) function1.invoke(KeyEvent.m1132boximpl(event))).booleanValue();
        }
        return false;
    }
}
