package kotlinx.coroutines.reactive;

import he1.y;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class PublisherAsFlow<T> extends ChannelFlow<T> {
    private final y<T> publisher;

    public /* synthetic */ PublisherAsFlow(y yVar, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(yVar, (i5 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i5 & 4) != 0 ? -2 : i, (i5 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d A[Catch: all -> 0x0042, TRY_ENTER, TryCatch #0 {all -> 0x0042, blocks: (B:13:0x003c, B:33:0x00b5, B:35:0x00c1, B:23:0x007f, B:30:0x009d, B:20:0x005b), top: B:40:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1 A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #0 {all -> 0x0042, blocks: (B:13:0x003c, B:33:0x00b5, B:35:0x00c1, B:23:0x007f, B:30:0x009d, B:20:0x005b), top: B:40:0x0028 }] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v8, types: [kotlinx.coroutines.reactive.ReactiveSubscriber] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00b2 -> B:14:0x003f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collectImpl(kotlin.coroutines.CoroutineContext r18, kotlinx.coroutines.flow.FlowCollector<? super T> r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instructions count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.PublisherAsFlow.collectImpl(kotlin.coroutines.CoroutineContext, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object collectSlowPath(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new PublisherAsFlow$collectSlowPath$2(flowCollector, this, null), continuation);
        if (coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    private final long getRequestSize() {
        if (this.onBufferOverflow != BufferOverflow.SUSPEND) {
            return Long.MAX_VALUE;
        }
        int i = this.capacity;
        if (i != -2) {
            if (i == 0) {
                return 1L;
            }
            if (i == Integer.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            long j2 = i;
            if (j2 < 1) {
                throw new IllegalStateException("Check failed.");
            }
            return j2;
        }
        return Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core();
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        CoroutineContext context = continuation.getContext();
        CoroutineContext coroutineContext = this.context;
        ContinuationInterceptor.Key key = ContinuationInterceptor.Key;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(key);
        if (continuationInterceptor != null && !Intrinsics.areEqual(continuationInterceptor, context.get(key))) {
            Object collectSlowPath = collectSlowPath(flowCollector, continuation);
            if (collectSlowPath == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return collectSlowPath;
            }
            return Unit.INSTANCE;
        }
        Object collectImpl = collectImpl(context.plus(this.context), flowCollector, continuation);
        if (collectImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collectImpl;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        Object collectImpl = collectImpl(producerScope.getCoroutineContext(), new SendingCollector(producerScope.getChannel()), continuation);
        if (collectImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collectImpl;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ChannelFlow<T> create(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return new PublisherAsFlow(this.publisher, coroutineContext, i, bufferOverflow);
    }

    public PublisherAsFlow(y<T> yVar, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.publisher = yVar;
    }
}
