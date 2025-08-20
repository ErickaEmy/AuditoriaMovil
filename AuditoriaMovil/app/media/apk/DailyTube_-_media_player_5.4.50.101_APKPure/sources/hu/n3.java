package hu;

import java.util.Collections;
import java.util.List;
import qh.c5;
import v5.j5;
/* loaded from: classes.dex */
public final class n3 implements c5 {

    /* renamed from: v  reason: collision with root package name */
    public final long[] f8927v;
    public final qh.n3[] y;

    public n3(qh.n3[] n3VarArr, long[] jArr) {
        this.y = n3VarArr;
        this.f8927v = jArr;
    }

    @Override // qh.c5
    public int gv() {
        return this.f8927v.length;
    }

    @Override // qh.c5
    public List<qh.n3> n3(long j2) {
        qh.n3 n3Var;
        int c52 = j5.c5(this.f8927v, j2, true, false);
        if (c52 != -1 && (n3Var = this.y[c52]) != qh.n3.f12847ej) {
            return Collections.singletonList(n3Var);
        }
        return Collections.emptyList();
    }

    @Override // qh.c5
    public int y(long j2) {
        int v2 = j5.v(this.f8927v, j2, false, false);
        if (v2 >= this.f8927v.length) {
            return -1;
        }
        return v2;
    }

    @Override // qh.c5
    public long zn(int i) {
        boolean z2;
        boolean z3 = false;
        if (i >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        if (i < this.f8927v.length) {
            z3 = true;
        }
        v5.y.y(z3);
        return this.f8927v[i];
    }
}
