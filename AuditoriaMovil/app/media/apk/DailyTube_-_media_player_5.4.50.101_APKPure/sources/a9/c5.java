package a9;

import androidx.annotation.Nullable;
import m1.m;
/* loaded from: classes.dex */
public final class c5 {

    /* renamed from: gv  reason: collision with root package name */
    public final int f45gv;

    /* renamed from: n3  reason: collision with root package name */
    public final m f46n3;

    /* renamed from: v  reason: collision with root package name */
    public final int f47v;
    public final String y;

    /* renamed from: zn  reason: collision with root package name */
    public final m f48zn;

    public c5(String str, m mVar, m mVar2, int i, int i5) {
        boolean z2;
        if (i != 0 && i5 != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        v5.y.y(z2);
        this.y = v5.y.gv(str);
        this.f46n3 = (m) v5.y.v(mVar);
        this.f48zn = (m) v5.y.v(mVar2);
        this.f45gv = i;
        this.f47v = i5;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c5.class != obj.getClass()) {
            return false;
        }
        c5 c5Var = (c5) obj;
        if (this.f45gv == c5Var.f45gv && this.f47v == c5Var.f47v && this.y.equals(c5Var.y) && this.f46n3.equals(c5Var.f46n3) && this.f48zn.equals(c5Var.f48zn)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.f45gv) * 31) + this.f47v) * 31) + this.y.hashCode()) * 31) + this.f46n3.hashCode()) * 31) + this.f48zn.hashCode();
    }
}
