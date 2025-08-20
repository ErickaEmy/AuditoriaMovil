package af;

import af.mg;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import m1.hy;
import m1.o0;
/* loaded from: classes.dex */
public final class yt extends fb<Integer> {

    /* renamed from: qn  reason: collision with root package name */
    public static final o0 f451qn = new o0.zn().gv("MergingMediaSource").y();

    /* renamed from: b  reason: collision with root package name */
    public long[][] f452b;

    /* renamed from: c  reason: collision with root package name */
    public final hy[] f453c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Object, Long> f454d;

    /* renamed from: d0  reason: collision with root package name */
    public final ArrayList<mg> f455d0;

    /* renamed from: ej  reason: collision with root package name */
    public final z0.z6<Object, gv> f456ej;

    /* renamed from: f3  reason: collision with root package name */
    public final boolean f457f3;

    /* renamed from: fh  reason: collision with root package name */
    public final c5 f458fh;
    @Nullable

    /* renamed from: j5  reason: collision with root package name */
    public n3 f459j5;

    /* renamed from: n  reason: collision with root package name */
    public final mg[] f460n;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f461r;

    /* renamed from: x  reason: collision with root package name */
    public int f462x;

    /* loaded from: classes.dex */
    public static final class n3 extends IOException {
        public final int reason;

