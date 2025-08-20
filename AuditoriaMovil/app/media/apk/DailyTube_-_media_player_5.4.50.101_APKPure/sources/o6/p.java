package o6;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class p<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final Comparator<Comparable> y = new y();
    final Comparator<? super K> comparator;
    private p<K, V>.gv entrySet;
    final fb<K, V> header;
    private p<K, V>.v keySet;
    int modCount;
    int size;
    fb<K, V>[] table;
    int threshold;

    /* loaded from: classes.dex */
    public final class gv extends AbstractSet<Map.Entry<K, V>> {
        public gv() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            p.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if ((obj instanceof Map.Entry) && p.this.t((Map.Entry) obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new y(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            fb<K, V> t2;
            if (!(obj instanceof Map.Entry) || (t2 = p.this.t((Map.Entry) obj)) == null) {
                return false;
            }
            p.this.co(t2, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return p.this.size;
        }
    }

    /* loaded from: classes.dex */
    public static final class n3<K, V> {

        /* renamed from: gv  reason: collision with root package name */
        public int f12189gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f12190n3;
        public fb<K, V> y;

        /* renamed from: zn  reason: collision with root package name */
        public int f12191zn;

        public void n3(int i) {
            this.f12190n3 = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.f12189gv = 0;
            this.f12191zn = 0;
            this.y = null;
        }

        public void y(fb<K, V> fbVar) {
            fbVar.f12183fb = null;
            fbVar.y = null;
            fbVar.f12187v = null;
            fbVar.f12181co = 1;
            int i = this.f12190n3;
            if (i > 0) {
                int i5 = this.f12189gv;
                if ((i5 & 1) == 0) {
                    this.f12189gv = i5 + 1;
                    this.f12190n3 = i - 1;
                    this.f12191zn++;
                }
            }
            fbVar.y = this.y;
            this.y = fbVar;
            int i6 = this.f12189gv;
            int i8 = i6 + 1;
            this.f12189gv = i8;
            int i10 = this.f12190n3;
            if (i10 > 0 && (i8 & 1) == 0) {
                this.f12189gv = i6 + 2;
                this.f12190n3 = i10 - 1;
                this.f12191zn++;
            }
            int i11 = 4;
            while (true) {
                int i12 = i11 - 1;
                if ((this.f12189gv & i12) == i12) {
                    int i13 = this.f12191zn;
                    if (i13 == 0) {
                        fb<K, V> fbVar2 = this.y;
                        fb<K, V> fbVar3 = fbVar2.y;
                        fb<K, V> fbVar4 = fbVar3.y;
                        fbVar3.y = fbVar4.y;
                        this.y = fbVar3;
                        fbVar3.f12187v = fbVar4;
                        fbVar3.f12183fb = fbVar2;
                        fbVar3.f12181co = fbVar2.f12181co + 1;
                        fbVar4.y = fbVar3;
                        fbVar2.y = fbVar3;
                    } else if (i13 == 1) {
                        fb<K, V> fbVar5 = this.y;
                        fb<K, V> fbVar6 = fbVar5.y;
                        this.y = fbVar6;
                        fbVar6.f12183fb = fbVar5;
                        fbVar6.f12181co = fbVar5.f12181co + 1;
                        fbVar5.y = fbVar6;
                        this.f12191zn = 0;
                    } else if (i13 == 2) {
                        this.f12191zn = 0;
                    }
                    i11 *= 2;
                } else {
                    return;
                }
            }
        }

        public fb<K, V> zn() {
            fb<K, V> fbVar = this.y;
            if (fbVar.y == null) {
                return fbVar;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes.dex */
    public final class v extends AbstractSet<K> {
        public v() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            p.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return p.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new y(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (p.this.r(obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return p.this.size;
        }
    }

    /* loaded from: classes.dex */
    public class y implements Comparator<Comparable> {
        @Override // java.util.Comparator
        /* renamed from: y */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* loaded from: classes.dex */
    public static class zn<K, V> {
        public fb<K, V> y;

        public void n3(fb<K, V> fbVar) {
            fb<K, V> fbVar2 = null;
            while (fbVar != null) {
                fbVar.y = fbVar2;
                fbVar2 = fbVar;
                fbVar = fbVar.f12187v;
            }
            this.y = fbVar2;
        }

        public fb<K, V> y() {
            fb<K, V> fbVar = this.y;
            if (fbVar == null) {
                return null;
            }
            fb<K, V> fbVar2 = fbVar.y;
            fbVar.y = null;
            fb<K, V> fbVar3 = fbVar.f12183fb;
            while (true) {
                fb<K, V> fbVar4 = fbVar2;
                fbVar2 = fbVar3;
                if (fbVar2 != null) {
                    fbVar2.y = fbVar4;
                    fbVar3 = fbVar2.f12187v;
                } else {
                    this.y = fbVar4;
                    return fbVar;
                }
            }
        }
    }

    public p() {
        this(null);
    }

    public static int ud(int i) {
        int i5 = i ^ ((i >>> 20) ^ (i >>> 12));
        return (i5 >>> 4) ^ ((i5 >>> 7) ^ i5);
    }

    public static <K, V> fb<K, V>[] v(fb<K, V>[] fbVarArr) {
        fb<K, V> fbVar;
        int length = fbVarArr.length;
        fb<K, V>[] fbVarArr2 = new fb[length * 2];
        zn znVar = new zn();
        n3 n3Var = new n3();
        n3 n3Var2 = new n3();
        for (int i = 0; i < length; i++) {
            fb<K, V> fbVar2 = fbVarArr[i];
            if (fbVar2 != null) {
                znVar.n3(fbVar2);
                int i5 = 0;
                int i6 = 0;
                while (true) {
                    fb<K, V> y2 = znVar.y();
                    if (y2 == null) {
                        break;
                    } else if ((y2.f12188w & length) == 0) {
                        i5++;
                    } else {
                        i6++;
                    }
                }
                n3Var.n3(i5);
                n3Var2.n3(i6);
                znVar.n3(fbVar2);
                while (true) {
                    fb<K, V> y7 = znVar.y();
                    if (y7 == null) {
                        break;
                    } else if ((y7.f12188w & length) == 0) {
                        n3Var.y(y7);
                    } else {
                        n3Var2.y(y7);
                    }
                }
                fb<K, V> fbVar3 = null;
                if (i5 > 0) {
                    fbVar = n3Var.zn();
                } else {
                    fbVar = null;
                }
                fbVarArr2[i] = fbVar;
                int i8 = i + length;
                if (i6 > 0) {
                    fbVar3 = n3Var2.zn();
                }
                fbVarArr2[i8] = fbVar3;
            }
        }
        return fbVarArr2;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        fb<K, V> fbVar = this.header;
        fb<K, V> fbVar2 = fbVar.f12185s;
        while (fbVar2 != fbVar) {
            fb<K, V> fbVar3 = fbVar2.f12185s;
            fbVar2.f12182f = null;
            fbVar2.f12185s = null;
            fbVar2 = fbVar3;
        }
        fbVar.f12182f = fbVar;
        fbVar.f12185s = fbVar;
    }

    public void co(fb<K, V> fbVar, boolean z2) {
        fb<K, V> y2;
        int i;
        if (z2) {
            fb<K, V> fbVar2 = fbVar.f12182f;
            fbVar2.f12185s = fbVar.f12185s;
            fbVar.f12185s.f12182f = fbVar2;
            fbVar.f12182f = null;
            fbVar.f12185s = null;
        }
        fb<K, V> fbVar3 = fbVar.f12187v;
        fb<K, V> fbVar4 = fbVar.f12183fb;
        fb<K, V> fbVar5 = fbVar.y;
        int i5 = 0;
        if (fbVar3 != null && fbVar4 != null) {
            if (fbVar3.f12181co > fbVar4.f12181co) {
                y2 = fbVar3.n3();
            } else {
                y2 = fbVar4.y();
            }
            co(y2, false);
            fb<K, V> fbVar6 = fbVar.f12187v;
            if (fbVar6 != null) {
                i = fbVar6.f12181co;
                y2.f12187v = fbVar6;
                fbVar6.y = y2;
                fbVar.f12187v = null;
            } else {
                i = 0;
            }
            fb<K, V> fbVar7 = fbVar.f12183fb;
            if (fbVar7 != null) {
                i5 = fbVar7.f12181co;
                y2.f12183fb = fbVar7;
                fbVar7.y = y2;
                fbVar.f12183fb = null;
            }
            y2.f12181co = Math.max(i, i5) + 1;
            x4(fbVar, y2);
            return;
        }
        if (fbVar3 != null) {
            x4(fbVar, fbVar3);
            fbVar.f12187v = null;
        } else if (fbVar4 != null) {
            x4(fbVar, fbVar4);
            fbVar.f12183fb = null;
        } else {
            x4(fbVar, null);
        }
        mt(fbVar5, false);
        this.size--;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (p(obj) != null) {
            return true;
        }
        return false;
    }

    public final void d(fb<K, V> fbVar) {
        int i;
        int i5;
        fb<K, V> fbVar2 = fbVar.f12187v;
        fb<K, V> fbVar3 = fbVar.f12183fb;
        fb<K, V> fbVar4 = fbVar2.f12187v;
        fb<K, V> fbVar5 = fbVar2.f12183fb;
        fbVar.f12187v = fbVar5;
        if (fbVar5 != null) {
            fbVar5.y = fbVar;
        }
        x4(fbVar, fbVar2);
        fbVar2.f12183fb = fbVar;
        fbVar.y = fbVar2;
        int i6 = 0;
        if (fbVar3 != null) {
            i = fbVar3.f12181co;
        } else {
            i = 0;
        }
        if (fbVar5 != null) {
            i5 = fbVar5.f12181co;
        } else {
            i5 = 0;
        }
        int max = Math.max(i, i5) + 1;
        fbVar.f12181co = max;
        if (fbVar4 != null) {
            i6 = fbVar4.f12181co;
        }
        fbVar2.f12181co = Math.max(max, i6) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        p<K, V>.gv gvVar = this.entrySet;
        if (gvVar == null) {
            p<K, V>.gv gvVar2 = new gv();
            this.entrySet = gvVar2;
            return gvVar2;
        }
        return gvVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        fb<K, V> p2 = p(obj);
        if (p2 != null) {
            return p2.f12184p;
        }
        return null;
    }

    public fb<K, V> i9(K k2, boolean z2) {
        fb<K, V> fbVar;
        int i;
        fb<K, V> fbVar2;
        Comparable comparable;
        int compare;
        fb<K, V> fbVar3;
        Comparator<? super K> comparator = this.comparator;
        fb<K, V>[] fbVarArr = this.table;
        int ud2 = ud(k2.hashCode());
        int length = (fbVarArr.length - 1) & ud2;
        fb<K, V> fbVar4 = fbVarArr[length];
        if (fbVar4 != null) {
            if (comparator == y) {
                comparable = (Comparable) k2;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    compare = comparable.compareTo(fbVar4.f12186t);
                } else {
                    compare = comparator.compare(k2, (K) fbVar4.f12186t);
                }
                if (compare == 0) {
                    return fbVar4;
                }
                if (compare < 0) {
                    fbVar3 = fbVar4.f12187v;
                } else {
                    fbVar3 = fbVar4.f12183fb;
                }
                if (fbVar3 == null) {
                    fbVar = fbVar4;
                    i = compare;
                    break;
                }
                fbVar4 = fbVar3;
            }
        } else {
            fbVar = fbVar4;
            i = 0;
        }
        if (!z2) {
            return null;
        }
        fb<K, V> fbVar5 = this.header;
        if (fbVar == null) {
            if (comparator == y && !(k2 instanceof Comparable)) {
                throw new ClassCastException(k2.getClass().getName() + " is not Comparable");
            }
            fbVar2 = new fb<>(fbVar, k2, ud2, fbVar5, fbVar5.f12182f);
            fbVarArr[length] = fbVar2;
        } else {
            fbVar2 = new fb<>(fbVar, k2, ud2, fbVar5, fbVar5.f12182f);
            if (i < 0) {
                fbVar.f12187v = fbVar2;
            } else {
                fbVar.f12183fb = fbVar2;
            }
            mt(fbVar, true);
        }
        int i5 = this.size;
        this.size = i5 + 1;
        if (i5 > this.threshold) {
            y();
        }
        this.modCount++;
        return fbVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        p<K, V>.v vVar = this.keySet;
        if (vVar == null) {
            p<K, V>.v vVar2 = new v();
            this.keySet = vVar2;
            return vVar2;
        }
        return vVar;
    }

    public final void mt(fb<K, V> fbVar, boolean z2) {
        int i;
        int i5;
        int i6;
        int i8;
        while (fbVar != null) {
            fb<K, V> fbVar2 = fbVar.f12187v;
            fb<K, V> fbVar3 = fbVar.f12183fb;
            int i10 = 0;
            if (fbVar2 != null) {
                i = fbVar2.f12181co;
            } else {
                i = 0;
            }
            if (fbVar3 != null) {
                i5 = fbVar3.f12181co;
            } else {
                i5 = 0;
            }
            int i11 = i - i5;
            if (i11 == -2) {
                fb<K, V> fbVar4 = fbVar3.f12187v;
                fb<K, V> fbVar5 = fbVar3.f12183fb;
                if (fbVar5 != null) {
                    i8 = fbVar5.f12181co;
                } else {
                    i8 = 0;
                }
                if (fbVar4 != null) {
                    i10 = fbVar4.f12181co;
                }
                int i12 = i10 - i8;
                if (i12 != -1 && (i12 != 0 || z2)) {
                    d(fbVar3);
                }
                ta(fbVar);
                if (z2) {
                    return;
                }
            } else if (i11 == 2) {
                fb<K, V> fbVar6 = fbVar2.f12187v;
                fb<K, V> fbVar7 = fbVar2.f12183fb;
                if (fbVar7 != null) {
                    i6 = fbVar7.f12181co;
                } else {
                    i6 = 0;
                }
                if (fbVar6 != null) {
                    i10 = fbVar6.f12181co;
                }
                int i13 = i10 - i6;
                if (i13 != 1 && (i13 != 0 || z2)) {
                    ta(fbVar2);
                }
                d(fbVar);
                if (z2) {
                    return;
                }
            } else if (i11 == 0) {
                fbVar.f12181co = i + 1;
                if (z2) {
                    return;
                }
            } else {
                fbVar.f12181co = Math.max(i, i5) + 1;
                if (!z2) {
                    return;
                }
            }
            fbVar = fbVar.y;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public fb<K, V> p(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return i9(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v2) {
        if (k2 != null) {
            fb<K, V> i92 = i9(k2, true);
            V v3 = i92.f12184p;
            i92.f12184p = v2;
            return v3;
        }
        throw new NullPointerException("key == null");
    }

    public fb<K, V> r(Object obj) {
        fb<K, V> p2 = p(obj);
        if (p2 != null) {
            co(p2, true);
        }
        return p2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        fb<K, V> r2 = r(obj);
        if (r2 != null) {
            return r2.f12184p;
        }
        return null;
    }

    public final boolean s(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public fb<K, V> t(Map.Entry<?, ?> entry) {
        fb<K, V> p2 = p(entry.getKey());
        if (p2 == null || !s(p2.f12184p, entry.getValue())) {
            return null;
        }
        return p2;
    }

    public final void ta(fb<K, V> fbVar) {
        int i;
        int i5;
        fb<K, V> fbVar2 = fbVar.f12187v;
        fb<K, V> fbVar3 = fbVar.f12183fb;
        fb<K, V> fbVar4 = fbVar3.f12187v;
        fb<K, V> fbVar5 = fbVar3.f12183fb;
        fbVar.f12183fb = fbVar4;
        if (fbVar4 != null) {
            fbVar4.y = fbVar;
        }
        x4(fbVar, fbVar3);
        fbVar3.f12187v = fbVar;
        fbVar.y = fbVar3;
        int i6 = 0;
        if (fbVar2 != null) {
            i = fbVar2.f12181co;
        } else {
            i = 0;
        }
        if (fbVar4 != null) {
            i5 = fbVar4.f12181co;
        } else {
            i5 = 0;
        }
        int max = Math.max(i, i5) + 1;
        fbVar.f12181co = max;
        if (fbVar5 != null) {
            i6 = fbVar5.f12181co;
        }
        fbVar3.f12181co = Math.max(max, i6) + 1;
    }

    public final void x4(fb<K, V> fbVar, fb<K, V> fbVar2) {
        fb<K, V> fbVar3 = fbVar.y;
        fbVar.y = null;
        if (fbVar2 != null) {
            fbVar2.y = fbVar3;
        }
        if (fbVar3 != null) {
            if (fbVar3.f12187v == fbVar) {
                fbVar3.f12187v = fbVar2;
                return;
            } else {
                fbVar3.f12183fb = fbVar2;
                return;
            }
        }
        int i = fbVar.f12188w;
        fb<K, V>[] fbVarArr = this.table;
        fbVarArr[i & (fbVarArr.length - 1)] = fbVar2;
    }

    public final void y() {
        fb<K, V>[] v2 = v(this.table);
        this.table = v2;
        this.threshold = (v2.length / 2) + (v2.length / 4);
    }

    public p(Comparator<? super K> comparator) {
        this.comparator = comparator == null ? y : comparator;
        this.header = new fb<>();
        fb<K, V>[] fbVarArr = new fb[16];
        this.table = fbVarArr;
        this.threshold = (fbVarArr.length / 2) + (fbVarArr.length / 4);
    }

    /* loaded from: classes.dex */
    public static final class fb<K, V> implements Map.Entry<K, V> {

        /* renamed from: co  reason: collision with root package name */
        public int f12181co;

        /* renamed from: f  reason: collision with root package name */
        public fb<K, V> f12182f;

        /* renamed from: fb  reason: collision with root package name */
        public fb<K, V> f12183fb;

        /* renamed from: p  reason: collision with root package name */
        public V f12184p;

        /* renamed from: s  reason: collision with root package name */
        public fb<K, V> f12185s;

        /* renamed from: t  reason: collision with root package name */
        public final K f12186t;

        /* renamed from: v  reason: collision with root package name */
        public fb<K, V> f12187v;

        /* renamed from: w  reason: collision with root package name */
        public final int f12188w;
        public fb<K, V> y;

        public fb() {
            this.f12188w = -1;
            this.f12182f = this;
            this.f12185s = this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k2 = this.f12186t;
            if (k2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k2.equals(entry.getKey())) {
                return false;
            }
            V v2 = this.f12184p;
            if (v2 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v2.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f12186t;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f12184p;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            K k2 = this.f12186t;
            int i = 0;
            if (k2 == null) {
                hashCode = 0;
            } else {
                hashCode = k2.hashCode();
            }
            V v2 = this.f12184p;
            if (v2 != null) {
                i = v2.hashCode();
            }
            return hashCode ^ i;
        }

        public fb<K, V> n3() {
            fb<K, V> fbVar = this;
            for (fb<K, V> fbVar2 = this.f12183fb; fbVar2 != null; fbVar2 = fbVar2.f12183fb) {
                fbVar = fbVar2;
            }
            return fbVar;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v2) {
            V v3 = this.f12184p;
            this.f12184p = v2;
            return v3;
        }

        public String toString() {
            return this.f12186t + "=" + this.f12184p;
        }

        public fb<K, V> y() {
            fb<K, V> fbVar = this;
            for (fb<K, V> fbVar2 = this.f12187v; fbVar2 != null; fbVar2 = fbVar2.f12187v) {
                fbVar = fbVar2;
            }
            return fbVar;
        }

        public fb(fb<K, V> fbVar, K k2, int i, fb<K, V> fbVar2, fb<K, V> fbVar3) {
            this.y = fbVar;
            this.f12186t = k2;
            this.f12188w = i;
            this.f12181co = 1;
            this.f12185s = fbVar2;
            this.f12182f = fbVar3;
            fbVar3.f12185s = this;
            fbVar2.f12182f = this;
        }
    }
}
