package z;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class n3<E> implements Collection<E>, Set<E> {
    @Nullable

    /* renamed from: co  reason: collision with root package name */
    public static Object[] f15528co;

    /* renamed from: p  reason: collision with root package name */
    public static int f15530p;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public static Object[] f15532w;

    /* renamed from: z  reason: collision with root package name */
    public static int f15533z;

    /* renamed from: fb  reason: collision with root package name */
    public int f15534fb;

    /* renamed from: s  reason: collision with root package name */
    public fb<E, E> f15535s;

    /* renamed from: v  reason: collision with root package name */
    public Object[] f15536v;
    public int[] y;

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f15529f = new int[0];

    /* renamed from: t  reason: collision with root package name */
    public static final Object[] f15531t = new Object[0];

    /* loaded from: classes.dex */
    public class y extends fb<E, E> {
        public y() {
        }

        @Override // z.fb
        public int a(Object obj) {
            return n3.this.indexOf(obj);
        }

        @Override // z.fb
        public E c5(int i, E e2) {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // z.fb
        public void fb(E e2, E e3) {
            n3.this.add(e2);
        }

        @Override // z.fb
        public int gv() {
            return n3.this.f15534fb;
        }

        @Override // z.fb
        public Object n3(int i, int i5) {
            return n3.this.f15536v[i];
        }

        @Override // z.fb
        public void s(int i) {
            n3.this.c5(i);
        }

        @Override // z.fb
        public int v(Object obj) {
            return n3.this.indexOf(obj);
        }

        @Override // z.fb
        public void y() {
            n3.this.clear();
        }

        @Override // z.fb
        public Map<E, E> zn() {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public n3() {
        this(0);
    }

    public static void zn(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (n3.class) {
                try {
                    if (f15533z < 10) {
                        objArr[0] = f15528co;
                        objArr[1] = iArr;
                        for (int i5 = i - 1; i5 >= 2; i5--) {
                            objArr[i5] = null;
                        }
                        f15528co = objArr;
                        f15533z++;
                    }
                } finally {
                }
            }
        } else if (iArr.length == 4) {
            synchronized (n3.class) {
                try {
                    if (f15530p < 10) {
                        objArr[0] = f15532w;
                        objArr[1] = iArr;
                        for (int i6 = i - 1; i6 >= 2; i6--) {
                            objArr[i6] = null;
                        }
                        f15532w = objArr;
                        f15530p++;
                    }
                } finally {
                }
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(@Nullable E e2) {
        int i;
        int v2;
        if (e2 == null) {
            v2 = fb();
            i = 0;
        } else {
            int hashCode = e2.hashCode();
            i = hashCode;
            v2 = v(e2, hashCode);
        }
        if (v2 >= 0) {
            return false;
        }
        int i5 = ~v2;
        int i6 = this.f15534fb;
        int[] iArr = this.y;
        if (i6 >= iArr.length) {
            int i8 = 8;
            if (i6 >= 8) {
                i8 = (i6 >> 1) + i6;
            } else if (i6 < 4) {
                i8 = 4;
            }
            Object[] objArr = this.f15536v;
            y(i8);
            int[] iArr2 = this.y;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f15536v, 0, objArr.length);
            }
            zn(iArr, objArr, this.f15534fb);
        }
        int i10 = this.f15534fb;
        if (i5 < i10) {
            int[] iArr3 = this.y;
            int i11 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i11, i10 - i5);
            Object[] objArr2 = this.f15536v;
            System.arraycopy(objArr2, i5, objArr2, i11, this.f15534fb - i5);
        }
        this.y[i5] = i;
        this.f15536v[i5] = e2;
        this.f15534fb++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(@NonNull Collection<? extends E> collection) {
        n3(this.f15534fb + collection.size());
        boolean z2 = false;
        for (E e2 : collection) {
            z2 |= add(e2);
        }
        return z2;
    }

    public E c5(int i) {
        Object[] objArr = this.f15536v;
        E e2 = (E) objArr[i];
        int i5 = this.f15534fb;
        if (i5 <= 1) {
            zn(this.y, objArr, i5);
            this.y = f15529f;
            this.f15536v = f15531t;
            this.f15534fb = 0;
        } else {
            int[] iArr = this.y;
            int i6 = 8;
            if (iArr.length > 8 && i5 < iArr.length / 3) {
                if (i5 > 8) {
                    i6 = i5 + (i5 >> 1);
                }
                y(i6);
                this.f15534fb--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.y, 0, i);
                    System.arraycopy(objArr, 0, this.f15536v, 0, i);
                }
                int i8 = this.f15534fb;
                if (i < i8) {
                    int i10 = i + 1;
                    System.arraycopy(iArr, i10, this.y, i, i8 - i);
                    System.arraycopy(objArr, i10, this.f15536v, i, this.f15534fb - i);
                }
            } else {
                int i11 = i5 - 1;
                this.f15534fb = i11;
                if (i < i11) {
                    int i12 = i + 1;
                    System.arraycopy(iArr, i12, iArr, i, i11 - i);
                    Object[] objArr2 = this.f15536v;
                    System.arraycopy(objArr2, i12, objArr2, i, this.f15534fb - i);
                }
                this.f15536v[this.f15534fb] = null;
            }
        }
        return e2;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.f15534fb;
        if (i != 0) {
            zn(this.y, this.f15536v, i);
            this.y = f15529f;
            this.f15536v = f15531t;
            this.f15534fb = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(@Nullable Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(@NonNull Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.f15534fb; i++) {
                try {
                    if (!set.contains(i9(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final int fb() {
        int i = this.f15534fb;
        if (i == 0) {
            return -1;
        }
        int y2 = gv.y(this.y, i, 0);
        if (y2 < 0) {
            return y2;
        }
        if (this.f15536v[y2] == null) {
            return y2;
        }
        int i5 = y2 + 1;
        while (i5 < i && this.y[i5] == 0) {
            if (this.f15536v[i5] == null) {
                return i5;
            }
            i5++;
        }
        for (int i6 = y2 - 1; i6 >= 0 && this.y[i6] == 0; i6--) {
            if (this.f15536v[i6] == null) {
                return i6;
            }
        }
        return ~i5;
    }

    public final fb<E, E> gv() {
        if (this.f15535s == null) {
            this.f15535s = new y();
        }
        return this.f15535s;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.y;
        int i = this.f15534fb;
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            i5 += iArr[i6];
        }
        return i5;
    }

    @Nullable
    public E i9(int i) {
        return (E) this.f15536v[i];
    }

    public int indexOf(@Nullable Object obj) {
        if (obj == null) {
            return fb();
        }
        return v(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (this.f15534fb <= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return gv().tl().iterator();
    }

    public void n3(int i) {
        int[] iArr = this.y;
        if (iArr.length < i) {
            Object[] objArr = this.f15536v;
            y(i);
            int i5 = this.f15534fb;
            if (i5 > 0) {
                System.arraycopy(iArr, 0, this.y, 0, i5);
                System.arraycopy(objArr, 0, this.f15536v, 0, this.f15534fb);
            }
            zn(iArr, objArr, this.f15534fb);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(@Nullable Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            c5(indexOf);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(@NonNull Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            z2 |= remove(it.next());
        }
        return z2;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(@NonNull Collection<?> collection) {
        boolean z2 = false;
        for (int i = this.f15534fb - 1; i >= 0; i--) {
            if (!collection.contains(this.f15536v[i])) {
                c5(i);
                z2 = true;
            }
        }
        return z2;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f15534fb;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public Object[] toArray() {
        int i = this.f15534fb;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f15536v, 0, objArr, 0, i);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f15534fb * 14);
        sb.append('{');
        for (int i = 0; i < this.f15534fb; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E i92 = i9(i);
            if (i92 != this) {
                sb.append(i92);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final int v(Object obj, int i) {
        int i5 = this.f15534fb;
        if (i5 == 0) {
            return -1;
        }
        int y2 = gv.y(this.y, i5, i);
        if (y2 < 0) {
            return y2;
        }
        if (obj.equals(this.f15536v[y2])) {
            return y2;
        }
        int i6 = y2 + 1;
        while (i6 < i5 && this.y[i6] == i) {
            if (obj.equals(this.f15536v[i6])) {
                return i6;
            }
            i6++;
        }
        for (int i8 = y2 - 1; i8 >= 0 && this.y[i8] == i; i8--) {
            if (obj.equals(this.f15536v[i8])) {
                return i8;
            }
        }
        return ~i6;
    }

    public final void y(int i) {
        if (i == 8) {
            synchronized (n3.class) {
                try {
                    Object[] objArr = f15528co;
                    if (objArr != null) {
                        this.f15536v = objArr;
                        f15528co = (Object[]) objArr[0];
                        this.y = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f15533z--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (n3.class) {
                try {
                    Object[] objArr2 = f15532w;
                    if (objArr2 != null) {
                        this.f15536v = objArr2;
                        f15532w = (Object[]) objArr2[0];
                        this.y = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f15530p--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.y = new int[i];
        this.f15536v = new Object[i];
    }

    public n3(int i) {
        if (i == 0) {
            this.y = f15529f;
            this.f15536v = f15531t;
        } else {
            y(i);
        }
        this.f15534fb = 0;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public <T> T[] toArray(@NonNull T[] tArr) {
        if (tArr.length < this.f15534fb) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f15534fb));
        }
        System.arraycopy(this.f15536v, 0, tArr, 0, this.f15534fb);
        int length = tArr.length;
        int i = this.f15534fb;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n3(@Nullable Collection<E> collection) {
        this();
        if (collection != 0) {
            addAll(collection);
        }
    }
}
