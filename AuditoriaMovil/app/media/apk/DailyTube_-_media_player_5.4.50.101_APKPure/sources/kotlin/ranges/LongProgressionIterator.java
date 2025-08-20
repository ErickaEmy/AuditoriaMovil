package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.LongIterator;
/* loaded from: classes.dex */
public final class LongProgressionIterator extends LongIterator {
    private final long finalElement;
    private boolean hasNext;
    private long next;
    private final long step;

    public LongProgressionIterator(long j2, long j4, long j6) {
        this.step = j6;
        this.finalElement = j4;
        boolean z2 = false;
        int i = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        int i5 = (j2 > j4 ? 1 : (j2 == j4 ? 0 : -1));
        if (i <= 0 ? i5 >= 0 : i5 <= 0) {
            z2 = true;
        }
        this.hasNext = z2;
        this.next = z2 ? j2 : j4;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.LongIterator
    public long nextLong() {
        long j2 = this.next;
        if (j2 == this.finalElement) {
            if (this.hasNext) {
                this.hasNext = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.next = this.step + j2;
        }
        return j2;
    }
}
