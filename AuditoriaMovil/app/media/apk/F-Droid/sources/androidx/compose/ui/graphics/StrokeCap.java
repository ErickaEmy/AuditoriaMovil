package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: StrokeCap.kt */
/* loaded from: classes.dex */
public final class StrokeCap {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Butt = m964constructorimpl(0);
    private static final int Round = m964constructorimpl(1);
    private static final int Square = m964constructorimpl(2);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ StrokeCap m963boximpl(int i) {
        return new StrokeCap(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m964constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m965equalsimpl(int i, Object obj) {
        return (obj instanceof StrokeCap) && i == ((StrokeCap) obj).m969unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m966equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m967hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m965equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m967hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m969unboximpl() {
        return this.value;
    }

    private /* synthetic */ StrokeCap(int i) {
        this.value = i;
    }

    /* compiled from: StrokeCap.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getButt-KaPHkGw  reason: not valid java name */
        public final int m970getButtKaPHkGw() {
            return StrokeCap.Butt;
        }

        /* renamed from: getRound-KaPHkGw  reason: not valid java name */
        public final int m971getRoundKaPHkGw() {
            return StrokeCap.Round;
        }

        /* renamed from: getSquare-KaPHkGw  reason: not valid java name */
        public final int m972getSquareKaPHkGw() {
            return StrokeCap.Square;
        }
    }

    public String toString() {
        return m968toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m968toStringimpl(int i) {
        return m966equalsimpl0(i, Butt) ? "Butt" : m966equalsimpl0(i, Round) ? "Round" : m966equalsimpl0(i, Square) ? "Square" : "Unknown";
    }
}
