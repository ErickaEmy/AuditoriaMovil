package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.ranges.RangesKt;
/* loaded from: classes.dex */
public final class ResizableAtomicArray<T> {
    private volatile AtomicReferenceArray<T> array;

    public ResizableAtomicArray(int i) {
        this.array = new AtomicReferenceArray<>(i);
    }

    public final int currentLength() {
        return this.array.length();
    }

    public final T get(int i) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        if (i < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(i);
        }
        return null;
    }

    public final void setSynchronized(int i, T t2) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (i < length) {
            atomicReferenceArray.set(i, t2);
            return;
        }
        AtomicReferenceArray<T> atomicReferenceArray2 = new AtomicReferenceArray<>(RangesKt.coerceAtLeast(i + 1, length * 2));
        for (int i5 = 0; i5 < length; i5++) {
            atomicReferenceArray2.set(i5, atomicReferenceArray.get(i5));
        }
        atomicReferenceArray2.set(i, t2);
        this.array = atomicReferenceArray2;
    }
}
