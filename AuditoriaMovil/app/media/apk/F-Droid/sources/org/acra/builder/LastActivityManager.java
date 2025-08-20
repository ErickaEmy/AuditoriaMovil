package org.acra.builder;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.collections.WeakStack;
import org.acra.log.ACRALog;
/* compiled from: LastActivityManager.kt */
/* loaded from: classes2.dex */
public final class LastActivityManager {
    private final WeakStack activityStack;
    private final Condition destroyedCondition;
    private final ReentrantLock lock;

    public LastActivityManager(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.activityStack = new WeakStack();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.destroyedCondition = reentrantLock.newCondition();
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: org.acra.builder.LastActivityManager.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (ACRA.DEV_LOGGING) {
                    ACRALog aCRALog = ACRA.log;
                    String str = ACRA.LOG_TAG;
                    Class<?> cls = activity.getClass();
                    aCRALog.d(str, "onActivityCreated " + cls);
                }
                LastActivityManager.this.activityStack.add(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (ACRA.DEV_LOGGING) {
                    ACRALog aCRALog = ACRA.log;
                    String str = ACRA.LOG_TAG;
                    Class<?> cls = activity.getClass();
                    aCRALog.d(str, "onActivityDestroyed " + cls);
                }
                ReentrantLock reentrantLock2 = LastActivityManager.this.lock;
                LastActivityManager lastActivityManager = LastActivityManager.this;
                reentrantLock2.lock();
                try {
                    lastActivityManager.activityStack.remove(activity);
                    lastActivityManager.destroyedCondition.signalAll();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    reentrantLock2.unlock();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (ACRA.DEV_LOGGING) {
                    ACRALog aCRALog = ACRA.log;
                    String str = ACRA.LOG_TAG;
                    Class<?> cls = activity.getClass();
                    aCRALog.d(str, "onActivityPaused " + cls);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (ACRA.DEV_LOGGING) {
                    ACRALog aCRALog = ACRA.log;
                    String str = ACRA.LOG_TAG;
                    Class<?> cls = activity.getClass();
                    aCRALog.d(str, "onActivityResumed " + cls);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(outState, "outState");
                if (ACRA.DEV_LOGGING) {
                    ACRALog aCRALog = ACRA.log;
                    String str = ACRA.LOG_TAG;
                    Class<?> cls = activity.getClass();
                    aCRALog.d(str, "onActivitySaveInstanceState " + cls);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (ACRA.DEV_LOGGING) {
                    ACRALog aCRALog = ACRA.log;
                    String str = ACRA.LOG_TAG;
                    Class<?> cls = activity.getClass();
                    aCRALog.d(str, "onActivityStarted " + cls);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (ACRA.DEV_LOGGING) {
                    ACRALog aCRALog = ACRA.log;
                    String str = ACRA.LOG_TAG;
                    Class<?> cls = activity.getClass();
                    aCRALog.d(str, "onActivityStopped " + cls);
                }
            }
        });
    }

    public final List getLastActivities() {
        return new ArrayList(this.activityStack);
    }

    public final void clearLastActivities() {
        this.activityStack.clear();
    }

    public final void waitForAllActivitiesDestroy(int i) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis;
            while (!this.activityStack.isEmpty()) {
                long j2 = i;
                if (currentTimeMillis + j2 <= j) {
                    break;
                }
                this.destroyedCondition.await((currentTimeMillis - j) + j2, TimeUnit.MILLISECONDS);
                j = System.currentTimeMillis();
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
