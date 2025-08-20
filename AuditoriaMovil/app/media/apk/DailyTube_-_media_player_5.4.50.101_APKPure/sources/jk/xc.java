package jk;

import androidx.core.app.NotificationCompat;
import e4.ta;
import m1.m;
import v5.j5;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class xc implements f {

    /* renamed from: f  reason: collision with root package name */
    public boolean f9536f;

    /* renamed from: gv  reason: collision with root package name */
    public long f9538gv;

    /* renamed from: i9  reason: collision with root package name */
    public boolean f9539i9;

    /* renamed from: n3  reason: collision with root package name */
    public ta f9540n3;

    /* renamed from: t  reason: collision with root package name */
    public boolean f9542t;
    public final r4.s y;

    /* renamed from: zn  reason: collision with root package name */
    public long f9544zn = -9223372036854775807L;

    /* renamed from: a  reason: collision with root package name */
    public int f9534a = -1;

    /* renamed from: fb  reason: collision with root package name */
    public long f9537fb = -9223372036854775807L;

    /* renamed from: v  reason: collision with root package name */
    public int f9543v = -1;

    /* renamed from: s  reason: collision with root package name */
    public int f9541s = -1;

    /* renamed from: c5  reason: collision with root package name */
    public int f9535c5 = -1;

    public xc(r4.s sVar) {
        this.y = sVar;
    }

    private void v() {
        long j2 = this.f9537fb;
        boolean z2 = this.f9542t;
        ((ta) v5.y.v(this.f9540n3)).gv(j2, z2 ? 1 : 0, this.f9534a, 0, null);
        this.f9534a = -1;
        this.f9537fb = -9223372036854775807L;
        this.f9539i9 = false;
    }

    public final boolean a(rz rzVar, int i) {
        boolean z2;
        int ej2 = rzVar.ej();
        if ((ej2 & 8) == 8) {
            if (this.f9539i9 && this.f9534a > 0) {
                v();
            }
            this.f9539i9 = true;
        } else if (this.f9539i9) {
            int n32 = r4.v.n3(this.f9543v);
            if (i < n32) {
                r.c5("RtpVp9Reader", j5.rz("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(n32), Integer.valueOf(i)));
                return false;
            }
        } else {
            r.c5("RtpVp9Reader", "First payload octet of the RTP packet is not the beginning of a new VP9 partition, Dropping current packet.");
            return false;
        }
        if ((ej2 & NotificationCompat.FLAG_HIGH_PRIORITY) != 0 && (rzVar.ej() & NotificationCompat.FLAG_HIGH_PRIORITY) != 0 && rzVar.y() < 1) {
            return false;
        }
        int i5 = ej2 & 16;
        if (i5 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.n3(z2, "VP9 flexible mode is not supported.");
        if ((ej2 & 32) != 0) {
            rzVar.ut(1);
            if (rzVar.y() < 1) {
                return false;
            }
            if (i5 == 0) {
                rzVar.ut(1);
            }
        }
        if ((ej2 & 2) != 0) {
            int ej3 = rzVar.ej();
            int i6 = (ej3 >> 5) & 7;
            if ((ej3 & 16) != 0) {
                int i8 = i6 + 1;
                if (rzVar.y() < i8 * 4) {
                    return false;
                }
                for (int i10 = 0; i10 < i8; i10++) {
                    this.f9541s = rzVar.yt();
                    this.f9535c5 = rzVar.yt();
                }
            }
            if ((ej3 & 8) != 0) {
                int ej4 = rzVar.ej();
                if (rzVar.y() < ej4) {
                    return false;
                }
                for (int i11 = 0; i11 < ej4; i11++) {
                    int yt2 = (rzVar.yt() & 12) >> 2;
                    if (rzVar.y() < yt2) {
                        return false;
                    }
                    rzVar.ut(yt2);
                }
            }
        }
        return true;
    }

    @Override // jk.f
    public void gv(e4.wz wzVar, int i) {
        ta a2 = wzVar.a(i, 2);
        this.f9540n3 = a2;
        a2.v(this.y.f13101zn);
    }

    @Override // jk.f
    public void n3(rz rzVar, long j2, int i, boolean z2) {
        int i5;
        int i6;
        boolean z3;
        v5.y.c5(this.f9540n3);
        if (a(rzVar, i)) {
            if (this.f9534a == -1 && this.f9539i9) {
                if ((rzVar.i9() & 4) == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.f9542t = z3;
            }
            if (!this.f9536f && (i5 = this.f9541s) != -1 && (i6 = this.f9535c5) != -1) {
                m mVar = this.y.f13101zn;
                if (i5 != mVar.f10943d || i6 != mVar.f10945ej) {
                    this.f9540n3.v(mVar.n3().s8(this.f9541s).o(this.f9535c5).z6());
                }
                this.f9536f = true;
            }
            int y = rzVar.y();
            this.f9540n3.zn(rzVar, y);
            int i8 = this.f9534a;
            if (i8 == -1) {
                this.f9534a = y;
            } else {
                this.f9534a = i8 + y;
            }
            this.f9537fb = tl.y(this.f9538gv, j2, this.f9544zn, 90000);
            if (z2) {
                v();
            }
            this.f9543v = i;
        }
    }

    @Override // jk.f
    public void y(long j2, long j4) {
        this.f9544zn = j2;
        this.f9534a = -1;
        this.f9538gv = j4;
    }

    @Override // jk.f
    public void zn(long j2, int i) {
        boolean z2;
        if (this.f9544zn == -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        this.f9544zn = j2;
    }
}
