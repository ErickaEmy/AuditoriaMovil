package z0;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import w0.fb;
import w0.xc;
import z0.q9;
/* loaded from: classes.dex */
public final class d {

    /* loaded from: classes.dex */
    public static abstract class a<K, V> extends AbstractMap<K, V> {

        /* renamed from: v  reason: collision with root package name */
        public transient Collection<V> f15557v;
        public transient Set<Map.Entry<K, V>> y;

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.y;
            if (set == null) {
                Set<Map.Entry<K, V>> y = y();
                this.y = y;
                return y;
            }
            return set;
        }

        public Collection<V> n3() {
            return new v(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.f15557v;
            if (collection == null) {
                Collection<V> n32 = n3();
                this.f15557v = n32;
                return n32;
            }
            return collection;
        }

        public abstract Set<Map.Entry<K, V>> y();
    }

    /* loaded from: classes.dex */
    public static class gv<K, V> extends q9.gv<K> {
        public final Map<K, V> y;

        public gv(Map<K, V> map) {
            this.y = (Map) xc.wz(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return y().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return y().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return y().size();
        }

        public Map<K, V> y() {
            return this.y;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static abstract class n3 implements fb<Map.Entry<?, ?>, Object> {
        public static final n3 y = new y("KEY", 0);

        /* renamed from: v  reason: collision with root package name */
        public static final n3 f15559v = new C0260n3("VALUE", 1);

        /* renamed from: fb  reason: collision with root package name */
        public static final /* synthetic */ n3[] f15558fb = y();

        /* renamed from: z0.d$n3$n3  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public enum C0260n3 extends n3 {
            public C0260n3(String str, int i) {
                super(str, i, null);
            }

            @Override // w0.fb
            /* renamed from: gv */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }

        /* loaded from: classes.dex */
        public enum y extends n3 {
            public y(String str, int i) {
                super(str, i, null);
            }

            @Override // w0.fb
            /* renamed from: gv */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        }

        public n3(String str, int i) {
        }

        public static n3 valueOf(String str) {
            return (n3) Enum.valueOf(n3.class, str);
        }

        public static n3[] values() {
            return (n3[]) f15558fb.clone();
        }

        public static /* synthetic */ n3[] y() {
            return new n3[]{y, f15559v};
        }

        public /* synthetic */ n3(String str, int i, ta taVar) {
            this(str, i);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* loaded from: classes.dex */
    public class y<K, V> extends f7<Map.Entry<K, V>, V> {
        public y(Iterator it) {
            super(it);
        }

        @Override // z0.f7
        /* renamed from: n3 */
        public V y(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    public static <K, V> IdentityHashMap<K, V> a() {
        return new IdentityHashMap<>();
    }

    public static <V> V c5(Map<?, V> map, Object obj) {
        xc.wz(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static <V> fb<Map.Entry<?, V>, V> f() {
        return n3.f15559v;
    }

    public static boolean fb(Map<?, ?> map, Object obj) {
        xc.wz(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static <K, V> Map.Entry<K, V> gv(K k2, V v2) {
        return new r(k2, v2);
    }

    public static String i9(Map<?, ?> map) {
        StringBuilder n32 = i9.n3(map.size());
        n32.append('{');
        boolean z2 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z2) {
                n32.append(", ");
            }
            n32.append(entry.getKey());
            n32.append('=');
            n32.append(entry.getValue());
            z2 = false;
        }
        n32.append('}');
        return n32.toString();
    }

    public static boolean n3(Map<?, ?> map, Object obj) {
        return fh.gv(t(map.entrySet().iterator()), obj);
    }

    public static <V> V s(Map<?, V> map, Object obj) {
        xc.wz(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static <K, V> Iterator<V> t(Iterator<Map.Entry<K, V>> it) {
        return new y(it);
    }

    public static <K> fb<Map.Entry<K, ?>, K> v() {
        return n3.y;
    }

    public static int y(int i) {
        if (i < 3) {
            c5.n3(i, "expectedSize");
            return i + 1;
        } else if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static boolean zn(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }
}
