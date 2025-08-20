package y3;

import java.io.IOException;
import v5.j5;
import v5.k5;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f15010a;

    /* renamed from: gv  reason: collision with root package name */
    public boolean f15013gv;

    /* renamed from: v  reason: collision with root package name */
    public boolean f15016v;
    public final int y;

    /* renamed from: n3  reason: collision with root package name */
    public final k5 f15014n3 = new k5(0);

    /* renamed from: fb  reason: collision with root package name */
    public long f15012fb = -9223372036854775807L;

    /* renamed from: s  reason: collision with root package name */
    public long f15015s = -9223372036854775807L;

    /* renamed from: c5  reason: collision with root package name */
    public long f15011c5 = -9223372036854775807L;

    /* renamed from: zn  reason: collision with root package name */
    public final v5.rz f15017zn = new v5.rz();

    public d(int i) {
        this.y = i;
    }

    public final int a(e4.tl tlVar, e4.d0 d0Var, int i) throws IOException {
        int min = (int) Math.min(this.y, tlVar.getLength());
        long j2 = 0;
        if (tlVar.getPosition() != j2) {
            d0Var.y = j2;
            return 1;
        }
        this.f15017zn.j5(min);
        tlVar.s();
        tlVar.z(this.f15017zn.v(), 0, min);
        this.f15012fb = fb(this.f15017zn, i);
        this.f15016v = true;
        return 0;
    }

    public final long c5(v5.rz rzVar, int i) {
        int a2 = rzVar.a();
        int fb2 = rzVar.fb();
        for (int i5 = fb2 - 188; i5 >= a2; i5--) {
            if (a8.n3(rzVar.v(), a2, fb2, i5)) {
                long zn2 = a8.zn(rzVar, i5, i);
                if (zn2 != -9223372036854775807L) {
                    return zn2;
                }
            }
        }
        return -9223372036854775807L;
    }

    public final long fb(v5.rz rzVar, int i) {
        int fb2 = rzVar.fb();
        for (int a2 = rzVar.a(); a2 < fb2; a2++) {
            if (rzVar.v()[a2] == 71) {
                long zn2 = a8.zn(rzVar, a2, i);
                if (zn2 != -9223372036854775807L) {
                    return zn2;
                }
            }
        }
        return -9223372036854775807L;
    }

    public boolean gv() {
        return this.f15013gv;
    }

    public long n3() {
        return this.f15011c5;
    }

    public final int s(e4.tl tlVar, e4.d0 d0Var, int i) throws IOException {
        long length = tlVar.getLength();
        int min = (int) Math.min(this.y, length);
        long j2 = length - min;
        if (tlVar.getPosition() != j2) {
            d0Var.y = j2;
            return 1;
        }
        this.f15017zn.j5(min);
        tlVar.s();
        tlVar.z(this.f15017zn.v(), 0, min);
        this.f15015s = c5(this.f15017zn, i);
        this.f15010a = true;
        return 0;
    }

    public int v(e4.tl tlVar, e4.d0 d0Var, int i) throws IOException {
        if (i <= 0) {
            return y(tlVar);
        }
        if (!this.f15010a) {
            return s(tlVar, d0Var, i);
        }
        if (this.f15015s == -9223372036854775807L) {
            return y(tlVar);
        }
        if (!this.f15016v) {
            return a(tlVar, d0Var, i);
        }
        long j2 = this.f15012fb;
        if (j2 == -9223372036854775807L) {
            return y(tlVar);
        }
        long n32 = this.f15014n3.n3(this.f15015s) - this.f15014n3.n3(j2);
        this.f15011c5 = n32;
        if (n32 < 0) {
            v5.r.c5("TsDurationReader", "Invalid duration: " + this.f15011c5 + ". Using TIME_UNSET instead.");
            this.f15011c5 = -9223372036854775807L;
        }
        return y(tlVar);
    }

    public final int y(e4.tl tlVar) {
        this.f15017zn.qn(j5.f14357a);
        this.f15013gv = true;
        tlVar.s();
        return 0;
    }

    public k5 zn() {
        return this.f15014n3;
    }
}
