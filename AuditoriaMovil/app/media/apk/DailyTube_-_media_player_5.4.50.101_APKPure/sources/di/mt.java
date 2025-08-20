package di;

import java.util.Comparator;
import java.util.TreeSet;
/* loaded from: classes.dex */
public final class mt implements gv {

    /* renamed from: n3  reason: collision with root package name */
    public final TreeSet<c5> f7268n3 = new TreeSet<>(new Comparator() { // from class: di.p
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int s2;
            s2 = mt.s((c5) obj, (c5) obj2);
            return s2;
        }
    });
    public final long y;

    /* renamed from: zn  reason: collision with root package name */
    public long f7269zn;

    public mt(long j2) {
        this.y = j2;
    }

    public static int s(c5 c5Var, c5 c5Var2) {
        long j2 = c5Var.f7253t;
        long j4 = c5Var2.f7253t;
        if (j2 - j4 == 0) {
            return c5Var.compareTo(c5Var2);
        }
        if (j2 < j4) {
            return -1;
        }
        return 1;
    }

    @Override // di.y.n3
    public void a(y yVar, c5 c5Var, c5 c5Var2) {
        y(yVar, c5Var);
        n3(yVar, c5Var2);
    }

    public final void c5(y yVar, long j2) {
        while (this.f7269zn + j2 > this.y && !this.f7268n3.isEmpty()) {
            yVar.fb(this.f7268n3.first());
        }
    }

    @Override // di.gv
    public void gv(y yVar, String str, long j2, long j4) {
        if (j4 != -1) {
            c5(yVar, j4);
        }
    }

    @Override // di.y.n3
    public void n3(y yVar, c5 c5Var) {
        this.f7268n3.add(c5Var);
        this.f7269zn += c5Var.f7251fb;
        c5(yVar, 0L);
    }

    @Override // di.y.n3
    public void y(y yVar, c5 c5Var) {
        this.f7268n3.remove(c5Var);
        this.f7269zn -= c5Var.f7251fb;
    }

    @Override // di.gv
    public boolean zn() {
        return true;
    }

    @Override // di.gv
    public void v() {
    }
}
