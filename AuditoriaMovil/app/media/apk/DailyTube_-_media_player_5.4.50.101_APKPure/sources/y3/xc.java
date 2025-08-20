package y3;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import java.util.Arrays;
import java.util.Collections;
import m1.m;
import v5.j5;
import y3.ud;
/* loaded from: classes.dex */
public final class xc implements tl {

    /* renamed from: t  reason: collision with root package name */
    public static final float[] f15234t = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    public n3 f15235a;

    /* renamed from: c5  reason: collision with root package name */
    public e4.ta f15236c5;

    /* renamed from: fb  reason: collision with root package name */
    public long f15238fb;

    /* renamed from: i9  reason: collision with root package name */
    public boolean f15240i9;
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public final v5.rz f15241n3;

    /* renamed from: s  reason: collision with root package name */
    public String f15242s;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final r f15243v;
    @Nullable
    public final x y;

    /* renamed from: zn  reason: collision with root package name */
    public final boolean[] f15244zn = new boolean[4];

    /* renamed from: gv  reason: collision with root package name */
    public final y f15239gv = new y(NotificationCompat.FLAG_HIGH_PRIORITY);

    /* renamed from: f  reason: collision with root package name */
    public long f15237f = -9223372036854775807L;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: a  reason: collision with root package name */
        public int f15245a;

        /* renamed from: fb  reason: collision with root package name */
        public long f15246fb;

        /* renamed from: gv  reason: collision with root package name */
        public boolean f15247gv;

        /* renamed from: n3  reason: collision with root package name */
        public boolean f15248n3;

        /* renamed from: s  reason: collision with root package name */
        public long f15249s;

        /* renamed from: v  reason: collision with root package name */
        public int f15250v;
        public final e4.ta y;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f15251zn;

        public n3(e4.ta taVar) {
            this.y = taVar;
        }

        public void gv() {
            this.f15248n3 = false;
            this.f15251zn = false;
            this.f15247gv = false;
            this.f15250v = -1;
        }

        public void n3(long j2, int i, boolean z2) {
            if (this.f15250v == 182 && z2 && this.f15248n3) {
                long j4 = this.f15249s;
                if (j4 != -9223372036854775807L) {
                    this.y.gv(j4, this.f15247gv ? 1 : 0, (int) (j2 - this.f15246fb), i, null);
                }
            }
            if (this.f15250v != 179) {
                this.f15246fb = j2;
            }
        }

