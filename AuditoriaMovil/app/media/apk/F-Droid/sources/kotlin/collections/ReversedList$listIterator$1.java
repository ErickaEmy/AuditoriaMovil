package kotlin.collections;

import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: ReversedViews.kt */
/* loaded from: classes.dex */
public final class ReversedList$listIterator$1 implements ListIterator, KMappedMarker {
    private final ListIterator delegateIterator;
    final /* synthetic */ ReversedList this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReversedList$listIterator$1(ReversedList reversedList, int i) {
        List list;
        int reversePositionIndex$CollectionsKt__ReversedViewsKt;
        this.this$0 = reversedList;
        list = reversedList.delegate;
        reversePositionIndex$CollectionsKt__ReversedViewsKt = CollectionsKt__ReversedViewsKt.reversePositionIndex$CollectionsKt__ReversedViewsKt(reversedList, i);
        this.delegateIterator = list.listIterator(reversePositionIndex$CollectionsKt__ReversedViewsKt);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.delegateIterator.hasPrevious();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.delegateIterator.hasNext();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        return this.delegateIterator.previous();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        int reverseIteratorIndex$CollectionsKt__ReversedViewsKt;
        reverseIteratorIndex$CollectionsKt__ReversedViewsKt = CollectionsKt__ReversedViewsKt.reverseIteratorIndex$CollectionsKt__ReversedViewsKt(this.this$0, this.delegateIterator.previousIndex());
        return reverseIteratorIndex$CollectionsKt__ReversedViewsKt;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        return this.delegateIterator.next();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        int reverseIteratorIndex$CollectionsKt__ReversedViewsKt;
        reverseIteratorIndex$CollectionsKt__ReversedViewsKt = CollectionsKt__ReversedViewsKt.reverseIteratorIndex$CollectionsKt__ReversedViewsKt(this.this$0, this.delegateIterator.nextIndex());
        return reverseIteratorIndex$CollectionsKt__ReversedViewsKt;
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        this.delegateIterator.add(obj);
        this.delegateIterator.previous();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        this.delegateIterator.remove();
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        this.delegateIterator.set(obj);
    }
}
