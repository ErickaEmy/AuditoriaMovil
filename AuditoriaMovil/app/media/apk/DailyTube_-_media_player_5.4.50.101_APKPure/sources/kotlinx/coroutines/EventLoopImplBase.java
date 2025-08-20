package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import r.n3;
/* loaded from: classes.dex */
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {
    private volatile Object _delayed;
    private volatile int _isCompleted;
    private volatile Object _queue;
    private static final AtomicReferenceFieldUpdater _queue$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue");
    private static final AtomicReferenceFieldUpdater _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed");
    private static final AtomicIntegerFieldUpdater _isCompleted$FU = AtomicIntegerFieldUpdater.newUpdater(EventLoopImplBase.class, "_isCompleted");

    /* loaded from: classes.dex */
    public final class DelayedResumeTask extends DelayedTask {
        private final CancellableContinuation<Unit> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public DelayedResumeTask(long j2, CancellableContinuation<? super Unit> cancellableContinuation) {
            super(j2);
            this.cont = cancellableContinuation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.cont.resumeUndispatched(EventLoopImplBase.this, Unit.INSTANCE);
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public String toString() {
            return super.toString() + this.cont;
        }
    }

    /* loaded from: classes.dex */
    public static final class DelayedRunnableTask extends DelayedTask {
        private final Runnable block;

        public DelayedRunnableTask(long j2, Runnable runnable) {
            super(j2);
            this.block = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.block.run();
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public String toString() {
            return super.toString() + this.block;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        private volatile Object _heap;
        private int index = -1;
        public long nanoTime;

        public DelayedTask(long j2) {
            this.nanoTime = j2;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            Symbol symbol;
            DelayedTaskQueue delayedTaskQueue;
            Symbol symbol2;
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    symbol = EventLoop_commonKt.DISPOSED_TASK;
                    if (obj == symbol) {
                        return;
                    }
                    if (obj instanceof DelayedTaskQueue) {
                        delayedTaskQueue = (DelayedTaskQueue) obj;
                    } else {
                        delayedTaskQueue = null;
                    }
                    if (delayedTaskQueue != null) {
                        delayedTaskQueue.remove(this);
                    }
                    symbol2 = EventLoop_commonKt.DISPOSED_TASK;
                    this._heap = symbol2;
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public ThreadSafeHeap<?> getHeap() {
            Object obj = this._heap;
            if (obj instanceof ThreadSafeHeap) {
                return (ThreadSafeHeap) obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public int getIndex() {
            return this.index;
        }

        public final int scheduleTask(long j2, DelayedTaskQueue delayedTaskQueue, EventLoopImplBase eventLoopImplBase) {
            Symbol symbol;
            synchronized (this) {
                Object obj = this._heap;
                symbol = EventLoop_commonKt.DISPOSED_TASK;
                if (obj == symbol) {
                    return 2;
                }
                synchronized (delayedTaskQueue) {
                    DelayedTask firstImpl = delayedTaskQueue.firstImpl();
                    if (eventLoopImplBase.isCompleted()) {
                        return 1;
                    }
                    if (firstImpl == null) {
                        delayedTaskQueue.timeNow = j2;
                    } else {
                        long j4 = firstImpl.nanoTime;
                        if (j4 - j2 < 0) {
                            j2 = j4;
                        }
                        if (j2 - delayedTaskQueue.timeNow > 0) {
                            delayedTaskQueue.timeNow = j2;
                        }
                    }
                    long j6 = this.nanoTime;
                    long j7 = delayedTaskQueue.timeNow;
                    if (j6 - j7 < 0) {
                        this.nanoTime = j7;
                    }
                    delayedTaskQueue.addImpl(this);
                    return 0;
                }
            }
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setHeap(ThreadSafeHeap<?> threadSafeHeap) {
            Symbol symbol;
            Object obj = this._heap;
            symbol = EventLoop_commonKt.DISPOSED_TASK;
            if (obj != symbol) {
                this._heap = threadSafeHeap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.");
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setIndex(int i) {
            this.index = i;
        }

        public final boolean timeToExecute(long j2) {
            if (j2 - this.nanoTime >= 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }

        @Override // java.lang.Comparable
        public int compareTo(DelayedTask delayedTask) {
            int i = ((this.nanoTime - delayedTask.nanoTime) > 0L ? 1 : ((this.nanoTime - delayedTask.nanoTime) == 0L ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            return i < 0 ? -1 : 0;
        }
    }

    /* loaded from: classes.dex */
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {
        public long timeNow;

        public DelayedTaskQueue(long j2) {
            this.timeNow = j2;
        }
    }

    private final void closeQueue() {
        Symbol symbol;
        Symbol symbol2;
        if (DebugKt.getASSERTIONS_ENABLED() && !isCompleted()) {
            throw new AssertionError();
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _queue$FU;
                symbol = EventLoop_commonKt.CLOSED_EMPTY;
                if (n3.y(atomicReferenceFieldUpdater2, this, null, symbol)) {
                    return;
                }
            } else if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol2 = EventLoop_commonKt.CLOSED_EMPTY;
                if (obj == symbol2) {
                    return;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                lockFreeTaskQueueCore.addLast((Runnable) obj);
                if (n3.y(_queue$FU, this, obj, lockFreeTaskQueueCore)) {
                    return;
                }
            } else {
                ((LockFreeTaskQueueCore) obj).close();
                return;
            }
        }
    }

    private final Runnable dequeue() {
        Symbol symbol;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = EventLoop_commonKt.CLOSED_EMPTY;
                if (obj == symbol) {
                    return null;
                }
                if (n3.y(_queue$FU, this, obj, null)) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            } else {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                Object removeFirstOrNull = lockFreeTaskQueueCore.removeFirstOrNull();
                if (removeFirstOrNull != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                    return (Runnable) removeFirstOrNull;
                }
                n3.y(_queue$FU, this, obj, lockFreeTaskQueueCore.next());
            }
        }
    }

    private final boolean enqueueImpl(Runnable runnable) {
        Symbol symbol;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (n3.y(_queue$FU, this, null, runnable)) {
                    return true;
                }
            } else if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = EventLoop_commonKt.CLOSED_EMPTY;
                if (obj == symbol) {
                    return false;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                lockFreeTaskQueueCore.addLast((Runnable) obj);
                lockFreeTaskQueueCore.addLast(runnable);
                if (n3.y(_queue$FU, this, obj, lockFreeTaskQueueCore)) {
                    return true;
                }
            } else {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = (LockFreeTaskQueueCore) obj;
                int addLast = lockFreeTaskQueueCore2.addLast(runnable);
                if (addLast == 0) {
                    return true;
                }
                if (addLast != 1) {
                    if (addLast == 2) {
                        return false;
                    }
                } else {
                    n3.y(_queue$FU, this, obj, lockFreeTaskQueueCore2.next());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCompleted() {
        if (_isCompleted$FU.get(this) != 0) {
            return true;
        }
        return false;
    }

    private final void rescheduleAllDelayed() {
        DelayedTask removeFirstOrNull;
        AbstractTimeSourceKt.getTimeSource();
        long nanoTime = System.nanoTime();
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) _delayed$FU.get(this);
            if (delayedTaskQueue != null && (removeFirstOrNull = delayedTaskQueue.removeFirstOrNull()) != null) {
                reschedule(nanoTime, removeFirstOrNull);
            } else {
                return;
            }
        }
    }

    private final int scheduleImpl(long j2, DelayedTask delayedTask) {
        if (isCompleted()) {
            return 1;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _delayed$FU;
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) atomicReferenceFieldUpdater.get(this);
        if (delayedTaskQueue == null) {
            n3.y(atomicReferenceFieldUpdater, this, null, new DelayedTaskQueue(j2));
            Object obj = atomicReferenceFieldUpdater.get(this);
            Intrinsics.checkNotNull(obj);
            delayedTaskQueue = (DelayedTaskQueue) obj;
        }
        return delayedTask.scheduleTask(j2, delayedTaskQueue, this);
    }

    private final void setCompleted(boolean z2) {
        _isCompleted$FU.set(this, z2 ? 1 : 0);
    }

    private final boolean shouldUnpark(DelayedTask delayedTask) {
        DelayedTask delayedTask2;
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) _delayed$FU.get(this);
        if (delayedTaskQueue != null) {
            delayedTask2 = delayedTaskQueue.peek();
        } else {
            delayedTask2 = null;
        }
        if (delayedTask2 == delayedTask) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public final void mo109dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        enqueue(runnable);
    }

    public void enqueue(Runnable runnable) {
        if (enqueueImpl(runnable)) {
            unpark();
        } else {
            DefaultExecutor.INSTANCE.enqueue(runnable);
        }
    }

    @Override // kotlinx.coroutines.EventLoop
    public long getNextTime() {
        DelayedTask peek;
        Symbol symbol;
        if (super.getNextTime() == 0) {
            return 0L;
        }
        Object obj = _queue$FU.get(this);
        if (obj != null) {
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = EventLoop_commonKt.CLOSED_EMPTY;
                if (obj != symbol) {
                    return 0L;
                }
                return Long.MAX_VALUE;
            } else if (!((LockFreeTaskQueueCore) obj).isEmpty()) {
                return 0L;
            }
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) _delayed$FU.get(this);
        if (delayedTaskQueue == null || (peek = delayedTaskQueue.peek()) == null) {
            return Long.MAX_VALUE;
        }
        long j2 = peek.nanoTime;
        AbstractTimeSourceKt.getTimeSource();
        return RangesKt.coerceAtLeast(j2 - System.nanoTime(), 0L);
    }

    public DisposableHandle invokeOnTimeout(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.invokeOnTimeout(this, j2, runnable, coroutineContext);
    }

    public boolean isEmpty() {
        Symbol symbol;
        if (!isUnconfinedQueueEmpty()) {
            return false;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) _delayed$FU.get(this);
        if (delayedTaskQueue != null && !delayedTaskQueue.isEmpty()) {
            return false;
        }
        Object obj = _queue$FU.get(this);
        if (obj != null) {
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = EventLoop_commonKt.CLOSED_EMPTY;
                if (obj != symbol) {
                    return false;
                }
            } else {
                return ((LockFreeTaskQueueCore) obj).isEmpty();
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0053  */
    @Override // kotlinx.coroutines.EventLoop
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long processNextEvent() {
        /*
            r9 = this;
            boolean r0 = r9.processUnconfinedEvent()
            r1 = 0
            if (r0 == 0) goto L9
            return r1
        L9:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.EventLoopImplBase._delayed$FU
            java.lang.Object r0 = r0.get(r9)
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r0
            if (r0 == 0) goto L49
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L49
            kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource()
            long r3 = java.lang.System.nanoTime()
        L20:
            monitor-enter(r0)
            kotlinx.coroutines.internal.ThreadSafeHeapNode r5 = r0.firstImpl()     // Catch: java.lang.Throwable -> L38
            r6 = 0
            if (r5 != 0) goto L2a
            monitor-exit(r0)
            goto L42
        L2a:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r5 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r5     // Catch: java.lang.Throwable -> L38
            boolean r7 = r5.timeToExecute(r3)     // Catch: java.lang.Throwable -> L38
            r8 = 0
            if (r7 == 0) goto L3a
            boolean r5 = r9.enqueueImpl(r5)     // Catch: java.lang.Throwable -> L38
            goto L3b
        L38:
            r1 = move-exception
            goto L47
        L3a:
            r5 = 0
        L3b:
            if (r5 == 0) goto L41
            kotlinx.coroutines.internal.ThreadSafeHeapNode r6 = r0.removeAtImpl(r8)     // Catch: java.lang.Throwable -> L38
        L41:
            monitor-exit(r0)
        L42:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r6 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r6
            if (r6 != 0) goto L20
            goto L49
        L47:
            monitor-exit(r0)
            throw r1
        L49:
            java.lang.Runnable r0 = r9.dequeue()
            if (r0 == 0) goto L53
            r0.run()
            return r1
        L53:
            long r0 = r9.getNextTime()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.processNextEvent():long");
    }

    public final void resetAll() {
        _queue$FU.set(this, null);
        _delayed$FU.set(this, null);
    }

    public final void schedule(long j2, DelayedTask delayedTask) {
        int scheduleImpl = scheduleImpl(j2, delayedTask);
        if (scheduleImpl != 0) {
            if (scheduleImpl != 1) {
                if (scheduleImpl != 2) {
                    throw new IllegalStateException("unexpected result");
                }
                return;
            }
            reschedule(j2, delayedTask);
        } else if (shouldUnpark(delayedTask)) {
            unpark();
        }
    }

    public final DisposableHandle scheduleInvokeOnTimeout(long j2, Runnable runnable) {
        long delayToNanos = EventLoop_commonKt.delayToNanos(j2);
        if (delayToNanos < 4611686018427387903L) {
            AbstractTimeSourceKt.getTimeSource();
            long nanoTime = System.nanoTime();
            DelayedRunnableTask delayedRunnableTask = new DelayedRunnableTask(delayToNanos + nanoTime, runnable);
            schedule(nanoTime, delayedRunnableTask);
            return delayedRunnableTask;
        }
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.Delay
    /* renamed from: scheduleResumeAfterDelay */
    public void mo110scheduleResumeAfterDelay(long j2, CancellableContinuation<? super Unit> cancellableContinuation) {
        long delayToNanos = EventLoop_commonKt.delayToNanos(j2);
        if (delayToNanos < 4611686018427387903L) {
            AbstractTimeSourceKt.getTimeSource();
            long nanoTime = System.nanoTime();
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(delayToNanos + nanoTime, cancellableContinuation);
            schedule(nanoTime, delayedResumeTask);
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuation, delayedResumeTask);
        }
    }

    @Override // kotlinx.coroutines.EventLoop
    public void shutdown() {
        ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        setCompleted(true);
        closeQueue();
        do {
        } while (processNextEvent() <= 0);
        rescheduleAllDelayed();
    }
}
