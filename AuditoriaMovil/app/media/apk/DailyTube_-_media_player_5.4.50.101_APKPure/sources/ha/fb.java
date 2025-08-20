package ha;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import e4.d0;
import e4.f3;
import e4.fh;
import e4.ta;
import ha.y;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import m1.m;
import m1.ne;
import v5.c;
import v5.j5;
import v5.k5;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public class fb implements e4.t {

    /* renamed from: a  reason: collision with root package name */
    public final rz f8795a;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public n3 f8796c;

    /* renamed from: c5  reason: collision with root package name */
    public final rz f8797c5;

    /* renamed from: co  reason: collision with root package name */
    public int f8798co;

    /* renamed from: d  reason: collision with root package name */
    public ta[] f8799d;

    /* renamed from: d0  reason: collision with root package name */
    public int f8800d0;

    /* renamed from: ej  reason: collision with root package name */
    public boolean f8801ej;

    /* renamed from: f  reason: collision with root package name */
    public final f5.n3 f8802f;

    /* renamed from: f3  reason: collision with root package name */
    public long f8803f3;

    /* renamed from: fb  reason: collision with root package name */
    public final rz f8804fb;

    /* renamed from: fh  reason: collision with root package name */
    public int f8805fh;

    /* renamed from: gv  reason: collision with root package name */
    public final SparseArray<n3> f8806gv;

    /* renamed from: i4  reason: collision with root package name */
    public long f8807i4;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public final k5 f8808i9;

    /* renamed from: mg  reason: collision with root package name */
    public boolean f8809mg;

    /* renamed from: mt  reason: collision with root package name */
    public long f8810mt;

    /* renamed from: n  reason: collision with root package name */
    public long f8811n;
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public final xc f8812n3;

    /* renamed from: p  reason: collision with root package name */
    public int f8813p;

    /* renamed from: r  reason: collision with root package name */
    public long f8814r;

    /* renamed from: rz  reason: collision with root package name */
    public int f8815rz;

    /* renamed from: s  reason: collision with root package name */
    public final byte[] f8816s;

    /* renamed from: t  reason: collision with root package name */
    public final rz f8817t;

    /* renamed from: ta  reason: collision with root package name */
    public e4.wz f8818ta;

    /* renamed from: tl  reason: collision with root package name */
    public final ArrayDeque<y.C0106y> f8819tl;

    /* renamed from: v  reason: collision with root package name */
    public final rz f8820v;

    /* renamed from: w  reason: collision with root package name */
    public int f8821w;

    /* renamed from: wz  reason: collision with root package name */
    public final ArrayDeque<y> f8822wz;

    /* renamed from: x4  reason: collision with root package name */
    public int f8823x4;
    @Nullable

    /* renamed from: xc  reason: collision with root package name */
    public final ta f8824xc;
    public final int y;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    public rz f8825z;

    /* renamed from: z6  reason: collision with root package name */
    public ta[] f8826z6;

    /* renamed from: zn  reason: collision with root package name */
    public final List<m> f8827zn;

    /* renamed from: ud  reason: collision with root package name */
    public static final e4.mt f8793ud = new e4.mt() { // from class: ha.v
        @Override // e4.mt
        public final e4.t[] createExtractors() {
            e4.t[] tl2;
            tl2 = fb.tl();
            return tl2;
        }

        @Override // e4.mt
        public /* synthetic */ e4.t[] y(Uri uri, Map map) {
            return e4.p.y(this, uri, map);
        }
    };

    /* renamed from: a8  reason: collision with root package name */
    public static final byte[] f8792a8 = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};

    /* renamed from: x  reason: collision with root package name */
    public static final m f8794x = new m.n3().o4("application/x-emsg").z6();

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: a  reason: collision with root package name */
        public int f8828a;

        /* renamed from: c5  reason: collision with root package name */
        public int f8829c5;

        /* renamed from: fb  reason: collision with root package name */
        public int f8831fb;

        /* renamed from: gv  reason: collision with root package name */
        public mt f8832gv;

        /* renamed from: s  reason: collision with root package name */
        public int f8835s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f8836t;

        /* renamed from: v  reason: collision with root package name */
        public zn f8837v;
        public final ta y;

        /* renamed from: n3  reason: collision with root package name */
        public final p f8834n3 = new p();

        /* renamed from: zn  reason: collision with root package name */
        public final rz f8838zn = new rz();

        /* renamed from: i9  reason: collision with root package name */
        public final rz f8833i9 = new rz(1);

        /* renamed from: f  reason: collision with root package name */
        public final rz f8830f = new rz();

        public n3(ta taVar, mt mtVar, zn znVar) {
            this.y = taVar;
            this.f8832gv = mtVar;
            this.f8837v = znVar;
            i9(mtVar, znVar);
        }

        public int a() {
            if (!this.f8836t) {
                return this.f8832gv.f8848gv[this.f8828a];
            }
            return this.f8834n3.f8876c5[this.f8828a];
        }

        public int c5(int i, int i5) {
            rz rzVar;
            boolean z2;
            int i6;
            w fb2 = fb();
            if (fb2 == null) {
                return 0;
            }
            int i8 = fb2.f8900gv;
            if (i8 != 0) {
                rzVar = this.f8834n3.f8890xc;
            } else {
                byte[] bArr = (byte[]) j5.i9(fb2.f8902v);
                this.f8830f.o(bArr, bArr.length);
                rz rzVar2 = this.f8830f;
                i8 = bArr.length;
                rzVar = rzVar2;
            }
            boolean fb3 = this.f8834n3.fb(this.f8828a);
            if (!fb3 && i5 == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            byte[] v2 = this.f8833i9.v();
            if (z2) {
                i6 = NotificationCompat.FLAG_HIGH_PRIORITY;
            } else {
                i6 = 0;
            }
            v2[0] = (byte) (i6 | i8);
            this.f8833i9.oz(0);
            this.y.a(this.f8833i9, 1, 1);
            this.y.a(rzVar, i8, 1);
            if (!z2) {
                return i8 + 1;
            }
            if (!fb3) {
                this.f8838zn.j5(8);
                byte[] v3 = this.f8838zn.v();
                v3[0] = 0;
                v3[1] = 1;
                v3[2] = (byte) ((i5 >> 8) & 255);
                v3[3] = (byte) (i5 & 255);
                v3[4] = (byte) ((i >> 24) & 255);
                v3[5] = (byte) ((i >> 16) & 255);
                v3[6] = (byte) ((i >> 8) & 255);
                v3[7] = (byte) (i & 255);
                this.y.a(this.f8838zn, 8, 1);
                return i8 + 9;
            }
            rz rzVar3 = this.f8834n3.f8890xc;
            int yt2 = rzVar3.yt();
            rzVar3.ut(-2);
            int i10 = (yt2 * 6) + 2;
            if (i5 != 0) {
                this.f8838zn.j5(i10);
                byte[] v4 = this.f8838zn.v();
                rzVar3.t(v4, 0, i10);
                int i11 = (((v4[2] & 255) << 8) | (v4[3] & 255)) + i5;
                v4[2] = (byte) ((i11 >> 8) & 255);
                v4[3] = (byte) (i11 & 255);
                rzVar3 = this.f8838zn;
            }
            this.y.a(rzVar3, i10, 1);
            return i8 + 1 + i10;
        }

        public void f() {
            this.f8834n3.a();
            this.f8828a = 0;
            this.f8835s = 0;
            this.f8831fb = 0;
            this.f8829c5 = 0;
            this.f8836t = false;
        }

        @Nullable
        public w fb() {
            if (!this.f8836t) {
                return null;
            }
            int i = ((zn) j5.i9(this.f8834n3.y)).y;
            w wVar = this.f8834n3.f8889wz;
            if (wVar == null) {
                wVar = this.f8832gv.y.y(i);
            }
            if (wVar == null || !wVar.y) {
                return null;
            }
            return wVar;
        }

        public long gv() {
            if (!this.f8836t) {
                return this.f8832gv.f8852zn[this.f8828a];
            }
            return this.f8834n3.f8878fb[this.f8835s];
        }

        public void i9(mt mtVar, zn znVar) {
            this.f8832gv = mtVar;
            this.f8837v = znVar;
            this.y.v(mtVar.y.f8904a);
            f();
        }

        public boolean s() {
            this.f8828a++;
            if (!this.f8836t) {
                return false;
            }
            int i = this.f8831fb + 1;
            this.f8831fb = i;
            int[] iArr = this.f8834n3.f8884s;
            int i5 = this.f8835s;
            if (i != iArr[i5]) {
                return true;
            }
            this.f8835s = i5 + 1;
            this.f8831fb = 0;
            return false;
        }

        public void t(long j2) {
            int i = this.f8828a;
            while (true) {
                p pVar = this.f8834n3;
                if (i < pVar.f8875a && pVar.zn(i) <= j2) {
                    if (this.f8834n3.f8877f[i]) {
                        this.f8829c5 = i;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }

        public void tl() {
            w fb2 = fb();
            if (fb2 == null) {
                return;
            }
            rz rzVar = this.f8834n3.f8890xc;
            int i = fb2.f8900gv;
            if (i != 0) {
                rzVar.ut(i);
            }
            if (this.f8834n3.fb(this.f8828a)) {
                rzVar.ut(rzVar.yt() * 6);
            }
        }

        public long v() {
            if (!this.f8836t) {
                return this.f8832gv.f8846a[this.f8828a];
            }
            return this.f8834n3.zn(this.f8828a);
        }

        public void wz(DrmInitData drmInitData) {
            String str;
            w y = this.f8832gv.y.y(((zn) j5.i9(this.f8834n3.y)).y);
            if (y != null) {
                str = y.f8901n3;
            } else {
                str = null;
            }
            this.y.v(this.f8832gv.y.f8904a.n3().vl(drmInitData.zn(str)).z6());
        }

        public int zn() {
            int i;
            if (!this.f8836t) {
                i = this.f8832gv.f8847fb[this.f8828a];
            } else if (this.f8834n3.f8877f[this.f8828a]) {
                i = 1;
            } else {
                i = 0;
            }
            if (fb() != null) {
                return i | 1073741824;
            }
            return i;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f8839n3;
        public final long y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f8840zn;

        public y(long j2, boolean z2, int i) {
            this.y = j2;
            this.f8839n3 = z2;
            this.f8840zn = i;
        }
    }

    public fb() {
        this(0);
    }

    private void a8(long j2) throws ne {
        while (!this.f8819tl.isEmpty() && this.f8819tl.peek().f8916n3 == j2) {
            xc(this.f8819tl.pop());
        }
        fb();
    }

    public static void c(rz rzVar, int i, p pVar) throws ne {
        boolean z2;
        rzVar.oz(i + 8);
        int n32 = ha.y.n3(rzVar.p());
        if ((n32 & 1) == 0) {
            if ((n32 & 2) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            int b2 = rzVar.b();
            if (b2 == 0) {
                Arrays.fill(pVar.f8886tl, 0, pVar.f8875a, false);
                return;
            } else if (b2 == pVar.f8875a) {
                Arrays.fill(pVar.f8886tl, 0, b2, z2);
                pVar.gv(rzVar.y());
                pVar.n3(rzVar);
                return;
            } else {
                throw ne.y("Senc sample count " + b2 + " is different from fragment sample count" + pVar.f8875a, null);
            }
        }
        throw ne.s("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    @Nullable
    public static DrmInitData c5(List<y.n3> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            y.n3 n3Var = list.get(i);
            if (n3Var.y == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] v2 = n3Var.f8914n3.v();
                UUID a2 = t.a(v2);
                if (a2 == null) {
                    r.c5("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(a2, "video/mp4", v2));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    public static Pair<Integer, zn> d(rz rzVar) {
        rzVar.oz(12);
        return Pair.create(Integer.valueOf(rzVar.p()), new zn(rzVar.p() - 1, rzVar.p(), rzVar.p(), rzVar.p()));
    }

    public static void d0(rz rzVar, p pVar) throws ne {
        c(rzVar, 0, pVar);
    }

    public static void ej(y.C0106y c0106y, n3 n3Var, int i) throws ne {
        List<y.n3> list = c0106y.f8917zn;
        int size = list.size();
        int i5 = 0;
        int i6 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            y.n3 n3Var2 = list.get(i8);
            if (n3Var2.y == 1953658222) {
                rz rzVar = n3Var2.f8914n3;
                rzVar.oz(12);
                int b2 = rzVar.b();
                if (b2 > 0) {
                    i6 += b2;
                    i5++;
                }
            }
        }
        n3Var.f8835s = 0;
        n3Var.f8831fb = 0;
        n3Var.f8828a = 0;
        n3Var.f8834n3.v(i5, i6);
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            y.n3 n3Var3 = list.get(i12);
            if (n3Var3.y == 1953658222) {
                i11 = z6(n3Var, i10, i, n3Var3.f8914n3, i11);
                i10++;
            }
        }
    }

    public static void f3(w wVar, rz rzVar, p pVar) throws ne {
        int i;
        boolean z2;
        int i5 = wVar.f8900gv;
        rzVar.oz(8);
        boolean z3 = true;
        if ((ha.y.n3(rzVar.p()) & 1) == 1) {
            rzVar.ut(8);
        }
        int ej2 = rzVar.ej();
        int b2 = rzVar.b();
        if (b2 <= pVar.f8875a) {
            if (ej2 == 0) {
                boolean[] zArr = pVar.f8886tl;
                i = 0;
                for (int i6 = 0; i6 < b2; i6++) {
                    int ej3 = rzVar.ej();
                    i += ej3;
                    if (ej3 > i5) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zArr[i6] = z2;
                }
            } else {
                if (ej2 <= i5) {
                    z3 = false;
                }
                i = ej2 * b2;
                Arrays.fill(pVar.f8886tl, 0, b2, z3);
            }
            Arrays.fill(pVar.f8886tl, b2, pVar.f8875a, false);
            if (i > 0) {
                pVar.gv(i);
                return;
            }
            return;
        }
        throw ne.y("Saiz sample count " + b2 + " is greater than fragment sample count" + pVar.f8875a, null);
    }

    private void fb() {
        this.f8821w = 0;
        this.f8798co = 0;
    }

    public static Pair<Long, e4.gv> fh(rz rzVar, long j2) throws ne {
        long k52;
        long k53;
        rzVar.oz(8);
        int zn2 = ha.y.zn(rzVar.p());
        rzVar.ut(4);
        long a82 = rzVar.a8();
        if (zn2 == 0) {
            k52 = rzVar.a8();
            k53 = rzVar.a8();
        } else {
            k52 = rzVar.k5();
            k53 = rzVar.k5();
        }
        long j4 = k52;
        long j6 = j2 + k53;
        long x52 = j5.x5(j4, 1000000L, a82);
        rzVar.ut(2);
        int yt2 = rzVar.yt();
        int[] iArr = new int[yt2];
        long[] jArr = new long[yt2];
        long[] jArr2 = new long[yt2];
        long[] jArr3 = new long[yt2];
        long j7 = j4;
        long j8 = x52;
        int i = 0;
        while (i < yt2) {
            int p2 = rzVar.p();
            if ((p2 & Integer.MIN_VALUE) == 0) {
                long a83 = rzVar.a8();
                iArr[i] = p2 & Integer.MAX_VALUE;
                jArr[i] = j6;
                jArr3[i] = j8;
                long j9 = j7 + a83;
                long[] jArr4 = jArr2;
                long[] jArr5 = jArr3;
                int i5 = yt2;
                int[] iArr2 = iArr;
                long x53 = j5.x5(j9, 1000000L, a82);
                jArr4[i] = x53 - jArr5[i];
                rzVar.ut(4);
                j6 += iArr2[i];
                i++;
                iArr = iArr2;
                jArr3 = jArr5;
                jArr2 = jArr4;
                jArr = jArr;
                yt2 = i5;
                j7 = j9;
                j8 = x53;
            } else {
                throw ne.y("Unhandled indirect reference", null);
            }
        }
        return Pair.create(Long.valueOf(x52), new e4.gv(iArr, jArr, jArr2, jArr3));
    }

    public static int gv(int i) throws ne {
        if (i >= 0) {
            return i;
        }
        throw ne.y("Unexpected negative value: " + i, null);
    }

    private static boolean hw(int i) {
        if (i != 1751411826 && i != 1835296868 && i != 1836476516 && i != 1936286840 && i != 1937011556 && i != 1937011827 && i != 1668576371 && i != 1937011555 && i != 1937011578 && i != 1937013298 && i != 1937007471 && i != 1668232756 && i != 1937011571 && i != 1952867444 && i != 1952868452 && i != 1953196132 && i != 1953654136 && i != 1953658222 && i != 1886614376 && i != 1935763834 && i != 1935763823 && i != 1936027235 && i != 1970628964 && i != 1935828848 && i != 1936158820 && i != 1701606260 && i != 1835362404 && i != 1701671783) {
            return false;
        }
        return true;
    }

    public static void i4(rz rzVar, p pVar) throws ne {
        long k52;
        rzVar.oz(8);
        int p2 = rzVar.p();
        if ((ha.y.n3(p2) & 1) == 1) {
            rzVar.ut(8);
        }
        int b2 = rzVar.b();
        if (b2 == 1) {
            int zn2 = ha.y.zn(p2);
            long j2 = pVar.f8879gv;
            if (zn2 == 0) {
                k52 = rzVar.a8();
            } else {
                k52 = rzVar.k5();
            }
            pVar.f8879gv = j2 + k52;
            return;
        }
        throw ne.y("Unexpected saio entry count: " + b2, null);
    }

    @Nullable
    public static n3 i9(SparseArray<n3> sparseArray) {
        int size = sparseArray.size();
        n3 n3Var = null;
        long j2 = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            n3 valueAt = sparseArray.valueAt(i);
            if ((valueAt.f8836t || valueAt.f8828a != valueAt.f8832gv.f8849n3) && (!valueAt.f8836t || valueAt.f8835s != valueAt.f8834n3.f8887v)) {
                long gv2 = valueAt.gv();
                if (gv2 < j2) {
                    n3Var = valueAt;
                    j2 = gv2;
                }
            }
        }
        return n3Var;
    }

    @Nullable
    public static n3 mg(rz rzVar, SparseArray<n3> sparseArray, boolean z2) {
        n3 n3Var;
        int i;
        int i5;
        int i6;
        int i8;
        rzVar.oz(8);
        int n32 = ha.y.n3(rzVar.p());
        int p2 = rzVar.p();
        if (z2) {
            n3Var = sparseArray.valueAt(0);
        } else {
            n3Var = sparseArray.get(p2);
        }
        n3 n3Var2 = n3Var;
        if (n3Var2 == null) {
            return null;
        }
        if ((n32 & 1) != 0) {
            long k52 = rzVar.k5();
            p pVar = n3Var2.f8834n3;
            pVar.f8891zn = k52;
            pVar.f8879gv = k52;
        }
        zn znVar = n3Var2.f8837v;
        if ((n32 & 2) != 0) {
            i = rzVar.p() - 1;
        } else {
            i = znVar.y;
        }
        if ((n32 & 8) != 0) {
            i5 = rzVar.p();
        } else {
            i5 = znVar.f8919n3;
        }
        if ((n32 & 16) != 0) {
            i6 = rzVar.p();
        } else {
            i6 = znVar.f8920zn;
        }
        if ((n32 & 32) != 0) {
            i8 = rzVar.p();
        } else {
            i8 = znVar.f8918gv;
        }
        n3Var2.f8834n3.y = new zn(i, i5, i6, i8);
        return n3Var2;
    }

    public static void n(y.C0106y c0106y, @Nullable String str, p pVar) throws ne {
        boolean z2;
        byte[] bArr = null;
        rz rzVar = null;
        rz rzVar2 = null;
        for (int i = 0; i < c0106y.f8917zn.size(); i++) {
            y.n3 n3Var = c0106y.f8917zn.get(i);
            rz rzVar3 = n3Var.f8914n3;
            int i5 = n3Var.y;
            if (i5 == 1935828848) {
                rzVar3.oz(12);
                if (rzVar3.p() == 1936025959) {
                    rzVar = rzVar3;
                }
            } else if (i5 == 1936158820) {
                rzVar3.oz(12);
                if (rzVar3.p() == 1936025959) {
                    rzVar2 = rzVar3;
                }
            }
        }
        if (rzVar != null && rzVar2 != null) {
            rzVar.oz(8);
            int zn2 = ha.y.zn(rzVar.p());
            rzVar.ut(4);
            if (zn2 == 1) {
                rzVar.ut(4);
            }
            if (rzVar.p() == 1) {
                rzVar2.oz(8);
                int zn3 = ha.y.zn(rzVar2.p());
                rzVar2.ut(4);
                if (zn3 == 1) {
                    if (rzVar2.a8() == 0) {
                        throw ne.s("Variable length description in sgpd found (unsupported)");
                    }
                } else if (zn3 >= 2) {
                    rzVar2.ut(4);
                }
                if (rzVar2.a8() == 1) {
                    rzVar2.ut(1);
                    int ej2 = rzVar2.ej();
                    int i6 = (ej2 & 240) >> 4;
                    int i8 = ej2 & 15;
                    if (rzVar2.ej() == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        return;
                    }
                    int ej3 = rzVar2.ej();
                    byte[] bArr2 = new byte[16];
                    rzVar2.t(bArr2, 0, 16);
                    if (ej3 == 0) {
                        int ej4 = rzVar2.ej();
                        bArr = new byte[ej4];
                        rzVar2.t(bArr, 0, ej4);
                    }
                    pVar.f8885t = true;
                    pVar.f8889wz = new w(z2, str, ej3, bArr2, i6, i8, bArr);
                    return;
                }
                throw ne.s("Entry count in sgpd != 1 (unsupported).");
            }
            throw ne.s("Entry count in sbgp != 1 (unsupported).");
        }
    }

    public static long r(rz rzVar) {
        rzVar.oz(8);
        if (ha.y.zn(rzVar.p()) == 0) {
            return rzVar.a8();
        }
        return rzVar.k5();
    }

    public static long rz(rz rzVar) {
        rzVar.oz(8);
        if (ha.y.zn(rzVar.p()) == 1) {
            return rzVar.k5();
        }
        return rzVar.a8();
    }

    public static boolean t(xc xcVar) {
        long[] jArr;
        long[] jArr2 = xcVar.f8911s;
        if (jArr2 == null || jArr2.length != 1 || (jArr = xcVar.f8905c5) == null) {
            return false;
        }
        long j2 = jArr2[0];
        if (j2 != 0 && j5.x5(j2 + jArr[0], 1000000L, xcVar.f8908gv) < xcVar.f8912v) {
            return false;
        }
        return true;
    }

    public static void ta(y.C0106y c0106y, SparseArray<n3> sparseArray, boolean z2, int i, byte[] bArr) throws ne {
        String str;
        n3 mg2 = mg(((y.n3) v5.y.v(c0106y.fb(1952868452))).f8914n3, sparseArray, z2);
        if (mg2 == null) {
            return;
        }
        p pVar = mg2.f8834n3;
        long j2 = pVar.f8883p;
        boolean z3 = pVar.f8881mt;
        mg2.f();
        mg2.f8836t = true;
        y.n3 fb2 = c0106y.fb(1952867444);
        if (fb2 != null && (i & 2) == 0) {
            pVar.f8883p = rz(fb2.f8914n3);
            pVar.f8881mt = true;
        } else {
            pVar.f8883p = j2;
            pVar.f8881mt = z3;
        }
        ej(c0106y, mg2, i);
        w y2 = mg2.f8832gv.y.y(((zn) v5.y.v(pVar.y)).y);
        y.n3 fb3 = c0106y.fb(1935763834);
        if (fb3 != null) {
            f3((w) v5.y.v(y2), fb3.f8914n3, pVar);
        }
        y.n3 fb4 = c0106y.fb(1935763823);
        if (fb4 != null) {
            i4(fb4.f8914n3, pVar);
        }
        y.n3 fb5 = c0106y.fb(1936027235);
        if (fb5 != null) {
            d0(fb5.f8914n3, pVar);
        }
        if (y2 != null) {
            str = y2.f8901n3;
        } else {
            str = null;
        }
        n(c0106y, str, pVar);
        int size = c0106y.f8917zn.size();
        for (int i5 = 0; i5 < size; i5++) {
            y.n3 n3Var = c0106y.f8917zn.get(i5);
            if (n3Var.y == 1970628964) {
                ud(n3Var.f8914n3, pVar, bArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e4.t[] tl() {
        return new e4.t[]{new fb()};
    }

    public static void ud(rz rzVar, p pVar, byte[] bArr) throws ne {
        rzVar.oz(8);
        rzVar.t(bArr, 0, 16);
        if (!Arrays.equals(bArr, f8792a8)) {
            return;
        }
        c(rzVar, 16, pVar);
    }

    private static boolean vl(int i) {
        if (i != 1836019574 && i != 1953653099 && i != 1835297121 && i != 1835626086 && i != 1937007212 && i != 1836019558 && i != 1953653094 && i != 1836475768 && i != 1701082227) {
            return false;
        }
        return true;
    }

    private boolean x(e4.tl tlVar) throws IOException {
        if (this.f8798co == 0) {
            if (!tlVar.f(this.f8817t.v(), 0, 8, true)) {
                return false;
            }
            this.f8798co = 8;
            this.f8817t.oz(0);
            this.f8810mt = this.f8817t.a8();
            this.f8813p = this.f8817t.p();
        }
        long j2 = this.f8810mt;
        if (j2 == 1) {
            tlVar.readFully(this.f8817t.v(), 8, 8);
            this.f8798co += 8;
            this.f8810mt = this.f8817t.k5();
        } else if (j2 == 0) {
            long length = tlVar.getLength();
            if (length == -1 && !this.f8819tl.isEmpty()) {
                length = this.f8819tl.peek().f8916n3;
            }
            if (length != -1) {
                this.f8810mt = (length - tlVar.getPosition()) + this.f8798co;
            }
        }
        if (this.f8810mt >= this.f8798co) {
            long position = tlVar.getPosition() - this.f8798co;
            int i = this.f8813p;
            if ((i == 1836019558 || i == 1835295092) && !this.f8801ej) {
                this.f8818ta.t(new fh.n3(this.f8803f3, position));
                this.f8801ej = true;
            }
            if (this.f8813p == 1836019558) {
                int size = this.f8806gv.size();
                for (int i5 = 0; i5 < size; i5++) {
                    p pVar = this.f8806gv.valueAt(i5).f8834n3;
                    pVar.f8882n3 = position;
                    pVar.f8879gv = position;
                    pVar.f8891zn = position;
                }
            }
            int i6 = this.f8813p;
            if (i6 == 1835295092) {
                this.f8796c = null;
                this.f8814r = position + this.f8810mt;
                this.f8821w = 2;
                return true;
            }
            if (vl(i6)) {
                long position2 = (tlVar.getPosition() + this.f8810mt) - 8;
                this.f8819tl.push(new y.C0106y(this.f8813p, position2));
                if (this.f8810mt == this.f8798co) {
                    a8(position2);
                } else {
                    fb();
                }
            } else if (hw(this.f8813p)) {
                if (this.f8798co == 8) {
                    if (this.f8810mt <= 2147483647L) {
                        rz rzVar = new rz((int) this.f8810mt);
                        System.arraycopy(this.f8817t.v(), 0, rzVar.v(), 0, 8);
                        this.f8825z = rzVar;
                        this.f8821w = 1;
                    } else {
                        throw ne.s("Leaf atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw ne.s("Leaf atom defines extended atom size (unsupported).");
                }
            } else if (this.f8810mt <= 2147483647L) {
                this.f8825z = null;
                this.f8821w = 1;
            } else {
                throw ne.s("Skipping atom with length > 2147483647 (unsupported).");
            }
            return true;
        }
        throw ne.s("Atom size less than header length (unsupported).");
    }

    public static void x4(y.C0106y c0106y, SparseArray<n3> sparseArray, boolean z2, int i, byte[] bArr) throws ne {
        int size = c0106y.f8915gv.size();
        for (int i5 = 0; i5 < size; i5++) {
            y.C0106y c0106y2 = c0106y.f8915gv.get(i5);
            if (c0106y2.y == 1953653094) {
                ta(c0106y2, sparseArray, z2, i, bArr);
            }
        }
    }

    public static int z6(n3 n3Var, int i, int i5, rz rzVar, int i6) throws ne {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        long j2;
        boolean z8;
        int i8;
        boolean z9;
        int i10;
        boolean z10;
        int i11;
        boolean z11;
        boolean z12;
        boolean z13;
        int i12;
        boolean z14;
        n3 n3Var2 = n3Var;
        rzVar.oz(8);
        int n32 = ha.y.n3(rzVar.p());
        xc xcVar = n3Var2.f8832gv.y;
        p pVar = n3Var2.f8834n3;
        zn znVar = (zn) j5.i9(pVar.y);
        pVar.f8884s[i] = rzVar.b();
        long[] jArr = pVar.f8878fb;
        long j4 = pVar.f8891zn;
        jArr[i] = j4;
        if ((n32 & 1) != 0) {
            jArr[i] = j4 + rzVar.p();
        }
        if ((n32 & 4) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i13 = znVar.f8918gv;
        if (z2) {
            i13 = rzVar.p();
        }
        if ((n32 & 256) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((n32 & 512) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if ((n32 & 1024) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if ((n32 & 2048) != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (t(xcVar)) {
            j2 = ((long[]) j5.i9(xcVar.f8905c5))[0];
        } else {
            j2 = 0;
        }
        int[] iArr = pVar.f8876c5;
        long[] jArr2 = pVar.f8880i9;
        boolean[] zArr = pVar.f8877f;
        int i14 = i13;
        if (xcVar.f8910n3 == 2 && (i5 & 1) != 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        int i15 = i6 + pVar.f8884s[i];
        boolean z15 = z8;
        long j6 = xcVar.f8913zn;
        long j7 = pVar.f8883p;
        int i16 = i6;
        while (i16 < i15) {
            if (z3) {
                i8 = rzVar.p();
            } else {
                i8 = znVar.f8919n3;
            }
            int gv2 = gv(i8);
            if (z4) {
                i10 = rzVar.p();
                z9 = z3;
            } else {
                z9 = z3;
                i10 = znVar.f8920zn;
            }
            int gv3 = gv(i10);
            if (z5) {
                z10 = z2;
                i11 = rzVar.p();
            } else if (i16 == 0 && z2) {
                z10 = z2;
                i11 = i14;
            } else {
                z10 = z2;
                i11 = znVar.f8918gv;
            }
            if (z7) {
                z11 = z7;
                z12 = z4;
                z13 = z5;
                i12 = rzVar.p();
            } else {
                z11 = z7;
                z12 = z4;
                z13 = z5;
                i12 = 0;
            }
            long x52 = j5.x5((i12 + j7) - j2, 1000000L, j6);
            jArr2[i16] = x52;
            if (!pVar.f8881mt) {
                jArr2[i16] = x52 + n3Var2.f8832gv.f8850s;
            }
            iArr[i16] = gv3;
            if (((i11 >> 16) & 1) == 0 && (!z15 || i16 == 0)) {
                z14 = true;
            } else {
                z14 = false;
            }
            zArr[i16] = z14;
            j7 += gv2;
            i16++;
            n3Var2 = n3Var;
            z3 = z9;
            z2 = z10;
            z7 = z11;
            z4 = z12;
            z5 = z13;
        }
        pVar.f8883p = j7;
        return i15;
    }

    @Override // e4.t
    public boolean a(e4.tl tlVar) throws IOException {
        return wz.n3(tlVar);
    }

    public final void b(e4.tl tlVar) throws IOException {
        int i = ((int) this.f8810mt) - this.f8798co;
        rz rzVar = this.f8825z;
        if (rzVar != null) {
            tlVar.readFully(rzVar.v(), 8, i);
            p(new y.n3(this.f8813p, rzVar), tlVar.getPosition());
        } else {
            tlVar.p(i);
        }
        a8(tlVar.getPosition());
    }

    public final void co(y.C0106y c0106y) throws ne {
        boolean z2;
        boolean z3;
        int i = 0;
        boolean z4 = true;
        if (this.f8812n3 == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.s(z2, "Unexpected moov box.");
        DrmInitData c52 = c5(c0106y.f8917zn);
        y.C0106y c0106y2 = (y.C0106y) v5.y.v(c0106y.a(1836475768));
        SparseArray<zn> sparseArray = new SparseArray<>();
        int size = c0106y2.f8917zn.size();
        long j2 = -9223372036854775807L;
        for (int i5 = 0; i5 < size; i5++) {
            y.n3 n3Var = c0106y2.f8917zn.get(i5);
            int i6 = n3Var.y;
            if (i6 == 1953654136) {
                Pair<Integer, zn> d2 = d(n3Var.f8914n3);
                sparseArray.put(((Integer) d2.first).intValue(), (zn) d2.second);
            } else if (i6 == 1835362404) {
                j2 = r(n3Var.f8914n3);
            }
        }
        f3 f3Var = new f3();
        if ((this.y & 16) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        List<mt> d02 = ha.n3.d0(c0106y, f3Var, j2, c52, z3, false, new w0.fb() { // from class: ha.a
            @Override // w0.fb
            public final Object apply(Object obj) {
                return fb.this.wz((xc) obj);
            }
        });
        int size2 = d02.size();
        if (this.f8806gv.size() == 0) {
            while (i < size2) {
                mt mtVar = d02.get(i);
                xc xcVar = mtVar.y;
                this.f8806gv.put(xcVar.y, new n3(this.f8818ta.a(i, xcVar.f8910n3), mtVar, s(sparseArray, xcVar.y)));
                this.f8803f3 = Math.max(this.f8803f3, xcVar.f8912v);
                i++;
            }
            this.f8818ta.xc();
            return;
        }
        if (this.f8806gv.size() != size2) {
            z4 = false;
        }
        v5.y.fb(z4);
        while (i < size2) {
            mt mtVar2 = d02.get(i);
            xc xcVar2 = mtVar2.y;
            this.f8806gv.get(xcVar2.y).i9(mtVar2, s(sparseArray, xcVar2.y));
            i++;
        }
    }

    public final void f() {
        int i;
        ta[] taVarArr = new ta[2];
        this.f8799d = taVarArr;
        ta taVar = this.f8824xc;
        int i5 = 0;
        if (taVar != null) {
            taVarArr[0] = taVar;
            i = 1;
        } else {
            i = 0;
        }
        int i6 = 100;
        if ((this.y & 4) != 0) {
            taVarArr[i] = this.f8818ta.a(100, 5);
            i6 = 101;
            i++;
        }
        ta[] taVarArr2 = (ta[]) j5.qj(this.f8799d, i);
        this.f8799d = taVarArr2;
        for (ta taVar2 : taVarArr2) {
            taVar2.v(f8794x);
        }
        this.f8826z6 = new ta[this.f8827zn.size()];
        while (i5 < this.f8826z6.length) {
            ta a2 = this.f8818ta.a(i6, 3);
            a2.v(this.f8827zn.get(i5));
            this.f8826z6[i5] = a2;
            i5++;
            i6++;
        }
    }

    public final void k5(e4.tl tlVar) throws IOException {
        int size = this.f8806gv.size();
        long j2 = Long.MAX_VALUE;
        n3 n3Var = null;
        for (int i = 0; i < size; i++) {
            p pVar = this.f8806gv.valueAt(i).f8834n3;
            if (pVar.f8888w) {
                long j4 = pVar.f8879gv;
                if (j4 < j2) {
                    n3Var = this.f8806gv.valueAt(i);
                    j2 = j4;
                }
            }
        }
        if (n3Var == null) {
            this.f8821w = 3;
            return;
        }
        int position = (int) (j2 - tlVar.getPosition());
        if (position >= 0) {
            tlVar.p(position);
            n3Var.f8834n3.y(tlVar);
            return;
        }
        throw ne.y("Offset to encryption data was negative.", null);
    }

    public final void mt(y.C0106y c0106y) throws ne {
        boolean z2;
        SparseArray<n3> sparseArray = this.f8806gv;
        if (this.f8812n3 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        x4(c0106y, sparseArray, z2, this.y, this.f8816s);
        DrmInitData c52 = c5(c0106y.f8917zn);
        if (c52 != null) {
            int size = this.f8806gv.size();
            for (int i = 0; i < size; i++) {
                this.f8806gv.valueAt(i).wz(c52);
            }
        }
        if (this.f8807i4 != -9223372036854775807L) {
            int size2 = this.f8806gv.size();
            for (int i5 = 0; i5 < size2; i5++) {
                this.f8806gv.valueAt(i5).t(this.f8807i4);
            }
            this.f8807i4 = -9223372036854775807L;
        }
    }

    public final void p(y.n3 n3Var, long j2) throws ne {
        if (!this.f8819tl.isEmpty()) {
            this.f8819tl.peek().v(n3Var);
            return;
        }
        int i = n3Var.y;
        if (i == 1936286840) {
            Pair<Long, e4.gv> fh2 = fh(n3Var.f8914n3, j2);
            this.f8811n = ((Long) fh2.first).longValue();
            this.f8818ta.t((fh) fh2.second);
            this.f8801ej = true;
        } else if (i == 1701671783) {
            w(n3Var.f8914n3);
        }
    }

    public final zn s(SparseArray<zn> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (zn) v5.y.v(sparseArray.get(i));
    }

    @Override // e4.t
    public int v(e4.tl tlVar, d0 d0Var) throws IOException {
        while (true) {
            int i = this.f8821w;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (yt(tlVar)) {
                            return 0;
                        }
                    } else {
                        k5(tlVar);
                    }
                } else {
                    b(tlVar);
                }
            } else if (!x(tlVar)) {
                return -1;
            }
        }
    }

    public final void w(rz rzVar) {
        long x52;
        long j2;
        String str;
        long x53;
        String str2;
        long a82;
        long j4;
        ta[] taVarArr;
        if (this.f8799d.length == 0) {
            return;
        }
        rzVar.oz(8);
        int zn2 = ha.y.zn(rzVar.p());
        if (zn2 != 0) {
            if (zn2 != 1) {
                r.c5("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + zn2);
                return;
            }
            long a83 = rzVar.a8();
            j4 = j5.x5(rzVar.k5(), 1000000L, a83);
            long x54 = j5.x5(rzVar.a8(), 1000L, a83);
            long a84 = rzVar.a8();
            str = (String) v5.y.v(rzVar.fh());
            x53 = x54;
            a82 = a84;
            str2 = (String) v5.y.v(rzVar.fh());
            x52 = -9223372036854775807L;
        } else {
            String str3 = (String) v5.y.v(rzVar.fh());
            String str4 = (String) v5.y.v(rzVar.fh());
            long a85 = rzVar.a8();
            x52 = j5.x5(rzVar.a8(), 1000000L, a85);
            long j6 = this.f8811n;
            if (j6 != -9223372036854775807L) {
                j2 = j6 + x52;
            } else {
                j2 = -9223372036854775807L;
            }
            str = str3;
            x53 = j5.x5(rzVar.a8(), 1000L, a85);
            str2 = str4;
            a82 = rzVar.a8();
            j4 = j2;
        }
        byte[] bArr = new byte[rzVar.y()];
        rzVar.t(bArr, 0, rzVar.y());
        rz rzVar2 = new rz(this.f8802f.y(new EventMessage(str, str2, x53, a82, bArr)));
        int y2 = rzVar2.y();
        for (ta taVar : this.f8799d) {
            rzVar2.oz(0);
            taVar.zn(rzVar2, y2);
        }
        if (j4 == -9223372036854775807L) {
            this.f8822wz.addLast(new y(x52, true, y2));
            this.f8823x4 += y2;
        } else if (!this.f8822wz.isEmpty()) {
            this.f8822wz.addLast(new y(j4, false, y2));
            this.f8823x4 += y2;
        } else {
            k5 k5Var = this.f8808i9;
            if (k5Var != null) {
                j4 = k5Var.y(j4);
            }
            for (ta taVar2 : this.f8799d) {
                taVar2.gv(j4, 1, y2, 0, null);
            }
        }
    }

    public final void xc(y.C0106y c0106y) throws ne {
        int i = c0106y.y;
        if (i == 1836019574) {
            co(c0106y);
        } else if (i == 1836019558) {
            mt(c0106y);
        } else if (!this.f8819tl.isEmpty()) {
            this.f8819tl.peek().gv(c0106y);
        }
    }

    @Override // e4.t
    public void y(long j2, long j4) {
        int size = this.f8806gv.size();
        for (int i = 0; i < size; i++) {
            this.f8806gv.valueAt(i).f();
        }
        this.f8822wz.clear();
        this.f8823x4 = 0;
        this.f8807i4 = j4;
        this.f8819tl.clear();
        fb();
    }

    public final boolean yt(e4.tl tlVar) throws IOException {
        ta.y yVar;
        boolean z2;
        int n32;
        n3 n3Var = this.f8796c;
        Throwable th = null;
        if (n3Var == null) {
            n3Var = i9(this.f8806gv);
            if (n3Var == null) {
                int position = (int) (this.f8814r - tlVar.getPosition());
                if (position >= 0) {
                    tlVar.p(position);
                    fb();
                    return false;
                }
                throw ne.y("Offset to end of mdat was negative.", null);
            }
            int gv2 = (int) (n3Var.gv() - tlVar.getPosition());
            if (gv2 < 0) {
                r.c5("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                gv2 = 0;
            }
            tlVar.p(gv2);
            this.f8796c = n3Var;
        }
        int i = 4;
        int i5 = 1;
        if (this.f8821w == 3) {
            int a2 = n3Var.a();
            this.f8800d0 = a2;
            if (n3Var.f8828a < n3Var.f8829c5) {
                tlVar.p(a2);
                n3Var.tl();
                if (!n3Var.s()) {
                    this.f8796c = null;
                }
                this.f8821w = 3;
                return true;
            }
            if (n3Var.f8832gv.y.f8907fb == 1) {
                this.f8800d0 = a2 - 8;
                tlVar.p(8);
            }
            if ("audio/ac4".equals(n3Var.f8832gv.y.f8904a.f10948f3)) {
                this.f8805fh = n3Var.c5(this.f8800d0, 7);
                d9.zn.y(this.f8800d0, this.f8797c5);
                n3Var.y.zn(this.f8797c5, 7);
                this.f8805fh += 7;
            } else {
                this.f8805fh = n3Var.c5(this.f8800d0, 0);
            }
            this.f8800d0 += this.f8805fh;
            this.f8821w = 4;
            this.f8815rz = 0;
        }
        xc xcVar = n3Var.f8832gv.y;
        ta taVar = n3Var.y;
        long v2 = n3Var.v();
        k5 k5Var = this.f8808i9;
        if (k5Var != null) {
            v2 = k5Var.y(v2);
        }
        long j2 = v2;
        if (xcVar.f8909i9 == 0) {
            while (true) {
                int i6 = this.f8805fh;
                int i8 = this.f8800d0;
                if (i6 >= i8) {
                    break;
                }
                this.f8805fh += taVar.n3(tlVar, i8 - i6, false);
            }
        } else {
            byte[] v3 = this.f8795a.v();
            v3[0] = 0;
            v3[1] = 0;
            v3[2] = 0;
            int i10 = xcVar.f8909i9;
            int i11 = i10 + 1;
            int i12 = 4 - i10;
            while (this.f8805fh < this.f8800d0) {
                int i13 = this.f8815rz;
                if (i13 == 0) {
                    tlVar.readFully(v3, i12, i11);
                    this.f8795a.oz(0);
                    int p2 = this.f8795a.p();
                    if (p2 >= i5) {
                        this.f8815rz = p2 - 1;
                        this.f8820v.oz(0);
                        taVar.zn(this.f8820v, i);
                        taVar.zn(this.f8795a, i5);
                        if (this.f8826z6.length > 0 && c.fb(xcVar.f8904a.f10948f3, v3[i])) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.f8809mg = z2;
                        this.f8805fh += 5;
                        this.f8800d0 += i12;
                    } else {
                        throw ne.y("Invalid NAL length", th);
                    }
                } else {
                    if (this.f8809mg) {
                        this.f8804fb.j5(i13);
                        tlVar.readFully(this.f8804fb.v(), 0, this.f8815rz);
                        taVar.zn(this.f8804fb, this.f8815rz);
                        n32 = this.f8815rz;
                        int p3 = c.p(this.f8804fb.v(), this.f8804fb.fb());
                        this.f8804fb.oz("video/hevc".equals(xcVar.f8904a.f10948f3) ? 1 : 0);
                        this.f8804fb.j(p3);
                        e4.zn.y(j2, this.f8804fb, this.f8826z6);
                    } else {
                        n32 = taVar.n3(tlVar, i13, false);
                    }
                    this.f8805fh += n32;
                    this.f8815rz -= n32;
                    th = null;
                    i = 4;
                    i5 = 1;
                }
            }
        }
        int zn2 = n3Var.zn();
        w fb2 = n3Var.fb();
        if (fb2 != null) {
            yVar = fb2.f8903zn;
        } else {
            yVar = null;
        }
        taVar.gv(j2, zn2, this.f8800d0, 0, yVar);
        z(j2);
        if (!n3Var.s()) {
            this.f8796c = null;
        }
        this.f8821w = 3;
        return true;
    }

    public final void z(long j2) {
        while (!this.f8822wz.isEmpty()) {
            y removeFirst = this.f8822wz.removeFirst();
            this.f8823x4 -= removeFirst.f8840zn;
            long j4 = removeFirst.y;
            if (removeFirst.f8839n3) {
                j4 += j2;
            }
            k5 k5Var = this.f8808i9;
            if (k5Var != null) {
                j4 = k5Var.y(j4);
            }
            for (ta taVar : this.f8799d) {
                taVar.gv(j4, 1, removeFirst.f8840zn, this.f8823x4, null);
            }
        }
    }

    @Override // e4.t
    public void zn(e4.wz wzVar) {
        this.f8818ta = wzVar;
        fb();
        f();
        xc xcVar = this.f8812n3;
        if (xcVar != null) {
            this.f8806gv.put(0, new n3(wzVar.a(0, xcVar.f8910n3), new mt(this.f8812n3, new long[0], new int[0], 0, new long[0], new int[0], 0L), new zn(0, 0, 0, 0)));
            this.f8818ta.xc();
        }
    }

    public fb(int i) {
        this(i, null);
    }

    public fb(int i, @Nullable k5 k5Var) {
        this(i, k5Var, null, Collections.emptyList());
    }

    public fb(int i, @Nullable k5 k5Var, @Nullable xc xcVar) {
        this(i, k5Var, xcVar, Collections.emptyList());
    }

    public fb(int i, @Nullable k5 k5Var, @Nullable xc xcVar, List<m> list) {
        this(i, k5Var, xcVar, list, null);
    }

    public fb(int i, @Nullable k5 k5Var, @Nullable xc xcVar, List<m> list, @Nullable ta taVar) {
        this.y = i;
        this.f8808i9 = k5Var;
        this.f8812n3 = xcVar;
        this.f8827zn = Collections.unmodifiableList(list);
        this.f8824xc = taVar;
        this.f8802f = new f5.n3();
        this.f8817t = new rz(16);
        this.f8820v = new rz(c.y);
        this.f8795a = new rz(5);
        this.f8804fb = new rz();
        byte[] bArr = new byte[16];
        this.f8816s = bArr;
        this.f8797c5 = new rz(bArr);
        this.f8819tl = new ArrayDeque<>();
        this.f8822wz = new ArrayDeque<>();
        this.f8806gv = new SparseArray<>();
        this.f8803f3 = -9223372036854775807L;
        this.f8807i4 = -9223372036854775807L;
        this.f8811n = -9223372036854775807L;
        this.f8818ta = e4.wz.f7522zn;
        this.f8799d = new ta[0];
        this.f8826z6 = new ta[0];
    }

    @Override // e4.t
    public void release() {
    }

    @Nullable
    public xc wz(@Nullable xc xcVar) {
        return xcVar;
    }
}
