package td1;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
/* loaded from: classes.dex */
public final class n3 {
    public static final String y(KClass<?> clazz, zd1.y yVar, zd1.y scopeQualifier) {
        String value;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        String str = "";
        if (yVar != null && (value = yVar.getValue()) != null) {
            str = value;
        }
        return ee1.y.y(clazz) + ':' + str + ':' + scopeQualifier;
    }
}
