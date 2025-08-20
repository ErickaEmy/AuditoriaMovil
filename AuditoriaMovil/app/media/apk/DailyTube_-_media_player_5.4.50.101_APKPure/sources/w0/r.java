package w0;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class r {

    /* renamed from: n3  reason: collision with root package name */
    public static final Method f14517n3;
    public static final Object y;

    /* renamed from: zn  reason: collision with root package name */
    public static final Method f14518zn;

    static {
        Method y2;
        Object n32 = n3();
        y = n32;
        Method method = null;
        if (n32 == null) {
            y2 = null;
        } else {
            y2 = y();
        }
        f14517n3 = y2;
        if (n32 != null) {
            method = gv(n32);
        }
        f14518zn = method;
    }

    public static Method gv(Object obj) {
        try {
            Method zn2 = zn("getStackTraceDepth", Throwable.class);
            if (zn2 == null) {
                return null;
            }
            zn2.invoke(obj, new Throwable());
            return zn2;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static Object n3() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", null).invoke(null, null);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void v(Throwable th) {
        xc.wz(th);
        if (!(th instanceof RuntimeException)) {
            if (!(th instanceof Error)) {
                return;
            }
            throw ((Error) th);
        }
        throw ((RuntimeException) th);
    }

    public static Method y() {
        return zn("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    public static Method zn(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }
}
