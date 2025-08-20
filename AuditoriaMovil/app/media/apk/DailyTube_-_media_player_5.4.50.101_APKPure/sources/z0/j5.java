package z0;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import w0.xc;
/* loaded from: classes.dex */
public final class j5<K, V> extends f3<K, V> {

    /* renamed from: p  reason: collision with root package name */
    public static final f3<Object, Object> f15617p = new j5(null, new Object[0], 0);
    private static final long serialVersionUID = 0;

    /* renamed from: f  reason: collision with root package name */
    public final transient Object f15618f;

    /* renamed from: t  reason: collision with root package name */
    public final transient Object[] f15619t;

    /* renamed from: w  reason: collision with root package name */
    public final transient int f15620w;

    /* loaded from: classes.dex */
    public static final class n3<K> extends c<K> {

        /* renamed from: fb  reason: collision with root package name */
        public final transient f3<K, ?> f15621fb;

        /* renamed from: s  reason: collision with root package name */
        public final transient x4<K> f15622s;

        public n3(f3<K, ?> f3Var, x4<K> x4Var) {
            this.f15621fb = f3Var;
            this.f15622s = x4Var;
        }

        @Override // z0.z, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (this.f15621fb.get(obj) != null) {
                return true;
            }
            return false;
        }

        @Override // z0.z
        public int gv(Object[] objArr, int i) {
            return y().gv(objArr, i);
        }

        @Override // z0.c, z0.z, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: mt */
        public en<K> iterator() {
            return y().iterator();
        }

        @Override // z0.z
        public boolean p() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f15621fb.size();
        }

        @Override // z0.c, z0.z
        public x4<K> y() {
            return this.f15622s;
        }
    }

    /* loaded from: classes.dex */
    public static class y<K, V> extends c<Map.Entry<K, V>> {

        /* renamed from: f  reason: collision with root package name */
        public final transient int f15623f;

        /* renamed from: fb  reason: collision with root package name */
        public final transient f3<K, V> f15624fb;

        /* renamed from: s  reason: collision with root package name */
        public final transient Object[] f15625s;

        /* renamed from: t  reason: collision with root package name */
        public final transient int f15626t;

        /* renamed from: z0.j5$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0262y extends x4<Map.Entry<K, V>> {
            public C0262y() {
            }

            @Override // java.util.List
            /* renamed from: lc */
            public Map.Entry<K, V> get(int i) {
                xc.t(i, y.this.f15626t);
                int i5 = i * 2;
                Object obj = y.this.f15625s[y.this.f15623f + i5];
                Objects.requireNonNull(obj);
                Object obj2 = y.this.f15625s[i5 + (y.this.f15623f ^ 1)];
                Objects.requireNonNull(obj2);
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }

            @Override // z0.z
            public boolean p() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return y.this.f15626t;
            }
        }

        public y(f3<K, V> f3Var, Object[] objArr, int i, int i5) {
            this.f15624fb = f3Var;
            this.f15625s = objArr;
            this.f15623f = i;
            this.f15626t = i5;
        }

        @Override // z0.z, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.f15624fb.get(key))) {
                return false;
            }
            return true;
        }

        @Override // z0.c
        public x4<Map.Entry<K, V>> d() {
            return new C0262y();
        }

        @Override // z0.z
        public int gv(Object[] objArr, int i) {
            return y().gv(objArr, i);
        }

        @Override // z0.c, z0.z, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: mt */
        public en<Map.Entry<K, V>> iterator() {
            return y().iterator();
        }

        @Override // z0.z
        public boolean p() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f15626t;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn extends x4<Object> {

        /* renamed from: f  reason: collision with root package name */
        public final transient int f15627f;

        /* renamed from: fb  reason: collision with root package name */
        public final transient Object[] f15628fb;

        /* renamed from: s  reason: collision with root package name */
        public final transient int f15629s;

        public zn(Object[] objArr, int i, int i5) {
            this.f15628fb = objArr;
            this.f15629s = i;
            this.f15627f = i5;
        }

        @Override // java.util.List
        public Object get(int i) {
            xc.t(i, this.f15627f);
            Object obj = this.f15628fb[(i * 2) + this.f15629s];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // z0.z
        public boolean p() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f15627f;
        }
    }

    public j5(Object obj, Object[] objArr, int i) {
        this.f15618f = obj;
        this.f15619t = objArr;
        this.f15620w = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
        r11[r5] = (byte) r1;
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008b, code lost:
        r11[r5] = (short) r1;
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c8, code lost:
        r11[r6] = r1;
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object b(java.lang.Object[] r9, int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.j5.b(java.lang.Object[], int, int, int):java.lang.Object");
    }

    public static IllegalArgumentException k5(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder sb = new StringBuilder(valueOf.length() + 39 + valueOf2.length() + valueOf3.length() + valueOf4.length());
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append("=");
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    public static <K, V> j5<K, V> ud(int i, Object[] objArr) {
        if (i == 0) {
            return (j5) f15617p;
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            c5.y(obj, obj2);
            return new j5<>(null, objArr, 1);
        }
        xc.w(i, objArr.length >> 1);
        return new j5<>(b(objArr, i, c.co(i), 0), objArr, i);
    }

    public static Object yt(Object obj, Object[] objArr, int i, int i5, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i == 1) {
            Object obj3 = objArr[i5];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i5 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        } else if (obj == null) {
            return null;
        } else {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length = bArr.length - 1;
                int n32 = co.n3(obj2.hashCode());
                while (true) {
                    int i6 = n32 & length;
                    int i8 = bArr[i6] & 255;
                    if (i8 == 255) {
                        return null;
                    }
                    if (obj2.equals(objArr[i8])) {
                        return objArr[i8 ^ 1];
                    }
                    n32 = i6 + 1;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length2 = sArr.length - 1;
                int n33 = co.n3(obj2.hashCode());
                while (true) {
                    int i10 = n33 & length2;
                    int i11 = sArr[i10] & 65535;
                    if (i11 == 65535) {
                        return null;
                    }
                    if (obj2.equals(objArr[i11])) {
                        return objArr[i11 ^ 1];
                    }
                    n33 = i10 + 1;
                }
            } else {
                int[] iArr = (int[]) obj;
                int length3 = iArr.length - 1;
                int n34 = co.n3(obj2.hashCode());
                while (true) {
                    int i12 = n34 & length3;
                    int i13 = iArr[i12];
                    if (i13 == -1) {
                        return null;
                    }
                    if (obj2.equals(objArr[i13])) {
                        return objArr[i13 ^ 1];
                    }
                    n34 = i12 + 1;
                }
            }
        }
    }

    @Override // z0.f3
    public boolean co() {
        return false;
    }

    @Override // z0.f3, java.util.Map
    public V get(Object obj) {
        V v2 = (V) yt(this.f15618f, this.f15619t, this.f15620w, 0, obj);
        if (v2 == null) {
            return null;
        }
        return v2;
    }

    @Override // z0.f3
    public c<Map.Entry<K, V>> i9() {
        return new y(this, this.f15619t, 0, this.f15620w);
    }

    @Override // z0.f3
    public z<V> p() {
        return new zn(this.f15619t, 1, this.f15620w);
    }

    @Override // java.util.Map
    public int size() {
        return this.f15620w;
    }

    @Override // z0.f3
    public c<K> t() {
        return new n3(this, new zn(this.f15619t, 0, this.f15620w));
    }
}
