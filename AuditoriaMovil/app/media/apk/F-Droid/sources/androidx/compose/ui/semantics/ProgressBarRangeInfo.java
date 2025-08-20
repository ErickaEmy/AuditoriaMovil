package androidx.compose.ui.semantics;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt__RangesKt;
/* compiled from: SemanticsProperties.kt */
/* loaded from: classes.dex */
public final class ProgressBarRangeInfo {
    public static final Companion Companion = new Companion(null);
    private static final ProgressBarRangeInfo Indeterminate;
    private final float current;
    private final ClosedFloatingPointRange range;
    private final int steps;

    public final float getCurrent() {
        return this.current;
    }

    public final ClosedFloatingPointRange getRange() {
        return this.range;
    }

    public final int getSteps() {
        return this.steps;
    }

    public ProgressBarRangeInfo(float f, ClosedFloatingPointRange range, int i) {
        Intrinsics.checkNotNullParameter(range, "range");
        this.current = f;
        this.range = range;
        this.steps = i;
        if (!(!Float.isNaN(f))) {
            throw new IllegalArgumentException("current must not be NaN".toString());
        }
    }

    public /* synthetic */ ProgressBarRangeInfo(float f, ClosedFloatingPointRange closedFloatingPointRange, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, closedFloatingPointRange, (i2 & 4) != 0 ? 0 : i);
    }

    /* compiled from: SemanticsProperties.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProgressBarRangeInfo getIndeterminate() {
            return ProgressBarRangeInfo.Indeterminate;
        }
    }

    static {
        ClosedFloatingPointRange rangeTo;
        rangeTo = RangesKt__RangesKt.rangeTo(0.0f, 0.0f);
        Indeterminate = new ProgressBarRangeInfo(0.0f, rangeTo, 0, 4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProgressBarRangeInfo) {
            ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) obj;
            return this.current == progressBarRangeInfo.current && Intrinsics.areEqual(this.range, progressBarRangeInfo.range) && this.steps == progressBarRangeInfo.steps;
        }
        return false;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.current) * 31) + this.range.hashCode()) * 31) + this.steps;
    }

    public String toString() {
        return "ProgressBarRangeInfo(current=" + this.current + ", range=" + this.range + ", steps=" + this.steps + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
