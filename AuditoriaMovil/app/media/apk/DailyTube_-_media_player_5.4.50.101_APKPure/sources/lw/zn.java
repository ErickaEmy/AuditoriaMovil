package lw;

import af.b;
import af.c;
import af.i4;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kx.d0;
import kx.mg;
import kx.ta;
import kx.tl;
import kx.z6;
import lw.fb;
import lw.i9;
import lw.s;
import lw.t;
import lw.zn;
import m1.ne;
import v5.j5;
import z0.d0;
/* loaded from: classes.dex */
public final class zn implements t, ta.n3<z6<c5>> {

    /* renamed from: fh  reason: collision with root package name */
    public static final t.y f10504fh = new t.y() { // from class: lw.n3
        @Override // lw.t.y
        public final t y(h4.fb fbVar, mg mgVar, f fVar) {
            return new zn(fbVar, mgVar, fVar);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public boolean f10505c;
    @Nullable

    /* renamed from: co  reason: collision with root package name */
    public Handler f10506co;

    /* renamed from: d0  reason: collision with root package name */
    public long f10507d0;

    /* renamed from: f  reason: collision with root package name */
    public final CopyOnWriteArrayList<t.n3> f10508f;
    @Nullable

    /* renamed from: f3  reason: collision with root package name */
    public Uri f10509f3;

    /* renamed from: fb  reason: collision with root package name */
    public final mg f10510fb;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public fb f10511n;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public ta f10512p;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    public s f10513r;

    /* renamed from: s  reason: collision with root package name */
    public final HashMap<Uri, C0150zn> f10514s;

    /* renamed from: t  reason: collision with root package name */
    public final double f10515t;

    /* renamed from: v  reason: collision with root package name */
    public final f f10516v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public b.y f10517w;
    public final h4.fb y;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    public t.v f10518z;

    /* loaded from: classes.dex */
    public class n3 implements t.n3 {
        public n3() {
        }

        @Override // lw.t.n3
        public void a() {
            zn.this.f10508f.remove(this);
        }

        @Override // lw.t.n3
        public boolean n3(Uri uri, mg.zn znVar, boolean z2) {
            C0150zn c0150zn;
            if (zn.this.f10511n == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                List<s.n3> list = ((s) j5.i9(zn.this.f10513r)).f10494v;
                int i = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    C0150zn c0150zn2 = (C0150zn) zn.this.f10514s.get(list.get(i5).y);
                    if (c0150zn2 != null && elapsedRealtime < c0150zn2.f10522p) {
                        i++;
                    }
                }
                mg.n3 n32 = zn.this.f10510fb.n3(new mg.y(1, 0, zn.this.f10513r.f10494v.size(), i), znVar);
                if (n32 != null && n32.y == 2 && (c0150zn = (C0150zn) zn.this.f10514s.get(uri)) != null) {
                    c0150zn.s(n32.f10055n3);
                }
            }
            return false;
        }
    }

    /* renamed from: lw.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0150zn implements ta.n3<z6<c5>> {

        /* renamed from: co  reason: collision with root package name */
        public boolean f10519co;

        /* renamed from: f  reason: collision with root package name */
        public long f10520f;

        /* renamed from: fb  reason: collision with root package name */
        public final tl f10521fb;

        /* renamed from: p  reason: collision with root package name */
        public long f10522p;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        public fb f10524s;

        /* renamed from: t  reason: collision with root package name */
        public long f10525t;

        /* renamed from: v  reason: collision with root package name */
        public final ta f10526v = new ta("DefaultHlsPlaylistTracker:MediaPlaylist");

        /* renamed from: w  reason: collision with root package name */
        public long f10527w;
        public final Uri y;
        @Nullable

        /* renamed from: z  reason: collision with root package name */
        public IOException f10528z;

        public C0150zn(Uri uri) {
            this.y = uri;
            this.f10521fb = zn.this.y.y(4);
        }

        public final Uri c5() {
            String str;
            fb fbVar = this.f10524s;
            if (fbVar != null) {
                fb.a aVar = fbVar.f10405x4;
                if (aVar.y != -9223372036854775807L || aVar.f10410v) {
                    Uri.Builder buildUpon = this.y.buildUpon();
                    fb fbVar2 = this.f10524s;
                    if (fbVar2.f10405x4.f10410v) {
                        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(fbVar2.f10392f + fbVar2.f10396mt.size()));
                        fb fbVar3 = this.f10524s;
                        if (fbVar3.f10404wz != -9223372036854775807L) {
                            List<fb.n3> list = fbVar3.f10391co;
                            int size = list.size();
                            if (!list.isEmpty() && ((fb.n3) d0.v(list)).f10415n) {
                                size--;
                            }
                            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                        }
                    }
                    fb.a aVar2 = this.f10524s.f10405x4;
                    if (aVar2.y != -9223372036854775807L) {
                        if (aVar2.f10409n3) {
                            str = "v2";
                        } else {
                            str = "YES";
                        }
                        buildUpon.appendQueryParameter("_HLS_skip", str);
                    }
                    return buildUpon.build();
                }
            }
            return this.y;
        }

