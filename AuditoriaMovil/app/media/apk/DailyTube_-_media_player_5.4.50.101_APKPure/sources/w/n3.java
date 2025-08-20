package w;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class n3<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: fb  reason: collision with root package name */
    public WeakHashMap<a<K, V>, Boolean> f14492fb = new WeakHashMap<>();

    /* renamed from: s  reason: collision with root package name */
    public int f14493s = 0;

    /* renamed from: v  reason: collision with root package name */
    public zn<K, V> f14494v;
    public zn<K, V> y;

    /* loaded from: classes.dex */
    public interface a<K, V> {
        void y(@NonNull zn<K, V> znVar);
    }

    /* loaded from: classes.dex */
    public class gv implements Iterator<Map.Entry<K, V>>, a<K, V> {

        /* renamed from: v  reason: collision with root package name */
        public boolean f14496v = true;
        public zn<K, V> y;

        public gv() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f14496v) {
                if (n3.this.y == null) {
                    return false;
                }
                return true;
            }
            zn<K, V> znVar = this.y;
            if (znVar == null || znVar.f14498fb == null) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        /* renamed from: n3 */
        public Map.Entry<K, V> next() {
            zn<K, V> znVar;
            if (this.f14496v) {
                this.f14496v = false;
                this.y = n3.this.y;
            } else {
                zn<K, V> znVar2 = this.y;
                if (znVar2 != null) {
                    znVar = znVar2.f14498fb;
                } else {
                    znVar = null;
                }
                this.y = znVar;
            }
            return this.y;
        }

        @Override // w.n3.a
        public void y(@NonNull zn<K, V> znVar) {
            boolean z2;
            zn<K, V> znVar2 = this.y;
            if (znVar == znVar2) {
                zn<K, V> znVar3 = znVar2.f14499s;
                this.y = znVar3;
                if (znVar3 == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.f14496v = z2;
            }
        }
    }

    /* renamed from: w.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0240n3<K, V> extends v<K, V> {
        public C0240n3(zn<K, V> znVar, zn<K, V> znVar2) {
            super(znVar, znVar2);
        }

        @Override // w.n3.v
        public zn<K, V> n3(zn<K, V> znVar) {
            return znVar.f14498fb;
        }

        @Override // w.n3.v
        public zn<K, V> zn(zn<K, V> znVar) {
            return znVar.f14499s;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class v<K, V> implements Iterator<Map.Entry<K, V>>, a<K, V> {

        /* renamed from: v  reason: collision with root package name */
        public zn<K, V> f14497v;
        public zn<K, V> y;

        public v(zn<K, V> znVar, zn<K, V> znVar2) {
            this.y = znVar2;
            this.f14497v = znVar;
        }

        @Override // java.util.Iterator
        /* renamed from: gv */
        public Map.Entry<K, V> next() {
            zn<K, V> znVar = this.f14497v;
            this.f14497v = v();
            return znVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f14497v != null) {
                return true;
            }
            return false;
        }

        public abstract zn<K, V> n3(zn<K, V> znVar);

        public final zn<K, V> v() {
            zn<K, V> znVar = this.f14497v;
            zn<K, V> znVar2 = this.y;
            if (znVar != znVar2 && znVar2 != null) {
                return zn(znVar);
            }
            return null;
        }

        @Override // w.n3.a
        public void y(@NonNull zn<K, V> znVar) {
            if (this.y == znVar && znVar == this.f14497v) {
                this.f14497v = null;
                this.y = null;
            }
            zn<K, V> znVar2 = this.y;
            if (znVar2 == znVar) {
                this.y = n3(znVar2);
            }
            if (this.f14497v == znVar) {
                this.f14497v = v();
            }
        }

        public abstract zn<K, V> zn(zn<K, V> znVar);
    }

    /* loaded from: classes.dex */
    public static class y<K, V> extends v<K, V> {
        public y(zn<K, V> znVar, zn<K, V> znVar2) {
            super(znVar, znVar2);
        }

        @Override // w.n3.v
        public zn<K, V> n3(zn<K, V> znVar) {
            return znVar.f14499s;
        }

        @Override // w.n3.v
        public zn<K, V> zn(zn<K, V> znVar) {
            return znVar.f14498fb;
        }
    }

    /* loaded from: classes.dex */
    public static class zn<K, V> implements Map.Entry<K, V> {

        /* renamed from: fb  reason: collision with root package name */
        public zn<K, V> f14498fb;

        /* renamed from: s  reason: collision with root package name */
        public zn<K, V> f14499s;
        @NonNull

        /* renamed from: v  reason: collision with root package name */
        public final V f14500v;
        @NonNull
        public final K y;

        public zn(@NonNull K k2, @NonNull V v2) {
            this.y = k2;
            this.f14500v = v2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zn)) {
                return false;
            }
            zn znVar = (zn) obj;
            if (this.y.equals(znVar.y) && this.f14500v.equals(znVar.f14500v)) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            return this.y;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public V getValue() {
            return this.f14500v;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.y.hashCode() ^ this.f14500v.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v2) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.y + "=" + this.f14500v;
        }
    }

    public V a(@NonNull K k2, @NonNull V v2) {
        zn<K, V> n32 = n3(k2);
        if (n32 != null) {
            return n32.f14500v;
        }
        v(k2, v2);
        return null;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0240n3 c0240n3 = new C0240n3(this.f14494v, this.y);
        this.f14492fb.put(c0240n3, Boolean.FALSE);
        return c0240n3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n3)) {
            return false;
        }
        n3 n3Var = (n3) obj;
        if (size() != n3Var.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = n3Var.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        if (!it.hasNext() && !it2.hasNext()) {
            return true;
        }
        return false;
    }

    public V fb(@NonNull K k2) {
        zn<K, V> n32 = n3(k2);
        if (n32 == null) {
            return null;
        }
        this.f14493s--;
        if (!this.f14492fb.isEmpty()) {
            for (a<K, V> aVar : this.f14492fb.keySet()) {
                aVar.y(n32);
            }
        }
        zn<K, V> znVar = n32.f14499s;
        if (znVar != null) {
            znVar.f14498fb = n32.f14498fb;
        } else {
            this.y = n32.f14498fb;
        }
        zn<K, V> znVar2 = n32.f14498fb;
        if (znVar2 != null) {
            znVar2.f14499s = znVar;
        } else {
            this.f14494v = znVar;
        }
        n32.f14498fb = null;
        n32.f14499s = null;
        return n32.f14500v;
    }

    public Map.Entry<K, V> gv() {
        return this.f14494v;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().hashCode();
        }
        return i;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        y yVar = new y(this.y, this.f14494v);
        this.f14492fb.put(yVar, Boolean.FALSE);
        return yVar;
    }

    public zn<K, V> n3(K k2) {
        zn<K, V> znVar = this.y;
        while (znVar != null && !znVar.y.equals(k2)) {
            znVar = znVar.f14498fb;
        }
        return znVar;
    }

    public int size() {
        return this.f14493s;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public zn<K, V> v(@NonNull K k2, @NonNull V v2) {
        zn<K, V> znVar = new zn<>(k2, v2);
        this.f14493s++;
        zn<K, V> znVar2 = this.f14494v;
        if (znVar2 == null) {
            this.y = znVar;
            this.f14494v = znVar;
            return znVar;
        }
        znVar2.f14498fb = znVar;
        znVar.f14499s = znVar2;
        this.f14494v = znVar;
        return znVar;
    }

    public Map.Entry<K, V> y() {
        return this.y;
    }

    public n3<K, V>.gv zn() {
        n3<K, V>.gv gvVar = new gv();
        this.f14492fb.put(gvVar, Boolean.FALSE);
        return gvVar;
    }
}
