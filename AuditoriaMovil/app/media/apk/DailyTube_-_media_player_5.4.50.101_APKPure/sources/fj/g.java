package fj;

import af.mg;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import fj.g3;
import fj.m;
import fj.zn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import m1.br;
import m1.gf;
import m1.hy;
import m1.o0;
import m1.qk;
import m1.uo;
import m1.v1;
/* loaded from: classes.dex */
public final class g implements zn, g3.y {

    /* renamed from: a  reason: collision with root package name */
    public final hy.n3 f7943a;

    /* renamed from: c5  reason: collision with root package name */
    public long f7944c5;

    /* renamed from: f  reason: collision with root package name */
    public int f7945f;

    /* renamed from: fb  reason: collision with root package name */
    public m f7946fb;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public final y f7947gv;

    /* renamed from: i9  reason: collision with root package name */
    public int f7948i9;

    /* renamed from: n3  reason: collision with root package name */
    public final Map<String, n3> f7949n3;

    /* renamed from: p  reason: collision with root package name */
    public wn.d0 f7950p;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public String f7951s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public Exception f7952t;

    /* renamed from: tl  reason: collision with root package name */
    public long f7953tl;

    /* renamed from: v  reason: collision with root package name */
    public final boolean f7954v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public m1.m f7955w;

    /* renamed from: wz  reason: collision with root package name */
    public long f7956wz;
    @Nullable

    /* renamed from: xc  reason: collision with root package name */
    public m1.m f7957xc;
    public final g3 y;

    /* renamed from: zn  reason: collision with root package name */
    public final Map<String, zn.y> f7958zn;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: a  reason: collision with root package name */
        public final List<m.n3> f7959a;

        /* renamed from: a8  reason: collision with root package name */
        public boolean f7960a8;

        /* renamed from: b  reason: collision with root package name */
        public boolean f7961b;

        /* renamed from: c  reason: collision with root package name */
        public long f7962c;

        /* renamed from: c5  reason: collision with root package name */
        public final boolean f7963c5;

        /* renamed from: co  reason: collision with root package name */
        public int f7964co;

        /* renamed from: d  reason: collision with root package name */
        public int f7965d;

        /* renamed from: d0  reason: collision with root package name */
        public long f7966d0;

        /* renamed from: ej  reason: collision with root package name */
        public int f7967ej;

        /* renamed from: f  reason: collision with root package name */
        public boolean f7968f;

        /* renamed from: f3  reason: collision with root package name */
        public long f7969f3;

        /* renamed from: fb  reason: collision with root package name */
        public final List<m.y> f7970fb;

        /* renamed from: fh  reason: collision with root package name */
        public long f7971fh;

        /* renamed from: gv  reason: collision with root package name */
        public final List<long[]> f7972gv;
        @Nullable

        /* renamed from: hw  reason: collision with root package name */
        public m1.m f7973hw;

        /* renamed from: i4  reason: collision with root package name */
        public long f7974i4;

        /* renamed from: i9  reason: collision with root package name */
        public long f7975i9;

        /* renamed from: j  reason: collision with root package name */
        public float f7976j;
        @Nullable

        /* renamed from: j5  reason: collision with root package name */
        public m1.m f7977j5;

        /* renamed from: k5  reason: collision with root package name */
        public boolean f7978k5;

        /* renamed from: mg  reason: collision with root package name */
        public long f7979mg;

        /* renamed from: mt  reason: collision with root package name */
        public long f7980mt;

        /* renamed from: n  reason: collision with root package name */
        public long f7981n;

        /* renamed from: n3  reason: collision with root package name */
        public final long[] f7982n3 = new long[16];

        /* renamed from: o  reason: collision with root package name */
        public long f7983o;

        /* renamed from: p  reason: collision with root package name */
        public int f7984p;

        /* renamed from: qn  reason: collision with root package name */
        public long f7985qn;

        /* renamed from: r  reason: collision with root package name */
        public long f7986r;

        /* renamed from: rz  reason: collision with root package name */
        public long f7987rz;

        /* renamed from: s  reason: collision with root package name */
        public final List<m.y> f7988s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f7989t;

        /* renamed from: ta  reason: collision with root package name */
        public long f7990ta;

        /* renamed from: tl  reason: collision with root package name */
        public boolean f7991tl;

        /* renamed from: ud  reason: collision with root package name */
        public long f7992ud;

        /* renamed from: v  reason: collision with root package name */
        public final List<m.n3> f7993v;

        /* renamed from: vl  reason: collision with root package name */
        public long f7994vl;

        /* renamed from: w  reason: collision with root package name */
        public int f7995w;

        /* renamed from: wz  reason: collision with root package name */
        public int f7996wz;

        /* renamed from: x  reason: collision with root package name */
        public boolean f7997x;

        /* renamed from: x4  reason: collision with root package name */
        public long f7998x4;

