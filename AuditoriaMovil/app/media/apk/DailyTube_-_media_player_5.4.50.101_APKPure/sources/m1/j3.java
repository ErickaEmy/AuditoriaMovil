package m1;

import af.mg;
import af.u;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m1.j3;
/* loaded from: classes.dex */
public final class j3 {

    /* renamed from: c5  reason: collision with root package name */
    public final v5.p f10878c5;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10879f;

    /* renamed from: s  reason: collision with root package name */
    public final fj.y f10884s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public kx.o f10885t;

    /* renamed from: v  reason: collision with root package name */
    public final gv f10886v;
    public final fj.u0 y;

    /* renamed from: i9  reason: collision with root package name */
    public af.u f10882i9 = new u.y(0);

    /* renamed from: zn  reason: collision with root package name */
    public final IdentityHashMap<af.d0, zn> f10887zn = new IdentityHashMap<>();

    /* renamed from: gv  reason: collision with root package name */
    public final Map<Object, zn> f10881gv = new HashMap();

    /* renamed from: n3  reason: collision with root package name */
    public final List<zn> f10883n3 = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<zn, n3> f10877a = new HashMap<>();

    /* renamed from: fb  reason: collision with root package name */
    public final Set<zn> f10880fb = new HashSet();

    /* loaded from: classes.dex */
    public interface gv {
        void zn();
    }

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final mg.zn f10888n3;
        public final af.mg y;

        /* renamed from: zn  reason: collision with root package name */
        public final y f10889zn;

