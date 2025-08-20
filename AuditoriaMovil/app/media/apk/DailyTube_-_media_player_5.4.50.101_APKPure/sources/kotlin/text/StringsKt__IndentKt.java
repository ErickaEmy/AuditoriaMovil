package kotlin.text;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class StringsKt__IndentKt extends StringsKt__AppendableKt {
    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(final String str) {
        if (str.length() == 0) {
            return new Function1<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(String line) {
                    Intrinsics.checkNotNullParameter(line, "line");
                    return line;
                }
            };
        }
        return new Function1<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String line) {
                Intrinsics.checkNotNullParameter(line, "line");
                return str + line;
            }
        };
    }

    private static final int indentWidth$StringsKt__IndentKt(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i < length) {
                if (!CharsKt__CharJVMKt.isWhitespace(str.charAt(i))) {
                    break;
                }
                i++;
            } else {
                i = -1;
                break;
            }
        }
        if (i == -1) {
            return str.length();
        }
        return i;
    }

    public static final String replaceIndent(String str, String newIndent) {
        int i;
        String invoke;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        List<String> lines = StringsKt.lines(str);
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : lines) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (String str2 : arrayList) {
            arrayList2.add(Integer.valueOf(indentWidth$StringsKt__IndentKt(str2)));
        }
        Integer num = (Integer) CollectionsKt.minOrNull(arrayList2);
        int i5 = 0;
        if (num != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        int length = str.length() + (newIndent.length() * lines.size());
        Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(newIndent);
        int lastIndex = CollectionsKt.getLastIndex(lines);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : lines) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str3 = (String) obj2;
            if ((i5 == 0 || i5 == lastIndex) && StringsKt.isBlank(str3)) {
                str3 = null;
            } else {
                String drop = StringsKt___StringsKt.drop(str3, i);
                if (drop != null && (invoke = indentFunction$StringsKt__IndentKt.invoke(drop)) != null) {
                    str3 = invoke;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i5 = i6;
        }
        String sb = ((StringBuilder) CollectionsKt.joinTo$default(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static final String replaceIndentByMargin(String str, String newIndent, String marginPrefix) {
        int i;
        String invoke;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        if (!StringsKt.isBlank(marginPrefix)) {
            List<String> lines = StringsKt.lines(str);
            int length = str.length() + (newIndent.length() * lines.size());
            Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(newIndent);
            int lastIndex = CollectionsKt.getLastIndex(lines);
            ArrayList arrayList = new ArrayList();
            int i5 = 0;
            for (Object obj : lines) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str2 = (String) obj;
                String str3 = null;
                if ((i5 == 0 || i5 == lastIndex) && StringsKt.isBlank(str2)) {
                    str2 = null;
                } else {
                    int length2 = str2.length();
                    int i8 = 0;
                    while (true) {
                        if (i8 < length2) {
                            if (!CharsKt__CharJVMKt.isWhitespace(str2.charAt(i8))) {
                                i = i8;
                                break;
                            }
                            i8++;
                        } else {
                            i = -1;
                            break;
                        }
                    }
                    if (i != -1) {
                        int i10 = i;
                        if (StringsKt.startsWith$default(str2, marginPrefix, i, false, 4, null)) {
                            Intrinsics.checkNotNull(str2, "null cannot be cast to non-null type java.lang.String");
                            str3 = str2.substring(i10 + marginPrefix.length());
                            Intrinsics.checkNotNullExpressionValue(str3, "substring(...)");
                        }
                    }
                    if (str3 != null && (invoke = indentFunction$StringsKt__IndentKt.invoke(str3)) != null) {
                        str2 = invoke;
                    }
                }
                if (str2 != null) {
                    arrayList.add(str2);
                }
                i5 = i6;
            }
            String sb = ((StringBuilder) CollectionsKt.joinTo$default(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
            Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
            return sb;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.");
    }

    public static String trimIndent(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return replaceIndent(str, "");
    }

    public static final String trimMargin(String str, String marginPrefix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        return replaceIndentByMargin(str, "", marginPrefix);
    }

    public static /* synthetic */ String trimMargin$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return trimMargin(str, str2);
    }
}