        public void y(byte[] bArr, int i, int i5) {
            boolean z2;
            if (this.f15251zn) {
                int i6 = this.f15245a;
                int i8 = (i + 1) - i6;
                if (i8 < i5) {
                    if (((bArr[i8] & 192) >> 6) == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.f15247gv = z2;
                    this.f15251zn = false;
                    return;
                }
                this.f15245a = i6 + (i5 - i);
            }
        }

        public void zn(int i, long j2) {
            boolean z2;
            this.f15250v = i;
            this.f15247gv = false;
            boolean z3 = true;
            if (i != 182 && i != 179) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.f15248n3 = z2;
            if (i != 182) {
                z3 = false;
            }
            this.f15251zn = z3;
            this.f15245a = 0;
            this.f15249s = j2;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        public static final byte[] f15252a = {0, 0, 1};

        /* renamed from: gv  reason: collision with root package name */
        public int f15253gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f15254n3;

        /* renamed from: v  reason: collision with root package name */
        public byte[] f15255v;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public int f15256zn;

        public y(int i) {
            this.f15255v = new byte[i];
        }

        public boolean n3(int i, int i5) {
            int i6 = this.f15254n3;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 != 3) {
                            if (i6 == 4) {
                                if (i == 179 || i == 181) {
                                    this.f15256zn -= i5;
                                    this.y = false;
                                    return true;
                                }
                            } else {
                                throw new IllegalStateException();
                            }
                        } else if ((i & 240) != 32) {
                            v5.r.c5("H263Reader", "Unexpected start code value");
                            zn();
                        } else {
                            this.f15253gv = this.f15256zn;
                            this.f15254n3 = 4;
                        }
                    } else if (i > 31) {
                        v5.r.c5("H263Reader", "Unexpected start code value");
                        zn();
                    } else {
                        this.f15254n3 = 3;
                    }
                } else if (i != 181) {
                    v5.r.c5("H263Reader", "Unexpected start code value");
                    zn();
                } else {
                    this.f15254n3 = 2;
                }
            } else if (i == 176) {
                this.f15254n3 = 1;
                this.y = true;
            }
            byte[] bArr = f15252a;
            y(bArr, 0, bArr.length);
            return false;
        }

        public void y(byte[] bArr, int i, int i5) {
            if (!this.y) {
                return;
            }
            int i6 = i5 - i;
            byte[] bArr2 = this.f15255v;
            int length = bArr2.length;
            int i8 = this.f15256zn;
            if (length < i8 + i6) {
                this.f15255v = Arrays.copyOf(bArr2, (i8 + i6) * 2);
            }
            System.arraycopy(bArr, i, this.f15255v, this.f15256zn, i6);
            this.f15256zn += i6;
        }

        public void zn() {
            this.y = false;
            this.f15256zn = 0;
            this.f15254n3 = 0;
        }
    }

    public xc(@Nullable x xVar) {
        this.y = xVar;
        if (xVar != null) {
            this.f15243v = new r(178, NotificationCompat.FLAG_HIGH_PRIORITY);
            this.f15241n3 = new v5.rz();
            return;
        }
        this.f15243v = null;
        this.f15241n3 = null;
    }

    public static m y(y yVar, int i, String str) {
        byte[] copyOf = Arrays.copyOf(yVar.f15255v, yVar.f15256zn);
        v5.fh fhVar = new v5.fh(copyOf);
        fhVar.co(i);
        fhVar.co(4);
        fhVar.p();
        fhVar.mt(8);
        if (fhVar.fb()) {
            fhVar.mt(4);
            fhVar.mt(3);
        }
        int s2 = fhVar.s(4);
        float f4 = 1.0f;
        if (s2 == 15) {
            int s3 = fhVar.s(8);
            int s4 = fhVar.s(8);
            if (s4 == 0) {
                v5.r.c5("H263Reader", "Invalid aspect ratio");
            } else {
                f4 = s3 / s4;
            }
        } else {
            float[] fArr = f15234t;
            if (s2 < fArr.length) {
                f4 = fArr[s2];
            } else {
                v5.r.c5("H263Reader", "Invalid aspect ratio");
            }
        }
        if (fhVar.fb()) {
            fhVar.mt(2);
            fhVar.mt(1);
            if (fhVar.fb()) {
                fhVar.mt(15);
                fhVar.p();
                fhVar.mt(15);
                fhVar.p();
                fhVar.mt(15);
                fhVar.p();
                fhVar.mt(3);
                fhVar.mt(11);
                fhVar.p();
                fhVar.mt(15);
                fhVar.p();
            }
        }
        if (fhVar.s(2) != 0) {
            v5.r.c5("H263Reader", "Unhandled video object layer shape");
        }
        fhVar.p();
        int s5 = fhVar.s(16);
        fhVar.p();
        if (fhVar.fb()) {
            if (s5 == 0) {
                v5.r.c5("H263Reader", "Invalid vop_increment_time_resolution");
            } else {
                int i5 = 0;
                for (int i6 = s5 - 1; i6 > 0; i6 >>= 1) {
                    i5++;
                }
                fhVar.mt(i5);
            }
        }
        fhVar.p();
        int s7 = fhVar.s(13);
        fhVar.p();
        int s9 = fhVar.s(13);
        fhVar.p();
        fhVar.p();
        return new m.n3().oz(str).o4("video/mp4v-es").s8(s7).o(s9).y5(f4).ut(Collections.singletonList(copyOf)).z6();
    }

    @Override // y3.tl
    public void a(long j2, int i) {
        if (j2 != -9223372036854775807L) {
            this.f15237f = j2;
        }
    }

    @Override // y3.tl
    public void n3(v5.rz rzVar) {
        int i;
        v5.y.c5(this.f15235a);
        v5.y.c5(this.f15236c5);
        int a2 = rzVar.a();
        int fb2 = rzVar.fb();
        byte[] v2 = rzVar.v();
        this.f15238fb += rzVar.y();
        this.f15236c5.zn(rzVar, rzVar.y());
        while (true) {
            int zn2 = v5.c.zn(v2, a2, fb2, this.f15244zn);
            if (zn2 == fb2) {
                break;
            }
            int i5 = zn2 + 3;
            int i6 = rzVar.v()[i5] & 255;
            int i8 = zn2 - a2;
            int i10 = 0;
            if (!this.f15240i9) {
                if (i8 > 0) {
                    this.f15239gv.y(v2, a2, zn2);
                }
                if (i8 < 0) {
                    i = -i8;
                } else {
                    i = 0;
                }
                if (this.f15239gv.n3(i6, i)) {
                    e4.ta taVar = this.f15236c5;
                    y yVar = this.f15239gv;
                    taVar.v(y(yVar, yVar.f15253gv, (String) v5.y.v(this.f15242s)));
                    this.f15240i9 = true;
                }
            }
            this.f15235a.y(v2, a2, zn2);
            r rVar = this.f15243v;
            if (rVar != null) {
                if (i8 > 0) {
                    rVar.y(v2, a2, zn2);
                } else {
                    i10 = -i8;
                }
                if (this.f15243v.n3(i10)) {
                    r rVar2 = this.f15243v;
                    ((v5.rz) j5.i9(this.f15241n3)).o(this.f15243v.f15124gv, v5.c.p(rVar2.f15124gv, rVar2.f15126v));
                    ((x) j5.i9(this.y)).y(this.f15237f, this.f15241n3);
                }
                if (i6 == 178 && rzVar.v()[zn2 + 2] == 1) {
                    this.f15243v.v(i6);
                }
            }
            int i11 = fb2 - zn2;
            this.f15235a.n3(this.f15238fb - i11, i11, this.f15240i9);
            this.f15235a.zn(i6, this.f15237f);
            a2 = i5;
        }
        if (!this.f15240i9) {
            this.f15239gv.y(v2, a2, fb2);
        }
        this.f15235a.y(v2, a2, fb2);
        r rVar3 = this.f15243v;
        if (rVar3 != null) {
            rVar3.y(v2, a2, fb2);
        }
    }

    @Override // y3.tl
    public void v(e4.wz wzVar, ud.gv gvVar) {
        gvVar.y();
        this.f15242s = gvVar.n3();
        e4.ta a2 = wzVar.a(gvVar.zn(), 2);
        this.f15236c5 = a2;
        this.f15235a = new n3(a2);
        x xVar = this.y;
        if (xVar != null) {
            xVar.n3(wzVar, gvVar);
        }
    }

    @Override // y3.tl
    public void zn() {
        v5.c.y(this.f15244zn);
        this.f15239gv.zn();
        n3 n3Var = this.f15235a;
        if (n3Var != null) {
            n3Var.gv();
        }
        r rVar = this.f15243v;
        if (rVar != null) {
            rVar.gv();
        }
        this.f15238fb = 0L;
        this.f15237f = -9223372036854775807L;
    }

    @Override // y3.tl
    public void gv() {
    }
}
