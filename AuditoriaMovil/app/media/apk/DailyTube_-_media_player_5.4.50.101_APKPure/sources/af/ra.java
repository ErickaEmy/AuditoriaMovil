package af;

import af.mg;
import androidx.annotation.Nullable;
import m1.hy;
import m1.o0;
/* loaded from: classes.dex */
public abstract class ra extends fb<Void> {

    /* renamed from: f3  reason: collision with root package name */
    public static final Void f373f3 = null;

    /* renamed from: r  reason: collision with root package name */
    public final mg f374r;

    public ra(mg mgVar) {
        this.f374r = mgVar;
    }

    public abstract void ad(hy hyVar);

    @Override // af.mg
    public o0 c() {
        return this.f374r.c();
    }

    @Override // af.fb
    /* renamed from: cr */
    public final long g3(Void r1, long j2) {
        return pq(j2);
    }

    public final void cy() {
        bk(f373f3, this.f374r);
    }

    @Override // af.fb, af.y
    public final void e(@Nullable kx.o oVar) {
        super.e(oVar);
        qk();
    }

    @Override // af.y, af.mg
    @Nullable
    public hy k() {
        return this.f374r.k();
    }

    @Override // af.fb
    @Nullable
    /* renamed from: pz */
    public final mg.n3 rb(Void r1, mg.n3 n3Var) {
        return tg(n3Var);
    }

    @Override // af.y, af.mg
    public boolean q9() {
        return this.f374r.q9();
    }

    public void qk() {
        cy();
    }

    @Override // af.fb
    /* renamed from: wf */
    public final void u0(Void r1, mg mgVar, hy hyVar) {
        ad(hyVar);
    }

    @Override // af.fb
    /* renamed from: xb */
    public final int m(Void r1, int i) {
        return o0(i);
    }

    public int o0(int i) {
        return i;
    }

    public long pq(long j2) {
        return j2;
    }

    @Nullable
    public mg.n3 tg(mg.n3 n3Var) {
        return n3Var;
    }
}
