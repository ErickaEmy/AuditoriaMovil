package kotlinx.serialization.json.internal;

import ch.qos.logback.core.CoreConstants;
import kotlin.KotlinNothingValueException;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: JsonLexer.kt */
/* loaded from: classes2.dex */
public final class ReaderJsonLexer extends AbstractJsonLexer {
    private final SerialReader reader;
    private final ArrayAsSequence source;
    private int threshold;

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String consumeLeadingMatchingValue(String keyToMatch, boolean z) {
        Intrinsics.checkNotNullParameter(keyToMatch, "keyToMatch");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public ArrayAsSequence getSource() {
        return this.source;
    }

    public /* synthetic */ ReaderJsonLexer(SerialReader serialReader, char[] cArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(serialReader, (i & 2) != 0 ? new char[16384] : cArr);
    }

    public ReaderJsonLexer(SerialReader reader, char[] charsBuffer) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(charsBuffer, "charsBuffer");
        this.reader = reader;
        this.threshold = 128;
        this.source = new ArrayAsSequence(charsBuffer);
        preload(0);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean tryConsumeComma() {
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces >= getSource().length() || skipWhitespaces == -1 || getSource().charAt(skipWhitespaces) != ',') {
            return false;
        }
        this.currentPosition++;
        return true;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean canConsumeValue() {
        ensureHaveChars();
        int i = this.currentPosition;
        while (true) {
            int prefetchOrEof = prefetchOrEof(i);
            if (prefetchOrEof == -1) {
                this.currentPosition = prefetchOrEof;
                return false;
            }
            char charAt = getSource().charAt(prefetchOrEof);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.currentPosition = prefetchOrEof;
                return isValidValueStart(charAt);
            }
            i = prefetchOrEof + 1;
        }
    }

    private final void preload(int i) {
        char[] buffer = getSource().getBuffer();
        if (i != 0) {
            int i2 = this.currentPosition;
            ArraysKt___ArraysJvmKt.copyInto(buffer, buffer, 0, i2, i2 + i);
        }
        int length = getSource().length();
        while (true) {
            if (i == length) {
                break;
            }
            int read = this.reader.read(buffer, i, length - i);
            if (read == -1) {
                getSource().trim(i);
                this.threshold = -1;
                break;
            }
            i += read;
        }
        this.currentPosition = 0;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int prefetchOrEof(int i) {
        if (i < getSource().length()) {
            return i;
        }
        this.currentPosition = i;
        ensureHaveChars();
        return (this.currentPosition != 0 || getSource().length() == 0) ? -1 : 0;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte consumeNextToken() {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int i = this.currentPosition;
        while (true) {
            int prefetchOrEof = prefetchOrEof(i);
            if (prefetchOrEof == -1) {
                this.currentPosition = prefetchOrEof;
                return (byte) 10;
            }
            int i2 = prefetchOrEof + 1;
            byte charToTokenClass = AbstractJsonLexerKt.charToTokenClass(source.charAt(prefetchOrEof));
            if (charToTokenClass != 3) {
                this.currentPosition = i2;
                return charToTokenClass;
            }
            i = i2;
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void ensureHaveChars() {
        int length = getSource().length() - this.currentPosition;
        if (length > this.threshold) {
            return;
        }
        preload(length);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String consumeKeyString() {
        consumeNextToken(CoreConstants.DOUBLE_QUOTE_CHAR);
        int i = this.currentPosition;
        int indexOf = indexOf(CoreConstants.DOUBLE_QUOTE_CHAR, i);
        if (indexOf == -1) {
            int prefetchOrEof = prefetchOrEof(i);
            if (prefetchOrEof == -1) {
                fail$kotlinx_serialization_json((byte) 1);
                throw new KotlinNothingValueException();
            }
            return consumeString(getSource(), this.currentPosition, prefetchOrEof);
        }
        for (int i2 = i; i2 < indexOf; i2++) {
            if (getSource().charAt(i2) == '\\') {
                return consumeString(getSource(), this.currentPosition, i2);
            }
        }
        this.currentPosition = indexOf + 1;
        return substring(i, indexOf);
    }

    public int indexOf(char c, int i) {
        ArrayAsSequence source = getSource();
        int length = source.length();
        while (i < length) {
            if (source.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String substring(int i, int i2) {
        return getSource().substring(i, i2);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    protected void appendRange(int i, int i2) {
        StringBuilder escapedString = getEscapedString();
        escapedString.append(getSource().getBuffer(), i, i2 - i);
        Intrinsics.checkNotNullExpressionValue(escapedString, "this.append(value, start…x, endIndex - startIndex)");
    }
}
