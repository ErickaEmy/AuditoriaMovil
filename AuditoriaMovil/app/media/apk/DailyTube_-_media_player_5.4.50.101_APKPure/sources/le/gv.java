package le;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class gv {
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public Long f10315n3;
    @NonNull
    public String y;

    public gv(@NonNull String str, boolean z2) {
        this(str, z2 ? 1L : 0L);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gv)) {
            return false;
        }
        gv gvVar = (gv) obj;
        if (!this.y.equals(gvVar.y)) {
            return false;
        }
        Long l2 = this.f10315n3;
        Long l3 = gvVar.f10315n3;
        if (l2 != null) {
            return l2.equals(l3);
        }
        if (l3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int hashCode = this.y.hashCode() * 31;
        Long l2 = this.f10315n3;
        if (l2 != null) {
            i = l2.hashCode();
        } else {
            i = 0;
        }
        return hashCode + i;
    }

    public gv(@NonNull String str, long j2) {
        this.y = str;
        this.f10315n3 = Long.valueOf(j2);
    }
}
