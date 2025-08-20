package jk;

import e4.ta;
import m1.ne;
import v5.c;
import v5.j5;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class fb implements f {

    /* renamed from: c5  reason: collision with root package name */
    public long f9474c5;

    /* renamed from: gv  reason: collision with root package name */
    public ta f9476gv;

    /* renamed from: s  reason: collision with root package name */
    public int f9478s;

    /* renamed from: v  reason: collision with root package name */
    public int f9479v;

    /* renamed from: zn  reason: collision with root package name */
    public final r4.s f9480zn;
    public final rz y = new rz();

    /* renamed from: n3  reason: collision with root package name */
    public final rz f9477n3 = new rz(c.y);

    /* renamed from: a  reason: collision with root package name */
    public long f9473a = -9223372036854775807L;

    /* renamed from: fb  reason: collision with root package name */
    public int f9475fb = -1;

    public fb(r4.s sVar) {
        this.f9480zn = sVar;
    }

    private void a(rz rzVar, int i) throws ne {
        boolean z2;
        boolean z3;
        if (rzVar.v().length >= 3) {
            int i5 = rzVar.v()[1] & 7;
            byte b2 = rzVar.v()[2];
            int i6 = b2 & 63;
            if ((b2 & 128) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((b2 & 64) > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z2) {
                this.f9478s += s();
                rzVar.v()[1] = (byte) ((i6 << 1) & 127);
                rzVar.v()[2] = (byte) i5;
                this.y.qn(rzVar.v());
                this.y.oz(1);
            } else {
                int i8 = (this.f9475fb + 1) % 65535;
                if (i != i8) {
                    r.c5("RtpH265Reader", j5.rz("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(i8), Integer.valueOf(i)));
                    return;
                } else {
                    this.y.qn(rzVar.v());
                    this.y.oz(3);
                }
            }
            int y = this.y.y();
            this.f9476gv.zn(this.y, y);
            this.f9478s += y;
            if (z3) {
                this.f9479v = v(i6);
                return;
            }
            return;
        }
        throw ne.v("Malformed FU header.", null);
    }

    private void fb(rz rzVar) {
        int y = rzVar.y();
        this.f9478s += s();
        this.f9476gv.zn(rzVar, y);
        this.f9478s += y;
        this.f9479v = v((rzVar.v()[0] >> 1) & 63);
    }

    private int s() {
        this.f9477n3.oz(0);
        int y = this.f9477n3.y();
        ((ta) v5.y.v(this.f9476gv)).zn(this.f9477n3, y);
        return y;
    }

    private static int v(int i) {
        if (i != 19 && i != 20) {
            return 0;
        }
        return 1;
    }

    @Override // jk.f
    public void gv(e4.wz wzVar, int i) {
        ta a2 = wzVar.a(i, 2);
        this.f9476gv = a2;
        a2.v(this.f9480zn.f13101zn);
    }

    @Override // jk.f
    public void n3(rz rzVar, long j2, int i, boolean z2) throws ne {
        if (rzVar.v().length != 0) {
            int i5 = (rzVar.v()[0] >> 1) & 63;
            v5.y.c5(this.f9476gv);
            if (i5 >= 0 && i5 < 48) {
                fb(rzVar);
            } else if (i5 != 48) {
                if (i5 == 49) {
                    a(rzVar, i);
                } else {
                    throw ne.v(String.format("RTP H265 payload type [%d] not supported.", Integer.valueOf(i5)), null);
                }
            } else {
                throw new UnsupportedOperationException("need to implement processAggregationPacket");
            }
            if (z2) {
                if (this.f9473a == -9223372036854775807L) {
                    this.f9473a = j2;
                }
                this.f9476gv.gv(tl.y(this.f9474c5, j2, this.f9473a, 90000), this.f9479v, this.f9478s, 0, null);
                this.f9478s = 0;
            }
            this.f9475fb = i;
            return;
        }
        throw ne.v("Empty RTP data packet.", null);
    }

    @Override // jk.f
    public void y(long j2, long j4) {
        this.f9473a = j2;
        this.f9478s = 0;
        this.f9474c5 = j4;
    }

    @Override // jk.f
    public void zn(long j2, int i) {
    }
}
