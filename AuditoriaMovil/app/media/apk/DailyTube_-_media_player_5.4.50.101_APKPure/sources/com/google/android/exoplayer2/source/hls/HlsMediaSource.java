package com.google.android.exoplayer2.source.hls;

import af.b;
import af.c5;
import af.d0;
import af.mg;
import af.y5;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.a;
import com.google.android.exoplayer2.offline.StreamKey;
import f8.r;
import h4.fb;
import h4.s;
import h4.zn;
import java.io.IOException;
import java.util.List;
import kx.mg;
import kx.n;
import kx.n3;
import kx.o;
import kx.tl;
import lw.f;
import lw.fb;
import lw.t;
import lw.v;
import m1.kp;
import m1.o0;
import v5.j5;
/* loaded from: classes.dex */
public final class HlsMediaSource extends af.y implements t.v {

    /* renamed from: b  reason: collision with root package name */
    public o0.fb f4505b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4506c;

    /* renamed from: co  reason: collision with root package name */
    public final o0.s f4507co;

    /* renamed from: d  reason: collision with root package name */
    public final t f4508d;

    /* renamed from: d0  reason: collision with root package name */
    public final int f4509d0;

    /* renamed from: ej  reason: collision with root package name */
    public final long f4510ej;

    /* renamed from: f3  reason: collision with root package name */
    public final a f4511f3;

    /* renamed from: fh  reason: collision with root package name */
    public final boolean f4512fh;
    @Nullable

    /* renamed from: j5  reason: collision with root package name */
    public o f4513j5;

    /* renamed from: n  reason: collision with root package name */
    public final mg f4514n;

    /* renamed from: p  reason: collision with root package name */
    public final s f4515p;

    /* renamed from: r  reason: collision with root package name */
    public final c5 f4516r;

    /* renamed from: x  reason: collision with root package name */
    public final o0 f4517x;

    /* renamed from: z  reason: collision with root package name */
    public final fb f4518z;

    /* loaded from: classes.dex */
    public static final class Factory implements mg.y {

        /* renamed from: a  reason: collision with root package name */
        public r f4519a;

        /* renamed from: c5  reason: collision with root package name */
        public int f4520c5;

        /* renamed from: f  reason: collision with root package name */
        public long f4521f;

        /* renamed from: fb  reason: collision with root package name */
        public kx.mg f4522fb;

        /* renamed from: gv  reason: collision with root package name */
        public t.y f4523gv;

        /* renamed from: i9  reason: collision with root package name */
        public boolean f4524i9;

        /* renamed from: n3  reason: collision with root package name */
        public s f4525n3;

        /* renamed from: s  reason: collision with root package name */
        public boolean f4526s;

        /* renamed from: v  reason: collision with root package name */
        public c5 f4527v;
        public final fb y;

        /* renamed from: zn  reason: collision with root package name */
        public f f4528zn;

        public Factory(tl.y yVar) {
            this(new zn(yVar));
        }

