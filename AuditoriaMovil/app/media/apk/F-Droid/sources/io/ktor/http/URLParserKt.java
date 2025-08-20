package io.ktor.http;

import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: URLParser.kt */
/* loaded from: classes.dex */
public abstract class URLParserKt {
    private static final List ROOT_PATH;

    public static final List getROOT_PATH() {
        return ROOT_PATH;
    }

    static {
        List listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("");
        ROOT_PATH = listOf;
    }

    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, String urlString) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        isBlank = StringsKt__StringsJVMKt.isBlank(urlString);
        if (isBlank) {
            return uRLBuilder;
        }
        try {
            return takeFromUnsafe(uRLBuilder, urlString);
        } catch (Throwable th) {
            throw new URLParserException(urlString, th);
        }
    }

    private static final void parseFile(URLBuilder uRLBuilder, String str, int i, int i2, int i3) {
        int indexOf$default;
        if (i3 != 2) {
            if (i3 == 3) {
                uRLBuilder.setHost("");
                StringBuilder sb = new StringBuilder();
                sb.append('/');
                String substring = str.substring(i, i2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb.append(substring);
                URLBuilderKt.setEncodedPath(uRLBuilder, sb.toString());
                return;
            }
            throw new IllegalArgumentException("Invalid file url: " + str);
        }
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '/', i, false, 4, (Object) null);
        if (indexOf$default == -1 || indexOf$default == i2) {
            String substring2 = str.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.setHost(substring2);
            return;
        }
        String substring3 = str.substring(i, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
        uRLBuilder.setHost(substring3);
        String substring4 = str.substring(indexOf$default, i2);
        Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String…ing(startIndex, endIndex)");
        URLBuilderKt.setEncodedPath(uRLBuilder, substring4);
    }

    private static final void parseMailto(URLBuilder uRLBuilder, String str, int i, int i2) {
        int indexOf$default;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, "@", i, false, 4, (Object) null);
        if (indexOf$default == -1) {
            throw new IllegalArgumentException("Invalid mailto url: " + str + ", it should contain '@'.");
        }
        String substring = str.substring(i, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        uRLBuilder.setUser(CodecsKt.decodeURLPart$default(substring, 0, 0, null, 7, null));
        String substring2 = str.substring(indexOf$default + 1, i2);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        uRLBuilder.setHost(substring2);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final io.ktor.http.URLBuilder takeFromUnsafe(io.ktor.http.URLBuilder r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.URLParserKt.takeFromUnsafe(io.ktor.http.URLBuilder, java.lang.String):io.ktor.http.URLBuilder");
    }

    private static final int parseQuery(final URLBuilder uRLBuilder, String str, int i, int i2) {
        int indexOf$default;
        int i3 = i + 1;
        if (i3 == i2) {
            uRLBuilder.setTrailingQuery(true);
            return i2;
        }
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '#', i3, false, 4, (Object) null);
        Integer valueOf = Integer.valueOf(indexOf$default);
        if (valueOf.intValue() <= 0) {
            valueOf = null;
        }
        if (valueOf != null) {
            i2 = valueOf.intValue();
        }
        String substring = str.substring(i3, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        QueryKt.parseQueryString$default(substring, 0, 0, false, 6, null).forEach(new Function2() { // from class: io.ktor.http.URLParserKt$parseQuery$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, (List) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String key, List values) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(values, "values");
                URLBuilder.this.getEncodedParameters().appendAll(key, values);
            }
        });
        return i2;
    }

    private static final void parseFragment(URLBuilder uRLBuilder, String str, int i, int i2) {
        if (i >= i2 || str.charAt(i) != '#') {
            return;
        }
        String substring = str.substring(i + 1, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        uRLBuilder.setEncodedFragment(substring);
    }

    private static final void fillHost(URLBuilder uRLBuilder, String str, int i, int i2) {
        Integer valueOf = Integer.valueOf(indexOfColonInHostPort(str, i, i2));
        if (valueOf.intValue() <= 0) {
            valueOf = null;
        }
        int intValue = valueOf != null ? valueOf.intValue() : i2;
        String substring = str.substring(i, intValue);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        uRLBuilder.setHost(substring);
        int i3 = intValue + 1;
        if (i3 < i2) {
            String substring2 = str.substring(i3, i2);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.setPort(Integer.parseInt(substring2));
            return;
        }
        uRLBuilder.setPort(0);
    }

    private static final int findScheme(String str, int i, int i2) {
        int i3;
        int i4;
        char charAt = str.charAt(i);
        if (('a' > charAt || charAt >= '{') && ('A' > charAt || charAt >= '[')) {
            i3 = i;
            i4 = i3;
        } else {
            i3 = i;
            i4 = -1;
        }
        while (i3 < i2) {
            char charAt2 = str.charAt(i3);
            if (charAt2 != ':') {
                if (charAt2 == '/' || charAt2 == '?' || charAt2 == '#') {
                    break;
                }
                if (i4 == -1 && (('a' > charAt2 || charAt2 >= '{') && (('A' > charAt2 || charAt2 >= '[') && (('0' > charAt2 || charAt2 >= ':') && charAt2 != '.' && charAt2 != '+' && charAt2 != '-')))) {
                    i4 = i3;
                }
                i3++;
            } else if (i4 == -1) {
                return i3 - i;
            } else {
                throw new IllegalArgumentException("Illegal character in scheme at position " + i4);
            }
        }
        return -1;
    }

    private static final int count(String str, int i, int i2, char c) {
        int i3 = 0;
        while (true) {
            int i4 = i + i3;
            if (i4 >= i2 || str.charAt(i4) != c) {
                break;
            }
            i3++;
        }
        return i3;
    }

    private static final int indexOfColonInHostPort(String str, int i, int i2) {
        boolean z = false;
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt == '[') {
                z = true;
            } else if (charAt == ']') {
                z = false;
            } else if (charAt == ':' && !z) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
