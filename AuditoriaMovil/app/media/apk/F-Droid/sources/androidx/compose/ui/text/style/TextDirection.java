package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TextDirection.kt */
/* loaded from: classes.dex */
public final class TextDirection {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Ltr = m1831constructorimpl(1);
    private static final int Rtl = m1831constructorimpl(2);
    private static final int Content = m1831constructorimpl(3);
    private static final int ContentOrLtr = m1831constructorimpl(4);
    private static final int ContentOrRtl = m1831constructorimpl(5);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TextDirection m1830boximpl(int i) {
        return new TextDirection(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1831constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1832equalsimpl(int i, Object obj) {
        return (obj instanceof TextDirection) && i == ((TextDirection) obj).m1836unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1833equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1834hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m1832equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1834hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1836unboximpl() {
        return this.value;
    }

    private /* synthetic */ TextDirection(int i) {
        this.value = i;
    }

    public String toString() {
        return m1835toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1835toStringimpl(int i) {
        return m1833equalsimpl0(i, Ltr) ? "Ltr" : m1833equalsimpl0(i, Rtl) ? "Rtl" : m1833equalsimpl0(i, Content) ? "Content" : m1833equalsimpl0(i, ContentOrLtr) ? "ContentOrLtr" : m1833equalsimpl0(i, ContentOrRtl) ? "ContentOrRtl" : "Invalid";
    }

    /* compiled from: TextDirection.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getLtr-s_7X-co  reason: not valid java name */
        public final int m1840getLtrs_7Xco() {
            return TextDirection.Ltr;
        }

        /* renamed from: getRtl-s_7X-co  reason: not valid java name */
        public final int m1841getRtls_7Xco() {
            return TextDirection.Rtl;
        }

        /* renamed from: getContent-s_7X-co  reason: not valid java name */
        public final int m1837getContents_7Xco() {
            return TextDirection.Content;
        }

        /* renamed from: getContentOrLtr-s_7X-co  reason: not valid java name */
        public final int m1838getContentOrLtrs_7Xco() {
            return TextDirection.ContentOrLtr;
        }

        /* renamed from: getContentOrRtl-s_7X-co  reason: not valid java name */
        public final int m1839getContentOrRtls_7Xco() {
            return TextDirection.ContentOrRtl;
        }
    }
}
