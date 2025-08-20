package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow;
/* loaded from: classes.dex */
public final /* synthetic */ class FlowKt__ContextKt {
    public static final <T> Flow<T> buffer(Flow<? extends T> flow, int i, BufferOverflow bufferOverflow) {
        int i5;
        BufferOverflow bufferOverflow2;
        if (i < 0 && i != -2 && i != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i).toString());
        } else if (i == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        } else {
            if (i == -1) {
                bufferOverflow2 = BufferOverflow.DROP_OLDEST;
                i5 = 0;
            } else {
                i5 = i;
                bufferOverflow2 = bufferOverflow;
            }
            if (flow instanceof FusibleFlow) {
                return FusibleFlow.DefaultImpls.fuse$default((FusibleFlow) flow, null, i5, bufferOverflow2, 1, null);
            }
            return new ChannelFlowOperatorImpl(flow, null, i5, bufferOverflow2, 2, null);
        }
    }

    public static /* synthetic */ Flow buffer$default(Flow flow, int i, BufferOverflow bufferOverflow, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = -2;
        }
        if ((i5 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return FlowKt.buffer(flow, i, bufferOverflow);
    }

    private static final void checkFlowContext$FlowKt__ContextKt(CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.Key) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineContext).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> flowOn(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        checkFlowContext$FlowKt__ContextKt(coroutineContext);
        if (!Intrinsics.areEqual(coroutineContext, EmptyCoroutineContext.INSTANCE)) {
            if (flow instanceof FusibleFlow) {
                return FusibleFlow.DefaultImpls.fuse$default((FusibleFlow) flow, coroutineContext, 0, null, 6, null);
            }
            return new ChannelFlowOperatorImpl(flow, coroutineContext, 0, null, 12, null);
        }
        return flow;
    }
}
