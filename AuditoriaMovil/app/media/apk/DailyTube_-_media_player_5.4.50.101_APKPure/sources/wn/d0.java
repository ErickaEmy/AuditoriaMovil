package wn;

import android.os.Bundle;
import androidx.annotation.Nullable;
import m1.s;
import v5.j5;
/* loaded from: classes.dex */
public final class d0 implements m1.s {

    /* renamed from: fb  reason: collision with root package name */
    public final int f14580fb;

    /* renamed from: s  reason: collision with root package name */
    public final float f14581s;

    /* renamed from: v  reason: collision with root package name */
    public final int f14582v;
    public final int y;

    /* renamed from: f  reason: collision with root package name */
    public static final d0 f14575f = new d0(0, 0);

    /* renamed from: t  reason: collision with root package name */
    public static final String f14577t = j5.g3(0);

    /* renamed from: w  reason: collision with root package name */
    public static final String f14578w = j5.g3(1);

    /* renamed from: p  reason: collision with root package name */
    public static final String f14576p = j5.g3(2);

    /* renamed from: co  reason: collision with root package name */
    public static final String f14574co = j5.g3(3);

    /* renamed from: z  reason: collision with root package name */
    public static final s.y<d0> f14579z = new s.y() { // from class: wn.c
        @Override // m1.s.y
        public final m1.s fromBundle(Bundle bundle) {
            d0 n32;
            n32 = d0.n3(bundle);
            return n32;
        }
    };

    public d0(int i, int i5) {
        this(i, i5, 0, 1.0f);
    }

    public static /* synthetic */ d0 n3(Bundle bundle) {
        return new d0(bundle.getInt(f14577t, 0), bundle.getInt(f14578w, 0), bundle.getInt(f14576p, 0), bundle.getFloat(f14574co, 1.0f));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        if (this.y == d0Var.y && this.f14582v == d0Var.f14582v && this.f14580fb == d0Var.f14580fb && this.f14581s == d0Var.f14581s) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((217 + this.y) * 31) + this.f14582v) * 31) + this.f14580fb) * 31) + Float.floatToRawIntBits(this.f14581s);
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(f14577t, this.y);
        bundle.putInt(f14578w, this.f14582v);
        bundle.putInt(f14576p, this.f14580fb);
        bundle.putFloat(f14574co, this.f14581s);
        return bundle;
    }

    public d0(int i, int i5, int i6, float f4) {
        this.y = i;
        this.f14582v = i5;
        this.f14580fb = i6;
        this.f14581s = f4;
    }
}
