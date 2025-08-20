package kotlinx.coroutines;

import java.util.concurrent.Executor;
/* compiled from: Executors.kt */
/* loaded from: classes2.dex */
public abstract class ExecutorsKt {
    public static final CoroutineDispatcher from(Executor executor) {
        return new ExecutorCoroutineDispatcherImpl(executor);
    }
}
