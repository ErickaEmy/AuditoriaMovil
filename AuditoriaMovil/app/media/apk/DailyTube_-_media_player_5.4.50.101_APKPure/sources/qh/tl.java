package qh;

import e4.c;
import e4.d0;
import e4.ta;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import m1.m;
import m1.ne;
import v5.j5;
import v5.rz;
/* loaded from: classes.dex */
public class tl implements e4.t {

    /* renamed from: c5  reason: collision with root package name */
    public int f12915c5;

    /* renamed from: fb  reason: collision with root package name */
    public e4.wz f12917fb;

    /* renamed from: gv  reason: collision with root package name */
    public final m f12918gv;

    /* renamed from: s  reason: collision with root package name */
    public ta f12921s;
    public final i9 y;

    /* renamed from: n3  reason: collision with root package name */
    public final gv f12920n3 = new gv();

    /* renamed from: zn  reason: collision with root package name */
    public final rz f12923zn = new rz();

    /* renamed from: v  reason: collision with root package name */
    public final List<Long> f12922v = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public final List<rz> f12914a = new ArrayList();

    /* renamed from: i9  reason: collision with root package name */
    public int f12919i9 = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f12916f = -9223372036854775807L;

    public tl(i9 i9Var, m mVar) {
        this.y = i9Var;
        this.f12918gv = mVar.n3().o4("text/x-exoplayer-cues").x(mVar.f10948f3).z6();
    }

    @Override // e4.t
    public boolean a(e4.tl tlVar) throws IOException {
        return true;
    }

    public final boolean fb(e4.tl tlVar) throws IOException {
        int i;
        if (tlVar.getLength() != -1) {
            i = d1.a.gv(tlVar.getLength());
        } else {
            i = 1024;
        }
        if (tlVar.xc(i) == -1) {
            return true;
        }
        return false;
    }

    public final boolean gv(e4.tl tlVar) throws IOException {
        int n32 = this.f12923zn.n3();
        int i = this.f12915c5;
        if (n32 == i) {
            this.f12923zn.zn(i + 1024);
        }
        int read = tlVar.read(this.f12923zn.v(), this.f12915c5, this.f12923zn.n3() - this.f12915c5);
        if (read != -1) {
            this.f12915c5 += read;
        }
        long length = tlVar.getLength();
        if ((length != -1 && this.f12915c5 == length) || read == -1) {
            return true;
        }
        return false;
    }

    public final void n3() throws IOException {
        try {
            wz gv2 = this.y.gv();
            while (gv2 == null) {
                Thread.sleep(5L);
                gv2 = this.y.gv();
            }
            gv2.mt(this.f12915c5);
            gv2.f56fb.put(this.f12923zn.v(), 0, this.f12915c5);
            gv2.f56fb.limit(this.f12915c5);
            this.y.zn(gv2);
            xc n32 = this.y.n3();
            while (n32 == null) {
                Thread.sleep(5L);
                n32 = this.y.n3();
            }
            for (int i = 0; i < n32.gv(); i++) {
                byte[] y = this.f12920n3.y(n32.n3(n32.zn(i)));
                this.f12922v.add(Long.valueOf(n32.zn(i)));
                this.f12914a.add(new rz(y));
            }
            n32.p();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        } catch (f e2) {
            throw ne.y("SubtitleDecoder failed.", e2);
        }
    }

    @Override // e4.t
    public void release() {
        if (this.f12919i9 == 5) {
            return;
        }
        this.y.release();
        this.f12919i9 = 5;
    }

    public final void s() {
        boolean z2;
        int a2;
        v5.y.c5(this.f12921s);
        if (this.f12922v.size() == this.f12914a.size()) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        long j2 = this.f12916f;
        if (j2 == -9223372036854775807L) {
            a2 = 0;
        } else {
            a2 = j5.a(this.f12922v, Long.valueOf(j2), true, true);
        }
        while (a2 < this.f12914a.size()) {
            rz rzVar = this.f12914a.get(a2);
            rzVar.oz(0);
            int length = rzVar.v().length;
            this.f12921s.zn(rzVar, length);
            this.f12921s.gv(this.f12922v.get(a2).longValue(), 1, length, 0, null);
            a2++;
        }
    }

    @Override // e4.t
    public int v(e4.tl tlVar, d0 d0Var) throws IOException {
        boolean z2;
        int i;
        int i5 = this.f12919i9;
        if (i5 != 0 && i5 != 5) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        if (this.f12919i9 == 1) {
            rz rzVar = this.f12923zn;
            if (tlVar.getLength() != -1) {
                i = d1.a.gv(tlVar.getLength());
            } else {
                i = 1024;
            }
            rzVar.j5(i);
            this.f12915c5 = 0;
            this.f12919i9 = 2;
        }
        if (this.f12919i9 == 2 && gv(tlVar)) {
            n3();
            s();
            this.f12919i9 = 4;
        }
        if (this.f12919i9 == 3 && fb(tlVar)) {
            s();
            this.f12919i9 = 4;
        }
        if (this.f12919i9 != 4) {
            return 0;
        }
        return -1;
    }

    @Override // e4.t
    public void y(long j2, long j4) {
        boolean z2;
        int i = this.f12919i9;
        if (i != 0 && i != 5) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        this.f12916f = j4;
        if (this.f12919i9 == 2) {
            this.f12919i9 = 1;
        }
        if (this.f12919i9 == 4) {
            this.f12919i9 = 3;
        }
    }

    @Override // e4.t
    public void zn(e4.wz wzVar) {
        boolean z2;
        if (this.f12919i9 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        this.f12917fb = wzVar;
        this.f12921s = wzVar.a(0, 3);
        this.f12917fb.xc();
        this.f12917fb.t(new c(new long[]{0}, new long[]{0}, -9223372036854775807L));
        this.f12921s.v(this.f12918gv);
        this.f12919i9 = 1;
    }
}
