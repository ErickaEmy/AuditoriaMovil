package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.ConcurrentModificationException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: PersistentVectorMutableIterator.kt */
/* loaded from: classes.dex */
public final class PersistentVectorMutableIterator extends AbstractListIterator {
    private final PersistentVectorBuilder builder;
    private int expectedModCount;
    private int lastIteratedIndex;
    private TrieIterator trieIterator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentVectorMutableIterator(PersistentVectorBuilder builder, int i) {
        super(i, builder.size());
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.expectedModCount = builder.getModCount$runtime_release();
        this.lastIteratedIndex = -1;
        setupTrieIterator();
    }

    @Override // java.util.ListIterator
    public Object previous() {
        checkForComodification();
        checkHasPrevious$runtime_release();
        this.lastIteratedIndex = getIndex() - 1;
        TrieIterator trieIterator = this.trieIterator;
        if (trieIterator == null) {
            Object[] tail$runtime_release = this.builder.getTail$runtime_release();
            setIndex(getIndex() - 1);
            return tail$runtime_release[getIndex()];
        } else if (getIndex() > trieIterator.getSize()) {
            Object[] tail$runtime_release2 = this.builder.getTail$runtime_release();
            setIndex(getIndex() - 1);
            return tail$runtime_release2[getIndex() - trieIterator.getSize()];
        } else {
            setIndex(getIndex() - 1);
            return trieIterator.previous();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        checkForComodification();
        checkHasNext$runtime_release();
        this.lastIteratedIndex = getIndex();
        TrieIterator trieIterator = this.trieIterator;
        if (trieIterator == null) {
            Object[] tail$runtime_release = this.builder.getTail$runtime_release();
            int index = getIndex();
            setIndex(index + 1);
            return tail$runtime_release[index];
        } else if (trieIterator.hasNext()) {
            setIndex(getIndex() + 1);
            return trieIterator.next();
        } else {
            Object[] tail$runtime_release2 = this.builder.getTail$runtime_release();
            int index2 = getIndex();
            setIndex(index2 + 1);
            return tail$runtime_release2[index2 - trieIterator.getSize()];
        }
    }

    private final void reset() {
        setSize(this.builder.size());
        this.expectedModCount = this.builder.getModCount$runtime_release();
        this.lastIteratedIndex = -1;
        setupTrieIterator();
    }

    private final void setupTrieIterator() {
        int coerceAtMost;
        Object[] root$runtime_release = this.builder.getRoot$runtime_release();
        if (root$runtime_release == null) {
            this.trieIterator = null;
            return;
        }
        int rootSize = UtilsKt.rootSize(this.builder.size());
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(getIndex(), rootSize);
        int rootShift$runtime_release = (this.builder.getRootShift$runtime_release() / 5) + 1;
        TrieIterator trieIterator = this.trieIterator;
        if (trieIterator == null) {
            this.trieIterator = new TrieIterator(root$runtime_release, coerceAtMost, rootSize, rootShift$runtime_release);
            return;
        }
        Intrinsics.checkNotNull(trieIterator);
        trieIterator.reset$runtime_release(root$runtime_release, coerceAtMost, rootSize, rootShift$runtime_release);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator
    public void add(Object obj) {
        checkForComodification();
        this.builder.add(getIndex(), obj);
        setIndex(getIndex() + 1);
        reset();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator, java.util.Iterator
    public void remove() {
        checkForComodification();
        checkHasIterated();
        this.builder.remove(this.lastIteratedIndex);
        if (this.lastIteratedIndex < getIndex()) {
            setIndex(this.lastIteratedIndex);
        }
        reset();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator
    public void set(Object obj) {
        checkForComodification();
        checkHasIterated();
        this.builder.set(this.lastIteratedIndex, obj);
        this.expectedModCount = this.builder.getModCount$runtime_release();
        setupTrieIterator();
    }

    private final void checkForComodification() {
        if (this.expectedModCount != this.builder.getModCount$runtime_release()) {
            throw new ConcurrentModificationException();
        }
    }

    private final void checkHasIterated() {
        if (this.lastIteratedIndex == -1) {
            throw new IllegalStateException();
        }
    }
}
