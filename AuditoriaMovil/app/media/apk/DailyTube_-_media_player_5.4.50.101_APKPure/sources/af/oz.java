package af;

import af.j;
import af.mg;
import af.oz;
import af.vl;
import android.os.Looper;
import androidx.annotation.Nullable;
import fj.u0;
import kx.tl;
import m1.hy;
import m1.o0;
/* loaded from: classes.dex */
public final class oz extends af.y implements j.n3 {

    /* renamed from: c  reason: collision with root package name */
    public final int f345c;

    /* renamed from: co  reason: collision with root package name */
    public final o0.s f346co;

    /* renamed from: d  reason: collision with root package name */
    public boolean f347d;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f348d0;

    /* renamed from: ej  reason: collision with root package name */
    public boolean f349ej;

    /* renamed from: f3  reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.a f350f3;

    /* renamed from: fh  reason: collision with root package name */
    public long f351fh;

    /* renamed from: n  reason: collision with root package name */
    public final kx.mg f352n;

    /* renamed from: p  reason: collision with root package name */
    public final o0 f353p;

    /* renamed from: r  reason: collision with root package name */
    public final vl.y f354r;
    @Nullable

    /* renamed from: x  reason: collision with root package name */
    public kx.o f355x;

    /* renamed from: z  reason: collision with root package name */
    public final tl.y f356z;

    /* loaded from: classes.dex */
    public static final class n3 implements mg.y {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public String f357a;
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public Object f358fb;

        /* renamed from: gv  reason: collision with root package name */
        public kx.mg f359gv;

        /* renamed from: n3  reason: collision with root package name */
        public vl.y f360n3;

        /* renamed from: v  reason: collision with root package name */
        public int f361v;
        public final tl.y y;

        /* renamed from: zn  reason: collision with root package name */
        public f8.r f362zn;

        public n3(tl.y yVar) {
            this(yVar, new e4.c5());
        }

        public static /* synthetic */ vl a(e4.mt mtVar, u0 u0Var) {
            return new zn(mtVar);
        }

        @Override // af.mg.y
        /* renamed from: fb */
        public n3 zn(f8.r rVar) {
            this.f362zn = (f8.r) v5.y.a(rVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // af.mg.y
        /* renamed from: s */
        public n3 y(kx.mg mgVar) {
            this.f359gv = (kx.mg) v5.y.a(mgVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // af.mg.y
        /* renamed from: v */
        public oz n3(o0 o0Var) {
            boolean z2;
            v5.y.v(o0Var.f11022v);
            o0.s sVar = o0Var.f11022v;
            boolean z3 = false;
            if (sVar.f11084s == null && this.f358fb != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (sVar.f11085v == null && this.f357a != null) {
                z3 = true;
            }
            if (z2 && z3) {
                o0Var = o0Var.n3().fb(this.f358fb).n3(this.f357a).y();
            } else if (z2) {
                o0Var = o0Var.n3().fb(this.f358fb).y();
            } else if (z3) {
                o0Var = o0Var.n3().n3(this.f357a).y();
            }
            o0 o0Var2 = o0Var;
            return new oz(o0Var2, this.y, this.f360n3, this.f362zn.y(o0Var2), this.f359gv, this.f361v, null);
        }

        public n3(tl.y yVar, final e4.mt mtVar) {
            this(yVar, new vl.y() { // from class: af.ut
                @Override // af.vl.y
                public final vl y(u0 u0Var) {
                    vl a2;
                    a2 = oz.n3.a(e4.mt.this, u0Var);
                    return a2;
                }
            });
        }

        public n3(tl.y yVar, vl.y yVar2) {
            this(yVar, yVar2, new com.google.android.exoplayer2.drm.zn(), new kx.n(), 1048576);
        }

        public n3(tl.y yVar, vl.y yVar2, f8.r rVar, kx.mg mgVar, int i) {
            this.y = yVar;
            this.f360n3 = yVar2;
            this.f362zn = rVar;
            this.f359gv = mgVar;
            this.f361v = i;
        }
    }

    /* loaded from: classes.dex */
    public class y extends r {
        public y(oz ozVar, hy hyVar) {
            super(hyVar);
        }

        @Override // af.r, m1.hy
        public hy.gv co(int i, hy.gv gvVar, long j2) {
            super.co(i, gvVar, j2);
            gvVar.f10810f3 = true;
            return gvVar;
        }

        @Override // af.r, m1.hy
        public hy.n3 f(int i, hy.n3 n3Var, boolean z2) {
            super.f(i, n3Var, z2);
            n3Var.f10830t = true;
            return n3Var;
        }
    }

    public /* synthetic */ oz(o0 o0Var, tl.y yVar, vl.y yVar2, com.google.android.exoplayer2.drm.a aVar, kx.mg mgVar, int i, y yVar3) {
        this(o0Var, yVar, yVar2, aVar, mgVar, i);
    }

    @Override // af.y
    public void ap() {
        this.f350f3.release();
    }

    @Override // af.mg
    public o0 c() {
        return this.f353p;
    }

    @Override // af.y
    public void e(@Nullable kx.o oVar) {
        this.f355x = oVar;
        this.f350f3.gv((Looper) v5.y.v(Looper.myLooper()), nf());
        this.f350f3.prepare();
        yg();
    }

    @Override // af.mg
    public d0 f7(mg.n3 n3Var, kx.n3 n3Var2, long j2) {
        kx.tl y2 = this.f356z.y();
        kx.o oVar = this.f355x;
        if (oVar != null) {
            y2.i9(oVar);
        }
        return new j(this.f346co.y, y2, this.f354r.y(nf()), this.f350f3, dm(n3Var), this.f352n, o4(n3Var), this, n3Var2, this.f346co.f11085v, this.f345c);
    }

    @Override // af.mg
    public void u(d0 d0Var) {
        ((j) d0Var).ct();
    }

    @Override // af.j.n3
    public void y(long j2, boolean z2, boolean z3) {
        if (j2 == -9223372036854775807L) {
            j2 = this.f351fh;
        }
        if (!this.f348d0 && this.f351fh == j2 && this.f347d == z2 && this.f349ej == z3) {
            return;
        }
        this.f351fh = j2;
        this.f347d = z2;
        this.f349ej = z3;
        this.f348d0 = false;
        yg();
    }

    public final void yg() {
        hy y5Var = new y5(this.f351fh, this.f347d, false, this.f349ej, null, this.f353p);
        if (this.f348d0) {
            y5Var = new y(this, y5Var);
        }
        s8(y5Var);
    }

    public oz(o0 o0Var, tl.y yVar, vl.y yVar2, com.google.android.exoplayer2.drm.a aVar, kx.mg mgVar, int i) {
        this.f346co = (o0.s) v5.y.v(o0Var.f11022v);
        this.f353p = o0Var;
        this.f356z = yVar;
        this.f354r = yVar2;
        this.f350f3 = aVar;
        this.f352n = mgVar;
        this.f345c = i;
        this.f348d0 = true;
        this.f351fh = -9223372036854775807L;
    }

    @Override // af.mg
    public void ut() {
    }
}
