package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: Sequences.kt */
/* loaded from: classes2.dex */
public final class SubSequence$iterator$1 implements Iterator, KMappedMarker {
    private final Iterator iterator;
    private int position;
    final /* synthetic */ SubSequence this$0;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubSequence$iterator$1(SubSequence subSequence) {
        Sequence sequence;
        this.this$0 = subSequence;
        sequence = subSequence.sequence;
        this.iterator = sequence.iterator();
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0008 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void drop() {
        /*
            r2 = this;
        L0:
            int r0 = r2.position
            kotlin.sequences.SubSequence r1 = r2.this$0
            int r1 = kotlin.sequences.SubSequence.access$getStartIndex$p(r1)
            if (r0 >= r1) goto L1e
            java.util.Iterator r0 = r2.iterator
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L1e
            java.util.Iterator r0 = r2.iterator
            r0.next()
            int r0 = r2.position
            int r0 = r0 + 1
            r2.position = r0
            goto L0
        L1e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SubSequence$iterator$1.drop():void");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i;
        drop();
        int i2 = this.position;
        i = this.this$0.endIndex;
        return i2 < i && this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        int i;
        drop();
        int i2 = this.position;
        i = this.this$0.endIndex;
        if (i2 >= i) {
            throw new NoSuchElementException();
        }
        this.position++;
        return this.iterator.next();
    }
}
