package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ReadonlySharedFlow<T> implements SharedFlow<T>, Flow, FusibleFlow<T> {
    private final /* synthetic */ SharedFlow<T> $$delegate_0;
    private final Job job;

    /* JADX WARN: Multi-variable type inference failed */
    public ReadonlySharedFlow(SharedFlow<? extends T> sharedFlow, Job job) {
        this.job = job;
        this.$$delegate_0 = sharedFlow;
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        return this.$$delegate_0.collect(flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        return this.$$delegate_0.getReplayCache();
    }
}
