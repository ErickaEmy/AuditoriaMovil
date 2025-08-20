package x1;

import androidx.annotation.Nullable;
import d9.ud;
import e4.fh;
import v5.j5;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class c5 implements fb {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final long[] f14903a;

    /* renamed from: gv  reason: collision with root package name */
    public final long f14904gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f14905n3;

    /* renamed from: v  reason: collision with root package name */
    public final long f14906v;
    public final long y;

    /* renamed from: zn  reason: collision with root package name */
    public final long f14907zn;

    public c5(long j2, int i, long j4) {
        this(j2, i, j4, -1L, null);
    }

    @Nullable
    public static c5 y(long j2, long j4, ud.y yVar, rz rzVar) {
        int b2;
        int i = yVar.f7194fb;
        int i5 = yVar.f7195gv;
        int p2 = rzVar.p();
        if ((p2 & 1) == 1 && (b2 = rzVar.b()) != 0) {
            long x52 = j5.x5(b2, i * 1000000, i5);
            if ((p2 & 6) != 6) {
                return new c5(j4, yVar.f7198zn, x52);
            }
            long a82 = rzVar.a8();
            long[] jArr = new long[100];
            for (int i6 = 0; i6 < 100; i6++) {
                jArr[i6] = rzVar.ej();
            }
            if (j2 != -1) {
                long j6 = j4 + a82;
                if (j2 != j6) {
                    r.c5("XingSeeker", "XING data size mismatch: " + j2 + ", " + j6);
                }
            }
            return new c5(j4, yVar.f7198zn, x52, a82, jArr);
        }
        return null;
    }

    @Override // e4.fh
    public long c5() {
        return this.f14907zn;
    }

    @Override // x1.fb
    public long fb() {
        return this.f14906v;
    }

    @Override // e4.fh
    public fh.y gv(long j2) {
        double d2;
        if (!s()) {
            return new fh.y(new e4.rz(0L, this.y + this.f14905n3));
        }
        long mt2 = j5.mt(j2, 0L, this.f14907zn);
        double d3 = (mt2 * 100.0d) / this.f14907zn;
        double d4 = 0.0d;
        if (d3 > 0.0d) {
            if (d3 >= 100.0d) {
                d4 = 256.0d;
            } else {
                int i = (int) d3;
                long[] jArr = (long[]) v5.y.c5(this.f14903a);
                double d5 = jArr[i];
                if (i == 99) {
                    d2 = 256.0d;
                } else {
                    d2 = jArr[i + 1];
                }
                d4 = d5 + ((d3 - i) * (d2 - d5));
            }
        }
        return new fh.y(new e4.rz(mt2, this.y + j5.mt(Math.round((d4 / 256.0d) * this.f14904gv), this.f14905n3, this.f14904gv - 1)));
    }

    @Override // x1.fb
    public long n3(long j2) {
        long j4;
        double d2;
        long j6 = j2 - this.y;
        if (s() && j6 > this.f14905n3) {
            long[] jArr = (long[]) v5.y.c5(this.f14903a);
            double d3 = (j6 * 256.0d) / this.f14904gv;
            int c52 = j5.c5(jArr, (long) d3, true, true);
            long zn2 = zn(c52);
            long j7 = jArr[c52];
            int i = c52 + 1;
            long zn3 = zn(i);
            if (c52 == 99) {
                j4 = 256;
            } else {
                j4 = jArr[i];
            }
            if (j7 == j4) {
                d2 = 0.0d;
            } else {
                d2 = (d3 - j7) / (j4 - j7);
            }
            return zn2 + Math.round(d2 * (zn3 - zn2));
        }
        return 0L;
    }

    @Override // e4.fh
    public boolean s() {
        if (this.f14903a != null) {
            return true;
        }
        return false;
    }

    public final long zn(int i) {
        return (this.f14907zn * i) / 100;
    }

    public c5(long j2, int i, long j4, long j6, @Nullable long[] jArr) {
        this.y = j2;
        this.f14905n3 = i;
        this.f14907zn = j4;
        this.f14903a = jArr;
        this.f14904gv = j6;
        this.f14906v = j6 != -1 ? j2 + j6 : -1L;
    }
}
