package y3;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import java.util.Collections;
import m1.m;
import v5.c;
import v5.j5;
import y3.ud;
/* loaded from: classes.dex */
public final class p implements tl {

    /* renamed from: gv  reason: collision with root package name */
    public y f15103gv;

    /* renamed from: n3  reason: collision with root package name */
    public String f15105n3;

    /* renamed from: t  reason: collision with root package name */
    public long f15107t;

    /* renamed from: v  reason: collision with root package name */
    public boolean f15109v;
    public final mg y;

    /* renamed from: zn  reason: collision with root package name */
    public e4.ta f15111zn;

    /* renamed from: a  reason: collision with root package name */
    public final boolean[] f15099a = new boolean[3];

    /* renamed from: fb  reason: collision with root package name */
    public final r f15102fb = new r(32, NotificationCompat.FLAG_HIGH_PRIORITY);

    /* renamed from: s  reason: collision with root package name */
    public final r f15106s = new r(33, NotificationCompat.FLAG_HIGH_PRIORITY);

    /* renamed from: c5  reason: collision with root package name */
    public final r f15100c5 = new r(34, NotificationCompat.FLAG_HIGH_PRIORITY);

    /* renamed from: i9  reason: collision with root package name */
    public final r f15104i9 = new r(39, NotificationCompat.FLAG_HIGH_PRIORITY);

    /* renamed from: f  reason: collision with root package name */
    public final r f15101f = new r(40, NotificationCompat.FLAG_HIGH_PRIORITY);

    /* renamed from: tl  reason: collision with root package name */
    public long f15108tl = -9223372036854775807L;

    /* renamed from: wz  reason: collision with root package name */
    public final v5.rz f15110wz = new v5.rz();

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        public boolean f15112a;

        /* renamed from: c5  reason: collision with root package name */
        public boolean f15113c5;

        /* renamed from: f  reason: collision with root package name */
        public long f15114f;

        /* renamed from: fb  reason: collision with root package name */
        public boolean f15115fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f15116gv;

        /* renamed from: i9  reason: collision with root package name */
        public boolean f15117i9;

        /* renamed from: n3  reason: collision with root package name */
        public long f15118n3;

        /* renamed from: s  reason: collision with root package name */
        public boolean f15119s;

        /* renamed from: t  reason: collision with root package name */
        public long f15120t;

        /* renamed from: tl  reason: collision with root package name */
        public boolean f15121tl;

        /* renamed from: v  reason: collision with root package name */
        public long f15122v;
        public final e4.ta y;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f15123zn;

        public y(e4.ta taVar) {
            this.y = taVar;
        }

        public static boolean n3(int i) {
            if ((32 <= i && i <= 35) || i == 39) {
                return true;
            }
            return false;
        }

        public static boolean zn(int i) {
            if (i >= 32 && i != 40) {
                return false;
            }
            return true;
        }

        public void a() {
            this.f15112a = false;
            this.f15115fb = false;
            this.f15119s = false;
            this.f15113c5 = false;
            this.f15117i9 = false;
        }

        public void fb(long j2, int i, int i5, long j4, boolean z2) {
            boolean z3;
            boolean z4 = false;
            this.f15115fb = false;
            this.f15119s = false;
            this.f15122v = j4;
            this.f15116gv = 0;
            this.f15118n3 = j2;
            if (!zn(i5)) {
                if (this.f15113c5 && !this.f15117i9) {
                    if (z2) {
                        gv(i);
                    }
                    this.f15113c5 = false;
                }
                if (n3(i5)) {
                    this.f15119s = !this.f15117i9;
                    this.f15117i9 = true;
                }
            }
            if (i5 >= 16 && i5 <= 21) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f15123zn = z3;
            this.f15112a = (z3 || i5 <= 9) ? true : true;
        }

        public final void gv(int i) {
            long j2 = this.f15120t;
            if (j2 == -9223372036854775807L) {
                return;
            }
            boolean z2 = this.f15121tl;
            this.y.gv(j2, z2 ? 1 : 0, (int) (this.f15118n3 - this.f15114f), i, null);
        }

        public void v(byte[] bArr, int i, int i5) {
            boolean z2;
            if (this.f15112a) {
                int i6 = this.f15116gv;
                int i8 = (i + 2) - i6;
                if (i8 < i5) {
                    if ((bArr[i8] & 128) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.f15115fb = z2;
                    this.f15112a = false;
                    return;
                }
                this.f15116gv = i6 + (i5 - i);
            }
        }

        public void y(long j2, int i, boolean z2) {
            if (this.f15117i9 && this.f15115fb) {
                this.f15121tl = this.f15123zn;
                this.f15117i9 = false;
            } else if (this.f15119s || this.f15115fb) {
                if (z2 && this.f15113c5) {
                    gv(i + ((int) (j2 - this.f15118n3)));
                }
                this.f15114f = this.f15118n3;
                this.f15120t = this.f15122v;
                this.f15121tl = this.f15123zn;
                this.f15113c5 = true;
            }
        }
    }

    public p(mg mgVar) {
        this.y = mgVar;
    }