        /* renamed from: xc  reason: collision with root package name */
        public int f7999xc;
        public final boolean y;

        /* renamed from: yt  reason: collision with root package name */
        public boolean f8000yt;

        /* renamed from: z  reason: collision with root package name */
        public long f8001z;

        /* renamed from: z6  reason: collision with root package name */
        public int f8002z6;

        /* renamed from: zn  reason: collision with root package name */
        public final List<m.zn> f8003zn;

        public n3(boolean z2, zn.y yVar) {
            List<m.zn> emptyList;
            List<long[]> emptyList2;
            List<m.n3> emptyList3;
            List<m.n3> emptyList4;
            List<m.y> emptyList5;
            List<m.y> emptyList6;
            this.y = z2;
            if (z2) {
                emptyList = new ArrayList<>();
            } else {
                emptyList = Collections.emptyList();
            }
            this.f8003zn = emptyList;
            if (z2) {
                emptyList2 = new ArrayList<>();
            } else {
                emptyList2 = Collections.emptyList();
            }
            this.f7972gv = emptyList2;
            if (z2) {
                emptyList3 = new ArrayList<>();
            } else {
                emptyList3 = Collections.emptyList();
            }
            this.f7993v = emptyList3;
            if (z2) {
                emptyList4 = new ArrayList<>();
            } else {
                emptyList4 = Collections.emptyList();
            }
            this.f7959a = emptyList4;
            if (z2) {
                emptyList5 = new ArrayList<>();
            } else {
                emptyList5 = Collections.emptyList();
            }
            this.f7970fb = emptyList5;
            if (z2) {
                emptyList6 = new ArrayList<>();
            } else {
                emptyList6 = Collections.emptyList();
            }
            this.f7988s = emptyList6;
            boolean z3 = false;
            this.f7967ej = 0;
            this.f7992ud = yVar.y;
            this.f7975i9 = -9223372036854775807L;
            this.f7980mt = -9223372036854775807L;
            mg.n3 n3Var = yVar.f8169gv;
            if (n3Var != null && n3Var.n3()) {
                z3 = true;
            }
            this.f7963c5 = z3;
            this.f7986r = -1L;
            this.f8001z = -1L;
            this.f7964co = -1;
            this.f7976j = 1.0f;
        }

        public static boolean a(int i) {
            if (i != 6 && i != 7 && i != 10) {
                return false;
            }
            return true;
        }

        public static boolean gv(int i) {
            if (i != 4 && i != 7) {
                return false;
            }
            return true;
        }

        public static boolean v(int i) {
            if (i != 3 && i != 4 && i != 9) {
                return false;
            }
            return true;
        }

        public static boolean zn(int i, int i5) {
            if ((i != 1 && i != 2 && i != 14) || i5 == 1 || i5 == 2 || i5 == 14 || i5 == 3 || i5 == 4 || i5 == 9 || i5 == 11) {
                return false;
            }
            return true;
        }

        public final void c5(zn.y yVar, @Nullable m1.m mVar) {
            int i;
            if (v5.j5.zn(this.f7977j5, mVar)) {
                return;
            }
            fb(yVar.y);
            if (mVar != null && this.f7986r == -1 && (i = mVar.f10959p) != -1) {
                this.f7986r = i;
            }
            this.f7977j5 = mVar;
            if (this.y) {
                this.f7959a.add(new m.n3(yVar, mVar));
            }
        }

        public final void f(long j2, long j4) {
            if (!this.y) {
                return;
            }
            if (this.f7967ej != 3) {
                if (j4 == -9223372036854775807L) {
                    return;
                }
                if (!this.f7972gv.isEmpty()) {
                    List<long[]> list = this.f7972gv;
                    long j6 = list.get(list.size() - 1)[1];
                    if (j6 != j4) {
                        this.f7972gv.add(new long[]{j2, j6});
                    }
                }
            }
            if (j4 != -9223372036854775807L) {
                this.f7972gv.add(new long[]{j2, j4});
            } else if (!this.f7972gv.isEmpty()) {
                this.f7972gv.add(n3(j2));
            }
        }

        public final void fb(long j2) {
            m1.m mVar;
            int i;
            if (this.f7967ej == 3 && (mVar = this.f7977j5) != null && (i = mVar.f10959p) != -1) {
                long j4 = ((float) (j2 - this.f7983o)) * this.f7976j;
                this.f7962c += j4;
                this.f7966d0 += j4 * i;
            }
            this.f7983o = j2;
        }

        public final void i9(long j2) {
            if (a(this.f7967ej)) {
                long j4 = j2 - this.f7994vl;
                long j6 = this.f7980mt;
                if (j6 == -9223372036854775807L || j4 > j6) {
                    this.f7980mt = j4;
                }
            }
        }

