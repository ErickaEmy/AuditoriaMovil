package androidx.compose.ui.unit;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Dp.kt */
/* loaded from: classes.dex */
public final class Dp implements Comparable {
    public static final Companion Companion = new Companion(null);
    private static final float Hairline = m1897constructorimpl(0.0f);
    private static final float Infinity = m1897constructorimpl(Float.POSITIVE_INFINITY);
    private static final float Unspecified = m1897constructorimpl(Float.NaN);
    private final float value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Dp m1895boximpl(float f) {
        return new Dp(f);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static float m1897constructorimpl(float f) {
        return f;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1898equalsimpl(float f, Object obj) {
        return (obj instanceof Dp) && Float.compare(f, ((Dp) obj).m1903unboximpl()) == 0;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1899equalsimpl0(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1900hashCodeimpl(float f) {
        return Float.floatToIntBits(f);
    }

    public boolean equals(Object obj) {
        return m1898equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1900hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ float m1903unboximpl() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return m1902compareTo0680j_4(((Dp) obj).m1903unboximpl());
    }

    private /* synthetic */ Dp(float f) {
        this.value = f;
    }

    /* renamed from: compareTo-0680j_4  reason: not valid java name */
    public static int m1896compareTo0680j_4(float f, float f2) {
        return Float.compare(f, f2);
    }

    /* renamed from: compareTo-0680j_4  reason: not valid java name */
    public int m1902compareTo0680j_4(float f) {
        return m1896compareTo0680j_4(this.value, f);
    }

    public String toString() {
        return m1901toStringimpl(this.value);
    }

    /* compiled from: Dp.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getHairline-D9Ej5fM  reason: not valid java name */
        public final float m1904getHairlineD9Ej5fM() {
            return Dp.Hairline;
        }

        /* renamed from: getUnspecified-D9Ej5fM  reason: not valid java name */
        public final float m1905getUnspecifiedD9Ej5fM() {
            return Dp.Unspecified;
        }
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1901toStringimpl(float f) {
        if (Float.isNaN(f)) {
            return "Dp.Unspecified";
        }
        return f + ".dp";
    }
}
