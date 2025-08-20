package z0;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import w0.xc;
/* loaded from: classes.dex */
public final class i9 {

    /* loaded from: classes.dex */
    public static class y<E> extends AbstractCollection<E> {

        /* renamed from: v  reason: collision with root package name */
        public final w0.w<? super E> f15616v;
        public final Collection<E> y;

        public y(Collection<E> collection, w0.w<? super E> wVar) {
            this.y = collection;
            this.f15616v = wVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(E e2) {
            xc.gv(this.f15616v.apply(e2));
            return this.y.add(e2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            for (E e2 : collection) {
                xc.gv(this.f15616v.apply(e2));
            }
            return this.y.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            d0.s(this.y, this.f15616v);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (i9.zn(this.y, obj)) {
                return this.f15616v.apply(obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return i9.y(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !d0.y(this.y, this.f15616v);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return fh.c5(this.y.iterator(), this.f15616v);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            if (contains(obj) && this.y.remove(obj)) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Iterator<E> it = this.y.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.f15616v.apply(next) && collection.contains(next)) {
                    it.remove();
                    z2 = true;
                }
            }
            return z2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Iterator<E> it = this.y.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.f15616v.apply(next) && !collection.contains(next)) {
                    it.remove();
                    z2 = true;
                }
            }
            return z2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (E e2 : this.y) {
                if (this.f15616v.apply(e2)) {
                    i++;
                }
            }
            return i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return mg.c5(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) mg.c5(iterator()).toArray(tArr);
        }
    }

    public static StringBuilder n3(int i) {
        c5.n3(i, "size");
        return new StringBuilder((int) Math.min(i * 8, 1073741824L));
    }

    public static boolean y(Collection<?> collection, Collection<?> collection2) {
        Iterator<?> it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean zn(Collection<?> collection, Object obj) {
        xc.wz(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }
}
