package e4;

import java.io.IOException;
import m1.ne;
import v5.j5;
/* loaded from: classes.dex */
public final class co {

    /* loaded from: classes.dex */
    public static final class y {
        public long y;
    }

    public static boolean a(int i, x4 x4Var) {
        if (i == 0 || i == x4Var.f7524c5) {
            return true;
        }
        return false;
    }

    public static long c5(tl tlVar, x4 x4Var) throws IOException {
        int i;
        tlVar.s();
        boolean z2 = true;
        tlVar.wz(1);
        byte[] bArr = new byte[1];
        tlVar.z(bArr, 0, 1);
        if ((bArr[0] & 1) != 1) {
            z2 = false;
        }
        tlVar.wz(2);
        if (z2) {
            i = 7;
        } else {
            i = 6;
        }
        v5.rz rzVar = new v5.rz(i);
        rzVar.j(xc.zn(tlVar, rzVar.v(), 0, i));
        tlVar.s();
        y yVar = new y();
        if (zn(rzVar, x4Var, z2, yVar)) {
            return yVar.y;
        }
        throw ne.y(null, null);
    }

    public static boolean fb(int i, x4 x4Var) {
        if (i <= 7) {
            if (i != x4Var.f7526fb - 1) {
                return false;
            }
            return true;
        } else if (i > 10 || x4Var.f7526fb != 2) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean gv(v5.rz rzVar, x4 x4Var, int i, y yVar) {
        boolean z2;
        boolean z3;
        int a2 = rzVar.a();
        long a82 = rzVar.a8();
        long j2 = a82 >>> 16;
        if (j2 != i) {
            return false;
        }
        if ((j2 & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i5 = (int) ((a82 >> 12) & 15);
        int i6 = (int) ((a82 >> 8) & 15);
        int i8 = (int) (15 & (a82 >> 4));
        int i10 = (int) ((a82 >> 1) & 7);
        if ((a82 & 1) == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!fb(i8, x4Var) || !a(i10, x4Var) || z3 || !zn(rzVar, x4Var, z2, yVar) || !y(rzVar, x4Var, i5) || !v(rzVar, x4Var, i6) || !n3(rzVar, a2)) {
            return false;
        }
        return true;
    }

    public static int i9(v5.rz rzVar, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return rzVar.ej() + 1;
            case 7:
                return rzVar.yt() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    public static boolean n3(v5.rz rzVar, int i) {
        if (rzVar.ej() == j5.r(rzVar.v(), i, rzVar.a() - 1, 0)) {
            return true;
        }
        return false;
    }

    public static boolean s(tl tlVar, x4 x4Var, int i, y yVar) throws IOException {
        long t2 = tlVar.t();
        byte[] bArr = new byte[2];
        tlVar.z(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
            tlVar.s();
            tlVar.wz((int) (t2 - tlVar.getPosition()));
            return false;
        }
        v5.rz rzVar = new v5.rz(16);
        System.arraycopy(bArr, 0, rzVar.v(), 0, 2);
        rzVar.j(xc.zn(tlVar, rzVar.v(), 2, 14));
        tlVar.s();
        tlVar.wz((int) (t2 - tlVar.getPosition()));
        return gv(rzVar, x4Var, i, yVar);
    }

    public static boolean v(v5.rz rzVar, x4 x4Var, int i) {
        int i5 = x4Var.f7532v;
        if (i == 0) {
            return true;
        }
        if (i <= 11) {
            if (i == x4Var.f7523a) {
                return true;
            }
            return false;
        } else if (i == 12) {
            if (rzVar.ej() * 1000 == i5) {
                return true;
            }
            return false;
        } else if (i > 14) {
            return false;
        } else {
            int yt2 = rzVar.yt();
            if (i == 14) {
                yt2 *= 10;
            }
            if (yt2 == i5) {
                return true;
            }
            return false;
        }
    }

    public static boolean y(v5.rz rzVar, x4 x4Var, int i) {
        int i92 = i9(rzVar, i);
        if (i92 != -1 && i92 <= x4Var.f7529n3) {
            return true;
        }
        return false;
    }

    public static boolean zn(v5.rz rzVar, x4 x4Var, boolean z2, y yVar) {
        try {
            long vl2 = rzVar.vl();
            if (!z2) {
                vl2 *= x4Var.f7529n3;
            }
            yVar.y = vl2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
