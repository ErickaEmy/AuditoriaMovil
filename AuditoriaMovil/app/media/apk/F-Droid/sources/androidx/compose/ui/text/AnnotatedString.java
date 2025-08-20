package androidx.compose.ui.text;

import ch.qos.logback.core.CoreConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AnnotatedString.kt */
/* loaded from: classes.dex */
public final class AnnotatedString implements CharSequence {
    private final List annotations;
    private final List paragraphStylesOrNull;
    private final List spanStylesOrNull;
    private final String text;

    public final List getAnnotations$ui_text_release() {
        return this.annotations;
    }

    public final List getParagraphStylesOrNull$ui_text_release() {
        return this.paragraphStylesOrNull;
    }

    public final List getSpanStylesOrNull$ui_text_release() {
        return this.spanStylesOrNull;
    }

    public final String getText() {
        return this.text;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.text;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
        r3 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r5, new androidx.compose.ui.text.AnnotatedString$special$$inlined$sortedBy$1());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AnnotatedString(java.lang.String r3, java.util.List r4, java.util.List r5, java.util.List r6) {
        /*
            r2 = this;
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r2.<init>()
            r2.text = r3
            r2.spanStylesOrNull = r4
            r2.paragraphStylesOrNull = r5
            r2.annotations = r6
            if (r5 == 0) goto L80
            androidx.compose.ui.text.AnnotatedString$special$$inlined$sortedBy$1 r3 = new androidx.compose.ui.text.AnnotatedString$special$$inlined$sortedBy$1
            r3.<init>()
            java.util.List r3 = kotlin.collections.CollectionsKt.sortedWith(r5, r3)
            if (r3 == 0) goto L80
            int r4 = r3.size()
            r5 = -1
            r6 = 0
        L23:
            if (r6 >= r4) goto L80
            java.lang.Object r0 = r3.get(r6)
            androidx.compose.ui.text.AnnotatedString$Range r0 = (androidx.compose.ui.text.AnnotatedString.Range) r0
            int r1 = r0.getStart()
            if (r1 < r5) goto L74
            int r5 = r0.getEnd()
            java.lang.String r1 = r2.text
            int r1 = r1.length()
            if (r5 > r1) goto L44
            int r5 = r0.getEnd()
            int r6 = r6 + 1
            goto L23
        L44:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "ParagraphStyle range ["
            r3.append(r4)
            int r4 = r0.getStart()
            r3.append(r4)
            java.lang.String r4 = ", "
            r3.append(r4)
            int r4 = r0.getEnd()
            r3.append(r4)
            java.lang.String r4 = ") is out of boundary"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r3 = r3.toString()
            r4.<init>(r3)
            throw r4
        L74:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "ParagraphStyle should not overlap"
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.AnnotatedString.<init>(java.lang.String, java.util.List, java.util.List, java.util.List):void");
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public /* synthetic */ AnnotatedString(String str, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : list3);
    }

