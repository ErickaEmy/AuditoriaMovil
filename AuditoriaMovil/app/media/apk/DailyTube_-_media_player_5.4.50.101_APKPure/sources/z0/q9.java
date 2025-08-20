package z0;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import w0.xc;
import z0.i9;
/* loaded from: classes.dex */
public final class q9 {

    /* loaded from: classes.dex */
    public static abstract class gv<E> extends AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return q9.c5(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) xc.wz(collection));
        }
    }

    /* loaded from: classes.dex */
    public static class n3<E> extends i9.y<E> implements Set<E> {
        public n3(Set<E> set, w0.w<? super E> wVar) {
            super(set, wVar);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return q9.y(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return q9.gv(this);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class v<E> extends AbstractSet<E> {
        public /* synthetic */ v(ut utVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean add(E e2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public v() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* loaded from: classes.dex */
    public class y<E> extends v<E> {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ Set f15632v;
        public final /* synthetic */ Set y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(Set set, Set set2) {
            super(null);
            this.y = set;
            this.f15632v = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (this.y.contains(obj) && this.f15632v.contains(obj)) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            if (this.y.containsAll(collection) && this.f15632v.containsAll(collection)) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.f15632v, this.y);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int i = 0;
            for (E e2 : this.y) {
                if (this.f15632v.contains(e2)) {
                    i++;
                }
            }
            return i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: y */
        public en<E> iterator() {
            return new y(this);
        }
    }

    /* loaded from: classes.dex */
    public static class zn<E> extends n3<E> implements SortedSet<E> {
        public zn(SortedSet<E> sortedSet, w0.w<? super E> wVar) {
            super(sortedSet, wVar);
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return ((SortedSet) this.y).comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) fh.i9(this.y.iterator(), this.f15616v);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E e2) {
            return new zn(((SortedSet) this.y).headSet(e2), this.f15616v);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [E, java.lang.Object] */
        @Override // java.util.SortedSet
        public E last() {
            SortedSet sortedSet = (SortedSet) this.y;
            while (true) {
                ?? r1 = (Object) sortedSet.last();
                if (this.f15616v.apply(r1)) {
                    return r1;
                }
                sortedSet = sortedSet.headSet(r1);
            }
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E e2, E e3) {
            return new zn(((SortedSet) this.y).subSet(e2, e3), this.f15616v);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E e2) {
            return new zn(((SortedSet) this.y).tailSet(e2), this.f15616v);
        }
    }

    public static <E> HashSet<E> a() {
        return new HashSet<>();
    }

    public static boolean c5(Set<?> set, Collection<?> collection) {
        xc.wz(collection);
        if (collection instanceof a8) {
            collection = ((a8) collection).ct();
        }
        if ((collection instanceof Set) && collection.size() > set.size()) {
            return fh.w(set.iterator(), collection);
        }
        return i9(set, collection.iterator());
    }

    public static <E> HashSet<E> fb(int i) {
        return new HashSet<>(d.y(i));
    }

    public static int gv(Set<?> set) {
        int i;
        int i5 = 0;
        for (Object obj : set) {
            if (obj != null) {
                i = obj.hashCode();
            } else {
                i = 0;
            }
            i5 = ~(~(i5 + i));
        }
        return i5;
    }

    public static boolean i9(Set<?> set, Iterator<?> it) {
        boolean z2 = false;
        while (it.hasNext()) {
            z2 |= set.remove(it.next());
        }
        return z2;
    }

    public static <E> Set<E> n3(Set<E> set, w0.w<? super E> wVar) {
        if (set instanceof SortedSet) {
            return zn((SortedSet) set, wVar);
        }
        if (set instanceof n3) {
            n3 n3Var = (n3) set;
            return new n3((Set) n3Var.y, w0.p.n3(n3Var.f15616v, wVar));
        }
        return new n3((Set) xc.wz(set), (w0.w) xc.wz(wVar));
    }

    public static <E> Set<E> s() {
        return Collections.newSetFromMap(d.a());
    }

    public static <E> v<E> v(Set<E> set, Set<?> set2) {
        xc.xc(set, "set1");
        xc.xc(set2, "set2");
        return new y(set, set2);
    }

    public static boolean y(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <E> SortedSet<E> zn(SortedSet<E> sortedSet, w0.w<? super E> wVar) {
        if (sortedSet instanceof n3) {
            n3 n3Var = (n3) sortedSet;
            return new zn((SortedSet) n3Var.y, w0.p.n3(n3Var.f15616v, wVar));
        }
        return new zn((SortedSet) xc.wz(sortedSet), (w0.w) xc.wz(wVar));
    }
}
