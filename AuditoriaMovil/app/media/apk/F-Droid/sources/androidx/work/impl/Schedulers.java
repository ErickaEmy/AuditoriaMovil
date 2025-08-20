package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.Clock;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.PackageManagerHelper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public abstract class Schedulers {
    private static final String TAG = Logger.tagWithPrefix("Schedulers");

    public static void registerRescheduling(final List list, Processor processor, final Executor executor, final WorkDatabase workDatabase, final Configuration configuration) {
        processor.addExecutionListener(new ExecutionListener() { // from class: androidx.work.impl.Schedulers$$ExternalSyntheticLambda0
            @Override // androidx.work.impl.ExecutionListener
            public final void onExecuted(WorkGenerationalId workGenerationalId, boolean z) {
                Schedulers.lambda$registerRescheduling$1(executor, list, configuration, workDatabase, workGenerationalId, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$registerRescheduling$1(Executor executor, final List list, final Configuration configuration, final WorkDatabase workDatabase, final WorkGenerationalId workGenerationalId, boolean z) {
        executor.execute(new Runnable() { // from class: androidx.work.impl.Schedulers$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Schedulers.lambda$registerRescheduling$0(list, workGenerationalId, configuration, workDatabase);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$registerRescheduling$0(List list, WorkGenerationalId workGenerationalId, Configuration configuration, WorkDatabase workDatabase) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Scheduler) it.next()).cancel(workGenerationalId.getWorkSpecId());
        }
        schedule(configuration, workDatabase, list);
    }

    public static void schedule(Configuration configuration, WorkDatabase workDatabase, List list) {
        List list2;
        if (list == null || list.size() == 0) {
            return;
        }
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        workDatabase.beginTransaction();
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                list2 = workSpecDao.getEligibleWorkForSchedulingWithContentUris();
                markScheduled(workSpecDao, configuration.getClock(), list2);
            } else {
                list2 = null;
            }
            List eligibleWorkForScheduling = workSpecDao.getEligibleWorkForScheduling(configuration.getMaxSchedulerLimit());
            markScheduled(workSpecDao, configuration.getClock(), eligibleWorkForScheduling);
            if (list2 != null) {
                eligibleWorkForScheduling.addAll(list2);
            }
            List allEligibleWorkSpecsForScheduling = workSpecDao.getAllEligibleWorkSpecsForScheduling(200);
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            if (eligibleWorkForScheduling.size() > 0) {
                WorkSpec[] workSpecArr = (WorkSpec[]) eligibleWorkForScheduling.toArray(new WorkSpec[eligibleWorkForScheduling.size()]);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Scheduler scheduler = (Scheduler) it.next();
                    if (scheduler.hasLimitedSchedulingSlots()) {
                        scheduler.schedule(workSpecArr);
                    }
                }
            }
            if (allEligibleWorkSpecsForScheduling.size() > 0) {
                WorkSpec[] workSpecArr2 = (WorkSpec[]) allEligibleWorkSpecsForScheduling.toArray(new WorkSpec[allEligibleWorkSpecsForScheduling.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    Scheduler scheduler2 = (Scheduler) it2.next();
                    if (!scheduler2.hasLimitedSchedulingSlots()) {
                        scheduler2.schedule(workSpecArr2);
                    }
                }
            }
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Scheduler createBestAvailableBackgroundScheduler(Context context, WorkDatabase workDatabase, Configuration configuration) {
        SystemJobScheduler systemJobScheduler = new SystemJobScheduler(context, workDatabase, configuration);
        PackageManagerHelper.setComponentEnabled(context, SystemJobService.class, true);
        Logger.get().debug(TAG, "Created SystemJobScheduler and enabled SystemJobService");
        return systemJobScheduler;
    }

    private static void markScheduled(WorkSpecDao workSpecDao, Clock clock, List list) {
        if (list.size() > 0) {
            long currentTimeMillis = clock.currentTimeMillis();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                workSpecDao.markWorkSpecScheduled(((WorkSpec) it.next()).id, currentTimeMillis);
            }
        }
    }
}
