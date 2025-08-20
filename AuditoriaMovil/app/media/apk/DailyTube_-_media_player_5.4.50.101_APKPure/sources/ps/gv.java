package ps;

import java.util.Collections;
import java.util.List;
import qh.c5;
import v5.j5;
/* loaded from: classes.dex */
public final class gv implements c5 {

    /* renamed from: v  reason: collision with root package name */
    public final List<Long> f12603v;
    public final List<List<qh.n3>> y;

    public gv(List<List<qh.n3>> list, List<Long> list2) {
        this.y = list;
        this.f12603v = list2;
    }

    @Override // qh.c5
    public int gv() {
        return this.f12603v.size();
    }

    @Override // qh.c5
    public List<qh.n3> n3(long j2) {
        int a2 = j5.a(this.f12603v, Long.valueOf(j2), true, false);
        if (a2 == -1) {
            return Collections.emptyList();
        }
        return this.y.get(a2);
    }

    @Override // qh.c5
    public int y(long j2) {
        int gv2 = j5.gv(this.f12603v, Long.valueOf(j2), false, false);
        if (gv2 >= this.f12603v.size()) {
            return -1;
        }
        return gv2;
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
        if (i < this.f12603v.size()) {
            z3 = true;
        }
        v5.y.y(z3);
        return this.f12603v.get(i).longValue();
    }
}
