package p0;

import e4.fh;
import e4.rz;
import e4.ta;
import e4.wz;
/* loaded from: classes.dex */
public final class gv implements wz {

    /* renamed from: v  reason: collision with root package name */
    public final wz f12368v;
    public final long y;

    /* loaded from: classes.dex */
    public class y implements fh {
        public final /* synthetic */ fh y;

        public y(fh fhVar) {
            this.y = fhVar;
        }

        @Override // e4.fh
        public long c5() {
            return this.y.c5();
        }

        @Override // e4.fh
        public fh.y gv(long j2) {
            fh.y gv2 = this.y.gv(j2);
            rz rzVar = gv2.y;
            rz rzVar2 = new rz(rzVar.y, rzVar.f7512n3 + gv.this.y);
            rz rzVar3 = gv2.f7504n3;
            return new fh.y(rzVar2, new rz(rzVar3.y, rzVar3.f7512n3 + gv.this.y));
        }

        @Override // e4.fh
        public boolean s() {
            return this.y.s();
        }
    }

    public gv(long j2, wz wzVar) {
        this.y = j2;
        this.f12368v = wzVar;
    }

    @Override // e4.wz
    public ta a(int i, int i5) {
        return this.f12368v.a(i, i5);
    }

    @Override // e4.wz
    public void t(fh fhVar) {
        this.f12368v.t(new y(fhVar));
    }

    @Override // e4.wz
    public void xc() {
        this.f12368v.xc();
    }
}
