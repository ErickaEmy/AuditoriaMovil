package fj;

import af.mg;
import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import fj.zn;
import java.io.IOException;
import java.util.List;
import m1.br;
import m1.gf;
import m1.hy;
import m1.o0;
import m1.qk;
import m1.uo;
import m1.v1;
import v5.z;
import z0.f3;
/* loaded from: classes.dex */
public class yg implements fj.y {

    /* renamed from: co  reason: collision with root package name */
    public boolean f8145co;

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<zn.y> f8146f;

    /* renamed from: fb  reason: collision with root package name */
    public final hy.gv f8147fb;

    /* renamed from: p  reason: collision with root package name */
    public v5.p f8148p;

    /* renamed from: s  reason: collision with root package name */
    public final y f8149s;

    /* renamed from: t  reason: collision with root package name */
    public v5.z<zn> f8150t;

    /* renamed from: v  reason: collision with root package name */
    public final hy.n3 f8151v;

    /* renamed from: w  reason: collision with root package name */
    public uo f8152w;
    public final v5.v y;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        public mg.n3 f8153a;
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public mg.n3 f8154gv;

        /* renamed from: v  reason: collision with root package name */
        public mg.n3 f8156v;
        public final hy.n3 y;

        /* renamed from: n3  reason: collision with root package name */
        public z0.x4<mg.n3> f8155n3 = z0.x4.j5();

        /* renamed from: zn  reason: collision with root package name */
        public z0.f3<mg.n3, hy> f8157zn = z0.f3.x4();

        public y(hy.n3 n3Var) {
            this.y = n3Var;
        }

        public static boolean c5(mg.n3 n3Var, @Nullable Object obj, boolean z2, int i, int i5, int i6) {
            if (!n3Var.y.equals(obj)) {
                return false;
            }
            if ((!z2 || n3Var.f239n3 != i || n3Var.f241zn != i5) && (z2 || n3Var.f239n3 != -1 || n3Var.f240v != i6)) {
                return false;
            }
            return true;
        }

        @Nullable
        public static mg.n3 zn(uo uoVar, z0.x4<mg.n3> x4Var, @Nullable mg.n3 n3Var, hy.n3 n3Var2) {
            Object p2;
            int i;
            hy b2 = uoVar.b();
            int en2 = uoVar.en();
            if (b2.r()) {
                p2 = null;
            } else {
                p2 = b2.p(en2);
            }
            if (!uoVar.i9() && !b2.r()) {
                i = b2.i9(en2, n3Var2).fb(v5.j5.xb(uoVar.getCurrentPosition()) - n3Var2.p());
            } else {
                i = -1;
            }
            for (int i5 = 0; i5 < x4Var.size(); i5++) {
                mg.n3 n3Var3 = x4Var.get(i5);
                if (c5(n3Var3, p2, uoVar.i9(), uoVar.ta(), uoVar.xg(), i)) {
                    return n3Var3;
                }
            }
            if (x4Var.isEmpty() && n3Var != null) {
                if (c5(n3Var, p2, uoVar.i9(), uoVar.ta(), uoVar.xg(), i)) {
                    return n3Var;
                }
            }
            return null;
        }

        @Nullable
        public hy a(mg.n3 n3Var) {
            return this.f8157zn.get(n3Var);
        }

        public void f(List<mg.n3> list, @Nullable mg.n3 n3Var, uo uoVar) {
            this.f8155n3 = z0.x4.d(list);
            if (!list.isEmpty()) {
                this.f8156v = list.get(0);
                this.f8153a = (mg.n3) v5.y.v(n3Var);
            }
            if (this.f8154gv == null) {
                this.f8154gv = zn(uoVar, this.f8155n3, this.f8156v, this.y);
            }
            tl(uoVar.b());
        }

        @Nullable
        public mg.n3 fb() {
            return this.f8156v;
        }

        @Nullable
        public mg.n3 gv() {
            return this.f8154gv;
        }

        public void i9(uo uoVar) {
            this.f8154gv = zn(uoVar, this.f8155n3, this.f8156v, this.y);
        }

