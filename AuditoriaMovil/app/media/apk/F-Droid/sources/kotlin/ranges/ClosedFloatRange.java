package kotlin.ranges;

import ch.qos.logback.classic.pattern.CallerDataConverter;
/* compiled from: Ranges.kt */
/* loaded from: classes.dex */
final class ClosedFloatRange implements ClosedFloatingPointRange {
    private final float _endInclusive;
    private final float _start;

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return this._start > this._endInclusive;
    }

    public boolean lessThanOrEquals(float f, float f2) {
        return f <= f2;
    }

    public ClosedFloatRange(float f, float f2) {
        this._start = f;
        this._endInclusive = f2;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Comparable comparable, Comparable comparable2) {
        return lessThanOrEquals(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }

    @Override // kotlin.ranges.ClosedRange
    public Float getStart() {
        return Float.valueOf(this._start);
    }

    @Override // kotlin.ranges.ClosedRange
    public Float getEndInclusive() {
        return Float.valueOf(this._endInclusive);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ClosedFloatRange) {
            if (!isEmpty() || !((ClosedFloatRange) obj).isEmpty()) {
                ClosedFloatRange closedFloatRange = (ClosedFloatRange) obj;
                if (this._start != closedFloatRange._start || this._endInclusive != closedFloatRange._endInclusive) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.floatToIntBits(this._start) * 31) + Float.floatToIntBits(this._endInclusive);
    }

    public String toString() {
        return this._start + CallerDataConverter.DEFAULT_RANGE_DELIMITER + this._endInclusive;
    }
}
