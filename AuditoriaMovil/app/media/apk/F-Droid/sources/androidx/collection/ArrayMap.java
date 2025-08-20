package androidx.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class ArrayMap extends SimpleArrayMap implements Map {
    MapCollections mCollections;

    public ArrayMap() {
    }

    public ArrayMap(int i) {
        super(i);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }

    private MapCollections getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new MapCollections() { // from class: androidx.collection.ArrayMap.1
                @Override // androidx.collection.MapCollections
                protected Map colGetMap() {
                    return ArrayMap.this;
                }

                @Override // androidx.collection.MapCollections
                protected int colGetSize() {
                    return ArrayMap.this.mSize;
                }

                @Override // androidx.collection.MapCollections
                protected Object colGetEntry(int i, int i2) {
                    return ArrayMap.this.mArray[(i << 1) + i2];
                }

                @Override // androidx.collection.MapCollections
                protected int colIndexOfKey(Object obj) {
                    return ArrayMap.this.indexOfKey(obj);
                }

                @Override // androidx.collection.MapCollections
                protected int colIndexOfValue(Object obj) {
                    return ArrayMap.this.indexOfValue(obj);
                }

                @Override // androidx.collection.MapCollections
                protected void colPut(Object obj, Object obj2) {
                    ArrayMap.this.put(obj, obj2);
                }

                @Override // androidx.collection.MapCollections
                protected Object colSetValue(int i, Object obj) {
                    return ArrayMap.this.setValueAt(i, obj);
                }

                @Override // androidx.collection.MapCollections
                protected void colRemoveAt(int i) {
                    ArrayMap.this.removeAt(i);
                }

                @Override // androidx.collection.MapCollections
                protected void colClear() {
                    ArrayMap.this.clear();
                }
            };
        }
        return this.mCollections;
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        ensureCapacity(this.mSize + map.size());
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean retainAll(Collection collection) {
        return MapCollections.retainAllHelper(this, collection);
    }

    @Override // java.util.Map
    public Set entrySet() {
        return getCollection().getEntrySet();
    }

    @Override // java.util.Map
    public Set keySet() {
        return getCollection().getKeySet();
    }

    @Override // java.util.Map
    public Collection values() {
        return getCollection().getValues();
    }
}