        @Override // kx.ta.n3
        /* renamed from: co */
        public ta.zn oz(z6<c5> z6Var, long j2, long j4, IOException iOException, int i) {
            boolean z2;
            int i5;
            ta.zn znVar;
            i4 i4Var = new i4(z6Var.y, z6Var.f10190n3, z6Var.v(), z6Var.zn(), j2, j4, z6Var.y());
            if (z6Var.v().getQueryParameter("_HLS_msn") != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z3 = iOException instanceof i9.y;
            if (z2 || z3) {
                if (iOException instanceof d0.v) {
                    i5 = ((d0.v) iOException).responseCode;
                } else {
                    i5 = Integer.MAX_VALUE;
                }
                if (z3 || i5 == 400 || i5 == 503) {
                    this.f10527w = SystemClock.elapsedRealtime();
                    tl();
                    ((b.y) j5.i9(zn.this.f10517w)).f3(i4Var, z6Var.f10192zn, iOException, true);
                    return ta.f10108a;
                }
            }
            mg.zn znVar2 = new mg.zn(i4Var, new c(z6Var.f10192zn), iOException, i);
            if (zn.this.b(this.y, znVar2, false)) {
                long gv2 = zn.this.f10510fb.gv(znVar2);
                if (gv2 != -9223372036854775807L) {
                    znVar = ta.s(false, gv2);
                } else {
                    znVar = ta.f10109fb;
                }
            } else {
                znVar = ta.f10108a;
            }
            boolean zn2 = znVar.zn();
            zn.this.f10517w.f3(i4Var, z6Var.f10192zn, iOException, !zn2);
            if (!zn2) {
                zn.this.f10510fb.zn(z6Var.y);
            }
            return znVar;
        }

        public boolean f() {
            int i;
            if (this.f10524s == null) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(30000L, j5.gf(this.f10524s.f10398r));
            fb fbVar = this.f10524s;
            if (!fbVar.f10406xc && (i = fbVar.f10394gv) != 2 && i != 1 && this.f10520f + max <= elapsedRealtime) {
                return false;
            }
            return true;
        }

        @Nullable
        public fb i9() {
            return this.f10524s;
        }

        @Override // kx.ta.n3
        /* renamed from: mt */
        public void ta(z6<c5> z6Var, long j2, long j4) {
            c5 gv2 = z6Var.gv();
            i4 i4Var = new i4(z6Var.y, z6Var.f10190n3, z6Var.v(), z6Var.zn(), j2, j4, z6Var.y());
            if (gv2 instanceof fb) {
                z((fb) gv2, i4Var);
                zn.this.f10517w.z(i4Var, 4);
            } else {
                this.f10528z = ne.v("Loaded playlist has unexpected type.", null);
                zn.this.f10517w.f3(i4Var, 4, this.f10528z, true);
            }
            zn.this.f10510fb.zn(z6Var.y);
        }

        @Override // kx.ta.n3
        /* renamed from: p */
        public void ud(z6<c5> z6Var, long j2, long j4, boolean z2) {
            i4 i4Var = new i4(z6Var.y, z6Var.f10190n3, z6Var.v(), z6Var.zn(), j2, j4, z6Var.y());
            zn.this.f10510fb.zn(z6Var.y);
            zn.this.f10517w.p(i4Var, 4);
        }

        public void r() {
            this.f10526v.t();
        }

        public final boolean s(long j2) {
            this.f10522p = SystemClock.elapsedRealtime() + j2;
            if (this.y.equals(zn.this.f10509f3) && !zn.this.a8()) {
                return true;
            }
            return false;
        }

        public final /* synthetic */ void t(Uri uri) {
            this.f10519co = false;
            wz(uri);
        }

        public void tl() {
            xc(this.y);
        }

        public void w() throws IOException {
            this.f10526v.n3();
            IOException iOException = this.f10528z;
            if (iOException == null) {
                return;
            }
            throw iOException;
        }

        public final void wz(Uri uri) {
            z6 z6Var = new z6(this.f10521fb, uri, 4, zn.this.f10516v.n3(zn.this.f10513r, this.f10524s));
            zn.this.f10517w.c(new i4(z6Var.y, z6Var.f10190n3, this.f10526v.wz(z6Var, this, zn.this.f10510fb.y(z6Var.f10192zn))), z6Var.f10192zn);
        }

        public final void xc(final Uri uri) {
            this.f10522p = 0L;
            if (!this.f10519co && !this.f10526v.i9() && !this.f10526v.c5()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.f10527w) {
                    this.f10519co = true;
                    zn.this.f10506co.postDelayed(new Runnable() { // from class: lw.gv
                        @Override // java.lang.Runnable
                        public final void run() {
                            zn.C0150zn.this.t(uri);
                        }
                    }, this.f10527w - elapsedRealtime);
                    return;
                }
                wz(uri);
            }
        }

