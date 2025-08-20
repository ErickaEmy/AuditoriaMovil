package kellinwood.security.zipsigner;
/* loaded from: classes.dex */
public class ProgressEvent {
    public static final int PRORITY_IMPORTANT = 1;
    public static final int PRORITY_NORMAL = 0;
    private String message;
    private int percentDone;
    private int priority;

    public String getMessage() {
        return this.message;
    }

    public int getPercentDone() {
        return this.percentDone;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setPercentDone(int i) {
        this.percentDone = i;
    }

    public void setPriority(int i) {
        this.priority = i;
    }
}
