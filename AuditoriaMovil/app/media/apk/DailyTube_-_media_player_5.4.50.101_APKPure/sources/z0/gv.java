package z0;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import w0.xc;
import z0.a;
import z0.d;
/* loaded from: classes.dex */
public abstract class gv<K, V> extends z0.a<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;

    /* renamed from: f  reason: collision with root package name */
    public transient Map<K, Collection<V>> f15594f;

    /* renamed from: t  reason: collision with root package name */
    public transient int f15595t;

    /* loaded from: classes.dex */
    public class a extends gv<K, V>.c5 implements NavigableMap<K, Collection<V>> {
        public a(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K k2) {
            Map.Entry<K, Collection<V>> ceilingEntry = i9().ceilingEntry(k2);
            if (ceilingEntry == null) {
                return null;
            }
            return fb(ceilingEntry);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k2) {
            return i9().ceilingKey(k2);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new a(i9().descendingMap());
        }

        @Override // z0.gv.c5
        /* renamed from: f */
        public NavigableSet<K> s() {
            return new fb(i9());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> firstEntry = i9().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return fb(firstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K k2) {
            Map.Entry<K, Collection<V>> floorEntry = i9().floorEntry(k2);
            if (floorEntry == null) {
                return null;
            }
            return fb(floorEntry);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k2) {
            return i9().floorKey(k2);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K k2) {
            Map.Entry<K, Collection<V>> higherEntry = i9().higherEntry(k2);
            if (higherEntry == null) {
                return null;
            }
            return fb(higherEntry);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k2) {
            return i9().higherKey(k2);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> lastEntry = i9().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return fb(lastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K k2) {
            Map.Entry<K, Collection<V>> lowerEntry = i9().lowerEntry(k2);
            if (lowerEntry == null) {
                return null;
            }
            return fb(lowerEntry);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k2) {
            return i9().lowerKey(k2);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return keySet();
        }

        @Override // z0.gv.c5, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: p */
        public NavigableMap<K, Collection<V>> tailMap(K k2) {
            return tailMap(k2, true);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return wz(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return wz(descendingMap().entrySet().iterator());
        }

        @Override // z0.gv.c5, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: t */
        public NavigableMap<K, Collection<V>> headMap(K k2) {
            return headMap(k2, false);
        }

        @Override // z0.gv.c5, z0.gv.zn, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* renamed from: tl */
        public NavigableSet<K> keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // z0.gv.c5, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: w */
        public NavigableMap<K, Collection<V>> subMap(K k2, K k3) {
            return subMap(k2, true, k3, false);
        }

        public Map.Entry<K, Collection<V>> wz(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            Collection<V> j52 = gv.this.j5();
            j52.addAll(next.getValue());
            it.remove();
            return d.gv(next.getKey(), gv.this.ct(j52));
        }

        @Override // z0.gv.c5
        /* renamed from: xc */
        public NavigableMap<K, Collection<V>> i9() {
            return (NavigableMap) super.i9();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k2, boolean z2) {
            return new a(i9().headMap(k2, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k2, boolean z2, K k3, boolean z3) {
            return new a(i9().subMap(k2, z2, k3, z3));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k2, boolean z2) {
            return new a(i9().tailMap(k2, z2));
        }
    }

    /* loaded from: classes.dex */
    public class c5 extends gv<K, V>.zn implements SortedMap<K, Collection<V>> {

        /* renamed from: f  reason: collision with root package name */
        public SortedSet<K> f15597f;

        public c5(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // z0.gv.zn, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* renamed from: c5 */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.f15597f;
            if (sortedSet == null) {
                SortedSet<K> s2 = s();
                this.f15597f = s2;
                return s2;
            }
            return sortedSet;
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return i9().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return i9().firstKey();
        }

        public SortedMap<K, Collection<V>> headMap(K k2) {
            return new c5(i9().headMap(k2));
        }

        public SortedMap<K, Collection<V>> i9() {
            return (SortedMap) this.f15611fb;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return i9().lastKey();
        }

        public SortedSet<K> s() {
            return new i9(i9());
        }

        public SortedMap<K, Collection<V>> subMap(K k2, K k3) {
            return new c5(i9().subMap(k2, k3));
        }

        public SortedMap<K, Collection<V>> tailMap(K k2) {
            return new c5(i9().tailMap(k2));
        }
    }

    /* loaded from: classes.dex */
    public class f extends AbstractCollection<V> {

        /* renamed from: fb  reason: collision with root package name */
        public final gv<K, V>.f f15600fb;

        /* renamed from: s  reason: collision with root package name */
        public final Collection<V> f15601s;

        /* renamed from: v  reason: collision with root package name */
        public Collection<V> f15602v;
        public final K y;

        public f(K k2, Collection<V> collection, gv<K, V>.f fVar) {
            Collection<V> zn2;
            this.y = k2;
            this.f15602v = collection;
            this.f15600fb = fVar;
            if (fVar == null) {
                zn2 = null;
            } else {
                zn2 = fVar.zn();
            }
            this.f15601s = zn2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v2) {
            v();
            boolean isEmpty = this.f15602v.isEmpty();
            boolean add = this.f15602v.add(v2);
            if (add) {
                gv.ta(gv.this);
                if (isEmpty) {
                    y();
                }
            }
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.f15602v.addAll(collection);
            if (addAll) {
                gv.ud(gv.this, this.f15602v.size() - size);
                if (size == 0) {
                    y();
                }
            }
            return addAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f15602v.clear();
            gv.b(gv.this, size);
            fb();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            v();
            return this.f15602v.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            v();
            return this.f15602v.containsAll(collection);
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            v();
            return this.f15602v.equals(obj);
        }

        public void fb() {
            gv<K, V>.f fVar = this.f15600fb;
            if (fVar != null) {
                fVar.fb();
            } else if (this.f15602v.isEmpty()) {
                gv.this.f15594f.remove(this.y);
            }
        }

        public K gv() {
            return this.y;
        }

        @Override // java.util.Collection
        public int hashCode() {
            v();
            return this.f15602v.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            v();
            return new y(this);
        }

        public gv<K, V>.f n3() {
            return this.f15600fb;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            v();
            boolean remove = this.f15602v.remove(obj);
            if (remove) {
                gv.d(gv.this);
                fb();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.f15602v.removeAll(collection);
            if (removeAll) {
                gv.ud(gv.this, this.f15602v.size() - size);
                fb();
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            xc.wz(collection);
            int size = size();
            boolean retainAll = this.f15602v.retainAll(collection);
            if (retainAll) {
                gv.ud(gv.this, this.f15602v.size() - size);
                fb();
            }
            return retainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            v();
            return this.f15602v.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            v();
            return this.f15602v.toString();
        }

        public void v() {
            Collection<V> collection;
            gv<K, V>.f fVar = this.f15600fb;
            if (fVar != null) {
                fVar.v();
                if (this.f15600fb.zn() != this.f15601s) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.f15602v.isEmpty() && (collection = (Collection) gv.this.f15594f.get(this.y)) != null) {
                this.f15602v = collection;
            }
        }

        public void y() {
            gv<K, V>.f fVar = this.f15600fb;
            if (fVar != null) {
                fVar.y();
            } else {
                gv.this.f15594f.put(this.y, this.f15602v);
            }
        }

        public Collection<V> zn() {
            return this.f15602v;
        }
    }

    /* loaded from: classes.dex */
    public class fb extends gv<K, V>.i9 implements NavigableSet<K> {
        public fb(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // z0.gv.i9, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: a */
        public NavigableSet<K> tailSet(K k2) {
            return tailSet(k2, true);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k2) {
            return n3().ceilingKey(k2);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new fb(n3().descendingMap());
        }

        @Override // java.util.NavigableSet
        public K floor(K k2) {
            return n3().floorKey(k2);
        }

        @Override // z0.gv.i9
        /* renamed from: gv */
        public NavigableMap<K, Collection<V>> n3() {
            return (NavigableMap) super.n3();
        }

        @Override // java.util.NavigableSet
        public K higher(K k2) {
            return n3().higherKey(k2);
        }

        @Override // java.util.NavigableSet
        public K lower(K k2) {
            return n3().lowerKey(k2);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) fh.xc(iterator());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) fh.xc(descendingIterator());
        }

        @Override // z0.gv.i9, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: v */
        public NavigableSet<K> subSet(K k2, K k3) {
            return subSet(k2, true, k3, false);
        }

        @Override // z0.gv.i9, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: zn */
        public NavigableSet<K> headSet(K k2) {
            return headSet(k2, false);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k2, boolean z2) {
            return new fb(n3().headMap(k2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k2, boolean z2, K k3, boolean z3) {
            return new fb(n3().subMap(k2, z2, k3, z3));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k2, boolean z2) {
            return new fb(n3().tailMap(k2, z2));
        }
    }

    /* renamed from: z0.gv$gv  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public abstract class AbstractC0261gv<T> implements Iterator<T> {
        public final Iterator<Map.Entry<K, Collection<V>>> y;

        /* renamed from: v  reason: collision with root package name */
        public K f15607v = null;

        /* renamed from: fb  reason: collision with root package name */
        public Collection<V> f15605fb = null;

        /* renamed from: s  reason: collision with root package name */
        public Iterator<V> f15606s = fh.s();

        public AbstractC0261gv() {
            this.y = (Iterator<Map.Entry<K, V>>) gv.this.f15594f.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.y.hasNext() && !this.f15606s.hasNext()) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f15606s.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.y.next();
                this.f15607v = next.getKey();
                Collection<V> value = next.getValue();
                this.f15605fb = value;
                this.f15606s = value.iterator();
            }
            return y(b.y(this.f15607v), this.f15606s.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f15606s.remove();
            Collection<V> collection = this.f15605fb;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.y.remove();
            }
            gv.d(gv.this);
        }

        public abstract T y(K k2, V v2);
    }

    /* loaded from: classes.dex */
    public class i9 extends gv<K, V>.v implements SortedSet<K> {
        public i9(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return n3().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return n3().firstKey();
        }

        public SortedSet<K> headSet(K k2) {
            return new i9(n3().headMap(k2));
        }

        @Override // java.util.SortedSet
        public K last() {
            return n3().lastKey();
        }

        public SortedMap<K, Collection<V>> n3() {
            return (SortedMap) super.y();
        }

        public SortedSet<K> subSet(K k2, K k3) {
            return new i9(n3().subMap(k2, k3));
        }

        public SortedSet<K> tailSet(K k2) {
            return new i9(n3().tailMap(k2));
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends gv<K, V>.AbstractC0261gv<Map.Entry<K, V>> {
        public n3(gv gvVar) {
            super();
        }

        @Override // z0.gv.AbstractC0261gv
        /* renamed from: n3 */
        public Map.Entry<K, V> y(K k2, V v2) {
            return d.gv(k2, v2);
        }
    }

    /* loaded from: classes.dex */
    public class s extends gv<K, V>.t implements RandomAccess {
        public s(gv gvVar, K k2, List<V> list, gv<K, V>.f fVar) {
            super(k2, list, fVar);
        }
    }

    /* loaded from: classes.dex */
    public class v extends d.gv<K, Collection<V>> {
        public v(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            fh.zn(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return y().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            if (this != obj && !y().keySet().equals(obj)) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return y().keySet().hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new y(this, y().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int i;
            Collection<V> remove = y().remove(obj);
            if (remove != null) {
                i = remove.size();
                remove.clear();
                gv.b(gv.this, i);
            } else {
                i = 0;
            }
            if (i <= 0) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class zn extends d.a<K, Collection<V>> {

        /* renamed from: fb  reason: collision with root package name */
        public final transient Map<K, Collection<V>> f15611fb;

        public zn(Map<K, Collection<V>> map) {
            this.f15611fb = map;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f15611fb == gv.this.f15594f) {
                gv.this.clear();
            } else {
                fh.zn(new n3(this));
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return d.fb(this.f15611fb, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            if (this != obj && !this.f15611fb.equals(obj)) {
                return false;
            }
            return true;
        }

        public Map.Entry<K, Collection<V>> fb(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return d.gv(key, gv.this.o4(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f15611fb.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set<K> keySet() {
            return gv.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f15611fb.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f15611fb.toString();
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: v */
        public Collection<V> remove(Object obj) {
            Collection<V> remove = this.f15611fb.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> j52 = gv.this.j5();
            j52.addAll(remove);
            gv.b(gv.this, remove.size());
            remove.clear();
            return j52;
        }

        @Override // z0.d.a
        public Set<Map.Entry<K, Collection<V>>> y() {
            return new y(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: zn */
        public Collection<V> get(Object obj) {
            Collection<V> collection = (Collection) d.s(this.f15611fb, obj);
            if (collection == null) {
                return null;
            }
            return gv.this.o4(obj, collection);
        }
    }

    public gv(Map<K, Collection<V>> map) {
        xc.gv(map.isEmpty());
        this.f15594f = map;
    }

    public static /* synthetic */ int b(gv gvVar, int i) {
        int i5 = gvVar.f15595t - i;
        gvVar.f15595t = i5;
        return i5;
    }

    public static /* synthetic */ int d(gv gvVar) {
        int i = gvVar.f15595t;
        gvVar.f15595t = i - 1;
        return i;
    }

    public static <E> Iterator<E> jz(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    public static /* synthetic */ int ta(gv gvVar) {
        int i = gvVar.f15595t;
        gvVar.f15595t = i + 1;
        return i;
    }

    public static /* synthetic */ int ud(gv gvVar, int i) {
        int i5 = gvVar.f15595t + i;
        gvVar.f15595t = i5;
        return i5;
    }

    @Override // z0.z6
    public void clear() {
        for (Collection<V> collection : this.f15594f.values()) {
            collection.clear();
        }
        this.f15594f.clear();
        this.f15595t = 0;
    }

    @Override // z0.a
    public Iterator<V> co() {
        return new y(this);
    }

    public abstract <E> Collection<E> ct(Collection<E> collection);

    public final void dm(Map<K, Collection<V>> map) {
        this.f15594f = map;
        this.f15595t = 0;
        for (Collection<V> collection : map.values()) {
            xc.gv(!collection.isEmpty());
            this.f15595t += collection.size();
        }
    }

    @Override // z0.z6
    public Collection<V> get(K k2) {
        Collection<V> collection = this.f15594f.get(k2);
        if (collection == null) {
            collection = o(k2);
        }
        return o4(k2, collection);
    }

    @Override // z0.a
    public Collection<Map.Entry<K, V>> i9() {
        return new a.y();
    }

    public final Map<K, Collection<V>> j() {
        Map<K, Collection<V>> map = this.f15594f;
        if (map instanceof NavigableMap) {
            return new a((NavigableMap) this.f15594f);
        }
        if (map instanceof SortedMap) {
            return new c5((SortedMap) this.f15594f);
        }
        return new zn(this.f15594f);
    }

    public abstract Collection<V> j5();

    public final Set<K> k() {
        Map<K, Collection<V>> map = this.f15594f;
        if (map instanceof NavigableMap) {
            return new fb((NavigableMap) this.f15594f);
        }
        if (map instanceof SortedMap) {
            return new i9((SortedMap) this.f15594f);
        }
        return new v(this.f15594f);
    }

    public final List<V> lc(K k2, List<V> list, gv<K, V>.f fVar) {
        if (list instanceof RandomAccess) {
            return new s(this, k2, list, fVar);
        }
        return new t(k2, list, fVar);
    }

    @Override // z0.a
    public Iterator<Map.Entry<K, V>> mt() {
        return new n3(this);
    }

    public Collection<V> o(K k2) {
        return j5();
    }

    public abstract Collection<V> o4(K k2, Collection<V> collection);

    @Override // z0.a
    public Collection<V> p() {
        return new a.n3();
    }

    @Override // z0.z6
    public boolean put(K k2, V v2) {
        Collection<V> collection = this.f15594f.get(k2);
        if (collection == null) {
            Collection<V> o2 = o(k2);
            if (o2.add(v2)) {
                this.f15595t++;
                this.f15594f.put(k2, o2);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (collection.add(v2)) {
            this.f15595t++;
            return true;
        } else {
            return false;
        }
    }

    @Override // z0.z6
    public int size() {
        return this.f15595t;
    }

    public final void u(Object obj) {
        Collection collection = (Collection) d.c5(this.f15594f, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.f15595t -= size;
        }
    }

    @Override // z0.a, z0.z6
    public Collection<V> values() {
        return super.values();
    }

    @Override // z0.a, z0.z6
    public Collection<Map.Entry<K, V>> y() {
        return super.y();
    }

    public Map<K, Collection<V>> yt() {
        return this.f15594f;
    }

    /* loaded from: classes.dex */
    public class t extends gv<K, V>.f implements List<V> {
        public t(K k2, List<V> list, gv<K, V>.f fVar) {
            super(k2, list, fVar);
        }

        @Override // java.util.List
        public void add(int i, V v2) {
            v();
            boolean isEmpty = zn().isEmpty();
            c5().add(i, v2);
            gv.ta(gv.this);
            if (isEmpty) {
                y();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = c5().addAll(i, collection);
            if (addAll) {
                gv.ud(gv.this, zn().size() - size);
                if (size == 0) {
                    y();
                }
            }
            return addAll;
        }

        public List<V> c5() {
            return (List) zn();
        }

        @Override // java.util.List
        public V get(int i) {
            v();
            return c5().get(i);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            v();
            return c5().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            v();
            return c5().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            v();
            return new y(this);
        }

        @Override // java.util.List
        public V remove(int i) {
            v();
            V remove = c5().remove(i);
            gv.d(gv.this);
            fb();
            return remove;
        }

        @Override // java.util.List
        public V set(int i, V v2) {
            v();
            return c5().set(i, v2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public List<V> subList(int i, int i5) {
            gv<K, V>.f n32;
            v();
            gv gvVar = gv.this;
            Object gv2 = gv();
            List<V> subList = c5().subList(i, i5);
            if (n3() == null) {
                n32 = this;
            } else {
                n32 = n3();
            }
            return gvVar.lc(gv2, subList, n32);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i) {
            v();
            return new y(this, i);
        }
    }

    /* loaded from: classes.dex */
    public class y extends gv<K, V>.AbstractC0261gv<V> {
        public y(gv gvVar) {
            super();
        }

        @Override // z0.gv.AbstractC0261gv
        public V y(K k2, V v2) {
            return v2;
        }
    }
}
