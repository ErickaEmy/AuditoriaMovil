package v5;

import android.text.TextUtils;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class y {
    public static <T> T a(@Nullable T t2, Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T c5(@Nullable T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new IllegalStateException();
    }

    public static void fb(boolean z2) {
        if (z2) {
            return;
        }
        throw new IllegalStateException();
    }

    public static String gv(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }

    public static <T> T i9(@Nullable T t2, Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new IllegalStateException(String.valueOf(obj));
    }

    public static void n3(boolean z2, Object obj) {
        if (z2) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static void s(boolean z2, Object obj) {
        if (z2) {
            return;
        }
        throw new IllegalStateException(String.valueOf(obj));
    }

    public static <T> T v(@Nullable T t2) {
        t2.getClass();
        return t2;
    }

    public static void y(boolean z2) {
        if (z2) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static int zn(int i, int i5, int i6) {
        if (i >= i5 && i < i6) {
            return i;
        }
        throw new IndexOutOfBoundsException();
    }
}
