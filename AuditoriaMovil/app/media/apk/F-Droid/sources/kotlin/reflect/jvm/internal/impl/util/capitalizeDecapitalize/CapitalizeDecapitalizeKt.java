package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: capitalizeDecapitalize.kt */
/* loaded from: classes2.dex */
public abstract class CapitalizeDecapitalizeKt {
    public static final String decapitalizeSmartForCompiler(String str, boolean z) {
        IntRange indices;
        Object obj;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() != 0 && isUpperCaseCharAt(str, 0, z)) {
            if (str.length() == 1 || !isUpperCaseCharAt(str, 1, z)) {
                if (z) {
                    return decapitalizeAsciiOnly(str);
                }
                if (str.length() > 0) {
                    char lowerCase = Character.toLowerCase(str.charAt(0));
                    String substring = str.substring(1);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    return lowerCase + substring;
                }
                return str;
            }
            indices = StringsKt__StringsKt.getIndices(str);
            Iterator it = indices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (!isUpperCaseCharAt(str, ((Number) obj).intValue(), z)) {
                    break;
                }
            }
            Integer num = (Integer) obj;
            if (num == null) {
                return toLowerCase(str, z);
            }
            int intValue = num.intValue() - 1;
            StringBuilder sb = new StringBuilder();
            String substring2 = str.substring(0, intValue);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            sb.append(toLowerCase(substring2, z));
            String substring3 = str.substring(intValue);
            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
            sb.append(substring3);
            return sb.toString();
        }
        return str;
    }

    private static final boolean isUpperCaseCharAt(String str, int i, boolean z) {
        char charAt = str.charAt(i);
        if (z) {
            return 'A' <= charAt && charAt < '[';
        }
        return Character.isUpperCase(charAt);
    }

    private static final String toLowerCase(String str, boolean z) {
        if (z) {
            return toLowerCaseAsciiOnly(str);
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static final String capitalizeAsciiOnly(String str) {
        char charAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() != 0 && 'a' <= (charAt = str.charAt(0)) && charAt < '{') {
            char upperCase = Character.toUpperCase(charAt);
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return upperCase + substring;
        }
        return str;
    }

    public static final String decapitalizeAsciiOnly(String str) {
        char charAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() != 0 && 'A' <= (charAt = str.charAt(0)) && charAt < '[') {
            char lowerCase = Character.toLowerCase(charAt);
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return lowerCase + substring;
        }
        return str;
    }

    public static final String toLowerCaseAsciiOnly(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ('A' <= charAt && charAt < '[') {
                charAt = Character.toLowerCase(charAt);
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
