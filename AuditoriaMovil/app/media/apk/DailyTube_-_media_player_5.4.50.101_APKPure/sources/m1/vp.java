package m1;

import af.mg;
import androidx.annotation.Nullable;
import m1.hy;
import z0.x4;
/* loaded from: classes.dex */
public final class vp {

    /* renamed from: a  reason: collision with root package name */
    public int f11299a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public qj f11300c5;

    /* renamed from: f  reason: collision with root package name */
    public int f11301f;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f11302fb;

    /* renamed from: gv  reason: collision with root package name */
    public final v5.p f11303gv;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public qj f11304i9;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public qj f11306s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public Object f11307t;

    /* renamed from: tl  reason: collision with root package name */
    public long f11308tl;

    /* renamed from: v  reason: collision with root package name */
    public long f11309v;

    /* renamed from: zn  reason: collision with root package name */
    public final fj.y f11310zn;
    public final hy.n3 y = new hy.n3();

    /* renamed from: n3  reason: collision with root package name */
    public final hy.gv f11305n3 = new hy.gv();

    public vp(fj.y yVar, v5.p pVar) {
        this.f11310zn = yVar;
        this.f11303gv = pVar;
    }

    public static mg.n3 d0(hy hyVar, Object obj, long j2, long j4, hy.gv gvVar, hy.n3 n3Var) {
        hyVar.t(obj, n3Var);
        hyVar.mt(n3Var.f10828fb, gvVar);
        int a2 = hyVar.a(obj);
        Object obj2 = obj;
        while (n3Var.f10829s == 0 && n3Var.a() > 0 && n3Var.z(n3Var.mt()) && n3Var.s(0L) == -1) {
            int i = a2 + 1;
            if (a2 >= gvVar.f10812fh) {
                break;
            }
            hyVar.f(i, n3Var, true);
            obj2 = v5.y.v(n3Var.f10831v);
            a2 = i;
        }
        hyVar.t(obj2, n3Var);
        int s2 = n3Var.s(j2);
        if (s2 == -1) {
            return new mg.n3(obj2, j4, n3Var.fb(j2));
        }
        return new mg.n3(obj2, s2, n3Var.wz(s2), j4);
    }

    public void a() {
        if (this.f11301f == 0) {
            return;
        }
        qj qjVar = (qj) v5.y.c5(this.f11306s);
        this.f11307t = qjVar.f11126n3;
        this.f11308tl = qjVar.f11120a.y.f238gv;
        while (qjVar != null) {
            qjVar.z();
            qjVar = qjVar.i9();
        }
        this.f11306s = null;
        this.f11304i9 = null;
        this.f11300c5 = null;
        this.f11301f = 0;
        f3();
    }

