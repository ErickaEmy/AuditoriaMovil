package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final Comparator<Comparable> y = new Comparator<Comparable>() { // from class: com.google.gson.internal.LinkedTreeMap.1
        @Override // java.util.Comparator
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.EntrySet entrySet;
    final Node<K, V> header;
    private LinkedTreeMap<K, V>.KeySet keySet;
    int modCount;
    Node<K, V> root;
    int size;

    /* loaded from: classes.dex */
    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if ((obj instanceof Map.Entry) && LinkedTreeMap.this.s((Map.Entry) obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>() { // from class: com.google.gson.internal.LinkedTreeMap.EntrySet.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                @Override // java.util.Iterator
                public Map.Entry<K, V> next() {
                    return y();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Node<K, V> s2;
            if (!(obj instanceof Map.Entry) || (s2 = LinkedTreeMap.this.s((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.p(s2, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* loaded from: classes.dex */
    public final class KeySet extends AbstractSet<K> {
        public KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<K>() { // from class: com.google.gson.internal.LinkedTreeMap.KeySet.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return y().f6215t;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (LinkedTreeMap.this.mt(obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* loaded from: classes.dex */
    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {

        /* renamed from: fb  reason: collision with root package name */
        public int f6208fb;

        /* renamed from: v  reason: collision with root package name */
        public Node<K, V> f6210v;
        public Node<K, V> y;

        public LinkedTreeMapIterator() {
            this.y = LinkedTreeMap.this.header.f6214s;
            this.f6208fb = LinkedTreeMap.this.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.y != LinkedTreeMap.this.header) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node<K, V> node = this.f6210v;
            if (node != null) {
                LinkedTreeMap.this.p(node, true);
                this.f6210v = null;
                this.f6208fb = LinkedTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }

        public final Node<K, V> y() {
            Node<K, V> node = this.y;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (node != linkedTreeMap.header) {
                if (linkedTreeMap.modCount == this.f6208fb) {
                    this.y = node.f6214s;
                    this.f6210v = node;
                    return node;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }
    }

    public LinkedTreeMap() {
        this(y);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        Node<K, V> node = this.header;
        node.f6211f = node;
        node.f6214s = node;
    }

    public final void co(Node<K, V> node, Node<K, V> node2) {
        Node<K, V> node3 = node.y;
        node.y = null;
        if (node2 != null) {
            node2.y = node3;
        }
        if (node3 != null) {
            if (node3.f6216v == node) {
                node3.f6216v = node2;
                return;
            } else {
                node3.f6212fb = node2;
                return;
            }
        }
        this.root = node2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (i9(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.EntrySet entrySet = this.entrySet;
        if (entrySet == null) {
            LinkedTreeMap<K, V>.EntrySet entrySet2 = new EntrySet();
            this.entrySet = entrySet2;
            return entrySet2;
        }
        return entrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Node<K, V> i92 = i9(obj);
        if (i92 != null) {
            return i92.f6217w;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Node<K, V> i9(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return v(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.KeySet keySet = this.keySet;
        if (keySet == null) {
            LinkedTreeMap<K, V>.KeySet keySet2 = new KeySet();
            this.keySet = keySet2;
            return keySet2;
        }
        return keySet;
    }

    public Node<K, V> mt(Object obj) {
        Node<K, V> i92 = i9(obj);
        if (i92 != null) {
            p(i92, true);
        }
        return i92;
    }

    public void p(Node<K, V> node, boolean z2) {
        Node<K, V> first;
        int i;
        if (z2) {
            Node<K, V> node2 = node.f6211f;
            node2.f6214s = node.f6214s;
            node.f6214s.f6211f = node2;
        }
        Node<K, V> node3 = node.f6216v;
        Node<K, V> node4 = node.f6212fb;
        Node<K, V> node5 = node.y;
        int i5 = 0;
        if (node3 != null && node4 != null) {
            if (node3.f6213p > node4.f6213p) {
                first = node3.last();
            } else {
                first = node4.first();
            }
            p(first, false);
            Node<K, V> node6 = node.f6216v;
            if (node6 != null) {
                i = node6.f6213p;
                first.f6216v = node6;
                node6.y = first;
                node.f6216v = null;
            } else {
                i = 0;
            }
            Node<K, V> node7 = node.f6212fb;
            if (node7 != null) {
                i5 = node7.f6213p;
                first.f6212fb = node7;
                node7.y = first;
                node.f6212fb = null;
            }
            first.f6213p = Math.max(i, i5) + 1;
            co(node, first);
            return;
        }
        if (node3 != null) {
            co(node, node3);
            node.f6216v = null;
        } else if (node4 != null) {
            co(node, node4);
            node.f6212fb = null;
        } else {
            co(node, null);
        }
        t(node5, false);
        this.size--;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v2) {
        if (k2 != null) {
            Node<K, V> v3 = v(k2, true);
            V v4 = v3.f6217w;
            v3.f6217w = v2;
            return v4;
        }
        throw new NullPointerException("key == null");
    }

    public final void r(Node<K, V> node) {
        int i;
        int i5;
        Node<K, V> node2 = node.f6216v;
        Node<K, V> node3 = node.f6212fb;
        Node<K, V> node4 = node3.f6216v;
        Node<K, V> node5 = node3.f6212fb;
        node.f6212fb = node4;
        if (node4 != null) {
            node4.y = node;
        }
        co(node, node3);
        node3.f6216v = node;
        node.y = node3;
        int i6 = 0;
        if (node2 != null) {
            i = node2.f6213p;
        } else {
            i = 0;
        }
        if (node4 != null) {
            i5 = node4.f6213p;
        } else {
            i5 = 0;
        }
        int max = Math.max(i, i5) + 1;
        node.f6213p = max;
        if (node5 != null) {
            i6 = node5.f6213p;
        }
        node3.f6213p = Math.max(max, i6) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Node<K, V> mt2 = mt(obj);
        if (mt2 != null) {
            return mt2.f6217w;
        }
        return null;
    }

    public Node<K, V> s(Map.Entry<?, ?> entry) {
        Node<K, V> i92 = i9(entry.getKey());
        if (i92 == null || !y(i92.f6217w, entry.getValue())) {
            return null;
        }
        return i92;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public final void t(Node<K, V> node, boolean z2) {
        int i;
        int i5;
        int i6;
        int i8;
        while (node != null) {
            Node<K, V> node2 = node.f6216v;
            Node<K, V> node3 = node.f6212fb;
            int i10 = 0;
            if (node2 != null) {
                i = node2.f6213p;
            } else {
                i = 0;
            }
            if (node3 != null) {
                i5 = node3.f6213p;
            } else {
                i5 = 0;
            }
            int i11 = i - i5;
            if (i11 == -2) {
                Node<K, V> node4 = node3.f6216v;
                Node<K, V> node5 = node3.f6212fb;
                if (node5 != null) {
                    i8 = node5.f6213p;
                } else {
                    i8 = 0;
                }
                if (node4 != null) {
                    i10 = node4.f6213p;
                }
                int i12 = i10 - i8;
                if (i12 != -1 && (i12 != 0 || z2)) {
                    x4(node3);
                    r(node);
                } else {
                    r(node);
                }
                if (z2) {
                    return;
                }
            } else if (i11 == 2) {
                Node<K, V> node6 = node2.f6216v;
                Node<K, V> node7 = node2.f6212fb;
                if (node7 != null) {
                    i6 = node7.f6213p;
                } else {
                    i6 = 0;
                }
                if (node6 != null) {
                    i10 = node6.f6213p;
                }
                int i13 = i10 - i6;
                if (i13 != 1 && (i13 != 0 || z2)) {
                    r(node2);
                    x4(node);
                } else {
                    x4(node);
                }
                if (z2) {
                    return;
                }
            } else if (i11 == 0) {
                node.f6213p = i + 1;
                if (z2) {
                    return;
                }
            } else {
                node.f6213p = Math.max(i, i5) + 1;
                if (!z2) {
                    return;
                }
            }
            node = node.y;
        }
    }

    public Node<K, V> v(K k2, boolean z2) {
        int i;
        Node<K, V> node;
        Comparable comparable;
        Node<K, V> node2;
        Comparator<? super K> comparator = this.comparator;
        Node<K, V> node3 = this.root;
        if (node3 != null) {
            if (comparator == y) {
                comparable = (Comparable) k2;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    i = comparable.compareTo(node3.f6215t);
                } else {
                    i = comparator.compare(k2, (K) node3.f6215t);
                }
                if (i == 0) {
                    return node3;
                }
                if (i < 0) {
                    node2 = node3.f6216v;
                } else {
                    node2 = node3.f6212fb;
                }
                if (node2 == null) {
                    break;
                }
                node3 = node2;
            }
        } else {
            i = 0;
        }
        if (!z2) {
            return null;
        }
        Node<K, V> node4 = this.header;
        if (node3 == null) {
            if (comparator == y && !(k2 instanceof Comparable)) {
                throw new ClassCastException(k2.getClass().getName() + " is not Comparable");
            }
            node = new Node<>(node3, k2, node4, node4.f6211f);
            this.root = node;
        } else {
            node = new Node<>(node3, k2, node4, node4.f6211f);
            if (i < 0) {
                node3.f6216v = node;
            } else {
                node3.f6212fb = node;
            }
            t(node3, true);
        }
        this.size++;
        this.modCount++;
        return node;
    }

    public final void x4(Node<K, V> node) {
        int i;
        int i5;
        Node<K, V> node2 = node.f6216v;
        Node<K, V> node3 = node.f6212fb;
        Node<K, V> node4 = node2.f6216v;
        Node<K, V> node5 = node2.f6212fb;
        node.f6216v = node5;
        if (node5 != null) {
            node5.y = node;
        }
        co(node, node2);
        node2.f6212fb = node;
        node.y = node2;
        int i6 = 0;
        if (node3 != null) {
            i = node3.f6213p;
        } else {
            i = 0;
        }
        if (node5 != null) {
            i5 = node5.f6213p;
        } else {
            i5 = 0;
        }
        int max = Math.max(i, i5) + 1;
        node.f6213p = max;
        if (node4 != null) {
            i6 = node4.f6213p;
        }
        node2.f6213p = Math.max(max, i6) + 1;
    }

    public final boolean y(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    /* loaded from: classes.dex */
    public static final class Node<K, V> implements Map.Entry<K, V> {

        /* renamed from: f  reason: collision with root package name */
        public Node<K, V> f6211f;

        /* renamed from: fb  reason: collision with root package name */
        public Node<K, V> f6212fb;

        /* renamed from: p  reason: collision with root package name */
        public int f6213p;

        /* renamed from: s  reason: collision with root package name */
        public Node<K, V> f6214s;

        /* renamed from: t  reason: collision with root package name */
        public final K f6215t;

        /* renamed from: v  reason: collision with root package name */
        public Node<K, V> f6216v;

        /* renamed from: w  reason: collision with root package name */
        public V f6217w;
        public Node<K, V> y;

        public Node() {
            this.f6211f = this;
            this.f6214s = this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k2 = this.f6215t;
            if (k2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k2.equals(entry.getKey())) {
                return false;
            }
            V v2 = this.f6217w;
            if (v2 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v2.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public Node<K, V> first() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.f6216v; node2 != null; node2 = node2.f6216v) {
                node = node2;
            }
            return node;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f6215t;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f6217w;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            K k2 = this.f6215t;
            int i = 0;
            if (k2 == null) {
                hashCode = 0;
            } else {
                hashCode = k2.hashCode();
            }
            V v2 = this.f6217w;
            if (v2 != null) {
                i = v2.hashCode();
            }
            return hashCode ^ i;
        }

        public Node<K, V> last() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.f6212fb; node2 != null; node2 = node2.f6212fb) {
                node = node2;
            }
            return node;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v2) {
            V v3 = this.f6217w;
            this.f6217w = v2;
            return v3;
        }

        public String toString() {
            return this.f6215t + "=" + this.f6217w;
        }

        public Node(Node<K, V> node, K k2, Node<K, V> node2, Node<K, V> node3) {
            this.y = node;
            this.f6215t = k2;
            this.f6213p = 1;
            this.f6214s = node2;
            this.f6211f = node3;
            node3.f6214s = this;
            node2.f6211f = this;
        }
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.header = new Node<>();
        this.comparator = comparator == null ? y : comparator;
    }
}