        public final void mt(int i, zn.y yVar) {
            boolean z2;
            boolean z3 = false;
            if (yVar.y >= this.f7992ud) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.y(z2);
            long j2 = yVar.y;
            long[] jArr = this.f7982n3;
            int i5 = this.f7967ej;
            jArr[i5] = jArr[i5] + (j2 - this.f7992ud);
            if (this.f7975i9 == -9223372036854775807L) {
                this.f7975i9 = j2;
            }
            this.f7991tl |= zn(i5, i);
            this.f7968f |= v(i);
            boolean z4 = this.f7989t;
            if (i == 11) {
                z3 = true;
            }
            this.f7989t = z4 | z3;
            if (!gv(this.f7967ej) && gv(i)) {
                this.f7996wz++;
            }
            if (i == 5) {
                this.f7995w++;
            }
            if (!a(this.f7967ej) && a(i)) {
                this.f7984p++;
                this.f7994vl = yVar.y;
            }
            if (a(this.f7967ej) && this.f7967ej != 7 && i == 7) {
                this.f7999xc++;
            }
            i9(yVar.y);
            this.f7967ej = i;
            this.f7992ud = yVar.y;
            if (this.y) {
                this.f8003zn.add(new m.zn(yVar, i));
            }
        }

        public final long[] n3(long j2) {
            List<long[]> list = this.f7972gv;
            long[] jArr = list.get(list.size() - 1);
            return new long[]{j2, jArr[1] + (((float) (j2 - jArr[0])) * this.f7976j)};
        }

        public final int p(uo uoVar) {
            int n32 = uoVar.n3();
            if (this.f7960a8 && this.f7997x) {
                return 5;
            }
            if (this.f7978k5) {
                return 13;
            }
            if (this.f7997x) {
                if (this.f7961b) {
                    return 14;
                }
                if (n32 == 4) {
                    return 11;
                }
                if (n32 == 2) {
                    int i = this.f7967ej;
                    if (i == 0 || i == 1 || i == 2 || i == 14) {
                        return 2;
                    }
                    if (!uoVar.oz()) {
                        return 7;
                    }
                    if (uoVar.x() != 0) {
                        return 10;
                    }
                    return 6;
                } else if (n32 == 3) {
                    if (!uoVar.oz()) {
                        return 4;
                    }
                    if (uoVar.x() == 0) {
                        return 3;
                    }
                    return 9;
                } else if (n32 == 1 && this.f7967ej != 0) {
                    return 12;
                } else {
                    return this.f7967ej;
                }
            }
            return this.f8000yt ? 1 : 0;
        }

        public final void s(long j2) {
            m1.m mVar;
            if (this.f7967ej == 3 && (mVar = this.f7973hw) != null) {
                long j4 = ((float) (j2 - this.f7985qn)) * this.f7976j;
                int i = mVar.f10945ej;
                if (i != -1) {
                    this.f7998x4 += j4;
                    this.f7974i4 += i * j4;
                }
                int i5 = mVar.f10959p;
                if (i5 != -1) {
                    this.f7969f3 += j4;
                    this.f7981n += j4 * i5;
                }
            }
            this.f7985qn = j2;
        }

        public final void t(zn.y yVar, @Nullable m1.m mVar) {
            int i;
            int i5;
            if (v5.j5.zn(this.f7973hw, mVar)) {
                return;
            }
            s(yVar.y);
            if (mVar != null) {
                if (this.f7964co == -1 && (i5 = mVar.f10945ej) != -1) {
                    this.f7964co = i5;
                }
                if (this.f8001z == -1 && (i = mVar.f10959p) != -1) {
                    this.f8001z = i;
                }
            }
            this.f7973hw = mVar;
            if (this.y) {
                this.f7993v.add(new m.n3(yVar, mVar));
            }
        }

