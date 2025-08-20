package org.acra.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.file.BulkReportDeleter;
import org.acra.file.CrashReportPersister;
import org.acra.interaction.DialogInteraction;
import org.acra.log.ACRALog;
import org.acra.scheduler.SchedulerStarter;
import org.json.JSONException;
/* compiled from: CrashReportDialogHelper.kt */
/* loaded from: classes2.dex */
public final class CrashReportDialogHelper {
    private final CoreConfiguration config;
    private final Context context;
    private final Lazy reportData$delegate;
    private final File reportFile;

    public final CoreConfiguration getConfig() {
        return this.config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendCrash$lambda$5(CrashReportDialogHelper this$0, String str, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (ACRA.DEV_LOGGING) {
                ACRALog aCRALog = ACRA.log;
                String str3 = ACRA.LOG_TAG;
                File file = this$0.reportFile;
                aCRALog.d(str3, "Add user comment to " + file);
            }
            CrashReportData reportData = this$0.getReportData();
            ReportField reportField = ReportField.USER_COMMENT;
            if (str == null) {
                str = "";
            }
            reportData.put(reportField, str);
            ReportField reportField2 = ReportField.USER_EMAIL;
            if (str2 == null) {
                str2 = "";
            }
            reportData.put(reportField2, str2);
            new CrashReportPersister().store(reportData, this$0.reportFile);
        } catch (IOException e) {
            ACRA.log.w(ACRA.LOG_TAG, "User comment not added: ", e);
        } catch (JSONException e2) {
            ACRA.log.w(ACRA.LOG_TAG, "User comment not added: ", e2);
        }
        new SchedulerStarter(this$0.context, this$0.config).scheduleReports(this$0.reportFile, false);
    }

    public CrashReportDialogHelper(Context context, Intent intent) {
        Object obj;
        Object obj2;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.context = context;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            obj = intent.getSerializableExtra(DialogInteraction.EXTRA_REPORT_CONFIG, CoreConfiguration.class);
        } else {
            Object serializableExtra = intent.getSerializableExtra(DialogInteraction.EXTRA_REPORT_CONFIG);
            obj = (CoreConfiguration) (serializableExtra instanceof CoreConfiguration ? serializableExtra : null);
        }
        CoreConfiguration coreConfiguration = (CoreConfiguration) obj;
        if (i >= 33) {
            obj2 = intent.getSerializableExtra(DialogInteraction.EXTRA_REPORT_FILE, File.class);
        } else {
            Serializable serializableExtra2 = intent.getSerializableExtra(DialogInteraction.EXTRA_REPORT_FILE);
            obj2 = (File) (serializableExtra2 instanceof File ? serializableExtra2 : null);
        }
        File file = (File) obj2;
        if (coreConfiguration == null || file == null) {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            String simpleName = CrashReportDialogHelper.class.getSimpleName();
            aCRALog.e(str, "Illegal or incomplete call of " + simpleName);
            throw new IllegalArgumentException();
        }
        this.config = coreConfiguration;
        this.reportFile = file;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: org.acra.dialog.CrashReportDialogHelper$reportData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CrashReportData invoke() {
                File file2;
                try {
                    CrashReportPersister crashReportPersister = new CrashReportPersister();
                    file2 = CrashReportDialogHelper.this.reportFile;
                    return crashReportPersister.load(file2);
                } catch (JSONException e) {
                    throw new IOException(e);
                }
            }
        });
        this.reportData$delegate = lazy;
    }

    public final CrashReportData getReportData() {
        return (CrashReportData) this.reportData$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelReports$lambda$1(CrashReportDialogHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new BulkReportDeleter(this$0.context).deleteReports(false, 0);
    }

    public final void cancelReports() {
        new Thread(new Runnable() { // from class: org.acra.dialog.CrashReportDialogHelper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                CrashReportDialogHelper.cancelReports$lambda$1(CrashReportDialogHelper.this);
            }
        }).start();
    }

    public final void sendCrash(final String str, final String str2) {
        new Thread(new Runnable() { // from class: org.acra.dialog.CrashReportDialogHelper$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                CrashReportDialogHelper.sendCrash$lambda$5(CrashReportDialogHelper.this, str, str2);
            }
        }).start();
    }
}
