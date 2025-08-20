package z0;

import java.io.Serializable;
/* loaded from: classes.dex */
public class r<K, V> extends v<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final K key;
    final V value;

    public r(K k2, V v2) {
        this.key = k2;
        this.value = v2;
    }

    @Override // z0.v, java.util.Map.Entry
    public final K getKey() {
        return this.key;
    }

    @Override // z0.v, java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v2) {
        throw new UnsupportedOperationException();
    }
}
