package org.acra.sender;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;
import org.acra.file.CrashReportFileNameParser;
import org.acra.file.ReportLocator;
import org.acra.util.ToastSender;
/* compiled from: SendingConductor.kt */
/* loaded from: classes2.dex */
public final class SendingConductor {
    private final CoreConfiguration config;
    private final Context context;
    private final ReportLocator locator;

    public final void sendReports(boolean z, Bundle extras) {
        List mutableList;
        Intrinsics.checkNotNullParameter(extras, "extras");
        if (ACRA.DEV_LOGGING) {
            ACRA.log.d(ACRA.LOG_TAG, "About to start sending reports from SenderService");
        }
        try {
            List loadSenders = ReportSender.Companion.loadSenders(this.context, this.config);
            ArrayList arrayList = new ArrayList();
            for (Object obj : loadSenders) {
                if (((ReportSender) obj).requiresForeground() == z) {
                    arrayList.add(obj);
                }
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
            if (mutableList.isEmpty()) {
                if (ACRA.DEV_LOGGING) {
                    ACRA.log.d(ACRA.LOG_TAG, "No ReportSenders configured - adding NullSender");
                }
                mutableList.add(new NullSender());
            }
            File[] approvedReports = this.locator.getApprovedReports();
            ReportDistributor reportDistributor = new ReportDistributor(this.context, this.config, mutableList, extras);
            CrashReportFileNameParser crashReportFileNameParser = new CrashReportFileNameParser();
            int i = 0;
            boolean z2 = false;
            for (File file : approvedReports) {
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                boolean z3 = !crashReportFileNameParser.isSilent(name);
                if (!extras.getBoolean("onlySendSilentReports") || !z3) {
                    z2 |= z3;
                    if (i >= 5) {
                        break;
                    } else if (reportDistributor.distribute(file)) {
                        i++;
                    }
                }
            }
            final String reportSendSuccessToast = i > 0 ? this.config.getReportSendSuccessToast() : this.config.getReportSendFailureToast();
            if (z2 && reportSendSuccessToast != null && reportSendSuccessToast.length() != 0) {
                if (ACRA.DEV_LOGGING) {
                    ACRA.log.d(ACRA.LOG_TAG, "About to show " + (i > 0 ? "success" : "failure") + " toast");
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: org.acra.sender.SendingConductor$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SendingConductor.sendReports$lambda$4(SendingConductor.this, reportSendSuccessToast);
                    }
                });
            }
        } catch (Exception e) {
            ACRA.log.e(ACRA.LOG_TAG, "", e);
        }
        if (ACRA.DEV_LOGGING) {
            ACRA.log.d(ACRA.LOG_TAG, "Finished sending reports from SenderService");
        }
    }

    public SendingConductor(Context context, CoreConfiguration config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        this.config = config;
        this.locator = new ReportLocator(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendReports$lambda$4(SendingConductor this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ToastSender.sendToast(this$0.context, str, 1);
    }
}
