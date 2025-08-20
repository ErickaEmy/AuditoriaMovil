package h3;

import d9.ud;
import java.nio.ByteBuffer;
import m1.m;
/* loaded from: classes.dex */
public final class c5 {

    /* renamed from: n3  reason: collision with root package name */
    public long f8415n3;
    public long y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f8416zn;

    public long gv(m mVar, a9.fb fbVar) {
        if (this.f8415n3 == 0) {
            this.y = fbVar.f55f;
        }
        if (this.f8416zn) {
            return fbVar.f55f;
        }
        ByteBuffer byteBuffer = (ByteBuffer) v5.y.v(fbVar.f56fb);
        int i = 0;
        for (int i5 = 0; i5 < 4; i5++) {
            i = (i << 8) | (byteBuffer.get(i5) & 255);
        }
        int tl2 = ud.tl(i);
        if (tl2 == -1) {
            this.f8416zn = true;
            this.f8415n3 = 0L;
            this.y = fbVar.f55f;
            v5.r.c5("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
            return fbVar.f55f;
        }
        long y = y(mVar.f10966ut);
        this.f8415n3 += tl2;
        return y;
    }

    public long n3(m mVar) {
        return y(mVar.f10966ut);
    }

    public final long y(long j2) {
        return this.y + Math.max(0L, ((this.f8415n3 - 529) * 1000000) / j2);
    }

    public void zn() {
        this.y = 0L;
        this.f8415n3 = 0L;
        this.f8416zn = false;
    }
}
