package w0;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class f extends a {
    public static int n3(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static boolean y(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }
}
