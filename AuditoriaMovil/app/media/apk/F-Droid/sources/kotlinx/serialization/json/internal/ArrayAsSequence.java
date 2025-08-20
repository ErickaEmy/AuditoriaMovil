package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* compiled from: JsonLexer.kt */
/* loaded from: classes2.dex */
public final class ArrayAsSequence implements CharSequence {
    private final char[] buffer;
    private int length;

    public final char[] getBuffer() {
        return this.buffer;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public ArrayAsSequence(char[] buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
        this.length = buffer.length;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public char get(int i) {
        return this.buffer[i];
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        String concatToString;
        concatToString = StringsKt__StringsJVMKt.concatToString(this.buffer, i, Math.min(i2, length()));
        return concatToString;
    }

    public final String substring(int i, int i2) {
        String concatToString;
        concatToString = StringsKt__StringsJVMKt.concatToString(this.buffer, i, Math.min(i2, length()));
        return concatToString;
    }

    public final void trim(int i) {
        setLength(Math.min(this.buffer.length, i));
    }
}
