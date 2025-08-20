package dq;

import androidx.annotation.Nullable;
import v5.j5;
/* loaded from: classes.dex */
public final class fb {
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public final String f7361n3;
    public final String y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public final String f7362zn;

    public fb(String str, @Nullable String str2, @Nullable String str3) {
        this.y = str;
        this.f7361n3 = str2;
        this.f7362zn = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || fb.class != obj.getClass()) {
            return false;
        }
        fb fbVar = (fb) obj;
        if (j5.zn(this.y, fbVar.y) && j5.zn(this.f7361n3, fbVar.f7361n3) && j5.zn(this.f7362zn, fbVar.f7362zn)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int hashCode = this.y.hashCode() * 31;
        String str = this.f7361n3;
        int i5 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i6 = (hashCode + i) * 31;
        String str2 = this.f7362zn;
        if (str2 != null) {
            i5 = str2.hashCode();
        }
        return i6 + i5;
    }
}
