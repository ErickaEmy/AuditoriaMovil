package m1;

import af.mg;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class qj {

    /* renamed from: a  reason: collision with root package name */
    public l f11120a;

    /* renamed from: c5  reason: collision with root package name */
    public final k3[] f11121c5;

    /* renamed from: f  reason: collision with root package name */
    public final j3 f11122f;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f11123fb;

    /* renamed from: gv  reason: collision with root package name */
    public boolean f11124gv;

    /* renamed from: i9  reason: collision with root package name */
    public final zo.fh f11125i9;

    /* renamed from: n3  reason: collision with root package name */
    public final Object f11126n3;

    /* renamed from: s  reason: collision with root package name */
    public final boolean[] f11127s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public qj f11128t;

    /* renamed from: tl  reason: collision with root package name */
    public af.lc f11129tl;

    /* renamed from: v  reason: collision with root package name */
    public boolean f11130v;

    /* renamed from: wz  reason: collision with root package name */
    public zo.rz f11131wz;

    /* renamed from: xc  reason: collision with root package name */
    public long f11132xc;
    public final af.d0 y;

    /* renamed from: zn  reason: collision with root package name */
    public final af.en[] f11133zn;

    public qj(k3[] k3VarArr, long j2, zo.fh fhVar, kx.n3 n3Var, j3 j3Var, l lVar, zo.rz rzVar) {
        this.f11121c5 = k3VarArr;
        this.f11132xc = j2;
        this.f11125i9 = fhVar;
        this.f11122f = j3Var;
        mg.n3 n3Var2 = lVar.y;
        this.f11126n3 = n3Var2.y;
        this.f11120a = lVar;
        this.f11129tl = af.lc.f327s;
        this.f11131wz = rzVar;
        this.f11133zn = new af.en[k3VarArr.length];
        this.f11127s = new boolean[k3VarArr.length];
        this.y = v(n3Var2, j3Var, n3Var, lVar.f10900n3, lVar.f10899gv);
    }

    public static void r(j3 j3Var, af.d0 d0Var) {
        try {
            if (d0Var instanceof af.gv) {
                j3Var.c(((af.gv) d0Var).y);
            } else {
                j3Var.c(d0Var);
            }
        } catch (RuntimeException e2) {
            v5.r.gv("MediaPeriodHolder", "Period release failed.", e2);
        }
    }

    public static af.d0 v(mg.n3 n3Var, j3 j3Var, kx.n3 n3Var2, long j2, long j4) {
        af.d0 s2 = j3Var.s(n3Var, n3Var2, j2);
        if (j4 != -9223372036854775807L) {
            return new af.gv(s2, true, 0L, j4);
        }
        return s2;
    }

    public final void a() {
        if (!mt()) {
            return;
        }
        int i = 0;
        while (true) {
            zo.rz rzVar = this.f11131wz;
            if (i < rzVar.y) {
                boolean zn2 = rzVar.zn(i);
                zo.co coVar = this.f11131wz.f15774zn[i];
                if (zn2 && coVar != null) {
                    coVar.fb();
                }
                i++;
            } else {
                return;
            }
        }
    }

    public long c(long j2) {
        return j2 + t();
    }

    public long c5() {
        long j2;
        if (!this.f11124gv) {
            return this.f11120a.f10900n3;
        }
        if (this.f11130v) {
            j2 = this.y.fb();
        } else {
            j2 = Long.MIN_VALUE;
        }
        if (j2 == Long.MIN_VALUE) {
            return this.f11120a.f10902v;
        }
        return j2;
    }

    public void co(long j2) {
        v5.y.fb(mt());
        if (this.f11124gv) {
            this.y.s(n(j2));
        }
    }

    public void d0() {
        af.d0 d0Var = this.y;
        if (d0Var instanceof af.gv) {
            long j2 = this.f11120a.f10899gv;
            if (j2 == -9223372036854775807L) {
                j2 = Long.MIN_VALUE;
            }
            ((af.gv) d0Var).x4(0L, j2);
        }
    }

    public long f() {
        if (!this.f11124gv) {
            return 0L;
        }
        return this.y.zn();
    }

    public void f3(long j2) {
        this.f11132xc = j2;
    }

    public final void fb(af.en[] enVarArr) {
        int i = 0;
        while (true) {
            k3[] k3VarArr = this.f11121c5;
            if (i < k3VarArr.length) {
                if (k3VarArr[i].s() == -2) {
                    enVarArr[i] = null;
                }
                i++;
            } else {
                return;
            }
        }
    }

    public void gv(long j2) {
        v5.y.fb(mt());
        this.y.v(n(j2));
    }

    public void i4(@Nullable qj qjVar) {
        if (qjVar == this.f11128t) {
            return;
        }
        a();
        this.f11128t = qjVar;
        s();
    }

    @Nullable
    public qj i9() {
        return this.f11128t;
    }

    public final boolean mt() {
        if (this.f11128t == null) {
            return true;
        }
        return false;
    }

    public long n(long j2) {
        return j2 - t();
    }

    public long n3(zo.rz rzVar, long j2, boolean z2, boolean[] zArr) {
        boolean z3;
        int i = 0;
        while (true) {
            boolean z4 = true;
            if (i >= rzVar.y) {
                break;
            }
            boolean[] zArr2 = this.f11127s;
            if (z2 || !rzVar.n3(this.f11131wz, i)) {
                z4 = false;
            }
            zArr2[i] = z4;
            i++;
        }
        fb(this.f11133zn);
        a();
        this.f11131wz = rzVar;
        s();
        long f4 = this.y.f(rzVar.f15774zn, this.f11127s, this.f11133zn, zArr, j2);
        zn(this.f11133zn);
        this.f11130v = false;
        int i5 = 0;
        while (true) {
            af.en[] enVarArr = this.f11133zn;
            if (i5 < enVarArr.length) {
                if (enVarArr[i5] != null) {
                    v5.y.fb(rzVar.zn(i5));
                    if (this.f11121c5[i5].s() != -2) {
                        this.f11130v = true;
                    }
                } else {
                    if (rzVar.f15774zn[i5] == null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    v5.y.fb(z3);
                }
                i5++;
            } else {
                return f4;
            }
        }
    }

    public boolean p() {
        if (this.f11124gv && (!this.f11130v || this.y.fb() == Long.MIN_VALUE)) {
            return true;
        }
        return false;
    }

    public final void s() {
        if (!mt()) {
            return;
        }
        int i = 0;
        while (true) {
            zo.rz rzVar = this.f11131wz;
            if (i < rzVar.y) {
                boolean zn2 = rzVar.zn(i);
                zo.co coVar = this.f11131wz.f15774zn[i];
                if (zn2 && coVar != null) {
                    coVar.y();
                }
                i++;
            } else {
                return;
            }
        }
    }

    public long t() {
        return this.f11132xc;
    }

    public long tl() {
        return this.f11120a.f10900n3 + this.f11132xc;
    }

    public void w(float f4, hy hyVar) throws p {
        this.f11124gv = true;
        this.f11129tl = this.y.p();
        zo.rz x42 = x4(f4, hyVar);
        l lVar = this.f11120a;
        long j2 = lVar.f10900n3;
        long j4 = lVar.f10902v;
        if (j4 != -9223372036854775807L && j2 >= j4) {
            j2 = Math.max(0L, j4 - 1);
        }
        long y = y(x42, j2, false);
        long j6 = this.f11132xc;
        l lVar2 = this.f11120a;
        this.f11132xc = j6 + (lVar2.f10900n3 - y);
        this.f11120a = lVar2.n3(y);
    }

    public af.lc wz() {
        return this.f11129tl;
    }

    public zo.rz x4(float f4, hy hyVar) throws p {
        zo.co[] coVarArr;
        zo.rz f6 = this.f11125i9.f(this.f11121c5, wz(), this.f11120a.y, hyVar);
        for (zo.co coVar : f6.f15774zn) {
            if (coVar != null) {
                coVar.i9(f4);
            }
        }
        return f6;
    }

    public zo.rz xc() {
        return this.f11131wz;
    }

    public long y(zo.rz rzVar, long j2, boolean z2) {
        return n3(rzVar, j2, z2, new boolean[this.f11121c5.length]);
    }

    public void z() {
        a();
        r(this.f11122f, this.y);
    }

    public final void zn(af.en[] enVarArr) {
        int i = 0;
        while (true) {
            k3[] k3VarArr = this.f11121c5;
            if (i < k3VarArr.length) {
                if (k3VarArr[i].s() == -2 && this.f11131wz.zn(i)) {
                    enVarArr[i] = new af.z();
                }
                i++;
            } else {
                return;
            }
        }
    }
}
