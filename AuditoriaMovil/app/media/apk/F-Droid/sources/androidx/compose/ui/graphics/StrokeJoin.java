package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: StrokeJoin.kt */
/* loaded from: classes.dex */
public final class StrokeJoin {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Miter = m974constructorimpl(0);
    private static final int Round = m974constructorimpl(1);
    private static final int Bevel = m974constructorimpl(2);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ StrokeJoin m973boximpl(int i) {
        return new StrokeJoin(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m974constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m975equalsimpl(int i, Object obj) {
        return (obj instanceof StrokeJoin) && i == ((StrokeJoin) obj).m979unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m976equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m977hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m975equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m977hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m979unboximpl() {
        return this.value;
    }

    private /* synthetic */ StrokeJoin(int i) {
        this.value = i;
    }

    /* compiled from: StrokeJoin.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getMiter-LxFBmk8  reason: not valid java name */
        public final int m981getMiterLxFBmk8() {
            return StrokeJoin.Miter;
        }

        /* renamed from: getRound-LxFBmk8  reason: not valid java name */
        public final int m982getRoundLxFBmk8() {
            return StrokeJoin.Round;
        }

        /* renamed from: getBevel-LxFBmk8  reason: not valid java name */
        public final int m980getBevelLxFBmk8() {
            return StrokeJoin.Bevel;
        }
    }

    public String toString() {
        return m978toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m978toStringimpl(int i) {
        return m976equalsimpl0(i, Miter) ? "Miter" : m976equalsimpl0(i, Round) ? "Round" : m976equalsimpl0(i, Bevel) ? "Bevel" : "Unknown";
    }
}
