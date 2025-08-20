package y3;

import m1.m;
import v5.j5;
import v5.k5;
import y3.ud;
/* loaded from: classes.dex */
public final class x4 implements fh {

    /* renamed from: n3  reason: collision with root package name */
    public k5 f15232n3;
    public m y;

    /* renamed from: zn  reason: collision with root package name */
    public e4.ta f15233zn;

    public x4(String str) {
        this.y = new m.n3().o4(str).z6();
    }

    @Override // y3.fh
    public void n3(v5.rz rzVar) {
        zn();
        long gv2 = this.f15232n3.gv();
        long v2 = this.f15232n3.v();
        if (gv2 != -9223372036854775807L && v2 != -9223372036854775807L) {
            m mVar = this.y;
            if (v2 != mVar.f10951fh) {
                m z62 = mVar.n3().nf(v2).z6();
                this.y = z62;
                this.f15233zn.v(z62);
            }
            int y = rzVar.y();
            this.f15233zn.zn(rzVar, y);
            this.f15233zn.gv(gv2, 1, y, 0, null);
        }
    }

    @Override // y3.fh
    public void y(k5 k5Var, e4.wz wzVar, ud.gv gvVar) {
        this.f15232n3 = k5Var;
        gvVar.y();
        e4.ta a2 = wzVar.a(gvVar.zn(), 5);
        this.f15233zn = a2;
        a2.v(this.y);
    }

    public final void zn() {
        v5.y.c5(this.f15232n3);
        j5.i9(this.f15233zn);
    }
}
