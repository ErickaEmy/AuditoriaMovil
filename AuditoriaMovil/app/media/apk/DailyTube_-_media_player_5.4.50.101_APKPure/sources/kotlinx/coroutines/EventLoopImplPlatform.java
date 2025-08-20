package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.EventLoopImplBase;
/* loaded from: classes.dex */
public abstract class EventLoopImplPlatform extends EventLoop {
    public abstract Thread getThread();

    public void reschedule(long j2, EventLoopImplBase.DelayedTask delayedTask) {
        DefaultExecutor.INSTANCE.schedule(j2, delayedTask);
    }

    public final void unpark() {
        Thread thread = getThread();
        if (Thread.currentThread() != thread) {
            AbstractTimeSourceKt.getTimeSource();
            LockSupport.unpark(thread);
        }
    }
}
