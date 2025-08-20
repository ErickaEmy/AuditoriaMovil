package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
/* loaded from: classes.dex */
final class SafeFlow<T> extends AbstractFlow<T> {
    private final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> block;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeFlow(Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.block = function2;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    public Object collectSafely(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object invoke = this.block.invoke(flowCollector, continuation);
        if (invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return invoke;
        }
        return Unit.INSTANCE;
    }
}
