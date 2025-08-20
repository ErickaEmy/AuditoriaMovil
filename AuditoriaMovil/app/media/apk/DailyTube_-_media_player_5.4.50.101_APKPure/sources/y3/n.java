package y3;

import java.io.IOException;
import v5.j5;
import v5.k5;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: gv  reason: collision with root package name */
    public boolean f15091gv;

    /* renamed from: v  reason: collision with root package name */
    public boolean f15094v;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f15095zn;
    public final k5 y = new k5(0);

    /* renamed from: a  reason: collision with root package name */
    public long f15089a = -9223372036854775807L;

    /* renamed from: fb  reason: collision with root package name */
    public long f15090fb = -9223372036854775807L;

    /* renamed from: s  reason: collision with root package name */
    public long f15093s = -9223372036854775807L;

    /* renamed from: n3  reason: collision with root package name */
    public final v5.rz f15092n3 = new v5.rz();

    public static long t(v5.rz rzVar) {
        int a2 = rzVar.a();
        if (rzVar.y() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        rzVar.t(bArr, 0, 9);
        rzVar.oz(a2);
        if (!y(bArr)) {
            return -9223372036854775807L;
        }
        return tl(bArr);
    }

    public static long tl(byte[] bArr) {
        byte b2 = bArr[0];
        byte b3 = bArr[2];
        return (((b2 & 56) >> 3) << 30) | ((b2 & 3) << 28) | ((bArr[1] & 255) << 20) | (((b3 & 248) >> 3) << 15) | ((b3 & 3) << 13) | ((bArr[3] & 255) << 5) | ((bArr[4] & 248) >> 3);
    }

    public static boolean y(byte[] bArr) {
        if ((bArr[0] & 196) != 68 || (bArr[2] & 4) != 4 || (bArr[4] & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return false;
        }
        return true;
    }

    public final int a(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public final long c5(v5.rz rzVar) {
        int fb2 = rzVar.fb();
        for (int a2 = rzVar.a(); a2 < fb2 - 3; a2++) {
            if (a(rzVar.v(), a2) == 442) {
                rzVar.oz(a2 + 4);
                long t2 = t(rzVar);
                if (t2 != -9223372036854775807L) {
                    return t2;
                }
            }
        }
        return -9223372036854775807L;
    }

    public final long f(v5.rz rzVar) {
        int a2 = rzVar.a();
        for (int fb2 = rzVar.fb() - 4; fb2 >= a2; fb2--) {
            if (a(rzVar.v(), fb2) == 442) {
                rzVar.oz(fb2 + 4);
                long t2 = t(rzVar);
                if (t2 != -9223372036854775807L) {
                    return t2;
                }
            }
        }
        return -9223372036854775807L;
    }

    public int fb(e4.tl tlVar, e4.d0 d0Var) throws IOException {
        if (!this.f15094v) {
            return i9(tlVar, d0Var);
        }
        if (this.f15090fb == -9223372036854775807L) {
            return n3(tlVar);
        }
        if (!this.f15091gv) {
            return s(tlVar, d0Var);
        }
        long j2 = this.f15089a;
        if (j2 == -9223372036854775807L) {
            return n3(tlVar);
        }
        long n32 = this.y.n3(this.f15090fb) - this.y.n3(j2);
        this.f15093s = n32;
        if (n32 < 0) {
            v5.r.c5("PsDurationReader", "Invalid duration: " + this.f15093s + ". Using TIME_UNSET instead.");
            this.f15093s = -9223372036854775807L;
        }
        return n3(tlVar);
    }

    public k5 gv() {
        return this.y;
    }

    public final int i9(e4.tl tlVar, e4.d0 d0Var) throws IOException {
        long length = tlVar.getLength();
        int min = (int) Math.min(20000L, length);
        long j2 = length - min;
        if (tlVar.getPosition() != j2) {
            d0Var.y = j2;
            return 1;
        }
        this.f15092n3.j5(min);
        tlVar.s();
        tlVar.z(this.f15092n3.v(), 0, min);
        this.f15090fb = f(this.f15092n3);
        this.f15094v = true;
        return 0;
    }

    public final int n3(e4.tl tlVar) {
        this.f15092n3.qn(j5.f14357a);
        this.f15095zn = true;
        tlVar.s();
        return 0;
    }

    public final int s(e4.tl tlVar, e4.d0 d0Var) throws IOException {
        int min = (int) Math.min(20000L, tlVar.getLength());
        long j2 = 0;
        if (tlVar.getPosition() != j2) {
            d0Var.y = j2;
            return 1;
        }
        this.f15092n3.j5(min);
        tlVar.s();
        tlVar.z(this.f15092n3.v(), 0, min);
        this.f15089a = c5(this.f15092n3);
        this.f15091gv = true;
        return 0;
    }

    public boolean v() {
        return this.f15095zn;
    }

    public long zn() {
        return this.f15093s;
    }
}