        public n3(af.mg mgVar, mg.zn znVar, y yVar) {
            this.y = mgVar;
            this.f10888n3 = znVar;
            this.f10889zn = yVar;
        }
    }

    /* loaded from: classes.dex */
    public final class y implements af.b, com.google.android.exoplayer2.drm.v {
        public final zn y;

        public y(zn znVar) {
            this.y = znVar;
        }

        @Override // af.b
        public void b(int i, @Nullable mg.n3 n3Var, final af.c cVar) {
            final Pair<Integer, mg.n3> q92 = q9(i, n3Var);
            if (q92 != null) {
                j3.this.f10878c5.c5(new Runnable() { // from class: m1.mp
                    @Override // java.lang.Runnable
                    public final void run() {
                        j3.y.this.k(q92, cVar);
                    }
                });
            }
        }

        public final /* synthetic */ void ct(Pair pair, af.i4 i4Var, af.c cVar) {
            j3.this.f10884s.mg(((Integer) pair.first).intValue(), (mg.n3) pair.second, i4Var, cVar);
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void d(int i, @Nullable mg.n3 n3Var, final int i5) {
            final Pair<Integer, mg.n3> q92 = q9(i, n3Var);
            if (q92 != null) {
                j3.this.f10878c5.c5(new Runnable() { // from class: m1.ix
                    @Override // java.lang.Runnable
                    public final void run() {
                        j3.y.this.u(q92, i5);
                    }
                });
            }
        }

        public final /* synthetic */ void dm(Pair pair, af.i4 i4Var, af.c cVar) {
            j3.this.f10884s.fb(((Integer) pair.first).intValue(), (mg.n3) pair.second, i4Var, cVar);
        }

        public final /* synthetic */ void eb(Pair pair, af.c cVar) {
            j3.this.f10884s.p(((Integer) pair.first).intValue(), (mg.n3) v5.y.v((mg.n3) pair.second), cVar);
        }

        public final /* synthetic */ void en(Pair pair) {
            j3.this.f10884s.zn(((Integer) pair.first).intValue(), (mg.n3) pair.second);
        }

        public final /* synthetic */ void f7(Pair pair) {
            j3.this.f10884s.mt(((Integer) pair.first).intValue(), (mg.n3) pair.second);
        }

        @Override // af.b
        public void fb(int i, @Nullable mg.n3 n3Var, final af.i4 i4Var, final af.c cVar) {
            final Pair<Integer, mg.n3> q92 = q9(i, n3Var);
            if (q92 != null) {
                j3.this.f10878c5.c5(new Runnable() { // from class: m1.yk
                    @Override // java.lang.Runnable
                    public final void run() {
                        j3.y.this.dm(q92, i4Var, cVar);
                    }
                });
            }
        }

        @Override // af.b
        public void fh(int i, @Nullable mg.n3 n3Var, final af.i4 i4Var, final af.c cVar) {
            final Pair<Integer, mg.n3> q92 = q9(i, n3Var);
            if (q92 != null) {
                j3.this.f10878c5.c5(new Runnable() { // from class: m1.ro
                    @Override // java.lang.Runnable
                    public final void run() {
                        j3.y.this.rs(q92, i4Var, cVar);
                    }
                });
            }
        }

        @Override // af.b
        public void j5(int i, @Nullable mg.n3 n3Var, final af.i4 i4Var, final af.c cVar, final IOException iOException, final boolean z2) {
            final Pair<Integer, mg.n3> q92 = q9(i, n3Var);
            if (q92 != null) {
                j3.this.f10878c5.c5(new Runnable() { // from class: m1.i2
                    @Override // java.lang.Runnable
                    public final void run() {
                        j3.y.this.o4(q92, i4Var, cVar, iOException, z2);
                    }
                });
            }
        }

        public final /* synthetic */ void jz(Pair pair) {
            j3.this.f10884s.ta(((Integer) pair.first).intValue(), (mg.n3) pair.second);
        }

        public final /* synthetic */ void k(Pair pair, af.c cVar) {
            j3.this.f10884s.b(((Integer) pair.first).intValue(), (mg.n3) pair.second, cVar);
        }

        @Override // af.b
        public void mg(int i, @Nullable mg.n3 n3Var, final af.i4 i4Var, final af.c cVar) {
            final Pair<Integer, mg.n3> q92 = q9(i, n3Var);
            if (q92 != null) {
                j3.this.f10878c5.c5(new Runnable() { // from class: m1.w2
                    @Override // java.lang.Runnable
                    public final void run() {
                        j3.y.this.ct(q92, i4Var, cVar);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void mt(int i, @Nullable mg.n3 n3Var) {
            final Pair<Integer, mg.n3> q92 = q9(i, n3Var);
            if (q92 != null) {
                j3.this.f10878c5.c5(new Runnable() { // from class: m1.q5
                    @Override // java.lang.Runnable
                    public final void run() {
                        j3.y.this.f7(q92);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void n(int i, @Nullable mg.n3 n3Var, final Exception exc) {
            final Pair<Integer, mg.n3> q92 = q9(i, n3Var);
            if (q92 != null) {
                j3.this.f10878c5.c5(new Runnable() { // from class: m1.cs
                    @Override // java.lang.Runnable
                    public final void run() {
                        j3.y.this.y5(q92, exc);
                    }
                });
            }
        }

        public final /* synthetic */ void o4(Pair pair, af.i4 i4Var, af.c cVar, IOException iOException, boolean z2) {
            j3.this.f10884s.j5(((Integer) pair.first).intValue(), (mg.n3) pair.second, i4Var, cVar, iOException, z2);
        }

        @Override // af.b
        public void p(int i, @Nullable mg.n3 n3Var, final af.c cVar) {
            final Pair<Integer, mg.n3> q92 = q9(i, n3Var);
            if (q92 != null) {
                j3.this.f10878c5.c5(new Runnable() { // from class: m1.i3
                    @Override // java.lang.Runnable
                    public final void run() {
                        j3.y.this.eb(q92, cVar);
                    }
                });
            }
        }

        @Nullable
        public final Pair<Integer, mg.n3> q9(int i, @Nullable mg.n3 n3Var) {
            mg.n3 n3Var2 = null;
            if (n3Var != null) {
                mg.n3 wz2 = j3.wz(this.y, n3Var);
                if (wz2 == null) {
                    return null;
                }
                n3Var2 = wz2;
            }
            return Pair.create(Integer.valueOf(j3.mt(this.y, i)), n3Var2);
        }

        public final /* synthetic */ void rs(Pair pair, af.i4 i4Var, af.c cVar) {
            j3.this.f10884s.fh(((Integer) pair.first).intValue(), (mg.n3) pair.second, i4Var, cVar);
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void ta(int i, @Nullable mg.n3 n3Var) {
            final Pair<Integer, mg.n3> q92 = q9(i, n3Var);
            if (q92 != null) {
                j3.this.f10878c5.c5(new Runnable() { // from class: m1.vn
                    @Override // java.lang.Runnable
                    public final void run() {
                        j3.y.this.jz(q92);
                    }
                });
            }
        }

        public final /* synthetic */ void u(Pair pair, int i) {
            j3.this.f10884s.d(((Integer) pair.first).intValue(), (mg.n3) pair.second, i);
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void w(int i, @Nullable mg.n3 n3Var) {
            final Pair<Integer, mg.n3> q92 = q9(i, n3Var);
            if (q92 != null) {
                j3.this.f10878c5.c5(new Runnable() { // from class: m1.le
                    @Override // java.lang.Runnable
                    public final void run() {
                        j3.y.this.xg(q92);
                    }
                });
            }
        }

        public final /* synthetic */ void xg(Pair pair) {
            j3.this.f10884s.w(((Integer) pair.first).intValue(), (mg.n3) pair.second);
        }

        @Override // com.google.android.exoplayer2.drm.v
        public /* synthetic */ void y(int i, mg.n3 n3Var) {
            f8.f.y(this, i, n3Var);
        }

        public final /* synthetic */ void y5(Pair pair, Exception exc) {
            j3.this.f10884s.n(((Integer) pair.first).intValue(), (mg.n3) pair.second, exc);
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void zn(int i, @Nullable mg.n3 n3Var) {
            final Pair<Integer, mg.n3> q92 = q9(i, n3Var);
            if (q92 != null) {
                j3.this.f10878c5.c5(new Runnable() { // from class: m1.x5
                    @Override // java.lang.Runnable
                    public final void run() {
                        j3.y.this.en(q92);
                    }
                });
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class zn implements oa {

        /* renamed from: gv  reason: collision with root package name */
        public int f10891gv;

        /* renamed from: v  reason: collision with root package name */
        public boolean f10893v;
        public final af.n y;

        /* renamed from: zn  reason: collision with root package name */
        public final List<mg.n3> f10894zn = new ArrayList();

        /* renamed from: n3  reason: collision with root package name */
        public final Object f10892n3 = new Object();

        public zn(af.mg mgVar, boolean z2) {
            this.y = new af.n(mgVar, z2);
        }

        @Override // m1.oa
        public hy n3() {
            return this.y.vp();
        }

        @Override // m1.oa
        public Object y() {
            return this.f10892n3;
        }

        public void zn(int i) {
            this.f10891gv = i;
            this.f10893v = false;
            this.f10894zn.clear();
        }
    }

    public j3(gv gvVar, fj.y yVar, v5.p pVar, fj.u0 u0Var) {
        this.y = u0Var;
        this.f10886v = gvVar;
        this.f10884s = yVar;
        this.f10878c5 = pVar;
    }

    public static int mt(zn znVar, int i) {
        return i + znVar.f10891gv;
    }

    public static Object tl(Object obj) {
        return m1.y.c(obj);
    }

    public static Object w(zn znVar, Object obj) {
        return m1.y.rz(znVar.f10892n3, obj);
    }

    @Nullable
    public static mg.n3 wz(zn znVar, mg.n3 n3Var) {
        for (int i = 0; i < znVar.f10894zn.size(); i++) {
            if (znVar.f10894zn.get(i).f238gv == n3Var.f238gv) {
                return n3Var.zn(w(znVar, n3Var.y));
            }
        }
        return null;
    }

    public static Object xc(Object obj) {
        return m1.y.d0(obj);
    }

    public hy a(int i, List<zn> list, af.u uVar) {
        if (!list.isEmpty()) {
            this.f10882i9 = uVar;
            for (int i5 = i; i5 < list.size() + i; i5++) {
                zn znVar = list.get(i5 - i);
                if (i5 > 0) {
                    zn znVar2 = this.f10883n3.get(i5 - 1);
                    znVar.zn(znVar2.f10891gv + znVar2.y.vp().z());
                } else {
                    znVar.zn(0);
                }
                fb(i5, znVar.y.vp().z());
                this.f10883n3.add(i5, znVar);
                this.f10881gv.put(znVar.f10892n3, znVar);
                if (this.f10879f) {
                    f3(znVar);
                    if (this.f10887zn.isEmpty()) {
                        this.f10880fb.add(znVar);
                    } else {
                        i9(znVar);
                    }
                }
            }
        }
        return c5();
    }

    public void c(af.d0 d0Var) {
        zn znVar = (zn) v5.y.v(this.f10887zn.remove(d0Var));
        znVar.y.u(d0Var);
        znVar.f10894zn.remove(((af.f3) d0Var).y);
        if (!this.f10887zn.isEmpty()) {
            f();
        }
        r(znVar);
    }

    public hy c5() {
        if (this.f10883n3.isEmpty()) {
            return hy.y;
        }
        int i = 0;
        for (int i5 = 0; i5 < this.f10883n3.size(); i5++) {
            zn znVar = this.f10883n3.get(i5);
            znVar.f10891gv = i;
            i += znVar.y.vp().z();
        }
        return new h(this.f10883n3, this.f10882i9);
    }

    public boolean co() {
        return this.f10879f;
    }

    public hy d0(int i, int i5, af.u uVar) {
        boolean z2;
        if (i >= 0 && i <= i5 && i5 <= p()) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        this.f10882i9 = uVar;
        fh(i, i5);
        return c5();
    }

    public final void f() {
        Iterator<zn> it = this.f10880fb.iterator();
        while (it.hasNext()) {
            zn next = it.next();
            if (next.f10894zn.isEmpty()) {
                i9(next);
                it.remove();
            }
        }
    }

    public final void f3(zn znVar) {
        af.n nVar = znVar.y;
        mg.zn znVar2 = new mg.zn() { // from class: m1.w9
            @Override // af.mg.zn
            public final void y(af.mg mgVar, hy hyVar) {
                j3.this.z(mgVar, hyVar);
            }
        };
        y yVar = new y(znVar);
        this.f10877a.put(znVar, new n3(nVar, znVar2, yVar));
        nVar.y5(v5.j5.n(), yVar);
        nVar.o(v5.j5.n(), yVar);
        nVar.mt(znVar2, this.f10885t, this.y);
    }

    public final void fb(int i, int i5) {
        while (i < this.f10883n3.size()) {
            this.f10883n3.get(i).f10891gv += i5;
            i++;
        }
    }

    public final void fh(int i, int i5) {
        for (int i6 = i5 - 1; i6 >= i; i6--) {
            zn remove = this.f10883n3.remove(i6);
            this.f10881gv.remove(remove.f10892n3);
            fb(i6, -remove.y.vp().z());
            remove.f10893v = true;
            if (this.f10879f) {
                r(remove);
            }
        }
    }

    public void i4(@Nullable kx.o oVar) {
        v5.y.fb(!this.f10879f);
        this.f10885t = oVar;
        for (int i = 0; i < this.f10883n3.size(); i++) {
            zn znVar = this.f10883n3.get(i);
            f3(znVar);
            this.f10880fb.add(znVar);
        }
        this.f10879f = true;
    }

    public final void i9(zn znVar) {
        n3 n3Var = this.f10877a.get(znVar);
        if (n3Var != null) {
            n3Var.y.vl(n3Var.f10888n3);
        }
    }

    public hy mg(af.u uVar) {
        int p2 = p();
        if (uVar.getLength() != p2) {
            uVar = uVar.x4().f3(0, p2);
        }
        this.f10882i9 = uVar;
        return c5();
    }

    public void n() {
        for (n3 n3Var : this.f10877a.values()) {
            try {
                n3Var.y.hw(n3Var.f10888n3);
            } catch (RuntimeException e2) {
                v5.r.gv("MediaSourceList", "Failed to release child source.", e2);
            }
            n3Var.y.jz(n3Var.f10889zn);
            n3Var.y.j(n3Var.f10889zn);
        }
        this.f10877a.clear();
        this.f10880fb.clear();
        this.f10879f = false;
    }

    public int p() {
        return this.f10883n3.size();
    }

    public final void r(zn znVar) {
        if (znVar.f10893v && znVar.f10894zn.isEmpty()) {
            n3 n3Var = (n3) v5.y.v(this.f10877a.remove(znVar));
            n3Var.y.hw(n3Var.f10888n3);
            n3Var.y.jz(n3Var.f10889zn);
            n3Var.y.j(n3Var.f10889zn);
            this.f10880fb.remove(znVar);
        }
    }

    public hy rz(List<zn> list, af.u uVar) {
        fh(0, this.f10883n3.size());
        return a(this.f10883n3.size(), list, uVar);
    }

    public af.d0 s(mg.n3 n3Var, kx.n3 n3Var2, long j2) {
        Object xc2 = xc(n3Var.y);
        mg.n3 zn2 = n3Var.zn(tl(n3Var.y));
        zn znVar = (zn) v5.y.v(this.f10881gv.get(xc2));
        t(znVar);
        znVar.f10894zn.add(zn2);
        af.f3 f72 = znVar.y.f7(zn2, n3Var2, j2);
        this.f10887zn.put(f72, znVar);
        f();
        return f72;
    }

    public final void t(zn znVar) {
        this.f10880fb.add(znVar);
        n3 n3Var = this.f10877a.get(znVar);
        if (n3Var != null) {
            n3Var.y.z6(n3Var.f10888n3);
        }
    }

    public hy x4(int i, int i5, int i6, af.u uVar) {
        boolean z2;
        if (i >= 0 && i <= i5 && i5 <= p() && i6 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        this.f10882i9 = uVar;
        if (i != i5 && i != i6) {
            int min = Math.min(i, i6);
            int max = Math.max(((i5 - i) + i6) - 1, i5 - 1);
            int i8 = this.f10883n3.get(min).f10891gv;
            v5.j5.o0(this.f10883n3, i, i5, i6);
            while (min <= max) {
                zn znVar = this.f10883n3.get(min);
                znVar.f10891gv = i8;
                i8 += znVar.y.vp().z();
                min++;
            }
            return c5();
        }
        return c5();
    }

    public final /* synthetic */ void z(af.mg mgVar, hy hyVar) {
        this.f10886v.zn();
    }
}