    public boolean c(qj qjVar) {
        boolean z2;
        boolean z3 = false;
        if (qjVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        if (qjVar.equals(this.f11304i9)) {
            return false;
        }
        this.f11304i9 = qjVar;
        while (qjVar.i9() != null) {
            qjVar = qjVar.i9();
            if (qjVar == this.f11300c5) {
                this.f11300c5 = this.f11306s;
                z3 = true;
            }
            qjVar.z();
            this.f11301f--;
        }
        this.f11304i9.i4(null);
        f3();
        return z3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00cc, code lost:
        if (r0.z(r0.mt()) != false) goto L26;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final m1.l c5(m1.hy r20, m1.qj r21, long r22) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.vp.c5(m1.hy, m1.qj, long):m1.l");
    }

    public final boolean co(mg.n3 n3Var) {
        if (!n3Var.n3() && n3Var.f240v == -1) {
            return true;
        }
        return false;
    }

    public boolean d(hy hyVar, long j2, long j4) {
        l lVar;
        long c2;
        boolean z2;
        qj qjVar = null;
        for (qj qjVar2 = this.f11306s; qjVar2 != null; qjVar2 = qjVar2.i9()) {
            l lVar2 = qjVar2.f11120a;
            if (qjVar == null) {
                lVar = mt(hyVar, lVar2);
            } else {
                l c52 = c5(hyVar, qjVar, j2);
                if (c52 == null) {
                    return !c(qjVar);
                }
                if (!v(lVar2, c52)) {
                    return !c(qjVar);
                }
                lVar = c52;
            }
            qjVar2.f11120a = lVar.y(lVar2.f10903zn);
            if (!gv(lVar2.f10902v, lVar.f10902v)) {
                qjVar2.d0();
                long j6 = lVar.f10902v;
                if (j6 == -9223372036854775807L) {
                    c2 = Long.MAX_VALUE;
                } else {
                    c2 = qjVar2.c(j6);
                }
                if (qjVar2 == this.f11300c5 && !qjVar2.f11120a.f10896a && (j4 == Long.MIN_VALUE || j4 >= c2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!c(qjVar2) && !z2) {
                    return true;
                }
                return false;
            }
            qjVar = qjVar2;
        }
        return true;
    }

    public boolean ej(hy hyVar, boolean z2) {
        this.f11302fb = z2;
        return ta(hyVar);
    }

    @Nullable
    public final l f(hy hyVar, mg.n3 n3Var, long j2, long j4) {
        hyVar.t(n3Var.y, this.y);
        if (n3Var.n3()) {
            return t(hyVar, n3Var.y, n3Var.f239n3, n3Var.f241zn, j2, n3Var.f238gv);
        }
        return tl(hyVar, n3Var.y, j4, j2, n3Var.f238gv);
    }

    public final void f3() {
        final mg.n3 n3Var;
        final x4.y x42 = z0.x4.x4();
        for (qj qjVar = this.f11306s; qjVar != null; qjVar = qjVar.i9()) {
            x42.y(qjVar.f11120a.y);
        }
        qj qjVar2 = this.f11300c5;
        if (qjVar2 == null) {
            n3Var = null;
        } else {
            n3Var = qjVar2.f11120a.y;
        }
        this.f11303gv.c5(new Runnable() { // from class: m1.gq
            @Override // java.lang.Runnable
            public final void run() {
                vp.this.i4(x42, n3Var);
            }
        });
    }

    public qj fb(k3[] k3VarArr, zo.fh fhVar, kx.n3 n3Var, j3 j3Var, l lVar, zo.rz rzVar) {
        long t2;
        qj qjVar = this.f11304i9;
        if (qjVar == null) {
            t2 = 1000000000000L;
        } else {
            t2 = (qjVar.t() + this.f11304i9.f11120a.f10902v) - lVar.f10900n3;
        }
        qj qjVar2 = new qj(k3VarArr, t2, fhVar, n3Var, j3Var, lVar, rzVar);
        qj qjVar3 = this.f11304i9;
        if (qjVar3 != null) {
            qjVar3.i4(qjVar2);
        } else {
            this.f11306s = qjVar2;
            this.f11300c5 = qjVar2;
        }
        this.f11307t = null;
        this.f11304i9 = qjVar2;
        this.f11301f++;
        f3();
        return qjVar2;
    }

    public mg.n3 fh(hy hyVar, Object obj, long j2) {
        long rz2 = rz(hyVar, obj);
        hyVar.t(obj, this.y);
        hyVar.mt(this.y.f10828fb, this.f11305n3);
        boolean z2 = false;
        for (int a2 = hyVar.a(obj); a2 >= this.f11305n3.f10808d0; a2--) {
            boolean z3 = true;
            hyVar.f(a2, this.y, true);
            if (this.y.a() <= 0) {
                z3 = false;
            }
            z2 |= z3;
            hy.n3 n3Var = this.y;
            if (n3Var.s(n3Var.f10829s) != -1) {
                obj = v5.y.v(this.y.f10831v);
            }
            if (z2 && (!z3 || this.y.f10829s != 0)) {
                break;
            }
        }
        return d0(hyVar, obj, j2, rz2, this.f11305n3, this.y);
    }

    public final boolean gv(long j2, long j4) {
        if (j2 != -9223372036854775807L && j2 != j4) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ void i4(x4.y yVar, mg.n3 n3Var) {
        this.f11310zn.qn(yVar.s(), n3Var);
    }

    @Nullable
    public qj i9() {
        return this.f11304i9;
    }

    public boolean mg() {
        qj qjVar = this.f11304i9;
        if (qjVar != null && (qjVar.f11120a.f10897c5 || !qjVar.p() || this.f11304i9.f11120a.f10902v == -9223372036854775807L || this.f11301f >= 100)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public m1.l mt(m1.hy r19, m1.l r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            af.mg$n3 r3 = r2.y
            boolean r12 = r0.co(r3)
            boolean r13 = r0.r(r1, r3)
            boolean r14 = r0.z(r1, r3, r12)
            af.mg$n3 r4 = r2.y
            java.lang.Object r4 = r4.y
            m1.hy$n3 r5 = r0.y
            r1.t(r4, r5)
            boolean r1 = r3.n3()
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = -1
            if (r1 != 0) goto L35
            int r1 = r3.f240v
            if (r1 != r6) goto L2e
            goto L35
        L2e:
            m1.hy$n3 r7 = r0.y
            long r7 = r7.c5(r1)
            goto L36
        L35:
            r7 = r4
        L36:
            boolean r1 = r3.n3()
            if (r1 == 0) goto L48
            m1.hy$n3 r1 = r0.y
            int r4 = r3.f239n3
            int r5 = r3.f241zn
            long r4 = r1.v(r4, r5)
        L46:
            r9 = r4
            goto L5c
        L48:
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 == 0) goto L55
            r4 = -9223372036854775808
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 != 0) goto L53
            goto L55
        L53:
            r9 = r7
            goto L5c
        L55:
            m1.hy$n3 r1 = r0.y
            long r4 = r1.tl()
            goto L46
        L5c:
            boolean r1 = r3.n3()
            if (r1 == 0) goto L6c
            m1.hy$n3 r1 = r0.y
            int r4 = r3.f239n3
            boolean r1 = r1.z(r4)
            r11 = r1
            goto L7d
        L6c:
            int r1 = r3.f240v
            if (r1 == r6) goto L7b
            m1.hy$n3 r4 = r0.y
            boolean r1 = r4.z(r1)
            if (r1 == 0) goto L7b
            r1 = 1
            r11 = 1
            goto L7d
        L7b:
            r1 = 0
            r11 = 0
        L7d:
            m1.l r15 = new m1.l
            long r4 = r2.f10900n3
            long r1 = r2.f10903zn
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.vp.mt(m1.hy, m1.l):m1.l");
    }

    public void n(long j2) {
        qj qjVar = this.f11304i9;
        if (qjVar != null) {
            qjVar.co(j2);
        }
    }

    @Nullable
    public qj n3() {
        qj qjVar = this.f11306s;
        if (qjVar == null) {
            return null;
        }
        if (qjVar == this.f11300c5) {
            this.f11300c5 = qjVar.i9();
        }
        this.f11306s.z();
        int i = this.f11301f - 1;
        this.f11301f = i;
        if (i == 0) {
            this.f11304i9 = null;
            qj qjVar2 = this.f11306s;
            this.f11307t = qjVar2.f11126n3;
            this.f11308tl = qjVar2.f11120a.y.f238gv;
        }
        this.f11306s = this.f11306s.i9();
        f3();
        return this.f11306s;
    }

    @Nullable
    public qj p() {
        return this.f11300c5;
    }

    public final boolean r(hy hyVar, mg.n3 n3Var) {
        if (!co(n3Var)) {
            return false;
        }
        int i = hyVar.t(n3Var.y, this.y).f10828fb;
        if (hyVar.mt(i, this.f11305n3).f10812fh != hyVar.a(n3Var.y)) {
            return false;
        }
        return true;
    }

    public final long rz(hy hyVar, Object obj) {
        int a2;
        int i = hyVar.t(obj, this.y).f10828fb;
        Object obj2 = this.f11307t;
        if (obj2 != null && (a2 = hyVar.a(obj2)) != -1 && hyVar.i9(a2, this.y).f10828fb == i) {
            return this.f11308tl;
        }
        for (qj qjVar = this.f11306s; qjVar != null; qjVar = qjVar.i9()) {
            if (qjVar.f11126n3.equals(obj)) {
                return qjVar.f11120a.y.f238gv;
            }
        }
        for (qj qjVar2 = this.f11306s; qjVar2 != null; qjVar2 = qjVar2.i9()) {
            int a3 = hyVar.a(qjVar2.f11126n3);
            if (a3 != -1 && hyVar.i9(a3, this.y).f10828fb == i) {
                return qjVar2.f11120a.y.f238gv;
            }
        }
        long j2 = this.f11309v;
        this.f11309v = 1 + j2;
        if (this.f11306s == null) {
            this.f11307t = obj;
            this.f11308tl = j2;
        }
        return j2;
    }

    @Nullable
    public final l s(bv bvVar) {
        return f(bvVar.y, bvVar.f10594n3, bvVar.f10603zn, bvVar.f10593mt);
    }

    public final l t(hy hyVar, Object obj, int i, int i5, long j2, long j4) {
        long j6;
        long j7;
        mg.n3 n3Var = new mg.n3(obj, i, i5, j4);
        long v2 = hyVar.t(n3Var.y, this.y).v(n3Var.f239n3, n3Var.f241zn);
        if (i5 == this.y.wz(i)) {
            j6 = this.y.i9();
        } else {
            j6 = 0;
        }
        boolean z2 = this.y.z(n3Var.f239n3);
        if (v2 != -9223372036854775807L && j6 >= v2) {
            j7 = Math.max(0L, v2 - 1);
        } else {
            j7 = j6;
        }
        return new l(n3Var, j7, j2, -9223372036854775807L, v2, z2, false, false, false);
    }

    public final boolean ta(hy hyVar) {
        qj qjVar = this.f11306s;
        if (qjVar == null) {
            return true;
        }
        int a2 = hyVar.a(qjVar.f11126n3);
        while (true) {
            a2 = hyVar.s(a2, this.y, this.f11305n3, this.f11299a, this.f11302fb);
            while (qjVar.i9() != null && !qjVar.f11120a.f10898fb) {
                qjVar = qjVar.i9();
            }
            qj i92 = qjVar.i9();
            if (a2 == -1 || i92 == null || hyVar.a(i92.f11126n3) != a2) {
                break;
            }
            qjVar = i92;
        }
        boolean c2 = c(qjVar);
        qjVar.f11120a = mt(hyVar, qjVar.f11120a);
        return !c2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002a, code lost:
        if (r9.z(r9.mt()) != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final m1.l tl(m1.hy r25, java.lang.Object r26, long r27, long r29, long r31) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = r27
            m1.hy$n3 r5 = r0.y
            r1.t(r2, r5)
            m1.hy$n3 r5 = r0.y
            int r5 = r5.fb(r3)
            r6 = 1
            r7 = 0
            r8 = -1
            if (r5 != r8) goto L2d
            m1.hy$n3 r9 = r0.y
            int r9 = r9.a()
            if (r9 <= 0) goto L4c
            m1.hy$n3 r9 = r0.y
            int r10 = r9.mt()
            boolean r9 = r9.z(r10)
            if (r9 == 0) goto L4c
            goto L4a
        L2d:
            m1.hy$n3 r9 = r0.y
            boolean r9 = r9.z(r5)
            if (r9 == 0) goto L4c
            m1.hy$n3 r9 = r0.y
            long r9 = r9.c5(r5)
            m1.hy$n3 r11 = r0.y
            long r12 = r11.f10829s
            int r14 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r14 != 0) goto L4c
            boolean r9 = r11.co(r5)
            if (r9 == 0) goto L4c
            r5 = -1
        L4a:
            r9 = 1
            goto L4d
        L4c:
            r9 = 0
        L4d:
            af.mg$n3 r11 = new af.mg$n3
            r12 = r31
            r11.<init>(r2, r12, r5)
            boolean r2 = r0.co(r11)
            boolean r22 = r0.r(r1, r11)
            boolean r23 = r0.z(r1, r11, r2)
            if (r5 == r8) goto L6d
            m1.hy$n3 r1 = r0.y
            boolean r1 = r1.z(r5)
            if (r1 == 0) goto L6d
            r20 = 1
            goto L6f
        L6d:
            r20 = 0
        L6f:
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r5 == r8) goto L7f
            m1.hy$n3 r1 = r0.y
            long r14 = r1.c5(r5)
        L7c:
            r16 = r14
            goto L88
        L7f:
            if (r9 == 0) goto L86
            m1.hy$n3 r1 = r0.y
            long r14 = r1.f10829s
            goto L7c
        L86:
            r16 = r12
        L88:
            int r1 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1))
            if (r1 == 0) goto L96
            r14 = -9223372036854775808
            int r1 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r1 != 0) goto L93
            goto L96
        L93:
            r18 = r16
            goto L9c
        L96:
            m1.hy$n3 r1 = r0.y
            long r14 = r1.f10829s
            r18 = r14
        L9c:
            int r1 = (r18 > r12 ? 1 : (r18 == r12 ? 0 : -1))
            if (r1 == 0) goto Lb3
            int r1 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r1 < 0) goto Lb3
            if (r23 != 0) goto Laa
            if (r9 != 0) goto La9
            goto Laa
        La9:
            r6 = 0
        Laa:
            long r3 = (long) r6
            long r3 = r18 - r3
            r5 = 0
            long r3 = java.lang.Math.max(r5, r3)
        Lb3:
            r12 = r3
            m1.l r1 = new m1.l
            r10 = r1
            r14 = r29
            r21 = r2
            r10.<init>(r11, r12, r14, r16, r18, r20, r21, r22, r23)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.vp.tl(m1.hy, java.lang.Object, long, long, long):m1.l");
    }

    public final boolean v(l lVar, l lVar2) {
        if (lVar.f10900n3 == lVar2.f10900n3 && lVar.y.equals(lVar2.y)) {
            return true;
        }
        return false;
    }

    @Nullable
    public qj w() {
        return this.f11306s;
    }

    public final long wz(hy hyVar, Object obj, int i) {
        hyVar.t(obj, this.y);
        long c52 = this.y.c5(i);
        if (c52 == Long.MIN_VALUE) {
            return this.y.f10829s;
        }
        return c52 + this.y.t(i);
    }

    public boolean x4(af.d0 d0Var) {
        qj qjVar = this.f11304i9;
        if (qjVar != null && qjVar.y == d0Var) {
            return true;
        }
        return false;
    }

    @Nullable
    public l xc(long j2, bv bvVar) {
        qj qjVar = this.f11304i9;
        if (qjVar == null) {
            return s(bvVar);
        }
        return c5(bvVar.y, qjVar, j2);
    }

    public final boolean z(hy hyVar, mg.n3 n3Var, boolean z2) {
        int a2 = hyVar.a(n3Var.y);
        if (!hyVar.mt(hyVar.i9(a2, this.y).f10828fb, this.f11305n3).f10806co && hyVar.x4(a2, this.y, this.f11305n3, this.f11299a, this.f11302fb) && z2) {
            return true;
        }
        return false;
    }

    public boolean z6(hy hyVar, int i) {
        this.f11299a = i;
        return ta(hyVar);
    }

    public qj zn() {
        boolean z2;
        qj qjVar = this.f11300c5;
        if (qjVar != null && qjVar.i9() != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        this.f11300c5 = this.f11300c5.i9();
        f3();
        return this.f11300c5;
    }
}
