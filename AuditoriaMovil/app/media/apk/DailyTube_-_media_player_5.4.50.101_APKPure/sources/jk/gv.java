package jk;

import e4.ta;
import v5.j5;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class gv implements f {

    /* renamed from: gv  reason: collision with root package name */
    public ta f9485gv;

    /* renamed from: n3  reason: collision with root package name */
    public final boolean f9486n3;
    public final r4.s y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f9488zn;

    /* renamed from: s  reason: collision with root package name */
    public static final int[] f9482s = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: c5  reason: collision with root package name */
    public static final int[] f9481c5 = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};

    /* renamed from: v  reason: collision with root package name */
    public long f9487v = -9223372036854775807L;

    /* renamed from: fb  reason: collision with root package name */
    public int f9484fb = -1;

    /* renamed from: a  reason: collision with root package name */
    public long f9483a = 0;

    public gv(r4.s sVar) {
        this.y = sVar;
        this.f9486n3 = "audio/amr-wb".equals(v5.y.v(sVar.f13101zn.f10948f3));
        this.f9488zn = sVar.f13099n3;
    }

    public static int v(int i, boolean z2) {
        boolean z3;
        String str;
        if ((i >= 0 && i <= 8) || i == 15) {
            z3 = true;
        } else {
            z3 = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        if (z2) {
            str = "WB";
        } else {
            str = "NB";
        }
        sb.append(str);
        sb.append(" frame type ");
        sb.append(i);
        v5.y.n3(z3, sb.toString());
        if (z2) {
            return f9481c5[i];
        }
        return f9482s[i];
    }

    @Override // jk.f
    public void gv(e4.wz wzVar, int i) {
        ta a2 = wzVar.a(i, 1);
        this.f9485gv = a2;
        a2.v(this.y.f13101zn);
    }

    @Override // jk.f
    public void n3(rz rzVar, long j2, int i, boolean z2) {
        int n32;
        boolean z3 = true;
        v5.y.c5(this.f9485gv);
        int i5 = this.f9484fb;
        if (i5 != -1 && i != (n32 = r4.v.n3(i5))) {
            r.c5("RtpAmrReader", j5.rz("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", Integer.valueOf(n32), Integer.valueOf(i)));
        }
        rzVar.ut(1);
        int v2 = v((rzVar.i9() >> 3) & 15, this.f9486n3);
        int y = rzVar.y();
        if (y != v2) {
            z3 = false;
        }
        v5.y.n3(z3, "compound payload not supported currently");
        this.f9485gv.zn(rzVar, y);
        this.f9485gv.gv(tl.y(this.f9483a, j2, this.f9487v, this.f9488zn), 1, y, 0, null);
        this.f9484fb = i;
    }

    @Override // jk.f
    public void y(long j2, long j4) {
        this.f9487v = j2;
        this.f9483a = j4;
    }

    @Override // jk.f
    public void zn(long j2, int i) {
        this.f9487v = j2;
    }
}
