package z0;

import java.util.NoSuchElementException;
import w0.xc;
/* loaded from: classes.dex */
public abstract class n3<T> extends en<T> {

    /* renamed from: v  reason: collision with root package name */
    public T f15631v;
    public n3 y = n3.v;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        boolean z2;
        if (this.y != n3.s) {
            z2 = true;
        } else {
            z2 = false;
        }
        xc.co(z2);
        int i = y.y[this.y.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        return zn();
    }

    public final T n3() {
        this.y = n3.fb;
        return null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.y = n3.v;
            T t2 = (T) b.y(this.f15631v);
            this.f15631v = null;
            return t2;
        }
        throw new NoSuchElementException();
    }

    public abstract T y();

    public final boolean zn() {
        this.y = n3.s;
        this.f15631v = y();
        if (this.y != n3.fb) {
            this.y = n3.y;
            return true;
        }
        return false;
    }
}
