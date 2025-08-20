package mv;

import android.net.Uri;
import e4.d0;
import e4.mt;
import e4.p;
import e4.t;
import e4.ta;
import e4.tl;
import e4.wz;
import java.io.IOException;
import java.util.Map;
import m1.ne;
import v5.rz;
/* loaded from: classes.dex */
public class gv implements t {

    /* renamed from: gv  reason: collision with root package name */
    public static final mt f11593gv = new mt() { // from class: mv.zn
        @Override // e4.mt
        public final t[] createExtractors() {
            t[] gv2;
            gv2 = gv.gv();
            return gv2;
        }

        @Override // e4.mt
        public /* synthetic */ t[] y(Uri uri, Map map) {
            return p.y(this, uri, map);
        }
    };

    /* renamed from: n3  reason: collision with root package name */
    public c5 f11594n3;
    public wz y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f11595zn;

    public static rz fb(rz rzVar) {
        rzVar.oz(0);
        return rzVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ t[] gv() {
        return new t[]{new gv()};
    }

    @Override // e4.t
    public boolean a(tl tlVar) throws IOException {
        try {
            return s(tlVar);
        } catch (ne unused) {
            return false;
        }
    }

    public final boolean s(tl tlVar) throws IOException {
        a aVar = new a();
        if (aVar.y(tlVar, true) && (aVar.f11576n3 & 2) == 2) {
            int min = Math.min(aVar.f11571c5, 8);
            rz rzVar = new rz(min);
            tlVar.z(rzVar.v(), 0, min);
            if (n3.w(fb(rzVar))) {
                this.f11594n3 = new n3();
            } else if (i9.mt(fb(rzVar))) {
                this.f11594n3 = new i9();
            } else if (s.xc(fb(rzVar))) {
                this.f11594n3 = new s();
            }
            return true;
        }
        return false;
    }

    @Override // e4.t
    public int v(tl tlVar, d0 d0Var) throws IOException {
        v5.y.c5(this.y);
        if (this.f11594n3 == null) {
            if (s(tlVar)) {
                tlVar.s();
            } else {
                throw ne.y("Failed to determine bitstream type", null);
            }
        }
        if (!this.f11595zn) {
            ta a2 = this.y.a(0, 1);
            this.y.xc();
            this.f11594n3.gv(this.y, a2);
            this.f11595zn = true;
        }
        return this.f11594n3.fb(tlVar, d0Var);
    }

    @Override // e4.t
    public void y(long j2, long j4) {
        c5 c5Var = this.f11594n3;
        if (c5Var != null) {
            c5Var.tl(j2, j4);
        }
    }

    @Override // e4.t
    public void zn(wz wzVar) {
        this.y = wzVar;
    }

    @Override // e4.t
    public void release() {
    }
}
