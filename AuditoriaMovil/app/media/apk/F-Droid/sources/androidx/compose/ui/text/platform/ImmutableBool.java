package androidx.compose.ui.text.platform;

import androidx.compose.runtime.State;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EmojiCompatStatus.kt */
/* loaded from: classes.dex */
public final class ImmutableBool implements State {
    private final boolean value;

    public ImmutableBool(boolean z) {
        this.value = z;
    }

    @Override // androidx.compose.runtime.State
    public Boolean getValue() {
        return Boolean.valueOf(this.value);
    }
}
