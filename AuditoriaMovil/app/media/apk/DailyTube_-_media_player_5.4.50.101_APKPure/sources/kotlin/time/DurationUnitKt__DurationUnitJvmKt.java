package kotlin.time;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
class DurationUnitKt__DurationUnitJvmKt {
    public static final long convertDurationUnit(long j2, DurationUnit sourceUnit, DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(j2, sourceUnit.getTimeUnit$kotlin_stdlib());
    }

    public static final long convertDurationUnitOverflow(long j2, DurationUnit sourceUnit, DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(j2, sourceUnit.getTimeUnit$kotlin_stdlib());
    }
}