        public void tl(uo uoVar, zn.y yVar, boolean z2, long j2, boolean z3, int i, boolean z4, boolean z5, @Nullable gf gfVar, @Nullable Exception exc, long j4, long j6, @Nullable m1.m mVar, @Nullable m1.m mVar2, @Nullable wn.d0 d0Var) {
            if (j2 != -9223372036854775807L) {
                f(yVar.y, j2);
                this.f7960a8 = true;
            }
            if (uoVar.n3() != 2) {
                this.f7960a8 = false;
            }
            int n32 = uoVar.n3();
            if (n32 == 1 || n32 == 4 || z3) {
                this.f7961b = false;
            }
            if (gfVar != null) {
                this.f7978k5 = true;
                this.f7965d++;
                if (this.y) {
                    this.f7970fb.add(new m.y(yVar, gfVar));
                }
            } else if (uoVar.a() == null) {
                this.f7978k5 = false;
            }
            if (this.f7997x && !this.f7961b) {
                v1 d02 = uoVar.d0();
                if (!d02.gv(2)) {
                    t(yVar, null);
                }
                if (!d02.gv(1)) {
                    c5(yVar, null);
                }
            }
            if (mVar != null) {
                t(yVar, mVar);
            }
            if (mVar2 != null) {
                c5(yVar, mVar2);
            }
            m1.m mVar3 = this.f7973hw;
            if (mVar3 != null && mVar3.f10945ej == -1 && d0Var != null) {
                t(yVar, mVar3.n3().s8(d0Var.y).o(d0Var.f14582v).z6());
            }
            if (z5) {
                this.f8000yt = true;
            }
            if (z4) {
                this.f7990ta++;
            }
            this.f7979mg += i;
            this.f7971fh += j4;
            this.f7987rz += j6;
            if (exc != null) {
                this.f8002z6++;
                if (this.y) {
                    this.f7988s.add(new m.y(yVar, exc));
                }
            }
            int p2 = p(uoVar);
            float f4 = uoVar.v().y;
            if (this.f7967ej != p2 || this.f7976j != f4) {
                f(yVar.y, z2 ? yVar.f8173v : -9223372036854775807L);
                s(yVar.y);
                fb(yVar.y);
            }
            this.f7976j = f4;
            if (this.f7967ej != p2) {
                mt(p2, yVar);
            }
        }

        public void w() {
            this.f7961b = true;
            this.f7960a8 = false;
        }

        public void wz(zn.y yVar, boolean z2, long j2) {
            int i = 11;
            if (this.f7967ej != 11 && !z2) {
                i = 15;
            }
            f(yVar.y, j2);
            s(yVar.y);
            fb(yVar.y);
            mt(i, yVar);
        }

        public void xc() {
            this.f7997x = true;
        }

