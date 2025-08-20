package h4;

import e4.d0;
import java.io.IOException;
import m1.m;
import v5.k5;
import y3.ej;
/* loaded from: classes.dex */
public final class n3 implements f {

    /* renamed from: gv  reason: collision with root package name */
    public static final d0 f8616gv = new d0();

    /* renamed from: n3  reason: collision with root package name */
    public final m f8617n3;
    public final e4.t y;

    /* renamed from: zn  reason: collision with root package name */
    public final k5 f8618zn;

    public n3(e4.t tVar, m mVar, k5 k5Var) {
        this.y = tVar;
        this.f8617n3 = mVar;
        this.f8618zn = k5Var;
    }

    @Override // h4.f
    public boolean a() {
        e4.t tVar = this.y;
        if (!(tVar instanceof y3.s) && !(tVar instanceof y3.n3) && !(tVar instanceof y3.v) && !(tVar instanceof x1.a)) {
            return false;
        }
        return true;
    }

    @Override // h4.f
    public f fb() {
        e4.t aVar;
        v5.y.fb(!v());
        e4.t tVar = this.y;
        if (tVar instanceof z) {
            aVar = new z(this.f8617n3.f10950fb, this.f8618zn);
        } else if (tVar instanceof y3.s) {
            aVar = new y3.s();
        } else if (tVar instanceof y3.n3) {
            aVar = new y3.n3();
        } else if (tVar instanceof y3.v) {
            aVar = new y3.v();
        } else if (tVar instanceof x1.a) {
            aVar = new x1.a();
        } else {
            throw new IllegalStateException("Unexpected extractor type for recreation: " + this.y.getClass().getSimpleName());
        }
        return new n3(aVar, this.f8617n3, this.f8618zn);
    }

    @Override // h4.f
    public void gv() {
        this.y.y(0L, 0L);
    }

    @Override // h4.f
    public boolean n3(e4.tl tlVar) throws IOException {
        if (this.y.v(tlVar, f8616gv) == 0) {
            return true;
        }
        return false;
    }

    @Override // h4.f
    public boolean v() {
        e4.t tVar = this.y;
        if (!(tVar instanceof ej) && !(tVar instanceof ha.fb)) {
            return false;
        }
        return true;
    }

    @Override // h4.f
    public void zn(e4.wz wzVar) {
        this.y.zn(wzVar);
    }
}
