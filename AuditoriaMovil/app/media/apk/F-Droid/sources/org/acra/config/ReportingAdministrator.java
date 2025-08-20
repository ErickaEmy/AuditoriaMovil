package org.acra.config;

import android.content.Context;
import ch.qos.logback.core.CoreConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.builder.LastActivityManager;
import org.acra.builder.ReportBuilder;
import org.acra.data.CrashReportData;
import org.acra.plugins.Plugin;
/* compiled from: ReportingAdministrator.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J*\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Lorg/acra/config/ReportingAdministrator;", "Lorg/acra/plugins/Plugin;", "notifyReportDropped", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "shouldFinishActivity", "", "lastActivityManager", "Lorg/acra/builder/LastActivityManager;", "shouldKillApplication", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", "crashReportData", "Lorg/acra/data/CrashReportData;", "shouldSendReport", "shouldStartCollecting", "acra-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ReportingAdministrator extends Plugin {

    /* compiled from: ReportingAdministrator.kt */
    /* renamed from: org.acra.config.ReportingAdministrator$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public abstract /* synthetic */ class CC {
        public static void $default$notifyReportDropped(ReportingAdministrator reportingAdministrator, Context context, CoreConfiguration config) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
        }

        public static boolean $default$shouldFinishActivity(ReportingAdministrator reportingAdministrator, Context context, CoreConfiguration config, LastActivityManager lastActivityManager) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(lastActivityManager, "lastActivityManager");
            return true;
        }

        public static boolean $default$shouldKillApplication(ReportingAdministrator reportingAdministrator, Context context, CoreConfiguration config, ReportBuilder reportBuilder, CrashReportData crashReportData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
            return true;
        }

        public static boolean $default$shouldSendReport(ReportingAdministrator reportingAdministrator, Context context, CoreConfiguration config, CrashReportData crashReportData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(crashReportData, "crashReportData");
            return true;
        }

        public static boolean $default$shouldStartCollecting(ReportingAdministrator reportingAdministrator, Context context, CoreConfiguration config, ReportBuilder reportBuilder) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
            return true;
        }
    }

    @Override // org.acra.plugins.Plugin
    /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration);

    void notifyReportDropped(Context context, CoreConfiguration coreConfiguration);

    boolean shouldFinishActivity(Context context, CoreConfiguration coreConfiguration, LastActivityManager lastActivityManager);

    boolean shouldKillApplication(Context context, CoreConfiguration coreConfiguration, ReportBuilder reportBuilder, CrashReportData crashReportData);

    boolean shouldSendReport(Context context, CoreConfiguration coreConfiguration, CrashReportData crashReportData);

    boolean shouldStartCollecting(Context context, CoreConfiguration coreConfiguration, ReportBuilder reportBuilder);
}
