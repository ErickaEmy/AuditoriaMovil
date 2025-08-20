package e1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import w0.xc;
/* loaded from: classes.dex */
public abstract class zn<T> {
    public final Type y() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        xc.i9(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }
}
