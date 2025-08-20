package z0;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public interface z6<K, V> {
    void clear();

    Collection<V> get(K k2);

    Map<K, Collection<V>> gv();

    Set<K> keySet();

    boolean put(K k2, V v2);

    boolean remove(Object obj, Object obj2);

    int size();

    boolean v(Object obj, Object obj2);

    Collection<V> values();

    Collection<Map.Entry<K, V>> y();
}
