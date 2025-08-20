package af;

import af.dm;
import af.mg;
import af.oz;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import e4.fh;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kx.r;
import kx.tl;
import m1.m;
import m1.o0;
/* loaded from: classes.dex */
public final class co implements mg.y {

    /* renamed from: a  reason: collision with root package name */
    public long f123a;

    /* renamed from: c5  reason: collision with root package name */
    public float f124c5;

    /* renamed from: fb  reason: collision with root package name */
    public long f125fb;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public kx.mg f126gv;

    /* renamed from: i9  reason: collision with root package name */
    public boolean f127i9;

    /* renamed from: n3  reason: collision with root package name */
    public tl.y f128n3;

    /* renamed from: s  reason: collision with root package name */
    public float f129s;

    /* renamed from: v  reason: collision with root package name */
    public long f130v;
    public final y y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public mg.y f131zn;

    /* loaded from: classes.dex */
    public static final class y {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public f8.r f132a;
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public kx.mg f133fb;

        /* renamed from: v  reason: collision with root package name */
        public tl.y f136v;
        public final e4.mt y;

        /* renamed from: n3  reason: collision with root package name */
        public final Map<Integer, w0.z<mg.y>> f135n3 = new HashMap();

        /* renamed from: zn  reason: collision with root package name */
        public final Set<Integer> f137zn = new HashSet();

        /* renamed from: gv  reason: collision with root package name */
        public final Map<Integer, mg.y> f134gv = new HashMap();

        public y(e4.mt mtVar) {
            this.y = mtVar;
        }

        @Nullable
        public mg.y a(int i) {
            mg.y yVar = this.f134gv.get(Integer.valueOf(i));
            if (yVar != null) {
                return yVar;
            }
            w0.z<mg.y> t2 = t(i);
            if (t2 == null) {
                return null;
            }
            mg.y yVar2 = t2.get();
            f8.r rVar = this.f132a;
            if (rVar != null) {
                yVar2.zn(rVar);
            }
            kx.mg mgVar = this.f133fb;
            if (mgVar != null) {
                yVar2.y(mgVar);
            }
            this.f134gv.put(Integer.valueOf(i), yVar2);
            return yVar2;
        }

