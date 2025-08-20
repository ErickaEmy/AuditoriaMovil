package jk;

import e4.ta;
import m1.ne;
import v5.fh;
import v5.j5;
import v5.rz;
import z0.f3;
/* loaded from: classes.dex */
public final class s implements f {

    /* renamed from: a  reason: collision with root package name */
    public int f9503a;

    /* renamed from: fb  reason: collision with root package name */
    public long f9504fb;

    /* renamed from: gv  reason: collision with root package name */
    public long f9505gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f9506n3;

    /* renamed from: s  reason: collision with root package name */
    public long f9507s;

    /* renamed from: v  reason: collision with root package name */
    public int f9508v;
    public final r4.s y;

    /* renamed from: zn  reason: collision with root package name */
    public ta f9509zn;

    public s(r4.s sVar) {
        this.y = sVar;
        try {
            this.f9506n3 = v(sVar.f13098gv);
            this.f9505gv = -9223372036854775807L;
            this.f9508v = -1;
            this.f9503a = 0;
            this.f9504fb = 0L;
            this.f9507s = -9223372036854775807L;
        } catch (ne e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private void a() {
        ((ta) v5.y.v(this.f9509zn)).gv(this.f9507s, 1, this.f9503a, 0, null);
        this.f9503a = 0;
        this.f9507s = -9223372036854775807L;
    }

    public static int v(f3<String, String> f3Var) throws ne {
        boolean z2;
        boolean z3;
        String str = f3Var.get("config");
        int i = 0;
        boolean z4 = false;
        i = 0;
        if (str != null && str.length() % 2 == 0) {
            fh fhVar = new fh(j5.a8(str));
            int s2 = fhVar.s(1);
            if (s2 == 0) {
                if (fhVar.s(1) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                v5.y.n3(z2, "Only supports allStreamsSameTimeFraming.");
                int s3 = fhVar.s(6);
                if (fhVar.s(4) == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                v5.y.n3(z3, "Only suppors one program.");
                if (fhVar.s(3) == 0) {
                    z4 = true;
                }
                v5.y.n3(z4, "Only suppors one layer.");
                i = s3;
            } else {
                throw ne.gv("unsupported audio mux version: " + s2, null);
            }
        }
        return i + 1;
    }

    @Override // jk.f
    public void gv(e4.wz wzVar, int i) {
        ta a2 = wzVar.a(i, 2);
        this.f9509zn = a2;
        ((ta) j5.i9(a2)).v(this.y.f13101zn);
    }

    @Override // jk.f
    public void n3(rz rzVar, long j2, int i, boolean z2) {
        v5.y.c5(this.f9509zn);
        int n32 = r4.v.n3(this.f9508v);
        if (this.f9503a > 0 && n32 < i) {
            a();
        }
        for (int i5 = 0; i5 < this.f9506n3; i5++) {
            int i6 = 0;
            while (rzVar.a() < rzVar.fb()) {
                int ej2 = rzVar.ej();
                i6 += ej2;
                if (ej2 != 255) {
                    break;
                }
            }
            this.f9509zn.zn(rzVar, i6);
            this.f9503a += i6;
        }
        this.f9507s = tl.y(this.f9504fb, j2, this.f9505gv, this.y.f13099n3);
        if (z2) {
            a();
        }
        this.f9508v = i;
    }

    @Override // jk.f
    public void y(long j2, long j4) {
        this.f9505gv = j2;
        this.f9503a = 0;
        this.f9504fb = j4;
    }

    @Override // jk.f
    public void zn(long j2, int i) {
        boolean z2;
        if (this.f9505gv == -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        this.f9505gv = j2;
    }
}
