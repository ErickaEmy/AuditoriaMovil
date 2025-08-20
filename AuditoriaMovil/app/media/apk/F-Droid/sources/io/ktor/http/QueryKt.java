package io.ktor.http;

import io.ktor.http.Parameters;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: Query.kt */
/* loaded from: classes.dex */
public abstract class QueryKt {
    public static /* synthetic */ Parameters parseQueryString$default(String str, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 1000;
        }
        if ((i3 & 8) != 0) {
            z = true;
        }
        return parseQueryString(str, i, i2, z);
    }

    public static final Parameters parseQueryString(String query, int i, int i2, boolean z) {
        int lastIndex;
        Intrinsics.checkNotNullParameter(query, "query");
        lastIndex = StringsKt__StringsKt.getLastIndex(query);
        if (i > lastIndex) {
            return Parameters.Companion.getEmpty();
        }
        Parameters.Companion companion = Parameters.Companion;
        ParametersBuilder ParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        parse(ParametersBuilder$default, query, i, i2, z);
        return ParametersBuilder$default.build();
    }

    private static final void parse(ParametersBuilder parametersBuilder, String str, int i, int i2, boolean z) {
        int lastIndex;
        int i3;
        int i4;
        lastIndex = StringsKt__StringsKt.getLastIndex(str);
        int i5 = 0;
        if (i <= lastIndex) {
            int i6 = 0;
            int i7 = -1;
            int i8 = i;
            int i9 = i8;
            while (i6 != i2) {
                char charAt = str.charAt(i8);
                if (charAt == '&') {
                    appendParam(parametersBuilder, str, i9, i7, i8, z);
                    i6++;
                    i7 = -1;
                    i9 = i8 + 1;
                } else if (charAt == '=' && i7 == -1) {
                    i7 = i8;
                }
                if (i8 != lastIndex) {
                    i8++;
                } else {
                    i4 = i9;
                    i3 = i7;
                    i5 = i6;
                }
            }
            return;
        }
        i3 = -1;
        i4 = i;
        if (i5 == i2) {
            return;
        }
        appendParam(parametersBuilder, str, i4, i3, str.length(), z);
    }

    private static final void appendParam(ParametersBuilder parametersBuilder, String str, int i, int i2, int i3, boolean z) {
        String substring;
        String substring2;
        String substring3;
        List emptyList;
        if (i2 == -1) {
            int trimStart = trimStart(i, i3, str);
            int trimEnd = trimEnd(trimStart, i3, str);
            if (trimEnd > trimStart) {
                if (z) {
                    substring3 = CodecsKt.decodeURLQueryComponent$default(str, trimStart, trimEnd, false, null, 12, null);
                } else {
                    substring3 = str.substring(trimStart, trimEnd);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                parametersBuilder.appendAll(substring3, emptyList);
                return;
            }
            return;
        }
        int trimStart2 = trimStart(i, i2, str);
        int trimEnd2 = trimEnd(trimStart2, i2, str);
        if (trimEnd2 > trimStart2) {
            if (z) {
                substring = CodecsKt.decodeURLQueryComponent$default(str, trimStart2, trimEnd2, false, null, 12, null);
            } else {
                substring = str.substring(trimStart2, trimEnd2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            int trimStart3 = trimStart(i2 + 1, i3, str);
            int trimEnd3 = trimEnd(trimStart3, i3, str);
            if (z) {
                substring2 = CodecsKt.decodeURLQueryComponent$default(str, trimStart3, trimEnd3, true, null, 8, null);
            } else {
                substring2 = str.substring(trimStart3, trimEnd3);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            parametersBuilder.append(substring, substring2);
        }
    }

    private static final int trimEnd(int i, int i2, CharSequence charSequence) {
        boolean isWhitespace;
        while (i2 > i) {
            isWhitespace = CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(i2 - 1));
            if (!isWhitespace) {
                break;
            }
            i2--;
        }
        return i2;
    }

    private static final int trimStart(int i, int i2, CharSequence charSequence) {
        boolean isWhitespace;
        while (i < i2) {
            isWhitespace = CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(i));
            if (!isWhitespace) {
                break;
            }
            i++;
        }
        return i;
    }
}
