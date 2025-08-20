package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
/* loaded from: classes.dex */
public final class LimitedDispatcher extends CoroutineDispatcher implements Delay {
    private static final AtomicIntegerFieldUpdater runningWorkers$FU = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers");
    private final /* synthetic */ Delay $$delegate_0;
    private final CoroutineDispatcher dispatcher;
    private final int parallelism;
    private final LockFreeTaskQueue<Runnable> queue;
    private volatile int runningWorkers;
    private final Object workerAllocationLock;

    /* loaded from: classes.dex */
    public final class Worker implements Runnable {
        private Runnable currentTask;

        public Worker(Runnable runnable) {
            this.currentTask = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 0;
            while (true) {
                try {
                    this.currentTask.run();
                } catch (Throwable th) {
                    CoroutineExceptionHandlerKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, th);
                }
                Runnable obtainTaskOrDeallocateWorker = LimitedDispatcher.this.obtainTaskOrDeallocateWorker();
                if (obtainTaskOrDeallocateWorker == null) {
                    return;
                }
                this.currentTask = obtainTaskOrDeallocateWorker;
                i++;
                if (i >= 16 && LimitedDispatcher.this.dispatcher.isDispatchNeeded(LimitedDispatcher.this)) {
                    LimitedDispatcher.this.dispatcher.mo109dispatch(LimitedDispatcher.this, this);
                    return;
                }
            }
        }
    }

    public LimitedDispatcher(CoroutineDispatcher coroutineDispatcher, int i) {
        Delay delay;
        this.dispatcher = coroutineDispatcher;
        this.parallelism = i;
        if (coroutineDispatcher instanceof Delay) {
            delay = (Delay) coroutineDispatcher;
        } else {
            delay = null;
        }
        this.$$delegate_0 = delay == null ? DefaultExecutorKt.getDefaultDelay() : delay;
        this.queue = new LockFreeTaskQueue<>(false);
        this.workerAllocationLock = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable obtainTaskOrDeallocateWorker() {
        while (true) {
            Runnable removeFirstOrNull = this.queue.removeFirstOrNull();
            if (removeFirstOrNull == null) {
                synchronized (this.workerAllocationLock) {
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = runningWorkers$FU;
                    atomicIntegerFieldUpdater.decrementAndGet(this);
                    if (this.queue.getSize() == 0) {
                        return null;
                    }
                    atomicIntegerFieldUpdater.incrementAndGet(this);
                }
            } else {
                return removeFirstOrNull;
            }
        }
    }

    private final boolean tryAllocateWorker() {
        synchronized (this.workerAllocationLock) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = runningWorkers$FU;
            if (atomicIntegerFieldUpdater.get(this) >= this.parallelism) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public void mo109dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable obtainTaskOrDeallocateWorker;
        this.queue.addLast(runnable);
        if (runningWorkers$FU.get(this) < this.parallelism && tryAllocateWorker() && (obtainTaskOrDeallocateWorker = obtainTaskOrDeallocateWorker()) != null) {
            this.dispatcher.mo109dispatch(this, new Worker(obtainTaskOrDeallocateWorker));
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable obtainTaskOrDeallocateWorker;
        this.queue.addLast(runnable);
        if (runningWorkers$FU.get(this) < this.parallelism && tryAllocateWorker() && (obtainTaskOrDeallocateWorker = obtainTaskOrDeallocateWorker()) != null) {
            this.dispatcher.dispatchYield(this, new Worker(obtainTaskOrDeallocateWorker));
        }
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle invokeOnTimeout(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        return this.$$delegate_0.invokeOnTimeout(j2, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.Delay
    /* renamed from: scheduleResumeAfterDelay */
    public void mo110scheduleResumeAfterDelay(long j2, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.$$delegate_0.mo110scheduleResumeAfterDelay(j2, cancellableContinuation);
    }
}