        public final void n3(f3.y<mg.n3, hy> yVar, @Nullable mg.n3 n3Var, hy hyVar) {
            if (n3Var == null) {
                return;
            }
            if (hyVar.a(n3Var.y) != -1) {
                yVar.gv(n3Var, hyVar);
                return;
            }
            hy hyVar2 = this.f8157zn.get(n3Var);
            if (hyVar2 != null) {
                yVar.gv(n3Var, hyVar2);
            }
        }

        @Nullable
        public mg.n3 s() {
            return this.f8153a;
        }

        public void t(uo uoVar) {
            this.f8154gv = zn(uoVar, this.f8155n3, this.f8156v, this.y);
            tl(uoVar.b());
        }

        public final void tl(hy hyVar) {
            f3.y<mg.n3, hy> y = z0.f3.y();
            if (this.f8155n3.isEmpty()) {
                n3(y, this.f8156v, hyVar);
                if (!w0.f.y(this.f8153a, this.f8156v)) {
                    n3(y, this.f8153a, hyVar);
                }
                if (!w0.f.y(this.f8154gv, this.f8156v) && !w0.f.y(this.f8154gv, this.f8153a)) {
                    n3(y, this.f8154gv, hyVar);
                }
            } else {
                for (int i = 0; i < this.f8155n3.size(); i++) {
                    n3(y, this.f8155n3.get(i), hyVar);
                }
                if (!this.f8155n3.contains(this.f8154gv)) {
                    n3(y, this.f8154gv, hyVar);
                }
            }
            this.f8157zn = y.n3();
        }

