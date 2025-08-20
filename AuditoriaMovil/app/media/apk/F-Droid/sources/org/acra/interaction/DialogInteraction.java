package org.acra.interaction;

import android.content.Context;
import android.content.Intent;
import ch.qos.logback.core.CoreConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.ConfigUtils;
import org.acra.config.CoreConfiguration;
import org.acra.config.DialogConfiguration;
import org.acra.log.ACRALog;
import org.acra.plugins.HasConfigPlugin;
import org.acra.prefs.SharedPreferencesFactory;
/* compiled from: DialogInteraction.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0012J \u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lorg/acra/interaction/DialogInteraction;", "Lorg/acra/plugins/HasConfigPlugin;", "Lorg/acra/interaction/ReportInteraction;", "()V", "createCrashReportDialogIntent", "Landroid/content/Intent;", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportFile", "Ljava/io/File;", "performInteraction", "", "Companion", "acra-dialog_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class DialogInteraction extends HasConfigPlugin implements ReportInteraction {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_REPORT_CONFIG = "REPORT_CONFIG";
    public static final String EXTRA_REPORT_FILE = "REPORT_FILE";

    /* compiled from: DialogInteraction.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private Intent createCrashReportDialogIntent(Context context, CoreConfiguration coreConfiguration, File file) {
        if (ACRA.DEV_LOGGING) {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            aCRALog.d(str, "Creating DialogIntent for " + file);
        }
        Intent intent = new Intent(context, ((DialogConfiguration) ConfigUtils.getPluginConfiguration(coreConfiguration, DialogConfiguration.class)).getReportDialogClass());
        intent.putExtra(EXTRA_REPORT_FILE, file);
        intent.putExtra(EXTRA_REPORT_CONFIG, coreConfiguration);
        return intent;
    }

    public DialogInteraction() {
        super(DialogConfiguration.class);
    }

    @Override // org.acra.interaction.ReportInteraction
    public boolean performInteraction(Context context, CoreConfiguration config, File reportFile) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportFile, "reportFile");
        if (new SharedPreferencesFactory(context, config).create().getBoolean("acra.alwaysaccept", false)) {
            return true;
        }
        if (ACRA.DEV_LOGGING) {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            aCRALog.d(str, "Creating CrashReportDialog for " + reportFile);
        }
        Intent createCrashReportDialogIntent = createCrashReportDialogIntent(context, config, reportFile);
        createCrashReportDialogIntent.setFlags(268435456);
        context.startActivity(createCrashReportDialogIntent);
        return false;
    }
}
