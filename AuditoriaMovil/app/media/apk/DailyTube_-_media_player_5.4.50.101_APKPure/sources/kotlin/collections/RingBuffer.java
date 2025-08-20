package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* loaded from: classes.dex */
final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {
    private final Object[] buffer;
    private final int capacity;
    private int size;
    private int startIndex;

    public RingBuffer(Object[] buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
        if (i >= 0) {
            if (i <= buffer.length) {
                this.capacity = buffer.length;
                this.size = i;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i + " cannot be larger than the buffer size: " + buffer.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i).toString());
    }

    @Override // java.util.Collection, java.util.List
    public final void add(T t2) {
        if (!isFull()) {
            this.buffer[(this.startIndex + size()) % this.capacity] = t2;
            this.size = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RingBuffer<T> expanded(int i) {
        Object[] array;
        int i5 = this.capacity;
        int coerceAtMost = RangesKt.coerceAtMost(i5 + (i5 >> 1) + 1, i);
        if (this.startIndex == 0) {
            array = Arrays.copyOf(this.buffer, coerceAtMost);
            Intrinsics.checkNotNullExpressionValue(array, "copyOf(...)");
        } else {
            array = toArray(new Object[coerceAtMost]);
        }
        return new RingBuffer<>(array, size());
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        return (T) this.buffer[(this.startIndex + i) % this.capacity];
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.size;
    }

    public final boolean isFull() {
        if (size() == this.capacity) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new AbstractIterator<T>(this) { // from class: kotlin.collections.RingBuffer$iterator$1
            private int count;
            private int index;
            final /* synthetic */ RingBuffer<T> this$0;

            {
                int i;
                this.this$0 = this;
                this.count = this.size();
                i = ((RingBuffer) this).startIndex;
                this.index = i;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.collections.AbstractIterator
            public void computeNext() {
                Object[] objArr;
                if (this.count != 0) {
                    objArr = ((RingBuffer) this.this$0).buffer;
                    setNext(objArr[this.index]);
                    this.index = (this.index + 1) % ((RingBuffer) this.this$0).capacity;
                    this.count--;
                    return;
                }
                done();
            }
        };
    }

    public final void removeFirst(int i) {
        if (i >= 0) {
            if (i <= size()) {
                if (i > 0) {
                    int i5 = this.startIndex;
                    int i6 = (i5 + i) % this.capacity;
                    if (i5 > i6) {
                        ArraysKt.fill(this.buffer, (Object) null, i5, this.capacity);
                        ArraysKt.fill(this.buffer, (Object) null, 0, i6);
                    } else {
                        ArraysKt.fill(this.buffer, (Object) null, i5, i6);
                    }
                    this.startIndex = i6;
                    this.size = size() - i;
                    return;
                }
                return;
            }
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i + ", size = " + size()).toString());
        }
        throw new IllegalArgumentException(("n shouldn't be negative but it is " + i).toString());
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        int length = array.length;
        T[] tArr = array;
        if (length < size()) {
            T[] tArr2 = (T[]) Arrays.copyOf(array, size());
            Intrinsics.checkNotNullExpressionValue(tArr2, "copyOf(...)");
            tArr = tArr2;
        }
        int size = size();
        int i = 0;
        int i5 = 0;
        for (int i6 = this.startIndex; i5 < size && i6 < this.capacity; i6++) {
            tArr[i5] = this.buffer[i6];
            i5++;
        }
        while (i5 < size) {
            tArr[i5] = this.buffer[i];
            i5++;
            i++;
        }
        return (T[]) CollectionsKt.terminateCollectionToArray(size, tArr);
    }

    public RingBuffer(int i) {
        this(new Object[i], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
