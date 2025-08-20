package androidx.compose.ui.semantics;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: SemanticsProperties.kt */
/* loaded from: classes.dex */
public final class LiveRegionMode {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Polite = m1467constructorimpl(0);
    private static final int Assertive = m1467constructorimpl(1);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ LiveRegionMode m1466boximpl(int i) {
        return new LiveRegionMode(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m1467constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1468equalsimpl(int i, Object obj) {
        return (obj instanceof LiveRegionMode) && i == ((LiveRegionMode) obj).m1472unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1469equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1470hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m1468equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1470hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1472unboximpl() {
        return this.value;
    }

    private /* synthetic */ LiveRegionMode(int i) {
        this.value = i;
    }

    /* compiled from: SemanticsProperties.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getPolite-0phEisY  reason: not valid java name */
        public final int m1474getPolite0phEisY() {
            return LiveRegionMode.Polite;
        }

        /* renamed from: getAssertive-0phEisY  reason: not valid java name */
        public final int m1473getAssertive0phEisY() {
            return LiveRegionMode.Assertive;
        }
    }

    public String toString() {
        return m1471toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1471toStringimpl(int i) {
        return m1469equalsimpl0(i, Polite) ? "Polite" : m1469equalsimpl0(i, Assertive) ? "Assertive" : "Unknown";
    }
}
