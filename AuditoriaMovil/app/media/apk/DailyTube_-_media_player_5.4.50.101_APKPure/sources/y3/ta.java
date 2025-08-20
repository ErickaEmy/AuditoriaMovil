package y3;

import e4.y;
import java.io.IOException;
import v5.j5;
import v5.k5;
/* loaded from: classes.dex */
public final class ta extends e4.y {

    /* loaded from: classes.dex */
    public static final class y implements y.a {

        /* renamed from: gv  reason: collision with root package name */
        public final int f15150gv;

        /* renamed from: n3  reason: collision with root package name */
        public final v5.rz f15151n3 = new v5.rz();
        public final k5 y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f15152zn;

        public y(int i, k5 k5Var, int i5) {
            this.f15152zn = i;
            this.y = k5Var;
            this.f15150gv = i5;
        }

        @Override // e4.y.a
        public void n3() {
            this.f15151n3.qn(j5.f14357a);
        }

        @Override // e4.y.a
        public y.v y(e4.tl tlVar, long j2) throws IOException {
            long position = tlVar.getPosition();
            int min = (int) Math.min(this.f15150gv, tlVar.getLength() - position);
            this.f15151n3.j5(min);
            tlVar.z(this.f15151n3.v(), 0, min);
            return zn(this.f15151n3, j2, position);
        }

        public final y.v zn(v5.rz rzVar, long j2, long j4) {
            int y;
            int y2;
            int fb2 = rzVar.fb();
            long j6 = -1;
            long j7 = -1;
            long j8 = -9223372036854775807L;
            while (rzVar.y() >= 188 && (y2 = (y = a8.y(rzVar.v(), rzVar.a(), fb2)) + 188) <= fb2) {
                long zn2 = a8.zn(rzVar, y, this.f15152zn);
                if (zn2 != -9223372036854775807L) {
                    long n32 = this.y.n3(zn2);
                    if (n32 > j2) {
                        if (j8 == -9223372036854775807L) {
                            return y.v.gv(n32, j4);
                        }
                        return y.v.v(j4 + j7);
                    } else if (100000 + n32 > j2) {
                        return y.v.v(j4 + y);
                    } else {
                        j7 = y;
                        j8 = n32;
                    }
                }
                rzVar.oz(y2);
                j6 = y2;
            }
            if (j8 != -9223372036854775807L) {
                return y.v.a(j8, j4 + j6);
            }
            return y.v.f7538gv;
        }
    }

    public ta(k5 k5Var, long j2, long j4, int i, int i5) {
        super(new y.n3(), new y(i, k5Var, i5), j2, 0L, j2 + 1, 0L, j4, 188L, 940);
    }
}
