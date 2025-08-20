package z;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;
/* loaded from: classes.dex */
public class s<K, V> {

    /* renamed from: f  reason: collision with root package name */
    public static int f15538f;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public static Object[] f15539s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public static Object[] f15540t;

    /* renamed from: w  reason: collision with root package name */
    public static int f15541w;

    /* renamed from: fb  reason: collision with root package name */
    public int f15542fb;

    /* renamed from: v  reason: collision with root package name */
    public Object[] f15543v;
    public int[] y;

    public s() {
        this.y = gv.y;
        this.f15543v = gv.f15527zn;
    }

    public static int n3(int[] iArr, int i, int i5) {
        try {
            return gv.y(iArr, i, i5);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static void v(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (s.class) {
                try {
                    if (f15541w < 10) {
                        objArr[0] = f15540t;
                        objArr[1] = iArr;
                        for (int i5 = (i << 1) - 1; i5 >= 2; i5--) {
                            objArr[i5] = null;
                        }
                        f15540t = objArr;
                        f15541w++;
                    }
                } finally {
                }
            }
        } else if (iArr.length == 4) {
            synchronized (s.class) {
                try {
                    if (f15538f < 10) {
                        objArr[0] = f15539s;
                        objArr[1] = iArr;
                        for (int i6 = (i << 1) - 1; i6 >= 2; i6--) {
                            objArr[i6] = null;
                        }
                        f15539s = objArr;
                        f15538f++;
                    }
                } finally {
                }
            }
        }
    }

    public int c5() {
        int i = this.f15542fb;
        if (i == 0) {
            return -1;
        }
        int n32 = n3(this.y, i, 0);
        if (n32 < 0) {
            return n32;
        }
        if (this.f15543v[n32 << 1] == null) {
            return n32;
        }
        int i5 = n32 + 1;
        while (i5 < i && this.y[i5] == 0) {
            if (this.f15543v[i5 << 1] == null) {
                return i5;
            }
            i5++;
        }
        for (int i6 = n32 - 1; i6 >= 0 && this.y[i6] == 0; i6--) {
            if (this.f15543v[i6 << 1] == null) {
                return i6;
            }
        }
        return ~i5;
    }

    public void clear() {
        int i = this.f15542fb;
        if (i > 0) {
            int[] iArr = this.y;
            Object[] objArr = this.f15543v;
            this.y = gv.y;
            this.f15543v = gv.f15527zn;
            this.f15542fb = 0;
            v(iArr, objArr, i);
        }
        if (this.f15542fb <= 0) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public boolean containsKey(@Nullable Object obj) {
        if (s(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        if (i9(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s) {
            s sVar = (s) obj;
            if (size() != sVar.size()) {
                return false;
            }
            for (int i = 0; i < this.f15542fb; i++) {
                try {
                    K f4 = f(i);
                    V xc2 = xc(i);
                    Object obj2 = sVar.get(f4);
                    if (xc2 == null) {
                        if (obj2 != null || !sVar.containsKey(f4)) {
                            return false;
                        }
                    } else if (!xc2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i5 = 0; i5 < this.f15542fb; i5++) {
                try {
                    K f6 = f(i5);
                    V xc3 = xc(i5);
                    Object obj3 = map.get(f6);
                    if (xc3 == null) {
                        if (obj3 != null || !map.containsKey(f6)) {
                            return false;
                        }
                    } else if (!xc3.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public K f(int i) {
        return (K) this.f15543v[i << 1];
    }

    public int fb(Object obj, int i) {
        int i5 = this.f15542fb;
        if (i5 == 0) {
            return -1;
        }
        int n32 = n3(this.y, i5, i);
        if (n32 < 0) {
            return n32;
        }
        if (obj.equals(this.f15543v[n32 << 1])) {
            return n32;
        }
        int i6 = n32 + 1;
        while (i6 < i5 && this.y[i6] == i) {
            if (obj.equals(this.f15543v[i6 << 1])) {
                return i6;
            }
            i6++;
        }
        for (int i8 = n32 - 1; i8 >= 0 && this.y[i8] == i; i8--) {
            if (obj.equals(this.f15543v[i8 << 1])) {
                return i8;
            }
        }
        return ~i6;
    }

    @Nullable
    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v2) {
        int s2 = s(obj);
        if (s2 >= 0) {
            return (V) this.f15543v[(s2 << 1) + 1];
        }
        return v2;
    }

    public int hashCode() {
        int hashCode;
        int[] iArr = this.y;
        Object[] objArr = this.f15543v;
        int i = this.f15542fb;
        int i5 = 1;
        int i6 = 0;
        int i8 = 0;
        while (i6 < i) {
            Object obj = objArr[i5];
            int i10 = iArr[i6];
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            i8 += hashCode ^ i10;
            i6++;
            i5 += 2;
        }
        return i8;
    }

    public int i9(Object obj) {
        int i = this.f15542fb * 2;
        Object[] objArr = this.f15543v;
        if (obj == null) {
            for (int i5 = 1; i5 < i; i5 += 2) {
                if (objArr[i5] == null) {
                    return i5 >> 1;
                }
            }
            return -1;
        }
        for (int i6 = 1; i6 < i; i6 += 2) {
            if (obj.equals(objArr[i6])) {
                return i6 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.f15542fb <= 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public V put(K k2, V v2) {
        int i;
        int fb2;
        int i5 = this.f15542fb;
        if (k2 == null) {
            fb2 = c5();
            i = 0;
        } else {
            int hashCode = k2.hashCode();
            i = hashCode;
            fb2 = fb(k2, hashCode);
        }
        if (fb2 >= 0) {
            int i6 = (fb2 << 1) + 1;
            Object[] objArr = this.f15543v;
            V v3 = (V) objArr[i6];
            objArr[i6] = v2;
            return v3;
        }
        int i8 = ~fb2;
        int[] iArr = this.y;
        if (i5 >= iArr.length) {
            int i10 = 8;
            if (i5 >= 8) {
                i10 = (i5 >> 1) + i5;
            } else if (i5 < 4) {
                i10 = 4;
            }
            Object[] objArr2 = this.f15543v;
            y(i10);
            if (i5 == this.f15542fb) {
                int[] iArr2 = this.y;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.f15543v, 0, objArr2.length);
                }
                v(iArr, objArr2, i5);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i8 < i5) {
            int[] iArr3 = this.y;
            int i11 = i8 + 1;
            System.arraycopy(iArr3, i8, iArr3, i11, i5 - i8);
            Object[] objArr3 = this.f15543v;
            System.arraycopy(objArr3, i8 << 1, objArr3, i11 << 1, (this.f15542fb - i8) << 1);
        }
        int i12 = this.f15542fb;
        if (i5 == i12) {
            int[] iArr4 = this.y;
            if (i8 < iArr4.length) {
                iArr4[i8] = i;
                Object[] objArr4 = this.f15543v;
                int i13 = i8 << 1;
                objArr4[i13] = k2;
                objArr4[i13 + 1] = v2;
                this.f15542fb = i12 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Nullable
    public V putIfAbsent(K k2, V v2) {
        V v3 = get(k2);
        if (v3 == null) {
            return put(k2, v2);
        }
        return v3;
    }

    @Nullable
    public V remove(Object obj) {
        int s2 = s(obj);
        if (s2 >= 0) {
            return tl(s2);
        }
        return null;
    }

    @Nullable
    public V replace(K k2, V v2) {
        int s2 = s(k2);
        if (s2 >= 0) {
            return wz(s2, v2);
        }
        return null;
    }

    public int s(@Nullable Object obj) {
        if (obj == null) {
            return c5();
        }
        return fb(obj, obj.hashCode());
    }

    public int size() {
        return this.f15542fb;
    }

    public void t(@NonNull s<? extends K, ? extends V> sVar) {
        int i = sVar.f15542fb;
        zn(this.f15542fb + i);
        if (this.f15542fb == 0) {
            if (i > 0) {
                System.arraycopy(sVar.y, 0, this.y, 0, i);
                System.arraycopy(sVar.f15543v, 0, this.f15543v, 0, i << 1);
                this.f15542fb = i;
                return;
            }
            return;
        }
        for (int i5 = 0; i5 < i; i5++) {
            put(sVar.f(i5), sVar.xc(i5));
        }
    }

    public V tl(int i) {
        Object[] objArr = this.f15543v;
        int i5 = i << 1;
        V v2 = (V) objArr[i5 + 1];
        int i6 = this.f15542fb;
        int i8 = 0;
        if (i6 <= 1) {
            v(this.y, objArr, i6);
            this.y = gv.y;
            this.f15543v = gv.f15527zn;
        } else {
            int i10 = i6 - 1;
            int[] iArr = this.y;
            int i11 = 8;
            if (iArr.length > 8 && i6 < iArr.length / 3) {
                if (i6 > 8) {
                    i11 = i6 + (i6 >> 1);
                }
                y(i11);
                if (i6 == this.f15542fb) {
                    if (i > 0) {
                        System.arraycopy(iArr, 0, this.y, 0, i);
                        System.arraycopy(objArr, 0, this.f15543v, 0, i5);
                    }
                    if (i < i10) {
                        int i12 = i + 1;
                        int i13 = i10 - i;
                        System.arraycopy(iArr, i12, this.y, i, i13);
                        System.arraycopy(objArr, i12 << 1, this.f15543v, i5, i13 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (i < i10) {
                    int i14 = i + 1;
                    int i15 = i10 - i;
                    System.arraycopy(iArr, i14, iArr, i, i15);
                    Object[] objArr2 = this.f15543v;
                    System.arraycopy(objArr2, i14 << 1, objArr2, i5, i15 << 1);
                }
                Object[] objArr3 = this.f15543v;
                int i16 = i10 << 1;
                objArr3[i16] = null;
                objArr3[i16 + 1] = null;
            }
            i8 = i10;
        }
        if (i6 == this.f15542fb) {
            this.f15542fb = i8;
            return v2;
        }
        throw new ConcurrentModificationException();
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f15542fb * 28);
        sb.append('{');
        for (int i = 0; i < this.f15542fb; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K f4 = f(i);
            if (f4 != this) {
                sb.append(f4);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V xc2 = xc(i);
            if (xc2 != this) {
                sb.append(xc2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public V wz(int i, V v2) {
        int i5 = (i << 1) + 1;
        Object[] objArr = this.f15543v;
        V v3 = (V) objArr[i5];
        objArr[i5] = v2;
        return v3;
    }

    public V xc(int i) {
        return (V) this.f15543v[(i << 1) + 1];
    }

    public final void y(int i) {
        if (i == 8) {
            synchronized (s.class) {
                try {
                    Object[] objArr = f15540t;
                    if (objArr != null) {
                        this.f15543v = objArr;
                        f15540t = (Object[]) objArr[0];
                        this.y = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f15541w--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (s.class) {
                try {
                    Object[] objArr2 = f15539s;
                    if (objArr2 != null) {
                        this.f15543v = objArr2;
                        f15539s = (Object[]) objArr2[0];
                        this.y = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f15538f--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.y = new int[i];
        this.f15543v = new Object[i << 1];
    }

    public void zn(int i) {
        int i5 = this.f15542fb;
        int[] iArr = this.y;
        if (iArr.length < i) {
            Object[] objArr = this.f15543v;
            y(i);
            if (this.f15542fb > 0) {
                System.arraycopy(iArr, 0, this.y, 0, i5);
                System.arraycopy(objArr, 0, this.f15543v, 0, i5 << 1);
            }
            v(iArr, objArr, i5);
        }
        if (this.f15542fb == i5) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public boolean remove(Object obj, Object obj2) {
        int s2 = s(obj);
        if (s2 >= 0) {
            V xc2 = xc(s2);
            if (obj2 == xc2 || (obj2 != null && obj2.equals(xc2))) {
                tl(s2);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean replace(K k2, V v2, V v3) {
        int s2 = s(k2);
        if (s2 >= 0) {
            V xc2 = xc(s2);
            if (xc2 == v2 || (v2 != null && v2.equals(xc2))) {
                wz(s2, v3);
                return true;
            }
            return false;
        }
        return false;
    }

    public s(int i) {
        if (i == 0) {
            this.y = gv.y;
            this.f15543v = gv.f15527zn;
        } else {
            y(i);
        }
        this.f15542fb = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(s<K, V> sVar) {
        this();
        if (sVar != 0) {
            t(sVar);
        }
    }
}
