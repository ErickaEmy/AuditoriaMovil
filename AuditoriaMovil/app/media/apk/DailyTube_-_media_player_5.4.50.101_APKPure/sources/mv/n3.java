package mv;

import androidx.annotation.Nullable;
import e4.co;
import e4.fh;
import e4.r;
import e4.tl;
import e4.x4;
import e4.z;
import java.util.Arrays;
import mv.c5;
import v5.j5;
import v5.rz;
/* loaded from: classes.dex */
public final class n3 extends c5 {
    @Nullable

    /* renamed from: wz  reason: collision with root package name */
    public x4 f11605wz;
    @Nullable

    /* renamed from: xc  reason: collision with root package name */
    public y f11606xc;

    /* loaded from: classes.dex */
    public static final class y implements fb {

        /* renamed from: n3  reason: collision with root package name */
        public x4.y f11608n3;
        public x4 y;

        /* renamed from: zn  reason: collision with root package name */
        public long f11609zn = -1;

        /* renamed from: gv  reason: collision with root package name */
        public long f11607gv = -1;

        public y(x4 x4Var, x4.y yVar) {
            this.y = x4Var;
            this.f11608n3 = yVar;
        }

        public void gv(long j2) {
            this.f11609zn = j2;
        }

        @Override // mv.fb
        public long n3(tl tlVar) {
            long j2 = this.f11607gv;
            if (j2 < 0) {
                return -1L;
            }
            long j4 = -(j2 + 2);
            this.f11607gv = -1L;
            return j4;
        }

        @Override // mv.fb
        public fh y() {
            boolean z2;
            if (this.f11609zn != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.fb(z2);
            return new r(this.y, this.f11609zn);
        }

        @Override // mv.fb
        public void zn(long j2) {
            long[] jArr = this.f11608n3.y;
            this.f11607gv = jArr[j5.c5(jArr, j2, true, true)];
        }
    }

    public static boolean w(rz rzVar) {
        if (rzVar.y() >= 5 && rzVar.ej() == 127 && rzVar.a8() == 1179402563) {
            return true;
        }
        return false;
    }

    public static boolean xc(byte[] bArr) {
        if (bArr[0] != -1) {
            return false;
        }
        return true;
    }

    @Override // mv.c5
    public long a(rz rzVar) {
        if (!xc(rzVar.v())) {
            return -1L;
        }
        return wz(rzVar);
    }

    @Override // mv.c5
    public boolean c5(rz rzVar, long j2, c5.n3 n3Var) {
        byte[] v2 = rzVar.v();
        x4 x4Var = this.f11605wz;
        if (x4Var == null) {
            x4 x4Var2 = new x4(v2, 17);
            this.f11605wz = x4Var2;
            n3Var.y = x4Var2.fb(Arrays.copyOfRange(v2, 9, rzVar.fb()), null);
            return true;
        } else if ((v2[0] & Byte.MAX_VALUE) == 3) {
            x4.y fb2 = z.fb(rzVar);
            x4 n32 = x4Var.n3(fb2);
            this.f11605wz = n32;
            this.f11606xc = new y(n32, fb2);
            return true;
        } else if (!xc(v2)) {
            return true;
        } else {
            y yVar = this.f11606xc;
            if (yVar != null) {
                yVar.gv(j2);
                n3Var.f11592n3 = this.f11606xc;
            }
            v5.y.v(n3Var.y);
            return false;
        }
    }

    @Override // mv.c5
    public void t(boolean z2) {
        super.t(z2);
        if (z2) {
            this.f11605wz = null;
            this.f11606xc = null;
        }
    }

    public final int wz(rz rzVar) {
        int i = (rzVar.v()[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            rzVar.ut(4);
            rzVar.vl();
        }
        int i92 = co.i9(rzVar, i);
        rzVar.oz(0);
        return i92;
    }
}
