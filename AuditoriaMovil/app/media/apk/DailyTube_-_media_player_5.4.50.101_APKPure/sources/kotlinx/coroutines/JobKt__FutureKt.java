package kotlinx.coroutines;

import java.util.concurrent.Future;
/* loaded from: classes.dex */
final /* synthetic */ class JobKt__FutureKt {
    public static final void cancelFutureOnCancellation(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        cancellableContinuation.invokeOnCancellation(new CancelFutureOnCancel(future));
    }
}
