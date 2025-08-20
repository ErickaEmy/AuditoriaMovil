package ie1;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class i9 {

    /* renamed from: n3  reason: collision with root package name */
    public final List<?> f9208n3;
    public final Method y;

    public i9(Method method, List<?> list) {
        this.y = method;
        this.f9208n3 = Collections.unmodifiableList(list);
    }

    public String toString() {
        return String.format("%s.%s() %s", this.y.getDeclaringClass().getName(), this.y.getName(), this.f9208n3);
    }

    public Method y() {
        return this.y;
    }
}
