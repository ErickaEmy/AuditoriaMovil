package m1;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class vc {

    /* renamed from: a  reason: collision with root package name */
    public static final vc f11292a;

    /* renamed from: fb  reason: collision with root package name */
    public static final vc f11293fb;

    /* renamed from: gv  reason: collision with root package name */
    public static final vc f11294gv;

    /* renamed from: v  reason: collision with root package name */
    public static final vc f11295v;

    /* renamed from: zn  reason: collision with root package name */
    public static final vc f11296zn;

    /* renamed from: n3  reason: collision with root package name */
    public final long f11297n3;
    public final long y;

    static {
        vc vcVar = new vc(0L, 0L);
        f11296zn = vcVar;
        f11294gv = new vc(Long.MAX_VALUE, Long.MAX_VALUE);
        f11295v = new vc(Long.MAX_VALUE, 0L);
        f11292a = new vc(0L, Long.MAX_VALUE);
        f11293fb = vcVar;
    }

    public vc(long j2, long j4) {
        boolean z2;
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        v5.y.y(j4 >= 0);
        this.y = j2;
        this.f11297n3 = j4;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || vc.class != obj.getClass()) {
            return false;
        }
        vc vcVar = (vc) obj;
        if (this.y == vcVar.y && this.f11297n3 == vcVar.f11297n3) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.y) * 31) + ((int) this.f11297n3);
    }

    public long y(long j2, long j4, long j6) {
        boolean z2;
        long j7 = this.y;
        if (j7 == 0 && this.f11297n3 == 0) {
            return j2;
        }
        long i22 = v5.j5.i2(j2, j7, Long.MIN_VALUE);
        long n32 = v5.j5.n3(j2, this.f11297n3, Long.MAX_VALUE);
        boolean z3 = false;
        if (i22 <= j4 && j4 <= n32) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (i22 <= j6 && j6 <= n32) {
            z3 = true;
        }
        if (z2 && z3) {
            if (Math.abs(j4 - j2) <= Math.abs(j6 - j2)) {
                return j4;
            }
            return j6;
        } else if (z2) {
            return j4;
        } else {
            if (z3) {
                return j6;
            }
            return i22;
        }
    }
}
