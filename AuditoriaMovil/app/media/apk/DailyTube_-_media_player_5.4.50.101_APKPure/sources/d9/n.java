package d9;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: n3  reason: collision with root package name */
    public final float f7085n3;
    public final int y;

    public n(int i, float f4) {
        this.y = i;
        this.f7085n3 = f4;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.y == nVar.y && Float.compare(nVar.f7085n3, this.f7085n3) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.y) * 31) + Float.floatToIntBits(this.f7085n3);
    }
}
