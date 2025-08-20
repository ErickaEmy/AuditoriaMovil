package wm;

import android.graphics.PointF;
import br.fb;
import br.gv;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class wz {

    /* renamed from: n3  reason: collision with root package name */
    public PointF f14549n3;
    public final List<ne.y> y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f14550zn;

    public wz(PointF pointF, boolean z2, List<ne.y> list) {
        this.f14549n3 = pointF;
        this.f14550zn = z2;
        this.y = new ArrayList(list);
    }

    public void a(float f4, float f6) {
        if (this.f14549n3 == null) {
            this.f14549n3 = new PointF();
        }
        this.f14549n3.set(f4, f6);
    }

    public boolean gv() {
        return this.f14550zn;
    }

    public PointF n3() {
        return this.f14549n3;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.y.size() + "closed=" + this.f14550zn + '}';
    }

    public void v(boolean z2) {
        this.f14550zn = z2;
    }

    public List<ne.y> y() {
        return this.y;
    }

    public void zn(wz wzVar, wz wzVar2, float f4) {
        boolean z2;
        if (this.f14549n3 == null) {
            this.f14549n3 = new PointF();
        }
        if (!wzVar.gv() && !wzVar2.gv()) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f14550zn = z2;
        if (wzVar.y().size() != wzVar2.y().size()) {
            gv.zn("Curves must have the same number of control points. Shape 1: " + wzVar.y().size() + "\tShape 2: " + wzVar2.y().size());
        }
        int min = Math.min(wzVar.y().size(), wzVar2.y().size());
        if (this.y.size() < min) {
            for (int size = this.y.size(); size < min; size++) {
                this.y.add(new ne.y());
            }
        } else if (this.y.size() > min) {
            for (int size2 = this.y.size() - 1; size2 >= min; size2--) {
                List<ne.y> list = this.y;
                list.remove(list.size() - 1);
            }
        }
        PointF n32 = wzVar.n3();
        PointF n33 = wzVar2.n3();
        a(fb.c5(n32.x, n33.x, f4), fb.c5(n32.y, n33.y, f4));
        for (int size3 = this.y.size() - 1; size3 >= 0; size3--) {
            ne.y yVar = wzVar.y().get(size3);
            ne.y yVar2 = wzVar2.y().get(size3);
            PointF y = yVar.y();
            PointF n34 = yVar.n3();
            PointF zn2 = yVar.zn();
            PointF y2 = yVar2.y();
            PointF n35 = yVar2.n3();
            PointF zn3 = yVar2.zn();
            this.y.get(size3).gv(fb.c5(y.x, y2.x, f4), fb.c5(y.y, y2.y, f4));
            this.y.get(size3).v(fb.c5(n34.x, n35.x, f4), fb.c5(n34.y, n35.y, f4));
            this.y.get(size3).a(fb.c5(zn2.x, zn3.x, f4), fb.c5(zn2.y, zn3.y, f4));
        }
    }

    public wz() {
        this.y = new ArrayList();
    }
}
