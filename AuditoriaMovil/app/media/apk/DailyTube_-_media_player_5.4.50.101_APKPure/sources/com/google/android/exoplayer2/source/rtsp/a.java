package com.google.android.exoplayer2.source.rtsp;

import af.d0;
import af.en;
import af.f7;
import af.lc;
import af.rs;
import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.rtsp.a;
import com.google.android.exoplayer2.source.rtsp.fb;
import com.google.android.exoplayer2.source.rtsp.gv;
import com.google.android.exoplayer2.source.rtsp.n3;
import com.google.android.exoplayer2.source.rtsp.y;
import e4.fh;
import e4.wz;
import java.io.IOException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import kx.ta;
import m1.g;
import m1.m;
import m1.vc;
import r4.f3;
import r4.i4;
import r4.xc;
import v5.j5;
import z0.x4;
import zo.co;
/* loaded from: classes.dex */
public final class a implements d0 {

    /* renamed from: b  reason: collision with root package name */
    public boolean f4560b;

    /* renamed from: c  reason: collision with root package name */
    public long f4561c;

    /* renamed from: co  reason: collision with root package name */
    public d0.y f4562co;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4563d;

    /* renamed from: d0  reason: collision with root package name */
    public long f4564d0;

    /* renamed from: ej  reason: collision with root package name */
    public boolean f4565ej;

    /* renamed from: f  reason: collision with root package name */
    public final List<v> f4566f;
    @Nullable

    /* renamed from: f3  reason: collision with root package name */
    public RtspMediaSource.zn f4567f3;

    /* renamed from: fb  reason: collision with root package name */
    public final n3 f4568fb;

    /* renamed from: fh  reason: collision with root package name */
    public boolean f4569fh;

    /* renamed from: j5  reason: collision with root package name */
    public int f4570j5;

    /* renamed from: n  reason: collision with root package name */
    public long f4571n;

    /* renamed from: p  reason: collision with root package name */
    public final y.InterfaceC0052y f4572p;

    /* renamed from: qn  reason: collision with root package name */
    public boolean f4573qn;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    public IOException f4574r;

    /* renamed from: s  reason: collision with root package name */
    public final com.google.android.exoplayer2.source.rtsp.gv f4575s;

    /* renamed from: t  reason: collision with root package name */
    public final List<gv> f4576t;

    /* renamed from: v  reason: collision with root package name */
    public final Handler f4577v = j5.i4();

    /* renamed from: w  reason: collision with root package name */
    public final zn f4578w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f4579x;
    public final kx.n3 y;

    /* renamed from: z  reason: collision with root package name */
    public x4<rs> f4580z;

    /* renamed from: com.google.android.exoplayer2.source.rtsp.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0049a implements en {
        public final int y;

        public C0049a(int i) {
            this.y = i;
        }

        @Override // af.en
        public int a(g gVar, a9.fb fbVar, int i) {
            return a.this.ut(this.y, gVar, fbVar, i);
        }

        @Override // af.en
        public boolean isReady() {
            return a.this.qn(this.y);
        }

        @Override // af.en
        public void n3() throws RtspMediaSource.zn {
            if (a.this.f4567f3 == null) {
                return;
            }
            throw a.this.f4567f3;
        }

        @Override // af.en
        public int t(long j2) {
            return a.this.en(this.y, j2);
        }
    }

    /* loaded from: classes.dex */
    public final class gv {

        /* renamed from: n3  reason: collision with root package name */
        public final com.google.android.exoplayer2.source.rtsp.n3 f4583n3;
        public final xc y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public String f4584zn;

        public gv(xc xcVar, int i, y.InterfaceC0052y interfaceC0052y) {
            this.y = xcVar;
            this.f4583n3 = new com.google.android.exoplayer2.source.rtsp.n3(i, xcVar, new n3.y() { // from class: r4.wz
                @Override // com.google.android.exoplayer2.source.rtsp.n3.y
                public final void y(String str, com.google.android.exoplayer2.source.rtsp.y yVar) {
                    a.gv.this.a(str, yVar);
                }
            }, a.this.f4568fb, interfaceC0052y);
        }

        public final /* synthetic */ void a(String str, com.google.android.exoplayer2.source.rtsp.y yVar) {
            this.f4584zn = str;
            fb.n3 tl2 = yVar.tl();
            if (tl2 != null) {
                a.this.f4575s.ix(yVar.gv(), tl2);
                a.this.f4573qn = true;
            }
            a.this.oz();
        }

