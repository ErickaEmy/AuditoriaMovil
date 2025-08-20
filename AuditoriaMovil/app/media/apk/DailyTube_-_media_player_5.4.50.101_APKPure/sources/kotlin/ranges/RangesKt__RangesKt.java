package kotlin.ranges;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
class RangesKt__RangesKt {
    public static final void checkStepIsPositive(boolean z2, Number step) {
        Intrinsics.checkNotNullParameter(step, "step");
        if (z2) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }
}
