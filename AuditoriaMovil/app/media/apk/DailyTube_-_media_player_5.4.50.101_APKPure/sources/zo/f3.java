package zo;

import af.rs;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import m1.s;
import v5.j5;
/* loaded from: classes.dex */
public final class f3 implements m1.s {

    /* renamed from: v  reason: collision with root package name */
    public final z0.x4<Integer> f15761v;
    public final rs y;

    /* renamed from: fb  reason: collision with root package name */
    public static final String f15759fb = j5.g3(0);

    /* renamed from: s  reason: collision with root package name */
    public static final String f15760s = j5.g3(1);

    /* renamed from: f  reason: collision with root package name */
    public static final s.y<f3> f15758f = new s.y() { // from class: zo.i4
        @Override // m1.s.y
        public final m1.s fromBundle(Bundle bundle) {
            f3 zn2;
            zn2 = f3.zn(bundle);
            return zn2;
        }
    };

    public f3(rs rsVar, List<Integer> list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= rsVar.y)) {
            throw new IndexOutOfBoundsException();
        }
        this.y = rsVar;
        this.f15761v = z0.x4.d(list);
    }

    public static /* synthetic */ f3 zn(Bundle bundle) {
        return new f3(rs.f375p.fromBundle((Bundle) v5.y.v(bundle.getBundle(f15759fb))), d1.a.zn((int[]) v5.y.v(bundle.getIntArray(f15760s))));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f3.class != obj.getClass()) {
            return false;
        }
        f3 f3Var = (f3) obj;
        if (this.y.equals(f3Var.y) && this.f15761v.equals(f3Var.f15761v)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.y.hashCode() + (this.f15761v.hashCode() * 31);
    }

    public int n3() {
        return this.y.f379fb;
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBundle(f15759fb, this.y.toBundle());
        bundle.putIntArray(f15760s, d1.a.wz(this.f15761v));
        return bundle;
    }
}
