package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: PersistentVectorIterator.kt */
/* loaded from: classes.dex */
public final class PersistentVectorIterator extends AbstractListIterator {
    private final Object[] tail;
    private final TrieIterator trieIterator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentVectorIterator(Object[] root, Object[] tail, int i, int i2, int i3) {
        super(i, i2);
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(tail, "tail");
        this.tail = tail;
        int rootSize = UtilsKt.rootSize(i2);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(i, rootSize);
        this.trieIterator = new TrieIterator(root, coerceAtMost, rootSize, i3);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        checkHasNext$runtime_release();
        if (this.trieIterator.hasNext()) {
            setIndex(getIndex() + 1);
            return this.trieIterator.next();
        }
        Object[] objArr = this.tail;
        int index = getIndex();
        setIndex(index + 1);
        return objArr[index - this.trieIterator.getSize()];
    }

    @Override // java.util.ListIterator
    public Object previous() {
        checkHasPrevious$runtime_release();
        if (getIndex() > this.trieIterator.getSize()) {
            Object[] objArr = this.tail;
            setIndex(getIndex() - 1);
            return objArr[getIndex() - this.trieIterator.getSize()];
        }
        setIndex(getIndex() - 1);
        return this.trieIterator.previous();
    }
}
