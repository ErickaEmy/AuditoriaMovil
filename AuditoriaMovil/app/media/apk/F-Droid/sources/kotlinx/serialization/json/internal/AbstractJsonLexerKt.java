package kotlinx.serialization.json.internal;
/* compiled from: AbstractJsonLexer.kt */
/* loaded from: classes2.dex */
public abstract class AbstractJsonLexerKt {
    public static final byte charToTokenClass(char c) {
        if (c < '~') {
            return CharMappings.CHAR_TO_TOKEN[c];
        }
        return (byte) 0;
    }

    public static final char escapeToChar(int i) {
        if (i < 117) {
            return CharMappings.ESCAPE_2_CHAR[i];
        }
        return (char) 0;
    }
}
