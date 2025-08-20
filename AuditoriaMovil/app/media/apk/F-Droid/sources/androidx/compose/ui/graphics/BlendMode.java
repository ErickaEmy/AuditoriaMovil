package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: BlendMode.kt */
/* loaded from: classes.dex */
public final class BlendMode {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Clear = m795constructorimpl(0);
    private static final int Src = m795constructorimpl(1);
    private static final int Dst = m795constructorimpl(2);
    private static final int SrcOver = m795constructorimpl(3);
    private static final int DstOver = m795constructorimpl(4);
    private static final int SrcIn = m795constructorimpl(5);
    private static final int DstIn = m795constructorimpl(6);
    private static final int SrcOut = m795constructorimpl(7);
    private static final int DstOut = m795constructorimpl(8);
    private static final int SrcAtop = m795constructorimpl(9);
    private static final int DstAtop = m795constructorimpl(10);
    private static final int Xor = m795constructorimpl(11);
    private static final int Plus = m795constructorimpl(12);
    private static final int Modulate = m795constructorimpl(13);
    private static final int Screen = m795constructorimpl(14);
    private static final int Overlay = m795constructorimpl(15);
    private static final int Darken = m795constructorimpl(16);
    private static final int Lighten = m795constructorimpl(17);
    private static final int ColorDodge = m795constructorimpl(18);
    private static final int ColorBurn = m795constructorimpl(19);
    private static final int Hardlight = m795constructorimpl(20);
    private static final int Softlight = m795constructorimpl(21);
    private static final int Difference = m795constructorimpl(22);
    private static final int Exclusion = m795constructorimpl(23);
    private static final int Multiply = m795constructorimpl(24);
    private static final int Hue = m795constructorimpl(25);
    private static final int Saturation = m795constructorimpl(26);
    private static final int Color = m795constructorimpl(27);
    private static final int Luminosity = m795constructorimpl(28);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ BlendMode m794boximpl(int i) {
        return new BlendMode(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m795constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m796equalsimpl(int i, Object obj) {
        return (obj instanceof BlendMode) && i == ((BlendMode) obj).m800unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m797equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m798hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m796equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m798hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m800unboximpl() {
        return this.value;
    }

    private /* synthetic */ BlendMode(int i) {
        this.value = i;
    }

    /* compiled from: BlendMode.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getClear-0nO6VwU  reason: not valid java name */
        public final int m801getClear0nO6VwU() {
            return BlendMode.Clear;
        }

        /* renamed from: getSrc-0nO6VwU  reason: not valid java name */
        public final int m824getSrc0nO6VwU() {
            return BlendMode.Src;
        }

        /* renamed from: getDst-0nO6VwU  reason: not valid java name */
        public final int m807getDst0nO6VwU() {
            return BlendMode.Dst;
        }

        /* renamed from: getSrcOver-0nO6VwU  reason: not valid java name */
        public final int m828getSrcOver0nO6VwU() {
            return BlendMode.SrcOver;
        }

        /* renamed from: getDstOver-0nO6VwU  reason: not valid java name */
        public final int m811getDstOver0nO6VwU() {
            return BlendMode.DstOver;
        }

        /* renamed from: getSrcIn-0nO6VwU  reason: not valid java name */
        public final int m826getSrcIn0nO6VwU() {
            return BlendMode.SrcIn;
        }

        /* renamed from: getDstIn-0nO6VwU  reason: not valid java name */
        public final int m809getDstIn0nO6VwU() {
            return BlendMode.DstIn;
        }

        /* renamed from: getSrcOut-0nO6VwU  reason: not valid java name */
        public final int m827getSrcOut0nO6VwU() {
            return BlendMode.SrcOut;
        }

        /* renamed from: getDstOut-0nO6VwU  reason: not valid java name */
        public final int m810getDstOut0nO6VwU() {
            return BlendMode.DstOut;
        }

        /* renamed from: getSrcAtop-0nO6VwU  reason: not valid java name */
        public final int m825getSrcAtop0nO6VwU() {
            return BlendMode.SrcAtop;
        }

        /* renamed from: getDstAtop-0nO6VwU  reason: not valid java name */
        public final int m808getDstAtop0nO6VwU() {
            return BlendMode.DstAtop;
        }

        /* renamed from: getXor-0nO6VwU  reason: not valid java name */
        public final int m829getXor0nO6VwU() {
            return BlendMode.Xor;
        }

        /* renamed from: getPlus-0nO6VwU  reason: not valid java name */
        public final int m820getPlus0nO6VwU() {
            return BlendMode.Plus;
        }

        /* renamed from: getModulate-0nO6VwU  reason: not valid java name */
        public final int m817getModulate0nO6VwU() {
            return BlendMode.Modulate;
        }

        /* renamed from: getScreen-0nO6VwU  reason: not valid java name */
        public final int m822getScreen0nO6VwU() {
            return BlendMode.Screen;
        }

        /* renamed from: getOverlay-0nO6VwU  reason: not valid java name */
        public final int m819getOverlay0nO6VwU() {
            return BlendMode.Overlay;
        }

        /* renamed from: getDarken-0nO6VwU  reason: not valid java name */
        public final int m805getDarken0nO6VwU() {
            return BlendMode.Darken;
        }

        /* renamed from: getLighten-0nO6VwU  reason: not valid java name */
        public final int m815getLighten0nO6VwU() {
            return BlendMode.Lighten;
        }

        /* renamed from: getColorDodge-0nO6VwU  reason: not valid java name */
        public final int m804getColorDodge0nO6VwU() {
            return BlendMode.ColorDodge;
        }

        /* renamed from: getColorBurn-0nO6VwU  reason: not valid java name */
        public final int m803getColorBurn0nO6VwU() {
            return BlendMode.ColorBurn;
        }

        /* renamed from: getHardlight-0nO6VwU  reason: not valid java name */
        public final int m813getHardlight0nO6VwU() {
            return BlendMode.Hardlight;
        }

        /* renamed from: getSoftlight-0nO6VwU  reason: not valid java name */
        public final int m823getSoftlight0nO6VwU() {
            return BlendMode.Softlight;
        }

        /* renamed from: getDifference-0nO6VwU  reason: not valid java name */
        public final int m806getDifference0nO6VwU() {
            return BlendMode.Difference;
        }

        /* renamed from: getExclusion-0nO6VwU  reason: not valid java name */
        public final int m812getExclusion0nO6VwU() {
            return BlendMode.Exclusion;
        }

        /* renamed from: getMultiply-0nO6VwU  reason: not valid java name */
        public final int m818getMultiply0nO6VwU() {
            return BlendMode.Multiply;
        }

        /* renamed from: getHue-0nO6VwU  reason: not valid java name */
        public final int m814getHue0nO6VwU() {
            return BlendMode.Hue;
        }

        /* renamed from: getSaturation-0nO6VwU  reason: not valid java name */
        public final int m821getSaturation0nO6VwU() {
            return BlendMode.Saturation;
        }

        /* renamed from: getColor-0nO6VwU  reason: not valid java name */
        public final int m802getColor0nO6VwU() {
            return BlendMode.Color;
        }

        /* renamed from: getLuminosity-0nO6VwU  reason: not valid java name */
        public final int m816getLuminosity0nO6VwU() {
            return BlendMode.Luminosity;
        }
    }

    public String toString() {
        return m799toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m799toStringimpl(int i) {
        return m797equalsimpl0(i, Clear) ? "Clear" : m797equalsimpl0(i, Src) ? "Src" : m797equalsimpl0(i, Dst) ? "Dst" : m797equalsimpl0(i, SrcOver) ? "SrcOver" : m797equalsimpl0(i, DstOver) ? "DstOver" : m797equalsimpl0(i, SrcIn) ? "SrcIn" : m797equalsimpl0(i, DstIn) ? "DstIn" : m797equalsimpl0(i, SrcOut) ? "SrcOut" : m797equalsimpl0(i, DstOut) ? "DstOut" : m797equalsimpl0(i, SrcAtop) ? "SrcAtop" : m797equalsimpl0(i, DstAtop) ? "DstAtop" : m797equalsimpl0(i, Xor) ? "Xor" : m797equalsimpl0(i, Plus) ? "Plus" : m797equalsimpl0(i, Modulate) ? "Modulate" : m797equalsimpl0(i, Screen) ? "Screen" : m797equalsimpl0(i, Overlay) ? "Overlay" : m797equalsimpl0(i, Darken) ? "Darken" : m797equalsimpl0(i, Lighten) ? "Lighten" : m797equalsimpl0(i, ColorDodge) ? "ColorDodge" : m797equalsimpl0(i, ColorBurn) ? "ColorBurn" : m797equalsimpl0(i, Hardlight) ? "HardLight" : m797equalsimpl0(i, Softlight) ? "Softlight" : m797equalsimpl0(i, Difference) ? "Difference" : m797equalsimpl0(i, Exclusion) ? "Exclusion" : m797equalsimpl0(i, Multiply) ? "Multiply" : m797equalsimpl0(i, Hue) ? "Hue" : m797equalsimpl0(i, Saturation) ? "Saturation" : m797equalsimpl0(i, Color) ? "Color" : m797equalsimpl0(i, Luminosity) ? "Luminosity" : "Unknown";
    }
}
