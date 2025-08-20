package z0;

import java.util.NoSuchElementException;
import w0.xc;
/* loaded from: classes.dex */
public abstract class y<E> extends jz<E> {

    /* renamed from: v  reason: collision with root package name */
    public int f15647v;
    public final int y;

    public y(int i, int i5) {
        xc.w(i5, i);
        this.y = i;
        this.f15647v = i5;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        if (this.f15647v < this.y) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.f15647v > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i = this.f15647v;
            this.f15647v = i + 1;
            return y(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f15647v;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i = this.f15647v - 1;
            this.f15647v = i;
            return y(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f15647v - 1;
    }

    public abstract E y(int i);
}
