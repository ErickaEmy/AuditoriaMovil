package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class BlockingCoroutine<T> extends AbstractCoroutine<T> {
    private final Thread blockedThread;
    private final EventLoop eventLoop;

    public BlockingCoroutine(CoroutineContext coroutineContext, Thread thread, EventLoop eventLoop) {
        super(coroutineContext, true, true);
        this.blockedThread = thread;
        this.eventLoop = eventLoop;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void afterCompletion(Object obj) {
        if (!Intrinsics.areEqual(Thread.currentThread(), this.blockedThread)) {
            Thread thread = this.blockedThread;
            AbstractTimeSourceKt.getTimeSource();
            LockSupport.unpark(thread);
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean isScopedCoroutine() {
        return true;
    }

    public final T joinBlocking() {
        long j2;
        AbstractTimeSourceKt.getTimeSource();
        try {
            EventLoop eventLoop = this.eventLoop;
            CompletedExceptionally completedExceptionally = null;
            if (eventLoop != null) {
                EventLoop.incrementUseCount$default(eventLoop, false, 1, null);
            }
            while (!Thread.interrupted()) {
                EventLoop eventLoop2 = this.eventLoop;
                if (eventLoop2 != null) {
                    j2 = eventLoop2.processNextEvent();
                } else {
                    j2 = Long.MAX_VALUE;
                }
                if (!isCompleted()) {
                    AbstractTimeSourceKt.getTimeSource();
                    LockSupport.parkNanos(this, j2);
                } else {
                    EventLoop eventLoop3 = this.eventLoop;
                    if (eventLoop3 != null) {
                        EventLoop.decrementUseCount$default(eventLoop3, false, 1, null);
                    }
                    AbstractTimeSourceKt.getTimeSource();
                    T t2 = (T) JobSupportKt.unboxState(getState$kotlinx_coroutines_core());
                    if (t2 instanceof CompletedExceptionally) {
                        completedExceptionally = (CompletedExceptionally) t2;
                    }
                    if (completedExceptionally == null) {
                        return t2;
                    }
                    throw completedExceptionally.cause;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            cancelCoroutine(interruptedException);
            throw interruptedException;
        } catch (Throwable th) {
            AbstractTimeSourceKt.getTimeSource();
            throw th;
        }
    }
}
