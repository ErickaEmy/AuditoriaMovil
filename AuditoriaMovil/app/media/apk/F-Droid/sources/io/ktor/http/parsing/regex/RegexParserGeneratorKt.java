package io.ktor.http.parsing.regex;

import ch.qos.logback.core.CoreConstants;
import io.ktor.http.parsing.AtLeastOne;
import io.ktor.http.parsing.ComplexGrammar;
import io.ktor.http.parsing.Grammar;
import io.ktor.http.parsing.OrGrammar;
import io.ktor.http.parsing.Parser;
import io.ktor.http.parsing.RangeGrammar;
import io.ktor.http.parsing.RawGrammar;
import io.ktor.http.parsing.SimpleGrammar;
import io.ktor.http.parsing.StringGrammar;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
/* compiled from: RegexParserGenerator.kt */
/* loaded from: classes.dex */
public abstract class RegexParserGeneratorKt {
    public static final Parser buildRegexParser(Grammar grammar) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        return new RegexParser(new Regex(toRegex$default(grammar, linkedHashMap, 0, false, 6, null).getRegex()), linkedHashMap);
    }

    static /* synthetic */ GrammarRegex toRegex$default(Grammar grammar, Map map, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return toRegex(grammar, map, i, z);
    }

    private static final GrammarRegex toRegex(Grammar grammar, Map map, int i, boolean z) {
        if (grammar instanceof StringGrammar) {
            return new GrammarRegex(Regex.Companion.escape(((StringGrammar) grammar).getValue()), 0, false, 6, null);
        }
        if (grammar instanceof RawGrammar) {
            return new GrammarRegex(((RawGrammar) grammar).getValue(), 0, false, 6, null);
        }
        if (grammar instanceof ComplexGrammar) {
            StringBuilder sb = new StringBuilder();
            int i2 = z ? i + 1 : i;
            int i3 = 0;
            for (Object obj : ((ComplexGrammar) grammar).getGrammars()) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                GrammarRegex regex = toRegex((Grammar) obj, map, i2, true);
                if (i3 != 0 && (grammar instanceof OrGrammar)) {
                    sb.append("|");
                }
                sb.append(regex.getRegex());
                i2 += regex.getGroupsCount();
                i3 = i4;
            }
            int i5 = i2 - i;
            if (z) {
                i5--;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "expression.toString()");
            return new GrammarRegex(sb2, i5, z);
        } else if (grammar instanceof SimpleGrammar) {
            if (!(grammar instanceof AtLeastOne)) {
                throw new IllegalStateException(("Unsupported simple grammar element: " + grammar).toString());
            }
            GrammarRegex regex2 = toRegex(((SimpleGrammar) grammar).getGrammar(), map, i, true);
            return new GrammarRegex(regex2.getRegex() + '+', regex2.getGroupsCount(), false, 4, null);
        } else if (!(grammar instanceof RangeGrammar)) {
            throw new IllegalStateException(("Unsupported grammar element: " + grammar).toString());
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append('[');
            RangeGrammar rangeGrammar = (RangeGrammar) grammar;
            sb3.append(rangeGrammar.getFrom());
            sb3.append(CoreConstants.DASH_CHAR);
            sb3.append(rangeGrammar.getTo());
            sb3.append(']');
            return new GrammarRegex(sb3.toString(), 0, false, 6, null);
        }
    }
}
