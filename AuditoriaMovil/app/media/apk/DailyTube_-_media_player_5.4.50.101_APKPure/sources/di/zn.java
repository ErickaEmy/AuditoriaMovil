package di;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import di.n3;
import di.y;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kx.a8;
import kx.c;
import kx.f;
import kx.o;
import kx.qn;
import kx.tl;
import kx.ud;
import v5.j5;
import v5.ta;
/* loaded from: classes.dex */
public final class zn implements kx.tl {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f7315a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public Uri f7316c5;

    /* renamed from: co  reason: collision with root package name */
    public long f7317co;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public kx.p f7318f;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f7319fb;

    /* renamed from: gv  reason: collision with root package name */
    public final kx.tl f7320gv;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public kx.p f7321i9;

    /* renamed from: mt  reason: collision with root package name */
    public boolean f7322mt;

    /* renamed from: n3  reason: collision with root package name */
    public final kx.tl f7323n3;

    /* renamed from: p  reason: collision with root package name */
    public boolean f7324p;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f7325s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public kx.tl f7326t;

    /* renamed from: tl  reason: collision with root package name */
    public long f7327tl;

    /* renamed from: v  reason: collision with root package name */
    public final CacheKeyFactory f7328v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public c5 f7329w;

    /* renamed from: wz  reason: collision with root package name */
    public long f7330wz;

    /* renamed from: xc  reason: collision with root package name */
    public long f7331xc;
    public final di.y y;

    /* renamed from: z  reason: collision with root package name */
    public long f7332z;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public final kx.tl f7333zn;

    /* loaded from: classes.dex */
    public interface n3 {
    }

    /* renamed from: di.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0085zn implements tl.y {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public tl.y f7334a;

        /* renamed from: c5  reason: collision with root package name */
        public int f7335c5;
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public ta f7336fb;

        /* renamed from: s  reason: collision with root package name */
        public int f7339s;

        /* renamed from: v  reason: collision with root package name */
        public boolean f7340v;
        public di.y y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public f.y f7341zn;

        /* renamed from: n3  reason: collision with root package name */
        public tl.y f7338n3 = new c.n3();

        /* renamed from: gv  reason: collision with root package name */
        public CacheKeyFactory f7337gv = CacheKeyFactory.DEFAULT;

        public CacheKeyFactory a() {
            return this.f7337gv;
        }

        public C0085zn c5(int i) {
            this.f7335c5 = i;
            return this;
        }

        public C0085zn fb(di.y yVar) {
            this.y = yVar;
            return this;
        }

        public final zn gv(@Nullable kx.tl tlVar, int i, int i5) {
            kx.f fVar;
            di.y yVar = (di.y) v5.y.v(this.y);
            if (!this.f7340v && tlVar != null) {
                f.y yVar2 = this.f7341zn;
                if (yVar2 != null) {
                    fVar = yVar2.y();
                } else {
                    fVar = new n3.C0083n3().n3(yVar).y();
                }
            } else {
                fVar = null;
            }
            return new zn(yVar, tlVar, this.f7338n3.y(), fVar, this.f7337gv, i, this.f7336fb, i5, null);
        }

        public C0085zn i9(@Nullable tl.y yVar) {
            this.f7334a = yVar;
            return this;
        }

        @Override // kx.tl.y
        /* renamed from: n3 */
        public zn y() {
            kx.tl tlVar;
            tl.y yVar = this.f7334a;
            if (yVar != null) {
                tlVar = yVar.y();
            } else {
                tlVar = null;
            }
            return gv(tlVar, this.f7335c5, this.f7339s);
        }

        public C0085zn s(@Nullable f.y yVar) {
            boolean z2;
            this.f7341zn = yVar;
            if (yVar == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f7340v = z2;
            return this;
        }

        @Nullable
        public di.y v() {
            return this.y;
        }

        public zn zn() {
            kx.tl tlVar;
            tl.y yVar = this.f7334a;
            if (yVar != null) {
                tlVar = yVar.y();
            } else {
                tlVar = null;
            }
            return gv(tlVar, this.f7335c5 | 1, -1000);
        }
    }

    public static Uri r(di.y yVar, String str, Uri uri) {
        Uri n32 = tl.n3(yVar.zn(str));
        if (n32 != null) {
            return n32;
        }
        return uri;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kx.tl, di.c5, kx.p] */
    public final void a() throws IOException {
        kx.tl tlVar = this.f7326t;
        if (tlVar == null) {
            return;
        }
        try {
            tlVar.close();
        } finally {
            this.f7318f = null;
            this.f7326t = null;
            c5 c5Var = this.f7329w;
            if (c5Var != null) {
                this.y.n3(c5Var);
                this.f7329w = null;
            }
        }
    }