        public n3(int i) {
            this.reason = i;
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends r {

        /* renamed from: p  reason: collision with root package name */
        public final long[] f463p;

        /* renamed from: w  reason: collision with root package name */
        public final long[] f464w;

        public y(hy hyVar, Map<Object, Long> map) {
            super(hyVar);
            int z2 = hyVar.z();
            this.f463p = new long[hyVar.z()];
            hy.gv gvVar = new hy.gv();
            for (int i = 0; i < z2; i++) {
                this.f463p[i] = hyVar.mt(i, gvVar).f10805c;
            }
            int tl2 = hyVar.tl();
            this.f464w = new long[tl2];
            hy.n3 n3Var = new hy.n3();
            for (int i5 = 0; i5 < tl2; i5++) {
                hyVar.f(i5, n3Var, true);
                long longValue = ((Long) v5.y.v(map.get(n3Var.f10831v))).longValue();
                long[] jArr = this.f464w;
                longValue = longValue == Long.MIN_VALUE ? n3Var.f10829s : longValue;
                jArr[i5] = longValue;
                long j2 = n3Var.f10829s;
                if (j2 != -9223372036854775807L) {
                    long[] jArr2 = this.f463p;
                    int i6 = n3Var.f10828fb;
                    jArr2[i6] = jArr2[i6] - (j2 - longValue);
                }
            }
        }

        @Override // af.r, m1.hy
        public hy.gv co(int i, hy.gv gvVar, long j2) {
            long j4;
            super.co(i, gvVar, j2);
            long j6 = this.f463p[i];
            gvVar.f10805c = j6;
            if (j6 != -9223372036854775807L) {
                long j7 = gvVar.f10813n;
                if (j7 != -9223372036854775807L) {
                    j4 = Math.min(j7, j6);
                    gvVar.f10813n = j4;
                    return gvVar;
                }
            }
            j4 = gvVar.f10813n;
            gvVar.f10813n = j4;
            return gvVar;
        }

        @Override // af.r, m1.hy
        public hy.n3 f(int i, hy.n3 n3Var, boolean z2) {
            super.f(i, n3Var, z2);
            n3Var.f10829s = this.f464w[i];
            return n3Var;
        }
    }

    public yt(mg... mgVarArr) {
        this(false, mgVarArr);
    }

    @Override // af.fb, af.y
    public void ap() {
        super.ap();
        Arrays.fill(this.f453c, (Object) null);
        this.f462x = -1;
        this.f459j5 = null;
        this.f455d0.clear();
        Collections.addAll(this.f455d0, this.f460n);
    }

    @Override // af.mg
    public o0 c() {
        mg[] mgVarArr = this.f460n;
        if (mgVarArr.length > 0) {
            return mgVarArr[0].c();
        }
        return f451qn;
    }

    public final void cr() {
        hy[] hyVarArr;
        hy.n3 n3Var = new hy.n3();
        for (int i = 0; i < this.f462x; i++) {
            long j2 = Long.MIN_VALUE;
            int i5 = 0;
            while (true) {
                hyVarArr = this.f453c;
                if (i5 >= hyVarArr.length) {
                    break;
                }
                long tl2 = hyVarArr[i5].i9(i, n3Var).tl();
                if (tl2 != -9223372036854775807L) {
                    long j4 = tl2 + this.f452b[i][i5];
                    if (j2 == Long.MIN_VALUE || j4 < j2) {
                        j2 = j4;
                    }
                }
                i5++;
            }
            Object p2 = hyVarArr[0].p(i);
            this.f454d.put(p2, Long.valueOf(j2));
            for (gv gvVar : this.f456ej.get(p2)) {
                gvVar.x4(0L, j2);
            }
        }
    }

    @Override // af.fb, af.y
    public void e(@Nullable kx.o oVar) {
        super.e(oVar);
        for (int i = 0; i < this.f460n.length; i++) {
            bk(Integer.valueOf(i), this.f460n[i]);
        }
    }

    @Override // af.mg
    public d0 f7(mg.n3 n3Var, kx.n3 n3Var2, long j2) {
        int length = this.f460n.length;
        d0[] d0VarArr = new d0[length];
        int a2 = this.f453c[0].a(n3Var.y);
        for (int i = 0; i < length; i++) {
            d0VarArr[i] = this.f460n[i].f7(n3Var.zn(this.f453c[i].p(a2)), n3Var2, j2 - this.f452b[a2][i]);
        }
        k5 k5Var = new k5(this.f458fh, this.f452b[a2], d0VarArr);
        if (this.f457f3) {
            gv gvVar = new gv(k5Var, true, 0L, ((Long) v5.y.v(this.f454d.get(n3Var.y))).longValue());
            this.f456ej.put(n3Var.y, gvVar);
            return gvVar;
        }
        return k5Var;
    }

    @Override // af.fb
    /* renamed from: pq */
    public void u0(Integer num, mg mgVar, hy hyVar) {
        if (this.f459j5 != null) {
            return;
        }
        if (this.f462x == -1) {
            this.f462x = hyVar.tl();
        } else if (hyVar.tl() != this.f462x) {
            this.f459j5 = new n3(0);
            return;
        }
        if (this.f452b.length == 0) {
            this.f452b = (long[][]) Array.newInstance(Long.TYPE, this.f462x, this.f453c.length);
        }
        this.f455d0.remove(mgVar);
        this.f453c[num.intValue()] = hyVar;
        if (this.f455d0.isEmpty()) {
            if (this.f461r) {
                tg();
            }
            y yVar = this.f453c[0];
            if (this.f457f3) {
                cr();
                yVar = new y(yVar, this.f454d);
            }
            s8(yVar);
        }
    }

    @Override // af.fb
    @Nullable
    /* renamed from: pz */
    public mg.n3 rb(Integer num, mg.n3 n3Var) {
        if (num.intValue() != 0) {
            return null;
        }
        return n3Var;
    }

    public final void tg() {
        hy.n3 n3Var = new hy.n3();
        for (int i = 0; i < this.f462x; i++) {
            long j2 = -this.f453c[0].i9(i, n3Var).p();
            int i5 = 1;
            while (true) {
                hy[] hyVarArr = this.f453c;
                if (i5 < hyVarArr.length) {
                    this.f452b[i][i5] = j2 - (-hyVarArr[i5].i9(i, n3Var).p());
                    i5++;
                }
            }
        }
    }

    @Override // af.mg
    public void u(d0 d0Var) {
        if (this.f457f3) {
            gv gvVar = (gv) d0Var;
            Iterator<Map.Entry<Object, gv>> it = this.f456ej.y().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Object, gv> next = it.next();
                if (next.getValue().equals(gvVar)) {
                    this.f456ej.remove(next.getKey(), next.getValue());
                    break;
                }
            }
            d0Var = gvVar.y;
        }
        k5 k5Var = (k5) d0Var;
        int i = 0;
        while (true) {
            mg[] mgVarArr = this.f460n;
            if (i < mgVarArr.length) {
                mgVarArr[i].u(k5Var.a(i));
                i++;
            } else {
                return;
            }
        }
    }

    @Override // af.fb, af.mg
    public void ut() throws IOException {
        n3 n3Var = this.f459j5;
        if (n3Var == null) {
            super.ut();
            return;
        }
        throw n3Var;
    }

    public yt(boolean z2, mg... mgVarArr) {
        this(z2, false, mgVarArr);
    }

    public yt(boolean z2, boolean z3, mg... mgVarArr) {
        this(z2, z3, new t(), mgVarArr);
    }

    public yt(boolean z2, boolean z3, c5 c5Var, mg... mgVarArr) {
        this.f461r = z2;
        this.f457f3 = z3;
        this.f460n = mgVarArr;
        this.f458fh = c5Var;
        this.f455d0 = new ArrayList<>(Arrays.asList(mgVarArr));
        this.f462x = -1;
        this.f453c = new hy[mgVarArr.length];
        this.f452b = new long[0];
        this.f454d = new HashMap();
        this.f456ej = z0.ej.y().y().v();
    }
}
