package r4;

import android.os.SystemClock;
import e4.d0;
import e4.fh;
import java.io.IOException;
import v5.rz;
/* loaded from: classes.dex */
public final class gv implements e4.t {

    /* renamed from: f  reason: collision with root package name */
    public boolean f13057f;

    /* renamed from: fb  reason: collision with root package name */
    public e4.wz f13058fb;

    /* renamed from: gv  reason: collision with root package name */
    public final int f13059gv;

    /* renamed from: s  reason: collision with root package name */
    public boolean f13062s;
    public final jk.f y;

    /* renamed from: n3  reason: collision with root package name */
    public final rz f13061n3 = new rz(65507);

    /* renamed from: zn  reason: collision with root package name */
    public final rz f13066zn = new rz();

    /* renamed from: v  reason: collision with root package name */
    public final Object f13065v = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final fb f13055a = new fb();

    /* renamed from: c5  reason: collision with root package name */
    public volatile long f13056c5 = -9223372036854775807L;

    /* renamed from: i9  reason: collision with root package name */
    public volatile int f13060i9 = -1;

    /* renamed from: t  reason: collision with root package name */
    public long f13063t = -9223372036854775807L;

    /* renamed from: tl  reason: collision with root package name */
    public long f13064tl = -9223372036854775807L;

    public gv(s sVar, int i) {
        this.f13059gv = i;
        this.y = (jk.f) v5.y.v(new jk.y().y(sVar));
    }

    public static long n3(long j2) {
        return j2 - 30;
    }

    @Override // e4.t
    public boolean a(e4.tl tlVar) {
        throw new UnsupportedOperationException("RTP packets are transmitted in a packet stream do not support sniffing.");
    }

    public void c5(long j2) {
        this.f13056c5 = j2;
    }

    public void fb() {
        synchronized (this.f13065v) {
            this.f13057f = true;
        }
    }

    public boolean gv() {
        return this.f13062s;
    }

    public void s(int i) {
        this.f13060i9 = i;
    }

    @Override // e4.t
    public int v(e4.tl tlVar, d0 d0Var) throws IOException {
        v5.y.v(this.f13058fb);
        int read = tlVar.read(this.f13061n3.v(), 0, 65507);
        if (read == -1) {
            return -1;
        }
        if (read == 0) {
            return 0;
        }
        this.f13061n3.oz(0);
        this.f13061n3.j(read);
        v gv2 = v.gv(this.f13061n3);
        if (gv2 == null) {
            return 0;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long n32 = n3(elapsedRealtime);
        this.f13055a.v(gv2, elapsedRealtime);
        v a2 = this.f13055a.a(n32);
        if (a2 == null) {
            return 0;
        }
        if (!this.f13062s) {
            if (this.f13056c5 == -9223372036854775807L) {
                this.f13056c5 = a2.f13110s;
            }
            if (this.f13060i9 == -1) {
                this.f13060i9 = a2.f13106fb;
            }
            this.y.zn(this.f13056c5, this.f13060i9);
            this.f13062s = true;
        }
        synchronized (this.f13065v) {
            try {
                if (this.f13057f) {
                    if (this.f13063t != -9223372036854775807L && this.f13064tl != -9223372036854775807L) {
                        this.f13055a.fb();
                        this.y.y(this.f13063t, this.f13064tl);
                        this.f13057f = false;
                        this.f13063t = -9223372036854775807L;
                        this.f13064tl = -9223372036854775807L;
                    }
                } else {
                    do {
                        this.f13066zn.qn(a2.f13105f);
                        this.y.n3(this.f13066zn, a2.f13110s, a2.f13106fb, a2.f13111v);
                        a2 = this.f13055a.a(n32);
                    } while (a2 != null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return 0;
    }

    @Override // e4.t
    public void y(long j2, long j4) {
        synchronized (this.f13065v) {
            try {
                if (!this.f13057f) {
                    this.f13057f = true;
                }
                this.f13063t = j2;
                this.f13064tl = j4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // e4.t
    public void zn(e4.wz wzVar) {
        this.y.gv(wzVar, this.f13059gv);
        wzVar.xc();
        wzVar.t(new fh.n3(-9223372036854775807L));
        this.f13058fb = wzVar;
    }

    @Override // e4.t
    public void release() {
    }
}
