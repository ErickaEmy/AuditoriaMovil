package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ResumeOnCompletion extends JobNode {
    private final Continuation<Unit> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeOnCompletion(Continuation<? super Unit> continuation) {
        this.continuation = continuation;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public void invoke2(Throwable th) {
        Continuation<Unit> continuation = this.continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m28constructorimpl(Unit.INSTANCE));
    }
}
