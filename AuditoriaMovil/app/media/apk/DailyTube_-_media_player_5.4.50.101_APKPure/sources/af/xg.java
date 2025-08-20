package af;

import af.b;
import af.d0;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import kx.mg;
import kx.ta;
import kx.tl;
import m1.g;
import m1.m;
import m1.vc;
/* loaded from: classes.dex */
public final class xg implements d0, ta.n3<zn> {

    /* renamed from: c  reason: collision with root package name */
    public int f412c;

    /* renamed from: f  reason: collision with root package name */
    public final b.y f414f;

    /* renamed from: f3  reason: collision with root package name */
    public boolean f415f3;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public final kx.o f416fb;

    /* renamed from: n  reason: collision with root package name */
    public byte[] f417n;

    /* renamed from: p  reason: collision with root package name */
    public final long f418p;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f419r;

    /* renamed from: s  reason: collision with root package name */
    public final kx.mg f420s;

    /* renamed from: t  reason: collision with root package name */
    public final lc f421t;

    /* renamed from: v  reason: collision with root package name */
    public final tl.y f422v;
    public final kx.p y;

    /* renamed from: z  reason: collision with root package name */
    public final m f424z;

    /* renamed from: w  reason: collision with root package name */
    public final ArrayList<n3> f423w = new ArrayList<>();

    /* renamed from: co  reason: collision with root package name */
    public final kx.ta f413co = new kx.ta("SingleSampleMediaPeriod");

    /* loaded from: classes.dex */
    public final class n3 implements en {

        /* renamed from: v  reason: collision with root package name */
        public boolean f426v;
        public int y;

        public n3() {
        }

        @Override // af.en
        public int a(g gVar, a9.fb fbVar, int i) {
            y();
            xg xgVar = xg.this;
            boolean z2 = xgVar.f415f3;
            if (z2 && xgVar.f417n == null) {
                this.y = 2;
            }
            int i5 = this.y;
            if (i5 == 2) {
                fbVar.v(4);
                return -4;
            } else if ((i & 2) == 0 && i5 != 0) {
                if (!z2) {
                    return -3;
                }
                v5.y.v(xgVar.f417n);
                fbVar.v(1);
                fbVar.f55f = 0L;
                if ((i & 4) == 0) {
                    fbVar.mt(xg.this.f412c);
                    ByteBuffer byteBuffer = fbVar.f56fb;
                    xg xgVar2 = xg.this;
                    byteBuffer.put(xgVar2.f417n, 0, xgVar2.f412c);
                }
                if ((i & 1) == 0) {
                    this.y = 2;
                }
                return -4;
            } else {
                gVar.f10757n3 = xgVar.f424z;
                this.y = 1;
                return -5;
            }
        }

        @Override // af.en
        public boolean isReady() {
            return xg.this.f415f3;
        }

        @Override // af.en
        public void n3() throws IOException {
            xg xgVar = xg.this;
            if (!xgVar.f419r) {
                xgVar.f413co.n3();
            }
        }

        @Override // af.en
        public int t(long j2) {
            y();
            if (j2 > 0 && this.y != 2) {
                this.y = 2;
                return 1;
            }
            return 0;
        }

        public final void y() {
            if (!this.f426v) {
                xg.this.f414f.c5(v5.n.f(xg.this.f424z.f10948f3), xg.this.f424z, 0, null, 0L);
                this.f426v = true;
            }
        }

        public void zn() {
            if (this.y == 2) {
                this.y = 1;
            }
        }
    }

    public xg(kx.p pVar, tl.y yVar, @Nullable kx.o oVar, m mVar, long j2, kx.mg mgVar, b.y yVar2, boolean z2) {
        this.y = pVar;
        this.f422v = yVar;
        this.f416fb = oVar;
        this.f424z = mVar;
        this.f418p = j2;
        this.f420s = mgVar;
        this.f414f = yVar2;
        this.f419r = z2;
        this.f421t = new lc(new rs(mVar));
    }

    @Override // kx.ta.n3
    /* renamed from: a */
    public void ud(zn znVar, long j2, long j4, boolean z2) {
        kx.j5 j5Var = znVar.f429zn;
        i4 i4Var = new i4(znVar.y, znVar.f428n3, j5Var.c5(), j5Var.mt(), j2, j4, j5Var.a());
        this.f420s.zn(znVar.y);
        this.f414f.mt(i4Var, 1, -1, null, 0, null, 0L, this.f418p);
    }

    @Override // af.d0
    public long c5(long j2) {
        for (int i = 0; i < this.f423w.size(); i++) {
            this.f423w.get(i).zn();
        }
        return j2;
    }

    @Override // af.d0
    public void co(d0.y yVar, long j2) {
        yVar.n3(this);
    }

    @Override // af.d0
    public long f(zo.co[] coVarArr, boolean[] zArr, en[] enVarArr, boolean[] zArr2, long j2) {
        for (int i = 0; i < coVarArr.length; i++) {
            en enVar = enVarArr[i];
            if (enVar != null && (coVarArr[i] == null || !zArr[i])) {
                this.f423w.remove(enVar);
                enVarArr[i] = null;
            }
            if (enVarArr[i] == null && coVarArr[i] != null) {
                n3 n3Var = new n3();
                this.f423w.add(n3Var);
                enVarArr[i] = n3Var;
                zArr2[i] = true;
            }
        }
        return j2;
    }

