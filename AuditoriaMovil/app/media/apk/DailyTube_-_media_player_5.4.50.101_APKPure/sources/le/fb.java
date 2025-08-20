package le;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class fb {

    /* renamed from: n3  reason: collision with root package name */
    public final int f10314n3;
    @NonNull
    public final String y;

    public fb(@NonNull String str, int i) {
        this.y = str;
        this.f10314n3 = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fb)) {
            return false;
        }
        fb fbVar = (fb) obj;
        if (this.f10314n3 != fbVar.f10314n3) {
            return false;
        }
        return this.y.equals(fbVar.y);
    }

    public int hashCode() {
        return (this.y.hashCode() * 31) + this.f10314n3;
    }
}