        @Override // af.mg.y
        /* renamed from: a */
        public Factory zn(r rVar) {
            this.f4519a = (r) v5.y.a(rVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // af.mg.y
        /* renamed from: fb */
        public Factory y(kx.mg mgVar) {
            this.f4522fb = (kx.mg) v5.y.a(mgVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // af.mg.y
        /* renamed from: gv */
        public HlsMediaSource n3(o0 o0Var) {
            v5.y.v(o0Var.f11022v);
            f fVar = this.f4528zn;
            List<StreamKey> list = o0Var.f11022v.f11082gv;
            if (!list.isEmpty()) {
                fVar = new v(fVar, list);
            }
            fb fbVar = this.y;
            s sVar = this.f4525n3;
            c5 c5Var = this.f4527v;
            a y = this.f4519a.y(o0Var);
            kx.mg mgVar = this.f4522fb;
            return new HlsMediaSource(o0Var, fbVar, sVar, c5Var, y, mgVar, this.f4523gv.y(this.y, mgVar, fVar), this.f4521f, this.f4526s, this.f4520c5, this.f4524i9);
        }

        public Factory v(boolean z2) {
            this.f4526s = z2;
            return this;
        }

        public Factory(fb fbVar) {
            this.y = (fb) v5.y.v(fbVar);
            this.f4519a = new com.google.android.exoplayer2.drm.zn();
            this.f4528zn = new lw.y();
            this.f4523gv = lw.zn.f10504fh;
            this.f4525n3 = s.y;
            this.f4522fb = new n();
            this.f4527v = new af.t();
            this.f4520c5 = 1;
            this.f4521f = -9223372036854775807L;
            this.f4526s = true;
        }
    }

    static {
        kp.y("goog.exo.hls");
    }

    public static long g(lw.fb fbVar, long j2) {
        long j4;
        fb.a aVar = fbVar.f10405x4;
        long j6 = fbVar.f10402v;
        if (j6 != -9223372036854775807L) {
            j4 = fbVar.f10398r - j6;
        } else {
            long j7 = aVar.f10408gv;
            if (j7 != -9223372036854775807L && fbVar.f10404wz != -9223372036854775807L) {
                j4 = j7;
            } else {
                long j8 = aVar.f10411zn;
                if (j8 != -9223372036854775807L) {
                    j4 = j8;
                } else {
                    j4 = fbVar.f10401tl * 3;
                }
            }
        }
        return j4 + j2;
    }

    @Nullable
    public static fb.n3 kp(List<fb.n3> list, long j2) {
        fb.n3 n3Var = null;
        for (int i = 0; i < list.size(); i++) {
            fb.n3 n3Var2 = list.get(i);
            long j4 = n3Var2.f10417f;
            if (j4 <= j2 && n3Var2.f10414f3) {
                n3Var = n3Var2;
            } else if (j4 > j2) {
                break;
            }
        }
        return n3Var;
    }

    public static fb.gv rb(List<fb.gv> list, long j2) {
        return list.get(j5.a(list, Long.valueOf(j2), true, true));
    }

    @Override // af.y
    public void ap() {
        this.f4508d.stop();
        this.f4511f3.release();
    }

    @Override // af.mg
    public o0 c() {
        return this.f4517x;
    }

    @Override // af.y
    public void e(@Nullable o oVar) {
        this.f4513j5 = oVar;
        this.f4511f3.gv((Looper) v5.y.v(Looper.myLooper()), nf());
        this.f4511f3.prepare();
        this.f4508d.zn(this.f4507co.y, o4(null), this);
    }

    @Override // af.mg
    public d0 f7(mg.n3 n3Var, n3 n3Var2, long j2) {
        b.y o42 = o4(n3Var);
        return new h4.t(this.f4515p, this.f4508d, this.f4518z, this.f4513j5, this.f4511f3, dm(n3Var), this.f4514n, o42, n3Var2, this.f4516r, this.f4506c, this.f4509d0, this.f4512fh, nf());
    }

    public final long g3(lw.fb fbVar) {
        if (fbVar.f10403w) {
            return j5.xb(j5.y5(this.f4510ej)) - fbVar.v();
        }
        return 0L;
    }

    public final long m(lw.fb fbVar, long j2) {
        long j4 = fbVar.f10402v;
        if (j4 == -9223372036854775807L) {
            j4 = (fbVar.f10398r + j2) - j5.xb(this.f4505b.y);
        }
        if (fbVar.f10393fb) {
            return j4;
        }
        fb.n3 kp2 = kp(fbVar.f10391co, j4);
        if (kp2 != null) {
            return kp2.f10417f;
        }
        if (fbVar.f10396mt.isEmpty()) {
            return 0L;
        }
        fb.gv rb2 = rb(fbVar.f10396mt, j4);
        fb.n3 kp3 = kp(rb2.f10413n, j4);
        if (kp3 != null) {
            return kp3.f10417f;
        }
        return rb2.f10417f;
    }

    @Override // af.mg
    public void u(d0 d0Var) {
        ((h4.t) d0Var).fh();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u0(lw.fb r6, long r7) {
        /*
            r5 = this;
            m1.o0 r0 = r5.f4517x
            m1.o0$fb r0 = r0.f11020s
            float r1 = r0.f11050s
            r2 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L28
            float r0 = r0.f11048f
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L28
            lw.fb$a r6 = r6.f10405x4
            long r0 = r6.f10411zn
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L28
            long r0 = r6.f10408gv
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L28
            r6 = 1
            goto L29
        L28:
            r6 = 0
        L29:
            m1.o0$fb$y r0 = new m1.o0$fb$y
            r0.<init>()
            long r7 = v5.j5.gf(r7)
            m1.o0$fb$y r7 = r0.f(r7)
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r6 == 0) goto L3d
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L41
        L3d:
            m1.o0$fb r0 = r5.f4505b
            float r0 = r0.f11050s
        L41:
            m1.o0$fb$y r7 = r7.i9(r0)
            if (r6 == 0) goto L48
            goto L4c
        L48:
            m1.o0$fb r6 = r5.f4505b
            float r8 = r6.f11048f
        L4c:
            m1.o0$fb$y r6 = r7.s(r8)
            m1.o0$fb r6 = r6.a()
            r5.f4505b = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsMediaSource.u0(lw.fb, long):void");
    }

    @Override // af.mg
    public void ut() throws IOException {
        this.f4508d.c5();
    }

    @Override // lw.t.v
    public void w(lw.fb fbVar) {
        long j2;
        long j4;
        y5 yc2;
        if (fbVar.f10403w) {
            j2 = j5.gf(fbVar.f10399s);
        } else {
            j2 = -9223372036854775807L;
        }
        int i = fbVar.f10394gv;
        if (i != 2 && i != 1) {
            j4 = -9223372036854775807L;
        } else {
            j4 = j2;
        }
        h4.c5 c5Var = new h4.c5((lw.s) v5.y.v(this.f4508d.v()), fbVar);
        if (this.f4508d.isLive()) {
            yc2 = yg(fbVar, j4, j2, c5Var);
        } else {
            yc2 = yc(fbVar, j4, j2, c5Var);
        }
        s8(yc2);
    }

    public final y5 yc(lw.fb fbVar, long j2, long j4, h4.c5 c5Var) {
        long j6;
        if (fbVar.f10402v != -9223372036854775807L && !fbVar.f10396mt.isEmpty()) {
            if (!fbVar.f10393fb) {
                long j7 = fbVar.f10402v;
                if (j7 != fbVar.f10398r) {
                    j6 = rb(fbVar.f10396mt, j7).f10417f;
                }
            }
            j6 = fbVar.f10402v;
        } else {
            j6 = 0;
        }
        long j8 = j6;
        long j9 = fbVar.f10398r;
        return new y5(j2, j4, -9223372036854775807L, j9, j9, 0L, j8, true, false, true, c5Var, this.f4517x, null);
    }

    public final y5 yg(lw.fb fbVar, long j2, long j4, h4.c5 c5Var) {
        long j6;
        long g2;
        boolean z2;
        long gv2 = fbVar.f10399s - this.f4508d.gv();
        if (fbVar.f10406xc) {
            j6 = gv2 + fbVar.f10398r;
        } else {
            j6 = -9223372036854775807L;
        }
        long g32 = g3(fbVar);
        long j7 = this.f4505b.y;
        if (j7 != -9223372036854775807L) {
            g2 = j5.xb(j7);
        } else {
            g2 = g(fbVar, g32);
        }
        u0(fbVar, j5.mt(g2, g32, fbVar.f10398r + g32));
        long m2 = m(fbVar, g32);
        if (fbVar.f10394gv == 2 && fbVar.f10389a) {
            z2 = true;
        } else {
            z2 = false;
        }
        return new y5(j2, j4, -9223372036854775807L, j6, fbVar.f10398r, gv2, m2, true, !fbVar.f10406xc, z2, c5Var, this.f4517x, this.f4505b);
    }

    public HlsMediaSource(o0 o0Var, h4.fb fbVar, s sVar, c5 c5Var, a aVar, kx.mg mgVar, t tVar, long j2, boolean z2, int i, boolean z3) {
        this.f4507co = (o0.s) v5.y.v(o0Var.f11022v);
        this.f4517x = o0Var;
        this.f4505b = o0Var.f11020s;
        this.f4518z = fbVar;
        this.f4515p = sVar;
        this.f4516r = c5Var;
        this.f4511f3 = aVar;
        this.f4514n = mgVar;
        this.f4508d = tVar;
        this.f4510ej = j2;
        this.f4506c = z2;
        this.f4509d0 = i;
        this.f4512fh = z3;
    }
}
