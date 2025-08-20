package w2;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class n3 {

    /* renamed from: gv  reason: collision with root package name */
    public boolean f14528gv;

    /* renamed from: n3  reason: collision with root package name */
    public boolean f14529n3;
    public boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f14530zn;

    public n3(boolean z2, boolean z3, boolean z4, boolean z5) {
        this.y = z2;
        this.f14529n3 = z3;
        this.f14530zn = z4;
        this.f14528gv = z5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n3)) {
            return false;
        }
        n3 n3Var = (n3) obj;
        if (this.y == n3Var.y && this.f14529n3 == n3Var.f14529n3 && this.f14530zn == n3Var.f14530zn && this.f14528gv == n3Var.f14528gv) {
            return true;
        }
        return false;
    }

    public boolean gv() {
        return this.f14529n3;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public int hashCode() {
        ?? r0 = this.y;
        int i = r0;
        if (this.f14529n3) {
            i = r0 + 16;
        }
        int i5 = i;
        if (this.f14530zn) {
            i5 = i + 256;
        }
        if (this.f14528gv) {
            return i5 + 4096;
        }
        return i5;
    }

    public boolean n3() {
        return this.f14530zn;
    }

    @NonNull
    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", Boolean.valueOf(this.y), Boolean.valueOf(this.f14529n3), Boolean.valueOf(this.f14530zn), Boolean.valueOf(this.f14528gv));
    }

    public boolean y() {
        return this.y;
    }

    public boolean zn() {
        return this.f14528gv;
    }
}
