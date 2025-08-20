package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: PathFillType.kt */
/* loaded from: classes.dex */
public final class PathFillType {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int NonZero = m934constructorimpl(0);
    private static final int EvenOdd = m934constructorimpl(1);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ PathFillType m933boximpl(int i) {
        return new PathFillType(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m934constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m935equalsimpl(int i, Object obj) {
        return (obj instanceof PathFillType) && i == ((PathFillType) obj).m939unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m936equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m937hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m935equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m937hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m939unboximpl() {
        return this.value;
    }

    private /* synthetic */ PathFillType(int i) {
        this.value = i;
    }

    /* compiled from: PathFillType.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getNonZero-Rg-k1Os  reason: not valid java name */
        public final int m941getNonZeroRgk1Os() {
            return PathFillType.NonZero;
        }

        /* renamed from: getEvenOdd-Rg-k1Os  reason: not valid java name */
        public final int m940getEvenOddRgk1Os() {
            return PathFillType.EvenOdd;
        }
    }

    public String toString() {
        return m938toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m938toStringimpl(int i) {
        return m936equalsimpl0(i, NonZero) ? "NonZero" : m936equalsimpl0(i, EvenOdd) ? "EvenOdd" : "Unknown";
    }
}
