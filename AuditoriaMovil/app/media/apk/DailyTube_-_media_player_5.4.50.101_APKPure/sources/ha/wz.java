package ha;

import java.io.IOException;
import v5.rz;
/* loaded from: classes.dex */
public final class wz {
    public static final int[] y = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean gv(e4.tl tlVar, boolean z2) throws IOException {
        return zn(tlVar, false, z2);
    }

    public static boolean n3(e4.tl tlVar) throws IOException {
        return zn(tlVar, true, false);
    }

    public static boolean y(int i, boolean z2) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z2) {
            return true;
        }
        for (int i5 : y) {
            if (i5 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean zn(e4.tl tlVar, boolean z2, boolean z3) throws IOException {
        boolean z4;
        boolean z5;
        int i;
        long length = tlVar.getLength();
        long j2 = 4096;
        long j4 = -1;
        int i5 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i5 != 0 && length <= 4096) {
            j2 = length;
        }
        int i6 = (int) j2;
        rz rzVar = new rz(64);
        boolean z7 = false;
        int i8 = 0;
        boolean z8 = false;
        while (i8 < i6) {
            rzVar.j5(8);
            if (!tlVar.v(rzVar.v(), z7 ? 1 : 0, 8, true)) {
                break;
            }
            long a82 = rzVar.a8();
            int p2 = rzVar.p();
            if (a82 == 1) {
                tlVar.z(rzVar.v(), 8, 8);
                rzVar.j(16);
                a82 = rzVar.d0();
                i = 16;
            } else {
                if (a82 == 0) {
                    long length2 = tlVar.getLength();
                    if (length2 != j4) {
                        a82 = (length2 - tlVar.t()) + 8;
                    }
                }
                i = 8;
            }
            long j6 = i;
            if (a82 < j6) {
                return z7;
            }
            i8 += i;
            if (p2 == 1836019574) {
                i6 += (int) a82;
                if (i5 != 0 && i6 > length) {
                    i6 = (int) length;
                }
                j4 = -1;
            } else if (p2 == 1836019558 || p2 == 1836475768) {
                z4 = true;
                z5 = true;
                break;
            } else {
                int i10 = i5;
                if ((i8 + a82) - j6 >= i6) {
                    break;
                }
                int i11 = (int) (a82 - j6);
                i8 += i11;
                if (p2 == 1718909296) {
                    if (i11 < 8) {
                        return false;
                    }
                    rzVar.j5(i11);
                    tlVar.z(rzVar.v(), 0, i11);
                    int i12 = i11 / 4;
                    int i13 = 0;
                    while (true) {
                        if (i13 >= i12) {
                            break;
                        }
                        if (i13 == 1) {
                            rzVar.ut(4);
                        } else if (y(rzVar.p(), z3)) {
                            z8 = true;
                            break;
                        }
                        i13++;
                    }
                    if (!z8) {
                        return false;
                    }
                } else if (i11 != 0) {
                    tlVar.wz(i11);
                }
                i5 = i10;
                j4 = -1;
                z7 = false;
            }
        }
        z4 = true;
        z5 = false;
        if (!z8 || z2 != z5) {
            return false;
        }
        return z4;
    }
}
