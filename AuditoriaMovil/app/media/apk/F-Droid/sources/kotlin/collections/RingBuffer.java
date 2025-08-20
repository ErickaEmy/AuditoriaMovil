package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: SlidingWindow.kt */
/* loaded from: classes.dex */
final class RingBuffer extends AbstractList implements RandomAccess {
    private final Object[] buffer;
    private final int capacity;
    private int size;
    private int startIndex;

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.size;
    }

    public RingBuffer(Object[] buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
        if (i < 0) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i).toString());
        } else if (i > buffer.length) {
            throw new IllegalArgumentException(("ring buffer filled size: " + i + " cannot be larger than the buffer size: " + buffer.length).toString());
        } else {
            this.capacity = buffer.length;
            this.size = i;
        }
    }

    public RingBuffer(int i) {
        this(new Object[i], 0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public Object get(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        return this.buffer[(this.startIndex + i) % this.capacity];
    }

    public final boolean isFull() {
        return size() == this.capacity;
    }

    @Override // kotlin.collections.AbstractList, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new AbstractIterator() { // from class: kotlin.collections.RingBuffer$iterator$1
            private int count;
            private int index;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i;
                this.count = RingBuffer.this.size();
                i = RingBuffer.this.startIndex;
                this.index = i;
            }

            @Override // kotlin.collections.AbstractIterator
            protected void computeNext() {
                Object[] objArr;
                if (this.count != 0) {
                    objArr = RingBuffer.this.buffer;
                    setNext(objArr[this.index]);
                    this.index = (this.index + 1) % RingBuffer.this.capacity;
                    this.count--;
                    return;
                }
                done();
            }
        };
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public Object[] toArray(Object[] array) {
        Object[] terminateCollectionToArray;
        Intrinsics.checkNotNullParameter(array, "array");
        if (array.length < size()) {
            array = Arrays.copyOf(array, size());
            Intrinsics.checkNotNullExpressionValue(array, "copyOf(...)");
        }
        int size = size();
        int i = 0;
        int i2 = 0;
        for (int i3 = this.startIndex; i2 < size && i3 < this.capacity; i3++) {
            array[i2] = this.buffer[i3];
            i2++;
        }
        while (i2 < size) {
            array[i2] = this.buffer[i];
            i2++;
            i++;
        }
        terminateCollectionToArray = CollectionsKt__CollectionsJVMKt.terminateCollectionToArray(size, array);
        return terminateCollectionToArray;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public final RingBuffer expanded(int i) {
        int coerceAtMost;
        Object[] array;
        int i2 = this.capacity;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(i2 + (i2 >> 1) + 1, i);
        if (this.startIndex == 0) {
            array = Arrays.copyOf(this.buffer, coerceAtMost);
            Intrinsics.checkNotNullExpressionValue(array, "copyOf(...)");
        } else {
            array = toArray(new Object[coerceAtMost]);
        }
        return new RingBuffer(array, size());
    }

    @Override // java.util.Collection, java.util.List
    public final void add(Object obj) {
        if (isFull()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.buffer[(this.startIndex + size()) % this.capacity] = obj;
        this.size = size() + 1;
    }

    public final void removeFirst(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i).toString());
        } else if (i > size()) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i + ", size = " + size()).toString());
        } else if (i > 0) {
            int i2 = this.startIndex;
            int i3 = (i2 + i) % this.capacity;
            if (i2 > i3) {
                ArraysKt___ArraysJvmKt.fill(this.buffer, (Object) null, i2, this.capacity);
                ArraysKt___ArraysJvmKt.fill(this.buffer, (Object) null, 0, i3);
            } else {
                ArraysKt___ArraysJvmKt.fill(this.buffer, (Object) null, i2, i3);
            }
            this.startIndex = i3;
            this.size = size() - i;
        }
    }
}
