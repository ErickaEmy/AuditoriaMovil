package vl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;
/* loaded from: classes.dex */
public class zn {

    /* loaded from: classes.dex */
    public static class y {
        public static int n3(Object... objArr) {
            return Objects.hash(objArr);
        }

        public static boolean y(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }
    }

    @NonNull
    public static <T> T gv(@Nullable T t2, @NonNull String str) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(str);
    }

    public static int n3(@Nullable Object... objArr) {
        return y.n3(objArr);
    }

    public static boolean y(@Nullable Object obj, @Nullable Object obj2) {
        return y.y(obj, obj2);
    }

    @NonNull
    public static <T> T zn(@Nullable T t2) {
        t2.getClass();
        return t2;
    }
}
