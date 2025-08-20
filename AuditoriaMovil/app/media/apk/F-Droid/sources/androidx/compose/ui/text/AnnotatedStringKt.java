package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import ch.qos.logback.core.CoreConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: AnnotatedString.kt */
/* loaded from: classes.dex */
public abstract class AnnotatedStringKt {
    private static final AnnotatedString EmptyAnnotatedString = new AnnotatedString("", null, null, 6, null);

    public static final boolean contains(int i, int i2, int i3, int i4) {
        if (i > i3 || i4 > i2) {
            return false;
        }
        if (i2 == i4) {
            if ((i3 == i4) != (i == i2)) {
                return false;
            }
        }
        return true;
    }

    public static final AnnotatedString emptyAnnotatedString() {
        return EmptyAnnotatedString;
    }

    public static final List filterRanges(List list, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException(("start (" + i + ") should be less than or equal to end (" + i2 + CoreConstants.RIGHT_PARENTHESIS_CHAR).toString());
        } else if (list == null) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = list.get(i3);
                AnnotatedString.Range range = (AnnotatedString.Range) obj;
                if (intersect(i, i2, range.getStart(), range.getEnd())) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int i4 = 0; i4 < size2; i4++) {
                AnnotatedString.Range range2 = (AnnotatedString.Range) arrayList.get(i4);
                arrayList2.add(new AnnotatedString.Range(range2.getItem(), Math.max(i, range2.getStart()) - i, Math.min(i2, range2.getEnd()) - i, range2.getTag()));
            }
            if (arrayList2.isEmpty()) {
                return null;
            }
            return arrayList2;
        }
    }

    public static final List normalizedParagraphStyles(AnnotatedString annotatedString, ParagraphStyle defaultParagraphStyle) {
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(defaultParagraphStyle, "defaultParagraphStyle");
        int length = annotatedString.getText().length();
        List paragraphStylesOrNull$ui_text_release = annotatedString.getParagraphStylesOrNull$ui_text_release();
        if (paragraphStylesOrNull$ui_text_release == null) {
            paragraphStylesOrNull$ui_text_release = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = paragraphStylesOrNull$ui_text_release.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            AnnotatedString.Range range = (AnnotatedString.Range) paragraphStylesOrNull$ui_text_release.get(i);
            ParagraphStyle paragraphStyle = (ParagraphStyle) range.component1();
            int component2 = range.component2();
            int component3 = range.component3();
            if (component2 != i2) {
                arrayList.add(new AnnotatedString.Range(defaultParagraphStyle, i2, component2));
            }
            arrayList.add(new AnnotatedString.Range(defaultParagraphStyle.merge(paragraphStyle), component2, component3));
            i++;
            i2 = component3;
        }
        if (i2 != length) {
            arrayList.add(new AnnotatedString.Range(defaultParagraphStyle, i2, length));
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new AnnotatedString.Range(defaultParagraphStyle, 0, 0));
        }
        return arrayList;
    }

    public static final List getLocalSpanStyles(AnnotatedString annotatedString, int i, int i2) {
        List spanStylesOrNull$ui_text_release;
        int coerceIn;
        int coerceIn2;
        if (i == i2 || (spanStylesOrNull$ui_text_release = annotatedString.getSpanStylesOrNull$ui_text_release()) == null) {
            return null;
        }
        if (i != 0 || i2 < annotatedString.getText().length()) {
            ArrayList arrayList = new ArrayList(spanStylesOrNull$ui_text_release.size());
            int size = spanStylesOrNull$ui_text_release.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = spanStylesOrNull$ui_text_release.get(i3);
                AnnotatedString.Range range = (AnnotatedString.Range) obj;
                if (intersect(i, i2, range.getStart(), range.getEnd())) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int i4 = 0; i4 < size2; i4++) {
                AnnotatedString.Range range2 = (AnnotatedString.Range) arrayList.get(i4);
                Object item = range2.getItem();
                coerceIn = RangesKt___RangesKt.coerceIn(range2.getStart(), i, i2);
                coerceIn2 = RangesKt___RangesKt.coerceIn(range2.getEnd(), i, i2);
                arrayList2.add(new AnnotatedString.Range(item, coerceIn - i, coerceIn2 - i));
            }
            return arrayList2;
        }
        return spanStylesOrNull$ui_text_release;
    }

    public static final List getLocalParagraphStyles(AnnotatedString annotatedString, int i, int i2) {
        List paragraphStylesOrNull$ui_text_release;
        int coerceIn;
        int coerceIn2;
        if (i == i2 || (paragraphStylesOrNull$ui_text_release = annotatedString.getParagraphStylesOrNull$ui_text_release()) == null) {
            return null;
        }
        if (i != 0 || i2 < annotatedString.getText().length()) {
            ArrayList arrayList = new ArrayList(paragraphStylesOrNull$ui_text_release.size());
            int size = paragraphStylesOrNull$ui_text_release.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = paragraphStylesOrNull$ui_text_release.get(i3);
                AnnotatedString.Range range = (AnnotatedString.Range) obj;
                if (intersect(i, i2, range.getStart(), range.getEnd())) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int i4 = 0; i4 < size2; i4++) {
                AnnotatedString.Range range2 = (AnnotatedString.Range) arrayList.get(i4);
                Object item = range2.getItem();
                coerceIn = RangesKt___RangesKt.coerceIn(range2.getStart(), i, i2);
                coerceIn2 = RangesKt___RangesKt.coerceIn(range2.getEnd(), i, i2);
                arrayList2.add(new AnnotatedString.Range(item, coerceIn - i, coerceIn2 - i));
            }
            return arrayList2;
        }
        return paragraphStylesOrNull$ui_text_release;
    }

    public static final List getLocalAnnotations(AnnotatedString annotatedString, int i, int i2) {
        List annotations$ui_text_release;
        int coerceIn;
        int coerceIn2;
        if (i == i2 || (annotations$ui_text_release = annotatedString.getAnnotations$ui_text_release()) == null) {
            return null;
        }
        if (i != 0 || i2 < annotatedString.getText().length()) {
            ArrayList arrayList = new ArrayList(annotations$ui_text_release.size());
            int size = annotations$ui_text_release.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = annotations$ui_text_release.get(i3);
                AnnotatedString.Range range = (AnnotatedString.Range) obj;
                if (intersect(i, i2, range.getStart(), range.getEnd())) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int i4 = 0; i4 < size2; i4++) {
                AnnotatedString.Range range2 = (AnnotatedString.Range) arrayList.get(i4);
                String tag = range2.getTag();
                Object item = range2.getItem();
                coerceIn = RangesKt___RangesKt.coerceIn(range2.getStart(), i, i2);
                coerceIn2 = RangesKt___RangesKt.coerceIn(range2.getEnd(), i, i2);
                arrayList2.add(new AnnotatedString.Range(item, coerceIn - i, coerceIn2 - i, tag));
            }
            return arrayList2;
        }
        return annotations$ui_text_release;
    }

    public static final AnnotatedString substringWithoutParagraphStyles(AnnotatedString annotatedString, int i, int i2) {
        String str;
        if (i != i2) {
            str = annotatedString.getText().substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            str = "";
        }
        return new AnnotatedString(str, getLocalSpanStyles(annotatedString, i, i2), null, null, 12, null);
    }

    public static final boolean intersect(int i, int i2, int i3, int i4) {
        return Math.max(i, i3) < Math.min(i2, i4) || contains(i, i2, i3, i4) || contains(i3, i4, i, i2);
    }
}
