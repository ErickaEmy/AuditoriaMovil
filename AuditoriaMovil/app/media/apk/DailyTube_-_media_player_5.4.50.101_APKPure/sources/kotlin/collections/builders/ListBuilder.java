package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableList;
/* loaded from: classes.dex */
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {
    private static final Companion Companion = new Companion(null);
    private static final ListBuilder Empty;
    private E[] array;
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    private int length;
    private int offset;
    private final ListBuilder<E> root;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public static final class Itr<E> implements ListIterator<E>, KMappedMarker {
        private int expectedModCount;
        private int index;
        private int lastIndex;
        private final ListBuilder<E> list;

        public Itr(ListBuilder<E> list, int i) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
            this.index = i;
            this.lastIndex = -1;
            this.expectedModCount = ((AbstractList) list).modCount;
        }

        private final void checkForComodification() {
            if (((AbstractList) this.list).modCount == this.expectedModCount) {
                return;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            checkForComodification();
            ListBuilder<E> listBuilder = this.list;
            int i = this.index;
            this.index = i + 1;
            listBuilder.add(i, e2);
            this.lastIndex = -1;
            this.expectedModCount = ((AbstractList) this.list).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.index < ((ListBuilder) this.list).length) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.index > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkForComodification();
            if (this.index < ((ListBuilder) this.list).length) {
                int i = this.index;
                this.index = i + 1;
                this.lastIndex = i;
                return (E) ((ListBuilder) this.list).array[((ListBuilder) this.list).offset + this.lastIndex];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public E previous() {
            checkForComodification();
            int i = this.index;
            if (i > 0) {
                int i5 = i - 1;
                this.index = i5;
                this.lastIndex = i5;
                return (E) ((ListBuilder) this.list).array[((ListBuilder) this.list).offset + this.lastIndex];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkForComodification();
            int i = this.lastIndex;
            if (i != -1) {
                this.list.remove(i);
                this.index = this.lastIndex;
                this.lastIndex = -1;
                this.expectedModCount = ((AbstractList) this.list).modCount;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            checkForComodification();
            int i = this.lastIndex;
            if (i != -1) {
                this.list.set(i, e2);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
        }
    }

    static {
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.isReadOnly = true;
        Empty = listBuilder;
    }

    private ListBuilder(E[] eArr, int i, int i5, boolean z2, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = eArr;
        this.offset = i;
        this.length = i5;
        this.isReadOnly = z2;
        this.backing = listBuilder;
        this.root = listBuilder2;
        if (listBuilder != null) {
            ((AbstractList) this).modCount = ((AbstractList) listBuilder).modCount;
        }
    }

    private final void addAllInternal(int i, Collection<? extends E> collection, int i5) {
        registerModification();
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAllInternal(i, collection, i5);
            this.array = this.backing.array;
            this.length += i5;
            return;
        }
        insertAtInternal(i, i5);
        Iterator<? extends E> it = collection.iterator();
        for (int i6 = 0; i6 < i5; i6++) {
            this.array[i + i6] = it.next();
        }
    }

    private final void addAtInternal(int i, E e2) {
        registerModification();
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAtInternal(i, e2);
            this.array = this.backing.array;
            this.length++;
            return;
        }
        insertAtInternal(i, 1);
        this.array[i] = e2;
    }

    private final void checkForComodification() {
        ListBuilder<E> listBuilder = this.root;
        if (listBuilder != null && ((AbstractList) listBuilder).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    private final void checkIsMutable() {
        if (!isEffectivelyReadOnly()) {
            return;
        }
        throw new UnsupportedOperationException();
    }

    private final boolean contentEquals(List<?> list) {
        boolean subarrayContentEquals;
        subarrayContentEquals = ListBuilderKt.subarrayContentEquals(this.array, this.offset, this.length, list);
        return subarrayContentEquals;
    }

    private final void ensureCapacityInternal(int i) {
        if (i >= 0) {
            E[] eArr = this.array;
            if (i > eArr.length) {
                this.array = (E[]) ListBuilderKt.copyOfUninitializedElements(this.array, kotlin.collections.AbstractList.Companion.newCapacity$kotlin_stdlib(eArr.length, i));
                return;
            }
            return;
        }
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int i) {
        ensureCapacityInternal(this.length + i);
    }

    private final void insertAtInternal(int i, int i5) {
        ensureExtraCapacity(i5);
        E[] eArr = this.array;
        ArraysKt.copyInto(eArr, eArr, i + i5, i, this.offset + this.length);
        this.length += i5;
    }

    private final boolean isEffectivelyReadOnly() {
        ListBuilder<E> listBuilder;
        if (!this.isReadOnly && ((listBuilder = this.root) == null || !listBuilder.isReadOnly)) {
            return false;
        }
        return true;
    }

    private final void registerModification() {
        ((AbstractList) this).modCount++;
    }

    private final E removeAtInternal(int i) {
        registerModification();
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            this.length--;
            return listBuilder.removeAtInternal(i);
        }
        E[] eArr = this.array;
        E e2 = eArr[i];
        ArraysKt.copyInto(eArr, eArr, i, i + 1, this.offset + this.length);
        ListBuilderKt.resetAt(this.array, (this.offset + this.length) - 1);
        this.length--;
        return e2;
    }

    private final void removeRangeInternal(int i, int i5) {
        if (i5 > 0) {
            registerModification();
        }
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.removeRangeInternal(i, i5);
        } else {
            E[] eArr = this.array;
            ArraysKt.copyInto(eArr, eArr, i, i + i5, this.length);
            E[] eArr2 = this.array;
            int i6 = this.length;
            ListBuilderKt.resetRange(eArr2, i6 - i5, i6);
        }
        this.length -= i5;
    }

    private final int retainOrRemoveAllInternal(int i, int i5, Collection<? extends E> collection, boolean z2) {
        int i6;
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            i6 = listBuilder.retainOrRemoveAllInternal(i, i5, collection, z2);
        } else {
            int i8 = 0;
            int i10 = 0;
            while (i8 < i5) {
                int i11 = i + i8;
                if (collection.contains(this.array[i11]) == z2) {
                    E[] eArr = this.array;
                    i8++;
                    eArr[i10 + i] = eArr[i11];
                    i10++;
                } else {
                    i8++;
                }
            }
            int i12 = i5 - i10;
            E[] eArr2 = this.array;
            ArraysKt.copyInto(eArr2, eArr2, i + i10, i5 + i, this.length);
            E[] eArr3 = this.array;
            int i13 = this.length;
            ListBuilderKt.resetRange(eArr3, i13 - i12, i13);
            i6 = i12;
        }
        if (i6 > 0) {
            registerModification();
        }
        this.length -= i6;
        return i6;
    }

    private final Object writeReplace() {
        if (isEffectivelyReadOnly()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e2) {
        checkIsMutable();
        checkForComodification();
        addAtInternal(this.offset + this.length, e2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        checkForComodification();
        int size = elements.size();
        addAllInternal(this.offset + this.length, elements, size);
        return size > 0;
    }

    public final List<E> build() {
        if (this.backing == null) {
            checkIsMutable();
            this.isReadOnly = true;
            if (this.length > 0) {
                return this;
            }
            return Empty;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        checkForComodification();
        removeRangeInternal(this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        checkForComodification();
        if (obj != this && (!(obj instanceof List) || !contentEquals((List) obj))) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        checkForComodification();
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, this.length);
        return this.array[this.offset + i];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        checkForComodification();
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int subarrayContentHashCode;
        checkForComodification();
        subarrayContentHashCode = ListBuilderKt.subarrayContentHashCode(this.array, this.offset, this.length);
        return subarrayContentHashCode;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        checkForComodification();
        for (int i = 0; i < this.length; i++) {
            if (Intrinsics.areEqual(this.array[this.offset + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        checkForComodification();
        if (this.length == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        checkForComodification();
        for (int i = this.length - 1; i >= 0; i--) {
            if (Intrinsics.areEqual(this.array[this.offset + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        checkIsMutable();
        checkForComodification();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        checkForComodification();
        if (retainOrRemoveAllInternal(this.offset, this.length, elements, false) <= 0) {
            return false;
        }
        return true;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int i) {
        checkIsMutable();
        checkForComodification();
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, this.length);
        return removeAtInternal(this.offset + i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        checkForComodification();
        if (retainOrRemoveAllInternal(this.offset, this.length, elements, true) > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e2) {
        checkIsMutable();
        checkForComodification();
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, this.length);
        E[] eArr = this.array;
        int i5 = this.offset;
        E e3 = eArr[i5 + i];
        eArr[i5 + i] = e2;
        return e3;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int i, int i5) {
        ListBuilder<E> listBuilder;
        kotlin.collections.AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i5, this.length);
        E[] eArr = this.array;
        int i6 = this.offset + i;
        int i8 = i5 - i;
        boolean z2 = this.isReadOnly;
        ListBuilder<E> listBuilder2 = this.root;
        if (listBuilder2 == null) {
            listBuilder = this;
        } else {
            listBuilder = listBuilder2;
        }
        return new ListBuilder(eArr, i6, i8, z2, this, listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        checkForComodification();
        int length = destination.length;
        int i = this.length;
        if (length < i) {
            E[] eArr = this.array;
            int i5 = this.offset;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr, i5, i + i5, destination.getClass());
            Intrinsics.checkNotNullExpressionValue(tArr, "copyOfRange(...)");
            return tArr;
        }
        E[] eArr2 = this.array;
        int i6 = this.offset;
        ArraysKt.copyInto(eArr2, destination, 0, i6, i + i6);
        return (T[]) CollectionsKt.terminateCollectionToArray(this.length, destination);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String subarrayContentToString;
        checkForComodification();
        subarrayContentToString = ListBuilderKt.subarrayContentToString(this.array, this.offset, this.length, this);
        return subarrayContentToString;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i) {
        checkForComodification();
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, this.length);
        return new Itr(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e2) {
        checkIsMutable();
        checkForComodification();
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, this.length);
        addAtInternal(this.offset + i, e2);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        checkForComodification();
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, this.length);
        int size = elements.size();
        addAllInternal(this.offset + i, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        checkForComodification();
        E[] eArr = this.array;
        int i = this.offset;
        return ArraysKt.copyOfRange(eArr, i, this.length + i);
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i) {
        this(ListBuilderKt.arrayOfUninitializedElements(i), 0, 0, false, null, null);
    }
}
