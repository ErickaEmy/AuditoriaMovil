package kotlin.time;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import yc.gv;
/* loaded from: classes.dex */
public final class Duration implements Comparable<Duration> {
    public static final Companion Companion = new Companion(null);
    private static final long ZERO = m41constructorimpl(0);
    private static final long INFINITE = DurationKt.access$durationOfMillis(4611686018427387903L);
    private static final long NEG_INFINITE = DurationKt.access$durationOfMillis(-4611686018427387903L);

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getINFINITE-UwyO8pc  reason: not valid java name */
        public final long m64getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib  reason: not valid java name */
        public final long m65getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        /* renamed from: getZERO-UwyO8pc  reason: not valid java name */
        public final long m66getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        private Companion() {
        }
    }

    /* renamed from: addValuesMixedRanges-UwyO8pc  reason: not valid java name */
    private static final long m38addValuesMixedRangesUwyO8pc(long j2, long j4, long j6) {
        long access$nanosToMillis = DurationKt.access$nanosToMillis(j6);
        long j7 = j4 + access$nanosToMillis;
        if (new LongRange(-4611686018426L, 4611686018426L).contains(j7)) {
            return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(j7) + (j6 - DurationKt.access$millisToNanos(access$nanosToMillis)));
        }
        return DurationKt.access$durationOfMillis(RangesKt.coerceIn(j7, -4611686018427387903L, 4611686018427387903L));
    }

    /* renamed from: appendFractional-impl  reason: not valid java name */
    private static final void m39appendFractionalimpl(long j2, StringBuilder sb, int i, int i5, int i6, String str, boolean z2) {
        sb.append(i);
        if (i5 != 0) {
            sb.append('.');
            String padStart = StringsKt.padStart(String.valueOf(i5), i6, '0');
            int i8 = -1;
            int length = padStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i10 = length - 1;
                    if (padStart.charAt(length) != '0') {
                        i8 = length;
                        break;
                    } else if (i10 < 0) {
                        break;
                    } else {
                        length = i10;
                    }
                }
            }
            int i11 = i8 + 1;
            if (!z2 && i11 < 3) {
                sb.append((CharSequence) padStart, 0, i11);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            } else {
                sb.append((CharSequence) padStart, 0, ((i8 + 3) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public static int m40compareToLRDsOJo(long j2, long j4) {
        long j6 = j2 ^ j4;
        if (j6 >= 0 && (((int) j6) & 1) != 0) {
            int i = (((int) j2) & 1) - (((int) j4) & 1);
            if (m59isNegativeimpl(j2)) {
                return -i;
            }
            return i;
        }
        return Intrinsics.compare(j2, j4);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m41constructorimpl(long j2) {
        if (DurationJvmKt.getDurationAssertionsEnabled()) {
            if (m57isInNanosimpl(j2)) {
                if (!new LongRange(-4611686018426999999L, 4611686018426999999L).contains(m53getValueimpl(j2))) {
                    throw new AssertionError(m53getValueimpl(j2) + " ns is out of nanoseconds range");
                }
            } else if (new LongRange(-4611686018427387903L, 4611686018427387903L).contains(m53getValueimpl(j2))) {
                if (new LongRange(-4611686018426L, 4611686018426L).contains(m53getValueimpl(j2))) {
                    throw new AssertionError(m53getValueimpl(j2) + " ms is denormalized");
                }
            } else {
                throw new AssertionError(m53getValueimpl(j2) + " ms is out of milliseconds range");
            }
        }
        return j2;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m42equalsimpl0(long j2, long j4) {
        return j2 == j4;
    }

    /* renamed from: getAbsoluteValue-UwyO8pc  reason: not valid java name */
    public static final long m43getAbsoluteValueUwyO8pc(long j2) {
        if (m59isNegativeimpl(j2)) {
            return m63unaryMinusUwyO8pc(j2);
        }
        return j2;
    }

    /* renamed from: getHoursComponent-impl  reason: not valid java name */
    public static final int m44getHoursComponentimpl(long j2) {
        if (m58isInfiniteimpl(j2)) {
            return 0;
        }
        return (int) (m46getInWholeHoursimpl(j2) % 24);
    }

    /* renamed from: getInWholeDays-impl  reason: not valid java name */
    public static final long m45getInWholeDaysimpl(long j2) {
        return m61toLongimpl(j2, DurationUnit.DAYS);
    }

    /* renamed from: getInWholeHours-impl  reason: not valid java name */
    public static final long m46getInWholeHoursimpl(long j2) {
        return m61toLongimpl(j2, DurationUnit.HOURS);
    }

    /* renamed from: getInWholeMinutes-impl  reason: not valid java name */
    public static final long m47getInWholeMinutesimpl(long j2) {
        return m61toLongimpl(j2, DurationUnit.MINUTES);
    }

    /* renamed from: getInWholeSeconds-impl  reason: not valid java name */
    public static final long m48getInWholeSecondsimpl(long j2) {
        return m61toLongimpl(j2, DurationUnit.SECONDS);
    }

    /* renamed from: getMinutesComponent-impl  reason: not valid java name */
    public static final int m49getMinutesComponentimpl(long j2) {
        if (m58isInfiniteimpl(j2)) {
            return 0;
        }
        return (int) (m47getInWholeMinutesimpl(j2) % 60);
    }

    /* renamed from: getNanosecondsComponent-impl  reason: not valid java name */
    public static final int m50getNanosecondsComponentimpl(long j2) {
        long m53getValueimpl;
        if (m58isInfiniteimpl(j2)) {
            return 0;
        }
        if (m56isInMillisimpl(j2)) {
            m53getValueimpl = DurationKt.access$millisToNanos(m53getValueimpl(j2) % 1000);
        } else {
            m53getValueimpl = m53getValueimpl(j2) % 1000000000;
        }
        return (int) m53getValueimpl;
    }

    /* renamed from: getSecondsComponent-impl  reason: not valid java name */
    public static final int m51getSecondsComponentimpl(long j2) {
        if (m58isInfiniteimpl(j2)) {
            return 0;
        }
        return (int) (m48getInWholeSecondsimpl(j2) % 60);
    }

    /* renamed from: getStorageUnit-impl  reason: not valid java name */
    private static final DurationUnit m52getStorageUnitimpl(long j2) {
        if (m57isInNanosimpl(j2)) {
            return DurationUnit.NANOSECONDS;
        }
        return DurationUnit.MILLISECONDS;
    }

    /* renamed from: getValue-impl  reason: not valid java name */
    private static final long m53getValueimpl(long j2) {
        return j2 >> 1;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m54hashCodeimpl(long j2) {
        return gv.y(j2);
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m55isFiniteimpl(long j2) {
        return !m58isInfiniteimpl(j2);
    }

    /* renamed from: isInMillis-impl  reason: not valid java name */
    private static final boolean m56isInMillisimpl(long j2) {
        return (((int) j2) & 1) == 1;
    }

    /* renamed from: isInNanos-impl  reason: not valid java name */
    private static final boolean m57isInNanosimpl(long j2) {
        return (((int) j2) & 1) == 0;
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m58isInfiniteimpl(long j2) {
        if (j2 != INFINITE && j2 != NEG_INFINITE) {
            return false;
        }
        return true;
    }

    /* renamed from: isNegative-impl  reason: not valid java name */
    public static final boolean m59isNegativeimpl(long j2) {
        return j2 < 0;
    }

    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public static final long m60plusLRDsOJo(long j2, long j4) {
        if (m58isInfiniteimpl(j2)) {
            if (!m55isFiniteimpl(j4) && (j4 ^ j2) < 0) {
                throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
            }
            return j2;
        } else if (m58isInfiniteimpl(j4)) {
            return j4;
        } else {
            if ((((int) j2) & 1) == (((int) j4) & 1)) {
                long m53getValueimpl = m53getValueimpl(j2) + m53getValueimpl(j4);
                if (m57isInNanosimpl(j2)) {
                    return DurationKt.access$durationOfNanosNormalized(m53getValueimpl);
                }
                return DurationKt.access$durationOfMillisNormalized(m53getValueimpl);
            } else if (m56isInMillisimpl(j2)) {
                return m38addValuesMixedRangesUwyO8pc(j2, m53getValueimpl(j2), m53getValueimpl(j4));
            } else {
                return m38addValuesMixedRangesUwyO8pc(j2, m53getValueimpl(j4), m53getValueimpl(j2));
            }
        }
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m61toLongimpl(long j2, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j2 == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j2 == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m53getValueimpl(j2), m52getStorageUnitimpl(j2), unit);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m62toStringimpl(long j2) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (j2 == 0) {
            return "0s";
        }
        if (j2 == INFINITE) {
            return "Infinity";
        }
        if (j2 == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean m59isNegativeimpl = m59isNegativeimpl(j2);
        StringBuilder sb = new StringBuilder();
        if (m59isNegativeimpl) {
            sb.append('-');
        }
        long m43getAbsoluteValueUwyO8pc = m43getAbsoluteValueUwyO8pc(j2);
        long m45getInWholeDaysimpl = m45getInWholeDaysimpl(m43getAbsoluteValueUwyO8pc);
        int m44getHoursComponentimpl = m44getHoursComponentimpl(m43getAbsoluteValueUwyO8pc);
        int m49getMinutesComponentimpl = m49getMinutesComponentimpl(m43getAbsoluteValueUwyO8pc);
        int m51getSecondsComponentimpl = m51getSecondsComponentimpl(m43getAbsoluteValueUwyO8pc);
        int m50getNanosecondsComponentimpl = m50getNanosecondsComponentimpl(m43getAbsoluteValueUwyO8pc);
        int i = 0;
        if (m45getInWholeDaysimpl != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (m44getHoursComponentimpl != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (m49getMinutesComponentimpl != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (m51getSecondsComponentimpl == 0 && m50getNanosecondsComponentimpl == 0) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z2) {
            sb.append(m45getInWholeDaysimpl);
            sb.append('d');
            i = 1;
        }
        if (z3 || (z2 && (z4 || z5))) {
            int i5 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(m44getHoursComponentimpl);
            sb.append('h');
            i = i5;
        }
        if (z4 || (z5 && (z3 || z2))) {
            int i6 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(m49getMinutesComponentimpl);
            sb.append('m');
            i = i6;
        }
        if (z5) {
            int i8 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (m51getSecondsComponentimpl == 0 && !z2 && !z3 && !z4) {
                if (m50getNanosecondsComponentimpl >= 1000000) {
                    m39appendFractionalimpl(j2, sb, m50getNanosecondsComponentimpl / 1000000, m50getNanosecondsComponentimpl % 1000000, 6, "ms", false);
                } else if (m50getNanosecondsComponentimpl >= 1000) {
                    m39appendFractionalimpl(j2, sb, m50getNanosecondsComponentimpl / 1000, m50getNanosecondsComponentimpl % 1000, 3, "us", false);
                } else {
                    sb.append(m50getNanosecondsComponentimpl);
                    sb.append("ns");
                }
            } else {
                m39appendFractionalimpl(j2, sb, m51getSecondsComponentimpl, m50getNanosecondsComponentimpl, 9, "s", false);
            }
            i = i8;
        }
        if (m59isNegativeimpl && i > 1) {
            sb.insert(1, '(').append(')');
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* renamed from: unaryMinus-UwyO8pc  reason: not valid java name */
    public static final long m63unaryMinusUwyO8pc(long j2) {
        return DurationKt.access$durationOf(-m53getValueimpl(j2), ((int) j2) & 1);
    }
}
