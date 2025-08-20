package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ResumeAwaitOnCompletion<T> extends JobNode {
    private final CancellableContinuationImpl<T> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeAwaitOnCompletion(CancellableContinuationImpl<? super T> cancellableContinuationImpl) {
        this.continuation = cancellableContinuationImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public void invoke2(Throwable th) {
        Object state$kotlinx_coroutines_core = getJob().getState$kotlinx_coroutines_core();
        if (DebugKt.getASSERTIONS_ENABLED() && (state$kotlinx_coroutines_core instanceof Incomplete)) {
            throw new AssertionError();
        }
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            CancellableContinuationImpl<T> cancellableContinuationImpl = this.continuation;
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(((CompletedExceptionally) state$kotlinx_coroutines_core).cause)));
            return;
        }
        CancellableContinuationImpl<T> cancellableContinuationImpl2 = this.continuation;
        Result.Companion companion2 = Result.Companion;
        cancellableContinuationImpl2.resumeWith(Result.m28constructorimpl(JobSupportKt.unboxState(state$kotlinx_coroutines_core)));
    }
}
