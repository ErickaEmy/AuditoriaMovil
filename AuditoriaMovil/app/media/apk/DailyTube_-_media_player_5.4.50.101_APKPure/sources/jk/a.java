package jk;

import e4.ta;
import m1.ne;
import v5.c;
import v5.j5;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class a implements f {

    /* renamed from: c5  reason: collision with root package name */
    public long f9460c5;

    /* renamed from: gv  reason: collision with root package name */
    public ta f9462gv;

    /* renamed from: s  reason: collision with root package name */
    public int f9464s;

    /* renamed from: v  reason: collision with root package name */
    public int f9465v;

    /* renamed from: zn  reason: collision with root package name */
    public final r4.s f9466zn;

    /* renamed from: n3  reason: collision with root package name */
    public final rz f9463n3 = new rz(c.y);
    public final rz y = new rz();

    /* renamed from: a  reason: collision with root package name */
    public long f9459a = -9223372036854775807L;

    /* renamed from: fb  reason: collision with root package name */
    public int f9461fb = -1;

    public a(r4.s sVar) {
        this.f9466zn = sVar;
    }

    public static int v(int i) {
        if (i == 5) {
            return 1;
        }
        return 0;
    }

    public final void a(rz rzVar, int i) {
        boolean z2;
        boolean z3;
        byte b2 = rzVar.v()[0];
        byte b3 = rzVar.v()[1];
        int i5 = (b2 & 224) | (b3 & 31);
        if ((b3 & 128) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((b3 & 64) > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2) {
            this.f9464s += c5();
            rzVar.v()[1] = (byte) i5;
            this.y.qn(rzVar.v());
            this.y.oz(1);
        } else {
            int n32 = r4.v.n3(this.f9461fb);
            if (i != n32) {
                r.c5("RtpH264Reader", j5.rz("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(n32), Integer.valueOf(i)));
                return;
            } else {
                this.y.qn(rzVar.v());
                this.y.oz(2);
            }
        }
        int y = this.y.y();
        this.f9462gv.zn(this.y, y);
        this.f9464s += y;
        if (z3) {
            this.f9465v = v(i5 & 31);
        }
    }

    public final int c5() {
        this.f9463n3.oz(0);
        int y = this.f9463n3.y();
        ((ta) v5.y.v(this.f9462gv)).zn(this.f9463n3, y);
        return y;
    }

    public final void fb(rz rzVar) {
        int y = rzVar.y();
        this.f9464s += c5();
        this.f9462gv.zn(rzVar, y);
        this.f9464s += y;
        this.f9465v = v(rzVar.v()[0] & 31);
    }

    @Override // jk.f
    public void gv(e4.wz wzVar, int i) {
        ta a2 = wzVar.a(i, 2);
        this.f9462gv = a2;
        ((ta) j5.i9(a2)).v(this.f9466zn.f13101zn);
    }

    @Override // jk.f
    public void n3(rz rzVar, long j2, int i, boolean z2) throws ne {
        try {
            int i5 = rzVar.v()[0] & 31;
            v5.y.c5(this.f9462gv);
            if (i5 > 0 && i5 < 24) {
                fb(rzVar);
            } else if (i5 == 24) {
                s(rzVar);
            } else if (i5 == 28) {
                a(rzVar, i);
            } else {
                throw ne.v(String.format("RTP H264 packetization mode [%d] not supported.", Integer.valueOf(i5)), null);
            }
            if (z2) {
                if (this.f9459a == -9223372036854775807L) {
                    this.f9459a = j2;
                }
                this.f9462gv.gv(tl.y(this.f9460c5, j2, this.f9459a, 90000), this.f9465v, this.f9464s, 0, null);
                this.f9464s = 0;
            }
            this.f9461fb = i;
        } catch (IndexOutOfBoundsException e2) {
            throw ne.v(null, e2);
        }
    }

    public final void s(rz rzVar) {
        rzVar.ej();
        while (rzVar.y() > 4) {
            int yt2 = rzVar.yt();
            this.f9464s += c5();
            this.f9462gv.zn(rzVar, yt2);
            this.f9464s += yt2;
        }
        this.f9465v = 0;
    }

    @Override // jk.f
    public void y(long j2, long j4) {
        this.f9459a = j2;
        this.f9464s = 0;
        this.f9460c5 = j4;
    }

    @Override // jk.f
    public void zn(long j2, int i) {
    }
}
