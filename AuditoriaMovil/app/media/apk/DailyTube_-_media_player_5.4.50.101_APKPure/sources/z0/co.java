package z0;
/* loaded from: classes.dex */
public final class co {
    public static int n3(int i) {
        return (int) (Integer.rotateLeft((int) (i * (-862048943)), 15) * 461845907);
    }

    public static int y(int i, double d2) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max > ((int) (d2 * highestOneBit))) {
            int i5 = highestOneBit << 1;
            if (i5 <= 0) {
                return 1073741824;
            }
            return i5;
        }
        return highestOneBit;
    }

    public static int zn(Object obj) {
        int hashCode;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return n3(hashCode);
    }
}
