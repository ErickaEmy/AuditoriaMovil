package af;

import af.d0;
import af.v;
import androidx.annotation.Nullable;
import java.io.IOException;
import m1.g;
import m1.m;
import m1.vc;
/* loaded from: classes.dex */
public final class gv implements d0, d0.y {

    /* renamed from: f  reason: collision with root package name */
    public long f242f;

    /* renamed from: fb  reason: collision with root package name */
    public y[] f243fb = new y[0];

    /* renamed from: s  reason: collision with root package name */
    public long f244s;

    /* renamed from: t  reason: collision with root package name */
    public long f245t;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public d0.y f246v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public v.n3 f247w;
    public final d0 y;

    /* loaded from: classes.dex */
    public final class y implements en {

        /* renamed from: v  reason: collision with root package name */
        public boolean f249v;
        public final en y;

        public y(en enVar) {
            this.y = enVar;
        }

        @Override // af.en
        public int a(g gVar, a9.fb fbVar, int i) {
            if (gv.this.xc()) {
                return -3;
            }
            if (this.f249v) {
                fbVar.w(4);
                return -4;
            }
            int a2 = this.y.a(gVar, fbVar, i);
            if (a2 == -5) {
                m mVar = (m) v5.y.v(gVar.f10757n3);
                int i5 = mVar.f10955k;
                if (i5 != 0 || mVar.f10949f7 != 0) {
                    gv gvVar = gv.this;
                    int i6 = 0;
                    if (gvVar.f242f != 0) {
                        i5 = 0;
                    }
                    if (gvVar.f245t == Long.MIN_VALUE) {
                        i6 = mVar.f10949f7;
                    }
                    gVar.f10757n3 = mVar.n3().hw(i5).j5(i6).z6();
                }
                return -5;
            }
            gv gvVar2 = gv.this;
            long j2 = gvVar2.f245t;
            if (j2 != Long.MIN_VALUE && ((a2 == -4 && fbVar.f55f >= j2) || (a2 == -3 && gvVar2.fb() == Long.MIN_VALUE && !fbVar.f58s))) {
                fbVar.a();
                fbVar.w(4);
                this.f249v = true;
                return -4;
            }
            return a2;
        }

        @Override // af.en
        public boolean isReady() {
            if (!gv.this.xc() && this.y.isReady()) {
                return true;
            }
            return false;
        }

        @Override // af.en
        public void n3() throws IOException {
            this.y.n3();
        }

        @Override // af.en
        public int t(long j2) {
            if (gv.this.xc()) {
                return -3;
            }
            return this.y.t(j2);
        }

        public void y() {
            this.f249v = false;
        }
    }

    public gv(d0 d0Var, boolean z2, long j2, long j4) {
        long j6;
        this.y = d0Var;
        if (z2) {
            j6 = j2;
        } else {
            j6 = -9223372036854775807L;
        }
        this.f244s = j6;
        this.f242f = j2;
        this.f245t = j4;
    }

