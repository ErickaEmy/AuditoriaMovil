package androidx.compose.foundation.text;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextInputSession;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: KeyboardActionRunner.kt */
/* loaded from: classes.dex */
public final class KeyboardActionRunner implements KeyboardActionScope {
    public FocusManager focusManager;
    private TextInputSession inputSession;
    public KeyboardActions keyboardActions;

    public final void setFocusManager(FocusManager focusManager) {
        Intrinsics.checkNotNullParameter(focusManager, "<set-?>");
        this.focusManager = focusManager;
    }

    public final void setInputSession(TextInputSession textInputSession) {
        this.inputSession = textInputSession;
    }

    public final void setKeyboardActions(KeyboardActions keyboardActions) {
        Intrinsics.checkNotNullParameter(keyboardActions, "<set-?>");
        this.keyboardActions = keyboardActions;
    }

    public final KeyboardActions getKeyboardActions() {
        KeyboardActions keyboardActions = this.keyboardActions;
        if (keyboardActions != null) {
            return keyboardActions;
        }
        Intrinsics.throwUninitializedPropertyAccessException("keyboardActions");
        return null;
    }

    public final FocusManager getFocusManager() {
        FocusManager focusManager = this.focusManager;
        if (focusManager != null) {
            return focusManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("focusManager");
        return null;
    }

    /* renamed from: runAction-KlQnJC8  reason: not valid java name */
    public final void m292runActionKlQnJC8(int i) {
        Function1 function1;
        ImeAction.Companion companion = ImeAction.Companion;
        Unit unit = null;
        if (ImeAction.m1678equalsimpl0(i, companion.m1683getDoneeUduSuo())) {
            function1 = getKeyboardActions().getOnDone();
        } else if (ImeAction.m1678equalsimpl0(i, companion.m1684getGoeUduSuo())) {
            function1 = getKeyboardActions().getOnGo();
        } else if (ImeAction.m1678equalsimpl0(i, companion.m1685getNexteUduSuo())) {
            function1 = getKeyboardActions().getOnNext();
        } else if (ImeAction.m1678equalsimpl0(i, companion.m1687getPreviouseUduSuo())) {
            function1 = getKeyboardActions().getOnPrevious();
        } else if (ImeAction.m1678equalsimpl0(i, companion.m1688getSearcheUduSuo())) {
            function1 = getKeyboardActions().getOnSearch();
        } else if (ImeAction.m1678equalsimpl0(i, companion.m1689getSendeUduSuo())) {
            function1 = getKeyboardActions().getOnSend();
        } else if (!ImeAction.m1678equalsimpl0(i, companion.m1682getDefaulteUduSuo()) && !ImeAction.m1678equalsimpl0(i, companion.m1686getNoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        } else {
            function1 = null;
        }
        if (function1 != null) {
            function1.invoke(this);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            m291defaultKeyboardActionKlQnJC8(i);
        }
    }

    /* renamed from: defaultKeyboardAction-KlQnJC8  reason: not valid java name */
    public void m291defaultKeyboardActionKlQnJC8(int i) {
        ImeAction.Companion companion = ImeAction.Companion;
        if (ImeAction.m1678equalsimpl0(i, companion.m1685getNexteUduSuo())) {
            getFocusManager().mo663moveFocus3ESFkO8(FocusDirection.Companion.m658getNextdhqQ8s());
        } else if (ImeAction.m1678equalsimpl0(i, companion.m1687getPreviouseUduSuo())) {
            getFocusManager().mo663moveFocus3ESFkO8(FocusDirection.Companion.m659getPreviousdhqQ8s());
        } else if (ImeAction.m1678equalsimpl0(i, companion.m1683getDoneeUduSuo())) {
            TextInputSession textInputSession = this.inputSession;
            if (textInputSession != null) {
                textInputSession.hideSoftwareKeyboard();
            }
        } else if (ImeAction.m1678equalsimpl0(i, companion.m1684getGoeUduSuo()) || ImeAction.m1678equalsimpl0(i, companion.m1688getSearcheUduSuo()) || ImeAction.m1678equalsimpl0(i, companion.m1689getSendeUduSuo()) || ImeAction.m1678equalsimpl0(i, companion.m1682getDefaulteUduSuo())) {
        } else {
            ImeAction.m1678equalsimpl0(i, companion.m1686getNoneeUduSuo());
        }
    }
}
