package io.ktor.http.parsing;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ParserDsl.kt */
/* loaded from: classes.dex */
public abstract class ParserDslKt {
    public static final Grammar then(String str, Grammar grammar) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        return then(new StringGrammar(str), grammar);
    }

    public static final Grammar then(Grammar grammar, Grammar grammar2) {
        List listOf;
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        Intrinsics.checkNotNullParameter(grammar2, "grammar");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Grammar[]{grammar, grammar2});
        return new SequenceGrammar(listOf);
    }

    public static final Grammar then(Grammar grammar, String value) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        return then(grammar, new StringGrammar(value));
    }

    public static final Grammar or(Grammar grammar, Grammar grammar2) {
        List listOf;
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        Intrinsics.checkNotNullParameter(grammar2, "grammar");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Grammar[]{grammar, grammar2});
        return new OrGrammar(listOf);
    }

    public static final Grammar or(Grammar grammar, String value) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        return or(grammar, new StringGrammar(value));
    }

    public static final Grammar atLeastOne(Grammar grammar) {
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        return new AtLeastOne(grammar);
    }

    public static final Grammar to(char c, char c2) {
        return new RangeGrammar(c, c2);
    }
}
