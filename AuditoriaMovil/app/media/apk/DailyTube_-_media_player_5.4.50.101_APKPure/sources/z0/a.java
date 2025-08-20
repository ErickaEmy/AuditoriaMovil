package z0;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import z0.ud;
/* loaded from: classes.dex */
public abstract class a<K, V> implements z6<K, V> {

    /* renamed from: fb  reason: collision with root package name */
    public transient Collection<V> f15553fb;

    /* renamed from: s  reason: collision with root package name */
    public transient Map<K, Collection<V>> f15554s;

    /* renamed from: v  reason: collision with root package name */
    public transient Set<K> f15555v;
    public transient Collection<Map.Entry<K, V>> y;

    /* loaded from: classes.dex */
    public class n3 extends AbstractCollection<V> {
        public n3() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return a.this.a(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return a.this.co();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a.this.size();
        }
    }

    /* loaded from: classes.dex */
    public class y extends ud.n3<K, V> {
        public y() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return a.this.mt();
        }

        @Override // z0.ud.n3
        public z6<K, V> y() {
            return a.this;
        }
    }

    public boolean a(Object obj) {
        for (Collection<V> collection : gv().values()) {
            if (collection.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract Iterator<V> co();

    public boolean equals(Object obj) {
        return ud.y(this, obj);
    }

    @Override // z0.z6
    public Map<K, Collection<V>> gv() {
        Map<K, Collection<V>> map = this.f15554s;
        if (map == null) {
            Map<K, Collection<V>> s2 = s();
            this.f15554s = s2;
            return s2;
        }
        return map;
    }

    public int hashCode() {
        return gv().hashCode();
    }

    public abstract Collection<Map.Entry<K, V>> i9();

    @Override // z0.z6
    public Set<K> keySet() {
        Set<K> set = this.f15555v;
        if (set == null) {
            Set<K> t2 = t();
            this.f15555v = t2;
            return t2;
        }
        return set;
    }

    public abstract Iterator<Map.Entry<K, V>> mt();

    public abstract Collection<V> p();

    @Override // z0.z6
    public boolean remove(Object obj, Object obj2) {
        Collection<V> collection = gv().get(obj);
        if (collection != null && collection.remove(obj2)) {
            return true;
        }
        return false;
    }

    public abstract Map<K, Collection<V>> s();

    public abstract Set<K> t();

    public String toString() {
        return gv().toString();
    }

    @Override // z0.z6
    public boolean v(Object obj, Object obj2) {
        Collection<V> collection = gv().get(obj);
        if (collection != null && collection.contains(obj2)) {
            return true;
        }
        return false;
    }

    @Override // z0.z6
    public Collection<V> values() {
        Collection<V> collection = this.f15553fb;
        if (collection == null) {
            Collection<V> p2 = p();
            this.f15553fb = p2;
            return p2;
        }
        return collection;
    }

    @Override // z0.z6
    public Collection<Map.Entry<K, V>> y() {
        Collection<Map.Entry<K, V>> collection = this.y;
        if (collection == null) {
            Collection<Map.Entry<K, V>> i92 = i9();
            this.y = i92;
            return i92;
        }
        return collection;
    }
}
