package org.acra.sender;

import android.content.Context;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.data.CrashReportData;
import org.acra.log.ACRALog;
import org.acra.sender.ReportSender;
/* compiled from: NullSender.kt */
/* loaded from: classes2.dex */
public class NullSender implements ReportSender {
    @Override // org.acra.sender.ReportSender
    public /* synthetic */ boolean requiresForeground() {
        return ReportSender.CC.$default$requiresForeground(this);
    }

    @Override // org.acra.sender.ReportSender
    public /* synthetic */ void send(Context context, CrashReportData crashReportData, Bundle bundle) {
        ReportSender.CC.$default$send(this, context, crashReportData, bundle);
    }

    @Override // org.acra.sender.ReportSender
    public void send(Context context, CrashReportData errorContent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(errorContent, "errorContent");
        ACRALog aCRALog = ACRA.log;
        String str = ACRA.LOG_TAG;
        String packageName = context.getPackageName();
        aCRALog.w(str, packageName + " reports will NOT be sent - no valid ReportSender was found!");
    }
}
