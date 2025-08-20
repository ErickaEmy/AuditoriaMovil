package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.rtsp.a;
import com.google.android.exoplayer2.source.rtsp.fb;
import com.google.android.exoplayer2.source.rtsp.gv;
import com.google.android.exoplayer2.source.rtsp.s;
import com.google.android.exoplayer2.source.rtsp.v;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.SocketFactory;
import m1.ne;
import r4.c;
import r4.co;
import r4.i4;
import r4.n;
import r4.r;
import r4.w;
import r4.xc;
import r4.z;
import v5.j5;
import z0.d0;
import z0.f3;
import z0.x4;
/* loaded from: classes.dex */
public final class gv implements Closeable {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.google.android.exoplayer2.source.rtsp.zn f4606c;

    /* renamed from: co  reason: collision with root package name */
    public Uri f4607co;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4608d;

    /* renamed from: ej  reason: collision with root package name */
    public boolean f4610ej;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f4611f;
    @Nullable

    /* renamed from: f3  reason: collision with root package name */
    public String f4612f3;

    /* renamed from: fb  reason: collision with root package name */
    public final String f4613fb;

    /* renamed from: fh  reason: collision with root package name */
    public boolean f4614fh;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public n3 f4615n;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    public s.y f4617r;

    /* renamed from: s  reason: collision with root package name */
    public final SocketFactory f4618s;

    /* renamed from: v  reason: collision with root package name */
    public final v f4620v;
    public final a y;

    /* renamed from: t  reason: collision with root package name */
    public final ArrayDeque<a.gv> f4619t = new ArrayDeque<>();

    /* renamed from: w  reason: collision with root package name */
    public final SparseArray<r> f4621w = new SparseArray<>();

    /* renamed from: p  reason: collision with root package name */
    public final C0051gv f4616p = new C0051gv();

    /* renamed from: z  reason: collision with root package name */
    public fb f4623z = new fb(new zn());

    /* renamed from: x  reason: collision with root package name */
    public long f4622x = -9223372036854775807L;

    /* renamed from: d0  reason: collision with root package name */
    public int f4609d0 = -1;

    /* loaded from: classes.dex */
    public interface a {
        void n3(String str, @Nullable Throwable th);

        void v(i4 i4Var, x4<xc> x4Var);
    }

    /* renamed from: com.google.android.exoplayer2.source.rtsp.gv$gv  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0051gv {

        /* renamed from: n3  reason: collision with root package name */
        public r f4624n3;
        public int y;

        public C0051gv() {
        }

