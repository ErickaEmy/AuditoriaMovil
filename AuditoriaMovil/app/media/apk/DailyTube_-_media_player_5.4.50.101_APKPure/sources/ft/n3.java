package ft;

import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class n3 implements qh.c5 {
    public final List<qh.n3> y;

    public n3(List<qh.n3> list) {
        this.y = Collections.unmodifiableList(list);
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
}
