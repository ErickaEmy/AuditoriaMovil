package m1;

import android.os.Bundle;
import androidx.annotation.Nullable;
import m1.s;
/* loaded from: classes.dex */
public final class xc implements s {

    /* renamed from: fb  reason: collision with root package name */
    public final int f11323fb;

    /* renamed from: v  reason: collision with root package name */
    public final int f11324v;
    public final int y;

    /* renamed from: s  reason: collision with root package name */
    public static final xc f11320s = new xc(0, 0, 0);

    /* renamed from: f  reason: collision with root package name */
    public static final String f11318f = v5.j5.g3(0);

    /* renamed from: t  reason: collision with root package name */
    public static final String f11321t = v5.j5.g3(1);

    /* renamed from: w  reason: collision with root package name */
    public static final String f11322w = v5.j5.g3(2);

    /* renamed from: p  reason: collision with root package name */
    public static final s.y<xc> f11319p = new s.y() { // from class: m1.wz
        @Override // m1.s.y
        public final s fromBundle(Bundle bundle) {
            xc n32;
            n32 = xc.n3(bundle);
            return n32;
        }
    };

    public xc(int i, int i5, int i6) {
        this.y = i;
        this.f11324v = i5;
        this.f11323fb = i6;
    }

    public static /* synthetic */ xc n3(Bundle bundle) {
        return new xc(bundle.getInt(f11318f, 0), bundle.getInt(f11321t, 0), bundle.getInt(f11322w, 0));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xc)) {
            return false;
        }
        xc xcVar = (xc) obj;
        if (this.y == xcVar.y && this.f11324v == xcVar.f11324v && this.f11323fb == xcVar.f11323fb) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.y) * 31) + this.f11324v) * 31) + this.f11323fb;
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(f11318f, this.y);
        bundle.putInt(f11321t, this.f11324v);
        bundle.putInt(f11322w, this.f11323fb);
        return bundle;
    }
}
