package androidx.compose.ui.text.platform;

import androidx.compose.runtime.State;
import androidx.emoji2.text.EmojiCompat;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EmojiCompatStatus.kt */
/* loaded from: classes.dex */
final class DefaultImpl implements EmojiCompatStatusDelegate {
    private State loadState;

    public DefaultImpl() {
        this.loadState = EmojiCompat.isConfigured() ? getFontLoadState() : null;
    }

    @Override // androidx.compose.ui.text.platform.EmojiCompatStatusDelegate
    public State getFontLoaded() {
        ImmutableBool immutableBool;
        State state = this.loadState;
        if (state != null) {
            Intrinsics.checkNotNull(state);
            return state;
        } else if (EmojiCompat.isConfigured()) {
            State fontLoadState = getFontLoadState();
            this.loadState = fontLoadState;
            Intrinsics.checkNotNull(fontLoadState);
            return fontLoadState;
        } else {
            immutableBool = EmojiCompatStatusKt.Falsey;
            return immutableBool;
        }
    }

    private final State getFontLoadState() {
        EmojiCompat.get();
        Intrinsics.checkNotNullExpressionValue(null, "get()");
        throw null;
    }
}
