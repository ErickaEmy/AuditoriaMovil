package m1;

import af.d0;
import af.mg;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.gv;
import com.google.android.exoplayer2.metadata.Metadata;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import m1.c8;
import m1.hy;
import m1.j3;
import m1.o0;
import m1.t;
import m1.zq;
import z0.x4;
import zo.fh;
/* loaded from: classes.dex */
public final class yc implements Handler.Callback, d0.y, fh.y, j3.gv, t.y, c8.y {

    /* renamed from: b  reason: collision with root package name */
    public final j3 f11333b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f11334c;
    @Nullable

    /* renamed from: co  reason: collision with root package name */
    public final HandlerThread f11335co;

    /* renamed from: ct  reason: collision with root package name */
    public int f11336ct;

    /* renamed from: d  reason: collision with root package name */
    public final v5.v f11337d;

    /* renamed from: d0  reason: collision with root package name */
    public final t f11338d0;

    /* renamed from: dm  reason: collision with root package name */
    public boolean f11339dm;

    /* renamed from: e  reason: collision with root package name */
    public long f11340e = -9223372036854775807L;

    /* renamed from: eb  reason: collision with root package name */
    public int f11341eb;

    /* renamed from: ej  reason: collision with root package name */
    public final a f11342ej;

    /* renamed from: en  reason: collision with root package name */
    public boolean f11343en;

    /* renamed from: f  reason: collision with root package name */
    public final zo.rz f11344f;

    /* renamed from: f3  reason: collision with root package name */
    public final hy.n3 f11345f3;

    /* renamed from: f7  reason: collision with root package name */
    public boolean f11346f7;

    /* renamed from: fb  reason: collision with root package name */
    public final k3[] f11347fb;

    /* renamed from: fh  reason: collision with root package name */
    public final ArrayList<gv> f11348fh;

    /* renamed from: j  reason: collision with root package name */
    public bv f11349j;

    /* renamed from: j5  reason: collision with root package name */
    public final pz f11350j5;

    /* renamed from: jz  reason: collision with root package name */
    public int f11351jz;

    /* renamed from: k  reason: collision with root package name */
    public boolean f11352k;

    /* renamed from: lc  reason: collision with root package name */
    public boolean f11353lc;

    /* renamed from: n  reason: collision with root package name */
    public final long f11354n;
    @Nullable

    /* renamed from: nf  reason: collision with root package name */
    public p f11355nf;

    /* renamed from: o  reason: collision with root package name */
    public vc f11356o;
    @Nullable

    /* renamed from: o4  reason: collision with root package name */
    public s f11357o4;

    /* renamed from: oz  reason: collision with root package name */
    public v f11358oz;

    /* renamed from: p  reason: collision with root package name */
    public final v5.p f11359p;

    /* renamed from: q9  reason: collision with root package name */
    public boolean f11360q9;

    /* renamed from: qn  reason: collision with root package name */
    public final long f11361qn;

    /* renamed from: r  reason: collision with root package name */
    public final hy.gv f11362r;

    /* renamed from: ra  reason: collision with root package name */
    public long f11363ra;

    /* renamed from: rs  reason: collision with root package name */
    public long f11364rs;

    /* renamed from: s  reason: collision with root package name */
    public final zo.fh f11365s;

    /* renamed from: t  reason: collision with root package name */
    public final pq f11366t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f11367u;

    /* renamed from: ut  reason: collision with root package name */
    public boolean f11368ut;

    /* renamed from: v  reason: collision with root package name */
    public final Set<zq> f11369v;

    /* renamed from: w  reason: collision with root package name */
    public final kx.a f11370w;

    /* renamed from: x  reason: collision with root package name */
    public final vp f11371x;

    /* renamed from: xg  reason: collision with root package name */
    public boolean f11372xg;
    public final zq[] y;

    /* renamed from: y5  reason: collision with root package name */
    public boolean f11373y5;

    /* renamed from: z  reason: collision with root package name */
    public final Looper f11374z;

    /* loaded from: classes.dex */
    public interface a {
        void y(v vVar);
    }

    /* loaded from: classes.dex */
    public static final class fb {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f11375a;

        /* renamed from: gv  reason: collision with root package name */
        public final boolean f11376gv;

        /* renamed from: n3  reason: collision with root package name */
        public final long f11377n3;

        /* renamed from: v  reason: collision with root package name */
        public final boolean f11378v;
        public final mg.n3 y;

        /* renamed from: zn  reason: collision with root package name */
        public final long f11379zn;

        public fb(mg.n3 n3Var, long j2, long j4, boolean z2, boolean z3, boolean z4) {
            this.y = n3Var;
            this.f11377n3 = j2;
            this.f11379zn = j4;
            this.f11376gv = z2;
            this.f11378v = z3;
            this.f11375a = z4;
        }
    }

    /* loaded from: classes.dex */
    public static final class gv implements Comparable<gv> {

        /* renamed from: fb  reason: collision with root package name */
        public long f11380fb;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        public Object f11381s;

        /* renamed from: v  reason: collision with root package name */
        public int f11382v;
        public final c8 y;

        public gv(c8 c8Var) {
            this.y = c8Var;
        }

        public void n3(int i, long j2, Object obj) {
            this.f11382v = i;
            this.f11380fb = j2;
            this.f11381s = obj;
        }

