package z6;

import android.graphics.Insets;
import android.graphics.Rect;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class n3 {
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    public static final n3 f15662v = new n3(0, 0, 0, 0);

    /* renamed from: gv  reason: collision with root package name */
    public final int f15663gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f15664n3;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f15665zn;

    /* loaded from: classes.dex */
    public static class y {
        public static Insets y(int i, int i5, int i6, int i8) {
            return Insets.of(i, i5, i6, i8);
        }
    }

    public n3(int i, int i5, int i6, int i8) {
        this.y = i;
        this.f15664n3 = i5;
        this.f15665zn = i6;
        this.f15663gv = i8;
    }

    @NonNull
    public static n3 gv(@NonNull Insets insets) {
        return n3(insets.left, insets.top, insets.right, insets.bottom);
    }

    @NonNull
    public static n3 n3(int i, int i5, int i6, int i8) {
        if (i == 0 && i5 == 0 && i6 == 0 && i8 == 0) {
            return f15662v;
        }
        return new n3(i, i5, i6, i8);
    }

    @NonNull
    public static n3 y(@NonNull n3 n3Var, @NonNull n3 n3Var2) {
        return n3(Math.max(n3Var.y, n3Var2.y), Math.max(n3Var.f15664n3, n3Var2.f15664n3), Math.max(n3Var.f15665zn, n3Var2.f15665zn), Math.max(n3Var.f15663gv, n3Var2.f15663gv));
    }

    @NonNull
    public static n3 zn(@NonNull Rect rect) {
        return n3(rect.left, rect.top, rect.right, rect.bottom);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n3.class != obj.getClass()) {
            return false;
        }
        n3 n3Var = (n3) obj;
        if (this.f15663gv == n3Var.f15663gv && this.y == n3Var.y && this.f15665zn == n3Var.f15665zn && this.f15664n3 == n3Var.f15664n3) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.y * 31) + this.f15664n3) * 31) + this.f15665zn) * 31) + this.f15663gv;
    }

    @NonNull
    public String toString() {
        return "Insets{left=" + this.y + ", top=" + this.f15664n3 + ", right=" + this.f15665zn + ", bottom=" + this.f15663gv + '}';
    }

    @NonNull
    public Insets v() {
        return y.y(this.y, this.f15664n3, this.f15665zn, this.f15663gv);
    }
}
