package af;

import af.d0;
import af.mg;
import androidx.annotation.Nullable;
import java.io.IOException;
import m1.vc;
/* loaded from: classes.dex */
public final class f3 implements d0, d0.y {

    /* renamed from: co  reason: collision with root package name */
    public long f187co = -9223372036854775807L;

    /* renamed from: f  reason: collision with root package name */
    public d0 f188f;

    /* renamed from: fb  reason: collision with root package name */
    public final kx.n3 f189fb;

    /* renamed from: p  reason: collision with root package name */
    public boolean f190p;

    /* renamed from: s  reason: collision with root package name */
    public mg f191s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public d0.y f192t;

    /* renamed from: v  reason: collision with root package name */
    public final long f193v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public y f194w;
    public final mg.n3 y;

    /* loaded from: classes.dex */
    public interface y {
        void n3(mg.n3 n3Var, IOException iOException);

        void y(mg.n3 n3Var);
    }

    public f3(mg.n3 n3Var, kx.n3 n3Var2, long j2) {
        this.y = n3Var;
        this.f189fb = n3Var2;
        this.f193v = j2;
    }

    public void a(mg.n3 n3Var) {
        long z2 = z(this.f193v);
        d0 f72 = ((mg) v5.y.v(this.f191s)).f7(n3Var, this.f189fb, z2);
        this.f188f = f72;
        if (this.f192t != null) {
            f72.co(this, z2);
        }
    }

    @Override // af.d0
    public long c5(long j2) {
        return ((d0) v5.j5.i9(this.f188f)).c5(j2);
    }

    @Override // af.d0
    public void co(d0.y yVar, long j2) {
        this.f192t = yVar;
        d0 d0Var = this.f188f;
        if (d0Var != null) {
            d0Var.co(this, z(this.f193v));
        }
    }

    @Override // af.d0
    public long f(zo.co[] coVarArr, boolean[] zArr, en[] enVarArr, boolean[] zArr2, long j2) {
        long j4;
        long j6 = this.f187co;
        if (j6 != -9223372036854775807L && j2 == this.f193v) {
            this.f187co = -9223372036854775807L;
            j4 = j6;
        } else {
            j4 = j2;
        }
        return ((d0) v5.j5.i9(this.f188f)).f(coVarArr, zArr, enVarArr, zArr2, j4);
    }

    public void f3(mg mgVar) {
        boolean z2;
        if (this.f191s == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        this.f191s = mgVar;
    }

    @Override // af.d0, af.jz
    public long fb() {
        return ((d0) v5.j5.i9(this.f188f)).fb();
    }

    @Override // af.d0
    public long gv(long j2, vc vcVar) {
        return ((d0) v5.j5.i9(this.f188f)).gv(j2, vcVar);
    }

    public void i4() {
        if (this.f188f != null) {
            ((mg) v5.y.v(this.f191s)).u(this.f188f);
        }
    }

    @Override // af.d0
    public long i9() {
        return ((d0) v5.j5.i9(this.f188f)).i9();
    }

    @Override // af.d0
    public void mt(long j2, boolean z2) {
        ((d0) v5.j5.i9(this.f188f)).mt(j2, z2);
    }

    @Override // af.d0.y
    public void n3(d0 d0Var) {
        ((d0.y) v5.j5.i9(this.f192t)).n3(this);
        y yVar = this.f194w;
        if (yVar != null) {
            yVar.y(this.y);
        }
    }

    @Override // af.d0
    public lc p() {
        return ((d0) v5.j5.i9(this.f188f)).p();
    }

    @Override // af.jz.y
    /* renamed from: r */
    public void t(d0 d0Var) {
        ((d0.y) v5.j5.i9(this.f192t)).t(this);
    }

    @Override // af.d0, af.jz
    public void s(long j2) {
        ((d0) v5.j5.i9(this.f188f)).s(j2);
    }

    @Override // af.d0, af.jz
    public boolean v(long j2) {
        d0 d0Var = this.f188f;
        if (d0Var != null && d0Var.v(j2)) {
            return true;
        }
        return false;
    }

    public long w() {
        return this.f193v;
    }

    @Override // af.d0
    public void wz() throws IOException {
        try {
            d0 d0Var = this.f188f;
            if (d0Var != null) {
                d0Var.wz();
            } else {
                mg mgVar = this.f191s;
                if (mgVar != null) {
                    mgVar.ut();
                }
            }
        } catch (IOException e2) {
            y yVar = this.f194w;
            if (yVar != null) {
                if (!this.f190p) {
                    this.f190p = true;
                    yVar.n3(this.y, e2);
                    return;
                }
                return;
            }
            throw e2;
        }
    }

    public void x4(long j2) {
        this.f187co = j2;
    }

    public long xc() {
        return this.f187co;
    }

    @Override // af.d0, af.jz
    public boolean y() {
        d0 d0Var = this.f188f;
        if (d0Var != null && d0Var.y()) {
            return true;
        }
        return false;
    }

    public final long z(long j2) {
        long j4 = this.f187co;
        if (j4 != -9223372036854775807L) {
            return j4;
        }
        return j2;
    }

    @Override // af.d0, af.jz
    public long zn() {
        return ((d0) v5.j5.i9(this.f188f)).zn();
    }
}
