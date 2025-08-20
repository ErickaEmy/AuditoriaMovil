package n6;

import e4.fh;
import e4.rz;
import v5.j5;
/* loaded from: classes.dex */
public final class v implements fh {

    /* renamed from: gv  reason: collision with root package name */
    public final long f11836gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f11837n3;

    /* renamed from: v  reason: collision with root package name */
    public final long f11838v;
    public final zn y;

    /* renamed from: zn  reason: collision with root package name */
    public final long f11839zn;

    public v(zn znVar, int i, long j2, long j4) {
        this.y = znVar;
        this.f11837n3 = i;
        this.f11839zn = j2;
        long j6 = (j4 - j2) / znVar.f11844v;
        this.f11836gv = j6;
        this.f11838v = y(j6);
    }

    @Override // e4.fh
    public long c5() {
        return this.f11838v;
    }

    @Override // e4.fh
    public fh.y gv(long j2) {
        long mt2 = j5.mt((this.y.f11845zn * j2) / (this.f11837n3 * 1000000), 0L, this.f11836gv - 1);
        long j4 = this.f11839zn + (this.y.f11844v * mt2);
        long y = y(mt2);
        rz rzVar = new rz(y, j4);
        if (y < j2 && mt2 != this.f11836gv - 1) {
            long j6 = mt2 + 1;
            return new fh.y(rzVar, new rz(y(j6), this.f11839zn + (this.y.f11844v * j6)));
        }
        return new fh.y(rzVar);
    }

    @Override // e4.fh
    public boolean s() {
        return true;
    }

    public final long y(long j2) {
        return j5.x5(j2 * this.f11837n3, 1000000L, this.y.f11845zn);
    }
}
