package j0;
/* loaded from: classes.dex */
public final class o4 {
    public static void n3(boolean z2, Object obj) {
        if (z2) {
            return;
        }
        throw new IllegalStateException(String.valueOf(obj));
    }

    public static Object y(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }
}
