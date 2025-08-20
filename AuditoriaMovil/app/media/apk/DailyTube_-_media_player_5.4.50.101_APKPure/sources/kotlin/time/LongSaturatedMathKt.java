package kotlin.time;

import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
/* loaded from: classes.dex */
public final class LongSaturatedMathKt {
    private static final long infinityOfSign(long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        Duration.Companion companion = Duration.Companion;
        if (i < 0) {
            return companion.m65getNEG_INFINITEUwyO8pc$kotlin_stdlib();
        }
        return companion.m64getINFINITEUwyO8pc();
    }

    private static final long saturatingFiniteDiff(long j2, long j4, DurationUnit durationUnit) {
        long j6 = j2 - j4;
        if (((j6 ^ j2) & (~(j6 ^ j4))) < 0) {
            DurationUnit durationUnit2 = DurationUnit.MILLISECONDS;
            if (durationUnit.compareTo(durationUnit2) < 0) {
                long convertDurationUnit = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(1L, durationUnit2, durationUnit);
                long j7 = (j2 % convertDurationUnit) - (j4 % convertDurationUnit);
                Duration.Companion companion = Duration.Companion;
                return Duration.m60plusLRDsOJo(DurationKt.toDuration((j2 / convertDurationUnit) - (j4 / convertDurationUnit), durationUnit2), DurationKt.toDuration(j7, durationUnit));
            }
            return Duration.m63unaryMinusUwyO8pc(infinityOfSign(j6));
        }
        return DurationKt.toDuration(j6, durationUnit);
    }

    public static final long saturatingOriginsDiff(long j2, long j4, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (((j4 - 1) | 1) == Long.MAX_VALUE) {
            if (j2 == j4) {
                return Duration.Companion.m66getZEROUwyO8pc();
            }
            return Duration.m63unaryMinusUwyO8pc(infinityOfSign(j4));
        } else if ((1 | (j2 - 1)) == Long.MAX_VALUE) {
            return infinityOfSign(j2);
        } else {
            return saturatingFiniteDiff(j2, j4, unit);
        }
    }
}
