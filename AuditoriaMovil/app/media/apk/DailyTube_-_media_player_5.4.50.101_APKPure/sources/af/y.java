package af;

import af.b;
import af.mg;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.v;
import fj.u0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import m1.hy;
/* loaded from: classes.dex */
public abstract class y implements mg {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Looper f430f;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public hy f433t;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public u0 f435w;
    public final ArrayList<mg.zn> y = new ArrayList<>(1);

    /* renamed from: v  reason: collision with root package name */
    public final HashSet<mg.zn> f434v = new HashSet<>(1);

    /* renamed from: fb  reason: collision with root package name */
    public final b.y f431fb = new b.y();

    /* renamed from: s  reason: collision with root package name */
    public final v.y f432s = new v.y();

    public abstract void ap();

    public final b.y ct(int i, @Nullable mg.n3 n3Var, long j2) {
        return this.f431fb.d(i, n3Var, j2);
    }

    public final v.y dm(@Nullable mg.n3 n3Var) {
        return this.f432s.r(0, n3Var);
    }

    public abstract void e(@Nullable kx.o oVar);

    @Override // af.mg
    public final void hw(mg.zn znVar) {
        this.y.remove(znVar);
        if (this.y.isEmpty()) {
            this.f430f = null;
            this.f433t = null;
            this.f435w = null;
            this.f434v.clear();
            ap();
            return;
        }
        vl(znVar);
    }

    @Override // af.mg
    public final void j(com.google.android.exoplayer2.drm.v vVar) {
        this.f432s.z(vVar);
    }

    @Override // af.mg
    public final void jz(b bVar) {
        this.f431fb.rz(bVar);
    }

    @Override // af.mg
    public /* synthetic */ hy k() {
        return rz.y(this);
    }

    @Override // af.mg
    public final void mt(mg.zn znVar, @Nullable kx.o oVar, u0 u0Var) {
        boolean z2;
        Looper myLooper = Looper.myLooper();
        Looper looper = this.f430f;
        if (looper != null && looper != myLooper) {
            z2 = false;
        } else {
            z2 = true;
        }
        v5.y.y(z2);
        this.f435w = u0Var;
        hy hyVar = this.f433t;
        this.y.add(znVar);
        if (this.f430f == null) {
            this.f430f = myLooper;
            this.f434v.add(znVar);
            e(oVar);
        } else if (hyVar != null) {
            z6(znVar);
            znVar.y(this, hyVar);
        }
    }

    public final u0 nf() {
        return (u0) v5.y.c5(this.f435w);
    }

    @Override // af.mg
    public final void o(Handler handler, com.google.android.exoplayer2.drm.v vVar) {
        v5.y.v(handler);
        v5.y.v(vVar);
        this.f432s.fb(handler, vVar);
    }

    public final b.y o4(@Nullable mg.n3 n3Var) {
        return this.f431fb.d(0, n3Var, 0L);
    }

    @Override // af.mg
    public /* synthetic */ boolean q9() {
        return rz.n3(this);
    }

    public final boolean ra() {
        return !this.f434v.isEmpty();
    }

    public final b.y rs(mg.n3 n3Var, long j2) {
        v5.y.v(n3Var);
        return this.f431fb.d(0, n3Var, j2);
    }

    public final void s8(hy hyVar) {
        this.f433t = hyVar;
        Iterator<mg.zn> it = this.y.iterator();
        while (it.hasNext()) {
            it.next().y(this, hyVar);
        }
    }

    @Override // af.mg
    public final void vl(mg.zn znVar) {
        boolean isEmpty = this.f434v.isEmpty();
        this.f434v.remove(znVar);
        if (!isEmpty && this.f434v.isEmpty()) {
            eb();
        }
    }

    public final v.y xg(int i, @Nullable mg.n3 n3Var) {
        return this.f432s.r(i, n3Var);
    }

    @Override // af.mg
    public final void y5(Handler handler, b bVar) {
        v5.y.v(handler);
        v5.y.v(bVar);
        this.f431fb.fb(handler, bVar);
    }

    @Override // af.mg
    public final void z6(mg.zn znVar) {
        v5.y.v(this.f430f);
        boolean isEmpty = this.f434v.isEmpty();
        this.f434v.add(znVar);
        if (isEmpty) {
            lc();
        }
    }

    public void eb() {
    }

    public void lc() {
    }
}
