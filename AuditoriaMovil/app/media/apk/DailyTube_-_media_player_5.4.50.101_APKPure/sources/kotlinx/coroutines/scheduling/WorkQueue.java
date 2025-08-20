package kotlinx.coroutines.scheduling;

import androidx.core.app.NotificationCompat;
import gc1.y;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.DebugKt;
import r.n3;
/* loaded from: classes.dex */
public final class WorkQueue {
    private volatile int blockingTasksInBuffer;
    private final AtomicReferenceArray<Task> buffer = new AtomicReferenceArray<>((int) NotificationCompat.FLAG_HIGH_PRIORITY);
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;
    private static final AtomicReferenceFieldUpdater lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");
    private static final AtomicIntegerFieldUpdater producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");
    private static final AtomicIntegerFieldUpdater consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");
    private static final AtomicIntegerFieldUpdater blockingTasksInBuffer$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");

    private final Task addLast(Task task) {
        if (getBufferSize() == 127) {
            return task;
        }
        if (task.taskContext.getTaskMode() == 1) {
            blockingTasksInBuffer$FU.incrementAndGet(this);
        }
        int i = producerIndex$FU.get(this) & 127;
        while (this.buffer.get(i) != null) {
            Thread.yield();
        }
        this.buffer.lazySet(i, task);
        producerIndex$FU.incrementAndGet(this);
        return null;
    }

    private final void decrementIfBlocking(Task task) {
        if (task != null && task.taskContext.getTaskMode() == 1) {
            int decrementAndGet = blockingTasksInBuffer$FU.decrementAndGet(this);
            if (DebugKt.getASSERTIONS_ENABLED() && decrementAndGet < 0) {
                throw new AssertionError();
            }
        }
    }

    private final int getBufferSize() {
        return producerIndex$FU.get(this) - consumerIndex$FU.get(this);
    }

    private final Task pollBuffer() {
        Task andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = consumerIndex$FU;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i - producerIndex$FU.get(this) == 0) {
                return null;
            }
            int i5 = i & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1) && (andSet = this.buffer.getAndSet(i5, null)) != null) {
                decrementIfBlocking(andSet);
                return andSet;
            }
        }
    }

    private final boolean pollTo(GlobalQueue globalQueue) {
        Task pollBuffer = pollBuffer();
        if (pollBuffer == null) {
            return false;
        }
        globalQueue.addLast(pollBuffer);
        return true;
    }

    private final Task pollWithExclusiveMode(boolean z2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Task task;
        do {
            atomicReferenceFieldUpdater = lastScheduledTask$FU;
            task = (Task) atomicReferenceFieldUpdater.get(this);
            if (task != null) {
                boolean z3 = true;
                if (task.taskContext.getTaskMode() != 1) {
                    z3 = false;
                }
                if (z3 == z2) {
                }
            }
            int i = consumerIndex$FU.get(this);
            int i5 = producerIndex$FU.get(this);
            while (i != i5) {
                if (z2 && blockingTasksInBuffer$FU.get(this) == 0) {
                    return null;
                }
                i5--;
                Task tryExtractFromTheMiddle = tryExtractFromTheMiddle(i5, z2);
                if (tryExtractFromTheMiddle != null) {
                    return tryExtractFromTheMiddle;
                }
            }
            return null;
        } while (!n3.y(atomicReferenceFieldUpdater, this, task, null));
        return task;
    }

    private final Task stealWithExclusiveMode(int i) {
        int i5 = consumerIndex$FU.get(this);
        int i6 = producerIndex$FU.get(this);
        boolean z2 = true;
        if (i != 1) {
            z2 = false;
        }
        while (i5 != i6) {
            if (z2 && blockingTasksInBuffer$FU.get(this) == 0) {
                return null;
            }
            int i8 = i5 + 1;
            Task tryExtractFromTheMiddle = tryExtractFromTheMiddle(i5, z2);
            if (tryExtractFromTheMiddle == null) {
                i5 = i8;
            } else {
                return tryExtractFromTheMiddle;
            }
        }
        return null;
    }

    private final Task tryExtractFromTheMiddle(int i, boolean z2) {
        int i5 = i & 127;
        Task task = this.buffer.get(i5);
        if (task != null) {
            boolean z3 = true;
            if (task.taskContext.getTaskMode() != 1) {
                z3 = false;
            }
            if (z3 == z2 && y.y(this.buffer, i5, task, null)) {
                if (z2) {
                    blockingTasksInBuffer$FU.decrementAndGet(this);
                }
                return task;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, kotlinx.coroutines.scheduling.Task, java.lang.Object] */
    private final long tryStealLastScheduled(int i, Ref$ObjectRef<Task> ref$ObjectRef) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ?? r1;
        do {
            atomicReferenceFieldUpdater = lastScheduledTask$FU;
            r1 = (Task) atomicReferenceFieldUpdater.get(this);
            if (r1 == 0) {
                return -2L;
            }
            int i5 = 1;
            if (r1.taskContext.getTaskMode() != 1) {
                i5 = 2;
            }
            if ((i5 & i) == 0) {
                return -2L;
            }
            long nanoTime = TasksKt.schedulerTimeSource.nanoTime() - r1.submissionTime;
            long j2 = TasksKt.WORK_STEALING_TIME_RESOLUTION_NS;
            if (nanoTime < j2) {
                return j2 - nanoTime;
            }
        } while (!n3.y(atomicReferenceFieldUpdater, this, r1, null));
        ref$ObjectRef.element = r1;
        return -1L;
    }

    public final Task add(Task task, boolean z2) {
        if (z2) {
            return addLast(task);
        }
        Task task2 = (Task) lastScheduledTask$FU.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return addLast(task2);
    }

    public final int getSize$kotlinx_coroutines_core() {
        if (lastScheduledTask$FU.get(this) != null) {
            return getBufferSize() + 1;
        }
        return getBufferSize();
    }

    public final void offloadAllWorkTo(GlobalQueue globalQueue) {
        Task task = (Task) lastScheduledTask$FU.getAndSet(this, null);
        if (task != null) {
            globalQueue.addLast(task);
        }
        do {
        } while (pollTo(globalQueue));
    }

    public final Task poll() {
        Task task = (Task) lastScheduledTask$FU.getAndSet(this, null);
        if (task == null) {
            return pollBuffer();
        }
        return task;
    }

    public final Task pollBlocking() {
        return pollWithExclusiveMode(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long trySteal(int i, Ref$ObjectRef<Task> ref$ObjectRef) {
        T t2;
        if (i == 3) {
            t2 = pollBuffer();
        } else {
            t2 = stealWithExclusiveMode(i);
        }
        if (t2 != 0) {
            ref$ObjectRef.element = t2;
            return -1L;
        }
        return tryStealLastScheduled(i, ref$ObjectRef);
    }
}
