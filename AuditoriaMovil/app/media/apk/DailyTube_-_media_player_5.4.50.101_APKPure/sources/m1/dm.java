package m1;

import af.mg;
import af.u;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import gk.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;
import m1.c8;
import m1.co;
import m1.dm;
import m1.gv;
import m1.hy;
import m1.j3;
import m1.n3;
import m1.rv;
import m1.uo;
import m1.yc;
import v5.z;
/* loaded from: classes.dex */
public final class dm extends m1.v implements co {

    /* renamed from: a  reason: collision with root package name */
    public final uo f10658a;

    /* renamed from: a8  reason: collision with root package name */
    public boolean f10659a8;

    /* renamed from: ap  reason: collision with root package name */
    public boolean f10660ap;

    /* renamed from: b  reason: collision with root package name */
    public vc f10661b;

    /* renamed from: c  reason: collision with root package name */
    public final m1.n3 f10662c;

    /* renamed from: c5  reason: collision with root package name */
    public final v5.p f10663c5;

    /* renamed from: co  reason: collision with root package name */
    public final Looper f10664co;

    /* renamed from: ct  reason: collision with root package name */
    public int f10665ct;

    /* renamed from: d  reason: collision with root package name */
    public int f10666d;

    /* renamed from: d0  reason: collision with root package name */
    public final m1.gv f10667d0;
    @Nullable

    /* renamed from: dm  reason: collision with root package name */
    public a9.v f10668dm;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public v5.ta f10669e;

    /* renamed from: eb  reason: collision with root package name */
    public boolean f10670eb;

    /* renamed from: ej  reason: collision with root package name */
    public int f10671ej;
    @Nullable

    /* renamed from: en  reason: collision with root package name */
    public TextureView f10672en;

    /* renamed from: f  reason: collision with root package name */
    public final yc f10673f;

    /* renamed from: f3  reason: collision with root package name */
    public final zn f10674f3;

    /* renamed from: f7  reason: collision with root package name */
    public boolean f10675f7;

    /* renamed from: fb  reason: collision with root package name */
    public final zq[] f10676fb;

    /* renamed from: fh  reason: collision with root package name */
    public final rv f10677fh;

    /* renamed from: g  reason: collision with root package name */
    public long f10678g;

    /* renamed from: g3  reason: collision with root package name */
    public int f10679g3;

    /* renamed from: gv  reason: collision with root package name */
    public final v5.s f10680gv;

    /* renamed from: hw  reason: collision with root package name */
    public qk f10681hw;

    /* renamed from: i4  reason: collision with root package name */
    public final v5.v f10682i4;

    /* renamed from: i9  reason: collision with root package name */
    public final yc.a f10683i9;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public AudioTrack f10684j;

    /* renamed from: j5  reason: collision with root package name */
    public qk f10685j5;

    /* renamed from: jz  reason: collision with root package name */
    public int f10686jz;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public gk.t f10687k;

    /* renamed from: k5  reason: collision with root package name */
    public af.u f10688k5;

    /* renamed from: kp  reason: collision with root package name */
    public qk f10689kp;

    /* renamed from: lc  reason: collision with root package name */
    public qh.a f10690lc;

    /* renamed from: m  reason: collision with root package name */
    public int f10691m;

    /* renamed from: mg  reason: collision with root package name */
    public final zx f10692mg;

    /* renamed from: mt  reason: collision with root package name */
    public final fj.y f10693mt;

    /* renamed from: n  reason: collision with root package name */
    public final gv f10694n;

    /* renamed from: n3  reason: collision with root package name */
    public final zo.rz f10695n3;

    /* renamed from: nf  reason: collision with root package name */
    public boolean f10696nf;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public m f10697o;

    /* renamed from: o4  reason: collision with root package name */
    public d9.v f10698o4;
    @Nullable

    /* renamed from: oz  reason: collision with root package name */
    public Object f10699oz;

    /* renamed from: p  reason: collision with root package name */
    public final mg.y f10700p;
    @Nullable

    /* renamed from: q9  reason: collision with root package name */
    public SurfaceHolder f10701q9;
    @Nullable

    /* renamed from: qn  reason: collision with root package name */
    public m f10702qn;

    /* renamed from: r  reason: collision with root package name */
    public final long f10703r;

    /* renamed from: ra  reason: collision with root package name */
    public boolean f10704ra;

    /* renamed from: rb  reason: collision with root package name */
    public bv f10705rb;

    /* renamed from: rs  reason: collision with root package name */
    public float f10706rs;

    /* renamed from: rz  reason: collision with root package name */
    public final gi f10707rz;

    /* renamed from: s  reason: collision with root package name */
    public final zo.fh f10708s;

    /* renamed from: s8  reason: collision with root package name */
    public boolean f10709s8;

    /* renamed from: t  reason: collision with root package name */
    public final v5.z<uo.gv> f10710t;

    /* renamed from: ta  reason: collision with root package name */
    public final long f10711ta;

    /* renamed from: tl  reason: collision with root package name */
    public final CopyOnWriteArraySet<co.y> f10712tl;

    /* renamed from: u  reason: collision with root package name */
    public int f10713u;

    /* renamed from: ud  reason: collision with root package name */
    public int f10714ud;
    @Nullable

    /* renamed from: ut  reason: collision with root package name */
    public Surface f10715ut;

    /* renamed from: v  reason: collision with root package name */
    public final Context f10716v;

    /* renamed from: vl  reason: collision with root package name */
    public uo.n3 f10717vl;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f10718w;

    /* renamed from: wz  reason: collision with root package name */
    public final hy.n3 f10719wz;

    /* renamed from: x  reason: collision with root package name */
    public int f10720x;

    /* renamed from: x4  reason: collision with root package name */
    public final long f10721x4;

    /* renamed from: xc  reason: collision with root package name */
    public final List<v> f10722xc;
    @Nullable

    /* renamed from: xg  reason: collision with root package name */
    public a9.v f10723xg;

    /* renamed from: y5  reason: collision with root package name */
    public v5.z6 f10724y5;

    /* renamed from: yc  reason: collision with root package name */
    public wn.d0 f10725yc;

    /* renamed from: yg  reason: collision with root package name */
    public xc f10726yg;

    /* renamed from: yt  reason: collision with root package name */
    public boolean f10727yt;

    /* renamed from: z  reason: collision with root package name */
    public final kx.a f10728z;

    /* renamed from: z6  reason: collision with root package name */
    public boolean f10729z6;

    /* renamed from: zn  reason: collision with root package name */
    public final uo.n3 f10730zn;

    /* loaded from: classes.dex */
    public static final class gv implements wn.f, gk.y, c8.n3 {
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public wn.f f10731fb;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        public gk.y f10732s;
        @Nullable

        /* renamed from: v  reason: collision with root package name */
        public gk.y f10733v;
        @Nullable
        public wn.f y;

        public gv() {
        }

        @Override // gk.y
        public void n3(long j2, float[] fArr) {
            gk.y yVar = this.f10732s;
            if (yVar != null) {
                yVar.n3(j2, fArr);
            }
            gk.y yVar2 = this.f10733v;
            if (yVar2 != null) {
                yVar2.n3(j2, fArr);
            }
        }

        @Override // m1.c8.n3
        public void tl(int i, @Nullable Object obj) {
            if (i != 7) {
                if (i != 8) {
                    if (i == 10000) {
                        gk.t tVar = (gk.t) obj;
                        if (tVar == null) {
                            this.f10731fb = null;
                            this.f10732s = null;
                            return;
                        }
                        this.f10731fb = tVar.getVideoFrameMetadataListener();
                        this.f10732s = tVar.getCameraMotionListener();
                        return;
                    }
                    return;
                }
                this.f10733v = (gk.y) obj;
                return;
            }
            this.y = (wn.f) obj;
        }

        @Override // wn.f
        public void v(long j2, long j4, m mVar, @Nullable MediaFormat mediaFormat) {
            wn.f fVar = this.f10731fb;
            if (fVar != null) {
                fVar.v(j2, j4, mVar, mediaFormat);
            }
            wn.f fVar2 = this.y;
            if (fVar2 != null) {
                fVar2.v(j2, j4, mVar, mediaFormat);
            }
        }

