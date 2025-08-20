package androidx.compose.ui.text.font;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: FontSynthesis.kt */
/* loaded from: classes.dex */
public final class FontSynthesis {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int None = m1648constructorimpl(0);
    private static final int All = m1648constructorimpl(1);
    private static final int Weight = m1648constructorimpl(2);
    private static final int Style = m1648constructorimpl(3);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FontSynthesis m1647boximpl(int i) {
        return new FontSynthesis(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1648constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1649equalsimpl(int i, Object obj) {
        return (obj instanceof FontSynthesis) && i == ((FontSynthesis) obj).m1655unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1650equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1651hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m1649equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1651hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1655unboximpl() {
        return this.value;
    }

    private /* synthetic */ FontSynthesis(int i) {
        this.value = i;
    }

    public String toString() {
        return m1654toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1654toStringimpl(int i) {
        return m1650equalsimpl0(i, None) ? "None" : m1650equalsimpl0(i, All) ? "All" : m1650equalsimpl0(i, Weight) ? "Weight" : m1650equalsimpl0(i, Style) ? "Style" : "Invalid";
    }

    /* compiled from: FontSynthesis.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getNone-GVVA2EU  reason: not valid java name */
        public final int m1657getNoneGVVA2EU() {
            return FontSynthesis.None;
        }

        /* renamed from: getAll-GVVA2EU  reason: not valid java name */
        public final int m1656getAllGVVA2EU() {
            return FontSynthesis.All;
        }

        /* renamed from: getWeight-GVVA2EU  reason: not valid java name */
        public final int m1659getWeightGVVA2EU() {
            return FontSynthesis.Weight;
        }

        /* renamed from: getStyle-GVVA2EU  reason: not valid java name */
        public final int m1658getStyleGVVA2EU() {
            return FontSynthesis.Style;
        }
    }

    /* renamed from: isWeightOn-impl$ui_text_release  reason: not valid java name */
    public static final boolean m1653isWeightOnimpl$ui_text_release(int i) {
        return m1650equalsimpl0(i, All) || m1650equalsimpl0(i, Weight);
    }

    /* renamed from: isStyleOn-impl$ui_text_release  reason: not valid java name */
    public static final boolean m1652isStyleOnimpl$ui_text_release(int i) {
        return m1650equalsimpl0(i, All) || m1650equalsimpl0(i, Style);
    }
}
