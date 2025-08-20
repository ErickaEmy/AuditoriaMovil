package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ProgressionIterators.kt */
/* loaded from: classes.dex */
public final class CharProgressionIterator extends CharIterator {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    public CharProgressionIterator(char c, char c2, int i) {
        this.step = i;
        this.finalElement = c2;
        boolean z = true;
        if (i <= 0 ? Intrinsics.compare((int) c, (int) c2) < 0 : Intrinsics.compare((int) c, (int) c2) > 0) {
            z = false;
        }
        this.hasNext = z;
        this.next = z ? c : c2;
    }

    @Override // kotlin.collections.CharIterator
    public char nextChar() {
        int i = this.next;
        if (i != this.finalElement) {
            this.next = this.step + i;
        } else if (!this.hasNext) {
            throw new NoSuchElementException();
        } else {
            this.hasNext = false;
        }
        return (char) i;
    }
}
