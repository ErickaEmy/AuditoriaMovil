package l;

import android.net.Uri;
import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public final class zn {
    public final Set<y> y = new HashSet();

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f10251n3;
        @NonNull
        public final Uri y;

        public y(@NonNull Uri uri, boolean z2) {
            this.y = uri;
            this.f10251n3 = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || y.class != obj.getClass()) {
                return false;
            }
            y yVar = (y) obj;
            if (this.f10251n3 == yVar.f10251n3 && this.y.equals(yVar.y)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.y.hashCode() * 31) + (this.f10251n3 ? 1 : 0);
        }

        public boolean n3() {
            return this.f10251n3;
        }

        @NonNull
        public Uri y() {
            return this.y;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zn.class == obj.getClass()) {
            return this.y.equals(((zn) obj).y);
        }
        return false;
    }

    public int hashCode() {
        return this.y.hashCode();
    }

    @NonNull
    public Set<y> n3() {
        return this.y;
    }

    public void y(@NonNull Uri uri, boolean z2) {
        this.y.add(new y(uri, z2));
    }

    public int zn() {
        return this.y.size();
    }
}
