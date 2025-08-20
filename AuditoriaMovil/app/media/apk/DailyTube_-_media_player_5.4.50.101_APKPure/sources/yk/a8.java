package yk;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class a8<V> {
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public final Throwable f15343n3;
    @Nullable
    public final V y;

    public a8(V v2) {
        this.y = v2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a8)) {
            return false;
        }
        a8 a8Var = (a8) obj;
        if (n3() != null && n3().equals(a8Var.n3())) {
            return true;
        }
        if (y() == null || a8Var.y() == null) {
            return false;
        }
        return y().toString().equals(y().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{n3(), y()});
    }

    @Nullable
    public V n3() {
        return this.y;
    }

    @Nullable
    public Throwable y() {
        return this.f15343n3;
    }

    public a8(Throwable th) {
        this.f15343n3 = th;
    }
}
