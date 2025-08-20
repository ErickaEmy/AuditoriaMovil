package io.ktor.http.parsing;
/* compiled from: ParserDsl.kt */
/* loaded from: classes.dex */
public final class RangeGrammar extends Grammar {
    private final char from;
    private final char to;

    public final char getFrom() {
        return this.from;
    }

    public final char getTo() {
        return this.to;
    }

    public RangeGrammar(char c, char c2) {
        super(null);
        this.from = c;
        this.to = c2;
    }
}
