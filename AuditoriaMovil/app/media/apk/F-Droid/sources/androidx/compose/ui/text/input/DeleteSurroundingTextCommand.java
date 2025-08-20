package androidx.compose.ui.text.input;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EditCommand.kt */
/* loaded from: classes.dex */
public final class DeleteSurroundingTextCommand implements EditCommand {
    private final int lengthAfterCursor;
    private final int lengthBeforeCursor;

    public int hashCode() {
        return (this.lengthBeforeCursor * 31) + this.lengthAfterCursor;
    }

    public DeleteSurroundingTextCommand(int i, int i2) {
        this.lengthBeforeCursor = i;
        this.lengthAfterCursor = i2;
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException(("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i + " and " + i2 + " respectively.").toString());
        }
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(EditingBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int selectionEnd$ui_text_release = buffer.getSelectionEnd$ui_text_release();
        int i = this.lengthAfterCursor;
        int i2 = selectionEnd$ui_text_release + i;
        if (((selectionEnd$ui_text_release ^ i2) & (i ^ i2)) < 0) {
            i2 = buffer.getLength$ui_text_release();
        }
        buffer.delete$ui_text_release(buffer.getSelectionEnd$ui_text_release(), Math.min(i2, buffer.getLength$ui_text_release()));
        buffer.delete$ui_text_release(Math.max(0, MathUtilsKt.subtractExactOrElse(buffer.getSelectionStart$ui_text_release(), this.lengthBeforeCursor, new Function0() { // from class: androidx.compose.ui.text.input.DeleteSurroundingTextCommand$applyTo$start$1
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return 0;
            }
        })), buffer.getSelectionStart$ui_text_release());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeleteSurroundingTextCommand) {
            DeleteSurroundingTextCommand deleteSurroundingTextCommand = (DeleteSurroundingTextCommand) obj;
            return this.lengthBeforeCursor == deleteSurroundingTextCommand.lengthBeforeCursor && this.lengthAfterCursor == deleteSurroundingTextCommand.lengthAfterCursor;
        }
        return false;
    }

    public String toString() {
        return "DeleteSurroundingTextCommand(lengthBeforeCursor=" + this.lengthBeforeCursor + ", lengthAfterCursor=" + this.lengthAfterCursor + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
