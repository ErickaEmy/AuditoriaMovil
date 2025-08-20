package m1;

import android.os.Bundle;
import androidx.annotation.Nullable;
import m1.s;
/* loaded from: classes.dex */
public final class i extends r6 {

    /* renamed from: f  reason: collision with root package name */
    public static final String f10837f = v5.j5.g3(1);

    /* renamed from: t  reason: collision with root package name */
    public static final String f10838t = v5.j5.g3(2);

    /* renamed from: w  reason: collision with root package name */
    public static final s.y<i> f10839w = new s.y() { // from class: m1.p1
        @Override // m1.s.y
        public final s fromBundle(Bundle bundle) {
            i gv2;
            gv2 = i.gv(bundle);
            return gv2;
        }
    };

    /* renamed from: fb  reason: collision with root package name */
    public final int f10840fb;

    /* renamed from: s  reason: collision with root package name */
    public final float f10841s;

    public i(int i) {
        v5.y.n3(i > 0, "maxStars must be a positive integer");
        this.f10840fb = i;
        this.f10841s = -1.0f;
    }

    public static i gv(Bundle bundle) {
        boolean z2;
        if (bundle.getInt(r6.y, -1) == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        int i = bundle.getInt(f10837f, 5);
        float f4 = bundle.getFloat(f10838t, -1.0f);
        if (f4 == -1.0f) {
            return new i(i);
        }
        return new i(i, f4);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f10840fb != iVar.f10840fb || this.f10841s != iVar.f10841s) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return w0.f.n3(Integer.valueOf(this.f10840fb), Float.valueOf(this.f10841s));
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(r6.y, 2);
        bundle.putInt(f10837f, this.f10840fb);
        bundle.putFloat(f10838t, this.f10841s);
        return bundle;
    }

    public i(int i, float f4) {
        boolean z2 = false;
        v5.y.n3(i > 0, "maxStars must be a positive integer");
        if (f4 >= 0.0f && f4 <= i) {
            z2 = true;
        }
        v5.y.n3(z2, "starRating is out of range [0, maxStars]");
        this.f10840fb = i;
        this.f10841s = f4;
    }
}
