package kotlin.time;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import org.fdroid.fdroid.Preferences;
/* compiled from: Duration.kt */
/* loaded from: classes2.dex */
public final class Duration implements Comparable {
    private static final long INFINITE;
    private static final long NEG_INFINITE;
    private final long rawValue;
    public static final Companion Companion = new Companion(null);
    private static final long ZERO = m2235constructorimpl(0);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Duration m2233boximpl(long j) {
        return new Duration(j);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2236equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).m2260unboximpl();
    }

    /* renamed from: getValue-impl  reason: not valid java name */
    private static final long m2247getValueimpl(long j) {
        return j >> 1;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2248hashCodeimpl(long j) {
        return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(j);
    }

    /* renamed from: isInMillis-impl  reason: not valid java name */
    private static final boolean m2250isInMillisimpl(long j) {
        return (((int) j) & 1) == 1;
    }

    /* renamed from: isInNanos-impl  reason: not valid java name */
    private static final boolean m2251isInNanosimpl(long j) {
        return (((int) j) & 1) == 0;
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m2252isInfiniteimpl(long j) {
        return j == INFINITE || j == NEG_INFINITE;
    }

    /* renamed from: isNegative-impl  reason: not valid java name */
    public static final boolean m2253isNegativeimpl(long j) {
        return j < 0;
    }

    public boolean equals(Object obj) {
        return m2236equalsimpl(this.rawValue, obj);
    }

    public int hashCode() {
        return m2248hashCodeimpl(this.rawValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m2260unboximpl() {
        return this.rawValue;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return m2259compareToLRDsOJo(((Duration) obj).m2260unboximpl());
    }

    private /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    /* renamed from: getStorageUnit-impl  reason: not valid java name */
    private static final DurationUnit m2246getStorageUnitimpl(long j) {
        return m2251isInNanosimpl(j) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m2235constructorimpl(long j) {
        if (DurationJvmKt.getDurationAssertionsEnabled()) {
            if (m2251isInNanosimpl(j)) {
                if (!new LongRange(-4611686018426999999L, 4611686018426999999L).contains(m2247getValueimpl(j))) {
                    throw new AssertionError(m2247getValueimpl(j) + " ns is out of nanoseconds range");
                }
            } else if (!new LongRange(-4611686018427387903L, 4611686018427387903L).contains(m2247getValueimpl(j))) {
                throw new AssertionError(m2247getValueimpl(j) + " ms is out of milliseconds range");
            } else if (new LongRange(-4611686018426L, 4611686018426L).contains(m2247getValueimpl(j))) {
                throw new AssertionError(m2247getValueimpl(j) + " ms is denormalized");
            }
        }
        return j;
    }

    /* compiled from: Duration.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZERO-UwyO8pc  reason: not valid java name */
        public final long m2262getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        /* renamed from: getINFINITE-UwyO8pc  reason: not valid java name */
        public final long m2261getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* renamed from: parseIsoString-UwyO8pc  reason: not valid java name */
        public final long m2263parseIsoStringUwyO8pc(String value) {
            long parseDuration;
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                parseDuration = DurationKt.parseDuration(value, true);
                return parseDuration;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }
    }

    static {
        long durationOfMillis;
        long durationOfMillis2;
        durationOfMillis = DurationKt.durationOfMillis(4611686018427387903L);
        INFINITE = durationOfMillis;
        durationOfMillis2 = DurationKt.durationOfMillis(-4611686018427387903L);
        NEG_INFINITE = durationOfMillis2;
    }

    /* renamed from: unaryMinus-UwyO8pc  reason: not valid java name */
    public static final long m2258unaryMinusUwyO8pc(long j) {
        long durationOf;
        durationOf = DurationKt.durationOf(-m2247getValueimpl(j), ((int) j) & 1);
        return durationOf;
    }

    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public static final long m2254plusLRDsOJo(long j, long j2) {
        long durationOfMillisNormalized;
        long durationOfNanosNormalized;
        if (m2252isInfiniteimpl(j)) {
            if (m2249isFiniteimpl(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        } else if (m2252isInfiniteimpl(j2)) {
            return j2;
        } else {
            if ((((int) j) & 1) == (((int) j2) & 1)) {
                long m2247getValueimpl = m2247getValueimpl(j) + m2247getValueimpl(j2);
                if (m2251isInNanosimpl(j)) {
                    durationOfNanosNormalized = DurationKt.durationOfNanosNormalized(m2247getValueimpl);
                    return durationOfNanosNormalized;
                }
                durationOfMillisNormalized = DurationKt.durationOfMillisNormalized(m2247getValueimpl);
                return durationOfMillisNormalized;
            } else if (m2250isInMillisimpl(j)) {
                return m2231addValuesMixedRangesUwyO8pc(j, m2247getValueimpl(j), m2247getValueimpl(j2));
            } else {
                return m2231addValuesMixedRangesUwyO8pc(j, m2247getValueimpl(j2), m2247getValueimpl(j));
            }
        }
    }

    /* renamed from: addValuesMixedRanges-UwyO8pc  reason: not valid java name */
    private static final long m2231addValuesMixedRangesUwyO8pc(long j, long j2, long j3) {
        long nanosToMillis;
        long coerceIn;
        long durationOfMillis;
        long millisToNanos;
        long millisToNanos2;
        long durationOfNanos;
        nanosToMillis = DurationKt.nanosToMillis(j3);
        long j4 = j2 + nanosToMillis;
        if (new LongRange(-4611686018426L, 4611686018426L).contains(j4)) {
            millisToNanos = DurationKt.millisToNanos(nanosToMillis);
            long j5 = j3 - millisToNanos;
            millisToNanos2 = DurationKt.millisToNanos(j4);
            durationOfNanos = DurationKt.durationOfNanos(millisToNanos2 + j5);
            return durationOfNanos;
        }
        coerceIn = RangesKt___RangesKt.coerceIn(j4, -4611686018427387903L, 4611686018427387903L);
        durationOfMillis = DurationKt.durationOfMillis(coerceIn);
        return durationOfMillis;
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m2249isFiniteimpl(long j) {
        return !m2252isInfiniteimpl(j);
    }

    /* renamed from: getAbsoluteValue-UwyO8pc  reason: not valid java name */
    public static final long m2237getAbsoluteValueUwyO8pc(long j) {
        return m2253isNegativeimpl(j) ? m2258unaryMinusUwyO8pc(j) : j;
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public int m2259compareToLRDsOJo(long j) {
        return m2234compareToLRDsOJo(this.rawValue, j);
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public static int m2234compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return Intrinsics.compare(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m2253isNegativeimpl(j) ? -i : i;
    }

    /* renamed from: getHoursComponent-impl  reason: not valid java name */
    public static final int m2238getHoursComponentimpl(long j) {
        if (m2252isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m2240getInWholeHoursimpl(j) % 24);
    }

    /* renamed from: getMinutesComponent-impl  reason: not valid java name */
    public static final int m2243getMinutesComponentimpl(long j) {
        if (m2252isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m2241getInWholeMinutesimpl(j) % 60);
    }

    /* renamed from: getSecondsComponent-impl  reason: not valid java name */
    public static final int m2245getSecondsComponentimpl(long j) {
        if (m2252isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m2242getInWholeSecondsimpl(j) % 60);
    }

    /* renamed from: getNanosecondsComponent-impl  reason: not valid java name */
    public static final int m2244getNanosecondsComponentimpl(long j) {
        long m2247getValueimpl;
        if (m2252isInfiniteimpl(j)) {
            return 0;
        }
        if (m2250isInMillisimpl(j)) {
            m2247getValueimpl = DurationKt.millisToNanos(m2247getValueimpl(j) % 1000);
        } else {
            m2247getValueimpl = m2247getValueimpl(j) % 1000000000;
        }
        return (int) m2247getValueimpl;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m2256toLongimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Preferences.UPDATE_INTERVAL_DISABLED;
        }
        if (j == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m2247getValueimpl(j), m2246getStorageUnitimpl(j), unit);
    }

    /* renamed from: getInWholeDays-impl  reason: not valid java name */
    public static final long m2239getInWholeDaysimpl(long j) {
        return m2256toLongimpl(j, DurationUnit.DAYS);
    }

    /* renamed from: getInWholeHours-impl  reason: not valid java name */
    public static final long m2240getInWholeHoursimpl(long j) {
        return m2256toLongimpl(j, DurationUnit.HOURS);
    }

    /* renamed from: getInWholeMinutes-impl  reason: not valid java name */
    public static final long m2241getInWholeMinutesimpl(long j) {
        return m2256toLongimpl(j, DurationUnit.MINUTES);
    }

    /* renamed from: getInWholeSeconds-impl  reason: not valid java name */
    public static final long m2242getInWholeSecondsimpl(long j) {
        return m2256toLongimpl(j, DurationUnit.SECONDS);
    }

    public String toString() {
        return m2257toStringimpl(this.rawValue);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2257toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == INFINITE) {
            return "Infinity";
        }
        if (j == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean m2253isNegativeimpl = m2253isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (m2253isNegativeimpl) {
            sb.append(CoreConstants.DASH_CHAR);
        }
        long m2237getAbsoluteValueUwyO8pc = m2237getAbsoluteValueUwyO8pc(j);
        long m2239getInWholeDaysimpl = m2239getInWholeDaysimpl(m2237getAbsoluteValueUwyO8pc);
        int m2238getHoursComponentimpl = m2238getHoursComponentimpl(m2237getAbsoluteValueUwyO8pc);
        int m2243getMinutesComponentimpl = m2243getMinutesComponentimpl(m2237getAbsoluteValueUwyO8pc);
        int m2245getSecondsComponentimpl = m2245getSecondsComponentimpl(m2237getAbsoluteValueUwyO8pc);
        int m2244getNanosecondsComponentimpl = m2244getNanosecondsComponentimpl(m2237getAbsoluteValueUwyO8pc);
        int i = 0;
        boolean z = m2239getInWholeDaysimpl != 0;
        boolean z2 = m2238getHoursComponentimpl != 0;
        boolean z3 = m2243getMinutesComponentimpl != 0;
        boolean z4 = (m2245getSecondsComponentimpl == 0 && m2244getNanosecondsComponentimpl == 0) ? false : true;
        if (z) {
            sb.append(m2239getInWholeDaysimpl);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(m2238getHoursComponentimpl);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(m2243getMinutesComponentimpl);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (m2245getSecondsComponentimpl != 0 || z || z2 || z3) {
                m2232appendFractionalimpl(j, sb, m2245getSecondsComponentimpl, m2244getNanosecondsComponentimpl, 9, "s", false);
            } else if (m2244getNanosecondsComponentimpl >= 1000000) {
                m2232appendFractionalimpl(j, sb, m2244getNanosecondsComponentimpl / 1000000, m2244getNanosecondsComponentimpl % 1000000, 6, "ms", false);
            } else if (m2244getNanosecondsComponentimpl >= 1000) {
                m2232appendFractionalimpl(j, sb, m2244getNanosecondsComponentimpl / 1000, m2244getNanosecondsComponentimpl % 1000, 3, "us", false);
            } else {
                sb.append(m2244getNanosecondsComponentimpl);
                sb.append("ns");
            }
            i = i4;
        }
        if (m2253isNegativeimpl && i > 1) {
            sb.insert(1, CoreConstants.LEFT_PARENTHESIS_CHAR).append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* renamed from: appendFractional-impl  reason: not valid java name */
    private static final void m2232appendFractionalimpl(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        String padStart;
        sb.append(i);
        if (i2 != 0) {
            sb.append(CoreConstants.DOT);
            padStart = StringsKt__StringsKt.padStart(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = padStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (padStart.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (!z && i6 < 3) {
                sb.append((CharSequence) padStart, 0, i6);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            } else {
                sb.append((CharSequence) padStart, 0, ((i4 + 3) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    /* renamed from: toIsoString-impl  reason: not valid java name */
    public static final String m2255toIsoStringimpl(long j) {
        StringBuilder sb = new StringBuilder();
        if (m2253isNegativeimpl(j)) {
            sb.append(CoreConstants.DASH_CHAR);
        }
        sb.append("PT");
        long m2237getAbsoluteValueUwyO8pc = m2237getAbsoluteValueUwyO8pc(j);
        long m2240getInWholeHoursimpl = m2240getInWholeHoursimpl(m2237getAbsoluteValueUwyO8pc);
        int m2243getMinutesComponentimpl = m2243getMinutesComponentimpl(m2237getAbsoluteValueUwyO8pc);
        int m2245getSecondsComponentimpl = m2245getSecondsComponentimpl(m2237getAbsoluteValueUwyO8pc);
        int m2244getNanosecondsComponentimpl = m2244getNanosecondsComponentimpl(m2237getAbsoluteValueUwyO8pc);
        if (m2252isInfiniteimpl(j)) {
            m2240getInWholeHoursimpl = 9999999999999L;
        }
        boolean z = false;
        boolean z2 = m2240getInWholeHoursimpl != 0;
        boolean z3 = (m2245getSecondsComponentimpl == 0 && m2244getNanosecondsComponentimpl == 0) ? false : true;
        if (m2243getMinutesComponentimpl != 0 || (z3 && z2)) {
            z = true;
        }
        if (z2) {
            sb.append(m2240getInWholeHoursimpl);
            sb.append('H');
        }
        if (z) {
            sb.append(m2243getMinutesComponentimpl);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            m2232appendFractionalimpl(j, sb, m2245getSecondsComponentimpl, m2244getNanosecondsComponentimpl, 9, "S", true);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
