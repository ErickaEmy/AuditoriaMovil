package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.DebugStringsKt;
/* loaded from: classes.dex */
public final class TaskImpl extends Task {
    public final Runnable block;

    public TaskImpl(Runnable runnable, long j2, TaskContext taskContext) {
        super(j2, taskContext);
        this.block = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.block.run();
        } finally {
            this.taskContext.afterTask();
        }
    }

    public String toString() {
        return "Task[" + DebugStringsKt.getClassSimpleName(this.block) + '@' + DebugStringsKt.getHexAddress(this.block) + ", " + this.submissionTime + ", " + this.taskContext + ']';
    }
}
