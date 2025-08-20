package kotlin.text;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
/* loaded from: classes.dex */
public class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    public static String concatToString(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new String(cArr);
    }

    public static String decodeToString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new String(bArr, Charsets.UTF_8);
    }

    public static boolean endsWith(String str, String suffix, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!z2) {
            return str.endsWith(suffix);
        }
        return regionMatches(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean endsWith$default(String str, String str2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return StringsKt.endsWith(str, str2, z2);
    }

    public static boolean equals(String str, String str2, boolean z2) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        } else if (!z2) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static /* synthetic */ boolean equals$default(String str, String str2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return StringsKt.equals(str, str2, z2);
    }

    public static Comparator<String> getCASE_INSENSITIVE_ORDER(StringCompanionObject stringCompanionObject) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        Comparator<String> CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkNotNullExpressionValue(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        return CASE_INSENSITIVE_ORDER;
    }

    public static boolean isBlank(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() != 0) {
            IntRange indices = StringsKt__StringsKt.getIndices(charSequence);
            if (!(indices instanceof Collection) || !((Collection) indices).isEmpty()) {
                Iterator<Integer> it = indices.iterator();
                while (it.hasNext()) {
                    if (!CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(((IntIterator) it).nextInt()))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static final boolean regionMatches(String str, int i, String other, int i5, int i6, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (!z2) {
            return str.regionMatches(i, other, i5, i6);
        }
        return str.regionMatches(z2, i, other, i5, i6);
    }

    public static /* synthetic */ boolean regionMatches$default(String str, int i, String str2, int i5, int i6, boolean z2, int i8, Object obj) {
        boolean z3;
        if ((i8 & 16) != 0) {
            z3 = false;
        } else {
            z3 = z2;
        }
        return regionMatches(str, i, str2, i5, i6, z3);
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static String repeat(CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return "";
            }
            if (i != 1) {
                int length = charSequence.length();
                if (length == 0) {
                    return "";
                }
                if (length != 1) {
                    StringBuilder sb = new StringBuilder(charSequence.length() * i);
                    ?? it = new IntRange(1, i).iterator();
                    while (it.hasNext()) {
                        it.nextInt();
                        sb.append(charSequence);
                    }
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNull(sb2);
                    return sb2;
                }
                char charAt = charSequence.charAt(0);
                char[] cArr = new char[i];
                for (int i5 = 0; i5 < i; i5++) {
                    cArr[i5] = charAt;
                }
                return new String(cArr);
            }
            return charSequence.toString();
        }
        throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
    }

    public static final String replace(String str, char c2, char c4, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!z2) {
            String replace = str.replace(c2, c4);
            Intrinsics.checkNotNullExpressionValue(replace, "replace(...)");
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (CharsKt__CharKt.equals(charAt, c2, z2)) {
                charAt = c4;
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static /* synthetic */ String replace$default(String str, char c2, char c4, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return replace(str, c2, c4, z2);
    }

    public static final String replaceFirst(String str, String oldValue, String newValue, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        int indexOf$default = StringsKt.indexOf$default(str, oldValue, 0, z2, 2, (Object) null);
        if (indexOf$default >= 0) {
            return StringsKt.replaceRange(str, indexOf$default, oldValue.length() + indexOf$default, newValue).toString();
        }
        return str;
    }

    public static /* synthetic */ String replaceFirst$default(String str, String str2, String str3, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return replaceFirst(str, str2, str3, z2);
    }

    public static List<String> split(CharSequence charSequence, Pattern regex, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        StringsKt__StringsKt.requireNonNegativeLimit(i);
        if (i == 0) {
            i = -1;
        }
        String[] split = regex.split(charSequence, i);
        Intrinsics.checkNotNullExpressionValue(split, "split(...)");
        return ArraysKt.asList(split);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, Pattern pattern, int i, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i = 0;
        }
        return StringsKt.split(charSequence, pattern, i);
    }

    public static boolean startsWith(String str, String prefix, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!z2) {
            return str.startsWith(prefix);
        }
        return regionMatches(str, 0, prefix, 0, prefix.length(), z2);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return StringsKt.startsWith(str, str2, z2);
    }

    public static String concatToString(char[] cArr, int i, int i5) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i, i5, cArr.length);
        return new String(cArr, i, i5 - i);
    }

    public static /* synthetic */ String replace$default(String str, String str2, String str3, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return StringsKt.replace(str, str2, str3, z2);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, int i, boolean z2, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z2 = false;
        }
        return StringsKt.startsWith(str, str2, i, z2);
    }

    public static boolean startsWith(String str, String prefix, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!z2) {
            return str.startsWith(prefix, i);
        }
        return regionMatches(str, i, prefix, 0, prefix.length(), z2);
    }

    public static String replace(String str, String oldValue, String newValue, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        int i = 0;
        int indexOf = StringsKt__StringsKt.indexOf(str, oldValue, 0, z2);
        if (indexOf < 0) {
            return str;
        }
        int length = oldValue.length();
        int coerceAtLeast = RangesKt.coerceAtLeast(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str, i, indexOf);
                sb.append(newValue);
                i = indexOf + length;
                if (indexOf >= str.length()) {
                    break;
                }
                indexOf = StringsKt__StringsKt.indexOf(str, oldValue, indexOf + coerceAtLeast, z2);
            } while (indexOf > 0);
            sb.append((CharSequence) str, i, str.length());
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
        throw new OutOfMemoryError();
    }
}
