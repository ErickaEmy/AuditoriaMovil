package com.google.android.exoplayer2.source.smoothstreaming;

import af.b;
import af.c;
import af.c5;
import af.d0;
import af.i4;
import af.mg;
import af.t;
import af.y5;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.a;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.n3;
import com.google.android.exoplayer2.source.smoothstreaming.y;
import f8.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kx.d;
import kx.mg;
import kx.n;
import kx.o;
import kx.ta;
import kx.tl;
import kx.z6;
import m1.kp;
import m1.o0;
import q3.y;
import v5.j5;
/* loaded from: classes.dex */
public final class SsMediaSource extends af.y implements ta.n3<z6<q3.y>> {

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<zn> f4662b;

    /* renamed from: c  reason: collision with root package name */
    public final c5 f4663c;

    /* renamed from: co  reason: collision with root package name */
    public final Uri f4664co;

    /* renamed from: d  reason: collision with root package name */
    public final long f4665d;

    /* renamed from: d0  reason: collision with root package name */
    public final a f4666d0;

    /* renamed from: ej  reason: collision with root package name */
    public final b.y f4667ej;

    /* renamed from: f3  reason: collision with root package name */
    public final tl.y f4668f3;

    /* renamed from: fh  reason: collision with root package name */
    public final mg f4669fh;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public o f4670j;

    /* renamed from: j5  reason: collision with root package name */
    public tl f4671j5;

    /* renamed from: n  reason: collision with root package name */
    public final n3.y f4672n;

    /* renamed from: o  reason: collision with root package name */
    public d f4673o;

    /* renamed from: oz  reason: collision with root package name */
    public long f4674oz;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f4675p;

    /* renamed from: q9  reason: collision with root package name */
    public Handler f4676q9;

    /* renamed from: qn  reason: collision with root package name */
    public ta f4677qn;

    /* renamed from: r  reason: collision with root package name */
    public final o0 f4678r;

    /* renamed from: ut  reason: collision with root package name */
    public q3.y f4679ut;

    /* renamed from: x  reason: collision with root package name */
    public final z6.y<? extends q3.y> f4680x;

    /* renamed from: z  reason: collision with root package name */
    public final o0.s f4681z;

    /* loaded from: classes.dex */
    public static final class Factory implements mg.y {

        /* renamed from: a  reason: collision with root package name */
        public long f4682a;
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public z6.y<? extends q3.y> f4683fb;

        /* renamed from: gv  reason: collision with root package name */
        public r f4684gv;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public final tl.y f4685n3;

        /* renamed from: v  reason: collision with root package name */
        public kx.mg f4686v;
        public final n3.y y;

        /* renamed from: zn  reason: collision with root package name */
        public c5 f4687zn;

        public Factory(tl.y yVar) {
            this(new y.C0053y(yVar), yVar);
        }