        public final void z(fb fbVar, i4 i4Var) {
            boolean z2;
            long j2;
            fb fbVar2 = this.f10524s;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f10520f = elapsedRealtime;
            fb rz2 = zn.this.rz(fbVar2, fbVar);
            this.f10524s = rz2;
            IOException iOException = null;
            if (rz2 != fbVar2) {
                this.f10528z = null;
                this.f10525t = elapsedRealtime;
                zn.this.hw(this.y, rz2);
            } else if (!rz2.f10406xc) {
                fb fbVar3 = this.f10524s;
                if (fbVar.f10392f + fbVar.f10396mt.size() < fbVar3.f10392f) {
                    iOException = new t.zn(this.y);
                    z2 = true;
                } else {
                    z2 = false;
                    if (elapsedRealtime - this.f10525t > j5.gf(fbVar3.f10401tl) * zn.this.f10515t) {
                        iOException = new t.gv(this.y);
                    }
                }
                if (iOException != null) {
                    this.f10528z = iOException;
                    zn.this.b(this.y, new mg.zn(i4Var, new c(4), iOException, 1), z2);
                }
            }
            fb fbVar4 = this.f10524s;
            if (!fbVar4.f10405x4.f10410v) {
                if (fbVar4 != fbVar2) {
                    j2 = fbVar4.f10401tl;
                } else {
                    j2 = fbVar4.f10401tl / 2;
                }
            } else {
                j2 = 0;
            }
            this.f10527w = elapsedRealtime + j5.gf(j2);
            if ((this.f10524s.f10404wz != -9223372036854775807L || this.y.equals(zn.this.f10509f3)) && !this.f10524s.f10406xc) {
                xc(c5());
            }
        }
    }

    public zn(h4.fb fbVar, mg mgVar, f fVar) {
        this(fbVar, mgVar, fVar, 3.5d);
    }

    public static fb.gv fh(fb fbVar, fb fbVar2) {
        int i = (int) (fbVar2.f10392f - fbVar.f10392f);
        List<fb.gv> list = fbVar.f10396mt;
        if (i < list.size()) {
            return list.get(i);
        }
        return null;
    }

    @Override // lw.t
    public void a(Uri uri) {
        this.f10514s.get(uri).tl();
    }

    public final boolean a8() {
        List<s.n3> list = this.f10513r.f10494v;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            C0150zn c0150zn = (C0150zn) v5.y.v(this.f10514s.get(list.get(i).y));
            if (elapsedRealtime > c0150zn.f10522p) {
                Uri uri = c0150zn.y;
                this.f10509f3 = uri;
                c0150zn.xc(z6(uri));
                return true;
            }
        }
        return false;
    }

    public final boolean b(Uri uri, mg.zn znVar, boolean z2) {
        Iterator<t.n3> it = this.f10508f.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            z3 |= !it.next().n3(uri, znVar, z2);
        }
        return z3;
    }

    @Override // lw.t
    public void c5() throws IOException {
        ta taVar = this.f10512p;
        if (taVar != null) {
            taVar.n3();
        }
        Uri uri = this.f10509f3;
        if (uri != null) {
            n3(uri);
        }
    }

    public final long d(@Nullable fb fbVar, fb fbVar2) {
        long j2;
        if (fbVar2.f10403w) {
            return fbVar2.f10399s;
        }
        fb fbVar3 = this.f10511n;
        if (fbVar3 != null) {
            j2 = fbVar3.f10399s;
        } else {
            j2 = 0;
        }
        if (fbVar == null) {
            return j2;
        }
        int size = fbVar.f10396mt.size();
        fb.gv fh2 = fh(fbVar, fbVar2);
        if (fh2 != null) {
            return fbVar.f10399s + fh2.f10417f;
        }
        if (size == fbVar2.f10392f - fbVar.f10392f) {
            return fbVar.v();
        }
        return j2;
    }

    public final void d0(List<Uri> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Uri uri = list.get(i);
            this.f10514s.put(uri, new C0150zn(uri));
        }
    }

    public final boolean ej(Uri uri) {
        List<s.n3> list = this.f10513r.f10494v;
        for (int i = 0; i < list.size(); i++) {
            if (uri.equals(list.get(i).y)) {
                return true;
            }
        }
        return false;
    }

    @Override // lw.t
    @Nullable
    public fb f(Uri uri, boolean z2) {
        fb i92 = this.f10514s.get(uri).i9();
        if (i92 != null && z2) {
            x(uri);
        }
        return i92;
    }

    @Override // lw.t
    public boolean fb(Uri uri) {
        return this.f10514s.get(uri).f();
    }

    @Override // lw.t
    public long gv() {
        return this.f10507d0;
    }

    public final void hw(Uri uri, fb fbVar) {
        if (uri.equals(this.f10509f3)) {
            if (this.f10511n == null) {
                this.f10505c = !fbVar.f10406xc;
                this.f10507d0 = fbVar.f10399s;
            }
            this.f10511n = fbVar;
            this.f10518z.w(fbVar);
        }
        Iterator<t.n3> it = this.f10508f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    @Override // lw.t
    public void i9(t.n3 n3Var) {
        this.f10508f.remove(n3Var);
    }

    @Override // lw.t
    public boolean isLive() {
        return this.f10505c;
    }

    @Override // kx.ta.n3
    /* renamed from: k5 */
    public void ud(z6<c5> z6Var, long j2, long j4, boolean z2) {
        i4 i4Var = new i4(z6Var.y, z6Var.f10190n3, z6Var.v(), z6Var.zn(), j2, j4, z6Var.y());
        this.f10510fb.zn(z6Var.y);
        this.f10517w.p(i4Var, 4);
    }

    public final int mg(@Nullable fb fbVar, fb fbVar2) {
        int i;
        if (fbVar2.f10390c5) {
            return fbVar2.f10395i9;
        }
        fb fbVar3 = this.f10511n;
        if (fbVar3 != null) {
            i = fbVar3.f10395i9;
        } else {
            i = 0;
        }
        if (fbVar == null) {
            return i;
        }
        fb.gv fh2 = fh(fbVar, fbVar2);
        if (fh2 != null) {
            return (fbVar.f10395i9 + fh2.f10421s) - fbVar2.f10396mt.get(0).f10421s;
        }
        return i;
    }

    @Override // lw.t
    public void n3(Uri uri) throws IOException {
        this.f10514s.get(uri).w();
    }

    public final fb rz(@Nullable fb fbVar, fb fbVar2) {
        if (!fbVar2.a(fbVar)) {
            if (fbVar2.f10406xc) {
                return fbVar.gv();
            }
            return fbVar;
        }
        return fbVar2.zn(d(fbVar, fbVar2), mg(fbVar, fbVar2));
    }

    @Override // lw.t
    public boolean s(Uri uri, long j2) {
        C0150zn c0150zn = this.f10514s.get(uri);
        if (c0150zn != null) {
            return !c0150zn.s(j2);
        }
        return false;
    }

    @Override // lw.t
    public void stop() {
        this.f10509f3 = null;
        this.f10511n = null;
        this.f10513r = null;
        this.f10507d0 = -9223372036854775807L;
        this.f10512p.t();
        this.f10512p = null;
        for (C0150zn c0150zn : this.f10514s.values()) {
            c0150zn.r();
        }
        this.f10506co.removeCallbacksAndMessages(null);
        this.f10506co = null;
        this.f10514s.clear();
    }

    @Override // lw.t
    @Nullable
    public s v() {
        return this.f10513r;
    }

    @Override // kx.ta.n3
    /* renamed from: vl */
    public ta.zn oz(z6<c5> z6Var, long j2, long j4, IOException iOException, int i) {
        boolean z2;
        i4 i4Var = new i4(z6Var.y, z6Var.f10190n3, z6Var.v(), z6Var.zn(), j2, j4, z6Var.y());
        long gv2 = this.f10510fb.gv(new mg.zn(i4Var, new c(z6Var.f10192zn), iOException, i));
        if (gv2 == -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f10517w.f3(i4Var, z6Var.f10192zn, iOException, z2);
        if (z2) {
            this.f10510fb.zn(z6Var.y);
        }
        if (z2) {
            return ta.f10109fb;
        }
        return ta.s(false, gv2);
    }

    public final void x(Uri uri) {
        if (!uri.equals(this.f10509f3) && ej(uri)) {
            fb fbVar = this.f10511n;
            if (fbVar == null || !fbVar.f10406xc) {
                this.f10509f3 = uri;
                C0150zn c0150zn = this.f10514s.get(uri);
                fb fbVar2 = c0150zn.f10524s;
                if (fbVar2 == null || !fbVar2.f10406xc) {
                    c0150zn.xc(z6(uri));
                    return;
                }
                this.f10511n = fbVar2;
                this.f10518z.w(fbVar2);
            }
        }
    }

    @Override // lw.t
    public void y(t.n3 n3Var) {
        v5.y.v(n3Var);
        this.f10508f.add(n3Var);
    }

    @Override // kx.ta.n3
    /* renamed from: yt */
    public void ta(z6<c5> z6Var, long j2, long j4) {
        s sVar;
        c5 gv2 = z6Var.gv();
        boolean z2 = gv2 instanceof fb;
        if (z2) {
            sVar = s.v(gv2.y);
        } else {
            sVar = (s) gv2;
        }
        this.f10513r = sVar;
        this.f10509f3 = sVar.f10494v.get(0).y;
        this.f10508f.add(new n3());
        d0(sVar.f10489gv);
        i4 i4Var = new i4(z6Var.y, z6Var.f10190n3, z6Var.v(), z6Var.zn(), j2, j4, z6Var.y());
        C0150zn c0150zn = this.f10514s.get(this.f10509f3);
        if (z2) {
            c0150zn.z((fb) gv2, i4Var);
        } else {
            c0150zn.tl();
        }
        this.f10510fb.zn(z6Var.y);
        this.f10517w.z(i4Var, 4);
    }

    public final Uri z6(Uri uri) {
        fb.zn znVar;
        fb fbVar = this.f10511n;
        if (fbVar != null && fbVar.f10405x4.f10410v && (znVar = fbVar.f10407z.get(uri)) != null) {
            Uri.Builder buildUpon = uri.buildUpon();
            buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(znVar.f10426n3));
            int i = znVar.f10427zn;
            if (i != -1) {
                buildUpon.appendQueryParameter("_HLS_part", String.valueOf(i));
            }
            return buildUpon.build();
        }
        return uri;
    }

    @Override // lw.t
    public void zn(Uri uri, b.y yVar, t.v vVar) {
        boolean z2;
        this.f10506co = j5.i4();
        this.f10517w = yVar;
        this.f10518z = vVar;
        z6 z6Var = new z6(this.y.y(4), uri, 4, this.f10516v.y());
        if (this.f10512p == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        ta taVar = new ta("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.f10512p = taVar;
        yVar.c(new i4(z6Var.y, z6Var.f10190n3, taVar.wz(z6Var, this, this.f10510fb.y(z6Var.f10192zn))), z6Var.f10192zn);
    }

    public zn(h4.fb fbVar, mg mgVar, f fVar, double d2) {
        this.y = fbVar;
        this.f10516v = fVar;
        this.f10510fb = mgVar;
        this.f10515t = d2;
        this.f10508f = new CopyOnWriteArrayList<>();
        this.f10514s = new HashMap<>();
        this.f10507d0 = -9223372036854775807L;
    }
}
