package y3;

import e4.y;
import java.io.IOException;
import v5.j5;
import v5.k5;
/* loaded from: classes.dex */
public final class f3 extends e4.y {

    /* loaded from: classes.dex */
    public static final class n3 implements y.a {

        /* renamed from: n3  reason: collision with root package name */
        public final v5.rz f15070n3;
        public final k5 y;

        public static void gv(v5.rz rzVar) {
            int f4;
            int fb2 = rzVar.fb();
            if (rzVar.y() < 10) {
                rzVar.oz(fb2);
                return;
            }
            rzVar.ut(9);
            int ej2 = rzVar.ej() & 7;
            if (rzVar.y() < ej2) {
                rzVar.oz(fb2);
                return;
            }
            rzVar.ut(ej2);
            if (rzVar.y() < 4) {
                rzVar.oz(fb2);
                return;
            }
            if (f3.f(rzVar.v(), rzVar.a()) == 443) {
                rzVar.ut(4);
                int yt2 = rzVar.yt();
                if (rzVar.y() < yt2) {
                    rzVar.oz(fb2);
                    return;
                }
                rzVar.ut(yt2);
            }
            while (rzVar.y() >= 4 && (f4 = f3.f(rzVar.v(), rzVar.a())) != 442 && f4 != 441 && (f4 >>> 8) == 1) {
                rzVar.ut(4);
                if (rzVar.y() < 2) {
                    rzVar.oz(fb2);
                    return;
                }
                rzVar.oz(Math.min(rzVar.fb(), rzVar.a() + rzVar.yt()));
            }
        }

        @Override // e4.y.a
        public void n3() {
            this.f15070n3.qn(j5.f14357a);
        }

        @Override // e4.y.a
        public y.v y(e4.tl tlVar, long j2) throws IOException {
            long position = tlVar.getPosition();
            int min = (int) Math.min(20000L, tlVar.getLength() - position);
            this.f15070n3.j5(min);
            tlVar.z(this.f15070n3.v(), 0, min);
            return zn(this.f15070n3, j2, position);
        }

        public final y.v zn(v5.rz rzVar, long j2, long j4) {
            int i = -1;
            long j6 = -9223372036854775807L;
            int i5 = -1;
            while (rzVar.y() >= 4) {
                if (f3.f(rzVar.v(), rzVar.a()) != 442) {
                    rzVar.ut(1);
                } else {
                    rzVar.ut(4);
                    long t2 = n.t(rzVar);
                    if (t2 != -9223372036854775807L) {
                        long n32 = this.y.n3(t2);
                        if (n32 > j2) {
                            if (j6 == -9223372036854775807L) {
                                return y.v.gv(n32, j4);
                            }
                            return y.v.v(j4 + i5);
                        } else if (100000 + n32 > j2) {
                            return y.v.v(j4 + rzVar.a());
                        } else {
                            i5 = rzVar.a();
                            j6 = n32;
                        }
                    }
                    gv(rzVar);
                    i = rzVar.a();
                }
            }
            if (j6 != -9223372036854775807L) {
                return y.v.a(j6, j4 + i);
            }
            return y.v.f7538gv;
        }

        public n3(k5 k5Var) {
            this.y = k5Var;
            this.f15070n3 = new v5.rz();
        }
    }

    public f3(k5 k5Var, long j2, long j4) {
        super(new y.n3(), new n3(k5Var), j2, 0L, j2 + 1, 0L, j4, 188L, 1000);
    }

    public static int f(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
