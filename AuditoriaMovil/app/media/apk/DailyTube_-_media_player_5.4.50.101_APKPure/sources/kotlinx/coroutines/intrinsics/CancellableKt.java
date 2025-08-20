package kotlinx.coroutines.intrinsics;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
/* loaded from: classes.dex */
public final class CancellableKt {
    private static final void dispatcherFailure(Continuation<?> continuation, Throwable th) {
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(th)));
        throw th;
    }

    public static final <R, T> void startCoroutineCancellable(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r2, Continuation<? super T> continuation, Function1<? super Throwable, Unit> function1) {
        try {
            Continuation intercepted = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function2, r2, continuation));
            Result.Companion companion = Result.Companion;
            DispatchedContinuationKt.resumeCancellableWith(intercepted, Result.m28constructorimpl(Unit.INSTANCE), function1);
        } catch (Throwable th) {
            dispatcherFailure(continuation, th);
        }
    }

    public static /* synthetic */ void startCoroutineCancellable$default(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i, Object obj2) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        startCoroutineCancellable(function2, obj, continuation, function1);
    }

    public static final void startCoroutineCancellable(Continuation<? super Unit> continuation, Continuation<?> continuation2) {
        try {
            Continuation intercepted = IntrinsicsKt.intercepted(continuation);
            Result.Companion companion = Result.Companion;
            DispatchedContinuationKt.resumeCancellableWith$default(intercepted, Result.m28constructorimpl(Unit.INSTANCE), null, 2, null);
        } catch (Throwable th) {
            dispatcherFailure(continuation2, th);
        }
    }
}
