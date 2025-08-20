package af;

import af.f7;
import androidx.annotation.Nullable;
import e4.ta;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kx.n3;
/* loaded from: classes.dex */
public class q9 {

    /* renamed from: a  reason: collision with root package name */
    public y f363a;

    /* renamed from: fb  reason: collision with root package name */
    public long f364fb;

    /* renamed from: gv  reason: collision with root package name */
    public y f365gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f366n3;

    /* renamed from: v  reason: collision with root package name */
    public y f367v;
    public final kx.n3 y;

    /* renamed from: zn  reason: collision with root package name */
    public final v5.rz f368zn;

    /* loaded from: classes.dex */
    public static final class y implements n3.y {
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public y f369gv;

        /* renamed from: n3  reason: collision with root package name */
        public long f370n3;
        public long y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public kx.y f371zn;

        public y(long j2, int i) {
            gv(j2, i);
        }

        public void gv(long j2, int i) {
            boolean z2;
            if (this.f371zn == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.fb(z2);
            this.y = j2;
            this.f370n3 = j2 + i;
        }

        public y n3() {
            this.f371zn = null;
            y yVar = this.f369gv;
            this.f369gv = null;
            return yVar;
        }

        @Override // kx.n3.y
        @Nullable
        public n3.y next() {
            y yVar = this.f369gv;
            if (yVar != null && yVar.f371zn != null) {
                return yVar;
            }
            return null;
        }

        public int v(long j2) {
            return ((int) (j2 - this.y)) + this.f371zn.f10162n3;
        }

        @Override // kx.n3.y
        public kx.y y() {
            return (kx.y) v5.y.v(this.f371zn);
        }

        public void zn(kx.y yVar, y yVar2) {
            this.f371zn = yVar;
            this.f369gv = yVar2;
        }
    }

    public q9(kx.n3 n3Var) {
        this.y = n3Var;
        int v2 = n3Var.v();
        this.f366n3 = v2;
        this.f368zn = new v5.rz(32);
        y yVar = new y(0L, v2);
        this.f365gv = yVar;
        this.f367v = yVar;
        this.f363a = yVar;
    }

    public static y c5(y yVar, long j2, ByteBuffer byteBuffer, int i) {
        y gv2 = gv(yVar, j2);
        while (i > 0) {
            int min = Math.min(i, (int) (gv2.f370n3 - j2));
            byteBuffer.put(gv2.f371zn.y, gv2.v(j2), min);
            i -= min;
            j2 += min;
            if (j2 == gv2.f370n3) {
                gv2 = gv2.f369gv;
            }
        }
        return gv2;
    }

