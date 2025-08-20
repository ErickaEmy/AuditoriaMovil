package androidx.compose.ui.input.pointer;

import java.util.concurrent.CancellationException;
/* compiled from: SuspendingPointerInputFilter.kt */
/* loaded from: classes.dex */
final class CancelTimeoutCancellationException extends CancellationException {
    public static final CancelTimeoutCancellationException INSTANCE = new CancelTimeoutCancellationException();

    private CancelTimeoutCancellationException() {
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