        public void a(Uri uri, String str) {
            boolean z2;
            if (gv.this.f4609d0 == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.fb(z2);
            s(y(5, str, f3.x4(), uri));
            gv.this.f4610ej = true;
        }

        public final void c5(r4.x4 x4Var) {
            x4<String> mt2 = s.mt(x4Var);
            gv.this.ro(mt2);
            gv.this.f4623z.co(mt2);
        }

        public void f(Uri uri, String str) {
            if (gv.this.f4609d0 != -1 && gv.this.f4609d0 != 0) {
                gv.this.f4609d0 = 0;
                s(y(12, str, f3.x4(), uri));
            }
        }

        public void fb(Uri uri, long j2, String str) {
            boolean z2 = true;
            if (gv.this.f4609d0 != 1 && gv.this.f4609d0 != 2) {
                z2 = false;
            }
            v5.y.fb(z2);
            s(y(6, str, f3.ta("Range", i4.n3(j2)), uri));
        }

        public void gv(int i) {
            c5(new r4.x4(405, new v.n3(gv.this.f4613fb, gv.this.f4612f3, i).v()));
            this.y = Math.max(this.y, i + 1);
        }

        public void i9(Uri uri, String str, @Nullable String str2) {
            gv.this.f4609d0 = 0;
            s(y(10, str2, f3.ta("Transport", str), uri));
        }

        public void n3() {
            v5.y.c5(this.f4624n3);
            z0.i4<String, String> n32 = this.f4624n3.f13097zn.n3();
            HashMap hashMap = new HashMap();
            for (String str : n32.keySet()) {
                if (!str.equals("CSeq") && !str.equals("User-Agent") && !str.equals("Session") && !str.equals("Authorization")) {
                    hashMap.put(str, (String) d0.v(n32.get(str)));
                }
            }
            s(y(this.f4624n3.f13096n3, gv.this.f4612f3, hashMap, this.f4624n3.y));
        }

        public final void s(r rVar) {
            boolean z2;
            int parseInt = Integer.parseInt((String) v5.y.v(rVar.f13097zn.gv("CSeq")));
            if (gv.this.f4621w.get(parseInt) == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.fb(z2);
            gv.this.f4621w.append(parseInt, rVar);
            x4<String> p2 = s.p(rVar);
            gv.this.ro(p2);
            gv.this.f4623z.co(p2);
            this.f4624n3 = rVar;
        }

        public void v(Uri uri, @Nullable String str) {
            s(y(4, str, f3.x4(), uri));
        }

        public final r y(int i, @Nullable String str, Map<String, String> map, Uri uri) {
            String str2 = gv.this.f4613fb;
            int i5 = this.y;
            this.y = i5 + 1;
            v.n3 n3Var = new v.n3(str2, str, i5);
            if (gv.this.f4606c != null) {
                v5.y.c5(gv.this.f4617r);
                try {
                    n3Var.n3("Authorization", gv.this.f4606c.y(gv.this.f4617r, uri, i));
                } catch (ne e2) {
                    gv.this.w2(new RtspMediaSource.zn(e2));
                }
            }
            n3Var.gv(map);
            return new r(uri, i, n3Var.v(), "");
        }

        public void zn(Uri uri, @Nullable String str) {
            s(y(2, str, f3.x4(), uri));
        }
    }

    /* loaded from: classes.dex */
    public final class n3 implements Runnable, Closeable {

        /* renamed from: fb  reason: collision with root package name */
        public boolean f4626fb;

        /* renamed from: v  reason: collision with root package name */
        public final long f4628v;
        public final Handler y = j5.i4();

        public n3(long j2) {
            this.f4628v = j2;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f4626fb = false;
            this.y.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            gv.this.f4616p.v(gv.this.f4607co, gv.this.f4612f3);
            this.y.postDelayed(this, this.f4628v);
        }

        public void y() {
            if (this.f4626fb) {
                return;
            }
            this.f4626fb = true;
            this.y.postDelayed(this, this.f4628v);
        }
    }

    /* loaded from: classes.dex */
    public interface v {
        void gv();

        void y(long j2, x4<r4.f3> x4Var);

        void zn(RtspMediaSource.zn znVar);
    }

    /* loaded from: classes.dex */
    public final class zn implements fb.gv {
        public final Handler y = j5.i4();

        public zn() {
        }

        public final void a(List<String> list) {
            gv.this.f4616p.gv(Integer.parseInt((String) v5.y.v(s.f(list).f13097zn.gv("CSeq"))));
        }

        public final void c5(r4.f fVar) {
            i4 i4Var = i4.f13068zn;
            String str = fVar.f13048n3.y.get("range");
            if (str != null) {
                try {
                    i4Var = i4.gv(str);
                } catch (ne e2) {
                    gv.this.y.n3("SDP format error.", e2);
                    return;
                }
            }
            x4<xc> l2 = gv.l(fVar.f13048n3, gv.this.f4607co);
            if (l2.isEmpty()) {
                gv.this.y.n3("No playable track.", null);
                return;
            }
            gv.this.y.v(i4Var, l2);
            gv.this.f4614fh = true;
        }

        public final void f() {
            boolean z2;
            if (gv.this.f4609d0 == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.fb(z2);
            gv.this.f4609d0 = 1;
            gv.this.f4610ej = false;
            if (gv.this.f4622x != -9223372036854775807L) {
                gv gvVar = gv.this;
                gvVar.ne(j5.gf(gvVar.f4622x));
            }
        }

        public final void fb(List<String> list) {
            i4 gv2;
            x4<r4.f3> j52;
            Throwable znVar;
            r4.x4 t2 = s.t(list);
            int parseInt = Integer.parseInt((String) v5.y.v(t2.f13120n3.gv("CSeq")));
            r rVar = (r) gv.this.f4621w.get(parseInt);
            if (rVar == null) {
                return;
            }
            gv.this.f4621w.remove(parseInt);
            int i = rVar.f13096n3;
            try {
                try {
                    int i5 = t2.y;
                    if (i5 != 200) {
                        if (i5 != 401) {
                            if (i5 != 461) {
                                if (i5 != 301 && i5 != 302) {
                                    gv.this.w2(new RtspMediaSource.zn(s.z(i) + " " + t2.y));
                                    return;
                                }
                                if (gv.this.f4609d0 != -1) {
                                    gv.this.f4609d0 = 0;
                                }
                                String gv3 = t2.f13120n3.gv("Location");
                                if (gv3 == null) {
                                    gv.this.y.n3("Redirection without new location.", null);
                                    return;
                                }
                                Uri parse = Uri.parse(gv3);
                                gv.this.f4607co = s.w(parse);
                                gv.this.f4617r = s.wz(parse);
                                gv.this.f4616p.zn(gv.this.f4607co, gv.this.f4612f3);
                                return;
                            }
                            String str = s.z(i) + " " + t2.y;
                            String str2 = (String) v5.y.v(rVar.f13097zn.gv("Transport"));
                            gv gvVar = gv.this;
                            if (i == 10 && !str2.contains("TCP")) {
                                znVar = new RtspMediaSource.gv(str);
                            } else {
                                znVar = new RtspMediaSource.zn(str);
                            }
                            gvVar.w2(znVar);
                            return;
                        } else if (gv.this.f4617r == null || gv.this.f4608d) {
                            gv.this.w2(new RtspMediaSource.zn(s.z(i) + " " + t2.y));
                            return;
                        } else {
                            x4<String> v2 = t2.f13120n3.v("WWW-Authenticate");
                            if (!v2.isEmpty()) {
                                for (int i6 = 0; i6 < v2.size(); i6++) {
                                    gv.this.f4606c = s.xc(v2.get(i6));
                                    if (gv.this.f4606c.y == 2) {
                                        break;
                                    }
                                }
                                gv.this.f4616p.n3();
                                gv.this.f4608d = true;
                                return;
                            }
                            throw ne.v("Missing WWW-Authenticate header in a 401 response.", null);
                        }
                    }
                    switch (i) {
                        case 1:
                        case 3:
                        case 7:
                        case 8:
                        case 9:
                        case 11:
                        case 12:
                            return;
                        case 2:
                            c5(new r4.f(i5, c.n3(t2.f13121zn)));
                            return;
                        case 4:
                            i9(new co(i5, s.i9(t2.f13120n3.gv("Public"))));
                            return;
                        case 5:
                            f();
                            return;
                        case 6:
                            String gv4 = t2.f13120n3.gv("Range");
                            if (gv4 == null) {
                                gv2 = i4.f13068zn;
                            } else {
                                gv2 = i4.gv(gv4);
                            }
                            try {
                                String gv5 = t2.f13120n3.gv("RTP-Info");
                                if (gv5 == null) {
                                    j52 = x4.j5();
                                } else {
                                    j52 = r4.f3.y(gv5, gv.this.f4607co);
                                }
                            } catch (ne unused) {
                                j52 = x4.j5();
                            }
                            t(new z(t2.y, gv2, j52));
                            return;
                        case 10:
                            String gv6 = t2.f13120n3.gv("Session");
                            String gv7 = t2.f13120n3.gv("Transport");
                            if (gv6 != null && gv7 != null) {
                                tl(new c5(t2.y, s.tl(gv6), gv7));
                                return;
                            }
                            throw ne.v("Missing mandatory session or transport header", null);
                        default:
                            throw new IllegalStateException();
                    }
                } catch (IllegalArgumentException e2) {
                    e = e2;
                    gv.this.w2(new RtspMediaSource.zn(e));
                }
            } catch (ne e3) {
                e = e3;
                gv.this.w2(new RtspMediaSource.zn(e));
            }
        }

        public final void i9(co coVar) {
            if (gv.this.f4615n != null) {
                return;
            }
            if (gv.i3(coVar.f13047n3)) {
                gv.this.f4616p.zn(gv.this.f4607co, gv.this.f4612f3);
            } else {
                gv.this.y.n3("DESCRIBE not supported.", null);
            }
        }

        @Override // com.google.android.exoplayer2.source.rtsp.fb.gv
        public /* synthetic */ void n3(List list, Exception exc) {
            w.n3(this, list, exc);
        }

        public final void t(z zVar) {
            boolean z2 = true;
            if (gv.this.f4609d0 != 1) {
                z2 = false;
            }
            v5.y.fb(z2);
            gv.this.f4609d0 = 2;
            if (gv.this.f4615n == null) {
                gv gvVar = gv.this;
                gvVar.f4615n = new n3(30000L);
                gv.this.f4615n.y();
            }
            gv.this.f4622x = -9223372036854775807L;
            gv.this.f4620v.y(j5.xb(zVar.f13143n3.y), zVar.f13144zn);
        }

        public final void tl(c5 c5Var) {
            boolean z2;
            if (gv.this.f4609d0 != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.fb(z2);
            gv.this.f4609d0 = 1;
            gv.this.f4612f3 = c5Var.f4590n3.y;
            gv.this.vp();
        }

        /* renamed from: v */
        public final void s(List<String> list) {
            gv.this.ro(list);
            if (s.v(list)) {
                fb(list);
            } else {
                a(list);
            }
        }

        @Override // com.google.android.exoplayer2.source.rtsp.fb.gv
        public /* synthetic */ void y(Exception exc) {
            w.y(this, exc);
        }

        @Override // com.google.android.exoplayer2.source.rtsp.fb.gv
        public void zn(final List<String> list) {
            this.y.post(new Runnable() { // from class: r4.i9
                @Override // java.lang.Runnable
                public final void run() {
                    gv.zn.this.s(list);
                }
            });
        }
    }

    public gv(a aVar, v vVar, String str, Uri uri, SocketFactory socketFactory, boolean z2) {
        this.y = aVar;
        this.f4620v = vVar;
        this.f4613fb = str;
        this.f4618s = socketFactory;
        this.f4611f = z2;
        this.f4607co = s.w(uri);
        this.f4617r = s.wz(uri);
    }

    public static boolean i3(List<Integer> list) {
        if (!list.isEmpty() && !list.contains(2)) {
            return false;
        }
        return true;
    }

    public static x4<xc> l(n nVar, Uri uri) {
        x4.y yVar = new x4.y();
        for (int i = 0; i < nVar.f13077n3.size(); i++) {
            r4.y yVar2 = nVar.f13077n3.get(i);
            if (r4.s.zn(yVar2)) {
                yVar.y(new xc(yVar2, uri));
            }
        }
        return yVar.s();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        n3 n3Var = this.f4615n;
        if (n3Var != null) {
            n3Var.close();
            this.f4615n = null;
            this.f4616p.f(this.f4607co, (String) v5.y.v(this.f4612f3));
        }
        this.f4623z.close();
    }

    public int cs() {
        return this.f4609d0;
    }

    public void i2(long j2) {
        if (this.f4609d0 == 2 && !this.f4610ej) {
            this.f4616p.a(this.f4607co, (String) v5.y.v(this.f4612f3));
        }
        this.f4622x = j2;
    }

    public void ix(int i, fb.n3 n3Var) {
        this.f4623z.mt(i, n3Var);
    }

    public void j3() throws IOException {
        try {
            this.f4623z.p(x5(this.f4607co));
            this.f4616p.v(this.f4607co, this.f4612f3);
        } catch (IOException e2) {
            j5.wz(this.f4623z);
            throw e2;
        }
    }

    public void ne(long j2) {
        this.f4616p.fb(this.f4607co, j2, (String) v5.y.v(this.f4612f3));
    }

    public final void ro(List<String> list) {
        if (this.f4611f) {
            v5.r.n3("RtspClient", w0.s.fb("\n").gv(list));
        }
    }

    public void vn(List<a.gv> list) {
        this.f4619t.addAll(list);
        vp();
    }

    public final void vp() {
        a.gv pollFirst = this.f4619t.pollFirst();
        if (pollFirst == null) {
            this.f4620v.gv();
        } else {
            this.f4616p.i9(pollFirst.zn(), pollFirst.gv(), this.f4612f3);
        }
    }

    public final void w2(Throwable th) {
        RtspMediaSource.zn znVar;
        if (th instanceof RtspMediaSource.zn) {
            znVar = (RtspMediaSource.zn) th;
        } else {
            znVar = new RtspMediaSource.zn(th);
        }
        if (this.f4614fh) {
            this.f4620v.zn(znVar);
        } else {
            this.y.n3(w0.co.gv(th.getMessage()), th);
        }
    }

    public final Socket x5(Uri uri) throws IOException {
        boolean z2;
        int i;
        if (uri.getHost() != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        if (uri.getPort() > 0) {
            i = uri.getPort();
        } else {
            i = 554;
        }
        return this.f4618s.createSocket((String) v5.y.v(uri.getHost()), i);
    }

    public void yk() {
        try {
            close();
            fb fbVar = new fb(new zn());
            this.f4623z = fbVar;
            fbVar.p(x5(this.f4607co));
            this.f4612f3 = null;
            this.f4608d = false;
            this.f4606c = null;
        } catch (IOException e2) {
            this.f4620v.zn(new RtspMediaSource.zn(e2));
        }
    }
}
