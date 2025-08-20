package jk;

import androidx.core.app.NotificationCompat;
import e4.ta;
import m1.m;
import v5.j5;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class wz implements f {

    /* renamed from: c5  reason: collision with root package name */
    public boolean f9526c5;

    /* renamed from: fb  reason: collision with root package name */
    public long f9527fb;

    /* renamed from: i9  reason: collision with root package name */
    public boolean f9529i9;

    /* renamed from: n3  reason: collision with root package name */
    public ta f9530n3;

    /* renamed from: s  reason: collision with root package name */
    public boolean f9531s;
    public final r4.s y;

    /* renamed from: zn  reason: collision with root package name */
    public long f9533zn = -9223372036854775807L;

    /* renamed from: gv  reason: collision with root package name */
    public int f9528gv = -1;

    /* renamed from: v  reason: collision with root package name */
    public int f9532v = -1;

    /* renamed from: a  reason: collision with root package name */
    public long f9525a = -9223372036854775807L;

    public wz(r4.s sVar) {
        this.y = sVar;
    }

    private void v() {
        long j2 = this.f9525a;
        boolean z2 = this.f9526c5;
        ((ta) v5.y.v(this.f9530n3)).gv(j2, z2 ? 1 : 0, this.f9532v, 0, null);
        this.f9532v = -1;
        this.f9525a = -9223372036854775807L;
        this.f9531s = false;
    }

    public final boolean a(rz rzVar, int i) {
        int ej2 = rzVar.ej();
        if ((ej2 & 16) == 16 && (ej2 & 7) == 0) {
            if (this.f9531s && this.f9532v > 0) {
                v();
            }
            this.f9531s = true;
        } else if (this.f9531s) {
            int n32 = r4.v.n3(this.f9528gv);
            if (i < n32) {
                r.c5("RtpVP8Reader", j5.rz("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(n32), Integer.valueOf(i)));
                return false;
            }
        } else {
            r.c5("RtpVP8Reader", "RTP packet is not the start of a new VP8 partition, skipping.");
            return false;
        }
        if ((ej2 & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
            int ej3 = rzVar.ej();
            if ((ej3 & NotificationCompat.FLAG_HIGH_PRIORITY) != 0 && (rzVar.ej() & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
                rzVar.ut(1);
            }
            if ((ej3 & 64) != 0) {
                rzVar.ut(1);
            }
            if ((ej3 & 32) != 0 || (ej3 & 16) != 0) {
                rzVar.ut(1);
            }
        }
        return true;
    }

    @Override // jk.f
    public void gv(e4.wz wzVar, int i) {
        ta a2 = wzVar.a(i, 2);
        this.f9530n3 = a2;
        a2.v(this.y.f13101zn);
    }

    @Override // jk.f
    public void n3(rz rzVar, long j2, int i, boolean z2) {
        boolean z3;
        v5.y.c5(this.f9530n3);
        if (a(rzVar, i)) {
            if (this.f9532v == -1 && this.f9531s) {
                if ((rzVar.i9() & 1) == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.f9526c5 = z3;
            }
            if (!this.f9529i9) {
                int a2 = rzVar.a();
                rzVar.oz(a2 + 6);
                int c2 = rzVar.c() & 16383;
                int c4 = rzVar.c() & 16383;
                rzVar.oz(a2);
                m mVar = this.y.f13101zn;
                if (c2 != mVar.f10943d || c4 != mVar.f10945ej) {
                    this.f9530n3.v(mVar.n3().s8(c2).o(c4).z6());
                }
                this.f9529i9 = true;
            }
            int y = rzVar.y();
            this.f9530n3.zn(rzVar, y);
            int i5 = this.f9532v;
            if (i5 == -1) {
                this.f9532v = y;
            } else {
                this.f9532v = i5 + y;
            }
            this.f9525a = tl.y(this.f9527fb, j2, this.f9533zn, 90000);
            if (z2) {
                v();
            }
            this.f9528gv = i;
        }
    }

    @Override // jk.f
    public void y(long j2, long j4) {
        this.f9533zn = j2;
        this.f9532v = -1;
        this.f9527fb = j4;
    }

    @Override // jk.f
    public void zn(long j2, int i) {
        boolean z2;
        if (this.f9533zn == -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        this.f9533zn = j2;
    }
}
