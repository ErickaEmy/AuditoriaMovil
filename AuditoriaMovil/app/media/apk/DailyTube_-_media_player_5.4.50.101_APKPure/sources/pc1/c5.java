package pc1;

import java.util.LinkedHashSet;
import java.util.Set;
import kc1.ta;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class c5 {
    public final Set<ta> y = new LinkedHashSet();

    public final synchronized void n3(ta failedRoute) {
        Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
        this.y.add(failedRoute);
    }

    public final synchronized void y(ta route) {
        Intrinsics.checkNotNullParameter(route, "route");
        this.y.remove(route);
    }

    public final synchronized boolean zn(ta route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.y.contains(route);
    }
}
