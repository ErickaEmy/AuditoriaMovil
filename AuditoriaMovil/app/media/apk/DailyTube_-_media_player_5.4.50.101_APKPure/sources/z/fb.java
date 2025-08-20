package z;

import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class fb<K, V> {
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public fb<K, V>.zn f15517n3;
    @Nullable
    public fb<K, V>.n3 y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public fb<K, V>.v f15518zn;

    /* loaded from: classes.dex */
    public final class gv implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: fb  reason: collision with root package name */
        public boolean f15519fb;

        /* renamed from: v  reason: collision with root package name */
        public int f15521v = -1;
        public int y;

        public gv() {
            this.y = fb.this.gv() - 1;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this.f15519fb) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!z.gv.zn(entry.getKey(), fb.this.n3(this.f15521v, 0)) || !z.gv.zn(entry.getValue(), fb.this.n3(this.f15521v, 1))) {
                    return false;
                }
                return true;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f15519fb) {
                return (K) fb.this.n3(this.f15521v, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f15519fb) {
                return (V) fb.this.n3(this.f15521v, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f15521v < this.y) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            if (this.f15519fb) {
                int i = 0;
                Object n32 = fb.this.n3(this.f15521v, 0);
                Object n33 = fb.this.n3(this.f15521v, 1);
                if (n32 == null) {
                    hashCode = 0;
                } else {
                    hashCode = n32.hashCode();
                }
                if (n33 != null) {
                    i = n33.hashCode();
                }
                return hashCode ^ i;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f15519fb) {
                fb.this.s(this.f15521v);
                this.f15521v--;
                this.y--;
                this.f15519fb = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v2) {
            if (this.f15519fb) {
                return (V) fb.this.c5(this.f15521v, v2);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }

        @Override // java.util.Iterator
        /* renamed from: y */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f15521v++;
                this.f15519fb = true;
                return this;
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: classes.dex */
    public final class n3 implements Set<Map.Entry<K, V>> {
        public n3() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int gv2 = fb.this.gv();
            for (Map.Entry<K, V> entry : collection) {
                fb.this.fb(entry.getKey(), entry.getValue());
            }
            if (gv2 != fb.this.gv()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            fb.this.y();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int v2 = fb.this.v(entry.getKey());
            if (v2 < 0) {
                return false;
            }
            return z.gv.zn(fb.this.n3(v2, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return fb.f(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int hashCode;
            int hashCode2;
            int i = 0;
            for (int gv2 = fb.this.gv() - 1; gv2 >= 0; gv2--) {
                Object n32 = fb.this.n3(gv2, 0);
                Object n33 = fb.this.n3(gv2, 1);
                if (n32 == null) {
                    hashCode = 0;
                } else {
                    hashCode = n32.hashCode();
                }
                if (n33 == null) {
                    hashCode2 = 0;
                } else {
                    hashCode2 = n33.hashCode();
                }
                i += hashCode ^ hashCode2;
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            if (fb.this.gv() == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new gv();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return fb.this.gv();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: y */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    public final class v implements Collection<V> {
        public v() {
        }

        @Override // java.util.Collection
        public boolean add(V v2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            fb.this.y();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            if (fb.this.a(obj) >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            if (fb.this.gv() == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new y(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int a2 = fb.this.a(obj);
            if (a2 >= 0) {
                fb.this.s(a2);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int gv2 = fb.this.gv();
            int i = 0;
            boolean z2 = false;
            while (i < gv2) {
                if (collection.contains(fb.this.n3(i, 1))) {
                    fb.this.s(i);
                    i--;
                    gv2--;
                    z2 = true;
                }
                i++;
            }
            return z2;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int gv2 = fb.this.gv();
            int i = 0;
            boolean z2 = false;
            while (i < gv2) {
                if (!collection.contains(fb.this.n3(i, 1))) {
                    fb.this.s(i);
                    i--;
                    gv2--;
                    z2 = true;
                }
                i++;
            }
            return z2;
        }

        @Override // java.util.Collection
        public int size() {
            return fb.this.gv();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return fb.this.p(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) fb.this.mt(tArr, 1);
        }
    }

    /* loaded from: classes.dex */
    public final class y<T> implements Iterator<T> {

        /* renamed from: fb  reason: collision with root package name */
        public int f15523fb;

        /* renamed from: s  reason: collision with root package name */
        public boolean f15524s;

        /* renamed from: v  reason: collision with root package name */
        public int f15525v;
        public final int y;

        public y(int i) {
            this.y = i;
            this.f15525v = fb.this.gv();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f15523fb < this.f15525v) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T t2 = (T) fb.this.n3(this.f15523fb, this.y);
                this.f15523fb++;
                this.f15524s = true;
                return t2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f15524s) {
                int i = this.f15523fb - 1;
                this.f15523fb = i;
                this.f15525v--;
                this.f15524s = false;
                fb.this.s(i);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes.dex */
    public final class zn implements Set<K> {
        public zn() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            fb.this.y();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (fb.this.v(obj) >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return fb.i9(fb.this.zn(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return fb.f(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int hashCode;
            int i = 0;
            for (int gv2 = fb.this.gv() - 1; gv2 >= 0; gv2--) {
                Object n32 = fb.this.n3(gv2, 0);
                if (n32 == null) {
                    hashCode = 0;
                } else {
                    hashCode = n32.hashCode();
                }
                i += hashCode;
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            if (fb.this.gv() == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new y(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int v2 = fb.this.v(obj);
            if (v2 >= 0) {
                fb.this.s(v2);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return fb.xc(fb.this.zn(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return fb.w(fb.this.zn(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return fb.this.gv();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return fb.this.p(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) fb.this.mt(tArr, 0);
        }
    }

    public static <T> boolean f(Set<T> set, Object obj) {
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

    public static <K, V> boolean i9(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean w(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    public static <K, V> boolean xc(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    public abstract int a(Object obj);

    public abstract V c5(int i, V v2);

    public abstract void fb(K k2, V v2);

    public abstract int gv();

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] mt(T[] tArr, int i) {
        int gv2 = gv();
        if (tArr.length < gv2) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), gv2));
        }
        for (int i5 = 0; i5 < gv2; i5++) {
            tArr[i5] = n3(i5, i);
        }
        if (tArr.length > gv2) {
            tArr[gv2] = null;
        }
        return tArr;
    }

    public abstract Object n3(int i, int i5);

    public Object[] p(int i) {
        int gv2 = gv();
        Object[] objArr = new Object[gv2];
        for (int i5 = 0; i5 < gv2; i5++) {
            objArr[i5] = n3(i5, i);
        }
        return objArr;
    }

    public abstract void s(int i);

    public Set<Map.Entry<K, V>> t() {
        if (this.y == null) {
            this.y = new n3();
        }
        return this.y;
    }

    public Set<K> tl() {
        if (this.f15517n3 == null) {
            this.f15517n3 = new zn();
        }
        return this.f15517n3;
    }

    public abstract int v(Object obj);

    public Collection<V> wz() {
        if (this.f15518zn == null) {
            this.f15518zn = new v();
        }
        return this.f15518zn;
    }

    public abstract void y();

    public abstract Map<K, V> zn();
}
