package m1;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class ic {

    /* renamed from: n3  reason: collision with root package name */
    public static final ic f10873n3 = new ic(false);
    public final boolean y;

    public ic(boolean z2) {
        this.y = z2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ic.class == obj.getClass() && this.y == ((ic) obj).y) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return !this.y ? 1 : 0;
    }
}
