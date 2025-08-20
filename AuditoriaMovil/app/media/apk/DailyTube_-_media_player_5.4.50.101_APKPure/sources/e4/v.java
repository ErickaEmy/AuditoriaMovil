package e4;

import e4.fh;
/* loaded from: classes.dex */
public class v implements fh {

    /* renamed from: a  reason: collision with root package name */
    public final long f7516a;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f7517fb;

    /* renamed from: gv  reason: collision with root package name */
    public final long f7518gv;

    /* renamed from: n3  reason: collision with root package name */
    public final long f7519n3;

    /* renamed from: v  reason: collision with root package name */
    public final int f7520v;
    public final long y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f7521zn;

    public v(long j2, long j4, int i, int i5, boolean z2) {
        this.y = j2;
        this.f7519n3 = j4;
        this.f7521zn = i5 == -1 ? 1 : i5;
        this.f7520v = i;
        this.f7517fb = z2;
        if (j2 == -1) {
            this.f7518gv = -1L;
            this.f7516a = -9223372036854775807L;
            return;
        }
        this.f7518gv = j2 - j4;
        this.f7516a = v(j2, j4, i);
    }

    public static long v(long j2, long j4, int i) {
        return (Math.max(0L, j2 - j4) * 8000000) / i;
    }

    @Override // e4.fh
    public long c5() {
        return this.f7516a;
    }

    @Override // e4.fh
    public fh.y gv(long j2) {
        if (this.f7518gv == -1 && !this.f7517fb) {
            return new fh.y(new rz(0L, this.f7519n3));
        }
        long y = y(j2);
        long zn2 = zn(y);
        rz rzVar = new rz(zn2, y);
        if (this.f7518gv != -1 && zn2 < j2) {
            int i = this.f7521zn;
            if (i + y < this.y) {
                long j4 = y + i;
                return new fh.y(rzVar, new rz(zn(j4), j4));
            }
        }
        return new fh.y(rzVar);
    }

    @Override // e4.fh
    public boolean s() {
        if (this.f7518gv == -1 && !this.f7517fb) {
            return false;
        }
        return true;
    }

    public final long y(long j2) {
        int i = this.f7521zn;
        long j4 = (((j2 * this.f7520v) / 8000000) / i) * i;
        long j6 = this.f7518gv;
        if (j6 != -1) {
            j4 = Math.min(j4, j6 - i);
        }
        return this.f7519n3 + Math.max(j4, 0L);
    }

    public long zn(long j2) {
        return v(j2, this.f7519n3, this.f7520v);
    }
}
