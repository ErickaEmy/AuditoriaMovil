package e4;

import e4.fh;
import v5.j5;
/* loaded from: classes.dex */
public final class c implements fh {

    /* renamed from: gv  reason: collision with root package name */
    public final boolean f7456gv;

    /* renamed from: n3  reason: collision with root package name */
    public final long[] f7457n3;
    public final long[] y;

    /* renamed from: zn  reason: collision with root package name */
    public final long f7458zn;

    public c(long[] jArr, long[] jArr2, long j2) {
        boolean z2;
        boolean z3;
        if (jArr.length == jArr2.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        int length = jArr2.length;
        if (length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f7456gv = z3;
        if (z3 && jArr2[0] > 0) {
            int i = length + 1;
            long[] jArr3 = new long[i];
            this.y = jArr3;
            long[] jArr4 = new long[i];
            this.f7457n3 = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        } else {
            this.y = jArr;
            this.f7457n3 = jArr2;
        }
        this.f7458zn = j2;
    }

    @Override // e4.fh
    public long c5() {
        return this.f7458zn;
    }

    @Override // e4.fh
    public fh.y gv(long j2) {
        if (!this.f7456gv) {
            return new fh.y(rz.f7511zn);
        }
        int c52 = j5.c5(this.f7457n3, j2, true, true);
        rz rzVar = new rz(this.f7457n3[c52], this.y[c52]);
        if (rzVar.y != j2 && c52 != this.f7457n3.length - 1) {
            int i = c52 + 1;
            return new fh.y(rzVar, new rz(this.f7457n3[i], this.y[i]));
        }
        return new fh.y(rzVar);
    }

    @Override // e4.fh
    public boolean s() {
        return this.f7456gv;
    }
}
