package qh;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import m1.s;
import v5.j5;
import z0.x4;
/* loaded from: classes.dex */
public final class a implements m1.s {

    /* renamed from: v  reason: collision with root package name */
    public final long f12837v;
    public final x4<n3> y;

    /* renamed from: fb  reason: collision with root package name */
    public static final a f12834fb = new a(x4.j5(), 0);

    /* renamed from: s  reason: collision with root package name */
    public static final String f12835s = j5.g3(0);

    /* renamed from: f  reason: collision with root package name */
    public static final String f12833f = j5.g3(1);

    /* renamed from: t  reason: collision with root package name */
    public static final s.y<a> f12836t = new s.y() { // from class: qh.v
        @Override // m1.s.y
        public final m1.s fromBundle(Bundle bundle) {
            a zn2;
            zn2 = a.zn(bundle);
            return zn2;
        }
    };

    public a(List<n3> list, long j2) {
        this.y = x4.d(list);
        this.f12837v = j2;
    }

    public static x4<n3> n3(List<n3> list) {
        x4.y x42 = x4.x4();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).f12874s == null) {
                x42.y(list.get(i));
            }
        }
        return x42.s();
    }

    public static final a zn(Bundle bundle) {
        x4 n32;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f12835s);
        if (parcelableArrayList == null) {
            n32 = x4.j5();
        } else {
            n32 = v5.gv.n3(n3.f12845ct, parcelableArrayList);
        }
        return new a(n32, bundle.getLong(f12833f));
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(f12835s, v5.gv.gv(n3(this.y)));
        bundle.putLong(f12833f, this.f12837v);
        return bundle;
    }
}
