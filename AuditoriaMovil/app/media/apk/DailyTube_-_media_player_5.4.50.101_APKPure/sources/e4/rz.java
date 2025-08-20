package e4;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class rz {

    /* renamed from: zn  reason: collision with root package name */
    public static final rz f7511zn = new rz(0, 0);

    /* renamed from: n3  reason: collision with root package name */
    public final long f7512n3;
    public final long y;

    public rz(long j2, long j4) {
        this.y = j2;
        this.f7512n3 = j4;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || rz.class != obj.getClass()) {
            return false;
        }
        rz rzVar = (rz) obj;
        if (this.y == rzVar.y && this.f7512n3 == rzVar.f7512n3) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.y) * 31) + ((int) this.f7512n3);
    }

    public String toString() {
        return "[timeUs=" + this.y + ", position=" + this.f7512n3 + "]";
    }
}
