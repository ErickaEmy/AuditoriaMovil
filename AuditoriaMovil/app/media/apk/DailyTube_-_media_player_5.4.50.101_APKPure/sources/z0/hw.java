package z0;

import java.util.Objects;
import w0.xc;
/* loaded from: classes.dex */
public class hw<E> extends x4<E> {

    /* renamed from: f  reason: collision with root package name */
    public static final x4<Object> f15613f = new hw(new Object[0], 0);

    /* renamed from: fb  reason: collision with root package name */
    public final transient Object[] f15614fb;

    /* renamed from: s  reason: collision with root package name */
    public final transient int f15615s;

    public hw(Object[] objArr, int i) {
        this.f15614fb = objArr;
        this.f15615s = i;
    }

    @Override // java.util.List
    public E get(int i) {
        xc.t(i, this.f15615s);
        E e2 = (E) this.f15614fb[i];
        Objects.requireNonNull(e2);
        return e2;
    }

    @Override // z0.x4, z0.z
    public int gv(Object[] objArr, int i) {
        System.arraycopy(this.f15614fb, 0, objArr, i, this.f15615s);
        return i + this.f15615s;
    }

    @Override // z0.z
    public int i9() {
        return this.f15615s;
    }

    @Override // z0.z
    public boolean p() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f15615s;
    }

    @Override // z0.z
    public int t() {
        return 0;
    }

    @Override // z0.z
    public Object[] v() {
        return this.f15614fb;
    }
}
