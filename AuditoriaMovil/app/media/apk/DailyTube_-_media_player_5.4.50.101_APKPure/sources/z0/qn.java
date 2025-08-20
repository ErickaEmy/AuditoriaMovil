package z0;
/* loaded from: classes.dex */
public final class qn<E> extends c<E> {

    /* renamed from: co  reason: collision with root package name */
    public static final qn<Object> f15633co;

    /* renamed from: p  reason: collision with root package name */
    public static final Object[] f15634p;

    /* renamed from: f  reason: collision with root package name */
    public final transient Object[] f15635f;

    /* renamed from: fb  reason: collision with root package name */
    public final transient Object[] f15636fb;

    /* renamed from: s  reason: collision with root package name */
    public final transient int f15637s;

    /* renamed from: t  reason: collision with root package name */
    public final transient int f15638t;

    /* renamed from: w  reason: collision with root package name */
    public final transient int f15639w;

    static {
        Object[] objArr = new Object[0];
        f15634p = objArr;
        f15633co = new qn<>(objArr, 0, objArr, 0, 0);
    }

    public qn(Object[] objArr, int i, Object[] objArr2, int i5, int i6) {
        this.f15636fb = objArr;
        this.f15637s = i;
        this.f15635f = objArr2;
        this.f15638t = i5;
        this.f15639w = i6;
    }

    @Override // z0.z, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Object[] objArr = this.f15635f;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int zn2 = co.zn(obj);
        while (true) {
            int i = zn2 & this.f15638t;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zn2 = i + 1;
        }
    }

    @Override // z0.c
    public x4<E> d() {
        return x4.r(this.f15636fb, this.f15639w);
    }

    @Override // z0.z
    public int gv(Object[] objArr, int i) {
        System.arraycopy(this.f15636fb, 0, objArr, i, this.f15639w);
        return i + this.f15639w;
    }

    @Override // z0.c, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f15637s;
    }

    @Override // z0.z
    public int i9() {
        return this.f15639w;
    }

    @Override // z0.c, z0.z, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: mt */
    public en<E> iterator() {
        return y().iterator();
    }

    @Override // z0.z
    public boolean p() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f15639w;
    }

    @Override // z0.z
    public int t() {
        return 0;
    }

    @Override // z0.c
    public boolean ud() {
        return true;
    }

    @Override // z0.z
    public Object[] v() {
        return this.f15636fb;
    }
}
