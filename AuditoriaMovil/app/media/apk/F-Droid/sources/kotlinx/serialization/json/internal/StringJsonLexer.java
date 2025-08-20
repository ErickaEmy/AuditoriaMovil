package kotlinx.serialization.json.internal;

import ch.qos.logback.core.CoreConstants;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: StringJsonLexer.kt */
/* loaded from: classes2.dex */
public final class StringJsonLexer extends AbstractJsonLexer {
    private final String source;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String getSource() {
        return this.source;
    }

    public StringJsonLexer(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int prefetchOrEof(int i) {
        if (i < getSource().length()) {
            return i;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte consumeNextToken() {
        byte charToTokenClass;
        String source = getSource();
        do {
            int i = this.currentPosition;
            if (i == -1 || i >= source.length()) {
                return (byte) 10;
            }
            int i2 = this.currentPosition;
            this.currentPosition = i2 + 1;
            charToTokenClass = AbstractJsonLexerKt.charToTokenClass(source.charAt(i2));
        } while (charToTokenClass == 3);
        return charToTokenClass;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean tryConsumeComma() {
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces == getSource().length() || skipWhitespaces == -1 || getSource().charAt(skipWhitespaces) != ',') {
            return false;
        }
        this.currentPosition++;
        return true;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean canConsumeValue() {
        int i = this.currentPosition;
        if (i == -1) {
            return false;
        }
        while (i < getSource().length()) {
            char charAt = getSource().charAt(i);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.currentPosition = i;
                return isValidValueStart(charAt);
            }
            i++;
        }
        this.currentPosition = i;
        return false;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int skipWhitespaces() {
        char charAt;
        int i = this.currentPosition;
        if (i == -1) {
            return i;
        }
        while (i < getSource().length() && ((charAt = getSource().charAt(i)) == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t')) {
            i++;
        }
        this.currentPosition = i;
        return i;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void consumeNextToken(char c) {
        if (this.currentPosition == -1) {
            unexpectedToken(c);
        }
        String source = getSource();
        while (this.currentPosition < source.length()) {
            int i = this.currentPosition;
            this.currentPosition = i + 1;
            char charAt = source.charAt(i);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                if (charAt == c) {
                    return;
                }
                unexpectedToken(c);
            }
        }
        unexpectedToken(c);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String consumeKeyString() {
        int indexOf$default;
        consumeNextToken(CoreConstants.DOUBLE_QUOTE_CHAR);
        int i = this.currentPosition;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) getSource(), (char) CoreConstants.DOUBLE_QUOTE_CHAR, i, false, 4, (Object) null);
        if (indexOf$default == -1) {
            fail$kotlinx_serialization_json((byte) 1);
            throw new KotlinNothingValueException();
        }
        for (int i2 = i; i2 < indexOf$default; i2++) {
            if (getSource().charAt(i2) == '\\') {
                return consumeString(getSource(), this.currentPosition, i2);
            }
        }
        this.currentPosition = indexOf$default + 1;
        String substring = getSource().substring(i, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String consumeLeadingMatchingValue(String keyToMatch, boolean z) {
        Intrinsics.checkNotNullParameter(keyToMatch, "keyToMatch");
        int i = this.currentPosition;
        try {
            if (consumeNextToken() != 6) {
                this.currentPosition = i;
                return null;
            }
            if (!Intrinsics.areEqual(z ? consumeKeyString() : consumeStringLenientNotNull(), keyToMatch)) {
                this.currentPosition = i;
                return null;
            } else if (consumeNextToken() != 5) {
                this.currentPosition = i;
                return null;
            } else {
                String consumeString = z ? consumeString() : consumeStringLenientNotNull();
                this.currentPosition = i;
                return consumeString;
            }
        } catch (Throwable th) {
            this.currentPosition = i;
            throw th;
        }
    }
}
