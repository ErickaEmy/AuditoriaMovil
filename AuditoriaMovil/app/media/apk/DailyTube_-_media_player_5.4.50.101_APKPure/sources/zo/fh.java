package zo;

import af.lc;
import af.mg;
import androidx.annotation.Nullable;
import m1.hy;
import m1.k3;
/* loaded from: classes.dex */
public abstract class fh {
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public kx.a f15762n3;
    @Nullable
    public y y;

    /* loaded from: classes.dex */
    public interface y {
        void y();
    }

    public void a(y yVar, kx.a aVar) {
        this.y = yVar;
        this.f15762n3 = aVar;
    }

    public abstract void c5(@Nullable Object obj);

    public abstract rz f(k3[] k3VarArr, lc lcVar, mg.n3 n3Var, hy hyVar) throws m1.p;

    public final void fb() {
        y yVar = this.y;
        if (yVar != null) {
            yVar.y();
        }
    }

    public final kx.a gv() {
        return (kx.a) v5.y.c5(this.f15762n3);
    }

    public void i9() {
        this.y = null;
        this.f15762n3 = null;
    }

    public boolean s() {
        return false;
    }

    public c v() {
        return c.f15694q9;
    }

    public void t(d9.v vVar) {
    }

    public void tl(c cVar) {
    }
}
