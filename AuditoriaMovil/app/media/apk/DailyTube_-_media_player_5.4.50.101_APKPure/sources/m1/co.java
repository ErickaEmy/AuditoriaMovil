package m1;

import af.mg;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.List;
import m1.co;
import m1.i9;
/* loaded from: classes.dex */
public interface co extends uo {

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: a  reason: collision with root package name */
        public w0.z<zo.fh> f10621a;

        /* renamed from: c  reason: collision with root package name */
        public boolean f10622c;

        /* renamed from: c5  reason: collision with root package name */
        public w0.fb<v5.v, fj.y> f10623c5;

        /* renamed from: co  reason: collision with root package name */
        public boolean f10624co;

        /* renamed from: d0  reason: collision with root package name */
        public boolean f10625d0;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public v5.ta f10626f;

        /* renamed from: f3  reason: collision with root package name */
        public long f10627f3;

        /* renamed from: fb  reason: collision with root package name */
        public w0.z<pq> f10628fb;
        @Nullable

        /* renamed from: fh  reason: collision with root package name */
        public Looper f10629fh;

        /* renamed from: gv  reason: collision with root package name */
        public w0.z<gn> f10630gv;

        /* renamed from: i4  reason: collision with root package name */
        public pz f10631i4;

        /* renamed from: i9  reason: collision with root package name */
        public Looper f10632i9;

        /* renamed from: mt  reason: collision with root package name */
        public int f10633mt;

        /* renamed from: n  reason: collision with root package name */
        public long f10634n;

        /* renamed from: n3  reason: collision with root package name */
        public v5.v f10635n3;

        /* renamed from: p  reason: collision with root package name */
        public int f10636p;

        /* renamed from: r  reason: collision with root package name */
        public long f10637r;

        /* renamed from: rz  reason: collision with root package name */
        public boolean f10638rz;

        /* renamed from: s  reason: collision with root package name */
        public w0.z<kx.a> f10639s;

        /* renamed from: t  reason: collision with root package name */
        public d9.v f10640t;

        /* renamed from: tl  reason: collision with root package name */
        public boolean f10641tl;

        /* renamed from: v  reason: collision with root package name */
        public w0.z<mg.y> f10642v;

        /* renamed from: w  reason: collision with root package name */
        public boolean f10643w;

        /* renamed from: wz  reason: collision with root package name */
        public int f10644wz;

        /* renamed from: x4  reason: collision with root package name */
        public long f10645x4;

        /* renamed from: xc  reason: collision with root package name */
        public boolean f10646xc;
        public final Context y;

        /* renamed from: z  reason: collision with root package name */
        public vc f10647z;

        /* renamed from: zn  reason: collision with root package name */
        public long f10648zn;

        public n3(final Context context) {
            this(context, new w0.z() { // from class: m1.x4
                @Override // w0.z
                public final Object get() {
                    gn f4;
                    f4 = co.n3.f(context);
                    return f4;
                }
            }, new w0.z() { // from class: m1.i4
                @Override // w0.z
                public final Object get() {
                    mg.y t2;
                    t2 = co.n3.t(context);
                    return t2;
                }
            });
        }

        public static /* synthetic */ gn f(Context context) {
            return new tl(context);
        }

        public static /* synthetic */ mg.y t(Context context) {
            return new af.co(context, new e4.c5());
        }

        public static /* synthetic */ zo.fh tl(Context context) {
            return new zo.tl(context);
        }

        public static /* synthetic */ mg.y w(Context context) {
            return new af.co(context, new e4.c5());
        }

        public n3 c(int i) {
            v5.y.fb(!this.f10638rz);
            this.f10644wz = i;
            return this;
        }

        public n3 f3(boolean z2) {
            v5.y.fb(!this.f10638rz);
            this.f10622c = z2;
            return this;
        }

        public n3 i4(final pq pqVar) {
            v5.y.fb(!this.f10638rz);
            v5.y.v(pqVar);
            this.f10628fb = new w0.z() { // from class: m1.z
                @Override // w0.z
                public final Object get() {
                    pq mt2;
                    mt2 = co.n3.mt(pq.this);
                    return mt2;
                }
            };
            return this;
        }

        public co i9() {
            v5.y.fb(!this.f10638rz);
            this.f10638rz = true;
            return new dm(this, null);
        }

