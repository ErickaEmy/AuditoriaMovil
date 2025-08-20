package z0;

import java.util.Iterator;
import w0.xc;
/* loaded from: classes.dex */
public abstract class f7<F, T> implements Iterator<T> {
    public final Iterator<? extends F> y;

    public f7(Iterator<? extends F> it) {
        this.y = (Iterator) xc.wz(it);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.y.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return y(this.y.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.y.remove();
    }

    public abstract T y(F f4);
}
