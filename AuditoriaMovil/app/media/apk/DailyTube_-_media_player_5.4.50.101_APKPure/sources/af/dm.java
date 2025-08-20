package af;

import af.mg;
import android.net.Uri;
import androidx.annotation.Nullable;
import kx.p;
import kx.tl;
import m1.hy;
import m1.m;
import m1.o0;
/* loaded from: classes.dex */
public final class dm extends af.y {

    /* renamed from: c  reason: collision with root package name */
    public final hy f143c;

    /* renamed from: co  reason: collision with root package name */
    public final tl.y f144co;

    /* renamed from: d0  reason: collision with root package name */
    public final o0 f145d0;

    /* renamed from: f3  reason: collision with root package name */
    public final kx.mg f146f3;
    @Nullable

    /* renamed from: fh  reason: collision with root package name */
    public kx.o f147fh;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f148n;

    /* renamed from: p  reason: collision with root package name */
    public final kx.p f149p;

    /* renamed from: r  reason: collision with root package name */
    public final long f150r;

    /* renamed from: z  reason: collision with root package name */
    public final m f151z;

    /* loaded from: classes.dex */
    public static final class n3 {
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public Object f152gv;
        @Nullable

        /* renamed from: v  reason: collision with root package name */
        public String f154v;
        public final tl.y y;

        /* renamed from: n3  reason: collision with root package name */
        public kx.mg f153n3 = new kx.n();

        /* renamed from: zn  reason: collision with root package name */
        public boolean f155zn = true;

        public n3(tl.y yVar) {
            this.y = (tl.y) v5.y.v(yVar);
        }

        public n3 n3(@Nullable kx.mg mgVar) {
            if (mgVar == null) {
                mgVar = new kx.n();
            }
            this.f153n3 = mgVar;
            return this;
        }

        public dm y(o0.t tVar, long j2) {
            return new dm(this.f154v, tVar, this.y, j2, this.f153n3, this.f155zn, this.f152gv);
        }
    }

    @Override // af.mg
    public o0 c() {
        return this.f145d0;
    }

    @Override // af.y
    public void e(@Nullable kx.o oVar) {
        this.f147fh = oVar;
        s8(this.f143c);
    }

    @Override // af.mg
    public d0 f7(mg.n3 n3Var, kx.n3 n3Var2, long j2) {
        return new xg(this.f149p, this.f144co, this.f147fh, this.f151z, this.f150r, this.f146f3, o4(n3Var), this.f148n);
    }

    @Override // af.mg
    public void u(d0 d0Var) {
        ((xg) d0Var).xc();
    }

    public dm(@Nullable String str, o0.t tVar, tl.y yVar, long j2, kx.mg mgVar, boolean z2, @Nullable Object obj) {
        this.f144co = yVar;
        this.f150r = j2;
        this.f146f3 = mgVar;
        this.f148n = z2;
        o0 y2 = new o0.zn().s(Uri.EMPTY).gv(tVar.y.toString()).a(z0.x4.o(tVar)).fb(obj).y();
        this.f145d0 = y2;
        m.n3 q92 = new m.n3().o4((String) w0.c5.y(tVar.f11090n3, "text/x-unknown")).k(tVar.f11092zn).eb(tVar.f11089gv).dm(tVar.f11091v).q9(tVar.f11087a);
        String str2 = tVar.f11088fb;
        this.f151z = q92.oz(str2 == null ? str : str2).z6();
        this.f149p = new p.n3().c5(tVar.y).n3(1).y();
        this.f143c = new y5(j2, true, false, false, null, y2);
    }

    @Override // af.y
    public void ap() {
    }

    @Override // af.mg
    public void ut() {
    }
}
