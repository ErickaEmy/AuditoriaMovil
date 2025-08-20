package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* loaded from: classes.dex */
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    public static final Companion Companion = new Companion(null);
    private static final Object[] emptyElementData = new Object[0];
    private Object[] elementData = emptyElementData;
    private int head;
    private int size;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void copyCollectionElements(int i, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.elementData.length;
        while (i < length && it.hasNext()) {
            this.elementData[i] = it.next();
            i++;
        }
        int i5 = this.head;
        for (int i6 = 0; i6 < i5 && it.hasNext(); i6++) {
            this.elementData[i6] = it.next();
        }
        this.size = size() + collection.size();
    }

    private final void copyElements(int i) {
        Object[] objArr = new Object[i];
        Object[] objArr2 = this.elementData;
        ArraysKt.copyInto(objArr2, objArr, 0, this.head, objArr2.length);
        Object[] objArr3 = this.elementData;
        int length = objArr3.length;
        int i5 = this.head;
        ArraysKt.copyInto(objArr3, objArr, length - i5, 0, i5);
        this.head = 0;
        this.elementData = objArr;
    }

    private final int decremented(int i) {
        if (i == 0) {
            return ArraysKt.getLastIndex(this.elementData);
        }
        return i - 1;
    }

    private final void ensureCapacity(int i) {
        if (i >= 0) {
            Object[] objArr = this.elementData;
            if (i <= objArr.length) {
                return;
            }
            if (objArr == emptyElementData) {
                this.elementData = new Object[RangesKt.coerceAtLeast(i, 10)];
                return;
            } else {
                copyElements(AbstractList.Companion.newCapacity$kotlin_stdlib(objArr.length, i));
                return;
            }
        }
        throw new IllegalStateException("Deque is too big.");
    }

    private final int incremented(int i) {
        if (i == ArraysKt.getLastIndex(this.elementData)) {
            return 0;
        }
        return i + 1;
    }

    private final int negativeMod(int i) {
        if (i < 0) {
            return i + this.elementData.length;
        }
        return i;
    }

    private final int positiveMod(int i) {
        Object[] objArr = this.elementData;
        if (i >= objArr.length) {
            return i - objArr.length;
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e2) {
        addLast(e2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        ensureCapacity(size() + elements.size());
        copyCollectionElements(positiveMod(this.head + size()), elements);
        return true;
    }

    public final void addFirst(E e2) {
        ensureCapacity(size() + 1);
        int decremented = decremented(this.head);
        this.head = decremented;
        this.elementData[decremented] = e2;
        this.size = size() + 1;
    }

    public final void addLast(E e2) {
        ensureCapacity(size() + 1);
        this.elementData[positiveMod(this.head + size())] = e2;
        this.size = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int positiveMod = positiveMod(this.head + size());
        int i = this.head;
        if (i < positiveMod) {
            ArraysKt.fill(this.elementData, (Object) null, i, positiveMod);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            ArraysKt.fill(objArr, (Object) null, this.head, objArr.length);
            ArraysKt.fill(this.elementData, (Object) null, 0, positiveMod);
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[this.head];
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        return (E) this.elementData[positiveMod(this.head + i)];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i;
        int positiveMod = positiveMod(this.head + size());
        int i5 = this.head;
        if (i5 < positiveMod) {
            while (i5 < positiveMod) {
                if (Intrinsics.areEqual(obj, this.elementData[i5])) {
                    i = this.head;
                } else {
                    i5++;
                }
            }
            return -1;
        } else if (i5 >= positiveMod) {
            int length = this.elementData.length;
            while (true) {
                if (i5 < length) {
                    if (Intrinsics.areEqual(obj, this.elementData[i5])) {
                        i = this.head;
                        break;
                    }
                    i5++;
                } else {
                    for (int i6 = 0; i6 < positiveMod; i6++) {
                        if (Intrinsics.areEqual(obj, this.elementData[i6])) {
                            i5 = i6 + this.elementData.length;
                            i = this.head;
                        }
                    }
                    return -1;
                }
            }
        } else {
            return -1;
        }
        return i5 - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int lastIndex;
        int i;
        int positiveMod = positiveMod(this.head + size());
        int i5 = this.head;
        if (i5 < positiveMod) {
            lastIndex = positiveMod - 1;
            if (i5 <= lastIndex) {
                while (!Intrinsics.areEqual(obj, this.elementData[lastIndex])) {
                    if (lastIndex != i5) {
                        lastIndex--;
                    }
                }
                i = this.head;
                return lastIndex - i;
            }
            return -1;
        }
        if (i5 > positiveMod) {
            int i6 = positiveMod - 1;
            while (true) {
                if (-1 < i6) {
                    if (Intrinsics.areEqual(obj, this.elementData[i6])) {
                        lastIndex = i6 + this.elementData.length;
                        i = this.head;
                        break;
                    }
                    i6--;
                } else {
                    lastIndex = ArraysKt.getLastIndex(this.elementData);
                    int i8 = this.head;
                    if (i8 <= lastIndex) {
                        while (!Intrinsics.areEqual(obj, this.elementData[lastIndex])) {
                            if (lastIndex != i8) {
                                lastIndex--;
                            }
                        }
                        i = this.head;
                    }
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        int positiveMod;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int positiveMod2 = positiveMod(this.head + size());
            int i = this.head;
            if (i < positiveMod2) {
                positiveMod = i;
                while (i < positiveMod2) {
                    Object obj = this.elementData[i];
                    if (!elements.contains(obj)) {
                        this.elementData[positiveMod] = obj;
                        positiveMod++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                ArraysKt.fill(this.elementData, (Object) null, positiveMod, positiveMod2);
            } else {
                int length = this.elementData.length;
                int i5 = i;
                boolean z3 = false;
                while (i < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (!elements.contains(obj2)) {
                        this.elementData[i5] = obj2;
                        i5++;
                    } else {
                        z3 = true;
                    }
                    i++;
                }
                positiveMod = positiveMod(i5);
                for (int i6 = 0; i6 < positiveMod2; i6++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i6];
                    objArr2[i6] = null;
                    if (!elements.contains(obj3)) {
                        this.elementData[positiveMod] = obj3;
                        positiveMod = incremented(positiveMod);
                    } else {
                        z3 = true;
                    }
                }
                z2 = z3;
            }
            if (z2) {
                this.size = negativeMod(positiveMod - this.head);
            }
        }
        return z2;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        if (i == CollectionsKt.getLastIndex(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        int positiveMod = positiveMod(this.head + i);
        E e2 = (E) this.elementData[positiveMod];
        if (i < (size() >> 1)) {
            int i5 = this.head;
            if (positiveMod >= i5) {
                Object[] objArr = this.elementData;
                ArraysKt.copyInto(objArr, objArr, i5 + 1, i5, positiveMod);
            } else {
                Object[] objArr2 = this.elementData;
                ArraysKt.copyInto(objArr2, objArr2, 1, 0, positiveMod);
                Object[] objArr3 = this.elementData;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i6 = this.head;
                ArraysKt.copyInto(objArr3, objArr3, i6 + 1, i6, objArr3.length - 1);
            }
            Object[] objArr4 = this.elementData;
            int i8 = this.head;
            objArr4[i8] = null;
            this.head = incremented(i8);
        } else {
            int positiveMod2 = positiveMod(this.head + CollectionsKt.getLastIndex(this));
            if (positiveMod <= positiveMod2) {
                Object[] objArr5 = this.elementData;
                ArraysKt.copyInto(objArr5, objArr5, positiveMod, positiveMod + 1, positiveMod2 + 1);
            } else {
                Object[] objArr6 = this.elementData;
                ArraysKt.copyInto(objArr6, objArr6, positiveMod, positiveMod + 1, objArr6.length);
                Object[] objArr7 = this.elementData;
                objArr7[objArr7.length - 1] = objArr7[0];
                ArraysKt.copyInto(objArr7, objArr7, 0, 1, positiveMod2 + 1);
            }
            this.elementData[positiveMod2] = null;
        }
        this.size = size() - 1;
        return e2;
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            Object[] objArr = this.elementData;
            int i = this.head;
            E e2 = (E) objArr[i];
            objArr[i] = null;
            this.head = incremented(i);
            this.size = size() - 1;
            return e2;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final E removeLast() {
        if (!isEmpty()) {
            int positiveMod = positiveMod(this.head + CollectionsKt.getLastIndex(this));
            Object[] objArr = this.elementData;
            E e2 = (E) objArr[positiveMod];
            objArr[positiveMod] = null;
            this.size = size() - 1;
            return e2;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        int positiveMod;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int positiveMod2 = positiveMod(this.head + size());
            int i = this.head;
            if (i < positiveMod2) {
                positiveMod = i;
                while (i < positiveMod2) {
                    Object obj = this.elementData[i];
                    if (elements.contains(obj)) {
                        this.elementData[positiveMod] = obj;
                        positiveMod++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                ArraysKt.fill(this.elementData, (Object) null, positiveMod, positiveMod2);
            } else {
                int length = this.elementData.length;
                int i5 = i;
                boolean z3 = false;
                while (i < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (elements.contains(obj2)) {
                        this.elementData[i5] = obj2;
                        i5++;
                    } else {
                        z3 = true;
                    }
                    i++;
                }
                positiveMod = positiveMod(i5);
                for (int i6 = 0; i6 < positiveMod2; i6++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i6];
                    objArr2[i6] = null;
                    if (elements.contains(obj3)) {
                        this.elementData[positiveMod] = obj3;
                        positiveMod = incremented(positiveMod);
                    } else {
                        z3 = true;
                    }
                }
                z2 = z3;
            }
            if (z2) {
                this.size = negativeMod(positiveMod - this.head);
            }
        }
        return z2;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e2) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        int positiveMod = positiveMod(this.head + i);
        Object[] objArr = this.elementData;
        E e3 = (E) objArr[positiveMod];
        objArr[positiveMod] = e2;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (array.length < size()) {
            array = (T[]) ArraysKt__ArraysJVMKt.arrayOfNulls(array, size());
        }
        int positiveMod = positiveMod(this.head + size());
        int i = this.head;
        if (i < positiveMod) {
            ArraysKt.copyInto$default(this.elementData, array, 0, i, positiveMod, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            ArraysKt.copyInto(objArr, array, 0, this.head, objArr.length);
            Object[] objArr2 = this.elementData;
            ArraysKt.copyInto(objArr2, array, objArr2.length - this.head, 0, positiveMod);
        }
        return (T[]) CollectionsKt.terminateCollectionToArray(size(), array);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e2) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, size());
        if (i == size()) {
            addLast(e2);
        } else if (i == 0) {
            addFirst(e2);
        } else {
            ensureCapacity(size() + 1);
            int positiveMod = positiveMod(this.head + i);
            if (i < ((size() + 1) >> 1)) {
                int decremented = decremented(positiveMod);
                int decremented2 = decremented(this.head);
                int i5 = this.head;
                if (decremented >= i5) {
                    Object[] objArr = this.elementData;
                    objArr[decremented2] = objArr[i5];
                    ArraysKt.copyInto(objArr, objArr, i5, i5 + 1, decremented + 1);
                } else {
                    Object[] objArr2 = this.elementData;
                    ArraysKt.copyInto(objArr2, objArr2, i5 - 1, i5, objArr2.length);
                    Object[] objArr3 = this.elementData;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    ArraysKt.copyInto(objArr3, objArr3, 0, 1, decremented + 1);
                }
                this.elementData[decremented] = e2;
                this.head = decremented2;
            } else {
                int positiveMod2 = positiveMod(this.head + size());
                if (positiveMod < positiveMod2) {
                    Object[] objArr4 = this.elementData;
                    ArraysKt.copyInto(objArr4, objArr4, positiveMod + 1, positiveMod, positiveMod2);
                } else {
                    Object[] objArr5 = this.elementData;
                    ArraysKt.copyInto(objArr5, objArr5, 1, 0, positiveMod2);
                    Object[] objArr6 = this.elementData;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    ArraysKt.copyInto(objArr6, objArr6, positiveMod + 1, positiveMod, objArr6.length - 1);
                }
                this.elementData[positiveMod] = e2;
            }
            this.size = size() + 1;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i == size()) {
            return addAll(elements);
        }
        ensureCapacity(size() + elements.size());
        int positiveMod = positiveMod(this.head + size());
        int positiveMod2 = positiveMod(this.head + i);
        int size = elements.size();
        if (i < ((size() + 1) >> 1)) {
            int i5 = this.head;
            int i6 = i5 - size;
            if (positiveMod2 < i5) {
                Object[] objArr = this.elementData;
                ArraysKt.copyInto(objArr, objArr, i6, i5, objArr.length);
                if (size >= positiveMod2) {
                    Object[] objArr2 = this.elementData;
                    ArraysKt.copyInto(objArr2, objArr2, objArr2.length - size, 0, positiveMod2);
                } else {
                    Object[] objArr3 = this.elementData;
                    ArraysKt.copyInto(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.elementData;
                    ArraysKt.copyInto(objArr4, objArr4, 0, size, positiveMod2);
                }
            } else if (i6 >= 0) {
                Object[] objArr5 = this.elementData;
                ArraysKt.copyInto(objArr5, objArr5, i6, i5, positiveMod2);
            } else {
                Object[] objArr6 = this.elementData;
                i6 += objArr6.length;
                int i8 = positiveMod2 - i5;
                int length = objArr6.length - i6;
                if (length >= i8) {
                    ArraysKt.copyInto(objArr6, objArr6, i6, i5, positiveMod2);
                } else {
                    ArraysKt.copyInto(objArr6, objArr6, i6, i5, i5 + length);
                    Object[] objArr7 = this.elementData;
                    ArraysKt.copyInto(objArr7, objArr7, 0, this.head + length, positiveMod2);
                }
            }
            this.head = i6;
            copyCollectionElements(negativeMod(positiveMod2 - size), elements);
        } else {
            int i10 = positiveMod2 + size;
            if (positiveMod2 < positiveMod) {
                int i11 = size + positiveMod;
                Object[] objArr8 = this.elementData;
                if (i11 <= objArr8.length) {
                    ArraysKt.copyInto(objArr8, objArr8, i10, positiveMod2, positiveMod);
                } else if (i10 >= objArr8.length) {
                    ArraysKt.copyInto(objArr8, objArr8, i10 - objArr8.length, positiveMod2, positiveMod);
                } else {
                    int length2 = positiveMod - (i11 - objArr8.length);
                    ArraysKt.copyInto(objArr8, objArr8, 0, length2, positiveMod);
                    Object[] objArr9 = this.elementData;
                    ArraysKt.copyInto(objArr9, objArr9, i10, positiveMod2, length2);
                }
            } else {
                Object[] objArr10 = this.elementData;
                ArraysKt.copyInto(objArr10, objArr10, size, 0, positiveMod);
                Object[] objArr11 = this.elementData;
                if (i10 >= objArr11.length) {
                    ArraysKt.copyInto(objArr11, objArr11, i10 - objArr11.length, positiveMod2, objArr11.length);
                } else {
                    ArraysKt.copyInto(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.elementData;
                    ArraysKt.copyInto(objArr12, objArr12, i10, positiveMod2, objArr12.length - size);
                }
            }
            copyCollectionElements(positiveMod2, elements);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
