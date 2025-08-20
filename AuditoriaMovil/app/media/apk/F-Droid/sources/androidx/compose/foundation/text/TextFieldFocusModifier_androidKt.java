package androidx.compose.foundation.text;

import android.view.InputDevice;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.text.input.TextInputSession;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextFieldFocusModifier.android.kt */
/* loaded from: classes.dex */
public abstract class TextFieldFocusModifier_androidKt {
    public static final Modifier interceptDPadAndMoveFocus(Modifier modifier, final TextFieldState state, final FocusManager focusManager) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(focusManager, "focusManager");
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1() { // from class: androidx.compose.foundation.text.TextFieldFocusModifier_androidKt$interceptDPadAndMoveFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m338invokeZmokQxo(((KeyEvent) obj).m1137unboximpl());
            }

            /* renamed from: invoke-ZmokQxo  reason: not valid java name */
            public final Boolean m338invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean m337isKeyCodeYhN2O0w;
                boolean m337isKeyCodeYhN2O0w2;
                boolean m337isKeyCodeYhN2O0w3;
                boolean m337isKeyCodeYhN2O0w4;
                boolean m337isKeyCodeYhN2O0w5;
                Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
                InputDevice device = keyEvent.getDevice();
                boolean z = false;
                if (device != null && device.supportsSource(513) && !device.isVirtual() && KeyEventType.m1139equalsimpl0(KeyEvent_androidKt.m1144getTypeZmokQxo(keyEvent), KeyEventType.Companion.m1140getKeyDownCS__XNY())) {
                    m337isKeyCodeYhN2O0w = TextFieldFocusModifier_androidKt.m337isKeyCodeYhN2O0w(keyEvent, 19);
                    if (m337isKeyCodeYhN2O0w) {
                        z = FocusManager.this.mo663moveFocus3ESFkO8(FocusDirection.Companion.m661getUpdhqQ8s());
                    } else {
                        m337isKeyCodeYhN2O0w2 = TextFieldFocusModifier_androidKt.m337isKeyCodeYhN2O0w(keyEvent, 20);
                        if (m337isKeyCodeYhN2O0w2) {
                            z = FocusManager.this.mo663moveFocus3ESFkO8(FocusDirection.Companion.m654getDowndhqQ8s());
                        } else {
                            m337isKeyCodeYhN2O0w3 = TextFieldFocusModifier_androidKt.m337isKeyCodeYhN2O0w(keyEvent, 21);
                            if (m337isKeyCodeYhN2O0w3) {
                                z = FocusManager.this.mo663moveFocus3ESFkO8(FocusDirection.Companion.m657getLeftdhqQ8s());
                            } else {
                                m337isKeyCodeYhN2O0w4 = TextFieldFocusModifier_androidKt.m337isKeyCodeYhN2O0w(keyEvent, 22);
                                if (m337isKeyCodeYhN2O0w4) {
                                    z = FocusManager.this.mo663moveFocus3ESFkO8(FocusDirection.Companion.m660getRightdhqQ8s());
                                } else {
                                    m337isKeyCodeYhN2O0w5 = TextFieldFocusModifier_androidKt.m337isKeyCodeYhN2O0w(keyEvent, 23);
                                    if (m337isKeyCodeYhN2O0w5) {
                                        TextInputSession inputSession = state.getInputSession();
                                        if (inputSession != null) {
                                            inputSession.showSoftwareKeyboard();
                                        }
                                        z = true;
                                    }
                                }
                            }
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isKeyCode-YhN2O0w  reason: not valid java name */
    public static final boolean m337isKeyCodeYhN2O0w(android.view.KeyEvent keyEvent, int i) {
        return Key_androidKt.m1149getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m1143getKeyZmokQxo(keyEvent)) == i;
    }
}
