package jk;

import androidx.core.app.NotificationCompat;
import e4.ta;
import m1.m;
import v5.j5;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class v implements f {

    /* renamed from: a  reason: collision with root package name */
    public int f9514a;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f9515c5;

    /* renamed from: f  reason: collision with root package name */
    public long f9516f;

    /* renamed from: fb  reason: collision with root package name */
    public int f9517fb;

    /* renamed from: gv  reason: collision with root package name */
    public int f9518gv;

    /* renamed from: i9  reason: collision with root package name */
    public long f9519i9;

    /* renamed from: n3  reason: collision with root package name */
    public ta f9520n3;

    /* renamed from: s  reason: collision with root package name */
    public boolean f9521s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f9522t;
    public final r4.s y;

    /* renamed from: zn  reason: collision with root package name */
    public long f9524zn = -9223372036854775807L;

    /* renamed from: v  reason: collision with root package name */
    public int f9523v = -1;

    public v(r4.s sVar) {
        this.y = sVar;
    }

    private void v() {
        long j2 = this.f9516f;
        boolean z2 = this.f9521s;
        ((ta) v5.y.v(this.f9520n3)).gv(j2, z2 ? 1 : 0, this.f9518gv, 0, null);
        this.f9518gv = 0;
        this.f9516f = -9223372036854775807L;
        this.f9521s = false;
        this.f9522t = false;
    }

    public final void a(rz rzVar, boolean z2) {
        int a2 = rzVar.a();
        boolean z3 = false;
        if (((rzVar.a8() >> 10) & 63) == 32) {
            int i92 = rzVar.i9();
            int i = (i92 >> 1) & 1;
            if (!z2 && i == 0) {
                int i5 = (i92 >> 2) & 7;
                if (i5 == 1) {
                    this.f9514a = NotificationCompat.FLAG_HIGH_PRIORITY;
                    this.f9517fb = 96;
                } else {
                    int i6 = i5 - 2;
                    this.f9514a = 176 << i6;
                    this.f9517fb = 144 << i6;
                }
            }
            rzVar.oz(a2);
            if (i == 0) {
                z3 = true;
            }
            this.f9521s = z3;
            return;
        }
        rzVar.oz(a2);
        this.f9521s = false;
    }

    @Override // jk.f
    public void gv(e4.wz wzVar, int i) {
        ta a2 = wzVar.a(i, 2);
        this.f9520n3 = a2;
        a2.v(this.y.f13101zn);
    }

    @Override // jk.f
    public void n3(rz rzVar, long j2, int i, boolean z2) {
        boolean z3;
        v5.y.c5(this.f9520n3);
        int a2 = rzVar.a();
        int yt2 = rzVar.yt();
        if ((yt2 & 1024) > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((yt2 & 512) == 0 && (yt2 & 504) == 0 && (yt2 & 7) == 0) {
            if (z3) {
                if (this.f9522t && this.f9518gv > 0) {
                    v();
                }
                this.f9522t = true;
                if ((rzVar.i9() & 252) < 128) {
                    r.c5("RtpH263Reader", "Picture start Code (PSC) missing, dropping packet.");
                    return;
                }
                rzVar.v()[a2] = 0;
                rzVar.v()[a2 + 1] = 0;
                rzVar.oz(a2);
            } else if (this.f9522t) {
                int n32 = r4.v.n3(this.f9523v);
                if (i < n32) {
                    r.c5("RtpH263Reader", j5.rz("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(n32), Integer.valueOf(i)));
                    return;
                }
            } else {
                r.c5("RtpH263Reader", "First payload octet of the H263 packet is not the beginning of a new H263 partition, Dropping current packet.");
                return;
            }
            if (this.f9518gv == 0) {
                a(rzVar, this.f9515c5);
                if (!this.f9515c5 && this.f9521s) {
                    int i5 = this.f9514a;
                    m mVar = this.y.f13101zn;
                    if (i5 != mVar.f10943d || this.f9517fb != mVar.f10945ej) {
                        this.f9520n3.v(mVar.n3().s8(this.f9514a).o(this.f9517fb).z6());
                    }
                    this.f9515c5 = true;
                }
            }
            int y = rzVar.y();
            this.f9520n3.zn(rzVar, y);
            this.f9518gv += y;
            this.f9516f = tl.y(this.f9519i9, j2, this.f9524zn, 90000);
            if (z2) {
                v();
            }
            this.f9523v = i;
            return;
        }
        r.c5("RtpH263Reader", "Dropping packet: video reduncancy coding is not supported, packet header VRC, or PLEN or PEBIT is non-zero");
    }

    @Override // jk.f
    public void y(long j2, long j4) {
        this.f9524zn = j2;
        this.f9518gv = 0;
        this.f9519i9 = j4;
    }

    @Override // jk.f
    public void zn(long j2, int i) {
        boolean z2;
        if (this.f9524zn == -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        this.f9524zn = j2;
    }
}
