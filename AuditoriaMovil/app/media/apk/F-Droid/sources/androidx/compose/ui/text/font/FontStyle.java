package androidx.compose.ui.text.font;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: FontStyle.kt */
/* loaded from: classes.dex */
public final class FontStyle {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Normal = m1639constructorimpl(0);
    private static final int Italic = m1639constructorimpl(1);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FontStyle m1638boximpl(int i) {
        return new FontStyle(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1639constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1640equalsimpl(int i, Object obj) {
        return (obj instanceof FontStyle) && i == ((FontStyle) obj).m1644unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1641equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1642hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m1640equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1642hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1644unboximpl() {
        return this.value;
    }

    private /* synthetic */ FontStyle(int i) {
        this.value = i;
    }

    public String toString() {
        return m1643toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1643toStringimpl(int i) {
        return m1641equalsimpl0(i, Normal) ? "Normal" : m1641equalsimpl0(i, Italic) ? "Italic" : "Invalid";
    }

    /* compiled from: FontStyle.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getNormal-_-LCdwA  reason: not valid java name */
        public final int m1646getNormal_LCdwA() {
            return FontStyle.Normal;
        }

        /* renamed from: getItalic-_-LCdwA  reason: not valid java name */
        public final int m1645getItalic_LCdwA() {
            return FontStyle.Italic;
        }
    }
}
