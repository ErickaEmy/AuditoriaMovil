package j0;
/* loaded from: classes.dex */
public final class j5 extends RuntimeException {
    public j5(String str) {
        super(str);
    }

    public j5(String str, Throwable th) {
        super("Failed to initialize FileStorage", th);
    }
}
