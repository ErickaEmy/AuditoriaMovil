package jk;

import d9.n3;
import e4.ta;
import v5.fh;
import v5.j5;
import v5.rz;
/* loaded from: classes.dex */
public final class zn implements f {

    /* renamed from: a  reason: collision with root package name */
    public long f9545a;

    /* renamed from: fb  reason: collision with root package name */
    public long f9546fb;

    /* renamed from: gv  reason: collision with root package name */
    public int f9547gv;

    /* renamed from: n3  reason: collision with root package name */
    public final fh f9548n3 = new fh();

    /* renamed from: v  reason: collision with root package name */
    public long f9549v = -9223372036854775807L;
    public final r4.s y;

    /* renamed from: zn  reason: collision with root package name */
    public ta f9550zn;

    public zn(r4.s sVar) {
        this.y = sVar;
    }

    public final void a() {
        ((ta) j5.i9(this.f9550zn)).gv(this.f9545a, 1, this.f9547gv, 0, null);
        this.f9547gv = 0;
    }

    public final void c5(rz rzVar, long j2) {
        int y = rzVar.y();
        ((ta) v5.y.v(this.f9550zn)).zn(rzVar, y);
        ((ta) j5.i9(this.f9550zn)).gv(j2, 1, y, 0, null);
    }

    public final void fb(rz rzVar, boolean z2, int i, long j2) {
        int y = rzVar.y();
        ((ta) v5.y.v(this.f9550zn)).zn(rzVar, y);
        this.f9547gv += y;
        this.f9545a = j2;
        if (z2 && i == 3) {
            a();
        }
    }

    @Override // jk.f
    public void gv(e4.wz wzVar, int i) {
        ta a2 = wzVar.a(i, 1);
        this.f9550zn = a2;
        a2.v(this.y.f13101zn);
    }

    @Override // jk.f
    public void n3(rz rzVar, long j2, int i, boolean z2) {
        int ej2 = rzVar.ej() & 3;
        int ej3 = rzVar.ej() & 255;
        long y = tl.y(this.f9546fb, j2, this.f9549v, this.y.f13099n3);
        if (ej2 != 0) {
            if (ej2 != 1 && ej2 != 2) {
                if (ej2 != 3) {
                    throw new IllegalArgumentException(String.valueOf(ej2));
                }
            } else {
                v();
            }
            fb(rzVar, z2, ej2, y);
            return;
        }
        v();
        if (ej3 == 1) {
            c5(rzVar, y);
        } else {
            s(rzVar, ej3, y);
        }
    }

    public final void s(rz rzVar, int i, long j2) {
        this.f9548n3.wz(rzVar.v());
        this.f9548n3.co(2);
        for (int i5 = 0; i5 < i; i5++) {
            n3.C0080n3 a2 = d9.n3.a(this.f9548n3);
            ((ta) v5.y.v(this.f9550zn)).zn(rzVar, a2.f7095v);
            ((ta) j5.i9(this.f9550zn)).gv(j2, 1, a2.f7095v, 0, null);
            j2 += (a2.f7091a / a2.f7096zn) * 1000000;
            this.f9548n3.co(a2.f7095v);
        }
    }

    public final void v() {
        if (this.f9547gv > 0) {
            a();
        }
    }

    @Override // jk.f
    public void y(long j2, long j4) {
        this.f9549v = j2;
        this.f9546fb = j4;
    }

    @Override // jk.f
    public void zn(long j2, int i) {
        boolean z2;
        if (this.f9549v == -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        this.f9549v = j2;
    }
}
