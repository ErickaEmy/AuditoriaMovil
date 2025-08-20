package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EditingBuffer.kt */
/* loaded from: classes.dex */
public final class EditingBuffer {
    private int compositionEnd;
    private int compositionStart;
    private final PartialGapBuffer gapBuffer;
    private int selectionEnd;
    private int selectionStart;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: EditingBuffer.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ EditingBuffer(AnnotatedString annotatedString, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j);
    }

    public final void commitComposition$ui_text_release() {
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final int getCompositionEnd$ui_text_release() {
        return this.compositionEnd;
    }

    public final int getCompositionStart$ui_text_release() {
        return this.compositionStart;
    }

    public final int getCursor$ui_text_release() {
        int i = this.selectionStart;
        int i2 = this.selectionEnd;
        if (i == i2) {
            return i2;
        }
        return -1;
    }

    public final int getSelectionEnd$ui_text_release() {
        return this.selectionEnd;
    }

    public final int getSelectionStart$ui_text_release() {
        return this.selectionStart;
    }

    public final boolean hasComposition$ui_text_release() {
        return this.compositionStart != -1;
    }

    private EditingBuffer(AnnotatedString text, long j) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.gapBuffer = new PartialGapBuffer(text.getText());
        this.selectionStart = TextRange.m1583getMinimpl(j);
        this.selectionEnd = TextRange.m1582getMaximpl(j);
        this.compositionStart = -1;
        this.compositionEnd = -1;
        int m1583getMinimpl = TextRange.m1583getMinimpl(j);
        int m1582getMaximpl = TextRange.m1582getMaximpl(j);
        if (m1583getMinimpl < 0 || m1583getMinimpl > text.length()) {
            throw new IndexOutOfBoundsException("start (" + m1583getMinimpl + ") offset is outside of text region " + text.length());
        } else if (m1582getMaximpl < 0 || m1582getMaximpl > text.length()) {
            throw new IndexOutOfBoundsException("end (" + m1582getMaximpl + ") offset is outside of text region " + text.length());
        } else if (m1583getMinimpl <= m1582getMaximpl) {
        } else {
            throw new IllegalArgumentException("Do not set reversed range: " + m1583getMinimpl + " > " + m1582getMaximpl);
        }
    }

    private final void setSelectionStart(int i) {
        if (i >= 0) {
            this.selectionStart = i;
            return;
        }
        throw new IllegalArgumentException(("Cannot set selectionStart to a negative value: " + i).toString());
    }

    private final void setSelectionEnd(int i) {
        if (i >= 0) {
            this.selectionEnd = i;
            return;
        }
        throw new IllegalArgumentException(("Cannot set selectionEnd to a negative value: " + i).toString());
    }

    /* renamed from: getComposition-MzsxiRA$ui_text_release  reason: not valid java name */
    public final TextRange m1672getCompositionMzsxiRA$ui_text_release() {
        if (hasComposition$ui_text_release()) {
            return TextRange.m1573boximpl(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd));
        }
        return null;
    }

    /* renamed from: getSelection-d9O1mEE$ui_text_release  reason: not valid java name */
    public final long m1673getSelectiond9O1mEE$ui_text_release() {
        return TextRangeKt.TextRange(this.selectionStart, this.selectionEnd);
    }

    public final void setCursor$ui_text_release(int i) {
        setSelection$ui_text_release(i, i);
    }

    public final char get$ui_text_release(int i) {
        return this.gapBuffer.get(i);
    }

    public final int getLength$ui_text_release() {
        return this.gapBuffer.getLength();
    }

    public final void replace$ui_text_release(int i, int i2, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (i < 0 || i > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + i + ") offset is outside of text region " + this.gapBuffer.getLength());
        } else if (i2 < 0 || i2 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + i2 + ") offset is outside of text region " + this.gapBuffer.getLength());
        } else if (i > i2) {
            throw new IllegalArgumentException("Do not set reversed range: " + i + " > " + i2);
        } else {
            this.gapBuffer.replace(i, i2, text);
            setSelectionStart(text.length() + i);
            setSelectionEnd(i + text.length());
            this.compositionStart = -1;
            this.compositionEnd = -1;
        }
    }

    public final void delete$ui_text_release(int i, int i2) {
        long TextRange = TextRangeKt.TextRange(i, i2);
        this.gapBuffer.replace(i, i2, "");
        long m1674updateRangeAfterDeletepWDy79M = EditingBufferKt.m1674updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.selectionStart, this.selectionEnd), TextRange);
        setSelectionStart(TextRange.m1583getMinimpl(m1674updateRangeAfterDeletepWDy79M));
        setSelectionEnd(TextRange.m1582getMaximpl(m1674updateRangeAfterDeletepWDy79M));
        if (hasComposition$ui_text_release()) {
            long m1674updateRangeAfterDeletepWDy79M2 = EditingBufferKt.m1674updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd), TextRange);
            if (TextRange.m1579getCollapsedimpl(m1674updateRangeAfterDeletepWDy79M2)) {
                commitComposition$ui_text_release();
                return;
            }
            this.compositionStart = TextRange.m1583getMinimpl(m1674updateRangeAfterDeletepWDy79M2);
            this.compositionEnd = TextRange.m1582getMaximpl(m1674updateRangeAfterDeletepWDy79M2);
        }
    }

    public final void setSelection$ui_text_release(int i, int i2) {
        if (i < 0 || i > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + i + ") offset is outside of text region " + this.gapBuffer.getLength());
        } else if (i2 < 0 || i2 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + i2 + ") offset is outside of text region " + this.gapBuffer.getLength());
        } else if (i > i2) {
            throw new IllegalArgumentException("Do not set reversed range: " + i + " > " + i2);
        } else {
            setSelectionStart(i);
            setSelectionEnd(i2);
        }
    }

    public final void setComposition$ui_text_release(int i, int i2) {
        if (i < 0 || i > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + i + ") offset is outside of text region " + this.gapBuffer.getLength());
        } else if (i2 < 0 || i2 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + i2 + ") offset is outside of text region " + this.gapBuffer.getLength());
        } else if (i < i2) {
            this.compositionStart = i;
            this.compositionEnd = i2;
        } else {
            throw new IllegalArgumentException("Do not set reversed or empty range: " + i + " > " + i2);
        }
    }

    public String toString() {
        return this.gapBuffer.toString();
    }

    public final AnnotatedString toAnnotatedString$ui_text_release() {
        return new AnnotatedString(toString(), null, null, 6, null);
    }
}
