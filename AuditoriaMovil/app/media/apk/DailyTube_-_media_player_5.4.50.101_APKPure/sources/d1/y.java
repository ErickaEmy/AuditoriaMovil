package d1;
/* loaded from: classes.dex */
public final class y {
    public static boolean n3(boolean[] zArr, boolean z2) {
        for (boolean z3 : zArr) {
            if (z3 == z2) {
                return true;
            }
        }
        return false;
    }

    public static int y(boolean z2, boolean z3) {
        if (z2 == z3) {
            return 0;
        }
        if (z2) {
            return 1;
        }
        return -1;
    }
}
