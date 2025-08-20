package androidx.work.impl.utils;

import android.os.Build;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EnqueueUtils.kt */
/* loaded from: classes.dex */
public abstract class EnqueueUtilsKt {
    public static final void checkContentUriTriggerWorkerLimits(WorkDatabase workDatabase, Configuration configuration, WorkContinuationImpl continuation) {
        List mutableListOf;
        Object removeLast;
        int i;
        Intrinsics.checkNotNullParameter(workDatabase, "workDatabase");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(continuation);
        int i2 = 0;
        while (!mutableListOf.isEmpty()) {
            removeLast = CollectionsKt__MutableCollectionsKt.removeLast(mutableListOf);
            WorkContinuationImpl workContinuationImpl = (WorkContinuationImpl) removeLast;
            List<WorkRequest> work = workContinuationImpl.getWork();
            Intrinsics.checkNotNullExpressionValue(work, "current.work");
            if ((work instanceof Collection) && work.isEmpty()) {
                i = 0;
            } else {
                i = 0;
                for (WorkRequest workRequest : work) {
                    if (workRequest.getWorkSpec().constraints.hasContentUriTriggers() && (i = i + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
            }
            i2 += i;
            List parents = workContinuationImpl.getParents();
            if (parents != null) {
                mutableListOf.addAll(parents);
            }
        }
        if (i2 == 0) {
            return;
        }
        int countNonFinishedContentUriTriggerWorkers = workDatabase.workSpecDao().countNonFinishedContentUriTriggerWorkers();
        int contentUriTriggerWorkersLimit = configuration.getContentUriTriggerWorkersLimit();
        if (countNonFinishedContentUriTriggerWorkers + i2 <= contentUriTriggerWorkersLimit) {
            return;
        }
        throw new IllegalArgumentException("Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: " + contentUriTriggerWorkersLimit + ";\nalready enqueued count: " + countNonFinishedContentUriTriggerWorkers + ";\ncurrent enqueue operation count: " + i2 + ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed.");
    }

    public static final WorkSpec tryDelegateConstrainedWorkSpec(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        Constraints constraints = workSpec.constraints;
        String str = workSpec.workerClassName;
        if (Intrinsics.areEqual(str, ConstraintTrackingWorker.class.getName())) {
            return workSpec;
        }
        if (constraints.requiresBatteryNotLow() || constraints.requiresStorageNotLow()) {
            Data build = new Data.Builder().putAll(workSpec.input).putString("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder().putAll(workSpe…ame)\n            .build()");
            String name = ConstraintTrackingWorker.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "name");
            return WorkSpec.copy$default(workSpec, null, null, name, null, build, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, 8388587, null);
        }
        return workSpec;
    }

    public static final WorkSpec wrapInConstraintTrackingWorkerIfNeeded(List schedulers, WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter(schedulers, "schedulers");
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        return Build.VERSION.SDK_INT < 26 ? tryDelegateConstrainedWorkSpec(workSpec) : workSpec;
    }
}