        public String gv() {
            v5.y.c5(this.f4584zn);
            return this.f4584zn;
        }

        public boolean v() {
            if (this.f4584zn != null) {
                return true;
            }
            return false;
        }

        public Uri zn() {
            return this.f4583n3.f4639n3.f13122n3;
        }
    }

    /* loaded from: classes.dex */
    public final class v {

        /* renamed from: gv  reason: collision with root package name */
        public boolean f4586gv;

        /* renamed from: n3  reason: collision with root package name */
        public final ta f4587n3;

        /* renamed from: v  reason: collision with root package name */
        public boolean f4588v;
        public final gv y;

        /* renamed from: zn  reason: collision with root package name */
        public final f7 f4589zn;

        public v(xc xcVar, int i, y.InterfaceC0052y interfaceC0052y) {
            this.y = new gv(xcVar, i, interfaceC0052y);
            this.f4587n3 = new ta("ExoPlayer:RtspMediaPeriod:RtspLoaderWrapper " + i);
            f7 t2 = f7.t(a.this.y);
            this.f4589zn = t2;
            t2.xg(a.this.f4568fb);
        }

        public int a(g gVar, a9.fb fbVar, int i) {
            return this.f4589zn.o(gVar, fbVar, i, this.f4586gv);
        }

        public int c5(long j2) {
            int ta2 = this.f4589zn.ta(j2, this.f4586gv);
            this.f4589zn.dm(ta2);
            return ta2;
        }

        public void fb() {
            if (this.f4588v) {
                return;
            }
            this.f4587n3.t();
            this.f4589zn.j();
            this.f4588v = true;
        }

        public long gv() {
            return this.f4589zn.c();
        }

        public void i9() {
            this.f4587n3.wz(this.y.f4583n3, a.this.f4568fb, 0);
        }

        public void s(long j2) {
            if (!this.f4586gv) {
                this.y.f4583n3.gv();
                this.f4589zn.ut();
                this.f4589zn.u(j2);
            }
        }

        public boolean v() {
            return this.f4589zn.x(this.f4586gv);
        }

