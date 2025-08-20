package kotlin.time;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class TimedValue<T> {
    private final long duration;
    private final T value;

    public /* synthetic */ TimedValue(Object obj, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TimedValue) {
            TimedValue timedValue = (TimedValue) obj;
            return Intrinsics.areEqual(this.value, timedValue.value) && Duration.m42equalsimpl0(this.duration, timedValue.duration);
        }
        return false;
    }

    /* renamed from: getDuration-UwyO8pc  reason: not valid java name */
    public final long m78getDurationUwyO8pc() {
        return this.duration;
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        T t2 = this.value;
        return ((t2 == null ? 0 : t2.hashCode()) * 31) + Duration.m54hashCodeimpl(this.duration);
    }

    public String toString() {
        return "TimedValue(value=" + this.value + ", duration=" + ((Object) Duration.m62toStringimpl(this.duration)) + ')';
    }

    private TimedValue(T t2, long j2) {
        this.value = t2;
        this.duration = j2;
    }
}
