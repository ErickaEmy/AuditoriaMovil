package e4;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.vorbis.VorbisComment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import m1.ne;
import v5.j5;
/* loaded from: classes.dex */
public final class ej {

    /* loaded from: classes.dex */
    public static final class gv {

        /* renamed from: a  reason: collision with root package name */
        public final int f7483a;

        /* renamed from: c5  reason: collision with root package name */
        public final boolean f7484c5;

        /* renamed from: fb  reason: collision with root package name */
        public final int f7485fb;

        /* renamed from: gv  reason: collision with root package name */
        public final int f7486gv;

        /* renamed from: i9  reason: collision with root package name */
        public final byte[] f7487i9;

        /* renamed from: n3  reason: collision with root package name */
        public final int f7488n3;

        /* renamed from: s  reason: collision with root package name */
        public final int f7489s;

        /* renamed from: v  reason: collision with root package name */
        public final int f7490v;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f7491zn;

        public gv(int i, int i5, int i6, int i8, int i10, int i11, int i12, int i13, boolean z2, byte[] bArr) {
            this.y = i;
            this.f7488n3 = i5;
            this.f7491zn = i6;
            this.f7486gv = i8;
            this.f7490v = i10;
            this.f7483a = i11;
            this.f7485fb = i12;
            this.f7489s = i13;
            this.f7484c5 = z2;
            this.f7487i9 = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final String[] f7492n3;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f7493zn;

        public n3(String str, String[] strArr, int i) {
            this.y = str;
            this.f7492n3 = strArr;
            this.f7493zn = i;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: gv  reason: collision with root package name */
        public final int f7494gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f7495n3;

        /* renamed from: v  reason: collision with root package name */
        public final boolean f7496v;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final long[] f7497zn;

        public y(int i, int i5, long[] jArr, int i6, boolean z2) {
            this.y = i;
            this.f7495n3 = i5;
            this.f7497zn = jArr;
            this.f7494gv = i6;
            this.f7496v = z2;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: gv  reason: collision with root package name */
        public final int f7498gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f7499n3;
        public final boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f7500zn;

        public zn(boolean z2, int i, int i5, int i6) {
            this.y = z2;
            this.f7499n3 = i;
            this.f7500zn = i5;
            this.f7498gv = i6;
        }
    }

    public static void a(int i, z6 z6Var) throws ne {
        int i5;
        int gv2 = z6Var.gv(6) + 1;
        for (int i6 = 0; i6 < gv2; i6++) {
            int gv3 = z6Var.gv(16);
            if (gv3 != 0) {
                v5.r.zn("VorbisUtil", "mapping type other than 0 not supported: " + gv3);
            } else {
                if (z6Var.zn()) {
                    i5 = z6Var.gv(4) + 1;
                } else {
                    i5 = 1;
                }
                if (z6Var.zn()) {
                    int gv4 = z6Var.gv(8) + 1;
                    for (int i8 = 0; i8 < gv4; i8++) {
                        int i10 = i - 1;
                        z6Var.v(y(i10));
                        z6Var.v(y(i10));
                    }
                }
                if (z6Var.gv(2) == 0) {
                    if (i5 > 1) {
                        for (int i11 = 0; i11 < i; i11++) {
                            z6Var.v(4);
                        }
                    }
                    for (int i12 = 0; i12 < i5; i12++) {
                        z6Var.v(8);
                        z6Var.v(8);
                        z6Var.v(8);
                    }
                } else {
                    throw ne.y("to reserved bits must be zero after mapping coupling steps", null);
                }
            }
        }
    }

    public static n3 c5(v5.rz rzVar) throws ne {
        return i9(rzVar, true, true);
    }

    public static gv f(v5.rz rzVar) throws ne {
        boolean z2 = true;
        tl(1, rzVar, false);
        int n2 = rzVar.n();
        int ej2 = rzVar.ej();
        int n4 = rzVar.n();
        int r2 = rzVar.r();
        if (r2 <= 0) {
            r2 = -1;
        }
        int r3 = rzVar.r();
        if (r3 <= 0) {
            r3 = -1;
        }
        int r5 = rzVar.r();
        if (r5 <= 0) {
            r5 = -1;
        }
        int ej3 = rzVar.ej();
        int pow = (int) Math.pow(2.0d, ej3 & 15);
        int pow2 = (int) Math.pow(2.0d, (ej3 & 240) >> 4);
        if ((rzVar.ej() & 1) <= 0) {
            z2 = false;
        }
        return new gv(n2, ej2, n4, r2, r3, r5, pow, pow2, z2, Arrays.copyOf(rzVar.v(), rzVar.fb()));
    }

    public static zn[] fb(z6 z6Var) {
        int gv2 = z6Var.gv(6) + 1;
        zn[] znVarArr = new zn[gv2];
        for (int i = 0; i < gv2; i++) {
            znVarArr[i] = new zn(z6Var.zn(), z6Var.gv(16), z6Var.gv(16), z6Var.gv(8));
        }
        return znVarArr;
    }

    public static y gv(z6 z6Var) throws ne {
        if (z6Var.gv(24) == 5653314) {
            int gv2 = z6Var.gv(16);
            int gv3 = z6Var.gv(24);
            long[] jArr = new long[gv3];
            boolean zn2 = z6Var.zn();
            long j2 = 0;
            if (!zn2) {
                boolean zn3 = z6Var.zn();
                for (int i = 0; i < gv3; i++) {
                    if (zn3) {
                        if (z6Var.zn()) {
                            jArr[i] = z6Var.gv(5) + 1;
                        } else {
                            jArr[i] = 0;
                        }
                    } else {
                        jArr[i] = z6Var.gv(5) + 1;
                    }
                }
            } else {
                int gv4 = z6Var.gv(5) + 1;
                int i5 = 0;
                while (i5 < gv3) {
                    int gv5 = z6Var.gv(y(gv3 - i5));
                    for (int i6 = 0; i6 < gv5 && i5 < gv3; i6++) {
                        jArr[i5] = gv4;
                        i5++;
                    }
                    gv4++;
                }
            }
            int gv6 = z6Var.gv(4);
            if (gv6 <= 2) {
                if (gv6 == 1 || gv6 == 2) {
                    z6Var.v(32);
                    z6Var.v(32);
                    int gv7 = z6Var.gv(4) + 1;
                    z6Var.v(1);
                    if (gv6 == 1) {
                        if (gv2 != 0) {
                            j2 = n3(gv3, gv2);
                        }
                    } else {
                        j2 = gv3 * gv2;
                    }
                    z6Var.v((int) (j2 * gv7));
                }
                return new y(gv2, gv3, jArr, gv6, zn2);
            }
            throw ne.y("lookup type greater than 2 not decodable: " + gv6, null);
        }
        throw ne.y("expected code book to start with [0x56, 0x43, 0x42] at " + z6Var.n3(), null);
    }

    public static n3 i9(v5.rz rzVar, boolean z2, boolean z3) throws ne {
        if (z2) {
            tl(3, rzVar, false);
        }
        String ta2 = rzVar.ta((int) rzVar.f3());
        int length = ta2.length();
        long f32 = rzVar.f3();
        String[] strArr = new String[(int) f32];
        int i = length + 15;
        for (int i5 = 0; i5 < f32; i5++) {
            String ta3 = rzVar.ta((int) rzVar.f3());
            strArr[i5] = ta3;
            i = i + 4 + ta3.length();
        }
        if (z3 && (rzVar.ej() & 1) == 0) {
            throw ne.y("framing bit expected to be set", null);
        }
        return new n3(ta2, strArr, i + 1);
    }

    public static long n3(long j2, long j4) {
        return (long) Math.floor(Math.pow(j2, 1.0d / j4));
    }

    public static void s(z6 z6Var) throws ne {
        int i;
        int gv2 = z6Var.gv(6) + 1;
        for (int i5 = 0; i5 < gv2; i5++) {
            if (z6Var.gv(16) <= 2) {
                z6Var.v(24);
                z6Var.v(24);
                z6Var.v(24);
                int gv3 = z6Var.gv(6) + 1;
                z6Var.v(8);
                int[] iArr = new int[gv3];
                for (int i6 = 0; i6 < gv3; i6++) {
                    int gv4 = z6Var.gv(3);
                    if (z6Var.zn()) {
                        i = z6Var.gv(5);
                    } else {
                        i = 0;
                    }
                    iArr[i6] = (i * 8) + gv4;
                }
                for (int i8 = 0; i8 < gv3; i8++) {
                    for (int i10 = 0; i10 < 8; i10++) {
                        if ((iArr[i8] & (1 << i10)) != 0) {
                            z6Var.v(8);
                        }
                    }
                }
            } else {
                throw ne.y("residueType greater than 2 is not decodable", null);
            }
        }
    }

    public static zn[] t(v5.rz rzVar, int i) throws ne {
        tl(5, rzVar, false);
        int ej2 = rzVar.ej() + 1;
        z6 z6Var = new z6(rzVar.v());
        z6Var.v(rzVar.a() * 8);
        for (int i5 = 0; i5 < ej2; i5++) {
            gv(z6Var);
        }
        int gv2 = z6Var.gv(6) + 1;
        for (int i6 = 0; i6 < gv2; i6++) {
            if (z6Var.gv(16) != 0) {
                throw ne.y("placeholder of time domain transforms not zeroed out", null);
            }
        }
        v(z6Var);
        s(z6Var);
        a(i, z6Var);
        zn[] fb2 = fb(z6Var);
        if (z6Var.zn()) {
            return fb2;
        }
        throw ne.y("framing bit after modes not set as expected", null);
    }

    public static boolean tl(int i, v5.rz rzVar, boolean z2) throws ne {
        if (rzVar.y() < 7) {
            if (z2) {
                return false;
            }
            throw ne.y("too short header: " + rzVar.y(), null);
        } else if (rzVar.ej() != i) {
            if (z2) {
                return false;
            }
            throw ne.y("expected header type " + Integer.toHexString(i), null);
        } else if (rzVar.ej() == 118 && rzVar.ej() == 111 && rzVar.ej() == 114 && rzVar.ej() == 98 && rzVar.ej() == 105 && rzVar.ej() == 115) {
            return true;
        } else {
            if (z2) {
                return false;
            }
            throw ne.y("expected characters 'vorbis'", null);
        }
    }

    public static void v(z6 z6Var) throws ne {
        int gv2 = z6Var.gv(6) + 1;
        for (int i = 0; i < gv2; i++) {
            int gv3 = z6Var.gv(16);
            if (gv3 != 0) {
                if (gv3 == 1) {
                    int gv4 = z6Var.gv(5);
                    int[] iArr = new int[gv4];
                    int i5 = -1;
                    for (int i6 = 0; i6 < gv4; i6++) {
                        int gv5 = z6Var.gv(4);
                        iArr[i6] = gv5;
                        if (gv5 > i5) {
                            i5 = gv5;
                        }
                    }
                    int i8 = i5 + 1;
                    int[] iArr2 = new int[i8];
                    for (int i10 = 0; i10 < i8; i10++) {
                        iArr2[i10] = z6Var.gv(3) + 1;
                        int gv6 = z6Var.gv(2);
                        if (gv6 > 0) {
                            z6Var.v(8);
                        }
                        for (int i11 = 0; i11 < (1 << gv6); i11++) {
                            z6Var.v(8);
                        }
                    }
                    z6Var.v(2);
                    int gv7 = z6Var.gv(4);
                    int i12 = 0;
                    int i13 = 0;
                    for (int i14 = 0; i14 < gv4; i14++) {
                        i12 += iArr2[iArr[i14]];
                        while (i13 < i12) {
                            z6Var.v(gv7);
                            i13++;
                        }
                    }
                } else {
                    throw ne.y("floor type greater than 1 not decodable: " + gv3, null);
                }
            } else {
                z6Var.v(8);
                z6Var.v(16);
                z6Var.v(16);
                z6Var.v(6);
                z6Var.v(8);
                int gv8 = z6Var.gv(4) + 1;
                for (int i15 = 0; i15 < gv8; i15++) {
                    z6Var.v(8);
                }
            }
        }
    }

    public static int y(int i) {
        int i5 = 0;
        while (i > 0) {
            i5++;
            i >>>= 1;
        }
        return i5;
    }

    @Nullable
    public static Metadata zn(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] ix2 = j5.ix(str, "=");
            if (ix2.length != 2) {
                v5.r.c5("VorbisUtil", "Failed to parse Vorbis comment: " + str);
            } else if (ix2[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(PictureFrame.y(new v5.rz(Base64.decode(ix2[1], 0))));
                } catch (RuntimeException e2) {
                    v5.r.i9("VorbisUtil", "Failed to parse vorbis picture", e2);
                }
            } else {
                arrayList.add(new VorbisComment(ix2[0], ix2[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }
}
