package jk;

import e4.ta;
import v5.fh;
import v5.j5;
import v5.rz;
/* loaded from: classes.dex */
public final class n3 implements f {

    /* renamed from: a  reason: collision with root package name */
    public final int f9495a;

    /* renamed from: c5  reason: collision with root package name */
    public long f9496c5;

    /* renamed from: fb  reason: collision with root package name */
    public long f9497fb;

    /* renamed from: gv  reason: collision with root package name */
    public final int f9498gv;

    /* renamed from: n3  reason: collision with root package name */
    public final fh f9499n3 = new fh();

    /* renamed from: s  reason: collision with root package name */
    public ta f9500s;

    /* renamed from: v  reason: collision with root package name */
    public final int f9501v;
    public final r4.s y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f9502zn;

    public n3(r4.s sVar) {
        this.y = sVar;
        this.f9502zn = sVar.f13099n3;
        String str = (String) v5.y.v(sVar.f13098gv.get("mode"));
        if (w0.zn.y(str, "AAC-hbr")) {
            this.f9498gv = 13;
            this.f9501v = 3;
        } else if (w0.zn.y(str, "AAC-lbr")) {
            this.f9498gv = 6;
            this.f9501v = 2;
        } else {
            throw new UnsupportedOperationException("AAC mode not supported");
        }
        this.f9495a = this.f9501v + this.f9498gv;
    }

    public static void v(ta taVar, long j2, int i) {
        taVar.gv(j2, 1, i, 0, null);
    }

    @Override // jk.f
    public void gv(e4.wz wzVar, int i) {
        ta a2 = wzVar.a(i, 1);
        this.f9500s = a2;
        a2.v(this.y.f13101zn);
    }

    @Override // jk.f
    public void n3(rz rzVar, long j2, int i, boolean z2) {
        v5.y.v(this.f9500s);
        short mg2 = rzVar.mg();
        int i5 = mg2 / this.f9495a;
        long y = tl.y(this.f9496c5, j2, this.f9497fb, this.f9502zn);
        this.f9499n3.tl(rzVar);
        if (i5 == 1) {
            int s2 = this.f9499n3.s(this.f9498gv);
            this.f9499n3.mt(this.f9501v);
            this.f9500s.zn(rzVar, rzVar.y());
            if (z2) {
                v(this.f9500s, y, s2);
                return;
            }
            return;
        }
        rzVar.ut((mg2 + 7) / 8);
        for (int i6 = 0; i6 < i5; i6++) {
            int s3 = this.f9499n3.s(this.f9498gv);
            this.f9499n3.mt(this.f9501v);
            this.f9500s.zn(rzVar, s3);
            v(this.f9500s, y, s3);
            y += j5.x5(i5, 1000000L, this.f9502zn);
        }
    }

    @Override // jk.f
    public void y(long j2, long j4) {
        this.f9497fb = j2;
        this.f9496c5 = j4;
    }

    @Override // jk.f
    public void zn(long j2, int i) {
        this.f9497fb = j2;
    }
}
