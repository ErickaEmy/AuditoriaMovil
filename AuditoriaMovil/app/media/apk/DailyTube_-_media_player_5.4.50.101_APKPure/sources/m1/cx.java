package m1;

import android.os.Bundle;
import androidx.annotation.Nullable;
import m1.s;
/* loaded from: classes.dex */
public final class cx extends r6 {

    /* renamed from: f  reason: collision with root package name */
    public static final String f10651f = v5.j5.g3(1);

    /* renamed from: t  reason: collision with root package name */
    public static final String f10652t = v5.j5.g3(2);

    /* renamed from: w  reason: collision with root package name */
    public static final s.y<cx> f10653w = new s.y() { // from class: m1.hr
        @Override // m1.s.y
        public final s fromBundle(Bundle bundle) {
            cx gv2;
            gv2 = cx.gv(bundle);
            return gv2;
        }
    };

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f10654fb;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f10655s;

    public cx() {
    }

    public static cx gv(Bundle bundle) {
        boolean z2;
        if (bundle.getInt(r6.y, -1) == 3) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        if (bundle.getBoolean(f10651f, false)) {
            return new cx(bundle.getBoolean(f10652t, false));
        }
        return new cx();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof cx)) {
            return false;
        }
        cx cxVar = (cx) obj;
        if (this.f10655s != cxVar.f10655s || this.f10654fb != cxVar.f10654fb) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return w0.f.n3(Boolean.valueOf(this.f10654fb), Boolean.valueOf(this.f10655s));
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(r6.y, 3);
        bundle.putBoolean(f10651f, this.f10654fb);
        bundle.putBoolean(f10652t, this.f10655s);
        return bundle;
    }

    public cx(boolean z2) {
        this.f10654fb = true;
        this.f10655s = z2;
    }
}