    public static y f(y yVar, a9.fb fbVar, f7.n3 n3Var, v5.rz rzVar) {
        boolean z2;
        int i;
        long j2 = n3Var.f227n3;
        rzVar.j5(1);
        y i92 = i9(yVar, j2, rzVar.v(), 1);
        long j4 = j2 + 1;
        byte b2 = rzVar.v()[0];
        if ((b2 & 128) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i5 = b2 & Byte.MAX_VALUE;
        a9.zn znVar = fbVar.f60v;
        byte[] bArr = znVar.y;
        if (bArr == null) {
            znVar.y = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        y i93 = i9(i92, j4, znVar.y, i5);
        long j6 = j4 + i5;
        if (z2) {
            rzVar.j5(2);
            i93 = i9(i93, j6, rzVar.v(), 2);
            j6 += 2;
            i = rzVar.yt();
        } else {
            i = 1;
        }
        int[] iArr = znVar.f90gv;
        if (iArr == null || iArr.length < i) {
            iArr = new int[i];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = znVar.f94v;
        if (iArr3 == null || iArr3.length < i) {
            iArr3 = new int[i];
        }
        int[] iArr4 = iArr3;
        if (z2) {
            int i6 = i * 6;
            rzVar.j5(i6);
            i93 = i9(i93, j6, rzVar.v(), i6);
            j6 += i6;
            rzVar.oz(0);
            for (int i8 = 0; i8 < i; i8++) {
                iArr2[i8] = rzVar.yt();
                iArr4[i8] = rzVar.b();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = n3Var.y - ((int) (j6 - n3Var.f227n3));
        }
        ta.y yVar2 = (ta.y) v5.j5.i9(n3Var.f228zn);
        znVar.zn(i, iArr2, iArr4, yVar2.f7514n3, znVar.y, yVar2.y, yVar2.f7515zn, yVar2.f7513gv);
        long j7 = n3Var.f227n3;
        int i10 = (int) (j6 - j7);
        n3Var.f227n3 = j7 + i10;
        n3Var.y -= i10;
        return i93;
    }

    public static y gv(y yVar, long j2) {
        while (j2 >= yVar.f370n3) {
            yVar = yVar.f369gv;
        }
        return yVar;
    }

    public static y i9(y yVar, long j2, byte[] bArr, int i) {
        y gv2 = gv(yVar, j2);
        int i5 = i;
        while (i5 > 0) {
            int min = Math.min(i5, (int) (gv2.f370n3 - j2));
            System.arraycopy(gv2.f371zn.y, gv2.v(j2), bArr, i - i5, min);
            i5 -= min;
            j2 += min;
            if (j2 == gv2.f370n3) {
                gv2 = gv2.f369gv;
            }
        }
        return gv2;
    }

    public static y t(y yVar, a9.fb fbVar, f7.n3 n3Var, v5.rz rzVar) {
        if (fbVar.z()) {
            yVar = f(yVar, fbVar, n3Var, rzVar);
        }
        if (fbVar.c5()) {
            rzVar.j5(4);
            y i92 = i9(yVar, n3Var.f227n3, rzVar.v(), 4);
            int b2 = rzVar.b();
            n3Var.f227n3 += 4;
            n3Var.y -= 4;
            fbVar.mt(b2);
            y c52 = c5(i92, n3Var.f227n3, fbVar.f56fb, b2);
            n3Var.f227n3 += b2;
            int i = n3Var.y - b2;
            n3Var.y = i;
            fbVar.x4(i);
            return c5(c52, n3Var.f227n3, fbVar.f59t, n3Var.y);
        }
        fbVar.mt(n3Var.y);
        return c5(yVar, n3Var.f227n3, fbVar.f56fb, n3Var.y);
    }

    public void a(a9.fb fbVar, f7.n3 n3Var) {
        t(this.f367v, fbVar, n3Var, this.f368zn);
    }

    public final void fb(int i) {
        long j2 = this.f364fb + i;
        this.f364fb = j2;
        y yVar = this.f363a;
        if (j2 == yVar.f370n3) {
            this.f363a = yVar.f369gv;
        }
    }

    public void n3(long j2) {
        y yVar;
        if (j2 == -1) {
            return;
        }
        while (true) {
            yVar = this.f365gv;
            if (j2 < yVar.f370n3) {
                break;
            }
            this.y.zn(yVar.f371zn);
            this.f365gv = this.f365gv.n3();
        }
        if (this.f367v.y < yVar.y) {
            this.f367v = yVar;
        }
    }

    public void p(v5.rz rzVar, int i) {
        while (i > 0) {
            int s2 = s(i);
            y yVar = this.f363a;
            rzVar.t(yVar.f371zn.y, yVar.v(this.f364fb), s2);
            i -= s2;
            fb(s2);
        }
    }

    public final int s(int i) {
        y yVar = this.f363a;
        if (yVar.f371zn == null) {
            yVar.zn(this.y.n3(), new y(this.f363a.f370n3, this.f366n3));
        }
        return Math.min(i, (int) (this.f363a.f370n3 - this.f364fb));
    }

    public void tl(a9.fb fbVar, f7.n3 n3Var) {
        this.f367v = t(this.f367v, fbVar, n3Var, this.f368zn);
    }

    public long v() {
        return this.f364fb;
    }

    public int w(kx.c5 c5Var, int i, boolean z2) throws IOException {
        int s2 = s(i);
        y yVar = this.f363a;
        int read = c5Var.read(yVar.f371zn.y, yVar.v(this.f364fb), s2);
        if (read == -1) {
            if (z2) {
                return -1;
            }
            throw new EOFException();
        }
        fb(read);
        return read;
    }

    public void wz() {
        y(this.f365gv);
        this.f365gv.gv(0L, this.f366n3);
        y yVar = this.f365gv;
        this.f367v = yVar;
        this.f363a = yVar;
        this.f364fb = 0L;
        this.y.gv();
    }

    public void xc() {
        this.f367v = this.f365gv;
    }

    public final void y(y yVar) {
        if (yVar.f371zn == null) {
            return;
        }
        this.y.y(yVar);
        yVar.n3();
    }

    public void zn(long j2) {
        boolean z2;
        if (j2 <= this.f364fb) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        this.f364fb = j2;
        if (j2 != 0) {
            y yVar = this.f365gv;
            if (j2 != yVar.y) {
                while (this.f364fb > yVar.f370n3) {
                    yVar = yVar.f369gv;
                }
                y yVar2 = (y) v5.y.v(yVar.f369gv);
                y(yVar2);
                y yVar3 = new y(yVar.f370n3, this.f366n3);
                yVar.f369gv = yVar3;
                if (this.f364fb == yVar.f370n3) {
                    yVar = yVar3;
                }
                this.f363a = yVar;
                if (this.f367v == yVar2) {
                    this.f367v = yVar3;
                    return;
                }
                return;
            }
        }
        y(this.f365gv);
        y yVar4 = new y(this.f364fb, this.f366n3);
        this.f365gv = yVar4;
        this.f367v = yVar4;
        this.f363a = yVar4;
    }
}