    public final boolean c() {
        if (this.f7326t == this.f7333zn) {
            return true;
        }
        return false;
    }

    public di.y c5() {
        return this.y;
    }

    @Override // kx.tl
    public void close() throws IOException {
        this.f7321i9 = null;
        this.f7316c5 = null;
        this.f7330wz = 0L;
        d0();
        try {
            a();
        } catch (Throwable th) {
            x4(th);
            throw th;
        }
    }

    public final boolean f3() {
        if (this.f7326t == this.f7323n3) {
            return true;
        }
        return false;
    }

    @Override // kx.tl
    public Map<String, List<String>> fb() {
        if (n()) {
            return this.f7320gv.fb();
        }
        return Collections.emptyMap();
    }

    public final boolean i4() {
        if (this.f7326t == this.f7320gv) {
            return true;
        }
        return false;
    }

    @Override // kx.tl
    public void i9(o oVar) {
        v5.y.v(oVar);
        this.f7323n3.i9(oVar);
        this.f7320gv.i9(oVar);
    }

    public final void mg(String str) throws IOException {
        this.f7331xc = 0L;
        if (c()) {
            xc xcVar = new xc();
            xc.fb(xcVar, this.f7330wz);
            this.y.s(str, xcVar);
        }
    }

    public CacheKeyFactory mt() {
        return this.f7328v;
    }

    public final boolean n() {
        return !f3();
    }

    @Override // kx.tl
    @Nullable
    public Uri n3() {
        return this.f7316c5;
    }

    @Override // kx.c5
    public int read(byte[] bArr, int i, int i5) throws IOException {
        if (i5 == 0) {
            return 0;
        }
        if (this.f7331xc == 0) {
            return -1;
        }
        kx.p pVar = (kx.p) v5.y.v(this.f7321i9);
        kx.p pVar2 = (kx.p) v5.y.v(this.f7318f);
        try {
            if (this.f7330wz >= this.f7332z) {
                rz(pVar, true);
            }
            int read = ((kx.tl) v5.y.v(this.f7326t)).read(bArr, i, i5);
            if (read != -1) {
                if (f3()) {
                    this.f7317co += read;
                }
                long j2 = read;
                this.f7330wz += j2;
                this.f7327tl += j2;
                long j4 = this.f7331xc;
                if (j4 != -1) {
                    this.f7331xc = j4 - j2;
                }
            } else {
                if (n()) {
                    long j6 = pVar2.f10075s;
                    if (j6 == -1 || this.f7327tl < j6) {
                        mg((String) j5.i9(pVar.f10069c5));
                    }
                }
                long j7 = this.f7331xc;
                if (j7 <= 0) {
                    if (j7 == -1) {
                    }
                }
                a();
                rz(pVar, false);
                return read(bArr, i, i5);
            }
            return read;
        } catch (Throwable th) {
            x4(th);
            throw th;
        }
    }

