package ie1;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kc1.fh;
import kc1.mg;
/* loaded from: classes.dex */
public interface a<F, T> {

    /* loaded from: classes.dex */
    public static abstract class y {
        public static Class<?> n3(Type type) {
            return i4.c5(type);
        }

        public static Type y(int i, ParameterizedType parameterizedType) {
            return i4.s(i, parameterizedType);
        }

        public a<mg, ?> gv(Type type, Annotation[] annotationArr, co coVar) {
            return null;
        }

        public a<?, String> v(Type type, Annotation[] annotationArr, co coVar) {
            return null;
        }

        public a<?, fh> zn(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, co coVar) {
            return null;
        }
    }

    T convert(F f4) throws IOException;
}
