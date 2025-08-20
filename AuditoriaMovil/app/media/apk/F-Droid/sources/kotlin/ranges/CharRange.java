package kotlin.ranges;

import ch.qos.logback.classic.pattern.CallerDataConverter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PrimitiveRanges.kt */
/* loaded from: classes.dex */
public final class CharRange extends CharProgression implements ClosedRange {
    public static final Companion Companion = new Companion(null);
    private static final CharRange EMPTY = new CharRange(1, 0);

    /* compiled from: PrimitiveRanges.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CharRange(char c, char c2) {
        super(c, c2, 1);
    }

    @Override // kotlin.ranges.ClosedRange
    public Character getStart() {
        return Character.valueOf(getFirst());
    }

    @Override // kotlin.ranges.ClosedRange
    public Character getEndInclusive() {
        return Character.valueOf(getLast());
    }

    public boolean contains(char c) {
        return Intrinsics.compare((int) getFirst(), (int) c) <= 0 && Intrinsics.compare((int) c, (int) getLast()) <= 0;
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return Intrinsics.compare((int) getFirst(), (int) getLast()) > 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CharRange) {
            if (!isEmpty() || !((CharRange) obj).isEmpty()) {
                CharRange charRange = (CharRange) obj;
                if (getFirst() != charRange.getFirst() || getLast() != charRange.getLast()) {
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
        return (getFirst() * 31) + getLast();
    }

    public String toString() {
        return getFirst() + CallerDataConverter.DEFAULT_RANGE_DELIMITER + getLast();
    }
}
