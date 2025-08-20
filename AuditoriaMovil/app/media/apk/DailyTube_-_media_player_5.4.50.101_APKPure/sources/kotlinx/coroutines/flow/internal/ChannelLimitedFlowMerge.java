package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
/* loaded from: classes.dex */
public final class ChannelLimitedFlowMerge<T> extends ChannelFlow<T> {
    private final Iterable<Flow<T>> flows;

    public /* synthetic */ ChannelLimitedFlowMerge(Iterable iterable, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(iterable, (i5 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i5 & 4) != 0 ? -2 : i, (i5 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        SendingCollector sendingCollector = new SendingCollector(producerScope);
        for (Flow<T> flow : this.flows) {
            BuildersKt__Builders_commonKt.launch$default(producerScope, null, null, new ChannelLimitedFlowMerge$collectTo$2$1(flow, sendingCollector, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ChannelFlow<T> create(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return new ChannelLimitedFlowMerge(this.flows, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ReceiveChannel<T> produceImpl(CoroutineScope coroutineScope) {
        return ProduceKt.produce(coroutineScope, this.context, this.capacity, getCollectToFun$kotlinx_coroutines_core());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelLimitedFlowMerge(Iterable<? extends Flow<? extends T>> iterable, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.flows = iterable;
    }
}
