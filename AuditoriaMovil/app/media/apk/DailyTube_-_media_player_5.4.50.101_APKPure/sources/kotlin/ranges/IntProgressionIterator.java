package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.IntIterator;
/* loaded from: classes.dex */
public final class IntProgressionIterator extends IntIterator {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    public IntProgressionIterator(int i, int i5, int i6) {
        this.step = i6;
        this.finalElement = i5;
        boolean z2 = false;
        if (i6 <= 0 ? i >= i5 : i <= i5) {
            z2 = true;
        }
        this.hasNext = z2;
        this.next = z2 ? i : i5;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.IntIterator
    public int nextInt() {
        int i = this.next;
        if (i == this.finalElement) {
            if (this.hasNext) {
                this.hasNext = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.next = this.step + i;
        }
        return i;
    }
}