        public void zn() {
            if (!this.f4586gv) {
                this.y.f4583n3.n3();
                this.f4586gv = true;
                a.this.u();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        void n3(i4 i4Var);

        void y();
    }

    public a(kx.n3 n3Var, y.InterfaceC0052y interfaceC0052y, Uri uri, zn znVar, String str, SocketFactory socketFactory, boolean z2) {
        this.y = n3Var;
        this.f4572p = interfaceC0052y;
        this.f4578w = znVar;
        n3 n3Var2 = new n3();
        this.f4568fb = n3Var2;
        this.f4575s = new com.google.android.exoplayer2.source.rtsp.gv(n3Var2, n3Var2, str, uri, socketFactory, z2);
        this.f4566f = new ArrayList();
        this.f4576t = new ArrayList();
        this.f4561c = -9223372036854775807L;
        this.f4571n = -9223372036854775807L;
        this.f4564d0 = -9223372036854775807L;
    }

    private boolean f7(long j2) {
        for (int i = 0; i < this.f4566f.size(); i++) {
            if (!this.f4566f.get(i).f4589zn.en(j2, false)) {
                return false;
            }
        }
        return true;
    }

    public static x4<rs> hw(x4<v> x4Var) {
        x4.y yVar = new x4.y();
        for (int i = 0; i < x4Var.size(); i++) {
            yVar.y(new rs(Integer.toString(i), (m) v5.y.v(x4Var.get(i).f4589zn.d())));
        }
        return yVar.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (!this.f4565ej && !this.f4579x) {
            for (int i = 0; i < this.f4566f.size(); i++) {
                if (this.f4566f.get(i).f4589zn.d() == null) {
                    return;
                }
            }
            this.f4579x = true;
            this.f4580z = hw(x4.d(this.f4566f));
            ((d0.y) v5.y.v(this.f4562co)).n3(this);
        }
    }

    private boolean jz() {
        return this.f4563d;
    }

    public static /* synthetic */ int n3(a aVar) {
        int i = aVar.f4570j5;
        aVar.f4570j5 = i + 1;
        return i;
    }

    @Override // af.d0
    public long c5(long j2) {
        if (fb() == 0 && !this.f4573qn) {
            this.f4564d0 = j2;
            return j2;
        }
        mt(j2, false);
        this.f4571n = j2;
        if (o()) {
            int cs2 = this.f4575s.cs();
            if (cs2 != 1) {
                if (cs2 == 2) {
                    this.f4561c = j2;
                    this.f4575s.i2(j2);
                    return j2;
                }
                throw new IllegalStateException();
            }
            return j2;
        } else if (f7(j2)) {
            return j2;
        } else {
            this.f4561c = j2;
            this.f4575s.i2(j2);
            for (int i = 0; i < this.f4566f.size(); i++) {
                this.f4566f.get(i).s(j2);
            }
            return j2;
        }
    }

    @Override // af.d0
    public void co(d0.y yVar, long j2) {
        this.f4562co = yVar;
        try {
            this.f4575s.j3();
        } catch (IOException e2) {
            this.f4574r = e2;
            j5.wz(this.f4575s);
        }
    }

    public int en(int i, long j2) {
        if (jz()) {
            return -3;
        }
        return this.f4566f.get(i).c5(j2);
    }

    @Override // af.d0
    public long f(co[] coVarArr, boolean[] zArr, en[] enVarArr, boolean[] zArr2, long j2) {
        for (int i = 0; i < coVarArr.length; i++) {
            if (enVarArr[i] != null && (coVarArr[i] == null || !zArr[i])) {
                enVarArr[i] = null;
            }
        }
        this.f4576t.clear();
        for (int i5 = 0; i5 < coVarArr.length; i5++) {
            co coVar = coVarArr[i5];
            if (coVar != null) {
                rs xc2 = coVar.xc();
                int indexOf = ((x4) v5.y.v(this.f4580z)).indexOf(xc2);
                this.f4576t.add(((v) v5.y.v(this.f4566f.get(indexOf))).y);
                if (this.f4580z.contains(xc2) && enVarArr[i5] == null) {
                    enVarArr[i5] = new C0049a(indexOf);
                    zArr2[i5] = true;
                }
            }
        }
        for (int i6 = 0; i6 < this.f4566f.size(); i6++) {
            v vVar = this.f4566f.get(i6);
            if (!this.f4576t.contains(vVar.y)) {
                vVar.zn();
            }
        }
        this.f4560b = true;
        if (j2 != 0) {
            this.f4571n = j2;
            this.f4561c = j2;
            this.f4564d0 = j2;
        }
        oz();
        return j2;
    }

    @Override // af.d0, af.jz
    public long fb() {
        if (this.f4569fh || this.f4566f.isEmpty()) {
            return Long.MIN_VALUE;
        }
        long j2 = this.f4571n;
        if (j2 != -9223372036854775807L) {
            return j2;
        }
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        for (int i = 0; i < this.f4566f.size(); i++) {
            v vVar = this.f4566f.get(i);
            if (!vVar.f4586gv) {
                j4 = Math.min(j4, vVar.gv());
                z2 = false;
            }
        }
        if (z2 || j4 == Long.MIN_VALUE) {
            return 0L;
        }
        return j4;
    }

    @Override // af.d0
    public long i9() {
        if (this.f4563d) {
            this.f4563d = false;
            return 0L;
        }
        return -9223372036854775807L;
    }

    @Nullable
    public final com.google.android.exoplayer2.source.rtsp.n3 j5(Uri uri) {
        for (int i = 0; i < this.f4566f.size(); i++) {
            if (!this.f4566f.get(i).f4586gv) {
                gv gvVar = this.f4566f.get(i).y;
                if (gvVar.zn().equals(uri)) {
                    return gvVar.f4583n3;
                }
            }
        }
        return null;
    }

    public final void k() {
        this.f4573qn = true;
        this.f4575s.yk();
        y.InterfaceC0052y n32 = this.f4572p.n3();
        if (n32 == null) {
            this.f4567f3 = new RtspMediaSource.zn("No fallback data channel factory for TCP retry");
            return;
        }
        ArrayList arrayList = new ArrayList(this.f4566f.size());
        ArrayList arrayList2 = new ArrayList(this.f4576t.size());
        for (int i = 0; i < this.f4566f.size(); i++) {
            v vVar = this.f4566f.get(i);
            if (!vVar.f4586gv) {
                v vVar2 = new v(vVar.y.y, i, n32);
                arrayList.add(vVar2);
                vVar2.i9();
                if (this.f4576t.contains(vVar.y)) {
                    arrayList2.add(vVar2.y);
                }
            } else {
                arrayList.add(vVar);
            }
        }
        x4 d2 = x4.d(this.f4566f);
        this.f4566f.clear();
        this.f4566f.addAll(arrayList);
        this.f4576t.clear();
        this.f4576t.addAll(arrayList2);
        for (int i5 = 0; i5 < d2.size(); i5++) {
            ((v) d2.get(i5)).zn();
        }
    }

    @Override // af.d0
    public void mt(long j2, boolean z2) {
        if (o()) {
            return;
        }
        for (int i = 0; i < this.f4566f.size(); i++) {
            v vVar = this.f4566f.get(i);
            if (!vVar.f4586gv) {
                vVar.f4589zn.p(j2, z2, true);
            }
        }
    }

    public final boolean o() {
        if (this.f4561c != -9223372036854775807L) {
            return true;
        }
        return false;
    }

    public final void oz() {
        boolean z2 = true;
        for (int i = 0; i < this.f4576t.size(); i++) {
            z2 &= this.f4576t.get(i).v();
        }
        if (z2 && this.f4560b) {
            this.f4575s.vn(this.f4576t);
        }
    }

    @Override // af.d0
    public lc p() {
        v5.y.fb(this.f4579x);
        return new lc((rs[]) ((x4) v5.y.v(this.f4580z)).toArray(new rs[0]));
    }

    public void q9() {
        for (int i = 0; i < this.f4566f.size(); i++) {
            this.f4566f.get(i).fb();
        }
        j5.wz(this.f4575s);
        this.f4565ej = true;
    }

    public boolean qn(int i) {
        if (!jz() && this.f4566f.get(i).v()) {
            return true;
        }
        return false;
    }

    @Override // af.d0, af.jz
    public void s(long j2) {
    }

    public final void u() {
        this.f4569fh = true;
        for (int i = 0; i < this.f4566f.size(); i++) {
            this.f4569fh &= this.f4566f.get(i).f4586gv;
        }
    }

    public int ut(int i, g gVar, a9.fb fbVar, int i5) {
        if (jz()) {
            return -3;
        }
        return this.f4566f.get(i).a(gVar, fbVar, i5);
    }

    @Override // af.d0, af.jz
    public boolean v(long j2) {
        return y();
    }

    @Override // af.d0
    public void wz() throws IOException {
        IOException iOException = this.f4574r;
        if (iOException == null) {
            return;
        }
        throw iOException;
    }

    @Override // af.d0, af.jz
    public boolean y() {
        return !this.f4569fh;
    }

    @Override // af.d0, af.jz
    public long zn() {
        return fb();
    }

    /* loaded from: classes.dex */
    public final class n3 implements wz, ta.n3<com.google.android.exoplayer2.source.rtsp.n3>, f7.gv, gv.a, gv.v {
        public n3() {
        }

        @Override // e4.wz
        public e4.ta a(int i, int i5) {
            return ((v) v5.y.v((v) a.this.f4566f.get(i))).f4589zn;
        }

        @Override // kx.ta.n3
        /* renamed from: f */
        public void ud(com.google.android.exoplayer2.source.rtsp.n3 n3Var, long j2, long j4, boolean z2) {
        }

        @Override // com.google.android.exoplayer2.source.rtsp.gv.v
        public void gv() {
            long j2;
            if (a.this.f4561c != -9223372036854775807L) {
                j2 = j5.gf(a.this.f4561c);
            } else if (a.this.f4564d0 != -9223372036854775807L) {
                j2 = j5.gf(a.this.f4564d0);
            } else {
                j2 = 0;
            }
            a.this.f4575s.ne(j2);
        }

        @Override // com.google.android.exoplayer2.source.rtsp.gv.a
        public void n3(String str, @Nullable Throwable th) {
            IOException iOException;
            a aVar = a.this;
            if (th == null) {
                iOException = new IOException(str);
            } else {
                iOException = new IOException(str, th);
            }
            aVar.f4574r = iOException;
        }

        @Override // kx.ta.n3
        /* renamed from: tl */
        public void ta(com.google.android.exoplayer2.source.rtsp.n3 n3Var, long j2, long j4) {
            if (a.this.fb() == 0) {
                if (!a.this.f4573qn) {
                    a.this.k();
                    return;
                }
                return;
            }
            for (int i = 0; i < a.this.f4566f.size(); i++) {
                v vVar = (v) a.this.f4566f.get(i);
                if (vVar.y.f4583n3 == n3Var) {
                    vVar.zn();
                    return;
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.rtsp.gv.a
        public void v(i4 i4Var, x4<xc> x4Var) {
            for (int i = 0; i < x4Var.size(); i++) {
                a aVar = a.this;
                v vVar = new v(x4Var.get(i), i, aVar.f4572p);
                a.this.f4566f.add(vVar);
                vVar.i9();
            }
            a.this.f4578w.n3(i4Var);
        }

        @Override // af.f7.gv
        public void w(m mVar) {
            Handler handler = a.this.f4577v;
            final a aVar = a.this;
            handler.post(new Runnable() { // from class: r4.tl
                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.exoplayer2.source.rtsp.a.this.j();
                }
            });
        }

        @Override // kx.ta.n3
        /* renamed from: wz */
        public ta.zn oz(com.google.android.exoplayer2.source.rtsp.n3 n3Var, long j2, long j4, IOException iOException, int i) {
            if (!a.this.f4579x) {
                a.this.f4574r = iOException;
            } else if (iOException.getCause() instanceof BindException) {
                if (a.n3(a.this) < 3) {
                    return ta.f10110gv;
                }
            } else {
                a.this.f4567f3 = new RtspMediaSource.zn(n3Var.f4639n3.f13122n3.toString(), iOException);
            }
            return ta.f10108a;
        }

        @Override // e4.wz
        public void xc() {
            Handler handler = a.this.f4577v;
            final a aVar = a.this;
            handler.post(new Runnable() { // from class: r4.t
                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.exoplayer2.source.rtsp.a.this.j();
                }
            });
        }

        @Override // com.google.android.exoplayer2.source.rtsp.gv.v
        public void y(long j2, x4<f3> x4Var) {
            ArrayList arrayList = new ArrayList(x4Var.size());
            for (int i = 0; i < x4Var.size(); i++) {
                arrayList.add((String) v5.y.v(x4Var.get(i).f13050zn.getPath()));
            }
            for (int i5 = 0; i5 < a.this.f4576t.size(); i5++) {
                if (!arrayList.contains(((gv) a.this.f4576t.get(i5)).zn().getPath())) {
                    a.this.f4578w.y();
                    if (a.this.o()) {
                        a.this.f4563d = true;
                        a.this.f4561c = -9223372036854775807L;
                        a.this.f4571n = -9223372036854775807L;
                        a.this.f4564d0 = -9223372036854775807L;
                    }
                }
            }
            for (int i6 = 0; i6 < x4Var.size(); i6++) {
                f3 f3Var = x4Var.get(i6);
                com.google.android.exoplayer2.source.rtsp.n3 j52 = a.this.j5(f3Var.f13050zn);
                if (j52 != null) {
                    j52.fb(f3Var.y);
                    j52.a(f3Var.f13049n3);
                    if (a.this.o() && a.this.f4561c == a.this.f4571n) {
                        j52.v(j2, f3Var.y);
                    }
                }
            }
            if (a.this.o()) {
                if (a.this.f4561c == a.this.f4571n) {
                    a.this.f4561c = -9223372036854775807L;
                    a.this.f4571n = -9223372036854775807L;
                    return;
                }
                a.this.f4561c = -9223372036854775807L;
                a aVar = a.this;
                aVar.c5(aVar.f4571n);
            } else if (a.this.f4564d0 != -9223372036854775807L && a.this.f4573qn) {
                a aVar2 = a.this;
                aVar2.c5(aVar2.f4564d0);
                a.this.f4564d0 = -9223372036854775807L;
            }
        }

        @Override // com.google.android.exoplayer2.source.rtsp.gv.v
        public void zn(RtspMediaSource.zn znVar) {
            if (!(znVar instanceof RtspMediaSource.gv) || a.this.f4573qn) {
                a.this.f4567f3 = znVar;
            } else {
                a.this.k();
            }
        }

        @Override // e4.wz
        public void t(fh fhVar) {
        }
    }

    @Override // af.d0
    public long gv(long j2, vc vcVar) {
        return j2;
    }
}
