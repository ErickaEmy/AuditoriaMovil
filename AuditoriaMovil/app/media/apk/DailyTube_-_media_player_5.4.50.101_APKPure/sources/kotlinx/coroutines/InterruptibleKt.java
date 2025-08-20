package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
/* loaded from: classes.dex */
public final class InterruptibleKt {
    public static final <T> Object runInterruptible(CoroutineContext coroutineContext, Function0<? extends T> function0, Continuation<? super T> continuation) {
        return BuildersKt.withContext(coroutineContext, new InterruptibleKt$runInterruptible$2(function0, null), continuation);
    }

    public static /* synthetic */ Object runInterruptible$default(CoroutineContext coroutineContext, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return runInterruptible(coroutineContext, function0, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T runInterruptibleInExpectedContext(CoroutineContext coroutineContext, Function0<? extends T> function0) {
        try {
            ThreadState threadState = new ThreadState(JobKt.getJob(coroutineContext));
            threadState.setup();
            T invoke = function0.invoke();
            threadState.clearInterrupt();
            return invoke;
        } catch (InterruptedException e2) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e2);
        }
    }
}
