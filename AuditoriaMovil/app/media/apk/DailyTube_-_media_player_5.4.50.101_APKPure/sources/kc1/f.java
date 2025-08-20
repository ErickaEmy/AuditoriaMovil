package kc1;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class f {
    public final pc1.s y;

    public f(pc1.s delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.y = delegate;
    }

    public final pc1.s y() {
        return this.y;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(int i, long j2, TimeUnit timeUnit) {
        this(new pc1.s(oc1.v.f12249s, i, j2, timeUnit));
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
    }

    public f() {
        this(5, 5L, TimeUnit.MINUTES);
    }
}
