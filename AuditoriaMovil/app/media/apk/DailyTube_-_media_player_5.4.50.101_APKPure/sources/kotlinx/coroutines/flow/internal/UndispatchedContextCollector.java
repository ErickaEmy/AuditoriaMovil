package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class UndispatchedContextCollector<T> implements FlowCollector<T> {
    private final Object countOrElement;
    private final CoroutineContext emitContext;
    private final Function2<T, Continuation<? super Unit>, Object> emitRef;

    public UndispatchedContextCollector(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        this.emitContext = coroutineContext;
        this.countOrElement = ThreadContextKt.threadContextElements(coroutineContext);
        this.emitRef = new UndispatchedContextCollector$emitRef$1(flowCollector, null);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t2, Continuation<? super Unit> continuation) {
        Object withContextUndispatched = ChannelFlowKt.withContextUndispatched(this.emitContext, t2, this.countOrElement, this.emitRef, continuation);
        if (withContextUndispatched == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContextUndispatched;
        }
        return Unit.INSTANCE;
    }
}
