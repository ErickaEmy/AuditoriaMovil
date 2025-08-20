package v5;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class z6 {

    /* renamed from: n3  reason: collision with root package name */
    public final int f14428n3;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public static final z6 f14427zn = new z6(-1, -1);

    /* renamed from: gv  reason: collision with root package name */
    public static final z6 f14426gv = new z6(0, 0);

    public z6(int i, int i5) {
        boolean z2;
        if ((i != -1 && i < 0) || (i5 != -1 && i5 < 0)) {
            z2 = false;
        } else {
            z2 = true;
        }
        y.y(z2);
        this.y = i;
        this.f14428n3 = i5;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z6)) {
            return false;
        }
        z6 z6Var = (z6) obj;
        if (this.y != z6Var.y || this.f14428n3 != z6Var.f14428n3) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.f14428n3;
        int i5 = this.y;
        return i ^ ((i5 >>> 16) | (i5 << 16));
    }

    public int n3() {
        return this.y;
    }

    public String toString() {
        return this.y + "x" + this.f14428n3;
    }

    public int y() {
        return this.f14428n3;
    }
}
