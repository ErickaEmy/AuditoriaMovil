package y5;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class z {
    public static final tl y(co lifecycleScope) {
        Intrinsics.checkNotNullParameter(lifecycleScope, "$this$lifecycleScope");
        androidx.lifecycle.v lifecycle = lifecycleScope.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        return p.y(lifecycle);
    }
}
