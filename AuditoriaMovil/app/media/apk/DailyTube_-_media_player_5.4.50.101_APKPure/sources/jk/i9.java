package jk;

import d9.a8;
import e4.ta;
import java.util.List;
import m1.m;
import v5.j5;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class i9 implements f {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9489a;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f9490fb;

    /* renamed from: gv  reason: collision with root package name */
    public long f9491gv;

    /* renamed from: n3  reason: collision with root package name */
    public ta f9492n3;
    public final r4.s y;

    /* renamed from: zn  reason: collision with root package name */
    public long f9494zn = -1;

    /* renamed from: v  reason: collision with root package name */
    public int f9493v = -1;

    public i9(r4.s sVar) {
        this.y = sVar;
    }

    public static void v(rz rzVar) {
        boolean z2;
        int a2 = rzVar.a();
        boolean z3 = false;
        if (rzVar.fb() > 18) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.n3(z2, "ID Header has insufficient data");
        v5.y.n3(rzVar.ta(8).equals("OpusHead"), "ID Header missing");
        if (rzVar.ej() == 1) {
            z3 = true;
        }
        v5.y.n3(z3, "version number must always be 1");
        rzVar.oz(a2);
    }

    @Override // jk.f
    public void gv(e4.wz wzVar, int i) {
        ta a2 = wzVar.a(i, 1);
        this.f9492n3 = a2;
        a2.v(this.y.f13101zn);
    }

    @Override // jk.f
    public void n3(rz rzVar, long j2, int i, boolean z2) {
        boolean z3 = false;
        v5.y.c5(this.f9492n3);
        if (!this.f9489a) {
            v(rzVar);
            List<byte[]> y = a8.y(rzVar.v());
            m.n3 n32 = this.y.f13101zn.n3();
            n32.ut(y);
            this.f9492n3.v(n32.z6());
            this.f9489a = true;
        } else if (!this.f9490fb) {
            if (rzVar.fb() >= 8) {
                z3 = true;
            }
            v5.y.n3(z3, "Comment Header has insufficient data");
            v5.y.n3(rzVar.ta(8).equals("OpusTags"), "Comment Header should follow ID Header");
            this.f9490fb = true;
        } else {
            int n33 = r4.v.n3(this.f9493v);
            if (i != n33) {
                r.c5("RtpOpusReader", j5.rz("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", Integer.valueOf(n33), Integer.valueOf(i)));
            }
            int y2 = rzVar.y();
            this.f9492n3.zn(rzVar, y2);
            this.f9492n3.gv(tl.y(this.f9491gv, j2, this.f9494zn, 48000), 1, y2, 0, null);
        }
        this.f9493v = i;
    }

    @Override // jk.f
    public void y(long j2, long j4) {
        this.f9494zn = j2;
        this.f9491gv = j4;
    }

    @Override // jk.f
    public void zn(long j2, int i) {
        this.f9494zn = j2;
    }
}
