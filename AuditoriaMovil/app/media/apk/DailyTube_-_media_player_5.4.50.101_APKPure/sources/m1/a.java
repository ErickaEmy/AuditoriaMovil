package m1;

import androidx.annotation.Nullable;
import java.io.IOException;
/* loaded from: classes.dex */
public abstract class a implements zq, k3 {

    /* renamed from: co  reason: collision with root package name */
    public long f10568co;

    /* renamed from: f  reason: collision with root package name */
    public fj.u0 f10569f;

    /* renamed from: f3  reason: collision with root package name */
    public boolean f10570f3;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public ic f10571fb;

    /* renamed from: n  reason: collision with root package name */
    public boolean f10572n;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public m[] f10573p;

    /* renamed from: s  reason: collision with root package name */
    public int f10575s;

    /* renamed from: t  reason: collision with root package name */
    public int f10576t;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public af.en f10578w;
    public final int y;

    /* renamed from: z  reason: collision with root package name */
    public long f10579z;

    /* renamed from: v  reason: collision with root package name */
    public final g f10577v = new g();

    /* renamed from: r  reason: collision with root package name */
    public long f10574r = Long.MIN_VALUE;

    public a(int i) {
        this.y = i;
    }

    public abstract void b(m[] mVarArr, long j2, long j4) throws p;

    public final ic c() {
        return (ic) v5.y.v(this.f10571fb);
    }

    @Override // m1.zq
    public final boolean c5() {
        if (this.f10574r == Long.MIN_VALUE) {
            return true;
        }
        return false;
    }

    public int co() throws p {
        return 0;
    }

    public abstract void d();

    public final g d0() {
        this.f10577v.y();
        return this.f10577v;
    }

    public abstract void ej(long j2, boolean z2) throws p;

    @Override // m1.zq
    public final void f(int i, fj.u0 u0Var) {
        this.f10575s = i;
        this.f10569f = u0Var;
    }

    public final p f3(Throwable th, @Nullable m mVar, int i) {
        return n(th, mVar, false, i);
    }

    @Override // m1.zq
    public final void fb() {
        boolean z2 = true;
        if (this.f10576t != 1) {
            z2 = false;
        }
        v5.y.fb(z2);
        this.f10577v.y();
        this.f10576t = 0;
        this.f10578w = null;
        this.f10573p = null;
        this.f10570f3 = false;
        d();
    }

    public final int fh() {
        return this.f10575s;
    }

    @Override // m1.zq
    public final int getState() {
        return this.f10576t;
    }

    @Override // m1.zq
    @Nullable
    public final af.en getStream() {
        return this.f10578w;
    }

    @Override // m1.zq
    @Nullable
    public v5.i4 i4() {
        return null;
    }

    @Override // m1.zq
    public final void i9() {
        this.f10570f3 = true;
    }

    public final int k5(g gVar, a9.fb fbVar, int i) {
        int a2 = ((af.en) v5.y.v(this.f10578w)).a(gVar, fbVar, i);
        if (a2 == -4) {
            if (fbVar.t()) {
                this.f10574r = Long.MIN_VALUE;
                if (this.f10570f3) {
                    return -4;
                }
                return -3;
            }
            long j2 = fbVar.f55f + this.f10568co;
            fbVar.f55f = j2;
            this.f10574r = Math.max(this.f10574r, j2);
        } else if (a2 == -5) {
            m mVar = (m) v5.y.v(gVar.f10757n3);
            if (mVar.f10951fh != Long.MAX_VALUE) {
                gVar.f10757n3 = mVar.n3().nf(mVar.f10951fh + this.f10568co).z6();
            }
        }
        return a2;
    }

    public final m[] mg() {
        return (m[]) v5.y.v(this.f10573p);
    }

    @Override // m1.zq
    public final void mt(m[] mVarArr, af.en enVar, long j2, long j4) throws p {
        v5.y.fb(!this.f10570f3);
        this.f10578w = enVar;
        if (this.f10574r == Long.MIN_VALUE) {
            this.f10574r = j2;
        }
        this.f10573p = mVarArr;
        this.f10568co = j4;
        b(mVarArr, j2, j4);
    }

    public final p n(Throwable th, @Nullable m mVar, boolean z2, int i) {
        int i5;
        if (mVar != null && !this.f10572n) {
            this.f10572n = true;
            try {
                int a2 = hk.a(n3(mVar));
                this.f10572n = false;
                i5 = a2;
            } catch (p unused) {
                this.f10572n = false;
            } catch (Throwable th2) {
                this.f10572n = false;
                throw th2;
            }
            return p.mt(th, getName(), fh(), mVar, i5, z2, i);
        }
        i5 = 4;
        return p.mt(th, getName(), fh(), mVar, i5, z2, i);
    }

    @Override // m1.zq
    public /* synthetic */ void p(float f4, float f6) {
        jr.y(this, f4, f6);
    }

    @Override // m1.zq
    public final long r() {
        return this.f10574r;
    }

    public final fj.u0 rz() {
        return (fj.u0) v5.y.v(this.f10569f);
    }

    @Override // m1.zq, m1.k3
    public final int s() {
        return this.y;
    }

    @Override // m1.zq
    public final void start() throws p {
        boolean z2 = true;
        if (this.f10576t != 1) {
            z2 = false;
        }
        v5.y.fb(z2);
        this.f10576t = 2;
        a8();
    }

    @Override // m1.zq
    public final void stop() {
        boolean z2;
        if (this.f10576t == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        this.f10576t = 1;
        x();
    }

    @Override // m1.zq
    public final void t(ic icVar, m[] mVarArr, af.en enVar, long j2, boolean z2, boolean z3, long j4, long j6) throws p {
        boolean z4;
        if (this.f10576t == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        v5.y.fb(z4);
        this.f10571fb = icVar;
        this.f10576t = 1;
        z6(z2, z3);
        mt(mVarArr, enVar, j4, j6);
        yt(j2, z2);
    }

    public final boolean ta() {
        if (c5()) {
            return this.f10570f3;
        }
        return ((af.en) v5.y.v(this.f10578w)).isReady();
    }

    public int vl(long j2) {
        return ((af.en) v5.y.v(this.f10578w)).t(j2 - this.f10568co);
    }

    @Override // m1.zq
    public final void wz() throws IOException {
        ((af.en) v5.y.v(this.f10578w)).n3();
    }

    @Override // m1.zq
    public final void x4(long j2) throws p {
        yt(j2, false);
    }

    @Override // m1.zq
    public final boolean xc() {
        return this.f10570f3;
    }

    @Override // m1.zq
    public final void y() {
        boolean z2;
        if (this.f10576t == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        this.f10577v.y();
        ud();
    }

    public final void yt(long j2, boolean z2) throws p {
        this.f10570f3 = false;
        this.f10579z = j2;
        this.f10574r = j2;
        ej(j2, z2);
    }

    public void a8() throws p {
    }

    @Override // m1.zq
    public final k3 gv() {
        return this;
    }

    public void ud() {
    }

    public void x() {
    }

    @Override // m1.c8.n3
    public void tl(int i, @Nullable Object obj) throws p {
    }

    public void z6(boolean z2, boolean z3) throws p {
    }
}
