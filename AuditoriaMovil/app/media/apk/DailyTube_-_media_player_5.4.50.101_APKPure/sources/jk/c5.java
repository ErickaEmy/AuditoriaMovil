package jk;

import e4.ta;
import v5.j5;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class c5 implements f {

    /* renamed from: a  reason: collision with root package name */
    public long f9467a;

    /* renamed from: fb  reason: collision with root package name */
    public int f9468fb;

    /* renamed from: n3  reason: collision with root package name */
    public ta f9470n3;
    public final r4.s y;

    /* renamed from: zn  reason: collision with root package name */
    public int f9472zn;

    /* renamed from: gv  reason: collision with root package name */
    public long f9469gv = -9223372036854775807L;

    /* renamed from: v  reason: collision with root package name */
    public int f9471v = -1;

    public c5(r4.s sVar) {
        this.y = sVar;
    }

    public static int v(rz rzVar) {
        int y = d1.n3.y(rzVar.v(), new byte[]{0, 0, 1, -74});
        if (y == -1) {
            return 0;
        }
        rzVar.oz(y + 4);
        if ((rzVar.i9() >> 6) != 0) {
            return 0;
        }
        return 1;
    }

    @Override // jk.f
    public void gv(e4.wz wzVar, int i) {
        ta a2 = wzVar.a(i, 2);
        this.f9470n3 = a2;
        ((ta) j5.i9(a2)).v(this.y.f13101zn);
    }

    @Override // jk.f
    public void n3(rz rzVar, long j2, int i, boolean z2) {
        int n32;
        v5.y.c5(this.f9470n3);
        int i5 = this.f9471v;
        if (i5 != -1 && i != (n32 = r4.v.n3(i5))) {
            r.c5("RtpMpeg4Reader", j5.rz("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(n32), Integer.valueOf(i)));
        }
        int y = rzVar.y();
        this.f9470n3.zn(rzVar, y);
        if (this.f9468fb == 0) {
            this.f9472zn = v(rzVar);
        }
        this.f9468fb += y;
        if (z2) {
            if (this.f9469gv == -9223372036854775807L) {
                this.f9469gv = j2;
            }
            this.f9470n3.gv(tl.y(this.f9467a, j2, this.f9469gv, 90000), this.f9472zn, this.f9468fb, 0, null);
            this.f9468fb = 0;
        }
        this.f9471v = i;
    }

    @Override // jk.f
    public void y(long j2, long j4) {
        this.f9469gv = j2;
        this.f9467a = j4;
        this.f9468fb = 0;
    }

    @Override // jk.f
    public void zn(long j2, int i) {
    }
}
