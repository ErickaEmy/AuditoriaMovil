package org.acra.sender;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.log.ACRALog;
/* compiled from: ReportSender.kt */
/* loaded from: classes2.dex */
public interface ReportSender {
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean requiresForeground();

    void send(Context context, CrashReportData crashReportData);

    void send(Context context, CrashReportData crashReportData, Bundle bundle);

    /* compiled from: ReportSender.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final List loadSenders(Context context, CoreConfiguration config) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            if (ACRA.DEV_LOGGING) {
                ACRA.log.d(ACRA.LOG_TAG, "Using PluginLoader to find ReportSender factories");
            }
            List<ReportSenderFactory> loadEnabled = config.getPluginLoader().loadEnabled(config, ReportSenderFactory.class);
            if (ACRA.DEV_LOGGING) {
                ACRALog aCRALog = ACRA.log;
                String str = ACRA.LOG_TAG;
                aCRALog.d(str, "reportSenderFactories : " + loadEnabled);
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(loadEnabled, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (ReportSenderFactory reportSenderFactory : loadEnabled) {
                ReportSender create = reportSenderFactory.create(context, config);
                if (ACRA.DEV_LOGGING) {
                    ACRALog aCRALog2 = ACRA.log;
                    String str2 = ACRA.LOG_TAG;
                    aCRALog2.d(str2, "Adding reportSender : " + create);
                }
                arrayList.add(create);
            }
            return arrayList;
        }

        public final boolean hasForegroundSenders(Context context, CoreConfiguration config) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            List<ReportSender> loadSenders = loadSenders(context, config);
            if ((loadSenders instanceof Collection) && loadSenders.isEmpty()) {
                return false;
            }
            for (ReportSender reportSender : loadSenders) {
                if (reportSender.requiresForeground()) {
                    return true;
                }
            }
            return false;
        }

        public final boolean hasBackgroundSenders(Context context, CoreConfiguration config) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            List<ReportSender> loadSenders = loadSenders(context, config);
            if ((loadSenders instanceof Collection) && loadSenders.isEmpty()) {
                return false;
            }
            for (ReportSender reportSender : loadSenders) {
                if (!reportSender.requiresForeground()) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: ReportSender.kt */
    /* renamed from: org.acra.sender.ReportSender$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public abstract /* synthetic */ class CC {
        public static boolean $default$requiresForeground(ReportSender reportSender) {
            return false;
        }

        public static void $default$send(ReportSender reportSender, Context context, CrashReportData errorContent, Bundle extras) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(errorContent, "errorContent");
            Intrinsics.checkNotNullParameter(extras, "extras");
            reportSender.send(context, errorContent);
        }
    }
}