    @Override // af.d0, af.jz
    public long fb() {
        if (this.f415f3) {
            return Long.MIN_VALUE;
        }
        return 0L;
    }

    @Override // af.d0
    public long i9() {
        return -9223372036854775807L;
    }

    @Override // af.d0
    public lc p() {
        return this.f421t;
    }

    @Override // kx.ta.n3
    /* renamed from: t */
    public void ta(zn znVar, long j2, long j4) {
        this.f412c = (int) znVar.f429zn.a();
        this.f417n = (byte[]) v5.y.v(znVar.f427gv);
        this.f415f3 = true;
        kx.j5 j5Var = znVar.f429zn;
        i4 i4Var = new i4(znVar.y, znVar.f428n3, j5Var.c5(), j5Var.mt(), j2, j4, this.f412c);
        this.f420s.zn(znVar.y);
        this.f414f.r(i4Var, 1, -1, this.f424z, 0, null, 0L, this.f418p);
    }

    @Override // kx.ta.n3
    /* renamed from: tl */
    public ta.zn oz(zn znVar, long j2, long j4, IOException iOException, int i) {
        boolean z2;
        ta.zn znVar2;
        kx.j5 j5Var = znVar.f429zn;
        i4 i4Var = new i4(znVar.y, znVar.f428n3, j5Var.c5(), j5Var.mt(), j2, j4, j5Var.a());
        long gv2 = this.f420s.gv(new mg.zn(i4Var, new c(1, -1, this.f424z, 0, null, 0L, v5.j5.gf(this.f418p)), iOException, i));
        int i5 = (gv2 > (-9223372036854775807L) ? 1 : (gv2 == (-9223372036854775807L) ? 0 : -1));
        if (i5 != 0 && i < this.f420s.y(1)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (this.f419r && z2) {
            v5.r.i9("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException);
            this.f415f3 = true;
            znVar2 = kx.ta.f10108a;
        } else if (i5 != 0) {
            znVar2 = kx.ta.s(false, gv2);
        } else {
            znVar2 = kx.ta.f10109fb;
        }
        ta.zn znVar3 = znVar2;
        boolean zn2 = znVar3.zn();
        this.f414f.i4(i4Var, 1, -1, this.f424z, 0, null, 0L, this.f418p, iOException, !zn2);
        if (!zn2) {
            this.f420s.zn(znVar.y);
        }
        return znVar3;
    }

    @Override // af.d0, af.jz
    public boolean v(long j2) {
        if (!this.f415f3 && !this.f413co.i9() && !this.f413co.c5()) {
            kx.tl y2 = this.f422v.y();
            kx.o oVar = this.f416fb;
            if (oVar != null) {
                y2.i9(oVar);
            }
            zn znVar = new zn(this.y, y2);
            this.f414f.d0(new i4(znVar.y, this.y, this.f413co.wz(znVar, this, this.f420s.y(1))), 1, -1, this.f424z, 0, null, 0L, this.f418p);
            return true;
        }
        return false;
    }

    public void xc() {
        this.f413co.t();
    }

    @Override // af.d0, af.jz
    public boolean y() {
        return this.f413co.i9();
    }

    @Override // af.d0, af.jz
    public long zn() {
        if (!this.f415f3 && !this.f413co.i9()) {
            return 0L;
        }
        return Long.MIN_VALUE;
    }

    /* loaded from: classes.dex */
    public static final class zn implements ta.v {
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public byte[] f427gv;

        /* renamed from: n3  reason: collision with root package name */
        public final kx.p f428n3;
        public final long y = i4.y();

        /* renamed from: zn  reason: collision with root package name */
        public final kx.j5 f429zn;

        public zn(kx.p pVar, kx.tl tlVar) {
            this.f428n3 = pVar;
            this.f429zn = new kx.j5(tlVar);
        }

        @Override // kx.ta.v
        public void load() throws IOException {
            this.f429zn.r();
            try {
                this.f429zn.y(this.f428n3);
                int i = 0;
                while (i != -1) {
                    int a2 = (int) this.f429zn.a();
                    byte[] bArr = this.f427gv;
                    if (bArr == null) {
                        this.f427gv = new byte[1024];
                    } else if (a2 == bArr.length) {
                        this.f427gv = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    kx.j5 j5Var = this.f429zn;
                    byte[] bArr2 = this.f427gv;
                    i = j5Var.read(bArr2, a2, bArr2.length - a2);
                }
                kx.w.y(this.f429zn);
            } catch (Throwable th) {
                kx.w.y(this.f429zn);
                throw th;
            }
        }

        @Override // kx.ta.v
        public void n3() {
        }
    }

    @Override // af.d0
    public void wz() {
    }

    @Override // af.d0, af.jz
    public void s(long j2) {
    }

    @Override // af.d0
    public long gv(long j2, vc vcVar) {
        return j2;
    }

    @Override // af.d0
    public void mt(long j2, boolean z2) {
    }
}
