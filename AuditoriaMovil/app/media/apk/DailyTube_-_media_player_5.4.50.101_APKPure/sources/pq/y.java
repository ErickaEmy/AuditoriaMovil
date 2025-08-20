package pq;

import android.annotation.SuppressLint;
import android.os.Trace;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: n3  reason: collision with root package name */
    public static Method f12602n3;
    public static long y;

    @SuppressLint({"NewApi"})
    public static boolean gv() {
        try {
            if (f12602n3 == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return v();
    }

    public static void n3() {
        n3.n3();
    }

    public static boolean v() {
        try {
            if (f12602n3 == null) {
                y = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f12602n3 = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f12602n3.invoke(null, Long.valueOf(y))).booleanValue();
        } catch (Exception e2) {
            zn("isTagEnabled", e2);
            return false;
        }
    }

    public static void y(@NonNull String str) {
        n3.y(str);
    }

    public static void zn(@NonNull String str, @NonNull Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }
}
