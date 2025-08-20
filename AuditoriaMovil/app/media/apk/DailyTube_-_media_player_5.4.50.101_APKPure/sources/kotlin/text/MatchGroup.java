package kotlin.text;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
/* loaded from: classes.dex */
public final class MatchGroup {
    private final IntRange range;
    private final String value;

    public MatchGroup(String value, IntRange range) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(range, "range");
        this.value = value;
        this.range = range;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MatchGroup) {
            MatchGroup matchGroup = (MatchGroup) obj;
            return Intrinsics.areEqual(this.value, matchGroup.value) && Intrinsics.areEqual(this.range, matchGroup.range);
        }
        return false;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + this.range.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.value + ", range=" + this.range + ')';
    }
}
