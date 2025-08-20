package kotlinx.coroutines.scheduling;
/* compiled from: Tasks.kt */
/* loaded from: classes2.dex */
final class TaskContextImpl implements TaskContext {
    private final int taskMode;

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public void afterTask() {
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public int getTaskMode() {
        return this.taskMode;
    }

    public TaskContextImpl(int i) {
        this.taskMode = i;
    }
}
