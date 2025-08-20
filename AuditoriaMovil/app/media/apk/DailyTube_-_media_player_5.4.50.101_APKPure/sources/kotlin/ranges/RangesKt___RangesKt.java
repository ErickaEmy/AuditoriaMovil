package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.ranges.IntProgression;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class RangesKt___RangesKt extends RangesKt__RangesKt {
    public static float coerceAtLeast(float f4, float f6) {
        return f4 < f6 ? f6 : f4;
    }

    public static int coerceAtMost(int i, int i5) {
        return i > i5 ? i5 : i;
    }

    public static int coerceIn(int i, int i5, int i6) {
        if (i5 <= i6) {
            return i < i5 ? i5 : i > i6 ? i6 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i6 + " is less than minimum " + i5 + '.');
    }

    public static IntProgression downTo(int i, int i5) {
        return IntProgression.Companion.fromClosedRange(i, i5, -1);
    }

    public static int random(IntRange intRange, Random random) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return RandomKt.nextInt(random, intRange);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    public static IntProgression step(IntProgression intProgression, int i) {
        boolean z2;
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        if (i > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        RangesKt__RangesKt.checkStepIsPositive(z2, Integer.valueOf(i));
        IntProgression.Companion companion = IntProgression.Companion;
        int first = intProgression.getFirst();
        int last = intProgression.getLast();
        if (intProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, last, i);
    }

    public static IntRange until(int i, int i5) {
        if (i5 <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        return new IntRange(i, i5 - 1);
    }

    public static int coerceAtLeast(int i, int i5) {
        return i < i5 ? i5 : i;
    }

    public static long coerceAtMost(long j2, long j4) {
        return j2 > j4 ? j4 : j2;
    }

    public static long coerceIn(long j2, long j4, long j6) {
        if (j4 <= j6) {
            return j2 < j4 ? j4 : j2 > j6 ? j6 : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j6 + " is less than minimum " + j4 + '.');
    }

    public static long coerceAtLeast(long j2, long j4) {
        return j2 < j4 ? j4 : j2;
    }

    public static float coerceIn(float f4, float f6, float f9) {
        if (f6 <= f9) {
            return f4 < f6 ? f6 : f4 > f9 ? f9 : f4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f9 + " is less than minimum " + f6 + '.');
    }
}
