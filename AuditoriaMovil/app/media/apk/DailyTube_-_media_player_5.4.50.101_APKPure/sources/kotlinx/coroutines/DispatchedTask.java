package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;
/* loaded from: classes.dex */
public abstract class DispatchedTask<T> extends Task {
    public int resumeMode;

    public DispatchedTask(int i) {
        this.resumeMode = i;
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th) {
    }

    public abstract Continuation<T> getDelegate$kotlinx_coroutines_core();

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        CompletedExceptionally completedExceptionally;
        if (obj instanceof CompletedExceptionally) {
            completedExceptionally = (CompletedExceptionally) obj;
        } else {
            completedExceptionally = null;
        }
        if (completedExceptionally == null) {
            return null;
        }
        return completedExceptionally.cause;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj;
    }

    public final void handleFatalException(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            kotlin.ExceptionsKt.addSuppressed(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        Intrinsics.checkNotNull(th);
        CoroutineExceptionHandlerKt.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object m28constructorimpl;
        UndispatchedCoroutine<?> undispatchedCoroutine;
        Job job;
        Object m28constructorimpl2;
        if (DebugKt.getASSERTIONS_ENABLED() && this.resumeMode == -1) {
            throw new AssertionError();
        }
        TaskContext taskContext = this.taskContext;
        try {
            Continuation<T> delegate$kotlinx_coroutines_core = getDelegate$kotlinx_coroutines_core();
            Intrinsics.checkNotNull(delegate$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) delegate$kotlinx_coroutines_core;
            Continuation<T> continuation = dispatchedContinuation.continuation;
            Object obj = dispatchedContinuation.countOrElement;
            CoroutineContext context = continuation.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, obj);
            if (updateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS) {
                undispatchedCoroutine = CoroutineContextKt.updateUndispatchedCompletion(continuation, context, updateThreadContext);
            } else {
                undispatchedCoroutine = null;
            }
            CoroutineContext context2 = continuation.getContext();
            Object takeState$kotlinx_coroutines_core = takeState$kotlinx_coroutines_core();
            Throwable exceptionalResult$kotlinx_coroutines_core = getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
            if (exceptionalResult$kotlinx_coroutines_core == null && DispatchedTaskKt.isCancellableMode(this.resumeMode)) {
                job = (Job) context2.get(Job.Key);
            } else {
                job = null;
            }
            if (job != null && !job.isActive()) {
                Throwable cancellationException = job.getCancellationException();
                cancelCompletedResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core, cancellationException);
                Result.Companion companion = Result.Companion;
                if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
                    cancellationException = StackTraceRecoveryKt.recoverFromStackFrame(cancellationException, (CoroutineStackFrame) continuation);
                }
                continuation.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(cancellationException)));
            } else if (exceptionalResult$kotlinx_coroutines_core != null) {
                Result.Companion companion2 = Result.Companion;
                continuation.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(exceptionalResult$kotlinx_coroutines_core)));
            } else {
                Result.Companion companion3 = Result.Companion;
                continuation.resumeWith(Result.m28constructorimpl(getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core)));
            }
            Unit unit = Unit.INSTANCE;
            if (undispatchedCoroutine == null || undispatchedCoroutine.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
            try {
                taskContext.afterTask();
                m28constructorimpl2 = Result.m28constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion4 = Result.Companion;
                m28constructorimpl2 = Result.m28constructorimpl(ResultKt.createFailure(th));
            }
            handleFatalException(null, Result.m30exceptionOrNullimpl(m28constructorimpl2));
        } catch (Throwable th2) {
            try {
                Result.Companion companion5 = Result.Companion;
                taskContext.afterTask();
                m28constructorimpl = Result.m28constructorimpl(Unit.INSTANCE);
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.Companion;
                m28constructorimpl = Result.m28constructorimpl(ResultKt.createFailure(th3));
            }
            handleFatalException(th2, Result.m30exceptionOrNullimpl(m28constructorimpl));
        }
    }

    public abstract Object takeState$kotlinx_coroutines_core();
}
