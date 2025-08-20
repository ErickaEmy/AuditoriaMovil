package z0;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import w0.fb;
import w0.xc;
/* loaded from: classes.dex */
public final class fh {

    /* loaded from: classes.dex */
    public static final class gv<T> extends z0.y<T> {

        /* renamed from: f  reason: collision with root package name */
        public static final jz<Object> f15586f = new gv(new Object[0], 0, 0, 0);

        /* renamed from: fb  reason: collision with root package name */
        public final T[] f15587fb;

        /* renamed from: s  reason: collision with root package name */
        public final int f15588s;

        public gv(T[] tArr, int i, int i5, int i6) {
            super(i5, i6);
            this.f15587fb = tArr;
            this.f15588s = i;
        }

        @Override // z0.y
        public T y(int i) {
            return this.f15587fb[this.f15588s + i];
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, F] */
    /* loaded from: classes.dex */
    public class n3<F, T> extends f7<F, T> {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ fb f15589v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n3(Iterator it, fb fbVar) {
            super(it);
            this.f15589v = fbVar;
        }

        @Override // z0.f7
        public T y(F f4) {
            return (T) this.f15589v.apply(f4);
        }
    }

    /* loaded from: classes.dex */
    public enum v implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            c5.zn(false);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class y<T> extends z0.n3<T> {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ Iterator f15591fb;

        /* renamed from: s  reason: collision with root package name */
        public final /* synthetic */ w0.w f15592s;

        public y(Iterator it, w0.w wVar) {
            this.f15591fb = it;
            this.f15592s = wVar;
        }

        @Override // z0.n3
        public T y() {
            while (this.f15591fb.hasNext()) {
                T t2 = (T) this.f15591fb.next();
                if (this.f15592s.apply(t2)) {
                    return t2;
                }
            }
            return n3();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class zn<T> extends en<T> {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ Object f15593v;
        public boolean y;

        public zn(Object obj) {
            this.f15593v = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.y;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.y) {
                this.y = true;
                return (T) this.f15593v;
            }
            throw new NoSuchElementException();
        }
    }

    public static <T> en<T> a() {
        return fb();
    }

    public static <T> en<T> c5(Iterator<T> it, w0.w<? super T> wVar) {
        xc.wz(it);
        xc.wz(wVar);
        return new y(it, wVar);
    }

    public static String co(Iterator<?> it) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean z2 = true;
        while (it.hasNext()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append(it.next());
            z2 = false;
        }
        sb.append(']');
        return sb.toString();
    }

    public static <T> T f(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static <T> jz<T> fb() {
        return (jz<T>) gv.f15586f;
    }

    public static boolean gv(Iterator<?> it, Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> T i9(Iterator<T> it, w0.w<? super T> wVar) {
        xc.wz(it);
        xc.wz(wVar);
        while (it.hasNext()) {
            T next = it.next();
            if (wVar.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    public static <T> en<T> mt(T t2) {
        return new zn(t2);
    }

    public static <T> boolean n3(Iterator<T> it, w0.w<? super T> wVar) {
        if (wz(it, wVar) != -1) {
            return true;
        }
        return false;
    }

    public static <T> boolean p(Iterator<T> it, w0.w<? super T> wVar) {
        xc.wz(wVar);
        boolean z2 = false;
        while (it.hasNext()) {
            if (wVar.apply(it.next())) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static <T> Iterator<T> s() {
        return v.INSTANCE;
    }

    public static <T> T t(Iterator<? extends T> it, T t2) {
        if (it.hasNext()) {
            return (T) f(it);
        }
        return t2;
    }

    public static <T> T tl(Iterator<? extends T> it, T t2) {
        if (it.hasNext()) {
            return it.next();
        }
        return t2;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean v(java.util.Iterator<?> r3, java.util.Iterator<?> r4) {
        /*
        L0:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L1d
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 != 0) goto Le
            return r1
        Le:
            java.lang.Object r0 = r3.next()
            java.lang.Object r2 = r4.next()
            boolean r0 = w0.f.y(r0, r2)
            if (r0 != 0) goto L0
            return r1
        L1d:
            boolean r3 = r4.hasNext()
            r3 = r3 ^ 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.fh.v(java.util.Iterator, java.util.Iterator):boolean");
    }

    public static boolean w(Iterator<?> it, Collection<?> collection) {
        xc.wz(collection);
        boolean z2 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static <T> int wz(Iterator<T> it, w0.w<? super T> wVar) {
        xc.xc(wVar, "predicate");
        int i = 0;
        while (it.hasNext()) {
            if (wVar.apply(it.next())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static <T> T xc(Iterator<T> it) {
        if (it.hasNext()) {
            T next = it.next();
            it.remove();
            return next;
        }
        return null;
    }

    public static <T> boolean y(Collection<T> collection, Iterator<? extends T> it) {
        xc.wz(collection);
        xc.wz(it);
        boolean z2 = false;
        while (it.hasNext()) {
            z2 |= collection.add(it.next());
        }
        return z2;
    }

    public static <F, T> Iterator<T> z(Iterator<F> it, fb<? super F, ? extends T> fbVar) {
        xc.wz(fbVar);
        return new n3(it, fbVar);
    }

    public static void zn(Iterator<?> it) {
        xc.wz(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }
}
