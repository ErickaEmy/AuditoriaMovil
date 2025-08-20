package org.acra.scheduler;

import android.content.Context;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;
import org.acra.file.ReportLocator;
import org.acra.log.ACRALog;
/* compiled from: SchedulerStarter.kt */
/* loaded from: classes2.dex */
public final class SchedulerStarter {
    private final ReportLocator locator;
    private final SenderScheduler senderScheduler;

    public final void scheduleReports(File file, boolean z) {
        if (file != null) {
            if (ACRA.DEV_LOGGING) {
                ACRALog aCRALog = ACRA.log;
                String str = ACRA.LOG_TAG;
                String name = file.getName();
                aCRALog.d(str, "Mark " + name + " as approved.");
            }
            File file2 = new File(this.locator.getApprovedFolder(), file.getName());
            if (!file.renameTo(file2)) {
                ACRALog aCRALog2 = ACRA.log;
                String str2 = ACRA.LOG_TAG;
                aCRALog2.w(str2, "Could not rename approved report from " + file + " to " + file2);
            }
        }
        if (ACRA.DEV_LOGGING) {
            ACRA.log.d(ACRA.LOG_TAG, "Schedule report sending");
        }
        this.senderScheduler.scheduleReportSending(z);
    }

    public SchedulerStarter(Context context, CoreConfiguration config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.locator = new ReportLocator(context);
        List loadEnabled = config.getPluginLoader().loadEnabled(config, SenderSchedulerFactory.class);
        if (loadEnabled.isEmpty()) {
            this.senderScheduler = new DefaultSenderScheduler(context, config);
            return;
        }
        SenderScheduler create = ((SenderSchedulerFactory) loadEnabled.get(0)).create(context, config);
        this.senderScheduler = create;
        if (loadEnabled.size() > 1) {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            String simpleName = create.getClass().getSimpleName();
            aCRALog.w(str, "More than one SenderScheduler found. Will use only " + simpleName);
        }
    }
}
