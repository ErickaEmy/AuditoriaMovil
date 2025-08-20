package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public final class ScheduledDirectTask extends AbstractDirectTask implements Callable {
    @Override // io.reactivex.rxjava3.internal.schedulers.AbstractDirectTask, java.util.concurrent.atomic.AtomicReference
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public ScheduledDirectTask(Runnable runnable, boolean z) {
        super(runnable, z);
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            lazySet(AbstractDirectTask.FINISHED);
            this.runner = null;
            return null;
        } catch (Throwable th) {
            RxJavaPlugins.onError(th);
            throw th;
        }
    }
}
