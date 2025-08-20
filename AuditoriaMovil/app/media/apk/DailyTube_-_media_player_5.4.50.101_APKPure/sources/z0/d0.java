package z0;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import w0.fb;
import w0.xc;
/* loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class n3<T> extends w<T> {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ fb f15560fb;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ Iterable f15561v;

        public n3(Iterable iterable, fb fbVar) {
            this.f15561v = iterable;
            this.f15560fb = fbVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return fh.z(this.f15561v.iterator(), this.f15560fb);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class y<T> extends w<T> {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ w0.w f15562fb;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ Iterable f15563v;

        public y(Iterable iterable, w0.w wVar) {
            this.f15563v = iterable;
            this.f15562fb = wVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return fh.c5(this.f15563v.iterator(), this.f15562fb);
        }
    }

    public static <T> T a(Iterable<? extends T> iterable, T t2) {
        if (iterable instanceof Collection) {
            if (((Collection) iterable).isEmpty()) {
                return t2;
            }
            if (iterable instanceof List) {
                return (T) fb(mg.y(iterable));
            }
        }
        return (T) fh.t(iterable.iterator(), t2);
    }

    public static <T> boolean c5(List<T> list, w0.w<? super T> wVar) {
        int i = 0;
        int i5 = 0;
        while (i < list.size()) {
            T t2 = list.get(i);
            if (!wVar.apply(t2)) {
                if (i > i5) {
                    try {
                        list.set(i5, t2);
                    } catch (IllegalArgumentException unused) {
                        i9(list, wVar, i5, i);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        i9(list, wVar, i5, i);
                        return true;
                    }
                }
                i5++;
            }
            i++;
        }
        list.subList(i5, list.size()).clear();
        if (i == i5) {
            return false;
        }
        return true;
    }

    public static Object[] f(Iterable<?> iterable) {
        return n3(iterable).toArray();
    }

    public static <T> T fb(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> T gv(Iterable<? extends T> iterable, T t2) {
        return (T) fh.tl(iterable.iterator(), t2);
    }

    public static <T> void i9(List<T> list, w0.w<? super T> wVar, int i, int i5) {
        for (int size = list.size() - 1; size > i5; size--) {
            if (wVar.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i6 = i5 - 1; i6 >= i; i6--) {
            list.remove(i6);
        }
    }

    public static <E> Collection<E> n3(Iterable<E> iterable) {
        if (iterable instanceof Collection) {
            return (Collection) iterable;
        }
        return mg.c5(iterable.iterator());
    }

    public static <T> boolean s(Iterable<T> iterable, w0.w<? super T> wVar) {
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            return c5((List) iterable, (w0.w) xc.wz(wVar));
        }
        return fh.p(iterable.iterator(), wVar);
    }

    public static String t(Iterable<?> iterable) {
        return fh.co(iterable.iterator());
    }

    public static <F, T> Iterable<T> tl(Iterable<F> iterable, fb<? super F, ? extends T> fbVar) {
        xc.wz(iterable);
        xc.wz(fbVar);
        return new n3(iterable, fbVar);
    }

    public static <T> T v(Iterable<T> iterable) {
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (!list.isEmpty()) {
                return (T) fb(list);
            }
            throw new NoSuchElementException();
        }
        return (T) fh.f(iterable.iterator());
    }

    public static <T> boolean y(Iterable<T> iterable, w0.w<? super T> wVar) {
        return fh.n3(iterable.iterator(), wVar);
    }

    public static <T> Iterable<T> zn(Iterable<T> iterable, w0.w<? super T> wVar) {
        xc.wz(iterable);
        xc.wz(wVar);
        return new y(iterable, wVar);
    }
}
