package y3;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import java.util.Arrays;
import y3.ud;
/* loaded from: classes.dex */
public final class wz implements tl {

    /* renamed from: p  reason: collision with root package name */
    public static final double[] f15211p = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a  reason: collision with root package name */
    public final boolean[] f15212a;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f15213c5;

    /* renamed from: f  reason: collision with root package name */
    public long f15214f;

    /* renamed from: fb  reason: collision with root package name */
    public final y f15215fb;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public final v5.rz f15216gv;

    /* renamed from: i9  reason: collision with root package name */
    public boolean f15217i9;

    /* renamed from: n3  reason: collision with root package name */
    public e4.ta f15218n3;

    /* renamed from: s  reason: collision with root package name */
    public long f15219s;

    /* renamed from: t  reason: collision with root package name */
    public long f15220t;

    /* renamed from: tl  reason: collision with root package name */
    public long f15221tl;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final r f15222v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f15223w;

    /* renamed from: wz  reason: collision with root package name */
    public long f15224wz;

    /* renamed from: xc  reason: collision with root package name */
    public boolean f15225xc;
    public String y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public final x f15226zn;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: v  reason: collision with root package name */
        public static final byte[] f15227v = {0, 0, 1};

        /* renamed from: gv  reason: collision with root package name */
        public byte[] f15228gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f15229n3;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public int f15230zn;

        public y(int i) {
            this.f15228gv = new byte[i];
        }

        public boolean n3(int i, int i5) {
            if (this.y) {
                int i6 = this.f15229n3 - i5;
                this.f15229n3 = i6;
                if (this.f15230zn == 0 && i == 181) {
                    this.f15230zn = i6;
                } else {
                    this.y = false;
                    return true;
                }
            } else if (i == 179) {
                this.y = true;
            }
            byte[] bArr = f15227v;
            y(bArr, 0, bArr.length);
            return false;
        }

        public void y(byte[] bArr, int i, int i5) {
            if (!this.y) {
                return;
            }
            int i6 = i5 - i;
            byte[] bArr2 = this.f15228gv;
            int length = bArr2.length;
            int i8 = this.f15229n3;
            if (length < i8 + i6) {
                this.f15228gv = Arrays.copyOf(bArr2, (i8 + i6) * 2);
            }
            System.arraycopy(bArr, i, this.f15228gv, this.f15229n3, i6);
            this.f15229n3 += i6;
        }

        public void zn() {
            this.y = false;
            this.f15229n3 = 0;
            this.f15230zn = 0;
        }
    }

    public wz() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair<m1.m, java.lang.Long> y(y3.wz.y r8, java.lang.String r9) {
        /*
            byte[] r0 = r8.f15228gv
            int r1 = r8.f15229n3
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            r1 = 4
            r2 = r0[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 5
            r4 = r0[r3]
            r5 = r4 & 255(0xff, float:3.57E-43)
            r6 = 6
            r6 = r0[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r1
            int r5 = r5 >> r1
            r2 = r2 | r5
            r4 = r4 & 15
            int r4 = r4 << 8
            r4 = r4 | r6
            r5 = 7
            r6 = r0[r5]
            r6 = r6 & 240(0xf0, float:3.36E-43)
            int r6 = r6 >> r1
            r7 = 2
            if (r6 == r7) goto L3e
            r7 = 3
            if (r6 == r7) goto L38
            if (r6 == r1) goto L30
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L44
        L30:
            int r1 = r4 * 121
            float r1 = (float) r1
            int r6 = r2 * 100
        L35:
            float r6 = (float) r6
            float r1 = r1 / r6
            goto L44
        L38:
            int r1 = r4 * 16
            float r1 = (float) r1
            int r6 = r2 * 9
            goto L35
        L3e:
            int r1 = r4 * 4
            float r1 = (float) r1
            int r6 = r2 * 3
            goto L35
        L44:
            m1.m$n3 r6 = new m1.m$n3
            r6.<init>()
            m1.m$n3 r9 = r6.oz(r9)
            java.lang.String r6 = "video/mpeg2"
            m1.m$n3 r9 = r9.o4(r6)
            m1.m$n3 r9 = r9.s8(r2)
            m1.m$n3 r9 = r9.o(r4)
            m1.m$n3 r9 = r9.y5(r1)
            java.util.List r1 = java.util.Collections.singletonList(r0)
            m1.m$n3 r9 = r9.ut(r1)
            m1.m r9 = r9.z6()
            r1 = r0[r5]
            r1 = r1 & 15
            int r1 = r1 + (-1)
            if (r1 < 0) goto L99
            double[] r2 = y3.wz.f15211p
            int r4 = r2.length
            if (r1 >= r4) goto L99
            r1 = r2[r1]
            int r8 = r8.f15230zn
            int r8 = r8 + 9
            r8 = r0[r8]
            r0 = r8 & 96
            int r0 = r0 >> r3
            r8 = r8 & 31
            if (r0 == r8) goto L91
            double r3 = (double) r0
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r5
            int r8 = r8 + 1
            double r5 = (double) r8
            double r3 = r3 / r5
            double r1 = r1 * r3
        L91:
            r3 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r3 = r3 / r1
            long r0 = (long) r3
            goto L9b
        L99:
            r0 = 0
        L9b:
            java.lang.Long r8 = java.lang.Long.valueOf(r0)
            android.util.Pair r8 = android.util.Pair.create(r9, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.wz.y(y3.wz$y, java.lang.String):android.util.Pair");
    }

    @Override // y3.tl
    public void a(long j2, int i) {
        this.f15220t = j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0142  */
    @Override // y3.tl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n3(v5.rz r21) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.wz.n3(v5.rz):void");
    }

    @Override // y3.tl
    public void v(e4.wz wzVar, ud.gv gvVar) {
        gvVar.y();
        this.y = gvVar.n3();
        this.f15218n3 = wzVar.a(gvVar.zn(), 2);
        x xVar = this.f15226zn;
        if (xVar != null) {
            xVar.n3(wzVar, gvVar);
        }
    }

    @Override // y3.tl
    public void zn() {
        v5.c.y(this.f15212a);
        this.f15215fb.zn();
        r rVar = this.f15222v;
        if (rVar != null) {
            rVar.gv();
        }
        this.f15219s = 0L;
        this.f15213c5 = false;
        this.f15220t = -9223372036854775807L;
        this.f15224wz = -9223372036854775807L;
    }

    public wz(@Nullable x xVar) {
        this.f15226zn = xVar;
        this.f15212a = new boolean[4];
        this.f15215fb = new y(NotificationCompat.FLAG_HIGH_PRIORITY);
        if (xVar != null) {
            this.f15222v = new r(178, NotificationCompat.FLAG_HIGH_PRIORITY);
            this.f15216gv = new v5.rz();
        } else {
            this.f15222v = null;
            this.f15216gv = null;
        }
        this.f15220t = -9223372036854775807L;
        this.f15224wz = -9223372036854775807L;
    }

    @Override // y3.tl
    public void gv() {
    }
}
