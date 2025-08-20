package m1;

import android.os.Bundle;
import m1.s;
/* loaded from: classes.dex */
public abstract class r6 implements s {
    public static final String y = v5.j5.g3(0);

    /* renamed from: v  reason: collision with root package name */
    public static final s.y<r6> f11234v = new s.y() { // from class: m1.ia
        @Override // m1.s.y
        public final s fromBundle(Bundle bundle) {
            r6 n32;
            n32 = r6.n3(bundle);
            return n32;
        }
    };

    public static r6 n3(Bundle bundle) {
        int i = bundle.getInt(y, -1);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return cx.f10653w.fromBundle(bundle);
                    }
                    throw new IllegalArgumentException("Unknown RatingType: " + i);
                }
                return i.f10839w.fromBundle(bundle);
            }
            return wm.f11314f.fromBundle(bundle);
        }
        return y4.f11330w.fromBundle(bundle);
    }
}
