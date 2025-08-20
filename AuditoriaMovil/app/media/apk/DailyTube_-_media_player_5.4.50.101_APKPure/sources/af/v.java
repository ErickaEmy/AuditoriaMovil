package af;

import af.mg;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import m1.hy;
/* loaded from: classes.dex */
public final class v extends ra {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public y f388b;

    /* renamed from: c  reason: collision with root package name */
    public final long f389c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f390d;

    /* renamed from: d0  reason: collision with root package name */
    public final boolean f391d0;

    /* renamed from: ej  reason: collision with root package name */
    public final ArrayList<gv> f392ej;

    /* renamed from: fh  reason: collision with root package name */
    public final boolean f393fh;
    @Nullable

    /* renamed from: j5  reason: collision with root package name */
    public n3 f394j5;

    /* renamed from: n  reason: collision with root package name */
    public final long f395n;

    /* renamed from: o  reason: collision with root package name */
    public long f396o;

    /* renamed from: qn  reason: collision with root package name */
    public long f397qn;

    /* renamed from: x  reason: collision with root package name */
    public final hy.gv f398x;

    /* loaded from: classes.dex */
    public static final class n3 extends IOException {
        public final int reason;

        public n3(int i) {
            super("Illegal clipping: " + y(i));
            this.reason = i;
        }

        public static String y(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return "unknown";
                    }
                    return "start exceeds end";
                }
                return "not seekable to start";
            }
            return "invalid period count";
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends r {

        /* renamed from: co  reason: collision with root package name */
        public final long f399co;

        /* renamed from: p  reason: collision with root package name */
        public final long f400p;

        /* renamed from: w  reason: collision with root package name */
        public final long f401w;

        /* renamed from: z  reason: collision with root package name */
        public final boolean f402z;

        public y(hy hyVar, long j2, long j4) throws n3 {
            super(hyVar);
            long max;
            long j6;
            boolean z2 = false;
            if (hyVar.tl() == 1) {
                hy.gv mt2 = hyVar.mt(0, new hy.gv());
                long max2 = Math.max(0L, j2);
                if (!mt2.f10810f3 && max2 != 0 && !mt2.f10814p) {
                    throw new n3(1);
                }
                if (j4 == Long.MIN_VALUE) {
                    max = mt2.f10805c;
                } else {
                    max = Math.max(0L, j4);
                }
                long j7 = mt2.f10805c;
                if (j7 != -9223372036854775807L) {
                    max = max > j7 ? j7 : max;
                    if (max2 > max) {
                        throw new n3(2);
                    }
                }
                this.f401w = max2;
                this.f400p = max;
                int i = (max > (-9223372036854775807L) ? 1 : (max == (-9223372036854775807L) ? 0 : -1));
                if (i == 0) {
                    j6 = -9223372036854775807L;
                } else {
                    j6 = max - max2;
                }
                this.f399co = j6;
                if (mt2.f10806co && (i == 0 || (j7 != -9223372036854775807L && max == j7))) {
                    z2 = true;
                }
                this.f402z = z2;
                return;
            }
            throw new n3(0);
        }

        @Override // af.r, m1.hy
        public hy.gv co(int i, hy.gv gvVar, long j2) {
            this.f372t.co(0, gvVar, 0L);
            long j4 = gvVar.f10807d;
            long j6 = this.f401w;
            gvVar.f10807d = j4 + j6;
            gvVar.f10805c = this.f399co;
            gvVar.f10806co = this.f402z;
            long j7 = gvVar.f10813n;
            if (j7 != -9223372036854775807L) {
                long max = Math.max(j7, j6);
                gvVar.f10813n = max;
                long j8 = this.f400p;
                if (j8 != -9223372036854775807L) {
                    max = Math.min(max, j8);
                }
                gvVar.f10813n = max - this.f401w;
            }
            long gf = v5.j5.gf(this.f401w);
            long j9 = gvVar.f10809f;
            if (j9 != -9223372036854775807L) {
                gvVar.f10809f = j9 + gf;
            }
            long j10 = gvVar.f10817t;
            if (j10 != -9223372036854775807L) {
                gvVar.f10817t = j10 + gf;
            }
            return gvVar;
        }

        @Override // af.r, m1.hy
        public hy.n3 f(int i, hy.n3 n3Var, boolean z2) {
            long j2;
            this.f372t.f(0, n3Var, z2);
            long p2 = n3Var.p() - this.f401w;
            long j4 = this.f399co;
            if (j4 == -9223372036854775807L) {
                j2 = -9223372036854775807L;
            } else {
                j2 = j4 - p2;
            }
            return n3Var.r(n3Var.y, n3Var.f10831v, 0, j2, p2);
        }
    }

    public v(mg mgVar, long j2, long j4, boolean z2, boolean z3, boolean z4) {
        super((mg) v5.y.v(mgVar));
        boolean z5;
        if (j2 >= 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        v5.y.y(z5);
        this.f395n = j2;
        this.f389c = j4;
        this.f391d0 = z2;
        this.f393fh = z3;
        this.f390d = z4;
        this.f392ej = new ArrayList<>();
        this.f398x = new hy.gv();
    }

    @Override // af.ra
    public void ad(hy hyVar) {
        if (this.f394j5 != null) {
            return;
        }
        qj(hyVar);
    }

    @Override // af.fb, af.y
    public void ap() {
        super.ap();
        this.f394j5 = null;
        this.f388b = null;
    }

    @Override // af.mg
    public d0 f7(mg.n3 n3Var, kx.n3 n3Var2, long j2) {
        gv gvVar = new gv(this.f374r.f7(n3Var, n3Var2, j2), this.f391d0, this.f397qn, this.f396o);
        this.f392ej.add(gvVar);
        return gvVar;
    }

    public final void qj(hy hyVar) {
        long j2;
        hyVar.mt(0, this.f398x);
        long fb2 = this.f398x.fb();
        long j4 = Long.MIN_VALUE;
        if (this.f388b != null && !this.f392ej.isEmpty() && !this.f393fh) {
            long j6 = this.f397qn - fb2;
            if (this.f389c != Long.MIN_VALUE) {
                j4 = this.f396o - fb2;
            }
            j2 = j6;
        } else {
            long j7 = this.f395n;
            long j8 = this.f389c;
            if (this.f390d) {
                long v2 = this.f398x.v();
                j7 += v2;
                j8 += v2;
            }
            this.f397qn = fb2 + j7;
            if (this.f389c != Long.MIN_VALUE) {
                j4 = fb2 + j8;
            }
            this.f396o = j4;
            int size = this.f392ej.size();
            for (int i = 0; i < size; i++) {
                this.f392ej.get(i).x4(this.f397qn, this.f396o);
            }
            j2 = j7;
            j4 = j8;
        }
        try {
            y yVar = new y(hyVar, j2, j4);
            this.f388b = yVar;
            s8(yVar);
        } catch (n3 e2) {
            this.f394j5 = e2;
            for (int i5 = 0; i5 < this.f392ej.size(); i5++) {
                this.f392ej.get(i5).z(this.f394j5);
            }
        }
    }

    @Override // af.mg
    public void u(d0 d0Var) {
        v5.y.fb(this.f392ej.remove(d0Var));
        this.f374r.u(((gv) d0Var).y);
        if (this.f392ej.isEmpty() && !this.f393fh) {
            qj(((y) v5.y.v(this.f388b)).f372t);
        }
    }

    @Override // af.fb, af.mg
    public void ut() throws IOException {
        n3 n3Var = this.f394j5;
        if (n3Var == null) {
            super.ut();
            return;
        }
        throw n3Var;
    }
}
