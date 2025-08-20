package vc1;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class gv extends Handler {
    public static final gv y = new gv();

    @Override // java.util.logging.Handler
    public void publish(LogRecord record) {
        int n32;
        Intrinsics.checkNotNullParameter(record, "record");
        zn znVar = zn.f14449zn;
        String loggerName = record.getLoggerName();
        Intrinsics.checkNotNullExpressionValue(loggerName, "record.loggerName");
        n32 = v.n3(record);
        String message = record.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "record.message");
        znVar.y(loggerName, n32, message, record.getThrown());
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }
}
