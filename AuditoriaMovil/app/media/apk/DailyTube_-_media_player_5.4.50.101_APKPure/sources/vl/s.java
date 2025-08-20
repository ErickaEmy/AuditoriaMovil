package vl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;
/* loaded from: classes.dex */
public final class s {
    public static int a(int i, int i5) {
        if ((i & i5) == i) {
            return i;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i) + ", but only 0x" + Integer.toHexString(i5) + " are allowed");
    }

    @NonNull
    public static <T extends CharSequence> T c5(@Nullable T t2, @NonNull Object obj) {
        if (!TextUtils.isEmpty(t2)) {
            return t2;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @NonNull
    public static <T> T fb(@Nullable T t2) {
        t2.getClass();
        return t2;
    }

    public static int gv(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException();
    }

    public static void n3(boolean z2, @NonNull Object obj) {
        if (z2) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @NonNull
    public static <T> T s(@Nullable T t2, @NonNull Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int v(int i, @Nullable String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str);
    }

    public static void y(boolean z2) {
        if (z2) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static int zn(int i, int i5, int i6, @NonNull String str) {
        if (i >= i5) {
            if (i <= i6) {
                return i;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i5), Integer.valueOf(i6)));
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i5), Integer.valueOf(i6)));
    }
}
