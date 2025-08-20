package yk;
/* loaded from: classes.dex */
public enum vl {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    /* loaded from: classes.dex */
    public static /* synthetic */ class y {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[vl.values().length];
            y = iArr;
            try {
                iArr[vl.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[vl.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                y[vl.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean gv(int i, boolean z2, int i5) {
        int i6 = y.y[ordinal()];
        if (i6 == 1) {
            return false;
        }
        if (i6 == 2) {
            return true;
        }
        if ((!z2 || i >= 28) && i5 <= 4 && i > 25) {
            return false;
        }
        return true;
    }
}
