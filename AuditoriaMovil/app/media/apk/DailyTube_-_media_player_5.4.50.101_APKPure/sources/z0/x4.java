package z0;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import w0.xc;
import z0.z;
/* loaded from: classes.dex */
public abstract class x4<E> extends z<E> implements List<E>, RandomAccess {

    /* renamed from: v  reason: collision with root package name */
    public static final jz<Object> f15643v = new n3(hw.f15613f, 0);

    /* loaded from: classes.dex */
    public class gv extends x4<E> {

        /* renamed from: fb  reason: collision with root package name */
        public final transient int f15644fb;

        /* renamed from: s  reason: collision with root package name */
        public final transient int f15645s;

        public gv(int i, int i5) {
            this.f15644fb = i;
            this.f15645s = i5;
        }

        @Override // z0.x4, java.util.List
        /* renamed from: dm */
        public x4<E> subList(int i, int i5) {
            xc.mt(i, i5, this.f15645s);
            x4 x4Var = x4.this;
            int i6 = this.f15644fb;
            return x4Var.subList(i + i6, i5 + i6);
        }

        @Override // java.util.List
        public E get(int i) {
            xc.t(i, this.f15645s);
            return x4.this.get(i + this.f15644fb);
        }

        @Override // z0.z
        public int i9() {
            return x4.this.t() + this.f15644fb + this.f15645s;
        }

        @Override // z0.x4, z0.z, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // z0.x4, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // z0.z
        public boolean p() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f15645s;
        }

        @Override // z0.z
        public int t() {
            return x4.this.t() + this.f15644fb;
        }

        @Override // z0.z
        public Object[] v() {
            return x4.this.v();
        }

        @Override // z0.x4, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return super.listIterator(i);
        }
    }

    /* loaded from: classes.dex */
    public static class n3<E> extends z0.y<E> {

        /* renamed from: fb  reason: collision with root package name */
        public final x4<E> f15646fb;

        public n3(x4<E> x4Var, int i) {
            super(x4Var.size(), i);
            this.f15646fb = x4Var;
        }

        @Override // z0.y
        public E y(int i) {
            return this.f15646fb.get(i);
        }
    }

    /* loaded from: classes.dex */
    public static final class y<E> extends z.y<E> {
        public y() {
            this(4);
        }

        @Override // z0.z.n3
        /* renamed from: a */
        public y<E> y(E e2) {
            super.gv(e2);
            return this;
        }

        public y<E> fb(Iterable<? extends E> iterable) {
            super.n3(iterable);
            return this;
        }

        public x4<E> s() {
            this.f15649zn = true;
            return x4.r(this.y, this.f15648n3);
        }

        public y(int i) {
            super(i);
        }
    }

    /* loaded from: classes.dex */
    public static class zn implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        public zn(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return x4.ud(this.elements);
        }
    }

    public static <E> x4<E> co(Object[] objArr) {
        return r(objArr, objArr.length);
    }

    public static <E> x4<E> d(Collection<? extends E> collection) {
        if (collection instanceof z) {
            x4<E> y2 = ((z) collection).y();
            if (y2.p()) {
                return co(y2.toArray());
            }
            return y2;
        }
        return ta(collection.toArray());
    }

    public static <E> x4<E> j(E e2, E e3) {
        return ta(e2, e3);
    }

    public static <E> x4<E> j5() {
        return (x4<E>) hw.f15613f;
    }

    public static <E> x4<E> jz(E e2, E e3, E e5, E e6, E e8) {
        return ta(e2, e3, e5, e6, e8);
    }

    public static <E> x4<E> k(E e2, E e3, E e5) {
        return ta(e2, e3, e5);
    }

    public static <E> x4<E> o(E e2) {
        return ta(e2);
    }

    public static <E> x4<E> r(Object[] objArr, int i) {
        if (i == 0) {
            return j5();
        }
        return new hw(objArr, i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E> x4<E> ta(Object... objArr) {
        return co(k5.n3(objArr));
    }

    public static <E> x4<E> u(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        xc.wz(comparator);
        Object[] f4 = d0.f(iterable);
        k5.n3(f4);
        Arrays.sort(f4, comparator);
        return co(f4);
    }

    public static <E> x4<E> ud(E[] eArr) {
        if (eArr.length == 0) {
            return j5();
        }
        return ta((Object[]) eArr.clone());
    }

    public static <E> y<E> x4() {
        return new y<>();
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // z0.z, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.List
    /* renamed from: dm */
    public x4<E> subList(int i, int i5) {
        xc.mt(i, i5, size());
        int i6 = i5 - i;
        if (i6 == size()) {
            return this;
        }
        if (i6 == 0) {
            return j5();
        }
        return o4(i, i5);
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return mg.zn(this, obj);
    }

    @Override // z0.z
    public int gv(Object[] objArr, int i) {
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            objArr[i + i5] = get(i5);
        }
        return i + size;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i5 = 0; i5 < size; i5++) {
            i = ~(~((i * 31) + get(i5).hashCode()));
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return mg.gv(this, obj);
    }

    @Override // java.util.List
    /* renamed from: k5 */
    public jz<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return mg.a(this, obj);
    }

    @Override // z0.z, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: mt */
    public en<E> iterator() {
        return listIterator();
    }

    public x4<E> o4(int i, int i5) {
        return new gv(i, i5 - i);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // z0.z
    public Object writeReplace() {
        return new zn(toArray());
    }

    @Override // java.util.List
    /* renamed from: yt */
    public jz<E> listIterator(int i) {
        xc.w(i, size());
        if (isEmpty()) {
            return (jz<E>) f15643v;
        }
        return new n3(this, i);
    }

    @Override // z0.z
    @Deprecated
    public final x4<E> y() {
        return this;
    }
}
