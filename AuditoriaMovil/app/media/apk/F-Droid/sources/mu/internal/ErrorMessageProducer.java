package mu.internal;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: ErrorMessageProducer.kt */
/* loaded from: classes2.dex */
public final class ErrorMessageProducer {
    public static final ErrorMessageProducer INSTANCE = new ErrorMessageProducer();

    private ErrorMessageProducer() {
    }

    public final String getErrorLog(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (System.getProperties().containsKey("kotlin-logging.throwOnMessageError")) {
            throw e;
        }
        return "Log message invocation failed: " + e;
    }
}