        @Override // af.mg.y
        /* renamed from: a */
        public Factory y(kx.mg mgVar) {
            this.f4686v = (kx.mg) v5.y.a(mgVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // af.mg.y
        /* renamed from: gv */
        public SsMediaSource n3(o0 o0Var) {
            ea.n3 n3Var;
            v5.y.v(o0Var.f11022v);
            z6.y yVar = this.f4683fb;
            if (yVar == null) {
                yVar = new q3.n3();
            }
            List<StreamKey> list = o0Var.f11022v.f11082gv;
            if (!list.isEmpty()) {
                n3Var = new ea.n3(yVar, list);
            } else {
                n3Var = yVar;
            }
            return new SsMediaSource(o0Var, null, this.f4685n3, n3Var, this.y, this.f4687zn, this.f4684gv.y(o0Var), this.f4686v, this.f4682a);
        }

        @Override // af.mg.y
        /* renamed from: v */
        public Factory zn(r rVar) {
            this.f4684gv = (r) v5.y.a(rVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory(n3.y yVar, @Nullable tl.y yVar2) {
            this.y = (n3.y) v5.y.v(yVar);
            this.f4685n3 = yVar2;
            this.f4684gv = new com.google.android.exoplayer2.drm.zn();
            this.f4686v = new n();
            this.f4682a = 30000L;
            this.f4687zn = new t();
        }
    }

    static {
        kp.y("goog.exo.smoothstreaming");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f4677qn.c5()) {
            return;
        }
        z6 z6Var = new z6(this.f4671j5, this.f4664co, 4, this.f4680x);
        this.f4667ej.c(new i4(z6Var.y, z6Var.f10190n3, this.f4677qn.wz(z6Var, this, this.f4669fh.y(z6Var.f10192zn))), z6Var.f10192zn);
    }

    @Override // af.y
    public void ap() {
        q3.y yVar;
        if (this.f4675p) {
            yVar = this.f4679ut;
        } else {
            yVar = null;
        }
        this.f4679ut = yVar;
        this.f4671j5 = null;
        this.f4674oz = 0L;
        ta taVar = this.f4677qn;
        if (taVar != null) {
            taVar.t();
            this.f4677qn = null;
        }
        Handler handler = this.f4676q9;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f4676q9 = null;
        }
        this.f4666d0.release();
    }

    @Override // af.mg
    public o0 c() {
        return this.f4678r;
    }

    @Override // af.y
    public void e(@Nullable o oVar) {
        this.f4670j = oVar;
        this.f4666d0.gv(Looper.myLooper(), nf());
        this.f4666d0.prepare();
        if (this.f4675p) {
            this.f4673o = new d.y();
            g3();
            return;
        }
        this.f4671j5 = this.f4668f3.y();
        ta taVar = new ta("SsMediaSource");
        this.f4677qn = taVar;
        this.f4673o = taVar;
        this.f4676q9 = j5.i4();
        g();
    }

    @Override // af.mg
    public d0 f7(mg.n3 n3Var, kx.n3 n3Var2, long j2) {
        b.y o42 = o4(n3Var);
        zn znVar = new zn(this.f4679ut, this.f4672n, this.f4670j, this.f4663c, this.f4666d0, dm(n3Var), this.f4669fh, o42, this.f4673o, n3Var2);
        this.f4662b.add(znVar);
        return znVar;
    }

    public final void g3() {
        y.n3[] n3VarArr;
        long j2;
        y5 y5Var;
        long j4;
        for (int i = 0; i < this.f4662b.size(); i++) {
            this.f4662b.get(i).x4(this.f4679ut);
        }
        long j6 = Long.MIN_VALUE;
        long j7 = Long.MAX_VALUE;
        for (y.n3 n3Var : this.f4679ut.f12731a) {
            if (n3Var.f12740f > 0) {
                j7 = Math.min(j7, n3Var.v(0));
                j6 = Math.max(j6, n3Var.v(n3Var.f12740f - 1) + n3Var.zn(n3Var.f12740f - 1));
            }
        }
        if (j7 == Long.MAX_VALUE) {
            if (this.f4679ut.f12733gv) {
                j4 = -9223372036854775807L;
            } else {
                j4 = 0;
            }
            q3.y yVar = this.f4679ut;
            boolean z2 = yVar.f12733gv;
            y5Var = new y5(j4, 0L, 0L, 0L, true, z2, z2, yVar, this.f4678r);
        } else {
            q3.y yVar2 = this.f4679ut;
            if (yVar2.f12733gv) {
                long j8 = yVar2.f12735s;
                if (j8 != -9223372036854775807L && j8 > 0) {
                    j7 = Math.max(j7, j6 - j8);
                }
                long j9 = j7;
                long j10 = j6 - j9;
                long xb2 = j10 - j5.xb(this.f4665d);
                if (xb2 < 5000000) {
                    xb2 = Math.min(5000000L, j10 / 2);
                }
                y5Var = new y5(-9223372036854775807L, j10, j9, xb2, true, true, true, this.f4679ut, this.f4678r);
            } else {
                long j11 = yVar2.f12732fb;
                if (j11 != -9223372036854775807L) {
                    j2 = j11;
                } else {
                    j2 = j6 - j7;
                }
                y5Var = new y5(j7 + j2, j2, j7, 0L, true, false, false, this.f4679ut, this.f4678r);
            }
        }
        s8(y5Var);
    }

    @Override // kx.ta.n3
    /* renamed from: kp */
    public void ta(z6<q3.y> z6Var, long j2, long j4) {
        i4 i4Var = new i4(z6Var.y, z6Var.f10190n3, z6Var.v(), z6Var.zn(), j2, j4, z6Var.y());
        this.f4669fh.zn(z6Var.y);
        this.f4667ej.z(i4Var, z6Var.f10192zn);
        this.f4679ut = z6Var.gv();
        this.f4674oz = j2 - j4;
        g3();
        m();
    }

    public final void m() {
        if (!this.f4679ut.f12733gv) {
            return;
        }
        this.f4676q9.postDelayed(new Runnable() { // from class: nj.y
            @Override // java.lang.Runnable
            public final void run() {
                SsMediaSource.this.g();
            }
        }, Math.max(0L, (this.f4674oz + 5000) - SystemClock.elapsedRealtime()));
    }

    @Override // kx.ta.n3
    /* renamed from: rb */
    public ta.zn oz(z6<q3.y> z6Var, long j2, long j4, IOException iOException, int i) {
        ta.zn s2;
        i4 i4Var = new i4(z6Var.y, z6Var.f10190n3, z6Var.v(), z6Var.zn(), j2, j4, z6Var.y());
        long gv2 = this.f4669fh.gv(new mg.zn(i4Var, new c(z6Var.f10192zn), iOException, i));
        if (gv2 == -9223372036854775807L) {
            s2 = ta.f10109fb;
        } else {
            s2 = ta.s(false, gv2);
        }
        boolean zn2 = s2.zn();
        this.f4667ej.f3(i4Var, z6Var.f10192zn, iOException, !zn2);
        if (!zn2) {
            this.f4669fh.zn(z6Var.y);
        }
        return s2;
    }

    @Override // af.mg
    public void u(d0 d0Var) {
        ((zn) d0Var).r();
        this.f4662b.remove(d0Var);
    }

    @Override // af.mg
    public void ut() throws IOException {
        this.f4673o.n3();
    }

    @Override // kx.ta.n3
    /* renamed from: yc */
    public void ud(z6<q3.y> z6Var, long j2, long j4, boolean z2) {
        i4 i4Var = new i4(z6Var.y, z6Var.f10190n3, z6Var.v(), z6Var.zn(), j2, j4, z6Var.y());
        this.f4669fh.zn(z6Var.y);
        this.f4667ej.p(i4Var, z6Var.f10192zn);
    }

    public SsMediaSource(o0 o0Var, @Nullable q3.y yVar, @Nullable tl.y yVar2, @Nullable z6.y<? extends q3.y> yVar3, n3.y yVar4, c5 c5Var, a aVar, kx.mg mgVar, long j2) {
        v5.y.fb(yVar == null || !yVar.f12733gv);
        this.f4678r = o0Var;
        o0.s sVar = (o0.s) v5.y.v(o0Var.f11022v);
        this.f4681z = sVar;
        this.f4679ut = yVar;
        this.f4664co = sVar.y.equals(Uri.EMPTY) ? null : j5.fh(sVar.y);
        this.f4668f3 = yVar2;
        this.f4680x = yVar3;
        this.f4672n = yVar4;
        this.f4663c = c5Var;
        this.f4666d0 = aVar;
        this.f4669fh = mgVar;
        this.f4665d = j2;
        this.f4667ej = o4(null);
        this.f4675p = yVar != null;
        this.f4662b = new ArrayList<>();
    }
}
