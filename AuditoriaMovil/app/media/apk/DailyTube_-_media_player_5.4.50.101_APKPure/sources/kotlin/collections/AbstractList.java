package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* loaded from: classes.dex */
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>, KMappedMarker {
    public static final Companion Companion = new Companion(null);

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void checkBoundsIndexes$kotlin_stdlib(int i, int i5, int i6) {
            if (i >= 0 && i5 <= i6) {
                if (i <= i5) {
                    return;
                }
                throw new IllegalArgumentException("startIndex: " + i + " > endIndex: " + i5);
            }
            throw new IndexOutOfBoundsException("startIndex: " + i + ", endIndex: " + i5 + ", size: " + i6);
        }

        public final void checkElementIndex$kotlin_stdlib(int i, int i5) {
            if (i >= 0 && i < i5) {
                return;
            }
            throw new IndexOutOfBoundsException("index: " + i + ", size: " + i5);
        }

        public final void checkPositionIndex$kotlin_stdlib(int i, int i5) {
            if (i >= 0 && i <= i5) {
                return;
            }
            throw new IndexOutOfBoundsException("index: " + i + ", size: " + i5);
        }

        public final void checkRangeIndexes$kotlin_stdlib(int i, int i5, int i6) {
            if (i >= 0 && i5 <= i6) {
                if (i <= i5) {
                    return;
                }
                throw new IllegalArgumentException("fromIndex: " + i + " > toIndex: " + i5);
            }
            throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i5 + ", size: " + i6);
        }

        public final int newCapacity$kotlin_stdlib(int i, int i5) {
            int i6 = i + (i >> 1);
            if (i6 - i5 < 0) {
                i6 = i5;
            }
            return i6 - 2147483639 > 0 ? i5 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i6;
        }

        public final boolean orderedEquals$kotlin_stdlib(Collection<?> c2, Collection<?> other) {
            Intrinsics.checkNotNullParameter(c2, "c");
            Intrinsics.checkNotNullParameter(other, "other");
            if (c2.size() != other.size()) {
                return false;
            }
            Iterator<?> it = other.iterator();
            Iterator<?> it2 = c2.iterator();
            while (it2.hasNext()) {
                if (!Intrinsics.areEqual(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int orderedHashCode$kotlin_stdlib(Collection<?> c2) {
            int i;
            Intrinsics.checkNotNullParameter(c2, "c");
            int i5 = 1;
            for (Object obj : c2) {
                int i6 = i5 * 31;
                if (obj != null) {
                    i = obj.hashCode();
                } else {
                    i = 0;
                }
                i5 = i6 + i;
            }
            return i5;
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public class IteratorImpl implements Iterator<E>, KMappedMarker {
        private int index;

        public IteratorImpl() {
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index < AbstractList.this.size()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                AbstractList<E> abstractList = AbstractList.this;
                int i = this.index;
                this.index = i + 1;
                return abstractList.get(i);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    /* loaded from: classes.dex */
    public class ListIteratorImpl extends AbstractList<E>.IteratorImpl implements ListIterator<E>, KMappedMarker {
        public ListIteratorImpl(int i) {
            super();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, AbstractList.this.size());
            setIndex(i);
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (getIndex() > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return getIndex();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious()) {
                AbstractList<E> abstractList = AbstractList.this;
                setIndex(getIndex() - 1);
                return abstractList.get(getIndex());
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return getIndex() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* loaded from: classes.dex */
    public static final class SubList<E> extends AbstractList<E> implements RandomAccess {
        private int _size;
        private final int fromIndex;
        private final AbstractList<E> list;

        /* JADX WARN: Multi-variable type inference failed */
        public SubList(AbstractList<? extends E> list, int i, int i5) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
            this.fromIndex = i;
            AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i5, list.size());
            this._size = i5 - i;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public E get(int i) {
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, this._size);
            return this.list.get(this.fromIndex + i);
        }

        @Override // kotlin.collections.AbstractCollection
        public int getSize() {
            return this._size;
        }
    }

    @Override // java.util.List
    public void add(int i, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        return Companion.orderedEquals$kotlin_stdlib(this, (Collection) obj);
    }

    @Override // java.util.List
    public abstract E get(int i);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.orderedHashCode$kotlin_stdlib(this);
    }

    @Override // java.util.List
    public int indexOf(E e2) {
        int i = 0;
        for (E e3 : this) {
            if (!Intrinsics.areEqual(e3, e2)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    @Override // java.util.List
    public int lastIndexOf(E e2) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (Intrinsics.areEqual(listIterator.previous(), e2)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new ListIteratorImpl(0);
    }

    @Override // java.util.List
    public E remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i, int i5) {
        return new SubList(this, i, i5);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return new ListIteratorImpl(i);
    }
}
