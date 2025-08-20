package v5;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class wz {
    public final SparseBooleanArray y;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public boolean f14402n3;
        public final SparseBooleanArray y = new SparseBooleanArray();

        public n3 gv(int i, boolean z2) {
            if (z2) {
                return y(i);
            }
            return this;
        }

        public n3 n3(wz wzVar) {
            for (int i = 0; i < wzVar.gv(); i++) {
                y(wzVar.zn(i));
            }
            return this;
        }

        public wz v() {
            v5.y.fb(!this.f14402n3);
            this.f14402n3 = true;
            return new wz(this.y);
        }

        public n3 y(int i) {
            v5.y.fb(!this.f14402n3);
            this.y.append(i, true);
            return this;
        }

        public n3 zn(int... iArr) {
            for (int i : iArr) {
                y(i);
            }
            return this;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wz)) {
            return false;
        }
        wz wzVar = (wz) obj;
        if (j5.y < 24) {
            if (gv() != wzVar.gv()) {
                return false;
            }
            for (int i = 0; i < gv(); i++) {
                if (zn(i) != wzVar.zn(i)) {
                    return false;
                }
            }
            return true;
        }
        return this.y.equals(wzVar.y);
    }

    public int gv() {
        return this.y.size();
    }

    public int hashCode() {
        if (j5.y < 24) {
            int gv2 = gv();
            for (int i = 0; i < gv(); i++) {
                gv2 = (gv2 * 31) + zn(i);
            }
            return gv2;
        }
        return this.y.hashCode();
    }

    public boolean n3(int... iArr) {
        for (int i : iArr) {
            if (y(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean y(int i) {
        return this.y.get(i);
    }

    public int zn(int i) {
        v5.y.zn(i, 0, gv());
        return this.y.keyAt(i);
    }

    public wz(SparseBooleanArray sparseBooleanArray) {
        this.y = sparseBooleanArray;
    }
}
