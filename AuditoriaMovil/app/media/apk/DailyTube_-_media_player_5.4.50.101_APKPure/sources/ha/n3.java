package ha;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import e4.f3;
import ha.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import m1.m;
import m1.ne;
import v5.j5;
import v5.n;
import v5.r;
import v5.rz;
import z0.x4;
/* loaded from: classes.dex */
public final class n3 {
    public static final byte[] y = j5.ap("OpusHead");

    /* loaded from: classes.dex */
    public static final class a implements zn {

        /* renamed from: gv  reason: collision with root package name */
        public int f8853gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f8854n3;

        /* renamed from: v  reason: collision with root package name */
        public int f8855v;
        public final rz y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f8856zn;

        public a(y.n3 n3Var) {
            rz rzVar = n3Var.f8914n3;
            this.y = rzVar;
            rzVar.oz(12);
            this.f8856zn = rzVar.b() & 255;
            this.f8854n3 = rzVar.b();
        }

        @Override // ha.n3.zn
        public int n3() {
            return -1;
        }

        @Override // ha.n3.zn
        public int y() {
            int i = this.f8856zn;
            if (i == 8) {
                return this.y.ej();
            }
            if (i == 16) {
                return this.y.yt();
            }
            int i5 = this.f8853gv;
            this.f8853gv = i5 + 1;
            if (i5 % 2 == 0) {
                int ej2 = this.y.ej();
                this.f8855v = ej2;
                return (ej2 & 240) >> 4;
            }
            return this.f8855v & 15;
        }

        @Override // ha.n3.zn
        public int zn() {
            return this.f8854n3;
        }
    }

    /* loaded from: classes.dex */
    public static final class fb {

        /* renamed from: n3  reason: collision with root package name */
        public final long f8857n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f8858zn;

        public fb(int i, long j2, int i5) {
            this.y = i;
            this.f8857n3 = j2;
            this.f8858zn = i5;
        }
    }

    /* loaded from: classes.dex */
    public static final class gv {

        /* renamed from: gv  reason: collision with root package name */
        public int f8859gv;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public m f8860n3;
        public final w[] y;

        /* renamed from: zn  reason: collision with root package name */
        public int f8861zn;

        public gv(int i) {
            this.y = new w[i];
        }
    }

    /* renamed from: ha.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0105n3 {

        /* renamed from: gv  reason: collision with root package name */
        public final long f8862gv;

        /* renamed from: n3  reason: collision with root package name */
        public final byte[] f8863n3;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final long f8864zn;

