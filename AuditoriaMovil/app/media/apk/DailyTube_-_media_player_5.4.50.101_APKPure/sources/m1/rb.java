package m1;
/* loaded from: classes.dex */
public final class rb extends RuntimeException {
    public final int timeoutOperation;

    public rb(int i) {
        super(y(i));
        this.timeoutOperation = i;
    }

    public static String y(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return "Undefined timeout.";
                }
                return "Detaching surface timed out.";
            }
            return "Setting foreground mode timed out.";
        }
        return "Player release timed out.";
    }
}
