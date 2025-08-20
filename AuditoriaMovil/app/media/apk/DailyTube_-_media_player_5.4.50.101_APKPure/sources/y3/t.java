package y3;

import java.util.Collections;
import java.util.List;
import m1.m;
import y3.ud;
/* loaded from: classes.dex */
public final class t implements tl {

    /* renamed from: a  reason: collision with root package name */
    public long f15145a = -9223372036854775807L;

    /* renamed from: gv  reason: collision with root package name */
    public int f15146gv;

    /* renamed from: n3  reason: collision with root package name */
    public final e4.ta[] f15147n3;

    /* renamed from: v  reason: collision with root package name */
    public int f15148v;
    public final List<ud.y> y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f15149zn;

    public t(List<ud.y> list) {
        this.y = list;
        this.f15147n3 = new e4.ta[list.size()];
    }

    @Override // y3.tl
    public void a(long j2, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.f15149zn = true;
        if (j2 != -9223372036854775807L) {
            this.f15145a = j2;
        }
        this.f15148v = 0;
        this.f15146gv = 2;
    }

    @Override // y3.tl
    public void gv() {
        if (this.f15149zn) {
            if (this.f15145a != -9223372036854775807L) {
                for (e4.ta taVar : this.f15147n3) {
                    taVar.gv(this.f15145a, 1, this.f15148v, 0, null);
                }
            }
            this.f15149zn = false;
        }
    }

    @Override // y3.tl
    public void n3(v5.rz rzVar) {
        e4.ta[] taVarArr;
        if (this.f15149zn) {
            if (this.f15146gv == 2 && !y(rzVar, 32)) {
                return;
            }
            if (this.f15146gv == 1 && !y(rzVar, 0)) {
                return;
            }
            int a2 = rzVar.a();
            int y = rzVar.y();
            for (e4.ta taVar : this.f15147n3) {
                rzVar.oz(a2);
                taVar.zn(rzVar, y);
            }
            this.f15148v += y;
        }
    }

    @Override // y3.tl
    public void v(e4.wz wzVar, ud.gv gvVar) {
        for (int i = 0; i < this.f15147n3.length; i++) {
            ud.y yVar = this.y.get(i);
            gvVar.y();
            e4.ta a2 = wzVar.a(gvVar.zn(), 3);
            a2.v(new m.n3().oz(gvVar.n3()).o4("application/dvbsubs").ut(Collections.singletonList(yVar.f15161zn)).k(yVar.y).z6());
            this.f15147n3[i] = a2;
        }
    }

    public final boolean y(v5.rz rzVar, int i) {
        if (rzVar.y() == 0) {
            return false;
        }
        if (rzVar.ej() != i) {
            this.f15149zn = false;
        }
        this.f15146gv--;
        return this.f15149zn;
    }

    @Override // y3.tl
    public void zn() {
        this.f15149zn = false;
        this.f15145a = -9223372036854775807L;
    }
}
