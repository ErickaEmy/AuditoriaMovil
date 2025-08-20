package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ConcurrentKt;
/* loaded from: classes.dex */
public final class ExecutorCoroutineDispatcherImpl extends ExecutorCoroutineDispatcher implements Delay {
    private final Executor executor;

    public ExecutorCoroutineDispatcherImpl(Executor executor) {
        this.executor = executor;
        ConcurrentKt.removeFutureOnCancel(getExecutor());
    }

    private final void cancelJobOnRejection(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        JobKt.cancel(coroutineContext, ExceptionsKt.CancellationException("The task was rejected", rejectedExecutionException));
    }

    private final ScheduledFuture<?> scheduleBlock(ScheduledExecutorService scheduledExecutorService, Runnable runnable, CoroutineContext coroutineContext, long j2) {
        try {
            return scheduledExecutorService.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            cancelJobOnRejection(coroutineContext, e2);
            return null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ExecutorService executorService;
        Executor executor = getExecutor();
        if (executor instanceof ExecutorService) {
            executorService = (ExecutorService) executor;
        } else {
            executorService = null;
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public void mo109dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            Executor executor = getExecutor();
            AbstractTimeSourceKt.getTimeSource();
            executor.execute(runnable);
        } catch (RejectedExecutionException e2) {
            AbstractTimeSourceKt.getTimeSource();
            cancelJobOnRejection(coroutineContext, e2);
            Dispatchers.getIO().mo109dispatch(coroutineContext, runnable);
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ExecutorCoroutineDispatcherImpl) && ((ExecutorCoroutineDispatcherImpl) obj).getExecutor() == getExecutor()) {
            return true;
        }
        return false;
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public int hashCode() {
        return System.identityHashCode(getExecutor());
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle invokeOnTimeout(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        ScheduledExecutorService scheduledExecutorService;
        Executor executor = getExecutor();
        ScheduledFuture<?> scheduledFuture = null;
        if (executor instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) executor;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            scheduledFuture = scheduleBlock(scheduledExecutorService, runnable, coroutineContext, j2);
        }
        if (scheduledFuture != null) {
            return new DisposableFutureHandle(scheduledFuture);
        }
        return DefaultExecutor.INSTANCE.invokeOnTimeout(j2, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.Delay
    /* renamed from: scheduleResumeAfterDelay */
    public void mo110scheduleResumeAfterDelay(long j2, CancellableContinuation<? super Unit> cancellableContinuation) {
        ScheduledExecutorService scheduledExecutorService;
        Executor executor = getExecutor();
        ScheduledFuture<?> scheduledFuture = null;
        if (executor instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) executor;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            scheduledFuture = scheduleBlock(scheduledExecutorService, new ResumeUndispatchedRunnable(this, cancellableContinuation), cancellableContinuation.getContext(), j2);
        }
        if (scheduledFuture != null) {
            JobKt.cancelFutureOnCancellation(cancellableContinuation, scheduledFuture);
        } else {
            DefaultExecutor.INSTANCE.mo110scheduleResumeAfterDelay(j2, cancellableContinuation);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return getExecutor().toString();
    }
}
