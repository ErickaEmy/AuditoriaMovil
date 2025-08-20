package androidx.compose.ui.text.input;

import android.view.inputmethod.ExtractedText;
import androidx.compose.ui.text.TextRange;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: InputState.android.kt */
/* loaded from: classes.dex */
public abstract class InputState_androidKt {
    public static final ExtractedText toExtractedText(TextFieldValue textFieldValue) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(textFieldValue, "<this>");
        ExtractedText extractedText = new ExtractedText();
        extractedText.text = textFieldValue.getText();
        extractedText.startOffset = 0;
        extractedText.partialEndOffset = textFieldValue.getText().length();
        extractedText.partialStartOffset = -1;
        extractedText.selectionStart = TextRange.m1583getMinimpl(textFieldValue.m1718getSelectiond9O1mEE());
        extractedText.selectionEnd = TextRange.m1582getMaximpl(textFieldValue.m1718getSelectiond9O1mEE());
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) textFieldValue.getText(), '\n', false, 2, (Object) null);
        extractedText.flags = !contains$default ? 1 : 0;
        return extractedText;
    }
}
