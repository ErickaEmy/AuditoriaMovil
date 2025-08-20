package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
/* loaded from: classes.dex */
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    private static final AtomicIntegerFieldUpdater _size$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size");
    private volatile int _size;

    /* renamed from: a  reason: collision with root package name */
    private T[] f9988a;

    private final T[] realloc() {
        T[] tArr = this.f9988a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new ThreadSafeHeapNode[4];
            this.f9988a = tArr2;
            return tArr2;
        } else if (getSize() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, getSize() * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            T[] tArr3 = (T[]) ((ThreadSafeHeapNode[]) copyOf);
            this.f9988a = tArr3;
            return tArr3;
        } else {
            return tArr;
        }
    }

    private final void setSize(int i) {
        _size$FU.set(this, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
        if (((java.lang.Comparable) r3).compareTo(r4) < 0) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void siftDownFrom(int r6) {
        /*
            r5 = this;
        L0:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.getSize()
            if (r1 < r2) goto Lb
            return
        Lb:
            T extends kotlinx.coroutines.internal.ThreadSafeHeapNode & java.lang.Comparable<? super T>[] r2 = r5.f9988a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r0 = r0 + 2
            int r3 = r5.getSize()
            if (r0 >= r3) goto L2b
            r3 = r2[r0]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L2b
            goto L2c
        L2b:
            r0 = r1
        L2c:
            r1 = r2[r6]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L3f
            return
        L3f:
            r5.swap(r6, r0)
            r6 = r0
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ThreadSafeHeap.siftDownFrom(int):void");
    }

    private final void siftUpFrom(int i) {
        while (i > 0) {
            T[] tArr = this.f9988a;
            Intrinsics.checkNotNull(tArr);
            int i5 = (i - 1) / 2;
            T t2 = tArr[i5];
            Intrinsics.checkNotNull(t2);
            T t3 = tArr[i];
            Intrinsics.checkNotNull(t3);
            if (((Comparable) t2).compareTo(t3) <= 0) {
                return;
            }
            swap(i, i5);
            i = i5;
        }
    }

    private final void swap(int i, int i5) {
        T[] tArr = this.f9988a;
        Intrinsics.checkNotNull(tArr);
        T t2 = tArr[i5];
        Intrinsics.checkNotNull(t2);
        T t3 = tArr[i];
        Intrinsics.checkNotNull(t3);
        tArr[i] = t2;
        tArr[i5] = t3;
        t2.setIndex(i);
        t3.setIndex(i5);
    }

    public final void addImpl(T t2) {
        if (DebugKt.getASSERTIONS_ENABLED() && t2.getHeap() != null) {
            throw new AssertionError();
        }
        t2.setHeap(this);
        T[] realloc = realloc();
        int size = getSize();
        setSize(size + 1);
        realloc[size] = t2;
        t2.setIndex(size);
        siftUpFrom(size);
    }

    public final T firstImpl() {
        T[] tArr = this.f9988a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int getSize() {
        return _size$FU.get(this);
    }

    public final boolean isEmpty() {
        if (getSize() == 0) {
            return true;
        }
        return false;
    }

    public final T peek() {
        T firstImpl;
        synchronized (this) {
            firstImpl = firstImpl();
        }
        return firstImpl;
    }

    public final boolean remove(T t2) {
        boolean z2;
        synchronized (this) {
            try {
                if (t2.getHeap() == null) {
                    z2 = false;
                } else {
                    int index = t2.getIndex();
                    if (DebugKt.getASSERTIONS_ENABLED() && index < 0) {
                        throw new AssertionError();
                    }
                    removeAtImpl(index);
                    z2 = true;
                }
            } finally {
            }
        }
        return z2;
    }

    public final T removeAtImpl(int i) {
        if (DebugKt.getASSERTIONS_ENABLED() && getSize() <= 0) {
            throw new AssertionError();
        }
        T[] tArr = this.f9988a;
        Intrinsics.checkNotNull(tArr);
        setSize(getSize() - 1);
        if (i < getSize()) {
            swap(i, getSize());
            int i5 = (i - 1) / 2;
            if (i > 0) {
                T t2 = tArr[i];
                Intrinsics.checkNotNull(t2);
                T t3 = tArr[i5];
                Intrinsics.checkNotNull(t3);
                if (((Comparable) t2).compareTo(t3) < 0) {
                    swap(i, i5);
                    siftUpFrom(i5);
                }
            }
            siftDownFrom(i);
        }
        T t4 = tArr[getSize()];
        Intrinsics.checkNotNull(t4);
        if (DebugKt.getASSERTIONS_ENABLED() && t4.getHeap() != this) {
            throw new AssertionError();
        }
        t4.setHeap(null);
        t4.setIndex(-1);
        tArr[getSize()] = null;
        return t4;
    }

    public final T removeFirstOrNull() {
        T t2;
        synchronized (this) {
            if (getSize() > 0) {
                t2 = removeAtImpl(0);
            } else {
                t2 = null;
            }
        }
        return t2;
    }
}
