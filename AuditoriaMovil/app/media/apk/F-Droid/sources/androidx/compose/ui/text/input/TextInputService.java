package androidx.compose.ui.text.input;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextInputService.kt */
/* loaded from: classes.dex */
public class TextInputService {
    private final AtomicReference _currentInputSession;
    private final PlatformTextInputService platformTextInputService;

    public TextInputService(PlatformTextInputService platformTextInputService) {
        Intrinsics.checkNotNullParameter(platformTextInputService, "platformTextInputService");
        this.platformTextInputService = platformTextInputService;
        this._currentInputSession = new AtomicReference(null);
    }

    public final TextInputSession getCurrentInputSession$ui_text_release() {
        return (TextInputSession) this._currentInputSession.get();
    }

    public TextInputSession startInput(TextFieldValue value, ImeOptions imeOptions, Function1 onEditCommand, Function1 onImeActionPerformed) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
        Intrinsics.checkNotNullParameter(onEditCommand, "onEditCommand");
        Intrinsics.checkNotNullParameter(onImeActionPerformed, "onImeActionPerformed");
        this.platformTextInputService.startInput(value, imeOptions, onEditCommand, onImeActionPerformed);
        TextInputSession textInputSession = new TextInputSession(this, this.platformTextInputService);
        this._currentInputSession.set(textInputSession);
        return textInputSession;
    }

    public void stopInput(TextInputSession session) {
        Intrinsics.checkNotNullParameter(session, "session");
        if (MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this._currentInputSession, session, null)) {
            this.platformTextInputService.stopInput();
        }
    }
}
