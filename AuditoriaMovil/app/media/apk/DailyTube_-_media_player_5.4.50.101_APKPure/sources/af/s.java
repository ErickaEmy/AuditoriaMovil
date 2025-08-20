package af;
/* loaded from: classes.dex */
public class s implements jz {
    public final jz[] y;

    public s(jz[] jzVarArr) {
        this.y = jzVarArr;
    }

    @Override // af.jz
    public final long fb() {
        long j2 = Long.MAX_VALUE;
        for (jz jzVar : this.y) {
            long fb2 = jzVar.fb();
            if (fb2 != Long.MIN_VALUE) {
                j2 = Math.min(j2, fb2);
            }
        }
        if (j2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j2;
    }

    @Override // af.jz
    public final void s(long j2) {
        for (jz jzVar : this.y) {
            jzVar.s(j2);
        }
    }

    @Override // af.jz
    public boolean v(long j2) {
        jz[] jzVarArr;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        do {
            long zn2 = zn();
            if (zn2 == Long.MIN_VALUE) {
                break;
            }
            z2 = false;
            for (jz jzVar : this.y) {
                long zn3 = jzVar.zn();
                if (zn3 != Long.MIN_VALUE && zn3 <= j2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (zn3 == zn2 || z3) {
                    z2 |= jzVar.v(j2);
                }
            }
            z4 |= z2;
        } while (z2);
        return z4;
    }

    @Override // af.jz
    public boolean y() {
        for (jz jzVar : this.y) {
            if (jzVar.y()) {
                return true;
            }
        }
        return false;
    }

    @Override // af.jz
    public final long zn() {
        long j2 = Long.MAX_VALUE;
        for (jz jzVar : this.y) {
            long zn2 = jzVar.zn();
            if (zn2 != Long.MIN_VALUE) {
                j2 = Math.min(j2, zn2);
            }
        }
        if (j2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j2;
    }
}