        public final /* synthetic */ mg.y f(tl.y yVar) {
            return new oz.n3(yVar, this.y);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
        @androidx.annotation.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final w0.z<af.mg.y> t(int r5) {
            /*
                r4 = this;
                java.util.Map<java.lang.Integer, w0.z<af.mg$y>> r0 = r4.f135n3
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                boolean r0 = r0.containsKey(r1)
                if (r0 == 0) goto L19
                java.util.Map<java.lang.Integer, w0.z<af.mg$y>> r0 = r4.f135n3
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r5 = r0.get(r5)
                w0.z r5 = (w0.z) r5
                return r5
            L19:
                kx.tl$y r0 = r4.f136v
                java.lang.Object r0 = v5.y.v(r0)
                kx.tl$y r0 = (kx.tl.y) r0
                java.lang.Class<af.mg$y> r1 = af.mg.y.class
                r2 = 0
                if (r5 == 0) goto L69
                r3 = 1
                if (r5 == r3) goto L59
                r3 = 2
                if (r5 == r3) goto L4c
                r3 = 3
                if (r5 == r3) goto L3c
                r1 = 4
                if (r5 == r1) goto L33
                goto L75
            L33:
                af.mt r1 = new af.mt     // Catch: java.lang.ClassNotFoundException -> L3a
                r1.<init>()     // Catch: java.lang.ClassNotFoundException -> L3a
            L38:
                r2 = r1
                goto L75
            L3a:
                goto L75
            L3c:
                java.lang.String r0 = "com.google.android.exoplayer2.source.rtsp.RtspMediaSource$Factory"
                java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.ClassNotFoundException -> L3a
                java.lang.Class r0 = r0.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L3a
                af.p r1 = new af.p     // Catch: java.lang.ClassNotFoundException -> L3a
                r1.<init>()     // Catch: java.lang.ClassNotFoundException -> L3a
                goto L38
            L4c:
                java.lang.Class<com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory> r3 = com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory.class
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L3a
                af.w r3 = new af.w     // Catch: java.lang.ClassNotFoundException -> L3a
                r3.<init>()     // Catch: java.lang.ClassNotFoundException -> L3a
            L57:
                r2 = r3
                goto L75
            L59:
                java.lang.String r3 = "com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.ClassNotFoundException -> L3a
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L3a
                af.xc r3 = new af.xc     // Catch: java.lang.ClassNotFoundException -> L3a
                r3.<init>()     // Catch: java.lang.ClassNotFoundException -> L3a
                goto L57
            L69:
                java.lang.Class<com.google.android.exoplayer2.source.dash.DashMediaSource$Factory> r3 = com.google.android.exoplayer2.source.dash.DashMediaSource.Factory.class
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L3a
                af.wz r3 = new af.wz     // Catch: java.lang.ClassNotFoundException -> L3a
                r3.<init>()     // Catch: java.lang.ClassNotFoundException -> L3a
                goto L57
            L75:
                java.util.Map<java.lang.Integer, w0.z<af.mg$y>> r0 = r4.f135n3
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                r0.put(r1, r2)
                if (r2 == 0) goto L89
                java.util.Set<java.lang.Integer> r0 = r4.f137zn
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r0.add(r5)
            L89:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: af.co.y.t(int):w0.z");
        }

        public void tl(tl.y yVar) {
            if (yVar != this.f136v) {
                this.f136v = yVar;
                this.f135n3.clear();
                this.f134gv.clear();
            }
        }

        public void wz(f8.r rVar) {
            this.f132a = rVar;
            for (mg.y yVar : this.f134gv.values()) {
                yVar.zn(rVar);
            }
        }

        public void xc(kx.mg mgVar) {
            this.f133fb = mgVar;
            for (mg.y yVar : this.f134gv.values()) {
                yVar.y(mgVar);
            }
        }
    }

    public co(Context context, e4.mt mtVar) {
        this(new r.y(context), mtVar);
    }

    public static mg.y f(Class<? extends mg.y> cls, tl.y yVar) {
        try {
            return cls.getConstructor(tl.y.class).newInstance(yVar);
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static /* synthetic */ e4.t[] fb(m mVar) {
        e4.t n3Var;
        qh.t tVar = qh.t.y;
        if (tVar.n3(mVar)) {
            n3Var = new qh.tl(tVar.y(mVar), mVar);
        } else {
            n3Var = new n3(mVar);
        }
        return new e4.t[]{n3Var};
    }

    public static mg.y i9(Class<? extends mg.y> cls) {
        try {
            return cls.getConstructor(null).newInstance(null);
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static mg s(o0 o0Var, mg mgVar) {
        o0.gv gvVar = o0Var.f11021t;
        if (gvVar.y == 0 && gvVar.f11066v == Long.MIN_VALUE && !gvVar.f11065s) {
            return mgVar;
        }
        long xb2 = v5.j5.xb(o0Var.f11021t.y);
        long xb3 = v5.j5.xb(o0Var.f11021t.f11066v);
        o0.gv gvVar2 = o0Var.f11021t;
        return new v(mgVar, xb2, xb3, !gvVar2.f11063f, gvVar2.f11064fb, gvVar2.f11065s);
    }

    public final mg c5(o0 o0Var, mg mgVar) {
        v5.y.v(o0Var.f11022v);
        o0Var.f11022v.getClass();
        return mgVar;
    }

    @Override // af.mg.y
    public mg n3(o0 o0Var) {
        v5.y.v(o0Var.f11022v);
        String scheme = o0Var.f11022v.y.getScheme();
        if (scheme != null && scheme.equals("ssai")) {
            return ((mg.y) v5.y.v(this.f131zn)).n3(o0Var);
        }
        o0.s sVar = o0Var.f11022v;
        int kp2 = v5.j5.kp(sVar.y, sVar.f11083n3);
        mg.y a2 = this.y.a(kp2);
        v5.y.i9(a2, "No suitable media source factory found for content type: " + kp2);
        o0.fb.y n32 = o0Var.f11020s.n3();
        if (o0Var.f11020s.y == -9223372036854775807L) {
            n32.f(this.f130v);
        }
        if (o0Var.f11020s.f11050s == -3.4028235E38f) {
            n32.i9(this.f129s);
        }
        if (o0Var.f11020s.f11048f == -3.4028235E38f) {
            n32.s(this.f124c5);
        }
        if (o0Var.f11020s.f11051v == -9223372036854775807L) {
            n32.c5(this.f123a);
        }
        if (o0Var.f11020s.f11049fb == -9223372036854775807L) {
            n32.fb(this.f125fb);
        }
        o0.fb a3 = n32.a();
        if (!a3.equals(o0Var.f11020s)) {
            o0Var = o0Var.n3().zn(a3).y();
        }
        mg n33 = a2.n3(o0Var);
        z0.x4<o0.t> x4Var = ((o0.s) v5.j5.i9(o0Var.f11022v)).f11080a;
        if (!x4Var.isEmpty()) {
            mg[] mgVarArr = new mg[x4Var.size() + 1];
            mgVarArr[0] = n33;
            for (int i = 0; i < x4Var.size(); i++) {
                if (this.f127i9) {
                    final m z62 = new m.n3().o4(x4Var.get(i).f11090n3).k(x4Var.get(i).f11092zn).eb(x4Var.get(i).f11089gv).dm(x4Var.get(i).f11091v).q9(x4Var.get(i).f11087a).oz(x4Var.get(i).f11088fb).z6();
                    oz.n3 n3Var = new oz.n3(this.f128n3, new e4.mt() { // from class: af.tl
                        @Override // e4.mt
                        public final e4.t[] createExtractors() {
                            e4.t[] fb2;
                            fb2 = co.fb(m.this);
                            return fb2;
                        }

                        @Override // e4.mt
                        public /* synthetic */ e4.t[] y(Uri uri, Map map) {
                            return e4.p.y(this, uri, map);
                        }
                    });
                    kx.mg mgVar = this.f126gv;
                    if (mgVar != null) {
                        n3Var.y(mgVar);
                    }
                    mgVarArr[i + 1] = n3Var.n3(o0.gv(x4Var.get(i).y.toString()));
                } else {
                    dm.n3 n3Var2 = new dm.n3(this.f128n3);
                    kx.mg mgVar2 = this.f126gv;
                    if (mgVar2 != null) {
                        n3Var2.n3(mgVar2);
                    }
                    mgVarArr[i + 1] = n3Var2.y(x4Var.get(i), -9223372036854775807L);
                }
            }
            n33 = new yt(mgVarArr);
        }
        return c5(o0Var, s(o0Var, n33));
    }

    @Override // af.mg.y
    /* renamed from: t */
    public co zn(f8.r rVar) {
        this.y.wz((f8.r) v5.y.a(rVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }

    @Override // af.mg.y
    /* renamed from: tl */
    public co y(kx.mg mgVar) {
        this.f126gv = (kx.mg) v5.y.a(mgVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.y.xc(mgVar);
        return this;
    }

    public co(tl.y yVar, e4.mt mtVar) {
        this.f128n3 = yVar;
        y yVar2 = new y(mtVar);
        this.y = yVar2;
        yVar2.tl(yVar);
        this.f130v = -9223372036854775807L;
        this.f123a = -9223372036854775807L;
        this.f125fb = -9223372036854775807L;
        this.f129s = -3.4028235E38f;
        this.f124c5 = -3.4028235E38f;
    }

    /* loaded from: classes.dex */
    public static final class n3 implements e4.t {
        public final m y;

        public n3(m mVar) {
            this.y = mVar;
        }

        @Override // e4.t
        public boolean a(e4.tl tlVar) {
            return true;
        }

        @Override // e4.t
        public int v(e4.tl tlVar, e4.d0 d0Var) throws IOException {
            if (tlVar.xc(Integer.MAX_VALUE) == -1) {
                return -1;
            }
            return 0;
        }

        @Override // e4.t
        public void zn(e4.wz wzVar) {
            e4.ta a2 = wzVar.a(0, 3);
            wzVar.t(new fh.n3(-9223372036854775807L));
            wzVar.xc();
            a2.v(this.y.n3().o4("text/x-unknown").x(this.y.f10948f3).z6());
        }

        @Override // e4.t
        public void release() {
        }

        @Override // e4.t
        public void y(long j2, long j4) {
        }
    }
}
