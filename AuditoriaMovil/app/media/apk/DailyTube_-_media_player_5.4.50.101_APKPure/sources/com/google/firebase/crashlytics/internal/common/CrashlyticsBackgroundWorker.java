package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CrashlyticsBackgroundWorker {
    private final ExecutorService executorService;
    private Task<Void> tail = Tasks.forResult(null);
    private final Object tailLock = new Object();
    private ThreadLocal<Boolean> isExecutorThread = new ThreadLocal<>();

    public CrashlyticsBackgroundWorker(ExecutorService executorService) {
        this.executorService = executorService;
        executorService.submit((Runnable) new 1(this));
    }

    private <T> Task<Void> ignoreResult(Task<T> task) {
        return task.continueWith(this.executorService, new 4(this));
    }

    private boolean isRunningOnThread() {
        return Boolean.TRUE.equals(this.isExecutorThread.get());
    }

    private <T> Continuation<Void, T> newContinuation(Callable<T> callable) {
        return new 3(this, callable);
    }

    public void checkRunningOnThread() {
        if (isRunningOnThread()) {
            return;
        }
        throw new IllegalStateException("Not running on background worker thread as intended.");
    }

    public Executor getExecutor() {
        return this.executorService;
    }

    public Task<Void> submit(Runnable runnable) {
        return submit((Callable) new 2(this, runnable));
    }

    public <T> Task<T> submitTask(Callable<Task<T>> callable) {
        Task<T> continueWithTask;
        synchronized (this.tailLock) {
            continueWithTask = this.tail.continueWithTask(this.executorService, newContinuation(callable));
            this.tail = ignoreResult(continueWithTask);
        }
        return continueWithTask;
    }

    public <T> Task<T> submit(Callable<T> callable) {
        Task<T> continueWith;
        synchronized (this.tailLock) {
            continueWith = this.tail.continueWith(this.executorService, newContinuation(callable));
            this.tail = ignoreResult(continueWith);
        }
        return continueWith;
    }
}
