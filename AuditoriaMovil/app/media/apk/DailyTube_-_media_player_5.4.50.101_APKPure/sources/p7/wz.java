package p7;

import androidx.annotation.Nullable;
import kx.p;
import m1.m;
/* loaded from: classes.dex */
public abstract class wz extends a {

    /* renamed from: i9  reason: collision with root package name */
    public final long f12511i9;

    public wz(kx.tl tlVar, p pVar, m mVar, int i, @Nullable Object obj, long j2, long j4, long j6) {
        super(tlVar, pVar, 1, mVar, i, obj, j2, j4);
        v5.y.v(mVar);
        this.f12511i9 = j6;
    }

    public long a() {
        long j2 = this.f12511i9;
        if (j2 == -1) {
            return -1L;
        }
        return 1 + j2;
    }

    public abstract boolean fb();
}
