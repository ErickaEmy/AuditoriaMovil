package kotlinx.coroutines.reactive;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
@DebugMetadata(c = "kotlinx.coroutines.reactive.PublisherAsFlow", f = "ReactiveFlow.kt", l = {98, 100}, m = "collectImpl")
/* loaded from: classes.dex */
public final class PublisherAsFlow$collectImpl$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PublisherAsFlow<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublisherAsFlow$collectImpl$1(PublisherAsFlow<T> publisherAsFlow, Continuation<? super PublisherAsFlow$collectImpl$1> continuation) {
        super(continuation);
        this.this$0 = publisherAsFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object collectImpl;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        collectImpl = this.this$0.collectImpl(null, null, this);
        return collectImpl;
    }
}
