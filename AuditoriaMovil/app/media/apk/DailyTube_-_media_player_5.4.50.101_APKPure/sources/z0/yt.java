package z0;

import java.util.Comparator;
import java.util.Map;
import w0.fb;
/* loaded from: classes.dex */
public abstract class yt<T> implements Comparator<T> {
    public static <C extends Comparable> yt<C> v() {
        return x.y;
    }

    public static <T> yt<T> y(Comparator<T> comparator) {
        if (comparator instanceof yt) {
            return (yt) comparator;
        }
        return new tl(comparator);
    }

    @Override // java.util.Comparator
    public abstract int compare(T t2, T t3);

    public <E extends T> x4<E> gv(Iterable<E> iterable) {
        return x4.u(this, iterable);
    }

    public <F> yt<F> i9(fb<F, ? extends T> fbVar) {
        return new s(fbVar, this);
    }

    public <T2 extends T> yt<Map.Entry<T2, ?>> s() {
        return (yt<Map.Entry<T2, ?>>) i9(d.v());
    }

    public <S extends T> yt<S> t() {
        return new j(this);
    }
}
