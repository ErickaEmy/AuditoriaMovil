package org.acra.sender;

import android.content.Context;
import ch.qos.logback.core.CoreConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.config.CoreConfiguration;
import org.acra.config.MailSenderConfiguration;
import org.acra.plugins.HasConfigPlugin;
/* compiled from: EmailIntentSenderFactory.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lorg/acra/sender/EmailIntentSenderFactory;", "Lorg/acra/plugins/HasConfigPlugin;", "Lorg/acra/sender/ReportSenderFactory;", "()V", "create", "Lorg/acra/sender/ReportSender;", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "acra-mail_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class EmailIntentSenderFactory extends HasConfigPlugin implements ReportSenderFactory {
    public EmailIntentSenderFactory() {
        super(MailSenderConfiguration.class);
    }

    @Override // org.acra.sender.ReportSenderFactory
    public ReportSender create(Context context, CoreConfiguration config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        return new EmailIntentSender(config);
    }
}
