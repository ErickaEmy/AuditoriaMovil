package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: EditCommand.kt */
/* loaded from: classes.dex */
public final class CommitTextCommand implements EditCommand {
    private final AnnotatedString annotatedString;
    private final int newCursorPosition;

    public final int getNewCursorPosition() {
        return this.newCursorPosition;
    }

    public CommitTextCommand(AnnotatedString annotatedString, int i) {
        Intrinsics.checkNotNullParameter(annotatedString, "annotatedString");
        this.annotatedString = annotatedString;
        this.newCursorPosition = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommitTextCommand(String text, int i) {
        this(new AnnotatedString(text, null, null, 6, null), i);
        Intrinsics.checkNotNullParameter(text, "text");
    }

    public final String getText() {
        return this.annotatedString.getText();
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(EditingBuffer buffer) {
        int coerceIn;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (buffer.hasComposition$ui_text_release()) {
            buffer.replace$ui_text_release(buffer.getCompositionStart$ui_text_release(), buffer.getCompositionEnd$ui_text_release(), getText());
        } else {
            buffer.replace$ui_text_release(buffer.getSelectionStart$ui_text_release(), buffer.getSelectionEnd$ui_text_release(), getText());
        }
        int cursor$ui_text_release = buffer.getCursor$ui_text_release();
        int i = this.newCursorPosition;
        coerceIn = RangesKt___RangesKt.coerceIn(i > 0 ? (cursor$ui_text_release + i) - 1 : (cursor$ui_text_release + i) - getText().length(), 0, buffer.getLength$ui_text_release());
        buffer.setCursor$ui_text_release(coerceIn);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CommitTextCommand) {
            CommitTextCommand commitTextCommand = (CommitTextCommand) obj;
            return Intrinsics.areEqual(getText(), commitTextCommand.getText()) && this.newCursorPosition == commitTextCommand.newCursorPosition;
        }
        return false;
    }

    public int hashCode() {
        return (getText().hashCode() * 31) + this.newCursorPosition;
    }

    public String toString() {
        return "CommitTextCommand(text='" + getText() + "', newCursorPosition=" + this.newCursorPosition + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
