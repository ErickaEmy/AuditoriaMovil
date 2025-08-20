package androidx.compose.ui.text.input;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;
/* compiled from: GapBuffer.kt */
/* loaded from: classes.dex */
public final class PartialGapBuffer {
    private int bufEnd;
    private int bufStart;
    private GapBuffer buffer;
    private String text;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: GapBuffer.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PartialGapBuffer(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.bufStart = -1;
        this.bufEnd = -1;
    }

    public final int getLength() {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text.length();
        }
        return (this.text.length() - (this.bufEnd - this.bufStart)) + gapBuffer.length();
    }

    public final void replace(int i, int i2, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (i > i2) {
            throw new IllegalArgumentException(("start index must be less than or equal to end index: " + i + " > " + i2).toString());
        } else if (i < 0) {
            throw new IllegalArgumentException(("start must be non-negative, but was " + i).toString());
        } else {
            GapBuffer gapBuffer = this.buffer;
            if (gapBuffer == null) {
                int max = Math.max((int) GF2Field.MASK, text.length() + 128);
                char[] cArr = new char[max];
                int min = Math.min(i, 64);
                int min2 = Math.min(this.text.length() - i2, 64);
                int i3 = i - min;
                GapBuffer_jvmKt.toCharArray(this.text, cArr, 0, i3, i);
                int i4 = max - min2;
                int i5 = min2 + i2;
                GapBuffer_jvmKt.toCharArray(this.text, cArr, i4, i2, i5);
                GapBufferKt.toCharArray(text, cArr, min);
                this.buffer = new GapBuffer(cArr, min + text.length(), i4);
                this.bufStart = i3;
                this.bufEnd = i5;
                return;
            }
            int i6 = this.bufStart;
            int i7 = i - i6;
            int i8 = i2 - i6;
            if (i7 < 0 || i8 > gapBuffer.length()) {
                this.text = toString();
                this.buffer = null;
                this.bufStart = -1;
                this.bufEnd = -1;
                replace(i, i2, text);
                return;
            }
            gapBuffer.replace(i7, i8, text);
        }
    }

    public final char get(int i) {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text.charAt(i);
        }
        if (i < this.bufStart) {
            return this.text.charAt(i);
        }
        int length = gapBuffer.length();
        int i2 = this.bufStart;
        if (i < length + i2) {
            return gapBuffer.get(i - i2);
        }
        return this.text.charAt(i - ((length - this.bufEnd) + i2));
    }

    public String toString() {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) this.text, 0, this.bufStart);
        gapBuffer.append(sb);
        String str = this.text;
        sb.append((CharSequence) str, this.bufEnd, str.length());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