    public static m c5(@Nullable String str, r rVar, r rVar2, r rVar3) {
        int i = rVar.f15126v;
        byte[] bArr = new byte[rVar2.f15126v + i + rVar3.f15126v];
        System.arraycopy(rVar.f15124gv, 0, bArr, 0, i);
        System.arraycopy(rVar2.f15124gv, 0, bArr, rVar.f15126v, rVar2.f15126v);
        System.arraycopy(rVar3.f15124gv, 0, bArr, rVar.f15126v + rVar2.f15126v, rVar3.f15126v);
        c.y s2 = v5.c.s(rVar2.f15124gv, 3, rVar2.f15126v);
        return new m.n3().oz(str).o4("video/hevc").x(v5.a.zn(s2.y, s2.f14318n3, s2.f14323zn, s2.f14316gv, s2.f14322v, s2.f14312a)).s8(s2.f14319s).o(s2.f14313c5).y5(s2.f14317i9).ut(Collections.singletonList(bArr)).z6();
    }

    private void fb(long j2, int i, int i5, long j4) {
        this.f15103gv.y(j2, i, this.f15109v);
        if (!this.f15109v) {
            this.f15102fb.n3(i5);
            this.f15106s.n3(i5);
            this.f15100c5.n3(i5);
            if (this.f15102fb.zn() && this.f15106s.zn() && this.f15100c5.zn()) {
                this.f15111zn.v(c5(this.f15105n3, this.f15102fb, this.f15106s, this.f15100c5));
                this.f15109v = true;
            }
        }
        if (this.f15104i9.n3(i5)) {
            r rVar = this.f15104i9;
            this.f15110wz.o(this.f15104i9.f15124gv, v5.c.p(rVar.f15124gv, rVar.f15126v));
            this.f15110wz.ut(5);
            this.y.y(j4, this.f15110wz);
        }
        if (this.f15101f.n3(i5)) {
            r rVar2 = this.f15101f;
            this.f15110wz.o(this.f15101f.f15124gv, v5.c.p(rVar2.f15124gv, rVar2.f15126v));
            this.f15110wz.ut(5);
            this.y.y(j4, this.f15110wz);
        }
    }

    private void s(byte[] bArr, int i, int i5) {
        this.f15103gv.v(bArr, i, i5);
        if (!this.f15109v) {
            this.f15102fb.y(bArr, i, i5);
            this.f15106s.y(bArr, i, i5);
            this.f15100c5.y(bArr, i, i5);
        }
        this.f15104i9.y(bArr, i, i5);
        this.f15101f.y(bArr, i, i5);
    }

    private void y() {
        v5.y.c5(this.f15111zn);
        j5.i9(this.f15103gv);
    }

    @Override // y3.tl
    public void a(long j2, int i) {
        if (j2 != -9223372036854775807L) {
            this.f15108tl = j2;
        }
    }

    public final void i9(long j2, int i, int i5, long j4) {
        this.f15103gv.fb(j2, i, i5, j4, this.f15109v);
        if (!this.f15109v) {
            this.f15102fb.v(i5);
            this.f15106s.v(i5);
            this.f15100c5.v(i5);
        }
        this.f15104i9.v(i5);
        this.f15101f.v(i5);
    }

    @Override // y3.tl
    public void n3(v5.rz rzVar) {
        int i;
        y();
        while (rzVar.y() > 0) {
            int a2 = rzVar.a();
            int fb2 = rzVar.fb();
            byte[] v2 = rzVar.v();
            this.f15107t += rzVar.y();
            this.f15111zn.zn(rzVar, rzVar.y());
            while (a2 < fb2) {
                int zn2 = v5.c.zn(v2, a2, fb2, this.f15099a);
                if (zn2 == fb2) {
                    s(v2, a2, fb2);
                    return;
                }
                int v3 = v5.c.v(v2, zn2);
                int i5 = zn2 - a2;
                if (i5 > 0) {
                    s(v2, a2, zn2);
                }
                int i6 = fb2 - zn2;
                long j2 = this.f15107t - i6;
                if (i5 < 0) {
                    i = -i5;
                } else {
                    i = 0;
                }
                fb(j2, i6, i, this.f15108tl);
                i9(j2, i6, v3, this.f15108tl);
                a2 = zn2 + 3;
            }
        }
    }

    @Override // y3.tl
    public void v(e4.wz wzVar, ud.gv gvVar) {
        gvVar.y();
        this.f15105n3 = gvVar.n3();
        e4.ta a2 = wzVar.a(gvVar.zn(), 2);
        this.f15111zn = a2;
        this.f15103gv = new y(a2);
        this.y.n3(wzVar, gvVar);
    }

    @Override // y3.tl
    public void zn() {
        this.f15107t = 0L;
        this.f15108tl = -9223372036854775807L;
        v5.c.y(this.f15099a);
        this.f15102fb.gv();
        this.f15106s.gv();
        this.f15100c5.gv();
        this.f15104i9.gv();
        this.f15101f.gv();
        y yVar = this.f15103gv;
        if (yVar != null) {
            yVar.a();
        }
    }

    @Override // y3.tl
    public void gv() {
    }
}