        @Override // gk.y
        public void zn() {
            gk.y yVar = this.f10732s;
            if (yVar != null) {
                yVar.zn();
            }
            gk.y yVar2 = this.f10733v;
            if (yVar2 != null) {
                yVar2.zn();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 {
        public static fj.u0 y(Context context, dm dmVar, boolean z2) {
            fj.rb pq2 = fj.rb.pq(context);
            if (pq2 == null) {
                v5.r.c5("ExoPlayerImpl", "MediaMetricsService unavailable.");
                return new fj.u0(LogSessionId.LOG_SESSION_ID_NONE);
            }
            if (z2) {
                dmVar.mt(pq2);
            }
            return new fj.u0(pq2.qk());
        }
    }

    /* loaded from: classes.dex */
    public static final class v implements oa {

        /* renamed from: n3  reason: collision with root package name */
        public hy f10734n3;
        public final Object y;

        public v(Object obj, hy hyVar) {
            this.y = obj;
            this.f10734n3 = hyVar;
        }

        @Override // m1.oa
        public hy n3() {
            return this.f10734n3;
        }

        @Override // m1.oa
        public Object y() {
            return this.y;
        }
    }

    /* loaded from: classes.dex */
    public final class zn implements wn.n, d9.z, qh.w, hd.v, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, t.n3, gv.n3, n3.InterfaceC0153n3, rv.n3, co.y {
        public zn() {
        }

        @Override // wn.n
        public void a(a9.v vVar) {
            dm.this.f10723xg = vVar;
            dm.this.f10693mt.a(vVar);
        }

        @Override // m1.co.y
        public /* synthetic */ void c(boolean z2) {
            mt.y(this, z2);
        }

        @Override // d9.z
        public void c5(String str, long j2, long j4) {
            dm.this.f10693mt.c5(str, j2, j4);
        }

        @Override // wn.n
        public void co(int i, long j2) {
            dm.this.f10693mt.co(i, j2);
        }

        @Override // m1.co.y
        public void d0(boolean z2) {
            dm.this.ni();
        }

        @Override // d9.z
        public void f(a9.v vVar) {
            dm.this.f10668dm = vVar;
            dm.this.f10693mt.f(vVar);
        }

        @Override // wn.n
        public void f3(long j2, int i) {
            dm.this.f10693mt.f3(j2, i);
        }

        @Override // m1.n3.InterfaceC0153n3
        public void fb() {
            dm.this.w5(false, -1, 3);
        }

        @Override // m1.gv.n3
        public void fh(float f4) {
            dm.this.t6();
        }

        @Override // d9.z
        public void gv(Exception exc) {
            dm.this.f10693mt.gv(exc);
        }

        @Override // d9.z
        public void i4(int i, long j2, long j4) {
            dm.this.f10693mt.i4(i, j2, j4);
        }

        @Override // d9.z
        public void i9(a9.v vVar) {
            dm.this.f10693mt.i9(vVar);
            dm.this.f10697o = null;
            dm.this.f10668dm = null;
        }

        @Override // m1.rv.n3
        public void mt(final int i, final boolean z2) {
            dm.this.f10710t.t(30, new z.y() { // from class: m1.lc
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    ((uo.gv) obj).onDeviceVolumeChanged(i, z2);
                }
            });
        }

        @Override // d9.z
        public /* synthetic */ void n(m mVar) {
            d9.c5.y(this, mVar);
        }

        @Override // wn.n
        public void n3(String str) {
            dm.this.f10693mt.n3(str);
        }

        @Override // qh.w
        public void onCues(final List<qh.n3> list) {
            dm.this.f10710t.t(27, new z.y() { // from class: m1.ct
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    ((uo.gv) obj).onCues(list);
                }
            });
        }

        @Override // hd.v
        public void onMetadata(final Metadata metadata) {
            dm dmVar = dm.this;
            dmVar.f10689kp = dmVar.f10689kp.n3().x(metadata).ej();
            qk l0 = dm.this.l0();
            if (!l0.equals(dm.this.f10681hw)) {
                dm.this.f10681hw = l0;
                dm.this.f10710t.c5(14, new z.y() { // from class: m1.rs
                    @Override // v5.z.y
                    public final void invoke(Object obj) {
                        dm.zn.this.yt((uo.gv) obj);
                    }
                });
            }
            dm.this.f10710t.c5(28, new z.y() { // from class: m1.eb
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    ((uo.gv) obj).onMetadata(Metadata.this);
                }
            });
            dm.this.f10710t.a();
        }

