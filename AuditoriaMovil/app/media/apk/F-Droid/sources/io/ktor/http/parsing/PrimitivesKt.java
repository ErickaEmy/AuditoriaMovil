package io.ktor.http.parsing;
/* compiled from: Primitives.kt */
/* loaded from: classes.dex */
public abstract class PrimitivesKt {
    public static final RawGrammar getDigit() {
        return new RawGrammar("\\d");
    }

    public static final Grammar getHex() {
        return ParserDslKt.or(ParserDslKt.or(getDigit(), ParserDslKt.to('A', 'F')), ParserDslKt.to('a', 'f'));
    }

    public static final Grammar getDigits() {
        return ParserDslKt.atLeastOne(getDigit());
    }
}