        @Nullable
        public mg.n3 v() {
            if (this.f8155n3.isEmpty()) {
                return null;
            }
            return (mg.n3) z0.d0.v(this.f8155n3);
        }
    }

    public yg(v5.v vVar) {
        this.y = (v5.v) v5.y.v(vVar);
        this.f8150t = new v5.z<>(v5.j5.j5(), vVar, new z.n3() { // from class: fj.mg
            @Override // v5.z.n3
            public final void y(Object obj, v5.wz wzVar) {
                yg.nd((zn) obj, wzVar);
            }
        });
        hy.n3 n3Var = new hy.n3();
        this.f8151v = n3Var;
        this.f8147fb = new hy.gv();
        this.f8149s = new y(n3Var);
        this.f8146f = new SparseArray<>();
    }

    public static /* synthetic */ void cx(zn.y yVar, boolean z2, zn znVar) {
        znVar.f7(yVar, z2);
        znVar.tl(yVar, z2);
    }

    public static /* synthetic */ void e5(zn.y yVar, a9.v vVar, zn znVar) {
        znVar.ut(yVar, vVar);
        znVar.n3(yVar, 2, vVar);
    }

    public static /* synthetic */ void fc(zn.y yVar, String str, long j2, long j4, zn znVar) {
        znVar.gv(yVar, str, j2);
        znVar.qn(yVar, str, j4, j2);
        znVar.s8(yVar, 1, str, j2);
    }

    public static /* synthetic */ void fq(zn.y yVar, int i, uo.v vVar, uo.v vVar2, zn znVar) {
        znVar.f(yVar, i);
        znVar.nf(yVar, vVar, vVar2, i);
    }

    public static /* synthetic */ void i(zn.y yVar, int i, zn znVar) {
        znVar.bk(yVar);
        znVar.y5(yVar, i);
    }

    public static /* synthetic */ void i1(zn.y yVar, wn.d0 d0Var, zn znVar) {
        znVar.mt(yVar, d0Var);
        znVar.i4(yVar, d0Var.y, d0Var.f14582v, d0Var.f14580fb, d0Var.f14581s);
    }

    public static /* synthetic */ void im(zn.y yVar, a9.v vVar, zn znVar) {
        znVar.tg(yVar, vVar);
        znVar.n3(yVar, 1, vVar);
    }

    public static /* synthetic */ void l3(zn.y yVar, a9.v vVar, zn znVar) {
        znVar.vl(yVar, vVar);
        znVar.eb(yVar, 2, vVar);
    }

    public static /* synthetic */ void mh(zn.y yVar, m1.m mVar, a9.c5 c5Var, zn znVar) {
        znVar.ud(yVar, mVar);
        znVar.ta(yVar, mVar, c5Var);
        znVar.ct(yVar, 1, mVar);
    }

    public static /* synthetic */ void nh(zn.y yVar, m1.m mVar, a9.c5 c5Var, zn znVar) {
        znVar.rz(yVar, mVar);
        znVar.x(yVar, mVar, c5Var);
        znVar.ct(yVar, 2, mVar);
    }

    public static /* synthetic */ void ou(zn.y yVar, String str, long j2, long j4, zn znVar) {
        znVar.ej(yVar, str, j2);
        znVar.j5(yVar, str, j4, j2);
        znVar.s8(yVar, 2, str, j2);
    }

    public static /* synthetic */ void uo(zn.y yVar, a9.v vVar, zn znVar) {
        znVar.q9(yVar, vVar);
        znVar.eb(yVar, 1, vVar);
    }

    @Override // fj.y
    public final void a(final a9.v vVar) {
        final zn.y q2 = q();
        jm(q2, 1015, new z.y() { // from class: fj.d0
            @Override // v5.z.y
            public final void invoke(Object obj) {
                yg.e5(zn.y.this, vVar, (zn) obj);
            }
        });
    }

    @Override // af.b
    public final void b(int i, @Nullable mg.n3 n3Var, final af.c cVar) {
        final zn.y j32 = j3(i, n3Var);
        jm(j32, 1004, new z.y() { // from class: fj.mt
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).g(zn.y.this, cVar);
            }
        });
    }

    @Override // kx.a.y
    public final void c(final int i, final long j2, final long j4) {
        final zn.y vn2 = vn();
        jm(vn2, 1006, new z.y() { // from class: fj.c
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).o4(zn.y.this, i, j2, j4);
            }
        });
    }

    @Override // fj.y
    public final void c5(final String str, final long j2, final long j4) {
        final zn.y q2 = q();
        jm(q2, 1008, new z.y() { // from class: fj.gv
            @Override // v5.z.y
            public final void invoke(Object obj) {
                yg.fc(zn.y.this, str, j4, j2, (zn) obj);
            }
        });
    }

    @Override // fj.y
    public final void co(final int i, final long j2) {
        final zn.y ne2 = ne();
        jm(ne2, 1018, new z.y() { // from class: fj.yt
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).g3(zn.y.this, i, j2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.v
    public final void d(int i, @Nullable mg.n3 n3Var, final int i5) {
        final zn.y j32 = j3(i, n3Var);
        jm(j32, 1022, new z.y() { // from class: fj.f7
            @Override // v5.z.y
            public final void invoke(Object obj) {
                yg.i(zn.y.this, i5, (zn) obj);
            }
        });
    }

    @Override // fj.y
    public final void d0() {
        if (!this.f8145co) {
            final zn.y yk2 = yk();
            this.f8145co = true;
            jm(yk2, -1, new z.y() { // from class: fj.wz
                @Override // v5.z.y
                public final void invoke(Object obj) {
                    ((zn) obj).v(zn.y.this);
                }
            });
        }
    }

    @Override // fj.y
    public final void f(final a9.v vVar) {
        final zn.y q2 = q();
        jm(q2, 1007, new z.y() { // from class: fj.q9
            @Override // v5.z.y
            public final void invoke(Object obj) {
                yg.im(zn.y.this, vVar, (zn) obj);
            }
        });
    }

    @Override // fj.y
    public final void f3(final long j2, final int i) {
        final zn.y ne2 = ne();
        jm(ne2, 1021, new z.y() { // from class: fj.qn
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).wz(zn.y.this, j2, i);
            }
        });
    }

    @Override // af.b
    public final void fb(int i, @Nullable mg.n3 n3Var, final af.i4 i4Var, final af.c cVar) {
        final zn.y j32 = j3(i, n3Var);
        jm(j32, 1002, new z.y() { // from class: fj.ra
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).z(zn.y.this, i4Var, cVar);
            }
        });
    }

    @Override // af.b
    public final void fh(int i, @Nullable mg.n3 n3Var, final af.i4 i4Var, final af.c cVar) {
        final zn.y j32 = j3(i, n3Var);
        jm(j32, 1000, new z.y() { // from class: fj.ut
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).u0(zn.y.this, i4Var, cVar);
            }
        });
    }

    @Override // fj.y
    public final void gv(final Exception exc) {
        final zn.y q2 = q();
        jm(q2, 1014, new z.y() { // from class: fj.j5
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).fb(zn.y.this, exc);
            }
        });
    }

    public final zn.y i2(@Nullable mg.n3 n3Var) {
        hy a2;
        v5.y.v(this.f8152w);
        if (n3Var == null) {
            a2 = null;
        } else {
            a2 = this.f8149s.a(n3Var);
        }
        if (n3Var != null && a2 != null) {
            return i3(a2, a2.t(n3Var.y, this.f8151v).f10828fb, n3Var);
        }
        int kp2 = this.f8152w.kp();
        hy b2 = this.f8152w.b();
        if (kp2 >= b2.z()) {
            b2 = hy.y;
        }
        return i3(b2, kp2, null);
    }

    public final zn.y i3(hy hyVar, int i, @Nullable mg.n3 n3Var) {
        mg.n3 n3Var2;
        boolean z2;
        if (hyVar.r()) {
            n3Var2 = null;
        } else {
            n3Var2 = n3Var;
        }
        long elapsedRealtime = this.y.elapsedRealtime();
        if (hyVar.equals(this.f8152w.b()) && i == this.f8152w.kp()) {
            z2 = true;
        } else {
            z2 = false;
        }
        long j2 = 0;
        if (n3Var2 != null && n3Var2.n3()) {
            if (z2 && this.f8152w.ta() == n3Var2.f239n3 && this.f8152w.xg() == n3Var2.f241zn) {
                j2 = this.f8152w.getCurrentPosition();
            }
        } else if (z2) {
            j2 = this.f8152w.ra();
        } else if (!hyVar.r()) {
            j2 = hyVar.mt(i, this.f8147fb).gv();
        }
        return new zn.y(elapsedRealtime, hyVar, i, n3Var2, j2, this.f8152w.b(), this.f8152w.kp(), this.f8149s.gv(), this.f8152w.getCurrentPosition(), this.f8152w.f());
    }

    @Override // fj.y
    public final void i4(final int i, final long j2, final long j4) {
        final zn.y q2 = q();
        jm(q2, 1011, new z.y() { // from class: fj.s
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).yg(zn.y.this, i, j2, j4);
            }
        });
    }

    @Override // fj.y
    public final void i9(final a9.v vVar) {
        final zn.y ne2 = ne();
        jm(ne2, 1013, new z.y() { // from class: fj.d
            @Override // v5.z.y
            public final void invoke(Object obj) {
                yg.uo(zn.y.this, vVar, (zn) obj);
            }
        });
    }

    public final void ih() {
        final zn.y yk2 = yk();
        jm(yk2, 1028, new z.y() { // from class: fj.eb
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).a8(zn.y.this);
            }
        });
        this.f8150t.i9();
    }

    public final zn.y j3(int i, @Nullable mg.n3 n3Var) {
        v5.y.v(this.f8152w);
        if (n3Var != null) {
            if (this.f8149s.a(n3Var) != null) {
                return i2(n3Var);
            }
            return i3(hy.y, i, n3Var);
        }
        hy b2 = this.f8152w.b();
        if (i >= b2.z()) {
            b2 = hy.y;
        }
        return i3(b2, i, null);
    }

    @Override // af.b
    public final void j5(int i, @Nullable mg.n3 n3Var, final af.i4 i4Var, final af.c cVar, final IOException iOException, final boolean z2) {
        final zn.y j32 = j3(i, n3Var);
        jm(j32, 1003, new z.y() { // from class: fj.z
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).c(zn.y.this, i4Var, cVar, iOException, z2);
            }
        });
    }

    public final void jm(zn.y yVar, int i, z.y<zn> yVar2) {
        this.f8146f.put(i, yVar);
        this.f8150t.t(i, yVar2);
    }

    @Override // af.b
    public final void mg(int i, @Nullable mg.n3 n3Var, final af.i4 i4Var, final af.c cVar) {
        final zn.y j32 = j3(i, n3Var);
        jm(j32, 1001, new z.y() { // from class: fj.t
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).r(zn.y.this, i4Var, cVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.v
    public final void mt(int i, @Nullable mg.n3 n3Var) {
        final zn.y j32 = j3(i, n3Var);
        jm(j32, 1023, new z.y() { // from class: fj.lc
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).xg(zn.y.this);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.v
    public final void n(int i, @Nullable mg.n3 n3Var, final Exception exc) {
        final zn.y j32 = j3(i, n3Var);
        jm(j32, 1024, new z.y() { // from class: fj.j
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).x4(zn.y.this, exc);
            }
        });
    }

    @Override // fj.y
    public final void n3(final String str) {
        final zn.y q2 = q();
        jm(q2, 1019, new z.y() { // from class: fj.xg
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).dm(zn.y.this, str);
            }
        });
    }

    public final zn.y ne() {
        return i2(this.f8149s.fb());
    }

    @Override // m1.uo.gv
    public void onAvailableCommandsChanged(final uo.n3 n3Var) {
        final zn.y yk2 = yk();
        jm(yk2, 13, new z.y() { // from class: fj.f3
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).d(zn.y.this, n3Var);
            }
        });
    }

    @Override // m1.uo.gv
    public void onCues(final List<qh.n3> list) {
        final zn.y yk2 = yk();
        jm(yk2, 27, new z.y() { // from class: fj.b
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).s(zn.y.this, list);
            }
        });
    }

    @Override // m1.uo.gv
    public void onDeviceInfoChanged(final m1.xc xcVar) {
        final zn.y yk2 = yk();
        jm(yk2, 29, new z.y() { // from class: fj.jz
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).xc(zn.y.this, xcVar);
            }
        });
    }

    @Override // m1.uo.gv
    public void onDeviceVolumeChanged(final int i, final boolean z2) {
        final zn.y yk2 = yk();
        jm(yk2, 30, new z.y() { // from class: fj.u
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).o(zn.y.this, i, z2);
            }
        });
    }

    @Override // m1.uo.gv
    public final void onIsLoadingChanged(final boolean z2) {
        final zn.y yk2 = yk();
        jm(yk2, 3, new z.y() { // from class: fj.o4
            @Override // v5.z.y
            public final void invoke(Object obj) {
                yg.cx(zn.y.this, z2, (zn) obj);
            }
        });
    }

    @Override // m1.uo.gv
    public void onIsPlayingChanged(final boolean z2) {
        final zn.y yk2 = yk();
        jm(yk2, 7, new z.y() { // from class: fj.s8
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).mg(zn.y.this, z2);
            }
        });
    }

    @Override // m1.uo.gv
    public final void onMediaItemTransition(@Nullable final o0 o0Var, final int i) {
        final zn.y yk2 = yk();
        jm(yk2, 1, new z.y() { // from class: fj.x4
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).m(zn.y.this, o0Var, i);
            }
        });
    }

    @Override // m1.uo.gv
    public void onMediaMetadataChanged(final qk qkVar) {
        final zn.y yk2 = yk();
        jm(yk2, 14, new z.y() { // from class: fj.c5
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).u(zn.y.this, qkVar);
            }
        });
    }

    @Override // m1.uo.gv
    public final void onMetadata(final Metadata metadata) {
        final zn.y yk2 = yk();
        jm(yk2, 28, new z.y() { // from class: fj.y5
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).lc(zn.y.this, metadata);
            }
        });
    }

    @Override // m1.uo.gv
    public final void onPlayWhenReadyChanged(final boolean z2, final int i) {
        final zn.y yk2 = yk();
        jm(yk2, 5, new z.y() { // from class: fj.xc
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).kp(zn.y.this, z2, i);
            }
        });
    }

    @Override // m1.uo.gv
    public final void onPlaybackParametersChanged(final br brVar) {
        final zn.y yk2 = yk();
        jm(yk2, 12, new z.y() { // from class: fj.f
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).yt(zn.y.this, brVar);
            }
        });
    }

    @Override // m1.uo.gv
    public final void onPlaybackStateChanged(final int i) {
        final zn.y yk2 = yk();
        jm(yk2, 4, new z.y() { // from class: fj.fh
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).k5(zn.y.this, i);
            }
        });
    }

    @Override // m1.uo.gv
    public final void onPlaybackSuppressionReasonChanged(final int i) {
        final zn.y yk2 = yk();
        jm(yk2, 6, new z.y() { // from class: fj.hw
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).jz(zn.y.this, i);
            }
        });
    }

    @Override // m1.uo.gv
    public final void onPlayerError(final gf gfVar) {
        final zn.y wm2 = wm(gfVar);
        jm(wm2, 10, new z.y() { // from class: fj.r
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).y4(zn.y.this, gfVar);
            }
        });
    }

    @Override // m1.uo.gv
    public void onPlayerErrorChanged(@Nullable final gf gfVar) {
        final zn.y wm2 = wm(gfVar);
        jm(wm2, 10, new z.y() { // from class: fj.vl
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).z6(zn.y.this, gfVar);
            }
        });
    }

    @Override // m1.uo.gv
    public final void onPlayerStateChanged(final boolean z2, final int i) {
        final zn.y yk2 = yk();
        jm(yk2, -1, new z.y() { // from class: fj.tl
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).zn(zn.y.this, z2, i);
            }
        });
    }

    @Override // m1.uo.gv
    public void onPositionDiscontinuity(int i) {
    }

    @Override // m1.uo.gv
    public final void onRepeatModeChanged(final int i) {
        final zn.y yk2 = yk();
        jm(yk2, 8, new z.y() { // from class: fj.ej
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).n(zn.y.this, i);
            }
        });
    }

    @Override // m1.uo.gv
    public final void onSeekProcessed() {
        final zn.y yk2 = yk();
        jm(yk2, -1, new z.y() { // from class: fj.p
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).f3(zn.y.this);
            }
        });
    }

    @Override // m1.uo.gv
    public final void onShuffleModeEnabledChanged(final boolean z2) {
        final zn.y yk2 = yk();
        jm(yk2, 9, new z.y() { // from class: fj.a
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).en(zn.y.this, z2);
            }
        });
    }

    @Override // m1.uo.gv
    public final void onSkipSilenceEnabledChanged(final boolean z2) {
        final zn.y q2 = q();
        jm(q2, 23, new z.y() { // from class: fj.e
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).c5(zn.y.this, z2);
            }
        });
    }

    @Override // m1.uo.gv
    public final void onSurfaceSizeChanged(final int i, final int i5) {
        final zn.y q2 = q();
        jm(q2, 24, new z.y() { // from class: fj.co
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).k(zn.y.this, i, i5);
            }
        });
    }

    @Override // m1.uo.gv
    public final void onTimelineChanged(hy hyVar, final int i) {
        this.f8149s.t((uo) v5.y.v(this.f8152w));
        final zn.y yk2 = yk();
        jm(yk2, 0, new z.y() { // from class: fj.k
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).yc(zn.y.this, i);
            }
        });
    }

    @Override // m1.uo.gv
    public void onTrackSelectionParametersChanged(final zo.c cVar) {
        final zn.y yk2 = yk();
        jm(yk2, 19, new z.y() { // from class: fj.ta
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).t(zn.y.this, cVar);
            }
        });
    }

    @Override // m1.uo.gv
    public void onTracksChanged(final v1 v1Var) {
        final zn.y yk2 = yk();
        jm(yk2, 2, new z.y() { // from class: fj.k5
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).co(zn.y.this, v1Var);
            }
        });
    }

    @Override // m1.uo.gv
    public final void onVideoSizeChanged(final wn.d0 d0Var) {
        final zn.y q2 = q();
        jm(q2, 25, new z.y() { // from class: fj.ct
            @Override // v5.z.y
            public final void invoke(Object obj) {
                yg.i1(zn.y.this, d0Var, (zn) obj);
            }
        });
    }

    @Override // m1.uo.gv
    public final void onVolumeChanged(final float f4) {
        final zn.y q2 = q();
        jm(q2, 22, new z.y() { // from class: fj.en
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).w(zn.y.this, f4);
            }
        });
    }

    @Override // af.b
    public final void p(int i, @Nullable mg.n3 n3Var, final af.c cVar) {
        final zn.y j32 = j3(i, n3Var);
        jm(j32, 1005, new z.y() { // from class: fj.o
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).p(zn.y.this, cVar);
            }
        });
    }

    public final zn.y q() {
        return i2(this.f8149s.s());
    }

    @Override // fj.y
    public final void qn(List<mg.n3> list, @Nullable mg.n3 n3Var) {
        this.f8149s.f(list, n3Var, (uo) v5.y.v(this.f8152w));
    }

    @Override // fj.y
    public final void r(final m1.m mVar, @Nullable final a9.c5 c5Var) {
        final zn.y q2 = q();
        jm(q2, 1017, new z.y() { // from class: fj.n
            @Override // v5.z.y
            public final void invoke(Object obj) {
                yg.nh(zn.y.this, mVar, c5Var, (zn) obj);
            }
        });
    }

    @Override // fj.y
    public void release() {
        ((v5.p) v5.y.c5(this.f8148p)).c5(new Runnable() { // from class: fj.i9
            @Override // java.lang.Runnable
            public final void run() {
                yg.this.ih();
            }
        });
    }

    @Override // fj.y
    public void rz(zn znVar) {
        this.f8150t.f(znVar);
    }

    @Override // fj.y
    public final void s(final String str) {
        final zn.y q2 = q();
        jm(q2, 1012, new z.y() { // from class: fj.z6
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).rs(zn.y.this, str);
            }
        });
    }

    @Override // fj.y
    public final void t(final long j2) {
        final zn.y q2 = q();
        jm(q2, 1010, new z.y() { // from class: fj.ud
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).ra(zn.y.this, j2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.v
    public final void ta(int i, @Nullable mg.n3 n3Var) {
        final zn.y j32 = j3(i, n3Var);
        jm(j32, 1025, new z.y() { // from class: fj.nf
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).i9(zn.y.this);
            }
        });
    }

    @Override // fj.y
    public final void tl(final a9.v vVar) {
        final zn.y ne2 = ne();
        jm(ne2, 1020, new z.y() { // from class: fj.x
            @Override // v5.z.y
            public final void invoke(Object obj) {
                yg.l3(zn.y.this, vVar, (zn) obj);
            }
        });
    }

    @Override // fj.y
    public final void v(final String str, final long j2, final long j4) {
        final zn.y q2 = q();
        jm(q2, 1016, new z.y() { // from class: fj.rz
            @Override // v5.z.y
            public final void invoke(Object obj) {
                yg.ou(zn.y.this, str, j4, j2, (zn) obj);
            }
        });
    }

    public final zn.y vn() {
        return i2(this.f8149s.v());
    }

    @Override // com.google.android.exoplayer2.drm.v
    public final void w(int i, @Nullable mg.n3 n3Var) {
        final zn.y j32 = j3(i, n3Var);
        jm(j32, 1027, new z.y() { // from class: fj.a8
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).hw(zn.y.this);
            }
        });
    }

    public final zn.y wm(@Nullable gf gfVar) {
        af.fh fhVar;
        if ((gfVar instanceof m1.p) && (fhVar = ((m1.p) gfVar).mediaPeriodId) != null) {
            return i2(new mg.n3(fhVar));
        }
        return yk();
    }

    @Override // fj.y
    public final void wz(final m1.m mVar, @Nullable final a9.c5 c5Var) {
        final zn.y q2 = q();
        jm(q2, 1009, new z.y() { // from class: fj.fb
            @Override // v5.z.y
            public final void invoke(Object obj) {
                yg.mh(zn.y.this, mVar, c5Var, (zn) obj);
            }
        });
    }

    @Override // fj.y
    public void x(zn znVar) {
        v5.y.v(znVar);
        this.f8150t.zn(znVar);
    }

    @Override // fj.y
    public final void x4(final Exception exc) {
        final zn.y q2 = q();
        jm(q2, 1029, new z.y() { // from class: fj.v
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).fh(zn.y.this, exc);
            }
        });
    }

    @Override // fj.y
    public final void xc(final Exception exc) {
        final zn.y q2 = q();
        jm(q2, 1030, new z.y() { // from class: fj.ap
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).oz(zn.y.this, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.v
    public /* synthetic */ void y(int i, mg.n3 n3Var) {
        f8.f.y(this, i, n3Var);
    }

    public final zn.y yk() {
        return i2(this.f8149s.gv());
    }

    @Override // fj.y
    public void yt(final uo uoVar, Looper looper) {
        boolean z2;
        if (this.f8152w != null && !this.f8149s.f8155n3.isEmpty()) {
            z2 = false;
        } else {
            z2 = true;
        }
        v5.y.fb(z2);
        this.f8152w = (uo) v5.y.v(uoVar);
        this.f8148p = this.y.n3(looper, null);
        this.f8150t = this.f8150t.v(looper, new z.n3() { // from class: fj.w
            @Override // v5.z.n3
            public final void y(Object obj, v5.wz wzVar) {
                yg.this.z8(uoVar, (zn) obj, wzVar);
            }
        });
    }

    @Override // fj.y
    public final void z(final Object obj, final long j2) {
        final zn.y q2 = q();
        jm(q2, 26, new z.y() { // from class: fj.rs
            @Override // v5.z.y
            public final void invoke(Object obj2) {
                ((zn) obj2).b(zn.y.this, obj, j2);
            }
        });
    }

    public final /* synthetic */ void z8(uo uoVar, zn znVar, v5.wz wzVar) {
        znVar.rb(uoVar, new zn.n3(wzVar, this.f8146f));
    }

    @Override // com.google.android.exoplayer2.drm.v
    public final void zn(int i, @Nullable mg.n3 n3Var) {
        final zn.y j32 = j3(i, n3Var);
        jm(j32, 1026, new z.y() { // from class: fj.dm
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).y(zn.y.this);
            }
        });
    }

    @Override // m1.uo.gv
    public final void onPositionDiscontinuity(final uo.v vVar, final uo.v vVar2, final int i) {
        if (i == 1) {
            this.f8145co = false;
        }
        this.f8149s.i9((uo) v5.y.v(this.f8152w));
        final zn.y yk2 = yk();
        jm(yk2, 11, new z.y() { // from class: fj.oz
            @Override // v5.z.y
            public final void invoke(Object obj) {
                yg.fq(zn.y.this, i, vVar, vVar2, (zn) obj);
            }
        });
    }

    @Override // m1.uo.gv
    public void onCues(final qh.a aVar) {
        final zn.y yk2 = yk();
        jm(yk2, 27, new z.y() { // from class: fj.i4
            @Override // v5.z.y
            public final void invoke(Object obj) {
                ((zn) obj).ap(zn.y.this, aVar);
            }
        });
    }

    @Override // m1.uo.gv
    public void onRenderedFirstFrame() {
    }

    @Override // m1.uo.gv
    public void onLoadingChanged(boolean z2) {
    }

    public static /* synthetic */ void nd(zn znVar, v5.wz wzVar) {
    }

    @Override // m1.uo.gv
    public void onEvents(uo uoVar, uo.zn znVar) {
    }
}
