package jk;

import android.util.Log;
import e4.ta;
import v5.j5;
import v5.rz;
/* loaded from: classes.dex */
public final class t implements f {

    /* renamed from: gv  reason: collision with root package name */
    public long f9510gv;

    /* renamed from: n3  reason: collision with root package name */
    public ta f9511n3;
    public final r4.s y;

    /* renamed from: zn  reason: collision with root package name */
    public long f9513zn = -9223372036854775807L;

    /* renamed from: v  reason: collision with root package name */
    public int f9512v = -1;

    public t(r4.s sVar) {
        this.y = sVar;
    }

    @Override // jk.f
    public void gv(e4.wz wzVar, int i) {
        ta a2 = wzVar.a(i, 1);
        this.f9511n3 = a2;
        a2.v(this.y.f13101zn);
    }

    @Override // jk.f
    public void n3(rz rzVar, long j2, int i, boolean z2) {
        int n32;
        v5.y.v(this.f9511n3);
        int i5 = this.f9512v;
        if (i5 != -1 && i != (n32 = r4.v.n3(i5))) {
            Log.w("RtpPcmReader", j5.rz("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", Integer.valueOf(n32), Integer.valueOf(i)));
        }
        long y = tl.y(this.f9510gv, j2, this.f9513zn, this.y.f13099n3);
        int y2 = rzVar.y();
        this.f9511n3.zn(rzVar, y2);
        this.f9511n3.gv(y, 1, y2, 0, null);
        this.f9512v = i;
    }

    @Override // jk.f
    public void y(long j2, long j4) {
        this.f9513zn = j2;
        this.f9510gv = j4;
    }

    @Override // jk.f
    public void zn(long j2, int i) {
        this.f9513zn = j2;
    }
}
