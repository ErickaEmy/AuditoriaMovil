package ie1;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public abstract class z<T> {
    public static <T> z<T> n3(co coVar, Method method) {
        p n32 = p.n3(coVar, method);
        Type genericReturnType = method.getGenericReturnType();
        if (!i4.f(genericReturnType)) {
            if (genericReturnType != Void.TYPE) {
                return c5.a(coVar, method, n32);
            }
            throw i4.wz(method, "Service methods cannot return void.", new Object[0]);
        }
        throw i4.wz(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
    }

    public abstract T y(Object[] objArr);
}
