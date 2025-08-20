package ee1;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
/* loaded from: classes.dex */
public final class y {
    public static final Map<KClass<?>, String> y = fe1.y.y.gv();

    public static final String n3(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        String n32 = fe1.y.y.n3(kClass);
        y.put(kClass, n32);
        return n32;
    }

    public static final String y(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        String str = y.get(kClass);
        if (str == null) {
            return n3(kClass);
        }
        return str;
    }
}
