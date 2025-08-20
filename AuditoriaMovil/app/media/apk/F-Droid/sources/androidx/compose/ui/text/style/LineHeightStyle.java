package androidx.compose.ui.text.style;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: LineHeightStyle.kt */
/* loaded from: classes.dex */
public final class LineHeightStyle {
    public static final Companion Companion = new Companion(null);
    private static final LineHeightStyle Default = new LineHeightStyle(Alignment.Companion.m1809getProportionalPIaL0Z0(), Trim.Companion.m1816getBothEVpEnUU(), null);
    private final float alignment;
    private final int trim;

    public /* synthetic */ LineHeightStyle(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, i);
    }

    /* renamed from: getAlignment-PIaL0Z0  reason: not valid java name */
    public final float m1803getAlignmentPIaL0Z0() {
        return this.alignment;
    }

    /* renamed from: getTrim-EVpEnUU  reason: not valid java name */
    public final int m1804getTrimEVpEnUU() {
        return this.trim;
    }

    private LineHeightStyle(float f, int i) {
        this.alignment = f;
        this.trim = i;
    }

    /* compiled from: LineHeightStyle.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LineHeightStyle getDefault() {
            return LineHeightStyle.Default;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LineHeightStyle) {
            LineHeightStyle lineHeightStyle = (LineHeightStyle) obj;
            return Alignment.m1806equalsimpl0(this.alignment, lineHeightStyle.alignment) && Trim.m1811equalsimpl0(this.trim, lineHeightStyle.trim);
        }
        return false;
    }

    public int hashCode() {
        return (Alignment.m1807hashCodeimpl(this.alignment) * 31) + Trim.m1812hashCodeimpl(this.trim);
    }

    public String toString() {
        return "LineHeightStyle(alignment=" + ((Object) Alignment.m1808toStringimpl(this.alignment)) + ", trim=" + ((Object) Trim.m1815toStringimpl(this.trim)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* compiled from: LineHeightStyle.kt */
    /* loaded from: classes.dex */
    public static final class Trim {
        public static final Companion Companion = new Companion(null);
        private static final int FirstLineTop = m1810constructorimpl(1);
        private static final int LastLineBottom = m1810constructorimpl(16);
        private static final int Both = m1810constructorimpl(17);
        private static final int None = m1810constructorimpl(0);

        /* renamed from: constructor-impl  reason: not valid java name */
        private static int m1810constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m1811equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m1812hashCodeimpl(int i) {
            return i;
        }

        /* renamed from: isTrimFirstLineTop-impl$ui_text_release  reason: not valid java name */
        public static final boolean m1813isTrimFirstLineTopimpl$ui_text_release(int i) {
            return (i & 1) > 0;
        }

        /* renamed from: isTrimLastLineBottom-impl$ui_text_release  reason: not valid java name */
        public static final boolean m1814isTrimLastLineBottomimpl$ui_text_release(int i) {
            return (i & 16) > 0;
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m1815toStringimpl(int i) {
            return i == FirstLineTop ? "LineHeightStyle.Trim.FirstLineTop" : i == LastLineBottom ? "LineHeightStyle.Trim.LastLineBottom" : i == Both ? "LineHeightStyle.Trim.Both" : i == None ? "LineHeightStyle.Trim.None" : "Invalid";
        }

        /* compiled from: LineHeightStyle.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getBoth-EVpEnUU  reason: not valid java name */
            public final int m1816getBothEVpEnUU() {
                return Trim.Both;
            }
        }
    }

    /* compiled from: LineHeightStyle.kt */
    /* loaded from: classes.dex */
    public static final class Alignment {
        public static final Companion Companion = new Companion(null);
        private static final float Top = m1805constructorimpl(0.0f);
        private static final float Center = m1805constructorimpl(0.5f);
        private static final float Proportional = m1805constructorimpl(-1.0f);
        private static final float Bottom = m1805constructorimpl(1.0f);

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m1806equalsimpl0(float f, float f2) {
            return Float.compare(f, f2) == 0;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m1807hashCodeimpl(float f) {
            return Float.floatToIntBits(f);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static float m1805constructorimpl(float f) {
            if ((0.0f > f || f > 1.0f) && f != -1.0f) {
                throw new IllegalStateException("topRatio should be in [0..1] range or -1".toString());
            }
            return f;
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m1808toStringimpl(float f) {
            if (f == Top) {
                return "LineHeightStyle.Alignment.Top";
            }
            if (f == Center) {
                return "LineHeightStyle.Alignment.Center";
            }
            if (f == Proportional) {
                return "LineHeightStyle.Alignment.Proportional";
            }
            if (f == Bottom) {
                return "LineHeightStyle.Alignment.Bottom";
            }
            return "LineHeightStyle.Alignment(topPercentage = " + f + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* compiled from: LineHeightStyle.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getProportional-PIaL0Z0  reason: not valid java name */
            public final float m1809getProportionalPIaL0Z0() {
                return Alignment.Proportional;
            }
        }
    }
}
