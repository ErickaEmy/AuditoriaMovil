package z;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class y<K, V> extends s<K, V> implements Map<K, V> {
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public fb<K, V> f15548p;

    /* renamed from: z.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0259y extends fb<K, V> {
        public C0259y() {
        }

        @Override // z.fb
        public int a(Object obj) {
            return y.this.i9(obj);
        }

        @Override // z.fb
        public V c5(int i, V v2) {
            return y.this.wz(i, v2);
        }

        @Override // z.fb
        public void fb(K k2, V v2) {
            y.this.put(k2, v2);
        }

        @Override // z.fb
        public int gv() {
            return y.this.f15542fb;
        }

        @Override // z.fb
        public Object n3(int i, int i5) {
            return y.this.f15543v[(i << 1) + i5];
        }

        @Override // z.fb
        public void s(int i) {
            y.this.tl(i);
        }

        @Override // z.fb
        public int v(Object obj) {
            return y.this.s(obj);
        }

        @Override // z.fb
        public void y() {
            y.this.clear();
        }

        @Override // z.fb
        public Map<K, V> zn() {
            return y.this;
        }
    }

    public y() {
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return w().t();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return w().tl();
    }

    public boolean p(@NonNull Collection<?> collection) {
        return fb.w(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        zn(this.f15542fb + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return w().wz();
    }

    public final fb<K, V> w() {
        if (this.f15548p == null) {
            this.f15548p = new C0259y();
        }
        return this.f15548p;
    }

    public y(int i) {
        super(i);
    }

    public y(s sVar) {
        super(sVar);
    }
}