        @Override // java.lang.Comparable
        /* renamed from: y */
        public int compareTo(gv gvVar) {
            boolean z2;
            boolean z3;
            Object obj = this.f11381s;
            if (obj == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (gvVar.f11381s == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z2 != z3) {
                if (obj == null) {
                    return 1;
                }
                return -1;
            } else if (obj == null) {
                return 0;
            } else {
                int i = this.f11382v - gvVar.f11382v;
                if (i != 0) {
                    return i;
                }
                return v5.j5.xc(this.f11380fb, gvVar.f11380fb);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: gv  reason: collision with root package name */
        public final long f11383gv;

        /* renamed from: n3  reason: collision with root package name */
        public final af.u f11384n3;
        public final List<j3.zn> y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f11385zn;

        public /* synthetic */ n3(List list, af.u uVar, int i, long j2, y yVar) {
            this(list, uVar, i, j2);
        }

        public n3(List<j3.zn> list, af.u uVar, int i, long j2) {
            this.y = list;
            this.f11384n3 = uVar;
            this.f11385zn = i;
            this.f11383gv = j2;
        }
    }

    /* loaded from: classes.dex */
    public static final class s {

        /* renamed from: n3  reason: collision with root package name */
        public final int f11386n3;
        public final hy y;

        /* renamed from: zn  reason: collision with root package name */
        public final long f11387zn;

        public s(hy hyVar, int i, long j2) {
            this.y = hyVar;
            this.f11386n3 = i;
            this.f11387zn = j2;
        }
    }

    /* loaded from: classes.dex */
    public static final class v {

        /* renamed from: a  reason: collision with root package name */
        public boolean f11388a;

        /* renamed from: fb  reason: collision with root package name */
        public int f11389fb;

        /* renamed from: gv  reason: collision with root package name */
        public boolean f11390gv;

        /* renamed from: n3  reason: collision with root package name */
        public bv f11391n3;

        /* renamed from: v  reason: collision with root package name */
        public int f11392v;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public int f11393zn;

        public v(bv bvVar) {
            this.f11391n3 = bvVar;
        }

        public void gv(bv bvVar) {
            boolean z2;
            boolean z3 = this.y;
            if (this.f11391n3 != bvVar) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.y = z3 | z2;
            this.f11391n3 = bvVar;
        }

        public void n3(int i) {
            boolean z2;
            boolean z3 = this.y;
            if (i > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.y = z3 | z2;
            this.f11393zn += i;
        }

        public void v(int i) {
            boolean z2 = true;
            if (this.f11390gv && this.f11392v != 5) {
                if (i != 5) {
                    z2 = false;
                }
                v5.y.y(z2);
                return;
            }
            this.y = true;
            this.f11390gv = true;
            this.f11392v = i;
        }

        public void zn(int i) {
            this.y = true;
            this.f11388a = true;
            this.f11389fb = i;
        }
    }

    /* loaded from: classes.dex */
    public class y implements zq.y {
        public y() {
        }

        @Override // m1.zq.y
        public void n3() {
            yc.this.f11359p.i9(2);
        }

        @Override // m1.zq.y
        public void y() {
            yc.this.f11372xg = true;
        }
    }

    /* loaded from: classes.dex */
    public static class zn {

        /* renamed from: gv  reason: collision with root package name */
        public final af.u f11394gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f11395n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f11396zn;
    }

    public yc(zq[] zqVarArr, zo.fh fhVar, zo.rz rzVar, pq pqVar, kx.a aVar, int i, boolean z2, fj.y yVar, vc vcVar, pz pzVar, long j2, boolean z3, Looper looper, v5.v vVar, a aVar2, fj.u0 u0Var, Looper looper2) {
        this.f11342ej = aVar2;
        this.y = zqVarArr;
        this.f11365s = fhVar;
        this.f11344f = rzVar;
        this.f11366t = pqVar;
        this.f11370w = aVar;
        this.f11351jz = i;
        this.f11367u = z2;
        this.f11356o = vcVar;
        this.f11350j5 = pzVar;
        this.f11361qn = j2;
        this.f11363ra = j2;
        this.f11360q9 = z3;
        this.f11337d = vVar;
        this.f11354n = pqVar.n3();
        this.f11334c = pqVar.y();
        bv i92 = bv.i9(rzVar);
        this.f11349j = i92;
        this.f11358oz = new v(i92);
        this.f11347fb = new k3[zqVarArr.length];
        for (int i5 = 0; i5 < zqVarArr.length; i5++) {
            zqVarArr[i5].f(i5, u0Var);
            this.f11347fb[i5] = zqVarArr[i5].gv();
        }
        this.f11338d0 = new t(this, vVar);
        this.f11348fh = new ArrayList<>();
        this.f11369v = z0.q9.s();
        this.f11362r = new hy.gv();
        this.f11345f3 = new hy.n3();
        fhVar.a(this, aVar);
        this.f11353lc = true;
        v5.p n32 = vVar.n3(looper, null);
        this.f11371x = new vp(yVar, n32);
        this.f11333b = new j3(this, yVar, n32, u0Var);
        if (looper2 != null) {
            this.f11335co = null;
            this.f11374z = looper2;
        } else {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
            this.f11335co = handlerThread;
            handlerThread.start();
            this.f11374z = handlerThread.getLooper();
        }
        this.f11359p = vVar.n3(this.f11374z, this);
    }

    @Nullable
    public static Pair<Object, Long> bk(hy hyVar, s sVar, boolean z2, int i, boolean z3, hy.gv gvVar, hy.n3 n3Var) {
        hy hyVar2;
        Pair<Object, Long> wz2;
        Object y42;
        hy hyVar3 = sVar.y;
        if (hyVar.r()) {
            return null;
        }
        if (hyVar3.r()) {
            hyVar2 = hyVar;
        } else {
            hyVar2 = hyVar3;
        }
        try {
            wz2 = hyVar2.wz(gvVar, n3Var, sVar.f11386n3, sVar.f11387zn);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (hyVar.equals(hyVar2)) {
            return wz2;
        }
        if (hyVar.a(wz2.first) != -1) {
            if (hyVar2.t(wz2.first, n3Var).f10830t && hyVar2.mt(n3Var.f10828fb, gvVar).f10808d0 == hyVar2.a(wz2.first)) {
                return hyVar.wz(gvVar, n3Var, hyVar.t(wz2.first, n3Var).f10828fb, sVar.f11387zn);
            }
            return wz2;
        }
        if (z2 && (y42 = y4(gvVar, n3Var, i, z3, wz2.first, hyVar2, hyVar)) != null) {
            return hyVar.wz(gvVar, n3Var, hyVar.t(y42, n3Var).f10828fb, -9223372036854775807L);
        }
        return null;
    }

    public static m[] f3(zo.co coVar) {
        int i;
        if (coVar != null) {
            i = coVar.length();
        } else {
            i = 0;
        }
        m[] mVarArr = new m[i];
        for (int i5 = 0; i5 < i; i5++) {
            mVarArr[i5] = coVar.a(i5);
        }
        return mVarArr;
    }

    public static void g3(hy hyVar, gv gvVar, hy.gv gvVar2, hy.n3 n3Var) {
        long j2;
        int i = hyVar.mt(hyVar.t(gvVar.f11381s, n3Var).f10828fb, gvVar2).f10812fh;
        Object obj = hyVar.f(i, n3Var, true).f10831v;
        long j4 = n3Var.f10829s;
        if (j4 != -9223372036854775807L) {
            j2 = j4 - 1;
        } else {
            j2 = Long.MAX_VALUE;
        }
        gvVar.n3(i, j2, obj);
    }

    public static boolean j5(zq zqVar) {
        if (zqVar.getState() != 0) {
            return true;
        }
        return false;
    }

    public static boolean m(gv gvVar, hy hyVar, hy hyVar2, int i, boolean z2, hy.gv gvVar2, hy.n3 n3Var) {
        long xb2;
        Object obj = gvVar.f11381s;
        if (obj == null) {
            if (gvVar.y.a() == Long.MIN_VALUE) {
                xb2 = -9223372036854775807L;
            } else {
                xb2 = v5.j5.xb(gvVar.y.a());
            }
            Pair<Object, Long> bk2 = bk(hyVar, new s(gvVar.y.s(), gvVar.y.gv(), xb2), false, i, z2, gvVar2, n3Var);
            if (bk2 == null) {
                return false;
            }
            gvVar.n3(hyVar.a(bk2.first), ((Long) bk2.second).longValue(), bk2.first);
            if (gvVar.y.a() == Long.MIN_VALUE) {
                g3(hyVar, gvVar, gvVar2, n3Var);
            }
            return true;
        }
        int a2 = hyVar.a(obj);
        if (a2 == -1) {
            return false;
        }
        if (gvVar.y.a() == Long.MIN_VALUE) {
            g3(hyVar, gvVar, gvVar2, n3Var);
            return true;
        }
        gvVar.f11382v = a2;
        hyVar2.t(gvVar.f11381s, n3Var);
        if (n3Var.f10830t && hyVar2.mt(n3Var.f10828fb, gvVar2).f10808d0 == hyVar2.a(gvVar.f11381s)) {
            Pair<Object, Long> wz2 = hyVar.wz(gvVar2, n3Var, hyVar.t(gvVar.f11381s, n3Var).f10828fb, gvVar.f11380fb + n3Var.p());
            gvVar.n3(hyVar.a(wz2.first), ((Long) wz2.second).longValue(), wz2.first);
        }
        return true;
    }

    public static boolean o(bv bvVar, hy.n3 n3Var) {
        mg.n3 n3Var2 = bvVar.f10594n3;
        hy hyVar = bvVar.y;
        if (!hyVar.r() && !hyVar.t(n3Var2.y, n3Var).f10830t) {
            return false;
        }
        return true;
    }

    private void ra() {
        yc(true, false, true, false);
        this.f11366t.fb();
        j3(1);
        HandlerThread handlerThread = this.f11335co;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        synchronized (this) {
            this.f11368ut = true;
            notifyAll();
        }
    }

    public static fb u0(hy hyVar, bv bvVar, @Nullable s sVar, vp vpVar, int i, boolean z2, hy.gv gvVar, hy.n3 n3Var) {
        long j2;
        int i5;
        mg.n3 n3Var2;
        long j4;
        int i6;
        boolean z3;
        boolean z4;
        boolean z5;
        int i8;
        int i10;
        boolean z7;
        vp vpVar2;
        long j6;
        boolean z8;
        int i11;
        boolean z9;
        int i12;
        boolean z10;
        boolean z11;
        if (hyVar.r()) {
            return new fb(bv.f(), 0L, -9223372036854775807L, false, true, false);
        }
        mg.n3 n3Var3 = bvVar.f10594n3;
        Object obj = n3Var3.y;
        boolean o2 = o(bvVar, n3Var);
        if (!bvVar.f10594n3.n3() && !o2) {
            j2 = bvVar.f10593mt;
        } else {
            j2 = bvVar.f10603zn;
        }
        long j7 = j2;
        boolean z12 = true;
        if (sVar != null) {
            i5 = -1;
            Pair<Object, Long> bk2 = bk(hyVar, sVar, true, i, z2, gvVar, n3Var);
            if (bk2 == null) {
                i12 = hyVar.v(z2);
                j4 = j7;
                z9 = false;
                z10 = false;
                z11 = true;
            } else {
                if (sVar.f11387zn == -9223372036854775807L) {
                    i12 = hyVar.t(bk2.first, n3Var).f10828fb;
                    j4 = j7;
                    z9 = false;
                } else {
                    obj = bk2.first;
                    j4 = ((Long) bk2.second).longValue();
                    z9 = true;
                    i12 = -1;
                }
                if (bvVar.f10599v == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 = false;
            }
            z5 = z9;
            z3 = z10;
            z4 = z11;
            i6 = i12;
            n3Var2 = n3Var3;
        } else {
            i5 = -1;
            if (bvVar.y.r()) {
                i8 = hyVar.v(z2);
            } else if (hyVar.a(obj) == -1) {
                Object y42 = y4(gvVar, n3Var, i, z2, obj, bvVar.y, hyVar);
                if (y42 == null) {
                    i10 = hyVar.v(z2);
                    z7 = true;
                } else {
                    i10 = hyVar.t(y42, n3Var).f10828fb;
                    z7 = false;
                }
                i6 = i10;
                z4 = z7;
                j4 = j7;
                n3Var2 = n3Var3;
                z3 = false;
                z5 = false;
            } else if (j7 == -9223372036854775807L) {
                i8 = hyVar.t(obj, n3Var).f10828fb;
            } else if (o2) {
                n3Var2 = n3Var3;
                bvVar.y.t(n3Var2.y, n3Var);
                if (bvVar.y.mt(n3Var.f10828fb, gvVar).f10808d0 == bvVar.y.a(n3Var2.y)) {
                    Pair<Object, Long> wz2 = hyVar.wz(gvVar, n3Var, hyVar.t(obj, n3Var).f10828fb, j7 + n3Var.p());
                    obj = wz2.first;
                    j4 = ((Long) wz2.second).longValue();
                } else {
                    j4 = j7;
                }
                i6 = -1;
                z3 = false;
                z4 = false;
                z5 = true;
            } else {
                n3Var2 = n3Var3;
                j4 = j7;
                i6 = -1;
                z3 = false;
                z4 = false;
                z5 = false;
            }
            i6 = i8;
            j4 = j7;
            n3Var2 = n3Var3;
            z3 = false;
            z4 = false;
            z5 = false;
        }
        if (i6 != i5) {
            Pair<Object, Long> wz3 = hyVar.wz(gvVar, n3Var, i6, -9223372036854775807L);
            obj = wz3.first;
            j4 = ((Long) wz3.second).longValue();
            vpVar2 = vpVar;
            j6 = -9223372036854775807L;
        } else {
            vpVar2 = vpVar;
            j6 = j4;
        }
        mg.n3 fh2 = vpVar2.fh(hyVar, obj, j4);
        int i13 = fh2.f240v;
        if (i13 != i5 && ((i11 = n3Var2.f240v) == i5 || i13 < i11)) {
            z8 = false;
        } else {
            z8 = true;
        }
        z12 = (!n3Var2.y.equals(obj) || n3Var2.n3() || fh2.n3() || !z8) ? false : false;
        Object obj2 = n3Var2;
        boolean vl2 = vl(o2, n3Var2, j7, fh2, hyVar.t(obj, n3Var), j6);
        if (z12 || vl2) {
            fh2 = obj2;
        }
        if (fh2.n3()) {
            if (fh2.equals(obj2)) {
                j4 = bvVar.f10593mt;
            } else {
                hyVar.t(fh2.y, n3Var);
                if (fh2.f241zn == n3Var.wz(fh2.f239n3)) {
                    j4 = n3Var.i9();
                } else {
                    j4 = 0;
                }
            }
        }
        return new fb(fh2, j4, j6, z3, z4, z5);
    }

    public static boolean vl(boolean z2, mg.n3 n3Var, long j2, mg.n3 n3Var2, hy.n3 n3Var3, long j4) {
        if (z2 || j2 != j4 || !n3Var.y.equals(n3Var2.y)) {
            return false;
        }
        if (n3Var.n3() && n3Var3.z(n3Var.f239n3)) {
            if (n3Var3.f(n3Var.f239n3, n3Var.f241zn) == 4 || n3Var3.f(n3Var.f239n3, n3Var.f241zn) == 2) {
                return false;
            }
            return true;
        } else if (!n3Var2.n3() || !n3Var3.z(n3Var2.f239n3)) {
            return false;
        } else {
            return true;
        }
    }

    @Nullable
    public static Object y4(hy.gv gvVar, hy.n3 n3Var, int i, boolean z2, Object obj, hy hyVar, hy hyVar2) {
        int a2 = hyVar.a(obj);
        int tl2 = hyVar.tl();
        int i5 = a2;
        int i6 = -1;
        for (int i8 = 0; i8 < tl2 && i6 == -1; i8++) {
            i5 = hyVar.s(i5, n3Var, gvVar, i, z2);
            if (i5 == -1) {
                break;
            }
            i6 = hyVar2.a(hyVar.p(i5));
        }
        if (i6 == -1) {
            return null;
        }
        return hyVar2.p(i6);
    }

    public final void a8(br brVar, float f4, boolean z2, boolean z3) throws p {
        zq[] zqVarArr;
        if (z2) {
            if (z3) {
                this.f11358oz.n3(1);
            }
            this.f11349j = this.f11349j.a(brVar);
        }
        ia(brVar.y);
        for (zq zqVar : this.y) {
            if (zqVar != null) {
                zqVar.p(f4, brVar.y);
            }
        }
    }

    public final void ad(c8 c8Var) throws p {
        if (c8Var.zn() == this.f11374z) {
            wz(c8Var);
            int i = this.f11349j.f10599v;
            if (i == 3 || i == 2) {
                this.f11359p.i9(2);
                return;
            }
            return;
        }
        this.f11359p.gv(15, c8Var).y();
    }

    public final boolean ap() throws p {
        boolean z2;
        qj p2 = this.f11371x.p();
        zo.rz xc2 = p2.xc();
        int i = 0;
        boolean z3 = false;
        while (true) {
            zq[] zqVarArr = this.y;
            if (i < zqVarArr.length) {
                zq zqVar = zqVarArr[i];
                if (j5(zqVar)) {
                    if (zqVar.getStream() != p2.f11133zn[i]) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!xc2.zn(i) || z2) {
                        if (!zqVar.xc()) {
                            zqVar.mt(f3(xc2.f15774zn[i]), p2.f11133zn[i], p2.tl(), p2.t());
                        } else if (zqVar.a()) {
                            xc(zqVar);
                        } else {
                            z3 = true;
                        }
                    }
                }
                i++;
            } else {
                return !z3;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckResult
    public final bv b(mg.n3 n3Var, long j2, long j4, long j6, boolean z2, int i) {
        boolean z3;
        List list;
        af.lc lcVar;
        zo.rz rzVar;
        af.lc wz2;
        zo.rz xc2;
        if (!this.f11353lc && j2 == this.f11349j.f10593mt && n3Var.equals(this.f11349j.f10594n3)) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.f11353lc = z3;
        kp();
        bv bvVar = this.f11349j;
        af.lc lcVar2 = bvVar.f10596s;
        zo.rz rzVar2 = bvVar.f10588c5;
        List list2 = bvVar.f10592i9;
        if (this.f11333b.co()) {
            qj w4 = this.f11371x.w();
            if (w4 == null) {
                wz2 = af.lc.f327s;
            } else {
                wz2 = w4.wz();
            }
            if (w4 == null) {
                xc2 = this.f11344f;
            } else {
                xc2 = w4.xc();
            }
            List x42 = x4(xc2.f15774zn);
            if (w4 != null) {
                l lVar = w4.f11120a;
                if (lVar.f10903zn != j4) {
                    w4.f11120a = lVar.y(j4);
                }
            }
            lcVar = wz2;
            rzVar = xc2;
            list = x42;
        } else if (!n3Var.equals(this.f11349j.f10594n3)) {
            af.lc lcVar3 = af.lc.f327s;
            lcVar = lcVar3;
            rzVar = this.f11344f;
            list = z0.x4.j5();
        } else {
            list = list2;
            lcVar = lcVar2;
            rzVar = rzVar2;
        }
        if (z2) {
            this.f11358oz.v(i);
        }
        return this.f11349j.zn(n3Var, j2, j4, j6, rz(), lcVar, rzVar, list);
    }

    public final void br(boolean z2, boolean z3) {
        boolean z4;
        if (!z2 && this.f11373y5) {
            z4 = false;
        } else {
            z4 = true;
        }
        yc(z4, false, true, false);
        this.f11358oz.n3(z3 ? 1 : 0);
        this.f11366t.a();
        j3(1);
    }

    public final void bv() throws p {
        zq[] zqVarArr;
        this.f11346f7 = false;
        this.f11338d0.fb();
        for (zq zqVar : this.y) {
            if (j5(zqVar)) {
                zqVar.start();
            }
        }
    }

    public final long c() {
        qj p2 = this.f11371x.p();
        if (p2 == null) {
            return 0L;
        }
        long t2 = p2.t();
        if (!p2.f11124gv) {
            return t2;
        }
        int i = 0;
        while (true) {
            zq[] zqVarArr = this.y;
            if (i < zqVarArr.length) {
                if (j5(zqVarArr[i]) && this.y[i].getStream() == p2.f11133zn[i]) {
                    long r2 = this.y[i].r();
                    if (r2 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    t2 = Math.max(r2, t2);
                }
                i++;
            } else {
                return t2;
            }
        }
    }

    public final void c5(n3 n3Var, int i) throws p {
        this.f11358oz.n3(1);
        j3 j3Var = this.f11333b;
        if (i == -1) {
            i = j3Var.p();
        }
        ej(j3Var.a(i, n3Var.y, n3Var.f11384n3), false);
    }

    public final void c8() throws p {
        long j2;
        boolean z2;
        qj w4 = this.f11371x.w();
        if (w4 == null) {
            return;
        }
        if (w4.f11124gv) {
            j2 = w4.y.i9();
        } else {
            j2 = -9223372036854775807L;
        }
        if (j2 != -9223372036854775807L) {
            rb(j2);
            if (j2 != this.f11349j.f10593mt) {
                bv bvVar = this.f11349j;
                this.f11349j = b(bvVar.f10594n3, j2, bvVar.f10603zn, j2, true, 5);
            }
        } else {
            t tVar = this.f11338d0;
            if (w4 != this.f11371x.p()) {
                z2 = true;
            } else {
                z2 = false;
            }
            long c52 = tVar.c5(z2);
            this.f11364rs = c52;
            long n2 = w4.n(c52);
            k(this.f11349j.f10593mt, n2);
            this.f11349j.f10593mt = n2;
        }
        this.f11349j.f10600w = this.f11371x.i9().c5();
        this.f11349j.f10595p = rz();
        bv bvVar2 = this.f11349j;
        if (bvVar2.f10597t && bvVar2.f10599v == 3 && gf(bvVar2.y, bvVar2.f10594n3) && this.f11349j.f10601wz.y == 1.0f) {
            float n32 = this.f11350j5.n3(i4(), rz());
            if (this.f11338d0.v().y != n32) {
                gq(this.f11349j.f10601wz.gv(n32));
                a8(this.f11349j.f10601wz, this.f11338d0.v().y, false, false);
            }
        }
    }

    public final void co(boolean[] zArr) throws p {
        qj p2 = this.f11371x.p();
        zo.rz xc2 = p2.xc();
        for (int i = 0; i < this.y.length; i++) {
            if (!xc2.zn(i) && this.f11369v.remove(this.y[i])) {
                this.y[i].y();
            }
        }
        for (int i5 = 0; i5 < this.y.length; i5++) {
            if (xc2.zn(i5)) {
                p(i5, zArr[i5]);
            }
        }
        p2.f11123fb = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab A[Catch: all -> 0x00ae, TryCatch #1 {all -> 0x00ae, blocks: (B:22:0x00a1, B:24:0x00ab, B:29:0x00b5, B:31:0x00bb, B:32:0x00be, B:34:0x00c4, B:36:0x00ce, B:38:0x00d6, B:42:0x00de, B:44:0x00e8, B:46:0x00f8, B:50:0x0102, B:54:0x0114, B:58:0x011d), top: B:74:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void cr(m1.yc.s r20) throws m1.p {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.yc.cr(m1.yc$s):void");
    }

    public void cs(int i) {
        this.f11359p.fb(11, i, 0).y();
    }

    public final void ct(boolean z2) {
        zo.co[] coVarArr;
        for (qj w4 = this.f11371x.w(); w4 != null; w4 = w4.i9()) {
            for (zo.co coVar : w4.xc().f15774zn) {
                if (coVar != null) {
                    coVar.w(z2);
                }
            }
        }
    }

    public final void cy(final c8 c8Var) {
        Looper zn2 = c8Var.zn();
        if (!zn2.getThread().isAlive()) {
            v5.r.c5("TAG", "Trying to send message on a dead thread.");
            c8Var.f(false);
            return;
        }
        this.f11337d.n3(zn2, null).c5(new Runnable() { // from class: m1.yg
            @Override // java.lang.Runnable
            public final void run() {
                yc.this.oz(c8Var);
            }
        });
    }

    public final void d(IOException iOException, int i) {
        p co2 = p.co(iOException, i);
        qj w4 = this.f11371x.w();
        if (w4 != null) {
            co2 = co2.p(w4.f11120a.y);
        }
        v5.r.gv("ExoPlayerImplInternal", "Playback error", co2);
        br(false, false);
        this.f11349j = this.f11349j.v(co2);
    }

    public final Pair<mg.n3, Long> d0(hy hyVar) {
        long j2 = 0;
        if (hyVar.r()) {
            return Pair.create(bv.f(), 0L);
        }
        Pair<Object, Long> wz2 = hyVar.wz(this.f11362r, this.f11345f3, hyVar.v(this.f11367u), -9223372036854775807L);
        mg.n3 fh2 = this.f11371x.fh(hyVar, wz2.first, 0L);
        long longValue = ((Long) wz2.second).longValue();
        if (fh2.n3()) {
            hyVar.t(fh2.y, this.f11345f3);
            if (fh2.f241zn == this.f11345f3.wz(fh2.f239n3)) {
                j2 = this.f11345f3.i9();
            }
            longValue = j2;
        }
        return Pair.create(fh2, Long.valueOf(longValue));
    }

    public final void dm() {
        zo.co[] coVarArr;
        for (qj w4 = this.f11371x.w(); w4 != null; w4 = w4.i9()) {
            for (zo.co coVar : w4.xc().f15774zn) {
                if (coVar != null) {
                    coVar.t();
                }
            }
        }
    }

    public final void e(int i, int i5, af.u uVar) throws p {
        this.f11358oz.n3(1);
        ej(this.f11333b.d0(i, i5, uVar), false);
    }

    public void eb() {
        this.f11359p.y(0).y();
    }

    /* JADX WARN: Not initialized variable reg: 25, insn: 0x007c: MOVE  (r5 I:??[long, double]) = (r25 I:??[long, double]), block:B:26:0x007b */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ej(m1.hy r28, boolean r29) throws m1.p {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.yc.ej(m1.hy, boolean):void");
    }

    public final void en() throws p {
        boolean z2;
        boolean z3 = false;
        while (ne()) {
            if (z3) {
                q9();
            }
            qj qjVar = (qj) v5.y.v(this.f11371x.n3());
            if (this.f11349j.f10594n3.y.equals(qjVar.f11120a.y.y)) {
                mg.n3 n3Var = this.f11349j.f10594n3;
                if (n3Var.f239n3 == -1) {
                    mg.n3 n3Var2 = qjVar.f11120a.y;
                    if (n3Var2.f239n3 == -1 && n3Var.f240v != n3Var2.f240v) {
                        z2 = true;
                        l lVar = qjVar.f11120a;
                        mg.n3 n3Var3 = lVar.y;
                        long j2 = lVar.f10900n3;
                        this.f11349j = b(n3Var3, j2, lVar.f10903zn, j2, !z2, 0);
                        kp();
                        c8();
                        z3 = true;
                    }
                }
            }
            z2 = false;
            l lVar2 = qjVar.f11120a;
            mg.n3 n3Var32 = lVar2.y;
            long j22 = lVar2.f10900n3;
            this.f11349j = b(n3Var32, j22, lVar2.f10903zn, j22, !z2, 0);
            kp();
            c8();
            z3 = true;
        }
    }

    public final void f() throws p {
        pq(true);
    }

    public final void f7() throws p {
        l xc2;
        this.f11371x.n(this.f11364rs);
        if (this.f11371x.mg() && (xc2 = this.f11371x.xc(this.f11364rs, this.f11349j)) != null) {
            qj fb2 = this.f11371x.fb(this.f11347fb, this.f11365s, this.f11366t.v(), this.f11333b, xc2, this.f11344f);
            fb2.y.co(this, xc2.f10900n3);
            if (this.f11371x.w() == fb2) {
                rb(xc2.f10900n3);
            }
            z6(false);
        }
        if (this.f11343en) {
            this.f11343en = hw();
            im();
            return;
        }
        ut();
    }

    public void fc() {
        this.f11359p.y(6).y();
    }

    public Looper fh() {
        return this.f11374z;
    }

    public final void g(hy hyVar, hy hyVar2) {
        if (hyVar.r() && hyVar2.r()) {
            return;
        }
        for (int size = this.f11348fh.size() - 1; size >= 0; size--) {
            if (!m(this.f11348fh.get(size), hyVar, hyVar2, this.f11351jz, this.f11367u, this.f11362r, this.f11345f3)) {
                this.f11348fh.get(size).y.f(false);
                this.f11348fh.remove(size);
            }
        }
        Collections.sort(this.f11348fh);
    }

    public final boolean gf(hy hyVar, mg.n3 n3Var) {
        if (n3Var.n3() || hyVar.r()) {
            return false;
        }
        hyVar.mt(hyVar.t(n3Var.y, this.f11345f3).f10828fb, this.f11362r);
        if (!this.f11362r.s()) {
            return false;
        }
        hy.gv gvVar = this.f11362r;
        if (!gvVar.f10806co || gvVar.f10817t == -9223372036854775807L) {
            return false;
        }
        return true;
    }

    public final void gq(br brVar) {
        this.f11359p.t(16);
        this.f11338d0.zn(brVar);
    }

    @Override // m1.c8.y
    public synchronized void gv(c8 c8Var) {
        if (!this.f11368ut && this.f11374z.getThread().isAlive()) {
            this.f11359p.gv(14, c8Var).y();
            return;
        }
        v5.r.c5("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        c8Var.f(false);
    }

    public final void h(hy hyVar, mg.n3 n3Var, hy hyVar2, mg.n3 n3Var2, long j2, boolean z2) throws p {
        Object obj;
        br brVar;
        if (!gf(hyVar, n3Var)) {
            if (n3Var.n3()) {
                brVar = br.f10581s;
            } else {
                brVar = this.f11349j.f10601wz;
            }
            if (!this.f11338d0.v().equals(brVar)) {
                gq(brVar);
                a8(this.f11349j.f10601wz, brVar.y, false, false);
                return;
            }
            return;
        }
        hyVar.mt(hyVar.t(n3Var.y, this.f11345f3).f10828fb, this.f11362r);
        this.f11350j5.y((o0.fb) v5.j5.i9(this.f11362r.f10815r));
        if (j2 != -9223372036854775807L) {
            this.f11350j5.v(n(hyVar, n3Var.y, j2));
            return;
        }
        Object obj2 = this.f11362r.y;
        if (!hyVar2.r()) {
            obj = hyVar2.mt(hyVar2.t(n3Var2.y, this.f11345f3).f10828fb, this.f11362r).y;
        } else {
            obj = null;
        }
        if (!v5.j5.zn(obj, obj2) || z2) {
            this.f11350j5.v(-9223372036854775807L);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        qj p2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        int i = 1000;
        try {
            switch (message.what) {
                case 0:
                    lc();
                    break;
                case 1:
                    if (message.arg1 != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    q5(z2, message.arg2, true, 1);
                    break;
                case 2:
                    w();
                    break;
                case 3:
                    cr((s) message.obj);
                    break;
                case 4:
                    le((br) message.obj);
                    break;
                case 5:
                    yk((vc) message.obj);
                    break;
                case 6:
                    br(false, true);
                    break;
                case 7:
                    ra();
                    return true;
                case 8:
                    ud((af.d0) message.obj);
                    break;
                case 9:
                    ta((af.d0) message.obj);
                    break;
                case 10:
                    yg();
                    break;
                case 11:
                    ro(message.arg1);
                    break;
                case 12:
                    if (message.arg1 != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    i3(z3);
                    break;
                case 13:
                    if (message.arg1 != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    l(z4, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    wf((c8) message.obj);
                    break;
                case 15:
                    cy((c8) message.obj);
                    break;
                case 16:
                    x((br) message.obj, false);
                    break;
                case 17:
                    vp((n3) message.obj);
                    break;
                case 18:
                    c5((n3) message.obj, message.arg1);
                    break;
                case 19:
                    xg((zn) message.obj);
                    break;
                case 20:
                    e(message.arg1, message.arg2, (af.u) message.obj);
                    break;
                case 21:
                    vn((af.u) message.obj);
                    break;
                case 22:
                    y5();
                    break;
                case 23:
                    if (message.arg1 != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    w2(z5);
                    break;
                case 24:
                    if (message.arg1 == 1) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    w9(z7);
                    break;
                case 25:
                    f();
                    break;
                default:
                    return false;
            }
        } catch (af.n3 e2) {
            d(e2, 1002);
        } catch (gv.y e3) {
            d(e3, e3.errorCode);
        } catch (RuntimeException e5) {
            p x42 = p.x4(e5, ((e5 instanceof IllegalStateException) || (e5 instanceof IllegalArgumentException)) ? 1004 : 1004);
            v5.r.gv("ExoPlayerImplInternal", "Playback error", x42);
            br(true, false);
            this.f11349j = this.f11349j.v(x42);
        } catch (kx.wz e6) {
            d(e6, e6.reason);
        } catch (ne e8) {
            int i5 = e8.dataType;
            if (i5 == 1) {
                if (e8.contentIsMalformed) {
                    i = 3001;
                } else {
                    i = 3003;
                }
            } else if (i5 == 4) {
                if (e8.contentIsMalformed) {
                    i = 3002;
                } else {
                    i = 3004;
                }
            }
            d(e8, i);
        } catch (IOException e9) {
            d(e9, 2000);
        } catch (p e10) {
            e = e10;
            if (e.type == 1 && (p2 = this.f11371x.p()) != null) {
                e = e.p(p2.f11120a.y);
            }
            if (e.isRecoverable && this.f11355nf == null) {
                v5.r.i9("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.f11355nf = e;
                v5.p pVar = this.f11359p;
                pVar.s(pVar.gv(25, e));
            } else {
                p pVar2 = this.f11355nf;
                if (pVar2 != null) {
                    pVar2.addSuppressed(e);
                    e = this.f11355nf;
                }
                v5.r.gv("ExoPlayerImplInternal", "Playback error", e);
                br(true, false);
                this.f11349j = this.f11349j.v(e);
            }
        }
        q9();
        return true;
    }

    public final boolean hw() {
        qj i92 = this.f11371x.i9();
        if (i92 == null || i92.f() == Long.MIN_VALUE) {
            return false;
        }
        return true;
    }

    public void i2(boolean z2) {
        this.f11359p.fb(12, z2 ? 1 : 0, 0).y();
    }

    public final void i3(boolean z2) throws p {
        this.f11367u = z2;
        if (!this.f11371x.ej(this.f11349j.y, z2)) {
            pq(true);
        }
        z6(false);
    }

    public final long i4() {
        bv bvVar = this.f11349j;
        return n(bvVar.y, bvVar.f10594n3.y, bvVar.f10593mt);
    }

    public void i9(int i, List<j3.zn> list, af.u uVar) {
        this.f11359p.zn(18, i, 0, new n3(list, uVar, -1, -9223372036854775807L, null)).y();
    }

    public final void ia(float f4) {
        zo.co[] coVarArr;
        for (qj w4 = this.f11371x.w(); w4 != null; w4 = w4.i9()) {
            for (zo.co coVar : w4.xc().f15774zn) {
                if (coVar != null) {
                    coVar.i9(f4);
                }
            }
        }
    }

    public final void im() {
        boolean z2;
        qj i92 = this.f11371x.i9();
        if (!this.f11343en && (i92 == null || !i92.y.y())) {
            z2 = false;
        } else {
            z2 = true;
        }
        bv bvVar = this.f11349j;
        if (z2 != bvVar.f10590fb) {
            this.f11349j = bvVar.y(z2);
        }
    }

    public void ix(vc vcVar) {
        this.f11359p.gv(5, vcVar).y();
    }

    public final /* synthetic */ Boolean j() {
        return Boolean.valueOf(this.f11368ut);
    }

    public final void j3(int i) {
        bv bvVar = this.f11349j;
        if (bvVar.f10599v != i) {
            if (i != 2) {
                this.f11340e = -9223372036854775807L;
            }
            this.f11349j = bvVar.fb(i);
        }
    }

    public final void jz() throws p {
        long j2;
        boolean z2;
        qj p2 = this.f11371x.p();
        if (p2 == null) {
            return;
        }
        int i = 0;
        if (p2.i9() != null && !this.f11352k) {
            if (!yt()) {
                return;
            }
            if (!p2.i9().f11124gv && this.f11364rs < p2.i9().tl()) {
                return;
            }
            zo.rz xc2 = p2.xc();
            qj zn2 = this.f11371x.zn();
            zo.rz xc3 = zn2.xc();
            hy hyVar = this.f11349j.y;
            h(hyVar, zn2.f11120a.y, hyVar, p2.f11120a.y, -9223372036854775807L, false);
            if (zn2.f11124gv && zn2.y.i9() != -9223372036854775807L) {
                qk(zn2.tl());
                return;
            }
            for (int i5 = 0; i5 < this.y.length; i5++) {
                boolean zn3 = xc2.zn(i5);
                boolean zn4 = xc3.zn(i5);
                if (zn3 && !this.y[i5].xc()) {
                    if (this.f11347fb[i5].s() == -2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    ic icVar = xc2.f15772n3[i5];
                    ic icVar2 = xc3.f15772n3[i5];
                    if (!zn4 || !icVar2.equals(icVar) || z2) {
                        qj(this.y[i5], zn2.tl());
                    }
                }
            }
        } else if (p2.f11120a.f10897c5 || this.f11352k) {
            while (true) {
                zq[] zqVarArr = this.y;
                if (i < zqVarArr.length) {
                    zq zqVar = zqVarArr[i];
                    af.en enVar = p2.f11133zn[i];
                    if (enVar != null && zqVar.getStream() == enVar && zqVar.c5()) {
                        long j4 = p2.f11120a.f10902v;
                        if (j4 != -9223372036854775807L && j4 != Long.MIN_VALUE) {
                            j2 = p2.t() + p2.f11120a.f10902v;
                        } else {
                            j2 = -9223372036854775807L;
                        }
                        qj(zqVar, j2);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0095 A[LOOP:1: B:29:0x0079->B:39:0x0095, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0078 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0078 -> B:29:0x0079). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(long r9, long r11) throws m1.p {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.yc.k(long, long):void");
    }

    public final boolean k5(zq zqVar, qj qjVar) {
        qj i92 = qjVar.i9();
        if (qjVar.f11120a.f10896a && i92.f11124gv && ((zqVar instanceof qh.p) || (zqVar instanceof com.google.android.exoplayer2.metadata.y) || zqVar.r() >= i92.tl())) {
            return true;
        }
        return false;
    }

    public final void kp() {
        boolean z2;
        qj w4 = this.f11371x.w();
        if (w4 != null && w4.f11120a.f10901s && this.f11360q9) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f11352k = z2;
    }

    public final void l(boolean z2, @Nullable AtomicBoolean atomicBoolean) {
        zq[] zqVarArr;
        if (this.f11373y5 != z2) {
            this.f11373y5 = z2;
            if (!z2) {
                for (zq zqVar : this.y) {
                    if (!j5(zqVar) && this.f11369v.remove(zqVar)) {
                        zqVar.y();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    public final void lc() {
        int i;
        this.f11358oz.n3(1);
        yc(false, false, false, true);
        this.f11366t.onPrepared();
        if (this.f11349j.y.r()) {
            i = 4;
        } else {
            i = 2;
        }
        j3(i);
        this.f11333b.i4(this.f11370w.zn());
        this.f11359p.i9(2);
    }

    public final void le(br brVar) throws p {
        gq(brVar);
        x(this.f11338d0.v(), true);
    }

    public final long mg(long j2) {
        qj i92 = this.f11371x.i9();
        if (i92 == null) {
            return 0L;
        }
        return Math.max(0L, j2 - i92.n(this.f11364rs));
    }

    public final void mh(af.lc lcVar, zo.rz rzVar) {
        this.f11366t.zn(this.y, lcVar, rzVar.f15774zn);
    }

    public void mp(br brVar) {
        this.f11359p.gv(4, brVar).y();
    }

    public final void mt() throws p {
        co(new boolean[this.y.length]);
    }

    public final long n(hy hyVar, Object obj, long j2) {
        hyVar.mt(hyVar.t(obj, this.f11345f3).f10828fb, this.f11362r);
        hy.gv gvVar = this.f11362r;
        if (gvVar.f10817t != -9223372036854775807L && gvVar.s()) {
            hy.gv gvVar2 = this.f11362r;
            if (gvVar2.f10806co) {
                return v5.j5.xb(gvVar2.zn() - this.f11362r.f10817t) - (j2 + this.f11345f3.p());
            }
        }
        return -9223372036854775807L;
    }

    @Override // af.d0.y
    public void n3(af.d0 d0Var) {
        this.f11359p.gv(8, d0Var).y();
    }

    public final void n7() throws p {
        if (!this.f11349j.y.r() && this.f11333b.co()) {
            f7();
            jz();
            u();
            en();
        }
    }

    public final boolean nd(boolean z2) {
        long j2;
        boolean z3;
        boolean z4;
        if (this.f11336ct == 0) {
            return qn();
        }
        if (!z2) {
            return false;
        }
        bv bvVar = this.f11349j;
        if (!bvVar.f10590fb) {
            return true;
        }
        if (gf(bvVar.y, this.f11371x.w().f11120a.y)) {
            j2 = this.f11350j5.zn();
        } else {
            j2 = -9223372036854775807L;
        }
        long j4 = j2;
        qj i92 = this.f11371x.i9();
        if (i92.p() && i92.f11120a.f10897c5) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (i92.f11120a.y.n3() && !i92.f11124gv) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z3 && !z4 && !this.f11366t.gv(rz(), this.f11338d0.v().y, this.f11346f7, j4)) {
            return false;
        }
        return true;
    }

    public final boolean ne() {
        qj w4;
        qj i92;
        if (!wm() || this.f11352k || (w4 = this.f11371x.w()) == null || (i92 = w4.i9()) == null || this.f11364rs < i92.tl() || !i92.f11123fb) {
            return false;
        }
        return true;
    }

    public synchronized boolean nf() {
        if (!this.f11368ut && this.f11374z.getThread().isAlive()) {
            this.f11359p.i9(7);
            r6(new w0.z() { // from class: m1.ap
                @Override // w0.z
                public final Object get() {
                    Boolean j2;
                    j2 = yc.this.j();
                    return j2;
                }
            }, this.f11361qn);
            return this.f11368ut;
        }
        return true;
    }

    public final long o0(mg.n3 n3Var, long j2, boolean z2) throws p {
        boolean z3;
        if (this.f11371x.w() != this.f11371x.p()) {
            z3 = true;
        } else {
            z3 = false;
        }
        return xb(n3Var, j2, z3, z2);
    }

    public final void o4() {
        zo.co[] coVarArr;
        for (qj w4 = this.f11371x.w(); w4 != null; w4 = w4.i9()) {
            for (zo.co coVar : w4.xc().f15774zn) {
                if (coVar != null) {
                    coVar.r();
                }
            }
        }
    }

    public void oa(List<j3.zn> list, int i, long j2, af.u uVar) {
        this.f11359p.gv(17, new n3(list, uVar, i, j2, null)).y();
    }

    @Override // m1.t.y
    public void onPlaybackParametersChanged(br brVar) {
        this.f11359p.gv(16, brVar).y();
    }

    public final /* synthetic */ void oz(c8 c8Var) {
        try {
            wz(c8Var);
        } catch (p e2) {
            v5.r.gv("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
            throw new RuntimeException(e2);
        }
    }

    public final void p(int i, boolean z2) throws p {
        boolean z3;
        boolean z4;
        boolean z5;
        zq zqVar = this.y[i];
        if (j5(zqVar)) {
            return;
        }
        qj p2 = this.f11371x.p();
        if (p2 == this.f11371x.w()) {
            z3 = true;
        } else {
            z3 = false;
        }
        zo.rz xc2 = p2.xc();
        ic icVar = xc2.f15772n3[i];
        m[] f32 = f3(xc2.f15774zn[i]);
        if (wm() && this.f11349j.f10599v == 3) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z2 && z4) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f11336ct++;
        this.f11369v.add(zqVar);
        zqVar.t(icVar, f32, p2.f11133zn[i], this.f11364rs, z5, z3, p2.tl(), p2.t());
        zqVar.tl(11, new y());
        this.f11338d0.n3(zqVar);
        if (z4) {
            zqVar.start();
        }
    }

    public final void pq(boolean z2) throws p {
        mg.n3 n3Var = this.f11371x.w().f11120a.y;
        long xb2 = xb(n3Var, this.f11349j.f10593mt, true, false);
        if (xb2 != this.f11349j.f10593mt) {
            bv bvVar = this.f11349j;
            this.f11349j = b(n3Var, xb2, bvVar.f10603zn, bvVar.f10591gv, z2, 5);
        }
    }

    public void pz(hy hyVar, int i, long j2) {
        this.f11359p.gv(3, new s(hyVar, i, j2)).y();
    }

    public final boolean q() {
        long n2;
        if (!hw()) {
            return false;
        }
        qj i92 = this.f11371x.i9();
        long mg2 = mg(i92.f());
        if (i92 == this.f11371x.w()) {
            n2 = i92.n(this.f11364rs);
        } else {
            n2 = i92.n(this.f11364rs) - i92.f11120a.f10900n3;
        }
        long j2 = n2;
        boolean s2 = this.f11366t.s(j2, mg2, this.f11338d0.v().y);
        if (!s2 && mg2 < 500000) {
            if (this.f11354n > 0 || this.f11334c) {
                this.f11371x.w().y.mt(this.f11349j.f10593mt, false);
                return this.f11366t.s(j2, mg2, this.f11338d0.v().y);
            }
            return s2;
        }
        return s2;
    }

    public final void q5(boolean z2, int i, boolean z3, int i5) throws p {
        this.f11358oz.n3(z3 ? 1 : 0);
        this.f11358oz.zn(i5);
        this.f11349j = this.f11349j.gv(z2, i);
        this.f11346f7 = false;
        ct(z2);
        if (!wm()) {
            uo();
            c8();
            return;
        }
        int i6 = this.f11349j.f10599v;
        if (i6 == 3) {
            bv();
            this.f11359p.i9(2);
        } else if (i6 == 2) {
            this.f11359p.i9(2);
        }
    }

    public final void q9() {
        this.f11358oz.gv(this.f11349j);
        if (this.f11358oz.y) {
            this.f11342ej.y(this.f11358oz);
            this.f11358oz = new v(this.f11349j);
        }
    }

    public final void qj(zq zqVar, long j2) {
        zqVar.i9();
        if (zqVar instanceof qh.p) {
            ((qh.p) zqVar).en(j2);
        }
    }

    public final void qk(long j2) {
        zq[] zqVarArr;
        for (zq zqVar : this.y) {
            if (zqVar.getStream() != null) {
                qj(zqVar, j2);
            }
        }
    }

    public final boolean qn() {
        qj w4 = this.f11371x.w();
        long j2 = w4.f11120a.f10902v;
        if (w4.f11124gv && (j2 == -9223372036854775807L || this.f11349j.f10593mt < j2 || !wm())) {
            return true;
        }
        return false;
    }

    public void r(long j2) {
        this.f11363ra = j2;
    }

    public final synchronized void r6(w0.z<Boolean> zVar, long j2) {
        long elapsedRealtime = this.f11337d.elapsedRealtime() + j2;
        boolean z2 = false;
        while (!zVar.get().booleanValue() && j2 > 0) {
            try {
                this.f11337d.zn();
                wait(j2);
            } catch (InterruptedException unused) {
                z2 = true;
            }
            j2 = elapsedRealtime - this.f11337d.elapsedRealtime();
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    public final void rb(long j2) throws p {
        long c2;
        zq[] zqVarArr;
        qj w4 = this.f11371x.w();
        if (w4 == null) {
            c2 = j2 + 1000000000000L;
        } else {
            c2 = w4.c(j2);
        }
        this.f11364rs = c2;
        this.f11338d0.gv(c2);
        for (zq zqVar : this.y) {
            if (j5(zqVar)) {
                zqVar.x4(this.f11364rs);
            }
        }
        dm();
    }

    public final void ro(int i) throws p {
        this.f11351jz = i;
        if (!this.f11371x.z6(this.f11349j.y, i)) {
            pq(true);
        }
        z6(false);
    }

    @Override // af.jz.y
    /* renamed from: rs */
    public void t(af.d0 d0Var) {
        this.f11359p.gv(9, d0Var).y();
    }

    public final long rz() {
        return mg(this.f11349j.f10600w);
    }

    public void s8(int i, int i5, af.u uVar) {
        this.f11359p.zn(20, i, i5, uVar).y();
    }

    public final void ta(af.d0 d0Var) {
        if (!this.f11371x.x4(d0Var)) {
            return;
        }
        this.f11371x.n(this.f11364rs);
        ut();
    }

    public final void tg(long j2, long j4) {
        this.f11359p.f(2, j2 + j4);
    }

    public final void u() throws p {
        qj p2 = this.f11371x.p();
        if (p2 != null && this.f11371x.w() != p2 && !p2.f11123fb && ap()) {
            mt();
        }
    }

    public final void ud(af.d0 d0Var) throws p {
        if (!this.f11371x.x4(d0Var)) {
            return;
        }
        qj i92 = this.f11371x.i9();
        i92.w(this.f11338d0.v().y, this.f11349j.y);
        mh(i92.wz(), i92.xc());
        if (i92 == this.f11371x.w()) {
            rb(i92.f11120a.f10900n3);
            mt();
            bv bvVar = this.f11349j;
            mg.n3 n3Var = bvVar.f10594n3;
            long j2 = i92.f11120a.f10900n3;
            this.f11349j = b(n3Var, j2, bvVar.f10603zn, j2, false, 5);
        }
        ut();
    }

    public final void uo() throws p {
        zq[] zqVarArr;
        this.f11338d0.s();
        for (zq zqVar : this.y) {
            if (j5(zqVar)) {
                z(zqVar);
            }
        }
    }

    public final void ut() {
        boolean q2 = q();
        this.f11343en = q2;
        if (q2) {
            this.f11371x.i9().gv(this.f11364rs);
        }
        im();
    }

    public final void vn(af.u uVar) throws p {
        this.f11358oz.n3(1);
        ej(this.f11333b.mg(uVar), false);
    }

    public final void vp(n3 n3Var) throws p {
        this.f11358oz.n3(1);
        if (n3Var.f11385zn != -1) {
            this.f11357o4 = new s(new h(n3Var.y, n3Var.f11384n3), n3Var.f11385zn, n3Var.f11383gv);
        }
        ej(this.f11333b.rz(n3Var.y, n3Var.f11384n3), false);
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x01c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w() throws m1.p, java.io.IOException {
        /*
            Method dump skipped, instructions count: 499
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.yc.w():void");
    }

    public final void w2(boolean z2) throws p {
        this.f11360q9 = z2;
        kp();
        if (this.f11352k && this.f11371x.p() != this.f11371x.w()) {
            pq(true);
            z6(false);
        }
    }

    public final void w9(boolean z2) {
        if (z2 == this.f11339dm) {
            return;
        }
        this.f11339dm = z2;
        if (!z2 && this.f11349j.f10602xc) {
            this.f11359p.i9(2);
        }
    }

    public final void wf(c8 c8Var) throws p {
        if (c8Var.a() == -9223372036854775807L) {
            ad(c8Var);
        } else if (this.f11349j.y.r()) {
            this.f11348fh.add(new gv(c8Var));
        } else {
            gv gvVar = new gv(c8Var);
            hy hyVar = this.f11349j.y;
            if (m(gvVar, hyVar, hyVar, this.f11351jz, this.f11367u, this.f11362r, this.f11345f3)) {
                this.f11348fh.add(gvVar);
                Collections.sort(this.f11348fh);
                return;
            }
            c8Var.f(false);
        }
    }

    public final boolean wm() {
        bv bvVar = this.f11349j;
        if (bvVar.f10597t && bvVar.f10598tl == 0) {
            return true;
        }
        return false;
    }

    public final void wz(c8 c8Var) throws p {
        if (c8Var.i9()) {
            return;
        }
        try {
            c8Var.fb().tl(c8Var.c5(), c8Var.v());
        } finally {
            c8Var.f(true);
        }
    }

    public final void x(br brVar, boolean z2) throws p {
        a8(brVar, brVar.y, true, z2);
    }

    public final z0.x4<Metadata> x4(zo.co[] coVarArr) {
        x4.y yVar = new x4.y();
        boolean z2 = false;
        for (zo.co coVar : coVarArr) {
            if (coVar != null) {
                Metadata metadata = coVar.a(0).f10972z;
                if (metadata == null) {
                    yVar.y(new Metadata(new Metadata.Entry[0]));
                } else {
                    yVar.y(metadata);
                    z2 = true;
                }
            }
        }
        if (z2) {
            return yVar.s();
        }
        return z0.x4.j5();
    }

    public void x5(boolean z2, int i) {
        this.f11359p.fb(1, z2 ? 1 : 0, i).y();
    }

    public final long xb(mg.n3 n3Var, long j2, boolean z2, boolean z3) throws p {
        uo();
        this.f11346f7 = false;
        if (z3 || this.f11349j.f10599v == 3) {
            j3(2);
        }
        qj w4 = this.f11371x.w();
        qj qjVar = w4;
        while (qjVar != null && !n3Var.equals(qjVar.f11120a.y)) {
            qjVar = qjVar.i9();
        }
        if (z2 || w4 != qjVar || (qjVar != null && qjVar.c(j2) < 0)) {
            for (zq zqVar : this.y) {
                xc(zqVar);
            }
            if (qjVar != null) {
                while (this.f11371x.w() != qjVar) {
                    this.f11371x.n3();
                }
                this.f11371x.c(qjVar);
                qjVar.f3(1000000000000L);
                mt();
            }
        }
        if (qjVar != null) {
            this.f11371x.c(qjVar);
            if (!qjVar.f11124gv) {
                qjVar.f11120a = qjVar.f11120a.n3(j2);
            } else if (qjVar.f11130v) {
                j2 = qjVar.y.c5(j2);
                qjVar.y.mt(j2 - this.f11354n, this.f11334c);
            }
            rb(j2);
            ut();
        } else {
            this.f11371x.a();
            rb(j2);
        }
        z6(false);
        this.f11359p.i9(2);
        return j2;
    }

    public final void xc(zq zqVar) throws p {
        if (!j5(zqVar)) {
            return;
        }
        this.f11338d0.y(zqVar);
        z(zqVar);
        zqVar.fb();
        this.f11336ct--;
    }

    public final void xg(zn znVar) throws p {
        this.f11358oz.n3(1);
        ej(this.f11333b.x4(znVar.y, znVar.f11395n3, znVar.f11396zn, znVar.f11394gv), false);
    }

    @Override // zo.fh.y
    public void y() {
        this.f11359p.i9(10);
    }

    public final void y5() throws p {
        ej(this.f11333b.c5(), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void yc(boolean r29, boolean r30, boolean r31, boolean r32) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.yc.yc(boolean, boolean, boolean, boolean):void");
    }

    public final void yg() throws p {
        boolean z2;
        float f4 = this.f11338d0.v().y;
        qj p2 = this.f11371x.p();
        boolean z3 = true;
        for (qj w4 = this.f11371x.w(); w4 != null && w4.f11124gv; w4 = w4.i9()) {
            zo.rz x42 = w4.x4(f4, this.f11349j.y);
            if (!x42.y(w4.xc())) {
                if (z3) {
                    qj w5 = this.f11371x.w();
                    boolean c2 = this.f11371x.c(w5);
                    boolean[] zArr = new boolean[this.y.length];
                    long n32 = w5.n3(x42, this.f11349j.f10593mt, c2, zArr);
                    bv bvVar = this.f11349j;
                    if (bvVar.f10599v != 4 && n32 != bvVar.f10593mt) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    bv bvVar2 = this.f11349j;
                    this.f11349j = b(bvVar2.f10594n3, n32, bvVar2.f10603zn, bvVar2.f10591gv, z2, 5);
                    if (z2) {
                        rb(n32);
                    }
                    boolean[] zArr2 = new boolean[this.y.length];
                    int i = 0;
                    while (true) {
                        zq[] zqVarArr = this.y;
                        if (i >= zqVarArr.length) {
                            break;
                        }
                        zq zqVar = zqVarArr[i];
                        boolean j52 = j5(zqVar);
                        zArr2[i] = j52;
                        af.en enVar = w5.f11133zn[i];
                        if (j52) {
                            if (enVar != zqVar.getStream()) {
                                xc(zqVar);
                            } else if (zArr[i]) {
                                zqVar.x4(this.f11364rs);
                            }
                        }
                        i++;
                    }
                    co(zArr2);
                } else {
                    this.f11371x.c(w4);
                    if (w4.f11124gv) {
                        w4.y(x42, Math.max(w4.f11120a.f10900n3, w4.n(this.f11364rs)), false);
                    }
                }
                z6(true);
                if (this.f11349j.f10599v != 4) {
                    ut();
                    c8();
                    this.f11359p.i9(2);
                    return;
                }
                return;
            }
            if (w4 == p2) {
                z3 = false;
            }
        }
    }

    public final void yk(vc vcVar) {
        this.f11356o = vcVar;
    }

    public final boolean yt() {
        qj p2 = this.f11371x.p();
        if (!p2.f11124gv) {
            return false;
        }
        int i = 0;
        while (true) {
            zq[] zqVarArr = this.y;
            if (i < zqVarArr.length) {
                zq zqVar = zqVarArr[i];
                af.en enVar = p2.f11133zn[i];
                if (zqVar.getStream() != enVar || (enVar != null && !zqVar.c5() && !k5(zqVar, p2))) {
                    break;
                }
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public final void z(zq zqVar) {
        if (zqVar.getState() == 2) {
            zqVar.stop();
        }
    }

    public final void z6(boolean z2) {
        mg.n3 n3Var;
        long c52;
        qj i92 = this.f11371x.i9();
        if (i92 == null) {
            n3Var = this.f11349j.f10594n3;
        } else {
            n3Var = i92.f11120a.y;
        }
        boolean equals = this.f11349j.f10589f.equals(n3Var);
        if (!equals) {
            this.f11349j = this.f11349j.n3(n3Var);
        }
        bv bvVar = this.f11349j;
        if (i92 == null) {
            c52 = bvVar.f10593mt;
        } else {
            c52 = i92.c5();
        }
        bvVar.f10600w = c52;
        this.f11349j.f10595p = rz();
        if ((!equals || z2) && i92 != null && i92.f11124gv) {
            mh(i92.wz(), i92.xc());
        }
    }

    @Override // m1.j3.gv
    public void zn() {
        this.f11359p.i9(22);
    }
}
