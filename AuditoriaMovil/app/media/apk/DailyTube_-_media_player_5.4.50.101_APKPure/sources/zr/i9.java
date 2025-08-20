package zr;

import dq.t;
/* loaded from: classes.dex */
public final class i9 implements s {

    /* renamed from: n3  reason: collision with root package name */
    public final long f15928n3;
    public final e4.gv y;

    public i9(e4.gv gvVar, long j2) {
        this.y = gvVar;
        this.f15928n3 = j2;
    }

    @Override // zr.s
    public long a(long j2, long j4) {
        return this.y.y(j2 + this.f15928n3);
    }

    @Override // zr.s
    public long c5() {
        return 0L;
    }

    @Override // zr.s
    public long fb(long j2) {
        return this.y.y;
    }

    @Override // zr.s
    public long gv(long j2, long j4) {
        return -9223372036854775807L;
    }

    @Override // zr.s
    public long i9(long j2, long j4) {
        return this.y.y;
    }

    @Override // zr.s
    public long n3(long j2) {
        return this.y.f7508v[(int) j2] - this.f15928n3;
    }

    @Override // zr.s
    public boolean s() {
        return true;
    }

    @Override // zr.s
    public t v(long j2) {
        e4.gv gvVar = this.y;
        int i = (int) j2;
        return new t(null, gvVar.f7509zn[i], gvVar.f7507n3[i]);
    }

    @Override // zr.s
    public long y(long j2, long j4) {
        return this.y.f7506gv[(int) j2];
    }

    @Override // zr.s
    public long zn(long j2, long j4) {
        return 0L;
    }
}