    public final boolean hasStringAnnotations(String tag, int i, int i2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        List list = this.annotations;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Range range = (Range) list.get(i3);
                if ((range.getItem() instanceof String) && Intrinsics.areEqual(tag, range.getTag()) && AnnotatedStringKt.intersect(i, i2, range.getStart(), range.getEnd())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final List getStringAnnotations(String tag, int i, int i2) {
        List emptyList;
        Intrinsics.checkNotNullParameter(tag, "tag");
        List list = this.annotations;
        if (list != null) {
            emptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = list.get(i3);
                Range range = (Range) obj;
                if ((range.getItem() instanceof String) && Intrinsics.areEqual(tag, range.getTag()) && AnnotatedStringKt.intersect(i, i2, range.getStart(), range.getEnd())) {
                    emptyList.add(obj);
                }
            }
        } else {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(emptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<kotlin.String>>");
        return emptyList;
    }

    public final List getTtsAnnotations(int i, int i2) {
        List emptyList;
        List list = this.annotations;
        if (list != null) {
            emptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = list.get(i3);
                Range range = (Range) obj;
                if ((range.getItem() instanceof TtsAnnotation) && AnnotatedStringKt.intersect(i, i2, range.getStart(), range.getEnd())) {
                    emptyList.add(obj);
                }
            }
        } else {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(emptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.TtsAnnotation>>");
        return emptyList;
    }

    public final List getUrlAnnotations(int i, int i2) {
        List emptyList;
        List list = this.annotations;
        if (list != null) {
            emptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = list.get(i3);
                Range range = (Range) obj;
                if ((range.getItem() instanceof UrlAnnotation) && AnnotatedStringKt.intersect(i, i2, range.getStart(), range.getEnd())) {
                    emptyList.add(obj);
                }
            }
        } else {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(emptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.UrlAnnotation>>");
        return emptyList;
    }

    public final List getSpanStyles() {
        List emptyList;
        List list = this.spanStylesOrNull;
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list;
    }

    public final List getParagraphStyles() {
        List emptyList;
        List list = this.paragraphStylesOrNull;
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list;
    }

    public /* synthetic */ AnnotatedString(String str, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnnotatedString(String text, List spanStyles, List paragraphStyles) {
        this(text, spanStyles.isEmpty() ? null : spanStyles, paragraphStyles.isEmpty() ? null : paragraphStyles, null);
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(spanStyles, "spanStyles");
        Intrinsics.checkNotNullParameter(paragraphStyles, "paragraphStyles");
    }

    public int getLength() {
        return this.text.length();
    }

    public char get(int i) {
        return this.text.charAt(i);
    }

    @Override // java.lang.CharSequence
    public AnnotatedString subSequence(int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException(("start (" + i + ") should be less or equal to end (" + i2 + CoreConstants.RIGHT_PARENTHESIS_CHAR).toString());
        } else if (i == 0 && i2 == this.text.length()) {
            return this;
        } else {
            String substring = this.text.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return new AnnotatedString(substring, AnnotatedStringKt.access$filterRanges(this.spanStylesOrNull, i, i2), AnnotatedStringKt.access$filterRanges(this.paragraphStylesOrNull, i, i2), AnnotatedStringKt.access$filterRanges(this.annotations, i, i2));
        }
    }

    /* renamed from: subSequence-5zc-tL8  reason: not valid java name */
    public final AnnotatedString m1511subSequence5zctL8(long j) {
        return subSequence(TextRange.m1583getMinimpl(j), TextRange.m1582getMaximpl(j));
    }

    public final AnnotatedString plus(AnnotatedString other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Builder builder = new Builder(this);
        builder.append(other);
        return builder.toAnnotatedString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AnnotatedString) {
            AnnotatedString annotatedString = (AnnotatedString) obj;
            return Intrinsics.areEqual(this.text, annotatedString.text) && Intrinsics.areEqual(this.spanStylesOrNull, annotatedString.spanStylesOrNull) && Intrinsics.areEqual(this.paragraphStylesOrNull, annotatedString.paragraphStylesOrNull) && Intrinsics.areEqual(this.annotations, annotatedString.annotations);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.text.hashCode() * 31;
        List list = this.spanStylesOrNull;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List list2 = this.paragraphStylesOrNull;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List list3 = this.annotations;
        return hashCode3 + (list3 != null ? list3.hashCode() : 0);
    }

    /* compiled from: AnnotatedString.kt */
    /* loaded from: classes.dex */
    public static final class Range {
        private final int end;
        private final Object item;
        private final int start;
        private final String tag;

        public final Object component1() {
            return this.item;
        }

        public final int component2() {
            return this.start;
        }

        public final int component3() {
            return this.end;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Range) {
                Range range = (Range) obj;
                return Intrinsics.areEqual(this.item, range.item) && this.start == range.start && this.end == range.end && Intrinsics.areEqual(this.tag, range.tag);
            }
            return false;
        }

        public final int getEnd() {
            return this.end;
        }

        public final Object getItem() {
            return this.item;
        }

        public final int getStart() {
            return this.start;
        }

        public final String getTag() {
            return this.tag;
        }

        public int hashCode() {
            Object obj = this.item;
            return ((((((obj == null ? 0 : obj.hashCode()) * 31) + this.start) * 31) + this.end) * 31) + this.tag.hashCode();
        }

        public String toString() {
            return "Range(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Range(Object obj, int i, int i2, String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.item = obj;
            this.start = i;
            this.end = i2;
            this.tag = tag;
            if (i > i2) {
                throw new IllegalArgumentException("Reversed range is not supported".toString());
            }
        }

        public Range(Object obj, int i, int i2) {
            this(obj, i, i2, "");
        }
    }

    /* compiled from: AnnotatedString.kt */
    /* loaded from: classes.dex */
    public static final class Builder implements Appendable {
        private final List annotations;
        private final List paragraphStyles;
        private final List spanStyles;
        private final List styleStack;
        private final StringBuilder text;

        public Builder(int i) {
            this.text = new StringBuilder(i);
            this.spanStyles = new ArrayList();
            this.paragraphStyles = new ArrayList();
            this.annotations = new ArrayList();
            this.styleStack = new ArrayList();
        }

        public /* synthetic */ Builder(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 16 : i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: AnnotatedString.kt */
        /* loaded from: classes.dex */
        public static final class MutableRange {
            private int end;
            private final Object item;
            private final int start;
            private final String tag;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof MutableRange) {
                    MutableRange mutableRange = (MutableRange) obj;
                    return Intrinsics.areEqual(this.item, mutableRange.item) && this.start == mutableRange.start && this.end == mutableRange.end && Intrinsics.areEqual(this.tag, mutableRange.tag);
                }
                return false;
            }

            public int hashCode() {
                Object obj = this.item;
                return ((((((obj == null ? 0 : obj.hashCode()) * 31) + this.start) * 31) + this.end) * 31) + this.tag.hashCode();
            }

            public String toString() {
                return "MutableRange(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public MutableRange(Object obj, int i, int i2, String tag) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                this.item = obj;
                this.start = i;
                this.end = i2;
                this.tag = tag;
            }

            public /* synthetic */ MutableRange(Object obj, int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(obj, i, (i3 & 4) != 0 ? Integer.MIN_VALUE : i2, (i3 & 8) != 0 ? "" : str);
            }

            public final Range toRange(int i) {
                int i2 = this.end;
                if (i2 != Integer.MIN_VALUE) {
                    i = i2;
                }
                if (i == Integer.MIN_VALUE) {
                    throw new IllegalStateException("Item.end should be set first".toString());
                }
                return new Range(this.item, this.start, i, this.tag);
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(AnnotatedString text) {
            this(0, 1, null);
            Intrinsics.checkNotNullParameter(text, "text");
            append(text);
        }

        public final void append(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text.append(text);
        }

        @Override // java.lang.Appendable
        public Builder append(CharSequence charSequence) {
            if (charSequence instanceof AnnotatedString) {
                append((AnnotatedString) charSequence);
            } else {
                this.text.append(charSequence);
            }
            return this;
        }

        @Override // java.lang.Appendable
        public Builder append(CharSequence charSequence, int i, int i2) {
            if (charSequence instanceof AnnotatedString) {
                append((AnnotatedString) charSequence, i, i2);
            } else {
                this.text.append(charSequence, i, i2);
            }
            return this;
        }

        @Override // java.lang.Appendable
        public Builder append(char c) {
            this.text.append(c);
            return this;
        }

        public final void append(AnnotatedString text) {
            Intrinsics.checkNotNullParameter(text, "text");
            int length = this.text.length();
            this.text.append(text.getText());
            List spanStylesOrNull$ui_text_release = text.getSpanStylesOrNull$ui_text_release();
            if (spanStylesOrNull$ui_text_release != null) {
                int size = spanStylesOrNull$ui_text_release.size();
                for (int i = 0; i < size; i++) {
                    Range range = (Range) spanStylesOrNull$ui_text_release.get(i);
                    addStyle((SpanStyle) range.getItem(), range.getStart() + length, range.getEnd() + length);
                }
            }
            List paragraphStylesOrNull$ui_text_release = text.getParagraphStylesOrNull$ui_text_release();
            if (paragraphStylesOrNull$ui_text_release != null) {
                int size2 = paragraphStylesOrNull$ui_text_release.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Range range2 = (Range) paragraphStylesOrNull$ui_text_release.get(i2);
                    addStyle((ParagraphStyle) range2.getItem(), range2.getStart() + length, range2.getEnd() + length);
                }
            }
            List annotations$ui_text_release = text.getAnnotations$ui_text_release();
            if (annotations$ui_text_release != null) {
                int size3 = annotations$ui_text_release.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    Range range3 = (Range) annotations$ui_text_release.get(i3);
                    this.annotations.add(new MutableRange(range3.getItem(), range3.getStart() + length, range3.getEnd() + length, range3.getTag()));
                }
            }
        }

        public final void append(AnnotatedString text, int i, int i2) {
            Intrinsics.checkNotNullParameter(text, "text");
            int length = this.text.length();
            this.text.append((CharSequence) text.getText(), i, i2);
            List access$getLocalSpanStyles = AnnotatedStringKt.access$getLocalSpanStyles(text, i, i2);
            if (access$getLocalSpanStyles != null) {
                int size = access$getLocalSpanStyles.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Range range = (Range) access$getLocalSpanStyles.get(i3);
                    addStyle((SpanStyle) range.getItem(), range.getStart() + length, range.getEnd() + length);
                }
            }
            List access$getLocalParagraphStyles = AnnotatedStringKt.access$getLocalParagraphStyles(text, i, i2);
            if (access$getLocalParagraphStyles != null) {
                int size2 = access$getLocalParagraphStyles.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    Range range2 = (Range) access$getLocalParagraphStyles.get(i4);
                    addStyle((ParagraphStyle) range2.getItem(), range2.getStart() + length, range2.getEnd() + length);
                }
            }
            List access$getLocalAnnotations = AnnotatedStringKt.access$getLocalAnnotations(text, i, i2);
            if (access$getLocalAnnotations != null) {
                int size3 = access$getLocalAnnotations.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    Range range3 = (Range) access$getLocalAnnotations.get(i5);
                    this.annotations.add(new MutableRange(range3.getItem(), range3.getStart() + length, range3.getEnd() + length, range3.getTag()));
                }
            }
        }

        public final void addStyle(SpanStyle style, int i, int i2) {
            Intrinsics.checkNotNullParameter(style, "style");
            this.spanStyles.add(new MutableRange(style, i, i2, null, 8, null));
        }

        public final void addStyle(ParagraphStyle style, int i, int i2) {
            Intrinsics.checkNotNullParameter(style, "style");
            this.paragraphStyles.add(new MutableRange(style, i, i2, null, 8, null));
        }

        public final int pushStyle(SpanStyle style) {
            Intrinsics.checkNotNullParameter(style, "style");
            MutableRange mutableRange = new MutableRange(style, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.spanStyles.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final AnnotatedString toAnnotatedString() {
            String sb = this.text.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "text.toString()");
            List list = this.spanStyles;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(((MutableRange) list.get(i)).toRange(this.text.length()));
            }
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            List list2 = this.paragraphStyles;
            ArrayList arrayList2 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                arrayList2.add(((MutableRange) list2.get(i2)).toRange(this.text.length()));
            }
            if (arrayList2.isEmpty()) {
                arrayList2 = null;
            }
            List list3 = this.annotations;
            ArrayList arrayList3 = new ArrayList(list3.size());
            int size3 = list3.size();
            for (int i3 = 0; i3 < size3; i3++) {
                arrayList3.add(((MutableRange) list3.get(i3)).toRange(this.text.length()));
            }
            return new AnnotatedString(sb, arrayList, arrayList2, arrayList3.isEmpty() ? null : arrayList3);
        }
    }
}
