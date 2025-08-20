package f8;
/* loaded from: classes.dex */
public final class fh extends Exception {
    public final int reason;

    public fh(int i) {
        this.reason = i;
    }

    public fh(int i, Exception exc) {
        super(exc);
        this.reason = i;
    }
}
