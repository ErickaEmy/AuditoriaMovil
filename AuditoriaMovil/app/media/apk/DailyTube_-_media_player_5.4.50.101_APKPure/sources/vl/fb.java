package vl;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class fb<T> extends a<T> {

    /* renamed from: zn  reason: collision with root package name */
    public final Object f14455zn;

    public fb(int i) {
        super(i);
        this.f14455zn = new Object();
    }

    @Override // vl.a, vl.v
    public T n3() {
        T t2;
        synchronized (this.f14455zn) {
            t2 = (T) super.n3();
        }
        return t2;
    }

    @Override // vl.a, vl.v
    public boolean y(@NonNull T t2) {
        boolean y;
        synchronized (this.f14455zn) {
            y = super.y(t2);
        }
        return y;
    }
}
