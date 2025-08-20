package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextFieldValue.kt */
/* loaded from: classes.dex */
public abstract class TextFieldValueKt {
    public static final AnnotatedString getTextBeforeSelection(TextFieldValue textFieldValue, int i) {
        Intrinsics.checkNotNullParameter(textFieldValue, "<this>");
        return textFieldValue.getAnnotatedString().subSequence(Math.max(0, TextRange.m1583getMinimpl(textFieldValue.m1718getSelectiond9O1mEE()) - i), TextRange.m1583getMinimpl(textFieldValue.m1718getSelectiond9O1mEE()));
    }

    public static final AnnotatedString getTextAfterSelection(TextFieldValue textFieldValue, int i) {
        Intrinsics.checkNotNullParameter(textFieldValue, "<this>");
        return textFieldValue.getAnnotatedString().subSequence(TextRange.m1582getMaximpl(textFieldValue.m1718getSelectiond9O1mEE()), Math.min(TextRange.m1582getMaximpl(textFieldValue.m1718getSelectiond9O1mEE()) + i, textFieldValue.getText().length()));
    }

    public static final AnnotatedString getSelectedText(TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(textFieldValue, "<this>");
        return textFieldValue.getAnnotatedString().m1511subSequence5zctL8(textFieldValue.m1718getSelectiond9O1mEE());
    }
}
