package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TextAlign.kt */
/* loaded from: classes.dex */
public final class TextAlign {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Left = m1818constructorimpl(1);
    private static final int Right = m1818constructorimpl(2);
    private static final int Center = m1818constructorimpl(3);
    private static final int Justify = m1818constructorimpl(4);
    private static final int Start = m1818constructorimpl(5);
    private static final int End = m1818constructorimpl(6);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TextAlign m1817boximpl(int i) {
        return new TextAlign(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1818constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1819equalsimpl(int i, Object obj) {
        return (obj instanceof TextAlign) && i == ((TextAlign) obj).m1823unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1820equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1821hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m1819equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1821hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1823unboximpl() {
        return this.value;
    }

    private /* synthetic */ TextAlign(int i) {
        this.value = i;
    }

    public String toString() {
        return m1822toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1822toStringimpl(int i) {
        return m1820equalsimpl0(i, Left) ? "Left" : m1820equalsimpl0(i, Right) ? "Right" : m1820equalsimpl0(i, Center) ? "Center" : m1820equalsimpl0(i, Justify) ? "Justify" : m1820equalsimpl0(i, Start) ? "Start" : m1820equalsimpl0(i, End) ? "End" : "Invalid";
    }

    /* compiled from: TextAlign.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getLeft-e0LSkKk  reason: not valid java name */
        public final int m1827getLefte0LSkKk() {
            return TextAlign.Left;
        }

        /* renamed from: getRight-e0LSkKk  reason: not valid java name */
        public final int m1828getRighte0LSkKk() {
            return TextAlign.Right;
        }

        /* renamed from: getCenter-e0LSkKk  reason: not valid java name */
        public final int m1824getCentere0LSkKk() {
            return TextAlign.Center;
        }

        /* renamed from: getJustify-e0LSkKk  reason: not valid java name */
        public final int m1826getJustifye0LSkKk() {
            return TextAlign.Justify;
        }

        /* renamed from: getStart-e0LSkKk  reason: not valid java name */
        public final int m1829getStarte0LSkKk() {
            return TextAlign.Start;
        }

        /* renamed from: getEnd-e0LSkKk  reason: not valid java name */
        public final int m1825getEnde0LSkKk() {
            return TextAlign.End;
        }
    }
}
