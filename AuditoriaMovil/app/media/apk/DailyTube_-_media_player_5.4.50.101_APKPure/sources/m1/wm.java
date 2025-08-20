package m1;

import android.os.Bundle;
import androidx.annotation.Nullable;
import m1.s;
/* loaded from: classes.dex */
public final class wm extends r6 {

    /* renamed from: fb  reason: collision with root package name */
    public final float f11316fb;

    /* renamed from: s  reason: collision with root package name */
    public static final String f11315s = v5.j5.g3(1);

    /* renamed from: f  reason: collision with root package name */
    public static final s.y<wm> f11314f = new s.y() { // from class: m1.q
        @Override // m1.s.y
        public final s fromBundle(Bundle bundle) {
            wm gv2;
            gv2 = wm.gv(bundle);
            return gv2;
        }
    };

    public wm() {
        this.f11316fb = -1.0f;
    }

    public static wm gv(Bundle bundle) {
        boolean z2 = true;
        if (bundle.getInt(r6.y, -1) != 1) {
            z2 = false;
        }
        v5.y.y(z2);
        float f4 = bundle.getFloat(f11315s, -1.0f);
        if (f4 == -1.0f) {
            return new wm();
        }
        return new wm(f4);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof wm) || this.f11316fb != ((wm) obj).f11316fb) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return w0.f.n3(Float.valueOf(this.f11316fb));
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(r6.y, 1);
        bundle.putFloat(f11315s, this.f11316fb);
        return bundle;
    }

    public wm(float f4) {
        v5.y.n3(f4 >= 0.0f && f4 <= 100.0f, "percent must be in the range of [0, 100]");
        this.f11316fb = f4;
    }
}
