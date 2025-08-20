package y3;

import java.util.List;
import m1.m;
import y3.ud;
/* loaded from: classes.dex */
public final class x {

    /* renamed from: n3  reason: collision with root package name */
    public final e4.ta[] f15231n3;
    public final List<m> y;

    public x(List<m> list) {
        this.y = list;
        this.f15231n3 = new e4.ta[list.size()];
    }

    public void n3(e4.wz wzVar, ud.gv gvVar) {
        boolean z2;
        for (int i = 0; i < this.f15231n3.length; i++) {
            gvVar.y();
            e4.ta a2 = wzVar.a(gvVar.zn(), 3);
            m mVar = this.y.get(i);
            String str = mVar.f10948f3;
            if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                z2 = false;
            } else {
                z2 = true;
            }
            v5.y.n3(z2, "Invalid closed caption mime type provided: " + str);
            a2.v(new m.n3().oz(gvVar.n3()).o4(str).eb(mVar.f10963s).k(mVar.f10950fb).ej(mVar.f10946en).ut(mVar.f10941c).z6());
            this.f15231n3[i] = a2;
        }
    }

    public void y(long j2, v5.rz rzVar) {
        if (rzVar.y() < 9) {
            return;
        }
        int p2 = rzVar.p();
        int p3 = rzVar.p();
        int ej2 = rzVar.ej();
        if (p2 == 434 && p3 == 1195456820 && ej2 == 3) {
            e4.zn.n3(j2, rzVar, this.f15231n3);
        }
    }
}
