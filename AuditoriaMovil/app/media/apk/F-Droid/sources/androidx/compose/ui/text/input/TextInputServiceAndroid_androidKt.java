package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
/* compiled from: TextInputServiceAndroid.android.kt */
/* loaded from: classes.dex */
public abstract class TextInputServiceAndroid_androidKt {
    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get();
            throw null;
        }
    }

    public static final void update(EditorInfo editorInfo, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(editorInfo, "<this>");
        Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        int m1691getImeActioneUduSuo = imeOptions.m1691getImeActioneUduSuo();
        ImeAction.Companion companion = ImeAction.Companion;
        int i = 6;
        if (ImeAction.m1678equalsimpl0(m1691getImeActioneUduSuo, companion.m1682getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m1678equalsimpl0(m1691getImeActioneUduSuo, companion.m1686getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m1678equalsimpl0(m1691getImeActioneUduSuo, companion.m1684getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m1678equalsimpl0(m1691getImeActioneUduSuo, companion.m1685getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m1678equalsimpl0(m1691getImeActioneUduSuo, companion.m1687getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m1678equalsimpl0(m1691getImeActioneUduSuo, companion.m1688getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m1678equalsimpl0(m1691getImeActioneUduSuo, companion.m1689getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m1678equalsimpl0(m1691getImeActioneUduSuo, companion.m1683getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i;
        int m1692getKeyboardTypePjHm6EE = imeOptions.m1692getKeyboardTypePjHm6EE();
        KeyboardType.Companion companion2 = KeyboardType.Companion;
        if (KeyboardType.m1703equalsimpl0(m1692getKeyboardTypePjHm6EE, companion2.m1713getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m1703equalsimpl0(m1692getKeyboardTypePjHm6EE, companion2.m1706getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m1703equalsimpl0(m1692getKeyboardTypePjHm6EE, companion2.m1709getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m1703equalsimpl0(m1692getKeyboardTypePjHm6EE, companion2.m1712getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m1703equalsimpl0(m1692getKeyboardTypePjHm6EE, companion2.m1714getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m1703equalsimpl0(m1692getKeyboardTypePjHm6EE, companion2.m1708getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m1703equalsimpl0(m1692getKeyboardTypePjHm6EE, companion2.m1711getPasswordPjHm6EE())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.m1703equalsimpl0(m1692getKeyboardTypePjHm6EE, companion2.m1710getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else if (KeyboardType.m1703equalsimpl0(m1692getKeyboardTypePjHm6EE, companion2.m1707getDecimalPjHm6EE())) {
            editorInfo.inputType = 8194;
        } else {
            throw new IllegalStateException("Invalid Keyboard Type".toString());
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= PKIFailureInfo.unsupportedVersion;
            if (ImeAction.m1678equalsimpl0(imeOptions.m1691getImeActioneUduSuo(), companion.m1682getDefaulteUduSuo())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int m1690getCapitalizationIUNYP9k = imeOptions.m1690getCapitalizationIUNYP9k();
            KeyboardCapitalization.Companion companion3 = KeyboardCapitalization.Companion;
            if (KeyboardCapitalization.m1695equalsimpl0(m1690getCapitalizationIUNYP9k, companion3.m1698getCharactersIUNYP9k())) {
                editorInfo.inputType |= PKIFailureInfo.certConfirmed;
            } else if (KeyboardCapitalization.m1695equalsimpl0(m1690getCapitalizationIUNYP9k, companion3.m1701getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m1695equalsimpl0(m1690getCapitalizationIUNYP9k, companion3.m1700getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m1585getStartimpl(textFieldValue.m1718getSelectiond9O1mEE());
        editorInfo.initialSelEnd = TextRange.m1580getEndimpl(textFieldValue.m1718getSelectiond9O1mEE());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }

    public static final Executor asExecutor(final Choreographer choreographer) {
        Intrinsics.checkNotNullParameter(choreographer, "<this>");
        return new Executor() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                TextInputServiceAndroid_androidKt.asExecutor$lambda$1(choreographer, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asExecutor$lambda$1(Choreographer this_asExecutor, final Runnable runnable) {
        Intrinsics.checkNotNullParameter(this_asExecutor, "$this_asExecutor");
        this_asExecutor.postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                runnable.run();
            }
        });
    }
}
