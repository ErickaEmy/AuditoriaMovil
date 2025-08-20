package kotlin.ranges;

import java.util.Iterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
/* loaded from: classes.dex */
public class IntProgression implements Iterable<Integer>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private final int first;
    private final int last;
    private final int step;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntProgression fromClosedRange(int i, int i5, int i6) {
            return new IntProgression(i, i5, i6);
        }

        private Companion() {
        }
    }

    public IntProgression(int i, int i5, int i6) {
        if (i6 != 0) {
            if (i6 != Integer.MIN_VALUE) {
                this.first = i;
                this.last = ProgressionUtilKt.getProgressionLastElement(i, i5, i6);
                this.step = i6;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public boolean equals(Object obj) {
        if (obj instanceof IntProgression) {
            if (!isEmpty() || !((IntProgression) obj).isEmpty()) {
                IntProgression intProgression = (IntProgression) obj;
                if (this.first != intProgression.first || this.last != intProgression.last || this.step != intProgression.step) {
                }
            }
            return true;
        }
        return false;
    }

    public final int getFirst() {
        return this.first;
    }

    public final int getLast() {
        return this.last;
    }

    public final int getStep() {
        return this.step;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.first * 31) + this.last) * 31) + this.step;
    }

    public boolean isEmpty() {
        if (this.step > 0) {
            if (this.first <= this.last) {
                return false;
            }
        } else if (this.first >= this.last) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.step > 0) {
            sb = new StringBuilder();
            sb.append(this.first);
            sb.append("..");
            sb.append(this.last);
            sb.append(" step ");
            i = this.step;
        } else {
            sb = new StringBuilder();
            sb.append(this.first);
            sb.append(" downTo ");
            sb.append(this.last);
            sb.append(" step ");
            i = -this.step;
        }
        sb.append(i);
        return sb.toString();
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return new IntProgressionIterator(this.first, this.last, this.step);
    }
}
