package androidx.compose.ui.text.input;
/* compiled from: EditCommand.kt */
/* loaded from: classes.dex */
public abstract class EditCommandKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isSurrogatePair(char c, char c2) {
        return Character.isHighSurrogate(c) && Character.isLowSurrogate(c2);
    }
}
