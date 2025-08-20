package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
/* loaded from: classes.dex */
public final class YieldKt {
    public static final Object yield(Continuation<? super Unit> continuation) {
        DispatchedContinuation dispatchedContinuation;
        Object obj;
        CoroutineContext context = continuation.getContext();
        JobKt.ensureActive(context);
        Continuation intercepted = IntrinsicsKt.intercepted(continuation);
        if (intercepted instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) intercepted;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation == null) {
            obj = Unit.INSTANCE;
        } else {
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(context)) {
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(context, Unit.INSTANCE);
            } else {
                YieldContext yieldContext = new YieldContext();
                CoroutineContext plus = context.plus(yieldContext);
                Unit unit = Unit.INSTANCE;
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(plus, unit);
                if (yieldContext.dispatcherWasUnconfined) {
                    if (DispatchedContinuationKt.yieldUndispatched(dispatchedContinuation)) {
                        obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    } else {
                        obj = unit;
                    }
                }
            }
            obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj;
        }
        return Unit.INSTANCE;
    }
}
