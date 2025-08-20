package kotlin.time;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
/* loaded from: classes.dex */
public final class DurationKt {
    public static final long durationOf(long j2, int i) {
        return Duration.m41constructorimpl((j2 << 1) + i);
    }

    public static final long durationOfMillis(long j2) {
        return Duration.m41constructorimpl((j2 << 1) + 1);
    }

    public static final long durationOfMillisNormalized(long j2) {
        if (new LongRange(-4611686018426L, 4611686018426L).contains(j2)) {
            return durationOfNanos(millisToNanos(j2));
        }
        return durationOfMillis(RangesKt.coerceIn(j2, -4611686018427387903L, 4611686018427387903L));
    }

    public static final long durationOfNanos(long j2) {
        return Duration.m41constructorimpl(j2 << 1);
    }

    public static final long durationOfNanosNormalized(long j2) {
        if (new LongRange(-4611686018426999999L, 4611686018426999999L).contains(j2)) {
            return durationOfNanos(j2);
        }
        return durationOfMillis(nanosToMillis(j2));
    }

    public static final long millisToNanos(long j2) {
        return j2 * 1000000;
    }

    public static final long nanosToMillis(long j2) {
        return j2 / 1000000;
    }

    public static final long toDuration(long j2, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit durationUnit = DurationUnit.NANOSECONDS;
        long convertDurationUnitOverflow = DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(4611686018426999999L, durationUnit, unit);
        if (new LongRange(-convertDurationUnitOverflow, convertDurationUnitOverflow).contains(j2)) {
            return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(j2, unit, durationUnit));
        }
        return durationOfMillis(RangesKt.coerceIn(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(j2, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
    }
}
