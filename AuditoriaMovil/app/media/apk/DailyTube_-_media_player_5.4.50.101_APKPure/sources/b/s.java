package b;

import android.os.OutcomeReceiver;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
/* loaded from: classes.dex */
public final class s<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver<R, E> {
    private final Continuation<R> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public s(Continuation<? super R> continuation) {
        super(false);
        this.continuation = continuation;
    }

    @Override // android.os.OutcomeReceiver
    public void onError(E e2) {
        if (compareAndSet(false, true)) {
            Continuation<R> continuation = this.continuation;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(e2)));
        }
    }

    @Override // android.os.OutcomeReceiver
    public void onResult(R r2) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(Result.m28constructorimpl(r2));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
