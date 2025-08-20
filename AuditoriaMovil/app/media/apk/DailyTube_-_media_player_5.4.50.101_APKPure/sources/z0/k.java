package z0;

import w0.xc;
/* loaded from: classes.dex */
public final class k<E> extends c<E> {

    /* renamed from: fb  reason: collision with root package name */
    public final transient E f15630fb;

    public k(E e2) {
        this.f15630fb = (E) xc.wz(e2);
    }

    @Override // z0.z, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f15630fb.equals(obj);
    }

    @Override // z0.z
    public int gv(Object[] objArr, int i) {
        objArr[i] = this.f15630fb;
        return i + 1;
    }

    @Override // z0.c, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f15630fb.hashCode();
    }

    @Override // z0.c, z0.z, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: mt */
    public en<E> iterator() {
        return fh.mt(this.f15630fb);
    }

    @Override // z0.z
    public boolean p() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String obj = this.f15630fb.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    @Override // z0.c, z0.z
    public x4<E> y() {
        return x4.o(this.f15630fb);
    }
}
