package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
/* loaded from: classes.dex */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {
    protected final Flow<S> flow;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(Flow<? extends S> flow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.flow = flow;
    }

    public static /* synthetic */ <S, T> Object collect$suspendImpl(ChannelFlowOperator<S, T> channelFlowOperator, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        if (channelFlowOperator.capacity == -3) {
            CoroutineContext context = continuation.getContext();
            CoroutineContext plus = context.plus(channelFlowOperator.context);
            if (Intrinsics.areEqual(plus, context)) {
                Object flowCollect = channelFlowOperator.flowCollect(flowCollector, continuation);
                if (flowCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return flowCollect;
                }
                return Unit.INSTANCE;
            }
            ContinuationInterceptor.Key key = ContinuationInterceptor.Key;
            if (Intrinsics.areEqual(plus.get(key), context.get(key))) {
                Object collectWithContextUndispatched = channelFlowOperator.collectWithContextUndispatched(flowCollector, plus, continuation);
                if (collectWithContextUndispatched == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return collectWithContextUndispatched;
                }
                return Unit.INSTANCE;
            }
        }
        Object collect = super.collect(flowCollector, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ <S, T> Object collectTo$suspendImpl(ChannelFlowOperator<S, T> channelFlowOperator, ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        Object flowCollect = channelFlowOperator.flowCollect(new SendingCollector(producerScope), continuation);
        if (flowCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return flowCollect;
        }
        return Unit.INSTANCE;
    }

    private final Object collectWithContextUndispatched(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
        Object withContextUndispatched$default = ChannelFlowKt.withContextUndispatched$default(coroutineContext, ChannelFlowKt.access$withUndispatchedContextCollector(flowCollector, continuation.getContext()), null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), continuation, 4, null);
        if (withContextUndispatched$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContextUndispatched$default;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return collect$suspendImpl((ChannelFlowOperator) this, (FlowCollector) flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return collectTo$suspendImpl(this, producerScope, continuation);
    }

    public abstract Object flowCollect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return this.flow + " -> " + super.toString();
    }
}
