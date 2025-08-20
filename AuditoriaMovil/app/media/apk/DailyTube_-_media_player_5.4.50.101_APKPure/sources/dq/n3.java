package dq;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: gv  reason: collision with root package name */
    public final int f7369gv;

    /* renamed from: n3  reason: collision with root package name */
    public final String f7370n3;
    public final String y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f7371zn;

    public n3(String str) {
        this(str, str, Integer.MIN_VALUE, 1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n3)) {
            return false;
        }
        n3 n3Var = (n3) obj;
        if (this.f7371zn == n3Var.f7371zn && this.f7369gv == n3Var.f7369gv && w0.f.y(this.y, n3Var.y) && w0.f.y(this.f7370n3, n3Var.f7370n3)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return w0.f.n3(this.y, this.f7370n3, Integer.valueOf(this.f7371zn), Integer.valueOf(this.f7369gv));
    }

    public n3(String str, String str2, int i, int i5) {
        this.y = str;
        this.f7370n3 = str2;
        this.f7371zn = i;
        this.f7369gv = i5;
    }
}
