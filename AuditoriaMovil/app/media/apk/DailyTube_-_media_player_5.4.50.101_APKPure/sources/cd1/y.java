package cd1;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
/* loaded from: classes.dex */
public class y {

    /* renamed from: cd1.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0043y implements InvocationHandler {
        public final Object y;

        public C0043y(@NonNull Object obj) {
            this.y = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                return y.gv(method, this.y.getClass().getClassLoader()).invoke(this.y, objArr);
            } catch (InvocationTargetException e2) {
                throw e2.getTargetException();
            } catch (ReflectiveOperationException e3) {
                throw new RuntimeException("Reflection failed for method " + method, e3);
            }
        }
    }

    public static Method gv(Method method, ClassLoader classLoader) throws ClassNotFoundException, NoSuchMethodException {
        return Class.forName(method.getDeclaringClass().getName(), true, classLoader).getDeclaredMethod(method.getName(), method.getParameterTypes());
    }

    public static boolean n3(Collection<String> collection, String str) {
        if (!collection.contains(str)) {
            if (v()) {
                if (collection.contains(str + ":dev")) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean v() {
        String str = Build.TYPE;
        if (!"eng".equals(str) && !"userdebug".equals(str)) {
            return false;
        }
        return true;
    }

    @Nullable
    public static <T> T y(@NonNull Class<T> cls, @Nullable InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(y.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    @Nullable
    public static InvocationHandler zn(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        return new C0043y(obj);
    }
}