        public n3 n(final zo.fh fhVar) {
            v5.y.fb(!this.f10638rz);
            v5.y.v(fhVar);
            this.f10621a = new w0.z() { // from class: m1.n
                @Override // w0.z
                public final Object get() {
                    zo.fh co2;
                    co2 = co.n3.co(zo.fh.this);
                    return co2;
                }
            };
            return this;
        }

        public n3 r(final kx.a aVar) {
            v5.y.fb(!this.f10638rz);
            v5.y.v(aVar);
            this.f10639s = new w0.z() { // from class: m1.f3
                @Override // w0.z
                public final Object get() {
                    kx.a p2;
                    p2 = co.n3.p(kx.a.this);
                    return p2;
                }
            };
            return this;
        }

        public n3 x4(boolean z2) {
            v5.y.fb(!this.f10638rz);
            this.f10646xc = z2;
            return this;
        }

        public n3 z(d9.v vVar, boolean z2) {
            v5.y.fb(!this.f10638rz);
            this.f10640t = (d9.v) v5.y.v(vVar);
            this.f10641tl = z2;
            return this;
        }

        public n3(final Context context, final gn gnVar) {
            this(context, new w0.z() { // from class: m1.c
                @Override // w0.z
                public final Object get() {
                    gn xc2;
                    xc2 = co.n3.xc(gn.this);
                    return xc2;
                }
            }, new w0.z() { // from class: m1.d0
                @Override // w0.z
                public final Object get() {
                    mg.y w4;
                    w4 = co.n3.w(context);
                    return w4;
                }
            });
            v5.y.v(gnVar);
        }

        public n3(final Context context, w0.z<gn> zVar, w0.z<mg.y> zVar2) {
            this(context, zVar, zVar2, new w0.z() { // from class: m1.fh
                @Override // w0.z
                public final Object get() {
                    zo.fh tl2;
                    tl2 = co.n3.tl(context);
                    return tl2;
                }
            }, new w0.z() { // from class: m1.rz
                @Override // w0.z
                public final Object get() {
                    return new f();
                }
            }, new w0.z() { // from class: m1.mg
                @Override // w0.z
                public final Object get() {
                    kx.a wz2;
                    wz2 = kx.z.wz(context);
                    return wz2;
                }
            }, new w0.fb() { // from class: m1.r
                @Override // w0.fb
                public final Object apply(Object obj) {
                    return new fj.yg((v5.v) obj);
                }
            });
        }

        public n3(Context context, w0.z<gn> zVar, w0.z<mg.y> zVar2, w0.z<zo.fh> zVar3, w0.z<pq> zVar4, w0.z<kx.a> zVar5, w0.fb<v5.v, fj.y> fbVar) {
            this.y = (Context) v5.y.v(context);
            this.f10630gv = zVar;
            this.f10642v = zVar2;
            this.f10621a = zVar3;
            this.f10628fb = zVar4;
            this.f10639s = zVar5;
            this.f10623c5 = fbVar;
            this.f10632i9 = v5.j5.j5();
            this.f10640t = d9.v.f7204w;
            this.f10644wz = 0;
            this.f10636p = 1;
            this.f10633mt = 0;
            this.f10624co = true;
            this.f10647z = vc.f11293fb;
            this.f10637r = 5000L;
            this.f10645x4 = 15000L;
            this.f10631i4 = new i9.n3().y();
            this.f10635n3 = v5.v.y;
            this.f10627f3 = 500L;
            this.f10634n = 2000L;
            this.f10625d0 = true;
        }

        public static /* synthetic */ zo.fh co(zo.fh fhVar) {
            return fhVar;
        }

        public static /* synthetic */ pq mt(pq pqVar) {
            return pqVar;
        }

        public static /* synthetic */ kx.a p(kx.a aVar) {
            return aVar;
        }

        public static /* synthetic */ gn xc(gn gnVar) {
            return gnVar;
        }
    }

    /* loaded from: classes.dex */
    public interface y {
        void c(boolean z2);

        void d0(boolean z2);
    }

    @Override // m1.uo
    @Nullable
    p a();

    void d(boolean z2);

    void dm(List<af.mg> list);

    void ej(List<af.mg> list, int i, long j2);

    void fh(List<af.mg> list, boolean z2);

    int getAudioSessionId();

    int j5(int i);

    int k();

    void mt(fj.zn znVar);

    void qn();

    void rb(fj.zn znVar);

    void s(boolean z2);

    @Nullable
    zo.fh wz();

    boolean yc();

    void yg(@Nullable vc vcVar);
}
