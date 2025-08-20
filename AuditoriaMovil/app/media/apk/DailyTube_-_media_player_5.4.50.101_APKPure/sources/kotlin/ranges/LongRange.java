package kotlin.ranges;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes.dex */
public final class LongRange extends LongProgression {
    public static final Companion Companion = new Companion(null);
    private static final LongRange EMPTY = new LongRange(1, 0);

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public LongRange(long j2, long j4) {
        super(j2, j4, 1L);
    }

    public boolean contains(long j2) {
        if (getFirst() <= j2 && j2 <= getLast()) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LongRange) {
            if (!isEmpty() || !((LongRange) obj).isEmpty()) {
                LongRange longRange = (LongRange) obj;
                if (getFirst() != longRange.getFirst() || getLast() != longRange.getLast()) {
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
        return (int) ((31 * (getFirst() ^ (getFirst() >>> 32))) + (getLast() ^ (getLast() >>> 32)));
    }

    public boolean isEmpty() {
        if (getFirst() > getLast()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return getFirst() + ".." + getLast();
    }
}
