package qx;

import e4.ta;
import m1.m;
import m1.ne;
import qx.v;
import v5.c;
import v5.rz;
/* loaded from: classes.dex */
public final class a extends v {

    /* renamed from: a  reason: collision with root package name */
    public boolean f12991a;

    /* renamed from: fb  reason: collision with root package name */
    public int f12992fb;

    /* renamed from: gv  reason: collision with root package name */
    public int f12993gv;

    /* renamed from: n3  reason: collision with root package name */
    public final rz f12994n3;

    /* renamed from: v  reason: collision with root package name */
    public boolean f12995v;

    /* renamed from: zn  reason: collision with root package name */
    public final rz f12996zn;

    public a(ta taVar) {
        super(taVar);
        this.f12994n3 = new rz(c.y);
        this.f12996zn = new rz(4);
    }

    @Override // qx.v
    public boolean n3(rz rzVar) throws v.y {
        int ej2 = rzVar.ej();
        int i = (ej2 >> 4) & 15;
        int i5 = ej2 & 15;
        if (i5 == 7) {
            this.f12992fb = i;
            if (i != 5) {
                return true;
            }
            return false;
        }
        throw new v.y("Video format not supported: " + i5);
    }

    @Override // qx.v
    public boolean zn(rz rzVar, long j2) throws ne {
        int i;
        int ej2 = rzVar.ej();
        long mt2 = j2 + (rzVar.mt() * 1000);
        if (ej2 == 0 && !this.f12995v) {
            rz rzVar2 = new rz(new byte[rzVar.y()]);
            rzVar.t(rzVar2.v(), 0, rzVar.y());
            wn.y n32 = wn.y.n3(rzVar2);
            this.f12993gv = n32.f14649n3;
            this.y.v(new m.n3().o4("video/avc").x(n32.f14647a).s8(n32.f14651zn).o(n32.f14648gv).y5(n32.f14650v).ut(n32.y).z6());
            this.f12995v = true;
            return false;
        } else if (ej2 != 1 || !this.f12995v) {
            return false;
        } else {
            if (this.f12992fb == 1) {
                i = 1;
            } else {
                i = 0;
            }
            if (!this.f12991a && i == 0) {
                return false;
            }
            byte[] v2 = this.f12996zn.v();
            v2[0] = 0;
            v2[1] = 0;
            v2[2] = 0;
            int i5 = 4 - this.f12993gv;
            int i6 = 0;
            while (rzVar.y() > 0) {
                rzVar.t(this.f12996zn.v(), i5, this.f12993gv);
                this.f12996zn.oz(0);
                int b2 = this.f12996zn.b();
                this.f12994n3.oz(0);
                this.y.zn(this.f12994n3, 4);
                this.y.zn(rzVar, b2);
                i6 = i6 + 4 + b2;
            }
            this.y.gv(mt2, i, i6, 0, null);
            this.f12991a = true;
            return true;
        }
    }
}
