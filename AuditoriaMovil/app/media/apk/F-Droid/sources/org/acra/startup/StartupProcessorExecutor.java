package org.acra.startup;

import android.content.Context;
import android.os.Handler;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;
import org.acra.file.CrashReportFileNameParser;
import org.acra.file.ReportLocator;
import org.acra.interaction.ReportInteractionExecutor;
import org.acra.scheduler.SchedulerStarter;
/* compiled from: StartupProcessorExecutor.kt */
/* loaded from: classes2.dex */
public final class StartupProcessorExecutor {
    private final CoreConfiguration config;
    private final Context context;
    private final CrashReportFileNameParser fileNameParser;
    private final ReportLocator reportLocator;
    private final SchedulerStarter schedulerStarter;

    public StartupProcessorExecutor(Context context, CoreConfiguration config, SchedulerStarter schedulerStarter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(schedulerStarter, "schedulerStarter");
        this.context = context;
        this.config = config;
        this.schedulerStarter = schedulerStarter;
        this.reportLocator = new ReportLocator(context);
        this.fileNameParser = new CrashReportFileNameParser();
    }

    public final void processReports(final boolean z) {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(12, -1);
        new Handler(this.context.getMainLooper()).post(new Runnable() { // from class: org.acra.startup.StartupProcessorExecutor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                StartupProcessorExecutor.processReports$lambda$6(StartupProcessorExecutor.this, calendar, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processReports$lambda$6(final StartupProcessorExecutor this$0, final Calendar calendar, final boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new Thread(new Runnable() { // from class: org.acra.startup.StartupProcessorExecutor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                StartupProcessorExecutor.processReports$lambda$6$lambda$5(StartupProcessorExecutor.this, calendar, z);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processReports$lambda$6$lambda$5(StartupProcessorExecutor this$0, Calendar calendar, boolean z) {
        List<Report> plus;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        File[] unapprovedReports = this$0.reportLocator.getUnapprovedReports();
        ArrayList arrayList = new ArrayList(unapprovedReports.length);
        for (File file : unapprovedReports) {
            arrayList.add(new Report(file, false));
        }
        File[] approvedReports = this$0.reportLocator.getApprovedReports();
        ArrayList arrayList2 = new ArrayList(approvedReports.length);
        for (File file2 : approvedReports) {
            arrayList2.add(new Report(file2, true));
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
        for (StartupProcessor startupProcessor : this$0.config.getPluginLoader().loadEnabled(this$0.config, StartupProcessor.class)) {
            startupProcessor.processReports(this$0.context, this$0.config, plus);
        }
        boolean z2 = false;
        for (Report report : plus) {
            CrashReportFileNameParser crashReportFileNameParser = this$0.fileNameParser;
            String name = report.getFile().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (crashReportFileNameParser.getTimestamp(name).before(calendar)) {
                if (report.getDelete()) {
                    if (!report.getFile().delete()) {
                        ACRA.log.w(ACRA.LOG_TAG, "Could not delete report " + report.getFile());
                    }
                } else if (report.getApproved()) {
                    z2 = true;
                } else if (report.getApprove() && z && new ReportInteractionExecutor(this$0.context, this$0.config).performInteractions(report.getFile())) {
                    this$0.schedulerStarter.scheduleReports(report.getFile(), false);
                }
            }
        }
        if (z2 && z) {
            this$0.schedulerStarter.scheduleReports(null, false);
        }
    }
}
