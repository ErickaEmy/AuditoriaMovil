package org.acra.sender;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;
import org.acra.config.DefaultRetryPolicy;
import org.acra.config.RetryPolicy;
import org.acra.data.CrashReportData;
import org.acra.file.CrashReportPersister;
import org.acra.log.ACRALog;
import org.acra.util.IOUtils;
import org.acra.util.InstanceCreator;
import org.json.JSONException;
/* compiled from: ReportDistributor.kt */
/* loaded from: classes2.dex */
public final class ReportDistributor {
    private final CoreConfiguration config;
    private final Context context;
    private final Bundle extras;
    private final List reportSenders;

    public final boolean distribute(File reportFile) {
        Intrinsics.checkNotNullParameter(reportFile, "reportFile");
        ACRALog aCRALog = ACRA.log;
        String str = ACRA.LOG_TAG;
        aCRALog.i(str, "Sending report " + reportFile);
        try {
            sendCrashReport(new CrashReportPersister().load(reportFile));
            IOUtils.deleteFile(reportFile);
            return true;
        } catch (IOException e) {
            ACRALog aCRALog2 = ACRA.log;
            String str2 = ACRA.LOG_TAG;
            aCRALog2.e(str2, "Failed to send crash reports for " + reportFile, e);
            IOUtils.deleteFile(reportFile);
            return false;
        } catch (RuntimeException e2) {
            ACRALog aCRALog3 = ACRA.log;
            String str3 = ACRA.LOG_TAG;
            aCRALog3.e(str3, "Failed to send crash reports for " + reportFile, e2);
            IOUtils.deleteFile(reportFile);
            return false;
        } catch (ReportSenderException e3) {
            ACRALog aCRALog4 = ACRA.log;
            String str4 = ACRA.LOG_TAG;
            aCRALog4.e(str4, "Failed to send crash reports for " + reportFile, e3);
            return false;
        } catch (JSONException e4) {
            ACRALog aCRALog5 = ACRA.log;
            String str5 = ACRA.LOG_TAG;
            aCRALog5.e(str5, "Failed to send crash reports for " + reportFile, e4);
            IOUtils.deleteFile(reportFile);
            return false;
        }
    }

    public ReportDistributor(Context context, CoreConfiguration config, List reportSenders, Bundle extras) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportSenders, "reportSenders");
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.context = context;
        this.config = config;
        this.reportSenders = reportSenders;
        this.extras = extras;
    }

    private final void sendCrashReport(CrashReportData crashReportData) {
        String joinToString$default;
        String joinToString$default2;
        if (!isDebuggable() || this.config.getSendReportsInDevMode()) {
            LinkedList linkedList = new LinkedList();
            for (ReportSender reportSender : this.reportSenders) {
                try {
                    if (ACRA.DEV_LOGGING) {
                        ACRALog aCRALog = ACRA.log;
                        String str = ACRA.LOG_TAG;
                        String name = reportSender.getClass().getName();
                        aCRALog.d(str, "Sending report using " + name);
                    }
                    reportSender.send(this.context, crashReportData, this.extras);
                    if (ACRA.DEV_LOGGING) {
                        ACRALog aCRALog2 = ACRA.log;
                        String str2 = ACRA.LOG_TAG;
                        String name2 = reportSender.getClass().getName();
                        aCRALog2.d(str2, "Sent report using " + name2);
                    }
                } catch (ReportSenderException e) {
                    linkedList.add(new RetryPolicy.FailedSender(reportSender, e));
                }
            }
            if (linkedList.isEmpty()) {
                if (ACRA.DEV_LOGGING) {
                    ACRA.log.d(ACRA.LOG_TAG, "Report was sent by all senders");
                }
            } else if (((RetryPolicy) InstanceCreator.create(this.config.getRetryPolicyClass(), new Function0() { // from class: org.acra.sender.ReportDistributor$sendCrashReport$4
                @Override // kotlin.jvm.functions.Function0
                public final RetryPolicy invoke() {
                    return new DefaultRetryPolicy();
                }
            })).shouldRetrySend(this.reportSenders, linkedList)) {
                throw new ReportSenderException("Policy marked this task as incomplete. ACRA will try to send this report again.", ((RetryPolicy.FailedSender) linkedList.get(0)).getException());
            } else {
                ACRALog aCRALog3 = ACRA.log;
                String str3 = ACRA.LOG_TAG;
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(linkedList, null, null, null, 0, null, new Function1() { // from class: org.acra.sender.ReportDistributor$sendCrashReport$5$1
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(RetryPolicy.FailedSender it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        String name3 = it.getSender().getClass().getName();
                        Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
                        return name3;
                    }
                }, 31, null);
                joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(linkedList, "\n", null, null, 0, null, new Function1() { // from class: org.acra.sender.ReportDistributor$sendCrashReport$5$2
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(RetryPolicy.FailedSender it) {
                        String stackTraceToString;
                        Intrinsics.checkNotNullParameter(it, "it");
                        stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(it.getException());
                        return stackTraceToString;
                    }
                }, 30, null);
                aCRALog3.w(str3, "ReportSenders of classes [" + joinToString$default + "] failed, but Policy marked this task as complete. ACRA will not send this report again.\nSuppressed:\n" + joinToString$default2);
            }
        }
    }

    private final boolean isDebuggable() {
        try {
            return (this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 0).flags & 2) > 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
