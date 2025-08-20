package n6;

import android.net.Uri;
import android.util.Pair;
import d9.hw;
import e4.d0;
import e4.mt;
import e4.p;
import e4.t;
import e4.ta;
import e4.tl;
import e4.wz;
import java.io.IOException;
import java.util.Map;
import m1.m;
import m1.ne;
import v5.j5;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class n3 implements t {

    /* renamed from: s  reason: collision with root package name */
    public static final mt f11809s = new mt() { // from class: n6.y
        @Override // e4.mt
        public final t[] createExtractors() {
            t[] fb2;
            fb2 = n3.fb();
            return fb2;
        }

        @Override // e4.mt
        public /* synthetic */ t[] y(Uri uri, Map map) {
            return p.y(this, uri, map);
        }
    };

    /* renamed from: n3  reason: collision with root package name */
    public ta f11813n3;

    /* renamed from: v  reason: collision with root package name */
    public InterfaceC0163n3 f11814v;
    public wz y;

    /* renamed from: zn  reason: collision with root package name */
    public int f11815zn;

    /* renamed from: gv  reason: collision with root package name */
    public long f11812gv = -1;

    /* renamed from: a  reason: collision with root package name */
    public int f11810a = -1;

    /* renamed from: fb  reason: collision with root package name */
    public long f11811fb = -1;

    /* renamed from: n6.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0163n3 {
        boolean n3(tl tlVar, long j2) throws IOException;

        void y(int i, long j2) throws ne;

        void zn(long j2);
    }

    /* loaded from: classes.dex */
    public static final class y implements InterfaceC0163n3 {

        /* renamed from: tl  reason: collision with root package name */
        public static final int[] f11816tl = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* renamed from: wz  reason: collision with root package name */
        public static final int[] f11817wz = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* renamed from: a  reason: collision with root package name */
        public final rz f11818a;

        /* renamed from: c5  reason: collision with root package name */
        public int f11819c5;

        /* renamed from: f  reason: collision with root package name */
        public int f11820f;

        /* renamed from: fb  reason: collision with root package name */
        public final int f11821fb;

        /* renamed from: gv  reason: collision with root package name */
        public final int f11822gv;

        /* renamed from: i9  reason: collision with root package name */
        public long f11823i9;

        /* renamed from: n3  reason: collision with root package name */
        public final ta f11824n3;

        /* renamed from: s  reason: collision with root package name */
        public final m f11825s;

        /* renamed from: t  reason: collision with root package name */
        public long f11826t;

        /* renamed from: v  reason: collision with root package name */
        public final byte[] f11827v;
        public final wz y;

        /* renamed from: zn  reason: collision with root package name */
        public final n6.zn f11828zn;

        public y(wz wzVar, ta taVar, n6.zn znVar) throws ne {
            this.y = wzVar;
            this.f11824n3 = taVar;
            this.f11828zn = znVar;
            int max = Math.max(1, znVar.f11845zn / 10);
            this.f11821fb = max;
            rz rzVar = new rz(znVar.f11841fb);
            rzVar.c();
            int c2 = rzVar.c();
            this.f11822gv = c2;
            int i = znVar.f11843n3;
            int i5 = (((znVar.f11844v - (i * 4)) * 8) / (znVar.f11840a * i)) + 1;
            if (c2 == i5) {
                int t2 = j5.t(max, c2);
                this.f11827v = new byte[znVar.f11844v * t2];
                this.f11818a = new rz(t2 * s(c2, i));
                int i6 = ((znVar.f11845zn * znVar.f11844v) * 8) / c2;
                this.f11825s = new m.n3().o4("audio/raw").ud(i6).u(i6).f7(s(max, i)).a8(znVar.f11843n3).rs(znVar.f11845zn).jz(2).z6();
                return;
            }
            throw ne.y("Expected frames per block: " + i5 + "; got: " + c2, null);
        }

        public static int s(int i, int i5) {
            return i * 2 * i5;
        }

        public final int a(int i) {
            return i / (this.f11828zn.f11843n3 * 2);
        }

        public final void c5(int i) {
            long x52 = this.f11823i9 + j5.x5(this.f11826t, 1000000L, this.f11828zn.f11845zn);
            int fb2 = fb(i);
            this.f11824n3.gv(x52, 1, fb2, this.f11820f - fb2, null);
            this.f11826t += i;
            this.f11820f -= fb2;
        }

        public final int fb(int i) {
            return s(i, this.f11828zn.f11843n3);
        }

        public final void gv(byte[] bArr, int i, rz rzVar) {
            for (int i5 = 0; i5 < i; i5++) {
                for (int i6 = 0; i6 < this.f11828zn.f11843n3; i6++) {
                    v(bArr, i5, i6, rzVar.v());
                }
            }
            int fb2 = fb(this.f11822gv * i);
            rzVar.oz(0);
            rzVar.j(fb2);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0036 -> B:4:0x001c). Please submit an issue!!! */
        @Override // n6.n3.InterfaceC0163n3
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean n3(e4.tl r7, long r8) throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.f11821fb
                int r1 = r6.f11820f
                int r1 = r6.a(r1)
                int r0 = r0 - r1
                int r1 = r6.f11822gv
                int r0 = v5.j5.t(r0, r1)
                n6.zn r1 = r6.f11828zn
                int r1 = r1.f11844v
                int r0 = r0 * r1
                r1 = 0
                r3 = 1
                int r4 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r4 != 0) goto L1e
            L1c:
                r1 = 1
                goto L1f
            L1e:
                r1 = 0
            L1f:
                if (r1 != 0) goto L3f
                int r2 = r6.f11819c5
                if (r2 >= r0) goto L3f
                int r2 = r0 - r2
                long r4 = (long) r2
                long r4 = java.lang.Math.min(r4, r8)
                int r2 = (int) r4
                byte[] r4 = r6.f11827v
                int r5 = r6.f11819c5
                int r2 = r7.read(r4, r5, r2)
                r4 = -1
                if (r2 != r4) goto L39
                goto L1c
            L39:
                int r4 = r6.f11819c5
                int r4 = r4 + r2
                r6.f11819c5 = r4
                goto L1f
            L3f:
                int r7 = r6.f11819c5
                n6.zn r8 = r6.f11828zn
                int r8 = r8.f11844v
                int r7 = r7 / r8
                if (r7 <= 0) goto L77
                byte[] r8 = r6.f11827v
                v5.rz r9 = r6.f11818a
                r6.gv(r8, r7, r9)
                int r8 = r6.f11819c5
                n6.zn r9 = r6.f11828zn
                int r9 = r9.f11844v
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.f11819c5 = r8
                v5.rz r7 = r6.f11818a
                int r7 = r7.fb()
                e4.ta r8 = r6.f11824n3
                v5.rz r9 = r6.f11818a
                r8.zn(r9, r7)
                int r8 = r6.f11820f
                int r8 = r8 + r7
                r6.f11820f = r8
                int r7 = r6.a(r8)
                int r8 = r6.f11821fb
                if (r7 < r8) goto L77
                r6.c5(r8)
            L77:
                if (r1 == 0) goto L84
                int r7 = r6.f11820f
                int r7 = r6.a(r7)
                if (r7 <= 0) goto L84
                r6.c5(r7)
            L84:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: n6.n3.y.n3(e4.tl, long):boolean");
        }

        public final void v(byte[] bArr, int i, int i5, byte[] bArr2) {
            int i6;
            n6.zn znVar = this.f11828zn;
            int i8 = znVar.f11844v;
            int i10 = znVar.f11843n3;
            int i11 = (i * i8) + (i5 * 4);
            int i12 = (i10 * 4) + i11;
            int i13 = (i8 / i10) - 4;
            int i14 = (short) (((bArr[i11 + 1] & 255) << 8) | (bArr[i11] & 255));
            int min = Math.min(bArr[i11 + 2] & 255, 88);
            int i15 = f11817wz[min];
            int i16 = ((i * this.f11822gv * i10) + i5) * 2;
            bArr2[i16] = (byte) (i14 & 255);
            bArr2[i16 + 1] = (byte) (i14 >> 8);
            for (int i17 = 0; i17 < i13 * 2; i17++) {
                byte b2 = bArr[((i17 / 8) * i10 * 4) + i12 + ((i17 / 2) % 4)];
                int i18 = b2 & 255;
                if (i17 % 2 == 0) {
                    i6 = b2 & 15;
                } else {
                    i6 = i18 >> 4;
                }
                int i19 = ((((i6 & 7) * 2) + 1) * i15) >> 3;
                if ((i6 & 8) != 0) {
                    i19 = -i19;
                }
                i14 = j5.p(i14 + i19, -32768, 32767);
                i16 += i10 * 2;
                bArr2[i16] = (byte) (i14 & 255);
                bArr2[i16 + 1] = (byte) (i14 >> 8);
                int i20 = min + f11816tl[i6];
                int[] iArr = f11817wz;
                min = j5.p(i20, 0, iArr.length - 1);
                i15 = iArr[min];
            }
        }

        @Override // n6.n3.InterfaceC0163n3
        public void y(int i, long j2) {
            this.y.t(new v(this.f11828zn, this.f11822gv, i, j2));
            this.f11824n3.v(this.f11825s);
        }

        @Override // n6.n3.InterfaceC0163n3
        public void zn(long j2) {
            this.f11819c5 = 0;
            this.f11823i9 = j2;
            this.f11820f = 0;
            this.f11826t = 0L;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn implements InterfaceC0163n3 {

        /* renamed from: a  reason: collision with root package name */
        public long f11829a;

        /* renamed from: fb  reason: collision with root package name */
        public int f11830fb;

        /* renamed from: gv  reason: collision with root package name */
        public final m f11831gv;

        /* renamed from: n3  reason: collision with root package name */
        public final ta f11832n3;

        /* renamed from: s  reason: collision with root package name */
        public long f11833s;

        /* renamed from: v  reason: collision with root package name */
        public final int f11834v;
        public final wz y;

        /* renamed from: zn  reason: collision with root package name */
        public final n6.zn f11835zn;

        public zn(wz wzVar, ta taVar, n6.zn znVar, String str, int i) throws ne {
            this.y = wzVar;
            this.f11832n3 = taVar;
            this.f11835zn = znVar;
            int i5 = (znVar.f11843n3 * znVar.f11840a) / 8;
            if (znVar.f11844v == i5) {
                int i6 = znVar.f11845zn;
                int i8 = i6 * i5 * 8;
                int max = Math.max(i5, (i6 * i5) / 10);
                this.f11834v = max;
                this.f11831gv = new m.n3().o4(str).ud(i8).u(i8).f7(max).a8(znVar.f11843n3).rs(znVar.f11845zn).jz(i).z6();
                return;
            }
            throw ne.y("Expected block size: " + i5 + "; got: " + znVar.f11844v, null);
        }

        @Override // n6.n3.InterfaceC0163n3
        public boolean n3(tl tlVar, long j2) throws IOException {
            int i;
            n6.zn znVar;
            int i5;
            int i6;
            long j4 = j2;
            while (true) {
                i = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
                if (i <= 0 || (i5 = this.f11830fb) >= (i6 = this.f11834v)) {
                    break;
                }
                int n32 = this.f11832n3.n3(tlVar, (int) Math.min(i6 - i5, j4), true);
                if (n32 == -1) {
                    j4 = 0;
                } else {
                    this.f11830fb += n32;
                    j4 -= n32;
                }
            }
            int i8 = this.f11835zn.f11844v;
            int i10 = this.f11830fb / i8;
            if (i10 > 0) {
                int i11 = i10 * i8;
                int i12 = this.f11830fb - i11;
                this.f11832n3.gv(this.f11829a + j5.x5(this.f11833s, 1000000L, znVar.f11845zn), 1, i11, i12, null);
                this.f11833s += i10;
                this.f11830fb = i12;
            }
            if (i <= 0) {
                return true;
            }
            return false;
        }

        @Override // n6.n3.InterfaceC0163n3
        public void y(int i, long j2) {
            this.y.t(new v(this.f11835zn, 1, i, j2));
            this.f11832n3.v(this.f11831gv);
        }

        @Override // n6.n3.InterfaceC0163n3
        public void zn(long j2) {
            this.f11829a = j2;
            this.f11830fb = 0;
            this.f11833s = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ t[] fb() {
        return new t[]{new n3()};
    }

    private void gv() {
        v5.y.c5(this.f11813n3);
        j5.i9(this.y);
    }

    @Override // e4.t
    public boolean a(tl tlVar) throws IOException {
        return gv.y(tlVar);
    }

    public final void c5(tl tlVar) throws IOException {
        n6.zn n32 = gv.n3(tlVar);
        int i = n32.y;
        if (i == 17) {
            this.f11814v = new y(this.y, this.f11813n3, n32);
        } else if (i == 6) {
            this.f11814v = new zn(this.y, this.f11813n3, n32, "audio/g711-alaw", -1);
        } else if (i == 7) {
            this.f11814v = new zn(this.y, this.f11813n3, n32, "audio/g711-mlaw", -1);
        } else {
            int y2 = hw.y(i, n32.f11840a);
            if (y2 != 0) {
                this.f11814v = new zn(this.y, this.f11813n3, n32, "audio/raw", y2);
            } else {
                throw ne.s("Unsupported WAV format type: " + n32.y);
            }
        }
        this.f11815zn = 3;
    }

    public final int f(tl tlVar) throws IOException {
        boolean z2;
        if (this.f11811fb != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        if (!((InterfaceC0163n3) v5.y.v(this.f11814v)).n3(tlVar, this.f11811fb - tlVar.getPosition())) {
            return 0;
        }
        return -1;
    }

    public final void i9(tl tlVar) throws IOException {
        this.f11812gv = gv.zn(tlVar);
        this.f11815zn = 2;
    }

    public final void s(tl tlVar) throws IOException {
        boolean z2;
        if (tlVar.getPosition() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        int i = this.f11810a;
        if (i != -1) {
            tlVar.p(i);
            this.f11815zn = 4;
        } else if (gv.y(tlVar)) {
            tlVar.p((int) (tlVar.t() - tlVar.getPosition()));
            this.f11815zn = 1;
        } else {
            throw ne.y("Unsupported or unrecognized wav file type.", null);
        }
    }

    public final void t(tl tlVar) throws IOException {
        Pair<Long, Long> v2 = gv.v(tlVar);
        this.f11810a = ((Long) v2.first).intValue();
        long longValue = ((Long) v2.second).longValue();
        long j2 = this.f11812gv;
        if (j2 != -1 && longValue == 4294967295L) {
            longValue = j2;
        }
        this.f11811fb = this.f11810a + longValue;
        long length = tlVar.getLength();
        if (length != -1 && this.f11811fb > length) {
            r.c5("WavExtractor", "Data exceeds input length: " + this.f11811fb + ", " + length);
            this.f11811fb = length;
        }
        ((InterfaceC0163n3) v5.y.v(this.f11814v)).y(this.f11810a, this.f11811fb);
        this.f11815zn = 4;
    }

    @Override // e4.t
    public int v(tl tlVar, d0 d0Var) throws IOException {
        gv();
        int i = this.f11815zn;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return f(tlVar);
                        }
                        throw new IllegalStateException();
                    }
                    t(tlVar);
                    return 0;
                }
                c5(tlVar);
                return 0;
            }
            i9(tlVar);
            return 0;
        }
        s(tlVar);
        return 0;
    }

    @Override // e4.t
    public void y(long j2, long j4) {
        int i;
        if (j2 == 0) {
            i = 0;
        } else {
            i = 4;
        }
        this.f11815zn = i;
        InterfaceC0163n3 interfaceC0163n3 = this.f11814v;
        if (interfaceC0163n3 != null) {
            interfaceC0163n3.zn(j4);
        }
    }

    @Override // e4.t
    public void zn(wz wzVar) {
        this.y = wzVar;
        this.f11813n3 = wzVar.a(0, 1);
        wzVar.xc();
    }

    @Override // e4.t
    public void release() {
    }
}
