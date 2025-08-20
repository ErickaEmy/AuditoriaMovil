package zr;

import af.en;
import java.io.IOException;
import m1.g;
import m1.m;
import v5.j5;
/* loaded from: classes.dex */
public final class f implements en {

    /* renamed from: f  reason: collision with root package name */
    public dq.s f15921f;

    /* renamed from: fb  reason: collision with root package name */
    public long[] f15922fb;

    /* renamed from: s  reason: collision with root package name */
    public boolean f15924s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f15925t;

    /* renamed from: w  reason: collision with root package name */
    public int f15927w;
    public final m y;

    /* renamed from: v  reason: collision with root package name */
    public final f5.n3 f15926v = new f5.n3();

    /* renamed from: p  reason: collision with root package name */
    public long f15923p = -9223372036854775807L;

    public f(dq.s sVar, m mVar, boolean z2) {
        this.y = mVar;
        this.f15921f = sVar;
        this.f15922fb = sVar.f7376n3;
        gv(sVar, z2);
    }

    @Override // af.en
    public int a(g gVar, a9.fb fbVar, int i) {
        boolean z2;
        int i5 = this.f15927w;
        if (i5 == this.f15922fb.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && !this.f15924s) {
            fbVar.w(4);
            return -4;
        } else if ((i & 2) == 0 && this.f15925t) {
            if (z2) {
                return -3;
            }
            if ((i & 1) == 0) {
                this.f15927w = i5 + 1;
            }
            if ((i & 4) == 0) {
                byte[] y = this.f15926v.y(this.f15921f.y[i5]);
                fbVar.mt(y.length);
                fbVar.f56fb.put(y);
            }
            fbVar.f55f = this.f15922fb[i5];
            fbVar.w(1);
            return -4;
        } else {
            gVar.f10757n3 = this.y;
            this.f15925t = true;
            return -5;
        }
    }

    public void gv(dq.s sVar, boolean z2) {
        long j2;
        int i = this.f15927w;
        if (i == 0) {
            j2 = -9223372036854775807L;
        } else {
            j2 = this.f15922fb[i - 1];
        }
        this.f15924s = z2;
        this.f15921f = sVar;
        long[] jArr = sVar.f7376n3;
        this.f15922fb = jArr;
        long j4 = this.f15923p;
        if (j4 != -9223372036854775807L) {
            zn(j4);
        } else if (j2 != -9223372036854775807L) {
            this.f15927w = j5.v(jArr, j2, false, false);
        }
    }

    @Override // af.en
    public boolean isReady() {
        return true;
    }

    @Override // af.en
    public int t(long j2) {
        int max = Math.max(this.f15927w, j5.v(this.f15922fb, j2, true, false));
        int i = max - this.f15927w;
        this.f15927w = max;
        return i;
    }

    public String y() {
        return this.f15921f.y();
    }

    public void zn(long j2) {
        int v2 = j5.v(this.f15922fb, j2, true, false);
        this.f15927w = v2;
        this.f15923p = (this.f15924s && v2 == this.f15922fb.length) ? -9223372036854775807L : -9223372036854775807L;
    }

    @Override // af.en
    public void n3() throws IOException {
    }
}
