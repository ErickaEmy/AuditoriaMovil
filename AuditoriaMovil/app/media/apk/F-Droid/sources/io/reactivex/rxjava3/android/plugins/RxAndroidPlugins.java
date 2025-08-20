package io.reactivex.rxjava3.android.plugins;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public abstract class RxAndroidPlugins {
    private static volatile Function onInitMainThreadHandler;
    private static volatile Function onMainThreadHandler;

    public static Scheduler initMainThreadScheduler(Callable callable) {
        if (callable != null) {
            Function function = onInitMainThreadHandler;
            if (function == null) {
                return callRequireNonNull(callable);
            }
            return applyRequireNonNull(function, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static Scheduler onMainThreadScheduler(Scheduler scheduler) {
        if (scheduler != null) {
            Function function = onMainThreadHandler;
            return function == null ? scheduler : (Scheduler) apply(function, scheduler);
        }
        throw new NullPointerException("scheduler == null");
    }

    static Scheduler callRequireNonNull(Callable callable) {
        try {
            Scheduler scheduler = (Scheduler) callable.call();
            if (scheduler != null) {
                return scheduler;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw Exceptions.propagate(th);
        }
    }

    static Scheduler applyRequireNonNull(Function function, Callable callable) {
        Scheduler scheduler = (Scheduler) apply(function, callable);
        if (scheduler != null) {
            return scheduler;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static Object apply(Function function, Object obj) {
        try {
            return function.apply(obj);
        } catch (Throwable th) {
            throw Exceptions.propagate(th);
        }
    }
}