        public C0105n3(String str, byte[] bArr, long j2, long j4) {
            this.y = str;
            this.f8863n3 = bArr;
            this.f8864zn = j2;
            this.f8862gv = j4;
        }
    }

    /* loaded from: classes.dex */
    public static final class v implements zn {

        /* renamed from: n3  reason: collision with root package name */
        public final int f8865n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final rz f8866zn;

        public v(y.n3 n3Var, m mVar) {
            rz rzVar = n3Var.f8914n3;
            this.f8866zn = rzVar;
            rzVar.oz(12);
            int b2 = rzVar.b();
            if ("audio/raw".equals(mVar.f10948f3)) {
                int ct2 = j5.ct(mVar.f10960q9, mVar.f10958oz);
                if (b2 == 0 || b2 % ct2 != 0) {
                    r.c5("AtomParsers", "Audio sample size mismatch. stsd sample size: " + ct2 + ", stsz sample size: " + b2);
                    b2 = ct2;
                }
            }
            this.y = b2 == 0 ? -1 : b2;
            this.f8865n3 = rzVar.b();
        }

        @Override // ha.n3.zn
        public int n3() {
            return this.y;
        }

        @Override // ha.n3.zn
        public int y() {
            int i = this.y;
            if (i == -1) {
                return this.f8866zn.b();
            }
            return i;
        }

        @Override // ha.n3.zn
        public int zn() {
            return this.f8865n3;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        public final rz f8867a;

        /* renamed from: c5  reason: collision with root package name */
        public int f8868c5;

        /* renamed from: fb  reason: collision with root package name */
        public final rz f8869fb;

        /* renamed from: gv  reason: collision with root package name */
        public long f8870gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f8871n3;

        /* renamed from: s  reason: collision with root package name */
        public int f8872s;

        /* renamed from: v  reason: collision with root package name */
        public final boolean f8873v;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public int f8874zn;

        public y(rz rzVar, rz rzVar2, boolean z2) throws ne {
            this.f8869fb = rzVar;
            this.f8867a = rzVar2;
            this.f8873v = z2;
            rzVar2.oz(12);
            this.y = rzVar2.b();
            rzVar.oz(12);
            this.f8868c5 = rzVar.b();
            e4.xc.y(rzVar.p() == 1, "first_chunk must be 1");
            this.f8871n3 = -1;
        }

        public boolean y() {
            long a82;
            int i;
            int i5 = this.f8871n3 + 1;
            this.f8871n3 = i5;
            if (i5 == this.y) {
                return false;
            }
            if (this.f8873v) {
                a82 = this.f8867a.k5();
            } else {
                a82 = this.f8867a.a8();
            }
            this.f8870gv = a82;
            if (this.f8871n3 == this.f8872s) {
                this.f8874zn = this.f8869fb.b();
                this.f8869fb.ut(4);
                int i6 = this.f8868c5 - 1;
                this.f8868c5 = i6;
                if (i6 > 0) {
                    i = this.f8869fb.b() - 1;
                } else {
                    i = -1;
                }
                this.f8872s = i;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        int n3();

        int y();

        int zn();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(v5.rz r22, int r23, int r24, int r25, int r26, java.lang.String r27, boolean r28, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData r29, ha.n3.gv r30, int r31) throws m1.ne {
        /*
            Method dump skipped, instructions count: 877
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ha.n3.a(v5.rz, int, int, int, int, java.lang.String, boolean, com.google.android.exoplayer2.drm.DrmInitData, ha.n3$gv, int):void");
    }

    @Nullable
    public static xc c(y.C0106y c0106y, y.n3 n3Var, long j2, @Nullable DrmInitData drmInitData, boolean z2, boolean z3) throws ne {
        y.n3 n3Var2;
        long j4;
        long[] jArr;
        long[] jArr2;
        y.C0106y a2;
        Pair<long[], long[]> s2;
        y.C0106y c0106y2 = (y.C0106y) v5.y.v(c0106y.a(1835297121));
        int gv2 = gv(f(((y.n3) v5.y.v(c0106y2.fb(1751411826))).f8914n3));
        if (gv2 == -1) {
            return null;
        }
        fb n2 = n(((y.n3) v5.y.v(c0106y.fb(1953196132))).f8914n3);
        long j6 = -9223372036854775807L;
        if (j2 == -9223372036854775807L) {
            n3Var2 = n3Var;
            j4 = n2.f8857n3;
        } else {
            n3Var2 = n3Var;
            j4 = j2;
        }
        long w4 = w(n3Var2.f8914n3);
        if (j4 != -9223372036854775807L) {
            j6 = j5.x5(j4, 1000000L, w4);
        }
        long j7 = j6;
        Pair<Long, String> tl2 = tl(((y.n3) v5.y.v(c0106y2.fb(1835296868))).f8914n3);
        y.n3 fb2 = ((y.C0106y) v5.y.v(((y.C0106y) v5.y.v(c0106y2.a(1835626086))).a(1937007212))).fb(1937011556);
        if (fb2 != null) {
            gv i42 = i4(fb2.f8914n3, n2.y, n2.f8858zn, (String) tl2.second, drmInitData, z3);
            if (!z2 && (a2 = c0106y.a(1701082227)) != null && (s2 = s(a2)) != null) {
                jArr2 = (long[]) s2.second;
                jArr = (long[]) s2.first;
            } else {
                jArr = null;
                jArr2 = null;
            }
            if (i42.f8860n3 == null) {
                return null;
            }
            return new xc(n2.y, gv2, ((Long) tl2.first).longValue(), w4, j7, i42.f8860n3, i42.f8859gv, i42.y, i42.f8861zn, jArr, jArr2);
        }
        throw ne.y("Malformed sample table (stbl) missing sample description (stsd)", null);
    }

    public static C0105n3 c5(rz rzVar, int i) {
        long j2;
        rzVar.oz(i + 12);
        rzVar.ut(1);
        i9(rzVar);
        rzVar.ut(2);
        int ej2 = rzVar.ej();
        if ((ej2 & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
            rzVar.ut(2);
        }
        if ((ej2 & 64) != 0) {
            rzVar.ut(rzVar.ej());
        }
        if ((ej2 & 32) != 0) {
            rzVar.ut(2);
        }
        rzVar.ut(1);
        i9(rzVar);
        String s2 = n.s(rzVar.ej());
        if (!"audio/mpeg".equals(s2) && !"audio/vnd.dts".equals(s2) && !"audio/vnd.dts.hd".equals(s2)) {
            rzVar.ut(4);
            long a82 = rzVar.a8();
            long a83 = rzVar.a8();
            rzVar.ut(1);
            int i92 = i9(rzVar);
            byte[] bArr = new byte[i92];
            rzVar.t(bArr, 0, i92);
            long j4 = -1;
            if (a83 > 0) {
                j2 = a83;
            } else {
                j2 = -1;
            }
            if (a82 > 0) {
                j4 = a82;
            }
            return new C0105n3(s2, bArr, j2, j4);
        }
        return new C0105n3(s2, null, -1L, -1L);
    }

    @Nullable
    public static Pair<Integer, w> co(rz rzVar, int i, int i5) throws ne {
        boolean z2;
        Pair<Integer, w> fb2;
        int a2 = rzVar.a();
        while (a2 - i < i5) {
            rzVar.oz(a2);
            int p2 = rzVar.p();
            if (p2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            e4.xc.y(z2, "childAtomSize must be positive");
            if (rzVar.p() == 1936289382 && (fb2 = fb(rzVar, a2, p2)) != null) {
                return fb2;
            }
            a2 += p2;
        }
        return null;
    }

    public static List<mt> d0(y.C0106y c0106y, f3 f3Var, long j2, @Nullable DrmInitData drmInitData, boolean z2, boolean z3, w0.fb<xc, xc> fbVar) throws ne {
        xc apply;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c0106y.f8915gv.size(); i++) {
            y.C0106y c0106y2 = c0106y.f8915gv.get(i);
            if (c0106y2.y == 1953653099 && (apply = fbVar.apply(c(c0106y2, (y.n3) v5.y.v(c0106y.fb(1836476516)), j2, drmInitData, z2, z3))) != null) {
                arrayList.add(x4(apply, (y.C0106y) v5.y.v(((y.C0106y) v5.y.v(((y.C0106y) v5.y.v(c0106y2.a(1835297121))).a(1835626086))).a(1937007212)), f3Var));
            }
        }
        return arrayList;
    }

    public static int f(rz rzVar) {
        rzVar.oz(16);
        return rzVar.p();
    }

    public static void f3(rz rzVar, int i, int i5, int i6, int i8, String str, gv gvVar) {
        rzVar.oz(i5 + 16);
        String str2 = "application/ttml+xml";
        x4 x4Var = null;
        long j2 = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i10 = i6 - 16;
                byte[] bArr = new byte[i10];
                rzVar.t(bArr, 0, i10);
                x4Var = x4.o(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i == 1937010800) {
                j2 = 0;
            } else if (i == 1664495672) {
                gvVar.f8859gv = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        gvVar.f8860n3 = new m.n3().j(i8).o4(str2).k(str).nf(j2).ut(x4Var).z6();
    }

    @Nullable
    public static Pair<Integer, w> fb(rz rzVar, int i, int i5) throws ne {
        boolean z2;
        boolean z3;
        int i6 = i + 8;
        boolean z4 = false;
        String str = null;
        Integer num = null;
        int i8 = -1;
        int i10 = 0;
        while (i6 - i < i5) {
            rzVar.oz(i6);
            int p2 = rzVar.p();
            int p3 = rzVar.p();
            if (p3 == 1718775137) {
                num = Integer.valueOf(rzVar.p());
            } else if (p3 == 1935894637) {
                rzVar.ut(4);
                str = rzVar.ta(4);
            } else if (p3 == 1935894633) {
                i8 = i6;
                i10 = p2;
            }
            i6 += p2;
        }
        if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
            return null;
        }
        if (num != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        e4.xc.y(z2, "frma atom is mandatory");
        if (i8 != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        e4.xc.y(z3, "schi atom is mandatory");
        w z5 = z(rzVar, i8, i10, str);
        if (z5 != null) {
            z4 = true;
        }
        e4.xc.y(z4, "tenc atom is mandatory");
        return Pair.create(num, (w) j5.i9(z5));
    }

    public static Pair<Metadata, Metadata> fh(y.n3 n3Var) {
        rz rzVar = n3Var.f8914n3;
        rzVar.oz(8);
        Metadata metadata = null;
        Metadata metadata2 = null;
        while (rzVar.y() >= 8) {
            int a2 = rzVar.a();
            int p2 = rzVar.p();
            int p3 = rzVar.p();
            if (p3 == 1835365473) {
                rzVar.oz(a2);
                metadata = rz(rzVar, a2 + p2);
            } else if (p3 == 1936553057) {
                rzVar.oz(a2);
                metadata2 = r(rzVar, a2 + p2);
            }
            rzVar.oz(a2 + p2);
        }
        return Pair.create(metadata, metadata2);
    }

    public static int gv(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        if (i != 1952807028 && i != 1935832172 && i != 1937072756 && i != 1668047728) {
            if (i == 1835365473) {
                return 5;
            }
            return -1;
        }
        return 3;
    }

    public static gv i4(rz rzVar, int i, int i5, String str, @Nullable DrmInitData drmInitData, boolean z2) throws ne {
        boolean z3;
        int i6;
        rzVar.oz(12);
        int p2 = rzVar.p();
        gv gvVar = new gv(p2);
        for (int i8 = 0; i8 < p2; i8++) {
            int a2 = rzVar.a();
            int p3 = rzVar.p();
            if (p3 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            e4.xc.y(z3, "childAtomSize must be positive");
            int p4 = rzVar.p();
            if (p4 == 1635148593 || p4 == 1635148595 || p4 == 1701733238 || p4 == 1831958048 || p4 == 1836070006 || p4 == 1752589105 || p4 == 1751479857 || p4 == 1932670515 || p4 == 1211250227 || p4 == 1987063864 || p4 == 1987063865 || p4 == 1635135537 || p4 == 1685479798 || p4 == 1685479729 || p4 == 1685481573 || p4 == 1685481521) {
                i6 = a2;
                mg(rzVar, p4, i6, p3, i, i5, drmInitData, gvVar, i8);
            } else if (p4 != 1836069985 && p4 != 1701733217 && p4 != 1633889587 && p4 != 1700998451 && p4 != 1633889588 && p4 != 1835823201 && p4 != 1685353315 && p4 != 1685353317 && p4 != 1685353320 && p4 != 1685353324 && p4 != 1685353336 && p4 != 1935764850 && p4 != 1935767394 && p4 != 1819304813 && p4 != 1936684916 && p4 != 1953984371 && p4 != 778924082 && p4 != 778924083 && p4 != 1835557169 && p4 != 1835560241 && p4 != 1634492771 && p4 != 1634492791 && p4 != 1970037111 && p4 != 1332770163 && p4 != 1716281667) {
                if (p4 != 1414810956 && p4 != 1954034535 && p4 != 2004251764 && p4 != 1937010800 && p4 != 1664495672) {
                    if (p4 == 1835365492) {
                        xc(rzVar, p4, a2, i, gvVar);
                    } else if (p4 == 1667329389) {
                        gvVar.f8860n3 = new m.n3().j(i).o4("application/x-camera-motion").z6();
                    }
                } else {
                    f3(rzVar, p4, a2, p3, i, str, gvVar);
                }
                i6 = a2;
            } else {
                i6 = a2;
                a(rzVar, p4, a2, p3, i, str, z2, drmInitData, gvVar, i8);
            }
            rzVar.oz(i6 + p3);
        }
        return gvVar;
    }

    public static int i9(rz rzVar) {
        int ej2 = rzVar.ej();
        int i = ej2 & 127;
        while ((ej2 & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            ej2 = rzVar.ej();
            i = (i << 7) | (ej2 & 127);
        }
        return i;
    }

    public static void mg(rz rzVar, int i, int i5, int i6, int i8, int i10, @Nullable DrmInitData drmInitData, gv gvVar, int i11) throws ne {
        String str;
        byte[] bArr;
        String str2;
        boolean z2;
        DrmInitData drmInitData2;
        int i12;
        int i13;
        float f4;
        List<byte[]> list;
        int i14;
        int i15;
        int i16;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        String str3;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        int i17 = i5;
        int i18 = i6;
        DrmInitData drmInitData3 = drmInitData;
        gv gvVar2 = gvVar;
        rzVar.oz(i17 + 16);
        rzVar.ut(16);
        int yt2 = rzVar.yt();
        int yt3 = rzVar.yt();
        rzVar.ut(50);
        int a2 = rzVar.a();
        int i19 = i;
        if (i19 == 1701733238) {
            Pair<Integer, w> co2 = co(rzVar, i17, i18);
            if (co2 != null) {
                i19 = ((Integer) co2.first).intValue();
                if (drmInitData3 == null) {
                    drmInitData3 = null;
                } else {
                    drmInitData3 = drmInitData3.zn(((w) co2.second).f8901n3);
                }
                gvVar2.y[i11] = (w) co2.second;
            }
            rzVar.oz(a2);
        }
        String str4 = "video/3gpp";
        if (i19 == 1831958048) {
            str = "video/mpeg";
        } else if (i19 == 1211250227) {
            str = "video/3gpp";
        } else {
            str = null;
        }
        float f6 = 1.0f;
        String str5 = null;
        List<byte[]> list2 = null;
        byte[] bArr2 = null;
        int i20 = -1;
        int i21 = -1;
        int i22 = -1;
        int i23 = -1;
        ByteBuffer byteBuffer = null;
        C0105n3 c0105n3 = null;
        boolean z12 = false;
        while (a2 - i17 < i18) {
            rzVar.oz(a2);
            int a3 = rzVar.a();
            int p2 = rzVar.p();
            if (p2 == 0) {
                str2 = str4;
                if (rzVar.a() - i17 == i18) {
                    break;
                }
            } else {
                str2 = str4;
            }
            if (p2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            e4.xc.y(z2, "childAtomSize must be positive");
            int p3 = rzVar.p();
            if (p3 == 1635148611) {
                if (str == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                e4.xc.y(z11, null);
                rzVar.oz(a3 + 8);
                wn.y n32 = wn.y.n3(rzVar);
                list2 = n32.y;
                gvVar2.f8861zn = n32.f14649n3;
                if (!z12) {
                    f6 = n32.f14650v;
                }
                str5 = n32.f14647a;
                str3 = "video/avc";
            } else {
                if (p3 == 1752589123) {
                    if (str == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    e4.xc.y(z10, null);
                    rzVar.oz(a3 + 8);
                    wn.a y2 = wn.a.y(rzVar);
                    list2 = y2.y;
                    gvVar2.f8861zn = y2.f14555n3;
                    if (!z12) {
                        f6 = y2.f14557v;
                    }
                    str5 = y2.f14552c5;
                    int i24 = y2.f14551a;
                    int i25 = y2.f14553fb;
                    i23 = y2.f14556s;
                    drmInitData2 = drmInitData3;
                    i12 = yt3;
                    i21 = i24;
                    i13 = i19;
                    i22 = i25;
                    str = "video/hevc";
                } else {
                    if (p3 == 1685480259 || p3 == 1685485123) {
                        drmInitData2 = drmInitData3;
                        i12 = yt3;
                        i13 = i19;
                        f4 = f6;
                        list = list2;
                        i14 = i21;
                        i15 = i22;
                        i16 = i23;
                        wn.gv y7 = wn.gv.y(rzVar);
                        if (y7 != null) {
                            str5 = y7.f14586zn;
                            str = "video/dolby-vision";
                        }
                    } else if (p3 == 1987076931) {
                        if (str == null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        e4.xc.y(z8, null);
                        if (i19 == 1987063864) {
                            str3 = "video/x-vnd.on2.vp8";
                        } else {
                            str3 = "video/x-vnd.on2.vp9";
                        }
                        rzVar.oz(a3 + 12);
                        rzVar.ut(2);
                        if ((rzVar.ej() & 1) != 0) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        int ej2 = rzVar.ej();
                        int ej3 = rzVar.ej();
                        i21 = wn.zn.n3(ej2);
                        if (z9) {
                            i22 = 1;
                        } else {
                            i22 = 2;
                        }
                        i23 = wn.zn.zn(ej3);
                    } else if (p3 == 1635135811) {
                        if (str == null) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        e4.xc.y(z7, null);
                        str3 = "video/av01";
                    } else if (p3 == 1668050025) {
                        if (byteBuffer == null) {
                            byteBuffer = y();
                        }
                        ByteBuffer byteBuffer2 = byteBuffer;
                        byteBuffer2.position(21);
                        byteBuffer2.putShort(rzVar.mg());
                        byteBuffer2.putShort(rzVar.mg());
                        byteBuffer = byteBuffer2;
                        drmInitData2 = drmInitData3;
                        i12 = yt3;
                        i13 = i19;
                    } else if (p3 == 1835295606) {
                        if (byteBuffer == null) {
                            byteBuffer = y();
                        }
                        ByteBuffer byteBuffer3 = byteBuffer;
                        short mg2 = rzVar.mg();
                        short mg3 = rzVar.mg();
                        short mg4 = rzVar.mg();
                        i13 = i19;
                        short mg5 = rzVar.mg();
                        short mg6 = rzVar.mg();
                        drmInitData2 = drmInitData3;
                        short mg7 = rzVar.mg();
                        List<byte[]> list3 = list2;
                        short mg8 = rzVar.mg();
                        float f9 = f6;
                        short mg9 = rzVar.mg();
                        long a82 = rzVar.a8();
                        long a83 = rzVar.a8();
                        i12 = yt3;
                        byteBuffer3.position(1);
                        byteBuffer3.putShort(mg6);
                        byteBuffer3.putShort(mg7);
                        byteBuffer3.putShort(mg2);
                        byteBuffer3.putShort(mg3);
                        byteBuffer3.putShort(mg4);
                        byteBuffer3.putShort(mg5);
                        byteBuffer3.putShort(mg8);
                        byteBuffer3.putShort(mg9);
                        byteBuffer3.putShort((short) (a82 / 10000));
                        byteBuffer3.putShort((short) (a83 / 10000));
                        byteBuffer = byteBuffer3;
                        list2 = list3;
                        f6 = f9;
                    } else {
                        drmInitData2 = drmInitData3;
                        i12 = yt3;
                        i13 = i19;
                        f4 = f6;
                        list = list2;
                        if (p3 == 1681012275) {
                            if (str == null) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            e4.xc.y(z5, null);
                            str = str2;
                        } else if (p3 == 1702061171) {
                            if (str == null) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            e4.xc.y(z4, null);
                            c0105n3 = c5(rzVar, a3);
                            String str6 = c0105n3.y;
                            byte[] bArr3 = c0105n3.f8863n3;
                            if (bArr3 != null) {
                                list2 = x4.o(bArr3);
                            } else {
                                list2 = list;
                            }
                            str = str6;
                            f6 = f4;
                            a2 += p2;
                            i17 = i5;
                            i18 = i6;
                            gvVar2 = gvVar;
                            str4 = str2;
                            i19 = i13;
                            drmInitData3 = drmInitData2;
                            yt3 = i12;
                        } else if (p3 == 1885434736) {
                            f6 = p(rzVar, a3);
                            list2 = list;
                            z12 = true;
                            a2 += p2;
                            i17 = i5;
                            i18 = i6;
                            gvVar2 = gvVar;
                            str4 = str2;
                            i19 = i13;
                            drmInitData3 = drmInitData2;
                            yt3 = i12;
                        } else if (p3 == 1937126244) {
                            bArr2 = mt(rzVar, a3, p2);
                        } else if (p3 == 1936995172) {
                            int ej4 = rzVar.ej();
                            rzVar.ut(3);
                            if (ej4 == 0) {
                                int ej5 = rzVar.ej();
                                if (ej5 != 0) {
                                    if (ej5 != 1) {
                                        if (ej5 != 2) {
                                            if (ej5 == 3) {
                                                i20 = 3;
                                            }
                                        } else {
                                            i20 = 2;
                                        }
                                    } else {
                                        i20 = 1;
                                    }
                                } else {
                                    i20 = 0;
                                }
                            }
                        } else {
                            i14 = i21;
                            if (p3 == 1668246642) {
                                i15 = i22;
                                if (i14 == -1) {
                                    i16 = i23;
                                    if (i15 == -1 && i16 == -1) {
                                        int p4 = rzVar.p();
                                        if (p4 != 1852009592 && p4 != 1852009571) {
                                            r.c5("AtomParsers", "Unsupported color type: " + ha.y.y(p4));
                                        } else {
                                            int yt4 = rzVar.yt();
                                            int yt5 = rzVar.yt();
                                            rzVar.ut(2);
                                            if (p2 == 19 && (rzVar.ej() & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            i21 = wn.zn.n3(yt4);
                                            if (z3) {
                                                i22 = 1;
                                            } else {
                                                i22 = 2;
                                            }
                                            i23 = wn.zn.zn(yt5);
                                        }
                                    }
                                }
                            } else {
                                i15 = i22;
                            }
                            i16 = i23;
                        }
                        list2 = list;
                        f6 = f4;
                        a2 += p2;
                        i17 = i5;
                        i18 = i6;
                        gvVar2 = gvVar;
                        str4 = str2;
                        i19 = i13;
                        drmInitData3 = drmInitData2;
                        yt3 = i12;
                    }
                    i22 = i15;
                    i23 = i16;
                    i21 = i14;
                    list2 = list;
                    f6 = f4;
                    a2 += p2;
                    i17 = i5;
                    i18 = i6;
                    gvVar2 = gvVar;
                    str4 = str2;
                    i19 = i13;
                    drmInitData3 = drmInitData2;
                    yt3 = i12;
                }
                a2 += p2;
                i17 = i5;
                i18 = i6;
                gvVar2 = gvVar;
                str4 = str2;
                i19 = i13;
                drmInitData3 = drmInitData2;
                yt3 = i12;
            }
            str = str3;
            drmInitData2 = drmInitData3;
            i12 = yt3;
            i13 = i19;
            a2 += p2;
            i17 = i5;
            i18 = i6;
            gvVar2 = gvVar;
            str4 = str2;
            i19 = i13;
            drmInitData3 = drmInitData2;
            yt3 = i12;
        }
        DrmInitData drmInitData4 = drmInitData3;
        int i26 = yt3;
        float f10 = f6;
        List<byte[]> list4 = list2;
        int i27 = i21;
        int i28 = i22;
        int i29 = i23;
        if (str == null) {
            return;
        }
        m.n3 vl2 = new m.n3().j(i8).o4(str).x(str5).s8(yt2).o(i26).y5(f10).ct(i10).xg(bArr2).lc(i20).ut(list4).vl(drmInitData4);
        if (i27 != -1 || i28 != -1 || i29 != -1 || byteBuffer != null) {
            if (byteBuffer != null) {
                bArr = byteBuffer.array();
            } else {
                bArr = null;
            }
            vl2.b(new wn.zn(i27, i28, i29, bArr));
        }
        if (c0105n3 != null) {
            vl2.ud(d1.a.tl(c0105n3.f8864zn)).u(d1.a.tl(c0105n3.f8862gv));
        }
        gvVar.f8860n3 = vl2.z6();
    }

    @Nullable
    public static byte[] mt(rz rzVar, int i, int i5) {
        int i6 = i + 8;
        while (i6 - i < i5) {
            rzVar.oz(i6);
            int p2 = rzVar.p();
            if (rzVar.p() == 1886547818) {
                return Arrays.copyOfRange(rzVar.v(), i6, p2 + i6);
            }
            i6 += p2;
        }
        return null;
    }

    public static fb n(rz rzVar) {
        int i;
        long j2;
        long k52;
        int i5 = 8;
        rzVar.oz(8);
        int zn2 = ha.y.zn(rzVar.p());
        if (zn2 == 0) {
            i = 8;
        } else {
            i = 16;
        }
        rzVar.ut(i);
        int p2 = rzVar.p();
        rzVar.ut(4);
        int a2 = rzVar.a();
        if (zn2 == 0) {
            i5 = 4;
        }
        int i6 = 0;
        int i8 = 0;
        while (true) {
            j2 = -9223372036854775807L;
            if (i8 < i5) {
                if (rzVar.v()[a2 + i8] != -1) {
                    if (zn2 == 0) {
                        k52 = rzVar.a8();
                    } else {
                        k52 = rzVar.k5();
                    }
                    if (k52 != 0) {
                        j2 = k52;
                    }
                } else {
                    i8++;
                }
            } else {
                rzVar.ut(i5);
                break;
            }
        }
        rzVar.ut(16);
        int p3 = rzVar.p();
        int p4 = rzVar.p();
        rzVar.ut(4);
        int p8 = rzVar.p();
        int p9 = rzVar.p();
        if (p3 == 0 && p4 == 65536 && p8 == -65536 && p9 == 0) {
            i6 = 90;
        } else if (p3 == 0 && p4 == -65536 && p8 == 65536 && p9 == 0) {
            i6 = 270;
        } else if (p3 == -65536 && p4 == 0 && p8 == 0 && p9 == -65536) {
            i6 = 180;
        }
        return new fb(p2, j2, i6);
    }

    public static boolean n3(long[] jArr, long j2, long j4, long j6) {
        int length = jArr.length - 1;
        int p2 = j5.p(4, 0, length);
        int p3 = j5.p(jArr.length - 4, 0, length);
        if (jArr[0] <= j4 && j4 < jArr[p2] && jArr[p3] < j6 && j6 <= j2) {
            return true;
        }
        return false;
    }

    public static float p(rz rzVar, int i) {
        rzVar.oz(i + 8);
        return rzVar.b() / rzVar.b();
    }

    @Nullable
    public static Metadata r(rz rzVar, int i) {
        float f4;
        rzVar.ut(12);
        while (rzVar.a() < i) {
            int a2 = rzVar.a();
            int p2 = rzVar.p();
            if (rzVar.p() == 1935766900) {
                if (p2 < 14) {
                    return null;
                }
                rzVar.ut(5);
                int ej2 = rzVar.ej();
                if (ej2 != 12 && ej2 != 13) {
                    return null;
                }
                if (ej2 == 12) {
                    f4 = 240.0f;
                } else {
                    f4 = 120.0f;
                }
                rzVar.ut(1);
                return new Metadata(new SmtaMetadataEntry(f4, rzVar.ej()));
            }
            rzVar.oz(a2 + p2);
        }
        return null;
    }

    @Nullable
    public static Metadata rz(rz rzVar, int i) {
        rzVar.ut(8);
        v(rzVar);
        while (rzVar.a() < i) {
            int a2 = rzVar.a();
            int p2 = rzVar.p();
            if (rzVar.p() == 1768715124) {
                rzVar.oz(a2);
                return t(rzVar, a2 + p2);
            }
            rzVar.oz(a2 + p2);
        }
        return null;
    }

    @Nullable
    public static Pair<long[], long[]> s(y.C0106y c0106y) {
        long a82;
        long p2;
        y.n3 fb2 = c0106y.fb(1701606260);
        if (fb2 == null) {
            return null;
        }
        rz rzVar = fb2.f8914n3;
        rzVar.oz(8);
        int zn2 = ha.y.zn(rzVar.p());
        int b2 = rzVar.b();
        long[] jArr = new long[b2];
        long[] jArr2 = new long[b2];
        for (int i = 0; i < b2; i++) {
            if (zn2 == 1) {
                a82 = rzVar.k5();
            } else {
                a82 = rzVar.a8();
            }
            jArr[i] = a82;
            if (zn2 == 1) {
                p2 = rzVar.d0();
            } else {
                p2 = rzVar.p();
            }
            jArr2[i] = p2;
            if (rzVar.mg() == 1) {
                rzVar.ut(2);
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    @Nullable
    public static Metadata t(rz rzVar, int i) {
        rzVar.ut(8);
        ArrayList arrayList = new ArrayList();
        while (rzVar.a() < i) {
            Metadata.Entry zn2 = s.zn(rzVar);
            if (zn2 != null) {
                arrayList.add(zn2);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static Pair<Long, String> tl(rz rzVar) {
        int i;
        int i5 = 8;
        rzVar.oz(8);
        int zn2 = ha.y.zn(rzVar.p());
        if (zn2 == 0) {
            i = 8;
        } else {
            i = 16;
        }
        rzVar.ut(i);
        long a82 = rzVar.a8();
        if (zn2 == 0) {
            i5 = 4;
        }
        rzVar.ut(i5);
        int yt2 = rzVar.yt();
        return Pair.create(Long.valueOf(a82), "" + ((char) (((yt2 >> 10) & 31) + 96)) + ((char) (((yt2 >> 5) & 31) + 96)) + ((char) ((yt2 & 31) + 96)));
    }

    public static void v(rz rzVar) {
        int a2 = rzVar.a();
        rzVar.ut(4);
        if (rzVar.p() != 1751411826) {
            a2 += 4;
        }
        rzVar.oz(a2);
    }

    public static long w(rz rzVar) {
        int i = 8;
        rzVar.oz(8);
        if (ha.y.zn(rzVar.p()) != 0) {
            i = 16;
        }
        rzVar.ut(i);
        return rzVar.a8();
    }

    @Nullable
    public static Metadata wz(y.C0106y c0106y) {
        y.n3 fb2 = c0106y.fb(1751411826);
        y.n3 fb3 = c0106y.fb(1801812339);
        y.n3 fb4 = c0106y.fb(1768715124);
        if (fb2 == null || fb3 == null || fb4 == null || f(fb2.f8914n3) != 1835299937) {
            return null;
        }
        rz rzVar = fb3.f8914n3;
        rzVar.oz(12);
        int p2 = rzVar.p();
        String[] strArr = new String[p2];
        for (int i = 0; i < p2; i++) {
            int p3 = rzVar.p();
            rzVar.ut(4);
            strArr[i] = rzVar.ta(p3 - 8);
        }
        rz rzVar2 = fb4.f8914n3;
        rzVar2.oz(8);
        ArrayList arrayList = new ArrayList();
        while (rzVar2.y() > 8) {
            int a2 = rzVar2.a();
            int p4 = rzVar2.p();
            int p8 = rzVar2.p() - 1;
            if (p8 >= 0 && p8 < p2) {
                MdtaMetadataEntry a3 = s.a(rzVar2, a2 + p4, strArr[p8]);
                if (a3 != null) {
                    arrayList.add(a3);
                }
            } else {
                r.c5("AtomParsers", "Skipped metadata with unknown key index: " + p8);
            }
            rzVar2.oz(a2 + p4);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x042a A[EDGE_INSN: B:212:0x042a->B:171:0x042a ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ha.mt x4(ha.xc r38, ha.y.C0106y r39, e4.f3 r40) throws m1.ne {
        /*
            Method dump skipped, instructions count: 1312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ha.n3.x4(ha.xc, ha.y$y, e4.f3):ha.mt");
    }

    public static void xc(rz rzVar, int i, int i5, int i6, gv gvVar) {
        rzVar.oz(i5 + 16);
        if (i == 1835365492) {
            rzVar.fh();
            String fh2 = rzVar.fh();
            if (fh2 != null) {
                gvVar.f8860n3 = new m.n3().j(i6).o4(fh2).z6();
            }
        }
    }

    public static ByteBuffer y() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    @Nullable
    public static w z(rz rzVar, int i, int i5, String str) {
        int i6;
        int i8;
        boolean z2;
        int i10 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i10 - i >= i5) {
                return null;
            }
            rzVar.oz(i10);
            int p2 = rzVar.p();
            if (rzVar.p() == 1952804451) {
                int zn2 = ha.y.zn(rzVar.p());
                rzVar.ut(1);
                if (zn2 == 0) {
                    rzVar.ut(1);
                    i8 = 0;
                    i6 = 0;
                } else {
                    int ej2 = rzVar.ej();
                    i6 = ej2 & 15;
                    i8 = (ej2 & 240) >> 4;
                }
                if (rzVar.ej() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                int ej3 = rzVar.ej();
                byte[] bArr2 = new byte[16];
                rzVar.t(bArr2, 0, 16);
                if (z2 && ej3 == 0) {
                    int ej4 = rzVar.ej();
                    bArr = new byte[ej4];
                    rzVar.t(bArr, 0, ej4);
                }
                return new w(z2, str, ej3, bArr2, i8, i6, bArr);
            }
            i10 += p2;
        }
    }

    public static int zn(rz rzVar, int i, int i5, int i6) throws ne {
        boolean z2;
        boolean z3;
        int a2 = rzVar.a();
        if (a2 >= i5) {
            z2 = true;
        } else {
            z2 = false;
        }
        e4.xc.y(z2, null);
        while (a2 - i5 < i6) {
            rzVar.oz(a2);
            int p2 = rzVar.p();
            if (p2 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            e4.xc.y(z3, "childAtomSize must be positive");
            if (rzVar.p() == i) {
                return a2;
            }
            a2 += p2;
        }
        return -1;
    }
}
