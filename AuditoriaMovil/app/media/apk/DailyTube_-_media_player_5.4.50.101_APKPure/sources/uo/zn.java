package uo;

import androidx.annotation.Nullable;
import vn.y;
/* loaded from: classes.dex */
public class zn<T> {
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public y<?, ?> f14080n3;
    public final n3<T> y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public T f14081zn;

    public zn() {
        this.y = new n3<>();
        this.f14081zn = null;
    }

    @Nullable
    public final T n3(float f4, float f6, T t2, T t3, float f9, float f10, float f11) {
        return y(this.y.s(f4, f6, t2, t3, f9, f10, f11));
    }

    @Nullable
    public T y(n3<T> n3Var) {
        return this.f14081zn;
    }

    public final void zn(@Nullable y<?, ?> yVar) {
        this.f14080n3 = yVar;
    }

    public zn(@Nullable T t2) {
        this.y = new n3<>();
        this.f14081zn = t2;
    }
}
