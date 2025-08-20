package y5;

import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
/* loaded from: classes.dex */
public final class p {
    public static final tl y(androidx.lifecycle.v coroutineScope) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        Intrinsics.checkNotNullParameter(coroutineScope, "$this$coroutineScope");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) coroutineScope.y.get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(coroutineScope, SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        } while (!w.y(coroutineScope.y, null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.v();
        return lifecycleCoroutineScopeImpl;
    }
}
