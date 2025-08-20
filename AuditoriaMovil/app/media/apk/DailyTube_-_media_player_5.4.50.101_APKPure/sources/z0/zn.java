package z0;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class zn<K, V> extends gv<K, V> implements rz<K, V> {
    private static final long serialVersionUID = 6588350623831699109L;

    public zn(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // z0.gv
    public <E> Collection<E> ct(Collection<E> collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // z0.a
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // z0.a, z0.z6
    public Map<K, Collection<V>> gv() {
        return super.gv();
    }

    @Override // z0.gv, z0.z6
    /* renamed from: nf */
    public List<V> get(K k2) {
        return (List) super.get(k2);
    }

    @Override // z0.gv
    public Collection<V> o4(K k2, Collection<V> collection) {
        return lc(k2, (List) collection, null);
    }

    @Override // z0.gv, z0.z6
    public boolean put(K k2, V v2) {
        return super.put(k2, v2);
    }
}
