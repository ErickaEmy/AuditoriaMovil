package w;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
import w.n3;
/* loaded from: classes.dex */
public class y<K, V> extends n3<K, V> {

    /* renamed from: f  reason: collision with root package name */
    public HashMap<K, n3.zn<K, V>> f14501f = new HashMap<>();

    @Override // w.n3
    public V a(@NonNull K k2, @NonNull V v2) {
        n3.zn<K, V> n32 = n3(k2);
        if (n32 != null) {
            return n32.f14500v;
        }
        this.f14501f.put(k2, v(k2, v2));
        return null;
    }

    public Map.Entry<K, V> c5(K k2) {
        if (contains(k2)) {
            return this.f14501f.get(k2).f14499s;
        }
        return null;
    }

    public boolean contains(K k2) {
        return this.f14501f.containsKey(k2);
    }

    @Override // w.n3
    public V fb(@NonNull K k2) {
        V v2 = (V) super.fb(k2);
        this.f14501f.remove(k2);
        return v2;
    }

    @Override // w.n3
    public n3.zn<K, V> n3(K k2) {
        return this.f14501f.get(k2);
    }
}
