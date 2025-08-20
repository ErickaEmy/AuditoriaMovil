package m1;

import android.os.Bundle;
import androidx.annotation.Nullable;
import m1.s;
/* loaded from: classes.dex */
public final class y4 extends r6 {

    /* renamed from: f  reason: collision with root package name */
    public static final String f11328f = v5.j5.g3(1);

    /* renamed from: t  reason: collision with root package name */
    public static final String f11329t = v5.j5.g3(2);

    /* renamed from: w  reason: collision with root package name */
    public static final s.y<y4> f11330w = new s.y() { // from class: m1.bk
        @Override // m1.s.y
        public final s fromBundle(Bundle bundle) {
            y4 gv2;
            gv2 = y4.gv(bundle);
            return gv2;
        }
    };

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f11331fb;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f11332s;

    public y4() {
    }

    public static y4 gv(Bundle bundle) {
        boolean z2;
        if (bundle.getInt(r6.y, -1) == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        if (bundle.getBoolean(f11328f, false)) {
            return new y4(bundle.getBoolean(f11329t, false));
        }
        return new y4();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof y4)) {
            return false;
        }
        y4 y4Var = (y4) obj;
        if (this.f11332s != y4Var.f11332s || this.f11331fb != y4Var.f11331fb) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return w0.f.n3(Boolean.valueOf(this.f11331fb), Boolean.valueOf(this.f11332s));
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(r6.y, 0);
        bundle.putBoolean(f11328f, this.f11331fb);
        bundle.putBoolean(f11329t, this.f11332s);
        return bundle;
    }

    public y4(boolean z2) {
        this.f11331fb = true;
        this.f11332s = z2;
    }
}
