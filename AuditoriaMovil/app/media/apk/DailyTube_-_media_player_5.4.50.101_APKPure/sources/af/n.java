package af;

import af.mg;
import androidx.annotation.Nullable;
import m1.hy;
import m1.o0;
/* loaded from: classes.dex */
public final class n extends ra {

    /* renamed from: b  reason: collision with root package name */
    public boolean f332b;

    /* renamed from: c  reason: collision with root package name */
    public final hy.gv f333c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public f3 f334d;

    /* renamed from: d0  reason: collision with root package name */
    public final hy.n3 f335d0;

    /* renamed from: ej  reason: collision with root package name */
    public boolean f336ej;

    /* renamed from: fh  reason: collision with root package name */
    public y f337fh;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f338n;

    /* renamed from: x  reason: collision with root package name */
    public boolean f339x;

    /* loaded from: classes.dex */
    public static final class n3 extends hy {

        /* renamed from: t  reason: collision with root package name */
        public final o0 f340t;

        public n3(o0 o0Var) {
            this.f340t = o0Var;
        }

        @Override // m1.hy
        public int a(Object obj) {
            if (obj == y.f341co) {
                return 0;
            }
            return -1;
        }

        @Override // m1.hy
        public hy.gv co(int i, hy.gv gvVar, long j2) {
            gvVar.c5(hy.gv.f10789ej, this.f340t, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            gvVar.f10810f3 = true;
            return gvVar;
        }

        @Override // m1.hy
        public hy.n3 f(int i, hy.n3 n3Var, boolean z2) {
            Integer num;
            Object obj = null;
            if (z2) {
                num = 0;
            } else {
                num = null;
            }
            if (z2) {
                obj = y.f341co;
            }
            n3Var.x4(num, obj, 0, -9223372036854775807L, 0L, je.zn.f9429w, true);
            return n3Var;
        }

        @Override // m1.hy
        public Object p(int i) {
            return y.f341co;
        }

        @Override // m1.hy
        public int tl() {
            return 1;
        }

        @Override // m1.hy
        public int z() {
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends r {

        /* renamed from: co  reason: collision with root package name */
        public static final Object f341co = new Object();
        @Nullable

        /* renamed from: p  reason: collision with root package name */
        public final Object f342p;
        @Nullable

        /* renamed from: w  reason: collision with root package name */
        public final Object f343w;

        public y(hy hyVar, @Nullable Object obj, @Nullable Object obj2) {
            super(hyVar);
            this.f343w = obj;
            this.f342p = obj2;
        }

        public static y c(hy hyVar, @Nullable Object obj, @Nullable Object obj2) {
            return new y(hyVar, obj, obj2);
        }

        public static y n(o0 o0Var) {
            return new y(new n3(o0Var), hy.gv.f10789ej, f341co);
        }

        @Override // af.r, m1.hy
        public int a(Object obj) {
            Object obj2;
            hy hyVar = this.f372t;
            if (f341co.equals(obj) && (obj2 = this.f342p) != null) {
                obj = obj2;
            }
            return hyVar.a(obj);
        }

        @Override // af.r, m1.hy
        public hy.gv co(int i, hy.gv gvVar, long j2) {
            this.f372t.co(i, gvVar, j2);
            if (v5.j5.zn(gvVar.y, this.f343w)) {
                gvVar.y = hy.gv.f10789ej;
            }
            return gvVar;
        }

        @Override // af.r, m1.hy
        public hy.n3 f(int i, hy.n3 n3Var, boolean z2) {
            this.f372t.f(i, n3Var, z2);
            if (v5.j5.zn(n3Var.f10831v, this.f342p) && z2) {
                n3Var.f10831v = f341co;
            }
            return n3Var;
        }

        public y f3(hy hyVar) {
            return new y(hyVar, this.f343w, this.f342p);
        }

        @Override // af.r, m1.hy
        public Object p(int i) {
            Object p2 = this.f372t.p(i);
            if (v5.j5.zn(p2, this.f342p)) {
                return f341co;
            }
            return p2;
        }
    }

    public n(mg mgVar, boolean z2) {
        super(mgVar);
        boolean z3;
        if (z2 && mgVar.q9()) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f338n = z3;
        this.f333c = new hy.gv();
        this.f335d0 = new hy.n3();
        hy k2 = mgVar.k();
        if (k2 != null) {
            this.f337fh = y.c(k2, null, null);
            this.f332b = true;
            return;
        }
        this.f337fh = y.n(mgVar.c());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // af.ra
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void ad(m1.hy r15) {
        /*
            r14 = this;
            boolean r0 = r14.f339x
            if (r0 == 0) goto L19
            af.n$y r0 = r14.f337fh
            af.n$y r15 = r0.f3(r15)
            r14.f337fh = r15
            af.f3 r15 = r14.f334d
            if (r15 == 0) goto Lae
            long r0 = r15.xc()
            r14.oa(r0)
            goto Lae
        L19:
            boolean r0 = r15.r()
            if (r0 == 0) goto L36
            boolean r0 = r14.f332b
            if (r0 == 0) goto L2a
            af.n$y r0 = r14.f337fh
            af.n$y r15 = r0.f3(r15)
            goto L32
        L2a:
            java.lang.Object r0 = m1.hy.gv.f10789ej
            java.lang.Object r1 = af.n.y.f341co
            af.n$y r15 = af.n.y.c(r15, r0, r1)
        L32:
            r14.f337fh = r15
            goto Lae
        L36:
            m1.hy$gv r0 = r14.f333c
            r1 = 0
            r15.mt(r1, r0)
            m1.hy$gv r0 = r14.f333c
            long r2 = r0.v()
            m1.hy$gv r0 = r14.f333c
            java.lang.Object r0 = r0.y
            af.f3 r4 = r14.f334d
            if (r4 == 0) goto L74
            long r4 = r4.w()
            af.n$y r6 = r14.f337fh
            af.f3 r7 = r14.f334d
            af.mg$n3 r7 = r7.y
            java.lang.Object r7 = r7.y
            m1.hy$n3 r8 = r14.f335d0
            r6.t(r7, r8)
            m1.hy$n3 r6 = r14.f335d0
            long r6 = r6.p()
            long r6 = r6 + r4
            af.n$y r4 = r14.f337fh
            m1.hy$gv r5 = r14.f333c
            m1.hy$gv r1 = r4.mt(r1, r5)
            long r4 = r1.v()
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 == 0) goto L74
            r12 = r6
            goto L75
        L74:
            r12 = r2
        L75:
            m1.hy$gv r9 = r14.f333c
            m1.hy$n3 r10 = r14.f335d0
            r11 = 0
            r8 = r15
            android.util.Pair r1 = r8.wz(r9, r10, r11, r12)
            java.lang.Object r2 = r1.first
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r3 = r1.longValue()
            boolean r1 = r14.f332b
            if (r1 == 0) goto L94
            af.n$y r0 = r14.f337fh
            af.n$y r15 = r0.f3(r15)
            goto L98
        L94:
            af.n$y r15 = af.n.y.c(r15, r0, r2)
        L98:
            r14.f337fh = r15
            af.f3 r15 = r14.f334d
            if (r15 == 0) goto Lae
            r14.oa(r3)
            af.mg$n3 r15 = r15.y
            java.lang.Object r0 = r15.y
            java.lang.Object r0 = r14.gq(r0)
            af.mg$n3 r15 = r15.zn(r0)
            goto Laf
        Lae:
            r15 = 0
        Laf:
            r0 = 1
            r14.f332b = r0
            r14.f339x = r0
            af.n$y r0 = r14.f337fh
            r14.s8(r0)
            if (r15 == 0) goto Lc6
            af.f3 r0 = r14.f334d
            java.lang.Object r0 = v5.y.v(r0)
            af.f3 r0 = (af.f3) r0
            r0.a(r15)
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: af.n.ad(m1.hy):void");
    }

    @Override // af.fb, af.y
    public void ap() {
        this.f339x = false;
        this.f336ej = false;
        super.ap();
    }

    public final Object gq(Object obj) {
        if (this.f337fh.f342p != null && obj.equals(y.f341co)) {
            return this.f337fh.f342p;
        }
        return obj;
    }

    public final Object l(Object obj) {
        if (this.f337fh.f342p != null && this.f337fh.f342p.equals(obj)) {
            return y.f341co;
        }
        return obj;
    }

    public final void oa(long j2) {
        f3 f3Var = this.f334d;
        int a2 = this.f337fh.a(f3Var.y.y);
        if (a2 == -1) {
            return;
        }
        long j4 = this.f337fh.i9(a2, this.f335d0).f10829s;
        if (j4 != -9223372036854775807L && j2 >= j4) {
            j2 = Math.max(0L, j4 - 1);
        }
        f3Var.x4(j2);
    }

    @Override // af.mg
    /* renamed from: qj */
    public f3 f7(mg.n3 n3Var, kx.n3 n3Var2, long j2) {
        f3 f3Var = new f3(n3Var, n3Var2, j2);
        f3Var.f3(this.f374r);
        if (this.f339x) {
            f3Var.a(n3Var.zn(gq(n3Var.y)));
        } else {
            this.f334d = f3Var;
            if (!this.f336ej) {
                this.f336ej = true;
                cy();
            }
        }
        return f3Var;
    }

    @Override // af.ra
    public void qk() {
        if (!this.f338n) {
            this.f336ej = true;
            cy();
        }
    }

    @Override // af.ra
    @Nullable
    public mg.n3 tg(mg.n3 n3Var) {
        return n3Var.zn(l(n3Var.y));
    }

    @Override // af.mg
    public void u(d0 d0Var) {
        ((f3) d0Var).i4();
        if (d0Var == this.f334d) {
            this.f334d = null;
        }
    }

    public hy vp() {
        return this.f337fh;
    }

    @Override // af.fb, af.mg
    public void ut() {
    }
}
