package ch.qos.logback.core.pattern;
/* loaded from: classes.dex */
public final class LiteralConverter extends Converter {
    String literal;

    public LiteralConverter(String str) {
        this.literal = str;
    }

    @Override // ch.qos.logback.core.pattern.Converter
    public String convert(Object obj) {
        return this.literal;
    }
}
