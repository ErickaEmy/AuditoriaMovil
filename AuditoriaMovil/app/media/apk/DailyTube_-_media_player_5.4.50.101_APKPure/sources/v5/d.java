package v5;
/* loaded from: classes.dex */
public final class d {
    public static boolean n3(int i, int i5) {
        if (i == 0) {
            return true;
        }
        if (i != 1) {
            if (i == 2 && (i5 & 2) != 0) {
                return true;
            }
            return false;
        } else if ((i5 & 1) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int y(int i, int i5) {
        for (int i6 = 1; i6 <= 2; i6++) {
            int i8 = (i + i6) % 3;
            if (n3(i8, i5)) {
                return i8;
            }
        }
        return i;
    }
}
