package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: Sequences.kt */
/* loaded from: classes2.dex */
public final class TakeSequence$iterator$1 implements Iterator, KMappedMarker {
    private final Iterator iterator;
    private int left;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TakeSequence$iterator$1(TakeSequence takeSequence) {
        int i;
        Sequence sequence;
        i = takeSequence.count;
        this.left = i;
        sequence = takeSequence.sequence;
        this.iterator = sequence.iterator();
    }

    @Override // java.util.Iterator
    public Object next() {
        int i = this.left;
        if (i == 0) {
            throw new NoSuchElementException();
        }
        this.left = i - 1;
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.left > 0 && this.iterator.hasNext();
    }
}
