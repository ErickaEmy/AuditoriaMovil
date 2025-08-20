package androidx.compose.ui.text.style;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: LineBreak.android.kt */
/* loaded from: classes.dex */
public final class LineBreak {
    public static final Companion Companion = new Companion(null);
    private static final int Heading;
    private static final int Paragraph;
    private static final int Simple;
    private final int mask;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ LineBreak m1762boximpl(int i) {
        return new LineBreak(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m1763constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1765equalsimpl(int i, Object obj) {
        return (obj instanceof LineBreak) && i == ((LineBreak) obj).m1771unboximpl();
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1769hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m1765equalsimpl(this.mask, obj);
    }

    public int hashCode() {
        return m1769hashCodeimpl(this.mask);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1771unboximpl() {
        return this.mask;
    }

    private /* synthetic */ LineBreak(int i) {
        this.mask = i;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1764constructorimpl(int i, int i2, int i3) {
        int packBytes;
        packBytes = LineBreak_androidKt.packBytes(i, i2, i3);
        return m1763constructorimpl(packBytes);
    }

    /* renamed from: getStrategy-fcGXIks  reason: not valid java name */
    public static final int m1766getStrategyfcGXIks(int i) {
        int unpackByte1;
        unpackByte1 = LineBreak_androidKt.unpackByte1(i);
        return Strategy.m1774constructorimpl(unpackByte1);
    }

    /* renamed from: getStrictness-usljTpc  reason: not valid java name */
    public static final int m1767getStrictnessusljTpc(int i) {
        int unpackByte2;
        unpackByte2 = LineBreak_androidKt.unpackByte2(i);
        return Strictness.m1784constructorimpl(unpackByte2);
    }

    /* renamed from: getWordBreak-jp8hJ3c  reason: not valid java name */
    public static final int m1768getWordBreakjp8hJ3c(int i) {
        int unpackByte3;
        unpackByte3 = LineBreak_androidKt.unpackByte3(i);
        return WordBreak.m1795constructorimpl(unpackByte3);
    }

    public String toString() {
        return m1770toStringimpl(this.mask);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1770toStringimpl(int i) {
        return "LineBreak(strategy=" + ((Object) Strategy.m1778toStringimpl(m1766getStrategyfcGXIks(i))) + ", strictness=" + ((Object) Strictness.m1788toStringimpl(m1767getStrictnessusljTpc(i))) + ", wordBreak=" + ((Object) WordBreak.m1799toStringimpl(m1768getWordBreakjp8hJ3c(i))) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* compiled from: LineBreak.android.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getSimple-rAG3T2k  reason: not valid java name */
        public final int m1772getSimplerAG3T2k() {
            return LineBreak.Simple;
        }
    }

    static {
        Strategy.Companion companion = Strategy.Companion;
        int m1782getSimplefcGXIks = companion.m1782getSimplefcGXIks();
        Strictness.Companion companion2 = Strictness.Companion;
        int m1792getNormalusljTpc = companion2.m1792getNormalusljTpc();
        WordBreak.Companion companion3 = WordBreak.Companion;
        Simple = m1764constructorimpl(m1782getSimplefcGXIks, m1792getNormalusljTpc, companion3.m1801getDefaultjp8hJ3c());
        Heading = m1764constructorimpl(companion.m1780getBalancedfcGXIks(), companion2.m1791getLooseusljTpc(), companion3.m1802getPhrasejp8hJ3c());
        Paragraph = m1764constructorimpl(companion.m1781getHighQualityfcGXIks(), companion2.m1793getStrictusljTpc(), companion3.m1801getDefaultjp8hJ3c());
    }

    /* compiled from: LineBreak.android.kt */
    /* loaded from: classes.dex */
    public static final class Strategy {
        private final int value;
        public static final Companion Companion = new Companion(null);
        private static final int Simple = m1774constructorimpl(1);
        private static final int HighQuality = m1774constructorimpl(2);
        private static final int Balanced = m1774constructorimpl(3);

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Strategy m1773boximpl(int i) {
            return new Strategy(i);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static int m1774constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m1775equalsimpl(int i, Object obj) {
            return (obj instanceof Strategy) && i == ((Strategy) obj).m1779unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m1776equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m1777hashCodeimpl(int i) {
            return i;
        }

        public boolean equals(Object obj) {
            return m1775equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m1777hashCodeimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m1779unboximpl() {
            return this.value;
        }

        private /* synthetic */ Strategy(int i) {
            this.value = i;
        }

        /* compiled from: LineBreak.android.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getSimple-fcGXIks  reason: not valid java name */
            public final int m1782getSimplefcGXIks() {
                return Strategy.Simple;
            }

            /* renamed from: getHighQuality-fcGXIks  reason: not valid java name */
            public final int m1781getHighQualityfcGXIks() {
                return Strategy.HighQuality;
            }

            /* renamed from: getBalanced-fcGXIks  reason: not valid java name */
            public final int m1780getBalancedfcGXIks() {
                return Strategy.Balanced;
            }
        }

        public String toString() {
            return m1778toStringimpl(this.value);
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m1778toStringimpl(int i) {
            return m1776equalsimpl0(i, Simple) ? "Strategy.Simple" : m1776equalsimpl0(i, HighQuality) ? "Strategy.HighQuality" : m1776equalsimpl0(i, Balanced) ? "Strategy.Balanced" : "Invalid";
        }
    }

    /* compiled from: LineBreak.android.kt */
    /* loaded from: classes.dex */
    public static final class Strictness {
        public static final Companion Companion = new Companion(null);
        private static final int Default = m1784constructorimpl(1);
        private static final int Loose = m1784constructorimpl(2);
        private static final int Normal = m1784constructorimpl(3);
        private static final int Strict = m1784constructorimpl(4);
        private final int value;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Strictness m1783boximpl(int i) {
            return new Strictness(i);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static int m1784constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m1785equalsimpl(int i, Object obj) {
            return (obj instanceof Strictness) && i == ((Strictness) obj).m1789unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m1786equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m1787hashCodeimpl(int i) {
            return i;
        }

        public boolean equals(Object obj) {
            return m1785equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m1787hashCodeimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m1789unboximpl() {
            return this.value;
        }

        private /* synthetic */ Strictness(int i) {
            this.value = i;
        }

        /* compiled from: LineBreak.android.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getDefault-usljTpc  reason: not valid java name */
            public final int m1790getDefaultusljTpc() {
                return Strictness.Default;
            }

            /* renamed from: getLoose-usljTpc  reason: not valid java name */
            public final int m1791getLooseusljTpc() {
                return Strictness.Loose;
            }

            /* renamed from: getNormal-usljTpc  reason: not valid java name */
            public final int m1792getNormalusljTpc() {
                return Strictness.Normal;
            }

            /* renamed from: getStrict-usljTpc  reason: not valid java name */
            public final int m1793getStrictusljTpc() {
                return Strictness.Strict;
            }
        }

        public String toString() {
            return m1788toStringimpl(this.value);
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m1788toStringimpl(int i) {
            return m1786equalsimpl0(i, Default) ? "Strictness.None" : m1786equalsimpl0(i, Loose) ? "Strictness.Loose" : m1786equalsimpl0(i, Normal) ? "Strictness.Normal" : m1786equalsimpl0(i, Strict) ? "Strictness.Strict" : "Invalid";
        }
    }

    /* compiled from: LineBreak.android.kt */
    /* loaded from: classes.dex */
    public static final class WordBreak {
        public static final Companion Companion = new Companion(null);
        private static final int Default = m1795constructorimpl(1);
        private static final int Phrase = m1795constructorimpl(2);
        private final int value;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ WordBreak m1794boximpl(int i) {
            return new WordBreak(i);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static int m1795constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m1796equalsimpl(int i, Object obj) {
            return (obj instanceof WordBreak) && i == ((WordBreak) obj).m1800unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m1797equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m1798hashCodeimpl(int i) {
            return i;
        }

        public boolean equals(Object obj) {
            return m1796equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m1798hashCodeimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m1800unboximpl() {
            return this.value;
        }

        private /* synthetic */ WordBreak(int i) {
            this.value = i;
        }

        /* compiled from: LineBreak.android.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getDefault-jp8hJ3c  reason: not valid java name */
            public final int m1801getDefaultjp8hJ3c() {
                return WordBreak.Default;
            }

            /* renamed from: getPhrase-jp8hJ3c  reason: not valid java name */
            public final int m1802getPhrasejp8hJ3c() {
                return WordBreak.Phrase;
            }
        }

        public String toString() {
            return m1799toStringimpl(this.value);
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m1799toStringimpl(int i) {
            return m1797equalsimpl0(i, Default) ? "WordBreak.None" : m1797equalsimpl0(i, Phrase) ? "WordBreak.Phrase" : "Invalid";
        }
    }
}