        @Override // d9.z
        public void onSkipSilenceEnabledChanged(final boolean z2) {
            if (dm.this.f10670eb != z2) {
                dm.this.f10670eb = z2;
                dm.this.f10710t.t(23, new z.y() { // from class: m1.e
                    @Override // v5.z.y
                    public final void invoke(Object obj) {
                        ((uo.gv) obj).onSkipSilenceEnabledChanged(z2);
                    }
                });
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i5) {
            dm.this.gm(surfaceTexture);
            dm.this.bx(i, i5);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            dm.this.jf(null);
            dm.this.bx(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i5) {
            dm.this.bx(i, i5);
        }

        @Override // wn.n
        public void onVideoSizeChanged(final wn.d0 d0Var) {
            dm.this.f10725yc = d0Var;
            dm.this.f10710t.t(25, new z.y() { // from class: m1.s8
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    ((uo.gv) obj).onVideoSizeChanged(wn.d0.this);
                }
            });
        }

        @Override // gk.t.n3
        public void p(Surface surface) {
            dm.this.jf(surface);
        }

        @Override // wn.n
        public void r(m mVar, @Nullable a9.c5 c5Var) {
            dm.this.f10702qn = mVar;
            dm.this.f10693mt.r(mVar, c5Var);
        }

        @Override // m1.gv.n3
        public void rz(int i) {
            boolean oz2 = dm.this.oz();
            dm.this.w5(oz2, i, dm.rt(oz2, i));
        }

        @Override // d9.z
        public void s(String str) {
            dm.this.f10693mt.s(str);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i5, int i6) {
            dm.this.bx(i5, i6);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (dm.this.f10675f7) {
                dm.this.jf(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (dm.this.f10675f7) {
                dm.this.jf(null);
            }
            dm.this.bx(0, 0);
        }

        @Override // d9.z
        public void t(long j2) {
            dm.this.f10693mt.t(j2);
        }

        @Override // wn.n
        public void tl(a9.v vVar) {
            dm.this.f10693mt.tl(vVar);
            dm.this.f10702qn = null;
            dm.this.f10723xg = null;
        }

        @Override // wn.n
        public void v(String str, long j2, long j4) {
            dm.this.f10693mt.v(str, j2, j4);
        }

        @Override // gk.t.n3
        public void w(Surface surface) {
            dm.this.jf(null);
        }

        @Override // d9.z
        public void wz(m mVar, @Nullable a9.c5 c5Var) {
            dm.this.f10697o = mVar;
            dm.this.f10693mt.wz(mVar, c5Var);
        }

        @Override // d9.z
        public void x4(Exception exc) {
            dm.this.f10693mt.x4(exc);
        }

        @Override // wn.n
        public void xc(Exception exc) {
            dm.this.f10693mt.xc(exc);
        }

        @Override // wn.n
        public /* synthetic */ void y(m mVar) {
            wn.wz.y(this, mVar);
        }

        public final /* synthetic */ void yt(uo.gv gvVar) {
            gvVar.onMediaMetadataChanged(dm.this.f10681hw);
        }

        @Override // wn.n
        public void z(Object obj, long j2) {
            dm.this.f10693mt.z(obj, j2);
            if (dm.this.f10699oz == obj) {
                dm.this.f10710t.t(26, new z.y() { // from class: m1.ra
                    @Override // v5.z.y
                    public final void invoke(Object obj2) {
                        ((uo.gv) obj2).onRenderedFirstFrame();
                    }
                });
            }
        }

        @Override // m1.rv.n3
        public void zn(int i) {
            final xc zh = dm.zh(dm.this.f10677fh);
            if (!zh.equals(dm.this.f10726yg)) {
                dm.this.f10726yg = zh;
                dm.this.f10710t.t(29, new z.y() { // from class: m1.nf
                    @Override // v5.z.y
                    public final void invoke(Object obj) {
                        ((uo.gv) obj).onDeviceInfoChanged(xc.this);
                    }
                });
            }
        }

        @Override // qh.w
        public void onCues(final qh.a aVar) {
            dm.this.f10690lc = aVar;
            dm.this.f10710t.t(27, new z.y() { // from class: m1.o4
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    ((uo.gv) obj).onCues(qh.a.this);
                }
            });
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    static {
        kp.y("goog.exo.exoplayer");
    }

    @SuppressLint({"HandlerLeak"})
    public dm(co.n3 n3Var, @Nullable uo uoVar) {
        boolean z2;
        uo uoVar2;
        fj.u0 y2;
        d9.v vVar;
        boolean z3;
        boolean z4;
        final dm dmVar = this;
        v5.s sVar = new v5.s();
        dmVar.f10680gv = sVar;
        try {
            v5.r.a("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.18.7] [" + v5.j5.f14367v + "]");
            Context applicationContext = n3Var.y.getApplicationContext();
            dmVar.f10716v = applicationContext;
            fj.y apply = n3Var.f10623c5.apply(n3Var.f10635n3);
            dmVar.f10693mt = apply;
            dmVar.f10669e = n3Var.f10626f;
            dmVar.f10698o4 = n3Var.f10640t;
            dmVar.f10686jz = n3Var.f10636p;
            dmVar.f10713u = n3Var.f10633mt;
            dmVar.f10670eb = n3Var.f10643w;
            dmVar.f10711ta = n3Var.f10634n;
            zn znVar = new zn();
            dmVar.f10674f3 = znVar;
            gv gvVar = new gv();
            dmVar.f10694n = gvVar;
            Handler handler = new Handler(n3Var.f10632i9);
            zq[] y7 = n3Var.f10630gv.get().y(handler, znVar, znVar, znVar, znVar);
            dmVar.f10676fb = y7;
            if (y7.length > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.fb(z2);
            zo.fh fhVar = n3Var.f10621a.get();
            dmVar.f10708s = fhVar;
            dmVar.f10700p = n3Var.f10642v.get();
            kx.a aVar = n3Var.f10639s.get();
            dmVar.f10728z = aVar;
            dmVar.f10718w = n3Var.f10624co;
            dmVar.f10661b = n3Var.f10647z;
            dmVar.f10703r = n3Var.f10637r;
            dmVar.f10721x4 = n3Var.f10645x4;
            dmVar.f10727yt = n3Var.f10622c;
            Looper looper = n3Var.f10632i9;
            dmVar.f10664co = looper;
            v5.v vVar2 = n3Var.f10635n3;
            dmVar.f10682i4 = vVar2;
            if (uoVar == null) {
                uoVar2 = dmVar;
            } else {
                uoVar2 = uoVar;
            }
            dmVar.f10658a = uoVar2;
            dmVar.f10710t = new v5.z<>(looper, vVar2, new z.n3() { // from class: m1.j5
                @Override // v5.z.n3
                public final void y(Object obj, v5.wz wzVar) {
                    dm.this.vi((uo.gv) obj, wzVar);
                }
            });
            dmVar.f10712tl = new CopyOnWriteArraySet<>();
            dmVar.f10722xc = new ArrayList();
            dmVar.f10688k5 = new u.y(0);
            zo.rz rzVar = new zo.rz(new ic[y7.length], new zo.co[y7.length], v1.f11282v, null);
            dmVar.f10695n3 = rzVar;
            dmVar.f10719wz = new hy.n3();
            uo.n3 v2 = new uo.n3.y().zn(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 23, 24, 25, 26, 27, 28).gv(29, fhVar.s()).v();
            dmVar.f10730zn = v2;
            dmVar.f10717vl = new uo.n3.y().n3(v2).y(4).y(10).v();
            dmVar.f10663c5 = vVar2.n3(looper, null);
            yc.a aVar2 = new yc.a() { // from class: m1.qn
                @Override // m1.yc.a
                public final void y(yc.v vVar3) {
                    dm.this.e5(vVar3);
                }
            };
            dmVar.f10683i9 = aVar2;
            dmVar.f10705rb = bv.i9(rzVar);
            apply.yt(uoVar2, looper);
            int i = v5.j5.y;
            if (i < 31) {
                y2 = new fj.u0();
            } else {
                y2 = n3.y(applicationContext, dmVar, n3Var.f10625d0);
            }
            try {
                yc ycVar = new yc(y7, fhVar, rzVar, n3Var.f10628fb.get(), aVar, dmVar.f10666d, dmVar.f10729z6, apply, dmVar.f10661b, n3Var.f10631i4, n3Var.f10627f3, dmVar.f10727yt, looper, vVar2, aVar2, y2, n3Var.f10629fh);
                dmVar = this;
                dmVar.f10673f = ycVar;
                dmVar.f10706rs = 1.0f;
                dmVar.f10666d = 0;
                qk qkVar = qk.f11140dm;
                dmVar.f10681hw = qkVar;
                dmVar.f10685j5 = qkVar;
                dmVar.f10689kp = qkVar;
                dmVar.f10679g3 = -1;
                if (i < 21) {
                    dmVar.f10665ct = dmVar.hf(0);
                } else {
                    dmVar.f10665ct = v5.j5.d(applicationContext);
                }
                dmVar.f10690lc = qh.a.f12834fb;
                dmVar.f10696nf = true;
                dmVar.g(apply);
                aVar.c5(new Handler(looper), apply);
                dmVar.v1(znVar);
                long j2 = n3Var.f10648zn;
                if (j2 > 0) {
                    ycVar.r(j2);
                }
                m1.n3 n3Var2 = new m1.n3(n3Var.y, handler, znVar);
                dmVar.f10662c = n3Var2;
                n3Var2.n3(n3Var.f10646xc);
                m1.gv gvVar2 = new m1.gv(n3Var.y, handler, znVar);
                dmVar.f10667d0 = gvVar2;
                if (n3Var.f10641tl) {
                    vVar = dmVar.f10698o4;
                } else {
                    vVar = null;
                }
                gvVar2.tl(vVar);
                rv rvVar = new rv(n3Var.y, handler, znVar);
                dmVar.f10677fh = rvVar;
                rvVar.s(v5.j5.rs(dmVar.f10698o4.f7207fb));
                gi giVar = new gi(n3Var.y);
                dmVar.f10707rz = giVar;
                if (n3Var.f10644wz != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                giVar.y(z3);
                zx zxVar = new zx(n3Var.y);
                dmVar.f10692mg = zxVar;
                if (n3Var.f10644wz == 2) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                zxVar.y(z4);
                dmVar.f10726yg = zh(rvVar);
                dmVar.f10725yc = wn.d0.f14575f;
                dmVar.f10724y5 = v5.z6.f14427zn;
                fhVar.t(dmVar.f10698o4);
                dmVar.y0(1, 10, Integer.valueOf(dmVar.f10665ct));
                dmVar.y0(2, 10, Integer.valueOf(dmVar.f10665ct));
                dmVar.y0(1, 3, dmVar.f10698o4);
                dmVar.y0(2, 4, Integer.valueOf(dmVar.f10686jz));
                dmVar.y0(2, 5, Integer.valueOf(dmVar.f10713u));
                dmVar.y0(1, 9, Boolean.valueOf(dmVar.f10670eb));
                dmVar.y0(2, 7, gvVar);
                dmVar.y0(6, 8, gvVar);
                sVar.a();
            } catch (Throwable th) {
                th = th;
                dmVar = this;
                dmVar.f10680gv.a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static /* synthetic */ void cw(bv bvVar, int i, uo.gv gvVar) {
        gvVar.onPlayWhenReadyChanged(bvVar.f10597t, i);
    }

    public static /* synthetic */ void ez(bv bvVar, uo.gv gvVar) {
        gvVar.onPlayerError(bvVar.f10587a);
    }

    public static long hj(bv bvVar) {
        hy.gv gvVar = new hy.gv();
        hy.n3 n3Var = new hy.n3();
        bvVar.y.t(bvVar.f10594n3.y, n3Var);
        if (bvVar.f10603zn == -9223372036854775807L) {
            return bvVar.y.mt(n3Var.f10828fb, gvVar).v();
        }
        return n3Var.p() + bvVar.f10603zn;
    }

    public static /* synthetic */ void iu(bv bvVar, uo.gv gvVar) {
        gvVar.onPlaybackStateChanged(bvVar.f10599v);
    }

    public static /* synthetic */ void jm(bv bvVar, int i, uo.gv gvVar) {
        gvVar.onTimelineChanged(bvVar.y, i);
    }

    public static /* synthetic */ void l8(bv bvVar, uo.gv gvVar) {
        gvVar.onIsPlayingChanged(w7(bvVar));
    }

    public static /* synthetic */ void mc(bv bvVar, uo.gv gvVar) {
        gvVar.onPlayerErrorChanged(bvVar.f10587a);
    }

    public static /* synthetic */ void mq(int i, uo.v vVar, uo.v vVar2, uo.gv gvVar) {
        gvVar.onPositionDiscontinuity(i);
        gvVar.onPositionDiscontinuity(vVar, vVar2, i);
    }

    public static /* synthetic */ void nz(bv bvVar, uo.gv gvVar) {
        gvVar.onPlaybackSuppressionReasonChanged(bvVar.f10598tl);
    }

    public static /* synthetic */ void p2(bv bvVar, uo.gv gvVar) {
        gvVar.onPlayerStateChanged(bvVar.f10597t, bvVar.f10599v);
    }

    public static int rt(boolean z2, int i) {
        if (!z2 || i == 1) {
            return 1;
        }
        return 2;
    }

    public static /* synthetic */ void t7(bv bvVar, uo.gv gvVar) {
        gvVar.onLoadingChanged(bvVar.f10590fb);
        gvVar.onIsLoadingChanged(bvVar.f10590fb);
    }

    public static boolean w7(bv bvVar) {
        if (bvVar.f10599v == 3 && bvVar.f10597t && bvVar.f10598tl == 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ void wb(bv bvVar, uo.gv gvVar) {
        gvVar.onTracksChanged(bvVar.f10588c5.f15771gv);
    }

    public static /* synthetic */ void xh(bv bvVar, uo.gv gvVar) {
        gvVar.onPlaybackParametersChanged(bvVar.f10601wz);
    }

    public static /* synthetic */ void yh(uo.gv gvVar) {
        gvVar.onPlayerError(p.x4(new rb(1), 1003));
    }

    public static xc zh(rv rvVar) {
        return new xc(0, rvVar.gv(), rvVar.zn());
    }

    @Override // m1.uo
    public hy b() {
        r3();
        return this.f10705rb.y;
    }

    @Override // m1.uo
    public long bk() {
        r3();
        if (this.f10705rb.y.r()) {
            return this.f10678g;
        }
        bv bvVar = this.f10705rb;
        if (bvVar.f10589f.f238gv != bvVar.f10594n3.f238gv) {
            return bvVar.y.mt(kp(), this.y).a();
        }
        long j2 = bvVar.f10600w;
        if (this.f10705rb.f10589f.n3()) {
            bv bvVar2 = this.f10705rb;
            hy.n3 t2 = bvVar2.y.t(bvVar2.f10589f.y, this.f10719wz);
            long c52 = t2.c5(this.f10705rb.f10589f.f239n3);
            if (c52 == Long.MIN_VALUE) {
                j2 = t2.f10829s;
            } else {
                j2 = c52;
            }
        }
        bv bvVar3 = this.f10705rb;
        return v5.j5.gf(ja(bvVar3.y, bvVar3.f10589f, j2));
    }

    public final void bx(final int i, final int i5) {
        if (i != this.f10724y5.n3() || i5 != this.f10724y5.y()) {
            this.f10724y5 = new v5.z6(i, i5);
            this.f10710t.t(24, new z.y() { // from class: m1.j
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    ((uo.gv) obj).onSurfaceSizeChanged(i, i5);
                }
            });
        }
    }

    @Override // m1.uo
    public int c5() {
        r3();
        return this.f10666d;
    }

    public final bv cp(int i, int i5) {
        int kp2 = kp();
        hy b2 = b();
        int size = this.f10722xc.size();
        this.f10671ej++;
        gd(i, i5);
        hy hb = hb();
        bv wv = wv(this.f10705rb, hb, t5(b2, hb));
        int i6 = wv.f10599v;
        if (i6 != 1 && i6 != 4 && i < i5 && i5 == size && kp2 >= wv.y.z()) {
            wv = wv.fb(4);
        }
        this.f10673f.s8(i, i5, this.f10688k5);
        return wv;
    }

    @Override // m1.co
    public void d(boolean z2) {
        r3();
        if (this.f10660ap) {
            return;
        }
        this.f10662c.n3(z2);
    }

    @Override // m1.uo
    public v1 d0() {
        r3();
        return this.f10705rb.f10588c5.f15771gv;
    }

    @Override // m1.co
    public void dm(List<af.mg> list) {
        r3();
        zx(this.f10722xc.size(), list);
    }

    @Override // m1.uo
    public void e(uo.gv gvVar) {
        r3();
        this.f10710t.f((uo.gv) v5.y.v(gvVar));
    }

    public final /* synthetic */ void e5(final yc.v vVar) {
        this.f10663c5.c5(new Runnable() { // from class: m1.oz
            @Override // java.lang.Runnable
            public final void run() {
                dm.this.l3(vVar);
            }
        });
    }

    @Override // m1.uo
    public void eb(final zo.c cVar) {
        r3();
        if (this.f10708s.s() && !cVar.equals(this.f10708s.v())) {
            this.f10708s.tl(cVar);
            this.f10710t.t(19, new z.y() { // from class: m1.k
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    ((uo.gv) obj).onTrackSelectionParametersChanged(zo.c.this);
                }
            });
        }
    }

    @Override // m1.co
    public void ej(List<af.mg> list, int i, long j2) {
        r3();
        m5(list, i, j2, false);
    }

    @Override // m1.uo
    public int en() {
        r3();
        if (this.f10705rb.y.r()) {
            return this.f10691m;
        }
        bv bvVar = this.f10705rb;
        return bvVar.y.a(bvVar.f10594n3.y);
    }

    @Override // m1.uo
    public long f() {
        r3();
        return v5.j5.gf(this.f10705rb.f10595p);
    }

    @Override // m1.uo
    public long f7() {
        r3();
        return 3000L;
    }

    @Override // m1.co
    public void fh(List<af.mg> list, boolean z2) {
        r3();
        m5(list, -1, -9223372036854775807L, z2);
    }

    public final void fm() {
        uo.n3 n3Var = this.f10717vl;
        uo.n3 ej2 = v5.j5.ej(this.f10658a, this.f10730zn);
        this.f10717vl = ej2;
        if (!ej2.equals(n3Var)) {
            this.f10710t.c5(13, new z.y() { // from class: m1.ut
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    dm.this.ih((uo.gv) obj);
                }
            });
        }
    }

    public final uo.v fp(int i, bv bvVar, int i5) {
        int i6;
        Object obj;
        o0 o0Var;
        Object obj2;
        int i8;
        long j2;
        long hj;
        hy.n3 n3Var = new hy.n3();
        if (!bvVar.y.r()) {
            Object obj3 = bvVar.f10594n3.y;
            bvVar.y.t(obj3, n3Var);
            int i10 = n3Var.f10828fb;
            int a2 = bvVar.y.a(obj3);
            Object obj4 = bvVar.y.mt(i10, this.y).y;
            o0Var = this.y.f10811fb;
            obj2 = obj3;
            i8 = a2;
            obj = obj4;
            i6 = i10;
        } else {
            i6 = i5;
            obj = null;
            o0Var = null;
            obj2 = null;
            i8 = -1;
        }
        if (i == 0) {
            if (bvVar.f10594n3.n3()) {
                mg.n3 n3Var2 = bvVar.f10594n3;
                j2 = n3Var.v(n3Var2.f239n3, n3Var2.f241zn);
                hj = hj(bvVar);
            } else {
                if (bvVar.f10594n3.f240v != -1) {
                    j2 = hj(this.f10705rb);
                } else {
                    j2 = n3Var.f10827f + n3Var.f10829s;
                }
                hj = j2;
            }
        } else if (bvVar.f10594n3.n3()) {
            j2 = bvVar.f10593mt;
            hj = hj(bvVar);
        } else {
            j2 = n3Var.f10827f + bvVar.f10593mt;
            hj = j2;
        }
        long gf = v5.j5.gf(j2);
        long gf2 = v5.j5.gf(hj);
        mg.n3 n3Var3 = bvVar.f10594n3;
        return new uo.v(obj, i6, o0Var, obj2, i8, gf, gf2, n3Var3.f239n3, n3Var3.f241zn);
    }

    public final Pair<Boolean, Integer> fq(bv bvVar, bv bvVar2, boolean z2, int i, boolean z3, boolean z4) {
        hy hyVar = bvVar2.y;
        hy hyVar2 = bvVar.y;
        if (hyVar2.r() && hyVar.r()) {
            return new Pair<>(Boolean.FALSE, -1);
        }
        int i5 = 3;
        if (hyVar2.r() != hyVar.r()) {
            return new Pair<>(Boolean.TRUE, 3);
        }
        if (!hyVar.mt(hyVar.t(bvVar2.f10594n3.y, this.f10719wz).f10828fb, this.y).y.equals(hyVar2.mt(hyVar2.t(bvVar.f10594n3.y, this.f10719wz).f10828fb, this.y).y)) {
            if (z2 && i == 0) {
                i5 = 1;
            } else if (z2 && i == 1) {
                i5 = 2;
            } else if (!z3) {
                throw new IllegalStateException();
            }
            return new Pair<>(Boolean.TRUE, Integer.valueOf(i5));
        } else if (z2 && i == 0 && bvVar2.f10594n3.f238gv < bvVar.f10594n3.f238gv) {
            return new Pair<>(Boolean.TRUE, 0);
        } else {
            if (z2 && i == 1 && z4) {
                return new Pair<>(Boolean.TRUE, 2);
            }
            return new Pair<>(Boolean.FALSE, -1);
        }
    }

    @Override // m1.uo
    public void g(uo.gv gvVar) {
        this.f10710t.zn((uo.gv) v5.y.v(gvVar));
    }

    @Override // m1.uo
    public void g3(@Nullable SurfaceView surfaceView) {
        SurfaceHolder holder;
        r3();
        if (surfaceView == null) {
            holder = null;
        } else {
            holder = surfaceView.getHolder();
        }
        wo(holder);
    }

    public final void gd(int i, int i5) {
        for (int i6 = i5 - 1; i6 >= i; i6--) {
            this.f10722xc.remove(i6);
        }
        this.f10688k5 = this.f10688k5.co(i, i5);
    }

    @Override // m1.co
    public int getAudioSessionId() {
        r3();
        return this.f10665ct;
    }

    @Override // m1.uo
    public long getCurrentPosition() {
        r3();
        return v5.j5.gf(ux(this.f10705rb));
    }

    @Override // m1.uo
    public long getDuration() {
        r3();
        if (i9()) {
            bv bvVar = this.f10705rb;
            mg.n3 n3Var = bvVar.f10594n3;
            bvVar.y.t(n3Var.y, this.f10719wz);
            return v5.j5.gf(this.f10719wz.v(n3Var.f239n3, n3Var.f241zn));
        }
        return co();
    }

    @Override // m1.uo
    public float getVolume() {
        r3();
        return this.f10706rs;
    }

    public final List<j3.zn> gi(int i, List<af.mg> list) {
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < list.size(); i5++) {
            j3.zn znVar = new j3.zn(list.get(i5), this.f10718w);
            arrayList.add(znVar);
            this.f10722xc.add(i5 + i, new v(znVar.f10892n3, znVar.y.vp()));
        }
        this.f10688k5 = this.f10688k5.f3(i, arrayList.size());
        return arrayList;
    }

    public final void gm(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        jf(surface);
        this.f10715ut = surface;
    }

    @Override // m1.uo
    public void gv(final int i) {
        r3();
        if (this.f10666d != i) {
            this.f10666d = i;
            this.f10673f.cs(i);
            this.f10710t.c5(8, new z.y() { // from class: m1.o
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    ((uo.gv) obj).onRepeatModeChanged(i);
                }
            });
            fm();
            this.f10710t.a();
        }
    }

    public final hy hb() {
        return new h(this.f10722xc, this.f10688k5);
    }

    public final int hf(int i) {
        AudioTrack audioTrack = this.f10684j;
        if (audioTrack != null && audioTrack.getAudioSessionId() != i) {
            this.f10684j.release();
            this.f10684j = null;
        }
        if (this.f10684j == null) {
            this.f10684j = new AudioTrack(3, 4000, 4, 2, 2, 0, i);
        }
        return this.f10684j.getAudioSessionId();
    }

    @Override // m1.uo
    public void hw(@Nullable TextureView textureView) {
        SurfaceTexture surfaceTexture;
        r3();
        if (textureView == null) {
            rs();
            return;
        }
        ng();
        this.f10672en = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            v5.r.c5("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f10674f3);
        if (textureView.isAvailable()) {
            surfaceTexture = textureView.getSurfaceTexture();
        } else {
            surfaceTexture = null;
        }
        if (surfaceTexture == null) {
            jf(null);
            bx(0, 0);
            return;
        }
        gm(surfaceTexture);
        bx(textureView.getWidth(), textureView.getHeight());
    }

    @Override // m1.uo
    public boolean i9() {
        r3();
        return this.f10705rb.f10594n3.n3();
    }

    public final /* synthetic */ void ih(uo.gv gvVar) {
        gvVar.onAvailableCommandsChanged(this.f10717vl);
    }

    public final void ik(boolean z2) {
        v5.ta taVar = this.f10669e;
        if (taVar != null) {
            if (z2 && !this.f10709s8) {
                taVar.y(0);
                this.f10709s8 = true;
            } else if (!z2 && this.f10709s8) {
                taVar.zn(0);
                this.f10709s8 = false;
            }
        }
    }

    @Override // m1.uo
    public uo.n3 j() {
        r3();
        return this.f10717vl;
    }

    @Override // m1.co
    public int j5(int i) {
        r3();
        return this.f10676fb[i].s();
    }

    public final long ja(hy hyVar, mg.n3 n3Var, long j2) {
        hyVar.t(n3Var.y, this.f10719wz);
        return j2 + this.f10719wz.p();
    }

    public final void jf(@Nullable Object obj) {
        boolean z2;
        ArrayList<c8> arrayList = new ArrayList();
        zq[] zqVarArr = this.f10676fb;
        int length = zqVarArr.length;
        int i = 0;
        while (true) {
            z2 = true;
            if (i >= length) {
                break;
            }
            zq zqVar = zqVarArr[i];
            if (zqVar.s() == 2) {
                arrayList.add(vb(zqVar).wz(1).tl(obj).t());
            }
            i++;
        }
        Object obj2 = this.f10699oz;
        if (obj2 != null && obj2 != obj) {
            try {
                for (c8 c8Var : arrayList) {
                    c8Var.y(this.f10711ta);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
            }
            z2 = false;
            Object obj3 = this.f10699oz;
            Surface surface = this.f10715ut;
            if (obj3 == surface) {
                surface.release();
                this.f10715ut = null;
            }
        } else {
            z2 = false;
        }
        this.f10699oz = obj;
        if (z2) {
            mf(false, p.x4(new rb(3), 1003));
        }
    }

    @Override // m1.uo
    public void jz(@Nullable TextureView textureView) {
        r3();
        if (textureView != null && textureView == this.f10672en) {
            rs();
        }
    }

    @Override // m1.co
    public int k() {
        r3();
        return this.f10676fb.length;
    }

    @Override // m1.uo
    public Looper k5() {
        return this.f10664co;
    }

    @Override // m1.uo
    public int kp() {
        r3();
        int vd = vd();
        if (vd == -1) {
            return 0;
        }
        return vd;
    }

    public final uo.v ks(long j2) {
        Object obj;
        o0 o0Var;
        Object obj2;
        int i;
        long j4;
        int kp2 = kp();
        if (!this.f10705rb.y.r()) {
            bv bvVar = this.f10705rb;
            Object obj3 = bvVar.f10594n3.y;
            bvVar.y.t(obj3, this.f10719wz);
            int a2 = this.f10705rb.y.a(obj3);
            i = a2;
            obj2 = obj3;
            obj = this.f10705rb.y.mt(kp2, this.y).y;
            o0Var = this.y.f10811fb;
        } else {
            obj = null;
            o0Var = null;
            obj2 = null;
            i = -1;
        }
        long gf = v5.j5.gf(j2);
        if (this.f10705rb.f10594n3.n3()) {
            j4 = v5.j5.gf(hj(this.f10705rb));
        } else {
            j4 = gf;
        }
        mg.n3 n3Var = this.f10705rb.f10594n3;
        return new uo.v(obj, kp2, o0Var, obj2, i, gf, j4, n3Var.f239n3, n3Var.f241zn);
    }

    public final qk l0() {
        hy b2 = b();
        if (b2.r()) {
            return this.f10689kp;
        }
        return this.f10689kp.n3().a8(b2.mt(kp(), this.y).f10811fb.f11017f).ej();
    }

    public final void m5(List<af.mg> list, int i, long j2, boolean z2) {
        int i5;
        long j4;
        int vd = vd();
        long currentPosition = getCurrentPosition();
        boolean z3 = true;
        this.f10671ej++;
        if (!this.f10722xc.isEmpty()) {
            gd(0, this.f10722xc.size());
        }
        List<j3.zn> gi = gi(0, list);
        hy hb = hb();
        if (!hb.r() && i >= hb.z()) {
            throw new tg(hb, i, j2);
        }
        if (z2) {
            j4 = -9223372036854775807L;
            i5 = hb.v(this.f10729z6);
        } else if (i == -1) {
            i5 = vd;
            j4 = currentPosition;
        } else {
            i5 = i;
            j4 = j2;
        }
        bv wv = wv(this.f10705rb, hb, rk(hb, i5, j4));
        int i6 = wv.f10599v;
        if (i5 != -1 && i6 != 1) {
            i6 = (hb.r() || i5 >= hb.z()) ? 4 : 2;
        }
        bv fb2 = wv.fb(i6);
        this.f10673f.oa(gi, i5, v5.j5.xb(j4), this.f10688k5);
        p4(fb2, 0, 1, false, (this.f10705rb.f10594n3.y.equals(fb2.f10594n3.y) || this.f10705rb.y.r()) ? false : false, 4, ux(fb2), -1, false);
    }

    public final void mf(boolean z2, @Nullable p pVar) {
        bv n32;
        boolean z3;
        if (z2) {
            n32 = cp(0, this.f10722xc.size()).v(null);
        } else {
            bv bvVar = this.f10705rb;
            n32 = bvVar.n3(bvVar.f10594n3);
            n32.f10600w = n32.f10593mt;
            n32.f10595p = 0L;
        }
        bv fb2 = n32.fb(1);
        if (pVar != null) {
            fb2 = fb2.v(pVar);
        }
        bv bvVar2 = fb2;
        this.f10671ej++;
        this.f10673f.fc();
        if (bvVar2.y.r() && !this.f10705rb.y.r()) {
            z3 = true;
        } else {
            z3 = false;
        }
        p4(bvVar2, 0, 1, false, z3, 4, ux(bvVar2), -1, false);
    }

    @Override // m1.uo
    public qh.a mg() {
        r3();
        return this.f10690lc;
    }

    @Override // m1.co
    public void mt(fj.zn znVar) {
        this.f10693mt.x((fj.zn) v5.y.v(znVar));
    }

    @Override // m1.uo
    public void n(boolean z2) {
        r3();
        int w4 = this.f10667d0.w(z2, n3());
        w5(z2, w4, rt(z2, w4));
    }

    @Override // m1.uo
    public int n3() {
        r3();
        return this.f10705rb.f10599v;
    }

    @Override // m1.uo
    public long nf() {
        r3();
        return this.f10721x4;
    }

    public final void ng() {
        if (this.f10687k != null) {
            vb(this.f10694n).wz(10000).tl(null).t();
            this.f10687k.c5(this.f10674f3);
            this.f10687k = null;
        }
        TextureView textureView = this.f10672en;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f10674f3) {
                v5.r.c5("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f10672en.setSurfaceTextureListener(null);
            }
            this.f10672en = null;
        }
        SurfaceHolder surfaceHolder = this.f10701q9;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f10674f3);
            this.f10701q9 = null;
        }
    }

    public final void ni() {
        int n32 = n3();
        boolean z2 = true;
        if (n32 != 1) {
            if (n32 != 2 && n32 != 3) {
                if (n32 != 4) {
                    throw new IllegalStateException();
                }
            } else {
                this.f10707rz.n3((!oz() || sx()) ? false : false);
                this.f10692mg.n3(oz());
                return;
            }
        }
        this.f10707rz.n3(false);
        this.f10692mg.n3(false);
    }

    @Override // m1.v
    public void o0(int i, long j2, int i5, boolean z2) {
        boolean z3;
        r3();
        int i6 = 1;
        if (i >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        v5.y.y(z3);
        this.f10693mt.d0();
        hy hyVar = this.f10705rb.y;
        if (!hyVar.r() && i >= hyVar.z()) {
            return;
        }
        this.f10671ej++;
        if (i9()) {
            v5.r.c5("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            yc.v vVar = new yc.v(this.f10705rb);
            vVar.n3(1);
            this.f10683i9.y(vVar);
            return;
        }
        if (n3() != 1) {
            i6 = 2;
        }
        int kp2 = kp();
        bv wv = wv(this.f10705rb.fb(i6), hyVar, rk(hyVar, i, j2));
        this.f10673f.pz(hyVar, i, v5.j5.xb(j2));
        p4(wv, 0, 1, true, true, 1, ux(wv), kp2, z2);
    }

    public final List<af.mg> ob(List<o0> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(this.f10700p.n3(list.get(i)));
        }
        return arrayList;
    }

    public final void op(SurfaceHolder surfaceHolder) {
        this.f10675f7 = false;
        this.f10701q9 = surfaceHolder;
        surfaceHolder.addCallback(this.f10674f3);
        Surface surface = this.f10701q9.getSurface();
        if (surface != null && surface.isValid()) {
            Rect surfaceFrame = this.f10701q9.getSurfaceFrame();
            bx(surfaceFrame.width(), surfaceFrame.height());
            return;
        }
        bx(0, 0);
    }

    @Override // m1.uo
    public boolean oz() {
        r3();
        return this.f10705rb.f10597t;
    }

    @Override // m1.uo
    public void p(@Nullable SurfaceView surfaceView) {
        SurfaceHolder holder;
        r3();
        if (surfaceView instanceof wn.i9) {
            ng();
            jf(surfaceView);
            op(surfaceView.getHolder());
        } else if (surfaceView instanceof gk.t) {
            ng();
            this.f10687k = (gk.t) surfaceView;
            vb(this.f10694n).wz(10000).tl(this.f10687k).t();
            this.f10687k.gv(this.f10674f3);
            jf(this.f10687k.getVideoSurface());
            op(surfaceView.getHolder());
        } else {
            if (surfaceView == null) {
                holder = null;
            } else {
                holder = surfaceView.getHolder();
            }
            x2(holder);
        }
    }

    public final void p4(final bv bvVar, final int i, final int i5, boolean z2, boolean z3, final int i6, long j2, int i8, boolean z4) {
        boolean z5;
        boolean z7;
        boolean z8;
        bv bvVar2 = this.f10705rb;
        this.f10705rb = bvVar;
        boolean equals = bvVar2.y.equals(bvVar.y);
        Pair<Boolean, Integer> fq = fq(bvVar, bvVar2, z3, i6, !equals, z4);
        boolean booleanValue = ((Boolean) fq.first).booleanValue();
        final int intValue = ((Integer) fq.second).intValue();
        qk qkVar = this.f10681hw;
        final o0 o0Var = null;
        if (booleanValue) {
            if (!bvVar.y.r()) {
                o0Var = bvVar.y.mt(bvVar.y.t(bvVar.f10594n3.y, this.f10719wz).f10828fb, this.y).f10811fb;
            }
            this.f10689kp = qk.f11140dm;
        }
        if (booleanValue || !bvVar2.f10592i9.equals(bvVar.f10592i9)) {
            this.f10689kp = this.f10689kp.n3().b(bvVar.f10592i9).ej();
            qkVar = l0();
        }
        boolean equals2 = qkVar.equals(this.f10681hw);
        this.f10681hw = qkVar;
        if (bvVar2.f10597t != bvVar.f10597t) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (bvVar2.f10599v != bvVar.f10599v) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7 || z5) {
            ni();
        }
        boolean z9 = bvVar2.f10590fb;
        boolean z10 = bvVar.f10590fb;
        if (z9 != z10) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            ik(z10);
        }
        if (!equals) {
            this.f10710t.c5(0, new z.y() { // from class: m1.f7
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    dm.jm(bv.this, i, (uo.gv) obj);
                }
            });
        }
        if (z3) {
            final uo.v fp = fp(i6, bvVar2, i8);
            final uo.v ks = ks(j2);
            this.f10710t.c5(11, new z.y() { // from class: m1.d
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    dm.mq(i6, fp, ks, (uo.gv) obj);
                }
            });
        }
        if (booleanValue) {
            this.f10710t.c5(1, new z.y() { // from class: m1.z6
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    ((uo.gv) obj).onMediaItemTransition(o0.this, intValue);
                }
            });
        }
        if (bvVar2.f10587a != bvVar.f10587a) {
            this.f10710t.c5(10, new z.y() { // from class: m1.ej
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    dm.mc(bv.this, (uo.gv) obj);
                }
            });
            if (bvVar.f10587a != null) {
                this.f10710t.c5(10, new z.y() { // from class: m1.ud
                    @Override // v5.z.y
                    public final void invoke(Object obj) {
                        dm.ez(bv.this, (uo.gv) obj);
                    }
                });
            }
        }
        zo.rz rzVar = bvVar2.f10588c5;
        zo.rz rzVar2 = bvVar.f10588c5;
        if (rzVar != rzVar2) {
            this.f10708s.c5(rzVar2.f15773v);
            this.f10710t.c5(2, new z.y() { // from class: m1.a8
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    dm.wb(bv.this, (uo.gv) obj);
                }
            });
        }
        if (!equals2) {
            final qk qkVar2 = this.f10681hw;
            this.f10710t.c5(14, new z.y() { // from class: m1.x
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    ((uo.gv) obj).onMediaMetadataChanged(qk.this);
                }
            });
        }
        if (z8) {
            this.f10710t.c5(3, new z.y() { // from class: m1.b
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    dm.t7(bv.this, (uo.gv) obj);
                }
            });
        }
        if (z7 || z5) {
            this.f10710t.c5(-1, new z.y() { // from class: m1.k5
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    dm.p2(bv.this, (uo.gv) obj);
                }
            });
        }
        if (z7) {
            this.f10710t.c5(4, new z.y() { // from class: m1.yt
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    dm.iu(bv.this, (uo.gv) obj);
                }
            });
        }
        if (z5) {
            this.f10710t.c5(5, new z.y() { // from class: m1.en
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    dm.cw(bv.this, i5, (uo.gv) obj);
                }
            });
        }
        if (bvVar2.f10598tl != bvVar.f10598tl) {
            this.f10710t.c5(6, new z.y() { // from class: m1.jz
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    dm.nz(bv.this, (uo.gv) obj);
                }
            });
        }
        if (w7(bvVar2) != w7(bvVar)) {
            this.f10710t.c5(7, new z.y() { // from class: m1.u
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    dm.l8(bv.this, (uo.gv) obj);
                }
            });
        }
        if (!bvVar2.f10601wz.equals(bvVar.f10601wz)) {
            this.f10710t.c5(12, new z.y() { // from class: m1.y5
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    dm.xh(bv.this, (uo.gv) obj);
                }
            });
        }
        if (z2) {
            this.f10710t.c5(-1, new z.y() { // from class: m1.xg
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    ((uo.gv) obj).onSeekProcessed();
                }
            });
        }
        fm();
        this.f10710t.a();
        if (bvVar2.f10602xc != bvVar.f10602xc) {
            Iterator<co.y> it = this.f10712tl.iterator();
            while (it.hasNext()) {
                it.next().d0(bvVar.f10602xc);
            }
        }
    }

    @Override // m1.uo
    public long pq() {
        r3();
        return this.f10703r;
    }

    @Override // m1.uo
    public void prepare() {
        r3();
        boolean oz2 = oz();
        int i = 2;
        int w4 = this.f10667d0.w(oz2, 2);
        w5(oz2, w4, rt(oz2, w4));
        bv bvVar = this.f10705rb;
        if (bvVar.f10599v != 1) {
            return;
        }
        bv v2 = bvVar.v(null);
        if (v2.y.r()) {
            i = 4;
        }
        bv fb2 = v2.fb(i);
        this.f10671ej++;
        this.f10673f.eb();
        p4(fb2, 1, 1, false, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // m1.uo
    public qk pz() {
        r3();
        return this.f10681hw;
    }

    @Override // m1.uo
    public void q9(boolean z2) {
        r3();
        this.f10667d0.w(oz(), 1);
        mf(z2, null);
        this.f10690lc = new qh.a(z0.x4.j5(), this.f10705rb.f10593mt);
    }

    @Override // m1.co
    public void qn() {
        r3();
        t3(new d9.n(0, 0.0f));
    }

    @Override // m1.uo
    public void r(int i, int i5) {
        boolean z2;
        r3();
        if (i >= 0 && i5 >= i) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        int size = this.f10722xc.size();
        int min = Math.min(i5, size);
        if (i < size && i != min) {
            bv cp = cp(i, min);
            p4(cp, 0, 1, false, !cp.f10594n3.y.equals(this.f10705rb.f10594n3.y), 4, ux(cp), -1, false);
        }
    }

    public final void r3() {
        IllegalStateException illegalStateException;
        this.f10680gv.zn();
        if (Thread.currentThread() != k5().getThread()) {
            String rz2 = v5.j5.rz("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), k5().getThread().getName());
            if (!this.f10696nf) {
                if (this.f10704ra) {
                    illegalStateException = null;
                } else {
                    illegalStateException = new IllegalStateException();
                }
                v5.r.i9("ExoPlayerImpl", rz2, illegalStateException);
                this.f10704ra = true;
                return;
            }
            throw new IllegalStateException(rz2);
        }
    }

    @Override // m1.uo
    public long ra() {
        r3();
        if (i9()) {
            bv bvVar = this.f10705rb;
            bvVar.y.t(bvVar.f10594n3.y, this.f10719wz);
            bv bvVar2 = this.f10705rb;
            if (bvVar2.f10603zn == -9223372036854775807L) {
                return bvVar2.y.mt(kp(), this.y).gv();
            }
            return this.f10719wz.w() + v5.j5.gf(this.f10705rb.f10603zn);
        }
        return getCurrentPosition();
    }

    @Override // m1.co
    public void rb(fj.zn znVar) {
        r3();
        this.f10693mt.rz((fj.zn) v5.y.v(znVar));
    }

    @Override // m1.uo
    public void release() {
        AudioTrack audioTrack;
        v5.r.a("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.18.7] [" + v5.j5.f14367v + "] [" + kp.n3() + "]");
        r3();
        if (v5.j5.y < 21 && (audioTrack = this.f10684j) != null) {
            audioTrack.release();
            this.f10684j = null;
        }
        this.f10662c.n3(false);
        this.f10677fh.fb();
        this.f10707rz.n3(false);
        this.f10692mg.n3(false);
        this.f10667d0.c5();
        if (!this.f10673f.nf()) {
            this.f10710t.t(10, new z.y() { // from class: m1.hw
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    dm.yh((uo.gv) obj);
                }
            });
        }
        this.f10710t.i9();
        this.f10663c5.v(null);
        this.f10728z.s(this.f10693mt);
        bv fb2 = this.f10705rb.fb(1);
        this.f10705rb = fb2;
        bv n32 = fb2.n3(fb2.f10594n3);
        this.f10705rb = n32;
        n32.f10600w = n32.f10593mt;
        this.f10705rb.f10595p = 0L;
        this.f10693mt.release();
        this.f10708s.i9();
        ng();
        Surface surface = this.f10715ut;
        if (surface != null) {
            surface.release();
            this.f10715ut = null;
        }
        if (this.f10709s8) {
            ((v5.ta) v5.y.v(this.f10669e)).zn(0);
            this.f10709s8 = false;
        }
        this.f10690lc = qh.a.f12834fb;
        this.f10660ap = true;
    }

    @Nullable
    public final Pair<Object, Long> rk(hy hyVar, int i, long j2) {
        if (hyVar.r()) {
            this.f10679g3 = i;
            if (j2 == -9223372036854775807L) {
                j2 = 0;
            }
            this.f10678g = j2;
            this.f10691m = 0;
            return null;
        }
        if (i == -1 || i >= hyVar.z()) {
            i = hyVar.v(this.f10729z6);
            j2 = hyVar.mt(i, this.y).gv();
        }
        return hyVar.wz(this.y, this.f10719wz, i, v5.j5.xb(j2));
    }

    @Override // m1.uo
    public void rs() {
        r3();
        ng();
        jf(null);
        bx(0, 0);
    }

    @Override // m1.co
    public void s(final boolean z2) {
        r3();
        if (this.f10670eb == z2) {
            return;
        }
        this.f10670eb = z2;
        y0(1, 9, Boolean.valueOf(z2));
        this.f10710t.t(23, new z.y() { // from class: m1.q9
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((uo.gv) obj).onSkipSilenceEnabledChanged(z2);
            }
        });
    }

    @Override // m1.uo
    public long s8() {
        r3();
        if (i9()) {
            bv bvVar = this.f10705rb;
            if (bvVar.f10589f.equals(bvVar.f10594n3)) {
                return v5.j5.gf(this.f10705rb.f10600w);
            }
            return getDuration();
        }
        return bk();
    }

    @Override // m1.uo
    public void setVolume(float f4) {
        r3();
        final float w4 = v5.j5.w(f4, 0.0f, 1.0f);
        if (this.f10706rs == w4) {
            return;
        }
        this.f10706rs = w4;
        t6();
        this.f10710t.t(22, new z.y() { // from class: m1.vl
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((uo.gv) obj).onVolumeChanged(w4);
            }
        });
    }

    /* renamed from: sh */
    public final void l3(yc.v vVar) {
        long j2;
        boolean z2;
        long j4;
        boolean z3;
        int i = this.f10671ej - vVar.f11393zn;
        this.f10671ej = i;
        boolean z4 = true;
        if (vVar.f11390gv) {
            this.f10714ud = vVar.f11392v;
            this.f10659a8 = true;
        }
        if (vVar.f11388a) {
            this.f10720x = vVar.f11389fb;
        }
        if (i == 0) {
            hy hyVar = vVar.f11391n3.y;
            if (!this.f10705rb.y.r() && hyVar.r()) {
                this.f10679g3 = -1;
                this.f10678g = 0L;
                this.f10691m = 0;
            }
            if (!hyVar.r()) {
                List<hy> ud2 = ((h) hyVar).ud();
                if (ud2.size() == this.f10722xc.size()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                v5.y.fb(z3);
                for (int i5 = 0; i5 < ud2.size(); i5++) {
                    this.f10722xc.get(i5).f10734n3 = ud2.get(i5);
                }
            }
            if (this.f10659a8) {
                if (vVar.f11391n3.f10594n3.equals(this.f10705rb.f10594n3) && vVar.f11391n3.f10591gv == this.f10705rb.f10593mt) {
                    z4 = false;
                }
                if (z4) {
                    if (!hyVar.r() && !vVar.f11391n3.f10594n3.n3()) {
                        bv bvVar = vVar.f11391n3;
                        j4 = ja(hyVar, bvVar.f10594n3, bvVar.f10591gv);
                    } else {
                        j4 = vVar.f11391n3.f10591gv;
                    }
                    j2 = j4;
                } else {
                    j2 = -9223372036854775807L;
                }
                z2 = z4;
            } else {
                j2 = -9223372036854775807L;
                z2 = false;
            }
            this.f10659a8 = false;
            p4(vVar.f11391n3, 1, this.f10720x, false, z2, this.f10714ud, j2, -1, false);
        }
    }

    @Override // m1.uo
    public void stop() {
        r3();
        q9(false);
    }

    public boolean sx() {
        r3();
        return this.f10705rb.f10602xc;
    }

    public void t3(d9.n nVar) {
        r3();
        y0(1, 6, nVar);
    }

    @Nullable
    public final Pair<Object, Long> t5(hy hyVar, hy hyVar2) {
        boolean z2;
        long ra2 = ra();
        int i = -1;
        if (!hyVar.r() && !hyVar2.r()) {
            Pair<Object, Long> wz2 = hyVar.wz(this.y, this.f10719wz, kp(), v5.j5.xb(ra2));
            Object obj = ((Pair) v5.j5.i9(wz2)).first;
            if (hyVar2.a(obj) != -1) {
                return wz2;
            }
            Object y42 = yc.y4(this.y, this.f10719wz, this.f10666d, this.f10729z6, obj, hyVar, hyVar2);
            if (y42 != null) {
                hyVar2.t(y42, this.f10719wz);
                int i5 = this.f10719wz.f10828fb;
                return rk(hyVar2, i5, hyVar2.mt(i5, this.y).gv());
            }
            return rk(hyVar2, -1, -9223372036854775807L);
        }
        if (!hyVar.r() && hyVar2.r()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            i = vd();
        }
        if (z2) {
            ra2 = -9223372036854775807L;
        }
        return rk(hyVar2, i, ra2);
    }

    public final void t6() {
        y0(1, 2, Float.valueOf(this.f10706rs * this.f10667d0.fb()));
    }

    @Override // m1.uo
    public int ta() {
        r3();
        if (i9()) {
            return this.f10705rb.f10594n3.f239n3;
        }
        return -1;
    }

    @Override // m1.uo
    public wn.d0 u() {
        r3();
        return this.f10725yc;
    }

    @Override // m1.uo
    public boolean u0() {
        r3();
        return this.f10729z6;
    }

    @Override // m1.uo
    public void ut(final boolean z2) {
        r3();
        if (this.f10729z6 != z2) {
            this.f10729z6 = z2;
            this.f10673f.i2(z2);
            this.f10710t.c5(9, new z.y() { // from class: m1.ta
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    ((uo.gv) obj).onShuffleModeEnabledChanged(z2);
                }
            });
            fm();
            this.f10710t.a();
        }
    }

    public final long ux(bv bvVar) {
        if (bvVar.y.r()) {
            return v5.j5.xb(this.f10678g);
        }
        if (bvVar.f10594n3.n3()) {
            return bvVar.f10593mt;
        }
        return ja(bvVar.y, bvVar.f10594n3, bvVar.f10593mt);
    }

    @Override // m1.uo
    public br v() {
        r3();
        return this.f10705rb.f10601wz;
    }

    public void v1(co.y yVar) {
        this.f10712tl.add(yVar);
    }

    public final c8 vb(c8.n3 n3Var) {
        int i;
        int vd = vd();
        yc ycVar = this.f10673f;
        hy hyVar = this.f10705rb.y;
        if (vd == -1) {
            i = 0;
        } else {
            i = vd;
        }
        return new c8(ycVar, n3Var, hyVar, i, this.f10682i4, ycVar.fh());
    }

    public final int vd() {
        if (this.f10705rb.y.r()) {
            return this.f10679g3;
        }
        bv bvVar = this.f10705rb;
        return bvVar.y.t(bvVar.f10594n3.y, this.f10719wz).f10828fb;
    }

    public final /* synthetic */ void vi(uo.gv gvVar, v5.wz wzVar) {
        gvVar.onEvents(this.f10658a, new uo.zn(wzVar));
    }

    @Override // m1.uo
    public void w(List<o0> list, boolean z2) {
        r3();
        fh(ob(list), z2);
    }

    public final void w5(boolean z2, int i, int i5) {
        boolean z3;
        int i6 = 0;
        if (z2 && i != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 && i != 1) {
            i6 = 1;
        }
        bv bvVar = this.f10705rb;
        if (bvVar.f10597t == z3 && bvVar.f10598tl == i6) {
            return;
        }
        this.f10671ej++;
        bv gv2 = bvVar.gv(z3, i6);
        this.f10673f.x5(z3, i6);
        p4(gv2, 0, i5, false, false, 5, -9223372036854775807L, -1, false);
    }

    public void wo(@Nullable SurfaceHolder surfaceHolder) {
        r3();
        if (surfaceHolder != null && surfaceHolder == this.f10701q9) {
            rs();
        }
    }

    public final bv wv(bv bvVar, hy hyVar, @Nullable Pair<Object, Long> pair) {
        boolean z2;
        mg.n3 n3Var;
        af.lc lcVar;
        zo.rz rzVar;
        List<Metadata> list;
        int i;
        long j2;
        if (!hyVar.r() && pair == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        v5.y.y(z2);
        hy hyVar2 = bvVar.y;
        bv c52 = bvVar.c5(hyVar);
        if (hyVar.r()) {
            mg.n3 f4 = bv.f();
            long xb2 = v5.j5.xb(this.f10678g);
            bv n32 = c52.zn(f4, xb2, xb2, xb2, 0L, af.lc.f327s, this.f10695n3, z0.x4.j5()).n3(f4);
            n32.f10600w = n32.f10593mt;
            return n32;
        }
        Object obj = c52.f10594n3.y;
        boolean equals = obj.equals(((Pair) v5.j5.i9(pair)).first);
        if (!equals) {
            n3Var = new mg.n3(pair.first);
        } else {
            n3Var = c52.f10594n3;
        }
        mg.n3 n3Var2 = n3Var;
        long longValue = ((Long) pair.second).longValue();
        long xb3 = v5.j5.xb(ra());
        if (!hyVar2.r()) {
            xb3 -= hyVar2.t(obj, this.f10719wz).p();
        }
        if (equals && longValue >= xb3) {
            if (i == 0) {
                int a2 = hyVar.a(c52.f10589f.y);
                if (a2 == -1 || hyVar.i9(a2, this.f10719wz).f10828fb != hyVar.t(n3Var2.y, this.f10719wz).f10828fb) {
                    hyVar.t(n3Var2.y, this.f10719wz);
                    if (n3Var2.n3()) {
                        j2 = this.f10719wz.v(n3Var2.f239n3, n3Var2.f241zn);
                    } else {
                        j2 = this.f10719wz.f10829s;
                    }
                    c52 = c52.zn(n3Var2, c52.f10593mt, c52.f10593mt, c52.f10591gv, j2 - c52.f10593mt, c52.f10596s, c52.f10588c5, c52.f10592i9).n3(n3Var2);
                    c52.f10600w = j2;
                }
            } else {
                v5.y.fb(!n3Var2.n3());
                long max = Math.max(0L, c52.f10595p - (longValue - xb3));
                long j4 = c52.f10600w;
                if (c52.f10589f.equals(c52.f10594n3)) {
                    j4 = longValue + max;
                }
                c52 = c52.zn(n3Var2, longValue, longValue, longValue, max, c52.f10596s, c52.f10588c5, c52.f10592i9);
                c52.f10600w = j4;
            }
            return c52;
        }
        v5.y.fb(!n3Var2.n3());
        if (!equals) {
            lcVar = af.lc.f327s;
        } else {
            lcVar = c52.f10596s;
        }
        af.lc lcVar2 = lcVar;
        if (!equals) {
            rzVar = this.f10695n3;
        } else {
            rzVar = c52.f10588c5;
        }
        zo.rz rzVar2 = rzVar;
        if (!equals) {
            list = z0.x4.j5();
        } else {
            list = c52.f10592i9;
        }
        bv n33 = c52.zn(n3Var2, longValue, longValue, longValue, 0L, lcVar2, rzVar2, list).n3(n3Var2);
        n33.f10600w = longValue;
        return n33;
    }

    @Override // m1.co
    public zo.fh wz() {
        r3();
        return this.f10708s;
    }

    @Override // m1.uo
    public int x() {
        r3();
        return this.f10705rb.f10598tl;
    }

    public void x2(@Nullable SurfaceHolder surfaceHolder) {
        r3();
        if (surfaceHolder == null) {
            rs();
            return;
        }
        ng();
        this.f10675f7 = true;
        this.f10701q9 = surfaceHolder;
        surfaceHolder.addCallback(this.f10674f3);
        Surface surface = surfaceHolder.getSurface();
        if (surface != null && surface.isValid()) {
            jf(surface);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            bx(surfaceFrame.width(), surfaceFrame.height());
            return;
        }
        jf(null);
        bx(0, 0);
    }

    @Override // m1.uo
    public int xg() {
        r3();
        if (i9()) {
            return this.f10705rb.f10594n3.f241zn;
        }
        return -1;
    }

    @Override // m1.uo
    public boolean y() {
        r3();
        return this.f10705rb.f10590fb;
    }

    public final void y0(int i, int i5, @Nullable Object obj) {
        zq[] zqVarArr;
        for (zq zqVar : this.f10676fb) {
            if (zqVar.s() == i) {
                vb(zqVar).wz(i5).tl(obj).t();
            }
        }
    }

    @Override // m1.co
    public boolean yc() {
        r3();
        return this.f10670eb;
    }

    @Override // m1.co
    public void yg(@Nullable vc vcVar) {
        r3();
        if (vcVar == null) {
            vcVar = vc.f11293fb;
        }
        if (!this.f10661b.equals(vcVar)) {
            this.f10661b = vcVar;
            this.f10673f.ix(vcVar);
        }
    }

    @Override // m1.uo
    public zo.c yt() {
        r3();
        return this.f10708s.v();
    }

    @Override // m1.uo
    public void zn(br brVar) {
        r3();
        if (brVar == null) {
            brVar = br.f10581s;
        }
        if (this.f10705rb.f10601wz.equals(brVar)) {
            return;
        }
        bv a2 = this.f10705rb.a(brVar);
        this.f10671ej++;
        this.f10673f.mp(brVar);
        p4(a2, 0, 1, false, false, 5, -9223372036854775807L, -1, false);
    }

    public void zx(int i, List<af.mg> list) {
        boolean z2;
        r3();
        if (i >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        int min = Math.min(i, this.f10722xc.size());
        hy b2 = b();
        this.f10671ej++;
        List<j3.zn> gi = gi(min, list);
        hy hb = hb();
        bv wv = wv(this.f10705rb, hb, t5(b2, hb));
        this.f10673f.i9(min, gi, this.f10688k5);
        p4(wv, 0, 1, false, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // m1.uo
    @Nullable
    public p a() {
        r3();
        return this.f10705rb.f10587a;
    }
}
