package mg;

import android.content.LocusId;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import vl.s;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: n3  reason: collision with root package name */
    public final LocusId f11472n3;
    public final String y;

    /* loaded from: classes.dex */
    public static class y {
        @NonNull
        public static String n3(@NonNull LocusId locusId) {
            return locusId.getId();
        }

        @NonNull
        public static LocusId y(@NonNull String str) {
            return new LocusId(str);
        }
    }

    public n3(@NonNull String str) {
        this.y = (String) s.c5(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.f11472n3 = y.y(str);
        } else {
            this.f11472n3 = null;
        }
    }

    @NonNull
    public static n3 gv(@NonNull LocusId locusId) {
        s.s(locusId, "locusId cannot be null");
        return new n3((String) s.c5(y.n3(locusId), "id cannot be empty"));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n3.class != obj.getClass()) {
            return false;
        }
        n3 n3Var = (n3) obj;
        String str = this.y;
        if (str == null) {
            if (n3Var.y == null) {
                return true;
            }
            return false;
        }
        return str.equals(n3Var.y);
    }

    public int hashCode() {
        int hashCode;
        String str = this.y;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return 31 + hashCode;
    }

    @NonNull
    public final String n3() {
        int length = this.y.length();
        return length + "_chars";
    }

    @NonNull
    public String toString() {
        return "LocusIdCompat[" + n3() + "]";
    }

    @NonNull
    public String y() {
        return this.y;
    }

    @NonNull
    public LocusId zn() {
        return this.f11472n3;
    }
}
