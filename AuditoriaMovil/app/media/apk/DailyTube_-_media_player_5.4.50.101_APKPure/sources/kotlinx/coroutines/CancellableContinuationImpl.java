package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import r.n3;
/* loaded from: classes.dex */
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame, Waiter {
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;
    private final CoroutineContext context;
    private final Continuation<T> delegate;
    private static final AtomicIntegerFieldUpdater _decisionAndIndex$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decisionAndIndex");
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
    private static final AtomicReferenceFieldUpdater _parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_parentHandle");

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(Continuation<? super T> continuation, int i) {
        super(i);
        this.delegate = continuation;
        if (DebugKt.getASSERTIONS_ENABLED() && i == -1) {
            throw new AssertionError();
        }
        this.context = continuation.getContext();
        this._decisionAndIndex = 536870911;
        this._state = Active.INSTANCE;
    }

    private final Void alreadyResumedError(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void callSegmentOnCancellation(Segment<?> segment, Throwable th) {
        int i = _decisionAndIndex$FU.get(this) & 536870911;
        if (i != 536870911) {
            try {
                segment.onCancellation(i, th, getContext());
                return;
            } catch (Throwable th2) {
                CoroutineContext context = getContext();
                CoroutineExceptionHandlerKt.handleCoroutineException(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
                return;
            }
        }
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
    }

    private final boolean cancelLater(Throwable th) {
        if (!isReusable()) {
            return false;
        }
        Continuation<T> continuation = this.delegate;
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((DispatchedContinuation) continuation).postponeCancellation(th);
    }

    private final void detachChildIfNonResuable() {
        if (!isReusable()) {
            detachChild$kotlinx_coroutines_core();
        }
    }

    private final void dispatchResume(int i) {
        if (tryResume()) {
            return;
        }
        DispatchedTaskKt.dispatch(this, i);
    }

    private final DisposableHandle getParentHandle() {
        return (DisposableHandle) _parentHandle$FU.get(this);
    }

    private final String getStateDebugRepresentation() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof NotCompleted) {
            return "Active";
        }
        if (state$kotlinx_coroutines_core instanceof CancelledContinuation) {
            return "Cancelled";
        }
        return "Completed";
    }

    private final DisposableHandle installParentHandle() {
        Job job = (Job) getContext().get(Job.Key);
        if (job == null) {
            return null;
        }
        DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new ChildContinuation(this), 2, null);
        n3.y(_parentHandle$FU, this, null, invokeOnCompletion$default);
        return invokeOnCompletion$default;
    }

    private final void invokeOnCancellationImpl(Object obj) {
        boolean z2;
        if (DebugKt.getASSERTIONS_ENABLED() && !(obj instanceof CancelHandler) && !(obj instanceof Segment)) {
            throw new AssertionError();
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof Active) {
                if (n3.y(_state$FU, this, obj2, obj)) {
                    return;
                }
            } else {
                if (obj2 instanceof CancelHandler) {
                    z2 = true;
                } else {
                    z2 = obj2 instanceof Segment;
                }
                if (z2) {
                    multipleHandlersError(obj, obj2);
                } else if (obj2 instanceof CompletedExceptionally) {
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj2;
                    if (!completedExceptionally.makeHandled()) {
                        multipleHandlersError(obj, obj2);
                    }
                    if (obj2 instanceof CancelledContinuation) {
                        Throwable th = null;
                        if (!(obj2 instanceof CompletedExceptionally)) {
                            completedExceptionally = null;
                        }
                        if (completedExceptionally != null) {
                            th = completedExceptionally.cause;
                        }
                        if (obj instanceof CancelHandler) {
                            callCancelHandler((CancelHandler) obj, th);
                            return;
                        }
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                        callSegmentOnCancellation((Segment) obj, th);
                        return;
                    }
                    return;
                } else if (obj2 instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj2;
                    if (completedContinuation.cancelHandler != null) {
                        multipleHandlersError(obj, obj2);
                    }
                    if (obj instanceof Segment) {
                        return;
                    }
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    CancelHandler cancelHandler = (CancelHandler) obj;
                    if (completedContinuation.getCancelled()) {
                        callCancelHandler(cancelHandler, completedContinuation.cancelCause);
                        return;
                    }
                    if (n3.y(_state$FU, this, obj2, CompletedContinuation.copy$default(completedContinuation, null, cancelHandler, null, null, null, 29, null))) {
                        return;
                    }
                } else if (obj instanceof Segment) {
                    return;
                } else {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    if (n3.y(_state$FU, this, obj2, new CompletedContinuation(obj2, (CancelHandler) obj, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    private final boolean isReusable() {
        if (DispatchedTaskKt.isReusableMode(this.resumeMode)) {
            Continuation<T> continuation = this.delegate;
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((DispatchedContinuation) continuation).isReusable()) {
                return true;
            }
        }
        return false;
    }

    private final CancelHandler makeCancelHandler(Function1<? super Throwable, Unit> function1) {
        if (function1 instanceof CancelHandler) {
            return (CancelHandler) function1;
        }
        return new InvokeOnCancel(function1);
    }

    private final void multipleHandlersError(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    private final void resumeImpl(Object obj, int i, Function1<? super Throwable, Unit> function1) {
        Object obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        do {
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof NotCompleted) {
            } else {
                if (obj2 instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                    if (cancelledContinuation.makeResumed()) {
                        if (function1 != null) {
                            callOnCancellation(function1, cancelledContinuation.cause);
                            return;
                        }
                        return;
                    }
                }
                alreadyResumedError(obj);
                throw new KotlinNothingValueException();
            }
        } while (!n3.y(_state$FU, this, obj2, resumedState((NotCompleted) obj2, obj, i, function1, null)));
        detachChildIfNonResuable();
        dispatchResume(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void resumeImpl$default(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i, Function1 function1, int i5, Object obj2) {
        if (obj2 == null) {
            if ((i5 & 4) != 0) {
                function1 = null;
            }
            cancellableContinuationImpl.resumeImpl(obj, i, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Object resumedState(NotCompleted notCompleted, Object obj, int i, Function1<? super Throwable, Unit> function1, Object obj2) {
        CancelHandler cancelHandler;
        if (obj instanceof CompletedExceptionally) {
            if (DebugKt.getASSERTIONS_ENABLED() && obj2 != null) {
                throw new AssertionError();
            }
            if (DebugKt.getASSERTIONS_ENABLED() && function1 != null) {
                throw new AssertionError();
            }
            return obj;
        } else if (DispatchedTaskKt.isCancellableMode(i) || obj2 != null) {
            if (function1 != null || (notCompleted instanceof CancelHandler) || obj2 != null) {
                if (notCompleted instanceof CancelHandler) {
                    cancelHandler = (CancelHandler) notCompleted;
                } else {
                    cancelHandler = null;
                }
                return new CompletedContinuation(obj, cancelHandler, function1, obj2, null, 16, null);
            }
            return obj;
        } else {
            return obj;
        }
    }

    private final boolean tryResume() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decisionAndIndex$FU;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            int i5 = i >> 29;
            if (i5 != 0) {
                if (i5 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!_decisionAndIndex$FU.compareAndSet(this, i, 1073741824 + (536870911 & i)));
        return true;
    }

    private final Symbol tryResumeImpl(Object obj, Object obj2, Function1<? super Throwable, Unit> function1) {
        Object obj3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        do {
            obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof NotCompleted) {
            } else if (!(obj3 instanceof CompletedContinuation) || obj2 == null) {
                return null;
            } else {
                CompletedContinuation completedContinuation = (CompletedContinuation) obj3;
                if (completedContinuation.idempotentResume != obj2) {
                    return null;
                }
                if (DebugKt.getASSERTIONS_ENABLED() && !Intrinsics.areEqual(completedContinuation.result, obj)) {
                    throw new AssertionError();
                }
                return CancellableContinuationImplKt.RESUME_TOKEN;
            }
        } while (!n3.y(_state$FU, this, obj3, resumedState((NotCompleted) obj3, obj, this.resumeMode, function1, obj2)));
        detachChildIfNonResuable();
        return CancellableContinuationImplKt.RESUME_TOKEN;
    }

    private final boolean trySuspend() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decisionAndIndex$FU;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            int i5 = i >> 29;
            if (i5 != 0) {
                if (i5 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!_decisionAndIndex$FU.compareAndSet(this, i, 536870912 + (536870911 & i)));
        return true;
    }

    public final void callCancelHandler(CancelHandler cancelHandler, Throwable th) {
        try {
            cancelHandler.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            CoroutineExceptionHandlerKt.handleCoroutineException(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void callOnCancellation(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            CoroutineExceptionHandlerKt.handleCoroutineException(context, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public boolean cancel(Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            boolean z2 = false;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
        } while (!n3.y(_state$FU, this, obj, new CancelledContinuation(this, th, ((obj instanceof CancelHandler) || (obj instanceof Segment)) ? true : true)));
        NotCompleted notCompleted = (NotCompleted) obj;
        if (notCompleted instanceof CancelHandler) {
            callCancelHandler((CancelHandler) obj, th);
        } else if (notCompleted instanceof Segment) {
            callSegmentOnCancellation((Segment) obj, th);
        }
        detachChildIfNonResuable();
        dispatchResume(this.resumeMode);
        return true;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof NotCompleted)) {
                if (obj2 instanceof CompletedExceptionally) {
                    return;
                }
                if (obj2 instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj2;
                    if (!completedContinuation.getCancelled()) {
                        if (n3.y(_state$FU, this, obj2, CompletedContinuation.copy$default(completedContinuation, null, null, null, null, th, 15, null))) {
                            completedContinuation.invokeHandlers(this, th);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once");
                    }
                } else if (n3.y(_state$FU, this, obj2, new CompletedContinuation(obj2, null, null, null, th, 14, null))) {
                    return;
                }
            } else {
                throw new IllegalStateException("Not completed");
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void completeResume(Object obj) {
        if (DebugKt.getASSERTIONS_ENABLED() && obj != CancellableContinuationImplKt.RESUME_TOKEN) {
            throw new AssertionError();
        }
        dispatchResume(this.resumeMode);
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle parentHandle = getParentHandle();
        if (parentHandle == null) {
            return;
        }
        parentHandle.dispose();
        _parentHandle$FU.set(this, NonDisposableHandle.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.context;
    }

    public Throwable getContinuationCancellationCause(Job job) {
        return job.getCancellationException();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        Throwable recoverFromStackFrame;
        Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(obj);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            Continuation<T> continuation = this.delegate;
            if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
                recoverFromStackFrame = StackTraceRecoveryKt.recoverFromStackFrame(exceptionalResult$kotlinx_coroutines_core, (CoroutineStackFrame) continuation);
                return recoverFromStackFrame;
            }
            return exceptionalResult$kotlinx_coroutines_core;
        }
        return null;
    }

    public final Object getResult() {
        Job job;
        Throwable recoverFromStackFrame;
        Throwable recoverFromStackFrame2;
        boolean isReusable = isReusable();
        if (trySuspend()) {
            if (getParentHandle() == null) {
                installParentHandle();
            }
            if (isReusable) {
                releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            }
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (isReusable) {
            releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        }
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            Throwable th = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                recoverFromStackFrame2 = StackTraceRecoveryKt.recoverFromStackFrame(th, this);
                throw recoverFromStackFrame2;
            }
            throw th;
        } else if (DispatchedTaskKt.isCancellableMode(this.resumeMode) && (job = (Job) getContext().get(Job.Key)) != null && !job.isActive()) {
            CancellationException cancellationException = job.getCancellationException();
            cancelCompletedResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core, cancellationException);
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                recoverFromStackFrame = StackTraceRecoveryKt.recoverFromStackFrame(cancellationException, this);
                throw recoverFromStackFrame;
            }
            throw cancellationException;
        } else {
            return getSuccessfulResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final Object getState$kotlinx_coroutines_core() {
        return _state$FU.get(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        if (obj instanceof CompletedContinuation) {
            return (T) ((CompletedContinuation) obj).result;
        }
        return obj;
    }

    public void initCancellability() {
        DisposableHandle installParentHandle = installParentHandle();
        if (installParentHandle != null && isCompleted()) {
            installParentHandle.dispose();
            _parentHandle$FU.set(this, NonDisposableHandle.INSTANCE);
        }
    }

    @Override // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(Segment<?> segment, int i) {
        int i5;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decisionAndIndex$FU;
        do {
            i5 = atomicIntegerFieldUpdater.get(this);
            if ((i5 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i5, ((i5 >> 29) << 29) + i));
        invokeOnCancellationImpl(segment);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    public String nameString() {
        return "CancellableContinuation";
    }

    public final void parentCancelled$kotlinx_coroutines_core(Throwable th) {
        if (cancelLater(th)) {
            return;
        }
        cancel(th);
        detachChildIfNonResuable();
    }

    public final void releaseClaimedReusableContinuation$kotlinx_coroutines_core() {
        DispatchedContinuation dispatchedContinuation;
        Throwable tryReleaseClaimedContinuation;
        Continuation<T> continuation = this.delegate;
        if (continuation instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) continuation;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation != null && (tryReleaseClaimedContinuation = dispatchedContinuation.tryReleaseClaimedContinuation(this)) != null) {
            detachChild$kotlinx_coroutines_core();
            cancel(tryReleaseClaimedContinuation);
        }
    }

    public final boolean resetStateReusable() {
        if (DebugKt.getASSERTIONS_ENABLED() && this.resumeMode != 2) {
            throw new AssertionError();
        }
        if (DebugKt.getASSERTIONS_ENABLED() && getParentHandle() == NonDisposableHandle.INSTANCE) {
            throw new AssertionError();
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (DebugKt.getASSERTIONS_ENABLED() && (obj instanceof NotCompleted)) {
            throw new AssertionError();
        }
        if ((obj instanceof CompletedContinuation) && ((CompletedContinuation) obj).idempotentResume != null) {
            detachChild$kotlinx_coroutines_core();
            return false;
        }
        _decisionAndIndex$FU.set(this, 536870911);
        atomicReferenceFieldUpdater.set(this, Active.INSTANCE);
        return true;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resume(T t2, Function1<? super Throwable, Unit> function1) {
        resumeImpl(t2, this.resumeMode, function1);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, T t2) {
        DispatchedContinuation dispatchedContinuation;
        int i;
        Continuation<T> continuation = this.delegate;
        CoroutineDispatcher coroutineDispatcher2 = null;
        if (continuation instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) continuation;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.dispatcher;
        }
        if (coroutineDispatcher2 == coroutineDispatcher) {
            i = 4;
        } else {
            i = this.resumeMode;
        }
        resumeImpl$default(this, t2, i, null, 4, null);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        resumeImpl$default(this, CompletionStateKt.toState(obj, this), this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object takeState$kotlinx_coroutines_core() {
        return getState$kotlinx_coroutines_core();
    }

    public String toString() {
        return nameString() + '(' + DebugStringsKt.toDebugString(this.delegate) + "){" + getStateDebugRepresentation() + "}@" + DebugStringsKt.getHexAddress(this);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResumeWithException(Throwable th) {
        return tryResumeImpl(new CompletedExceptionally(th, false, 2, null), null, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void invokeOnCancellation(Function1<? super Throwable, Unit> function1) {
        invokeOnCancellationImpl(makeCancelHandler(function1));
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResume(T t2, Object obj, Function1<? super Throwable, Unit> function1) {
        return tryResumeImpl(t2, obj, function1);
    }
}
