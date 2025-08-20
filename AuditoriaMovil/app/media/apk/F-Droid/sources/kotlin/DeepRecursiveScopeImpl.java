package kotlin;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepRecursive.kt */
/* loaded from: classes.dex */
public final class DeepRecursiveScopeImpl extends DeepRecursiveScope implements Continuation {
    private Continuation cont;
    private Function3 function;
    private Object result;
    private Object value;

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        this.cont = null;
        this.result = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepRecursiveScopeImpl(Function3 block, Object obj) {
        super(null);
        Object obj2;
        Intrinsics.checkNotNullParameter(block, "block");
        this.function = block;
        this.value = obj;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.cont = this;
        obj2 = DeepRecursiveKt.UNDEFINED_RESULT;
        this.result = obj2;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.DeepRecursiveScope
    public Object callRecursive(Object obj, Continuation continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.cont = continuation;
        this.value = obj;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == coroutine_suspended2) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended;
    }

    public final Object runCallLoop() {
        Object obj;
        Object obj2;
        Object coroutine_suspended;
        while (true) {
            Object obj3 = this.result;
            Continuation continuation = this.cont;
            if (continuation == null) {
                ResultKt.throwOnFailure(obj3);
                return obj3;
            }
            obj = DeepRecursiveKt.UNDEFINED_RESULT;
            if (Result.m2083equalsimpl0(obj, obj3)) {
                try {
                    Function3 function3 = this.function;
                    Object obj4 = this.value;
                    Object wrapWithContinuationImpl = !(function3 instanceof BaseContinuationImpl) ? IntrinsicsKt__IntrinsicsJvmKt.wrapWithContinuationImpl(function3, this, obj4, continuation) : ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function3, 3)).invoke(this, obj4, continuation);
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (wrapWithContinuationImpl != coroutine_suspended) {
                        continuation.resumeWith(Result.m2081constructorimpl(wrapWithContinuationImpl));
                    }
                } catch (Throwable th) {
                    Result.Companion companion = Result.Companion;
                    continuation.resumeWith(Result.m2081constructorimpl(ResultKt.createFailure(th)));
                }
            } else {
                obj2 = DeepRecursiveKt.UNDEFINED_RESULT;
                this.result = obj2;
                continuation.resumeWith(obj3);
            }
        }
    }
}
