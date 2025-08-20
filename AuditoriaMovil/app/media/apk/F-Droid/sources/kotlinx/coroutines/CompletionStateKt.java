package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
/* compiled from: CompletionState.kt */
/* loaded from: classes2.dex */
public abstract class CompletionStateKt {
    public static /* synthetic */ Object toState$default(Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return toState(obj, function1);
    }

    public static final Object toState(Object obj, Function1 function1) {
        Throwable m2084exceptionOrNullimpl = Result.m2084exceptionOrNullimpl(obj);
        if (m2084exceptionOrNullimpl == null) {
            return function1 != null ? new CompletedWithCancellation(obj, function1) : obj;
        }
        return new CompletedExceptionally(m2084exceptionOrNullimpl, false, 2, null);
    }

    public static final Object toState(Object obj, CancellableContinuation cancellableContinuation) {
        Throwable m2084exceptionOrNullimpl = Result.m2084exceptionOrNullimpl(obj);
        return m2084exceptionOrNullimpl == null ? obj : new CompletedExceptionally(m2084exceptionOrNullimpl, false, 2, null);
    }

    public static final Object recoverResult(Object obj, Continuation continuation) {
        if (obj instanceof CompletedExceptionally) {
            Result.Companion companion = Result.Companion;
            return Result.m2081constructorimpl(ResultKt.createFailure(((CompletedExceptionally) obj).cause));
        }
        return Result.m2081constructorimpl(obj);
    }
}
