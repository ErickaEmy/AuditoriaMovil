package z0;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class p<K, V> extends mt implements Map<K, V> {
    @Override // java.util.Map
    public void clear() {
        n3().clear();
    }

    public boolean containsKey(Object obj) {
        return n3().containsKey(obj);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return n3().entrySet();
    }

    public int fb() {
        return q9.gv(entrySet());
    }

    public V get(Object obj) {
        return n3().get(obj);
    }

    public boolean isEmpty() {
        return n3().isEmpty();
    }

    public Set<K> keySet() {
        return n3().keySet();
    }

    public abstract Map<K, V> n3();

    @Override // java.util.Map
    public V put(K k2, V v2) {
        return n3().put(k2, v2);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        n3().putAll(map);
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        return n3().remove(obj);
    }

    public int size() {
        return n3().size();
    }

    public boolean v(Object obj) {
        return d.zn(this, obj);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return n3().values();
    }

    public boolean zn(Object obj) {
        return d.n3(this, obj);
    }
}
