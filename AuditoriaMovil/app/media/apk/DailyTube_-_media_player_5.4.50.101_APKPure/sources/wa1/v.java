package wa1;
/* loaded from: classes.dex */
public final class v {
    public static final int y(int i, int i5, int i6) {
        int min = Math.min(i5, i6);
        int max = Math.max(i5, i6);
        if (i < min) {
            return min;
        }
        if (i > max) {
            return max;
        }
        return i;
    }
}
