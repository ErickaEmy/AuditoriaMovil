package ek;

import androidx.annotation.Nullable;
import v5.rz;
import z0.en;
import z0.x4;
/* loaded from: classes.dex */
public final class a implements y {

    /* renamed from: n3  reason: collision with root package name */
    public final int f7621n3;
    public final x4<y> y;

    public a(int i, x4<y> x4Var) {
        this.f7621n3 = i;
        this.y = x4Var;
    }

    @Nullable
    public static y y(int i, int i5, rz rzVar) {
        switch (i) {
            case 1718776947:
                return fb.gv(i5, rzVar);
            case 1751742049:
                return zn.n3(rzVar);
            case 1752331379:
                return gv.zn(rzVar);
            case 1852994675:
                return s.y(rzVar);
            default:
                return null;
        }
    }

    public static a zn(int i, rz rzVar) {
        y y;
        x4.y yVar = new x4.y();
        int fb2 = rzVar.fb();
        int i5 = -2;
        while (rzVar.y() > 8) {
            int r2 = rzVar.r();
            int a2 = rzVar.a() + rzVar.r();
            rzVar.j(a2);
            if (r2 == 1414744396) {
                y = zn(rzVar.r(), rzVar);
            } else {
                y = y(r2, i5, rzVar);
            }
            if (y != null) {
                if (y.getType() == 1752331379) {
                    i5 = ((gv) y).n3();
                }
                yVar.y(y);
            }
            rzVar.oz(a2);
            rzVar.j(fb2);
        }
        return new a(i, yVar.s());
    }

    @Override // ek.y
    public int getType() {
        return this.f7621n3;
    }

    @Nullable
    public <T extends y> T n3(Class<T> cls) {
        en<y> it = this.y.iterator();
        while (it.hasNext()) {
            T t2 = (T) it.next();
            if (t2.getClass() == cls) {
                return t2;
            }
        }
        return null;
    }
}
