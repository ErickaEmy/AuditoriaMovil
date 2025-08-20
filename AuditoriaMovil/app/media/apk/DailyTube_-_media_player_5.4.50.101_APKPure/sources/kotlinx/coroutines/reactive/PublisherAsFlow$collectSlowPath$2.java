package kotlinx.coroutines.reactive;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.ChannelFlow;
@DebugMetadata(c = "kotlinx.coroutines.reactive.PublisherAsFlow$collectSlowPath$2", f = "ReactiveFlow.kt", l = {87}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PublisherAsFlow$collectSlowPath$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector<T> $collector;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PublisherAsFlow<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PublisherAsFlow$collectSlowPath$2(FlowCollector<? super T> flowCollector, PublisherAsFlow<T> publisherAsFlow, Continuation<? super PublisherAsFlow$collectSlowPath$2> continuation) {
        super(2, continuation);
        this.$collector = flowCollector;
        this.this$0 = publisherAsFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PublisherAsFlow$collectSlowPath$2 publisherAsFlow$collectSlowPath$2 = new PublisherAsFlow$collectSlowPath$2(this.$collector, this.this$0, continuation);
        publisherAsFlow$collectSlowPath$2.L$0 = obj;
        return publisherAsFlow$collectSlowPath$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector<T> flowCollector = this.$collector;
            ChannelFlow channelFlow = this.this$0;
            ReceiveChannel produceImpl = channelFlow.produceImpl(CoroutineScopeKt.plus((CoroutineScope) this.L$0, channelFlow.context));
            this.label = 1;
            if (FlowKt.emitAll(flowCollector, produceImpl, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PublisherAsFlow$collectSlowPath$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
