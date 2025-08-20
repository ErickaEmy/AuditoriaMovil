package y3;
/* loaded from: classes.dex */
public final class a8 {
    public static long gv(byte[] bArr) {
        return ((bArr[0] & 255) << 25) | ((bArr[1] & 255) << 17) | ((bArr[2] & 255) << 9) | ((bArr[3] & 255) << 1) | ((255 & bArr[4]) >> 7);
    }

    public static boolean n3(byte[] bArr, int i, int i5, int i6) {
        int i8 = 0;
        for (int i10 = -4; i10 <= 4; i10++) {
            int i11 = (i10 * 188) + i6;
            if (i11 >= i && i11 < i5 && bArr[i11] == 71) {
                i8++;
                if (i8 == 5) {
                    return true;
                }
            } else {
                i8 = 0;
            }
        }
        return false;
    }

    public static int y(byte[] bArr, int i, int i5) {
        while (i < i5 && bArr[i] != 71) {
            i++;
        }
        return i;
    }

    public static long zn(v5.rz rzVar, int i, int i5) {
        rzVar.oz(i);
        if (rzVar.y() < 5) {
            return -9223372036854775807L;
        }
        int p2 = rzVar.p();
        if ((8388608 & p2) != 0 || ((2096896 & p2) >> 8) != i5 || (p2 & 32) == 0 || rzVar.ej() < 7 || rzVar.y() < 7 || (rzVar.ej() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        rzVar.t(bArr, 0, 6);
        return gv(bArr);
    }
}
