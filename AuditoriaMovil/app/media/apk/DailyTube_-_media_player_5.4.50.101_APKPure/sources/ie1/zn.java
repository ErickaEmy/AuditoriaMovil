package ie1;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public interface zn<R, T> {

    /* loaded from: classes.dex */
    public static abstract class y {
        public static Type n3(int i, ParameterizedType parameterizedType) {
            return i4.s(i, parameterizedType);
        }

        public static Class<?> zn(Type type) {
            return i4.c5(type);
        }

        public abstract zn<?, ?> y(Type type, Annotation[] annotationArr, co coVar);
    }

    T n3(n3<R> n3Var);

    Type y();
}
