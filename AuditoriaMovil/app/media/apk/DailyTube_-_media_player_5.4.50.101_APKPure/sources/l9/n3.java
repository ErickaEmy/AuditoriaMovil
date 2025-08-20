package l9;

import java.util.Collections;
import java.util.List;
import qh.c5;
/* loaded from: classes.dex */
public final class n3 implements c5 {

    /* renamed from: v  reason: collision with root package name */
    public static final n3 f10260v = new n3();
    public final List<qh.n3> y;

    public n3(qh.n3 n3Var) {
        this.y = Collections.singletonList(n3Var);
    }

    @Override // qh.c5
    public int gv() {
        return 1;
    }

    @Override // qh.c5
    public List<qh.n3> n3(long j2) {
        if (j2 >= 0) {
            return this.y;
        }
        return Collections.emptyList();
    }

    @Override // qh.c5
    public int y(long j2) {
        if (j2 < 0) {
            return 0;
        }
        return -1;
    }

    @Override // qh.c5
    public long zn(int i) {
        boolean z2;
        if (i == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        return 0L;
    }

    public n3() {
        this.y = Collections.emptyList();
    }
}
