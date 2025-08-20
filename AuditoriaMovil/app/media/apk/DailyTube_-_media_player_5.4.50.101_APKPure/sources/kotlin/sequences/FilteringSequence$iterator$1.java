package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
public final class FilteringSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {
    private final Iterator<T> iterator;
    private T nextItem;
    private int nextState;
    final /* synthetic */ FilteringSequence<T> this$0;

    public FilteringSequence$iterator$1(FilteringSequence<T> filteringSequence) {
        Sequence sequence;
        this.this$0 = filteringSequence;
        sequence = ((FilteringSequence) filteringSequence).sequence;
        this.iterator = sequence.iterator();
        this.nextState = -1;
    }

    private final void calcNext() {
        Function1 function1;
        boolean z2;
        while (this.iterator.hasNext()) {
            T next = this.iterator.next();
            function1 = ((FilteringSequence) this.this$0).predicate;
            boolean booleanValue = ((Boolean) function1.invoke(next)).booleanValue();
            z2 = ((FilteringSequence) this.this$0).sendWhen;
            if (booleanValue == z2) {
                this.nextItem = next;
                this.nextState = 1;
                return;
            }
        }
        this.nextState = 0;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextState == -1) {
            calcNext();
        }
        if (this.nextState == 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.nextState == -1) {
            calcNext();
        }
        if (this.nextState != 0) {
            T t2 = this.nextItem;
            this.nextItem = null;
            this.nextState = -1;
            return t2;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
