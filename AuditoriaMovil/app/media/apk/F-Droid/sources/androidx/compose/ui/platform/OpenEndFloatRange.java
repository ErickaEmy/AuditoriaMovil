package androidx.compose.ui.platform;
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
/* loaded from: classes.dex */
final class OpenEndFloatRange implements OpenEndRange {
    private final float _endExclusive;
    private final float _start;

    @Override // androidx.compose.ui.platform.OpenEndRange
    public boolean isEmpty() {
        return this._start >= this._endExclusive;
    }

    public OpenEndFloatRange(float f, float f2) {
        this._start = f;
        this._endExclusive = f2;
    }

    @Override // androidx.compose.ui.platform.OpenEndRange
    public Float getStart() {
        return Float.valueOf(this._start);
    }

    @Override // androidx.compose.ui.platform.OpenEndRange
    public Float getEndExclusive() {
        return Float.valueOf(this._endExclusive);
    }

    public boolean equals(Object obj) {
        if (obj instanceof OpenEndFloatRange) {
            if (!isEmpty() || !((OpenEndFloatRange) obj).isEmpty()) {
                OpenEndFloatRange openEndFloatRange = (OpenEndFloatRange) obj;
                if (this._start != openEndFloatRange._start || this._endExclusive != openEndFloatRange._endExclusive) {
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
        return (Float.floatToIntBits(this._start) * 31) + Float.floatToIntBits(this._endExclusive);
    }

    public String toString() {
        return this._start + "..<" + this._endExclusive;
    }
}
