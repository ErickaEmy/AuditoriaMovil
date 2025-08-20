package z0;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import w0.xc;
/* loaded from: classes.dex */
public class f<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: z  reason: collision with root package name */
    public static final Object f15565z = new Object();

    /* renamed from: co  reason: collision with root package name */
    public transient Collection<V> f15566co;

    /* renamed from: f  reason: collision with root package name */
    public transient int f15567f;

    /* renamed from: fb  reason: collision with root package name */
    public transient Object[] f15568fb;

    /* renamed from: p  reason: collision with root package name */
    public transient Set<Map.Entry<K, V>> f15569p;

    /* renamed from: s  reason: collision with root package name */
    public transient Object[] f15570s;

    /* renamed from: t  reason: collision with root package name */
    public transient int f15571t;

    /* renamed from: v  reason: collision with root package name */
    public transient int[] f15572v;

    /* renamed from: w  reason: collision with root package name */
    public transient Set<K> f15573w;
    public transient Object y;

    /* loaded from: classes.dex */
    public class a extends AbstractSet<K> {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            f.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return f.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return f.this.rb();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> ct2 = f.this.ct();
            if (ct2 != null) {
                return ct2.keySet().remove(obj);
            }
            if (f.this.g(obj) != f.f15565z) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return f.this.size();
        }
    }

    /* loaded from: classes.dex */
    public class gv extends AbstractSet<Map.Entry<K, V>> {
        public gv() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            f.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map<K, V> ct2 = f.this.ct();
            if (ct2 != null) {
                return ct2.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int ap2 = f.this.ap(entry.getKey());
            if (ap2 == -1 || !w0.f.y(f.this.cy(ap2), entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return f.this.lc();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> ct2 = f.this.ct();
            if (ct2 != null) {
                return ct2.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!f.this.m()) {
                int e2 = f.this.e();
                int a2 = t.a(entry.getKey(), entry.getValue(), e2, f.this.y4(), f.this.u0(), f.this.bk(), f.this.tg());
                if (a2 == -1) {
                    return false;
                }
                f.this.g3(a2, e2);
                f.t(f.this);
                f.this.s8();
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return f.this.size();
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends f<K, V>.v<Map.Entry<K, V>> {
        public n3() {
            super(f.this, null);
        }

        @Override // z0.f.v
        /* renamed from: gv */
        public Map.Entry<K, V> n3(int i) {
            return new fb(f.this, i);
        }
    }

    /* loaded from: classes.dex */
    public class s extends AbstractCollection<V> {
        public s() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            f.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return f.this.qk();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return f.this.size();
        }
    }

    /* loaded from: classes.dex */
    public class y extends f<K, V>.v<K> {
        public y() {
            super(f.this, null);
        }

        @Override // z0.f.v
        public K n3(int i) {
            return (K) f.this.kp(i);
        }
    }

    /* loaded from: classes.dex */
    public class zn extends f<K, V>.v<V> {
        public zn() {
            super(f.this, null);
        }

        @Override // z0.f.v
        public V n3(int i) {
            return (V) f.this.cy(i);
        }
    }

    public f() {
        yg(3);
    }

    public static <K, V> f<K, V> dm(int i) {
        return new f<>(i);
    }

    public static <K, V> f<K, V> o() {
        return new f<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            yg(readInt);
            for (int i = 0; i < readInt; i++) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
            return;
        }
        StringBuilder sb = new StringBuilder(25);
        sb.append("Invalid size: ");
        sb.append(readInt);
        throw new InvalidObjectException(sb.toString());
    }

    public static /* synthetic */ int t(f fVar) {
        int i = fVar.f15571t;
        fVar.f15571t = i - 1;
        return i;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<Map.Entry<K, V>> lc2 = lc();
        while (lc2.hasNext()) {
            Map.Entry<K, V> next = lc2.next();
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeObject(next.getValue());
        }
    }

    public final void ad(int i, V v2) {
        tg()[i] = v2;
    }

    public final int ap(Object obj) {
        if (m()) {
            return -1;
        }
        int zn2 = co.zn(obj);
        int e2 = e();
        int s2 = t.s(y4(), zn2 & e2);
        if (s2 == 0) {
            return -1;
        }
        int n32 = t.n3(zn2, e2);
        do {
            int i = s2 - 1;
            int o42 = o4(i);
            if (t.n3(o42, e2) == n32 && w0.f.y(obj, kp(i))) {
                return i;
            }
            s2 = t.zn(o42, e2);
        } while (s2 != 0);
        return -1;
    }

    public final Object[] bk() {
        Object[] objArr = this.f15568fb;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (m()) {
            return;
        }
        s8();
        Map<K, V> ct2 = ct();
        if (ct2 != null) {
            this.f15567f = d1.a.a(size(), 3, 1073741823);
            ct2.clear();
            this.y = null;
            this.f15571t = 0;
            return;
        }
        Arrays.fill(bk(), 0, this.f15571t, (Object) null);
        Arrays.fill(tg(), 0, this.f15571t, (Object) null);
        t.fb(y4());
        Arrays.fill(u0(), 0, this.f15571t, 0);
        this.f15571t = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map<K, V> ct2 = ct();
        if (ct2 != null) {
            return ct2.containsKey(obj);
        }
        if (ap(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map<K, V> ct2 = ct();
        if (ct2 != null) {
            return ct2.containsValue(obj);
        }
        for (int i = 0; i < this.f15571t; i++) {
            if (w0.f.y(obj, cy(i))) {
                return true;
            }
        }
        return false;
    }

    public final int cr(int i, int i5, int i6, int i8) {
        Object y2 = t.y(i5);
        int i10 = i5 - 1;
        if (i8 != 0) {
            t.c5(y2, i6 & i10, i8 + 1);
        }
        Object y42 = y4();
        int[] u02 = u0();
        for (int i11 = 0; i11 <= i; i11++) {
            int s2 = t.s(y42, i11);
            while (s2 != 0) {
                int i12 = s2 - 1;
                int i13 = u02[i12];
                int n32 = t.n3(i13, i) | i11;
                int i14 = n32 & i10;
                int s3 = t.s(y2, i14);
                t.c5(y2, i14, s2);
                u02[i12] = t.gv(n32, s3, i10);
                s2 = t.zn(i13, i);
            }
        }
        this.y = y2;
        xb(i10);
        return i10;
    }

    public Map<K, V> ct() {
        Object obj = this.y;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final V cy(int i) {
        return (V) tg()[i];
    }

    public final int e() {
        return (1 << (this.f15567f & 31)) - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f15569p;
        if (set == null) {
            Set<Map.Entry<K, V>> j2 = j();
            this.f15569p = j2;
            return j2;
        }
        return set;
    }

    public final Object g(Object obj) {
        if (m()) {
            return f15565z;
        }
        int e2 = e();
        int a2 = t.a(obj, null, e2, y4(), u0(), bk(), null);
        if (a2 == -1) {
            return f15565z;
        }
        V cy2 = cy(a2);
        g3(a2, e2);
        this.f15571t--;
        s8();
        return cy2;
    }

    public void g3(int i, int i5) {
        Object y42 = y4();
        int[] u02 = u0();
        Object[] bk2 = bk();
        Object[] tg2 = tg();
        int size = size();
        int i6 = size - 1;
        if (i < i6) {
            Object obj = bk2[i6];
            bk2[i] = obj;
            tg2[i] = tg2[i6];
            bk2[i6] = null;
            tg2[i6] = null;
            u02[i] = u02[i6];
            u02[i6] = 0;
            int zn2 = co.zn(obj) & i5;
            int s2 = t.s(y42, zn2);
            if (s2 == size) {
                t.c5(y42, zn2, i + 1);
                return;
            }
            while (true) {
                int i8 = s2 - 1;
                int i10 = u02[i8];
                int zn3 = t.zn(i10, i5);
                if (zn3 == size) {
                    u02[i8] = t.gv(i10, i + 1, i5);
                    return;
                }
                s2 = zn3;
            }
        } else {
            bk2[i] = null;
            tg2[i] = null;
            u02[i] = 0;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Map<K, V> ct2 = ct();
        if (ct2 != null) {
            return ct2.get(obj);
        }
        int ap2 = ap(obj);
        if (ap2 == -1) {
            return null;
        }
        b(ap2);
        return cy(ap2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public Set<Map.Entry<K, V>> j() {
        return new gv();
    }

    public Map<K, V> j5() {
        Map<K, V> k2 = k(e() + 1);
        int nf2 = nf();
        while (nf2 >= 0) {
            k2.put(kp(nf2), cy(nf2));
            nf2 = ra(nf2);
        }
        this.y = k2;
        this.f15572v = null;
        this.f15568fb = null;
        this.f15570s = null;
        s8();
        return k2;
    }

    public Set<K> jz() {
        return new a();
    }

    public Map<K, V> k(int i) {
        return new LinkedHashMap(i, 1.0f);
    }

    public int k5(int i, int i5) {
        return i - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f15573w;
        if (set == null) {
            Set<K> jz2 = jz();
            this.f15573w = jz2;
            return jz2;
        }
        return set;
    }

    public final K kp(int i) {
        return (K) bk()[i];
    }

    public Iterator<Map.Entry<K, V>> lc() {
        Map<K, V> ct2 = ct();
        if (ct2 != null) {
            return ct2.entrySet().iterator();
        }
        return new n3();
    }

    public boolean m() {
        if (this.y == null) {
            return true;
        }
        return false;
    }

    public int nf() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    public final void o0(int i, int i5) {
        u0()[i] = i5;
    }

    public final int o4(int i) {
        return u0()[i];
    }

    public final void pq(int i) {
        int min;
        int length = u0().length;
        if (i > length && (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            pz(min);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v2) {
        int cr2;
        int i;
        if (m()) {
            yt();
        }
        Map<K, V> ct2 = ct();
        if (ct2 != null) {
            return ct2.put(k2, v2);
        }
        int[] u02 = u0();
        Object[] bk2 = bk();
        Object[] tg2 = tg();
        int i5 = this.f15571t;
        int i6 = i5 + 1;
        int zn2 = co.zn(k2);
        int e2 = e();
        int i8 = zn2 & e2;
        int s2 = t.s(y4(), i8);
        if (s2 == 0) {
            if (i6 > e2) {
                cr2 = cr(e2, t.v(e2), zn2, i5);
                i = cr2;
            } else {
                t.c5(y4(), i8, i6);
                i = e2;
            }
        } else {
            int n32 = t.n3(zn2, e2);
            int i10 = 0;
            while (true) {
                int i11 = s2 - 1;
                int i12 = u02[i11];
                if (t.n3(i12, e2) == n32 && w0.f.y(k2, bk2[i11])) {
                    V v3 = (V) tg2[i11];
                    tg2[i11] = v2;
                    b(i11);
                    return v3;
                }
                int zn3 = t.zn(i12, e2);
                i10++;
                if (zn3 == 0) {
                    if (i10 >= 9) {
                        return j5().put(k2, v2);
                    }
                    if (i6 > e2) {
                        cr2 = cr(e2, t.v(e2), zn2, i5);
                    } else {
                        u02[i11] = t.gv(i12, i6, e2);
                    }
                } else {
                    s2 = zn3;
                }
            }
        }
        pq(i6);
        yc(i5, k2, v2, zn2, i);
        this.f15571t = i6;
        s8();
        return null;
    }

    public void pz(int i) {
        this.f15572v = Arrays.copyOf(u0(), i);
        this.f15568fb = Arrays.copyOf(bk(), i);
        this.f15570s = Arrays.copyOf(tg(), i);
    }

    public Iterator<V> qk() {
        Map<K, V> ct2 = ct();
        if (ct2 != null) {
            return ct2.values().iterator();
        }
        return new zn();
    }

    public int ra(int i) {
        int i5 = i + 1;
        if (i5 >= this.f15571t) {
            return -1;
        }
        return i5;
    }

    public Iterator<K> rb() {
        Map<K, V> ct2 = ct();
        if (ct2 != null) {
            return ct2.keySet().iterator();
        }
        return new y();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Map<K, V> ct2 = ct();
        if (ct2 != null) {
            return ct2.remove(obj);
        }
        V v2 = (V) g(obj);
        if (v2 == f15565z) {
            return null;
        }
        return v2;
    }

    public void s8() {
        this.f15567f += 32;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> ct2 = ct();
        if (ct2 != null) {
            return ct2.size();
        }
        return this.f15571t;
    }

    public final Object[] tg() {
        Object[] objArr = this.f15570s;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public Collection<V> u() {
        return new s();
    }

    public final int[] u0() {
        int[] iArr = this.f15572v;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f15566co;
        if (collection == null) {
            Collection<V> u2 = u();
            this.f15566co = u2;
            return u2;
        }
        return collection;
    }

    public final void wf(int i, K k2) {
        bk()[i] = k2;
    }

    public final void xb(int i) {
        this.f15567f = t.gv(this.f15567f, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    public final Object y4() {
        Object obj = this.y;
        Objects.requireNonNull(obj);
        return obj;
    }

    public void yc(int i, K k2, V v2, int i5, int i6) {
        o0(i, t.gv(i5, 0, i6));
        wf(i, k2);
        ad(i, v2);
    }

    public void yg(int i) {
        boolean z2;
        if (i >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        xc.v(z2, "Expected size must be >= 0");
        this.f15567f = d1.a.a(i, 1, 1073741823);
    }

    public int yt() {
        xc.z(m(), "Arrays already allocated");
        int i = this.f15567f;
        int i92 = t.i9(i);
        this.y = t.y(i92);
        xb(i92 - 1);
        this.f15572v = new int[i];
        this.f15568fb = new Object[i];
        this.f15570s = new Object[i];
        return i;
    }

    public f(int i) {
        yg(i);
    }

    /* loaded from: classes.dex */
    public abstract class v<T> implements Iterator<T> {

        /* renamed from: fb  reason: collision with root package name */
        public int f15575fb;

        /* renamed from: v  reason: collision with root package name */
        public int f15577v;
        public int y;

        public v() {
            this.y = f.this.f15567f;
            this.f15577v = f.this.nf();
            this.f15575fb = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f15577v >= 0) {
                return true;
            }
            return false;
        }

        public abstract T n3(int i);

        @Override // java.util.Iterator
        public T next() {
            y();
            if (hasNext()) {
                int i = this.f15577v;
                this.f15575fb = i;
                T n32 = n3(i);
                this.f15577v = f.this.ra(this.f15577v);
                return n32;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z2;
            y();
            if (this.f15575fb >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            c5.zn(z2);
            zn();
            f fVar = f.this;
            fVar.remove(fVar.kp(this.f15575fb));
            this.f15577v = f.this.k5(this.f15577v, this.f15575fb);
            this.f15575fb = -1;
        }

        public final void y() {
            if (f.this.f15567f == this.y) {
                return;
            }
            throw new ConcurrentModificationException();
        }

        public void zn() {
            this.y += 32;
        }

        public /* synthetic */ v(f fVar, y yVar) {
            this();
        }
    }

    public void b(int i) {
    }
}
