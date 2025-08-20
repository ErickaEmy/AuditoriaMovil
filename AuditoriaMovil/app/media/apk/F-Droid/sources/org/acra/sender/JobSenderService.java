package org.acra.sender;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Bundle;
import android.os.PersistableBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.config.CoreConfiguration;
import org.acra.util.IOUtils;
/* compiled from: JobSenderService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lorg/acra/sender/JobSenderService;", "Landroid/app/job/JobService;", "()V", "onStartJob", "", "params", "Landroid/app/job/JobParameters;", "onStopJob", "acra-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class JobSenderService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters params) {
        Intrinsics.checkNotNullParameter(params, "params");
        final PersistableBundle extras = params.getExtras();
        Intrinsics.checkNotNullExpressionValue(extras, "getExtras(...)");
        final CoreConfiguration coreConfiguration = (CoreConfiguration) IOUtils.INSTANCE.deserialize(CoreConfiguration.class, extras.getString("acraConfig"));
        if (coreConfiguration != null) {
            new Thread(new Runnable() { // from class: org.acra.sender.JobSenderService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    JobSenderService.onStartJob$lambda$0(JobSenderService.this, coreConfiguration, extras, params);
                }
            }).start();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStartJob$lambda$0(JobSenderService this$0, CoreConfiguration coreConfiguration, PersistableBundle extras, JobParameters params) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(extras, "$extras");
        Intrinsics.checkNotNullParameter(params, "$params");
        new SendingConductor(this$0, coreConfiguration).sendReports(false, new Bundle(extras));
        this$0.jobFinished(params, false);
    }
}
