package kotlin.coroutines;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Continuation.kt */
/* loaded from: classes.dex */
public abstract class ContinuationKt {
    public static final Continuation createCoroutine(Function2 function2, Object obj, Continuation completion) {
        Continuation createCoroutineUnintercepted;
        Continuation intercepted;
        Object coroutine_suspended;
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, obj, completion);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return new SafeContinuation(intercepted, coroutine_suspended);
    }

    public static final void startCoroutine(Function2 function2, Object obj, Continuation completion) {
        Continuation createCoroutineUnintercepted;
        Continuation intercepted;
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, obj, completion);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
        Result.Companion companion = Result.Companion;
        intercepted.resumeWith(Result.m2081constructorimpl(Unit.INSTANCE));
    }
}
