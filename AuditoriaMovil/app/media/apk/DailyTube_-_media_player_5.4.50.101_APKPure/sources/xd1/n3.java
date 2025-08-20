package xd1;

import kotlin.jvm.internal.Intrinsics;
import vd1.zn;
/* loaded from: classes.dex */
public final class n3 {
    public static final void y(zn<?> factory, String mapping) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        throw new ud1.n3("Already existing definition for " + factory.zn() + " at " + mapping);
    }
}
