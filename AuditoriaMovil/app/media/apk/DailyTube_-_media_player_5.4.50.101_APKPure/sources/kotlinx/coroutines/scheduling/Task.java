package kotlinx.coroutines.scheduling;
/* loaded from: classes.dex */
public abstract class Task implements Runnable {
    public long submissionTime;
    public TaskContext taskContext;

    public Task(long j2, TaskContext taskContext) {
        this.submissionTime = j2;
        this.taskContext = taskContext;
    }

    public Task() {
        this(0L, TasksKt.NonBlockingContext);
    }
}