    public static boolean r(long j2, zo.co[] coVarArr) {
        if (j2 != 0) {
            for (zo.co coVar : coVarArr) {
                if (coVar != null) {
                    m co2 = coVar.co();
                    if (!v5.n.y(co2.f10948f3, co2.f10942co)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final vc a(long j2, vc vcVar) {
        long j4;
        long mt2 = v5.j5.mt(vcVar.y, 0L, j2 - this.f242f);
        long j6 = vcVar.f11297n3;
        long j7 = this.f245t;
        if (j7 == Long.MIN_VALUE) {
            j4 = Long.MAX_VALUE;
        } else {
            j4 = j7 - j2;
        }
        long mt3 = v5.j5.mt(j6, 0L, j4);
        if (mt2 == vcVar.y && mt3 == vcVar.f11297n3) {
            return vcVar;
        }
        return new vc(mt2, mt3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
        if (r0 > r7) goto L18;
     */
    @Override // af.d0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long c5(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.f244s = r0
            af.gv$y[] r0 = r6.f243fb
            int r1 = r0.length
            r2 = 0
            r3 = 0
        Lc:
            if (r3 >= r1) goto L18
            r4 = r0[r3]
            if (r4 == 0) goto L15
            r4.y()
        L15:
            int r3 = r3 + 1
            goto Lc
        L18:
            af.d0 r0 = r6.y
            long r0 = r0.c5(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L34
            long r7 = r6.f242f
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L35
            long r7 = r6.f245t
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L34
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L35
        L34:
            r2 = 1
        L35:
            v5.y.fb(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: af.gv.c5(long):long");
    }

    @Override // af.d0
    public void co(d0.y yVar, long j2) {
        this.f246v = yVar;
        this.y.co(this, j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
        if (r2 > r4) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006a  */
    @Override // af.d0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long f(zo.co[] r13, boolean[] r14, af.en[] r15, boolean[] r16, long r17) {
        /*
            r12 = this;
            r0 = r12
            r1 = r15
            int r2 = r1.length
            af.gv$y[] r2 = new af.gv.y[r2]
            r0.f243fb = r2
            int r2 = r1.length
            af.en[] r9 = new af.en[r2]
            r10 = 0
            r2 = 0
        Lc:
            int r3 = r1.length
            r11 = 0
            if (r2 >= r3) goto L21
            af.gv$y[] r3 = r0.f243fb
            r4 = r1[r2]
            af.gv$y r4 = (af.gv.y) r4
            r3[r2] = r4
            if (r4 == 0) goto L1c
            af.en r11 = r4.y
        L1c:
            r9[r2] = r11
            int r2 = r2 + 1
            goto Lc
        L21:
            af.d0 r2 = r0.y
            r3 = r13
            r4 = r14
            r5 = r9
            r6 = r16
            r7 = r17
            long r2 = r2.f(r3, r4, r5, r6, r7)
            boolean r4 = r12.xc()
            if (r4 == 0) goto L43
            long r4 = r0.f242f
            int r6 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r6 != 0) goto L43
            r6 = r13
            boolean r4 = r(r4, r13)
            if (r4 == 0) goto L43
            r4 = r2
            goto L48
        L43:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L48:
            r0.f244s = r4
            int r4 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r4 == 0) goto L63
            long r4 = r0.f242f
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L61
            long r4 = r0.f245t
            r6 = -9223372036854775808
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L63
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L61
            goto L63
        L61:
            r4 = 0
            goto L64
        L63:
            r4 = 1
        L64:
            v5.y.fb(r4)
        L67:
            int r4 = r1.length
            if (r10 >= r4) goto L8d
            r4 = r9[r10]
            if (r4 != 0) goto L73
            af.gv$y[] r4 = r0.f243fb
            r4[r10] = r11
            goto L84
        L73:
            af.gv$y[] r5 = r0.f243fb
            r6 = r5[r10]
            if (r6 == 0) goto L7d
            af.en r6 = r6.y
            if (r6 == r4) goto L84
        L7d:
            af.gv$y r6 = new af.gv$y
            r6.<init>(r4)
            r5[r10] = r6
        L84:
            af.gv$y[] r4 = r0.f243fb
            r4 = r4[r10]
            r1[r10] = r4
            int r10 = r10 + 1
            goto L67
        L8d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: af.gv.f(zo.co[], boolean[], af.en[], boolean[], long):long");
    }

    @Override // af.d0, af.jz
    public long fb() {
        long fb2 = this.y.fb();
        if (fb2 != Long.MIN_VALUE) {
            long j2 = this.f245t;
            if (j2 == Long.MIN_VALUE || fb2 < j2) {
                return fb2;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // af.d0
    public long gv(long j2, vc vcVar) {
        long j4 = this.f242f;
        if (j2 == j4) {
            return j4;
        }
        return this.y.gv(j2, a(j2, vcVar));
    }

    @Override // af.d0
    public long i9() {
        boolean z2;
        if (xc()) {
            long j2 = this.f244s;
            this.f244s = -9223372036854775807L;
            long i92 = i9();
            if (i92 != -9223372036854775807L) {
                return i92;
            }
            return j2;
        }
        long i93 = this.y.i9();
        if (i93 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z3 = false;
        if (i93 >= this.f242f) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        long j4 = this.f245t;
        v5.y.fb((j4 == Long.MIN_VALUE || i93 <= j4) ? true : true);
        return i93;
    }

    @Override // af.d0
    public void mt(long j2, boolean z2) {
        this.y.mt(j2, z2);
    }

    @Override // af.d0.y
    public void n3(d0 d0Var) {
        if (this.f247w != null) {
            return;
        }
        ((d0.y) v5.y.v(this.f246v)).n3(this);
    }

    @Override // af.d0
    public lc p() {
        return this.y.p();
    }

    @Override // af.d0, af.jz
    public void s(long j2) {
        this.y.s(j2);
    }

    @Override // af.d0, af.jz
    public boolean v(long j2) {
        return this.y.v(j2);
    }

    @Override // af.jz.y
    /* renamed from: w */
    public void t(d0 d0Var) {
        ((d0.y) v5.y.v(this.f246v)).t(this);
    }

    @Override // af.d0
    public void wz() throws IOException {
        v.n3 n3Var = this.f247w;
        if (n3Var == null) {
            this.y.wz();
            return;
        }
        throw n3Var;
    }

    public void x4(long j2, long j4) {
        this.f242f = j2;
        this.f245t = j4;
    }

    public boolean xc() {
        if (this.f244s != -9223372036854775807L) {
            return true;
        }
        return false;
    }

    @Override // af.d0, af.jz
    public boolean y() {
        return this.y.y();
    }

    public void z(v.n3 n3Var) {
        this.f247w = n3Var;
    }

    @Override // af.d0, af.jz
    public long zn() {
        long zn2 = this.y.zn();
        if (zn2 != Long.MIN_VALUE) {
            long j2 = this.f245t;
            if (j2 == Long.MIN_VALUE || zn2 < j2) {
                return zn2;
            }
        }
        return Long.MIN_VALUE;
    }
}
