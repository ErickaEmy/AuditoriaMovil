package org.acra.config;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;
/* compiled from: RetryPolicy.kt */
/* loaded from: classes2.dex */
public interface RetryPolicy {
    boolean shouldRetrySend(List list, List list2);

    /* compiled from: RetryPolicy.kt */
    /* loaded from: classes2.dex */
    public static final class FailedSender {
        private final ReportSenderException exception;
        private final ReportSender sender;

        public final ReportSenderException getException() {
            return this.exception;
        }

        public final ReportSender getSender() {
            return this.sender;
        }

        public FailedSender(ReportSender sender, ReportSenderException exception) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.sender = sender;
            this.exception = exception;
        }
    }
}
