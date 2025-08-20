package w0;
/* loaded from: classes.dex */
public final class c5 {
    public static <T> T y(T t2, T t3) {
        if (t2 != null) {
            return t2;
        }
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException("Both parameters are null");
    }
}
