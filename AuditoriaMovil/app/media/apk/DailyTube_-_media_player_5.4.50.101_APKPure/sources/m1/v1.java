package m1;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import m1.s;
import m1.v1;
/* loaded from: classes.dex */
public final class v1 implements s {
    public final z0.x4<y> y;

    /* renamed from: v  reason: collision with root package name */
    public static final v1 f11282v = new v1(z0.x4.j5());

    /* renamed from: fb  reason: collision with root package name */
    public static final String f11280fb = v5.j5.g3(0);

    /* renamed from: s  reason: collision with root package name */
    public static final s.y<v1> f11281s = new s.y() { // from class: m1.jb
        @Override // m1.s.y
        public final s fromBundle(Bundle bundle) {
            v1 v2;
            v2 = v1.v(bundle);
            return v2;
        }
    };

    /* loaded from: classes.dex */
    public static final class y implements s {

        /* renamed from: f  reason: collision with root package name */
        public final boolean[] f11288f;

        /* renamed from: fb  reason: collision with root package name */
        public final boolean f11289fb;

        /* renamed from: s  reason: collision with root package name */
        public final int[] f11290s;

        /* renamed from: v  reason: collision with root package name */
        public final af.rs f11291v;
        public final int y;

        /* renamed from: t  reason: collision with root package name */
        public static final String f11285t = v5.j5.g3(0);

        /* renamed from: w  reason: collision with root package name */
        public static final String f11286w = v5.j5.g3(1);

        /* renamed from: p  reason: collision with root package name */
        public static final String f11284p = v5.j5.g3(3);

        /* renamed from: co  reason: collision with root package name */
        public static final String f11283co = v5.j5.g3(4);

        /* renamed from: z  reason: collision with root package name */
        public static final s.y<y> f11287z = new s.y() { // from class: m1.sw
            @Override // m1.s.y
            public final s fromBundle(Bundle bundle) {
                v1.y i92;
                i92 = v1.y.i9(bundle);
                return i92;
            }
        };

        public y(af.rs rsVar, boolean z2, int[] iArr, boolean[] zArr) {
            boolean z3;
            int i = rsVar.y;
            this.y = i;
            boolean z4 = false;
            if (i == iArr.length && i == zArr.length) {
                z3 = true;
            } else {
                z3 = false;
            }
            v5.y.y(z3);
            this.f11291v = rsVar;
            if (z2 && i > 1) {
                z4 = true;
            }
            this.f11289fb = z4;
            this.f11290s = (int[]) iArr.clone();
            this.f11288f = (boolean[]) zArr.clone();
        }

        public static /* synthetic */ y i9(Bundle bundle) {
            af.rs fromBundle = af.rs.f375p.fromBundle((Bundle) v5.y.v(bundle.getBundle(f11285t)));
            return new y(fromBundle, bundle.getBoolean(f11283co, false), (int[]) w0.c5.y(bundle.getIntArray(f11286w), new int[fromBundle.y]), (boolean[]) w0.c5.y(bundle.getBooleanArray(f11284p), new boolean[fromBundle.y]));
        }

        public boolean a() {
            return d1.y.n3(this.f11288f, true);
        }

        public boolean c5(int i, boolean z2) {
            int i5 = this.f11290s[i];
            if (i5 != 4 && (!z2 || i5 != 3)) {
                return false;
            }
            return true;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || y.class != obj.getClass()) {
                return false;
            }
            y yVar = (y) obj;
            if (this.f11289fb == yVar.f11289fb && this.f11291v.equals(yVar.f11291v) && Arrays.equals(this.f11290s, yVar.f11290s) && Arrays.equals(this.f11288f, yVar.f11288f)) {
                return true;
            }
            return false;
        }

        public boolean fb(int i) {
            return this.f11288f[i];
        }

        public int gv() {
            return this.f11291v.f379fb;
        }

        public int hashCode() {
            return (((((this.f11291v.hashCode() * 31) + (this.f11289fb ? 1 : 0)) * 31) + Arrays.hashCode(this.f11290s)) * 31) + Arrays.hashCode(this.f11288f);
        }

        public af.rs n3() {
            return this.f11291v;
        }

        public boolean s(int i) {
            return c5(i, false);
        }

        @Override // m1.s
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBundle(f11285t, this.f11291v.toBundle());
            bundle.putIntArray(f11286w, this.f11290s);
            bundle.putBooleanArray(f11284p, this.f11288f);
            bundle.putBoolean(f11283co, this.f11289fb);
            return bundle;
        }

        public boolean v() {
            return this.f11289fb;
        }

        public m zn(int i) {
            return this.f11291v.zn(i);
        }
    }

    public v1(List<y> list) {
        this.y = z0.x4.d(list);
    }

    public static /* synthetic */ v1 v(Bundle bundle) {
        z0.x4 n32;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f11280fb);
        if (parcelableArrayList == null) {
            n32 = z0.x4.j5();
        } else {
            n32 = v5.gv.n3(y.f11287z, parcelableArrayList);
        }
        return new v1(n32);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && v1.class == obj.getClass()) {
            return this.y.equals(((v1) obj).y);
        }
        return false;
    }

    public boolean gv(int i) {
        for (int i5 = 0; i5 < this.y.size(); i5++) {
            y yVar = this.y.get(i5);
            if (yVar.a() && yVar.gv() == i) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.y.hashCode();
    }

    public z0.x4<y> n3() {
        return this.y;
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(f11280fb, v5.gv.gv(this.y));
        return bundle;
    }

    public boolean zn() {
        return this.y.isEmpty();
    }
}
