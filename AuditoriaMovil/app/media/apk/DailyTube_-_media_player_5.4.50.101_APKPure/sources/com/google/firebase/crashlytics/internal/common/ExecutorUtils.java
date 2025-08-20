package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class ExecutorUtils {
    private ExecutorUtils() {
    }

    private static final void addDelayedShutdownHook(String str, ExecutorService executorService) {
        addDelayedShutdownHook(str, executorService, 2L, TimeUnit.SECONDS);
    }

    public static ExecutorService buildSingleThreadExecutorService(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(getNamedThreadFactory(str));
        addDelayedShutdownHook(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    public static ScheduledExecutorService buildSingleThreadScheduledExecutorService(String str) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(getNamedThreadFactory(str));
        addDelayedShutdownHook(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    public static final ThreadFactory getNamedThreadFactory(String str) {
        return new 1(str, new AtomicLong(1L));
    }

    public static final void addDelayedShutdownHook(String str, ExecutorService executorService, long j2, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        2 r8 = new 2(str, executorService, j2, timeUnit);
        runtime.addShutdownHook(new Thread((Runnable) r8, "Crashlytics Shutdown Hook for " + str));
    }
}