    public final void rz(kx.p pVar, boolean z2) throws IOException {
        c5 c52;
        long j2;
        kx.p y2;
        kx.tl tlVar;
        long j4;
        String str = (String) j5.i9(pVar.f10069c5);
        Uri uri = null;
        if (this.f7322mt) {
            c52 = null;
        } else if (this.f7315a) {
            try {
                c52 = this.y.c5(str, this.f7330wz, this.f7331xc);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            c52 = this.y.v(str, this.f7330wz, this.f7331xc);
        }
        if (c52 == null) {
            tlVar = this.f7320gv;
            y2 = pVar.y().s(this.f7330wz).fb(this.f7331xc).y();
        } else if (c52.f7252s) {
            Uri fromFile = Uri.fromFile((File) j5.i9(c52.f7250f));
            long j6 = c52.f7254v;
            long j7 = this.f7330wz - j6;
            long j8 = c52.f7251fb - j7;
            long j9 = this.f7331xc;
            if (j9 != -1) {
                j8 = Math.min(j8, j9);
            }
            y2 = pVar.y().c5(fromFile).f(j6).s(j7).fb(j8).y();
            tlVar = this.f7323n3;
        } else {
            if (c52.zn()) {
                j2 = this.f7331xc;
            } else {
                j2 = c52.f7251fb;
                long j10 = this.f7331xc;
                if (j10 != -1) {
                    j2 = Math.min(j2, j10);
                }
            }
            y2 = pVar.y().s(this.f7330wz).fb(j2).y();
            tlVar = this.f7333zn;
            if (tlVar == null) {
                tlVar = this.f7320gv;
                this.y.n3(c52);
                c52 = null;
            }
        }
        if (!this.f7322mt && tlVar == this.f7320gv) {
            j4 = this.f7330wz + 102400;
        } else {
            j4 = Long.MAX_VALUE;
        }
        this.f7332z = j4;
        if (z2) {
            v5.y.fb(i4());
            if (tlVar == this.f7320gv) {
                return;
            }
            try {
                a();
            } catch (Throwable th) {
                if (((c5) j5.i9(c52)).n3()) {
                    this.y.n3(c52);
                }
                throw th;
            }
        }
        if (c52 != null && c52.n3()) {
            this.f7329w = c52;
        }
        this.f7326t = tlVar;
        this.f7318f = y2;
        this.f7327tl = 0L;
        long y7 = tlVar.y(y2);
        xc xcVar = new xc();
        if (y2.f10075s == -1 && y7 != -1) {
            this.f7331xc = y7;
            xc.fb(xcVar, this.f7330wz + y7);
        }
        if (n()) {
            Uri n32 = tlVar.n3();
            this.f7316c5 = n32;
            if (!pVar.y.equals(n32)) {
                uri = this.f7316c5;
            }
            xc.s(xcVar, uri);
        }
        if (c()) {
            this.y.s(str, xcVar);
        }
    }

    public final int ta(kx.p pVar) {
        if (this.f7319fb && this.f7324p) {
            return 0;
        }
        if (this.f7325s && pVar.f10075s == -1) {
            return 1;
        }
        return -1;
    }

    public final void x4(Throwable th) {
        if (f3() || (th instanceof y.C0084y)) {
            this.f7324p = true;
        }
    }

    @Override // kx.tl
    public long y(kx.p pVar) throws IOException {
        boolean z2;
        try {
            String buildCacheKey = this.f7328v.buildCacheKey(pVar);
            kx.p y2 = pVar.y().a(buildCacheKey).y();
            this.f7321i9 = y2;
            this.f7316c5 = r(this.y, buildCacheKey, y2.y);
            this.f7330wz = pVar.f10071fb;
            int ta2 = ta(pVar);
            if (ta2 != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f7322mt = z2;
            if (z2) {
                fh(ta2);
            }
            if (this.f7322mt) {
                this.f7331xc = -1L;
            } else {
                long y7 = tl.y(this.y.zn(buildCacheKey));
                this.f7331xc = y7;
                if (y7 != -1) {
                    long j2 = y7 - pVar.f10071fb;
                    this.f7331xc = j2;
                    if (j2 < 0) {
                        throw new kx.wz(2008);
                    }
                }
            }
            long j4 = pVar.f10075s;
            if (j4 != -1) {
                long j6 = this.f7331xc;
                if (j6 != -1) {
                    j4 = Math.min(j6, j4);
                }
                this.f7331xc = j4;
            }
            long j7 = this.f7331xc;
            if (j7 > 0 || j7 == -1) {
                rz(y2, false);
            }
            long j8 = pVar.f10075s;
            if (j8 == -1) {
                return this.f7331xc;
            }
            return j8;
        } catch (Throwable th) {
            x4(th);
            throw th;
        }
    }

    public zn(di.y yVar, @Nullable kx.tl tlVar, kx.tl tlVar2, @Nullable kx.f fVar, @Nullable CacheKeyFactory cacheKeyFactory, int i, @Nullable ta taVar, int i5, @Nullable n3 n3Var) {
        this.y = yVar;
        this.f7323n3 = tlVar2;
        this.f7328v = cacheKeyFactory == null ? CacheKeyFactory.DEFAULT : cacheKeyFactory;
        this.f7315a = (i & 1) != 0;
        this.f7319fb = (i & 2) != 0;
        this.f7325s = (i & 4) != 0;
        if (tlVar != null) {
            tlVar = taVar != null ? new a8(tlVar, taVar, i5) : tlVar;
            this.f7320gv = tlVar;
            this.f7333zn = fVar != null ? new qn(tlVar, fVar) : null;
            return;
        }
        this.f7320gv = ud.y;
        this.f7333zn = null;
    }

    public final void d0() {
    }

    public final void fh(int i) {
    }
}
