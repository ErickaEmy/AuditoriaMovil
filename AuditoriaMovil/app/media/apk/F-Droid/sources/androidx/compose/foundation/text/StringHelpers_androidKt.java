package androidx.compose.foundation.text;

import androidx.emoji2.text.EmojiCompat;
import java.text.BreakIterator;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StringHelpers.android.kt */
/* loaded from: classes.dex */
public abstract class StringHelpers_androidKt {
    public static final int findPrecedingBreak(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        getEmojiCompatIfLoaded();
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(str);
        return characterInstance.preceding(i);
    }

    public static final int findFollowingBreak(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        getEmojiCompatIfLoaded();
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(str);
        return characterInstance.following(i);
    }

    private static final EmojiCompat getEmojiCompatIfLoaded() {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get();
            throw null;
        }
        return null;
    }
}
