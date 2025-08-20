package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.TextRange;
import ch.qos.logback.core.CoreConstants;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* compiled from: EditProcessor.kt */
/* loaded from: classes.dex */
public final class EditProcessor {
    private TextFieldValue mBufferState = new TextFieldValue(AnnotatedStringKt.emptyAnnotatedString(), TextRange.Companion.m1590getZerod9O1mEE(), (TextRange) null, (DefaultConstructorMarker) null);
    private EditingBuffer mBuffer = new EditingBuffer(this.mBufferState.getAnnotatedString(), this.mBufferState.m1718getSelectiond9O1mEE(), null);

    public final TextFieldValue toTextFieldValue() {
        return this.mBufferState;
    }

    public final TextFieldValue apply(List editCommands) {
        EditCommand editCommand;
        Exception e;
        Intrinsics.checkNotNullParameter(editCommands, "editCommands");
        EditCommand editCommand2 = null;
        try {
            int size = editCommands.size();
            int i = 0;
            while (i < size) {
                editCommand = (EditCommand) editCommands.get(i);
                try {
                    editCommand.applyTo(this.mBuffer);
                    i++;
                    editCommand2 = editCommand;
                } catch (Exception e2) {
                    e = e2;
                    throw new RuntimeException(generateBatchErrorMessage(editCommands, editCommand), e);
                }
            }
            TextFieldValue textFieldValue = new TextFieldValue(this.mBuffer.toAnnotatedString$ui_text_release(), this.mBuffer.m1673getSelectiond9O1mEE$ui_text_release(), this.mBuffer.m1672getCompositionMzsxiRA$ui_text_release(), (DefaultConstructorMarker) null);
            this.mBufferState = textFieldValue;
            return textFieldValue;
        } catch (Exception e3) {
            editCommand = editCommand2;
            e = e3;
        }
    }

    public final void reset(TextFieldValue value, TextInputSession textInputSession) {
        Intrinsics.checkNotNullParameter(value, "value");
        boolean z = true;
        boolean z2 = !Intrinsics.areEqual(value.m1717getCompositionMzsxiRA(), this.mBuffer.m1672getCompositionMzsxiRA$ui_text_release());
        boolean z3 = false;
        if (!Intrinsics.areEqual(this.mBufferState.getAnnotatedString(), value.getAnnotatedString())) {
            this.mBuffer = new EditingBuffer(value.getAnnotatedString(), value.m1718getSelectiond9O1mEE(), null);
        } else if (TextRange.m1578equalsimpl0(this.mBufferState.m1718getSelectiond9O1mEE(), value.m1718getSelectiond9O1mEE())) {
            z = false;
        } else {
            this.mBuffer.setSelection$ui_text_release(TextRange.m1583getMinimpl(value.m1718getSelectiond9O1mEE()), TextRange.m1582getMaximpl(value.m1718getSelectiond9O1mEE()));
            z3 = true;
            z = false;
        }
        if (value.m1717getCompositionMzsxiRA() == null) {
            this.mBuffer.commitComposition$ui_text_release();
        } else if (!TextRange.m1579getCollapsedimpl(value.m1717getCompositionMzsxiRA().m1589unboximpl())) {
            this.mBuffer.setComposition$ui_text_release(TextRange.m1583getMinimpl(value.m1717getCompositionMzsxiRA().m1589unboximpl()), TextRange.m1582getMaximpl(value.m1717getCompositionMzsxiRA().m1589unboximpl()));
        }
        if (z || (!z3 && z2)) {
            this.mBuffer.commitComposition$ui_text_release();
            value = TextFieldValue.m1715copy3r_uNRQ$default(value, null, 0L, null, 3, null);
        }
        TextFieldValue textFieldValue = this.mBufferState;
        this.mBufferState = value;
        if (textInputSession != null) {
            textInputSession.updateState(textFieldValue, value);
        }
    }

    private final String generateBatchErrorMessage(List list, final EditCommand editCommand) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error while applying EditCommand batch to buffer (length=" + this.mBuffer.getLength$ui_text_release() + ", composition=" + this.mBuffer.m1672getCompositionMzsxiRA$ui_text_release() + ", selection=" + ((Object) TextRange.m1588toStringimpl(this.mBuffer.m1673getSelectiond9O1mEE$ui_text_release())) + "):");
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        CollectionsKt___CollectionsKt.joinTo$default(list, sb, "\n", null, null, 0, null, new Function1() { // from class: androidx.compose.ui.text.input.EditProcessor$generateBatchErrorMessage$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(EditCommand it) {
                String stringForLog;
                Intrinsics.checkNotNullParameter(it, "it");
                String str = EditCommand.this == it ? " > " : "   ";
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                stringForLog = this.toStringForLog(it);
                sb2.append(stringForLog);
                return sb2.toString();
            }
        }, 60, null);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toStringForLog(EditCommand editCommand) {
        if (editCommand instanceof CommitTextCommand) {
            StringBuilder sb = new StringBuilder();
            sb.append("CommitTextCommand(text.length=");
            CommitTextCommand commitTextCommand = (CommitTextCommand) editCommand;
            sb.append(commitTextCommand.getText().length());
            sb.append(", newCursorPosition=");
            sb.append(commitTextCommand.getNewCursorPosition());
            sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
            return sb.toString();
        } else if (editCommand instanceof SetComposingTextCommand) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SetComposingTextCommand(text.length=");
            SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) editCommand;
            sb2.append(setComposingTextCommand.getText().length());
            sb2.append(", newCursorPosition=");
            sb2.append(setComposingTextCommand.getNewCursorPosition());
            sb2.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
            return sb2.toString();
        } else {
            if (!(editCommand instanceof SetComposingRegionCommand) && !(editCommand instanceof DeleteSurroundingTextCommand) && !(editCommand instanceof DeleteSurroundingTextInCodePointsCommand) && !(editCommand instanceof SetSelectionCommand) && !(editCommand instanceof FinishComposingTextCommand) && !(editCommand instanceof DeleteAllCommand)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unknown EditCommand: ");
                String simpleName = Reflection.getOrCreateKotlinClass(editCommand.getClass()).getSimpleName();
                if (simpleName == null) {
                    simpleName = "{anonymous EditCommand}";
                }
                sb3.append(simpleName);
                return sb3.toString();
            }
            return editCommand.toString();
        }
    }
}
