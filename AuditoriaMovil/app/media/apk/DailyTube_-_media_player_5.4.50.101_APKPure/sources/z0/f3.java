package z0;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import z0.z;
/* loaded from: classes.dex */
public abstract class f3<K, V> implements Map<K, V>, Serializable {

    /* renamed from: s  reason: collision with root package name */
    public static final Map.Entry<?, ?>[] f15580s = new Map.Entry[0];

    /* renamed from: fb  reason: collision with root package name */
    public transient z<V> f15581fb;

    /* renamed from: v  reason: collision with root package name */
    public transient c<K> f15582v;
    public transient c<Map.Entry<K, V>> y;

    /* loaded from: classes.dex */
    public static class n3<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object keys;
        private final Object values;

        public n3(f3<K, V> f3Var) {
            Object[] objArr = new Object[f3Var.size()];
            Object[] objArr2 = new Object[f3Var.size()];
            en<Map.Entry<K, V>> it = f3Var.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                objArr[i] = next.getKey();
                objArr2[i] = next.getValue();
                i++;
            }
            this.keys = objArr;
            this.values = objArr2;
        }

        public y<K, V> gv(int i) {
            return new y<>(i);
        }

        public final Object readResolve() {
            Object obj = this.keys;
            if (!(obj instanceof c)) {
                return y();
            }
            c cVar = (c) obj;
            y<K, V> gv2 = gv(cVar.size());
            en it = cVar.iterator();
            en it2 = ((z) this.values).iterator();
            while (it.hasNext()) {
                gv2.gv((K) it.next(), (V) it2.next());
            }
            return gv2.y();
        }

        public final Object y() {
            Object[] objArr = (Object[]) this.keys;
            Object[] objArr2 = (Object[]) this.values;
            y<K, V> gv2 = gv(objArr.length);
            for (int i = 0; i < objArr.length; i++) {
                gv2.gv((K) objArr[i], (V) objArr2[i]);
            }
            return gv2.y();
        }
    }

    /* loaded from: classes.dex */
    public static class y<K, V> {

        /* renamed from: gv  reason: collision with root package name */
        public boolean f15583gv;

        /* renamed from: n3  reason: collision with root package name */
        public Object[] f15584n3;
        public Comparator<? super V> y;

        /* renamed from: zn  reason: collision with root package name */
        public int f15585zn;

        public y() {
            this(4);
        }

        public y<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                zn(this.f15585zn + ((Collection) iterable).size());
            }
            for (Map.Entry<? extends K, ? extends V> entry : iterable) {
                v(entry);
            }
            return this;
        }

        public void fb() {
            int i;
            if (this.y != null) {
                if (this.f15583gv) {
                    this.f15584n3 = Arrays.copyOf(this.f15584n3, this.f15585zn * 2);
                }
                Map.Entry[] entryArr = new Map.Entry[this.f15585zn];
                int i5 = 0;
                while (true) {
                    i = this.f15585zn;
                    if (i5 >= i) {
                        break;
                    }
                    int i6 = i5 * 2;
                    Object obj = this.f15584n3[i6];
                    Objects.requireNonNull(obj);
                    Object obj2 = this.f15584n3[i6 + 1];
                    Objects.requireNonNull(obj2);
                    entryArr[i5] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
                    i5++;
                }
                Arrays.sort(entryArr, 0, i, yt.y(this.y).i9(d.f()));
                for (int i8 = 0; i8 < this.f15585zn; i8++) {
                    int i10 = i8 * 2;
                    this.f15584n3[i10] = entryArr[i8].getKey();
                    this.f15584n3[i10 + 1] = entryArr[i8].getValue();
                }
            }
        }

        public y<K, V> gv(K k2, V v2) {
            zn(this.f15585zn + 1);
            c5.y(k2, v2);
            Object[] objArr = this.f15584n3;
            int i = this.f15585zn;
            objArr[i * 2] = k2;
            objArr[(i * 2) + 1] = v2;
            this.f15585zn = i + 1;
            return this;
        }

        public f3<K, V> n3() {
            fb();
            this.f15583gv = true;
            return j5.ud(this.f15585zn, this.f15584n3);
        }

        public y<K, V> v(Map.Entry<? extends K, ? extends V> entry) {
            return gv(entry.getKey(), entry.getValue());
        }

        public f3<K, V> y() {
            return n3();
        }

        public final void zn(int i) {
            int i5 = i * 2;
            Object[] objArr = this.f15584n3;
            if (i5 > objArr.length) {
                this.f15584n3 = Arrays.copyOf(objArr, z.n3.zn(objArr.length, i5));
                this.f15583gv = false;
            }
        }

        public y(int i) {
            this.f15584n3 = new Object[i * 2];
        }
    }

    public static <K, V> f3<K, V> s(Map<? extends K, ? extends V> map) {
        if ((map instanceof f3) && !(map instanceof SortedMap)) {
            f3<K, V> f3Var = (f3) map;
            if (!f3Var.co()) {
                return f3Var;
            }
        }
        return v(map.entrySet());
    }

    public static <K, V> f3<K, V> ta(K k2, V v2) {
        c5.y(k2, v2);
        return j5.ud(1, new Object[]{k2, v2});
    }

    public static <K, V> f3<K, V> v(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        int i;
        if (iterable instanceof Collection) {
            i = ((Collection) iterable).size();
        } else {
            i = 4;
        }
        y yVar = new y(i);
        yVar.a(iterable);
        return yVar.y();
    }

    public static <K, V> f3<K, V> x4() {
        return (f3<K, V>) j5.f15617p;
    }

    public static <K, V> y<K, V> y() {
        return new y<>();
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean co();

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    /* renamed from: d */
    public z<V> values() {
        z<V> zVar = this.f15581fb;
        if (zVar == null) {
            z<V> p2 = p();
            this.f15581fb = p2;
            return p2;
        }
        return zVar;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return d.zn(this, obj);
    }

    @Override // java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map
    public final V getOrDefault(Object obj, V v2) {
        V v3 = get(obj);
        if (v3 != null) {
            return v3;
        }
        return v2;
    }

    @Override // java.util.Map
    public int hashCode() {
        return q9.gv(entrySet());
    }

    public abstract c<Map.Entry<K, V>> i9();

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    /* renamed from: mt */
    public c<Map.Entry<K, V>> entrySet() {
        c<Map.Entry<K, V>> cVar = this.y;
        if (cVar == null) {
            c<Map.Entry<K, V>> i92 = i9();
            this.y = i92;
            return i92;
        }
        return cVar;
    }

    public abstract z<V> p();

    @Override // java.util.Map
    @Deprecated
    public final V put(K k2, V v2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    /* renamed from: r */
    public c<K> keySet() {
        c<K> cVar = this.f15582v;
        if (cVar == null) {
            c<K> t2 = t();
            this.f15582v = t2;
            return t2;
        }
        return cVar;
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public abstract c<K> t();

    public String toString() {
        return d.i9(this);
    }

    public Object writeReplace() {
        return new n3(this);
    }
}
