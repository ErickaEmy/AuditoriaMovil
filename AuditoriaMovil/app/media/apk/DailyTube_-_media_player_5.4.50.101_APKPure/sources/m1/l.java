package m1;

import af.mg;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f10896a;

    /* renamed from: c5  reason: collision with root package name */
    public final boolean f10897c5;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f10898fb;

    /* renamed from: gv  reason: collision with root package name */
    public final long f10899gv;

    /* renamed from: n3  reason: collision with root package name */
    public final long f10900n3;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f10901s;

    /* renamed from: v  reason: collision with root package name */
    public final long f10902v;
    public final mg.n3 y;

    /* renamed from: zn  reason: collision with root package name */
    public final long f10903zn;

    public l(mg.n3 n3Var, long j2, long j4, long j6, long j7, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z7;
        boolean z8;
        boolean z9 = true;
        if (z5 && !z3) {
            z7 = false;
        } else {
            z7 = true;
        }
        v5.y.y(z7);
        if (z4 && !z3) {
            z8 = false;
        } else {
            z8 = true;
        }
        v5.y.y(z8);
        if (z2 && (z3 || z4 || z5)) {
            z9 = false;
        }
        v5.y.y(z9);
        this.y = n3Var;
        this.f10900n3 = j2;
        this.f10903zn = j4;
        this.f10899gv = j6;
        this.f10902v = j7;
        this.f10896a = z2;
        this.f10898fb = z3;
        this.f10901s = z4;
        this.f10897c5 = z5;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f10900n3 == lVar.f10900n3 && this.f10903zn == lVar.f10903zn && this.f10899gv == lVar.f10899gv && this.f10902v == lVar.f10902v && this.f10896a == lVar.f10896a && this.f10898fb == lVar.f10898fb && this.f10901s == lVar.f10901s && this.f10897c5 == lVar.f10897c5 && v5.j5.zn(this.y, lVar.y)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.y.hashCode()) * 31) + ((int) this.f10900n3)) * 31) + ((int) this.f10903zn)) * 31) + ((int) this.f10899gv)) * 31) + ((int) this.f10902v)) * 31) + (this.f10896a ? 1 : 0)) * 31) + (this.f10898fb ? 1 : 0)) * 31) + (this.f10901s ? 1 : 0)) * 31) + (this.f10897c5 ? 1 : 0);
    }

    public l n3(long j2) {
        if (j2 == this.f10900n3) {
            return this;
        }
        return new l(this.y, j2, this.f10903zn, this.f10899gv, this.f10902v, this.f10896a, this.f10898fb, this.f10901s, this.f10897c5);
    }

    public l y(long j2) {
        if (j2 == this.f10903zn) {
            return this;
        }
        return new l(this.y, this.f10900n3, j2, this.f10899gv, this.f10902v, this.f10896a, this.f10898fb, this.f10901s, this.f10897c5);
    }
}
