package kotlin.ranges;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes.dex */
public final class IntRange extends IntProgression {
    public static final Companion Companion = new Companion(null);
    private static final IntRange EMPTY = new IntRange(1, 0);

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntRange getEMPTY() {
            return IntRange.EMPTY;
        }

        private Companion() {
        }
    }

    public IntRange(int i, int i5) {
        super(i, i5, 1);
    }

    public boolean contains(int i) {
        if (getFirst() <= i && i <= getLast()) {
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.IntProgression
    public boolean equals(Object obj) {
        if (obj instanceof IntRange) {
            if (!isEmpty() || !((IntRange) obj).isEmpty()) {
                IntRange intRange = (IntRange) obj;
                if (getFirst() != intRange.getFirst() || getLast() != intRange.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    public Integer getEndInclusive() {
        return Integer.valueOf(getLast());
    }

    public Integer getStart() {
        return Integer.valueOf(getFirst());
    }

    @Override // kotlin.ranges.IntProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // kotlin.ranges.IntProgression
    public boolean isEmpty() {
        if (getFirst() > getLast()) {
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.IntProgression
    public String toString() {
        return getFirst() + ".." + getLast();
    }
}
