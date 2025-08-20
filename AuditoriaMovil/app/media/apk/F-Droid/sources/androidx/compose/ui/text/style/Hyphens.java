package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Hyphens.kt */
/* loaded from: classes.dex */
public final class Hyphens {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int None = m1754constructorimpl(1);
    private static final int Auto = m1754constructorimpl(2);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Hyphens m1753boximpl(int i) {
        return new Hyphens(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m1754constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1755equalsimpl(int i, Object obj) {
        return (obj instanceof Hyphens) && i == ((Hyphens) obj).m1759unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1756equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1757hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m1755equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1757hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1759unboximpl() {
        return this.value;
    }

    private /* synthetic */ Hyphens(int i) {
        this.value = i;
    }

    /* compiled from: Hyphens.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getNone-vmbZdU8  reason: not valid java name */
        public final int m1761getNonevmbZdU8() {
            return Hyphens.None;
        }

        /* renamed from: getAuto-vmbZdU8  reason: not valid java name */
        public final int m1760getAutovmbZdU8() {
            return Hyphens.Auto;
        }
    }

    public String toString() {
        return m1758toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1758toStringimpl(int i) {
        return m1756equalsimpl0(i, None) ? "Hyphens.None" : m1756equalsimpl0(i, Auto) ? "Hyphens.Auto" : "Invalid";
    }
}
