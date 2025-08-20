package io.ktor.http;

import ch.qos.logback.core.CoreConstants;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
/* compiled from: HeaderValueWithParameters.kt */
/* loaded from: classes.dex */
public abstract class HeaderValueWithParametersKt {
    private static final Set HeaderFieldValueSeparators;

    static {
        Set of;
        of = SetsKt__SetsKt.setOf((Object[]) new Character[]{Character.valueOf(CoreConstants.LEFT_PARENTHESIS_CHAR), Character.valueOf(CoreConstants.RIGHT_PARENTHESIS_CHAR), '<', '>', '@', Character.valueOf(CoreConstants.COMMA_CHAR), ';', Character.valueOf(CoreConstants.COLON_CHAR), Character.valueOf(CoreConstants.ESCAPE_CHAR), Character.valueOf(CoreConstants.DOUBLE_QUOTE_CHAR), '/', '[', ']', '?', '=', Character.valueOf(CoreConstants.CURLY_LEFT), Character.valueOf(CoreConstants.CURLY_RIGHT), ' ', '\t', '\n', '\r'});
        HeaderFieldValueSeparators = of;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean needQuotes(String str) {
        if (str.length() == 0) {
            return true;
        }
        if (isQuoted(str)) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (HeaderFieldValueSeparators.contains(Character.valueOf(str.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    private static final boolean isQuoted(String str) {
        char first;
        char last;
        int indexOf$default;
        int lastIndex;
        if (str.length() < 2) {
            return false;
        }
        first = StringsKt___StringsKt.first(str);
        if (first == '\"') {
            last = StringsKt___StringsKt.last(str);
            if (last == '\"') {
                int i = 1;
                do {
                    indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, (char) CoreConstants.DOUBLE_QUOTE_CHAR, i, false, 4, (Object) null);
                    lastIndex = StringsKt__StringsKt.getLastIndex(str);
                    if (indexOf$default == lastIndex) {
                        break;
                    }
                    int i2 = 0;
                    for (int i3 = indexOf$default - 1; str.charAt(i3) == '\\'; i3--) {
                        i2++;
                    }
                    if (i2 % 2 == 0) {
                        return false;
                    }
                    i = indexOf$default + 1;
                } while (i < str.length());
                return true;
            }
        }
        return false;
    }

    public static final String quote(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder();
        quoteTo(str, sb);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private static final void quoteTo(String str, StringBuilder sb) {
        sb.append("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\\') {
                sb.append("\\\\");
            } else if (charAt == '\n') {
                sb.append("\\n");
            } else if (charAt == '\r') {
                sb.append("\\r");
            } else if (charAt == '\t') {
                sb.append("\\t");
            } else if (charAt == '\"') {
                sb.append("\\\"");
            } else {
                sb.append(charAt);
            }
        }
        sb.append("\"");
    }
}
