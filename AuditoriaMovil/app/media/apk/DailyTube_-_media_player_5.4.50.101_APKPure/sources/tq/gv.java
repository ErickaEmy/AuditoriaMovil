package tq;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import e4.co;
import e4.d0;
import e4.fh;
import e4.mt;
import e4.p;
import e4.r;
import e4.t;
import e4.ta;
import e4.tl;
import e4.wz;
import e4.x4;
import e4.z;
import java.io.IOException;
import java.util.Map;
import v5.j5;
import v5.rz;
/* loaded from: classes.dex */
public final class gv implements t {

    /* renamed from: xc  reason: collision with root package name */
    public static final mt f14002xc = new mt() { // from class: tq.zn
        @Override // e4.mt
        public final t[] createExtractors() {
            t[] i92;
            i92 = gv.i9();
            return i92;
        }

        @Override // e4.mt
        public /* synthetic */ t[] y(Uri uri, Map map) {
            return p.y(this, uri, map);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public ta f14003a;

    /* renamed from: c5  reason: collision with root package name */
    public x4 f14004c5;

    /* renamed from: f  reason: collision with root package name */
    public int f14005f;

    /* renamed from: fb  reason: collision with root package name */
    public int f14006fb;

    /* renamed from: gv  reason: collision with root package name */
    public final co.y f14007gv;

    /* renamed from: i9  reason: collision with root package name */
    public int f14008i9;

    /* renamed from: n3  reason: collision with root package name */
    public final rz f14009n3;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public Metadata f14010s;

    /* renamed from: t  reason: collision with root package name */
    public n3 f14011t;

    /* renamed from: tl  reason: collision with root package name */
    public int f14012tl;

    /* renamed from: v  reason: collision with root package name */
    public wz f14013v;

    /* renamed from: wz  reason: collision with root package name */
    public long f14014wz;
    public final byte[] y;

    /* renamed from: zn  reason: collision with root package name */
    public final boolean f14015zn;

    public gv() {
        this(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ t[] i9() {
        return new t[]{new gv()};
    }

    @Override // e4.t
    public boolean a(tl tlVar) throws IOException {
        z.zn(tlVar, false);
        return z.y(tlVar);
    }

    public final void c5(tl tlVar) throws IOException {
        byte[] bArr = this.y;
        tlVar.z(bArr, 0, bArr.length);
        tlVar.s();
        this.f14006fb = 2;
    }

    public final void f() {
        ((ta) j5.i9(this.f14003a)).gv((this.f14014wz * 1000000) / ((x4) j5.i9(this.f14004c5)).f7532v, 1, this.f14012tl, 0, null);
    }

    public final void fb(tl tlVar) throws IOException {
        this.f14005f = z.n3(tlVar);
        ((wz) j5.i9(this.f14013v)).t(s(tlVar.getPosition(), tlVar.getLength()));
        this.f14006fb = 5;
    }

    public final long gv(rz rzVar, boolean z2) {
        boolean z3;
        v5.y.v(this.f14004c5);
        int a2 = rzVar.a();
        while (a2 <= rzVar.fb() - 16) {
            rzVar.oz(a2);
            if (co.gv(rzVar, this.f14004c5, this.f14005f, this.f14007gv)) {
                rzVar.oz(a2);
                return this.f14007gv.y;
            }
            a2++;
        }
        if (z2) {
            while (a2 <= rzVar.fb() - this.f14008i9) {
                rzVar.oz(a2);
                boolean z4 = false;
                try {
                    z3 = co.gv(rzVar, this.f14004c5, this.f14005f, this.f14007gv);
                } catch (IndexOutOfBoundsException unused) {
                    z3 = false;
                }
                if (rzVar.a() <= rzVar.fb()) {
                    z4 = z3;
                }
                if (z4) {
                    rzVar.oz(a2);
                    return this.f14007gv.y;
                }
                a2++;
            }
            rzVar.oz(rzVar.fb());
            return -1L;
        }
        rzVar.oz(a2);
        return -1L;
    }

    public final fh s(long j2, long j4) {
        v5.y.v(this.f14004c5);
        x4 x4Var = this.f14004c5;
        if (x4Var.f7525f != null) {
            return new r(x4Var, j2);
        }
        if (j4 != -1 && x4Var.f7528i9 > 0) {
            n3 n3Var = new n3(x4Var, this.f14005f, j2, j4);
            this.f14011t = n3Var;
            return n3Var.n3();
        }
        return new fh.n3(x4Var.a());
    }

    public final int t(tl tlVar, d0 d0Var) throws IOException {
        boolean z2;
        v5.y.v(this.f14003a);
        v5.y.v(this.f14004c5);
        n3 n3Var = this.f14011t;
        if (n3Var != null && n3Var.gv()) {
            return this.f14011t.zn(tlVar, d0Var);
        }
        if (this.f14014wz == -1) {
            this.f14014wz = co.c5(tlVar, this.f14004c5);
            return 0;
        }
        int fb2 = this.f14009n3.fb();
        if (fb2 < 32768) {
            int read = tlVar.read(this.f14009n3.v(), fb2, 32768 - fb2);
            if (read == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                this.f14009n3.j(fb2 + read);
            } else if (this.f14009n3.y() == 0) {
                f();
                return -1;
            }
        } else {
            z2 = false;
        }
        int a2 = this.f14009n3.a();
        int i = this.f14012tl;
        int i5 = this.f14008i9;
        if (i < i5) {
            rz rzVar = this.f14009n3;
            rzVar.ut(Math.min(i5 - i, rzVar.y()));
        }
        long gv2 = gv(this.f14009n3, z2);
        int a3 = this.f14009n3.a() - a2;
        this.f14009n3.oz(a2);
        this.f14003a.zn(this.f14009n3, a3);
        this.f14012tl += a3;
        if (gv2 != -1) {
            f();
            this.f14012tl = 0;
            this.f14014wz = gv2;
        }
        if (this.f14009n3.y() < 16) {
            int y = this.f14009n3.y();
            System.arraycopy(this.f14009n3.v(), this.f14009n3.a(), this.f14009n3.v(), 0, y);
            this.f14009n3.oz(0);
            this.f14009n3.j(y);
        }
        return 0;
    }

    public final void tl(tl tlVar) throws IOException {
        this.f14010s = z.gv(tlVar, !this.f14015zn);
        this.f14006fb = 1;
    }

    @Override // e4.t
    public int v(tl tlVar, d0 d0Var) throws IOException {
        int i = this.f14006fb;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                return t(tlVar, d0Var);
                            }
                            throw new IllegalStateException();
                        }
                        fb(tlVar);
                        return 0;
                    }
                    wz(tlVar);
                    return 0;
                }
                xc(tlVar);
                return 0;
            }
            c5(tlVar);
            return 0;
        }
        tl(tlVar);
        return 0;
    }

    public final void wz(tl tlVar) throws IOException {
        z.y yVar = new z.y(this.f14004c5);
        boolean z2 = false;
        while (!z2) {
            z2 = z.v(tlVar, yVar);
            this.f14004c5 = (x4) j5.i9(yVar.y);
        }
        v5.y.v(this.f14004c5);
        this.f14008i9 = Math.max(this.f14004c5.f7533zn, 6);
        ((ta) j5.i9(this.f14003a)).v(this.f14004c5.fb(this.y, this.f14010s));
        this.f14006fb = 4;
    }

    public final void xc(tl tlVar) throws IOException {
        z.c5(tlVar);
        this.f14006fb = 3;
    }

    @Override // e4.t
    public void y(long j2, long j4) {
        long j6 = 0;
        if (j2 == 0) {
            this.f14006fb = 0;
        } else {
            n3 n3Var = this.f14011t;
            if (n3Var != null) {
                n3Var.s(j4);
            }
        }
        if (j4 != 0) {
            j6 = -1;
        }
        this.f14014wz = j6;
        this.f14012tl = 0;
        this.f14009n3.j5(0);
    }

    @Override // e4.t
    public void zn(wz wzVar) {
        this.f14013v = wzVar;
        this.f14003a = wzVar.a(0, 1);
        wzVar.xc();
    }

    public gv(int i) {
        this.y = new byte[42];
        this.f14009n3 = new rz(new byte[32768], 0);
        this.f14015zn = (i & 1) != 0;
        this.f14007gv = new co.y();
        this.f14006fb = 0;
    }

    @Override // e4.t
    public void release() {
    }
}
