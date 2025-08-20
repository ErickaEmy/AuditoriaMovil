package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: IdGenerator.kt */
/* loaded from: classes.dex */
public final class IdGenerator {
    private final WorkDatabase workDatabase;

    public IdGenerator(WorkDatabase workDatabase) {
        Intrinsics.checkNotNullParameter(workDatabase, "workDatabase");
        this.workDatabase = workDatabase;
    }

    public final int nextJobSchedulerIdWithRange(final int i, final int i2) {
        Object runInTransaction = this.workDatabase.runInTransaction(new Callable() { // from class: androidx.work.impl.utils.IdGenerator$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Integer nextJobSchedulerIdWithRange$lambda$0;
                nextJobSchedulerIdWithRange$lambda$0 = IdGenerator.nextJobSchedulerIdWithRange$lambda$0(IdGenerator.this, i, i2);
                return nextJobSchedulerIdWithRange$lambda$0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(runInTransaction, "workDatabase.runInTransa…            id\n        })");
        return ((Number) runInTransaction).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer nextJobSchedulerIdWithRange$lambda$0(IdGenerator this$0, int i, int i2) {
        int nextId;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        nextId = IdGeneratorKt.nextId(this$0.workDatabase, "next_job_scheduler_id");
        if (i > nextId || nextId > i2) {
            IdGeneratorKt.updatePreference(this$0.workDatabase, "next_job_scheduler_id", i + 1);
        } else {
            i = nextId;
        }
        return Integer.valueOf(i);
    }

    public final int nextAlarmManagerId() {
        Object runInTransaction = this.workDatabase.runInTransaction(new Callable() { // from class: androidx.work.impl.utils.IdGenerator$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Integer nextAlarmManagerId$lambda$1;
                nextAlarmManagerId$lambda$1 = IdGenerator.nextAlarmManagerId$lambda$1(IdGenerator.this);
                return nextAlarmManagerId$lambda$1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(runInTransaction, "workDatabase.runInTransa…ANAGER_ID_KEY)\n        })");
        return ((Number) runInTransaction).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer nextAlarmManagerId$lambda$1(IdGenerator this$0) {
        int nextId;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        nextId = IdGeneratorKt.nextId(this$0.workDatabase, "next_alarm_manager_id");
        return Integer.valueOf(nextId);
    }
}
