package vl;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class gv<F, S> {

    /* renamed from: n3  reason: collision with root package name */
    public final S f14456n3;
    public final F y;

    public gv(F f4, S s2) {
        this.y = f4;
        this.f14456n3 = s2;
    }

    @NonNull
    public static <A, B> gv<A, B> y(A a2, B b2) {
        return new gv<>(a2, b2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof gv)) {
            return false;
        }
        gv gvVar = (gv) obj;
        if (!zn.y(gvVar.y, this.y) || !zn.y(gvVar.f14456n3, this.f14456n3)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        F f4 = this.y;
        int i = 0;
        if (f4 == null) {
            hashCode = 0;
        } else {
            hashCode = f4.hashCode();
        }
        S s2 = this.f14456n3;
        if (s2 != null) {
            i = s2.hashCode();
        }
        return hashCode ^ i;
    }

    @NonNull
    public String toString() {
        return "Pair{" + this.y + " " + this.f14456n3 + "}";
    }
}
