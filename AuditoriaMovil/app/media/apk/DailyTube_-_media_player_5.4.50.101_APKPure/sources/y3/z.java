package y3;

import androidx.annotation.Nullable;
import d9.ud;
import m1.m;
import y3.ud;
/* loaded from: classes.dex */
public final class z implements tl {

    /* renamed from: a  reason: collision with root package name */
    public int f15257a;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f15258c5;

    /* renamed from: f  reason: collision with root package name */
    public int f15259f;

    /* renamed from: fb  reason: collision with root package name */
    public int f15260fb;

    /* renamed from: gv  reason: collision with root package name */
    public e4.ta f15261gv;

    /* renamed from: i9  reason: collision with root package name */
    public long f15262i9;

    /* renamed from: n3  reason: collision with root package name */
    public final ud.y f15263n3;

    /* renamed from: s  reason: collision with root package name */
    public boolean f15264s;

    /* renamed from: t  reason: collision with root package name */
    public long f15265t;

    /* renamed from: v  reason: collision with root package name */
    public String f15266v;
    public final v5.rz y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public final String f15267zn;

    public z() {
        this(null);
    }

    @Override // y3.tl
    public void a(long j2, int i) {
        if (j2 != -9223372036854775807L) {
            this.f15265t = j2;
        }
    }

    public final void fb(v5.rz rzVar) {
        int min = Math.min(rzVar.y(), this.f15259f - this.f15260fb);
        this.f15261gv.zn(rzVar, min);
        int i = this.f15260fb + min;
        this.f15260fb = i;
        int i5 = this.f15259f;
        if (i < i5) {
            return;
        }
        long j2 = this.f15265t;
        if (j2 != -9223372036854775807L) {
            this.f15261gv.gv(j2, 1, i5, 0, null);
            this.f15265t += this.f15262i9;
        }
        this.f15260fb = 0;
        this.f15257a = 0;
    }

    @Override // y3.tl
    public void n3(v5.rz rzVar) {
        v5.y.c5(this.f15261gv);
        while (rzVar.y() > 0) {
            int i = this.f15257a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        fb(rzVar);
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    s(rzVar);
                }
            } else {
                y(rzVar);
            }
        }
    }

    public final void s(v5.rz rzVar) {
        int min = Math.min(rzVar.y(), 4 - this.f15260fb);
        rzVar.t(this.y.v(), this.f15260fb, min);
        int i = this.f15260fb + min;
        this.f15260fb = i;
        if (i < 4) {
            return;
        }
        this.y.oz(0);
        if (!this.f15263n3.y(this.y.p())) {
            this.f15260fb = 0;
            this.f15257a = 1;
            return;
        }
        ud.y yVar = this.f15263n3;
        this.f15259f = yVar.f7198zn;
        if (!this.f15264s) {
            this.f15262i9 = (yVar.f7194fb * 1000000) / yVar.f7195gv;
            this.f15261gv.v(new m.n3().oz(this.f15266v).o4(this.f15263n3.f7196n3).f7(4096).a8(this.f15263n3.f7197v).rs(this.f15263n3.f7195gv).k(this.f15267zn).z6());
            this.f15264s = true;
        }
        this.y.oz(0);
        this.f15261gv.zn(this.y, 4);
        this.f15257a = 2;
    }

    @Override // y3.tl
    public void v(e4.wz wzVar, ud.gv gvVar) {
        gvVar.y();
        this.f15266v = gvVar.n3();
        this.f15261gv = wzVar.a(gvVar.zn(), 1);
    }

    public final void y(v5.rz rzVar) {
        boolean z2;
        boolean z3;
        byte[] v2 = rzVar.v();
        int fb2 = rzVar.fb();
        for (int a2 = rzVar.a(); a2 < fb2; a2++) {
            byte b2 = v2[a2];
            if ((b2 & 255) == 255) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.f15258c5 && (b2 & 224) == 224) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f15258c5 = z2;
            if (z3) {
                rzVar.oz(a2 + 1);
                this.f15258c5 = false;
                this.y.v()[1] = v2[a2];
                this.f15260fb = 2;
                this.f15257a = 1;
                return;
            }
        }
        rzVar.oz(fb2);
    }

    @Override // y3.tl
    public void zn() {
        this.f15257a = 0;
        this.f15260fb = 0;
        this.f15258c5 = false;
        this.f15265t = -9223372036854775807L;
    }

    public z(@Nullable String str) {
        v5.rz rzVar = new v5.rz(4);
        this.y = rzVar;
        rzVar.v()[0] = -1;
        this.f15263n3 = new ud.y();
        this.f15265t = -9223372036854775807L;
        this.f15267zn = str;
    }

    @Override // y3.tl
    public void gv() {
    }
}
