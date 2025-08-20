package x1;

import androidx.annotation.Nullable;
import d9.ud;
import e4.fh;
import v5.j5;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class s implements fb {

    /* renamed from: gv  reason: collision with root package name */
    public final long f14911gv;

    /* renamed from: n3  reason: collision with root package name */
    public final long[] f14912n3;
    public final long[] y;

    /* renamed from: zn  reason: collision with root package name */
    public final long f14913zn;

    public s(long[] jArr, long[] jArr2, long j2, long j4) {
        this.y = jArr;
        this.f14912n3 = jArr2;
        this.f14913zn = j2;
        this.f14911gv = j4;
    }

    @Nullable
    public static s y(long j2, long j4, ud.y yVar, rz rzVar) {
        int i;
        int ej2;
        rzVar.ut(10);
        int p2 = rzVar.p();
        if (p2 <= 0) {
            return null;
        }
        int i5 = yVar.f7195gv;
        long j6 = p2;
        if (i5 >= 32000) {
            i = 1152;
        } else {
            i = 576;
        }
        long x52 = j5.x5(j6, i * 1000000, i5);
        int yt2 = rzVar.yt();
        int yt3 = rzVar.yt();
        int yt4 = rzVar.yt();
        rzVar.ut(2);
        long j7 = j4 + yVar.f7198zn;
        long[] jArr = new long[yt2];
        long[] jArr2 = new long[yt2];
        int i6 = 0;
        long j8 = j4;
        while (i6 < yt2) {
            int i8 = yt3;
            long j9 = j7;
            jArr[i6] = (i6 * x52) / yt2;
            jArr2[i6] = Math.max(j8, j9);
            if (yt4 != 1) {
                if (yt4 != 2) {
                    if (yt4 != 3) {
                        if (yt4 != 4) {
                            return null;
                        }
                        ej2 = rzVar.b();
                    } else {
                        ej2 = rzVar.x();
                    }
                } else {
                    ej2 = rzVar.yt();
                }
            } else {
                ej2 = rzVar.ej();
            }
            j8 += ej2 * i8;
            i6++;
            jArr = jArr;
            yt3 = i8;
            j7 = j9;
        }
        long[] jArr3 = jArr;
        if (j2 != -1 && j2 != j8) {
            r.c5("VbriSeeker", "VBRI data size mismatch: " + j2 + ", " + j8);
        }
        return new s(jArr3, jArr2, x52, j8);
    }

    @Override // e4.fh
    public long c5() {
        return this.f14913zn;
    }

    @Override // x1.fb
    public long fb() {
        return this.f14911gv;
    }

    @Override // e4.fh
    public fh.y gv(long j2) {
        int c52 = j5.c5(this.y, j2, true, true);
        e4.rz rzVar = new e4.rz(this.y[c52], this.f14912n3[c52]);
        if (rzVar.y < j2 && c52 != this.y.length - 1) {
            int i = c52 + 1;
            return new fh.y(rzVar, new e4.rz(this.y[i], this.f14912n3[i]));
        }
        return new fh.y(rzVar);
    }

    @Override // x1.fb
    public long n3(long j2) {
        return this.y[j5.c5(this.f14912n3, j2, true, true)];
    }

    @Override // e4.fh
    public boolean s() {
        return true;
    }
}