        public m y(boolean z2) {
            long[] jArr;
            ArrayList arrayList;
            int i;
            long j2;
            int i5;
            List arrayList2;
            List arrayList3;
            List arrayList4;
            int i6;
            int i8;
            int i10;
            int i11;
            long[] jArr2 = this.f7982n3;
            List<long[]> list = this.f7972gv;
            if (!z2) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long[] copyOf = Arrays.copyOf(this.f7982n3, 16);
                long max = Math.max(0L, elapsedRealtime - this.f7992ud);
                int i12 = this.f7967ej;
                copyOf[i12] = copyOf[i12] + max;
                i9(elapsedRealtime);
                s(elapsedRealtime);
                fb(elapsedRealtime);
                ArrayList arrayList5 = new ArrayList(this.f7972gv);
                if (this.y && this.f7967ej == 3) {
                    arrayList5.add(n3(elapsedRealtime));
                }
                jArr = copyOf;
                arrayList = arrayList5;
            } else {
                jArr = jArr2;
                arrayList = list;
            }
            if (!this.f7991tl && this.f7968f) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                j2 = -9223372036854775807L;
            } else {
                j2 = jArr[2];
            }
            long j4 = j2;
            if (jArr[1] > 0) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (z2) {
                arrayList2 = this.f7993v;
            } else {
                arrayList2 = new ArrayList(this.f7993v);
            }
            List list2 = arrayList2;
            if (z2) {
                arrayList3 = this.f7959a;
            } else {
                arrayList3 = new ArrayList(this.f7959a);
            }
            List list3 = arrayList3;
            if (z2) {
                arrayList4 = this.f8003zn;
            } else {
                arrayList4 = new ArrayList(this.f8003zn);
            }
            List list4 = arrayList4;
            long j6 = this.f7975i9;
            boolean z3 = this.f7997x;
            int i13 = !this.f7968f ? 1 : 0;
            boolean z4 = this.f7989t;
            int i14 = i ^ 1;
            int i15 = this.f7996wz;
            int i16 = this.f7999xc;
            int i17 = this.f7995w;
            int i18 = this.f7984p;
            long j7 = this.f7980mt;
            boolean z5 = this.f7963c5;
            long[] jArr3 = jArr;
            long j8 = this.f7998x4;
            long j9 = this.f7974i4;
            long j10 = this.f7969f3;
            long j11 = this.f7981n;
            long j12 = this.f7962c;
            long j13 = this.f7966d0;
            int i19 = this.f7964co;
            if (i19 == -1) {
                i6 = 0;
            } else {
                i6 = 1;
            }
            long j14 = this.f8001z;
            if (j14 == -1) {
                i8 = 0;
            } else {
                i8 = 1;
            }
            long j15 = this.f7986r;
            if (j15 == -1) {
                i10 = 0;
            } else {
                i10 = 1;
            }
            long j16 = this.f7971fh;
            long j17 = this.f7987rz;
            long j18 = this.f7979mg;
            long j19 = this.f7990ta;
            int i20 = this.f7965d;
            if (i20 > 0) {
                i11 = 1;
            } else {
                i11 = 0;
            }
            return new m(1, jArr3, list4, arrayList, j6, z3 ? 1 : 0, i13, z4 ? 1 : 0, i5, j4, i14, i15, i16, i17, i18, j7, z5 ? 1 : 0, list2, list3, j8, j9, j10, j11, j12, j13, i6, i8, i19, j14, i10, j15, j16, j17, j18, j19, i11, i20, this.f8002z6, this.f7970fb, this.f7988s);
        }
    }

    /* loaded from: classes.dex */
    public interface y {
        void y(zn.y yVar, m mVar);
    }

    public g(boolean z2, @Nullable y yVar) {
        this.f7947gv = yVar;
        this.f7954v = z2;
        kp kpVar = new kp();
        this.y = kpVar;
        this.f7949n3 = new HashMap();
        this.f7958zn = new HashMap();
        this.f7946fb = m.f8028vl;
        this.f7943a = new hy.n3();
        this.f7950p = wn.d0.f14575f;
        kpVar.a(this);
    }

    private void cr(zn.n3 n3Var) {
        for (int i = 0; i < n3Var.gv(); i++) {
            int n32 = n3Var.n3(i);
            zn.y zn2 = n3Var.zn(n32);
            if (n32 == 0) {
                this.y.zn(zn2);
            } else if (n32 == 11) {
                this.y.gv(zn2, this.f7948i9);
            } else {
                this.y.s(zn2);
            }
        }
    }

    @Override // fj.g3.y
    public void a(zn.y yVar, String str) {
        ((n3) v5.y.v(this.f7949n3.get(str))).xc();
    }

    @Override // fj.zn
    public /* synthetic */ void a8(zn.y yVar) {
        fj.n3.ut(this, yVar);
    }

    @Override // fj.zn
    public /* synthetic */ void ap(zn.y yVar, qh.a aVar) {
        fj.n3.xc(this, yVar, aVar);
    }

    @Override // fj.zn
    public /* synthetic */ void b(zn.y yVar, Object obj, long j2) {
        fj.n3.en(this, yVar, obj, j2);
    }

    @Override // fj.zn
    public /* synthetic */ void bk(zn.y yVar) {
        fj.n3.c(this, yVar);
    }

    @Override // fj.zn
    public void c(zn.y yVar, af.i4 i4Var, af.c cVar, IOException iOException, boolean z2) {
        this.f7952t = iOException;
    }

    @Override // fj.zn
    public /* synthetic */ void c5(zn.y yVar, boolean z2) {
        fj.n3.dm(this, yVar, z2);
    }

    @Override // fj.zn
    public /* synthetic */ void co(zn.y yVar, v1 v1Var) {
        fj.n3.eb(this, yVar, v1Var);
    }

    @Override // fj.zn
    public /* synthetic */ void ct(zn.y yVar, int i, m1.m mVar) {
        fj.n3.co(this, yVar, i, mVar);
    }

    @Override // fj.zn
    public /* synthetic */ void d(zn.y yVar, uo.n3 n3Var) {
        fj.n3.t(this, yVar, n3Var);
    }

    @Override // fj.g3.y
    public void d0(zn.y yVar, String str) {
        this.f7949n3.put(str, new n3(this.f7954v, yVar));
        this.f7958zn.put(str, yVar);
    }

    @Override // fj.zn
    public /* synthetic */ void dm(zn.y yVar, String str) {
        fj.n3.s8(this, yVar, str);
    }

    @Override // fj.g3.y
    public void e(zn.y yVar, String str, boolean z2) {
        long j2;
        n3 n3Var = (n3) v5.y.v(this.f7949n3.remove(str));
        zn.y yVar2 = (zn.y) v5.y.v(this.f7958zn.remove(str));
        if (str.equals(this.f7951s)) {
            j2 = this.f7944c5;
        } else {
            j2 = -9223372036854775807L;
        }
        n3Var.wz(yVar, z2, j2);
        m y2 = n3Var.y(true);
        this.f7946fb = m.co(this.f7946fb, y2);
        y yVar3 = this.f7947gv;
        if (yVar3 != null) {
            yVar3.y(yVar2, y2);
        }
    }

    @Override // fj.zn
    public /* synthetic */ void eb(zn.y yVar, int i, a9.v vVar) {
        fj.n3.w(this, yVar, i, vVar);
    }

    @Override // fj.zn
    public /* synthetic */ void ej(zn.y yVar, String str, long j2) {
        fj.n3.ra(this, yVar, str, j2);
    }

    @Override // fj.zn
    public /* synthetic */ void en(zn.y yVar, boolean z2) {
        fj.n3.xg(this, yVar, z2);
    }

    @Override // fj.zn
    public /* synthetic */ void f(zn.y yVar, int i) {
        fj.n3.k(this, yVar, i);
    }

    @Override // fj.zn
    public /* synthetic */ void f3(zn.y yVar) {
        fj.n3.u(this, yVar);
    }

    @Override // fj.zn
    public /* synthetic */ void f7(zn.y yVar, boolean z2) {
        fj.n3.b(this, yVar, z2);
    }

    @Override // fj.zn
    public /* synthetic */ void fb(zn.y yVar, Exception exc) {
        fj.n3.i9(this, yVar, exc);
    }

    @Override // fj.zn
    public /* synthetic */ void fh(zn.y yVar, Exception exc) {
        fj.n3.y(this, yVar, exc);
    }

    @Override // fj.zn
    public void g(zn.y yVar, af.c cVar) {
        int i = cVar.f120n3;
        if (i != 2 && i != 0) {
            if (i == 1) {
                this.f7955w = cVar.f122zn;
                return;
            }
            return;
        }
        this.f7957xc = cVar.f122zn;
    }

    @Override // fj.zn
    public void g3(zn.y yVar, int i, long j2) {
        this.f7945f = i;
    }

    @Override // fj.zn
    public /* synthetic */ void gv(zn.y yVar, String str, long j2) {
        fj.n3.n3(this, yVar, str, j2);
    }

    @Override // fj.zn
    public /* synthetic */ void hw(zn.y yVar) {
        fj.n3.rz(this, yVar);
    }

    @Override // fj.zn
    public /* synthetic */ void i4(zn.y yVar, int i, int i5, int i6, float f4) {
        fj.n3.g3(this, yVar, i, i5, i6, f4);
    }

    @Override // fj.zn
    public /* synthetic */ void i9(zn.y yVar) {
        fj.n3.n(this, yVar);
    }

    @Override // fj.g3.y
    public void j(zn.y yVar, String str, String str2) {
        ((n3) v5.y.v(this.f7949n3.get(str))).w();
    }

    @Override // fj.zn
    public /* synthetic */ void j5(zn.y yVar, String str, long j2, long j4) {
        fj.n3.e(this, yVar, str, j2, j4);
    }

    @Override // fj.zn
    public /* synthetic */ void jz(zn.y yVar, int i) {
        fj.n3.o(this, yVar, i);
    }

    @Override // fj.zn
    public /* synthetic */ void k(zn.y yVar, int i, int i5) {
        fj.n3.ct(this, yVar, i, i5);
    }

    @Override // fj.zn
    public /* synthetic */ void k5(zn.y yVar, int i) {
        fj.n3.qn(this, yVar, i);
    }

    @Override // fj.zn
    public /* synthetic */ void kp(zn.y yVar, boolean z2, int i) {
        fj.n3.hw(this, yVar, z2, i);
    }

    @Override // fj.zn
    public /* synthetic */ void lc(zn.y yVar, Metadata metadata) {
        fj.n3.vl(this, yVar, metadata);
    }

    @Override // fj.zn
    public /* synthetic */ void m(zn.y yVar, o0 o0Var, int i) {
        fj.n3.k5(this, yVar, o0Var, i);
    }

    @Override // fj.zn
    public /* synthetic */ void mg(zn.y yVar, boolean z2) {
        fj.n3.z6(this, yVar, z2);
    }

    @Override // fj.zn
    public void mt(zn.y yVar, wn.d0 d0Var) {
        this.f7950p = d0Var;
    }

    @Override // fj.zn
    public /* synthetic */ void n(zn.y yVar, int i) {
        fj.n3.jz(this, yVar, i);
    }

    @Override // fj.zn
    public /* synthetic */ void n3(zn.y yVar, int i, a9.v vVar) {
        fj.n3.p(this, yVar, i, vVar);
    }

    @Override // fj.zn
    public void nf(zn.y yVar, uo.v vVar, uo.v vVar2, int i) {
        if (this.f7951s == null) {
            this.f7951s = this.y.y();
            this.f7944c5 = vVar.f11278w;
        }
        this.f7948i9 = i;
    }

    @Override // fj.zn
    public /* synthetic */ void o(zn.y yVar, int i, boolean z2) {
        fj.n3.r(this, yVar, i, z2);
    }

    @Override // fj.zn
    public void o4(zn.y yVar, int i, long j2, long j4) {
        this.f7953tl = i;
        this.f7956wz = j2;
    }

    @Override // fj.zn
    public /* synthetic */ void oz(zn.y yVar, Exception exc) {
        fj.n3.nf(this, yVar, exc);
    }

    @Override // fj.zn
    public /* synthetic */ void p(zn.y yVar, af.c cVar) {
        fj.n3.lc(this, yVar, cVar);
    }

    public final boolean pq(zn.n3 n3Var, String str, int i) {
        if (n3Var.y(i) && this.y.fb(n3Var.zn(i), str)) {
            return true;
        }
        return false;
    }

    public final Pair<zn.y, Boolean> pz(zn.n3 n3Var, String str) {
        mg.n3 n3Var2;
        zn.y yVar = null;
        boolean z2 = false;
        for (int i = 0; i < n3Var.gv(); i++) {
            zn.y zn2 = n3Var.zn(n3Var.n3(i));
            boolean fb2 = this.y.fb(zn2, str);
            if (yVar == null || ((fb2 && !z2) || (fb2 == z2 && zn2.y > yVar.y))) {
                yVar = zn2;
                z2 = fb2;
            }
        }
        v5.y.v(yVar);
        if (!z2 && (n3Var2 = yVar.f8169gv) != null && n3Var2.n3()) {
            long c52 = yVar.f8171n3.t(yVar.f8169gv.y, this.f7943a).c5(yVar.f8169gv.f239n3);
            if (c52 == Long.MIN_VALUE) {
                c52 = this.f7943a.f10829s;
            }
            long p2 = c52 + this.f7943a.p();
            long j2 = yVar.y;
            hy hyVar = yVar.f8171n3;
            int i5 = yVar.f8174zn;
            mg.n3 n3Var3 = yVar.f8169gv;
            zn.y yVar2 = new zn.y(j2, hyVar, i5, new mg.n3(n3Var3.y, n3Var3.f238gv, n3Var3.f239n3), v5.j5.gf(p2), yVar.f8171n3, yVar.f8168fb, yVar.f8172s, yVar.f8167c5, yVar.f8170i9);
            z2 = this.y.fb(yVar2, str);
            yVar = yVar2;
        }
        return Pair.create(yVar, Boolean.valueOf(z2));
    }

    @Override // fj.zn
    public /* synthetic */ void q9(zn.y yVar, a9.v vVar) {
        fj.n3.v(this, yVar, vVar);
    }

    @Override // fj.zn
    public /* synthetic */ void qn(zn.y yVar, String str, long j2, long j4) {
        fj.n3.zn(this, yVar, str, j2, j4);
    }

    @Override // fj.zn
    public /* synthetic */ void r(zn.y yVar, af.i4 i4Var, af.c cVar) {
        fj.n3.ud(this, yVar, i4Var, cVar);
    }

    @Override // fj.zn
    public /* synthetic */ void ra(zn.y yVar, long j2) {
        fj.n3.c5(this, yVar, j2);
    }

    @Override // fj.zn
    public void rb(uo uoVar, zn.n3 n3Var) {
        boolean z2;
        long j2;
        int i;
        gf gfVar;
        Exception exc;
        long j4;
        long j6;
        m1.m mVar;
        m1.m mVar2;
        wn.d0 d0Var;
        if (n3Var.gv() == 0) {
            return;
        }
        cr(n3Var);
        for (String str : this.f7949n3.keySet()) {
            Pair<zn.y, Boolean> pz2 = pz(n3Var, str);
            n3 n3Var2 = this.f7949n3.get(str);
            boolean pq2 = pq(n3Var, str, 11);
            boolean pq3 = pq(n3Var, str, 1018);
            boolean pq4 = pq(n3Var, str, 1011);
            boolean pq5 = pq(n3Var, str, 1000);
            boolean pq6 = pq(n3Var, str, 10);
            if (!pq(n3Var, str, 1003) && !pq(n3Var, str, 1024)) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean pq7 = pq(n3Var, str, 1006);
            boolean pq8 = pq(n3Var, str, 1004);
            boolean pq9 = pq(n3Var, str, 25);
            zn.y yVar = (zn.y) pz2.first;
            boolean booleanValue = ((Boolean) pz2.second).booleanValue();
            if (str.equals(this.f7951s)) {
                j2 = this.f7944c5;
            } else {
                j2 = -9223372036854775807L;
            }
            if (pq3) {
                i = this.f7945f;
            } else {
                i = 0;
            }
            if (pq6) {
                gfVar = uoVar.a();
            } else {
                gfVar = null;
            }
            if (z2) {
                exc = this.f7952t;
            } else {
                exc = null;
            }
            if (pq7) {
                j4 = this.f7953tl;
            } else {
                j4 = 0;
            }
            if (pq7) {
                j6 = this.f7956wz;
            } else {
                j6 = 0;
            }
            if (pq8) {
                mVar = this.f7957xc;
            } else {
                mVar = null;
            }
            if (pq8) {
                mVar2 = this.f7955w;
            } else {
                mVar2 = null;
            }
            if (pq9) {
                d0Var = this.f7950p;
            } else {
                d0Var = null;
            }
            n3Var2.tl(uoVar, yVar, booleanValue, j2, pq2, i, pq4, pq5, gfVar, exc, j4, j6, mVar, mVar2, d0Var);
        }
        this.f7957xc = null;
        this.f7955w = null;
        this.f7951s = null;
        if (n3Var.y(1028)) {
            this.y.n3(n3Var.zn(1028));
        }
    }

    @Override // fj.zn
    public /* synthetic */ void rs(zn.y yVar, String str) {
        fj.n3.gv(this, yVar, str);
    }

    @Override // fj.zn
    public /* synthetic */ void rz(zn.y yVar, m1.m mVar) {
        fj.n3.kp(this, yVar, mVar);
    }

    @Override // fj.zn
    public /* synthetic */ void s(zn.y yVar, List list) {
        fj.n3.wz(this, yVar, list);
    }

    @Override // fj.zn
    public /* synthetic */ void s8(zn.y yVar, int i, String str, long j2) {
        fj.n3.mt(this, yVar, i, str, j2);
    }

    @Override // fj.zn
    public /* synthetic */ void t(zn.y yVar, zo.c cVar) {
        fj.n3.rs(this, yVar, cVar);
    }

    @Override // fj.zn
    public /* synthetic */ void ta(zn.y yVar, m1.m mVar, a9.c5 c5Var) {
        fj.n3.s(this, yVar, mVar, c5Var);
    }

    @Override // fj.zn
    public /* synthetic */ void tg(zn.y yVar, a9.v vVar) {
        fj.n3.a(this, yVar, vVar);
    }

    @Override // fj.zn
    public /* synthetic */ void tl(zn.y yVar, boolean z2) {
        fj.n3.d(this, yVar, z2);
    }

    @Override // fj.zn
    public /* synthetic */ void u(zn.y yVar, qk qkVar) {
        fj.n3.yt(this, yVar, qkVar);
    }

    @Override // fj.zn
    public /* synthetic */ void u0(zn.y yVar, af.i4 i4Var, af.c cVar) {
        fj.n3.x(this, yVar, i4Var, cVar);
    }

    @Override // fj.zn
    public /* synthetic */ void ud(zn.y yVar, m1.m mVar) {
        fj.n3.fb(this, yVar, mVar);
    }

    @Override // fj.zn
    public /* synthetic */ void ut(zn.y yVar, a9.v vVar) {
        fj.n3.yg(this, yVar, vVar);
    }

    @Override // fj.zn
    public /* synthetic */ void v(zn.y yVar) {
        fj.n3.y5(this, yVar);
    }

    @Override // fj.zn
    public /* synthetic */ void vl(zn.y yVar, a9.v vVar) {
        fj.n3.ap(this, yVar, vVar);
    }

    @Override // fj.zn
    public /* synthetic */ void w(zn.y yVar, float f4) {
        fj.n3.g(this, yVar, f4);
    }

    @Override // fj.zn
    public /* synthetic */ void wz(zn.y yVar, long j2, int i) {
        fj.n3.yc(this, yVar, j2, i);
    }

    @Override // fj.zn
    public /* synthetic */ void x(zn.y yVar, m1.m mVar, a9.c5 c5Var) {
        fj.n3.rb(this, yVar, mVar, c5Var);
    }

    @Override // fj.zn
    public void x4(zn.y yVar, Exception exc) {
        this.f7952t = exc;
    }

    @Override // fj.zn
    public /* synthetic */ void xc(zn.y yVar, m1.xc xcVar) {
        fj.n3.z(this, yVar, xcVar);
    }

    @Override // fj.zn
    public /* synthetic */ void xg(zn.y yVar) {
        fj.n3.i4(this, yVar);
    }

    @Override // fj.zn
    public /* synthetic */ void y(zn.y yVar) {
        fj.n3.f3(this, yVar);
    }

    @Override // fj.zn
    public /* synthetic */ void y4(zn.y yVar, gf gfVar) {
        fj.n3.j(this, yVar, gfVar);
    }

    @Override // fj.zn
    public /* synthetic */ void y5(zn.y yVar, int i) {
        fj.n3.d0(this, yVar, i);
    }

    @Override // fj.zn
    public /* synthetic */ void yc(zn.y yVar, int i) {
        fj.n3.o4(this, yVar, i);
    }

    @Override // fj.zn
    public /* synthetic */ void yg(zn.y yVar, int i, long j2, long j4) {
        fj.n3.f(this, yVar, i, j2, j4);
    }

    @Override // fj.zn
    public /* synthetic */ void yt(zn.y yVar, br brVar) {
        fj.n3.j5(this, yVar, brVar);
    }

    @Override // fj.zn
    public /* synthetic */ void z(zn.y yVar, af.i4 i4Var, af.c cVar) {
        fj.n3.ej(this, yVar, i4Var, cVar);
    }

    @Override // fj.zn
    public /* synthetic */ void z6(zn.y yVar, gf gfVar) {
        fj.n3.oz(this, yVar, gfVar);
    }

    @Override // fj.zn
    public /* synthetic */ void zn(zn.y yVar, boolean z2, int i) {
        fj.n3.q9(this, yVar, z2, i);
    }
}
