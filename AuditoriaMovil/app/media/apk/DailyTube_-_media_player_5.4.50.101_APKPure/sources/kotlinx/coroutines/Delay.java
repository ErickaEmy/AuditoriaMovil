package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
/* loaded from: classes.dex */
public interface Delay {

    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static DisposableHandle invokeOnTimeout(Delay delay, long j2, Runnable runnable, CoroutineContext coroutineContext) {
            return DefaultExecutorKt.getDefaultDelay().invokeOnTimeout(j2, runnable, coroutineContext);
        }
    }

    DisposableHandle invokeOnTimeout(long j2, Runnable runnable, CoroutineContext coroutineContext);

    /* renamed from: scheduleResumeAfterDelay */
    void mo110scheduleResumeAfterDelay(long j2, CancellableContinuation<? super Unit> cancellableContinuation);
}
