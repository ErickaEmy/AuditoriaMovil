package e4;

import e4.fh;
import e4.x4;
import v5.j5;
/* loaded from: classes.dex */
public final class r implements fh {

    /* renamed from: n3  reason: collision with root package name */
    public final long f7510n3;
    public final x4 y;

    public r(x4 x4Var, long j2) {
        this.y = x4Var;
        this.f7510n3 = j2;
    }

    @Override // e4.fh
    public long c5() {
        return this.y.a();
    }

    @Override // e4.fh
    public fh.y gv(long j2) {
        long j4;
        v5.y.c5(this.y.f7525f);
        x4 x4Var = this.y;
        x4.y yVar = x4Var.f7525f;
        long[] jArr = yVar.y;
        long[] jArr2 = yVar.f7534n3;
        int c52 = j5.c5(jArr, x4Var.c5(j2), true, false);
        long j6 = 0;
        if (c52 == -1) {
            j4 = 0;
        } else {
            j4 = jArr[c52];
        }
        if (c52 != -1) {
            j6 = jArr2[c52];
        }
        rz y = y(j4, j6);
        if (y.y != j2 && c52 != jArr.length - 1) {
            int i = c52 + 1;
            return new fh.y(y, y(jArr[i], jArr2[i]));
        }
        return new fh.y(y);
    }

    @Override // e4.fh
    public boolean s() {
        return true;
    }

    public final rz y(long j2, long j4) {
        return new rz((j2 * 1000000) / this.y.f7532v, this.f7510n3 + j4);
    }
}
