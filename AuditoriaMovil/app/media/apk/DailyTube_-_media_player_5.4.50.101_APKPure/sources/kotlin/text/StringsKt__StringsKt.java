package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static boolean contains(CharSequence charSequence, CharSequence other, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof String) {
            if (StringsKt.indexOf$default(charSequence, (String) other, 0, z2, 2, (Object) null) < 0) {
                return false;
            }
        } else if (indexOf$StringsKt__StringsKt$default(charSequence, other, 0, charSequence.length(), z2, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return StringsKt.contains(charSequence, charSequence2, z2);
    }

    public static final boolean endsWith(CharSequence charSequence, char c2, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() > 0 && CharsKt__CharKt.equals(charSequence.charAt(StringsKt.getLastIndex(charSequence)), c2, z2);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return endsWith(charSequence, c2, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence charSequence, Collection<String> collection, int i, boolean z2, boolean z3) {
        IntProgression downTo;
        Object obj;
        Object obj2;
        int lastIndexOf$default;
        if (!z2 && collection.size() == 1) {
            String str = (String) CollectionsKt.single(collection);
            if (!z3) {
                lastIndexOf$default = StringsKt.indexOf$default(charSequence, str, i, false, 4, (Object) null);
            } else {
                lastIndexOf$default = StringsKt.lastIndexOf$default(charSequence, str, i, false, 4, (Object) null);
            }
            if (lastIndexOf$default < 0) {
                return null;
            }
            return TuplesKt.to(Integer.valueOf(lastIndexOf$default), str);
        }
        if (!z3) {
            downTo = new IntRange(RangesKt.coerceAtLeast(i, 0), charSequence.length());
        } else {
            downTo = RangesKt.downTo(RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)), 0);
        }
        if (charSequence instanceof String) {
            int first = downTo.getFirst();
            int last = downTo.getLast();
            int step = downTo.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj2 = it.next();
                            String str2 = (String) obj2;
                            if (StringsKt__StringsJVMKt.regionMatches(str2, 0, (String) charSequence, first, str2.length(), z2)) {
                                break;
                            }
                        } else {
                            obj2 = null;
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 != null) {
                        return TuplesKt.to(Integer.valueOf(first), str3);
                    }
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int first2 = downTo.getFirst();
            int last2 = downTo.getLast();
            int step2 = downTo.getStep();
            if ((step2 > 0 && first2 <= last2) || (step2 < 0 && last2 <= first2)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            obj = it2.next();
                            String str4 = (String) obj;
                            if (regionMatchesImpl(str4, 0, charSequence, first2, str4.length(), z2)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 != null) {
                        return TuplesKt.to(Integer.valueOf(first2), str5);
                    }
                    if (first2 == last2) {
                        break;
                    }
                    first2 += step2;
                }
            }
        }
        return null;
    }

    public static final IntRange getIndices(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static int getLastIndex(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int indexOf(CharSequence charSequence, char c2, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return (z2 || !(charSequence instanceof String)) ? indexOfAny(charSequence, new char[]{c2}, i, z2) : ((String) charSequence).indexOf(c2, i);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i, int i5, boolean z2, boolean z3) {
        IntProgression downTo;
        if (!z3) {
            downTo = new IntRange(RangesKt.coerceAtLeast(i, 0), RangesKt.coerceAtMost(i5, charSequence.length()));
        } else {
            downTo = RangesKt.downTo(RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)), RangesKt.coerceAtLeast(i5, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = downTo.getFirst();
            int last = downTo.getLast();
            int step = downTo.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (!StringsKt__StringsJVMKt.regionMatches((String) charSequence2, 0, (String) charSequence, first, charSequence2.length(), z2)) {
                    if (first != last) {
                        first += step;
                    } else {
                        return -1;
                    }
                }
                return first;
            }
            return -1;
        }
        int first2 = downTo.getFirst();
        int last2 = downTo.getLast();
        int step2 = downTo.getStep();
        if ((step2 > 0 && first2 <= last2) || (step2 < 0 && last2 <= first2)) {
            while (!regionMatchesImpl(charSequence2, 0, charSequence, first2, charSequence2.length(), z2)) {
                if (first2 != last2) {
                    first2 += step2;
                } else {
                    return -1;
                }
            }
            return first2;
        }
        return -1;
    }

    public static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int i, int i5, boolean z2, boolean z3, int i6, Object obj) {
        boolean z4;
        if ((i6 & 16) != 0) {
            z4 = false;
        } else {
            z4 = z3;
        }
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i, i5, z2, z4);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c2, int i, boolean z2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i = 0;
        }
        if ((i5 & 4) != 0) {
            z2 = false;
        }
        return indexOf(charSequence, c2, i, z2);
    }

    /* JADX WARN: Type inference failed for: r8v2, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final int indexOfAny(CharSequence charSequence, char[] chars, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!z2 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ArraysKt.single(chars), i);
        }
        ?? it = new IntRange(RangesKt.coerceAtLeast(i, 0), StringsKt.getLastIndex(charSequence)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            char charAt = charSequence.charAt(nextInt);
            for (char c2 : chars) {
                if (CharsKt__CharKt.equals(c2, charAt, z2)) {
                    return nextInt;
                }
            }
        }
        return -1;
    }

    public static final int lastIndexOf(CharSequence charSequence, char c2, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return (z2 || !(charSequence instanceof String)) ? lastIndexOfAny(charSequence, new char[]{c2}, i, z2) : ((String) charSequence).lastIndexOf(c2, i);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c2, int i, boolean z2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i5 & 4) != 0) {
            z2 = false;
        }
        return lastIndexOf(charSequence, c2, i, z2);
    }

    public static final int lastIndexOfAny(CharSequence charSequence, char[] chars, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!z2 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(ArraysKt.single(chars), i);
        }
        for (int coerceAtMost = RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)); -1 < coerceAtMost; coerceAtMost--) {
            char charAt = charSequence.charAt(coerceAtMost);
            for (char c2 : chars) {
                if (CharsKt__CharKt.equals(c2, charAt, z2)) {
                    return coerceAtMost;
                }
            }
        }
        return -1;
    }

    public static final Sequence<String> lineSequence(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return splitToSequence$default(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static List<String> lines(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return SequencesKt.toList(lineSequence(charSequence));
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final CharSequence padStart(CharSequence charSequence, int i, char c2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i >= 0) {
            if (i <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(i);
            ?? it = new IntRange(1, i - charSequence.length()).iterator();
            while (it.hasNext()) {
                it.nextInt();
                sb.append(c2);
            }
            sb.append(charSequence);
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, final char[] cArr, int i, final boolean z2, int i5) {
        requireNonNegativeLimit(i5);
        return new DelimitedRangesSequence(charSequence, i, i5, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            public final Pair<Integer, Integer> invoke(CharSequence $receiver, int i6) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                int indexOfAny = StringsKt__StringsKt.indexOfAny($receiver, cArr, i6, z2);
                if (indexOfAny < 0) {
                    return null;
                }
                return TuplesKt.to(Integer.valueOf(indexOfAny), 1);
            }
        });
    }

    public static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, char[] cArr, int i, boolean z2, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        if ((i6 & 4) != 0) {
            z2 = false;
        }
        if ((i6 & 8) != 0) {
            i5 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArr, i, z2, i5);
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i, CharSequence other, int i5, int i6, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i5 < 0 || i < 0 || i > charSequence.length() - i6 || i5 > other.length() - i6) {
            return false;
        }
        for (int i8 = 0; i8 < i6; i8++) {
            if (!CharsKt__CharKt.equals(charSequence.charAt(i + i8), other.charAt(i5 + i8), z2)) {
                return false;
            }
        }
        return true;
    }

    public static String removePrefix(String str, CharSequence prefix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (StringsKt.startsWith$default((CharSequence) str, prefix, false, 2, (Object) null)) {
            String substring = str.substring(prefix.length());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return str;
    }

    public static String removeSuffix(String str, CharSequence suffix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (StringsKt.endsWith$default((CharSequence) str, suffix, false, 2, (Object) null)) {
            String substring = str.substring(0, str.length() - suffix.length());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return str;
    }

    public static final String removeSurrounding(String str, CharSequence prefix, CharSequence suffix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (str.length() >= prefix.length() + suffix.length() && StringsKt.startsWith$default((CharSequence) str, prefix, false, 2, (Object) null) && StringsKt.endsWith$default((CharSequence) str, suffix, false, 2, (Object) null)) {
            String substring = str.substring(prefix.length(), str.length() - suffix.length());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return str;
    }

    public static CharSequence replaceRange(CharSequence charSequence, int i, int i5, CharSequence replacement) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        if (i5 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(replacement);
            sb.append(charSequence, i5, charSequence.length());
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i5 + ") is less than start index (" + i + ").");
    }

    public static final void requireNonNegativeLimit(int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i).toString());
    }

    public static final List<String> split(CharSequence charSequence, String[] delimiters, boolean z2, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                return split$StringsKt__StringsKt(charSequence, str, z2, i);
            }
        }
        Iterable<IntRange> asIterable = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, delimiters, 0, z2, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(asIterable, 10));
        for (IntRange intRange : asIterable) {
            arrayList.add(substring(charSequence, intRange));
        }
        return arrayList;
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence charSequence, String str, boolean z2, int i) {
        boolean z3;
        requireNonNegativeLimit(i);
        int i5 = 0;
        int indexOf = indexOf(charSequence, str, 0, z2);
        if (indexOf != -1 && i != 1) {
            if (i > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            int i6 = 10;
            if (z3) {
                i6 = RangesKt.coerceAtMost(i, 10);
            }
            ArrayList arrayList = new ArrayList(i6);
            do {
                arrayList.add(charSequence.subSequence(i5, indexOf).toString());
                i5 = str.length() + indexOf;
                if (z3 && arrayList.size() == i - 1) {
                    break;
                }
                indexOf = indexOf(charSequence, str, i5, z2);
            } while (indexOf != -1);
            arrayList.add(charSequence.subSequence(i5, charSequence.length()).toString());
            return arrayList;
        }
        return CollectionsKt.listOf(charSequence.toString());
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z2, int i, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z2 = false;
        }
        if ((i5 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, strArr, z2, i);
    }

    public static final Sequence<String> splitToSequence(final CharSequence charSequence, String[] delimiters, boolean z2, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, delimiters, 0, z2, i, 2, (Object) null), new Function1<IntRange, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(IntRange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return StringsKt__StringsKt.substring(charSequence, it);
            }
        });
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, String[] strArr, boolean z2, int i, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z2 = false;
        }
        if ((i5 & 4) != 0) {
            i = 0;
        }
        return splitToSequence(charSequence, strArr, z2, i);
    }

    public static final boolean startsWith(CharSequence charSequence, char c2, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() > 0 && CharsKt__CharKt.equals(charSequence.charAt(0), c2, z2);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return startsWith(charSequence, c2, z2);
    }

    public static final String substring(CharSequence charSequence, IntRange range) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    public static final String substringAfter(String str, char c2, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(indexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ String substringAfter$default(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfter(str, c2, str2);
    }

    public static final String substringAfterLast(String str, char c2, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (lastIndexOf$default != -1) {
            String substring = str.substring(lastIndexOf$default + 1, str.length());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return missingDelimiterValue;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfterLast(str, c2, str2);
    }

    public static final String substringBefore(String str, char c2, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ String substringBefore$default(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBefore(str, c2, str2);
    }

    public static final String substringBeforeLast(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (lastIndexOf$default != -1) {
            String substring = str.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return missingDelimiterValue;
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBeforeLast(str, str2, str3);
    }

    public static CharSequence trim(CharSequence charSequence) {
        int i;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i5 = 0;
        boolean z2 = false;
        while (i5 <= length) {
            if (!z2) {
                i = i5;
            } else {
                i = length;
            }
            boolean isWhitespace = CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(i));
            if (!z2) {
                if (!isWhitespace) {
                    z2 = true;
                } else {
                    i5++;
                }
            } else if (!isWhitespace) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i5, length + 1);
    }

    public static CharSequence trimEnd(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return "";
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return contains(charSequence, c2, z2);
    }

    public static final boolean endsWith(CharSequence charSequence, CharSequence suffix, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!z2 && (charSequence instanceof String) && (suffix instanceof String)) {
            return StringsKt.endsWith$default((String) charSequence, (String) suffix, false, 2, (Object) null);
        }
        return regionMatchesImpl(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z2);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return endsWith(charSequence, charSequence2, z2);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i = 0;
        }
        if ((i5 & 4) != 0) {
            z2 = false;
        }
        return indexOf(charSequence, str, i, z2);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i, boolean z2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i5 & 4) != 0) {
            z2 = false;
        }
        return lastIndexOf(charSequence, str, i, z2);
    }

    public static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, int i, boolean z2, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        if ((i6 & 4) != 0) {
            z2 = false;
        }
        if ((i6 & 8) != 0) {
            i5 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, strArr, i, z2, i5);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z2, int i, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z2 = false;
        }
        if ((i5 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, cArr, z2, i);
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence prefix, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!z2 && (charSequence instanceof String) && (prefix instanceof String)) {
            return StringsKt.startsWith$default((String) charSequence, (String) prefix, false, 2, (Object) null);
        }
        return regionMatchesImpl(charSequence, 0, prefix, 0, prefix.length(), z2);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return startsWith(charSequence, charSequence2, z2);
    }

    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringAfter(str, str2, str3);
    }

    public static /* synthetic */ String substringBefore$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBefore(str, str2, str3);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, String[] strArr, int i, final boolean z2, int i5) {
        requireNonNegativeLimit(i5);
        final List asList = ArraysKt.asList(strArr);
        return new DelimitedRangesSequence(charSequence, i, i5, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            public final Pair<Integer, Integer> invoke(CharSequence $receiver, int i6) {
                Pair findAnyOf$StringsKt__StringsKt;
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                findAnyOf$StringsKt__StringsKt = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($receiver, asList, i6, z2, false);
                if (findAnyOf$StringsKt__StringsKt != null) {
                    return TuplesKt.to(findAnyOf$StringsKt__StringsKt.getFirst(), Integer.valueOf(((String) findAnyOf$StringsKt__StringsKt.getSecond()).length()));
                }
                return null;
            }
        });
    }

    public static String removeSurrounding(String str, CharSequence delimiter) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        return removeSurrounding(str, delimiter, delimiter);
    }

    public static final String substringAfter(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(indexOf$default + delimiter.length(), str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static final String substringBefore(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static final boolean contains(CharSequence charSequence, char c2, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return StringsKt.indexOf$default(charSequence, c2, 0, z2, 2, (Object) null) >= 0;
    }

    public static final int indexOf(CharSequence charSequence, String string, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!z2 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(string, i);
        }
        return indexOf$StringsKt__StringsKt$default(charSequence, string, i, charSequence.length(), z2, false, 16, null);
    }

    public static final int lastIndexOf(CharSequence charSequence, String string, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!z2 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(string, i);
        }
        return indexOf$StringsKt__StringsKt(charSequence, string, i, 0, z2, true);
    }

    public static String padStart(String str, int i, char c2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return padStart((CharSequence) str, i, c2).toString();
    }

    public static final List<String> split(CharSequence charSequence, char[] delimiters, boolean z2, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return split$StringsKt__StringsKt(charSequence, String.valueOf(delimiters[0]), z2, i);
        }
        Iterable<IntRange> asIterable = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, delimiters, 0, z2, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(asIterable, 10));
        for (IntRange intRange : asIterable) {
            arrayList.add(substring(charSequence, intRange));
        }
        return arrayList;
    }
}
