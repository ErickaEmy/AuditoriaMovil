package kotlinx.coroutines;

import kotlinx.coroutines.internal.MainDispatchersKt;
import kotlinx.coroutines.internal.SystemPropsKt;
/* loaded from: classes.dex */
public final class DefaultExecutorKt {
    private static final boolean defaultMainDelayOptIn = SystemPropsKt.systemProp("kotlinx.coroutines.main.delay", false);
    private static final Delay DefaultDelay = initializeDefaultDelay();

    public static final Delay getDefaultDelay() {
        return DefaultDelay;
    }

    private static final Delay initializeDefaultDelay() {
        if (!defaultMainDelayOptIn) {
            return DefaultExecutor.INSTANCE;
        }
        MainCoroutineDispatcher main = Dispatchers.getMain();
        if (!MainDispatchersKt.isMissing(main) && (main instanceof Delay)) {
            return (Delay) main;
        }
        return DefaultExecutor.INSTANCE;
    }
}
