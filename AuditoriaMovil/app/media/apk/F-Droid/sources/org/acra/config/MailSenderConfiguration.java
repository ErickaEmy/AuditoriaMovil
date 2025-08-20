package org.acra.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MailSenderConfiguration.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u0017\u0010\u000e\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0016"}, d2 = {"Lorg/acra/config/MailSenderConfiguration;", "Lorg/acra/config/Configuration;", "", "enabled", "Z", "getEnabled", "()Z", "", "mailTo", "Ljava/lang/String;", "getMailTo", "()Ljava/lang/String;", "reportAsFile", "getReportAsFile", "reportFileName", "getReportFileName", "subject", "getSubject", "body", "getBody", "<init>", "(ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "acra-mail_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class MailSenderConfiguration implements Configuration {
    private final String body;
    private final boolean enabled;
    private final String mailTo;
    private final boolean reportAsFile;
    private final String reportFileName;
    private final String subject;

    @Override // org.acra.config.Configuration
    public boolean enabled() {
        return this.enabled;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getMailTo() {
        return this.mailTo;
    }

    public final boolean getReportAsFile() {
        return this.reportAsFile;
    }

    public final String getReportFileName() {
        return this.reportFileName;
    }

    public final String getSubject() {
        return this.subject;
    }

    public MailSenderConfiguration(boolean z, String mailTo, boolean z2, String reportFileName, String str, String str2) {
        Intrinsics.checkNotNullParameter(mailTo, "mailTo");
        Intrinsics.checkNotNullParameter(reportFileName, "reportFileName");
        this.enabled = z;
        this.mailTo = mailTo;
        this.reportAsFile = z2;
        this.reportFileName = reportFileName;
        this.subject = str;
        this.body = str2;
    }

    public /* synthetic */ MailSenderConfiguration(boolean z, String str, boolean z2, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, str, (i & 4) != 0 ? true : z2, (i & 8) != 0 ? "ACRA-report.stacktrace" : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
    }
}
