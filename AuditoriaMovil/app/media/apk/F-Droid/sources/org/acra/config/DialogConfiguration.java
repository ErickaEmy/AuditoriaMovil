package org.acra.config;

import android.app.Activity;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.acra.dialog.CrashReportDialog;
/* compiled from: DialogConfiguration.kt */
/* loaded from: classes2.dex */
public final class DialogConfiguration implements Configuration {
    private final String commentPrompt;
    private final String emailPrompt;
    private final boolean enabled;
    private final String negativeButtonText;
    private final String positiveButtonText;
    private final Class reportDialogClass;
    private final Integer resIcon;
    private final Integer resTheme;
    private final String text;
    private final String title;

    public DialogConfiguration() {
        this(false, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    @Override // org.acra.config.Configuration
    public boolean enabled() {
        return this.enabled;
    }

    public final String getCommentPrompt() {
        return this.commentPrompt;
    }

    public final String getEmailPrompt() {
        return this.emailPrompt;
    }

    public final String getNegativeButtonText() {
        return this.negativeButtonText;
    }

    public final String getPositiveButtonText() {
        return this.positiveButtonText;
    }

    public final Class getReportDialogClass() {
        return this.reportDialogClass;
    }

    public final Integer getResIcon() {
        return this.resIcon;
    }

    public final Integer getResTheme() {
        return this.resTheme;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public DialogConfiguration(boolean z, Class<? extends Activity> reportDialogClass, String str, String str2, String str3, String str4, Integer num, String str5, String str6, Integer num2) {
        Intrinsics.checkNotNullParameter(reportDialogClass, "reportDialogClass");
        this.enabled = z;
        this.reportDialogClass = reportDialogClass;
        this.positiveButtonText = str;
        this.negativeButtonText = str2;
        this.commentPrompt = str3;
        this.emailPrompt = str4;
        this.resIcon = num;
        this.text = str5;
        this.title = str6;
        this.resTheme = num2;
    }

    public /* synthetic */ DialogConfiguration(boolean z, Class cls, String str, String str2, String str3, String str4, Integer num, String str5, String str6, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? CrashReportDialog.class : cls, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? 17301543 : num, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : str6, (i & 512) == 0 ? num2 : null);
    }
}
