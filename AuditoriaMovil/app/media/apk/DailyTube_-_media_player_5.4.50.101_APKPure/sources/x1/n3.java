package x1;

import e4.fh;
import e4.rz;
import v5.j5;
import v5.x4;
/* loaded from: classes.dex */
public final class n3 implements fb {

    /* renamed from: gv  reason: collision with root package name */
    public long f14908gv;

    /* renamed from: n3  reason: collision with root package name */
    public final x4 f14909n3;
    public final long y;

    /* renamed from: zn  reason: collision with root package name */
    public final x4 f14910zn;

    public n3(long j2, long j4, long j6) {
        this.f14908gv = j2;
        this.y = j6;
        x4 x4Var = new x4();
        this.f14909n3 = x4Var;
        x4 x4Var2 = new x4();
        this.f14910zn = x4Var2;
        x4Var.y(0L);
        x4Var2.y(j4);
    }

    @Override // e4.fh
    public long c5() {
        return this.f14908gv;
    }

    @Override // x1.fb
    public long fb() {
        return this.y;
    }

    @Override // e4.fh
    public fh.y gv(long j2) {
        int fb2 = j5.fb(this.f14909n3, j2, true, true);
        rz rzVar = new rz(this.f14909n3.n3(fb2), this.f14910zn.n3(fb2));
        if (rzVar.y != j2 && fb2 != this.f14909n3.zn() - 1) {
            int i = fb2 + 1;
            return new fh.y(rzVar, new rz(this.f14909n3.n3(i), this.f14910zn.n3(i)));
        }
        return new fh.y(rzVar);
    }

    @Override // x1.fb
    public long n3(long j2) {
        return this.f14909n3.n3(j5.fb(this.f14910zn, j2, true, true));
    }

    @Override // e4.fh
    public boolean s() {
        return true;
    }

    public void v(long j2) {
        this.f14908gv = j2;
    }

    public boolean y(long j2) {
        x4 x4Var = this.f14909n3;
        if (j2 - x4Var.n3(x4Var.zn() - 1) < 100000) {
            return true;
        }
        return false;
    }

    public void zn(long j2, long j4) {
        if (y(j2)) {
            return;
        }
        this.f14909n3.y(j2);
        this.f14910zn.y(j4);
    }
}
