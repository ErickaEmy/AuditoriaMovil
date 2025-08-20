package mv;

import e4.d0;
import e4.fh;
import e4.ta;
import e4.tl;
import e4.wz;
import java.io.IOException;
import m1.m;
import v5.j5;
import v5.rz;
/* loaded from: classes.dex */
public abstract class c5 {

    /* renamed from: a  reason: collision with root package name */
    public long f11580a;

    /* renamed from: c5  reason: collision with root package name */
    public int f11581c5;

    /* renamed from: f  reason: collision with root package name */
    public long f11582f;

    /* renamed from: fb  reason: collision with root package name */
    public long f11583fb;

    /* renamed from: gv  reason: collision with root package name */
    public fb f11584gv;

    /* renamed from: n3  reason: collision with root package name */
    public ta f11586n3;

    /* renamed from: s  reason: collision with root package name */
    public int f11587s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f11588t;

    /* renamed from: tl  reason: collision with root package name */
    public boolean f11589tl;

    /* renamed from: v  reason: collision with root package name */
    public long f11590v;

    /* renamed from: zn  reason: collision with root package name */
    public wz f11591zn;
    public final v y = new v();

    /* renamed from: i9  reason: collision with root package name */
    public n3 f11585i9 = new n3();

    /* loaded from: classes.dex */
    public static class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public fb f11592n3;
        public m y;
    }

    public abstract long a(rz rzVar);

    public abstract boolean c5(rz rzVar, long j2, n3 n3Var) throws IOException;

    public final int f(tl tlVar, d0 d0Var) throws IOException {
        long n32 = this.f11584gv.n3(tlVar);
        if (n32 >= 0) {
            d0Var.y = n32;
            return 1;
        }
        if (n32 < -1) {
            v(-(n32 + 2));
        }
        if (!this.f11588t) {
            this.f11591zn.t((fh) v5.y.c5(this.f11584gv.y()));
            this.f11588t = true;
        }
        if (this.f11582f <= 0 && !this.y.gv(tlVar)) {
            this.f11587s = 3;
            return -1;
        }
        this.f11582f = 0L;
        rz zn2 = this.y.zn();
        long a2 = a(zn2);
        if (a2 >= 0) {
            long j2 = this.f11583fb;
            if (j2 + a2 >= this.f11590v) {
                long n33 = n3(j2);
                this.f11586n3.zn(zn2, zn2.fb());
                this.f11586n3.gv(n33, 1, zn2.fb(), 0, null);
                this.f11590v = -1L;
            }
        }
        this.f11583fb += a2;
        return 0;
    }

    public final int fb(tl tlVar, d0 d0Var) throws IOException {
        y();
        int i = this.f11587s;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return -1;
                    }
                    throw new IllegalStateException();
                }
                j5.i9(this.f11584gv);
                return f(tlVar, d0Var);
            }
            tlVar.p((int) this.f11580a);
            this.f11587s = 2;
            return 0;
        }
        return i9(tlVar);
    }

    public void gv(wz wzVar, ta taVar) {
        this.f11591zn = wzVar;
        this.f11586n3 = taVar;
        t(true);
    }

    public final int i9(tl tlVar) throws IOException {
        boolean z2;
        if (!s(tlVar)) {
            return -1;
        }
        m mVar = this.f11585i9.y;
        this.f11581c5 = mVar.f10966ut;
        if (!this.f11589tl) {
            this.f11586n3.v(mVar);
            this.f11589tl = true;
        }
        fb fbVar = this.f11585i9.f11592n3;
        if (fbVar != null) {
            this.f11584gv = fbVar;
        } else if (tlVar.getLength() == -1) {
            this.f11584gv = new zn();
        } else {
            a n32 = this.y.n3();
            if ((n32.f11576n3 & 4) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f11584gv = new mv.y(this, this.f11580a, tlVar.getLength(), n32.f11577s + n32.f11571c5, n32.f11579zn, z2);
        }
        this.f11587s = 2;
        this.y.a();
        return 0;
    }

    public long n3(long j2) {
        return (j2 * 1000000) / this.f11581c5;
    }

    public final boolean s(tl tlVar) throws IOException {
        while (this.y.gv(tlVar)) {
            this.f11582f = tlVar.getPosition() - this.f11580a;
            if (c5(this.y.zn(), this.f11580a, this.f11585i9)) {
                this.f11580a = tlVar.getPosition();
            } else {
                return true;
            }
        }
        this.f11587s = 3;
        return false;
    }

    public void t(boolean z2) {
        if (z2) {
            this.f11585i9 = new n3();
            this.f11580a = 0L;
            this.f11587s = 0;
        } else {
            this.f11587s = 1;
        }
        this.f11590v = -1L;
        this.f11583fb = 0L;
    }

    public final void tl(long j2, long j4) {
        this.y.v();
        if (j2 == 0) {
            t(!this.f11588t);
        } else if (this.f11587s != 0) {
            this.f11590v = zn(j4);
            ((fb) j5.i9(this.f11584gv)).zn(this.f11590v);
            this.f11587s = 2;
        }
    }

    public void v(long j2) {
        this.f11583fb = j2;
    }

    public final void y() {
        v5.y.c5(this.f11586n3);
        j5.i9(this.f11591zn);
    }

    public long zn(long j2) {
        return (this.f11581c5 * j2) / 1000000;
    }

    /* loaded from: classes.dex */
    public static final class zn implements fb {
        public zn() {
        }

        @Override // mv.fb
        public long n3(tl tlVar) {
            return -1L;
        }

        @Override // mv.fb
        public fh y() {
            return new fh.n3(-9223372036854775807L);
        }

        @Override // mv.fb
        public void zn(long j2) {
        }
    }
}
