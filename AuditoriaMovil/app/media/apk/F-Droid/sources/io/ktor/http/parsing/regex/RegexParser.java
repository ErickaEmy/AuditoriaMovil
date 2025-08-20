package io.ktor.http.parsing.regex;

import io.ktor.http.parsing.Parser;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
/* compiled from: RegexParser.kt */
/* loaded from: classes.dex */
public final class RegexParser implements Parser {
    private final Regex expression;
    private final Map indexes;

    public RegexParser(Regex expression, Map indexes) {
        Intrinsics.checkNotNullParameter(expression, "expression");
        Intrinsics.checkNotNullParameter(indexes, "indexes");
        this.expression = expression;
        this.indexes = indexes;
    }

    @Override // io.ktor.http.parsing.Parser
    public boolean match(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.expression.matches(input);
    }
}
