package com.google.protobuf;

import com.google.protobuf.FieldSet;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: f  reason: collision with root package name */
    public volatile SmallSortedMap<K, V>.EntrySet f6511f;

    /* renamed from: fb  reason: collision with root package name */
    public Map<K, V> f6512fb;

    /* renamed from: s  reason: collision with root package name */
    public boolean f6513s;

    /* renamed from: t  reason: collision with root package name */
    public Map<K, V> f6514t;

    /* renamed from: v  reason: collision with root package name */
    public List<SmallSortedMap<K, V>.Entry> f6515v;

    /* renamed from: w  reason: collision with root package name */
    public volatile SmallSortedMap<K, V>.DescendingEntrySet f6516w;
    public final int y;

    /* loaded from: classes.dex */
    public class DescendingEntryIterator implements Iterator<Map.Entry<K, V>> {

        /* renamed from: v  reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f6518v;
        public int y;

        public DescendingEntryIterator() {
            this.y = SmallSortedMap.this.f6515v.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.y;
            if ((i > 0 && i <= SmallSortedMap.this.f6515v.size()) || y().hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public final Iterator<Map.Entry<K, V>> y() {
            if (this.f6518v == null) {
                this.f6518v = SmallSortedMap.this.f6514t.entrySet().iterator();
            }
            return this.f6518v;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (!y().hasNext()) {
                List list = SmallSortedMap.this.f6515v;
                int i = this.y - 1;
                this.y = i;
                return (Map.Entry) list.get(i);
            }
            return y().next();
        }
    }

    /* loaded from: classes.dex */
    public class DescendingEntrySet extends SmallSortedMap<K, V>.EntrySet {
        public DescendingEntrySet() {
            super();
        }

        @Override // com.google.protobuf.SmallSortedMap.EntrySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new DescendingEntryIterator();
        }
    }

    /* loaded from: classes.dex */
    public static class EmptySet {
        public static final Iterator<Object> y = new Iterator<Object>() { // from class: com.google.protobuf.SmallSortedMap.EmptySet.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

        /* renamed from: n3  reason: collision with root package name */
        public static final Iterable<Object> f6520n3 = new Iterable<Object>() { // from class: com.google.protobuf.SmallSortedMap.EmptySet.2
            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return EmptySet.y;
            }
        };

        public static <T> Iterable<T> n3() {
            return (Iterable<T>) f6520n3;
        }
    }

    /* loaded from: classes.dex */
    public class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {

        /* renamed from: v  reason: collision with root package name */
        public V f6522v;
        public final K y;

        public Entry(SmallSortedMap smallSortedMap, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((Entry) ((Entry) obj));
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (y(this.y, entry.getKey()) && y(this.f6522v, entry.getValue())) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f6522v;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            K k2 = this.y;
            int i = 0;
            if (k2 == null) {
                hashCode = 0;
            } else {
                hashCode = k2.hashCode();
            }
            V v2 = this.f6522v;
            if (v2 != null) {
                i = v2.hashCode();
            }
            return hashCode ^ i;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v2) {
            SmallSortedMap.this.c5();
            V v3 = this.f6522v;
            this.f6522v = v2;
            return v3;
        }

        public String toString() {
            return this.y + "=" + this.f6522v;
        }

        public final boolean y(Object obj, Object obj2) {
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
                return false;
            }
            return obj.equals(obj2);
        }

        public Entry(K k2, V v2) {
            this.y = k2;
            this.f6522v = v2;
        }

        public int compareTo(SmallSortedMap<K, V>.Entry entry) {
            return getKey().compareTo(entry.getKey());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.y;
        }
    }

    /* loaded from: classes.dex */
    public class EntryIterator implements Iterator<Map.Entry<K, V>> {

        /* renamed from: fb  reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f6523fb;

        /* renamed from: v  reason: collision with root package name */
        public boolean f6525v;
        public int y;

        public EntryIterator() {
            this.y = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.y + 1 < SmallSortedMap.this.f6515v.size()) {
                return true;
            }
            if (!SmallSortedMap.this.f6512fb.isEmpty() && y().hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f6525v) {
                this.f6525v = false;
                SmallSortedMap.this.c5();
                if (this.y < SmallSortedMap.this.f6515v.size()) {
                    SmallSortedMap smallSortedMap = SmallSortedMap.this;
                    int i = this.y;
                    this.y = i - 1;
                    smallSortedMap.wz(i);
                    return;
                }
                y().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        public final Iterator<Map.Entry<K, V>> y() {
            if (this.f6523fb == null) {
                this.f6523fb = SmallSortedMap.this.f6512fb.entrySet().iterator();
            }
            return this.f6523fb;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.f6525v = true;
            int i = this.y + 1;
            this.y = i;
            if (i < SmallSortedMap.this.f6515v.size()) {
                return (Map.Entry) SmallSortedMap.this.f6515v.get(this.y);
            }
            return y().next();
        }
    }

    /* loaded from: classes.dex */
    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            return add((Map.Entry) ((Map.Entry) obj));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            SmallSortedMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = SmallSortedMap.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value && (obj2 == null || !obj2.equals(value))) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                SmallSortedMap.this.remove(entry.getKey());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return SmallSortedMap.this.size();
        }

        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            SmallSortedMap.this.put((SmallSortedMap) entry.getKey(), (K) entry.getValue());
            return true;
        }
    }

    public static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> tl(int i) {
        return (SmallSortedMap<FieldDescriptorType, Object>) new SmallSortedMap<FieldDescriptorType, Object>(i) { // from class: com.google.protobuf.SmallSortedMap.1
            @Override // com.google.protobuf.SmallSortedMap
            public void makeImmutable() {
                if (!isImmutable()) {
                    for (int i5 = 0; i5 < getNumArrayEntries(); i5++) {
                        Map.Entry<FieldDescriptorType, Object> arrayEntryAt = getArrayEntryAt(i5);
                        if (((FieldSet.FieldDescriptorLite) arrayEntryAt.getKey()).isRepeated()) {
                            arrayEntryAt.setValue(Collections.unmodifiableList((List) arrayEntryAt.getValue()));
                        }
                    }
                    for (Map.Entry<FieldDescriptorType, Object> entry : getOverflowEntries()) {
                        if (((FieldSet.FieldDescriptorLite) entry.getKey()).isRepeated()) {
                            entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                        }
                    }
                }
                super.makeImmutable();
            }

            @Override // com.google.protobuf.SmallSortedMap, java.util.AbstractMap, java.util.Map
            public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
                return super.put((AnonymousClass1<FieldDescriptorType>) ((Comparable) obj), (Comparable) obj2);
            }
        };
    }

    public final void c5() {
        if (!this.f6513s) {
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        c5();
        if (!this.f6515v.isEmpty()) {
            this.f6515v.clear();
        }
        if (!this.f6512fb.isEmpty()) {
            this.f6512fb.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (s(comparable) < 0 && !this.f6512fb.containsKey(comparable)) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f6511f == null) {
            this.f6511f = new EntrySet();
        }
        return this.f6511f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmallSortedMap)) {
            return super.equals(obj);
        }
        SmallSortedMap smallSortedMap = (SmallSortedMap) obj;
        int size = size();
        if (size != smallSortedMap.size()) {
            return false;
        }
        int numArrayEntries = getNumArrayEntries();
        if (numArrayEntries != smallSortedMap.getNumArrayEntries()) {
            return entrySet().equals(smallSortedMap.entrySet());
        }
        for (int i = 0; i < numArrayEntries; i++) {
            if (!getArrayEntryAt(i).equals(smallSortedMap.getArrayEntryAt(i))) {
                return false;
            }
        }
        if (numArrayEntries == size) {
            return true;
        }
        return this.f6512fb.equals(smallSortedMap.f6512fb);
    }

    public final void f() {
        c5();
        if (this.f6515v.isEmpty() && !(this.f6515v instanceof ArrayList)) {
            this.f6515v = new ArrayList(this.y);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int s2 = s(comparable);
        if (s2 >= 0) {
            return this.f6515v.get(s2).getValue();
        }
        return this.f6512fb.get(comparable);
    }

    public Map.Entry<K, V> getArrayEntryAt(int i) {
        return this.f6515v.get(i);
    }

    public int getNumArrayEntries() {
        return this.f6515v.size();
    }

    public int getNumOverflowEntries() {
        return this.f6512fb.size();
    }

    public Iterable<Map.Entry<K, V>> getOverflowEntries() {
        if (this.f6512fb.isEmpty()) {
            return EmptySet.n3();
        }
        return this.f6512fb.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int numArrayEntries = getNumArrayEntries();
        int i = 0;
        for (int i5 = 0; i5 < numArrayEntries; i5++) {
            i += this.f6515v.get(i5).hashCode();
        }
        if (getNumOverflowEntries() > 0) {
            return i + this.f6512fb.hashCode();
        }
        return i;
    }

    public Set<Map.Entry<K, V>> i9() {
        if (this.f6516w == null) {
            this.f6516w = new DescendingEntrySet();
        }
        return this.f6516w;
    }

    public boolean isImmutable() {
        return this.f6513s;
    }

    public void makeImmutable() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (!this.f6513s) {
            if (this.f6512fb.isEmpty()) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(this.f6512fb);
            }
            this.f6512fb = unmodifiableMap;
            if (this.f6514t.isEmpty()) {
                unmodifiableMap2 = Collections.emptyMap();
            } else {
                unmodifiableMap2 = Collections.unmodifiableMap(this.f6514t);
            }
            this.f6514t = unmodifiableMap2;
            this.f6513s = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((SmallSortedMap<K, V>) ((Comparable) obj), (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        c5();
        Comparable comparable = (Comparable) obj;
        int s2 = s(comparable);
        if (s2 >= 0) {
            return (V) wz(s2);
        }
        if (this.f6512fb.isEmpty()) {
            return null;
        }
        return this.f6512fb.remove(comparable);
    }

    public final int s(K k2) {
        int i;
        int size = this.f6515v.size();
        int i5 = size - 1;
        if (i5 >= 0) {
            int compareTo = k2.compareTo(this.f6515v.get(i5).getKey());
            if (compareTo > 0) {
                i = size + 1;
                return -i;
            } else if (compareTo == 0) {
                return i5;
            }
        }
        int i6 = 0;
        while (i6 <= i5) {
            int i8 = (i6 + i5) / 2;
            int compareTo2 = k2.compareTo(this.f6515v.get(i8).getKey());
            if (compareTo2 < 0) {
                i5 = i8 - 1;
            } else if (compareTo2 > 0) {
                i6 = i8 + 1;
            } else {
                return i8;
            }
        }
        i = i6 + 1;
        return -i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f6515v.size() + this.f6512fb.size();
    }

    public final SortedMap<K, V> t() {
        c5();
        if (this.f6512fb.isEmpty() && !(this.f6512fb instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f6512fb = treeMap;
            this.f6514t = treeMap.descendingMap();
        }
        return (SortedMap) this.f6512fb;
    }

    public final V wz(int i) {
        c5();
        V value = this.f6515v.remove(i).getValue();
        if (!this.f6512fb.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = t().entrySet().iterator();
            this.f6515v.add(new Entry(this, it.next()));
            it.remove();
        }
        return value;
    }

    public SmallSortedMap(int i) {
        this.y = i;
        this.f6515v = Collections.emptyList();
        this.f6512fb = Collections.emptyMap();
        this.f6514t = Collections.emptyMap();
    }

    public V put(K k2, V v2) {
        c5();
        int s2 = s(k2);
        if (s2 >= 0) {
            return this.f6515v.get(s2).setValue(v2);
        }
        f();
        int i = -(s2 + 1);
        if (i >= this.y) {
            return t().put(k2, v2);
        }
        int size = this.f6515v.size();
        int i5 = this.y;
        if (size == i5) {
            SmallSortedMap<K, V>.Entry remove = this.f6515v.remove(i5 - 1);
            t().put((K) remove.getKey(), remove.getValue());
        }
        this.f6515v.add(i, new Entry(k2, v2));
        return null;
    }
}
