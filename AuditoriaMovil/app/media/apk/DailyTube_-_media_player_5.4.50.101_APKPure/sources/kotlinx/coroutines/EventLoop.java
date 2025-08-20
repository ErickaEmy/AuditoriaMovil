package kotlinx.coroutines;

import kotlin.collections.ArrayDeque;
/* loaded from: classes.dex */
public abstract class EventLoop extends CoroutineDispatcher {
    private boolean shared;
    private ArrayDeque<DispatchedTask<?>> unconfinedQueue;
    private long useCount;

    public static /* synthetic */ void decrementUseCount$default(EventLoop eventLoop, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            eventLoop.decrementUseCount(z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    private final long delta(boolean z2) {
        return z2 ? 4294967296L : 1L;
    }

    public static /* synthetic */ void incrementUseCount$default(EventLoop eventLoop, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            eventLoop.incrementUseCount(z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void decrementUseCount(boolean z2) {
        long delta = this.useCount - delta(z2);
        this.useCount = delta;
        if (delta > 0) {
            return;
        }
        if (DebugKt.getASSERTIONS_ENABLED() && this.useCount != 0) {
            throw new AssertionError();
        }
        if (this.shared) {
            shutdown();
        }
    }

    public final void dispatchUnconfined(DispatchedTask<?> dispatchedTask) {
        ArrayDeque<DispatchedTask<?>> arrayDeque = this.unconfinedQueue;
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque<>();
            this.unconfinedQueue = arrayDeque;
        }
        arrayDeque.addLast(dispatchedTask);
    }

    public long getNextTime() {
        ArrayDeque<DispatchedTask<?>> arrayDeque = this.unconfinedQueue;
        if (arrayDeque == null || arrayDeque.isEmpty()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public final void incrementUseCount(boolean z2) {
        this.useCount += delta(z2);
        if (!z2) {
            this.shared = true;
        }
    }

    public final boolean isUnconfinedLoopActive() {
        if (this.useCount >= delta(true)) {
            return true;
        }
        return false;
    }

    public final boolean isUnconfinedQueueEmpty() {
        ArrayDeque<DispatchedTask<?>> arrayDeque = this.unconfinedQueue;
        if (arrayDeque != null) {
            return arrayDeque.isEmpty();
        }
        return true;
    }

    public long processNextEvent() {
        if (!processUnconfinedEvent()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public final boolean processUnconfinedEvent() {
        DispatchedTask<?> removeFirstOrNull;
        ArrayDeque<DispatchedTask<?>> arrayDeque = this.unconfinedQueue;
        if (arrayDeque == null || (removeFirstOrNull = arrayDeque.removeFirstOrNull()) == null) {
            return false;
        }
        removeFirstOrNull.run();
        return true;
    }

    public boolean shouldBeProcessedFromContext() {
        return false;
    }

    public void shutdown() {
    }
}
