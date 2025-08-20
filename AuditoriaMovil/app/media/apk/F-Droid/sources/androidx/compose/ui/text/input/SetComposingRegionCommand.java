package androidx.compose.ui.text.input;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: EditCommand.kt */
/* loaded from: classes.dex */
public final class SetComposingRegionCommand implements EditCommand {
    private final int end;
    private final int start;

    public int hashCode() {
        return (this.start * 31) + this.end;
    }

    public SetComposingRegionCommand(int i, int i2) {
        this.start = i;
        this.end = i2;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(EditingBuffer buffer) {
        int coerceIn;
        int coerceIn2;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (buffer.hasComposition$ui_text_release()) {
            buffer.commitComposition$ui_text_release();
        }
        coerceIn = RangesKt___RangesKt.coerceIn(this.start, 0, buffer.getLength$ui_text_release());
        coerceIn2 = RangesKt___RangesKt.coerceIn(this.end, 0, buffer.getLength$ui_text_release());
        if (coerceIn != coerceIn2) {
            if (coerceIn < coerceIn2) {
                buffer.setComposition$ui_text_release(coerceIn, coerceIn2);
            } else {
                buffer.setComposition$ui_text_release(coerceIn2, coerceIn);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SetComposingRegionCommand) {
            SetComposingRegionCommand setComposingRegionCommand = (SetComposingRegionCommand) obj;
            return this.start == setComposingRegionCommand.start && this.end == setComposingRegionCommand.end;
        }
        return false;
    }

    public String toString() {
        return "SetComposingRegionCommand(start=" + this.start + ", end=" + this.end + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
