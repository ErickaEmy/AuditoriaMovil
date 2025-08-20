package z0;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import w0.xc;
/* loaded from: classes.dex */
public abstract class c<E> extends z<E> implements Set<E> {

    /* renamed from: v  reason: collision with root package name */
    public transient x4<E> f15556v;

    /* loaded from: classes.dex */
    public static class y implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        public y(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return c.ta(this.elements);
        }
    }

    public static int co(int i) {
        int max = Math.max(i, 2);
        boolean z2 = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (highestOneBit * 0.7d < max) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z2 = false;
        }
        xc.v(z2, "collection too large");
        return 1073741824;
    }

    public static <E> c<E> j(E e2, E e3, E e5, E e6, E e8) {
        return r(5, e2, e3, e5, e6, e8);
    }

    public static <E> c<E> j5(E e2, E e3) {
        return r(2, e2, e3);
    }

    public static boolean k(int i, int i5) {
        if (i < (i5 >> 1) + (i5 >> 2)) {
            return true;
        }
        return false;
    }

    public static <E> c<E> k5() {
        return qn.f15633co;
    }

    public static <E> c<E> o(E e2, E e3, E e5) {
        return r(3, e2, e3, e5);
    }

    public static <E> c<E> r(int i, Object... objArr) {
        if (i != 0) {
            if (i != 1) {
                int co2 = co(i);
                Object[] objArr2 = new Object[co2];
                int i5 = co2 - 1;
                int i6 = 0;
                int i8 = 0;
                for (int i10 = 0; i10 < i; i10++) {
                    Object y2 = k5.y(objArr[i10], i10);
                    int hashCode = y2.hashCode();
                    int n32 = co.n3(hashCode);
                    while (true) {
                        int i11 = n32 & i5;
                        Object obj = objArr2[i11];
                        if (obj == null) {
                            objArr[i8] = y2;
                            objArr2[i11] = y2;
                            i6 += hashCode;
                            i8++;
                            break;
                        } else if (obj.equals(y2)) {
                            break;
                        } else {
                            n32++;
                        }
                    }
                }
                Arrays.fill(objArr, i8, i, (Object) null);
                if (i8 == 1) {
                    Object obj2 = objArr[0];
                    Objects.requireNonNull(obj2);
                    return new k(obj2);
                } else if (co(i8) < co2 / 2) {
                    return r(i8, objArr);
                } else {
                    if (k(i8, objArr.length)) {
                        objArr = Arrays.copyOf(objArr, i8);
                    }
                    return new qn(objArr, i6, objArr2, i5, i8);
                }
            }
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return yt(obj3);
        }
        return k5();
    }

    public static <E> c<E> ta(E[] eArr) {
        int length = eArr.length;
        if (length != 0) {
            if (length != 1) {
                return r(eArr.length, (Object[]) eArr.clone());
            }
            return yt(eArr[0]);
        }
        return k5();
    }

    public static <E> c<E> x4(Collection<? extends E> collection) {
        if ((collection instanceof c) && !(collection instanceof SortedSet)) {
            c<E> cVar = (c) collection;
            if (!cVar.p()) {
                return cVar;
            }
        }
        Object[] array = collection.toArray();
        return r(array.length, array);
    }

    public static <E> c<E> yt(E e2) {
        return new k(e2);
    }

    public x4<E> d() {
        return x4.co(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof c) && ud() && ((c) obj).ud() && hashCode() != obj.hashCode()) {
            return false;
        }
        return q9.y(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return q9.gv(this);
    }

    @Override // z0.z, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: mt */
    public abstract en<E> iterator();

    public boolean ud() {
        return false;
    }

    @Override // z0.z
    public Object writeReplace() {
        return new y(toArray());
    }

    @Override // z0.z
    public x4<E> y() {
        x4<E> x4Var = this.f15556v;
        if (x4Var == null) {
            x4<E> d2 = d();
            this.f15556v = d2;
            return d2;
        }
        return x4Var;
    }
}
