package z0;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import w0.xc;
import z0.x4;
/* loaded from: classes.dex */
public abstract class z<E> extends AbstractCollection<E> implements Serializable {
    public static final Object[] y = new Object[0];

    /* loaded from: classes.dex */
    public static abstract class n3<E> {
        public static int zn(int i, int i5) {
            if (i5 >= 0) {
                int i6 = i + (i >> 1) + 1;
                if (i6 < i5) {
                    i6 = Integer.highestOneBit(i5 - 1) << 1;
                }
                if (i6 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i6;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        public n3<E> n3(Iterable<? extends E> iterable) {
            for (E e2 : iterable) {
                y(e2);
            }
            return this;
        }

        public abstract n3<E> y(E e2);
    }

    /* loaded from: classes.dex */
    public static abstract class y<E> extends n3<E> {

        /* renamed from: n3  reason: collision with root package name */
        public int f15648n3;
        public Object[] y;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f15649zn;

        public y(int i) {
            c5.n3(i, "initialCapacity");
            this.y = new Object[i];
            this.f15648n3 = 0;
        }

        public y<E> gv(E e2) {
            xc.wz(e2);
            v(this.f15648n3 + 1);
            Object[] objArr = this.y;
            int i = this.f15648n3;
            this.f15648n3 = i + 1;
            objArr[i] = e2;
            return this;
        }

        @Override // z0.z.n3
        public n3<E> n3(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                v(this.f15648n3 + collection.size());
                if (collection instanceof z) {
                    this.f15648n3 = ((z) collection).gv(this.y, this.f15648n3);
                    return this;
                }
            }
            super.n3(iterable);
            return this;
        }

        public final void v(int i) {
            Object[] objArr = this.y;
            if (objArr.length < i) {
                this.y = Arrays.copyOf(objArr, n3.zn(objArr.length, i));
                this.f15649zn = false;
            } else if (this.f15649zn) {
                this.y = (Object[]) objArr.clone();
                this.f15649zn = false;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    public int gv(Object[] objArr, int i) {
        en<E> it = iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return i;
    }

    public int i9() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: mt */
    public abstract en<E> iterator();

    public abstract boolean p();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public int t() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(y);
    }

    public Object[] v() {
        return null;
    }

    public Object writeReplace() {
        return new x4.zn(toArray());
    }

    public x4<E> y() {
        if (isEmpty()) {
            return x4.j5();
        }
        return x4.co(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        xc.wz(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] v2 = v();
            if (v2 != null) {
                return (T[]) vl.y(v2, t(), i9(), tArr);
            }
            tArr = (T[]) k5.gv(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        gv(tArr, 0);
        return tArr;
    }
}
