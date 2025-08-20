package qh;

import androidx.annotation.Nullable;
import java.util.List;
/* loaded from: classes.dex */
public abstract class xc extends a9.s implements c5 {

    /* renamed from: f  reason: collision with root package name */
    public long f12925f;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public c5 f12926s;

    @Override // a9.y
    public void a() {
        super.a();
        this.f12926s = null;
    }

    @Override // qh.c5
    public int gv() {
        return ((c5) v5.y.v(this.f12926s)).gv();
    }

    public void mt(long j2, c5 c5Var, long j4) {
        this.f75v = j2;
        this.f12926s = c5Var;
        if (j4 != Long.MAX_VALUE) {
            j2 = j4;
        }
        this.f12925f = j2;
    }

    @Override // qh.c5
    public List<n3> n3(long j2) {
        return ((c5) v5.y.v(this.f12926s)).n3(j2 - this.f12925f);
    }

    @Override // qh.c5
    public int y(long j2) {
        return ((c5) v5.y.v(this.f12926s)).y(j2 - this.f12925f);
    }

    @Override // qh.c5
    public long zn(int i) {
        return ((c5) v5.y.v(this.f12926s)).zn(i) + this.f12925f;
    }
}
