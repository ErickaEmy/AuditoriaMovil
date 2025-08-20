package b;

import android.os.Build;
import android.os.Trace;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;
@Deprecated
/* loaded from: classes.dex */
public final class xc {

    /* renamed from: gv  reason: collision with root package name */
    public static Method f3824gv;

    /* renamed from: n3  reason: collision with root package name */
    public static Method f3825n3;

    /* renamed from: v  reason: collision with root package name */
    public static Method f3826v;
    public static long y;

    /* renamed from: zn  reason: collision with root package name */
    public static Method f3827zn;

    /* loaded from: classes.dex */
    public static class y {
        public static void n3() {
            Trace.endSection();
        }

        public static void y(String str) {
            Trace.beginSection(str);
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                y = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f3825n3 = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f3827zn = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f3824gv = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f3826v = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception unused) {
            }
        }
    }

    public static void n3() {
        y.n3();
    }

    public static void y(@NonNull String str) {
        y.y(str);
    }
}
