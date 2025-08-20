package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;
/* loaded from: classes.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    private volatile int _isTerminated;
    private volatile long controlState;
    public final int corePoolSize;
    public final GlobalQueue globalBlockingQueue;
    public final GlobalQueue globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    private volatile long parkedWorkersStack;
    public final String schedulerName;
    public final ResizableAtomicArray<Worker> workers;
    public static final Companion Companion = new Companion(null);
    private static final AtomicLongFieldUpdater parkedWorkersStack$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
    private static final AtomicLongFieldUpdater controlState$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
    private static final AtomicIntegerFieldUpdater _isTerminated$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
    public static final Symbol NOT_IN_STACK = new Symbol("NOT_IN_STACK");

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WorkerState.values().length];
            try {
                iArr[WorkerState.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkerState.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkerState.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WorkerState.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* loaded from: classes.dex */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public CoroutineScheduler(int i, int i5, long j2, String str) {
        this.corePoolSize = i;
        this.maxPoolSize = i5;
        this.idleWorkerKeepAliveNs = j2;
        this.schedulerName = str;
        if (i >= 1) {
            if (i5 >= i) {
                if (i5 <= 2097150) {
                    if (j2 > 0) {
                        this.globalCpuQueue = new GlobalQueue();
                        this.globalBlockingQueue = new GlobalQueue();
                        this.workers = new ResizableAtomicArray<>((i + 1) * 2);
                        this.controlState = i << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + i5 + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + i5 + " should be greater than or equals to core pool size " + i).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + i + " should be at least 1").toString());
    }

    private final boolean addToGlobalQueue(Task task) {
        if (task.taskContext.getTaskMode() == 1) {
            return this.globalBlockingQueue.addLast(task);
        }
        return this.globalCpuQueue.addLast(task);
    }

    private final int createNewWorker() {
        synchronized (this.workers) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = controlState$FU;
                long j2 = atomicLongFieldUpdater.get(this);
                int i = (int) (j2 & 2097151);
                int coerceAtLeast = RangesKt.coerceAtLeast(i - ((int) ((j2 & 4398044413952L) >> 21)), 0);
                if (coerceAtLeast >= this.corePoolSize) {
                    return 0;
                }
                if (i >= this.maxPoolSize) {
                    return 0;
                }
                int i5 = ((int) (controlState$FU.get(this) & 2097151)) + 1;
                if (i5 > 0 && this.workers.get(i5) == null) {
                    Worker worker = new Worker(this, i5);
                    this.workers.setSynchronized(i5, worker);
                    if (i5 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                        int i6 = coerceAtLeast + 1;
                        worker.start();
                        return i6;
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalArgumentException("Failed requirement.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final Worker currentWorker() {
        Worker worker;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof Worker) {
            worker = (Worker) currentThread;
        } else {
            worker = null;
        }
        if (worker == null || !Intrinsics.areEqual(CoroutineScheduler.this, this)) {
            return null;
        }
        return worker;
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            taskContext = TasksKt.NonBlockingContext;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        coroutineScheduler.dispatch(runnable, taskContext, z2);
    }

    private final int parkedWorkersStackNextIndex(Worker worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != NOT_IN_STACK) {
            if (nextParkedWorker == null) {
                return 0;
            }
            Worker worker2 = (Worker) nextParkedWorker;
            int indexInArray = worker2.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = worker2.getNextParkedWorker();
        }
        return -1;
    }

    private final Worker parkedWorkersStackPop() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = parkedWorkersStack$FU;
        while (true) {
            long j2 = atomicLongFieldUpdater.get(this);
            Worker worker = this.workers.get((int) (2097151 & j2));
            if (worker == null) {
                return null;
            }
            long j4 = (2097152 + j2) & (-2097152);
            int parkedWorkersStackNextIndex = parkedWorkersStackNextIndex(worker);
            if (parkedWorkersStackNextIndex >= 0 && parkedWorkersStack$FU.compareAndSet(this, j2, parkedWorkersStackNextIndex | j4)) {
                worker.setNextParkedWorker(NOT_IN_STACK);
                return worker;
            }
        }
    }

    private final void signalBlockingWork(long j2, boolean z2) {
        if (z2 || tryUnpark() || tryCreateWorker(j2)) {
            return;
        }
        tryUnpark();
    }

    private final Task submitToLocalQueue(Worker worker, Task task, boolean z2) {
        if (worker == null) {
            return task;
        }
        if (worker.state == WorkerState.TERMINATED) {
            return task;
        }
        if (task.taskContext.getTaskMode() == 0 && worker.state == WorkerState.BLOCKING) {
            return task;
        }
        worker.mayHaveLocalTasks = true;
        return worker.localQueue.add(task, z2);
    }

    private final boolean tryCreateWorker(long j2) {
        if (RangesKt.coerceAtLeast(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0) < this.corePoolSize) {
            int createNewWorker = createNewWorker();
            if (createNewWorker == 1 && this.corePoolSize > 1) {
                createNewWorker();
            }
            if (createNewWorker > 0) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean tryCreateWorker$default(CoroutineScheduler coroutineScheduler, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = controlState$FU.get(coroutineScheduler);
        }
        return coroutineScheduler.tryCreateWorker(j2);
    }

    private final boolean tryUnpark() {
        Worker parkedWorkersStackPop;
        do {
            parkedWorkersStackPop = parkedWorkersStackPop();
            if (parkedWorkersStackPop == null) {
                return false;
            }
        } while (!Worker.workerCtl$FU.compareAndSet(parkedWorkersStackPop, -1, 0));
        LockSupport.unpark(parkedWorkersStackPop);
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        shutdown(10000L);
    }

    public final Task createTask(Runnable runnable, TaskContext taskContext) {
        long nanoTime = TasksKt.schedulerTimeSource.nanoTime();
        if (runnable instanceof Task) {
            Task task = (Task) runnable;
            task.submissionTime = nanoTime;
            task.taskContext = taskContext;
            return task;
        }
        return new TaskImpl(runnable, nanoTime, taskContext);
    }

    public final void dispatch(Runnable runnable, TaskContext taskContext, boolean z2) {
        boolean z3;
        long j2;
        AbstractTimeSourceKt.getTimeSource();
        Task createTask = createTask(runnable, taskContext);
        boolean z4 = false;
        if (createTask.taskContext.getTaskMode() == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            j2 = controlState$FU.addAndGet(this, 2097152L);
        } else {
            j2 = 0;
        }
        Worker currentWorker = currentWorker();
        Task submitToLocalQueue = submitToLocalQueue(currentWorker, createTask, z2);
        if (submitToLocalQueue != null && !addToGlobalQueue(submitToLocalQueue)) {
            throw new RejectedExecutionException(this.schedulerName + " was terminated");
        }
        if (z2 && currentWorker != null) {
            z4 = true;
        }
        if (z3) {
            signalBlockingWork(j2, z4);
        } else if (z4) {
        } else {
            signalCpuWork();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        dispatch$default(this, runnable, null, false, 6, null);
    }

    public final boolean isTerminated() {
        if (_isTerminated$FU.get(this) != 0) {
            return true;
        }
        return false;
    }

    public final boolean parkedWorkersStackPush(Worker worker) {
        long j2;
        long j4;
        int indexInArray;
        if (worker.getNextParkedWorker() != NOT_IN_STACK) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = parkedWorkersStack$FU;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            int i = (int) (2097151 & j2);
            j4 = (2097152 + j2) & (-2097152);
            indexInArray = worker.getIndexInArray();
            if (DebugKt.getASSERTIONS_ENABLED() && indexInArray == 0) {
                throw new AssertionError();
            }
            worker.setNextParkedWorker(this.workers.get(i));
        } while (!parkedWorkersStack$FU.compareAndSet(this, j2, j4 | indexInArray));
        return true;
    }

    public final void parkedWorkersStackTopUpdate(Worker worker, int i, int i5) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = parkedWorkersStack$FU;
        while (true) {
            long j2 = atomicLongFieldUpdater.get(this);
            int i6 = (int) (2097151 & j2);
            long j4 = (2097152 + j2) & (-2097152);
            if (i6 == i) {
                if (i5 == 0) {
                    i6 = parkedWorkersStackNextIndex(worker);
                } else {
                    i6 = i5;
                }
            }
            if (i6 >= 0 && parkedWorkersStack$FU.compareAndSet(this, j2, j4 | i6)) {
                return;
            }
        }
    }

    public final void runSafely(Task task) {
        try {
            task.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void shutdown(long j2) {
        int i;
        Task removeFirstOrNull;
        if (!_isTerminated$FU.compareAndSet(this, 0, 1)) {
            return;
        }
        Worker currentWorker = currentWorker();
        synchronized (this.workers) {
            i = (int) (controlState$FU.get(this) & 2097151);
        }
        if (1 <= i) {
            int i5 = 1;
            while (true) {
                Worker worker = this.workers.get(i5);
                Intrinsics.checkNotNull(worker);
                Worker worker2 = worker;
                if (worker2 != currentWorker) {
                    while (worker2.isAlive()) {
                        LockSupport.unpark(worker2);
                        worker2.join(j2);
                    }
                    WorkerState workerState = worker2.state;
                    if (DebugKt.getASSERTIONS_ENABLED() && workerState != WorkerState.TERMINATED) {
                        throw new AssertionError();
                    }
                    worker2.localQueue.offloadAllWorkTo(this.globalBlockingQueue);
                }
                if (i5 == i) {
                    break;
                }
                i5++;
            }
        }
        this.globalBlockingQueue.close();
        this.globalCpuQueue.close();
        while (true) {
            if (currentWorker != null) {
                removeFirstOrNull = currentWorker.findTask(true);
                if (removeFirstOrNull != null) {
                    continue;
                    runSafely(removeFirstOrNull);
                }
            }
            removeFirstOrNull = this.globalCpuQueue.removeFirstOrNull();
            if (removeFirstOrNull == null && (removeFirstOrNull = this.globalBlockingQueue.removeFirstOrNull()) == null) {
                break;
            }
            runSafely(removeFirstOrNull);
        }
        if (currentWorker != null) {
            currentWorker.tryReleaseCpu(WorkerState.TERMINATED);
        }
        if (DebugKt.getASSERTIONS_ENABLED() && ((int) ((controlState$FU.get(this) & 9223367638808264704L) >> 42)) != this.corePoolSize) {
            throw new AssertionError();
        }
        parkedWorkersStack$FU.set(this, 0L);
        controlState$FU.set(this, 0L);
    }

    public final void signalCpuWork() {
        if (tryUnpark() || tryCreateWorker$default(this, 0L, 1, null)) {
            return;
        }
        tryUnpark();
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int currentLength = this.workers.currentLength();
        int i = 0;
        int i5 = 0;
        int i6 = 0;
        int i8 = 0;
        int i10 = 0;
        for (int i11 = 1; i11 < currentLength; i11++) {
            Worker worker = this.workers.get(i11);
            if (worker != null) {
                int size$kotlinx_coroutines_core = worker.localQueue.getSize$kotlinx_coroutines_core();
                int i12 = WhenMappings.$EnumSwitchMapping$0[worker.state.ordinal()];
                if (i12 != 1) {
                    if (i12 != 2) {
                        if (i12 != 3) {
                            if (i12 != 4) {
                                if (i12 == 5) {
                                    i10++;
                                }
                            } else {
                                i8++;
                                if (size$kotlinx_coroutines_core > 0) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(size$kotlinx_coroutines_core);
                                    sb.append('d');
                                    arrayList.add(sb.toString());
                                }
                            }
                        } else {
                            i++;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(size$kotlinx_coroutines_core);
                            sb2.append('c');
                            arrayList.add(sb2.toString());
                        }
                    } else {
                        i5++;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(size$kotlinx_coroutines_core);
                        sb3.append('b');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    i6++;
                }
            }
        }
        long j2 = controlState$FU.get(this);
        return this.schedulerName + '@' + DebugStringsKt.getHexAddress(this) + "[Pool Size {core = " + this.corePoolSize + ", max = " + this.maxPoolSize + "}, Worker States {CPU = " + i + ", blocking = " + i5 + ", parked = " + i6 + ", dormant = " + i8 + ", terminated = " + i10 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.globalCpuQueue.getSize() + ", global blocking queue size = " + this.globalBlockingQueue.getSize() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.corePoolSize - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }

    /* loaded from: classes.dex */
    public final class Worker extends Thread {
        private static final AtomicIntegerFieldUpdater workerCtl$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");
        private volatile int indexInArray;
        public final WorkQueue localQueue;
        public boolean mayHaveLocalTasks;
        private long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        private int rngState;
        public WorkerState state;
        private final Ref$ObjectRef<Task> stolenTask;
        private long terminationDeadline;
        private volatile int workerCtl;

        private Worker() {
            setDaemon(true);
            this.localQueue = new WorkQueue();
            this.stolenTask = new Ref$ObjectRef<>();
            this.state = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            this.rngState = Random.Default.nextInt();
        }

        private final void afterTask(int i) {
            if (i == 0) {
                return;
            }
            CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, -2097152L);
            WorkerState workerState = this.state;
            if (workerState != WorkerState.TERMINATED) {
                if (DebugKt.getASSERTIONS_ENABLED() && workerState != WorkerState.BLOCKING) {
                    throw new AssertionError();
                }
                this.state = WorkerState.DORMANT;
            }
        }

        private final void beforeTask(int i) {
            if (i != 0 && tryReleaseCpu(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.signalCpuWork();
            }
        }

        private final void executeTask(Task task) {
            int taskMode = task.taskContext.getTaskMode();
            idleReset(taskMode);
            beforeTask(taskMode);
            CoroutineScheduler.this.runSafely(task);
            afterTask(taskMode);
        }

        private final Task findAnyTask(boolean z2) {
            boolean z3;
            Task pollGlobalQueues;
            Task pollGlobalQueues2;
            if (z2) {
                if (nextInt(CoroutineScheduler.this.corePoolSize * 2) == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3 && (pollGlobalQueues2 = pollGlobalQueues()) != null) {
                    return pollGlobalQueues2;
                }
                Task poll = this.localQueue.poll();
                if (poll != null) {
                    return poll;
                }
                if (!z3 && (pollGlobalQueues = pollGlobalQueues()) != null) {
                    return pollGlobalQueues;
                }
            } else {
                Task pollGlobalQueues3 = pollGlobalQueues();
                if (pollGlobalQueues3 != null) {
                    return pollGlobalQueues3;
                }
            }
            return trySteal(3);
        }

        private final Task findBlockingTask() {
            Task pollBlocking = this.localQueue.pollBlocking();
            if (pollBlocking == null) {
                Task removeFirstOrNull = CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
                if (removeFirstOrNull == null) {
                    return trySteal(1);
                }
                return removeFirstOrNull;
            }
            return pollBlocking;
        }

        private final void idleReset(int i) {
            this.terminationDeadline = 0L;
            if (this.state == WorkerState.PARKING) {
                if (DebugKt.getASSERTIONS_ENABLED() && i != 1) {
                    throw new AssertionError();
                }
                this.state = WorkerState.BLOCKING;
            }
        }

        private final boolean inStack() {
            if (this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK) {
                return true;
            }
            return false;
        }

        private final void park() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
            if (System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0L;
                tryTerminateWorker();
            }
        }

        private final Task pollGlobalQueues() {
            if (nextInt(2) == 0) {
                Task removeFirstOrNull = CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
                if (removeFirstOrNull != null) {
                    return removeFirstOrNull;
                }
                return CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            }
            Task removeFirstOrNull2 = CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            if (removeFirstOrNull2 != null) {
                return removeFirstOrNull2;
            }
            return CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
        }

        private final void runWorker() {
            loop0: while (true) {
                boolean z2 = false;
                while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                    Task findTask = findTask(this.mayHaveLocalTasks);
                    if (findTask != null) {
                        this.minDelayUntilStealableTaskNs = 0L;
                        executeTask(findTask);
                    } else {
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs != 0) {
                            if (!z2) {
                                z2 = true;
                            } else {
                                tryReleaseCpu(WorkerState.PARKING);
                                Thread.interrupted();
                                LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                                this.minDelayUntilStealableTaskNs = 0L;
                            }
                        } else {
                            tryPark();
                        }
                    }
                }
            }
            tryReleaseCpu(WorkerState.TERMINATED);
        }

        private final boolean tryAcquireCpuPermit() {
            long j2;
            if (this.state == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.controlState$FU;
            do {
                j2 = atomicLongFieldUpdater.get(coroutineScheduler);
                if (((int) ((9223367638808264704L & j2) >> 42)) != 0) {
                } else {
                    return false;
                }
            } while (!CoroutineScheduler.controlState$FU.compareAndSet(coroutineScheduler, j2, j2 - 4398046511104L));
            this.state = WorkerState.CPU_ACQUIRED;
            return true;
        }

        private final void tryPark() {
            if (!inStack()) {
                CoroutineScheduler.this.parkedWorkersStackPush(this);
                return;
            }
            workerCtl$FU.set(this, -1);
            while (inStack() && workerCtl$FU.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                tryReleaseCpu(WorkerState.PARKING);
                Thread.interrupted();
                park();
            }
        }

        private final Task trySteal(int i) {
            int i5 = (int) (CoroutineScheduler.controlState$FU.get(CoroutineScheduler.this) & 2097151);
            if (i5 < 2) {
                return null;
            }
            int nextInt = nextInt(i5);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j2 = Long.MAX_VALUE;
            for (int i6 = 0; i6 < i5; i6++) {
                nextInt++;
                if (nextInt > i5) {
                    nextInt = 1;
                }
                Worker worker = coroutineScheduler.workers.get(nextInt);
                if (worker != null && worker != this) {
                    long trySteal = worker.localQueue.trySteal(i, this.stolenTask);
                    if (trySteal == -1) {
                        Ref$ObjectRef<Task> ref$ObjectRef = this.stolenTask;
                        Task task = ref$ObjectRef.element;
                        ref$ObjectRef.element = null;
                        return task;
                    } else if (trySteal > 0) {
                        j2 = Math.min(j2, trySteal);
                    }
                }
            }
            if (j2 == Long.MAX_VALUE) {
                j2 = 0;
            }
            this.minDelayUntilStealableTaskNs = j2;
            return null;
        }

        private final void tryTerminateWorker() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.workers) {
                try {
                    if (coroutineScheduler.isTerminated()) {
                        return;
                    }
                    if (((int) (CoroutineScheduler.controlState$FU.get(coroutineScheduler) & 2097151)) <= coroutineScheduler.corePoolSize) {
                        return;
                    }
                    if (!workerCtl$FU.compareAndSet(this, -1, 1)) {
                        return;
                    }
                    int i = this.indexInArray;
                    setIndexInArray(0);
                    coroutineScheduler.parkedWorkersStackTopUpdate(this, i, 0);
                    int andDecrement = (int) (CoroutineScheduler.controlState$FU.getAndDecrement(coroutineScheduler) & 2097151);
                    if (andDecrement != i) {
                        Worker worker = coroutineScheduler.workers.get(andDecrement);
                        Intrinsics.checkNotNull(worker);
                        Worker worker2 = worker;
                        coroutineScheduler.workers.setSynchronized(i, worker2);
                        worker2.setIndexInArray(i);
                        coroutineScheduler.parkedWorkersStackTopUpdate(worker2, andDecrement, i);
                    }
                    coroutineScheduler.workers.setSynchronized(andDecrement, null);
                    Unit unit = Unit.INSTANCE;
                    this.state = WorkerState.TERMINATED;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final Task findTask(boolean z2) {
            if (tryAcquireCpuPermit()) {
                return findAnyTask(z2);
            }
            return findBlockingTask();
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final int nextInt(int i) {
            int i5 = this.rngState;
            int i6 = i5 ^ (i5 << 13);
            int i8 = i6 ^ (i6 >> 17);
            int i10 = i8 ^ (i8 << 5);
            this.rngState = i10;
            int i11 = i - 1;
            if ((i11 & i) == 0) {
                return i10 & i11;
            }
            return (i10 & Integer.MAX_VALUE) % i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            runWorker();
        }

        public final void setIndexInArray(int i) {
            String valueOf;
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            if (i == 0) {
                valueOf = "TERMINATED";
            } else {
                valueOf = String.valueOf(i);
            }
            sb.append(valueOf);
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryReleaseCpu(WorkerState workerState) {
            boolean z2;
            WorkerState workerState2 = this.state;
            if (workerState2 == WorkerState.CPU_ACQUIRED) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.state = workerState;
            }
            return z2;
        }

        public Worker(CoroutineScheduler coroutineScheduler, int i) {
            this();
            setIndexInArray(i);
        }
    }
}
